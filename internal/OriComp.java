/**
@author David Shen
*/
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

package SRM;

final class OriComp
{
    protected static SRM_Matrix_3x3 ident_mat = new SRM_Matrix_3x3();

    protected static SRM_Matrix_3x3 matrixMultiply(SRM_Matrix_3x3 a,
                                                   SRM_Matrix_3x3 b)
    {
        SRM_Matrix_3x3 c = new SRM_Matrix_3x3();

        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
            {
                c.m[i][j] = 0.0;
                for (int k=0; k<3; k++)
                    c.m[i][j] += a.m[i][k] * b.m[k][j];
            }

        return c;
    }

    protected static double[] matrixMultiply(SRM_Matrix_3x3 mat,
                                             double[] vec)
    {
        double[] ret_vec = new double[3];

        ret_vec[0] = mat.m[0][0]*vec[0] +
                     mat.m[0][1]*vec[1] +
                     mat.m[0][2]*vec[2];
        ret_vec[1] = mat.m[1][0]*vec[0] +
                     mat.m[1][1]*vec[1] +
                     mat.m[1][2]*vec[2];
        ret_vec[2] = mat.m[2][0]*vec[0] +
                     mat.m[2][1]*vec[1] +
                     mat.m[2][2]*vec[2];

        return ret_vec;
    }

    protected static SRM_Matrix_3x3 matrixTranspose(SRM_Matrix_3x3 mat)
    {
        SRM_Matrix_3x3 ret_mat =  new SRM_Matrix_3x3();

        ret_mat.m[0][1] = mat.m[1][0];
        ret_mat.m[0][2] = mat.m[2][0];
        ret_mat.m[1][0] = mat.m[0][1];
        ret_mat.m[1][2] = mat.m[2][1];
        ret_mat.m[2][0] = mat.m[0][2];
        ret_mat.m[2][1] = mat.m[1][2];

        return ret_mat;
    }

    protected static SRM_Matrix_3x3
        tait_bryan_to_matrix(SRM_Tait_Bryan_Angles_Params tb_params)
    {
        SRM_Matrix_3x3 mat = new SRM_Matrix_3x3();

        double salpha = Math.sin(tb_params.roll);
        double calpha = Math.cos(tb_params.roll);
        double sbeta = Math.sin(tb_params.pitch);
        double cbeta = Math.cos(tb_params.pitch);
        double sgamma = Math.sin(tb_params.yaw);
        double cgamma = Math.cos(tb_params.yaw);

        mat.m[0][0] = cgamma*cbeta;
        mat.m[0][1] = sgamma*cbeta;
        mat.m[0][2] = -sbeta;
        mat.m[1][0] = cgamma*sbeta*salpha - sgamma*calpha;
        mat.m[1][1] = sgamma*sbeta*salpha + cgamma*calpha;
        mat.m[1][2] = cbeta*salpha;
        mat.m[2][0] = cgamma*sbeta*calpha + sgamma*salpha;
        mat.m[2][1] = sgamma*sbeta*calpha - cgamma*salpha;
        mat.m[2][2] = cbeta*calpha;

        return mat;
    }


    protected static SRM_Tait_Bryan_Angles_Params
        matrix_to_tait_bryan(SRM_Matrix_3x3 mat)
    {
        SRM_Tait_Bryan_Angles_Params ret_tb = new SRM_Tait_Bryan_Angles_Params();

        if (Const.isEqual(mat.m[0][2], 1.0, 1.e-12))
        {
            ret_tb.pitch = -Const.PI_DIV_2;
            ret_tb.roll  = Math.atan2(-mat.m[1][0],-mat.m[2][0]);
            ret_tb.yaw   = 0.0;
        }
        else if (Const.isEqual(mat.m[0][2], -1.0, 1.e-12))
        {
            ret_tb.pitch = Const.PI_DIV_2;
            ret_tb.roll  = Math.atan2(mat.m[1][0],mat.m[2][0]);
            ret_tb.yaw   = 0.0;
        }
        else
        {
            ret_tb.pitch = Math.asin(-mat.m[0][2]);
            ret_tb.roll  = Math.atan2(mat.m[1][2], mat.m[2][2]);
            ret_tb.yaw   = Math.atan2(mat.m[0][1], mat.m[0][0]);
        }
        return ret_tb;
    }


    protected static SRM_Matrix_3x3
        euler_zxz_to_matrix(SRM_Euler_Angles_ZXZ_Params zxz_params)
    {
        SRM_Matrix_3x3 mat = new SRM_Matrix_3x3();

        double salpha = Math.sin(zxz_params.spin);
        double calpha = Math.cos(zxz_params.spin);
        double sbeta = Math.sin(zxz_params.nutation);
        double cbeta = Math.cos(zxz_params.nutation);
        double sgamma = Math.sin(zxz_params.precession);
        double cgamma = Math.cos(zxz_params.precession);

        mat.m[0][0] = calpha*cgamma-salpha*cbeta*sgamma;
        mat.m[0][1] = calpha*sgamma+salpha*cbeta*cgamma;
        mat.m[0][2] = salpha*sbeta;
        mat.m[1][0] = -salpha*cgamma-calpha*cbeta*sgamma;
        mat.m[1][1] = -salpha*sgamma+calpha*cbeta*cgamma;
        mat.m[1][2] = calpha*sbeta;
        mat.m[2][0] = sbeta*sgamma;
        mat.m[2][1] = -sbeta*cgamma;
        mat.m[2][2] = cbeta;

        return mat;
    }


    protected static SRM_Euler_Angles_ZXZ_Params
        matrix_to_euler_zxz(SRM_Matrix_3x3 mat)
    {
        SRM_Euler_Angles_ZXZ_Params ret_zxz = new SRM_Euler_Angles_ZXZ_Params();

        if (Const.isEqual(mat.m[2][2], 1.0, 1.e-12))
        {
            ret_zxz.nutation   = 0.0;
            ret_zxz.spin       = 0.0;
            ret_zxz.precession = Math.atan2(mat.m[0][1],mat.m[0][0]);
        }
        else if (Const.isEqual(mat.m[2][2], -1.0, 1.e-12))
        {
            ret_zxz.nutation   = Const.PI;
            ret_zxz.spin       = 0.0;
            ret_zxz.precession = Math.atan2(mat.m[0][1],mat.m[0][0]);
        }
        else
        {
            ret_zxz.nutation   = Math.acos(mat.m[2][2]);
            ret_zxz.spin       = Math.atan2(mat.m[0][2],  mat.m[1][2]);
            ret_zxz.precession = Math.atan2(mat.m[2][0], -mat.m[2][1]);
        }
        return ret_zxz;
    }


    protected static SRM_Matrix_3x3
        axis_angle_to_matrix(SRM_Axis_Angle_Params aa)
    {
        SRM_Matrix_3x3 mat = new SRM_Matrix_3x3();

        double cos_theta, sin_theta;
        double n11, n12, n13, n22, n23, n33, n1st, n2st, n3st, oneMinusCt;

        cos_theta = Math.cos(aa.angle);
        sin_theta = Math.sin(aa.angle);

        n11 = aa.axis[0] * aa.axis[0];
        n12 = aa.axis[0] * aa.axis[1];
        n13 = aa.axis[0] * aa.axis[2];
        n22 = aa.axis[1] * aa.axis[1];
        n23 = aa.axis[1] * aa.axis[2];
        n33 = aa.axis[2] * aa.axis[2];

        n1st = aa.axis[0] * sin_theta;
        n2st = aa.axis[1] * sin_theta;
        n3st = aa.axis[2] * sin_theta;

        oneMinusCt = 1.0 - cos_theta;

        mat.m[0][0] = oneMinusCt*n11 + cos_theta;
        mat.m[0][1] = oneMinusCt*n12 - n3st;
        mat.m[0][2] = oneMinusCt*n13 + n2st;
        mat.m[1][0] = oneMinusCt*n12 + n3st;
        mat.m[1][1] = oneMinusCt*n22 + cos_theta;
        mat.m[1][2] = oneMinusCt*n23 - n1st;
        mat.m[2][0] = oneMinusCt*n13 - n2st;
        mat.m[2][1] = oneMinusCt*n23 + n1st;
        mat.m[2][2] = oneMinusCt*n33 + cos_theta;

        return mat;
    }


    protected static SRM_Axis_Angle_Params
        matrix_to_axis_angle(SRM_Matrix_3x3 mat)
    {
        SRM_Axis_Angle_Params aa = new SRM_Axis_Angle_Params();
        double diag_sum = mat.m[0][0]+mat.m[1][1]+mat.m[2][2];

        if (diag_sum > 3.0)  // upper-bound check
            diag_sum = 3.0;
        else if (diag_sum < -1.0)  // lower-bound check
            diag_sum = -1.0;

        // find angle (may change in extreme cases below)
        aa.angle = Math.acos(0.5*(diag_sum-1.0));

        // find nu
        aa.axis[0] = mat.m[2][1]-mat.m[1][2];
        aa.axis[1] = mat.m[0][2]-mat.m[2][0];
        aa.axis[2] = mat.m[1][0]-mat.m[0][1];

        // modulus of nu
        double modulus = Math.sqrt(aa.axis[0]*aa.axis[0] +
                                   aa.axis[1]*aa.axis[1] +
                                   aa.axis[2]*aa.axis[2]);

        // deal with extreme angle cases
        if (Const.isEqual(aa.angle, 0.0, 1.e-12)) // $$$ need to change to epsilon
        { // small angle case
            aa.angle = Math.asin(0.5*modulus);

            if (modulus < (1.0e-10))
            { // treat as zero
                aa.axis = new double[]{ 1.0, 0.0, 0.0 };
                modulus = 0.0;
            }
        }
        else if (Const.isEqual(aa.angle, Const.PI, 1.e-12)) // $$$ need to change to epsilon
        { // large angle case
            aa.angle = Const.PI - Math.asin(0.5*modulus);

            switch (Const.max(mat.m[0][0], mat.m[1][1], mat.m[2][2]))
            {
                case 1:
                     aa.axis[0] = mat.m[0][0]+1.0;
                     aa.axis[1] = mat.m[0][1];
                     aa.axis[2] = mat.m[0][2];
                     break;
                case 2:
                     aa.axis[0] = mat.m[0][1];
                     aa.axis[1] = mat.m[1][1]+1.0;
                     aa.axis[2] = mat.m[2][1];
                     break;
                case 3:
                     aa.axis[0] = mat.m[0][2];
                     aa.axis[1] = mat.m[1][2];
                     aa.axis[2] = mat.m[2][2]+1.0;
                     break;
            }
            modulus = Math.sqrt(aa.axis[0]*aa.axis[0] +
                                aa.axis[1]*aa.axis[1] +
                                aa.axis[2]*aa.axis[2]);
        }

        // All cases: normalize vector
        if (modulus > 0.0)
        {
            double inv_modulus = 1.0/modulus;

            aa.axis[0] = aa.axis[0] * inv_modulus;
            aa.axis[1] = aa.axis[1] * inv_modulus;
            aa.axis[2] = aa.axis[2] * inv_modulus;
        }
        return aa;
    }

    protected static SRM_Quaternion_Params
        axis_angle_to_qt(SRM_Axis_Angle_Params aa)
    {
        SRM_Quaternion_Params ret_qt = new SRM_Quaternion_Params();

        double stheta2 = Math.sin(aa.angle*0.5);
        ret_qt.e0 = Math.cos(aa.angle*0.5);
        ret_qt.e1 = aa.axis[0]*stheta2;
        ret_qt.e2 = aa.axis[1]*stheta2;
        ret_qt.e3 = aa.axis[2]*stheta2;

        return ret_qt;
    }

    protected static SRM_Quaternion_Params
        matrix_to_qt(SRM_Matrix_3x3 mat)
    {
        return axis_angle_to_qt(matrix_to_axis_angle(mat));
    }

    protected static SRM_Matrix_3x3
        qt_to_matrix(SRM_Quaternion_Params qt)
    {
        SRM_Matrix_3x3 mat = new SRM_Matrix_3x3();

        double e01, e02, e03, e11, e12, e13, e22, e23, e33;

        e01 = qt.e0*qt.e1;
        e02 = qt.e0*qt.e2;
        e03 = qt.e0*qt.e3;
        e11 = qt.e1*qt.e1;
        e12 = qt.e1*qt.e2;
        e13 = qt.e1*qt.e3;
        e22 = qt.e2*qt.e2;
        e23 = qt.e2*qt.e3;
        e33 = qt.e3*qt.e3;

        mat.m[0][0] = 1.0 - 2.0*(e22+e33);
        mat.m[0][1] = 2.0*(e12-e03);
        mat.m[0][2] = 2.0*(e13+e02);
        mat.m[1][0] = 2.0*(e12+e03);
        mat.m[1][1] = 1.0 - 2.0*(e11+e33);
        mat.m[1][2] = 2.0*(e23-e01);
        mat.m[2][0] = 2.0*(e13-e02);
        mat.m[2][1] = 2.0*(e23+e01);
        mat.m[2][2] = 1.0 - 2.0*(e11+e22);

        return mat;
    }
}
