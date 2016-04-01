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

class Lsr2Conv extends LsrConv
{
    protected Lsr2Conv()
    {
        // setting the source and destinations of this conversion object
        super (SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_2D,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_POLAR_2D,
                                    SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_AZIMUTHAL_2D,
                                    SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_2D,
                                    SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone()
    {
        return (Conversions) new Lsr2Conv();
    }


/*
 *----------------------------------------------------------------------------
 *
 * Conversion dispatcher
 *
 *----------------------------------------------------------------------------
 */
    protected SRM_Coordinate_Valid_Region_Code convert
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

        switch (destSrfType)
        {
            case SRFTCOD_LOCAL_SPACE_POLAR_2D:
            {
                 // perform pre validation
                 // An exception is thrown if a bad coordinate was passed in
                 // (either implicitly bad or one that would make the
                 // computation fail) and is thrown back to the caller before
                 // we proceed with the computation.
                 retValid = CoordCheck.forLsr2d(src);

                 // azimuth = arctan2(u, v)
                 dest[1] = Math.atan2(src[1], src[0]);

                 if (dest[1] < 0.0)
                     dest[1]+= Const.TWO_PI;

                 // radius = sqrt(x^2 + y^2)
                 dest[0] = Math.sqrt(src[0] * src[0] +
                                     src[1] * src[1]);

                 // perform post validation
                 retValid = CoordCheck.forLocalSpacePolar(dest);
                 break;
            }
            case SRFTCOD_LOCAL_SPACE_AZIMUTHAL_2D:
            {
                 // perform pre validation
                 // An exception is thrown if a bad coordinate was passed in
                 // (either implicitly bad or one that would make the
                 // computation fail) and is thrown back to the caller before
                 // we proceed with the computation.
                 retValid = CoordCheck.forLsr2d(src);

                 // azimuth = arctan2(u, v)
                 dest[1] = Math.atan2(src[0], src[1]);

                 if (dest[1] < 0.0)
                     dest[1]+= Const.TWO_PI;

                 // radius = sqrt(x^2 + y^2)
                 dest[0] = Math.sqrt(src[0] * src[0] +
                                     src[1] * src[1]);

                 // perform post validation
                 retValid = CoordCheck.forLocalSpaceAzimuthal2D(dest);
                 break;
            }
            case SRFTCOD_LOCAL_SPACE_RECT_2D:
            {
                 // perform pre validation
                 // An exception is thrown if a bad coordinate was passed in
                 // and is thrown back to the caller before we proceed with
                 // the computation.
                 retValid = CoordCheck.forNaN_2D(src);

                 toLsr(srcSrf, destSrf, src, dest);

                 // perform post validation
                 retValid = CoordCheck.forNaN_2D(dest);
                 break;
            }
            case SRFTCOD_UNSPECIFIED:
            {
                // Just pass the coordinate through.
                // This is the last conversion of a chain.
                dest[0] = src[0];
                dest[1] = src[1];
                break;
            }
        }
        return retValid;
    }


    protected static double[][] compute_F_u_v
    (
         SRF_LSR_2D_Params lsr_2d_SRF_params
    ) throws SrmException
    {

        /* These values are column vectors representing the
         * axes primary, secondary and tertiary
         */
        double    e1[] = {1,0,0};
        double    e2[] = {0,1,0};

        double    s[] = new double[3];
        double    t[] = new double[3]; /*Where s is forward and t is the other one*/

        double[][] F = new double[4][4];

        switch (lsr_2d_SRF_params.forward_direction)
        {
            case AXDIR_POSITIVE_PRIMARY_AXIS:
                 Const.copyArray(e1, s);
                 Const.copyArray(e2, t);
                 break;
            case AXDIR_POSITIVE_SECONDARY_AXIS:
                 Const.copyArray(e2, s);
                 Const.copyArray(e1, t);
                 break;
            case AXDIR_NEGATIVE_PRIMARY_AXIS:
                 Const.copyArray(e1, s);
                 Const.ConstTimesVect(s, -1); /*Explicitly multiplied by -1 for negative primary axis*/
                 Const.copyArray(e2, t);
                 Const.ConstTimesVect(t, -1);
                 break;
            case AXDIR_NEGATIVE_SECONDARY_AXIS:
                 Const.copyArray(e2, s);
                 Const.ConstTimesVect(s, -1);

                 Const.copyArray(e1, t);
                 Const.ConstTimesVect(t, -1);
                 break;
            default:
                 throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                        new String("Invalid LSR 2D parameters"));
        }
        F[0][0] = s[0];
        F[1][0] = t[0];
        F[2][0] = 0.0;
        F[3][0] = 0.0;

        F[0][1] = s[1];
        F[1][1] = t[1];
        F[2][1] = 0.0;
        F[3][1] = 0.0;

        F[0][2] = s[2];
        F[1][2] = t[2];
        F[2][2] = 0.0;
        F[3][2] = 0.0;

        F[0][3] = 0.0;
        F[1][3] = 0.0;
        F[2][3] = 0.0;
        F[3][3] = 1.0;

        return F;
    }


    protected void setTransformMatrix
    (BaseSRF srcSrf, BaseSRF destSrf) throws SrmException
    {
        double[][] F_src, F_tgt;
        double[][] F_inv_tgt = new double[4][4];
        SRF_LSR_2D_Params lsr2d_srf_src = ((SRF_LocalSpaceRectangular2D)
                                           srcSrf).getSRFParameters();
        SRF_LSR_2D_Params lsr2d_srf_tgt = ((SRF_LocalSpaceRectangular2D)
                                           destSrf).getSRFParameters();

        _transformation_matrix = new double[4][4];

        F_src = compute_F_u_v(lsr2d_srf_src);

        F_tgt = compute_F_u_v(lsr2d_srf_tgt);

        F_tgt[2][2]=1.0;
        Const.transpose(F_tgt, F_inv_tgt, 4);

        Const.matrixMultiply4x4(F_src, F_inv_tgt, _transformation_matrix);
    }
}
