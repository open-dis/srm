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

class PostConv extends Conversions
{
    private ToCdetConst _toCdetConst = null;

    protected PostConv()
    {
        super(SRM_SRFT_Code.SRFTCOD_POLAR_STEREOGRAPHIC,
              new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
                                   SRM_SRFT_Code.SRFTCOD_UNSPECIFIED});
    }

    protected Conversions makeClone()
    {
        return (Conversions) new PostConv();
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
            src[0] -= ((SRF_PolarStereographic)srcSrf).get_false_easting();
            src[1] -= ((SRF_PolarStereographic)srcSrf).get_false_northing();

            // pre-validation - NO RESTRICTION
            retValid = CoordCheck.forNaN_3D(src);

            // perform conversion
            toCdet(srcSrf, destSrf, src, dest);

            // perform post validation
            // use UPS validation if source SRF is UPS
            if (destSrf.getSRFSetCode() ==
                SRM_SRFS_Code.SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC)
            {
                retValid = CoordCheck.forUPS_cd
                                      (((SRF_PolarStereographic)srcSrf).
                                             getSRFParameters(),
                                       dest);
            }
            else
            {
                retValid = CoordCheck.forPolarStereographic_cd
                                      (((SRF_PolarStereographic)srcSrf).
                                             getSRFParameters(),
                                       dest);
            }
        }
        else if (destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            // Just pass the coordinate through. This is the last conversion in
            // the chain.
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
        double[] b = new double[4];
        double sin_critical_lat;
        double[] cr1 = new double[5];
        double[] cr2 = new double[5];
        double P0, P1;
        double Tc;
        double longitude_origin;
        double scale_inverse;
        double xmc_inv;
        double polar_aspect_constant;
        double FK_inv;

        public ToCdetConst(OrmData e_constants, SRF_PS_Params params) throws SrmException
        {
            Const.init_chi_series(e_constants, b);

            if(e_constants.Eps!=0.0)
                Const.init_power_p_series(e_constants, cr1, cr2);
            else
            {
                for (int i=0;i<5;i++)
                {
                    cr1[i]=Double.NaN;
                    cr2[i]=Double.NaN;
                }
            }
            P0 = Const.power_p( e_constants, 1.0);
            longitude_origin=params.origin_longitude;
            scale_inverse=1.0/params.central_scale;
            polar_aspect_constant=
                            (params.polar_aspect==SRM_Polar_Aspect.PLRASP_NORTH)?1.0:-1.0;

            FK_inv=1.0/(2.0*P0*e_constants.A2*e_constants.B_inv);
        }
    }


    protected void toCdet(BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coordinate,
                          double[] dest_generic_coordinate) throws SrmException
    {
        OrmData e_constants = this.getOrmData();

        if (_toCdetConst == null)
            _toCdetConst = new ToCdetConst(e_constants,
                            ((SRF_PolarStereographic)srcSrf).getSRFParameters());

        double easting=source_generic_coordinate[0],
               northing=source_generic_coordinate[1],
               longitude,
               latitude,
               longitude_origin=_toCdetConst.longitude_origin,
               rho=Math.sqrt(Const.square(easting)+Const.square(northing)),
               tanz2=Double.NaN,
               ski=Double.NaN,
               cki=Double.NaN;

        if ((rho)<(Const.EPSILON))
        {
            /*
               POINT AT POLE
               We know that we are at a pole and forego the remainder
               of the routine except for the setting of the polar
               aspect.
             */
            latitude=Const.PI_DIV_2;
            longitude=longitude_origin;
        }
        else
        {
            /*POINT NOT AT A POLE: do the whole calculation*/

            northing*= _toCdetConst.polar_aspect_constant;
            easting*=_toCdetConst.polar_aspect_constant;
            longitude_origin*=_toCdetConst.polar_aspect_constant;

            if (e_constants.Eps!=0.0)
            {
                /* Critical latitude is near a pole*/
                tanz2=rho*_toCdetConst.scale_inverse*_toCdetConst.FK_inv;
                {
                    /*Get sine and cosine of chi by trig identity from tangent squared*/
                    double T2=tanz2*tanz2;
                    double DEN_INV=1.0/(1.0+T2);
                    cki=2.0*tanz2*DEN_INV;
                    ski=(1.0-T2)*DEN_INV;
                }

                // SIN & COS CHI NOW DONE
                // USE INVERSE POWER SERIES FOR LATITUDE (NO ITERATION)
                {
                    double sk2=ski*ski;
                    double xki=Const.PI_DIV_2-2.0*Math.atan(tanz2);
                    latitude=xki+ski*cki*Const.chi_approx(_toCdetConst.b,sk2);
                }

                //C COMPUTED LATITUDE MAY EXCEED +-PI DUE TO ROUND OFF SO REPAIR IT

                if (latitude>Const.PI_DIV_2)
                {
                    latitude=Const.PI_DIV_2;
                }
                else if (latitude<-Const.PI_DIV_2)
                {
                    latitude=-Const.PI_DIV_2;
                }
            }
            else
            {
                /*Spherical Case (Latitude is different from ellipsoidal case but longitude is the same)*/

                tanz2=rho*(0.5*e_constants.A_inv*_toCdetConst.scale_inverse);
                latitude= Const.PI_DIV_2 - 2.0 * Math.atan(tanz2);
            }

            //C COMPUTE LONGITUDE--MUST USE ATAN2
            longitude=longitude_origin+Math.atan2(easting,-northing);

            //C CHECK TO SEE IF LON IS IN CORRECT INTERVAL

            if (longitude> Const.PI)
            {
                longitude-=Const.TWO_PI;
            }
            else if (longitude< -Const.PI)
            {
                longitude+=Const.TWO_PI;
            }
        }
        latitude *=_toCdetConst.polar_aspect_constant;
        longitude*=_toCdetConst.polar_aspect_constant;

        dest_generic_coordinate[0] = longitude;
        dest_generic_coordinate[1] = latitude;
        dest_generic_coordinate[2] = source_generic_coordinate[2];
    }
}
