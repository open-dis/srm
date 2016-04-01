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

/** @author David Shen
*/

package SRM;

/** SRM_Euler_Angles_ZXZ_Params class declaration.
This class holds the specific parameters for the Euler Angle (ZXZ) orientation representation
@author David Shen
*/
public class SRM_Euler_Angles_ZXZ_Params
{
    public double spin = 0.0;
    public double nutation = 0.0;
    public double precession = 0.0;

    /** The default constructor
     */
    public SRM_Euler_Angles_ZXZ_Params ()
    {
    }

    /** Constructor using axis and angle parameters
     @note the spin angle is in radians in the range of [-2PI, 2PI]
     @note the nutation angle is in radians in the range of [-2PI, 2PI]
     @note the precesion angle is in radians in the range of [-2PI, 2PI]
     */
    public SRM_Euler_Angles_ZXZ_Params
    (
        double spin,
        double nutation,
        double precession
    )
    {
        this.spin = spin;
        this.nutation = nutation;
        this.precession = precession;
    }

    /** the copy constructor
     */
    public SRM_Euler_Angles_ZXZ_Params ( SRM_Euler_Angles_ZXZ_Params params )
    {
        this.spin = params.spin;
        this.nutation = params.nutation;
        this.precession = params.precession;
    }

    /** Returns TRUE if a's member data are "equivalent" to those in b.
    */
    public static final boolean isEquiv
    (
        SRM_Euler_Angles_ZXZ_Params a,
        SRM_Euler_Angles_ZXZ_Params b,
        double                      tolerance
    )
    {
        return((Const.areEqualAngles(a.nutation, b.nutation, tolerance) &&
                Const.areEqualAngles(a.nutation, Const.PI, tolerance) &&
                Const.areEqualAngles((a.spin-a.precession), (b.spin-b.precession), tolerance)) ||
               (Const.areEqualAngles(a.nutation, b.nutation, tolerance) &&
                Const.areEqualAngles(a.nutation, 0.0, tolerance) &&
                Const.areEqualAngles((a.spin+a.precession), (b.spin+b.precession), tolerance)) ||
               (Const.areEqualAngles(a.nutation, b.nutation, tolerance) &&
                Const.areEqualAngles(a.spin, b.spin, tolerance) &&
                Const.areEqualAngles(a.precession, b.precession, tolerance)) ||
               (Const.areEqualAngles((a.nutation+b.nutation), Const.TWO_PI, tolerance) &&
                Const.areEqualAngles(Math.abs(a.spin-b.spin), Const.PI, tolerance) &&
                Const.areEqualAngles(Math.abs(a.precession-b.precession), Const.PI, tolerance)));
    }

    /** Returns true if the orientation parameters are valid
     @note the spin angle is in radians in the range of [-2PI, 2PI]
     @note the nutation angle is in radians in the range of [-2PI, 2PI]
     @note the precesion angle is in radians in the range of [-2PI, 2PI]
     */
    public boolean valid()
    {
        // check the axis is a unit vector and angle is within valid range
        return (Const.inFourPiRange(spin) &&
                Const.inFourPiRange(nutation) &&
                Const.inFourPiRange(precession) );
    }

    public String toString()
    {
        return ("[ " + spin + ", " +  nutation + ", " +  precession + " ]" );
    }
}
