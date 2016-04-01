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

class EqcyConv extends Conversions
{
    private ToCdetConst _toCdetConst = null;

    protected EqcyConv()
    {
        // setting the source and destinations of this conversion object
        super (SRM_SRFT_Code.SRFTCOD_EQUIDISTANT_CYLINDRICAL,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
                                    SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone()
    {
        return (Conversions) new EqcyConv();
    }

/*
 *----------------------------------------------------------------------------
 *
 * Conversion dispatcher
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
            src[0] -= ((SRF_EquidistantCylindrical)srcSrf).get_false_easting();
            src[1] -= ((SRF_EquidistantCylindrical)srcSrf).get_false_northing();

            // apply pre validation - NO RESTRICTIONS

            // perform conversion
            toCdet(srcSrf, destSrf, src, dest);

            // perform post validation
            retValid = CoordCheck.forEquidistantCylindrical_cd(this.getOrmData(), dest);
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            // just pass the coordinate through. this is the last convesion in
            // the chain
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
     private class ToCdetConst
     {
        double               longitude_origin;
        double               scale_factor_inv;
        double               conap_inv;
        Const.FootPointConst fp;
        Const.ArcLengthConst al;

        public ToCdetConst(OrmData e_constants, SRF_EC_Params params)
        {
            double conap;

            longitude_origin = params.origin_longitude;
            scale_factor_inv=1.0/params.central_scale;

            /*Note that this is the same conap from tm_cd*/
            conap=
                 e_constants.A* (1.0-
                   e_constants.Eps2*
                   (.250+
                    e_constants.Eps2*
                    (.0468750+
                     e_constants.Eps2* (0.019531250+
                                         0.010681152343750*
                                         e_constants.Eps2))));

            conap_inv=1.0/conap;
            al = new Const.ArcLengthConst(e_constants);
            fp = new Const.FootPointConst(e_constants, al, 1.0);

    // The central scale factor is 1.0 in the latitude coordinate curve by
    // defintion in equidistant cylindrical due to the fact the equidistant
    // implies that the change in y mapp coordiantes is always proportional to
    // the arc length.

        }
     }


    protected void toCdet(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coordinate,
                          double[] dest_generic_coordinate) throws SrmException
    {
        double source_x = 0.0;
        double source_y = 0.0;
        double source_z = 0.0;
        double dest_lat, dest_lon;
        OrmData e_constants = this.getOrmData();
        double lambda_star;

        if (_toCdetConst == null)
            _toCdetConst = new ToCdetConst(e_constants,
                                           ((SRF_EquidistantCylindrical)srcSrf).getSRFParameters());

        source_x = source_generic_coordinate[0];
        source_y = source_generic_coordinate[1];
        source_z = source_generic_coordinate[2];

        double lambda =
            source_x * _toCdetConst.scale_factor_inv * e_constants.A_inv;

        lambda_star = Const.getLambdaStar(lambda, -_toCdetConst.longitude_origin);

        dest_lon = lambda_star;

        if (e_constants.Eps2 != 0.0) // ellipsoidal case
            dest_lat = Const.footPoint(e_constants,
                                       _toCdetConst.al,
                                       _toCdetConst.fp,
                                       source_y * _toCdetConst.conap_inv);
        else // spherical case
            dest_lat = source_y * e_constants.A_inv;

        dest_generic_coordinate[0] = dest_lon;
        dest_generic_coordinate[1] = dest_lat;
        dest_generic_coordinate[2] = source_z;
    }
}
