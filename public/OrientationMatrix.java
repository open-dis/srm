/**
@author David Shen
@brief Declaration of orientation matrix classes.
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

/** The concrete class for the orientation in matrix 3x3 orientation representation.
@see Orientation
*/
public class OrientationMatrix extends Orientation
{
    private SRM_Matrix_3x3 _matrix = new SRM_Matrix_3x3();

    /** Default constructor.  The default value is identity matrix.
    */
    public OrientationMatrix()
    {
    }

    /** constructor.using matrix 3x3 parameter data structure
        @note the INV(mat)=TRANSPOSE(mat), consequently, mat*TRANSPOSE(mat)=I
    */
    public OrientationMatrix(SRM_Matrix_3x3 params) throws SrmException
    {
        if (params.valid())
        {
            System.arraycopy(params.m[0], 0, _matrix.m[0], 0, 3);
            System.arraycopy(params.m[1], 0, _matrix.m[1], 0, 3);
            System.arraycopy(params.m[2], 0, _matrix.m[2], 0, 3);
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("OrientationMatrix(params): invalid matrix 3x3 parameters"));
        }
    }

    /** Constructor using elements of the matrix (mat) 3x3 pamameter
        @note the INV(mat)=TRANSPOSE(mat), consequently, mat*TRANSPOSE(mat)=I
    */
    public OrientationMatrix(double a11, double a12, double a13,
                             double a21, double a22, double a23,
                             double a31, double a32, double a33) throws SrmException
    {
        SRM_Matrix_3x3 mat =
            new SRM_Matrix_3x3(a11, a12, a13, a21, a22, a23, a31, a32, a33);

        if (mat.valid())
            _matrix = mat;
        else
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("OrientationMatrix(a11, ..., a33): invalid matrix 3x3 parameters"));
    }

    /** Gets the Matrix 3x3 orientation representation
    */
    public SRM_Matrix_3x3 getMatrix3x3()
    {
        return new SRM_Matrix_3x3(_matrix);
    }

    /** Sets the Matrix 3x3 orientation representation
        @note the INV(mat)=TRANSPOSE(mat), consequently, mat*TRANSPOSE(mat)=I
    */
    public void setMatrix3x3(SRM_Matrix_3x3 params) throws SrmException
    {
        if (params.valid())
        {
            System.arraycopy(params.m[0], 0, _matrix.m[0], 0, 3);
            System.arraycopy(params.m[1], 0, _matrix.m[1], 0, 3);
            System.arraycopy(params.m[2], 0, _matrix.m[2], 0, 3);
            _set_internal_data_is_current(false);
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("OrientationMatrix::setMatrix3x3: invalid matrix 3x3 parameters"));
        }
    }

    OrientationMatrix(Orientation other)
    {
        _set_matrix_base(_matrix);
        _set_internal_data_is_current(true);
    }

    /** Returns the string for the matrix 3x3 orientation representation
    */
    public String toString()
    {
        return _matrix.toString();
    }

    /** Returns the native orientation representation type.
    */
    public SRM_Ori_Rep getOriRep()
    {
        return SRM_Ori_Rep.ORI_REP_MATRIX_3X3;
    }

   /** Composes the right orientation with the left orientation and returns
       the result in the output orientation, i.e., composed_ori = left*right.
    */
    public static OrientationMatrix compose
    (
        Orientation left,
        Orientation right
    ) throws SrmException
    {
        SRM_Matrix_3x3 ret_mat = OriComp.matrixMultiply
                                         (left.getMatrix3x3(),
                                          right.getMatrix3x3());

        return new OrientationMatrix(ret_mat);
    }

    protected void _updateIntData()
    {
        if (!_get_internal_data_is_current())
        {
            _set_matrix_base(_matrix);
            _set_internal_data_is_current(true);
        }
    }

    protected void _updateRepData()
    {
        _matrix = _get_matrix_base_unch();
        _set_internal_data_is_current(true);
    }
}
