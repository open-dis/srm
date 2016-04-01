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
@brief Declaration of SRF Set enumeration class.
*/
public enum SRM_SRFS_Code
{
   /** Unspecified
    */
    SRFSCOD_UNSPECIFIED (0),

   /** Alabama (US) state plane coordinate system.
    */
    SRFSCOD_ALABAMA_SPCS (1),

   /** GTRS global coordinate system (GCS) (Earth).
    */
    SRFSCOD_GTRS_GLOBAL_COORDINATE_SYSTEM (2),

   /** Japan plane coordinate system
    */
    SRFSCOD_JAPAN_RECTANGULAR_PLANE_CS (3),

   /** Lambert NTF.
    */
    SRFSCOD_LAMBERT_NTF (4),

   /** Universal polar stereographic (UPS) (Earth).
    */
    SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC (5),

   /** Universal transverse Mercator (UTM) (Earth).
    */
    SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR (6),

   /** Wisconsin (US) state plane coordinate system.
    */
    SRFSCOD_WISCONSIN_SPCS (7);

    public static final int _totalEnum = 7;

    private int    _enumInt;

    private static Vector<SRM_SRFS_Code> _enumVec = new Vector<SRM_SRFS_Code>( );

    static
    {
        for (SRM_SRFS_Code x : SRM_SRFS_Code.values())
        {
            _enumVec.add(x._enumInt, x);
        }
    }

    private SRM_SRFS_Code(int enumInt)
    {
        _enumInt = enumInt;
    }

    /** returns the integer code value for the enumerant
     */
    public int toInt()
    {
        return _enumInt;
    }

    /** @return the SRM_SRFS_Code object from its enumerant value
     */
    public static SRM_SRFS_Code getEnum(int item) throws SrmException
    {
        if (item < 0 || item > _totalEnum)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("SRM_SRFS_Code.getEnum: enumerant out of range") );
        else
            return (SRM_SRFS_Code)(_enumVec.elementAt( item ));
    }
}

