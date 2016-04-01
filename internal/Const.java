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

final class Const
{
    protected static final double PI = 3.14159265358979323846; // more precise than Math.PI
    protected static final double TWO_PI = 2.0 * PI;
    protected static final double FOUR_PI = 4.0 * PI;
    protected static final double PI_DIV_4 = 0.785398163397448309615;
    protected static final double PI_DIV_2 = 1.570796326794896619230;
    protected static final double ONE_DIV_ROOT_2 = 0.70710678118654752440;
    protected static final double RADIANS_PER_DEGREE = PI / 180.0;
    protected static final double DEGREES_PER_RADIAN = 180.0 / PI;

    /** Epsilon value for equivalence tests
     */
    protected static final double EPSILON = 0.000001;
    protected static final double EPSILON_SQ = EPSILON*EPSILON;

    protected static final double TM_EXTENDED_LONGITUDE_RANGE = (3.5* Const.RADIANS_PER_DEGREE);
    protected static final double TM_LONGITUDE_RANGE = (3.0* Const.RADIANS_PER_DEGREE);

    protected static final double square(double var)
    {
        return var * var;
    }

    protected static final double cube(double var)
    {
        return var * var * var;
    }

    protected static final double twoTimes(double var)
    {
        return var + var;
    }

    protected static final double triple(double var)
    {
        return var + var + var;
    }

    protected static final int roundDown(double var)
    {
        if (Math.round(var) < var)
            return (int)Math.round(var);
        else
            return (int)(Math.round(var) - 1);
    }

    protected static final double power_p(OrmData e_constants, double var)
    {
        return (Math.pow((1.0-e_constants.Eps*var)/(1.0+e_constants.Eps*var),
                         e_constants.Eps*0.5));
    }

    protected static final double power_p_inv(OrmData e_constants, double var)
    {
        return (Math.pow((1.0+e_constants.Eps*var)/(1.0-e_constants.Eps*var),
                         e_constants.Eps*0.5));
    }

    protected static final double power_p_approx
    (
        double[] cr1,
        double[] cr2,
        double   sin_lat
    )
    {
        return ((Math.abs(sin_lat) < 0.5807029557109)?
                (cr1[0] + (cr1[1] * sin_lat + cr1[2])/ (cr1[3] + sin_lat * (cr1[4] + sin_lat))):
                (cr2[0] + (cr2[1] * sin_lat + cr2[2])/ (cr2[3] + sin_lat * (cr2[4] + sin_lat))));
    }

    protected static final double chi_approx(double[] b, double sin_squared_chi)
    {
        return (b[0] + (sin_squared_chi) *(b[1] + (sin_squared_chi)* (b[2] + (sin_squared_chi) * b[3])));
    }

    protected static final double gee(double h,
                                      double xlat,
                                      double a,
                                      double eps2)
    {
        double rn, result;
        double s2 = Math.sin(xlat);
        s2        = s2 * s2;
        rn        = a / Math.sqrt(1.0-eps2*s2);
        result    = (rn+h) / ((1.0-eps2)*rn+h);
        return result;
    }

    protected static final double computeRnFast(double arg, OrmData e_constants)
    {
        double alpha =   1.004244;
        double d1    = - 0.5*e_constants.Eps2;
        double x     =   d1*arg;
        double ak    =   0.5+x;
        double z     =   1.0-(alpha*x);
        return (e_constants.A*z*(1.5-ak*z*z));
    }

    protected static final double computeRn(double arg, OrmData e_constants)
    {
        double z0;
        double temp;

        temp = e_constants.Eps25 * arg;
        z0   = 0.4999986087 - temp;

        return (e_constants.A * z0) / (square(z0) + 0.25 - temp);
    }

    protected static final double computeRnExact(double arg, OrmData e_constants)
    {
        return e_constants.A / Math.sqrt(1.0 - e_constants.Eps2 * arg);
    }

    protected static final double computeRnInv(double arg, OrmData e_constants)
    {
        final double alpha=.4999986087;
        /*Alpha is a magic number for the first guess*/
        double temp=e_constants.Eps25*arg;
        double z0=alpha-temp;

        return ((Const.square(z0)+0.25-temp)/(e_constants.A*z0));
    }

    protected static boolean isValidOrmRt(SRM_ORM_Code orm,
                                          SRM_RT_Code  rt)
    {
        boolean isValid = false;

        // Unspecified RT is valid for all dynamic ORMs, but only for them
        if (rt == SRM_RT_Code.RTCOD_UNSPECIFIED)
        {
            if ((orm == SRM_ORM_Code.ORMCOD_EARTH_INERT_ARIES_1950)
             || (orm == SRM_ORM_Code.ORMCOD_EARTH_INERT_ARIES_TRUE_OF_DATE)
             || (orm == SRM_ORM_Code.ORMCOD_EARTH_INERTIAL_J2000r0))
            {
                isValid = true;
            }
        }
        else if (orm == SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_MAX)
        {
            if (rt == SRM_RT_Code.RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT)
            {
                isValid = true;
            }
        }
        else if (orm == SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_SPHERE)
        {
            if (rt == SRM_RT_Code.RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT)
            {
                isValid = true;
            }
        }
        else
        {
            isValid = RtDataSet.isValidPair(orm, rt);
        }
        return isValid;
    }

    protected static final boolean isWellFormedLongitude(double longitude)
    {
        return ((longitude > -PI) && (longitude <= PI));
    }

    protected static final boolean isWellFormedLatitude(double latitude)
    {
        return ((latitude > -PI_DIV_2) && (latitude < PI_DIV_2));
    }

    protected static final boolean isWellFormedRadius(double radius)
    {
        return (radius > 0.0);
    }

    protected static final boolean isWellFormedScale(double scale)
    {
        return (scale > 0.5 && scale <= 1.25);
    }

    protected static final boolean isWellFormedAzimuth(double azimuth)
    {
        return (azimuth >= 0.0 && azimuth <= TWO_PI);
    }

    protected static final boolean isWellFormedCylindricalAngle(double angle)
    {
        return (angle >=0.0  && angle < TWO_PI);
    }

    protected static final boolean isWellFormedHeight(double height)
    {
        /*Because of the numerical nature of the celestiocentric to
          celestiodetic conversion, .2mm of EPSILON error margin is added to
          so that tests on the boundary pass.  Because the output of
          celestiocentric to celestiodetic conversion is guaranteed to 1mm
          and significant figures in the code are meaningful only in the .1mm
          place and higher, this change has no significance other than
          preventing a bunch of good test data from being regenerated.
          --CDK June 28, 2005
        */
        return (height > -50000.0002  &&
                height <= 1000000.0);
    }

    protected static final boolean isEqual(double a, double b, double tolerance)
    {
        return (Math.abs(a - b) <= tolerance);
    }

    protected static final double atanh(double x)
    {
        return ((Math.log((1.0+x)/(1.0-x))*0.5));
    }

    // simple orientation comparison operations
    protected static final boolean areEqualAngles
    (
        double a,
        double b,
        double tolerance
    )
    {
        return (Math.abs(a - b)                   <= tolerance ||
                Math.abs(Math.abs(a - b)-TWO_PI)  <= tolerance ||
                Math.abs(Math.abs(a - b)-FOUR_PI) <= tolerance);
    }

    protected static final boolean isEqual
    (
        double[] a,
        double[] b,
        double   tolerance
    )
    {
        return ((square(a[0]-b[0]) +
                 square(a[1]-b[1]) +
                 square(a[2]-b[2])) <= tolerance*tolerance);
    }

    protected static final boolean isEqual
    (
        double[][] a,
        double[][] b,
        double     tolerance
    )
    {
        return (isEqual(a[0][0], b[0][0], tolerance) &&
                isEqual(a[0][1], b[0][1], tolerance) &&
                isEqual(a[0][2], b[0][2], tolerance) &&
                isEqual(a[1][0], b[1][0], tolerance) &&
                isEqual(a[1][1], b[1][1], tolerance) &&
                isEqual(a[1][2], b[1][2], tolerance) &&
                isEqual(a[2][0], b[2][0], tolerance) &&
                isEqual(a[2][1], b[2][1], tolerance) &&
                isEqual(a[2][2], b[2][2], tolerance));
    }

    protected static final boolean isUnit(double[] vec)
    {
        return isEqual(square(vec[0])+square(vec[1])+square(vec[2]),
                       1.0, EPSILON);
    }

    protected static final boolean inFourPiRange(double a)
    {
        return (-TWO_PI<=a && TWO_PI>=a);
    }

    protected static final boolean inPiRange(double a)
    {
        return (-PI_DIV_2<=a && PI_DIV_2>=a);
    }

    protected static final double reduce(double angle, double bound)
    {
        if (angle <= -bound)
            return angle + 2.0*bound;
        else
            return angle;
    }

    protected static final int max(double a,
                                   double b,
                                   double c)
    {
        if (a>=b && a>=c)
            return 1;
        else if (b>=a && b>=c)
            return 2;
        else
            return 3;
    }


    protected static double delta_lambda_min(double  lambda1, double lambda2)
    {
        double simple_difference;

        if (lambda2 >= lambda1)
        {
            simple_difference = lambda2 - lambda1;
            if (Math.abs(simple_difference) >= Const.PI)
                return Math.IEEEremainder((Const.TWO_PI -lambda2) + lambda1,
                                          Const.TWO_PI);
            else
                return simple_difference;
        }
        else
        {
            simple_difference = lambda1 - lambda2;
            if (Math.abs(simple_difference) >= Math.PI)
                return Math.IEEEremainder((Const.TWO_PI-lambda1) + lambda2,
                                          Const.TWO_PI);
            else
                return simple_difference;
        }
    }

    protected static class ArcLengthConst
    {
        double n;
        double P, Pn;
        double v;
        double Pv;
        double u;
        double B0, B2, B4, B6;

        public ArcLengthConst(OrmData e_constants)
        {
            n  = (e_constants.A-e_constants.B)/(e_constants.A+e_constants.B);
            P  = e_constants.A/(1.0+n);
            Pn = P*n;
            v  = Const.square(n);
            Pv = P*v;
            u  = 23.3333333333333333*n;
            B0 = P+0.25*Pv;
            B2 = Pn*(-3.0+3.75*n-4.0*v);
            B4 = Pv*(-7.5 + u);
            B6 = -u*Pv;
        }
    }

    protected static double arcLength(ArcLengthConst al,
                                      double         phi,
                                      double         sin_phi,
                                      double         cos_phi)
    {
        /*Arc length is often called Sa or S in SEDRIS related literature*/
        return (al.B0*phi)+(sin_phi*cos_phi)*
               (al.B2+square(sin_phi)*(al.B4+square(sin_phi)*al.B6));
    }

    protected static class FootPointConst
    {
        double k0_inv;
        double P1, P2, P3;

        public FootPointConst(OrmData        e_constants,
                              ArcLengthConst al,
                              double         central_scale)
        {
           /*note that footpoint constants is interrelated with arclength
             constants and that arclength constants must have been
             called with the same earth model and the results passed here
             for the initialization to work*/
            k0_inv=1.0/central_scale;
            P1=al.n*(3.0+al.n*(5.25+7.75*(al.n)));
            P2=-Const.square(al.n)*(10.5+50.3333333333333333*al.n);
            P3=50.3333333333333333*cube(al.n);
        }
    }


    protected static double footPoint(OrmData        e_constants,
                                      ArcLengthConst al,
                                      FootPointConst fp,
                                      double         mu)
    {
        double sin_mu=Math.sin(mu), cos_mu=Math.cos(mu);
        /*y is assumed to have been divided by the scale factor before if is pased to this routine*/
        return mu+sin_mu*cos_mu*(fp.P1+square(sin_mu)*(fp.P2+square(sin_mu)*(fp.P3)));
    }


    protected static double getLambdaStar(double longitude,
                                          double origin_longitude)
    {
        double lambda_star = longitude - origin_longitude;

        if (lambda_star <= - PI)
            lambda_star += TWO_PI;

        else if (lambda_star > PI)
            lambda_star -= TWO_PI;

        return lambda_star;
    }

    protected static double getAlphaStar(double azimuth, double origin_azimuth)
    {
        double alpha_star = azimuth - origin_azimuth;

        if (alpha_star < 0.0)
            alpha_star += Const.TWO_PI;
        else if (alpha_star >= Const.TWO_PI)
            alpha_star -= Const.TWO_PI;

        return alpha_star;
    }


    protected static void copyArray(double[] src, double[] dest)
    {
        dest[0] = src[0];
        dest[1] = src[1];
        dest[2] = src[2];
    }


    protected static void ConstTimesVect(double[] dest, double factor)
    {
        dest[0] *= factor;
        dest[1] *= factor;
        dest[2] *= factor;
    }


    protected static double[] vectSum(double[] vec1, double[] vec2)
    {
        double[] ret_sum = new double[3];

        ret_sum[0] = vec1[0] + vec2[0];
        ret_sum[1] = vec1[1] + vec2[1];
        ret_sum[2] = vec1[2] + vec2[2];

        return ret_sum;
    }


    protected static double vectDotProd(double[] v1, double[] v2)
    {
        double ret_v = 0.0;

        for (int i=0; i<3; i++)
            ret_v = ret_v + (v1[i] * v2[i]);

        return ret_v;
    }

    protected static void vectCrossProd(double[] v1, double[] v2, double[] v3)
    {
        v3[0] = v1[1]*v2[2] - v1[2]*v2[1];
        v3[1] = v1[2]*v2[0] - v1[0]*v2[2];
        v3[2] = v1[0]*v2[1] - v1[1]*v2[0];
    }

    protected static void multMatrixSubsetVector(double[][] A,
                                                 double[]   x,
                                                 double[]   b,
                                                 int        rank)
    {
        for (int i=0; i<rank; i++)
        {
            b[i] = 0.0;
            for (int j=0; j<rank; j++)
            {
                b[i]+= A[i][j] * x[j];
            }
        }
    }

    protected static double exactArcLength(double a,
                                           double c,
                                           double e2,
                                           double xlat)
    {
        double c1,c2,c3,c4,c5,c6,con,e4,e6,t1,t2,t3,t4,t5,t6;

        c1 = 1.0 + e2 * (0.75 + e2 * (45.0 / 64.0 + e2 * (175.0 / 256.0 + e2 * (11025.0 / 16384.0 + e2 * (43659.0 / 65536.0)))));
        c2 = e2 * (0.75 + e2 * (15.0 / 16.0 + e2 * (525.0 / 512.0 + e2 * (2205.0 / 2048.0 + e2 * (72765.0 / 65536.0)))));

        e4 = e2 * e2;
        c3 = e4 * (15.0 / 64.0 + e2 * (105.0 / 256.0 + e2 * (2205.0 / 4096.0 + e2 * 10395.0 / 16384)));
        e6 = e4 * e2;
        c4 = e6 * (35.0 / 512.0 + e2 * (315.0 / 2048.0 + e2 * 31185.0 / 131072.0));
        c5 = e4 * e4 * (315.0 / 16384.0 + e2 * 3465.0 / 65536.0);
        c6 = e4 * e6 * 693.0 / 131072.0;

        con = a * (1 - e2);

        t1 = con * c1 * xlat;
        t2 = con * c2;
        t3 = con * c3;
        t4 = con * c4;
        t5 = con * c5;
        t6 = con * c6;

        t2 = t2 * Math.sin(2.0 * xlat) / 2.0;
        t3 = t3 * Math.sin(4.0 * xlat) / 4.0;
        t4 = t4 * Math.sin(6.0 * xlat) / 6.0;
        t5 = t5 * Math.sin(8.0 * xlat) / 8.0;
        t6 = t6 * Math.sin(10.0 * xlat) / 10.0;

        return (t1 - t2 + t3 - t4 + t5 -t6);
    }


    /*This function places in t a matrix for use with homogenous coordinates
     *that will perform the rotation and translation components of the
     *WGS 84 Conversion.  Scale is currently not used
     *
     *  Source is PDB: LTPxfer01.doc 11/18/2002
     */
    protected static void WGS84_Transformation_Matrix
    (
        double[][] T,
        double delta_x,
        double delta_y,
        double delta_z,
        double omega_x, /* omega_1 rot around x_axis*/
        double omega_y, /* omega_2 rot around y_axis*/
        double omega_z, /* omega_3 rot around z_axis*/
        double delta_scale
    )
    {
        double cox=Math.cos(-omega_x);
        double sox=Math.sin(-omega_x);

        double coy=Math.cos(-omega_y);
        double soy=Math.sin(-omega_y);

        double coz=Math.cos(-omega_z);
        double soz=Math.sin(-omega_z);

        double[][] Tsr1 = { {1.0, 0.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0, 0.0},
                            {0.0, 0.0, 1.0, 0.0},
                            {0.0, 0.0, 0.0, 1.0 } };
        double[][] Tsr2 = { {1.0, 0.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0, 0.0},
                            {0.0, 0.0, 1.0, 0.0},
                            {0.0, 0.0, 0.0, 1.0 } };
        double[][] Tsr3 = { {1.0, 0.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0, 0.0},
                            {0.0, 0.0, 1.0, 0.0},
                            {0.0, 0.0, 0.0, 1.0 } };
        double[][] result1 = { {1.0, 0.0, 0.0, 0.0},
                               {0.0, 1.0, 0.0, 0.0},
                               {0.0, 0.0, 1.0, 0.0},
                               {0.0, 0.0, 0.0, 1.0 } };

        /*Initialize the upper left 3x3 to what we need it to be*/
        /*The two instances
          of soz seem to have had their signs swapped in this matrix.
          No fix has been applied*/
        Tsr3[0][0]= coz;   Tsr3[0][1]= soz;   Tsr3[0][2]= 0.0;

        Tsr3[1][0]= -soz;  Tsr3[1][1]= coz;   Tsr3[1][2]= 0.0;

        Tsr3[2][0]= 0.0;   Tsr3[2][1]= 0.0;   Tsr3[2][2]= 1.0;
        /* end m1 *************/

        /* m2 *****************/
        Tsr2[0][0]= coy;   Tsr2[0][1]= 0.0;   Tsr2[0][2]= -soy;

        Tsr2[1][0]= 0.0;   Tsr2[1][1]= 1.0;   Tsr2[1][2]= 0.0;

        Tsr2[2][0]= soy;   Tsr2[2][1]= 0.0;   Tsr2[2][2]= coy;
        /* end m2 *************/

        /* m3******************/

        Tsr1[0][0]= 1.0;   Tsr1[0][1]= 0.0;  Tsr1[0][2]= 0.0;

        Tsr1[1][0]= 0.0;   Tsr1[1][1]= cox;  Tsr1[1][2]= sox;

        Tsr1[2][0]= 0.0;   Tsr1[2][1]= -sox; Tsr1[2][2]= cox;
        /* end m3*/

        matrixMultiply4x4(Tsr2, Tsr1, result1);
        matrixMultiply4x4(Tsr3, result1, T);

        T[0][3]=delta_x;
        T[1][3]=delta_y;
        T[2][3]=delta_z;

        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                T[i][j] *= (1.0 + delta_scale * 1.0e-6);
    }


    protected static void WGS84_Transformation_Matrix_2D
    (
        double[][] T,
        double     delta_x,
        double     delta_y,
        double     omega,
        double     delta_scale
    )
    {
        double co=Math.cos(-omega);
        double so=Math.sin(-omega);

        T[0][0]= co;
        T[0][1]= so;
        T[1][0]= -so;
        T[1][1]= co;

        T[0][2]=delta_x;
        T[1][2]=delta_y;

        for (int i=0;i<2;i++)
            for (int j=0;j<2;j++)
                T[i][j] *= (1.0 + delta_scale * 1.0e-6);
    }


    protected static void WGS84_InverseTransformation_Matrix
    (
        double[][] T,
        double delta_x,
        double delta_y,
        double delta_z,
        double omega_x,  /* omega_1 rot around x_axis*/
        double omega_y,  /* omega_2 rot around y_axis*/
        double omega_z,  /* omega_3 rot around z_axis*/
        double delta_scale
    )
    {
        double cox=Math.cos(-omega_x);
        double sox=Math.sin(-omega_x);

        double coy=Math.cos(-omega_y);
        double soy=Math.sin(-omega_y);

        double coz=Math.cos(-omega_z);
        double soz=Math.sin(-omega_z);

        double[] delta_TR = {0.0, 0.0, 0.0, 1.0};
        double[] delta_RT = new double[4];

        double[][] Tsr1 = { {1.0, 0.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0, 0.0},
                            {0.0, 0.0, 1.0, 0.0},
                            {0.0, 0.0, 0.0, 1.0 } };
        double[][] Tsr2 = { {1.0, 0.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0, 0.0},
                            {0.0, 0.0, 1.0, 0.0},
                            {0.0, 0.0, 0.0, 1.0 } };
        double[][] Tsr3 = { {1.0, 0.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0, 0.0},
                            {0.0, 0.0, 1.0, 0.0},
                            {0.0, 0.0, 0.0, 1.0 } };
        double[][] result1 = { {1.0, 0.0, 0.0, 0.0},
                               {0.0, 1.0, 0.0, 0.0},
                               {0.0, 0.0, 1.0, 0.0},
                               {0.0, 0.0, 0.0, 1.0 } };
        double[][] result2 = { {1.0, 0.0, 0.0, 0.0},
                               {0.0, 1.0, 0.0, 0.0},
                               {0.0, 0.0, 1.0, 0.0},
                               {0.0, 0.0, 0.0, 1.0 } };

        /*Initialize the upper left 3x3 to what we need it to be*/
        /* m1******************/
        /*The two instances
          of soz seem to have had their signs swapped in this matrix.
          No fix has been applied*/
        Tsr3[0][0]= coz;   Tsr3[0][1]= soz;   Tsr3[0][2]= 0.0;

        Tsr3[1][0]= -soz;  Tsr3[1][1]= coz;   Tsr3[1][2]= 0.0;

        Tsr3[2][0]= 0.0;   Tsr3[2][1]= 0.0;   Tsr3[2][2]= 1.0;
        /* end m1 *************/

        /* m2 *****************/
        Tsr2[0][0]= coy;   Tsr2[0][1]= 0.0;   Tsr2[0][2]= -soy;

        Tsr2[1][0]= 0.0;   Tsr2[1][1]= 1.0;   Tsr2[1][2]= 0.0;

        Tsr2[2][0]= soy;   Tsr2[2][1]= 0.0;   Tsr2[2][2]= coy;
        /* end m2 *************/

        /* m3******************/

        Tsr1[0][0]= 1.0;   Tsr1[0][1]= 0.0;  Tsr1[0][2]= 0.0;

        Tsr1[1][0]= 0.0;   Tsr1[1][1]= cox;  Tsr1[1][2]= sox;

        Tsr1[2][0]= 0.0;   Tsr1[2][1]= -sox; Tsr1[2][2]= cox;
        /* end m3*/

        matrixMultiply4x4(Tsr2, Tsr1, result1);
        matrixMultiply4x4(Tsr3, result1, result2);

        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                result2[i][j] *= 1.0 / (1.0+delta_scale*1.0e-6);

        transpose(result2, T, 4);

        delta_TR[0]=-delta_x;
        delta_TR[1]=-delta_y;
        delta_TR[2]=-delta_z;

        multMatrixSubsetVector(T, delta_TR, delta_RT, 3);

        T[0][3]=delta_RT[0];
        T[1][3]=delta_RT[1];
        T[2][3]=delta_RT[2];
    }

    protected static void normalizeDirection(double[] v) throws SrmException
    {
        double magnitude = Math.sqrt(v[0] * v[0] +
                                     v[1] * v[1] +
                                     v[2] * v[2]);
        if (magnitude * magnitude > EPSILON_SQ)
        {
            double scale = 1.0 / magnitude;

            v[0] *= scale;
            v[1] *= scale;
            v[2] *= scale;
        }
        else
            throw new SrmException(SrmException._INACTIONABLE,
                                   new String("Normalization of zero magnitude vector"));
    }


    protected static double fix_longitude(double lon)
    {
        if (lon > Const.PI)
            return lon - Const.TWO_PI ;
        else if (lon <= -Const.PI)
             return lon + Const.TWO_PI;
        else
            return lon;
    }


    protected static void applyMatrix3x3 (double[]   src,
                                          double[][] mtx3x3,
                                          double[]   dest)
    {
        // pre-multiple vector by matrix dest = src * mtx3x3
        for (int i=0; i<3; i++)
        {
            dest[i] = 0.0;
            for (int j=0; j<3; j++)
            {
                dest[i] += src[j] * mtx3x3[i][j];
            }
        }
    }


    protected static void applyMatrix4x4 (double[]   src,
                                          double[][] mtx4x4,
                                          double[]   dest)
    {
        // pre-multiple vector by matrix dest = src * mtx4x4
        for (int i=0; i<4; i++)
        {
            dest[i] = 0.0;
            for (int j=0; j<4; j++)
            {
                dest[i] += src[j] * mtx4x4[j][i];
            }
        }
    }


    // 4x4 matrix multiplication c=a*b
    protected static void matrixMultiply4x4 (double[][] a,
                                             double[][] b,
                                             double[][] c)
    {
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4; j++)
            {
                c[i][j] = 0.0;
                for (int n=0; n<4; n++)
                {
                    c[i][j] += a[i][n] * b[n][j];
                }
            }
        }
    }

    // 3x3 matrix multiplication c=a*b
    protected static void matrixMultiply3x3 (double[][] a,
                                             double[][] b,
                                             double[][] c)
    {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                c[i][j] = 0.0;
                for (int n=0; n<3; n++)
                {
                    c[i][j] += a[i][n] * b[n][j];
                }
            }
        }
    }


    // this matrix invert method only applies to the cases
    // where the inverse is the trasposed matrix.  This
    // is the case for all LTE to CC_3D and back Conversions
    // matrices.  This routine transposes the upper left
    // 3x3 matrix and changes the sign of the first three
    // elements for the 4 row.  Element [4][4] is always 1.0.
    protected static void invert (double[][] src, double[][] invSrc)
    {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                invSrc[i][j] =  src[j][i];
            }
        }
        invSrc[3][0] = -src[3][0];
        invSrc[3][1] = -src[3][1];
        invSrc[3][2] = -src[3][2];

        invSrc[3][3] = 1.0;
    }


    protected static void invert_datum(double[][] src,
                                       double     delta_scale,
                                       double[][] invSrc)
    {
        double[] tmp = new double[3];
        double[] deltas = { -src[3][0], -src[3][1], -src[3][2] };

        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                invSrc[i][j] =  src[j][i];

        invSrc[0][3] = 0.0;
        invSrc[1][3] = 0.0;
        invSrc[2][3] = 0.0;

        applyMatrix3x3(deltas, invSrc, tmp);

        invSrc[3][0] = tmp[0];
        invSrc[3][1] = tmp[1];
        invSrc[3][2] = tmp[2];

        double factor = 1.0 / (1.0 + delta_scale);

        for (int i=0; i<4; i++)
            for (int j=0; j<4; j++)
                invSrc[i][j] *= factor;

        invSrc[3][3] = 1.0;
    }

    // transpose
    protected static void transpose(double[][] src,
                                    double[][] transposedSrc,
                                    int        rank)
    {
        for (int i=0; i<rank; i++)
        {
            for (int j=0; j<rank; j++)
            {
                transposedSrc[i][j] =  src[j][i];
            }
        }
    }

    // dot product
    protected static double dot_product(double[] A, double[] B)
    {
        double result = 0.0;

        for (int i=0;i<3;i++)
            result += A[i] * B[i];

        return result;
    }

    // cross product
    protected static double[] cross_product (final double[] A, final double[] B)
    {
        double[] result = new double[3];

        result[0] = A[1] * B[2] - A[2] * B[1] ;
        result[1] = A[2] * B[0] - A[0] * B[2] ;
        result[2] = A[0] * B[1] - A[1] * B[0] ;

        return result;
    }


    // compute the determinant of matrix of rank n
    protected static double det (double m[][])
    {
        Matrix mtx = new Matrix(m);
        return mtx.det();
    }


    // cpMatrix
    protected static void cpMatrix(double[][] m_cp, double[][] m, int rank)
    {
        for (int i=0; i<rank; i++)
            for (int j=0; j<rank; j++)
                m_cp[i][j] = m[i][j];
    }

    protected static void print(double[] vec)
    {
        System.out.println("[ " + vec[0] + ", " + vec[1] + ", " + vec[2] + " ]");
    }


    protected static void LTP_Rotation_Matrix_T(double lambda,
                                                double phi,
                                                double alpha,
                                                double[][] T)
    {
         double cl=Math.cos(lambda);
         double sl=Math.sin(lambda);

         double cp=Math.cos(phi);
         double sp=Math.sin(phi);

         double ca=Math.cos(alpha);
         double sa=Math.sin(alpha);

         T[0][0]= -sl * ca + cl * sp * sa;
         T[0][1]= -sl * sa + -cl *sp *ca;
         T[0][2]=  cl * cp;
         T[0][3]=  0;

         T[1][0]= cl * ca + sl * sp * sa;
         T[1][1]= cl * sa + -sl * sp * ca;
         T[1][2]= sl * cp;
         T[1][3]=  0;

         T[2][0]= cp * -sa;
         T[2][1]= cp *  ca;
         T[2][2]= sp;
         T[2][3]=  0;

         T[3][0]= 0;
         T[3][1]= 0;
         T[3][2]= 0;
         T[3][3]= 1;
    }

    protected static void calc_T(OrmData e_constants, SRF_LTSE_Params params,
                                 double[][] T, double[][] T_inv)
    {
        double  azimuth,Origin_Height,radius,rn,height_radius_factor;

        double[] R = new double[4];
        double[] R2 = new double[4];

        double slat, clat, slon, clon;

        slat = Math.sin(params.geodetic_latitude);
        clat = Math.cos(params.geodetic_latitude);
        slon = Math.sin(params.geodetic_longitude);
        clon = Math.cos(params.geodetic_longitude);
        azimuth    =    params.azimuth;
        Origin_Height = params.height_offset;

        if (e_constants.Eps != 0.0) /* ellipsoid */
        {
            rn = e_constants.A / Math.sqrt(1 - e_constants.Eps2 * (slat*slat));

            radius = rn + Origin_Height;

            height_radius_factor = Origin_Height + rn * (1.0 - e_constants.Eps2);
        }
        else  /* spheroid */
        {
            radius = Origin_Height + e_constants.A;
            height_radius_factor = radius;
        }
        R[0]=(radius * clat * clon);
        R[1]=(radius * clat * slon);
        R[2]=(height_radius_factor * slat);
        R[3]=1.0;

        LTP_Rotation_Matrix_T(params.geodetic_longitude,
                               params.geodetic_latitude,
                               azimuth,
                               T);


        T[0][3] = R[0];
        T[1][3] = R[1];
        T[2][3] = R[2];
        T[3][3] = 1.0;

        transpose(T, T_inv, 4);

        R[0] *= -1;
        R[1] *= -1;
        R[2] *= -1;

        multMatrixSubsetVector(T_inv, R, R2, 3);

        T_inv[3][0] = 0.0;
        T_inv[3][1] = 0.0;
        T_inv[3][2] = 0.0;

        T_inv[0][3] = R2[0];
        T_inv[1][3] = R2[1];
        T_inv[2][3] = R2[2];
        T_inv[3][3] = 1.0;
    }


    protected static void init_chi_series(OrmData e_constants, double[] b)
            throws SrmException
    {
        double Eps2=e_constants.Eps2;
        double Eps4=(e_constants.Eps2*e_constants.Eps2);
        b[0]=Eps2*(1.0+Eps2*(1.0+Eps2*(1.0+Eps2)));
        b[1]=-Eps4*(7.0+Eps2*(17.0+30.0*Eps2))/6.0;
        b[2]=Eps4*Eps2*(28.0/15.0+6223.0*Eps2/840.0);
        b[3]=-4279.0*(Eps4*Eps4)/1260.0;

        if (e_constants.Eps2 < 0.0)
            throw new SrmException(SrmException._INACTIONABLE,
                                   "Internal math inconsistency");
    }

    protected static void init_power_p_series(OrmData  e_constants,
                                              double[] cr1,
                                              double[] cr2)
    {
        double AA1, AA2, AA3, AA4, AA5, AA6, AA7, AA8, AA9,
               AB1, AB2, AB3, AB4, AB5, AB6, AB7, AB8, AB9,
               BB1, BB2, BB3, BB4, BB5;

        /*AA1 - BB5 are magic numbers representing coefficients
          needed to compute a taylor series approximation of
          POWERP
        */
        AA1= 0.100000000003490E+01;
        AA2=-0.643155723158021;
        AA3=-0.333332134894985;
        AA4=-0.241457540671514E-04;
        AA5= 0.143376648162652;
        AA6= 0.356844276587295;
        AA7=-0.333332875955149;
        AA8= 0.0;
        AA9= 0.0;

        BB1=AA1;
        BB2=e_constants.Eps2*AA2;
        BB3=e_constants.Eps2*(AA3+e_constants.Eps*(AA4+e_constants.Eps*AA5));
        BB4=e_constants.Eps2*AA6;
        BB5=e_constants.Eps2*(AA7+e_constants.Eps*(AA8+e_constants.Eps*AA9));

        /*Coefficients for POWER_P approximation with lat less than 35.5 degrees*/
        cr1[0]=BB3/BB5-.187E-11;
        cr1[1]=(BB2-BB4*BB3/BB5)/BB5;
        cr1[2]=(BB1-BB3/BB5)/BB5;
        cr1[3]=1.0/BB5;
        cr1[4]=BB4/BB5;

        AB1= 0.999999999957885;
        AB2=-0.115979311942142E+01;
        AB3=-0.333339671395063;
        AB4= 0.276473457331734E-03;
        AB5= 0.587786240368508;
        AB6=-0.159793128888088;
        AB7=-0.333333465982150;
        AB8= 0.746505041501704E-04;
        AB9=-0.701559218182283E-01;

        BB1=AB1;
        BB2=e_constants.Eps2*AB2;
        BB3=e_constants.Eps2*(AB3+e_constants.Eps*(AB4+e_constants.Eps*AB5));
        BB4=e_constants.Eps2*AB6;
        BB5=e_constants.Eps2*(AB7+e_constants.Eps*(AB8+e_constants.Eps*AB9));

        /*Coefficients for POWER_P approximation with lat greater than 35.5 degrees*/
        cr2[0]=BB3/BB5+.2689E-11;
        cr2[1]=(BB2-BB4*BB3/BB5)/BB5;
        cr2[2]=(BB1-BB3/BB5)/BB5;
        cr2[3]=1.0/BB5;
        cr2[4]=BB4/BB5;
    }


    protected class GcToGdConst
    {
        double Eps21,C254,CEEps2,CEE,TwoCEE,
               C2DA,tem,ARat1,ARat2,BRat1,BRat2,
               aeps21,ak1,ak2,rho,rho_inv;
        double[] b1 = new double[5];
        double[] b2 = new double[5];
        double[] b3 = new double[5];
        double[] b4 = new double[5];
        double[] b5 = new double[5];
        double[] u = new double[5];
        double[] v = new double[5];
    }

    public static void printMatrix(double[][] mtx, int rank)
    {
        for (int i=0; i < rank; i++)
        {
            for (int j=0; j < rank; j++)
            {
                System.out.print(mtx[i][j] + ", ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] arg)
    {
        double[][] test_data =
        {{16, 16, 19, 21, 20},
         {14, 17, 15, 22, 18},
         {24, 23, 21, 24, 20},
         {18, 17, 16, 15, 20},
         {18, 11, 9, 18, 7}};

        Matrix mtx = new Matrix(test_data);

        System.out.println("determinant=> " + mtx.det());
    }
}
