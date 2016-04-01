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

class LccConv extends Conversions
{
    private ToCdetConst1 _toCdetConst1;
    private ToCdetConst2 _toCdetConst2;

    public LccConv()
    {
        super(SRM_SRFT_Code.SRFTCOD_LAMBERT_CONFORMAL_CONIC,
              new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
                                   SRM_SRFT_Code.SRFTCOD_UNSPECIFIED});
    }

    protected Conversions makeClone()
    {
        return (Conversions) new LccConv();
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
            src[0] -= ((SRF_LambertConformalConic)srcSrf).get_false_easting();
            src[1] -= ((SRF_LambertConformalConic)srcSrf).get_false_northing();
            toCdet(srcSrf, destSrf, src, dest);

            // perform post validation
            retValid = CoordCheck.forCelestiodetic(this.getOrmData(), dest);
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
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
 * FUNCTION: toCdet
 *
 *----------------------------------------------------------------------------
 */
    protected void toCdet(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coord,
                          double[] dest_generic_coord) throws SrmException
    {
        double latitude1 =
            (((SRF_LambertConformalConic)srcSrf).get_latitude1());
        double latitude2 =
            (((SRF_LambertConformalConic)srcSrf).get_latitude2());

        // use lcc1 is north and south parallels are the same
        if (Math.abs(latitude1 - latitude2) < Const.EPSILON)
            toCdet1(srcSrf, destSrf, source_generic_coord, dest_generic_coord);
        else  // use lcc2 otherwise
            toCdet2(srcSrf, destSrf, source_generic_coord, dest_generic_coord);
    }

/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: toCdet1
 *
 *----------------------------------------------------------------------------
 */

    // this is for the case where the northern parallel is the same
    // as the southern parallel.
    private class ToCdetConst1
    {
        double _b1, _b2, _b3, _b4, _xlonz, _xl, _pz, _rz, _rz2, _ex,
               _rho_origin;

        public ToCdetConst1(OrmData e_constants, SRF_LCC_Params params)
        {
            double ex, latitude_origin, pa2, pa4, pa6, pa8, phiz, porg, pz,
                   rz, rz2, sin_org, xl, xl2;

            // phiz == standard parallel, in radians
            // _xlonz == meridian y-axis, in radians
            // latitude_origin == latitude origin, in radians
            phiz            = params.latitude1;
            _xlonz          = params.origin_longitude;
            latitude_origin = params.origin_latitude;

            sin_org = Math.sin(latitude_origin);

            porg = Math.tan(Const.PI_DIV_4 + 0.5 * latitude_origin);

            xl  = Math.sin(phiz);
            ex  = 1.0 / (xl+xl);
            xl2 = xl * xl;

            pz = Math.tan(Const.PI_DIV_4 + .5 * phiz);

            if (e_constants.Eps != 0.0) /* do ellipsoid calculations */
            {
                pa2 = e_constants.Eps2 / 2.0 +
                      Math.pow(e_constants.Eps2, 2.0) * 5.0 / 24.0;

                pa2 += Math.pow(e_constants.Eps2, 3.0) / 12.0 +
                       Math.pow(e_constants.Eps2, 4.0) * 13.0 / 360.0;

                pa4 = Math.pow(e_constants.Eps2, 2.0) * 7.0 / 48.0 +
                      Math.pow(e_constants.Eps2, 3.0) * 29.0 / 240.0;

                pa4 += Math.pow(e_constants.Eps2, 4.0) * 811.0 / 11520.0;

                pa6 = Math.pow(e_constants.Eps2, 3.0) * 7.0 / 120.0 +
                      Math.pow(e_constants.Eps2, 4.0) * 81.0 / 1120.0;

                pa8 = Math.pow(e_constants.Eps2, 4.0) * 4279.0 / 161280.0;

                _b1 = pa2 *    2.0 + pa4 *   4.0 + pa6 *  6.0 + pa8 * 8.0;
                _b2 = pa4 *   -8.0 - pa6 *  32.0 - pa8 * 80.0;
                _b3 = pa6 *   32.0 + pa8 * 192.0;
                _b4 = pa8 * -128.0;

                pz = Math.pow((1.0 - e_constants.Eps * xl)/
                              (e_constants.Eps * xl + 1.0),
                              e_constants.EpsH) *  pz;

                rz  = e_constants.A*Math.cos(phiz)/
                      (xl*Math.sqrt(1 - e_constants.Eps2 * xl2));

                porg = Math.pow((1.0 - e_constants.Eps  * sin_org) /
                                (e_constants.Eps * sin_org + 1.0),
                                e_constants.EpsH)*porg;
            }
            else /* do sphere calculations */
            {
                rz = e_constants.A*Math.cos(phiz)/xl;
            }
            rz2  = rz*rz;
            _pz  = pz;
            _rz  = rz;
            _rz2 = rz2;
            _xl  = xl;
            _ex  = ex;

            /* prevent divide by zero  */
            if (Math.abs(porg)<=.000000000001)
                pz = 0.0;
            else
                pz = pz / porg;

            _rho_origin = rz * Math.pow(pz , xl);
        }
    }


    protected void toCdet1(BaseSRF  srcSrf,
                           BaseSRF  destSrf,
                           double[] source_generic_coordinate,
                           double[] dest_generic_coordinate) throws SrmException
    {
        OrmData e_constants = this.getOrmData();
        double dest_lat, dest_lon, source_x, source_y, source_z;
        double cki, den, drz, r2, ski, tanz2, t2, thet, xki;

        if (_toCdetConst1 == null)
        {
            _toCdetConst1 = new ToCdetConst1
                                (e_constants,
                                 ((SRF_LambertConformalConic)srcSrf).
                                  getSRFParameters());
        }
        source_x = source_generic_coordinate[0];
        source_y = source_generic_coordinate[1];
        source_z = source_generic_coordinate[2];

        if (_toCdetConst1._xl < 0.0)
        {
            source_x = -source_x;
            source_y = -source_y;
        }
        drz      = _toCdetConst1._rho_origin - source_y;
        thet     = Math.atan2(source_x, drz);
        dest_lon = thet / _toCdetConst1._xl +
                   _toCdetConst1._xlonz;

        /* get latitude using inverse power series */

        /* Get r squared  */
        r2    = source_x * source_x + drz * drz;
        tanz2 = Math.pow(r2 / _toCdetConst1._rz2, _toCdetConst1._ex) /
                _toCdetConst1._pz;

        if (e_constants.Eps != 0.0) /* do ellipsoid calculations */
        {
            double sk2, z;

            /* Use Identity to get sin & cos without trig functions */
            t2  = tanz2 * tanz2;
            den = 1.0 + t2;
            cki = 2.0 * tanz2 / den;
            ski = (1.0 -t2) / den;

            sk2 = ski * ski;
            z   = 2.0 * Math.atan(tanz2);
            xki = Const.PI_DIV_2 - z;

            dest_lat = xki + ski * cki *
                       (_toCdetConst1._b1 + sk2 * (_toCdetConst1._b2 + sk2 *
                       (_toCdetConst1._b3 + sk2 * _toCdetConst1._b4)));
        }
        else /* do spherical calculations */
        {
            dest_lat = (Const.PI_DIV_2) - 2  * Math.atan(tanz2);
        }
        dest_lon = Const.fix_longitude(dest_lon);

        dest_generic_coordinate[0] = dest_lon;
        dest_generic_coordinate[1] = dest_lat;
        dest_generic_coordinate[2] = source_z;
    }

/*
 *----------------------------------------------------------------------------
 *
 * FUNCTION: toCdet2
 *
 *----------------------------------------------------------------------------
 */

    // this is for the case where the northern parallel is different
    // from the southern parallel.
    private class ToCdetConst2
    {
        double _b1, _b2, _b3, _b4, _xlonz, _rz, _xl, _ex, _rz2, _p1;

        public ToCdetConst2(OrmData e_constants, SRF_LCC_Params params)
        {
            double c12, c22, ex, latitude_origin, p1, p2, pa2, pa4, pa6, pa8,
                   phiz1, phiz2, pz, rn12, rn22, rz, rz2, s1, s12, s2, s22,
                   sfx, temp, xl;

            /* _xlonz == meridian y-axis */
            phiz1           = params.latitude1;
            phiz2           = params.latitude2;
            _xlonz          = params.origin_longitude; // ???
            latitude_origin = params.origin_latitude;

            pa2  = e_constants.Eps2 / 2.0 + Math.pow(e_constants.Eps2, 2) * 5.0 / 24.0;

            pa2 += Math.pow(e_constants.Eps2, 3) / 12.0 +
                   Math.pow(e_constants.Eps2, 4) * 13.0 / 360.0;

            pa4  = Math.pow(e_constants.Eps2, 2) * 7.0 / 48.0 +
                   Math.pow(e_constants.Eps2, 3) * 29.0 / 240.0;

            pa4 += Math.pow(e_constants.Eps2, 4) * 811.0 / 11520.0;

            pa6  = Math.pow(e_constants.Eps2, 3) * 7.0 / 120.0 +
                   Math.pow(e_constants.Eps2, 4) * 81.0 / 1120.0;

            pa8  = Math.pow(e_constants.Eps2, 4) * 4279.0 / 161280.0;

            _b1 = pa2 *    2.0 + pa4 *   4.0 + pa6 *  6.0 + pa8 * 8.0;
            _b2 = pa4 *   -8.0 - pa6 *  32.0 - pa8 * 80.0;
            _b3 = pa6 *   32.0 + pa8 * 192.0;
            _b4 = pa8 * -128.0;

            sfx = Math.sin(latitude_origin);
            s1  = Math.sin(phiz1);
            s2  = Math.sin(phiz2);
            s12 = s1 * s1;
            c12 = 1.0 - s12;
            s22 = s2 * s2;
            c22 = 1.0 - s22;

            pz = Math.tan(Const.PI_DIV_4 + .5 * latitude_origin);

            p1 = Math.tan(Const.PI_DIV_4 + .5 * phiz1);
            p2 = Math.tan(Const.PI_DIV_4 + .5 * phiz2);

            if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
            {
                pz = pz *Math.pow((1.0 - e_constants.Eps * sfx) /
                                  (e_constants.Eps * sfx + 1.0), e_constants.EpsH);

                p1 = p1 * Math.pow((1.0 - e_constants.Eps * s1) /
                                   (e_constants.Eps * s1 + 1.0), e_constants.EpsH);

                p2 = p2 * Math.pow((1.0 - e_constants.Eps * s2) /
                                   (e_constants.Eps * s2 + 1.0), e_constants.EpsH);

                rn12 = e_constants.A2 / (1.0 - e_constants.Eps2 * s12);
                rn22 = e_constants.A2 / (1.0 - e_constants.Eps2 * s22);

                temp = p2 / p1;

                xl  = 0.5 * Math.log((rn12 * c12) / (c22 * rn22)) / Math.log(temp);
            }
            else /* compute spherical values */
            {
                temp = p2 / p1;
                rn12 = e_constants.A2;
                xl   = 0.5 * Math.log(c12/c22)/Math.log(temp);
            }
            rz2 = rn12 * c12 / (xl*xl);

            rz  = Math.sqrt(rz2) * Math.pow(p1/pz,xl);

            ex  = 1.0 / (xl+xl);

            _rz  = rz;
            _xl  = xl;
            _ex  = ex;
            _rz2 = rz2;
            _p1  = p1;
        }
    }


    protected void toCdet2(BaseSRF  srcSrf,
                           BaseSRF  destSrf,
                           double[] source_generic_coordinate,
                           double[] dest_generic_coordinate) throws SrmException
    {
        OrmData e_constants = this.getOrmData();

        double dest_lat, dest_lon, source_x, source_y, source_z;
        double drz, r2, tanz2, thet;

        if (_toCdetConst2 == null)
            _toCdetConst2 = new ToCdetConst2(e_constants,
                                             ((SRF_LambertConformalConic)srcSrf).getSRFParameters());

        source_x = source_generic_coordinate[0];
        source_y = source_generic_coordinate[1];
        source_z = source_generic_coordinate[2];

       /*
        * LATITUDE FIRST USING INVERSE POWER SERIES
        */
        if (_toCdetConst2._xl < 0.0)
        {
            source_x = -source_x;
            source_y = -source_y;
        }
        drz = _toCdetConst2._rz - source_y;

       /* Get r2 */
        r2    = (source_x * source_x) + (drz * drz);

        tanz2 = Math.pow(r2/_toCdetConst2._rz2, _toCdetConst2._ex)/
                _toCdetConst2._p1;

        if (e_constants.Eps != 0.0) /* compute ellipsoidal values */
        {
            double cki, den, sk2, ski, t2, xki, z;

            /*
             * Use Identity to get sin & cos without trig functions
             */
            t2  = tanz2 * tanz2;
            den = 1.0 + t2;
            cki = 2.0 * tanz2 / den;
            ski = (1.0 - t2) / den;
            /* Sin and Cos of xki now done */

            /* Use inverse power series for latitude */
            sk2 = ski * ski;
            z   = 2.0 * Math.atan(tanz2);
            xki = Const.PI_DIV_2 - z;

            dest_lat = xki +
                       ski * cki * (_toCdetConst2._b1 + sk2 *
                      (_toCdetConst2._b2 + sk2 *
                       (_toCdetConst2._b3 + sk2 *
                        _toCdetConst2._b4)));
        }
        else /* compute spherical values */
        {
            dest_lat = Const.PI_DIV_2 - 2.0* Math.atan(tanz2);
        }
        thet = Math.atan2(source_x, drz);

        dest_lon = thet/_toCdetConst2._xl + _toCdetConst2._xlonz;

        dest_lon = Const.fix_longitude(dest_lon);

        dest_generic_coordinate[0] = dest_lon;
        dest_generic_coordinate[1] = dest_lat;
        dest_generic_coordinate[2] = source_z;
    }
}
