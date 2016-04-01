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

/** SRF_LambertConformalConic class declaration.
@author David Shen
@see BaseSRF_MapProjection
*/
public class SRF_LambertConformalConic extends BaseSRF_MapProjection
{
    /// Cached constants for the Point Scale calculation
    // set to sentinel value of 123.123
    private double _lcc_n = 123.123;
    private double _lcc_mphi1 = 0.0;
    private double _lcc_tphi1 = 0.0;

    /// Cached constants for the COM calculation
    // set to sentinel value of 123.123
    private double _com_n = 123.123;

    /// SRF Parameter data using SRF_LCC_Params
    private SRF_LCC_Params _params = new SRF_LCC_Params();

    /** Constructor by SRF parameter object
    */
    public SRF_LambertConformalConic(SRM_ORM_Code   orm,
                                     SRM_RT_Code    rt,
                                     SRF_LCC_Params params) throws SrmException
    {
        _mySrftCode = SRM_SRFT_Code.SRFTCOD_LAMBERT_CONFORMAL_CONIC;
        _myCsCode   = SRM_CS_Code.CSCOD_LAMBERT_CONFORMAL_CONIC;
        _orm        = orm;
        _rt         = rt;
        _params.origin_longitude = params.origin_longitude;
        _params.origin_latitude = params.origin_latitude;
        _params.latitude1 = params.latitude1;
        _params.latitude2 = params.latitude2;
        _params.false_easting = params.false_easting;
        _params.false_northing = params.false_northing;

        SrfCheck.forLambertConformalConic(_orm, _rt, _params);
    }

    /** Constructor by individual SRF parameters
    */
    public SRF_LambertConformalConic(
                                    SRM_ORM_Code orm,
                                    SRM_RT_Code rt,
                                    double origin_longitude,
                                    double origin_latitude,
                                    double latitude1,
                                    double latitude2,
                                    double false_easting,
                                    double false_northing
                                ) throws SrmException
    {
        _mySrftCode = SRM_SRFT_Code.SRFTCOD_LAMBERT_CONFORMAL_CONIC;
        _myCsCode   = SRM_CS_Code.CSCOD_LAMBERT_CONFORMAL_CONIC;
        _orm        = orm;
        _rt         = rt;
        _params.origin_longitude = origin_longitude;
        _params.origin_latitude = origin_latitude;
        _params.latitude1 = latitude1;
        _params.latitude2 = latitude2;
        _params.false_easting = false_easting;
        _params.false_northing = false_northing;

        SrfCheck.forLambertConformalConic(_orm, _rt, _params);
    }

    /** Create specific 3D coordinate for SRF_LambertConformalConic with
        [ Double.NaN, Double.NaN, Double.NaN ]
    */
    public Coord3D createCoordinate3D()
    {
        return new Coord3D_LambertConformalConic
                   ((SRF_LambertConformalConic)this,
                    Double.NaN, Double.NaN, Double.NaN);
    }

    /** Create specific 3D coordinate for SRF_LambertConformalConic with
        input values
    */
    public Coord3D createCoordinate3D(double coord_comp1,
                                      double coord_comp2,
                                      double coord_comp3)
    {
        return new Coord3D_LambertConformalConic
                   ((SRF_LambertConformalConic)this,
                    coord_comp1, coord_comp2, coord_comp3);
    }

    /** Create specific Surface coordinate for SRF_LambertConformalConic with
        [ Double.NaN, Double.NaN ]
    */
    public CoordSurf createSurfaceCoordinate()
    {
        return new CoordSurf_LambertConformalConic
                   ((SRF_LambertConformalConic)this,
                    Double.NaN, Double.NaN);
    }

    /** Create specific Surface coordinate for SRF_LambertConformalConic with
        input values
    */
    public CoordSurf createSurfaceCoordinate(double coord_comp1,
                                             double coord_comp2)
    {
        return new CoordSurf_LambertConformalConic
                   ((SRF_LambertConformalConic)this,
                    coord_comp1, coord_comp2);
    }

    /** Returns the SRF parameter object
    */
    public SRF_LCC_Params getSRFParameters()
    {
       SRF_LCC_Params retParams = new SRF_LCC_Params();

       retParams.origin_longitude = _params.origin_longitude;
       retParams.origin_latitude = _params.origin_latitude;
       retParams.latitude1 = _params.latitude1;
       retParams.latitude2 = _params.latitude2;
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

    /** Returns the origin_latitude SRF parameter value
    */
    public double get_origin_latitude()
    {
        return _params.origin_latitude;
    }

    /** Returns the latitude1 SRF parameter value
    */
    public double get_latitude1()
    {
        return _params.latitude1;
    }

    /** Returns the latitude2 SRF parameter value
    */
    public double get_latitude2()
    {
        return _params.latitude2;
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

    /** Returns a surface coordinate associated with a 3D coordinate for
        SRF_LambertConformalConic
    */
    public CoordSurf getAssociatedSurfaceCoordinate(Coord3D coord)
    throws SrmException
    {
       if (coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("getAssociatedSurfaceCoordinate: Coordinate associated with different SRF"));

        return new CoordSurf_LambertConformalConic
                   ((SRF_LambertConformalConic)this,
                    coord.getValues()[0],
                    coord.getValues()[1]);
    }

    /** Returns a 3D coordinate representing the same location as
        specified by a surface coordinate for SRF_LambertConformalConic
    */
    public Coord3D getPromotedSurfaceCoordinate(CoordSurf surf_coord)
    throws SrmException
    {
       if (surf_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("getPromotedSurfaceCoordinate: Coordinate associated with different SRF"));

        return new Coord3D_LambertConformalConic
                   ((SRF_LambertConformalConic)this,
                    surf_coord.getValues()[0],
                    surf_coord.getValues()[1],
                    0.0);
    }

    /** Returns TRUE if the SRF parameters are equal
    */
    public boolean isEqual(BaseSRF srf)
    {
        return ((srf != null) &&
                (srf instanceof SRF_LambertConformalConic) &&
                 this._orm == srf.getOrm() &&
                 this._rt == srf.getRt() &&
                 this._params.isEqual(((SRF_LambertConformalConic)srf).
                                      getSRFParameters()));
    }

    /** Returns a String with the parameter values
    */
    public String toString()
    {
       String retString = new String();

       retString = super.toString() + "\n" + _params;

       return retString;
    }

    protected double comCalculation(OrmData e_constants, double[] cd_coord)
    throws SrmException
    {
        double lambda_star;

        // compute initialization data if not done already
        if (_com_n == 123.123)
        {
            double
                sin_lat1, sin_lat2,
                epsilon_squared_sin_squared_lat1,
                epsilon_squared_sin_squared_lat2,
                epsilon_times_sin_lat1, epsilon_times_sin_lat2,
                m_phi1, m_phi2, tan_phi1, tan_phi2;

            double latitude1 = get_latitude1();
            double latitude2 = get_latitude2();

            sin_lat1 = Math.sin(latitude1);
            epsilon_times_sin_lat1 = e_constants.Eps * sin_lat1;
            epsilon_squared_sin_squared_lat1 = epsilon_times_sin_lat1 *
                                               epsilon_times_sin_lat1;
            sin_lat2 = Math.sin(latitude2);
            epsilon_times_sin_lat2 = e_constants.Eps * sin_lat2;
            epsilon_squared_sin_squared_lat2 = epsilon_times_sin_lat2 *
                                               epsilon_times_sin_lat2;

            m_phi1 = Math.cos(latitude1) /
                     Math.sqrt(1.0 - epsilon_squared_sin_squared_lat1);
            m_phi2 = Math.cos(latitude2) /
                     Math.sqrt(1.0 - epsilon_squared_sin_squared_lat2);

            tan_phi1= Math.tan(Const.PI_DIV_4 - latitude1 * 0.5) *
                Math.pow((1.0+epsilon_times_sin_lat1)/
                         (1.0-epsilon_times_sin_lat1), e_constants.EpsH);

            tan_phi2= Math.tan(Const.PI_DIV_4 - latitude2 * 0.5) *
                Math.pow((1.0+epsilon_times_sin_lat2)/
                         (1.0-epsilon_times_sin_lat2), e_constants.EpsH);

            if (Const.isEqual(latitude1, latitude2, Const.EPSILON))
            {
                _com_n = Math.sin(latitude1);
            }
            else // if different
            {
                _com_n =
                       (Math.log(m_phi1) - Math.log(m_phi2)) /
                       (Math.log(tan_phi1) - Math.log(tan_phi2));
            }
        }
        // performing LCC_AUGMENTED_3D COM calculation
        lambda_star = Const.getLambdaStar(cd_coord[0],  // lon
                                          get_origin_longitude());

        return (_com_n * lambda_star);
    }

    protected double pointScaleCalculation
    (
        OrmData  e_constants,
        double[] cd_coord
    ) throws SrmException
    {
        double esphi, mphi, sphi, tphi;

        // compute initialization data if not done already
        if (_lcc_n == 123.123)
        {
            double slat1, slat2, e2slat12, e2slat22, eslat1, eslat2,
                   mphi2, tphi2;

            double latitude1 = get_latitude1();
            double latitude2 = get_latitude2();

            slat1 = Math.sin(latitude1);
            eslat1 = e_constants.Eps * slat1;
            e2slat12 = eslat1 * eslat1;
            slat2 = Math.sin(latitude2);
            eslat2 = e_constants.Eps * slat2;
            e2slat22 = eslat2 * eslat2;

            _lcc_mphi1 = Math.cos(latitude1) / Math.sqrt(1.0 - e2slat12);
            mphi2 = Math.cos(latitude2) / Math.sqrt(1.0 - e2slat22);

            _lcc_tphi1=
                Math.tan(Const.PI_DIV_4 - latitude1 * 0.5) *
              Math.pow((1.0+eslat1)/(1.0-eslat1), e_constants.EpsH);
            tphi2=
              Math.tan(Const.PI_DIV_4 - latitude2 * 0.5) *
              Math.pow((1.0+eslat2)/(1.0-eslat2), e_constants.EpsH);

            if (Const.isEqual(latitude1, latitude2, Const.EPSILON))
            {
                _lcc_n = slat1;
            }
            else // if different
            {
                _lcc_n =
                    (Math.log(_lcc_mphi1) - Math.log(mphi2)) /
                    (Math.log(_lcc_tphi1) - Math.log(tphi2));
            }
        }
        sphi =  Math.sin(cd_coord[1]);

        esphi = e_constants.Eps * sphi;

        tphi =
            Math.tan(Const.PI_DIV_4 - cd_coord[1] * 0.5) *
            Math.pow((1.0+esphi)/(1.0-esphi), e_constants.EpsH);

        mphi =
            Math.cos(cd_coord[1]) /
            Math.sqrt(1.0 - esphi*esphi);

        return ((_lcc_mphi1/mphi) *
                Math.pow( tphi/_lcc_tphi1, _lcc_n));
    }
}
