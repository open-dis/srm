/**
@author David Shen
@brief The concrete class for the Axis-Angle orientation representation.
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

/** The Orientation subclass in (axis, angle) representation.
@see Orientation
*/
public class OrientationAxisAngle extends Orientation
{
    private SRM_Axis_Angle_Params _axis_angle = new SRM_Axis_Angle_Params();

    /** Default constructor.  The default value is identity ((1, 0, 0), 0),
     */
    public OrientationAxisAngle()
    {
    }

    /** Constructor using (axis, angle) pamameter
        @note the input axis is a unit vector of size 3
        @note the input angle is in radians in the range of [-2PI, 2PI]
        @param params in: the (axis, angle) parameter
    */
    public OrientationAxisAngle(SRM_Axis_Angle_Params params) throws SrmException
    {
        if (params.valid())
        {
            System.arraycopy( params.axis, 0, _axis_angle.axis, 0, 3);
            _axis_angle.angle = params.angle;
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "OrientationAxisAngle(params): invalid (axis, angle) parameters");
        }
    }

    /** Constructor using (axis, angle) pamameter
        @note the input axis is a unit vector
        @note the input angle is in radians in the range of [-2PI, 2PI]
        @param axis in: the axis of rotation
        @param angle_in_rad in: the angle of rotation
    */
    public OrientationAxisAngle( double[] axis, double angle_in_rad) throws SrmException
    {
        SRM_Axis_Angle_Params aa =
            new SRM_Axis_Angle_Params(axis, angle_in_rad);

        if ( !aa.valid())
            throw new SrmException( SrmException._INVALID_INPUT,
                                    new String("OrientationAxisAngle(axis, angle): invalid (axis, angle) parameters"));
        else
           _axis_angle  = aa;

    }

    /** Gets the (axis, angle) orientation representation
     */
    public SRM_Axis_Angle_Params getAxisAngle()
    {
        return new SRM_Axis_Angle_Params(_axis_angle);
    }

    /** Sets the (axis, angle) orientation representation
        @note the input axis is a unit vector
        @note the input angle is in radians in the range of [-2PI, 2PI]
    */
    public void setAxisAngle
    (
        SRM_Axis_Angle_Params params
    ) throws SrmException
    {
        if (params.valid())
        {
            System.arraycopy( params.axis, 0, _axis_angle.axis, 0, 3);
            _axis_angle.angle = params.angle;
            _set_internal_data_is_current(false);
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("OrientationAxisAngle.setAxisAngle: "
                                            + "invalid (axis, angle) parameters"));
        }
    }

    /** Returns the string for the (axis, angle) orientation representation
     */
    public String toString()
    {
        return _axis_angle.toString();
    }

    /** Returns the native orientation representation type.
     */
    public SRM_Ori_Rep getOriRep()
    {
        return SRM_Ori_Rep.ORI_REP_AXIS_ANGLE;
    }

   /** Composes the right orientation with the left orientation and returns
       the result in the output orientation, i.e., composed_ori = left*right.
    */
    public static OrientationAxisAngle compose
    (
        Orientation left,
        Orientation right
    ) throws SrmException
    {
        SRM_Matrix_3x3 ret_mat = OriComp.matrixMultiply
                                         (left.getMatrix3x3(),
                                          right.getMatrix3x3());

        return new OrientationAxisAngle
                   (OriComp.matrix_to_axis_angle(ret_mat));
    }

    protected void _updateIntData()
    {
        if( !_get_internal_data_is_current())
        {
            _set_matrix_base(OriComp.axis_angle_to_matrix(_axis_angle));
            _set_internal_data_is_current(true);
        }
    }

    protected void _updateRepData()
    {
        _axis_angle = OriComp.matrix_to_axis_angle(_get_matrix_base_unch());
        _set_internal_data_is_current(true);
    }
}
