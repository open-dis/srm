/**
@author David Shen
@brief SRFSM_Lambert_NTF
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

public class SRM_SRFSM_Lambert_NTF_Code extends SRM_SRFSM_Code
{
    public static final int _SRFSMLAMNTFCOD_UNSPECIFIED = 0; /// Unspecified
    public static final int _SRFSMLAMNTFCOD_ZONE_I = 1; /// LAMBERT_NTF_ZONE_I
    public static final int _SRFSMLAMNTFCOD_ZONE_II = 2; /// LAMBERT_NTF_ZONE_II
    public static final int _SRFSMLAMNTFCOD_ZONE_III = 3; /// LAMBERT_NTF_ZONE_III
    public static final int _SRFSMLAMNTFCOD_ZONE_IV = 4; /// LAMBERT_NTF_ZONE_IV

    public static final int _totalEnum = 4;

    private static Vector<SRM_SRFSM_Lambert_NTF_Code> _enumVec = new Vector<SRM_SRFSM_Lambert_NTF_Code>();

    private static HashMap<String, SRM_SRFSM_Lambert_NTF_Code> _enumMap = new HashMap<String, SRM_SRFSM_Lambert_NTF_Code>();

    public static final SRM_SRFSM_Lambert_NTF_Code SRFSMLAMNTFCOD_UNSPECIFIED
        = new SRM_SRFSM_Lambert_NTF_Code( _SRFSMLAMNTFCOD_UNSPECIFIED, "SRFSMLAMNTFCOD_UNSPECIFIED");


    public static final SRM_SRFSM_Lambert_NTF_Code SRFSMLAMNTFCOD_ZONE_I
        = new SRM_SRFSM_Lambert_NTF_Code( _SRFSMLAMNTFCOD_ZONE_I, "SRFSMLAMNTFCOD_ZONE_I");
    public static final SRM_SRFSM_Lambert_NTF_Code SRFSMLAMNTFCOD_ZONE_II
        = new SRM_SRFSM_Lambert_NTF_Code( _SRFSMLAMNTFCOD_ZONE_II, "SRFSMLAMNTFCOD_ZONE_II");
    public static final SRM_SRFSM_Lambert_NTF_Code SRFSMLAMNTFCOD_ZONE_III
        = new SRM_SRFSM_Lambert_NTF_Code( _SRFSMLAMNTFCOD_ZONE_III, "SRFSMLAMNTFCOD_ZONE_III");
    public static final SRM_SRFSM_Lambert_NTF_Code SRFSMLAMNTFCOD_ZONE_IV
        = new SRM_SRFSM_Lambert_NTF_Code( _SRFSMLAMNTFCOD_ZONE_IV, "SRFSMLAMNTFCOD_ZONE_IV");

    private SRM_SRFSM_Lambert_NTF_Code(int code, String name)
    {
        super (code, name);
        _enumMap.put(name, this);
        _enumVec.add(code, this);
    }

    /** @return the SRM_SRFSM_Lambert_NTF_Code from its enumerant value
     */
    public static SRM_SRFSM_Lambert_NTF_Code getEnum(int enum_value) throws SrmException
    {
        if (enum_value < 1 || enum_value > _totalEnum)
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFSM_Lambert_NTF_Code.getEnum: enumerant out of range"));
        else
            return (SRM_SRFSM_Lambert_NTF_Code)(_enumVec.elementAt(enum_value));
    }

    /** @return the SRM_SRFSM_Lambert_NTF_Code from its string name
     */
    public static SRM_SRFSM_Lambert_NTF_Code getEnum(String name) throws SrmException
    {
        SRM_SRFSM_Lambert_NTF_Code retCode = (SRM_SRFSM_Lambert_NTF_Code)_enumMap.get(name);

        if (retCode == null)
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFSM_Lambert_NTF_Code.getEnum: enum. string not found"));

        return retCode;
    }
}
