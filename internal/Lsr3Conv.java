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

class Lsr3Conv extends LsrConv
{
    protected Lsr3Conv()
    {
        // setting the source and destinations of this conversion object
        super (SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_3D,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_3D,
                                    SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone()
    {
        return (Conversions) new Lsr3Conv();
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

        if (destSrfType == SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_3D)
        {
            // No restrictions
            toLsr(srcSrf, destSrf, src, dest);
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            // just pass the coordinate through.  This is the last conversion of chain
            dest[0] = src[0];
            dest[1] = src[1];
            dest[2] = src[2];
        }
        return retValid;
    }

    protected static double[][] compute_F_u_v_w
    (
        SRF_LSR_3D_Params lsr_3d_SRF_params
    ) throws SrmException
    {
        /* These values are column vectors representing the
         * axes primary secondary and tertiary
         */
        double e1[]={1,0,0};
        double e2[]={0,1,0};
        double e3[]={0,0,1};

        /* These values are column vecors representing the
         * Transform Matrix U coumns E2 and E3.  E1=E2xE3
         * where x is the vector cross product
         */
        double    primary_axis[] = new double[3];   /* direction of forward */
        double    secondary_axis[] = new double[3]; /* direction of up */
        double    t[] = new double[3];  /*t=primary_axis x secondary_axis*/

        double[][] F = new double[4][4];

        if (lsr_3d_SRF_params.forward_direction ==
            SRM_Axis_Direction.AXDIR_POSITIVE_PRIMARY_AXIS)
        {
            /*Implicitly multiplied by 1 for positive primary axis*/
            Const.copyArray(e1, primary_axis);
        }
        else if (lsr_3d_SRF_params.forward_direction ==
                 SRM_Axis_Direction.AXDIR_POSITIVE_SECONDARY_AXIS)
        {
            /*Implicitly multiplied by 1 for positive secondary axis*/
            Const.copyArray(e2, primary_axis);
        }
        else if (lsr_3d_SRF_params.forward_direction ==
                 SRM_Axis_Direction.AXDIR_POSITIVE_TERTIARY_AXIS)
        {
            /*Implicitly multiplied by 1 for positive tertiary axis*/
            Const.copyArray(e3, primary_axis);
        }
        else if (lsr_3d_SRF_params.forward_direction ==
                 SRM_Axis_Direction.AXDIR_NEGATIVE_PRIMARY_AXIS)
        {
            Const.copyArray(e1, primary_axis);
            Const.ConstTimesVect(primary_axis, -1); /*Explicitly multiplied by -1 for negative primary axis*/
        }
        else if (lsr_3d_SRF_params.forward_direction ==
                 SRM_Axis_Direction.AXDIR_NEGATIVE_SECONDARY_AXIS)
        {
            Const.copyArray(e2, primary_axis);
            Const.ConstTimesVect(primary_axis, -1); /*Explicitly multiplied by -1 for negative secondary axis*/
        }
        else
        {
            // (lsr_3d_SRF_params.forward_direction ==
            // SRM_Axis_Direction.AXDIR_NEGATIVE_TERTIARY_AXIS)
            Const.copyArray(e3, primary_axis);
            Const.ConstTimesVect(primary_axis, -1); /*Explicitly multiplied by -1 for negative secondary axis*/
        }


        if (lsr_3d_SRF_params.up_direction ==
            SRM_Axis_Direction.AXDIR_POSITIVE_PRIMARY_AXIS)
        {
            /*Implicitly multiplied by 1 for positive primary axis*/
            Const.copyArray(e1, secondary_axis);
        }
        else if (lsr_3d_SRF_params.up_direction ==
                 SRM_Axis_Direction.AXDIR_POSITIVE_SECONDARY_AXIS)
        {
            /*Implicitly multiplied by 1 for positive secondary axis*/
            Const.copyArray(e2, secondary_axis);
        }
        else if (lsr_3d_SRF_params.up_direction ==
                 SRM_Axis_Direction.AXDIR_POSITIVE_TERTIARY_AXIS)
        {
            /*Implicitly multiplied by 1 for positive tertiary axis*/
            Const.copyArray(e3, secondary_axis);
        }
        else if (lsr_3d_SRF_params.up_direction ==
                 SRM_Axis_Direction.AXDIR_NEGATIVE_PRIMARY_AXIS)
        {
            Const.copyArray(e1, secondary_axis);
            Const.ConstTimesVect(secondary_axis, -1); /*Explicitly multiplied by -1 for negative primary axis*/
        }
        else if (lsr_3d_SRF_params.up_direction ==
                 SRM_Axis_Direction.AXDIR_NEGATIVE_SECONDARY_AXIS)
        {
            Const.copyArray(e2, secondary_axis);
            Const.ConstTimesVect(secondary_axis, -1); /*Explicitly multiplied by -1 for negative secondary axis*/
        }
        else
        {
            // (lsr_3d_SRF_params.up_direction ==
            // SRM_Axis_Direction.AXDIR_NEGATIVE_TERTIARY_AXIS)
            Const.copyArray(e3, secondary_axis);
            Const.ConstTimesVect(secondary_axis, -1); /*Explicitly multiplied by -1 for negative secondary axis*/
        }
        Const.vectCrossProd(primary_axis, secondary_axis, t);  /*Generates t which we consider z by taking the cross product of u and secondary_axis*/

        if (Const.square(t[0]) + Const.square(t[1])
            + Const.square(t[2]) < Const.EPSILON_SQ)
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   new String("Invalid LSR 3D parameters"));
        }
        else
        {
            /* Following ISO 18026 and a personal communication from Paul
               Berner dated April 28, 2004 we resolved that the correct
               nomenclature for the unit vectors in LSR is primary_axis,
               secondary_axis, and t. These are to be column vectors following
               the notation of the standard so that when the matrix formed of
               them is placed on the left of a column vector and multiplied,
               the result will be a coordinate with customary sign and order
               of the components.
            */
            F[0][0] = primary_axis[0];
            F[1][0] = primary_axis[1];
            F[2][0] = primary_axis[2];
            F[3][0] = 0.0;

            F[0][1] = secondary_axis[0];
            F[1][1] = secondary_axis[1];
            F[2][1] = secondary_axis[2];
            F[3][1] = 0.0;

            F[0][2] = t[0];
            F[1][2] = t[1];
            F[2][2] = t[2];
            F[3][2] = 0.0;

            F[0][3] = 0.0;
            F[1][3] = 0.0;
            F[2][3] = 0.0;
            F[3][3] = 1.0;

        }
        return F;
    }


    protected void setTransformMatrix
    (
        BaseSRF srcSrf,
        BaseSRF destSrf
    ) throws SrmException
    {
        double[][] F_src, F_tgt;
        double[][] F_inv_tgt = new double[4][4];
        SRF_LSR_3D_Params lsr3d_srf_src = ((SRF_LocalSpaceRectangular3D)
                                           srcSrf).getSRFParameters();
        SRF_LSR_3D_Params lsr3d_srf_tgt = ((SRF_LocalSpaceRectangular3D)
                                           destSrf).getSRFParameters();

        _transformation_matrix = new double[4][4];

        F_src = compute_F_u_v_w(lsr3d_srf_src);

        F_tgt = compute_F_u_v_w(lsr3d_srf_tgt);

        Const.transpose(F_tgt, F_inv_tgt, 4);

        Const.matrixMultiply4x4(F_inv_tgt, F_src, _transformation_matrix);
    }
}
