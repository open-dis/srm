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

class OmConv extends Conversions
{
    private ToCdetConst _toCdetConst = null;

    protected OmConv()
    {
        super(SRM_SRFT_Code.SRFTCOD_OBLIQUE_MERCATOR_SPHERICAL,
              new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
                                   SRM_SRFT_Code.SRFTCOD_UNSPECIFIED});
    }

    protected Conversions makeClone()
    {
        return (Conversions) new OmConv();
    }

/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: convert
 *
 *----------------------------------------------------------------------------
 */
    public SRM_Coordinate_Valid_Region_Code convert
    (
        SRM_SRFT_Code        destSrfType,
        BaseSRF              srcSrf,
        BaseSRF              destSrf,
        double[]             src,
        double[]             dest,
        SRM_ORM_Trans_Params hst
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid =
           SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;

        if (destSrfType == SRM_SRFT_Code.SRFTCOD_CELESTIODETIC)
        {
            // apply the false origin offset before the conversion
            src[0] -= ((SRF_ObliqueMercatorSpherical)srcSrf).get_false_easting();
            src[1] -= ((SRF_ObliqueMercatorSpherical)srcSrf).get_false_northing();

            // pre-validation - NO RESTRICTIONS

            // perform conversion
            toCdet(srcSrf, destSrf, src, dest);

            // pos- validation - NO RESTRICTIONS
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            // just pass the coordinate through. this is the last convesion in
            // the chain
            dest[0] = src[0];
            dest[1] = src[1];
            dest[2] = src[2];
        }
        return retValid;
    }


/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: toCdet
 *
 *----------------------------------------------------------------------------
 */
    private class ToCdetConst
    {
        double lambda_0;
        double sl0;
        double cl0;
        double inv_ak0;
        double sa0;
        double ca0;

        public ToCdetConst(OrmData e_constants, SRF_OM_Params omParams)
        {
            double sin_lat1=0.0,
                   cos_lat1=0.0,
                   sin_lat2=0.0,
                   cos_lat2=0.0,
                   sin_lon1=0.0,
                   cos_lon1=0.0,
                   sin_lon2=0.0,
                   cos_lon2=0.0,
                   p0=0.0,
                   q0=0.0,
                   alpha_0=0.0,
                   sin_lambda_1_minus_lambda_0=0.0,
                   sin_lambda_2_minus_lambda_0=0.0;

            sin_lat1 = Math.sin(omParams.latitude1);
            cos_lat1 = Math.cos(omParams.latitude1);

            sin_lat2 = Math.sin(omParams.latitude2);
            cos_lat2 = Math.cos(omParams.latitude2);

            sin_lon1 = Math.sin(omParams.longitude1);
            cos_lon1 = Math.cos(omParams.longitude1);

            sin_lon2 = Math.sin(omParams.longitude2);
            cos_lon2 = Math.cos(omParams.longitude2);

            p0 = cos_lat1*sin_lat2*sin_lon1-sin_lat1*cos_lat2*sin_lon2;
            q0 = cos_lat1*sin_lat2*cos_lon1-sin_lat1*cos_lat2*cos_lon2;

            lambda_0 = Math.atan(p0/q0);
           /* This should *_NOT_* be atan2(p0,q0) as suggested by ISO 18026 table 5.19
              CDK July 23, 2005
            */
            cl0 = Math.cos(lambda_0);
            sl0 = Math.sin(lambda_0);

            sin_lambda_1_minus_lambda_0=Math.sin(omParams.longitude1-lambda_0);
            //sin_lon1*gd_om_spec->cl0-cos_lon1*gd_om_spec->sl0;
            sin_lambda_2_minus_lambda_0=Math.sin(omParams.longitude2-lambda_0);
            //sin_lon2*gd_om_spec->cl0-cos_lon2*gd_om_spec->sl0;

            if (Math.abs(sin_lambda_1_minus_lambda_0) >=
                Math.abs(sin_lambda_2_minus_lambda_0))
            {
                alpha_0 = Math.atan(sin_lat1 /
                                    (cos_lat1*sin_lambda_1_minus_lambda_0));
            }
            else
            {
                alpha_0 = Math.atan(sin_lat2 /
                                    (cos_lat2*sin_lambda_2_minus_lambda_0));
            }
            sa0     = Math.sin(alpha_0);
            ca0     = Math.cos(alpha_0);
            inv_ak0 = 1.0/(e_constants.A*omParams.central_scale);
        }
    }


    protected void toCdet(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coordinate,
                          double[] dest_generic_coordinate) throws SrmException
    {
        double dest_lat = 0.0, dest_lon = 0.0,
               source_x = 0.0, source_y = 0.0, source_z = 0.0;

        double cos_u = 0.0, cosh_v = 0.0, q1 = 0.0, q2 = 0.0,
               sin_u = 0.0, sinh_v = 0.0, u_star = 0.0, v_star = 0.0,
               xlon1=0.0;

        OrmData e_constants = this.getOrmData();

        if (_toCdetConst == null)
            _toCdetConst = new ToCdetConst(e_constants,
                                           ((SRF_ObliqueMercatorSpherical)
                                            srcSrf).getSRFParameters());

        source_x = source_generic_coordinate[0];
        source_y = source_generic_coordinate[1];
        source_z = source_generic_coordinate[2];

        u_star = source_x * _toCdetConst.inv_ak0;
        v_star = source_y * _toCdetConst.inv_ak0;
        /*Note that the false northing and easting has already been subtracted by the caller
          CDK 7/25/2005
        */

        // Implementation of sinh and cosh until using Java 5.0 that supports them
        {
            double exp_v    = 0.0;
            double inv_expv = 0.0;

            exp_v    = Math.exp(v_star);
            inv_expv = 1.0 / exp_v;
            sinh_v   = 0.5 * (exp_v - inv_expv);
            cosh_v   = 0.5 * (exp_v + inv_expv);
        }

        // Java 1.4.2 does not support sinh and cosh
        //         sinh_v = sinh(v_star);
        //         cosh_v = cosh(v_star);

        sin_u = Math.sin(u_star);
        cos_u = Math.cos(u_star);

        q1 = _toCdetConst.ca0*sin_u-_toCdetConst.sa0*sinh_v;
        q2 = _toCdetConst.sa0*sin_u+_toCdetConst.ca0*sinh_v;

        xlon1 = Math.atan2(q1, cos_u);

        dest_lon = Const.getLambdaStar(xlon1, -_toCdetConst.lambda_0);

        dest_lat = Math.asin(q2 / cosh_v);

        dest_generic_coordinate[0] = dest_lon;
        dest_generic_coordinate[1] = dest_lat;
        dest_generic_coordinate[2] = source_z;
    }
}
