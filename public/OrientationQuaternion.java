/**
@author David Shen
@brief The concrete class for the Quaternion orientation representation.
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

/** The concrete class for the orientation in quaternion representation.
@see Orientation
*/
public class OrientationQuaternion extends Orientation
{
    private SRM_Quaternion_Params _quaternion = new SRM_Quaternion_Params();

    /** Default constructor.  The default value is identity (0, 1, 0, 0).
    */
    public OrientationQuaternion()
    {}

    /** Constructor using quaternion pamameter
        @note q = e0 + e1*i + e2*j + e3*k
        @note e0^2 + e1^2 + e2^2 + e3^2 = 1
        @exception This method throws srm::Exception
    */
    public OrientationQuaternion(SRM_Quaternion_Params params) throws SrmException
    {
        if (params.valid())
            _quaternion = params;
        else
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "OrientationQuaternion(params): invalid quaternion parameters");
    }

     /** Constructor using quaternion (e0, e1, e2, e3) pamameters
          @note q = e0 + e1*i + e2*j + e3*k
          @note e0^2 + e1^2 + e2^2 + e3^2 = 1
          @param e0 in: the scale (real) parameter
          @param e1 in: the vector multiplier in (i) direction
          @param e2 in: the vector multiplier in (j) direction
          @param e3 in: the vector multiplier in (k) direction
          @exception This method throws srm::Exception
     */
    public OrientationQuaternion
    (
        double e0, double e1, double e2, double e3
    ) throws SrmException
    {
        SRM_Quaternion_Params qt =
            new SRM_Quaternion_Params(e0, e1, e2, e3);

        if (qt.valid())
            _quaternion = qt;
        else
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("OrientationQuaternion: invalid quaternion parameters"));
    }

    /** Gets the quaternion orientation representation
     */
    public SRM_Quaternion_Params getQuaternion()
    {
        return new SRM_Quaternion_Params(_quaternion);
    }

    /** Sets the quaternion orientation representation
          @note q = e0 + e1*i + e2*j + e3*k
          @note e0^2 + e1^2 + e2^2 + e3^2 = 1
          @exception This method throws srm::Exception
    */
    public void setQuaternion(SRM_Quaternion_Params params) throws SrmException
    {
        if (params.valid())
        {
            _quaternion = params;
            _set_internal_data_is_current(false);
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                new String("OrientationQuaternion.setQuaternion: invalid quaternion parameters"));
        }
    }

    /** Returns the string for the quaternion orientation representation
    */
    public String toString()
    {
        return _quaternion.toString();
    }

    /** Returns the native orientation representation type.
    */
    public SRM_Ori_Rep getOriRep()
    {
        return SRM_Ori_Rep.ORI_REP_QUATERNION;
    }

   /** Composes the right orientation with the left orientation and returns
       the result in the output orientation, i.e., composed_ori = left*right.
    */
    public static OrientationQuaternion compose
    (
        Orientation left,
        Orientation right
    ) throws SrmException
    {
        SRM_Matrix_3x3 ret_mat = OriComp.matrixMultiply
                                         (left.getMatrix3x3(),
                                          right.getMatrix3x3());

        return new OrientationQuaternion
                   (OriComp.matrix_to_qt(ret_mat));
    }

    protected void _updateIntData()
    {
        if (!_get_internal_data_is_current())
        {
            _set_matrix_base(OriComp.qt_to_matrix(_quaternion));
            _set_internal_data_is_current(true);
        }
    }

    protected void _updateRepData()
    {
        _quaternion = OriComp.matrix_to_qt(_get_matrix_base_unch());
        _set_internal_data_is_current(true);
    }
}
