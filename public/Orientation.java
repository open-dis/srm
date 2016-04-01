/**
   @author David Shen
   @brief Declaration of Orientation.
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

/** The Orientation base class.
    @author David Shen
    @see BaseSRF_3D
*/
public abstract class Orientation implements Cloneable
{
    /** Epsilon value for equivalence tests
     */
    public static final double epsilon = Const.EPSILON;

    /** Internal matrix 3x3 representation (for now) used for calculations
     */
    private SRM_Matrix_3x3 _matrix_base;

    /** is set to true when the internal data is equivalent to the
        representation class data.
     */
    private boolean _internal_data_is_current;

    /** Internal matrix 3x3 representation (for now) used for calculations
     */
    protected SRM_Matrix_3x3 _get_matrix_base()
    {
        _updateIntData();

        return _matrix_base;
    }

    protected SRM_Matrix_3x3 _get_matrix_base_unch()
    {
        return _matrix_base;
    }

    protected void _set_matrix_base(SRM_Matrix_3x3 mat)
    {
        _matrix_base = mat;
    }

    /** is set to true when the internal data is equivalent to the
        representation class data.
     */
    protected boolean _get_internal_data_is_current()
    {
        return _internal_data_is_current;
    }

    protected void _set_internal_data_is_current(boolean internal_data_is_current)
    {
        _internal_data_is_current = internal_data_is_current;
    }

    /** the virtual function to convert the data from native representation to
        the internal representation
     */
    protected abstract void _updateIntData();

    /** the virtual function to convert the data from internal representation
        to the native representation
     */
    protected abstract void _updateRepData();


    /** Gets the orientation in matrix 3x3 representation
     */
    public SRM_Matrix_3x3 getMatrix3x3()
    {
        return _get_matrix_base();
    }

    /** Gets the orientation in (axis, angle) representation
     */
    public SRM_Axis_Angle_Params getAxisAngle() throws SrmException

    {
        return OriComp.matrix_to_axis_angle(_get_matrix_base());
    }

    /** Gets the orientation in Euler angles (ZXZ) representation
     */
    public SRM_Euler_Angles_ZXZ_Params getEulerAnglesZXZ()
    {
        return OriComp.matrix_to_euler_zxz(_get_matrix_base());
    }

    /** Gets the orientation in Tait-Bryan angles representation
     */
    public SRM_Tait_Bryan_Angles_Params getTaitBryanAngles()
    {
        return OriComp.matrix_to_tait_bryan(_get_matrix_base());
    }

    /** Gets the orientation in Quaternion representation
     */
    public SRM_Quaternion_Params getQuaternion() throws SrmException
    {
        return OriComp.matrix_to_qt(_get_matrix_base());
    }

   /** Sets the Matrix 3x3 orientation representation
       @note the INV(mat)=TRANSPOSE(mat), consequently, mat*TRANSPOSE(mat)=I
    */
    public void setMatrix3x3(SRM_Matrix_3x3 params) throws SrmException
    {
        if (params.valid())
        {
            _set_matrix_base(params);
            _updateRepData();
        }
        else
        {
            throw new SrmException
                      (SrmException._INVALID_INPUT,
                       new String("Orientation::setMatrix3x3: "
                                + "invalid matrix 3x3 parameters"));
        }
    }

   /** Sets the orientation using elements of the matrix (mat) 3x3 parameter
       @note the INV(mat)=TRANSPOSE(mat), consequently, mat*TRANSPOSE(mat)=I
    */
    public void setMatrix3x3
    (
        double a11, double a12, double a13,
        double a21, double a22, double a23,
        double a31, double a32, double a33
    ) throws SrmException
    {
        setMatrix3x3(new SRM_Matrix_3x3(a11, a12, a13,
                                        a21, a22, a23,
                                        a31, a32, a33));
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
            setMatrix3x3(OriComp.axis_angle_to_matrix(params));
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Orientation::setAxisAngle: " +
                                              "invalid (axis, angle) parameters"));
        }
    }

   /** Sets the orientation using (axis, angle) parameters.
       @param axis in: the axis of rotation, which is a unit vector
       @param angle in: the angle of rotation, which is in radians in
                        the range of [-2PI, 2PI]
    */
    public void setAxisAngle
    (
        double[] axis,
        double   angle_in_rad
    ) throws SrmException
    {
        SRM_Axis_Angle_Params aa = new SRM_Axis_Angle_Params
                                       (axis, angle_in_rad);

        setAxisAngle(aa);
    }

   /** Sets the Euler angles (ZXZ) orientation representation
       @note the spin angle is in radians in the range of [-2PI, 2PI]
       @note the nutation angle is in radians in the range of [-2PI, 2PI]
       @note the precession angle is in radians in the range of [-2PI, 2PI]
    */
    public void setEulerAnglesZXZ
    (
        SRM_Euler_Angles_ZXZ_Params params
    ) throws SrmException
    {
        if (params.valid())
        {
            setMatrix3x3(OriComp.euler_zxz_to_matrix(params));
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Orientation::setEulerAnglesZXZ: "
                                            + "invalid Euler zxz parameters"));
        }
    }

   /** Sets the orientation using spin, nutation, and precession parameters
       @param spin in: the spin angle, which is in radians in the range of
                       [-2PI, 2PI]
       @param nutation in: the nutation angle is in radians in the range of
                           [-2PI, 2PI]
       @param precession in: the precession angle, which is in radians in the
                             range of [-2PI, 2PI]
    */
    public void setEulerAnglesZXZ
    (
        double spin,
        double nutation,
        double precession
    ) throws SrmException
    {
        SRM_Euler_Angles_ZXZ_Params ea = new SRM_Euler_Angles_ZXZ_Params
                                             (spin, nutation, precession);

        setEulerAnglesZXZ(ea);
    }

   /** Sets the Tait-Bryan angles orientation representation.
       @note the roll angle is in radians in the range of [-2PI, 2PI]
       @note the pitch angle is in radians in the range of [-2PI, 2PI]
       @note the yaw angle is in radians in the range of [-2PI, 2PI]
       @exception This method throws srm::Exception
    */
    public void setTaitBryanAngles
    (
        SRM_Tait_Bryan_Angles_Params params
    ) throws SrmException
    {
        if (params.valid())
        {
            setMatrix3x3(OriComp.tait_bryan_to_matrix(params));
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Orientation::setTaitBryanAngles: "
                                            + "invalid Tait-Bryan parameters"));
        }
    }

   /** Sets the orientation using roll, pitch and yaw parameters
       @param roll in: the roll angle, which is in radians in the range of
                       [-2PI, 2PI]
       @param pitch in: the pitch angle, which is in radians in the range
                        of [-2PI, 2PI]
       @param yaw in: the yaw angle, which is in radians in the range of
                      [-2PI, 2PI]
    */
    public void setTaitBryanAngles
    (
        double roll,
        double pitch,
        double yaw
    ) throws SrmException
    {
        SRM_Tait_Bryan_Angles_Params tb = new SRM_Tait_Bryan_Angles_Params
                                              (roll, pitch, yaw);

        setTaitBryanAngles(tb);
    }

   /** Sets the quaternion orientation representation
       @note q = e0 + e1*i + e2*j + e3*k
       @note e0^2 + e1^2 + e2^2 + e3^2 = 1
    */
    public void setQuaternion
    (
        SRM_Quaternion_Params params
    ) throws SrmException
    {
        if (params.valid())
        {
            setMatrix3x3(OriComp.qt_to_matrix(params));
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Orientation::setQuaternion: " +
                                              "invalid quaternion parameters"));
        }
    }

   /** Sets the orientation using quaternion (e0, e1, e2, e3 ) parameters
       @note q = e0 + e1*i + e2*j + e3*k
       @note e0^2 + e1^2 + e2^2 + e3^2 = 1
       @param e0 in: the scale (real) parameter
       @param e1 in: the vector multiplier in (i) direction
       @param e2 in: the vector multiplier in (j) direction
       @param e3 in: the vector multiplier in (k) direction
    */
    public void setQuaternion
    (
        double e0,
        double e1,
        double e2,
        double e3
    ) throws SrmException
    {
        SRM_Quaternion_Params qt = new SRM_Quaternion_Params
                                   (e0, e1, e2, e3);

        setQuaternion(qt);
    }

    /** Returns the string for the orientation values.
     */
    public abstract String toString();

    /** Returns the native orientation representation type.
     */
    public abstract SRM_Ori_Rep getOriRep();

    /** Applies this orientation to the input vector and sets the result in the
        return vector.
        @note The input/output arrays are of size 3.
        @exception This method throws srm::Exception
    */
    public double[] transformVector(double[] vec) throws SrmException
    {
        return OriComp.matrixMultiply(_get_matrix_base(), vec);
    }

    public static final boolean equivalence
    (
        Orientation instance1,
        Orientation instance2,
        double      tolerance
    ) throws SrmException
    {
        if (tolerance < 0.0)
            throw new SrmException(SrmException._INVALID_INPUT,
                  new String("equivalance: invalid (negative) tolerance"));

        return SRM_Matrix_3x3.isEquiv(instance1._get_matrix_base(),
                                      instance2._get_matrix_base(),
                                      tolerance);
    }

    public static final boolean equivalence
    (
        Orientation instance1,
        Orientation instance2
    )
    {
        return SRM_Matrix_3x3.isEquiv(instance1._get_matrix_base(),
                                      instance2._get_matrix_base(),
                                      epsilon);
    }

    /** The equality operator.
     *  @note This operator is deprecated. Use equivalence() method.
     */
    public boolean isEqual(Orientation ori) throws SrmException
    {
        return equivalence(this, ori, 0.0);
    }
}
