/**
@author David Shen
@brief CS code enumeration according to the SRM spec.
*/
// FILE: SRM_CS_Code.java

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

public enum SRM_CS_Code
{
   /** Unspecified
    */
    CSCOD_UNSPECIFIED (0),

   /** Euclidean 3D.
    */
    CSCOD_EUCLIDEAN_3D (1),

   /** Localized Euclidean 3D
    */
    CSCOD_LOCOCENT_EUCLIDEAN_3D (2),

   /** Equatorial Spherical.
    */
    CSCOD_EQUATORIAL_SPHERICAL (3),

   /** Localized spherical
    */
    CSCOD_LOCOCENT_EQUATORIAL_SPHERICAL (4),

   /** Azimuthal spherical.
    */
    CSCOD_AZIMUTHAL_SPHERICAL (5),

   /** Localized azimuthal spherical.
    */
    CSCOD_LOCOCENT_AZIMUTHAL_SPHERICAL (6),

   /** Geodetic 3D.
    */
    CSCOD_GEODETIC (7),

   /** Planetodetic 3D. Geodetic 3D with longitude in opposite direction.
    */
    CSCOD_PLANETODETIC (8),

   /** Cylindrical.
    */
    CSCOD_CYLINDRICAL (9),

   /** Localized cylindrical.
    */
    CSCOD_LOCOCENTRIC_CYLINDRICAL (10),

   /** Mercator and augmented Mercator map projection coordinate systems.
    */
    CSCOD_MERCATOR (11),

   /** Oblique Mercator and augmented oblique Mercator map projections of a sphere.
    */
    CSCOD_OBLIQUE_MERCATOR_SPHERICAL (12),

   /** Transverse Mercator and augmented transverse Mercator map projections.
    */
    CSCOD_TRANSVERSE_MERCATOR (13),

   /** Lambert conformal conic and augmented Lambert conformal conic map projections.
    */
    CSCOD_LAMBERT_CONFORMAL_CONIC (14),

   /** Polar stereographic and augmented polar stereographic map projections.
    */
    CSCOD_POLAR_STEREOGRAPHIC (15),

   /** Equidistant cylindrical and augmented equidistant cylindrical map projections.
    */
    CSCOD_EQUIDISTANT_CYLINDRICAL (16),

   /** Surface geodetic.
    */
    CSCOD_SURFACE_GEODETIC (17),

   /** Surface planetodetic. Surface geodetic with longitude in opposite direction.
    */
    CSCOD_SURFACE_PLANETODETIC (18),

   /** Localization of Euclidean 2D CS into plane surface in 3D position-space.
    */
    CSCOD_LOCOCENTRIC_SURFACE_EUCLIDEAN (19),

   /** Localization of azimuthal CS into plane surface in 3D position-space.
    */
    CSCOD_LOCOCENTRIC_SURFACE_AZIMUTHAL (20),

   /** Localization of polar CS into plane surface in 3D position-space.
    */
    CSCOD_LOCOCENTRIC_SURFACE_POLAR (21),

   /** Euclidean 2D.
    */
    CSCOD_EUCLIDEAN_2D (22),

   /** Localized Euclidean 2D.
    */
    CSCOD_LOCOCENT_EUCLIDEAN_2D (23),

   /** Azimuthal coordinate system.
    */
    CSCOD_AZIMUTHAL (24),

   /** Localization of azimuthal CS.
    */
    CSCOD_LOCOCENT_AZIMUTHAL (25),

   /** Polar coordinate system.
    */
    CSCOD_POLAR (26),

   /** Localized polar.
    */
    CSCOD_LOCOCENTRIC_POLAR (27),

   /** Euclidean 1D.
    */
    CSCOD_EUCLIDEAN_1D (28);

    public static final int _totalEnum = 28;

    private int    _enumInt;

    private static Vector<SRM_CS_Code> _enumVec = new Vector<SRM_CS_Code>( );

    static
    {
        for (SRM_CS_Code x : SRM_CS_Code.values())
        {
            _enumVec.add(x._enumInt, x);
        }
    }

    private SRM_CS_Code(int enumInt)
    {
        _enumInt = enumInt;
    }

    /** returns the integer code value for the enumerant
     */
    public int toInt()
    {
        return _enumInt;
    }

    /** @return the SRM_CS_Code object from its enumerant value
     */
    public static SRM_CS_Code getEnum(int item) throws SrmException
    {
        if (item < 0 || item > _totalEnum)
            throw new SrmException( SrmException._INVALID_INPUT,
                                    new String("SRM_CS_Code.getEnum: enumerant out of range") );
        else
            return (SRM_CS_Code)(_enumVec.elementAt( item ));
    }
}
