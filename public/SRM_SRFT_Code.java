/**
@author David Shen, Michele L. Worley
@brief Declaration of SRM SRF template enumeration.
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

public enum SRM_SRFT_Code
{
    SRFTCOD_UNSPECIFIED (0), /// Unspecified
    SRFTCOD_CELESTIOCENTRIC (1), /// Celestiocentric SRFT
    SRFTCOD_LOCAL_SPACE_RECT_3D (2), /// Local Space Rectangular 3D SRFT
    SRFTCOD_CELESTIODETIC (3), /// Celestiodetic SRFT
    SRFTCOD_PLANETODETIC (4), /// Planetodetic SRFT
    SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN (5), /// Local Tangent Space Euclidean SRFT
    SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL (6), /// Local Tangent Space Azimuthal Spherical SRFT
    SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL (7), /// Local Tangent Space Cylindrical SRFT
    SRFTCOD_LOCOCENTRIC_EUCLIDEAN_3D (8), /// Lococentric Euclidean 3D SRFT
    SRFTCOD_CELESTIOMAGNETIC (9), /// Celestiomagnetic SRFT
    SRFTCOD_EQUATORIAL_INERTIAL (10), /// Equatorial Inertial SRFT
    SRFTCOD_SOLAR_ECLIPTIC (11), /// Solar Ecliptic SRFT
    SRFTCOD_SOLAR_EQUATORIAL (12), /// Solar Equatorial SRFT
    SRFTCOD_SOLAR_MAGNETIC_ECLIPTIC (13), /// Solar Magnetic Ecliptic SRFT
    SRFTCOD_SOLAR_MAGNETIC_DIPOLE (14), /// Solar Magnetic Dipole SRFT
    SRFTCOD_HELIOSPHERIC_ARIES_ECLIPTIC (15), /// Heliospheric Aries Ecliptic SRFT
    SRFTCOD_HELIOSPHER_EARTH_ECLIPTIC (16), /// Heliospheric Earth Ecliptic SRFT
    SRFTCOD_HELIOSPHER_EARTH_EQUATORIAL (17), /// Heliospheric Earth Equatorial SRFT
    SRFTCOD_MERCATOR (18), /// Mercator SRFT
    SRFTCOD_OBLIQUE_MERCATOR_SPHERICAL (19), /// Oblique Mercator SRFT for a sphere ORM
    SRFTCOD_TRANSVERSE_MERCATOR (20), /// Transverse Mercator SRFT
    SRFTCOD_LAMBERT_CONFORMAL_CONIC (21), /// Lambert Conformal Conic SRFT
    SRFTCOD_POLAR_STEREOGRAPHIC (22), /// Polar Stereographic SRFT
    SRFTCOD_EQUIDISTANT_CYLINDRICAL (23), /// Equidistant Cylindrical SRFT
    SRFTCOD_LOCAL_SPACE_RECT_2D (24), /// Local Space Rectangular 2D SRFT
    SRFTCOD_LOCAL_SPACE_AZIMUTHAL_2D (25), /// Local Space Azimuthal 2D SRFT
    SRFTCOD_LOCAL_SPACE_POLAR_2D (26); /// Local Space Polar 2D SRFT

    public static final int _totalEnum = 26;

    private int    _enumInt;

    private static Vector<SRM_SRFT_Code> _enumVec = new Vector<SRM_SRFT_Code>( );

    static
    {
        for (SRM_SRFT_Code x : SRM_SRFT_Code.values())
        {
            _enumVec.add(x._enumInt, x);
        }
    }

    private SRM_SRFT_Code(int enumInt)
    {
        _enumInt = enumInt;
    }

    /** returns the integer code value for the enumerant
     */
    public int toInt()
    {
        return _enumInt;
    }

    /** @return the SRM_SRFT_Code object from its enumerant value
     */
    public static SRM_SRFT_Code getEnum(int item) throws SrmException
    {
        if (item < 0 || item > _totalEnum)
            throw new SrmException( SrmException._INVALID_INPUT,
                                    new String("SRM_SRFT_Code.getEnum: enumerant out of range") );
        else
            return (SRM_SRFT_Code)(_enumVec.elementAt( item ));
    }
}
