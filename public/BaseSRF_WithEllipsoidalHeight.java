/**
@author David Shen
@brief Declaration of Base SRF with ellipsoidal height.
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

import java.util.*;
import java.io.*;

/** The BaseSRF_WithEllipsoidalHeight abstract class.
@author David Shen
@see BaseSRF_3D, BaseSRF
*/
public abstract class BaseSRF_WithEllipsoidalHeight extends BaseSRF_3D
{
    /** Creates a surface coordinate object with default [ Double.NaN, Double.NaN ].
        @return a surface coordinate object
     */
    public abstract CoordSurf createSurfaceCoordinate();

    /** Creates a surface coordinate object with initial values.
        @param coord_surf_comp1 in: the values of the first component of the surface coordinate
        @param coord_surf_comp2 in: the values of the second component of the surface coordinate
        @return a surface coordinate object
     */
    public abstract CoordSurf createSurfaceCoordinate(double coord_surf_comp1,
                                                      double coord_surf_comp2);

    /** Retrieves a coordinate surface component values
        @param coord_surf in: a surface coordinate
        @return an array of size 2 containing the component values for the surface coordinate
        @note The input surface coordinate must have been created using this SRF.
     */
    public double[] getSurfaceCoordinateValues(CoordSurf coord_surf) throws SrmException
    {
        if (coord_surf == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getSurfaceCoordinateValues: Input null reference coordinate"));

        return coord_surf.getValues();
    }


    /** Returns a surface coordinate associated with a 3D coordinate.
        @param coord in: a 3D coordinate in this SRF
        @return a surface coordinate object in this SRF
        @note The input coordinate must have been created using this SRF.
     */
    public abstract CoordSurf getAssociatedSurfaceCoordinate(Coord3D coord) throws SrmException;


    /** Returns a 3D coordinate representing the same location as specified
        by a surface coordinate.
        @param surf_coord in: a surface coordinate in this SRF
        @return a 3D coordinate object in this SRF
        @note The input surface coordinate must have been created using this SRF.
    */
    public abstract Coord3D getPromotedSurfaceCoordinate(CoordSurf surf_coord) throws SrmException;


    /** Creates a Local Tangent Euclidean SRF with natural origin at a given
        position.
        @param surf_coord in: a surface coordinate
        @param azimuth in: the LTE's azimuth parameter
        @param false_x_origin in: the LTE's false x origin
        @param false_y_origin in: the LTE's false y origin
        @param offset_height in: the LTE's offset height
        @return a local tangent euclidean object
        @note The input surface coordinate must have been created using this SRF.
    */
    public SRF_LocalTangentSpaceEuclidean
        createLocalTangentSpaceEuclideanSRF(CoordSurf surf_coord,
                                            double azimuth,
                                            double false_x_origin,
                                            double false_y_origin,
                                            double offset_height) throws SrmException
    {
        if (surf_coord == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("createLocalTangentEuclideanSRF: null reference input parameter"));

        if (surf_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("createLocalTangentEuclideanSRF: Coordinate associated with different SRF"));

        try
        {
            return LteSupport.createLtesSRF(this, surf_coord.getValues(), azimuth,
                                            false_x_origin, false_y_origin, offset_height);
        }
        catch (SrmException ex)
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("createLocalTangentEuclideanSRF: Incompatible input parameters"));
        }
    }


    /** Computes the natural SRF Set member code (region) where the Surface coordinate is
        located in the target SRF Set.
        @note The input coordinate must have been created using this SRF.
        @param src_coord in : the source surface coordinate in an SRF
        @param orm_dst in : the ORM for the destination SRF Set
        @param rt_dst in : the RT for the destination SRF Set
        @param tgt_srfs in : the destination SRF Set Code
        @return the SRF Set Member code for the destination SRF Set
    */
    public SRM_SRFSM_Code getNaturalSRFSetMemberCode(CoordSurf src_coord,
                                                     SRM_ORM_Code orm_dst,
                                                     SRM_RT_Code rt_dst,
                                                     SRM_SRFS_Code tgt_srfs) throws SrmException
    {
        if (src_coord == null || orm_dst == null || rt_dst == null || tgt_srfs == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getNaturalSRFSetMemberCode: null reference input parameter"));

        if (src_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getNaturalSRFSetMemberCode: Coordinate associated with different SRF"));

        // fill in the third coord (altitude) parameter with 0.0.
        // The set member is independent of the altitude.
        double[] tmpCoord = { src_coord.getValues()[0], src_coord.getValues()[1], 0.0 };

        return getMemberCode(tmpCoord, orm_dst, rt_dst, tgt_srfs);
    }


    /** Computes the natural SRF Set member instance that the surface coordinate is
        located in the target SRF Set.
        @note The input coordinate must have been created using this SRF.
        @param src_coord in : the source surface coordinate in an SRF
        @param orm_dst in : the ORM for the destination SRF Set
        @param rt_dst in : the Rt for the destination SRF Set
        @param tgt_srfs in : the destination SRF Set Code
        @return the SRF Set Member instance for the destination SRF Set
    */
    public BaseSRF_3D getNaturalSRFSetMember(CoordSurf src_coord,
                                             SRM_ORM_Code orm_dst,
                                             SRM_RT_Code rt_dst,
                                             SRM_SRFS_Code tgt_srfs) throws SrmException
    {
        if (src_coord == null || orm_dst == null || rt_dst == null || tgt_srfs == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("getNaturalSRFSetMemberCode: null reference input parameter"));

        if (src_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                    new String("getNaturalSRFSetMemberCode: Coordinate associated with different SRF"));

        // fill in the third coord (altitude) parameter with 0.0.
        // The set member is independent of the altitude.
        double[] tmpCoord = { src_coord.getValues()[0], src_coord.getValues()[1], 0.0 };

        SRM_SRFSM_Code tmpMemberCode;

        tmpMemberCode = getMemberCode(tmpCoord, orm_dst, rt_dst, tgt_srfs);

        return (BaseSRF_3D)CreateSRF.srfSetMember(tgt_srfs, tmpMemberCode, orm_dst, rt_dst);
    }


    /** Returns the Euclidean distance between two coordinates.
        @param coord1 in: a coordinate in some SRF
        @param coord2 in: a coordinate in some SRF
        @return the Euclidean distance between the two CoordSurf coordinates (in meters).
        @note The input coordinates do not need to be from the same SRF.
        @note This method will make (and cache) internal conversions when the inputs coordinates
              are from SRFs other than SRF_Celestiocentric.
     */
    public static double calculateEuclideanDistance(CoordSurf coord1,
                                                    CoordSurf coord2) throws SrmException
    {
        SRF_Celestiocentric tempCcSrf;
        double delta_x,delta_y,delta_z;

        /*Check for null reference*/
        if (coord1 == null || coord2 == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("calculateEuclideanDistance: null reference input parameter"));

        /*Test to see if the source and target SRF's are both for the same body*/
        if (OrmDataSet.getElem(coord1.getSRF().getOrm())._reference_orm !=
            OrmDataSet.getElem(coord2.getSRF().getOrm())._reference_orm)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("calculateEuclideanDistance: coordinates" +
                                               " associated with different reference ORMs"));

        // instantiate cache for the interim SRFs
        double[] tempCcSrcCoord = interimConv(coord1,
            SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);

        double[] tempCcTgtCoord = interimConv(coord2,
            SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);

        delta_x = tempCcSrcCoord[0] - tempCcTgtCoord[0];
        delta_y = tempCcSrcCoord[1] - tempCcTgtCoord[1];
        delta_z = tempCcSrcCoord[2] - tempCcTgtCoord[2];

        return Math.sqrt(Const.square(delta_x) +
                          Const.square(delta_y) +
                          Const.square(delta_z));
    }


    /** Returns the geodesic distance between two surface coordinates.
        @param src_coord in: the source surface coordinate in this SRF
        @param des_coord in: the destination surface coordinate in this SRF
        @return the geodesic distance between the two surface coordinates (in meters)
        @note The input surface coordinates must have been created using this SRF.
    */
    public double calculateGeodesicDistance(CoordSurf src_coord,
                                            CoordSurf des_coord) throws SrmException
    {
        if (src_coord.getSRF() != this ||
            des_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("calculateGeodesicDistance: input coordinate not in this SRF"));

        if (src_coord.getValues()[1] == des_coord.getValues()[1] &&
            src_coord.getValues()[2] == des_coord.getValues()[2])
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("calculateGeodesicDistance: the source and destination coordinates are the same"));

        // instantiate cache for the interim SRFs
        double[] tempCdSrcCoord = interimConv(src_coord,
                    SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

        double[] tempCdDesCoord = interimConv(des_coord,
                    SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

        OrmData orm_data = new OrmData(this.getOrm());

        return compute_geodesic_distance (tempCdSrcCoord[1], tempCdSrcCoord[0],
                        tempCdDesCoord[1], tempCdDesCoord[0],
                        orm_data.A, orm_data.F);
    }

    /** Returns the vertical separation at a position.
        @param dss in: the reference vertical offset surface model
        @param surf_coord in: the surface coordinate in this SRF
        @return the vertical separation distance (in meters)
        @note The input surface coordinate must have been created using this SRF.
     */
    public double calculateVerticalSeparationOffset(SRM_DSS_Code dss,
                                                    CoordSurf surf_coord) throws SrmException
    {
        if (surf_coord == null || dss == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   "calculateVerticalSeparationOffset: null input parameter");

        if (surf_coord.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   "calculateVerticalSeparationOffset: input coordinate not in this SRF");

        if (dss == SRM_DSS_Code.DSSCOD_UNSPECIFIED)
            throw new SrmException(SrmException._INVALID_CODE, "calculateVerticalSeparationOffset: Invalid DSS code");

        // the EGM 1996 geoid is the only DSS calculation we can perform.
        if (dss != SRM_DSS_Code.DSSCOD_EGM96_GEOID ||
            dss != SRM_DSS_Code.DSSCOD_WGS84_ELLIPSOID ||
            dss != SRM_DSS_Code.DSSCOD_EGM84_GEOID)
            throw new SrmException(SrmException._OPERATION_UNSUPPORTED, "calculateVerticalSeparationOffset: not supported for this DSS");
        else if (dss == SRM_DSS_Code.DSSCOD_EGM84_GEOID)
            throw new SrmException(SrmException._NOT_IMPLEMENTED, "calculateVerticalSeparationOffset: not implemented for DSS_EGM84_GEOID");

        double[] tgtCdCoord;

        // convert the coordinate to celestiodetic.
        tgtCdCoord = interimConv(surf_coord, SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

        return dssCalculation(dss, tgtCdCoord);
    }

    // private data member for the WGS 1984 geiod data
    static private double[] _wgs84GeoidSeparationData = null;

    // geodetic distance computation algorithm.
    private double compute_geodesic_distance (double phi_1, double lambda_1,
                                              double phi_2, double lambda_2,
                                              double a, double f)
    {
        double geodesic_distance;

        double e2 = (2.-f)*f;

        //Reduced latitudes
        double u1 = Math.atan((1-f)*Math.tan(phi_1));
        double u2 = Math.atan((1-f)*Math.tan(phi_2));

        double deltaomega_old = 0;
        double deltaomega_new = 1;
        double omega, sigma=0.0, cosun, sinun2=0.0, sigmam=0.0, v, t, K1, K2, K3, deltasigma,
          cos_u1, cos_u2, sin_u1, sin_u2, cos_omega, sin_omega, sin_sigma=0.0, cos_sigma=0.0,
          cos_sigmam=0.0, cos_2sigmam=0.0;

        while (Math.abs(deltaomega_old-deltaomega_new) > 1.e-12)
        {
            deltaomega_old = deltaomega_new;
            omega = lambda_2-lambda_1+deltaomega_old;
            cos_u1 = Math.cos(u1);
            cos_u2 = Math.cos(u2);
            sin_u1 = Math.sin(u1);
            sin_u2 = Math.sin(u2);
            cos_omega = Math.cos(omega);
            sin_omega = Math.sin(omega);
            // the following equation uses "hypot" which us not currently supported in Java 2.1.4
            // We will explicitly implement it as sqrt(x*x + y*y).
//          sigma = Math.atan2(Math.hypot(cos_u2*sin_omega,
//                                        cos_u1*sin_u2-sin_u1*cos_u2*cos_omega),
//                             sin_u1*sin_u2+cos_u1*cos_u2*cos_omega);
            {
                double x = cos_u2*sin_omega;
                double y = cos_u1*sin_u2-sin_u1*cos_u2*cos_omega;
                sigma = Math.atan2(Math.sqrt(x*x + y*y),
                                    sin_u1*sin_u2+cos_u1*cos_u2*cos_omega);
            }
            sin_sigma = Math.sin(sigma);
            cos_sigma = Math.cos(sigma);
            cosun = cos_u1*cos_u2*sin_omega/sin_sigma;
            sinun2 = 1.0-cosun*cosun;
            if (sinun2 == 0.0)
                sigmam = Math.acos(cos_sigma-2.0);
            else
                sigmam = Math.acos(cos_sigma-2.0*sin_u1*sin_u2/sinun2+1.e-12);
                //                                                    ^temporary fix to avoid -1.#IND
            cos_sigmam = Math.cos(sigmam);
            cos_2sigmam = Math.cos(2.0*sigmam);

            v = 0.25*f*sinun2;
            K3 = v*(1.0+f+f*f-v*(3.0+7.0*f-13.0*v));
            deltaomega_new = (1.0-K3)*f*cosun*(sigma+K3*sin_sigma*(cos_sigmam+K3*cos_sigma*cos_2sigmam));
        }
        t  = (e2/(1.0-e2))*sinun2/4;
        K1 = 1.0+t*(1.0-t*(3.0-t*(5.0-11.0*t))*0.25);
        K2 = t*(1.0-t*(2.0-t*(37.0-94.0*t)*0.125));
        deltasigma = K2*sin_sigma*(cos_sigmam+
                                   K2*(cos_sigma*cos_2sigmam+
                                       K2*(1.0+2.0*Math.cos(2.0*sigma))*Math.cos(3.0*sigmam)/6.0)*0.25);

        geodesic_distance = K1*(1.0-f)*a*(sigma-deltasigma);

        return geodesic_distance;
    }

    private double[] getFileContent(int numRow,
                                    int numCol,
                                    String file_name)
    throws FileNotFoundException, IOException
    {
        double[] ret_data = new double [numRow * numCol];

        Reader reader = null;

        try
        {
            reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(file_name)));
            StringBuffer sb = new StringBuffer();
            char[] cBuf = new char[numRow * numCol];
            for (int i = 0; (i = reader.read(cBuf)) > -1;)
            {
                sb.append(cBuf, 0, i);
            }
            StringTokenizer st_data = new StringTokenizer(sb.toString(), ",");

            int total_token = st_data.countTokens();

            for (int j = 0; j < total_token; j++)
            {
                ret_data[j] = Double.parseDouble(st_data.nextToken());
            }
            return ret_data;
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                }
            }
        }
    }

    private double dssCalculation
    (
        SRM_DSS_Code dss,
        double[]     coord_org_wgs84_cd
    ) throws SrmException
    {
        int  Index,ScaleFactor,NumbGeoidCols,NumbGeoidRows;
        double DeltaX, DeltaY,
          ElevationSE, ElevationSW, ElevationNE, ElevationNW,
          OffsetX, OffsetY, PostX, PostY, UpperY, LowerY;

        // dss is always zero the WGS 1984 which is the reference ORM
        if (dss == SRM_DSS_Code.DSSCOD_WGS84_ELLIPSOID)
            return 0;

        ScaleFactor = 4;
        NumbGeoidCols = 1441;
        NumbGeoidRows = 721;

        try
        {
            // read the geoid data from file is not already
            if (_wgs84GeoidSeparationData == null)
                _wgs84GeoidSeparationData = getFileContent(NumbGeoidRows,
                                                           NumbGeoidCols,
                                                           "WGS84GeoidSeparationTable.dat");
        }
        catch (FileNotFoundException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
              "calculateVerticalSeparationOffset: Geoid Separation data file not found");
        }
        catch (IOException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
              "calculateVerticalSeparationOffset: Internal file I/O error");
        }
        catch (NullPointerException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
              "calculateVerticalSeparationOffset: Geoid Separation data file not found");
        }


       /*
        *  Compute X and Y Offsets into Geoid Height Array.
        */
        if (coord_org_wgs84_cd[0] < 0.0)
        {
            OffsetX = (Math.toRadians(coord_org_wgs84_cd[0]) + 360.0)
                      * ScaleFactor;
        }
        else
        {
            OffsetX = Math.toRadians(coord_org_wgs84_cd[0]) * ScaleFactor;
        }
        OffsetY = (90.0 - Math.toRadians(coord_org_wgs84_cd[1]))
                  * ScaleFactor;

        /*
         * Find Four Nearest Geoid Height Cells for specified Latitude, Longitude;
         * Assumes that (0,0) of Geoid Height Array is at Northwest corner.
         */
        PostX = Math.floor(OffsetX);
        if ((PostX + 1) == NumbGeoidCols)
            PostX--;
        PostY = Math.floor(OffsetY);
        if ((PostY + 1) == NumbGeoidRows)
            PostY--;

        Index = (int)(PostY * NumbGeoidCols + PostX);
        if (Index > _wgs84GeoidSeparationData.length || Index < 0)
            throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                   "calculateVerticalSeparationOffset: computation not possible");

        ElevationNW = _wgs84GeoidSeparationData[ Index ];
        ElevationNE = _wgs84GeoidSeparationData[ Index+ 1 ];

        Index = (int)((PostY + 1) * NumbGeoidCols + PostX);
        if (Index > _wgs84GeoidSeparationData.length || (Index < 0))
            throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                   "calculateVerticalSeparationOffset: computation not possible");

        ElevationSW = _wgs84GeoidSeparationData[ Index ];
        ElevationSE = _wgs84GeoidSeparationData[ Index + 1 ];

        // Perform Bi-Linear Interpolation to compute Height above Ellipsoid

        DeltaX = OffsetX - PostX;
        DeltaY = OffsetY - PostY;

        UpperY = ElevationNW + DeltaX * (ElevationNE - ElevationNW);
        LowerY = ElevationSW + DeltaX * (ElevationSE - ElevationSW);

        return (UpperY + DeltaY * (LowerY - UpperY));
    }
}
