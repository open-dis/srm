/** @author David Shen
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

package SRM;

/** SRF_Mercator class declaration.
@author David Shen
@see BaseSRF_MapProjection
*/
public class SRF_Mercator extends BaseSRF_MapProjection
{
    /** SRF Parameter data using SRF_M_Params
     */
    private SRF_M_Params _params = new SRF_M_Params();

    /** Constructor by SRF parameter object
     */
    public SRF_Mercator( SRM_ORM_Code orm,
                         SRM_RT_Code rt,
                         SRF_M_Params params ) throws SrmException
    {
        _mySrftCode = SRM_SRFT_Code.SRFTCOD_MERCATOR;
        _myCsCode = SRM_CS_Code.CSCOD_MERCATOR;
        _orm = orm;
        _rt = rt;
        _params.origin_longitude = params.origin_longitude;
        _params.central_scale = params.central_scale;
        _params.false_easting = params.false_easting;
        _params.false_northing = params.false_northing;

        SrfCheck.forMercator( _orm, _rt, _params );
    }

    /** Constructor by individual SRF parameters
     */
    public SRF_Mercator(
                        SRM_ORM_Code orm,
                        SRM_RT_Code rt,
                        double origin_longitude,
                        double central_scale,
                        double false_easting,
                        double false_northing
                       ) throws SrmException
    {
        _mySrftCode = SRM_SRFT_Code.SRFTCOD_MERCATOR;
        _myCsCode = SRM_CS_Code.CSCOD_MERCATOR;
        _orm = orm;
        _rt = rt;
        _params.origin_longitude = origin_longitude;
        _params.central_scale = central_scale;
        _params.false_easting = false_easting;
        _params.false_northing = false_northing;

        SrfCheck.forMercator( _orm, _rt, _params );
    }

    /** Create specific 3D coordinate for SRF_Mercator with [ Double.NaN, Double.NaN, Double.NaN ]
     */
    public Coord3D createCoordinate3D( )
    {
        return new Coord3D_Mercator( (SRF_Mercator)this,
                                     Double.NaN, Double.NaN, Double.NaN );
    }

    /** Create specific 3D coordinate for SRF_Mercator with input values
     */
    public Coord3D createCoordinate3D( double coord_comp1,
                                       double coord_comp2,
                                       double coord_comp3 )
    {
        return new Coord3D_Mercator( (SRF_Mercator)this,
                                     coord_comp1, coord_comp2, coord_comp3);
    }

    /** Create specific Surface coordinate for SRF_Mercator with [ Double.NaN, Double.NaN ]
     */
    public CoordSurf createSurfaceCoordinate( )
    {
        return new CoordSurf_Mercator( (SRF_Mercator)this,
                                             Double.NaN, Double.NaN );
    }

    /** Create specific Surface coordinate for SRF_Mercator with input values
     */
    public CoordSurf createSurfaceCoordinate( double coord_comp1,
                                              double coord_comp2 )
    {
        return new CoordSurf_Mercator( (SRF_Mercator)this,
                                       coord_comp1, coord_comp2);
    }

    /** Returns the SRF parameter object
     */
    public SRF_M_Params getSRFParameters()
    {
        SRF_M_Params retParams = new SRF_M_Params();

        retParams.origin_longitude = _params.origin_longitude;
        retParams.central_scale = _params.central_scale;
        retParams.false_easting = _params.false_easting;
        retParams.false_northing = _params.false_northing;

        return retParams;
    }

    /** Returns the origin_longitude SRF parameter value
     */
    public double get_origin_longitude()
    {
        return _params.origin_longitude;
    }

    /** Returns the central_scale SRF parameter value
     */
    public double get_central_scale()
    {
        return _params.central_scale;
    }

    /** Returns the false_easting SRF parameter value
     */
    public double get_false_easting()
    {
        return _params.false_easting;
    }

    /** Returns the false_northing SRF parameter value
     */
    public double get_false_northing()
    {
        return _params.false_northing;
    }

    /** Returns a surface coordinate associated with a 3D coordinate for SRF_Mercator
     */
    public CoordSurf getAssociatedSurfaceCoordinate( Coord3D coord ) throws SrmException
    {
       if (coord.getSRF() != this)
            throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getAssociatedSurfaceCoordinate: Coordinate associated with different SRF"));

        return new CoordSurf_Mercator((SRF_Mercator)this,
                                      coord.getValues()[0],
                                      coord.getValues()[1]);
    }

    /** Returns a 3D coordinate representing the same location as
     *  specified by a surface coordinate for SRF_Mercator
     */
    public Coord3D getPromotedSurfaceCoordinate( CoordSurf surf_coord ) throws SrmException
    {
       if (surf_coord.getSRF() != this)
            throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getPromotedSurfaceCoordinate: Coordinate associated with different SRF"));

        return new Coord3D_Mercator((SRF_Mercator)this,
                                    surf_coord.getValues()[0],
                                    surf_coord.getValues()[1],
                                    0.0);
    }

    /** Returns TRUE if the SRF parameters are equal
    */
    public boolean isEqual( BaseSRF srf )
    {
        return ((srf != null) &&
                (srf instanceof SRF_Mercator ) &&
                 this._orm == srf.getOrm() &&
                 this._rt == srf.getRt() &&
                 this._params.isEqual( ((SRF_Mercator)srf).getSRFParameters() ) );
    }

    /** Returns a String with the parameter values */
    public String toString()
    {
       String retString = new String();

       retString = retString + super.toString() + "\n";
       retString = retString + _params;

       return retString;
    }

    protected double comCalculation( OrmData e_constants, double[] cd_coord ) throws SrmException
    {
        // The COM for Mercator is always 0.0
        return 0.0;
    }

   protected double pointScaleCalculation( OrmData e_constants, double[] cd_coord ) throws SrmException
   {
      double slat= Math.sin( cd_coord[1] );
      double Rn=0.0;

      Rn = Const.computeRnFast( slat*slat, e_constants );

      return ( get_central_scale()*e_constants.A/(Rn*Math.cos(cd_coord[1])) );
   }
}
