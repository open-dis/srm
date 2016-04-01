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

class CdetConv extends Conversions
{
    private ToTmerConst _toTmerConst;
    private ToMercConst _toMercConst;
    private ToLccConst1 _toLccConst1;
    private ToLccConst2 _toLccConst2;
    private ToOmerConst _toOmerConst;
    private ToEqcyConst _toEqcyConst;
    private ToPostConst _toPostConst;

    protected CdetConv()
    {
        // setting the source and destinations of this conversion object
        super (SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC,
                                    SRM_SRFT_Code.SRFTCOD_LAMBERT_CONFORMAL_CONIC,
                                    SRM_SRFT_Code.SRFTCOD_TRANSVERSE_MERCATOR,
                                    SRM_SRFT_Code.SRFTCOD_MERCATOR,
                                    SRM_SRFT_Code.SRFTCOD_PLANETODETIC,
                                    SRM_SRFT_Code.SRFTCOD_OBLIQUE_MERCATOR_SPHERICAL,
                                    SRM_SRFT_Code.SRFTCOD_EQUIDISTANT_CYLINDRICAL,
                                    SRM_SRFT_Code.SRFTCOD_POLAR_STEREOGRAPHIC,
                                    SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone()
    {
        return (Conversions) new CdetConv();
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
            case SRFTCOD_CELESTIOCENTRIC:
            {
                // perform pre validation
                retValid = CoordCheck.forCelestiodetic(this.getOrmData(), src);
                toCcen(srcSrf, destSrf, src, dest);

                 // post validation - NO RESTRICTION
                 retValid = CoordCheck.forNaN_3D(dest);
                break;
            }
            case SRFTCOD_TRANSVERSE_MERCATOR:
            {
                // perform pre validation
                switch (destSrf.getSRFSetCode())
                {
                    // use ALSP validation if destination SRF is ALSP
                    case SRFSCOD_ALABAMA_SPCS:
                         retValid = CoordCheck.forALSP_cd
                                    (this.getOrmData(),
                                     ((SRF_TransverseMercator)destSrf).
                                      getSRFParameters(),
                                     src);
                         break;
                    case SRFSCOD_JAPAN_RECTANGULAR_PLANE_CS:
                         // use Japan validation if source SRF is Japan
                         retValid = CoordCheck.forJapan_cd
                                    (this.getOrmData(),
                                     (SRM_SRFSM_Japan_Rectangular_Plane_CS_Code)destSrf.getSRFSetMemberCode(),
                                     ((SRF_TransverseMercator)
                                      destSrf).getSRFParameters(),
                                     src);
                         break;
                    // use UTM validation if destination SRF is UTM
                    case SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR:
                         retValid = CoordCheck.forUTM_cd
                                    (this.getOrmData(),
                                     ((SRF_TransverseMercator)destSrf).
                                      getSRFParameters(),
                                     (SRM_SRFSM_UTM_Code)destSrf.
                                      getSRFSetMemberCode(),
                                     src);
                         break;
                    default: // use TM_AUGMENTED_3D validation
                         retValid = CoordCheck.forTransverseMercator_cd
                                    (this.getOrmData(),
                                     ((SRF_TransverseMercator)destSrf).
                                      getSRFParameters(),
                                     src);
                         break;
                }
                toTmer(srcSrf, destSrf, src, dest);

                // post validation - NO RESTRICTION
                retValid = CoordCheck.forNaN_3D(dest);

                // apply the false origin offset after the conversion
                dest[0] += ((SRF_TransverseMercator)destSrf).
                           get_false_easting();
                dest[1] += ((SRF_TransverseMercator)destSrf).
                           get_false_northing();
                break;
            }
            case SRFTCOD_MERCATOR:
            {
                // perform pre validation
                retValid = CoordCheck.forCelestiodetic(this.getOrmData(), src);

                toMerc(srcSrf, destSrf, src, dest);

                 // post validation - NO RESTRICTION
                 retValid = CoordCheck.forNaN_3D(dest);

                // apply the false origin offset after the conversion
                dest[0] += ((SRF_Mercator)destSrf).get_false_easting();
                dest[1] += ((SRF_Mercator)destSrf).get_false_northing();
                break;
            }
            case SRFTCOD_LAMBERT_CONFORMAL_CONIC:
            {
                // perform pre validation
                retValid = CoordCheck.forCelestiodetic(this.getOrmData(), src);

                toLcc(srcSrf, destSrf, src, dest);

                // perform post validation - NO CONSTRAINT
                 retValid = CoordCheck.forNaN_3D(dest);

                // apply the false origin offset after the conversion
                dest[0] += ((SRF_LambertConformalConic)destSrf).
                           get_false_easting();
                dest[1] += ((SRF_LambertConformalConic)destSrf).
                           get_false_northing();
                break;
            }
            case SRFTCOD_PLANETODETIC:
            {
                // perform pre validation
                retValid = CoordCheck.forCelestiodetic(this.getOrmData(), src);

                // pd_lon = -cd_lon
                dest[1] = -src[0];

                // pd_lat = cd_lat
                dest[0] = src[1];

                // height = height
                dest[2] = src[2];

                // post validation - don't need due to nature of conversion
                break;
            }
            case SRFTCOD_OBLIQUE_MERCATOR_SPHERICAL:
            {
                // perform pre validation - NO CONSTRAINT

                toOmer(srcSrf, destSrf, src, dest);

                 // post validation - NO RESTRICTION
                 retValid = CoordCheck.forNaN_3D(dest);

                // apply the false origin offset after the conversion
                dest[0] += ((SRF_ObliqueMercatorSpherical)destSrf).
                           get_false_easting();
                dest[1] += ((SRF_ObliqueMercatorSpherical)destSrf).
                           get_false_northing();
                break;
            }
            case SRFTCOD_EQUIDISTANT_CYLINDRICAL:
            {
                // perform pre validation
                retValid = CoordCheck.forEquidistantCylindrical_cd
                           (this.getOrmData(), src);

                toEqcy(srcSrf, destSrf, src, dest);

                // perform post validation - NO CONSTRAINT
                 retValid = CoordCheck.forNaN_3D(dest);

                // apply the false origin offset after the conversion
                dest[0] += ((SRF_EquidistantCylindrical)destSrf).
                           get_false_easting();
                dest[1] += ((SRF_EquidistantCylindrical)destSrf).
                           get_false_northing();
                break;
            }
            case SRFTCOD_POLAR_STEREOGRAPHIC:
            {
                // perform pre validation
                // use UPS validation if destination SRF is UPS
                if (destSrf.getSRFSetCode() ==
                    SRM_SRFS_Code.SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC)
                {
                    retValid = CoordCheck.forUPS_cd
                               (((SRF_PolarStereographic)destSrf).
                                 getSRFParameters(),
                                src);
                }
                else
                {
                    retValid = CoordCheck.forPolarStereographic_cd
                               (((SRF_PolarStereographic)destSrf).
                                 getSRFParameters(),
                                src);
                }
                toPost(srcSrf, destSrf, src, dest);

                 // post validation - NO RESTRICTION
                 retValid = CoordCheck.forNaN_3D(dest);

                // apply the false origin offset after the conversion
                dest[0] += ((SRF_PolarStereographic)destSrf).
                           get_false_easting();
                dest[1] += ((SRF_PolarStereographic)destSrf).
                           get_false_northing();
                break;
            }
            case SRFTCOD_UNSPECIFIED:
            {
                // Just pass the coordinate through.
                // This is the last conversion of chain
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
 * CDET to CCEN routines
 *
 *----------------------------------------------------------------------------
 */
    private void toCcen
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] src,
        double[] dest
    ) throws SrmException
    {
        double rn, Rnc2a2, Rnhc, slat;
        double srcLon       = src[0];
        double srcLat       = src[1];
        double srcHeight    = src[2];
        OrmData e_constants = this.getOrmData();

        slat = Math.sin(srcLat);

        if (e_constants.Eps != 0.0) /* compute ellipsoidal values */
        {
            double temp   = e_constants.Eps25 * slat * slat;

            temp   = 0.5 - temp;
            temp   = temp + (temp - .25)/temp;
            rn     = (e_constants.A)/temp;
            Rnc2a2 = rn * e_constants.C2 / e_constants.A2;
        }
        else /* compute spherical values */
        {
            rn     = e_constants.A;
            Rnc2a2 = rn;
        }
        Rnhc = (rn + srcHeight) * Math.cos(srcLat);

        dest[0] = Rnhc * Math.cos(srcLon);
        dest[1] = Rnhc * Math.sin(srcLon);
        dest[2] = (Rnc2a2 + srcHeight) * slat;
    }

/*
 *----------------------------------------------------------------------------
 *
 * CDET to TMER routines and classes
 *
 *----------------------------------------------------------------------------
 */
    private class ToTmerConst
    {
        double Cdb6,
               Cdb24,
               Cdb120,
               Cdb720,
               Cdb5040,
               Cdb40320,
               CScale,
               latitude_origin,
               longitude_origin,
               smz;
        Const.ArcLengthConst arclength_spec;

        public ToTmerConst
        (
            OrmData       e_constants,
            SRF_TM_Params params
        )
        {
            latitude_origin  = params.origin_latitude;
            longitude_origin = params.origin_longitude;
            CScale           = params.central_scale;

            Cdb6     = 0.166666666666667;
            Cdb24    = 0.416666666666667e-1;
            Cdb120   = 0.833333333333333e-2;
            Cdb720   = 0.138888888888888e-2;
            Cdb5040  = 1.0/5040;
            Cdb40320 = 1.0/40320.0;

             if (e_constants.Eps != 0.0) /* compute ellipsoidal values */
             {
                 smz = Const.exactArcLength(e_constants.A, e_constants.C,
                                            e_constants.Eps2,
                                            latitude_origin);
                 arclength_spec = new Const.ArcLengthConst(e_constants);
             }
             else /* compute spherical values */
             {
                 smz = e_constants.A * latitude_origin;
             }
        }
    }

    // This method takes an "intermediate" format so that the TM_AUGMENTED_3D Conv
    // could access it to compute validation boundary - hence protected
    protected void toTmer
    (
        SRF_TM_Params params,
        double[]      source_generic_coordinate,
        double[]      dest_generic_coordinate
    ) throws SrmException
    {
        final double ONE_POINT_ONE_DEGREES   = .0191986217719376253459;
        final double TWO_POINT_FOUR_DEGREES  = .0418879020478639098456;
        final double FOUR_POINT_ZERO_DEGREES = .069813170079773183076;

        OrmData e_constants = this.getOrmData();

        // This works because the intermediate STFs are either CCEN or CDET.
        // Only source or destination SRFs can be TM_AUGMENTED_3D.  Since
        // this is a conversion to TM_AUGMENTED_3D, then the TM_AUGMENTED_3D
        // must be the destination SRF.
        if (_toTmerConst == null)
            _toTmerConst = new ToTmerConst(e_constants, params);

        double source_lon = source_generic_coordinate[0];
        double source_lat = source_generic_coordinate[1];
        double source_elv = source_generic_coordinate[2];

        double al=0.0,
               al2=0.0,
               lambda_star=0.0,
               sin_lat=0.0,
               cos_lat=0.0,
               Sm=0.0,
               tan_lat_squared=0.0,
               tan_lat=0.0,
               sin_squared_lat=0.0;

        sin_lat=Math.sin(source_lat); /*s1*/
        cos_lat=Math.cos(source_lat); /*c1*/
        if (cos_lat != 0.0)
        {
            tan_lat = sin_lat/cos_lat; /*tx*/
        }
        else
        {
            tan_lat = 0.0;
        }
        tan_lat_squared=Const.square(tan_lat); /*tn2*/
        sin_squared_lat=Const.square(sin_lat);

        lambda_star = Const.getLambdaStar(source_lon, _toTmerConst.longitude_origin);

        /*!\bug $$$ Note that the changes made to replace dlon with
          lambda_star must be made to the convergence of the meridian
          routines
        */
        al  = (lambda_star) * cos_lat;
        al2 = al * al;

        if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
        {
            double Rn;
            double Fe, Fn;
            double cee=e_constants.Epps2*cos_lat*cos_lat;
            double cee_squared=Const.square(cee);

            Rn = Const.computeRn(sin_squared_lat, e_constants);

            // This fast approximation for arcLength is used rather
            // than the highly accurate 8th order series approximation
            // for reasons of speed.
            Sm=Const.arcLength(_toTmerConst.arclength_spec,source_lat,sin_lat,cos_lat);

            /* here we're taking only enough terms to meet
               accuracy requirements based on our location*/

            if (Math.abs(lambda_star) <= ONE_POINT_ONE_DEGREES)
            {
                double polx1 = 1.0 - tan_lat_squared + cee;
                double poly1 = 5.0 - tan_lat_squared;

                Fe = 1.0+al2*polx1*_toTmerConst.Cdb6;
                Fn = 0.5+al2*poly1*_toTmerConst.Cdb24;
            }
            else if (Math.abs(lambda_star) <= TWO_POINT_FOUR_DEGREES)
            {
                double polx1 =  1.0 - tan_lat_squared+cee;
                double polx2 =  5.0 + tan_lat_squared*
                                      (tan_lat_squared-18.0);
                double poly1 = (5.0-tan_lat_squared) +
                               cee*(9.0 + 4.0*cee);

                Fe = 1.0+al2*(polx1*_toTmerConst.Cdb6+al2*polx2*_toTmerConst.Cdb120);
                Fn = 0.5+al2*poly1*_toTmerConst.Cdb24;
            }
            else if (Math.abs(lambda_star) <= FOUR_POINT_ZERO_DEGREES)
            {
                double polx1     = 1.0 - tan_lat_squared+cee;
                double tmp_polx2 = 5.0 + tan_lat_squared*
                                         (tan_lat_squared-18.0);
                double polx2 = tmp_polx2+cee*(14.0-58.0*tan_lat_squared);
                double poly1 = (5.0-tan_lat_squared) +cee*(9.0 + 4.0*cee);
                double tmp_poly2 = 61.0+tan_lat_squared*(tan_lat_squared-58.0);
                double poly2     = tmp_poly2+cee*(270.0-330.0*tan_lat_squared);

                Fe = 1.0+al2*(polx1*_toTmerConst.Cdb6+al2*polx2*_toTmerConst.Cdb120);
                Fn = 0.5+al2*(poly1*_toTmerConst.Cdb24+al2 *poly2*_toTmerConst.Cdb720);
            }
            else
            {
                double polx1 = 1.0 - tan_lat_squared+cee;
                double tx2   = cee_squared*(13.0+cee*4.0 -
                                            tan_lat_squared*(64.0+24.0*cee));
                double polx2 = tx2+ 5.0 +
                               tan_lat_squared*(tan_lat_squared-18.0) +
                               cee*(14.0-58.0*tan_lat_squared);
                double polx3 = 61.0 +
                               tan_lat_squared*(-479.0+tan_lat_squared*(179.0-tan_lat_squared));

                double poly1=(5.0-tan_lat_squared) +cee*(9.0 + 4.0*cee);
                double tmp_poly2=61.0+tan_lat_squared*(tan_lat_squared-58.0);
                double poly2=tmp_poly2+cee*(270.0-330.0*tan_lat_squared);
                double tmp_ty2=poly2+445.0*Const.square(cee);
                double tmp2_ty2=tmp_ty2+324.0*Const.cube(cee)-680.0*tan_lat_squared*Const.square(cee);
                double ty2=tmp2_ty2+88.0*Const.square(cee)*Const.square(cee)-600.0*tan_lat_squared*Const.cube(cee);
                double new_poly2=ty2-192.0*tan_lat_squared*Const.square(cee)*Const.square(cee);
                double new_poly3=1385.0+tan_lat_squared*(-3111.0+tan_lat_squared*(543.0-tan_lat_squared));

                Fe=1.0+al2*(polx1*_toTmerConst.Cdb6+al2*(polx2*_toTmerConst.Cdb120+al2*polx3*_toTmerConst.Cdb5040));
                Fn=0.5+al2*(poly1*_toTmerConst.Cdb24+al2*(new_poly2*_toTmerConst.Cdb720+al2*new_poly3*_toTmerConst.Cdb40320));
            }
            {
                double easting=Fe*al*_toTmerConst.CScale*Rn;
                double northing=_toTmerConst.CScale*(Sm-_toTmerConst.smz+Rn*tan_lat*al2*Fn);

                dest_generic_coordinate[0] = easting;
                dest_generic_coordinate[1] = northing;

                /*CDK Nov 2, 2004. The false easting and northing are added
                  elsewhere; adding them in this routine would be double counting*/
            }
        }
        else /* compute spherical values */
        {
            double Rn = _toTmerConst.CScale * e_constants.A;

            dest_generic_coordinate[0] = Rn * Const.atanh(cos_lat*Math.sin(lambda_star));
            dest_generic_coordinate[1] = Rn * (Math.atan(tan_lat/Math.cos(lambda_star)) - _toTmerConst.latitude_origin);
        }
        dest_generic_coordinate[2]=source_elv;
    }


    private void toTmer
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coordinate,
        double[] dest_generic_coordinate
    ) throws SrmException
    {
        toTmer(((SRF_TransverseMercator)destSrf).getSRFParameters(),
                source_generic_coordinate,
                dest_generic_coordinate);
    }

/*
 *----------------------------------------------------------------------------
 *
 * CDET to Mercator routines and classes
 *
 *----------------------------------------------------------------------------
 */
    private class ToMercConst
    {
        double CR11, CR12, CR13, CR14, CR15, CR21, CR22, CR23, CR24, CR25;
        double scale, longitude_origin;

        public ToMercConst
        (
            OrmData      e_constants,
            SRF_M_Params params
        )
        {
            double AA1, AA2, AA3, AA4, AA5, AA6, AA7, AA8, AA9,
                   AB1, AB2, AB3, AB4, AB5, AB6, AB7, AB8, AB9,
                   BB1, BB2, BB3, BB4, BB5;

            longitude_origin = params.origin_longitude;
            scale            = params.central_scale;

            if (e_constants.Eps2 != 0.0)
            {
                AA1 =  0.100000000003490E+01;
                AA2 = -0.643155723158021;
                AA3 = -0.333332134894985;
                AA4 = -0.241457540671514E-04;
                AA5 =  0.143376648162652;
                AA6 =  0.356844276587295;
                AA7 = -0.333332875955149;
                AA8 =  0.0;
                AA9 =  0.0;

                BB1 = AA1;
                BB2 = e_constants.Eps2*AA2;
                BB3 = e_constants.Eps2*(AA3+e_constants.Eps*(AA4+e_constants.Eps*AA5));
                BB4 = e_constants.Eps2*AA6;
                BB5 = e_constants.Eps2*(AA7+e_constants.Eps*(AA8+e_constants.Eps*AA9));

                CR11 = BB3/BB5-.187E-11;
                CR12 = (BB2-BB4*BB3/BB5)/BB5;
                CR13 = (BB1-BB3/BB5)/BB5;
                CR14 = 1.0/BB5;
                CR15 = BB4/BB5;

                AB1 =  0.999999999957885;
                AB2 = -0.115979311942142E+01;
                AB3 = -0.333339671395063;
                AB4 =  0.276473457331734E-03;
                AB5 =  0.587786240368508;
                AB6 = -0.159793128888088;
                AB7 = -0.333333465982150;
                AB8 =  0.746505041501704E-04;
                AB9 = -0.701559218182283E-01;

                BB1 = AB1;
                BB2 = e_constants.Eps2*AB2;
                BB3 = e_constants.Eps2*(AB3+e_constants.Eps*(AB4+e_constants.Eps*AB5));
                BB4 = e_constants.Eps2*AB6;
                BB5 = e_constants.Eps2*(AB7+e_constants.Eps*(AB8+e_constants.Eps*AB9));

                CR21 = BB3/BB5+.2689E-11;
                CR22 = (BB2-BB4*BB3/BB5)/BB5;
                CR23 = (BB1-BB3/BB5)/BB5;
                CR24 = 1.0/BB5;
                CR25 = BB4/BB5;
            }
        }
    }

    private void toMerc
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coordinate,
        double[] dest_generic_coordinate
    ) throws SrmException
    {
        double source_elv, source_lat, source_lon;
        double dest_x, dest_y;
        double p, sin_lat;

        OrmData e_constants = this.getOrmData();

        if (_toMercConst == null)
        {
            _toMercConst = new ToMercConst
                               (e_constants,
                                ((SRF_Mercator)destSrf).getSRFParameters());
        }
        source_lon = Const.getLambdaStar(source_generic_coordinate[0],
                                         _toMercConst.longitude_origin);
        source_lat = source_generic_coordinate[1];
        source_elv = source_generic_coordinate[2];

        sin_lat = Math.sin(source_lat);

        if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
        {
            double abs_sin_lat = Math.abs(sin_lat);

            if (abs_sin_lat <= (35.5* Const.RADIANS_PER_DEGREE))
                p = _toMercConst.CR11 +
                    (_toMercConst.CR12 * abs_sin_lat + _toMercConst.CR13)
                    / (_toMercConst.CR14 + abs_sin_lat *
                        (_toMercConst.CR15 + abs_sin_lat));
            else
                p = _toMercConst.CR21 +
                    (_toMercConst.CR22 * abs_sin_lat + _toMercConst.CR23)
                    / (_toMercConst.CR24 + abs_sin_lat *
                       (_toMercConst.CR25 + abs_sin_lat));

            if (sin_lat < 0.0)
                p = 1.0/p;

            p = p * Math.sqrt((1.0 + sin_lat)/(1.0 - sin_lat));
        }
        else /* compute spherical values */
            p = Math.sqrt((1.0 + sin_lat)/(1.0 - sin_lat));

        /* fix quadrant on longitude */
        source_lon = Const.fix_longitude(source_lon);

        /* COMPUTE NORTHING AND EASTING */

        dest_x = _toMercConst.scale * e_constants.A * source_lon;

        dest_y = _toMercConst.scale * e_constants.A * Math.log(p);

        dest_generic_coordinate[0] = dest_x;
        dest_generic_coordinate[1] = dest_y;
        dest_generic_coordinate[2] = source_elv;
    }

/*
 *----------------------------------------------------------------------------
 *
 * CDET to Mercator routines and classes
 *
 *----------------------------------------------------------------------------
 */
    private class ToOmerConst
    {
        double sa0;
        double ca0;
        double cl0;
        double sl0;
        double ak0;
        double lambda_0;

        public ToOmerConst (OrmData e_constants, SRF_OM_Params params)
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

            sin_lat1 = Math.sin(params.latitude1);
            cos_lat1 = Math.cos(params.latitude1);

            sin_lat2 = Math.sin(params.latitude2);
            cos_lat2 = Math.cos(params.latitude2);

            sin_lon1 = Math.sin(params.longitude1);
            cos_lon1 = Math.cos(params.longitude1);

            sin_lon2 = Math.sin(params.longitude2);
            cos_lon2 = Math.cos(params.longitude2);


            p0=cos_lat1*sin_lat2*sin_lon1-sin_lat1*cos_lat2*sin_lon2;
            q0=cos_lat1*sin_lat2*cos_lon1-sin_lat1*cos_lat2*cos_lon2;

            lambda_0=Math.atan2(p0,q0);

            cl0=Math.cos(lambda_0);
            sl0=Math.sin(lambda_0);

            sin_lambda_1_minus_lambda_0=sin_lon1*cl0-cos_lon1*sl0;
            sin_lambda_2_minus_lambda_0=sin_lon2*cl0-cos_lon2*sl0;

            if(Math.abs(sin_lambda_1_minus_lambda_0)>=Math.abs(sin_lambda_2_minus_lambda_0))
            {
                alpha_0=Math.atan(sin_lat1/(cos_lat1*sin_lambda_1_minus_lambda_0));
            }
            else
            {
                alpha_0=Math.atan(sin_lat2/(cos_lat2*sin_lambda_2_minus_lambda_0));
            }
            sa0=Math.sin(alpha_0);
            ca0=Math.cos(alpha_0);
            ak0=e_constants.A * params.central_scale;
        }
    }


    private void toOmer (BaseSRF  srcSrf,
                         BaseSRF  destSrf,
                         double[] source_generic_coordinate,
                         double[] dest_generic_coordinate) throws SrmException
    {
        double dest_x, dest_y;

        OrmData e_constants = this.getOrmData();

        if (_toOmerConst == null)
            _toOmerConst = new ToOmerConst(e_constants,
                                           ((SRF_ObliqueMercatorSpherical)destSrf).getSRFParameters());

        double source_lon = source_generic_coordinate[0];
        double source_lat = source_generic_coordinate[1];
        double source_elv = source_generic_coordinate[2];

        double
            sin_phi=0.0,
            cos_phi=0.0,
            sin_lambda=0.0,
            cos_lambda=0.0,
            p1=0.0,
            p2=0.0,
            sin_lambda_minus_lambda_0=0.0,
            cos_lambda_minus_lambda_0=0.0;

        sin_lambda = Math.sin(source_lon);
        cos_lambda = Math.cos(source_lon);

        sin_phi = Math.sin(source_lat);
        cos_phi = Math.cos(source_lat);


        sin_lambda_minus_lambda_0=(sin_lambda*_toOmerConst.cl0 - cos_lambda*_toOmerConst.sl0); /*good*/
        cos_lambda_minus_lambda_0=(cos_lambda*_toOmerConst.cl0 + sin_lambda*_toOmerConst.sl0); /*good*/

        p1= (_toOmerConst.sa0*sin_phi) + _toOmerConst.ca0 * cos_phi * sin_lambda_minus_lambda_0;
        p2= (-_toOmerConst.ca0*sin_phi) + _toOmerConst.sa0 * cos_phi * sin_lambda_minus_lambda_0;

        dest_x=_toOmerConst.ak0*Math.atan2(p1,cos_phi*cos_lambda_minus_lambda_0);
        dest_y=0.5*_toOmerConst.ak0*Math.log((1-p2)/(1+p2));

        dest_generic_coordinate[0] = dest_x;
        dest_generic_coordinate[1] = dest_y;
        dest_generic_coordinate[2] = source_elv;
    }


/*----------------------------------------------------------------------------
 *
 * CDET to LCC1 routines and classes
 *
 *----------------------------------------------------------------------------
 */
    private void toLcc (BaseSRF  srcSrf,
                        BaseSRF  destSrf,
                        double[] source_generic_coordinate,
                        double[] dest_generic_coordinate) throws SrmException
    {
        double latitude1 =
            (((SRF_LambertConformalConic)destSrf).get_latitude1());
        double latitude2 =
            (((SRF_LambertConformalConic)destSrf).get_latitude2());

        // use lcc1 is north and south parallels are the same
        if (Math.abs(latitude1 - latitude2) < 0.0001)
            toLcc1(srcSrf, destSrf, source_generic_coordinate,
                   dest_generic_coordinate);
        else  // use lcc2 otherwise
            toLcc2(srcSrf, destSrf, source_generic_coordinate,
                   dest_generic_coordinate);

    }
/*----------------------------------------------------------------------------
 *
 * CDET to LCC1 routines and classes
 *
 *----------------------------------------------------------------------------
 */
    // This computes and stores the constants used for converting from LCC
    // to CD, for the case where the LCC northern parallel is the same as
    // the LCC southern parallel.
    private class ToLccConst1
    {
        double _CR11, _CR12, _CR13, _CR14, _CR15,
               _CR21, _CR22, _CR23, _CR24, _CR25,
               _xlonz, _xl, _pz, _rz, _rho_origin;

        public ToLccConst1(OrmData e_constants, SRF_LCC_Params params)
        {
            double AA1, AA2, AA3, AA4, AA5, AA6, AA7, AA8, AA9,
                   AB1, AB2, AB3, AB4, AB5, AB6, AB7, AB8, AB9,
                   BB1, BB2, BB3, BB4, BB5;
            double latitude_origin, phiz, porg, pz, rz, rz2, xl, xl2,
                   sin_org;

            /* phiz   == standard parallel, in radians */
            /* _xlonz == meridian y-axis, in radians */
            phiz            = params.latitude1;
            _xlonz          = params.origin_longitude;
            latitude_origin = params.origin_latitude;

            xl  = Math.sin(phiz);
            xl2 = xl*xl;

            pz = Math.tan(Const.PI_DIV_4 + 0.5 * phiz);

            sin_org = Math.sin(latitude_origin);

            porg = Math.tan(Const.PI_DIV_4 + 0.5 * latitude_origin);

            if (e_constants.Eps!=0) /* do ellipsoid calculations */
            {
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
                BB3=e_constants.Eps2*
                    (AA3+e_constants.Eps*(AA4+e_constants.Eps*AA5));
                BB4=e_constants.Eps2*AA6;
                BB5=e_constants.Eps2*
                    (AA7+e_constants.Eps*(AA8+e_constants.Eps*AA9));

                _CR11=BB3/BB5-.187E-11;
                _CR12=(BB2-BB4*BB3/BB5)/BB5;
                _CR13=(BB1-BB3/BB5)/BB5;
                _CR14=1.0/BB5;
                _CR15=BB4/BB5;

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
                BB3=e_constants.Eps2*
                    (AB3+e_constants.Eps*(AB4+e_constants.Eps*AB5));
                BB4=e_constants.Eps2*AB6;
                BB5=e_constants.Eps2*
                    (AB7+e_constants.Eps*(AB8+e_constants.Eps*AB9));

                _CR21=BB3/BB5-.2689E-11;
                _CR22=(BB2-BB4*BB3/BB5)/BB5;
                _CR23=(BB1-BB3/BB5)/BB5;
                _CR24=1.0/BB5;
                _CR25=BB4/BB5;

                pz  = Math.pow((1.0 - e_constants.Eps * xl) /
                               (e_constants.Eps * xl + 1.0),
                               e_constants.EpsH) * pz;

                porg = Math.pow((1.0 - e_constants.Eps  * sin_org) /
                                (e_constants.Eps * sin_org + 1.0),
                                e_constants.EpsH)*porg;

                rz  = e_constants.A*Math.cos(phiz) /
                      (xl*Math.sqrt(1.0 - e_constants.Eps2 * xl2));
            }
            else /* do sphere calculations */
            {
                rz = e_constants.A*Math.cos(phiz)/xl;
            }
            _xl=xl;
            _pz=pz;
            _rz=rz;

            /* prevent divide by zero  */
            if (Math.abs(porg)<=.000000000001)
                pz = 0.0;
            else
                pz = pz / porg;

            _rho_origin = rz * Math.pow(pz , xl);
        }
    }


    protected void toLcc1
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coordinate,
        double[] dest_generic_coordinate
    ) throws SrmException
    {
        OrmData e_constants = this.getOrmData();

        if (_toLccConst1 == null)
        {
            _toLccConst1 = new ToLccConst1
                               (e_constants,
                                ((SRF_LambertConformalConic)destSrf).
                                 getSRFParameters());
        }
        double arg, dest_x, dest_y, dlon, p, r, s1, sl, t;

        double source_lon = source_generic_coordinate[0];
        double source_lat = source_generic_coordinate[1];
        double source_elv = source_generic_coordinate[2];

        sl = Math.sin(source_lat);

        if (e_constants.Eps!=0.0) /* do ellipsoid calculations */
        {
            double esl = e_constants.Eps * sl;
            p = Math.pow((1.0 + esl)/(1.0 - esl), e_constants.EpsH);
        }
        else /* do sphere calculations */
        {
            p = 1.0;
        }
        p = p * Math.tan(Const.PI_DIV_4 - 0.5 * source_lat);
        r = _toLccConst1._rz *
            Math.pow(_toLccConst1._pz*p, _toLccConst1._xl);

        dlon = Const.getLambdaStar(source_lon, _toLccConst1._xlonz);

        arg = _toLccConst1._xl * dlon;
        s1  = Math.sin(arg);
        t   = Math.cos(arg);

        dest_x = r * s1;
        dest_y = _toLccConst1._rho_origin - (r * t);

        /* fix signs */
        if (_toLccConst1._xl < 0.0)
        {
            dest_x=-dest_x;
            dest_y=-dest_y;
        }
        dest_generic_coordinate[0] = dest_x;
        dest_generic_coordinate[1] = dest_y;
        dest_generic_coordinate[2] = source_elv;
    }


/*----------------------------------------------------------------------------
 *
 * CDET to LCC2 routines and classes
 *
 *----------------------------------------------------------------------------
 */
    // This computes and stores the constants used for converting from LCC
    // to CD, for the case where the LCC northern parallel differs from
    // the LCC southern parallel.
    private class ToLccConst2
    {
        double _CR11, _CR12, _CR13, _CR14, _CR15,
               _CR21, _CR22, _CR23, _CR24, _CR25,
               _xlonz, _rx, _rz, _p1, _xl;

        public ToLccConst2(OrmData e_constants, SRF_LCC_Params params)
        {
            double AA1, AA2, AA3, AA4, AA5, AA6, AA7, AA8, AA9,
                   AB1, AB2, AB3, AB4, AB5, AB6, AB7, AB8, AB9,
                   BB1, BB2, BB3, BB4, BB5;
            double c12, c22, latitude_origin, p1, p2, phiz1,  phiz2, pz,
                   rn12, rn22, rx, rx2, rz, s1, s12, s2, s22, sfx, temp, xl;

            /* phiz == standard parallels */
            phiz1           = params.latitude1;
            phiz2           = params.latitude2;
            _xlonz          = params.origin_longitude;
            latitude_origin = params.origin_latitude;

            /*
             * Test whether this is a spherical transformation(Eps=0);
             * if not, then we compute these constants.
             */
            if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
            {
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
                BB3=e_constants.Eps2*
                    (AA3+e_constants.Eps*(AA4+e_constants.Eps*AA5));
                BB4=e_constants.Eps2*AA6;
                BB5=e_constants.Eps2*
                    (AA7+e_constants.Eps*(AA8+e_constants.Eps*AA9));

                _CR11=BB3/BB5-.187E-11;
                _CR12=(BB2-BB4*BB3/BB5)/BB5;
                _CR13=(BB1-BB3/BB5)/BB5;
                _CR14=1.0/BB5;
                _CR15=BB4/BB5;

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
                BB3=e_constants.Eps2*
                    (AB3+e_constants.Eps*(AB4+e_constants.Eps*AB5));
                BB4=e_constants.Eps2*AB6;
                BB5=e_constants.Eps2*
                    (AB7+e_constants.Eps*(AB8+e_constants.Eps*AB9));

                _CR21=BB3/BB5-.2689E-11;
                _CR22=(BB2-BB4*BB3/BB5)/BB5;
                _CR23=(BB1-BB3/BB5)/BB5;
                _CR24=1.0/BB5;
                _CR25=BB4/BB5;
            } /* end if not spherical */

            sfx = Math.sin(latitude_origin);
            s1  = Math.sin(phiz1);
            s2  = Math.sin(phiz2);

            s12 = s1*s1;
            c12 = 1.0-s12;

            s22 = s2*s2;
            c22 = 1.0-s22;

            pz = Math.tan(Const.PI_DIV_4 + (0.5 * latitude_origin));
            p1 = Math.tan(Const.PI_DIV_4 + (0.5 * phiz1));
            p2 = Math.tan(Const.PI_DIV_4 + (0.5 * phiz2));

            if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
            {
                pz  = pz * Math.pow((1.0 - e_constants.Eps * sfx)/
                                    (e_constants.Eps * sfx + 1.0),
                                    e_constants.EpsH);

                p1  = p1 * Math.pow((1.0 - e_constants.Eps * s1)/
                                    (e_constants.Eps * s1 + 1.0),
                                    e_constants.EpsH);

                p2  = p2 * Math.pow((1.0 - e_constants.Eps * s2)/
                                    (e_constants.Eps * s2 + 1.0),
                                    e_constants.EpsH);

                rn12 = e_constants.A2 / (1.0 - (e_constants.Eps2 * s12));
                rn22 = e_constants.A2 / (1.0 - (e_constants.Eps2 * s22));
                temp = p2/p1;
                xl  = .5 * Math.log((rn12 * c12)/(c22 * rn22)) / Math.log(temp);
            }
            else /* compute spherical values */
            {
                rn12 = e_constants.A2;
                temp = p2 / p1;
                xl = 0.5 * Math.log(c12 / c22) / Math.log(temp);
            }
            rx2 = rn12 * c12 / (xl * xl);
            rx  = Math.sqrt(rx2);
            rz  = rx * Math.pow(p1 / pz,xl);

            _rx = rx;
            _rz = rz;
            _xl = xl;
            _p1 = p1;
        }
    }


    protected void toLcc2
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coordinate,
        double[] dest_generic_coordinate
    ) throws SrmException
    {
        OrmData e_constants = this.getOrmData();

        if (_toLccConst2 == null)
        {
            _toLccConst2 = new ToLccConst2
                               (e_constants,
                                ((SRF_LambertConformalConic)destSrf).
                                 getSRFParameters());
        }
        double dest_x, dest_y, source_elv, source_lat, source_lon;
        double arg, dlon, p, r, s1, sl, t;

        source_lon = source_generic_coordinate[0];
        source_lat = source_generic_coordinate[1];
        source_elv = source_generic_coordinate[2];

        sl = Math.sin(source_lat);

        if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
        {
            double esl = e_constants.Eps * sl;
            p = Math.pow((1.0 + esl)/(1.0 - esl), e_constants.EpsH);
        }
        else /* compute spherical values */
        {
            p = 1.0;
        }

        /*
         * if sl < sin(89 degrees)
         */
        p = p * Math.tan(Const.PI_DIV_4 - .5 * source_lat);

        r = _toLccConst2._rx *
            Math.pow(_toLccConst2._p1*p, _toLccConst2._xl);

        dlon = Const.getLambdaStar(source_lon, _toLccConst2._xlonz);

        arg = _toLccConst2._xl*dlon;

        s1 = Math.sin(arg);
        t  = Math.cos(arg);

        dest_x = r * s1;
        dest_y = _toLccConst2._rz - r * t;

        if (_toLccConst2._xl < 0)
        {
            dest_x=-dest_x;
            dest_y=-dest_y;
        }
        dest_generic_coordinate[0] = dest_x;
        dest_generic_coordinate[1] = dest_y;
        dest_generic_coordinate[2] = source_elv;
    }

/*----------------------------------------------------------------------------
*
* FUNCTION: toEC
*
*----------------------------------------------------------------------------
*/
    private class ToEqcyConst
    {
        double               longitude_origin;
        double               scale_factor;
        Const.ArcLengthConst al;

        public ToEqcyConst
        (
            OrmData       e_constants,
            SRF_EC_Params params
        )
        {
            longitude_origin = params.origin_longitude;
            scale_factor     = params.central_scale;
            al               = new Const.ArcLengthConst(e_constants);
       }
    }


    protected void toEqcy
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coordinate,
        double[] dest_generic_coordinate
    ) throws SrmException
    {
        OrmData e_constants = this.getOrmData();
        double  source_lon  = source_generic_coordinate[0];
        double  source_lat  = source_generic_coordinate[1];
        double  source_elv  = source_generic_coordinate[2];

        if (_toEqcyConst == null)
            _toEqcyConst = new ToEqcyConst(e_constants,
                                           ((SRF_EquidistantCylindrical)destSrf).getSRFParameters());

        double lambda_star = Const.getLambdaStar
                                   (source_lon,
                                    _toEqcyConst.longitude_origin);

        dest_generic_coordinate[0] =
                e_constants.A * _toEqcyConst.scale_factor * lambda_star;

        // Note that the y term does not have the scale factor k0 in it,
        // because equidistant cyllindrical would not be an equidistant
        // projection if it did.
        if (e_constants.Eps2 != 0.0) // ellipsoidal case
        {
            dest_generic_coordinate[1] =
               Const.arcLength(_toEqcyConst.al,
                               source_lat,
                               Math.sin(source_lat),
                               Math.cos(source_lat));
        }
        else // spherical case
        {
            dest_generic_coordinate[1] = source_lat * e_constants.A;
        }
        dest_generic_coordinate[2] = source_elv;
    }

/*----------------------------------------------------------------------------
*
* FUNCTION: toPost
*
*----------------------------------------------------------------------------
*/
    private class ToPostConst
    {
        double
            false_easting,
            false_northing, m0,
            eps_factor,
            origin_lon,
            t_of_lat_origin_inv,
            k0,
            scale_factor,
            P0,
            xmc,
            tc,
            tc_inv,
            e,
            e_inv,
            cr1[] = new double[5],
            cr2[] = new double[5],
            cos_origin_lon,
            sin_origin_lon,
            polar_aspect_constant;
                   /* will be 1 or negative 1 prevents having to do test
             in the conversion, just multiply by the constant*/
        SRM_Polar_Aspect   polar_aspect;

        public ToPostConst(OrmData e_constants, SRF_PS_Params params)
        {
            double origin_longitude;
            double polar_aspect_sign=1.0;

            polar_aspect     = params.polar_aspect;
            false_easting    = params.false_easting;
            false_northing   = params.false_northing;
            k0               = params.central_scale;
            scale_factor     = params.central_scale;


            if (polar_aspect == SRM_Polar_Aspect.PLRASP_SOUTH)
            {
                polar_aspect_sign     = -1.0;
                polar_aspect_constant = -1.0;
            }
            else
            {
                polar_aspect_sign     = 1.0;
                polar_aspect_constant = 1.0;
            }
            origin_longitude=polar_aspect_sign*params.origin_longitude;

            eps_factor= Double.NaN;
            origin_lon=origin_longitude;

            P0 = Const.power_p(e_constants, 1.0);

            e=e_constants.A*P0*e_constants.B_inv;
            e_inv=1.0/e;

            if(e_constants.Eps!=0.0)
            {
                Const.init_power_p_series(e_constants, cr1, cr2);
            }
            else
            {
                for (int i=0;i<5;i++)
                {
                    cr1[i]=Double.NaN;
                    cr2[i]=Double.NaN;
                }
            }
            sin_origin_lon=Math.sin(origin_lon);
            cos_origin_lon=Math.cos(origin_lon);
        }
    }

    protected void toPost(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coordinate,
                          double[] dest_generic_coordinate)
    throws SrmException
    {
        OrmData e_constants = this.getOrmData();

        if (_toPostConst == null)
        {
            _toPostConst = new ToPostConst(e_constants,
                                           ((SRF_PolarStereographic)destSrf).getSRFParameters());
        }
        double
    source_lon=source_generic_coordinate[0]*_toPostConst.polar_aspect_constant,
    source_lat=source_generic_coordinate[1]*_toPostConst.polar_aspect_constant,
    sin_lat=Math.sin(source_lat),
    sin_lon=Math.sin(source_lon),
    rho=Double.NaN,
    P=Double.NaN,
    T=Double.NaN,
    scale_factor=_toPostConst.scale_factor,
    cos_lat=Math.cos(source_lat),
    cos_lon=Math.cos(source_lon),
    cos_lat_inv=1.0/cos_lat;

       /* This is the equation for P.  This POWER_P macro below computes this
          with a Taylor series to avoid the costly operations.
          P = pow(((1.0-e_constants.Eps)/(1.0+e_constants.Eps)),
                  (0.5*e_constants.Eps));
          POWER_P(sin_lat,P);
          Note that the series used for p CANNOT be inverted
          by doing algebra on the forward series used as there aren't
          enough terms for it to converge correctly in that case
        */
        if (e_constants.Eps!=0.0)
        {
           /*This is the Ellipsoidal case*/

            P = Const.power_p_approx(_toPostConst.cr1,_toPostConst.cr2, sin_lat);

            T=(1.0-sin_lat)*cos_lat_inv/P;

            rho=2.0*e_constants.A*scale_factor*T*_toPostConst.e;
            {
               /* Note that the bounds don't need to be checked because you can
                  use the trig angle difference formulas and thus the angles
                  themselves are already converted into their trig functions
                  and thus ranges won't matter as everything in this expression
                  is always bounded.
                */
                double
                cos_arg=cos_lon*_toPostConst.cos_origin_lon+sin_lon*_toPostConst.sin_origin_lon,
                sin_arg=sin_lon*_toPostConst.cos_origin_lon-cos_lon*_toPostConst.sin_origin_lon;

                // ASSIGN RETURN VALUE AND ADJUST OUTPUT FOR LSP_2D ASPECT

                dest_generic_coordinate[0]= (rho*sin_arg)*_toPostConst.polar_aspect_constant;
                dest_generic_coordinate[1]= (-rho*cos_arg)*_toPostConst.polar_aspect_constant;
                dest_generic_coordinate[2]= source_generic_coordinate[2];
            }
        }
        else
        {
            T=(1.0-sin_lat)*cos_lat_inv;

            dest_generic_coordinate[0]=2.0*e_constants.A*scale_factor*
                        T*((sin_lon*_toPostConst.cos_origin_lon)-
                   (cos_lon*_toPostConst.sin_origin_lon))*_toPostConst.polar_aspect_constant;
            dest_generic_coordinate[1]=-2.0*e_constants.A*scale_factor*
                      T*((cos_lon*_toPostConst.cos_origin_lon)+
                   (sin_lon*_toPostConst.sin_origin_lon))*_toPostConst.polar_aspect_constant;
                  dest_generic_coordinate[2]= source_generic_coordinate[2];
        }
    }
}
