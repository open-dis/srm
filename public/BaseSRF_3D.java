/**
@author David Shen
@brief Declaration of Base SRF 3D class.
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

import java.util.*;

/** The BaseSRF_3D abstract class is the base class for the 3D SRFs.
@author David Shen
@see BaseSRF, BaseSRF_2D
*/
public abstract class BaseSRF_3D extends BaseSRF
{
    /** member data for the geodetic valid region
     */
    protected SRM_Extended_Valid_Region_Params[] _component_valid_region =
        new SRM_Extended_Valid_Region_Params[3];

    /** boolean flag indicating whether the coordinate component associated with
        this SRF is angular
    */
    protected boolean[] _component_is_angular = { false, false, false };

    /** Creates a 3D coordinate object.
        @return a 3D coordinate object
        @note The initial coordinate value is defaulted to [ Double.NaN, Double.NaN, Double.NaN ].
    */
    public abstract Coord3D createCoordinate3D();

    /** Creates a 3D coordinate object.
        @param coord_comp1 in: the values of the first component of the 3D coordinate
        @param coord_comp2 in: the values of the second component of the 3D coordinate
        @param coord_comp3 in: the values of the third component of the 3D coordinate
        @return a 3D coordinate object
    */
    public abstract Coord3D createCoordinate3D(double coord_comp1,
                                               double coord_comp2,
                                               double coord_comp3);

    /** Retrieves the 3D coordinate component values.
        @note The input coordinate must have been created using this SRF.
        @param coord in: a 3D coordinate
        @return an array of size 3 containing the component values for the 3D coordinate
    */
    public double[] getCoordinate3DValues(Coord3D coord) throws SrmException
    {
        if (coord == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("getCoordinate3DValues: null reference input parameter"));
        if (coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("getCoordinate3DValues: Coordinate associated with different SRF"));

        return coord.getValues();
    }


    /** Changes a coordinate's values to this SRF.
        @param src in: the source 3D coordinate in some other 3D SRF
        @param tgt in out: the target coordinate in this 3D SRF
        @return the Valid Region of the target coordinate
    */
    public SRM_Coordinate_Valid_Region_Code changeCoordinate3DSRF(Coord3D src,
                                                                  Coord3D tgt) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid;
        double[] tgtValues = new double[3];

        if (src == null || tgt == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinate3DSRF: null reference input parameters"));

        retValid = OpManager.instance().computeAsArray
                   (src.getSRF(), this, src.getValues(), tgtValues, null);

        tgt.setValues(tgtValues);

        return retValid;
    }


    /** Changes an array of 3D coordinate to this SRF.
        @note all the arrays must be of same length.
        @note all the coordinate in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus
              one to indicate that the operation successfully converted all the
              coordinates in the source array.  Otherwise, the return value is
              the index of the offending coordinate in the source array.
        @param src in: the array of source 3D coordinate in some other 3D SRF
        @param tgt out: the array of target coordinate in this 3D SRF
        @param region out: the array of valid region associated with the array
                           of target coordinates
        @return the index of the offending coordinate in the source array when
                an error condition occurs.  Otherwise, it is the size of the
                source array plus one.
    */
    public int changeCoordinate3DArraySRF(Coord3D[] src,
                                          Coord3D[] tgt,
                                          SRM_Coordinate_Valid_Region_Code[] region) throws SrmException
    {
        boolean has_no_failure = true;
        double[] tgtValues = new double[3];

        if (src.length != tgt.length || src.length != region.length)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeCoordinate3DArraySRF: inconsistent array size"));

        int retIndex = src.length+1;

        for (int i=0; i<src.length && has_no_failure; i++)
        {
            try
            {
                if (src[i] == null || tgt[i] == null)
                {
                    throw new SrmException(SrmException._INVALID_INPUT,
                                           new String("changeCoordinate3DArraySRF: null array element"));
                }
                region[i] = OpManager.instance().computeAsArray
                            (src[i].getSRF(), this, src[i].getValues(), tgtValues, null);

                tgt[i].setValues(tgtValues);
            }
            catch (SrmException ex)
            {
                retIndex = i;
                has_no_failure = false;
            }
        }
        return retIndex;
    }


    /** Set the Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
        method or the setExtendedValidRegion method determines
        the valid and extended valid intervals of the coordinate
        component values.
        @note Upper or Lower value is ignored if the interval is a
        semi-interval or unbounded.
        @note The Lower value must be strictly less than the Upper value.
        @param component in: the coordinate component (1, 2, or 3)
        @param type in: the type of interval
        @param lower in: the lower value of the interval
        @param upper in: the upper value of the interval
    */
    public void setValidRegion(int component,
                               SRM_Interval_Type type,
                               double lower,
                               double upper) throws SrmException
    {
        if (component < 1 || component > 3)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setValidRegion: component out of range [ 1, 3 ]");

        SRM_SRFT_Code srft_code = getSRFTemplateCode();

        if (srft_code == SRM_SRFT_Code.SRFTCOD_CELESTIODETIC ||
            srft_code == SRM_SRFT_Code.SRFTCOD_PLANETODETIC)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                             "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (!(Const.isWellFormedLongitude(lower) &&
                               Const.isWellFormedLongitude(upper)))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                                    "setValidRegion: component 1 (longitude) out of range (-PI, PI]");
                         else if (lower == upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                                    "setValidRegion: component 1 (longitude) lower and upper bounds are the same");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                             "setValidRegion: component 2 (latitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (!(Const.isWellFormedLatitude(lower) &&
                               Const.isWellFormedLatitude(upper)))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                 "setValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
                         else if (lower == upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                 "setValidRegion: component 2 (latitude) lower and upper bounds are the same");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else //component == 3
            {
                switch (type)
                {
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                   "setValidRegion: component 3 (height) " +
                                   "lower bound greater than upper bound");
//                       else if (upper <= -B || lower <= -B)
//                            throw new SrmException(SrmException._INVALID_INPUT,
//                                  "setValidRegion: component 3 (height) bounds " +
//                                  "lower than minor semi-axes length");
                         break;
                }
            }
        }
        // azimuth, elevation, radius
        else if (srft_code == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (!(Const.isWellFormedAzimuth(lower) &&
                              Const.isWellFormedAzimuth(upper)))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                    "setValidRegion: component 1 (longitude) out of range (-PI, PI]");
                        else if (lower == upper)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                   "setValidRegion: component 1 (longitude) lower and upper bounds are the same");
                        break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                "setValidRegion: component 2 (latitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (!(Const.isWellFormedLatitude(lower) &&
                              Const.isWellFormedLatitude(upper)))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                      "setValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
                        else if (lower == upper)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                      "setValidRegion: component 2 (latitude) lower and upper bounds are the same");
                        break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else //component == 3
            {
                switch (type)
                {
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (upper <= lower)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                   "setValidRegion: component 3 (height) lower bound greater than upper bound");
                        else if (upper <= 0.0 || lower <= 0.0)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                   "setValidRegion: component 3 (height) bounds lower than minor semi-axes length");
                        break;
                    }
                }
            }
        }
        // cylindrical angle, radius, h
        else if (srft_code == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                            "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (!(Const.isWellFormedLongitude(lower) &&
                              Const.isWellFormedLongitude(upper)))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                   "setValidRegion: component 1 (longitude) out of range (-PI, PI]");
                        else if (lower == upper)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                   "setValidRegion: component 1 (longitude) lower and upper bounds are the same");
                        break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (upper <= lower)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                   "setValidRegion: component 2 (height) lower bound greater than upper bound");
                        else if (upper <= 0.0 || lower <= 0.0)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                                   "setValidRegion: component 2 (height) bounds lower than minor semi-axes length");
                        break;
                    }
                }
                // component 3 has no boundaries.
            }
        }
        // spherical: lon, lat, h
        else if (srft_code == SRM_SRFT_Code.SRFTCOD_CELESTIOMAGNETIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_SOLAR_ECLIPTIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_SOLAR_EQUATORIAL ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_HELIOSPHERIC_ARIES_ECLIPTIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_ECLIPTIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_EQUATORIAL)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                   "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (!(Const.isWellFormedLongitude(lower) &&
                              Const.isWellFormedLongitude(upper)))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setValidRegion: component 1 (longitude) out of range (-PI, PI]");
                        else if (lower == upper)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setValidRegion: component 1 (longitude) lower and upper bounds are the same");
                        break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setValidRegion: component 2 (latitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (!(Const.isWellFormedLatitude(lower) &&
                              Const.isWellFormedLatitude(upper)))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
                        else if (lower == upper)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setValidRegion: component 2 (latitude) lower and upper bounds are the same");
                        break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else //component == 3
            {
                switch (type)
                {
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setValidRegion: component 3 (height) lower bound greater than upper bound");
                         else if (upper <= 0.0 || lower <= 0.0)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setValidRegion: component 3 (height) bounds lower than minor semi-axes length");
                        break;
                    }
                }
            }
        }
        else
        {
            switch (type)
            {
                case IVLTYP_OPEN_INTERVAL:
                case IVLTYP_GE_LT_INTERVAL:
                case IVLTYP_GT_LE_INTERVAL:
                case IVLTYP_CLOSED_INTERVAL:
                {
                    if (upper <= lower)
                        throw new SrmException(SrmException._INVALID_INPUT,
                                "setValidRegion: int_interval lower bound greater than upper bound");
                    break;
                }
            }
        }

        // allocate array if needed
        if (_component_valid_region[component-1] == null)
            _component_valid_region[component-1] = new SRM_Extended_Valid_Region_Params();

        _component_valid_region[component-1].type = type;
        _component_valid_region[component-1].lower = lower;
        _component_valid_region[component-1].upper = upper;
    }

    /** Set the Extended Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
        method or the setValidRegion method determines
        the valid and extended valid intervals of the coordinate
        component values.
        @note Upper or Lower value is ignored if the interval is a
        semi-interval or unbounded.
        @note The Lower value must be strictly less than the Upper value.
        @note The Extended_Lower value must be strictly greater than the Lower value and
        the Extended_Upper value must be strictly smaller than the Lower value.
        @param component in: the coordinate component (1, 2, or 3)
        @param type in: the type of interval
        @param extended_lower in: the extended lower value of the interval
        @param lower in: the lower value of the interval
        @param upper in: the upper value of the interval
        @param extended_upper in: the extended_upper value of the interval
    */
    public void setExtendedValidRegion(int    component,
                                       SRM_Interval_Type type,
                                       double extended_lower,
                                       double lower,
                                       double upper,
                                       double extended_upper) throws SrmException
    {
        if (component < 1 || component > 3)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component out of range [ 1, 3 ]");

        SRM_SRFT_Code srft_code = getSRFTemplateCode();

        if (srft_code == SRM_SRFT_Code.SRFTCOD_CELESTIODETIC ||
            srft_code == SRM_SRFT_Code.SRFTCOD_PLANETODETIC)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (!(Const.isWellFormedLongitude(lower) && Const.isWellFormedLongitude(upper) &&
                               Const.isWellFormedLongitude(extended_lower) && Const.isWellFormedLongitude(extended_upper)))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                                    "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
                         else if (lower == upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                                    "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
                         else if (lower < upper  && (extended_lower > lower || extended_upper < upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                                    "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                         else if (lower > upper && (extended_lower < lower || extended_upper > upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                                    "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 2 (latitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (!(Const.isWellFormedLatitude(lower) && Const.isWellFormedLatitude(upper) &&
                               Const.isWellFormedLatitude(extended_lower) && Const.isWellFormedLatitude(extended_upper)))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
                         else if (lower == upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) lower and upper bounds are the same");
                         else if (lower < upper && (extended_lower > lower || extended_upper < upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
                         else if (lower > upper && (extended_lower < lower || extended_upper > upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else //component == 3
            {
                switch (type)
                {
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 3 (height) lower bound greater than upper bound");
//                       else if (upper <= -B || lower <= -B)
//                           throw new SrmException(SrmException._INVALID_INPUT,
//                                   "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
//                       else if (type < SRM_Interval_Type.IVLTYP_CLOSED_INTERVAL &&
//                             (extended_lower <= -B || extended_lower > lower || extended_upper < upper))
//                           throw new SrmException(SrmException._INVALID_INPUT,
//                                   "setExtendedValidRegion: component 3 (height) extended bounds falls within valid region");
                         break;
                    }
                }
            }
        }
        // azimuth, elevation, radius
        else if (srft_code == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (!(Const.isWellFormedAzimuth(lower) &&
                               Const.isWellFormedAzimuth(upper) &&
                               Const.isWellFormedAzimuth(extended_lower) &&
                               Const.isWellFormedAzimuth(extended_upper)))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
                         else if (lower == upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
                         else if (lower < upper  &&
                                  (extended_lower > lower || extended_upper < upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                         else if (lower > upper &&
                                  (extended_lower < lower || extended_upper > upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 2 (latitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (!(Const.isWellFormedLatitude(lower) &&
                              Const.isWellFormedLatitude(upper) &&
                              Const.isWellFormedLatitude(extended_lower) &&
                              Const.isWellFormedLatitude(extended_upper)))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
                        else if (lower == upper)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 2 (latitude) lower and upper bounds are the same");
                        else if (lower < upper &&
                                 (extended_lower > lower || extended_upper < upper))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
                        else if (lower > upper &&
                                 (extended_lower < lower || extended_upper > upper))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
                        break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else //component == 3
            {
                switch (type)
                {
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 3 (height) lower bound greater than upper bound");
                         else if (upper <= 0.0 || lower <= 0.0)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
                         break;
                    }
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    {
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 3 (height) lower bound greater than upper bound");
                         else if (upper <= 0.0 || lower <= 0.0)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
                         else if (extended_lower <= 0.0 || extended_lower > lower || extended_upper < upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 3 (height) extended bounds falls within valid region");
                         break;
                    }
                }
            }
        }
        // cylindrical angle, radius, h
        else if (srft_code == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                               "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (!(Const.isWellFormedCylindricalAngle(lower) && Const.isWellFormedCylindricalAngle(upper) &&
                               Const.isWellFormedCylindricalAngle(extended_lower) && Const.isWellFormedCylindricalAngle(extended_upper)))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
                         else if (lower == upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
                         else if (lower < upper  && (extended_lower > lower || extended_upper < upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                         else if (lower > upper && (extended_lower < lower || extended_upper > upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (height) lower bound greater than upper bound");
                         else if (upper <= 0.0 || lower <= 0.0)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (height) bounds lower than minor semi-axes length");
                         break;
                    }
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    {
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (height) lower bound greater than upper bound");
                         else if (upper <= 0.0 || lower <= 0.0)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (height) bounds lower than minor semi-axes length");
                         else if (extended_lower <= 0.0 || extended_lower > lower || extended_upper < upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (height) extended bounds falls within valid region");
                         break;
                    }
                }
            }
            // component 3 has no boundaries.
        }
        // spherical: lon, lat, h
        else if (srft_code == SRM_SRFT_Code.SRFTCOD_CELESTIOMAGNETIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_SOLAR_ECLIPTIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_SOLAR_EQUATORIAL ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_HELIOSPHERIC_ARIES_ECLIPTIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_ECLIPTIC ||
                 srft_code == SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_EQUATORIAL)
        {
            if (component == 1)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                        if (!(Const.isWellFormedLongitude(lower) && Const.isWellFormedLongitude(upper) &&
                              Const.isWellFormedLongitude(extended_lower) && Const.isWellFormedLongitude(extended_upper)))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
                        else if (lower == upper)
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
                        else if (lower < upper  && (extended_lower > lower || extended_upper < upper))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                        else if (lower > upper && (extended_lower < lower || extended_upper > upper))
                            throw new SrmException(SrmException._INVALID_INPUT,
                                    "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else if (component == 2)
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: component 2 (latitude) cannot be a semi-interval region");
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (!(Const.isWellFormedLatitude(lower) && Const.isWellFormedLatitude(upper) &&
                               Const.isWellFormedLatitude(extended_lower) && Const.isWellFormedLatitude(extended_upper)))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
                         else if (lower == upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) lower and upper bounds are the same");
                         else if (lower < upper && (extended_lower > lower || extended_upper < upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
                         else if (lower > upper && (extended_lower < lower || extended_upper > upper))
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
                         break;
                    }
                }
                _component_is_angular[component] = true;
            }
            else //component == 3
            {
                switch (type)
                {
                    case IVLTYP_GT_SEMI_INTERVAL:
                    case IVLTYP_GE_SEMI_INTERVAL:
                    case IVLTYP_LT_SEMI_INTERVAL:
                    case IVLTYP_LE_SEMI_INTERVAL:
                         if (upper <= lower)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 3 (height) lower bound greater than upper bound");
                         break;
                    case IVLTYP_CLOSED_INTERVAL:
                    {
                         if (upper <= 0.0 || lower <= 0.0)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
                         break;
                    }
                    case IVLTYP_OPEN_INTERVAL:
                    case IVLTYP_GE_LT_INTERVAL:
                    case IVLTYP_GT_LE_INTERVAL:
                    {
                         if (upper <= 0.0 || lower <= 0.0)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
                         else if (extended_lower <= 0.0 || extended_lower > lower || extended_upper < upper)
                             throw new SrmException(SrmException._INVALID_INPUT,
                                     "setExtendedValidRegion: component 3 (height) extended bounds falls within valid region");
                         break;
                    }
                }
            }
        }
        else
        {
            switch (type)
            {
                case IVLTYP_OPEN_INTERVAL:
                case IVLTYP_GE_LT_INTERVAL:
                case IVLTYP_GT_LE_INTERVAL:
                case IVLTYP_CLOSED_INTERVAL:
                {
                     if (upper <= lower)
                         throw new SrmException(SrmException._INVALID_INPUT,
                                 "setExtendedValidRegion: interval lower bound greater than upper bound");
                     break;
                }
            }
        }

        // allocate array if needed
        if (_component_valid_region[component-1] == null)
            _component_valid_region[component-1] = new SRM_Extended_Valid_Region_Params();

        _component_valid_region[component-1].type = type;
        _component_valid_region[component-1].extended_lower = extended_lower;
        _component_valid_region[component-1].lower = lower;
        _component_valid_region[component-1].upper = upper;
        _component_valid_region[component-1].extended_upper = extended_upper;
    }

    /** Get the Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
        method or the setExtendedValidRegion method determines
        the valid and extended valid intervals of the coordinate
        component values.
        @param component in: the coordinate component (1, 2, or 3)
        @return the valid region parameters
    */
    public SRM_Valid_Region_Params getValidRegion(int component) throws SrmException
    {
        SRM_Valid_Region_Params ret_reg = new SRM_Valid_Region_Params();

        if (component < 1 || component > 3)
            throw new SrmException(SrmException._INVALID_INPUT, "getValidRegion: component out of range [ 1, 3 ]");

        ret_reg.type = _component_valid_region[component-1].type;
        ret_reg.lower = _component_valid_region[component-1].lower;
        ret_reg.upper = _component_valid_region[component-1].upper;

        return ret_reg;
    }

    /** Get the Extended Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
        method or the setValidRegion method determines
        the valid and extended valid intervals of the coordinate
        component values.
        @param component in: the coordinate component (1, 2, or 3)
        @return the extended valid region parameters
    */
    public SRM_Extended_Valid_Region_Params getExtendedValidRegion(int component) throws SrmException
    {
        SRM_Extended_Valid_Region_Params ret_reg = new SRM_Extended_Valid_Region_Params();

        if (component < 1 || component > 3)
            throw new SrmException(SrmException._INVALID_INPUT, "getExtendedValidRegion: component out of range [ 1, 3 ]");

        ret_reg.type = _component_valid_region[component-1].type;
        ret_reg.extended_lower = _component_valid_region[component-1].extended_lower;
        ret_reg.lower = _component_valid_region[component-1].lower;
        ret_reg.upper = _component_valid_region[component-1].upper;
        ret_reg.extended_upper = _component_valid_region[component-1].extended_upper;

        return ret_reg;
    }

    /** Changes a coordinate's values to this SRF using tranformation object.
        @note The tgt coordinate must have been created using this SRF.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range (-2_PI, 2_PI).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src in: the source coordinate in some other 3D SRF
        @param hst in: the ORM 3D transformation
        @param tgt in out: the target coordinate in this 3D SRF
        @return the Valid Region of the target coordinate
    */
    public SRM_Coordinate_Valid_Region_Code changeCoordinate3DSRFObject(Coord3D src,
                                                                        SRM_ORM_Trans_3D_Params hst,
                                                                        Coord3D tgt)  throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid;
        double[] tgtValues = new double[3];

        if (src == null || tgt == null || hst == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeCoordinate3DSRFObject: null reference input parameters"));

        retValid = OpManager.instance().computeAsArray
            (src.getSRF(), this, src.getValues(), tgtValues, hst);

        tgt.setValues(tgtValues);

        return retValid;
    }


    /** Changes an array of coordinates to this SRF using tranformation object.
        @note The tgt coordinates in the tgt array must have been created using this SRF.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range (-2_PI, 2_PI).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @note all the arrays must be of same length.
        @note all the coordinate in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus one to
        indicate that the operation successfully converted all the ccordinates
        in the source array.  Otherwise, the return value is the index of the offending coordinate
        in the source array.
        @param src in: the array of source coordinates in some other 3D SRF
        @param hst in: the ORM 3D transformation object
        @param tgt out: the array of target coordinates in this 3D SRF
        @param region out: the array of valid region associated with the array of target coordinates
        @return the index of the offending coordinate in the source array when an error condition occurs.  Otherwise,
        it is the size of the source array plus one.
    */
    public int changeCoordinate3DArraySRFObject(Coord3D[]               src,
                                                SRM_ORM_Trans_3D_Params hst,
                                                Coord3D[]               tgt,
                                                SRM_Coordinate_Valid_Region_Code[] region) throws SrmException
    {
        boolean has_no_failure = true;
        double[] tgtValues = new double[3];

        if (hst == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeCoordinate3DArraySRFObject: null reference input parameters"));

        if (src.length != tgt.length || src.length != region.length)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeCoordinate3DArraySRFObject: inconsistent array size"));

        int retIndex = src.length+1;

        for (int i=0; i<src.length && has_no_failure; i++)
        {
            try
            {
                if (src[i] == null || tgt[i] == null)
                {
                    throw new SrmException(SrmException._INVALID_INPUT,
                                                new String("changeCoordinate3DArraySRFObject: null array element"));
                }
                region[i] = OpManager.instance().computeAsArray
                        (src[i].getSRF(), this, src[i].getValues(), tgtValues, hst);

                tgt[i].setValues(tgtValues);
            }
            catch (SrmException ex)
            {
                retIndex = i;
                has_no_failure = false;
            }
        }
        return retIndex;
    }


    /** Creates a direction object.
        @param ref_coord in: the 3D reference coordinate in this SRF.
        @param vec[] in: the array of size 3 containing the vector component values.  It can
        be changed after the direction is created.
        @return a direction object
        @note The input reference coordinate must have been created using this SRF.
        @note The reference coordinate cannot be changed after the direction is instantiated.

        A sample code to instantiate a Direction object is as follows:
        @code

        import SRM.*;
        ...

        try {

        // first instantiate an SRF, say CD_3D SRF in WGS 1984
        SRF_Celestiodetic CdSrf = new SRF_Celestiodetic(SRM_ORM_Code.ORM_WGS_1984,
        SRM_RT_Code.RT_WGS_1984_IDENTITY);

        // then instantiate a 3D CD_3D coordinate as the reference coordinate
        Coord3D_Celestiodetic CdCoord =
        (Coord3D_Celestiodetic)CdSrf.createCoordinate3D(Math.toRadians(10.0),
        Math.toRadians(20.0),
        100.0);

        // then instantiate the Direction object by invoking the createDirection method
        Direction dir = CdSrf.createDirection(CdCoord, { 1.0, 2.0, 3.0 });

        } catch (SrmException ex)
        ...

        // Note: The input reference coordinate is immutable.

        @endcode
    */
    public Direction createDirection(Coord3D ref_coord,
                                     double  vec[]) throws SrmException
    {
        if (ref_coord == null || vec == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("createDirection: null reference input parameter"));
        if (ref_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("createDirection: Ref. coordinate associated with different SRF"));
        if (vec.length != 3)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("createDirection: Input vector is not of size 3"));

        return new Direction (this, ref_coord, vec);
    }

    /** Creates a direction object with reference location and vector components as Double.NaN.
        @return a direction object
        @note This method is mainly intended for facilitating the creation of Direction objects
        that will be used as the target Direction for the changeDirectionSRF() method.
    */
    public Direction createDirection() throws SrmException
    {
        return new Direction(this,
                              this.createCoordinate3D(),
                              new double[]{ Double.NaN, Double.NaN, Double.NaN });
    }


    /** Retrieves the direction component values.
        @param direction in: the direction object
        @param ref_coord out: the 3D reference coordinate in this SRF
        @param vec[] out: the 3D reference coordinate in this SRF
        @note The input direction must have been created using this SRF.
        @note The input reference coordinate must have been created using this SRF.
    */
    public void getDirectionValues(Direction direction,
                                   Coord3D   ref_coord,
                                   double    vec[])  throws SrmException
    {
        if (direction == null || ref_coord == null || vec == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getDirectionValues: null reference input parameter"));

        if (direction.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getDirectionValues: Direction associated with different SRF"));

        if (ref_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getDirectionValues: Reference Coordinate associated with different SRF"));

        if (vec.length != 3)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getDirectionValues: Input vector is not of size 3"));

        double[] tmpDir = direction.getVec();

        ref_coord.setValues(direction.getInternalRefCoord().getValues());

        vec[0] = tmpDir[0];
        vec[1] = tmpDir[1];
        vec[2] = tmpDir[2];
    }

    /** Changes a direction's reference coordinate and vector to this SRF.
        @param src_dir in: the source direction in some other SRF
        @param tgt_dir out: the target direction in this SRF
    */
    public SRM_Coordinate_Valid_Region_Code changeDirectionSRF(Direction src_dir,
                                                               Direction tgt_dir) throws SrmException
    {
        if (src_dir == null || tgt_dir == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeDirectionSRF: null reference input parameter"));

        if (tgt_dir.getSRF() != this)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeDirectionSRF: Target Direction associated with different SRF"));

        SRM_Coordinate_Valid_Region_Code retValidity = SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        double[] dir_values_tgt = new double[3];

        retValidity = this.changeCoordinate3DSRF(src_dir.getInternalRefCoord(), tgt_dir.getInternalRefCoord());

        DirectionSupport.changeDirectionVector((BaseSRF_3D) src_dir.getSRF(),
                                                src_dir.getInternalRefCoord(),
                                                src_dir.getVec(),
                                                this,
                                                tgt_dir.getInternalRefCoord(),
                                                dir_values_tgt);

        tgt_dir.setVec(dir_values_tgt);

        return retValidity;
    }


    /** Changes an array of directions to this SRF.
        @note all the arrays must be of same length.
        @note all the directions in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus one to
        indicate that the operation successfully converted all the directions
        in the source array.  Otherwise, the return value is the index of the offending direction
        in the source array.
        @param src_dir in: the array of source direction in some other 3D SRF
        @param tgt_dir out: the array of target direction in this 3D SRF
        @param region out: the array of valid region associated with the array of target direction
        @return the index of the offending direction in the source array when an error condition occurs.  Otherwise,
        it is the size of the source array plus one.
    */
    public int changeDirectionArraySRF(Direction[]                        src_dir,
                                       Direction[]                        tgt_dir,
                                       SRM_Coordinate_Valid_Region_Code[] region) throws SrmException
    {
        boolean has_no_failure = true;
        double[] dir_values_tgt = new double[3];

        if (src_dir.length != tgt_dir.length || src_dir.length != region.length)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeDirectionArraySRF: inconsistent array size"));

        int retIndex = src_dir.length+1;

        for (int i=0; i<src_dir.length && has_no_failure; i++)
        {
            try
            {
                if (src_dir[i] == null || tgt_dir[i] == null)
                {
                    throw new SrmException(SrmException._INVALID_INPUT,
                                            new String("changeDirectionArraySRF: null array element"));
                }
                region[i] = this.changeCoordinate3DSRF(src_dir[i].getInternalRefCoord(), tgt_dir[i].getInternalRefCoord());

                DirectionSupport.changeDirectionVector((BaseSRF_3D) src_dir[i].getSRF(),
                                                        src_dir[i].getInternalRefCoord(),
                                                        src_dir[i].getVec(),
                                                        this,
                                                        tgt_dir[i].getInternalRefCoord(),
                                                        dir_values_tgt);

                tgt_dir[i].setVec(dir_values_tgt);
            }
            catch (SrmException ex)
            {
                retIndex = i;
                has_no_failure = false;
            }
        }
        return retIndex;
    }


    /** Changes a direction's values to this SRF using tranformation object.
        @note The tgt direction must have been created using this SRF.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range (-2_PI, 2_PI).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src_dir in: the source direction in some other SRF
        @param hst in: the ORM 3D transformation
        @param tgt_dir out: the target direction in this SRF
        @return valid region category for the reference location associated with the target direction
    */
    public SRM_Coordinate_Valid_Region_Code changeDirectionSRFObject(Direction               src_dir,
                                                                     SRM_ORM_Trans_3D_Params hst,
                                                                     Direction               tgt_dir) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid =
           SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED;

        if (src_dir == null || tgt_dir == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeDirectionSRF: null reference input parameter"));

        if (tgt_dir.getSRF() != this)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeDirectionSRF: Target Direction associated with different SRF"));

        double[] dir_values_tgt = new double[3];

        try
        {
            retValid = this.changeCoordinate3DSRFObject(src_dir.getInternalRefCoord(), hst, tgt_dir.getInternalRefCoord());
        }
        catch (SrmException ex)
        {
            throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                    new String("changeDirectionSRFObject: change reference coodinate SRF not possible"));
        }
        DirectionSupport.changeDirectionVector((BaseSRF_3D) src_dir.getSRF(),
                                                src_dir.getInternalRefCoord(),
                                                src_dir.getVec(),
                                                this,
                                                tgt_dir.getInternalRefCoord(),
                                                dir_values_tgt);

        tgt_dir.setVec(dir_values_tgt);

        return retValid;
    }

    /** Changes an array of directions to this SRF using tranformation object.
        @note all the arrays must be of same length.
        @note all the directions in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus one to
        indicate that the operation successfully converted all the directions
        in the source array.  Otherwise, the return value is the index of the offending direction
        in the source array.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range (-2_PI, 2_PI).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src_dir in: the array of source direction in some other 3D SRF
        @param hst in: the ORM 3D transformation
        @param tgt_dir out: the array of target direction in this 3D SRF
        @param region out: the array of valid region associated with the array of target direction
        @return the index of the offending direction in the source array when an error condition occurs.  Otherwise,
        it is the size of the source array plus one.
    */
    public int changeDirectionArraySRFObject(Direction[]             src_dir,
                                             SRM_ORM_Trans_3D_Params hst,
                                             Direction[]             tgt_dir,
                                             SRM_Coordinate_Valid_Region_Code[] region) throws SrmException
    {
        boolean has_no_failure = true;
        double[] dir_values_tgt = new double[3];

        if (src_dir.length != tgt_dir.length || src_dir.length != region.length)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("changeDirectionArraySRF: inconsistent array size"));

        int retIndex = src_dir.length+1;

        for (int i=0; i<src_dir.length && has_no_failure; i++)
        {
            try
            {
                if (src_dir[i] == null || tgt_dir[i] == null)
                {
                    throw new SrmException(SrmException._INVALID_INPUT,
                                            new String("changeDirectionArraySRF: null array element"));
                }
                region[i] = this.changeCoordinate3DSRFObject(src_dir[i].getInternalRefCoord(),
                                                             hst,
                                                             tgt_dir[i].getInternalRefCoord());

                DirectionSupport.changeDirectionVector((BaseSRF_3D) src_dir[i].getSRF(),
                                                        src_dir[i].getInternalRefCoord(),
                                                        src_dir[i].getVec(),
                                                        this,
                                                        tgt_dir[i].getInternalRefCoord(),
                                                        dir_values_tgt);

                tgt_dir[i].setVec(dir_values_tgt);
            }
            catch (SrmException ex)
            {
                retIndex = i;
                has_no_failure = false;
            }
        }
        return retIndex;
    }


    /** Check a direction in this SRF.
        @note The input direction object must have been created using this SRF.
        @param direction in: the direction in this SRF
        @return the coordinate valid region code in the direction's SRF
    */
    public SRM_Coordinate_Valid_Region_Code checkDirection(Direction direction) throws SrmException
    {
        if (direction == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("checkDirection: null reference input parameter"));

        if (direction.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("checkDirection: direction associated with different SRF"));

        SRM_Coordinate_Valid_Region_Code retReg = null;

        retReg = this.checkCoordinate(direction.getInternalRefCoord());

        double [] vec = direction.getVec();

        if (vec[0]*vec[0] + vec[1]*vec[1] + vec[2]*vec[2] <= Const.EPSILON_SQ)
            throw new SrmException(SrmException._INVALID_SOURCE_DIRECTION,
                                    new String("checkDirection: Direction vector magnitude ~ 0.0 "));

        return retReg;
    }

    private class LTP_vec
    {
        double[] r = new double[3];
        double[] s = new double[3];
    }

    /** This method creates an Orientation object representing the orientation
        of the source srf (at the source reference point) with respect to this (the
        target) srf (at the target reference point).  The Orientation is computed as
        the cosine matrix of the source local tangent frame with respect to the target
        local tangent frame.
        @param src_ref_point in : the source reference point
        @param tgt_ref_point in : the target reference point in this SRF
        @param out_ori out : the resulting orientation
    */
    public void computeSRFOrientation(Coord3D     src_ref_point,
                                      Coord3D     tgt_ref_point,
                                      Orientation out_ori) throws SrmException
    {
        if (tgt_ref_point.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                    "createSRFOrientation: Target reference coordinate associated with a different SRF");

        LTP_vec src_vec = compLTP(src_ref_point.getSRF(), src_ref_point);
        LTP_vec tgt_vec = compLTP(this, tgt_ref_point);

        out_ori._set_matrix_base(comp_ori_mat(src_vec, tgt_vec));
        out_ori._updateRepData();
    }

    /** Computes the parameters corresponding to the local tangent frame
        at the input reference coordinate.
        @param ref_point in : the reference point
        @return the parameters for the local tangent frame, which are
        the parameters for the Lococentric Euclidean 3D SRF at the reference coordinate
    */
    public SRF_LCE_3D_Params
        getLocalTangentFrameSRFParameters (Coord3D ref_point) throws SrmException
    {
        SRF_LCE_3D_Params ltf = new SRF_LCE_3D_Params();

        if (ref_point.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   "getLocalTangentFrameSRFParameters: " +
                      "Reference coordinate associated with a different SRF");

        // Convert reference point to CC coord
        if (ref_point.getClassType() == Coord_ClassType.LSR_3D)
        {
            ltf.lococentre[0] = 0.0;
            ltf.lococentre[1] = 0.0;
            ltf.lococentre[2] = 0.0;
        }
        else if (ref_point.getClassType() == Coord_ClassType.CC_3D) // do nothing
        {
            ltf.lococentre[0] = ref_point.getValues()[0];
            ltf.lococentre[1] = ref_point.getValues()[1];
            ltf.lococentre[2] = ref_point.getValues()[2];
        }
        else // do the normal coordinate SRF
        {
            /* Reconvert to MP to CC */
            double[] tempCcCoord = interimConv(ref_point,
                                            SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);

            ltf.lococentre[0] = tempCcCoord[0];
            ltf.lococentre[1] = tempCcCoord[1];
            ltf.lococentre[2] = tempCcCoord[2];
        }
        LTP_vec ltp = compLTP(this, ref_point);
        System.arraycopy(ltp.r, 0, ltf.primary_axis, 0, 3);
        System.arraycopy(ltp.s, 0, ltf.secondary_axis, 0, 3);

        return ltf;
    }


    /** Given an orientation with respect to a local tangent frame (LTF_S) associated
        with a reference location in the source SRF, this method computes the orientation
        with respect to the local tangent frame (LTF_T) associated with the specified
        reference location in the target SRF. The output orientation is computed by composing
        the orientation of LTF_S with respect to LTF_T with the input source orientation.
        The SRF invoking this method is the target SRF.
         @param src_ref_loc in : the source reference location (a coordinate in the source
                                SRF) where the origin of the source local tangent frame
                                (LTF_S) is located
         @param src_ori in : the source orientation of some linear reference frame with
                            respect to LTF_S
         @param tgt_ref_loc in : the target reference location (a coordinate in this SRF,
                                the target SRF) where the origin of the target local tangent
                                frame (LTF_T) is located
        @param tgt_ori out : the target orientation with respect to LTF_T
    */
    public void transformOrientation(Coord3D     src_ref_loc,
                                     Orientation src_ori,
                                     Coord3D     tgt_ref_loc,
                                     Orientation tgt_ori) throws SrmException
    {
        OrientationMatrix ori_st = new OrientationMatrix();

        if (tgt_ref_loc.getSRF() != this)
            throw new SrmException(SrmException._INVALID_TARGET_COORDINATE,
                                    "transformOrientation: Target reference location associated with a different SRF");

        computeSRFOrientation(src_ref_loc, tgt_ref_loc, ori_st);

        tgt_ori = OrientationMatrix.compose(ori_st, src_ori);
    }


    /** Given an orientation with respect to a local tangent frame (LTF_S) associated
        with a reference location in the source SRF, this method computes the orientation
        with respect to the local tangent frame (LTF_T) associated with the specified
        reference location in the target SRF.  LTF_S and LTF_T have a common origin.  The
        output orientation is computed by composing the orientation of LTF_S with respect
        to LTF_T with the input source orientation.  The SRF invoking this method is the
        target SRF.
         @param src_ref_loc in : the source reference location (a coordinate in the source
                                SRF) where the origin of the source local tangent frame
                                (LTF_S) is located
         @param src_ori in : the source orientation of some linear reference frame with
                            respect to LTF_S
         @param tgt_ref_loc out : the coordinate of the common reference location in the
                                 target SRF
        @param tgt_ori out : the target orientation with respect to LTF_T
        @return valid region category for the target reference location
    */
    public SRM_Coordinate_Valid_Region_Code
        transformOrientationCommonOrigin(Coord3D     src_ref_loc,
                                         Orientation src_ori,
                                         Coord3D     tgt_ref_loc,
                                         Orientation tgt_ori) throws SrmException
    {
        OrientationMatrix ori_st = new OrientationMatrix();
        SRM_Coordinate_Valid_Region_Code ret_reg;

        if (tgt_ref_loc.getSRF() != this)
            throw new SrmException(SrmException._INVALID_TARGET_COORDINATE,
                                    "transformOrientationCommonOrigin: Target reference location associated with a different SRF");

        ret_reg = this.changeCoordinate3DSRF(src_ref_loc, tgt_ref_loc);

        computeSRFOrientation(src_ref_loc, tgt_ref_loc, ori_st);

        tgt_ori = OrientationMatrix.compose(ori_st, src_ori);

        return ret_reg;
    }


    /** Given a vector in a body frame (or in general any linear reference frame) whose
        orientation with respect to the local tangent frame (LTF_S) that is associated with a reference
        location in the source SRF, this method computes the vector in the local tangent frame
        (LTF_T) associated with the specified reference location in the target SRF.  The output vector
        is computed by applying the composed orientation, from the orientation of LTF_S with
        respect to LTF_T with the source orientation, to the source vector. This method is
        equivalent to applying the orientation result from the transformOrientation method to
        the source vector.  The SRF invoking this method is the target SRF.
        @note The input/output arrays are of size 3.
         @param src_ref_loc in : the source reference location (a coordinate in the source
                                SRF) where the origin of the source local tangent frame
                                (LTF_S) is located
         @param src_ori in : the source orientation of some linear reference frame L with
                            respect to LTF_S
         @param src_vec in : the input vector in L
         @param tgt_ref_loc in : the target reference location (a coordinate in this SRF,
                                the target SRF) where the origin of the target local tangent
                                frame (LTF_T) is located
        @param tgt_vec out : the target vector in LTF_T
    */
    public void transformVectorInBodyFrame(Coord3D     src_ref_loc,
                                           Orientation src_ori,
                                           double[]    src_vec,
                                           Coord3D     tgt_ref_loc,
                                           double[]    tgt_vec) throws SrmException
    {
        OrientationMatrix ori_st = new OrientationMatrix();

        if (tgt_ref_loc.getSRF() != this)
            throw new SrmException(SrmException._INVALID_TARGET_COORDINATE,
                                    "transformVectorInBodyFrame: Target reference location associated with a different SRF");

        computeSRFOrientation(src_ref_loc, tgt_ref_loc, ori_st);

        tgt_vec = OrientationMatrix.compose(ori_st, src_ori).transformVector(src_vec);
    }


    /** Given a vector in a body frame (or in general any linear reference frame) whose
        orientation with respect to the local tangent frame (LTF_S) that is associated with a reference
        location in the source SRF, this method computes the vector in the local tangent frame
        (LTF_T) associated with the specified reference location in the target SRF.
        LTF_S and LTF_T have a common origin.  The output vector
        is computed by applying the composed orientation, from the orientation of LTF_S with
        respect to LTF_T with the source orientation, to the source vector. This method is
        equivalent to applying the orientation result from the transformOrientation method to
        the source vector.  The SRF invoking this method is the target SRF.
        @note The input/output arrays are of size 3.
         @param src_ref_loc in : the source reference location (a coordinate in the source
                                SRF) where the origin of the source local tangent frame
                                (LTF_S) is located
         @param src_ori in : the source orientation of some linear reference frame L with
                            respect to LTF_S
         @param src_vec in : the input vector in L
         @param tgt_ref_loc out : the coordinate of the common reference location in the
                                 target SRF
        @param tgt_vec out : the target vector in LTF_T
        @return valid region category for the target reference location
    */
    public SRM_Coordinate_Valid_Region_Code
        transformVectorInBodyFrameCommonOrigin(Coord3D     src_ref_loc,
                                               Orientation src_ori,
                                               double[]    src_vec,
                                               Coord3D     tgt_ref_loc,
                                               double[]    tgt_vec) throws SrmException
    {
        OrientationMatrix ori_st = new OrientationMatrix();
        SRM_Coordinate_Valid_Region_Code ret_reg;

        if (tgt_ref_loc.getSRF() != this)
            throw new SrmException(SrmException._INVALID_TARGET_COORDINATE,
                                    "transformVectorInBodyFrameCommonOrigin: Target reference location associated with a different SRF");

        ret_reg = this.changeCoordinate3DSRF(src_ref_loc, tgt_ref_loc);

        computeSRFOrientation(src_ref_loc, tgt_ref_loc, ori_st);

        tgt_vec = OrientationMatrix.compose(ori_st, src_ori).transformVector(src_vec);

        return ret_reg;
    }


    /** Given a vector in the local tangent frame (LTF_S) associated with a reference
        location in the source SRF, this method computes the vector in the local tangent
        frame (LTF_T) associated with the specified reference location in the target SRF.
        The output vector is computed by applying the orientation of LTF_S with respect to
        LTF_T to the source vector. The SRF invoking this method is the target SRF.
         @note The input/output arrays are of size 3.
        @param src_ref_loc in : the source reference location (a coordinate in the source
                                SRF) where the origin of the source local tangent frame
                                (LTF_S) is located
         @param src_vec in : the source vector in LTF_S
         @param tgt_ref_loc in : the target reference location (a coordinate in this SRF,
                                the target SRF) where the origin of the target local tangent
                                frame (LTF_T) is located
        @param tgt_vec out : the target vector in LTF_T
    */
    public void transformVector(Coord3D  src_ref_loc,
                                double[] src_vec,
                                Coord3D  tgt_ref_loc,
                                double[] tgt_vec) throws SrmException
    {
        OrientationMatrix ori_st = new OrientationMatrix();

        if (tgt_ref_loc.getSRF() != this)
            throw new SrmException(SrmException._INVALID_TARGET_COORDINATE,
                                    "transformVector: Target reference location associated with a different SRF");

        computeSRFOrientation(src_ref_loc, tgt_ref_loc, ori_st);

        tgt_vec = ori_st.transformVector(src_vec);
    }


    /** Given a vector in the local tangent frame (LTF_S) associated with a reference
        location in the source SRF, this method computes the vector in the local tangent
        frame (LTF_T) associated with the specified reference location in the target SRF.
        LTF_S and LTF_T have a common origin.  The output vector is computed by applying
        the orientation of LTF_S with respect to LTF_T to the source vector. The SRF
        invoking this method is the target SRF.
        @note The input/output arrays are of size 3.
         @param src_ref_loc in : the source reference location (a coordinate in the source
                                SRF) where the origin of the source local tangent frame
                                (LTF_S) is located
         @param src_vec in : the source vector in LTF_S
         @param tgt_ref_loc out : coordinate of the common reference location in the
                                 target SRF
        @param tgt_vec out : the target vector in LTF_T
        @return valid region category for the target reference location
    */
    public SRM_Coordinate_Valid_Region_Code transformVectorCommonOrigin(Coord3D  src_ref_loc,
                                                                        double[] src_vec,
                                                                        Coord3D  tgt_ref_loc,
                                                                        double[] tgt_vec) throws SrmException
    {
        OrientationMatrix ori_st = new OrientationMatrix();
        SRM_Coordinate_Valid_Region_Code ret_reg;

        if (tgt_ref_loc.getSRF() != this)
            throw new SrmException(SrmException._INVALID_TARGET_COORDINATE,
                                    "transformVectorCommonOrigin: Target reference location associated with a different SRF");

        ret_reg = this.changeCoordinate3DSRF(src_ref_loc, tgt_ref_loc);

        computeSRFOrientation(src_ref_loc, tgt_ref_loc, ori_st);

        tgt_vec = ori_st.transformVector(src_vec);

        return ret_reg;
    }

    /** creates a Loccentric Euclidean 3D SRF whose origin in at the input lococentre and the
        primary and secodary axes are aligned with the input direction axes.
         @param lococentre in : the lococentre of the SRF
        @param primary_axis in : the direction of the primary axis
        @param secondary_axis in : the direction of the secondary axis
        @return an instance of Lococentric Euclidean 3D SRF
        @exception This method throws srm::Exception
    */
    public SRF_LococentricEuclidean3D
        createLococentricEuclidean3DSRF(Coord3D lococentre,
                                        Direction primary_axis,
                                        Direction secondary_axis) throws SrmException
    {
        if (lococentre.getSRF() != this)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    "createLococentricEuclidean3DSRF: lococentre associated with a different SRF ");

        if (primary_axis.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_DIRECTION,
                                    "createLococentricEuclidean3DSRF: primary axis associated with a different SRF");

        if (secondary_axis.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_DIRECTION,
                                    "createLococentricEuclidean3DSRF: secondary axis associated with a different SRF");

        SRF_LCE_3D_Params lce_params = new SRF_LCE_3D_Params();
        LTP_vec ltp_pri = new LTP_vec();
        LTP_vec ltp_sec = new LTP_vec();
        double[] pri_t = new double[3];
        double[] sec_t = new double[3];
        double dot_proc = 0.0;

        try
        {
            System.arraycopy(interimConv(lococentre,
                             SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC),
                             0, lce_params.lococentre, 0, 3);
        }
        catch (SrmException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
                                    "createLococentricEuclidean3DSRF: Unable to determine lococentre");
        }
        ltp_pri = compLTP(this, primary_axis.getRefCoord());

        System.arraycopy(Const.cross_product(ltp_pri.r,  ltp_pri.s), 0, pri_t, 0, 3);

        if (primary_axis.getRefCoord().isEqual(secondary_axis.getRefCoord()))
        {
            System.arraycopy(ltp_pri.r, 0, ltp_sec.r, 0, 3);
            System.arraycopy(ltp_pri.s, 0, ltp_sec.s, 0, 3);
            System.arraycopy(pri_t, 0, sec_t, 0, 3);
        }
        else
        {
            ltp_sec = compLTP(this, secondary_axis.getRefCoord());

            System.arraycopy(Const.cross_product(ltp_sec.r,  ltp_sec.s), 0, sec_t, 0, 3);
        }
        Const.ConstTimesVect(ltp_pri.r, primary_axis.getVectorComp1());
        Const.ConstTimesVect(ltp_pri.s, primary_axis.getVectorComp2());
        Const.ConstTimesVect(pri_t, primary_axis.getVectorComp3());

        lce_params.primary_axis = Const.vectSum(pri_t, Const.vectSum(ltp_pri.r, ltp_pri.s));

        Const.ConstTimesVect(ltp_sec.r, secondary_axis.getVectorComp1());
        Const.ConstTimesVect(ltp_sec.s, secondary_axis.getVectorComp2());
        Const.ConstTimesVect(sec_t, secondary_axis.getVectorComp3());

        lce_params.secondary_axis = Const.vectSum(sec_t, Const.vectSum(ltp_sec.r, ltp_sec.s));

        if (!(Const.isEqual(Const.vectDotProd(lce_params.primary_axis,
                                              lce_params.secondary_axis),
                                              0.0, Const.EPSILON)))
            throw new SrmException(SrmException._INVALID_INPUT,
                                    "createLococentricEuclidean3DSRF: the input direction vectors are not orthogonal");

        Const.normalizeDirection(lce_params.primary_axis);
        Const.normalizeDirection(lce_params.secondary_axis);

        return (new SRF_LococentricEuclidean3D(this.getOrm(),
                                               this.getRt(),
                                               lce_params));
    }


    /** Returns the euclidean distance between two coordinates.
        @param coord1 in: a coordinate in some SRF
        @param coord2 in: a coordinate in some SRF
        @return the Euclidean distance between the two Coord3D coordinates (in meters).
        @note The input coordinates do not need to be from the same SRF.
        @note This method will make (and cache) internal conversions when the inputs coordinates
        are from SRFs other than SRF_Celestiocentric.
    */
    public static double calculateEuclideanDistance(Coord3D coord1,
                                                    Coord3D coord2) throws SrmException
    {
        double[] tempCcSrcCoord = new double[3];
        double[] tempCcTgtCoord = new double[3];

        double delta_x,delta_y,delta_z;

        /*Check for null reference*/
        if (coord1 == null || coord2 == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("calculateEuclideanDistance: null reference input parameter"));

        /*Test to see if the source and target SRF's are both for the same body*/
        if (OrmDataSet.getElem(coord1.getSRF().getOrm())._reference_orm !=
            OrmDataSet.getElem(coord2.getSRF().getOrm())._reference_orm)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("calculateEuclideanDistance: coordinates" +
                                               " associated with different reference ORMs"));

        // converting source coordinate to celestiocentric SRF
        tempCcSrcCoord = interimConv(coord1, SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);

        // converting target coordinate to celestiocentric SRF
        tempCcTgtCoord = interimConv(coord2, SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);

        delta_x = tempCcSrcCoord[0] - tempCcTgtCoord[0];
        delta_y = tempCcSrcCoord[1] - tempCcTgtCoord[1];
        delta_z = tempCcSrcCoord[2] - tempCcTgtCoord[2];

        return Math.sqrt(Const.square(delta_x) +
                          Const.square(delta_y) +
                          Const.square(delta_z));
    }


    /** Computes the natural SRF Set member code (region) where the 3D coordinate is
        located in the target SRF Set.
        @note The input coordinate must have been created using this SRF.
        @param src_coord in : the source 3D coordinate in an SRF
        @param orm_dst in : the ORM for the destination SRF Set
        @param rt_dst in : the RT for the destination SRF Set
        @param tgt_srfs in : the destination SRF Set Code
        @return the SRF Set Member code for the destination SRF Set
    */
    public SRM_SRFSM_Code getNaturalSRFSetMemberCode(Coord3D       src_coord,
                                                     SRM_ORM_Code  orm_dst,
                                                     SRM_RT_Code   rt_dst,
                                                     SRM_SRFS_Code tgt_srfs) throws SrmException
    {
        if (src_coord == null || orm_dst == null || rt_dst == null || tgt_srfs == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getNaturalSRFSetMemberCode: null reference input parameter"));

        if (src_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getNaturalSRFSetMemberCode: Coordinate associated with different SRF"));

        return getMemberCode(src_coord.getValues(), orm_dst, rt_dst, tgt_srfs);
    }


    /** Returns the natural SRF Set member instance that the 3D coordinate is
        located in the target SRF Set.
        @note The input coordinate must have been created using this SRF.
        @param src_coord in : the source 3D coordinate in an SRF
        @param orm_dst in : the ORM for the destination SRF Set
        @param rt_dst in : the RT for the destination SRF Set
        @param tgt_srfs in : the destination SRF Set Code
        @return the SRF Set Member instance for the destination SRF Set
    */
    public BaseSRF_3D getNaturalSRFSetMember(Coord3D src_coord,
                                             SRM_ORM_Code orm_dst,
                                             SRM_RT_Code rt_dst,
                                             SRM_SRFS_Code tgt_srfs) throws SrmException
    {
        if (src_coord == null || orm_dst == null || rt_dst == null || tgt_srfs == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getNaturalSRFSetMemberCode: null reference input parameter"));

        if (src_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getNaturalSRFSetMemberCode: Coordinate associated with different SRF"));

        SRM_SRFSM_Code tmpMemberCode;

        tmpMemberCode = getMemberCode(src_coord.getValues(), orm_dst, rt_dst, tgt_srfs);

        return (BaseSRF_3D)CreateSRF.srfSetMember(tgt_srfs, tmpMemberCode, orm_dst, rt_dst);
    }


    protected SRM_SRFSM_Code getMemberCode(double[] src_coord,
                                           SRM_ORM_Code orm_dst,
                                           SRM_RT_Code rt_dst,
                                           SRM_SRFS_Code tgt_srfs) throws SrmException
    {
        SRM_SRFT_Code myBoundaryTemplateSrf;
        BaseSRF tmpSrf;
        double[] coord_tgt = new double[3];
        SRM_SRFSM_Code retSetMember;

        if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_UNSPECIFIED)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getNaturalSRFSetMemberCode: UNSPECIFIED SRF Set is not valid for this operation"));


        // instantiate cache for the SRF if not already created
        if (this._internalSRFs == null)
            this._internalSRFs = new HashMap<String, BaseSRF>();

        tmpSrf = (BaseSRF)this._internalSRFs.get("TgtBoundSrfT"+orm_dst+tgt_srfs);

        // create an interim boundary SRF using SRF's local cache
        if (tmpSrf == null)
        {
            myBoundaryTemplateSrf = CoordCheck.getsrfsBoundaryDefTemplate(tgt_srfs);

            tmpSrf = CreateSRF.fromCode(myBoundaryTemplateSrf,
                                         orm_dst,
                                         rt_dst);

                            // cache the created interim SRF
            this._internalSRFs.put("NatRegTgtBoundSrfT"+orm_dst+tgt_srfs, tmpSrf);
        }

        try
        {
            // convert src coord to the interin Celestiodetic (in this case) coord.
            OpManager.instance().computeAsArray(this,
                                                tmpSrf,
                                                src_coord,
                                                coord_tgt,
                                                null);
        }
        catch (SrmException ex)
        {
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                    new String("No natural set member code for this coordinate"));
        }

        if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_ALABAMA_SPCS)
            retSetMember = NaturalSetMember.forALSP(coord_tgt);
        else if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_LAMBERT_NTF)
            retSetMember = NaturalSetMember.forLAMBERT_NTF(coord_tgt);
        else if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_GTRS_GLOBAL_COORDINATE_SYSTEM)
            retSetMember = NaturalSetMember.forGTRS(coord_tgt);
        else if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_JAPAN_RECTANGULAR_PLANE_CS)
            retSetMember = NaturalSetMember.forJPRP(coord_tgt);
        else if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC)
            retSetMember = NaturalSetMember.forUPS(coord_tgt);
        else if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR)
            retSetMember = NaturalSetMember.forUTM(coord_tgt);
        else if (tgt_srfs == SRM_SRFS_Code.SRFSCOD_WISCONSIN_SPCS)
            retSetMember = NaturalSetMember.forWISP(coord_tgt);
        else
            throw new SrmException(SrmException._INACTIONABLE,
                                    new String("getNaturalSRFSetMemberCode: Inactionable error"));

        return retSetMember;
    }

    // Compute LTP for the LCE_3D r and s parameters
    protected LTP_vec compLTP(BaseSRF srf,
                               Coord3D coord) throws SrmException
    {
        LTP_vec ltp = new LTP_vec();

        switch (srf.getCSCode())
        {
            case CSCOD_UNSPECIFIED:
                 throw new SrmException(SrmException._INACTIONABLE,
                                        "Received SRF with CSCOD_UNSPECIFIED");
            case CSCOD_EUCLIDEAN_3D:
                 ltp.r[0] = 1.0;
                 ltp.s[1] = 1.0;
                 break;
            case CSCOD_LOCOCENT_EUCLIDEAN_3D:
            {
                 switch (srf.getSRFTemplateCode())
                 {
                     case SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN:
                     {
                         double slon =
                             Math.sin(((SRF_LocalTangentSpaceEuclidean)srf).get_geodetic_longitude());
                         double clon =
                             Math.cos(((SRF_LocalTangentSpaceEuclidean)srf).get_geodetic_longitude());
                         double slat =
                             Math.sin(((SRF_LocalTangentSpaceEuclidean)srf).get_geodetic_latitude());
                         double clat =
                             Math.cos(((SRF_LocalTangentSpaceEuclidean)srf).get_geodetic_latitude());
                         double sa =
                             Math.sin(((SRF_LocalTangentSpaceEuclidean)srf).get_azimuth());
                         double ca =
                             Math.cos(((SRF_LocalTangentSpaceEuclidean)srf).get_azimuth());
                         ltp.r[0] = -slon*ca+clon*slat*sa;
                         ltp.r[1] =  clon*ca+slon*slat*sa;
                         ltp.r[2] = -clat*sa;
                         ltp.s[0] = -slon*sa-clon*slat*ca;
                         ltp.s[1] =  clon*sa-slon*slat*ca;
                         ltp.s[2] =  clat*ca;
                         break;
                     }
                     case SRFTCOD_LOCOCENTRIC_EUCLIDEAN_3D:
                     {
                         System.arraycopy(((SRF_LococentricEuclidean3D)srf).get_primary_axis(), 0, ltp.r, 0, 3);
                         System.arraycopy(((SRF_LococentricEuclidean3D)srf).get_secondary_axis() , 0, ltp.s, 0, 3);
                         break;
                     }
                     case SRFTCOD_LOCAL_SPACE_RECT_3D:
                     {
                         throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                                 "unable to determine local tangent frame for abstract LSR_3D");
                     }
                     default:
                         throw new SrmException(SrmException._INACTIONABLE,
                                                 "Received SRF with CSCOD_UNSPECIFIED");
                 }
             }
             break;
        case CSCOD_EQUATORIAL_SPHERICAL:
        {
            double lon = coord.getValues()[0]; // longitude
            double lat = coord.getValues()[1]; // using geocentric latitude
            double slon = Math.sin(lon);
            double clon = Math.cos(lon);
            double slat = Math.sin(lat);
            double clat = Math.cos(lat);
            ltp.r[0] = -slon;
            ltp.r[1] =  clon;
            ltp.r[2] = 0.0;
            ltp.s[0] = -slat*clon;
            ltp.s[1] = -slat*slon;
            ltp.s[2] =  clat;
            break;
        }
        case CSCOD_GEODETIC:
        {
            double lon = coord.getValues()[0]; // longitude
            double lat = coord.getValues()[1]; // using geodetic latitude
            double slon = Math.sin(lon);
            double clon = Math.cos(lon);
            double slat = Math.sin(lat);
            double clat = Math.cos(lat);
            ltp.r[0] = -slon;
            ltp.r[1] =  clon;
            ltp.r[2] = 0.0;
            ltp.s[0] = -slat*clon;
            ltp.s[1] = -slat*slon;
            ltp.s[2] = clat;
            break;
        }
        case CSCOD_PLANETODETIC:
        {
            double lat = coord.getValues()[0]; //latitude
            double lon = coord.getValues()[1]; //longitude
            double slon = Math.sin(lon);
            double clon = Math.cos(lon);
            double slat = Math.sin(lat);
            double clat = Math.cos(lat);
            ltp.r[0] = -slat*clon;
            ltp.r[1] = -slat*slon;
            ltp.r[2] = clat;
            ltp.s[0] =  slon;
            ltp.s[1] = -clon;
            ltp.s[2] = 0.0;
            break;
        }
        case CSCOD_OBLIQUE_MERCATOR_SPHERICAL:
        case CSCOD_TRANSVERSE_MERCATOR:
        case CSCOD_LAMBERT_CONFORMAL_CONIC:
        case CSCOD_POLAR_STEREOGRAPHIC:
        {
            /* Reconvert to MP to CD */
            double[] tempCdCoord = interimConv(coord,
                                                SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

            if (((BaseSRF_MapProjection)srf)._ormData == null)
                    ((BaseSRF_MapProjection)srf)._ormData = new OrmData(srf.getOrm());

            // compute com
            double com = ((BaseSRF_MapProjection)srf).comCalculation(((BaseSRF_MapProjection)srf)._ormData, tempCdCoord);

            double lon = tempCdCoord[0];
            double lat = tempCdCoord[1];
            double slon = Math.sin(lon);
            double clon = Math.cos(lon);
            double slat = Math.sin(lat);
            double clat = Math.cos(lat);
            double scom = Math.sin(com);
            double ccom = Math.cos(com);
            ltp.r[0] = -slon*ccom+clon*slat*scom;
            ltp.r[1] =  clon*ccom+slon*slat*scom;
            ltp.r[2] = -clat*scom;
            ltp.s[0] = -slon*scom-clon*slat*ccom;
            ltp.s[1] =  clon*scom-slon*slat*ccom;
            ltp.s[2] =  clat*ccom;
            break;
        }
        // COM = 0 cases
        case CSCOD_MERCATOR:
        case CSCOD_EQUIDISTANT_CYLINDRICAL:
        {
            /* Reconvert to MP to CD */
            double[] tempCdCoord = interimConv(coord,
                                                SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

            if (((BaseSRF_MapProjection)srf)._ormData == null)
                ((BaseSRF_MapProjection)srf)._ormData = new OrmData(srf.getOrm());

            double lon = tempCdCoord[0];
            double lat = tempCdCoord[1];
            double slon = Math.sin(lon);
            double clon = Math.cos(lon);
            double slat = Math.sin(lat);
            double clat = Math.cos(lat);
            ltp.r[0] = -slon;
            ltp.r[1] =  clon;
            ltp.r[2] =  0.0;
            ltp.s[0] = -slat;
            ltp.s[1] = -slat*slon;
            ltp.s[2] =  clat;
            break;
        }
        case CSCOD_LOCOCENT_AZIMUTHAL_SPHERICAL:
        {
            double alpha  = coord.getValues()[0];
            double theta = coord.getValues()[2];

            double salpha = Math.sin(alpha);
            double calpha = Math.cos(alpha);
            double stheta = Math.sin(theta);
            double ctheta = Math.cos(theta);
            ltp.r[0] =  calpha;
            ltp.r[1] = -salpha;
            ltp.r[2] =  0.0;
            ltp.s[0] =  ctheta*salpha;
            ltp.s[1] =  ctheta*calpha;
            ltp.s[2] =  stheta;
            break;
        }
        case CSCOD_LOCOCENTRIC_CYLINDRICAL:
        {
            double theta = coord.getValues()[1];

            double stheta = Math.sin(theta);
            double ctheta = Math.cos(theta);
            ltp.r[0] =  ctheta;
            ltp.r[1] =  stheta;
            ltp.r[2] =  0.0;
            ltp.s[0] = -stheta;
            ltp.s[1] =  ctheta;
            ltp.s[2] =  0.0;
            break;
        }
        default:
             throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                 "compute LTP: operation not supported for this SRF");
        }
        return ltp;
    }

    protected SRM_Matrix_3x3 comp_ori_mat(LTP_vec src, LTP_vec tgt)
    {
        SRM_Matrix_3x3 mat = new SRM_Matrix_3x3();

        double[] src_t = Const.cross_product(src.r, src.s);
        double[] tgt_t = Const.cross_product(tgt.r, tgt.s);

        mat.m[0][0] = Const.dot_product(src.r, tgt.r);
        mat.m[0][1] = Const.dot_product(src.s, tgt.r);
        mat.m[0][2] = Const.dot_product(src_t, tgt.r);
        mat.m[1][0] = Const.dot_product(src.r, tgt.s);
        mat.m[1][1] = Const.dot_product(src.s, tgt.s);
        mat.m[1][2] = Const.dot_product(src_t, tgt.s);
        mat.m[2][0] = Const.dot_product(src.r, tgt_t);
        mat.m[2][1] = Const.dot_product(src.s, tgt_t);
        mat.m[2][2] = Const.dot_product(src_t, tgt_t);

        return mat;
    }
}
