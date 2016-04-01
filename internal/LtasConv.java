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

class LtasConv extends SphereConv
{
    private LtsasLtseConst _ltsasLtseConst;

    protected LtasConv()
    {
        super (SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN,
                                    SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone() {
        return (Conversions) new LtasConv();
    }


    // Function dispatcher keyed on the destination SRF
    protected SRM_Coordinate_Valid_Region_Code convert(SRM_SRFT_Code        destSrfType,
                                                       BaseSRF              srcSrf,
                                                       BaseSRF              destSrf,
                                                       double[]             src,
                                                       double[]             dest,
                                                       SRM_ORM_Trans_Params hst) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid =
            SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;

        if ( destSrfType == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN )
        {
                // is LTSAS_3D is not the terminal SRF, then use src template for the
                // SRFT parameters.
                boolean ltse_is_terminal = (destSrfType == destSrf.getSRFTemplateCode());

                // perform pre validation
                retValid = CoordCheck.forAzSpherical( src );
                toLtse(srcSrf, destSrf, src, dest, ltse_is_terminal);
        }
        else if ( destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED )
        {
            // just pass the coordinate through.  This is a datum shift case
            // or this is the last conversion in the chain
            dest[0] = src[0];
            dest[1] = src[1];
            dest[2] = src[2];
        }
        return retValid;
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

         public LtsasLtseConst(SRF_LT_Params ltsas_params,
                               SRF_LTSE_Params ltse_params)
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
 * to LTSE_3D
 *
 *----------------------------------------------------------------------------
 */
    protected void toLtse(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coord,
                          double[] dest_generic_coord,
                          boolean  ltse_is_terminal) throws SrmException
    {
        // the source coordinate is interpreted as
        // source_generic_coord[0] => alpha
        // source_generic_coord[1] => theta
        // source_generic_coord[2] => rho

        if (_ltsasLtseConst == null)
            if ( ltse_is_terminal )
            {
                _ltsasLtseConst = new LtsasLtseConst(((SRF_LocalTangentSpaceAzimuthalSpherical)srcSrf).getSRFParameters(),
                                                     ((SRF_LocalTangentSpaceEuclidean)destSrf).getSRFParameters());
            }
            else
            {
                SRF_LT_Params tmp_ltsas
                        = ((SRF_LocalTangentSpaceAzimuthalSpherical)srcSrf).getSRFParameters();
                SRF_LTSE_Params tmp_ltse = new SRF_LTSE_Params();
                tmp_ltse.azimuth = tmp_ltsas.azimuth;
                tmp_ltse.height_offset = tmp_ltsas.height_offset;
                _ltsasLtseConst = new LtsasLtseConst(tmp_ltsas, tmp_ltse);
            }

        double alpha_star = Const.getAlphaStar( source_generic_coord[0],
                                                _ltsasLtseConst.ltsas_azimuth );
          /*This subtracts the azimuth offset inherent in the Local Tangent Azimuthal
            Coordinate.  This scales the result to the correct range for Azimuth
            between 0 and 2pi
          */

        double alpha_star_star = Const.getAlphaStar( alpha_star,
                                                     -_ltsasLtseConst.ltse_azimuth );
          /*This adds the azimuth offset required to go from the zero azimuth solution
            stored in alpha_star to the Azimuth inhernat in the LTSE_3D.  This scales the
            result to the correct range for azimuth between zero and 2 pi.

            Note that the negative sign in the call is here because this routine subtracts
            by default but to correct the azimuth to the value used by the LTSE_3D we need to add.
          */

        dest_generic_coord[0] = source_generic_coord[2] *
                                Math.cos(source_generic_coord[1])*
                                Math.sin(alpha_star_star);

        dest_generic_coord[1] = source_generic_coord[2] *
                                Math.cos(source_generic_coord[1])*
                                Math.cos(alpha_star_star);

        dest_generic_coord[2]= (source_generic_coord[2] * Math.sin(source_generic_coord[1]) ) -
                                _ltsasLtseConst.ltsas_height_offset +
                                _ltsasLtseConst.ltse_height_offset;
    }
}
