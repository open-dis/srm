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

/** SRM_Quaternion_Params class declaration.
This class holds the specific parameters for the Quaternion orientation representation
@author David Shen
*/
public class SRM_Quaternion_Params
{
    public double e0 = 1.0;
    public double e1 = 0.0;
    public double e2 = 0.0;
    public double e3 = 0.0;

    /// The default constructor
    public SRM_Quaternion_Params ()
    {
    }

    /** Constructor using axis and angle pamameters
        @note q = e0 + e1*i + e2*j + e3*k
        @note e0^2 + e1^2 + e2^2 + e3^2 = 1
        @param e0 in: the scale (real) parameter
        @param e1 in: the vector multiplier in (i) direction
        @param e2 in: the vector multiplier in (j) direction
        @param e3 in: the vector multiplier in (k) direction
    */
    public SRM_Quaternion_Params
    (
        double e0,
        double e1,
        double e2,
        double e3
    )
    {
        this.e0 = e0;
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    /** the copy constructor
    */
    public SRM_Quaternion_Params (SRM_Quaternion_Params params)
    {
        this.e0 = params.e0;
        this.e1 = params.e1;
        this.e2 = params.e2;
        this.e3 = params.e3;
    }

    /** Returns TRUE if a's member data are "equivalent" to those in b.
    */
    public static final boolean isEqual
    (
        SRM_Quaternion_Params a,
        SRM_Quaternion_Params b,
        double                tolerance
    )
    {
        // a and b are equivalent if both have an angle of zero,
        // if they are equal, or if one is the negative of the other
        if (Const.areEqualAngles(a.e0, 0.0, tolerance) &&
            Const.areEqualAngles(b.e0, 0.0, tolerance))
        {
            return true;
        }
        else
        {
            double[] params1_vec = { a.e1, a.e2, a.e3 };
            double[] params2_vec = { b.e1, b.e2, b.e3 };

            if (Const.areEqualAngles(a.e0, b.e0, tolerance) &&
                Const.isEqual(params1_vec, params2_vec, tolerance))
            {
                return true;
            }
            else if (Const.areEqualAngles(a.e0, -b.e0, tolerance))
            {
                params2_vec[0] = -params2_vec[0];
                params2_vec[1] = -params2_vec[1];
                params2_vec[2] = -params2_vec[2];

                if (Const.isEqual(params1_vec, params2_vec, tolerance))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /** Returns true if the orientation parameters are valid
        @note q = e0 + e1*i + e2*j + e3*k
        @note e0^2 + e1^2 + e2^2 + e3^2 = 1
    */
    public boolean valid()
    {
        return Const.isEqual(Const.square(e0)+Const.square(e1)
                           + Const.square(e2)+Const.square(e3),
                             1.0, Const.EPSILON);
    }

    public String toString()
    {
       return ("[ " + e0 + ", " + e1 + ", " +  e2 + ", " + e3 + " ]");
    }
}
