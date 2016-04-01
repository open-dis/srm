/**
@author David Shen
@brief The concrete class for the Euler Angles (ZXZ) orientation representation.
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

/** The concrete class for the orientation in Euler Angles (ZXZ) representation.
@see Orientation
*/
public class OrientationEulerAnglesZXZ extends Orientation
{
    private SRM_Euler_Angles_ZXZ_Params _euler_angles = new SRM_Euler_Angles_ZXZ_Params();

    /** Default constructor.  The default value is (0, 0, 0).
    */
    public OrientationEulerAnglesZXZ()
    {
    }

    /** Constructor using Euler angles (ZXZ) pamameter
        @note the spin angle is in radians in the range of [-2PI, 2PI]
        @note the nutation angle is in radians in the range of [-2PI, 2PI]
        @note the precession angle is in radians in the range of [-2PI, 2PI]
    */
    public OrientationEulerAnglesZXZ
    (
        SRM_Euler_Angles_ZXZ_Params params
    ) throws SrmException
    {
        if (params.valid())
        {
            _euler_angles.spin = params.spin;
            _euler_angles.nutation = params.nutation;
            _euler_angles.precession = params.precession;
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "OrientationEulerAnglesZXZ(spin, nutation, precession): invalid parameters" );
        }
    }

    /** Constructor using spin, nutation, and precession pamameters
        @note the spin angle is in radians in the range of [-2PI, 2PI]
        @note the nutation angle is in radians in the range of [-2PI, 2PI]
        @note the precesion angle is in radians in the range of [-2PI, 2PI]
        @param spin in: the spin angle in radians
        @param nutation in: the nutation angle in radians
        @param precession in: the precession angle in radians
    */
    public OrientationEulerAnglesZXZ
    (
        double spin, double nutation, double precession
    ) throws SrmException
    {
        SRM_Euler_Angles_ZXZ_Params ea =
            new SRM_Euler_Angles_ZXZ_Params(spin, nutation, precession);

        if (ea.valid())
           _euler_angles  = ea;
        else
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "OrientationEulerAnglesZXZ(spin, nutation, precession): invalid parameters");
    }

    /** Gets the Euler angles (ZXZ) orientation representation
    */
    public SRM_Euler_Angles_ZXZ_Params getEulerAnglesZXZ()
    {
        return new SRM_Euler_Angles_ZXZ_Params(_euler_angles);
    }

    /** Sets the Euler angles (ZXZ) orientation representation
        @note the spin angle is in radians in the range of [-2PI, 2PI]
        @note the nutation angle is in radians in the range of [-PI/2, PI/2]
        @note the precession angle is in radians in the range of [-PI/2, PI/2]
    */
    public void setEulerAnglesZXZ
    (
        SRM_Euler_Angles_ZXZ_Params params
    ) throws SrmException
    {
        if (params.valid())
        {
            _euler_angles.spin = params.spin;
            _euler_angles.nutation = params.nutation;
            _euler_angles.precession = params.precession;
            _set_internal_data_is_current(false);
        }
        else
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "OrientationEulerAnglesZXZ.setEulerAnglesZXZ: invalid parameters");
    }

    /** Returns the string for the Euler angles (ZXZ) orientation representation
    */
    public String toString()
    {
        return _euler_angles.toString();
    }

    /** Returns the native orientation representation type.
    */
    public SRM_Ori_Rep getOriRep()
    {
        return SRM_Ori_Rep.ORI_REP_EULER_ANGLES_ZXZ;
    }

   /** Composes the right orientation with the left orientation and returns
       the result in the output orientation, i.e., composed_ori = left*right.
    */
    public static OrientationEulerAnglesZXZ compose
    (
        Orientation left,
        Orientation right
    ) throws SrmException
    {
        SRM_Matrix_3x3 ret_mat = OriComp.matrixMultiply
                                         (left.getMatrix3x3(),
                                          right.getMatrix3x3());

        return new OrientationEulerAnglesZXZ
                   (OriComp.matrix_to_euler_zxz(ret_mat));
    }

    protected void _updateIntData()
    {
        if( !_get_internal_data_is_current() )
        {
            _set_matrix_base(OriComp.euler_zxz_to_matrix(_euler_angles));
            _set_internal_data_is_current(true);
        }
    }

    protected void _updateRepData()
    {
        _euler_angles = OriComp.matrix_to_euler_zxz(_get_matrix_base_unch());
        _set_internal_data_is_current(true);
    }
}
