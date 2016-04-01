// SRM SDK Release 4.4.0 - January 21, 2010

// - SRM spec. 4.4

/*
 *                             NOTICE
 * 
 * This software is provided openly and freely for use in representing and
 * interchanging environmental data & databases.
 * 
 * This software was developed for use by the United States Government with
 * unlimited rights.  The software was developed under contract
 * DASG60-02-D-0006 TO-193 by Science Applications International Corporation.
 * The software is unclassified and is deemed as Distribution A, approved
 * for Public Release.
 * 
 * Use by others is permitted only upon the ACCEPTANCE OF THE TERMS AND
 * CONDITIONS, AS STIPULATED UNDER THE FOLLOWING PROVISIONS:
 * 
 *    1. Recipient may make unlimited copies of this software and give
 *       copies to other persons or entities as long as the copies contain
 *       this NOTICE, and as long as the same copyright notices that
 *       appear on, or in, this software remain.
 * 
 *    2. Trademarks. All trademarks belong to their respective trademark
 *       holders.  Third-Party applications/software/information are
 *       copyrighted by their respective owners.
 * 
 *    3. Recipient agrees to forfeit all intellectual property and
 *       ownership rights for any version created from the modification
 *       or adaptation of this software, including versions created from
 *       the translation and/or reverse engineering of the software design.
 * 
 *    4. Transfer.  Recipient may not sell, rent, lease, or sublicense
 *       this software.  Recipient may, however enable another person
 *       or entity the rights to use this software, provided that this
 *       AGREEMENT and NOTICE is furnished along with the software and
 *       /or software system utilizing this software.
 * 
 *       All revisions, modifications, created by the Recipient, to this
 *       software and/or related technical data shall be forwarded by the
 *       Recipient to the Government at the following address:
 * 
 *         SMDC
 *         Attention SEDRIS (TO193) TPOC
 *         P.O. Box 1500
 *         Huntsville, AL  35807-3801
 * 
 *         or via electronic mail to:  se-mgmt@sedris.org
 * 
 *    5. No Warranty. This software is being delivered to you AS IS
 *       and there is no warranty, EXPRESS or IMPLIED, as to its use
 *       or performance.
 * 
 *       The RECIPIENT ASSUMES ALL RISKS, KNOWN AND UNKNOWN, OF USING
 *       THIS SOFTWARE.  The DEVELOPER EXPRESSLY DISCLAIMS, and the
 *       RECIPIENT WAIVES, ANY and ALL PERFORMANCE OR RESULTS YOU MAY
 *       OBTAIN BY USING THIS SOFTWARE OR DOCUMENTATION.  THERE IS
 *       NO WARRANTY, EXPRESS OR, IMPLIED, AS TO NON-INFRINGEMENT OF
 *       THIRD PARTY RIGHTS, MERCHANTABILITY, OR FITNESS FOR ANY
 *       PARTICULAR PURPOSE.  IN NO EVENT WILL THE DEVELOPER, THE
 *       UNITED STATES GOVERNMENT OR ANYONE ELSE ASSOCIATED WITH THE
 *       DEVELOPMENT OF THIS SOFTWARE BE HELD LIABLE FOR ANY CONSEQUENTIAL,
 *       INCIDENTAL OR SPECIAL DAMAGES, INCLUDING ANY LOST PROFITS
 *       OR LOST SAVINGS WHATSOEVER.
 */

/*
 * COPYRIGHT 2010, SCIENCE APPLICATIONS INTERNATIONAL CORPORATION.
 *                 ALL RIGHTS RESERVED.
 * 
 */

// SRM_OTHERS_GOES_HERE

/**
@author David Shen
*/

package SRM;

public class LteConv extends Conversions
{
    private ToCcenConst _toCcenConst;

    public LteConv()
    {
        super(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN,
              new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC,
                                   SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL,
                                   SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL,
                                   SRM_SRFT_Code.SRFTCOD_UNSPECIFIED});
    }

    protected Conversions makeClone()
    {
        return (Conversions) new LteConv();
    }

/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: convert
 *
 *----------------------------------------------------------------------------
 */
    public SRM_Coordinate_Valid_Region_Code convert(SRM_SRFT_Code        destSrfType,
                                                    BaseSRF              srcSrf,
                                                    BaseSRF              destSrf,
                                                    double[]             src,
                                                    double[]             dest,
                                                    SRM_ORM_Trans_Params hst) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid =
           SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;

        if (destSrfType == SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC)
        {
            if (srcSrf.getSRFSetCode() == SRM_SRFS_Code.SRFSCOD_GTRS_GLOBAL_COORDINATE_SYSTEM)
                retValid = CoordCheck.forGTRS (src);
            // else
            // NO restriction

            // apply the false origin offset before the conversion if LTSE_3D is the
            // source SRF.  Otherwise do nothing because LTSE_3D is just an intermediate SRF
            if (srcSrf instanceof SRF_LocalTangentSpaceEuclidean)
            {
                src[0] -= ((SRF_LocalTangentSpaceEuclidean)srcSrf).get_x_false_origin();
                src[1] -= ((SRF_LocalTangentSpaceEuclidean)srcSrf).get_y_false_origin();
            }
            // no restrictions
            toCcen(srcSrf, destSrf, src, dest);
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL)
        {
            toLtsc(srcSrf, destSrf, src, dest);
            // perform post validation
            retValid = CoordCheck.forCylindrical(dest);
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL)
        {
            toAzSphere(srcSrf, destSrf, src, dest);
            // perform post validation
            retValid = CoordCheck.forAzSpherical(dest);
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            // just pass the coordinate through.  This is the last conversion
            // in the chain
            dest[0] = src[0];
            dest[1] = src[1];
            dest[2] = src[2];
        }
        return retValid;
    }


/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: toCcenConst
 *
 *----------------------------------------------------------------------------
 */
    public class ToCcenConst
    {
        double[][] T = new double[4][4];
        double[][] T_inv = new double[4][4];

        public ToCcenConst(OrmData e_constants, SRF_LTSE_Params params)
        {
            Const.calc_T(e_constants, params,
                          T, T_inv);
        }
    }


    protected void toCcen (BaseSRF  srcSrf,
                           BaseSRF  destSrf,
                           double[] source_generic_coordinate,
                           double[] dest_generic_coordinate) throws SrmException
    {
        double[] temp = new double[4];
        double[] temp1 = new double[4];

        // copy source to temp and set last element to 1.0
        temp[0] = source_generic_coordinate[0];
        temp[1] = source_generic_coordinate[1];
        temp[2] = source_generic_coordinate[2];
        temp[3] = 1.0;

        OrmData e_constants = this.getOrmData();

        // if converting to CC_3D, then there are only three possibilities for the
        // LTE parameters to come from.  Either they are copies from the source
        // SRF's params when these are LTAS or LTC, or they are the parameters of
        // source LTE SRF.
        if (_toCcenConst == null)
        {
            if (srcSrf instanceof SRF_LocalTangentSpaceAzimuthalSpherical)
            {
                SRF_LT_Params tmpLTParam =
                    ((SRF_LocalTangentSpaceAzimuthalSpherical)srcSrf).getSRFParameters();
                SRF_LTSE_Params tmpLTEParam = new SRF_LTSE_Params();
                tmpLTEParam.geodetic_longitude = tmpLTParam.geodetic_longitude;
                tmpLTEParam.geodetic_latitude = tmpLTParam.geodetic_latitude;
                tmpLTEParam.azimuth = tmpLTParam.azimuth;
                tmpLTEParam.x_false_origin = 0.0;
                tmpLTEParam.y_false_origin = 0.0;
                tmpLTEParam.height_offset = tmpLTParam.height_offset;
                _toCcenConst = new ToCcenConst(e_constants, tmpLTEParam);
            }
            else if (srcSrf instanceof SRF_LocalTangentSpaceCylindrical)
            {
                SRF_LT_Params tmpLTParam =
                    ((SRF_LocalTangentSpaceCylindrical)srcSrf).getSRFParameters();
                SRF_LTSE_Params tmpLTEParam = new SRF_LTSE_Params();
                tmpLTEParam.geodetic_longitude = tmpLTParam.geodetic_longitude;
                tmpLTEParam.geodetic_latitude = tmpLTParam.geodetic_latitude;
                tmpLTEParam.azimuth = tmpLTParam.azimuth;
                tmpLTEParam.x_false_origin = 0.0;
                tmpLTEParam.y_false_origin = 0.0;
                tmpLTEParam.height_offset = tmpLTParam.height_offset;
                _toCcenConst = new ToCcenConst(e_constants, tmpLTEParam);
            }
            else // it is LTE itself
                _toCcenConst = new ToCcenConst(e_constants,
                                               ((SRF_LocalTangentSpaceEuclidean)srcSrf).getSRFParameters());
            }

        Const.multMatrixSubsetVector(_toCcenConst.T, temp, temp1, 4);

        // copy first three elements of temp1 to destination
        dest_generic_coordinate[0] =  temp1[0];
        dest_generic_coordinate[1] =  temp1[1];
        dest_generic_coordinate[2] =  temp1[2];
    }


    /*
     *----------------------------------------------------------------------------
     *
     * FUNCTION: LtsasLtseConst
     *
     *----------------------------------------------------------------------------
     */
        public class LtsasLtseConst
        {
            double ltsas_azimuth;
            double ltsas_height_offset;
            double ltse_azimuth;
            double ltse_height_offset;

            public LtsasLtseConst(SRF_LT_Params ltsas_params, SRF_LTSE_Params ltse_params)
            {
                ltsas_azimuth=ltsas_params.azimuth;
                ltsas_height_offset=ltsas_params.height_offset;
                ltse_azimuth=ltse_params.azimuth;
                ltse_height_offset=ltse_params.height_offset;
            }
        }

/*
 *----------------------------------------------------------------------------
 *
 * LTE to Cylindrical (LTSAS_3D) routines and classes
 *
 *----------------------------------------------------------------------------
 */
    /**
     * @param srcSrf
     * @param destSrf
     * @param source_generic_coord
     * @param dest_generic_coord
     * @throws SrmException
     */
    protected void toLtsc(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coord,
                          double[] dest_generic_coord) throws SrmException
    {
        // the source coordinate is interpreted as
        // source_generic_coord[0] => x
        // source_generic_coord[1] => y
        // source_generic_coord[2] => z

        double rho, theta, theta_prime,x2, zeta;

        x2=Const.square(source_generic_coord[0]);

        if ((x2 > (Const.EPSILON*Const.EPSILON)))
        {
            theta_prime= Math.atan((source_generic_coord[1])/(source_generic_coord[0]));
            if ((source_generic_coord[0] >= 0))
                if ((source_generic_coord[1] >= 0))
                    theta=theta_prime;        /* I */
                else
                    theta=Const.TWO_PI+theta_prime;  /* IV */
            else
                if ((source_generic_coord[1] >= 0))
                {
                    theta=Const.PI+theta_prime;  /* II */
                }
                else
                    theta=Const.PI+theta_prime;  /* III */
        }
        else
        {
            if (source_generic_coord[1] >= Const.EPSILON)
                theta = 0.0;
            else
                theta = Const.PI;
        }
        rho=Math.sqrt(x2 +Const.square(source_generic_coord[1]));
        zeta=(source_generic_coord[2]);

        dest_generic_coord[0] = theta;
        dest_generic_coord[1] = rho;
        dest_generic_coord[2] = zeta;
   }

/*
 *----------------------------------------------------------------------------
 *
 * LTE to Spherical routines and classes
 *
 *----------------------------------------------------------------------------
 */
    protected void toAzSphere(BaseSRF  srcSrf,
                              BaseSRF  destSrf,
                              double[] source_generic_coord,
                              double[] dest_generic_coord) throws SrmException
    {
        // the source coordinate is interpreted as
        // source_generic_coord[0] => x
        // source_generic_coord[1] => y
        // source_generic_coord[2] => z

        double x2 = Const.square(source_generic_coord[0]);

        // alpha
        if (x2 > Const.EPSILON_SQ)
        {
            if (source_generic_coord[0] >= 0.0)
            {
                if (source_generic_coord[1] >= 0.0) // I Q
                    dest_generic_coord[0] = Math.atan(source_generic_coord[1] / source_generic_coord[0]);
                else // IV Q
                    dest_generic_coord[0] = Const.TWO_PI + Math.atan(source_generic_coord[1] / source_generic_coord[0]);
            }
            else
            { // II Q and III Q
                    dest_generic_coord[0] = Const.PI + Math.atan(source_generic_coord[1] / source_generic_coord[0]);
            }
        }
        else
        {
            if (source_generic_coord[1] > Const.EPSILON)
                dest_generic_coord[0] = 0.0;
            else
                dest_generic_coord[0] = Const.PI;
        }


        // rho
        dest_generic_coord[2] = Math.sqrt(x2 +
                                          Const.square(source_generic_coord[1]) +
                                          Const.square(source_generic_coord[2]));

        // theta
        dest_generic_coord[1] = Math.asin(source_generic_coord[2] / dest_generic_coord[2]);
    }
}
