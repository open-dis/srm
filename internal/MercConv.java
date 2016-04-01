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

class MercConv extends Conversions
{
    private ToCdetConst _toCdetConst;

    public MercConv() {
        super(SRM_SRFT_Code.SRFTCOD_MERCATOR,
              new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
                                   SRM_SRFT_Code.SRFTCOD_UNSPECIFIED});
    }

    protected Conversions makeClone() {
        return (Conversions) new MercConv();
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
            src[0] -= ((SRF_Mercator)srcSrf).get_false_easting();
            src[1] -= ((SRF_Mercator)srcSrf).get_false_northing();
            toCdet(srcSrf, destSrf, src, dest);
            // perform post validation
            retValid = CoordCheck.forCelestiodetic(this.getOrmData(), dest);
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            // Just pass the coordinate through.
            // This is the last conversion in the chain
            dest[0] = src[0];
            dest[1] = src[1];
            dest[2] = src[2];
        }
        return retValid;
    }

/*
 *----------------------------------------------------------------------------
 *
 * To Cdet functions
 *
 *----------------------------------------------------------------------------
 */

    private class ToCdetConst
    {
        double b1, b2, b3, b4,
            longitude_origin,
            geodetic_latitude,
            scale_inv;

        public ToCdetConst(OrmData e_constants, SRF_M_Params params)
        {
            double pa2, pa4, pa6, pa8;

            longitude_origin  = params.origin_longitude;
            scale_inv         = 1.0 / params.central_scale;

            /*
             * NOTE: There are no spherical constants, so we save a second by
             *       not computing the ellipsoid constants needlessly.
             *       -- Dan Toms
             */
            if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
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

                b1 = pa2 *    2.0 + pa4 *   4.0 + pa6 *  6.0 + pa8 * 8.0;
                b2 = pa4 *   -8.0 - pa6 *  32.0 - pa8 * 80.0;
                b3 = pa6 *   32.0 + pa8 * 192.0;
                b4 = pa8 * -128.0;
            }
        }
    }


    protected void toCdet
    (
        BaseSRF  srcSrf,
        BaseSRF  destSrf,
        double[] source_generic_coordinate,
        double[] dest_generic_coordinate
    ) throws SrmException
    {
        OrmData e_constants = this.getOrmData();

        if (_toCdetConst == null)
        {
            _toCdetConst = new ToCdetConst
                               (e_constants,
                                ((SRF_Mercator)srcSrf).getSRFParameters());
        }
        double dest_lat, dest_lon;
        double source_x, source_y, source_z;
        double tanz2, z;

        source_x = source_generic_coordinate[0] * _toCdetConst.scale_inv;
        source_y = source_generic_coordinate[1] * _toCdetConst.scale_inv;
        source_z = source_generic_coordinate[2];

        /* COMPUTE LONGITUDE */
        dest_lon = source_x *
                   e_constants.A_inv +
                   _toCdetConst.longitude_origin;

        tanz2 = Math.exp(- source_y * e_constants.A_inv );
        z     = 2.0 * Math.atan(tanz2);

        if (e_constants.Eps!=0.0) /* compute ellipsoidal values */
        {
            double cki, den_inv, sk2, ski, t2, xki;

            /* Compute ellipsoidal latitude */

            /*
             * Use identity to get SIN and COS of xki without trig
             * functions
             */
            t2  = tanz2 * tanz2;
            den_inv = 1.0 / (1.0 + t2);
            cki = 2.0 * tanz2 * den_inv;
            ski = (1.0 - t2) * den_inv;

            /* Use inverse power series for latitude */
            sk2 = ski * ski;

            xki = Const.PI_DIV_2 - z;

            dest_lat = xki + ski * cki * (_toCdetConst.b1 + sk2 *
                       (_toCdetConst.b2 + sk2 *
                       (_toCdetConst.b3 + sk2 * _toCdetConst.b4)));
        }
        else /* compute spherical latitude */
            dest_lat = Const.PI_DIV_2 - z;

        dest_lon = Const.fix_longitude(dest_lon);

        dest_generic_coordinate[0] = dest_lon;
        dest_generic_coordinate[1] = dest_lat;
        dest_generic_coordinate[2] = source_z;
    }
}
