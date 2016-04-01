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

class TmConv extends Conversions
{
    private ToCdetConst _toCdetConst = null;
    private TmValidConst _tmValidConst = null;

    protected TmConv()
    {
        super(SRM_SRFT_Code.SRFTCOD_TRANSVERSE_MERCATOR,
              new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
                                   SRM_SRFT_Code.SRFTCOD_UNSPECIFIED});
    }

    protected Conversions makeClone()
    {
        return (Conversions) new TmConv();
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
            src[0] -= ((SRF_TransverseMercator)srcSrf).get_false_easting();
            src[1] -= ((SRF_TransverseMercator)srcSrf).get_false_northing();

            // apply pre validation
            if (_tmValidConst == null)
                _tmValidConst = new TmValidConst(this.getOrmData(),
                                                 ((SRF_TransverseMercator)
                                                  srcSrf).getSRFParameters());

            retValid = CoordCheck.forTransverseMercator_native
                       (_tmValidConst._m,
                        _tmValidConst._bl,
                        _tmValidConst._x_threshold,
                        _tmValidConst._y_threshold,
                        src);

            // perform conversion
            toCdet(srcSrf, destSrf, src, dest);

            // perform post validation
            switch (srcSrf.getSRFSetCode())
            {
                case SRFSCOD_ALABAMA_SPCS:
                     // use ALSP validation if source SRF is ALSP
                     retValid = CoordCheck.forALSP_cd(this.getOrmData(),
                                                      ((SRF_TransverseMercator)
                                                       srcSrf).getSRFParameters(),
                                                       dest);
                     break;
                case SRFSCOD_JAPAN_RECTANGULAR_PLANE_CS:
                     // use Japan validation if source SRF is Japan
                     retValid = CoordCheck.forJapan_cd(this.getOrmData(),
                                 (SRM_SRFSM_Japan_Rectangular_Plane_CS_Code)srcSrf.getSRFSetMemberCode(),
                                                      ((SRF_TransverseMercator)
                                                       srcSrf).getSRFParameters(),
                                                       dest);
                     break;
                case SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR:
                     // use UTM validation if source SRF is UTM
                     retValid = CoordCheck.forUTM_cd
                                (this.getOrmData(),
                                 ((SRF_TransverseMercator)srcSrf)
                                 .getSRFParameters(),
                                 (SRM_SRFSM_UTM_Code)srcSrf.getSRFSetMemberCode(),
                                 dest);
                     break;
                default:  // this is a celestiodetic source SRF
                     retValid = CoordCheck.forTransverseMercator_cd
                                (this.getOrmData(),
                                 ((SRF_TransverseMercator)srcSrf).getSRFParameters(),
                                 dest);
                     break;
            }
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            // just pass the coordinate through. this is the last conversion
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
 * FUNCTION: toCdetGtrsDataSet.getNaturalCell( coord)
 *
 *----------------------------------------------------------------------------
 */
    private class TmValidConst
    {
        /* This software abomination computes spherical TM_AUGMENTED_3D
           coordinates for GtrsDataSet.getNaturalCell(coord)
           a bounding box for TM_AUGMENTED_3D shaped like this to ensure that
           horrible coordinates are rejected without being operated on. The
           assumption is that if the sphere and the scaling are made generous
           enough that this will always be outside the precise boundary.
         */
        double _m;  /*slope of the lines being drawn in TMERC*/
        double _bl;  /*Intercept of lines on the right side*/
        double _x_threshold; /* Northing that when less than just uses
                                 a square sided test*/
        double _y_threshold; /*The x value tested against when
                                not testing against the lines*/

        public TmValidConst( OrmData e_constants, SRF_TM_Params params) throws SrmException
        {
            CdetConv tmpCdet = new CdetConv();
            tmpCdet.setOrmData( e_constants);

            double[] uln = new double[]{0.0,0.0,0.0};
            double[] uls =  new double[]{0.0,0.0,0.0};
            double[] eql = new double[]{0.0,0.0,0.0};

            double left_lon_val = Const.getLambdaStar
                                  (params.origin_longitude,
                                   -13.0 * Const.RADIANS_PER_DEGREE);

            double[] uln_cd = new double[]{left_lon_val,
                                           89.991*Const.RADIANS_PER_DEGREE,
                                           0.0};
            double[] uls_cd = new double[]{left_lon_val,
                                           89.990*Const.RADIANS_PER_DEGREE,
                                           0.0};
            double[] eql_cd = new double[]{left_lon_val, 0.0,0.0};

            tmpCdet.toTmer( params, uln_cd, uln);
            tmpCdet.toTmer( params, uls_cd, uls);
            tmpCdet.toTmer( params, eql_cd, eql);

            _m = (uln[1]-uls[1])/(uln[0]-uls[0]);

            /*upper left boundary*/
            _bl = uln[1] - _m*uln[0];

            _y_threshold = _m*eql[0] + _bl;

            _x_threshold = Math.abs(eql[0]);
        }
    }



/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: toCdet
 *GtrsDataSet.getNaturalCell( coord)
 *----------------------------------------------------------------------------
 */
    private class ToCdetConst
    {
        double con_lat;
        double con_lat2;
        double con_lat24;
        double con_lat120;
        double con_lat720;
        double con_lat40320;
        double longitude_origin;
        double latitude_origin;
        double CScale;
        double CScale_inv;
        double conap;
        double conap_inv;
        double smz;
        Const.ArcLengthConst arclength_spec;
        Const.FootPointConst footpoint_spec;

        public ToCdetConst(OrmData e_constants, SRF_TM_Params tmParams)
        {
            longitude_origin = tmParams.origin_longitude;
            latitude_origin  = tmParams.origin_latitude;
            CScale           = tmParams.central_scale;
            CScale_inv       = 1.0 / CScale;

            con_lat      = 1.0/(1.0-e_constants.Eps2);
            con_lat2     = 0.5*con_lat;
            con_lat24    = con_lat/24.0;
            con_lat120   = con_lat/120.0;
            con_lat720   = con_lat/720.0;
            con_lat40320 = con_lat/40320.0;

            if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
            {
                arclength_spec = new Const.ArcLengthConst(e_constants);

               /*
                * The arc length approximation Const.arcLength() should not be
                * used in the initialization as it causes a 20 metre accuracy
                * loss for British National Grid. It's fine in the routine
                * itself where the values are less.
                */
                smz = Const.exactArcLength(e_constants.A, e_constants.C,
                                           e_constants.Eps2, latitude_origin);

                conap=
                  e_constants.A* (1.0-
                                  e_constants.Eps2*
                                  (.250+
                                   e_constants.Eps2*
                                   (.0468750+
                                    e_constants.Eps2* (0.019531250+
                                                       0.010681152343750*
                                                       e_constants.Eps2))));

                footpoint_spec = new Const.FootPointConst(e_constants,
                                                          arclength_spec,
                                                          CScale);
            }
            else /* compute spherical values */
            {
                smz = e_constants.A * latitude_origin;
                conap = e_constants.A;
            }

            /*needs to be done in both cases*/
            conap_inv=1.0/conap;
        }
    }


    protected void toCdet(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coordinate,
                          double[] dest_generic_coordinate) throws SrmException
    {
        final double ZERO_POINT_THREE_DEGREES = .005235987755982988730771072305;
        final double ZERO_POINT_SEVEN_FIVE_DEGREES = .013089969389957471826927680763;
        final double TWO_POINT_ZERO_DEGREES = .034906585039886591538473815369;
        final double TWO_POINT_SEVEN_DEGREES = .047123889803846898576939650749;
        final double SIX_POINT_ZERO_DEGREES =  .104719755119659774615421446109;
        final double con_lon6=1.0/6.0;
        final double con_lon120=1.0/120.0;
        final double con_lon5040=1.0/5040;

        OrmData e_constants = this.getOrmData();

        if (_toCdetConst == null)
            _toCdetConst = new ToCdetConst(e_constants,
                                           ((SRF_TransverseMercator)srcSrf).
                                           getSRFParameters());

        double source_x = source_generic_coordinate[0] * _toCdetConst.CScale_inv;
        double source_y = source_generic_coordinate[1] * _toCdetConst.CScale_inv;
        double source_z = source_generic_coordinate[2];

        double mu=(_toCdetConst.smz + source_y)* _toCdetConst.conap_inv;
        /*mu is the parameterization variable of footpoint latitude which is
          an intermediate varaible in the computation of latitude*/

        if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
        {
            /* This ellipsoidal tm_cd routine is a formulation
               based on the work of Ralph Toms and C. Kellough
               between 2001 and 2005.  It bears little resemblance
               to the 3.x and earlier SEDRIS software.
             */
            double
                phi1=Const.footPoint(e_constants,      /* footpoint latitude */
                                     _toCdetConst.arclength_spec,
                                     _toCdetConst.footpoint_spec,
                                     mu),
                sin_phi1=Math.sin(phi1),
                cos_phi1=Math.cos(phi1),
                sec_phi1=1.0/cos_phi1,
                sin_phi1_squared= Const.square(sin_phi1),
                tan_phi1=sin_phi1*sec_phi1,
                tan_phi1_squared= Const.square(tan_phi1),
                omessp= (1.0- Const.square(e_constants.Eps*sin_phi1)),
                eta_sub1_squared=e_constants.Epps2*Const.square(cos_phi1);

            double Rn1_inv=Double.NaN,    /*1 over the radius of curvature in the prime vertical*/
                       phi=Double.NaN,    /*latitude*/
                       lambda=Double.NaN; /*longitude*/

            /* These values are computed later in ways which cannot be
               used as initializations.  As a result they are initialized
               here to NaN to prevent problems if something else fails
             */
            Rn1_inv = Const.computeRnInv(sin_phi1_squared, e_constants);

            /*
               Mu is the variable that footpoint_latitude is parameterized in.
               The following definition is correct but the above form using
               precomputed constants that is actually used is more accurate:

               mu = src_coord[1]/
                    (e_constants->A*
                    (1.0-SQUARE(e_constants->Eps)*(0.25+SQUARE(e_constants->Eps)*
                    ((3.0/64.0)+(5.0/256.0)*SQUARE(e_constants->Eps)))));

                    Rn1, the radius of curvature in the prime vertical is
                    defined thus but 1 over it is actually computed to save
                    a sqrt:
                    Rn1=e_constants->A/sqrt(omessp);

                    Rm1, the radius of curvature in the meridian is defined as
                    follows but not needed:
                    Rm1=e_constants->A/sqrt(CUBE(omessp));
             */

            /*
               phi = phi1 - (tan_phi1*omessp/omes)*SQUARE(zeta)*((1.0/2.0)
                          + SQUARE(zeta)*((-b4/24.0)+(b6/720.0)*SQUARE(zeta)));
               lambda = _toCdetConst.longitude_origin +
                        zeta*sec_phi1*(1+SQUARE(zeta)*((-b3/6.0) +
                        b5/120.0*SQUARE(zeta)));

               These expressions were derived from a draft of the writeup.  Both
               are known good with the following definitions of the b'secondary_axis
               in this function.  The actually implemented code removes a number of
               divide operations which are unnecessary and does further cleanup.
             */

            /* 0.3 2.0 6.0 >6.0 are the latitude regions in degrees*/
            {
                double zeta         = source_x*Rn1_inv,
                       zeta_squared = Const.square(zeta);

                double lon_range= Math.abs(zeta*sec_phi1);

                if (lon_range< ZERO_POINT_THREE_DEGREES)
                {
                    phi=phi1-tan_phi1*omessp*zeta_squared*_toCdetConst.con_lat2;
                }
                else
                {
                    double b4 = 5.0 + Const.triple(tan_phi1_squared) +
                                eta_sub1_squared*
                                (1.0-4.0*eta_sub1_squared -
                                 9.0 *tan_phi1_squared);

                    if (lon_range < TWO_POINT_ZERO_DEGREES)
                    {
                        phi=phi1-tan_phi1*omessp*(zeta_squared*(_toCdetConst.con_lat2-
                                                                zeta_squared*_toCdetConst.con_lat24*b4));
                    }
                    else
                    {
                        double b6=61.0 +tan_phi1_squared*(90.0+45.0*tan_phi1_squared)+
                          eta_sub1_squared*(46.0+tan_phi1_squared*(-252.0 -90.0*tan_phi1_squared));

                        if (lon_range < SIX_POINT_ZERO_DEGREES)
                        {
                            phi=phi1-tan_phi1*omessp*
                              (zeta_squared*(_toCdetConst.con_lat2
                                             +zeta_squared*(-_toCdetConst.con_lat24*b4+
                                                            zeta_squared*_toCdetConst.con_lat720*b6)));
                        }
                        else
                        {
                            double b8=1385.0+
                              tan_phi1_squared*(3633.0+tan_phi1_squared*(4095.0+1574.0*tan_phi1_squared));

                            phi=phi1-tan_phi1*omessp*
                              zeta_squared*(_toCdetConst.con_lat2+zeta_squared*
                                            (-_toCdetConst.con_lat24*b4+
                                             zeta_squared*(_toCdetConst.con_lat720*b6-
                                                           zeta_squared*_toCdetConst.con_lat40320*b8)));
                        }
                    }
                }

                /* Longitude ranges 0.75 2.7 >2.7  Note, lat test is used
                   because the longitude formula here depends on the latitude
                   we're at*/
                {
                    double b3=1 + Const.twoTimes(tan_phi1_squared)+ eta_sub1_squared;
                    /* zeta/cp */

                    if (lon_range< ZERO_POINT_SEVEN_FIVE_DEGREES)
                    {
                        lambda = _toCdetConst.longitude_origin +
                                 zeta*(1.0-b3*con_lon6*zeta_squared)*sec_phi1;
                    }
                    else
                    {
                        double b5 = 5.0 + tan_phi1_squared*(28.0+24.0*tan_phi1_squared)+eta_sub1_squared*(6.0+8.0*tan_phi1_squared);
                        if (lon_range < TWO_POINT_SEVEN_DEGREES)
                        {
                            lambda=_toCdetConst.longitude_origin+
                              zeta*(1.0+zeta_squared*(-b3*con_lon6+b5*con_lon120*zeta_squared))*sec_phi1;
                        }
                        else
                        {
                            double b7=61.0+662.0*tan_phi1_squared+
                              1320.0*Const.square(tan_phi1_squared)+720.0*Const.cube(tan_phi1_squared);

                            lambda=_toCdetConst.longitude_origin+
                              zeta*(1.0+zeta_squared*(-con_lon6*b3+
                                                    zeta_squared*(con_lon120*b5-zeta_squared*b7*con_lon5040)))*sec_phi1;
                        }
                    }
                }
            }
            dest_generic_coordinate[1]=phi; // lat
            dest_generic_coordinate[0]=lambda; // lon
        }
        else /* compute spherical values */
        {
            double B   = 1.0/(_toCdetConst.CScale*e_constants.A);
            double D   = source_generic_coordinate[1]*B + _toCdetConst.latitude_origin;
            double xB  = source_generic_coordinate[0]*B;
            double xB2 = xB*xB;

            // lat
            dest_generic_coordinate[1] = Math.asin(Math.sin(D)*(1.0+((-0.5+(5.0/24.0-(61.0/720.0)*xB2)*xB2)*xB2)));
                                    /* = Math.asin(Math.sin(D)*sech(xB)); Power series approx for sech() */

            // lon
            dest_generic_coordinate[0] = _toCdetConst.longitude_origin +
                + Math.atan2(xB*(1.0+xB2*((1.0/6.0)+xB2*(1.0/120.0)+xB2*(1.0/5040.0))), Math.cos(D));
             /* + Math.atan2(Math.sinh(xB), Math.cos(D)); Power series approx for sinh() */
        }
        dest_generic_coordinate[2]=source_z;
    }
}
