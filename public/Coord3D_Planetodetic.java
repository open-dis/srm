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

/** A Coord3D for SRF_Planetodetic.
@author David Shen
@see SRF_Planetodetic
*/
public class Coord3D_Planetodetic extends Coord3D
{
    /** Constructor with initial value defaulted to [ Double.NaN, Double.NaN, Double.NaN ]
     */
    public Coord3D_Planetodetic(SRF_Planetodetic srf)
    {
        super( srf, Coord_ClassType.PD_3D );
        setValues( Double.NaN, Double.NaN, Double.NaN );
    }

    /** Constructor with input values
     */
    public Coord3D_Planetodetic
    (
        SRF_Planetodetic srf,
        double           latitude,
        double           longitude,
        double           ellipsoidal_height
    )
    {
        super(srf, Coord_ClassType.PD_3D);
        setValues(latitude, longitude, ellipsoidal_height);
    }

    /** Copy constructor
     */
    public Coord3D_Planetodetic( Coord3D_Planetodetic original)
    {
        super(original.getSRF(), Coord_ClassType.PD_3D);
        setValues(original._values[0],
                  original._values[1],
                  original._values[2]);
    }

    /** Sets all coordinate component values
     */
    public void setValues(double latitude, double longitude, double ellipsoidal_height)
    {
        _values[0] = latitude;
        _values[1] = longitude;
        _values[2] = ellipsoidal_height;
    }

    /** Returns the latitude value
     */
    public double get_latitude()
    {
        return _values[0];
    }

    /** Returns the longitude value
     */
    public double get_longitude()
    {
        return _values[1];
    }

    /** Returns the ellipsoidal_height value
     */
    public double get_ellipsoidal_height()
    {
        return _values[2];
    }

    /** Sets the latitude value
     */
    public void set_latitude(double value)
    {
        _values[0] = value;
    }

    /** Sets the longitude value
     */
    public void set_longitude(double value)
    {
        _values[1] = value;
    }

    /** Sets the ellipsoidal_height value
     */
    public void set_ellipsoidal_height(double value)
    {
        _values[2] = value;
    }

    /* Returns TRUE if the coordinate components are "Equal"
       @note Two component values of type "double" are equal
             if their difference is within Const.EPSILON
    */
    public boolean isEqual(Coord coord)
    {
        if (coord == null)
           return false;

        double[] tmp = coord.getValues();

        return ((coord instanceof Coord3D_Planetodetic) &&
                 Const.isEqual( this._values[0], tmp[0], Const.EPSILON) &&
                 Const.isEqual( this._values[1], tmp[1], Const.EPSILON) &&
                 Const.isEqual( this._values[2], tmp[2], Const.EPSILON));
    }

    /** Returns a String of coordinate component (lat, lon, height) values
     */
    public String toString()
    {
        return new String("[ " + _values[0] + ", " +  _values[1] + ", " +  _values[2] + " ]");
    }
}
