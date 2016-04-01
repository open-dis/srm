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

class CcenConv extends Conversions
{
    private ToCdetConst _toCdetConst;
    private ToLteConst  _toLteConst;
    private ToLceConst  _toLceConst;

    protected CcenConv()
    {
        super (SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
                                    SRM_SRFT_Code.SRFTCOD_LOCOCENTRIC_EUCLIDEAN_3D,
                                    SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN,
                                    SRM_SRFT_Code.SRFTCOD_CELESTIOMAGNETIC,
                                    SRM_SRFT_Code.SRFTCOD_EQUATORIAL_INERTIAL,
                                    SRM_SRFT_Code.SRFTCOD_SOLAR_ECLIPTIC,
                                    SRM_SRFT_Code.SRFTCOD_SOLAR_EQUATORIAL,
                                    SRM_SRFT_Code.SRFTCOD_HELIOSPHERIC_ARIES_ECLIPTIC,
                                    SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_ECLIPTIC,
                                    SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_EQUATORIAL,
                                    SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone()
    {
        return (Conversions) new CcenConv();
    }


    // Function dispatcher keyed on the destination SRF
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

        // perform pre validation
        // An exception is thrown if a bad coordinate was passed in
        // and is thrown back to the caller before we proceed with
        // the computation.
        retValid = CoordCheck.forNaN_3D(src);

        switch (destSrfType)
        {
            case SRFTCOD_CELESTIODETIC:
            {
                 toCdet(srcSrf, destSrf, src, dest);

                 // perform post validation
                 retValid = CoordCheck.forCelestiodetic(this.getOrmData(), dest);
                 break;
            }
            case SRFTCOD_LOCOCENTRIC_EUCLIDEAN_3D:
            {
                 if (_toLceConst == null)
                     _toLceConst = new ToLceConst(((SRF_LococentricEuclidean3D)
                                                   destSrf).getSRFParameters());

                 double[] p_minus_q = new double[3];

                 for (int i=0; i<3; i++)
                 {
                     p_minus_q[i] = src[i] - _toLceConst.lococentre[i];
                 }
                 dest[0] = Const.vectDotProd(p_minus_q, _toLceConst.primary_axis);
                 dest[1] = Const.vectDotProd(p_minus_q, _toLceConst.secondary_axis);
                 dest[2] = Const.vectDotProd(p_minus_q, _toLceConst.xprod_rs);

                 // post validation - NO RESTRICTION
                 retValid = CoordCheck.forNaN_3D(dest);
                 break;
            }
            case SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN:
            {
                 toLte(srcSrf, destSrf, src, dest);

                 // perform post validation
                 // for GTRS
                 if (srcSrf.getSRFSetCode() == SRM_SRFS_Code.SRFSCOD_GTRS_GLOBAL_COORDINATE_SYSTEM)
                     retValid = CoordCheck.forGTRS(dest);

                 // for LTES there are no restrictions
                 // apply the false origin offset after the conversion if LTSE_3D
                 // is the destination SRF.  Otherwise do nothing because LTSE_3D
                 // is just an intermediate SRF
                 if (destSrf instanceof SRF_LocalTangentSpaceEuclidean)
                 {
                     dest[0] += ((SRF_LocalTangentSpaceEuclidean)destSrf).get_x_false_origin();
                     dest[1] += ((SRF_LocalTangentSpaceEuclidean)destSrf).get_y_false_origin();
                 }

                 // post validation - NO RESTRICTION
                 retValid = CoordCheck.forNaN_3D(dest);
                 break;
            }
            case SRFTCOD_CELESTIOMAGNETIC:
            case SRFTCOD_EQUATORIAL_INERTIAL:
            case SRFTCOD_SOLAR_ECLIPTIC:
            case SRFTCOD_SOLAR_EQUATORIAL:
            case SRFTCOD_HELIOSPHERIC_ARIES_ECLIPTIC:
            case SRFTCOD_HELIOSPHER_EARTH_ECLIPTIC:
            case SRFTCOD_HELIOSPHER_EARTH_EQUATORIAL:
            {
                 toSphere(srcSrf, destSrf, src, dest);

                 // perform post validation
                 retValid = CoordCheck.forSpherical(dest);
                 break;
            }
            case SRFTCOD_UNSPECIFIED:
            {
                 // just pass the coordinate through.  This is a datum shift case
                 // or this is the last conversion in the chain
                 dest[0] = src[0];
                 dest[1] = src[1];
                 dest[2] = src[2];
                 break;
            }
        }
        return retValid;
    }


/*
 *----------------------------------------------------------------------------
 *
 * CCEN to CDET routines and classes
 *
 *----------------------------------------------------------------------------
 */
    public class ToCdetConst
    {
        double Eps21, C254, CEEps2, CEE, TwoCEE,
               C2DA, tem, ARat1, ARat2, BRat1, BRat2,
               aeps21, ak1, ak2, rho, rho_inv;
        double[] b1 = new double[5];
        double[] b2 = new double[5];
        double[] b3 = new double[5];
        double[] b4 = new double[5];
        double[] b5 = new double[5];
        double[] u = new double[5];
        double[] v = new double[5];

        public ToCdetConst(OrmData e_constants)
        {
            double CE2;
            double[] del = new double[5];
            double hmn, hmx, g1, g2, g3, g4, gm, hm,
                   d1, d2, d3, d4, d5, d6, sm, rnm, zm, wm, z2, w2,
                   d7, d8, d9, d10, a1, a2, a3, a4, a5, f1, f2;
            int i;

            if (e_constants.Eps > Const.EPSILON_SQ)
            {
                CE2 = e_constants.A2 - e_constants.C2;

                Eps21  = e_constants.Eps2 - 1.0;
                C254   = 54.0 * e_constants.C2;
                CEEps2 = e_constants.Eps2 * CE2;
                CEE    = e_constants.Eps2 * e_constants.Eps2;
                TwoCEE = 2.0 * CEE;
                C2DA   = e_constants.C2 / e_constants.A;
                tem    = CE2 / e_constants.C2;

                rho     = e_constants.A / e_constants.C;
                rho_inv = e_constants.C / e_constants.A;
                aeps21  = e_constants.A * (e_constants.Eps2 - 1.0);
                ak1 = e_constants.C * e_constants.Eps2 / (1.0 - e_constants.Eps2);
                ak2 = e_constants.Eps2 * e_constants.A;

                del[0] = 3E4;
                del[1] = 5E4;
                del[2] = 2.2E7 - 5E4;
                del[3] = 4.5E8 - 2.2E7;
                del[4] = 1E10;

                hmn = -30000.0;

                for(i=0;i<5;i++)
                {
                    hmx = hmn + del[i];
                    g1 = Const.gee(hmn,0.0,e_constants.A,e_constants.Eps2);  /* changed 0 to 1e-14*/
                    g2 = Const.gee(hmx,0.0,e_constants.A,e_constants.Eps2);
                    g3 = Const.gee(hmx,Const.PI_DIV_2,e_constants.A,e_constants.Eps2);
                    g4 = Const.gee(hmn,Const.PI_DIV_2,e_constants.A,e_constants.Eps2);

                    hm = (hmx - hmn) *0.5;

                    gm = Const.gee(hm,Const.PI_DIV_4,e_constants.A,e_constants.Eps2);

                    d1 = Const.square(e_constants.C + hmx) * g3 -
                         Const.square(e_constants.C + hmn) * g4;
                    d1 = d1 / (Const.square(e_constants.C + hmx) -
                               Const.square(e_constants.C + hmn));

                    d2 = - (g4 - g3) / (Const.square(e_constants.C + hmx) -
                                        Const.square(e_constants.C + hmn));

                    d3 = Const.square(e_constants.C + hmx) * d2 - g3;

                    d4 = Const.square(e_constants.C + hmx) * (g3 - d1);

                    d5 = (g1 + d3) / Const.square(e_constants.A + hmn) - (g2 + d3) /
                         Const.square(e_constants.A + hmx);

                    d5 = d5 / (g2 -g1);

                    d6 = 1.0 / Const.square(e_constants.A + hmx) -
                         1.0 / Const.square(e_constants.A + hmn);

                    d6 = d6 * d4 / (g2 - g1);

                    sm = Const.ONE_DIV_ROOT_2;  /*sin(SRM_PI_DIV_4)=1/sqrt(2)*/

                    rnm = e_constants.A /
                          Math.sqrt(1.0 - e_constants.Eps2 * Const.square(sm));

                    zm = ((1.0 - e_constants.Eps2) * rnm + hm) * sm;
                    wm = (rnm + hm) * Const.ONE_DIV_ROOT_2;  /*cos(SRM_PI_DIV_4)=1/sqrt(2)*/

                    z2 = zm * zm;
                    w2 = wm * wm;

                    d7 = (z2*d2 - d3 - gm - gm*w2*d5) / w2;

                    d8 = (z2 * gm -d4 - z2 * d1+gm*w2*d6) / w2;

                    d9 = (g2 + d3) / Const.square(e_constants.A + hmx) + g2 * d5;

                    d10 = -d4 / Const.square(e_constants.A + hmx) + d6 * g2;

                    a4 = (d8 - d10) / (d9 + d7);
                    a2 = d9 *a4 + d10;
                    a5 = d5 * a4 + d6;
                    a1 = d4 - d3 * a4;
                    a3 = d1 + d2 * a4;

                    b1[i] = a3;
                    b2[i] = a1 - a3 * a4;
                    b3[i] = a2 - a3 * a5;
                    b4[i] = a4;
                    b5[i] = a5;

                    f1 = Const.square(e_constants.A + hmn - 1E-8);
                    f2 = Const.square(e_constants.C + hmn - 1E-8);

                    u[i] = f1 / f2 ;
                    v[i] = f1;
                    hmn  = hmx;
                }
            }
            else
            {
                Eps21  = Double.NaN;
                C254   = Double.NaN;
                CEEps2 = Double.NaN;
                CEE    = Double.NaN;
                TwoCEE = Double.NaN;
                C2DA  = Double.NaN;
                tem   = Double.NaN;
                ARat1 = Double.NaN;
                ARat2 = Double.NaN;
                BRat1 = Double.NaN;
                BRat2 = Double.NaN;

                for (i=0; i < 5; i++)
                {
                    b1[i] = Double.NaN;
                    b2[i] = Double.NaN;
                    b3[i] = Double.NaN;
                    b4[i] = Double.NaN;
                    b5[i] = Double.NaN;
                    u[i]  = Double.NaN;
                    v[i]  = Double.NaN;
                }
                aeps21  = Double.NaN;
                ak1     = Double.NaN;
                ak2     = Double.NaN;
                rho     = Double.NaN;
                rho_inv = Double.NaN;
            }
        }
    }


    protected void toCdet
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coord,
        double[] dest_generic_coord
    ) throws SrmException
    {
        final int REGION_1 = 0;
        final int REGION_2 = 1;
        final int REGION_3 = 2;
        final int REGION_4 = 3;
        final int REGION_5 = 4;
        final int REGION_UNDEFINED = 5;
        final int REGION_SPHERICAL = 6;

        double cl, p, r1, r2, rr, w, w2, z2;

        double dest_lat_ptr = -1.0, dest_lon_ptr= -1.0, dest_elv_ptr= -1.0;

        int region = REGION_UNDEFINED;

        OrmData e_constants = this.getOrmData();

        if (_toCdetConst == null)
            _toCdetConst = new ToCdetConst(this.getOrmData());

        boolean done_by_special_case = false;

        w2 = Const.square(source_generic_coord[0]) +
             Const.square(source_generic_coord[1]);
        z2 = Const.square(source_generic_coord[2]);
        w  = Math.sqrt(w2);

        if (Math.abs(e_constants.Eps) <= (1.0e-12))
        {
            /*This is the spherical special case*/
            /**dest_lon_ptr=atan2(source_generic_coord[1],source_generic_coord[0]);*/
            /*This is done below at the end to avoid duplicating the code*/
            dest_lat_ptr = Math.atan2(source_generic_coord[2]/*z*/,w);
            dest_elv_ptr = Math.sqrt(w2 + z2)-e_constants.A;
            region=REGION_SPHERICAL;
        }
        else
        {
            /* Check for special cases */
            if (Math.abs(source_generic_coord[0]) <= (1.0e-12))
            {
                if (source_generic_coord[1] > 0.0)
                {
                    dest_lon_ptr = Const.PI_DIV_2;
                }
                else if (source_generic_coord[1] < 0.0)
                {
                    dest_lon_ptr = -Const.PI_DIV_2;
                }
                else /* y == 0 */
                {
                    if (source_generic_coord[2] >= 0.0)
                    {
                        dest_lat_ptr = Const.PI_DIV_2;
                        dest_lon_ptr = 0.0;
                        dest_elv_ptr = source_generic_coord[2] - e_constants.C;

                        done_by_special_case = true;
                    } /* end if z> 0 */
                    else if (source_generic_coord[2] <= 0.0)
                    {
                        dest_lat_ptr = -Const.PI_DIV_2;
                        dest_lon_ptr =  0.0;
                        dest_elv_ptr = - (source_generic_coord[2] + e_constants.C);

                        done_by_special_case =true;
                    } /* end if z < 0 */
                    else
                    {
                        /* at origin */

                        throw new SrmException(SrmException._INVALID_TARGET_COORDINATE,
                                               new String("changeCoordinateSRF: impossible conversion"));
                    } /* end else at origin */
                } /* end else y == 0 */
            } /* end if x == 0 */
        }
        /* end of special cases */


        if (!done_by_special_case || region == REGION_SPHERICAL)
        {
            double bot, ga, q, s12, top, top2;

            if (region != REGION_SPHERICAL)
            {
                double lowerBound, upperBound;

                /* region 2      0-50 kilometers*/

                lowerBound = w2 + _toCdetConst.u[REGION_2] * z2;
                upperBound = w2 + _toCdetConst.u[REGION_3] * z2;
                if ((lowerBound >= _toCdetConst.v[REGION_2]) &&
                    (upperBound <= _toCdetConst.v[REGION_3]))
                {
                    region = REGION_2;
                }
                else
                {
                    /* region 3  50 - 23000 kilometers*/
                    lowerBound = upperBound;
                    upperBound = w2 + z2 * _toCdetConst.u[REGION_4];
                    if ((lowerBound >= _toCdetConst.v[REGION_3]) &&
                        (upperBound <= _toCdetConst.v[REGION_4]))
                    {
                        region = REGION_3;
                    }
                    else
                    {
                        /* region 1 -30 to 0 kilometers */
                        lowerBound = w2 + z2 * _toCdetConst.u[REGION_1];
                        upperBound = w2 + z2 * _toCdetConst.u[REGION_2];
                        if ((lowerBound >= _toCdetConst.v[REGION_1]) &&
                            (upperBound <= _toCdetConst.v[REGION_2]))
                        {
                            region = REGION_1;
                        }
                        else
                        {
                            /* region 4  23000 to 10e6 kilometers */
                            lowerBound = upperBound;
                            upperBound = w2 + z2 * _toCdetConst.u[REGION_5];
                            if ((lowerBound >= _toCdetConst.v[REGION_4]) &&
                                (upperBound <= _toCdetConst.v[REGION_5]))
                            {
                                region = REGION_4;
                            }
                            else
                            {
                                /*Declare region 5 unless the following test fails*/
                                region=REGION_5;
                                /* region 5 < -30 or > 10e6 kilometers*/
                            }
                        }
                    }
                }
            }

            /* Approximation to g function*/

            ga = _toCdetConst.b1[region] +
                (_toCdetConst.b2[region] + _toCdetConst.b3[region] * w2) /
                (_toCdetConst.b4[region] + _toCdetConst.b5[region] * w2 + z2);

            /*
              GA=B1(II)+(B2(II)+B3(II)*W2)/(B4(II)+B5(II)*W2+Z2)
            */

            switch (region)
            {
                case REGION_1:
                case REGION_2:
                {
                    double Rn;
                    top = source_generic_coord[2] * ga;
                    dest_lat_ptr = Math.atan2(top,w);
                    top2 = top * top;
                    rr   = top2 + w2;
                    q    = Math.sqrt(rr);
                    s12  = top2 / rr;

                    /*uses a Newton-Raphson single iteration with
                      excellent first guess using only multiplications*/

                    Rn = Const.computeRnFast(s12, e_constants);


                    if (s12 <= 0.5)  /* If between +- 45 degrees lattitude */
                        dest_elv_ptr = q - Rn;
                    else
                        dest_elv_ptr = q / ga + _toCdetConst.aeps21 * Rn * e_constants.A_inv;

                    //******************************************************************
                    // Done below at end of function as optimization
                    // dest_lon_ptr = atan2(src.source_y,src.source_x);
                    // ***************************************************************
                    break;
                }

                case REGION_3:
                case REGION_4:
                {
                    /* correct g by using it as a first guess into the bowring formula*/
                    top = source_generic_coord[2] * ga * _toCdetConst.rho_inv;
                    top2 = top * top;
                    rr   = top2 + w2;
                    q    = Math.sqrt(rr);

                    {
                        double qinv,sn,cn,s3,c3;
                        qinv=1.0 / q;
                        sn = top * qinv;
                        cn = w * qinv;
                        s3 = Const.cube(sn);
                        c3 = Const.cube(cn);
                        top = source_generic_coord[2] + _toCdetConst.ak1 * s3;
                        bot = w - _toCdetConst.ak2 * c3;
                    }
                    top2 = Const.square(top);
                    rr   = top2 + Const.square(bot);
                    q    = Math.sqrt(rr);
                    s12  = top2 / rr;

                    /*Fast Rn computation*/
                    {
                        double Rn;

                        Rn = Const.computeRnFast( s12, e_constants);
                        /*Fast Computation of Rn = a/sqrt(1.0-Eps2*sin_squared(latitude))*/

                        /* end inline root*/

                        if (s12 <= 0.5)
                        {
                            dest_elv_ptr = w * q / bot - Rn;
                        }
                        else
                        {
                            dest_elv_ptr = source_generic_coord[2] * q / top +
                            _toCdetConst.aeps21 * Rn*e_constants.A_inv;
                        }
                    }
                    dest_lat_ptr = Math.atan2(top,bot);
                    break;
                }
                case REGION_5:
                {
                    double alpha, arg, arg2, cf, gee, ro, roe, s, s1, v, xarg, zo;

                    cf  = _toCdetConst.C254 * z2;
                    gee = w2 - (_toCdetConst.Eps21 * z2) - _toCdetConst.CEEps2;
                    {
                        double g_inv = 1.0 / gee;
                        alpha = cf * Const.square(g_inv);
                        cl    = _toCdetConst.CEE * w2 * alpha * g_inv;
                    }
                    arg2 = cl * (cl + 2.0);
                    s1   = 1.0 + cl + Math.sqrt(arg2);
                    s    = Math.pow(s1,(.333333333333333333333333333333));
                    {
                        double temp = s / (Const.square(s) + 1.0 + s);
                        p = alpha * .333333333333333333333333333 * Const.square(temp);
                    }
                    xarg = 1.0 + (_toCdetConst.TwoCEE * p);
                    q    = Math.sqrt(xarg);

                    {
                        double q_inv = 1.0/q;
                        double one_plus_q_inv = 1.0/(1.0+q);
                        r2= -p * (2.0 * (1.0 - e_constants.Eps2) * z2 * ( q_inv * one_plus_q_inv)+ w2);
                        r1 = (1.0 + q_inv);
                        r2 = r2 * e_constants.A2_inv;
                        /*
                         * DUE TO PRECISION ERRORS THE ARGUMENT MAY BECOME
                         * NEGATIVE. IF SO SET THE ARGUMENT TO ZERO.
                         */
                        if (r1+r2 > 0.0)
                            ro = e_constants.A * Math.sqrt( .50 * (r1+r2));
                        else
                            ro=0.0;
                        ro=ro - p * e_constants.Eps2 * w * one_plus_q_inv;
                    }

                    roe = e_constants.Eps2 * ro;
                    arg = Const.square( w - roe) + z2;
                    v   = Math.sqrt(arg - e_constants.Eps2 * z2);
                    {
                        double v_inv=1.0/v;
                        zo=_toCdetConst.C2DA * source_generic_coord[2] *v_inv;
                        dest_elv_ptr = Math.sqrt(arg)*(1.0 - _toCdetConst.C2DA*v_inv);
                    }
                    top= source_generic_coord[2] + _toCdetConst.tem * zo;
                    dest_lat_ptr = Math.atan(top / w);

                    //************************************************************
                    //As an optimization, this is done below
                    //*dest_lon_ptr = atan2(src.source_y, src.source_x);
                    //************************************************************

                    /* end of Exact solution */
                    break;
                }
                case REGION_SPHERICAL:
                    /*This case gets out of the switch statement and lets the longitude
                     *be computed at the end of the routine with a single return statement
                     *Conclusion:  Don't Remove this case or there won't be a good way
                     *to skip the region test and this won't work very well.
                     */
                    break;

                default:
                    throw new SrmException( SrmException._INVALID_TARGET_COORDINATE,
                                            new String("changeCoordinateSRF: impossible conversion"));
            }

            /* Since longitude calculation is common to all regions and
              requires lots of time, we'll just do it here to break interlock
              and hopefully have it occur during some of the function
              return bureaucracy*/

            dest_lon_ptr = Math.atan2(source_generic_coord[1],source_generic_coord[0]);
        }
        dest_generic_coord[0] = dest_lon_ptr;
        dest_generic_coord[1] = dest_lat_ptr;
        dest_generic_coord[2] = dest_elv_ptr;
    }

/*
 *----------------------------------------------------------------------------
 *
 * CCEN to LTES routines and classes
 *
 *----------------------------------------------------------------------------
 */
    public class ToLteConst
    {
        double[][] T = new double[4][4];
        double[][] T_inv = new double[4][4];

        public ToLteConst
        (
            OrmData         e_constants,
            SRF_LTSE_Params params
        ) throws SrmException
        {
            Const.calc_T(e_constants, params, T, T_inv);
        }
    }


    protected void toLte
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coordinate,
        double[] dest_generic_coordinate
    ) throws SrmException
    {
        double[] temp = new double[4];
        double[] temp1 = new double[4];

        // copy source to temp1 and set last element to 1.0
        temp[0] = source_generic_coordinate[0];
        temp[1] = source_generic_coordinate[1];
        temp[2] = source_generic_coordinate[2];
        temp[3] = 1.0;

        OrmData e_constants = this.getOrmData();

        // Converting to LTES, then there are only three possibilities for the
        // LTES parameters to come from.  Either they are copies from the target
        // SRF's params when these are LTSAS_3D or LTSC_3D, or they are the parameters of
        // target LTES SRF.
        if (_toLteConst == null)
        {
            if (destSrf instanceof SRF_LocalTangentSpaceAzimuthalSpherical)
            {
                SRF_LT_Params tmpLTParam =
                    ((SRF_LocalTangentSpaceAzimuthalSpherical)destSrf).getSRFParameters();
                SRF_LTSE_Params tmpLTEParam = new SRF_LTSE_Params();
                tmpLTEParam.geodetic_longitude = tmpLTParam.geodetic_longitude;
                tmpLTEParam.geodetic_latitude  = tmpLTParam.geodetic_latitude;
                tmpLTEParam.azimuth            = tmpLTParam.azimuth;
                tmpLTEParam.x_false_origin = 0.0;
                tmpLTEParam.y_false_origin = 0.0;
                tmpLTEParam.height_offset  = tmpLTParam.height_offset;
                _toLteConst = new ToLteConst(e_constants, tmpLTEParam);
            }
            else if (destSrf instanceof SRF_LocalTangentSpaceCylindrical)
            {
                SRF_LT_Params tmpLTParam =
                    ((SRF_LocalTangentSpaceCylindrical)destSrf).getSRFParameters();
                SRF_LTSE_Params tmpLTEParam = new SRF_LTSE_Params();
                tmpLTEParam.geodetic_longitude = tmpLTParam.geodetic_longitude;
                tmpLTEParam.geodetic_latitude  = tmpLTParam.geodetic_latitude;
                tmpLTEParam.azimuth            = tmpLTParam.azimuth;
                tmpLTEParam.x_false_origin = 0.0;
                tmpLTEParam.y_false_origin = 0.0;
                tmpLTEParam.height_offset  = tmpLTParam.height_offset;
                _toLteConst = new ToLteConst(e_constants, tmpLTEParam);
            }
            else // it is LTES itself
                _toLteConst = new ToLteConst(e_constants,
                                             ((SRF_LocalTangentSpaceEuclidean)destSrf).getSRFParameters());
        }
        Const.multMatrixSubsetVector(_toLteConst.T_inv, temp, temp1, 4);

        // copy first three elements of temp1 to destination
        dest_generic_coordinate[0] =  temp1[0];
        dest_generic_coordinate[1] =  temp1[1];
        dest_generic_coordinate[2] =  temp1[2];
    }

/*
 *----------------------------------------------------------------------------
 *
 * CCEN to Spherical routines and classes
 *
 *----------------------------------------------------------------------------
 */
    protected void toSphere
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coord,
        double[] dest_generic_coord
    ) throws SrmException
    {
        // the source coordinate is interpreted as
        // source_generic_coord[0] => x
        // source_generic_coord[1] => y
        // source_generic_coord[2] => z

        double x2 = Const.square(source_generic_coord[0]);
        double y2 = Const.square(source_generic_coord[1]);

        // lambda
        if ((x2 > Const.EPSILON_SQ) && (y2 > Const.EPSILON_SQ))
        {
            double lambda_prime = Math.atan(source_generic_coord[1] /
                                            source_generic_coord[0]);

            if (source_generic_coord[0] >= 0.0)
            {
                // invariant on source_generic_coord[1] (Q1, Q4)
                dest_generic_coord[0] = lambda_prime;
            }
            else if (source_generic_coord[1] >= 0.0)
                dest_generic_coord[0] =  Const.PI + lambda_prime;
            else
                dest_generic_coord[0] = -Const.PI + lambda_prime;
        }
        else
        {
            if (source_generic_coord[1] >= Const.EPSILON)
                dest_generic_coord[0] =  Const.PI_DIV_2;
            else
                dest_generic_coord[0] = -Const.PI_DIV_2;

            if (source_generic_coord[0] >= Const.EPSILON)
                dest_generic_coord[0] = 0.0;
            else
                dest_generic_coord[0] = Const.PI;
        }

        // rho
        dest_generic_coord[2] = Math.sqrt(x2 + y2 +
                                          Const.square(source_generic_coord[2]));

        // theta
        // If rho is zero, set declination to zero
        if (dest_generic_coord[2] != 0.0)
        {
            dest_generic_coord[1] = Math.asin(source_generic_coord[2] /
                                              dest_generic_coord[2]);
        }
        else
        {
            dest_generic_coord[1] = 0.0;
        }
    }


/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: toLce
 *
 *----------------------------------------------------------------------------
 */
    private class ToLceConst
    {
        double[] lococentre     = new double[3];
        double[] primary_axis   = new double[3];
        double[] secondary_axis = new double[3];
        double[] xprod_rs       = new double[3];

        public ToLceConst(SRF_LCE_3D_Params params)
        {
            Const.vectCrossProd(params.primary_axis, params.secondary_axis, xprod_rs);

            for (int i=0; i<3; i++)
            {
                lococentre[i]     = params.lococentre[i];
                primary_axis[i]   = params.primary_axis[i];
                secondary_axis[i] = params.secondary_axis[i];
            }
        }
    }
}
