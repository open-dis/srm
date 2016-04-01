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

/** SRM_ORM_Trans_3D_Params class declaration.
This class holds the specific parameters for ORM 3D transformation (h_st)
@author David Shen
*/
public class SRM_ORM_Trans_3D_Params extends SRM_ORM_Trans_Params
{
    protected double _delta_z;
    protected double _omega_1;
    protected double _omega_2;
    protected double _omega_3;

    public SRM_ORM_Trans_3D_Params(double delta_x,
                                   double delta_y,
                                   double delta_z,
                                   double omega_1,
                                   double omega_2,
                                   double omega_3,
                                   double delta_s) throws SrmException
    {
        super(delta_x, delta_y, delta_s);

        if (omega_1 >= Const.TWO_PI || omega_1 <= -Const.TWO_PI ||
            omega_2 >= Const.TWO_PI || omega_2 <= -Const.TWO_PI ||
            omega_3 >= Const.TWO_PI || omega_3 <= -Const.TWO_PI)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("SRM_ORM_Trans_3D_Params: Omega parameter out of bounds (-2_PI < omega < 2_PI)"));

        _delta_z = delta_z;
        _omega_1 = omega_1;
        _omega_2 = omega_2;
        _omega_3 = omega_3;
    }

    /** Returns TRUE is this object's member data are "equal" to the ones in
        input object.
    */
    public boolean isEqual(SRM_ORM_Trans_3D_Params params)
    {
        return (
                this._delta_x == params._delta_x &&
                this._delta_y == params._delta_y &&
                this._delta_z == params._delta_z &&
                this._omega_1 == params._omega_1 &&
                this._omega_2 == params._omega_2 &&
                this._omega_3 == params._omega_3 &&
                this._delta_s == params._delta_s
                );
    }
}
