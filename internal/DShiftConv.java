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

class DShiftConv extends Conversions
{
    protected double[][] _Tst = { {1.0, 0.0, 0.0, 0.0},
                                  {0.0, 1.0, 0.0, 0.0},
                                  {0.0, 0.0, 1.0, 0.0},
                                  {0.0, 0.0, 0.0, 1.0 } };

    private boolean constAreSet = false;

    protected DShiftConv()
    {
        super (SRM_SRFT_Code.SRFTCOD_UNSPECIFIED,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone()
    {
        return (Conversions) new DShiftConv();
    }

    private double[][] makeTst(SRM_ORM_Trans_Params  hst)
    {
        double[][] Tst = new double[4][4];

        if (hst instanceof SRM_ORM_Trans_3D_Params)
        {
            Const.WGS84_Transformation_Matrix(Tst,
                                              ((SRM_ORM_Trans_3D_Params)hst)._delta_x,
                                              ((SRM_ORM_Trans_3D_Params)hst)._delta_y,
                                              ((SRM_ORM_Trans_3D_Params)hst)._delta_z,
                                              ((SRM_ORM_Trans_3D_Params)hst)._omega_1,  /* omega_1 rot around x_axis*/
                                              ((SRM_ORM_Trans_3D_Params)hst)._omega_2,  /* omega_2 rot around y_axis*/
                                              ((SRM_ORM_Trans_3D_Params)hst)._omega_3,  /* omega_3 rot around z_axis*/
                                              ((SRM_ORM_Trans_3D_Params)hst)._delta_s);
        }
        else // this is of class SRM_ORM_Trans_2D_Params
        {
            Const.WGS84_Transformation_Matrix_2D(Tst,
                                                 ((SRM_ORM_Trans_2D_Params)hst)._delta_x,
                                                 ((SRM_ORM_Trans_2D_Params)hst)._delta_y,
                                                 ((SRM_ORM_Trans_2D_Params)hst)._omega,
                                                 ((SRM_ORM_Trans_2D_Params)hst)._delta_s);
        }
        return Tst;
    }


    protected SRM_Coordinate_Valid_Region_Code convert
    (
        SRM_SRFT_Code        srfType,
        BaseSRF              srcSrf,
        BaseSRF              destSrf,
        double[]             src,
        double[]             dest,
        SRM_ORM_Trans_Params hst
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid =
            SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;

        double[] temp1 = { src[0], src[1], src[2], 1.0 };
        double[] temp2 = new double[4];

        if (hst == null)
        {
            // we will just apply the 4x4 matrix and return it as the "dest" Coordinate
            if (!constAreSet)
                setDShiftConst(srcSrf.getOrm(),  srcSrf.getRt(),
                               destSrf.getOrm(), destSrf.getRt());

            Const.multMatrixSubsetVector(_Tst, temp1, temp2, 4);
        }
        else
        {
            Const.multMatrixSubsetVector(makeTst(hst), temp1, temp2, 4);
        }
        dest[0] = temp2[0];
        dest[1] = temp2[1];
        dest[2] = temp2[2];

        return retValid;
    }


    protected void setDShiftConst
    (
        SRM_ORM_Code srcOrm,
        SRM_RT_Code  srcRt,
        SRM_ORM_Code tgtOrm,
        SRM_RT_Code  tgtRt
    ) throws SrmException
    {
        RtDataSet secondary_axis = null;
        RtDataSet t = null;

        secondary_axis = RtDataSet.getElem(srcRt);

        t = RtDataSet.getElem(tgtRt);

        double[][] T_SR = new double[4][4];
        double[][] T_RT = new double[4][4];

        // kludge for now until the db is fixed
        if (Double.isNaN(secondary_axis._delta_x))
        {
            secondary_axis._delta_x = 0.0;
            secondary_axis._delta_y = 0.0;
            secondary_axis._delta_z = 0.0;
            secondary_axis._omega_1 = 0.0;
            secondary_axis._omega_2 = 0.0;
            secondary_axis._omega_3 = 0.0;
            secondary_axis._delta_scale = 0.0;
        }
        if (Double.isNaN(t._delta_x))
        {
            t._delta_x = 0.0;
            t._delta_y = 0.0;
            t._delta_z = 0.0;
            t._omega_1 = 0.0;
            t._omega_2 = 0.0;
            t._omega_3 = 0.0;
            t._delta_scale = 0.0;
        }

        // set the _Tsr constant to the result of this tranformation
        Const.WGS84_Transformation_Matrix(T_SR,
                                          secondary_axis._delta_x,
                                          secondary_axis._delta_y,
                                          secondary_axis._delta_z,
                                          secondary_axis._omega_1,  /* omega1 rot around x_axis*/
                                          secondary_axis._omega_2,  /* omega2 rot around y_axis*/
                                          secondary_axis._omega_3,  /* omega3 rot around z_axis*/
                                          secondary_axis._delta_scale);

        Const.WGS84_InverseTransformation_Matrix(T_RT,
                                                 t._delta_x,
                                                 t._delta_y,
                                                 t._delta_z,
                                                 t._omega_1,  /* omega1 rot around x_axis*/
                                                 t._omega_2,  /* omega2 rot around y_axis*/
                                                 t._omega_3,  /* omega3 rot around z_axis*/
                                                 t._delta_scale);

        Const.matrixMultiply4x4(T_RT, T_SR, _Tst);

        constAreSet = true;
   }
}
