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

class SrfCheck
{
    protected static void forCelestiocentric
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                case ORMTCOD_PROLATE_ELLIPSOID:
                case ORMTCOD_TRI_AXIAL_ELLIPSOID:
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                case ORMTCOD_TRI_PLANE:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_Celestiocentric: " +
                                            "Invalid ORM for SRF - not 3D");
            }
        }

        if (orm == SRM_ORM_Code.ORMCOD_ABSTRACT_3D ||
            !Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_Celestiocentric: Invalid ORM/RT pair");
        }
    }

    protected static void forLocalSpaceRectangular3D
    (
        SRM_ORM_Code      orm,
        SRM_RT_Code       rt,
        SRF_LSR_3D_Params params
    ) throws SrmException
    {
        if (orm == SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            Lsr3Conv.compute_F_u_v_w(params);
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LocalSpaceRectangular3D: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forCelestiodetic
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_Celestiodetic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (orm == SRM_ORM_Code.ORMCOD_ABSTRACT_3D ||
            !Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_Celestiodetic: Invalid ORM/RT pair");
        }
    }

    protected static void forPlanetodetic
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_Planetodetic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (orm == SRM_ORM_Code.ORMCOD_ABSTRACT_3D ||
            !Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_Planetodetic: Invalid ORM/RT pair");
        }
    }

    protected static void forLocalTangentSpaceEuclidean
    (
        SRM_ORM_Code    orm,
        SRM_RT_Code     rt,
        SRF_LTSE_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_LocalTangentSpaceEuclidean: "
                                          + "Invalid ORM for SRF");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            if (!CoordCheck.forCelestiodeticSurface(params.geodetic_longitude,
                                                    params.geodetic_latitude) ||
                !Const.isWellFormedAzimuth(params.azimuth))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                             new String("SRF_LocalTangentSpaceEuclidean: " +
                                        "Invalid SRF parameters"));
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LocalTangentSpaceEuclidean: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forLocalTangentSpaceAzimuthalSpherical
    (
        SRM_ORM_Code  orm,
        SRM_RT_Code   rt,
        SRF_LT_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                  "SRF_LocalTangentSpaceAzimuthalSpherical:"
                                + " Invalid ORM for SRF");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            if (!CoordCheck.forCelestiodeticSurface(params.geodetic_longitude,
                                                    params.geodetic_latitude) ||
                !Const.isWellFormedAzimuth(params.azimuth))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                          new String("SRF_LocalTangentSpaceAzimuthalSpherical:"
                                   + " Invalid SRF parameters"));
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                          "SRF_LocalTangentSpaceAzimuthalSpherical: " +
                          "Invalid ORM/RT pair");
        }
    }

    protected static void forLocalTangentSpaceCylindrical
    (
        SRM_ORM_Code  orm,
        SRM_RT_Code   rt,
        SRF_LT_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                  "SRF_LocalTangentSpaceCylindrical: " +
                                  "Invalid ORM for SRF");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            if (!CoordCheck.forCelestiodeticSurface(params.geodetic_longitude,
                                                    params.geodetic_latitude) ||
                !Const.isWellFormedAzimuth(params.azimuth))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                             new String("SRF_LocalTangentSpaceCylindrical: " +
                                        "Invalid SRF parameters"));
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LocalTangentSpaceCylindrical: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forLococentricEuclidean3D
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt,
        double[]     lococentre,
        double[]     primary_axis,
        double[]     secondary_axis
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                case ORMTCOD_PROLATE_ELLIPSOID:
                case ORMTCOD_TRI_AXIAL_ELLIPSOID:
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                case ORMTCOD_TRI_PLANE:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_LococentricEuclidean3D: " +
                                            "Invalid ORM for SRF - not 3D");
            }
        }

        if (Const.isValidOrmRt(orm, rt))
        {
            // verify vector primary_axis and secondary_axis are orthogonal
            // (dot_product(primary_axis, secondary_axis) = 0.0)
            if (! Const.isEqual(Const.vectDotProd(primary_axis, secondary_axis),
                                0.0, Const.EPSILON))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                             "SRF_LococentricEuclidean3D: Vectors primary_axis"
                           + " and secondary_axis are not orthogonal");
            }

            // verify vector primary_axis is normal
            // (dot_product(primary_axis, primary_axis) = 1.0)
            if (! Const.isEqual(Const.vectDotProd(primary_axis, primary_axis),
                                1.0, Const.EPSILON))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                       "SRF_LococentricEuclidean3D: " +
                                       "Vector primary_axis is not normalized");
            }

            // verify vector secondary_axis is normal
            // (dot_product(secondary_axis, secondary_axis) = 1.0)
            if (! Const.isEqual(Const.vectDotProd(secondary_axis,
                   secondary_axis), 1.0, Const.EPSILON))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                             "SRF_LococentricEuclidean3D: " +
                             "Vector secondary_axis is not normalized");
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LococentricEuclidean3D: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forCelestiomagnetic
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_Celestiomagnetic: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_Celestiomagnetic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_Celestiomagnetic: Invalid ORM/RT pair");
    }

    protected static void forEquatorialInertial
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_EquatorialInertial: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_EquatorialInertial: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_EquatorialInertial: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forSolarEcliptic
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_SOLAR_ECLIPTIC)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_SolarEcliptic: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_SolarEcliptic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                    "SRF_SolarEcliptic: Invalid ORM/RT pair");
        }
    }

    protected static void forSolarEquatorial
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_SOLAR_EQUATORIAL)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_SolarEquatorial: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_SolarEquatorial: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_SolarEquatorial: Invalid ORM/RT pair");
        }
    }

    protected static void forSolarMagneticEcliptic
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_SOLAR_MAGNETIC_ECLIPTIC)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_SolarMagneticEcliptic: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_SolarMagneticEcliptic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_SolarMagneticEcliptic: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forSolarMagneticDipole
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_SOLAR_MAGNETIC_DIPOLE)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_SolarMagneticDipole: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_SolarMagneticDipole: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_SolarMagneticDipole: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forHeliosphericAriesEcliptic
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_HELIOCENTRIC_ARIES_ECLIPTIC)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_HeliosphericAriesEcliptic: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_HeliosphericAriesEcliptic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_HeliosphericAriesEcliptic: " +
                                   "Invalid ORM/RT pair");
    }

    protected static void forHeliosphericEarthEcliptic
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_HELIOCENT_PLANET_ECLIPTIC)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_HeliosphericEarthEcliptic: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_HeliosphericEarthEcliptic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_HeliosphericEarthEcliptic: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forHeliosphericEarthEquatorial
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_BI_AXIS_ORIGIN_3D:
                     if (OrmDataSet.getElem(orm)._obrs_code !=
                         SRM_OBRS_Code.OBRSCOD_HELIOCENT_PLANET_EQUATORIAL)
                     {
                         throw new SrmException
                                   (SrmException._INVALID_SOURCE_SRF,
                                    "SRF_HeliosphericEarthEquatorial: " +
                                    "Invalid ORM for SRF");
                     }
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_HeliosphericEarthEquatorial: "
                                          + "Invalid ORM for SRF");
            }
        }

        if (!Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_HeliosphericEarthEquatorial: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forMercator
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt,
        SRF_M_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_Mercator: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            if (!Const.isWellFormedLongitude(params.origin_longitude) ||
                !Const.isWellFormedScale(params.central_scale))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                       "SRF_Mercator: Invalid SRF parameters");
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_Mercator: Invalid ORM/RT pair");
        }
    }

    protected static void forObliqueMercatorSpherical
    (
        SRM_ORM_Code  orm,
        SRM_RT_Code   rt,
        SRF_OM_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_SPHERE_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                  "SRF_ObliqueMercatorSpherical: " +
                                  "Invalid ORM for SRF - must be spherical");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            if (!Const.isWellFormedLongitude(params.longitude1) ||
                !Const.isWellFormedLatitude(params.latitude1) ||
                !Const.isWellFormedLongitude(params.longitude2) ||
                !Const.isWellFormedLatitude(params.latitude2) ||
                !Const.isWellFormedScale(params.central_scale))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                       new String("SRF_ObliqueMercator: " +
                                                  "Invalid SRF parameters"));
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_ObliqueMercatorSpherical: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forTransverseMercator
    (
        SRM_ORM_Code  orm,
        SRM_RT_Code   rt,
        SRF_TM_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_TransverseMercator: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            if (!Const.isWellFormedLongitude(params.origin_longitude) ||
                !Const.isWellFormedLatitude(params.origin_latitude) ||
                !Const.isWellFormedScale(params.central_scale))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                       new String("SRF_TransverseMercator: " +
                                                  "Invalid SRF parameters"));
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_TransverseMercator: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forLambertConformalConic
    (
        SRM_ORM_Code   orm,
        SRM_RT_Code    rt,
        SRF_LCC_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_LambertConformalConic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            // check if using standard parallels or alternate specification
            // for LCC using scale factor
            if (params.latitude2 != 1234.4321)
            {
                // using standard parallels
                if (!Const.isWellFormedLongitude(params.origin_longitude) ||
                    !Const.isWellFormedLatitude(params.latitude1) ||
                    !Const.isWellFormedLatitude(params.latitude2) ||
                    (params.latitude1 == -params.latitude2))
                {
                    throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                           "SRF_LambertConformalConic: " +
                                           "Invalid SRF parameters");
                }
            }
            else
            {
                // using alternate specification for LCC using scale factor
                if (!Const.isWellFormedLongitude(params.origin_longitude) &&
                    ((params.latitude1 <= 0.0) ||
                     (params.latitude1 > 1.0)))
                {
                    throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                           "SRF_LambertConformalConic: " +
                                           "Invalid SRF parameters");
                }
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LambertConformalConic: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forPolarStereographic
    (
        SRM_ORM_Code  orm,
        SRM_RT_Code   rt,
        SRF_PS_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_PolarStereographic: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (orm == SRM_ORM_Code.ORMCOD_ABSTRACT_3D ||
             ! Const.isValidOrmRt(orm, rt))
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                    "SRF_PolarStereographic: " +
                                    "Invalid ORM/RT pair");

        if (!Const.isWellFormedScale(params.central_scale))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                new String("SRF_PolarStereographic: " +
                                           "Invalid central scale"));
        }

        if ((params.polar_aspect != SRM_Polar_Aspect.PLRASP_NORTH) &&
            (params.polar_aspect != SRM_Polar_Aspect.PLRASP_SOUTH))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   new String("SRF_PolarStereographic: " +
                                              "Invalid polar aspect"));
        }
    }

    protected static void forEquidistantCylindrical
    (
        SRM_ORM_Code  orm,
        SRM_RT_Code   rt,
        SRF_EC_Params params
    ) throws SrmException
    {
        if (orm.toInt() > 0)
        {
            switch (OrmDataSet.getElem(orm)._orm_template)
            {
                case ORMTCOD_SPHERE:
                case ORMTCOD_OBLATE_ELLIPSOID:
                case ORMTCOD_SPHERE_ORIGIN:
                case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                     break;

                default:
                     throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                            "SRF_EquidistantCylindrical: " +
                                            "Invalid ORM for SRF");
            }
        }

        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_3D &&
            Const.isValidOrmRt(orm, rt))
        {
            if (!Const.isWellFormedLongitude(params.origin_longitude) ||
                !Const.isWellFormedScale(params.central_scale))
            {
                throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                       new String("SRF_EquidistantCylindrical:"
                                                + " Invalid SRF parameters"));
            }
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_EquidistantCylindrical: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forLocalSpaceRectangular2D
    (
        SRM_ORM_Code      orm,
        SRM_RT_Code       rt,
        SRF_LSR_2D_Params params
    ) throws SrmException
    {
        if (orm == SRM_ORM_Code.ORMCOD_ABSTRACT_2D &&
            Const.isValidOrmRt(orm, rt))
        {
            Lsr2Conv.compute_F_u_v(params);
        }
        else
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LocalSpaceRectangular2D: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forLocalSpaceAzimuthal
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_2D ||
            ! Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LocalSpaceAzimuthal: " +
                                   "Invalid ORM/RT pair");
        }
    }

    protected static void forLocalSpacePolar
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt
    ) throws SrmException
    {
        if (orm != SRM_ORM_Code.ORMCOD_ABSTRACT_2D ||
            ! Const.isValidOrmRt(orm, rt))
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "SRF_LocalSpacePolar: Invalid ORM/RT pair");
        }
    }
}
