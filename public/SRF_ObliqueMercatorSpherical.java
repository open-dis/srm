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

/** SRF_ObliqueMercatorSpherical class declaration.
@author David Shen
@see BaseSRF_MapProjection
*/
public class SRF_ObliqueMercatorSpherical extends BaseSRF_MapProjection
{
    /** Constants used in COM and OM_AUGMENTED_3D calculation
     * _com_cl0 is assigned the sentinel value of 123.123
     */
    private double _const_om_cl0 = 123.123;
    private double _const_om_sl0 = 0.0;
    private double _const_om_ca0 = 0.0;
    private double _const_om_sa0 = 0.0;

    /** SRF Parameter data using SRF_OM_Params
     */
    private SRF_OM_Params _params = new SRF_OM_Params();

    /** Constructor by SRF parameter object
     */
    public SRF_ObliqueMercatorSpherical(SRM_ORM_Code  orm,
                                        SRM_RT_Code   rt,
                                        SRF_OM_Params params) throws SrmException
    {
        _mySrftCode = SRM_SRFT_Code.SRFTCOD_OBLIQUE_MERCATOR_SPHERICAL;
        _myCsCode = SRM_CS_Code.CSCOD_OBLIQUE_MERCATOR_SPHERICAL;
        _orm = orm;
        _rt = rt;
        _params.longitude1 = params.longitude1;
        _params.latitude1 = params.latitude1;
        _params.longitude2 = params.longitude2;
        _params.latitude2 = params.latitude2;
        _params.central_scale = params.central_scale;
        _params.false_easting = params.false_easting;
        _params.false_northing = params.false_northing;

        SrfCheck.forObliqueMercatorSpherical( _orm, _rt, _params );
    }

    /** Constructor by individual SRF parameters
     */
    public SRF_ObliqueMercatorSpherical
    (
        SRM_ORM_Code orm,
        SRM_RT_Code  rt,
        double       longitude1,
        double       latitude1,
        double       longitude2,
        double       latitude2,
        double       central_scale,
        double       false_easting,
        double       false_northing
    ) throws SrmException
    {
        _mySrftCode = SRM_SRFT_Code.SRFTCOD_OBLIQUE_MERCATOR_SPHERICAL;
        _myCsCode = SRM_CS_Code.CSCOD_OBLIQUE_MERCATOR_SPHERICAL;
        _orm = orm;
        _rt = rt;
        _params.longitude1 = longitude1;
        _params.latitude1 = latitude1;
        _params.longitude2 = longitude2;
        _params.latitude2 = latitude2;
        _params.central_scale = central_scale;
        _params.false_easting = false_easting;
        _params.false_northing = false_northing;

        SrfCheck.forObliqueMercatorSpherical( _orm, _rt, _params );
    }

    /** Create specific 3D coordinate for SRF_ObliqueMercatorSpherical with [ Double.NaN, Double.NaN, Double.NaN ]
     */
    public Coord3D createCoordinate3D( )
    {
        return new Coord3D_ObliqueMercatorSpherical( (SRF_ObliqueMercatorSpherical)this,
                                             Double.NaN, Double.NaN, Double.NaN );
    }

    /** Create specific 3D coordinate for SRF_ObliqueMercatorSpherical with input values
     */
    public Coord3D createCoordinate3D( double coord_comp1,
                                       double coord_comp2,
                                       double coord_comp3 )
    {
        return new Coord3D_ObliqueMercatorSpherical( (SRF_ObliqueMercatorSpherical)this,
                                             coord_comp1, coord_comp2, coord_comp3);
    }

    /** Create specific Surface coordinate for SRF_ObliqueMercatorSpherical with [ Double.NaN, Double.NaN ]
     */
    public CoordSurf createSurfaceCoordinate( )
    {
        return new CoordSurf_ObliqueMercatorSpherical( (SRF_ObliqueMercatorSpherical)this,
                                             Double.NaN, Double.NaN );
    }

    /** Create specific Surface coordinate for SRF_ObliqueMercatorSpherical with input values
     */
    public CoordSurf createSurfaceCoordinate( double coord_comp1,
                                              double coord_comp2 )
    {
        return new CoordSurf_ObliqueMercatorSpherical( (SRF_ObliqueMercatorSpherical)this,
                                             coord_comp1, coord_comp2);
    }

    /** Returns the SRF parameter object
     */
    public SRF_OM_Params getSRFParameters()
    {
       SRF_OM_Params retParams = new SRF_OM_Params();

       retParams.longitude1 = _params.longitude1;
       retParams.latitude1 = _params.latitude1;
       retParams.longitude2 = _params.longitude2;
       retParams.latitude2 = _params.latitude2;
       retParams.central_scale = _params.central_scale;
       retParams.false_easting = _params.false_easting;
       retParams.false_northing = _params.false_northing;

       return retParams;
    }

    /** Returns the longitude1 SRF parameter value
     */
    public double get_longitude1()
    {
        return _params.longitude1;
    }

    /** Returns the latitude1 SRF parameter value
     */
    public double get_latitude1()
    {
        return _params.latitude1;
    }

    /** Returns the longitude2 SRF parameter value
     */
    public double get_longitude2()
    {
        return _params.longitude2;
    }

    /** Returns the latitude2 SRF parameter value
     */
    public double get_latitude2()
    {
        return _params.latitude2;
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

    /** Returns a surface coordinate associated with a 3D coordinate for SRF_ObliqueMercatorSpherical
     */
    public CoordSurf getAssociatedSurfaceCoordinate( Coord3D coord ) throws SrmException
    {
       if (coord.getSRF() != this)
            throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getAssociatedSurfaceCoordinate: Coordinate associated with different SRF"));

        return new CoordSurf_ObliqueMercatorSpherical((SRF_ObliqueMercatorSpherical)this,
                                               coord.getValues()[0],
                                               coord.getValues()[1]);
    }

    /** Returns a 3D coordinate representing the same location as
     *  specified by a surface coordinate for SRF_ObliqueMercatorSpherical
     */
    public Coord3D getPromotedSurfaceCoordinate( CoordSurf surf_coord ) throws SrmException
    {
       if (surf_coord.getSRF() != this)
            throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getPromotedSurfaceCoordinate: Coordinate associated with different SRF"));

        return new Coord3D_ObliqueMercatorSpherical((SRF_ObliqueMercatorSpherical)this,
                                               surf_coord.getValues()[0],
                                               surf_coord.getValues()[1],
                                               0.0);
    }

    /** Returns TRUE if the SRF parameters are equal
    */
    public boolean isEqual( BaseSRF srf )
    {
        return ((srf != null ) &&
                (srf instanceof SRF_ObliqueMercatorSpherical ) &&
                 this._orm == srf.getOrm() &&
                 this._rt == srf.getRt() &&
                 this._params.isEqual( ((SRF_ObliqueMercatorSpherical)srf).getSRFParameters() ) );
    }

    /** Returns a String with the parameter values
     */
    public String toString()
    {
        String retString = new String();

        retString = retString + super.toString() + "\n";
        retString = retString + _params;

        return retString;
    }

    private void setOmConst ( )
    {
        double
          sin_lat1=0.0,
          cos_lat1=0.0,
          sin_lat2=0.0,
          cos_lat2=0.0,
          sin_lon1=0.0,
          cos_lon1=0.0,
          sin_lon2=0.0,
          cos_lon2=0.0,
          lambda_0=0.0,
          sin_lambda_1_minus_lambda_0=0.0,
          sin_lambda_2_minus_lambda_0=0.0,
          p0=0.0,
          q0=0.0,
          alpha_0=0.0;

        sin_lat1 = Math.sin( get_latitude1() );
        cos_lat1 = Math.cos( get_latitude1() );

        sin_lat2 = Math.sin( get_latitude2() );
        cos_lat2 = Math.cos( get_latitude2() );

        sin_lon1 = Math.sin( get_longitude1() );
        cos_lon1 = Math.cos( get_longitude1() );

        sin_lon2 = Math.sin( get_longitude2() );
        cos_lon2 = Math.cos( get_longitude2() );


        p0=cos_lat1*sin_lat2*sin_lon1-sin_lat1*cos_lat2*sin_lon2;
        q0=cos_lat1*sin_lat2*cos_lon1-sin_lat1*cos_lat2*cos_lon2;

        lambda_0=Math.atan2(p0,q0);

        _const_om_cl0=Math.cos(lambda_0);
        _const_om_sl0=Math.sin(lambda_0);

        sin_lambda_1_minus_lambda_0=sin_lon1*_const_om_cl0-cos_lon1*_const_om_sl0;
        sin_lambda_2_minus_lambda_0=sin_lon2*_const_om_cl0-cos_lon2*_const_om_sl0;

        if(Math.abs(sin_lambda_1_minus_lambda_0)>=Math.abs(sin_lambda_2_minus_lambda_0))
        {
            alpha_0=Math.atan(sin_lat1/(cos_lat1*sin_lambda_1_minus_lambda_0));
        }
        else
        {
            alpha_0=Math.atan(sin_lat2/(cos_lat2*sin_lambda_2_minus_lambda_0));
        }
        _const_om_sa0=Math.sin(alpha_0);
        _const_om_ca0=Math.cos(alpha_0);
    }

    protected double comCalculation( OrmData e_constants, double[] cd_coord ) throws SrmException
    {
        double sin_lon, cos_lon, sin_lat, cos_lat,
            sin_lambda_minus_lambda_0, cos_lambda_minus_lambda_0;

        sin_lon = Math.sin( cd_coord[0] );
        cos_lon = Math.cos( cd_coord[0] );
        sin_lat = Math.sin( cd_coord[1] );
        cos_lat = Math.cos( cd_coord[1] );

        // compute initialization data if not done already
        if ( _const_om_cl0 == 123.123 )
              setOmConst();

        sin_lambda_minus_lambda_0=(sin_lon*_const_om_cl0-cos_lon*_const_om_sl0);
        cos_lambda_minus_lambda_0=(cos_lon*_const_om_cl0+sin_lon*_const_om_sl0);

        return Math.atan2( -_const_om_sa0*cos_lambda_minus_lambda_0,
                           _const_om_ca0*cos_lat +
                           _const_om_sa0*sin_lat*sin_lambda_minus_lambda_0 );
    }

    protected double pointScaleCalculation( OrmData e_constants, double[] cd_coord ) throws SrmException
    {
        double
          sin_lat=Math.sin(cd_coord[1]),
          cos_lat=Math.cos(cd_coord[1]),
          sin_lon=Math.sin(cd_coord[0]),
          cos_lon=Math.cos(cd_coord[0]) ;

        // compute initialization data if not done already
        if ( _const_om_cl0 == 123.123 )
            setOmConst();

        double A=
            (_const_om_ca0*sin_lat)-
            (_const_om_sa0*cos_lat*(sin_lon*_const_om_cl0 - cos_lon*_const_om_sl0));

        return ( get_central_scale() / Math.sqrt( 1 - A*A ) );
    }
}
