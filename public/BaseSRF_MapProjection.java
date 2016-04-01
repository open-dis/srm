/**
@author David Shen
@brief Declaration of Base SRF map projection class.
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

/** The BaseSRF_MapProjection abstract class.
@author David Shen
@see BaseSRF_WithEllipsoidalHeight, BaseSRF_3D
*/
public abstract class BaseSRF_MapProjection extends BaseSRF_WithEllipsoidalHeight
{
    // this is a cache for the ormData used in COM and Point Distortion calculations
    protected OrmData _ormData;

    // member data for the geodetic valid region
    private SRM_Extended_Valid_Region_Params[] _component_valid_gd_region =
                              new SRM_Extended_Valid_Region_Params[2];

    /** Set the Valid Region for this SRF in geodetic coordinates (lon/lat).
        @note Given a coordinate component, the last invocation of this
              method or the setExtendedValidGeodeticRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @note Upper or Lower value is ignored if the interval is a
              semi-interval or unbounded.
        @note The Lower value must be strictly less than the Upper value.
        @param component in: the coordinate component (1 or 2)
        @param type in: the type of interval
        @param lower in: the lower value of the interval
        @param upper in: the upper value of the interval
    */
    public void setValidGeodeticRegion(int component,
                                       SRM_Interval_Type type,
                                       double lower,
                                       double upper) throws SrmException
    {
        if (component < 1 || component > 2)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "setValidGeodeticRegion: component out of range [ 1, 2 ]");

        switch (type)
        {
            case IVLTYP_GT_SEMI_INTERVAL:
            case IVLTYP_GE_SEMI_INTERVAL:
            case IVLTYP_LT_SEMI_INTERVAL:
            case IVLTYP_LE_SEMI_INTERVAL:
                 throw new SrmException(SrmException._INVALID_INPUT,
                         "setValidGeodeticRegion: cannot be a semi-interval region");
            case IVLTYP_OPEN_INTERVAL:
            case IVLTYP_GE_LT_INTERVAL:
            case IVLTYP_GT_LE_INTERVAL:
            case IVLTYP_CLOSED_INTERVAL:
                 if (lower == upper)
                     throw new SrmException(SrmException._INVALID_INPUT,
                             "setValidGeodeticRegion: lower and upper bounds are the same");

                 if (component == 1 &&
                     lower<=-Const.PI && lower>Const.PI &&
                     upper<=-Const.PI && upper>Const.PI)
                     throw new SrmException(SrmException._INVALID_INPUT,
                           "setValidGeodeticRegion: component 1 (longitude) out of range (-PI, PI]");

                 if (component == 2 &&
                     lower<=-Const.PI_DIV_2 && lower>=Const.PI_DIV_2 &&
                     upper<=-Const.PI_DIV_2 && upper>=Const.PI_DIV_2)
                     throw new SrmException(SrmException._INVALID_INPUT,
                             "setValidGeodeticRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
                 break;
        }

        // allocate array needed if needed
        if (_component_valid_gd_region[component-1] == null)
            _component_valid_gd_region[component-1] = new SRM_Extended_Valid_Region_Params();

        _component_valid_gd_region[component-1].type = type;
        _component_valid_gd_region[component-1].lower = lower;
        _component_valid_gd_region[component-1].upper = upper;
    }

    /** Set the Extended Valid Geodetic Region for this SRF.
        @note Given a coordinate component, the last invocation of this
              method or the setValidGeodeticRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @note Upper or Lower value is ignored if the interval is a
              semi-interval or unbounded.
        @note The Lower value must be strictly less than the Upper value.
        @note The Extended_Lower value must be strictly greater than the Lower value and
              the Extended_Upper value must be strictly smaller than the Lower value.
        @param component in: the coordinate component (1 or 2)
        @param type in: the type of interval
        @param extended_lower in: the extended lower value of the interval
        @param lower in: the lower value of the interval
        @param upper in: the upper value of the interval
        @param extended_upper in: the extended_upper value of the interval
    */
    public void setExtendedValidGeodeticRegion(int component,
                                               SRM_Interval_Type type,
                                               double extended_lower,
                                               double lower,
                                               double upper,
                                               double extended_upper) throws SrmException
    {
        if (component < 1 || component > 2)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "setExtendedValidGeodeticRegion: component out of range [ 1, 2 ]");


        switch (type)
        {
            case IVLTYP_GT_SEMI_INTERVAL:
            case IVLTYP_GE_SEMI_INTERVAL:
            case IVLTYP_LT_SEMI_INTERVAL:
            case IVLTYP_LE_SEMI_INTERVAL:
                 throw new SrmException(SrmException._INVALID_INPUT,
                         "setExtendedValidGeodeticRegion: cannot be a semi-interval region");
            case IVLTYP_OPEN_INTERVAL:
            case IVLTYP_GE_LT_INTERVAL:
            case IVLTYP_GT_LE_INTERVAL:
            case IVLTYP_CLOSED_INTERVAL:
                 if (lower == upper)
                     throw new SrmException(SrmException._INVALID_INPUT,
                             "setExtendedValidGeodeticRegion: lower and upper bounds are the same");

                 if (component == 1 &&
                     lower<=-Const.PI && lower>Const.PI &&
                     upper<=-Const.PI && upper>Const.PI)
                     throw new SrmException(SrmException._INVALID_INPUT,
                           "setExtendedValidGeodeticRegion: component 1 (longitude) out of range (-PI, PI]");

                 if (component == 2 &&
                     lower<=-Const.PI_DIV_2 && lower>=Const.PI_DIV_2 &&
                     upper<=-Const.PI_DIV_2 && upper>=Const.PI_DIV_2)
                     throw new SrmException(SrmException._INVALID_INPUT,
                             "setExtendedValidGeodeticRegion: component 2 (latitude) out of range (-PI/2, PI/2)");

                 if (lower < upper  && (extended_lower > lower || extended_upper < upper))
                     throw new SrmException(SrmException._INVALID_INPUT,
                             "setExtendedValidGeodeticRegion: extended bounds falls within valid region");
                 else if (lower > upper && (extended_lower < lower || extended_upper > upper))
                     throw new SrmException(SrmException._INVALID_INPUT,
                             "setExtendedValidGeodeticRegion: extended bounds falls within valid region");
                 break;
        }

        // allocate array needed if needed
        if (_component_valid_gd_region[component-1] == null)
            _component_valid_gd_region[component-1] = new SRM_Extended_Valid_Region_Params();

        _component_valid_gd_region[component-1].type = type;
        _component_valid_gd_region[component-1].extended_lower = extended_lower;
        _component_valid_gd_region[component-1].lower = lower;
        _component_valid_gd_region[component-1].upper = upper;
        _component_valid_gd_region[component-1].extended_upper = extended_upper;
    }

    /** Get the Valid Geodetic Region for this SRF.
        @note Given a coordinate component, the last invocation of this
              method or the setExtendedValidGeodeticRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @param component in: the coordinate component (1 or 2)
        @return the extended valid region parameters
    */
    public SRM_Valid_Region_Params getValidGeodeticRegion(int component) throws SrmException
    {
        SRM_Valid_Region_Params ret_reg = new SRM_Valid_Region_Params();

        if (component < 1 || component > 2)
            throw  new SrmException(SrmException._INVALID_INPUT, "getValidGeodeticRegion: component out of range [ 1, 2 ]");

        ret_reg.type = _component_valid_gd_region[component-1].type;
        ret_reg.lower = _component_valid_gd_region[component-1].lower;
        ret_reg.upper = _component_valid_gd_region[component-1].upper;

        return ret_reg;
    }

    /** Get the Extended Valid Geodetic Region for this SRF.
        @note Given a coordinate component, the last invocation of this
              method or the setValidGeodeticRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @param component in: the coordinate component (1 or 2)
        @return the extended valid region parameters
    */
    public SRM_Extended_Valid_Region_Params getExtendedValidGeodeticRegion(int component) throws SrmException
    {
        SRM_Extended_Valid_Region_Params ret_reg = new SRM_Extended_Valid_Region_Params();

        if (component < 1 || component > 2)
            throw new SrmException(SrmException._INVALID_INPUT, "getExtendedValidGeodeticRegion: component out of range [ 1, 2 ]");

        ret_reg.type = _component_valid_gd_region[component-1].type;
        ret_reg.extended_lower = _component_valid_gd_region[component-1].extended_lower;
        ret_reg.lower = _component_valid_gd_region[component-1].lower;
        ret_reg.upper = _component_valid_gd_region[component-1].upper;
        ret_reg.extended_upper = _component_valid_gd_region[component-1].extended_upper;

        return ret_reg;
    }

    /** Returns the Convergence of the Meridian in radians at a position on
        the surface of the oblate spheroid.
        @param surf_coord in: the surface coordinate in this SRF
        @return the convergence of the meridian angle (in radians)
        @note The input surface coordinate must have been created using this SRF.
    */
    public double calculateConvergenceOfTheMeridian(CoordSurf surf_coord) throws SrmException
    {
        if (surf_coord == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "calculateConvergenceOfTheMeridian: Input parameter is null");

        if (surf_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("calculateConvergenceOfTheMeridian: input coordinate not in this SRF"));

        if (_ormData == null)
            _ormData = new OrmData(_orm);

        // convert the coordinate to celestiodetic.
        double[] tgtCdCoord = interimConv(surf_coord, SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

        // the following cases result to zero (0).
        return comCalculation(_ormData, tgtCdCoord);
    }

    /** Returns the point scale at a position on the surface of the oblate
        spheroid.
        @param surf_coord in: the surface coordinate in this SRF
        @return the point scale length (in meters)
        @note The input surface coordinate must have been created using this SRF.
    */
    public double calculatePointScale(CoordSurf surf_coord) throws SrmException
    {
        if (surf_coord == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "calculatePointScale: Input parameter is null");

        if (surf_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   "calculatePointScale: input coordinate not in this SRF");

        if (_ormData == null)
            _ormData = new OrmData(_orm);

        // convert the coordinate to celestiodetic.
        double[] tgtCdCoord = interimConv(surf_coord, SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

        // the following cases result to zero (0).
        return pointScaleCalculation(_ormData, tgtCdCoord);
    }

    /** Returns the map azimuth in radians between two surface coordinates.
        @param src_coord in: the source surface coordinate in this SRF
        @param des_coord in: the destination surface coordinate in this SRF
        @return the map azimuth angle (in radians)
        @note The input surface coordinates must have been created using this SRF.
        @note The
     */
    public double calculateMapAzimuth(CoordSurf src_coord,
                                      CoordSurf des_coord) throws SrmException
    {
        double ret_azimuth = 0.0;

        if (src_coord.getSRF() != this ||
            des_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("calculateMapAzimuth: input coordinate not in this SRF"));


        if (src_coord.getValues()[1] == des_coord.getValues()[1] &&
            src_coord.getValues()[2] == des_coord.getValues()[2])
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("calculateMapAzimuth: the source and destination coordinates are the same"));

        else
        {
            ret_azimuth = Math.atan2(des_coord.getValues()[0]-src_coord.getValues()[0],
                                     des_coord.getValues()[1]-src_coord.getValues()[1]);

            if (ret_azimuth < 0.0)
                ret_azimuth += Const.TWO_PI;
        }
        return ret_azimuth;
    }

    // COM calculations
    abstract protected double comCalculation(OrmData e_constants, double[] cd_coord) throws SrmException;

    // Point Scale calculations
    abstract protected double pointScaleCalculation(OrmData e_constants, double[] cd_coord) throws SrmException;
}
