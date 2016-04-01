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

/** SRM_Matrix_3x3 class declaration.
This class holds the specific parameters for the Matrix 3x3 orientation representation
@author David Shen
*/
public class SRM_Matrix_3x3
{
    public double[][] m = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};

    /** The default constructor
     */
    public SRM_Matrix_3x3()
    {
    }

    /** Constructor using elements of the matrix (mat) 3x3 pamameter
     */
    public SRM_Matrix_3x3(double a11, double a12, double a13,
                          double a21, double a22, double a23,
                          double a31, double a32, double a33)
    {
        m[0][0] = a11;
        m[0][1] = a12;
        m[0][2] = a13;
        m[1][0] = a21;
        m[1][1] = a22;
        m[1][2] = a23;
        m[2][0] = a31;
        m[2][1] = a32;
        m[2][2] = a33;
    }

    /** the copy constructor
     */
    public SRM_Matrix_3x3(SRM_Matrix_3x3 params)
    {
        System.arraycopy(params.m[0], 0, this.m[0], 0, 3);
        System.arraycopy(params.m[1], 0, this.m[1], 0, 3);
        System.arraycopy(params.m[2], 0, this.m[2], 0, 3);
    }

    /** Returns TRUE if a's member data are "equivalent" to those in b.
    */
    public static final boolean isEquiv
    (
        SRM_Matrix_3x3 a,
        SRM_Matrix_3x3 b,
        double         tolerance
    )
    {
        return (Const.isEqual(a.m[0][0], b.m[0][0], tolerance) &&
                Const.isEqual(a.m[0][1], b.m[0][1], tolerance) &&
                Const.isEqual(a.m[0][2], b.m[0][2], tolerance) &&
                Const.isEqual(a.m[1][0], b.m[1][0], tolerance) &&
                Const.isEqual(a.m[1][1], b.m[1][1], tolerance) &&
                Const.isEqual(a.m[1][2], b.m[1][2], tolerance) &&
                Const.isEqual(a.m[2][0], b.m[2][0], tolerance) &&
                Const.isEqual(a.m[2][1], b.m[2][1], tolerance) &&
                Const.isEqual(a.m[2][2], b.m[2][2], tolerance)
               );
    }

    /** Returns true if the orientation parameters are valid
     */
    public boolean valid()
    {
        return Const.isEqual(Const.det(m), 1.0, Const.EPSILON);
    }

    public String toString()
    {
       String retString;

       retString = "[ [" + m[0][0] + ", " +  m[0][1] + ", " +  m[0][2] + "], "
                   + "[" + m[1][0] + ", " +  m[1][1] + ", " +  m[1][2] + " ], "
                   + "[" + m[2][0] + ", " +  m[2][1] + ", " +  m[2][2] + " ] ]";

       return retString;
    }
}
