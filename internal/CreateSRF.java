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
@brief class that handle the creation of SRFs, SRF Set Members and SRF Templates.
*/

package SRM;

class CreateSRF
{
    // createSRFTFromCode (limited cases just for the interim SRF for validation checking)
    protected static BaseSRF
        fromCode( SRM_SRFT_Code srftCode, SRM_ORM_Code orm, SRM_RT_Code rt) throws SrmException
    {
        BaseSRF retSrf;

        if (srftCode == SRM_SRFT_Code.SRFTCOD_CELESTIODETIC)
            retSrf = new SRF_Celestiodetic ( orm, rt);
        else if (srftCode == SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC)
            retSrf = new SRF_Celestiocentric ( orm, rt);
        else
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("Validation checking not supported"));

        return retSrf;
    }


    protected static BaseSRF standardSRF
    (
        SRM_SRF_Code srf_code,
        SRM_RT_Code  rt_code
    ) throws SrmException
    {
        BaseSRF retSRF = null;

        if (srf_code == SRM_SRF_Code.SRFCOD_BRITISH_NATIONAL_GRID_AIRY)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_OSGB_1936, rt_code))
                retSRF = new SRF_TransverseMercator(SRM_ORM_Code.ORMCOD_OSGB_1936,
                                                    rt_code,
                                                    -2.0 * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                    49.0 * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                    0.9996012717, //central_scale
                                                    400000.0, //false_easting
                                                    -100000.0);  //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_OSGB_1936"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_BRITISH_OSGRS80_GRID)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_ETRS_1989, rt_code))
                retSRF = new SRF_TransverseMercator(SRM_ORM_Code.ORMCOD_ETRS_1989,
                                                    rt_code,
                                                    -2.0 * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                     49.0 * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                     0.9996012717, //central_scale
                                                     400000.0, //false_easting
                                                     -100000.0);  //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_ETRS_1989"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_DELAWARE_SPCS_1983)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_N_AM_1983, rt_code))
                retSRF = new SRF_TransverseMercator(SRM_ORM_Code.ORMCOD_N_AM_1983,
                                                    rt_code,
                                                    /*-75 degrees 25 minutes*/
                                                    (-75.0-(25.0/60.0)) * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                    38.0 * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                    (1.0 - (1.0/200000.0)), //central_scale
                                                    200000.0, //false_easting
                                                    0.0);  //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_N_AM_1983"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_GEOCENTRIC_WGS_1984)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_WGS_1984, rt_code))
                retSRF = new SRF_Celestiocentric (SRM_ORM_Code.ORMCOD_WGS_1984, rt_code);
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_WGS_1984"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_GEODETIC_AUSTRALIA_1984)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_AUSTRALIAN_GEOD_1984, rt_code))
                retSRF = new SRF_Celestiodetic(SRM_ORM_Code.ORMCOD_AUSTRALIAN_GEOD_1984,
                                               rt_code);
                else
                    throw new SrmException( SrmException._INVALID_CODE,
                                            new String("createStandardSRF: incompatble RT with ORMCOD_AUSTRALIAN_GEOD_1984"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_GEODETIC_WGS_1984)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_WGS_1984, rt_code))
                retSRF = new SRF_Celestiodetic (SRM_ORM_Code.ORMCOD_WGS_1984, rt_code);
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_WGS_1984"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_GEODETIC_N_AMERICAN_1983)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_N_AM_1983, rt_code))
                retSRF = new SRF_Celestiodetic (SRM_ORM_Code.ORMCOD_N_AM_1983, rt_code);
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_N_AM_1983"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_IRISH_GRID_1965)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_IRELAND_1965, rt_code))
                retSRF = new SRF_TransverseMercator(SRM_ORM_Code.ORMCOD_IRELAND_1965,
                                                    rt_code,
                                                    -8.0 * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                    (53.0+30.0/60.0) * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                    1.000035, //central_scale
                                                    200000.0, //false_easting
                                                    250000.0);  //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_IRELAND_1965"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_IRISH_TRANSVERSE_MERCATOR_1989)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_ETRS_1989, rt_code))
                retSRF = new SRF_TransverseMercator(SRM_ORM_Code.ORMCOD_ETRS_1989,
                                                    rt_code,
                                                    -8.0 * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                    (53.0+30.0/60.0) * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                    0.999820, //central_scale
                                                    600000.0, //false_easting
                                                    750000.0);  //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_ETRS_1989"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_LAMBERT_93)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_RGF_1993, rt_code))
                retSRF = new SRF_LambertConformalConic(SRM_ORM_Code.ORMCOD_RGF_1993,
                                                       rt_code,
                                                       3.0 * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                       (46.0+(30.0/60.0)) * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                       44.0 * Const.RADIANS_PER_DEGREE, //north_parallel_geodetic_latitude
                                                       49.0 * Const.RADIANS_PER_DEGREE, //south_parallel_geodetic_latitude
                                                       700000.0, //false_easting
                                                       6600000.0); //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_RGF_1993"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_LAMBERT_II_WIDE)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_NTF_1896_PM_PARIS, rt_code))
                retSRF = new SRF_LambertConformalConic(SRM_ORM_Code.ORMCOD_NTF_1896_PM_PARIS,
                                                       rt_code,
                                                       0.0 * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                       (46.0+(48.0/60.0)) * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                       (45.0+(53.0/60.0)+(56.108/3600.0)) * Const.RADIANS_PER_DEGREE, //north_parallel_geodetic_latitude
                                                       (47.0+(41.0/60.0)+(45.652/3600.0)) * Const.RADIANS_PER_DEGREE, //south_parallel_geodetic_latitude
                                                       600000.0, //false_easting
                                                       2200000.0); //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_NTF_1896_PM_PARIS"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_MARYLAND_SPCS_1983)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_N_AM_1983, rt_code))
                retSRF = new SRF_LambertConformalConic(SRM_ORM_Code.ORMCOD_N_AM_1983,
                                                       rt_code,
                                                       -77.0 * Const.RADIANS_PER_DEGREE, //origin_longitude
                                                       (37.0+(50.0/60.0)) * Const.RADIANS_PER_DEGREE, //origin_latitude
                                                       (38.0+18.0/60.0) * Const.RADIANS_PER_DEGREE, //north_parallel_geodetic_latitude
                                                       (39.0+(27.0/60.0)) * Const.RADIANS_PER_DEGREE, //south_parallel_geodetic_latitude
                                                       400000.0, //false_easting
                                                       0.0); //false_northing
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_N_AM_1983"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_MARS_PLANETOCENTRIC_2000)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_MARS_SPHERE_2000, rt_code))
                retSRF = new SRF_Celestiodetic(SRM_ORM_Code.ORMCOD_MARS_SPHERE_2000,
                                               rt_code);
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_MARS_SPHERE_2000"));
        }
        else if (srf_code == SRM_SRF_Code.SRFCOD_MARS_PLANETOGRAPHIC_2000)
        {
            if (Const.isValidOrmRt( SRM_ORM_Code.ORMCOD_MARS_2000, rt_code))
                retSRF = new SRF_Planetodetic(SRM_ORM_Code.ORMCOD_MARS_2000,
                                              rt_code);
            else
                throw new SrmException( SrmException._INVALID_CODE,
                                        new String("createStandardSRF: incompatble RT with ORMCOD_MARS_2000"));
        }
        else // none of the above
            throw new SrmException( SrmException._INVALID_CODE,
                                    new String("createStandardSRF: invalid SRF code"));

        retSRF.setSrfCode( srf_code);

        return retSRF;
    }


    protected static BaseSRF srfSetMember
    (
        SRM_SRFS_Code  srf_set,
        SRM_SRFSM_Code set_member,
        SRM_ORM_Code   orm,
        SRM_RT_Code    rt
    ) throws SrmException
    {
        BaseSRF retSRF = null;
        boolean is_compatible = false;

        // ORM and RT are checked when instantiating the SRF templates.

        if (srf_set == SRM_SRFS_Code.SRFSCOD_ALABAMA_SPCS)
        {
            if (set_member instanceof SRM_SRFSM_Alabama_SPCS_Code)
            {
                retSRF = createAlabama_SPCS(set_member, orm, rt);
                is_compatible = true;
            }
        }
        else if (srf_set == SRM_SRFS_Code.SRFSCOD_GTRS_GLOBAL_COORDINATE_SYSTEM)
        {
            if (set_member instanceof SRM_SRFSM_GTRS_GCS_Code)
            {
                retSRF = createGTRS_GCS(set_member, orm, rt);
                is_compatible = true;
            }
        }
        else if (srf_set == SRM_SRFS_Code.SRFSCOD_LAMBERT_NTF)
        {
            if (set_member instanceof SRM_SRFSM_Lambert_NTF_Code)
            {
                retSRF = createLambert_NTF(set_member, orm, rt);
                is_compatible = true;
            }
        }
        else if (srf_set == SRM_SRFS_Code.SRFSCOD_JAPAN_RECTANGULAR_PLANE_CS)
        {
            if (set_member instanceof SRM_SRFSM_Japan_Rectangular_Plane_CS_Code)
            {
                retSRF = createJpRectPlane(set_member, orm, rt);
                is_compatible = true;
            }
        }
        else if (srf_set == SRM_SRFS_Code.SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC)
        {
            if (set_member instanceof SRM_SRFSM_UPS_Code)
            {
                retSRF = createUPS(set_member, orm, rt);
                is_compatible = true;
            }
        }
        else if (srf_set == SRM_SRFS_Code.SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR)
        {
            if (set_member instanceof SRM_SRFSM_UTM_Code)
            {
                retSRF = createUTM(set_member, orm, rt);
                is_compatible = true;
            }
        }
        else if (srf_set == SRM_SRFS_Code.SRFSCOD_WISCONSIN_SPCS)
        {
            if (set_member instanceof SRM_SRFSM_Wisconsin_SPCS_Code)
            {
                retSRF = createWI_SPCS(set_member, orm, rt);
                is_compatible = true;
            }
        }
        else // none of the above
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("srfSetMember: invalid SRFS code"));

        if (!is_compatible)
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("srfSetMember: incompatible SRFS and SRFS Member codes"));

        retSRF.setSrfSetCode( srf_set);

        return retSRF;
    }


    // createAlabama_SPCS
    private static BaseSRF createAlabama_SPCS
    (
        SRM_SRFSM_Code set_member,
        SRM_ORM_Code   orm,
        SRM_RT_Code    rt
    ) throws SrmException
    {
        BaseSRF retSRF = null;

        if (orm != SRM_ORM_Code.ORMCOD_N_AM_1983 ||
            rt != SRM_RT_Code.RTCOD_N_AM_1983_CONTINENTAL_US)
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("createSRFSetMember: invalid Alabama SPCS SRF ORM code"));

        // ASPCS_WEST_ZONE
        if (set_member == SRM_SRFSM_Alabama_SPCS_Code.SRFSMALCOD_WEST_ZONE)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (-87.0-30.0/60.0) * Const.RADIANS_PER_DEGREE, //origin_longitude
                          (30.0) * Const.RADIANS_PER_DEGREE, //origin_latitude
                          1.0-(1.0/15000.0), //central_scale
                          600000.0, //false_easting
                          0.0);  //false_northing
        //ASPCS_EAST_ZONE
        else if (set_member == SRM_SRFSM_Alabama_SPCS_Code.SRFSMALCOD_EAST_ZONE)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (-85.0-50.0/60.0) * Const.RADIANS_PER_DEGREE, //origin_longitude
                          30.5 * Const.RADIANS_PER_DEGREE, //origin_latitude 30.0 + 30.0/60.0 = 30.5
                          1.0-(1.0/25000.0), //central_scale
                          200000.0, //false_easting
                          0.0);  //false_northing
        else
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("createSRFSetMember: invalid Alabama SPCS SRF Set member code"));

        retSRF.setSrfSetMemberCode( set_member);

        return retSRF;
    }


    // createGTRS_GCS
    private static BaseSRF createGTRS_GCS
    (
        SRM_SRFSM_Code set_member,
        SRM_ORM_Code   orm,
        SRM_RT_Code    rt
    ) throws SrmException
    {
        BaseSRF retSRF = null;

        if (orm != SRM_ORM_Code.ORMCOD_WGS_1984 ||
            rt != SRM_RT_Code.RTCOD_WGS_1984_IDENTITY)
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("createSRFSetMember: invalid GCS ORM code (valid ORM=> WGS_1984"));

        GtrsDataSet tmpGtrsElem = GtrsDataSet.getElem( set_member.toInt());

        retSRF = new SRF_LocalTangentSpaceEuclidean
                     (orm,
                      rt,
                      GtrsDataSet.getCellOrigLon(set_member.toInt(),
                                                 tmpGtrsElem), //geodetic_longitude
                      GtrsDataSet.getCellOrigLat(tmpGtrsElem), //geodetic_latitude
                      0.0, //azimuth
                      50000.0, //x_false_origin
                      50000.0, //y_false_origin
                      0.0);  //height_offset

        retSRF.setSrfSetMemberCode( set_member);

        return retSRF;
    }


    // createLambert_NTF
    private static BaseSRF createLambert_NTF
    (
        SRM_SRFSM_Code set_member,
        SRM_ORM_Code   orm,
        SRM_RT_Code    rt
    ) throws SrmException
    {
        BaseSRF retSRF = null;

        if (orm != SRM_ORM_Code.ORMCOD_NTF_1896 ||
            rt != SRM_RT_Code.RTCOD_NTF_1896_FRANCE)
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("createSRFSetMember: invalid Lambert NTF SRF ORM code"));

        // LNTF_ZONE_I
        if (set_member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_I)
            retSRF = new SRF_LambertConformalConic
                         (orm,
                          rt,
                          0.0 * Const.RADIANS_PER_DEGREE, // origin_longitude
                          (49.5)* Const.RADIANS_PER_DEGREE, // origin_latitude
                          (48.0+ (35.0/60.0)+ (54.682/3600.0)) * Const.RADIANS_PER_DEGREE, // north_parallel_geodetic_latitude
                          (50.0+( 23.0/60.0)+( 45.282/3600.0)) * Const.RADIANS_PER_DEGREE, // south_parallel_geodetic_latitude
                          600000.0, // false_easting
                          200000.0);  // false_northing
        // LNTF_ZONE_II
        else if (set_member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_II)
            retSRF = new SRF_LambertConformalConic
                         (orm,
                          rt,
                          0.0 * Const.RADIANS_PER_DEGREE, // origin_longitude
                          (46.8) * Const.RADIANS_PER_DEGREE, // origin_latitude
                          (45.0+ (53.0/60.0)+  (56.108/3600.0)) * Const.RADIANS_PER_DEGREE, // north_parallel_geodetic_latitude
                          (47.0+( 41.0/60.0)+( 45.652/3600.0)) * Const.RADIANS_PER_DEGREE, // south_parallel_geodetic_latitude
                          600000.0, // false_easting
                          200000.0);  // false_northing

        // LNTF_ZONE_III
        else if (set_member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_III)
            retSRF = new SRF_LambertConformalConic
                         (orm,
                          rt,
                          0.0 * Const.RADIANS_PER_DEGREE, // origin_longitude
                          (44.1)* Const.RADIANS_PER_DEGREE, // origin_latitude
                          (43.0 + (11.0/60.0) + (57.449/3600.0)) * Const.RADIANS_PER_DEGREE, // north_parallel_geodetic_latitude
                          (44.0+( 59.0/60.0)+( 45.938/3600.0)) * Const.RADIANS_PER_DEGREE, // south_parallel_geodetic_latitude
                          600000.0, // false_easting
                          200000.0);  // false_northing

        // LNTF_ZONE_IV
        else if (set_member ==
                 SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTFCOD_ZONE_IV)
            retSRF = new SRF_LambertConformalConic
                         (orm,
                          rt,
                          0.0 * Const.RADIANS_PER_DEGREE, // origin_longitude
                          (42.0+(9.0/60.0)+(54.0/3600.0)) * Const.RADIANS_PER_DEGREE, // origin_latitude
                          (41.0+ (33.0/60.0) + (37.396/3600.0)) * Const.RADIANS_PER_DEGREE, // north_parallel_geodetic_latitude
                          (42.0+( 46.0/60.0)+( 3.588/3600)) * Const.RADIANS_PER_DEGREE, // south_parallel_geodetic_latitude
                          234358.0, // false_easting
                          185861.369);  // false_northing

        else
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("createSRFSetMember: invalid Lambert NTF SRF Set member code"));

        retSRF.setSrfSetMemberCode( set_member);

        return retSRF;
    }

    // createJpRectPlane
    private static BaseSRF createJpRectPlane
    (
        SRM_SRFSM_Code set_member,
        SRM_ORM_Code   orm,
        SRM_RT_Code    rt
    ) throws SrmException
    {
        BaseSRF retSRF = null;

        if (orm != SRM_ORM_Code.ORMCOD_JGD_2000 ||
            rt != SRM_RT_Code.RTCOD_JGD_2000_IDENTITY_BY_MEASUREMENT)
            throw new SrmException(SrmException._INVALID_CODE,
                                   new String("createSRFSetMember: invalid Japan Rectangular Plane CS RT/ORM code"));

        if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_I)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (129.0+30.0/60.0)*Const.RADIANS_PER_DEGREE, //origin_longitude
                          (33.0)*Const.RADIANS_PER_DEGREE, //origin_latitude
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_II)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (131.0+30.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (33.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_III)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (132.0+10.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (36.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_IV)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (133.0+30.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (33.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_V)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (134.0+20.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (36.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_VI)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (136.0)*Const.RADIANS_PER_DEGREE,
                          (36.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_VII)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (137.0+10.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (36.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_VIII)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (138.0+30.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (36.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_IX)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (139.0+50.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (36.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_X)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (140.0+50.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (40.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XI)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (140.0+15.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (44.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XII)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (142.0+15.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (44.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XIII)
            retSRF = new SRF_TransverseMercator
                         (orm,
                          rt,
                          (144.0+15.0/60.0)*Const.RADIANS_PER_DEGREE,
                          (44.0)*Const.RADIANS_PER_DEGREE,
                          0.9999, //central_scale
                          0.0, //false_easting
                          0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XIV)
            retSRF = new SRF_TransverseMercator(orm,
                                                rt,
                                                (142.0)*Const.RADIANS_PER_DEGREE,
                                                (26.0)*Const.RADIANS_PER_DEGREE,
                                                0.9999, //central_scale
                                                0.0, //false_easting
                                                0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XV)
            retSRF = new SRF_TransverseMercator(orm,
                                                rt,
                                                (127.0+30.0/60.0)*Const.RADIANS_PER_DEGREE,
                                                (26.0)*Const.RADIANS_PER_DEGREE,
                                                0.9999, //central_scale
                                                0.0, //false_easting
                                                0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XVI)
            retSRF = new SRF_TransverseMercator(orm,
                                                rt,
                                                (124.0)*Const.RADIANS_PER_DEGREE,
                                                (26.0)*Const.RADIANS_PER_DEGREE,
                                                0.9999, //central_scale
                                                0.0, //false_easting
                                                0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XVII)
            retSRF = new SRF_TransverseMercator(orm,
                                                rt,
                                                (131.0)*Const.RADIANS_PER_DEGREE,
                                                (26.0)*Const.RADIANS_PER_DEGREE,
                                                0.9999, //central_scale
                                                0.0, //false_easting
                                                0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XVIII)
            retSRF = new SRF_TransverseMercator(orm,
                                                rt,
                                                (136.0)*Const.RADIANS_PER_DEGREE,
                                                (20.0)*Const.RADIANS_PER_DEGREE,
                                                0.9999, //central_scale
                                                0.0, //false_easting
                                                0.0);  //false_northing
        else if (set_member == SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.SRFSMJPRPCSCOD_ZONE_XIX)
            retSRF = new SRF_TransverseMercator(orm,
                                                rt,
                                                (154.0)*Const.RADIANS_PER_DEGREE,
                                                (26.0)*Const.RADIANS_PER_DEGREE,
                                                0.9999, //central_scale
                                                0.0, //false_easting
                                                0.0);  //false_northing
        else
            throw new SrmException( SrmException._INVALID_CODE,
                                    new String("createSRFSetMember: invalid Japan Rectangular Plane CS Set member code"));

        retSRF.setSrfSetMemberCode( set_member);

        return retSRF;
    }

    // createUPS
    private static BaseSRF createUPS
    (
        SRM_SRFSM_Code set_member,
        SRM_ORM_Code   orm,
        SRM_RT_Code    rt
    ) throws SrmException
    {
        BaseSRF retSRF = null;

        //
        if (set_member == SRM_SRFSM_UPS_Code.SRFSMUPSCOD_NORTHERN_POLE)
            retSRF = new SRF_PolarStereographic(orm,
                                                rt,
                                                SRM_Polar_Aspect.PLRASP_NORTH, //polar_aspect
                                                0.0, //origin_longitude
                                                0.994, // central_scale
                                                2000000.0, //false_easting
                                                2000000.0);  //false_northing

        else if (set_member == SRM_SRFSM_UPS_Code.SRFSMUPSCOD_SOUTHERN_POLE)
            retSRF = new SRF_PolarStereographic(orm,
                                                rt,
                                                SRM_Polar_Aspect.PLRASP_SOUTH, //polar_aspect
                                                0.0, //origin_longitude
                                                0.994, // central_scale
                                                2000000.0, //false_easting
                                                2000000.0);  //false_northing
        else
            throw new SrmException( SrmException._INVALID_CODE,
                                    new String("createSRFSetMember: invalid UPS Set member code"));

        retSRF.setSrfSetMemberCode( set_member);

        return retSRF;
    }

    // createUTM
    private static BaseSRF createUTM( SRM_SRFSM_Code set_member, SRM_ORM_Code orm, SRM_RT_Code rt) throws SrmException
    {
        BaseSRF retSRF = null;
        double origin_longitude = 0.0;
        double false_northing = 0.0;

        // UTM zone between 1 and 60
        if (set_member.toInt() >= SRM_SRFSM_UTM_Code._SRFSMUTMCOD_ZONE_1_NORTHERN_HEMISPHERE &&
             set_member.toInt() <= SRM_SRFSM_UTM_Code._SRFSMUTMCOD_ZONE_60_NORTHERN_HEMISPHERE) {
            origin_longitude = ( (double)set_member.toInt() * 6.0 - 183.0) * Const.RADIANS_PER_DEGREE;
            false_northing = 0.0;
        }
        // UTM zone between 61 and 120
        else if  ( set_member.toInt() >= SRM_SRFSM_UTM_Code._SRFSMUTMCOD_ZONE_1_SOUTHERN_HEMISPHERE &&
                   set_member.toInt() <= SRM_SRFSM_UTM_Code._SRFSMUTMCOD_ZONE_60_SOUTHERN_HEMISPHERE) {
            origin_longitude =  ( (double)set_member.toInt() * 6.0 - 543.0) * Const.RADIANS_PER_DEGREE;
            false_northing = 10000000.0;
        }
        else
            throw new SrmException( SrmException._INVALID_CODE,
                                    new String("createSRFSetMember: invalid UTM Set member code"));

        retSRF = new SRF_TransverseMercator(orm,
                                            rt,
                                            origin_longitude, //origin_longitude
                                            0.0, //origin_latitude
                                            0.9996, //central_scale
                                            500000.0, //false_easting
                                            false_northing);  //false_northing

        retSRF.setSrfSetMemberCode( set_member);

        return retSRF;
    }


    // createUPS
    private static BaseSRF createWI_SPCS( SRM_SRFSM_Code set_member, SRM_ORM_Code orm, SRM_RT_Code rt) throws SrmException
    {
        BaseSRF retSRF = null;

        if (orm != SRM_ORM_Code.ORMCOD_N_AM_1983 || rt != SRM_RT_Code.RTCOD_N_AM_1983_CONTINENTAL_US)
            throw new SrmException( SrmException._INVALID_CODE,
                                    new String("createSRFSetMember: invalid WI SPCS SRF ORM code"));

        // WSPCS_SOUTH_ZONE
        if (set_member == SRM_SRFSM_Wisconsin_SPCS_Code.SRFSMWNSPCSCOD_SOUTH_ZONE)
            retSRF = new SRF_LambertConformalConic(orm,
                                                   rt,
                                                   -90.0 * Const.RADIANS_PER_DEGREE, // origin_longitude
                                                   (42.0) * Const.RADIANS_PER_DEGREE, // origin_latitude
                                                   (42.0+(44.0/60.0)) * Const.RADIANS_PER_DEGREE, // north_parallel_geodetic_latitude
                                                   (44.0+(4.0/60.0)) * Const.RADIANS_PER_DEGREE, // south_parallel_geodetic_latitude
                                                   600000.0, // false_easting
                                                   0.0);  // false_northing
        // WSPCS_CENTRAL_ZONE
        else if (set_member == SRM_SRFSM_Wisconsin_SPCS_Code.SRFSMWNSPCSCOD_CENTRAL_ZONE)
            retSRF = new SRF_LambertConformalConic(orm,
                                                   rt,
                                                   -90.0 * Const.RADIANS_PER_DEGREE, // origin_longitude
                                                   (43.0+(50.0/60.0)) * Const.RADIANS_PER_DEGREE, // origin_latitude
                                                   (44.0+(15.0/60.0)) * Const.RADIANS_PER_DEGREE, // north_parallel_geodetic_latitude
                                                   (45.0+(30.0/60.0)) * Const.RADIANS_PER_DEGREE, // south_parallel_geodetic_latitude
                                                   600000.0, // false_easting
                                                   0.0);  // false_northing
        // WSPCS_NORTH_ZONE
        else if (set_member == SRM_SRFSM_Wisconsin_SPCS_Code.SRFSMWNSPCSCOD_NORTH_ZONE)
            retSRF = new SRF_LambertConformalConic(orm,
                                                   rt,
                                                   -90.0 * Const.RADIANS_PER_DEGREE, // origin_longitude
                                                   (45.0+(10.0/60.0)) * Const.RADIANS_PER_DEGREE, // origin_latitude
                                                   (45.0+(34.0/60.0)) * Const.RADIANS_PER_DEGREE, // north_parallel_geodetic_latitude
                                                   (46.0+(46.0/60.0)) * Const.RADIANS_PER_DEGREE, // south_parallel_geodetic_latitude
                                                   600000.0, // false_easting
                                                   0.0);  // false_northing
        else
            throw new SrmException( SrmException._INVALID_CODE,
                                    new String("createSRFSetMember: invalid WI SPCS SRF Set member code"));

        retSRF.setSrfSetMemberCode( set_member);


        return retSRF;
    }
}
