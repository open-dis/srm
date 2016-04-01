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

/**
@author David Shen, Michele L. Worley
@brief Declaration of ORM template enumeration class.
*/
public enum SRM_ORMT_Code
{
    ORMTCOD_UNSPECIFIED       (0), /// Unspecified
    ORMTCOD_BI_AXIS_ORIGIN_2D (1), /// x- and y-axes determined by directed perpendicular lines passing through the origin
    ORMTCOD_SPHERE            (2), /// 3D sphere with designated directional axis and xz-plane
    ORMTCOD_OBLATE_ELLIPSOID  (3), /// Oblate ellipsoid with designated minor axis direction and xz-plane
    ORMTCOD_PROLATE_ELLIPSOID (4), /// prolate ellipsoid with designated major axis direction and xz-plane
    ORMTCOD_TRI_AXIAL_ELLIPSOID (5), /// 3D tri-axial ellipsoid with designated z-axis direction and xz-plane
    ORMTCOD_BI_AXIS_ORIGIN_3D   (6), /// x- and y-axes determined by directed perpendicular lines passing through the origin
    ORMTCOD_SPHERE_ORIGIN       (7), /// Sphere with two directed perpendicular lines passing through the centre of the sphere
    ORMTCOD_OBLATE_ELLIPSOID_ORIGIN (8), /// Oblate ellipsoid with designated centre, minor axis direction and xz-plane
    ORMTCOD_TRI_PLANE (9); /// Origin determined by the intersection of three planes

    public static final int _totalEnum = 9;

    private int    _enumInt;

    private static Vector<SRM_ORMT_Code> _enumVec = new Vector<SRM_ORMT_Code>( );

    static
    {
        for (SRM_ORMT_Code x : SRM_ORMT_Code.values())
        {
            _enumVec.add(x._enumInt, x);
        }
    }

    private SRM_ORMT_Code(int enumInt)
    {
        _enumInt = enumInt;
    }

    /** returns the integer code value for the enumerant
     */
    public int toInt()
    {
        return _enumInt;
    }

    /** @return the SRM_ORMT_Code object from its enumerant value
     */
    public static SRM_ORMT_Code getEnum(int item) throws SrmException
    {
        if (item < 0 || item > _totalEnum)
            throw new SrmException( SrmException._INVALID_INPUT,
                                    new String("SRM_ORMT_Code.getEnum: enumerant out of range") );
        else
            return (SRM_ORMT_Code)(_enumVec.elementAt( item ));
    }
}
