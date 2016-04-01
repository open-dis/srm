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

abstract class CoordCheck
{
    // table of reference template SRFs associated with the SRF (standard)
    private static SRM_SRFT_Code[] srfStdBoundaryDefTemplate =
    {
        SRM_SRFT_Code.SRFTCOD_UNSPECIFIED, // UNSPECIFIED,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // BRITISH_NATIONAL_GRID = 1;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // DELAWARE_SPCS_1983 = 2;
        SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC, // GEOCENTRIC_DATUM_AUSTRALIA_1994 = 3;
        SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC, // GEOCENTRIC_WGS_1984 = 4;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // GEODETIC_AUSTRALIA_1984 = 5;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // GEODETIC_EUROPE_1950 = 6;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // GEODETIC_N_AMERICAN_1983 = 7;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // GEODETIC_WGS_1984 = 8;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // IRISH_GRID_1965 = 9;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // IRISH_TRANSVERSE_MERCATOR_1989 = 10;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // LAMBERT_1993 = 11;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // LAMBERT_II_WIDE = 12;
        SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC, // MARS_PLANETOCENTRIC_2000 = 13;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC, // MARS_PLANETOGRAPHIC_2000 = 14;
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC // MARYLAND_SPCS_1983 = 15;
    };

    // table of reference template SRFs associated with the SRF sets
    // Notice they all have boundaries defined in CD_3D SRF.
    private static SRM_SRFT_Code[] srfsBoundaryDefTemplate =
    {
        SRM_SRFT_Code.SRFTCOD_UNSPECIFIED,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC
    };

    // table of reference template SRFs associated with the SRF templates
    // Notice that only the Projection based SRFs have their boundary SRFs
    // different from their own SRFs
    private static SRM_SRFT_Code[] srftBoundaryDefTemplate =
    {
        SRM_SRFT_Code.SRFTCOD_UNSPECIFIED,
        SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC,
        SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_3D,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_PLANETODETIC,
        SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN,
        SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL,
        SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL,
        SRM_SRFT_Code.SRFTCOD_LOCOCENTRIC_EUCLIDEAN_3D,
        SRM_SRFT_Code.SRFTCOD_CELESTIOMAGNETIC,
        SRM_SRFT_Code.SRFTCOD_EQUATORIAL_INERTIAL,
        SRM_SRFT_Code.SRFTCOD_SOLAR_ECLIPTIC,
        SRM_SRFT_Code.SRFTCOD_SOLAR_EQUATORIAL,
        SRM_SRFT_Code.SRFTCOD_SOLAR_MAGNETIC_ECLIPTIC,
        SRM_SRFT_Code.SRFTCOD_SOLAR_MAGNETIC_DIPOLE,
        SRM_SRFT_Code.SRFTCOD_HELIOSPHERIC_ARIES_ECLIPTIC,
        SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_ECLIPTIC,
        SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_EQUATORIAL,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_CELESTIODETIC,
        SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_2D,
        SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_AZIMUTHAL_2D,
        SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_POLAR_2D
    };

    protected static SRM_SRFT_Code getsrfsBoundaryDefTemplate
    (
        SRM_SRFS_Code srfs_code
    )
    {
        return srfsBoundaryDefTemplate[ srfs_code.toInt() ];
    }

    protected static SRM_SRFT_Code getsrfBoundaryDefTemplate
    (
        BaseSRF srf
    ) throws SrmException
    {
        SRM_SRFT_Code retCode = SRM_SRFT_Code.SRFTCOD_UNSPECIFIED;

        // if it is a SRF Set member
        if (srf.getSRFSetCode() != SRM_SRFS_Code.SRFSCOD_UNSPECIFIED)
        {
            retCode = srfsBoundaryDefTemplate[srf.getSRFSetCode().toInt()];
        }

        // if it is a standard (defined) SRF
        else if (srf.getSRFCode() != SRM_SRF_Code.SRFCOD_UNSPECIFIED)
        {
            retCode = srfStdBoundaryDefTemplate[srf.getSRFCode().toInt()];
        }

        // it is a SRF template instance
        else if (srf.getSRFTemplateCode() != SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
        {
            retCode = srftBoundaryDefTemplate[srf.getSRFTemplateCode().toInt()];
        }
        else
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   new String("Invalid source SRF Code"));

        return retCode;
    }

    // This case does not handle the cases where the angular parameter has
    // the lower bound > upper bound. That's the case where the complement
    // angle must be computed, but there are ranges of valid angles that
    // make this verification tedious and inefficient.
    // $$$ Fix for standard implementation.
    private static SRM_Coordinate_Valid_Region_Code validcoordCheck
    (
        SRM_Extended_Valid_Region_Params region,
        boolean                          region_is_angular,
        double                           v_coord
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code ret_reg = null;

        // If there is no accuracy region, or if the accuracy region has no
        // bounds, then the coordinate is valid for the accuracy region.
        // Otherwise, check that the coordinate is within the bounds
        // specified by the accuracy region.
        if (region == null ||
            region.type == SRM_Interval_Type.IVLTYP_UNBOUNDED)
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else if (region.type == SRM_Interval_Type.IVLTYP_OPEN_INTERVAL)
        {
            // case for the complement circle (l->PI and -PI->h)
            if (region_is_angular && region.lower > region.upper)
            {
                if ((v_coord > region.lower && v_coord < Const.PI) ||
                    (v_coord > -Const.PI && v_coord < region.upper))
                {
                    ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
                }
                else if ((v_coord > region.extended_lower &&
                          v_coord < Const.PI) ||
                         (v_coord > -Const.PI &&
                          v_coord < region.extended_upper))
                {
                    ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
                }
                else
                {
                    ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
                }
            }
            else
            {
                if (v_coord > region.lower && v_coord < region.upper)
                {
                    ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
                }
                else if (v_coord > region.extended_lower &&
                         v_coord < region.extended_upper)
                {
                    ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
                }
                else
                {
                    ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
                }
            }
        }
        else if (region.type == SRM_Interval_Type.IVLTYP_CLOSED_INTERVAL)
        {
            // case for the complement circle (l->PI and -PI->h)
            if (region_is_angular && region.lower > region.upper)
            {
            }
            else if (v_coord >= region.lower && v_coord <= region.upper)
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else if (v_coord >= region.extended_lower &&
                     v_coord <= region.extended_upper)
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
            }
            else
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
            }
        }
        else if (region.type == SRM_Interval_Type.IVLTYP_GE_LT_INTERVAL ||
                 region.type == SRM_Interval_Type.IVLTYP_GE_SEMI_INTERVAL ||
                 region.type == SRM_Interval_Type.IVLTYP_LT_SEMI_INTERVAL)
        {
            // case for the complement circle (l->PI and -PI->h)
            if (region_is_angular && region.lower > region.upper)
            {
            }
            else if (v_coord >= region.lower && v_coord < region.upper)
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else if (v_coord >= region.extended_lower &&
                     v_coord < region.extended_upper)
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
            }
            else
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
            }
        }
        else if (region.type == SRM_Interval_Type.IVLTYP_GT_LE_INTERVAL ||
                 region.type == SRM_Interval_Type.IVLTYP_GT_SEMI_INTERVAL ||
                 region.type == SRM_Interval_Type.IVLTYP_LE_SEMI_INTERVAL)
        {
            if (region_is_angular)
            {
            }
            else if (v_coord > region.lower && v_coord <= region.upper)
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else if (v_coord > region.extended_lower &&
                     v_coord <= region.extended_upper)
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
            }
            else
            {
                ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
            }
        }

        if (ret_reg == null)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                            new String("Invalid coordinate"));
        else
            return ret_reg;
    }


    private static SRM_Coordinate_Valid_Region_Code validcoord2DCheck
    (
        SRM_Extended_Valid_Region_Params[] region,
        boolean[]                          region_is_angular,
        double[]                           v_coord
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code[] reg = new SRM_Coordinate_Valid_Region_Code[2];
        SRM_Coordinate_Valid_Region_Code ret_reg;

        for (int i=0; i<2; i++)
            reg[i] = validcoordCheck(region[i],
                                     region_is_angular[i],
                                     v_coord[i]);

        if (reg[0]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID &&
            reg[1]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID)
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else if (reg[0]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED ||
                 reg[1]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED)
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
        }
        else
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
        }
        return ret_reg;
    }


    private static SRM_Coordinate_Valid_Region_Code validcoord3DCheck
    (
        SRM_Extended_Valid_Region_Params[] region,
        boolean[]                          region_is_angular,
        double[]                           v_coord
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code[] reg = new SRM_Coordinate_Valid_Region_Code[3];
        SRM_Coordinate_Valid_Region_Code ret_reg;

        for (int i=0; i<3; i++)
            reg[i] = validcoordCheck(region[i],
                                     region_is_angular[i],
                                     v_coord[i]);

        if (reg[0]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID &&
            reg[1]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID &&
            reg[2]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID)
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else if (reg[0]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED ||
                 reg[1]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED ||
                 reg[2]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED)
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
        }
        else
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
        }
        return ret_reg;
    }

    private static SRM_Coordinate_Valid_Region_Code validcoordGDCheck
    (
        SRM_Extended_Valid_Region_Params[] region,
        boolean[]                          region_is_angular,
        double[]                           v_coord
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code[] reg = new SRM_Coordinate_Valid_Region_Code[2];
        SRM_Coordinate_Valid_Region_Code ret_reg;

        for (int i=0; i<2; i++)
            reg[i] = validcoordCheck(region[i],
                                     region_is_angular[i],
                                     v_coord[i]);

        if (reg[0]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID &&
            reg[1]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID)
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else if (reg[0]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED ||
                 reg[1]==SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED)
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
        }
        else
        {
            ret_reg = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
        }
        return ret_reg;
    }

    // check for NaN
    protected static SRM_Coordinate_Valid_Region_Code
        forNaN_2D
    (
        double[] coord
    ) throws SrmException
    {
        double nan_test_value = coord[0]*coord[1];

        // this catches the cases where any of coord is NaN
        if (Double.isNaN(nan_test_value))
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Invalid (not well formed) coordinate - NaN"));
        else
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
    }

    // check for NaN
    protected static SRM_Coordinate_Valid_Region_Code
        forNaN_3D
    (
        double[] coord
    ) throws SrmException
    {
        double nan_test_value = coord[0]*coord[1]*coord[2];

        // this catches the cases where any of coord is NaN
        if (Double.isNaN(nan_test_value))
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Invalid (not well formed) coordinate - NaN"));
        else
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
    }

    // for LSR_3D
    protected static SRM_Coordinate_Valid_Region_Code
        forLsr3d(double[] coord) throws SrmException
    {
        //   u=coord[0];
        //   v=coord[1];
        //   w=coord[2];

        if (Math.abs(coord[0]) + Math.abs(coord[1]) + Math.abs(coord[2]) > Const.EPSILON)
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        else
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Invalid LSR 3D coordinate"));
    }

    // for LSR_2D
    /** This routine is called to validate an LSR_2D coordinate
        when it is about to be used for an operation that can't
        accept (0, 0) as input. An exception will be thrown if
        either piece of coord is NaN, or if coord is too close to
        (0, 0).
     */
    protected static SRM_Coordinate_Valid_Region_Code
        forLsr2d
    (
        double[] coord
    ) throws SrmException
    {
        // u=coord[0];
        // v=coord[1];

        if (Math.abs(coord[0]) + Math.abs(coord[1]) > Const.EPSILON)
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        else
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Invalid LSR 2D coordinate"));
    }

    /** This routine is called to validate a celestiodetic surface coordinate
        when it is used as part of some SRF parameters.
     */
    protected static boolean
    forCelestiodeticSurface
    (
        double longitude,
        double geodetic_latitude
    )
    {
        // In addition to (longitude,geodetic_latitude) pairs that
        // pass the well-formed tests, accept (0, +/- Const.PI_DIV_2)
        if ((Const.isWellFormedLongitude(longitude)&&
             Const.isWellFormedLatitude(geodetic_latitude))
          || ((longitude == 0.0) &&
              ((geodetic_latitude == -Const.PI_DIV_2)
            || (geodetic_latitude ==  Const.PI_DIV_2))))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // forCelestiodetic
    //
    // This routine is called by some of the map projections. As long as we
    // need only the OrmData we can get away with that. If ever we need to
    // access parameters that are specific to the SRF, then we will need to
    // do something more sophisticated.
    protected static SRM_Coordinate_Valid_Region_Code
        forCelestiodetic(OrmData ormData, double[] coord) throws SrmException
    {
        // longitude          = coord[0]
        // geodetic_latitude  = coord[1]
        // ellipsoidal_height = coord[2]

        // In addition to (longitude,geodetic_latitude) pairs that
        // pass the well-formed tests, accept (0, +/- SRM_PI_DIV_2)
        if (((Const.isWellFormedLongitude(coord[0]) &&
              Const.isWellFormedLatitude(coord[1]))
          || ((coord[0] == 0.0) &&
              ((coord[1] == -Const.PI_DIV_2)
            || (coord[1] ==  Const.PI_DIV_2))))
         && (coord[2] > -ormData.B) &&
            Const.isWellFormedHeight(coord[2]))
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else
           throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid Celestiodetic coordinate"));
    }

    // forPlanetodetic
    protected static SRM_Coordinate_Valid_Region_Code
        forPlanetodetic
    (
        OrmData  ormData,
        double[] coord
    ) throws SrmException
    {
        // geodetic_latitude  = coord[0]
        // longitude          = coord[1]
        // ellipsoidal_height = coord[2]

        // In addition to (geodetic_latitude,longitude) pairs that
        // pass the well-formed tests, accept (+/- SRM_PI_DIV_2, 0)
        if (((Const.isWellFormedLongitude(coord[1]) &&
              Const.isWellFormedLatitude(coord[0]))
          || ((coord[1] == 0.0) &&
              ((coord[0] == -Const.PI_DIV_2)
            || (coord[0] ==  Const.PI_DIV_2))))
         && (coord[2] > -ormData.B) &&
            Const.isWellFormedHeight(coord[2]))
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else
           throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid Planetodetic coordinate"));
    }

    protected static SRM_Coordinate_Valid_Region_Code
    forLocalSpaceAzimuthal2D
    (
        double[] coord
    ) throws SrmException
    {
        if ((Const.isWellFormedAzimuth(coord[0]) &&
             Const.isWellFormedRadius(coord[1]))
         || ((coord[0] == 0.0) && (coord[1] == 0.0)))
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                      new String("Invalid Local Space Azimuthal coordinate"));
        }
    }

    // forLocalSpacePolar
    protected static SRM_Coordinate_Valid_Region_Code
        forLocalSpacePolar
    (
        double[] coord
    ) throws SrmException
    {
        if ((Const.isWellFormedAzimuth(coord[0]) &&
             Const.isWellFormedRadius(coord[1]))
         || ((coord[0] == 0.0) && (coord[1] == 0.0)))
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                               new String("Invalid Local Space Polar coordinate"));
    }

    // forMercator (using Celestiodetic)
    protected static SRM_Coordinate_Valid_Region_Code
        forMercator_cd(OrmData ormData, double[] coord) throws SrmException
    {
        return forCelestiodetic(ormData, coord);
    }

    // forTransverseMercator
    //
    // Note that this routine receives a Transverse Mercator SRF but a
    // coordinate that is celestiodetic, since validation for Mercator
    // is performed in a celestiodetic SRF.
    protected static SRM_Coordinate_Valid_Region_Code
        forTransverseMercator_cd
    (
        OrmData       ormData,
        SRF_TM_Params params,
        double[]      coord
    ) throws SrmException
    {
        /* This ensures the the coordinate that we got is actually a good
           celestiodetic
         */
        forCelestiodetic(ormData, coord);

        if ((Const.delta_lambda_min(coord[0], params.origin_longitude) <=
             (4.0 * Const.RADIANS_PER_DEGREE + Const.EPSILON)) &&
            (coord[1] <=  84.5 * Const.RADIANS_PER_DEGREE + Const.EPSILON) &&
            (coord[1] >= -80.5 * Const.RADIANS_PER_DEGREE + Const.EPSILON))
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else if ((Const.delta_lambda_min(coord[0], params.origin_longitude) <=
                  (12.0 * Const.RADIANS_PER_DEGREE) + 1.0e-5) &&
                 (coord[1] <=  89.99 * Const.RADIANS_PER_DEGREE + 1.0e-5) &&
                 (coord[1] >= -89.99 * Const.RADIANS_PER_DEGREE + 1.0e-5))
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
        }
        throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                               new String("Invalid coordinate"));
    }


    // forLCC  (using Celestiodetic)
    protected static SRM_Coordinate_Valid_Region_Code
        forLCC_cd(OrmData ormData, double[] coord) throws SrmException
    {
        return forCelestiodetic(ormData, coord);
    }


    // forPolarStereographic
    protected static SRM_Coordinate_Valid_Region_Code
        forPolarStereographic_cd
    (
        SRF_PS_Params params,
        double[]      coord
    ) throws SrmException
    {
        // geodetic_longitude=coord[0];
        // geodetic_latitude=coord[1];
        // ellipsoidal_height=coord[2];

        if (params.polar_aspect == SRM_Polar_Aspect.PLRASP_NORTH)
        {
            if ((coord[1] >= 0.0       && coord[1] <= Const.PI_DIV_2 &&
                 coord[0] >  -Const.PI && coord[0] <= Const.PI)
             || (coord[1] == Const.PI_DIV_2 &&
                 coord[0] == 0.0))
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else
            {
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
            }
        }
        else // SOUTH
        {
            if ((coord[1] >= -Const.PI_DIV_2 && coord[1] <= 0.0 &&
                 coord[0] >  -Const.PI       && coord[0] <= Const.PI)
             || (coord[1] == -Const.PI_DIV_2 &&
                 coord[0] == 0.0))
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else
            {
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
            }
        }
    }


    // forEquidistantCylindrical (using Celestiodetic)
    protected static SRM_Coordinate_Valid_Region_Code
        forEquidistantCylindrical_cd
    (
        OrmData  ormData,
        double[] coord
    ) throws SrmException
    {
        return forCelestiodetic(ormData, coord);
    }


    // forSpherical
    protected static SRM_Coordinate_Valid_Region_Code
        forSpherical(double[] coord) throws SrmException
    {
        //   spherical_longitude=coord[0];
        //   spherical_latitude=coord[1];
        //   radius=coord[2];

        // three cases
        // 1) well formed spherical_longitude, spherical_latitude,,
        //    and radius
        // 2) spherical_longitude == 0.0, with a spherical_latitude
        //    of + or - SRM_PI_DIV_2, and well formed radius
        // 3) (0,0,0)
        if ((((Const.isWellFormedLongitude(coord[0]) &&
               Const.isWellFormedLatitude(coord[1]))
          || ((coord[0] == 0.0) &&
              ((coord[1] == -Const.PI_DIV_2) ||
               (coord[1] ==  Const.PI_DIV_2))))
         && Const.isWellFormedRadius(coord[2]))
         || ((coord[0] == 0.0) &&
             (coord[1] == 0.0) &&
             (coord[2] == 0.0)))
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        else
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Invalid coordinate"));
    }


    // forAzSpher
    protected static SRM_Coordinate_Valid_Region_Code
        forAzSpherical(double[] coord) throws SrmException
    {
        //  azimuth =coord[0];
        //  elevation_angle =coord[1];
        //  radius =coord[2];

        // three cases
        // 1) well formed azimuth, elevation_angle,
        //    and radius
        // 2) azimuth == 0.0, with an elevation_angle
        //    of + or - SRM_PI_DIV_2, and well formed radius
        // 3) (0,0,0)
        if ((((Const.isWellFormedAzimuth(coord[0]) &&
               Const.isWellFormedLatitude(coord[1]))
          || ((coord[0] == 0.0) &&
              ((coord[1] == -Const.PI_DIV_2) ||
               (coord[1] ==  Const.PI_DIV_2))))
          && Const.isWellFormedRadius(coord[2]))
          || ((coord[0] == 0.0) &&
              (coord[1] == 0.0) &&
              (coord[2] == 0.0)))
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        else
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Invalid coordinate"));
    }


    // forCylindrical
    protected static SRM_Coordinate_Valid_Region_Code
        forCylindrical(double[] coord) throws SrmException
    {
        // cylindrical_angle_theta = coord[0];
        // radius_rho              = coord[1];
        // height_zeta             = coord[2];

        if ((Const.isWellFormedAzimuth(coord[0]) &&
             Const.isWellFormedRadius(coord[1]))
        || ((coord[0] == 0.0) && (coord[1] == 0.0)))
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        else
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Invalid coordinate"));
    }

    //
    // For SRF Sets
    //

    // forALSP
    protected static SRM_Coordinate_Valid_Region_Code
        forALSP_cd
    (
        OrmData       ormData,
        SRF_TM_Params params,
        double[]      coord
    ) throws SrmException
    {
        // this validation is based on TM_AUGMENTED_3D validation
        return forTransverseMercator_cd(ormData, params, coord);
    }

    // forGTRS
    protected static SRM_Coordinate_Valid_Region_Code
        forGTRS(double[] coord) throws SrmException
    {
        /* This is the version that is used in conversions where it is not on
           the path to check the validity
        */
        return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
    }


    /** This uses code inside the GTRS library to look up the validity
        of a GCS coordinate.  It takes the cellid and the WGS84
        Celestiodetic coordinates of a point
    */
    protected static SRM_Coordinate_Valid_Region_Code
        forGTRS_cd
    (
        SRM_SRFSM_Code srfSetMemberCode,
        double[]       coord
    ) throws SrmException
    {
        double GtrsCellOriginLat = 0.0;

        GtrsDataSet tmpGtrsElem = GtrsDataSet.getElem(srfSetMemberCode.toInt());

        GtrsCellOriginLat = GtrsDataSet.getCellOrigLat(tmpGtrsElem);

        if ((coord[0] >= GtrsDataSet.getCellOrigLonMinExtent
                                     (srfSetMemberCode.toInt(), tmpGtrsElem))
         && (coord[0] <= GtrsDataSet.getCellOrigLonMaxExtent
                                     (srfSetMemberCode.toInt(), tmpGtrsElem))
         && (coord[1] >= (GtrsCellOriginLat - (0.5 * Const.RADIANS_PER_DEGREE)))
         && (coord[1] <= (GtrsCellOriginLat + (0.5 * Const.RADIANS_PER_DEGREE))))
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else
        {
            return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;
        }
    }


    // forUPS
    protected static SRM_Coordinate_Valid_Region_Code
        forUPS_cd
    (
        SRF_PS_Params params,
        double[]      coord
    ) throws SrmException
    {
        /*!\note that this routine receives a transverse mercator SRF but a
          coordinate that is celestiodetic since validation for mercator is
          performed in a celestiodetic SRF*/

        // geodetic_longitude = coord[0];
        // geodetic_latitude  = coord[1];
        // ellipsoidal_height = coord[2];

        if (params.polar_aspect == SRM_Polar_Aspect.PLRASP_NORTH)
        {
            if (coord[1] >= 84.0 * Const.RADIANS_PER_DEGREE)
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else if (coord[1] >= 83.5 * Const.RADIANS_PER_DEGREE)
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
            }
            else
            {
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
            }
        }
        else  //SRM_Polar_Aspect.PLRASP_SOUTH
        {
            if (coord[1] <= -80.0 * Const.RADIANS_PER_DEGREE)
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else if (coord[1] <= -79.5 * Const.RADIANS_PER_DEGREE)
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
            }
            else
            {
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
            }
        }
    }


    // forUTM
    protected static SRM_Coordinate_Valid_Region_Code
        forUTM_cd
    (
        OrmData            ormData,
        SRF_TM_Params      params,
        SRM_SRFSM_UTM_Code srfSetMemberCode,
        double[]           coord
    ) throws SrmException
    {
        /*!\note that this routine receives a transverse mercator SRF but a
          coordinate that is celestiodetic since validation for mercator is
          performed in a celestiodetic SRF*/

        // geodetic_longitude = coord[0];
        // geodetic_latitude  = coord[1];
        // ellipsoidal_height = coord[2];
        /* This ensures the the coordinate that we got is actually a good
           celestiodetic
         */
        forCelestiodetic(ormData, coord);

        double dlm = Const.delta_lambda_min(coord[0], params.origin_longitude);

        if (srfSetMemberCode.toInt() <= 60)  // zones 1 through 60
        {
            if(
               (dlm <= (3.0 * Const.RADIANS_PER_DEGREE))&&
               (coord[1] <  84.0 * Const.RADIANS_PER_DEGREE)&&
               (coord[1] >= 0.0 * Const.RADIANS_PER_DEGREE)
              )
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else if(
                    (dlm <= (6.0*Const.RADIANS_PER_DEGREE))&&
                    (coord[1] <  84.5 * Const.RADIANS_PER_DEGREE)&&
                    (coord[1] >= -0.5 * Const.RADIANS_PER_DEGREE)
                   )
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
            }
            else
            {
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                        new String("Invalid coordinate"));
            }
        }
        else // > 60 and <= 120
        {
            if(
               (dlm <= (3.0*Const.RADIANS_PER_DEGREE))&&
               (coord[1] <    0.0 * Const.RADIANS_PER_DEGREE)&&
               (coord[1] >= -80.0 * Const.RADIANS_PER_DEGREE)
              )
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            }
            else if(
                    (dlm <= (6.0*Const.RADIANS_PER_DEGREE))&&
                    (coord[1] <    0.5 * Const.RADIANS_PER_DEGREE)&&
                    (coord[1] >= -80.5 * Const.RADIANS_PER_DEGREE)
                    )
            {
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID;
            }
            else
            {
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
            }
        }
    }

    // forWISP
    protected static SRM_Coordinate_Valid_Region_Code
        forWISP_cd(OrmData ormData, double[] coord) throws SrmException
    {
        // this validation is based on LCC_AUGMENTED_3D, which is based on
        // the celestiodetic validation
        return forLCC_cd(ormData, coord);
    }

    // forLNTF
    protected static SRM_Coordinate_Valid_Region_Code
        forLNTF_cd
    (
        OrmData                    ormData,
        SRM_SRFSM_Lambert_NTF_Code member,
        double[]                   coord
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid = null;

        if (member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_I)
        {
            if ((coord[0] >= -5.0*Const.RADIANS_PER_DEGREE)&&
                (coord[0] <= 10.0*Const.RADIANS_PER_DEGREE)&&
                (coord[1] >= 53.5*Const.RADIANS_PER_DEGREE)&&
                (coord[1] <  57.0*Const.RADIANS_PER_DEGREE))
                retValid = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            else
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
        }
        else if (member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_II)
        {
            if ((coord[0] >= -5.0*Const.RADIANS_PER_DEGREE)&&
                (coord[0] <= 10.0*Const.RADIANS_PER_DEGREE)&&
                (coord[1] >= 50.5*Const.RADIANS_PER_DEGREE)&&
                (coord[1] <  53.5*Const.RADIANS_PER_DEGREE))
                retValid = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            else
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
        }
        else if (member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_III)
        {
            if ((coord[0] >= -5.0*Const.RADIANS_PER_DEGREE)&&
                (coord[0] <= 10.0*Const.RADIANS_PER_DEGREE)&&
                (coord[1] >= 47.0*Const.RADIANS_PER_DEGREE)&&
                (coord[1] <  50.5*Const.RADIANS_PER_DEGREE))
                retValid = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            else
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
        }
        else if (member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_IV)
        {
            if ((coord[0] >=  8.0*Const.RADIANS_PER_DEGREE)&&
                (coord[0] <= 10.0*Const.RADIANS_PER_DEGREE)&&
                (coord[1] >= 41.0*Const.RADIANS_PER_DEGREE)&&
                (coord[1] <  43.5*Const.RADIANS_PER_DEGREE))
                retValid = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
            else
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                       new String("Invalid coordinate"));
        }
        else
            throw new SrmException(SrmException._INACTIONABLE,
                                   new String("Error in LNTF validation - illegal member=> " + member));

        return retValid;
    }

    // forJapan_cd
    protected static SRM_Coordinate_Valid_Region_Code
        forJapan_cd
    (
        OrmData                                   ormData,
        SRM_SRFSM_Japan_Rectangular_Plane_CS_Code member,
        SRF_TM_Params                             params,
        double[]                                  coord
    ) throws SrmException
    {
        // this validation is based on TM_AUGMENTED_3D, which is based on
        // the celestiodetic validation
        SRM_Coordinate_Valid_Region_Code status;

        switch (member.toInt())
        {
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_I:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_II:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_III:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_IV:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_V:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_VI:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_VII:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_VIII:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_IX:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_X:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XI:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XII:
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XIII:
                 // make this more specific as the zone information is
                 // made more quantitative
                 status = forTransverseMercator_cd(ormData, params, coord);
                 break;
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XIV:
                 if (((coord[0] > 140.5*Const.RADIANS_PER_DEGREE) &&
                      (coord[0] < 143.0*Const.RADIANS_PER_DEGREE)) &&
                      (coord[1] < 28.0*Const.RADIANS_PER_DEGREE))
                 {
                     status = forTransverseMercator_cd(ormData, params, coord);
                 }
                 else
                 {
                     throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid coordinate - out of valid"
                                           + " range for zone"));
                 }
                 break;
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XV:
                 if ((coord[0] > 126.0*Const.RADIANS_PER_DEGREE) &&
                     (coord[0] < 130.0*Const.RADIANS_PER_DEGREE))
                 {
                     status = forTransverseMercator_cd(ormData, params, coord);
                 }
                 else
                 {
                     throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid coordinate - out of valid"
                                           + " range for zone"));
                 }
                 break;
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XVI:
                 if (coord[0] > 126.0*Const.RADIANS_PER_DEGREE)
                 {
                     status = forTransverseMercator_cd(ormData, params, coord);
                 }
                 else
                 {
                     throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid coordinate - out of valid"
                                           + " range for zone"));
                 }
                 break;
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XVII:
                 if (coord[0] > 130.0*Const.RADIANS_PER_DEGREE)
                 {
                     status = forTransverseMercator_cd(ormData, params, coord);
                 }
                 else
                 {
                     throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid coordinate - out of valid"
                                           + " range for zone"));
                 }
                 break;
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XVIII:
                 if ((coord[0] > 140.5*Const.RADIANS_PER_DEGREE)
                  && (coord[1] < 28.0*Const.RADIANS_PER_DEGREE))
                 {
                     status = forTransverseMercator_cd(ormData, params, coord);
                 }
                 else
                 {
                     throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid coordinate - out of valid"
                                           + " range for zone"));
                 }
                 break;
            case SRM_SRFSM_Japan_Rectangular_Plane_CS_Code._SRFSMJPRPCSCOD_ZONE_XIX:
                 if ((coord[0] > 143.0*Const.RADIANS_PER_DEGREE)
                  && (coord[1] < 28.0*Const.RADIANS_PER_DEGREE))
                 {
                     status = forTransverseMercator_cd(ormData, params, coord);
                 }
                 else
                 {
                     throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                  new String("Invalid coordinate - out of valid"
                                           + " range for zone"));
                 }
                 break;
            default:
                 throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                        new String("Invalid zone"));
        }
        return status;
    }

    // for TM_AUGMENTED_3D native
    protected static SRM_Coordinate_Valid_Region_Code
        forTransverseMercator_native
    (
        double   m,
        double   bl,
        double   x_threshold,
        double   y_threshold,
        double[] coord
    ) throws SrmException
    {
        if (coord[1] > y_threshold)
        {
            if ((coord[1] > (m * -Math.abs(coord[0])+bl)))
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                             new String("Invalid coordinate - northing greater"
                                      + " than threshold"));
            else
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else if (coord[1] < -y_threshold)
        {
            if (coord[1] < (-m * -Math.abs(coord[0]) - bl))
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                             new String("Invalid coordinate - northing less"
                                      + " than threshold"));
            else
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
        else
        {
            if (Math.abs(coord[0]) > x_threshold)
                throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                             new String("Invalid coordinate - easting greater"
                                      + " than threshold"));
            else
                return SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        }
    }
}
