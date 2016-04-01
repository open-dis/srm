/**
@author David Shen
@brief SRFSM_Japan_RPCS
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

public class SRM_SRFSM_Japan_Rectangular_Plane_CS_Code extends SRM_SRFSM_Code
{
    public static final int _SRFSMJPRPCSCOD_UNSPECIFIED = 0; /// UNSPECIFIED
    public static final int _SRFSMJPRPCSCOD_ZONE_I = 1; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_I
    public static final int _SRFSMJPRPCSCOD_ZONE_II = 2; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_II
    public static final int _SRFSMJPRPCSCOD_ZONE_III = 3; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_III
    public static final int _SRFSMJPRPCSCOD_ZONE_IV = 4; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_IV
    public static final int _SRFSMJPRPCSCOD_ZONE_V = 5; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_V
    public static final int _SRFSMJPRPCSCOD_ZONE_VI = 6; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_VI
    public static final int _SRFSMJPRPCSCOD_ZONE_VII = 7; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_VII
    public static final int _SRFSMJPRPCSCOD_ZONE_VIII = 8; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_VIII
    public static final int _SRFSMJPRPCSCOD_ZONE_IX = 9; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_IX
    public static final int _SRFSMJPRPCSCOD_ZONE_X = 10; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_X
    public static final int _SRFSMJPRPCSCOD_ZONE_XI = 11; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XI
    public static final int _SRFSMJPRPCSCOD_ZONE_XII = 12; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XII
    public static final int _SRFSMJPRPCSCOD_ZONE_XIII = 13; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XIII
    public static final int _SRFSMJPRPCSCOD_ZONE_XIV = 14; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XIV
    public static final int _SRFSMJPRPCSCOD_ZONE_XV = 15; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XV
    public static final int _SRFSMJPRPCSCOD_ZONE_XVI = 16; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XVI
    public static final int _SRFSMJPRPCSCOD_ZONE_XVII = 17; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XVII
    public static final int _SRFSMJPRPCSCOD_ZONE_XVIII = 18; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XVIII
    public static final int _SRFSMJPRPCSCOD_ZONE_XIX = 19; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XIX

    public static final int _totalEnum = 19;

    private static Vector<SRM_SRFSM_Japan_Rectangular_Plane_CS_Code> _enumVec = new Vector<SRM_SRFSM_Japan_Rectangular_Plane_CS_Code>( );

    private static HashMap<String, SRM_SRFSM_Japan_Rectangular_Plane_CS_Code> _enumMap = new HashMap<String, SRM_SRFSM_Japan_Rectangular_Plane_CS_Code>( );


    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_UNSPECIFIED
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_UNSPECIFIED, "SRFSMJPRPCSCOD_UNSPECIFIED" );


    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_I
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_I, "SRFSMJPRPCSCOD_ZONE_I" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_II
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_II, "SRFSMJPRPCSCOD_ZONE_II" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_III
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_III, "SRFSMJPRPCSCOD_ZONE_III" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_IV
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_IV, "SRFSMJPRPCSCOD_ZONE_IV" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_V
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_V, "SRFSMJPRPCSCOD_ZONE_V" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_VI
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_VI, "SRFSMJPRPCSCOD_ZONE_VI" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_VII
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_VII, "SRFSMJPRPCSCOD_ZONE_VII" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_VIII
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_VIII, "SRFSMJPRPCSCOD_ZONE_VIII" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_IX
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_IX, "SRFSMJPRPCSCOD_ZONE_IX" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_X
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_X, "SRFSMJPRPCSCOD_ZONE_X" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XI
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XI, "SRFSMJPRPCSCOD_ZONE_XI" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XII
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XII, "SRFSMJPRPCSCOD_ZONE_XII" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XIII
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XIII, "SRFSMJPRPCSCOD_ZONE_XIII" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XIV
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XIV, "SRFSMJPRPCSCOD_ZONE_XIV" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XV
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XV, "SRFSMJPRPCSCOD_ZONE_XV" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XVI
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XVI, "SRFSMJPRPCSCOD_ZONE_XVI" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XVII
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XVII, "SRFSMJPRPCSCOD_ZONE_XVII" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XVIII
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XVIII, "SRFSMJPRPCSCOD_ZONE_XVIII" );
    public static final SRM_SRFSM_Japan_Rectangular_Plane_CS_Code SRFSMJPRPCSCOD_ZONE_XIX
        = new SRM_SRFSM_Japan_Rectangular_Plane_CS_Code( _SRFSMJPRPCSCOD_ZONE_XIX, "SRFSMJPRPCSCOD_ZONE_XIX" );

    private SRM_SRFSM_Japan_Rectangular_Plane_CS_Code(int code, String name)
    {
        super (code, name);
        _enumMap.put( name, this );
        _enumVec.add( code, this );
    }

    /** @return the SRM_SRFSM_Japan_Rectangular_Plane_CS_Code from its enumerant value
     */
    public static SRM_SRFSM_Japan_Rectangular_Plane_CS_Code getEnum( int enum_value ) throws SrmException
    {
        if (enum_value < 1 || enum_value > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.getEnum: enumerant out of range") );
        else
            return (SRM_SRFSM_Japan_Rectangular_Plane_CS_Code)(_enumVec.elementAt( enum_value ));
    }

    /** @return the SRM_SRFSM_Japan_Rectangular_Plane_CS_Code from its string name
     */
    public static SRM_SRFSM_Japan_Rectangular_Plane_CS_Code getEnum( String name ) throws SrmException
    {
        SRM_SRFSM_Japan_Rectangular_Plane_CS_Code retCode = (SRM_SRFSM_Japan_Rectangular_Plane_CS_Code)_enumMap.get( name );

        if (retCode == null)
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFSM_Japan_Rectangular_Plane_CS_Code.getEnum: enum. string not found") );

        return retCode;
    }
}
