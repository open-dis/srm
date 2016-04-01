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
@brief Declaration of 2D coordinate base classes.
*/

package SRM;

/** The Coord2D abstract class is used for representing 2D coordinates.
@see Coord
*/
public abstract class Coord2D extends Coord
{
    /** An array to store the coordinate component values
    */
    protected double[] _values = new double [2];

    /** Constructor setting the associated SRF and the concrete class type
    */
    protected Coord2D (BaseSRF assocSRF, Coord_ClassType type)
    {
        super(assocSRF, type);
    }

    /** Returns the coordinate component values as an array
        @return an array of size 2 containing the 2D coordinate component values
    */
    public double[] getValues()
    {
        double[] retVal = new double[2];

        retVal[0] = _values[0];
        retVal[1] = _values[1];

        return retVal;
    }

    /** Sets the coordinate component values as an array
        @param values in: array of size 2 containing the
                          2D coordinate component values
    */
    public void setValues(double[] values) throws SrmException
    {
        try
        {
            _values[0] = values[0];
            _values[1] = values[1];
        }
        catch (RuntimeException primary_axis)
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Coord2D.setValues: " +
                                   "Input array size different than 2"));
        }
    }

    /** Returns TRUE if the coordinate component values are "equal"
        @note  Two components of type "double" are equal
               if their difference is within Const.EPSILON
    */
    public boolean isEqual(Coord coord)
    {
        if (coord == null)
           return false;

        double[] tmp = coord.getValues();

        return ((this.getClass()  == coord.getClass()) &&
                 Const.isEqual(this._values[0], tmp[0], Const.EPSILON) &&
                 Const.isEqual(this._values[1], tmp[1], Const.EPSILON));
    }

    /** Copies the component values from this coordinate to the parameter
        coordinate.
        @note  The parameter coordinate and this coordinate must be associated
               with the same SRF.
    */
    public void copyTo(Coord2D coord) throws SrmException
    {
        if (coord == null)
          throw new SrmException(SrmException._INVALID_INPUT,
                                 new String("Coord2D.copyTo: " +
                                 "Input coordinate reference is null"));

        if (this.getSRF() != coord.getSRF())
          throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                 new String("Coord2D.copyTo: " +
                                 "Input coordinate not of the same SRF"));

        coord._values[0] = this._values[0];
        coord._values[1] = this._values[1];
    }
}
