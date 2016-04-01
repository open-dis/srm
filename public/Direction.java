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

/**
@author David Shen
@brief Declaration of Direction.
*/

package SRM;

/** The Direction abstract contains a three element vector and a reference location.
@author David Shen
@see BaseSRF_3D
*/
public class Direction implements Cloneable
{
    /// The SRF this Direction belongs to
    private BaseSRF _srf;

    /** The reference coordinate
     */
    protected Coord3D _ref_coord;

    /** The vector values
     */
    protected double[] _vec = new double[3];

    /** Returns the SRF this Direction belongs to.
     */
    public BaseSRF getSRF()
    {
        return _srf;
    }

    /** Returns a clone (copy) of the reference coordinate object
     */
    public Coord3D getRefCoord() throws SrmException
    {
        try
        {
            return (Coord3D)_ref_coord.makeClone();
        }
        catch (SrmException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
                                   new String("Direction.getRefCoord: Unable to return reference location"));
        }
    }

    /** Returns the direction component values.
     */
    public double[] getVec()
    {
        return _vec;
    }

    /** Return the values of the 1st vector component
     */
    public double getVectorComp1()
    {
        return _vec[0];
    }

    /** Return the values of the 2nd direction vector component
     */
    public double getVectorComp2()
    {
        return _vec[1];
    }

    /** Return the values of the 3rd direction vector component
     */
    public double getVectorComp3()
    {
        return _vec[2];
    }

    /** Return the values of the Nth direction vector component.
        @note N within [ 1, 2, 3 ]
    */
    public double getVectorComp(int n) throws SrmException
    {
        if ( n < 1 || n > 3)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Direction.getVectorComp: Vector component index out of bound"));
        return _vec[ n-1 ];
    }

    /** sets the direction vector component values
     */
    public void setVec(double[] vec) throws SrmException
    {
        try
        {
            _vec[0] = vec[0];
            _vec[1] = vec[1];
            _vec[2] = vec[2];
        }
        catch (RuntimeException primary_axis)
        {
            throw new SrmException( SrmException._INVALID_INPUT,
                                    new String("Direction.setVec: Input vector size different than 3"));
        }
    }

    /** sets the values of the direction vector
     */
    public void setVectorComp(double comp1, double comp2, double comp3)
    {
        _vec[0] = comp1;
        _vec[1] = comp2;
        _vec[2] = comp3;
    }

    /** sets the value of the Nth component of direction vector
        @note N within [ 1, 2, 3 ]
     */
    public void setVectorComp( int n, double comp) throws SrmException
    {
        if (n < 1 || n > 3)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Direction.setVectorComp: Vector component index out of bound"));

        _vec[ n-1 ] = comp;
    }

    /** Copies the vector component values of this direction to the input direction.
        @note  The reference coordinate of this and input direction must be the same.
    */
    public void copyTo( Direction dir) throws SrmException
    {
        if (dir == null)
          throw new SrmException( SrmException._INVALID_INPUT,
                                    new String("Direction.copyTo: Input direction reference is null"));

        // don't need to check the srf because the ref. coordinate implies the same SRF.
        if (this._ref_coord != dir._ref_coord)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("Direciton.copyTo: Input direction not referring to the" +
                                               " same reference coordinate"));

        dir._vec[0] = this._vec[0];
        dir._vec[1] = this._vec[1];
        dir._vec[2] = this._vec[2];
    }

    /** Returns the shallow copy of this object instance.
        @note The cloned object will reference the same object as the
        original object.
    */
    public Direction makeClone() throws SrmException
    {
        try
        {
            return (Direction)super.clone();
        }
        catch (java.lang.CloneNotSupportedException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
                                   new String("Direction.makeClone(): failed"));
        }
    }

    /** Returns TRUE if the Direction parameters are "Equal"
        @note  Two variables of type "double" are equal
        if their difference is within epsilon=Const.EPSILON
    */
    public boolean isEqual( Direction dir)
    {
        return ((dir != null) &&
                this._srf == dir._srf &&
                this._ref_coord == dir._ref_coord &&
                Const.isEqual(this._vec[0], dir._vec[0], Const.EPSILON) &&
                Const.isEqual(this._vec[1], dir._vec[1], Const.EPSILON) &&
                Const.isEqual(this._vec[2], dir._vec[2], Const.EPSILON));
    }

    /** Gets the reference coordinate associated with the
        Returns the values of the vector as "[ val1, val2, val3 ]"
     */
    public String toString()
    {
        return "[ " + _vec[0] + ", " +  _vec[1] + ", " + _vec[2] + " ]" ;
    }

    /** Constructor, requires an SRF, 3 reference coordinate values, and
        3 direction values.
    */
    protected Direction(BaseSRF srf,
                        Coord3D ref_coord,
                        double  vec[])
    {
        _srf = srf;
        _ref_coord = ref_coord;
        _vec = vec;
    }


    /** Returns the actual reference coordinate object associated with the Direction
     */
    protected Coord3D getInternalRefCoord()
    {
        return _ref_coord;
    }
}
