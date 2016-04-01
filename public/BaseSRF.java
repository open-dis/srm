// SRM SDK Release 4.4.0 - January 21, 2010

// - SRM spec. 4.4
//
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
@brief Declaration of Base SRF class.
*/

/** @mainpage Spatial Reference Model (SRM) Java API
@section Introduction
This is the documentation for the SRM Java API.

All classes in this API are in the <i>SRM</i> package.

The SRM classes provide the following functionality:
- Creation
  - SRFs
    - SRF templates (e.g., LSR 3D, TM_AUGMENTED_3D, Celestiodetic, Celestiocentric)
    - SRF set members (e.g., UTM zone 12, GTRS cell 1234, UPS northern pole)
    - SRFs (e.g., British National Grid Airy)
  - Coordinates
    - 2D coordinate
    - 3D coordinate
    - Surface coordinate
  - Directions
  - Orientations
- Conversion
  - Coordinate conversion between SRFs
  - Direction conversion between SRFs
  - Orientation conversion between SRFs
- Validation
  - Coordinate validation within a SRF
  - Direction validation within a SRF
  - Orientation validation within a SRF
- Calculations
  - Euclidean distance
  - Geodesic distance
  - Point scale
  - Vertical separation offset
  - Convergence of the Meridian
  - Map azimuth
- Abstract space coordinate instancing in a SRF

A sample program to convert a Celestiodetic 3D coordinate to
a Celestiocentric 3D coordinate is as follows:
@code
import SRM.*;

public class CdToCcConv
{
    public static void main (String args[])
    {
        System.out.println("*** Sample program using SRM Java API to convert a 3D coordinate");
        System.out.println("*** from a Celestiodetic SRF to a Celestiocentric SRF.");

        // Declare reference variables for the CD_3D and CC_3D SRFs
        SRF_Celestiodetic CdSrf = null;
        SRF_Celestiocentric CcSrf = null;

        try
        {
            // Create a Celestiodetic SRF with WGS 1984 and Identity transformation
            CdSrf = new SRF_Celestiodetic(SRM_ORM_Code.ORMCOD_WGS_1984,
                                          SRM_RT_Code.RTCOD_WGS_1984_IDENTITY);

            // Create a Celestiocentric SRF with WGS 1984 and Identity transformation
            CcSrf = new SRF_Celestiocentric(SRM_ORM_Code.ORMCOD_WGS_1984,
                                            SRM_RT_Code.RTCOD_WGS_1984_IDENTITY);

            // Create a 3D Celestiodetic coordinate with
            // longitude           => 10.0 degrees (note: this input parameter is converted to radians)
            // latitude            => 20.0 degrees (note: this input parameter is converted to radians)
            // ellipsoidal height => 100.0 meters
            Coord3D_Celestiodetic CdCoord =
                (Coord3D_Celestiodetic)CdSrf.createCoordinate3D(Math.toRadians(10.0),
                                                                Math.toRadians(20.0),
                                                                100.0);

            // Instantiate a 3D Celestiocentric coordinate
            // This is an alternative method for instantiate a 3D coordinate
            Coord3D_Celestiocentric CcCoord = new Coord3D_Celestiocentric(CcSrf);

            // print out the SRF parameter values and the coordinate component values
            System.out.println("CdSrf parameter =>  \n" + CdSrf);
            System.out.println("CcSrf parameter =>  \n" + CcSrf);
            System.out.println("CdCoord components (source) => \n" + CdCoord);

            // convert the 3D Celestiodetic coordinate to 3D Celestiocentric coordinate
            SRM_Coordinate_Valid_Region_Code valRegion =
                CcSrf.changeCoordinateSRF(CdCoord, CcCoord);

            // print out the values of the resulting 3D Celestiocentric coordinate
            System.out.println("CcCoord components (destination) => \n" + CcCoord + " is " + valRegion);
        }
        catch (SrmException ex)
        {
            // catch SrmException and print out the error code and text.
            System.out.println("Exception caught=> " + ex.what() + ", " + ex);
        }
    }
}
@endcode

Running the sample program above will produce output as follows:
@verbatim
*** Sample program using SRM Java API to convert a 3D coordinate
*** from a Celestiodetic SRF to a Celestiocentric SRF.
CdSrf parameter =>
orm: ORMCOD_WGS_1984
rt: RTCOD_WGS_1984_IDENTITY
CcSrf parameter =>
orm: ORMCOD_WGS_1984
rt: RTCOD_WGS_1984_IDENTITY
CdCoord components (source) =>
[ 0.17453292519943295, 0.3490658503988659, 100.0 ]
CcCoord components (destination) =>
[ 5904838.698311626, 1041182.3792437915, 2167730.9898430835 ] is VALID
@endverbatim
*/

package SRM;

import java.util.*;

/** The BaseSRF abstract class is the base class for all SRFs.
 @author David Shen
 @see BaseSRF_2D, BaseSRF_3D
 */
public abstract class BaseSRF implements Cloneable
{
    private SRM_SRF_Code _mySrfCode = SRM_SRF_Code.SRFCOD_UNSPECIFIED;

    private SRM_SRFS_Code _mySrfsCode = SRM_SRFS_Code.SRFSCOD_UNSPECIFIED;

    private SRM_SRFSM_Code _mySrfsMemberCode = null;

    // ORM code for the SRF
    protected SRM_ORM_Code _orm;

    // RT Code for the SRF
    protected SRM_RT_Code _rt;

    protected SRM_SRFT_Code _mySrftCode = SRM_SRFT_Code.SRFTCOD_UNSPECIFIED;

    protected SRM_CS_Code _myCsCode = SRM_CS_Code.CSCOD_UNSPECIFIED;

    // The following Hash Map does not need to be Synchronized because the assumption
    // (constraint) is that an SRF cannot be shared by several threads.

    // this is for the caching of the interim conversion path and initialization data
    // This is a controlled version of the HashMap that currently limites the number
    // of cached OpSeq to 200 per SRF.
    protected CacheManager _myOpSeq;

    // this is for caching of the interim SRFs for conversion prior to the distance
    // computation
    protected HashMap<String, BaseSRF> _internalSRFs;

    /** Creates a Standard SRF from its SRF code.
        @param srf_code in: the code for a standard SRF to create
        @param rt_code in: the RT code to use in the created SRF
        @return a SRF template instance associated with the "Standard" SRF.
        @exception This method throws SrmException
        @note Use the concrete SRF classes to create "standard" SRFs,
              which use pre-defined SRF template constructor parameters.
        @note All SRFs are intrinsically created from a template, hence the
             appropriate template instance will always be returned.
        @see createStandardSRF(), SRM_SRF_Code

        A sample code to create a British National Grid Airy SRF is as follows:
        @code

        import SRM.*;
        ...

        // call createStandardSRF with:
        //   SRF code     => SRFCOD_BRITISH_NATIONAL_GRID_AIRY
        try
        {
            BaseSRF bngSrf = BaseSRF.createStandardSRF(SRM_SRF_Code.SRFCOD_BRITISH_NATIONAL_GRID_AIRY,
                                                       SRM_RT_Code.RTCOD_OSGB_1936_3_MEAN_SOLUTION);
        }
        catch (SrmException ex)
        ...

        // Note1: In this example, the returned object is of class SRF_TransverseMercator with its pre-defined parameters.
        // Note2: The RT parameter must be compatible with ORMCOD_OSGB_1936. (See Users' Guide for the
                  pre-assigned ORMs associated with each standard SRF.

        @endcode
    */
    public static BaseSRF createStandardSRF(SRM_SRF_Code srf_code,
                                            SRM_RT_Code  rt_code) throws SrmException
    {
        if (srf_code == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("createStandardSRF: null reference srf code"));

        if (srf_code == SRM_SRF_Code.SRFCOD_UNSPECIFIED)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("createStandardSRF: UNSPECIFIED SRF is not valid for this operation"));

        if (rt_code == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("createStandardSRF: null reference rt code"));

        return CreateSRF.standardSRF(srf_code, rt_code);
    }


    /** Creates an SRF from a SRF set code, a set member code specific to
        that set, and an ORM code.
        @param srf_set in: the code for an SRF set
        @param set_member in: the code for an SRF set member.
        @param orm in: the ORM code associated with the created SRF
        @param rt in: the RT transformation associated with the created SRF
        @return a SRF template instance associated with the SRF Set member.
        @note All SRFs are intrinsically created from a template, hence the
             appropriate template instance will always be returned.
        @note There is a specific sub-class of SRM_SRFSM_Code class associated with each SRF set for specifying its member code as follows:.
        @note The SRFS member code "UNSPECIFIED" is not allowed when specifying a SRF set member.
         <ol>
         <li>Alabama SPCS                     =&gt; SRM_SRFSM_Alabama_SPCS_Code</li>
         <li>Global Coordinate System (GTRS)  =&gt; SRM_SRFSM_GTRS_GCS_Code</li>
         <li>Lambert NTF                      =&gt; SRM_SRFSM_Lambert_NTF_Code</li>
         <li>Japan Plane System               =&gt; SRM_SRFSM_Japan_Rectangular_Plane_CS_Code</li>
         <li>Universal Polar Stereographic    =&gt; SRM_SRFSM_UPS_Code</li>
         <li>Universal Transverse Mercator    =&gt; SRM_SRFSM_UTM_Code</li>
         <li>Wisconsin SPCS                   =&gt; SRM_SRFSM_Wisconsin_SPCS_Code</li>
         </ol>
        @see createSRFSetMember(), SRM_SRFS_Code, SRM_SSM_Code

        A sample code to create a UTM SRF corresponding to Zone 12 Southern hemisphere based
        on WGS 1984 with Identity transformation is as follows:
        @code

        import SRM.*;
        ...

        // call createSRFSetMember with:
        //   SRF Set code     => UTM
        //   Set Member code  => Zone 12 southern hemisphere
        //   ORM              => WGS 1984
        //   RT               => WGS 1984 IDENTITY transformation
        try
        {
            BaseSRF utmSrf = BaseSRF.createSRFSetMember(SRM_SRFS_Code.SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR,
                                                        SRFSM_UTM_Code.SRFMSUTM_ZONE_12_SOUTHERN_HEMISPHERE,
                                                        SRM_ORM_Code.ORMCOD_WGS_1984,
                                                        SRM_RT_Code.RTCOD_WGS_1984_IDENTITY);
        }
        catch (SrmException ex)
        ...

        // Note1: In this example, the returned object is of class SRF_TransverseMercator with its parameters pre-defined.
        // Note2: The SRFS member code (SRFSM_UTM_Code) must be compatible with the SRFS code (SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR).

        @endcode
    */
    public static BaseSRF createSRFSetMember(SRM_SRFS_Code  srf_set,
                                             SRM_SRFSM_Code set_member,
                                             SRM_ORM_Code   orm,
                                             SRM_RT_Code    rt) throws SrmException
    {
        if (srf_set == null || set_member == null || orm == null || rt == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("createSRFSetMember: null reference input parameter"));

        if (srf_set == SRM_SRFS_Code.SRFSCOD_UNSPECIFIED)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("createSRFSetMember: UNSPECIFIED SRF is not valid for this operation"));

        return CreateSRF.srfSetMember(srf_set, set_member, orm, rt);
    }


    /** Returns this pre-defined ("standard") SRF code.
        @return the pre-defined SRF code of this SRF
        @note This method will return "SRFCOD_UNSPECIFIED" if the SRF was not originally
         created with the createStandardSRF method.
        @see createStandardSRF()
    */
    public SRM_SRF_Code getSRFCode()
    {
        return _mySrfCode;
    }


    /** Returns this SRF's Template code.
        @return the SRF Template code of this SRF
        @see createStandardSRF()
    */
    public SRM_SRFT_Code getSRFTemplateCode()
    {
        return _mySrftCode;
    }


    /** Returns this SRF's Set code.
        @return the SRF Set code of this SRF
        @note This method will return "SRFSCOD_UNSPECIFIED" if the SRF Set was not originally
         created with the createSRFSetMember method.
        @see createSRFSetMember()
    */
    public SRM_SRFS_Code getSRFSetCode()
    {
        return _mySrfsCode;
    }


    /** Returns this SRF's Set member code.
        @return the SRF Set member code of this SRF
        @note This method will return 0 (which means "UNSPECIFIED") if the SRF Set was not
             originally created with the createSRFSetMember method.
        @see createSRFSetMember()
    */
    public SRM_SRFSM_Code getSRFSetMemberCode()
    {
        return _mySrfsMemberCode;
    }


    /** Returns this SRF's CS Code.
        @return the SRF CS code of this SRF
    */
    public SRM_CS_Code getCSCode()
    {
        return _myCsCode;
    }


    /** Returns this SRF's Object Reference Model code.
        @return an ORM code of this SRF
        @deprecated As of SRM 4.1.2, replaced by getOrm()
        @see getOrm()
    */
    public SRM_ORM_Code get_orm()
    {
        return _orm;
    }


    /** Returns this SRF's Object Reference Model code.
        @return an ORM code of this SRF
    */
    public SRM_ORM_Code getOrm()
    {
        return _orm;
    }


    /** Returns this SRF's RT code.
        @return an RT code of this SRF
        @deprecated As of SRM 4.1.2, replaced by getRt()
        @see getRt()
    */
    public SRM_RT_Code get_rt()
    {
        return _rt;
    }


    /** Returns this SRF's RT code.
        @return an RT code of this SRF
    */
    public SRM_RT_Code getRt()
    {
        return _rt;
    }

    /** Returns this SRF's major semi-axis value (A).
        @return a major semi-axis value
     */
    public double getA()
    {
        return (new OrmData(this.getOrm())).A;
    }

    /** Returns this SRF's flattening value (F).
        @return a flattening value
     */
    public double getF()
    {
        return (new OrmData(this.getOrm())).F;
    }

    /** Queries for the SRFT support by the implementation.
        @return true if the SRFT is supported by this implementation.
    */
    public static boolean querySRFTSupport(SRM_SRFT_Code srft_code)
    {
        if (srft_code == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED)
            return false;
        else
            return true; // hardcoded to true because we support all the SRFTs.
    }


    /** Queries for the ORM/RT pair support by the implementation.
        @param orm_code in: the object reference model code.
        @param rt_code in: the reference transformation code.
        @return true if the ORM/RT pair is supported by this implementation.
        @note Not all the supported SRFTs is compatible with all the supported ORM/RT pairs.
    */
    static boolean queryORMSupport(SRM_ORM_Code orm_code,
                                   SRM_RT_Code  rt_code)
    {
        return RtDataSet.isValidPair(orm_code, rt_code);
    }


    /** Changes a coordinate's values to this SRF.
        @param src in: the source coordinate in some other SRF
        @param tgt in out: the target coordinate in this SRF
        @return the Valid Region of the target coordinate
        @note The source and target coordinates must be of same the dimension (2D or 3D).
    */
    public SRM_Coordinate_Valid_Region_Code changeCoordinateSRF(Coord src, Coord tgt)  throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid;
        double[] tgtValues = new double[3];

        if (src == null || tgt == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinateSRF: null reference input parameter"));

        if ((src instanceof Coord3D) && (tgt instanceof Coord3D))
        {
            retValid = OpManager.instance().computeAsArray
                       (src.getSRF(), this, src.getValues(), tgtValues, null);
            ((Coord3D)tgt).setValues(tgtValues);

            return retValid;
        }
        else if ((src instanceof Coord2D) && (tgt instanceof Coord2D))
        {
            double[] srcValues = { src.getValues()[0], src.getValues()[1], 0.0 };

            retValid = OpManager.instance().computeAsArray
                       (src.getSRF(), this, srcValues, tgtValues, null);
            // this operation only uses the first two components of the tgtValues
            ((Coord2D)tgt).setValues(tgtValues);

            return retValid;
        }
        else
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinateSRF: Input coordinate of different dimensions"));
   }


    /** Check a coordinate in this SRF for valid region.
        @param src in: the source coordinate in some other SRF
        @return the coordinate valid region code in the coordinate's SRF
        @note The input coordinate must have been created using this SRF.
    */
    public SRM_Coordinate_Valid_Region_Code checkCoordinate(Coord src) throws SrmException
    {
        SRM_SRFT_Code myBoundaryTemplateSrf;
        SRM_SRFS_Code mySrfSet;

        if (src == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("checkCoordinate: null reference input parameter"));

        if (src.getSRF() != this)
            throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                   new String("checkCoordinate: Coordinate associated with different SRF"));

        // get the template SRF where the boundary validation will take place
        myBoundaryTemplateSrf = CoordCheck.getsrfBoundaryDefTemplate(this);

        SRM_Coordinate_Valid_Region_Code retValidity =
           SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;

        mySrfSet = this.getSRFSetCode();

        if (myBoundaryTemplateSrf != this.getSRFTemplateCode())
        {
            /*!\note
              This case is where the validity boundaries for
              an SRF are in a different SRF from the SRF itself
            */
            BaseSRF tmpSrf;
            double[] coord_tgt = new double[3];

            // instantiate cache for the interim SRFs
            if (this._internalSRFs == null)
                this._internalSRFs = new HashMap<String, BaseSRF>();

            tmpSrf = (BaseSRF)this._internalSRFs.get("IntCheckBoundSrfT");

            // create an interim SRF using the common
            if (tmpSrf == null)
            {
                tmpSrf = CreateSRF.fromCode(myBoundaryTemplateSrf,
                                            this.getOrm(),
                                            this.getRt());

                // cache the created interim SRF
                this._internalSRFs.put("IntCheckBoundSrfT", tmpSrf);
            }

            // convert src coord to the interim Celestiodetic (in this case) coord.
            retValidity = OpManager.instance().computeAsArray(this,
                                                              tmpSrf,
                                                              src.getValues(),
                                                              coord_tgt,
                                                              null);

            // Use specialized SRF coord checks if it is an SRF Set member
            if (this.getSRFSetCode() != SRM_SRFS_Code.SRFSCOD_UNSPECIFIED)
            {
                switch (mySrfSet)
                {
                    case SRFSCOD_ALABAMA_SPCS:
                         retValidity = CoordCheck.forALSP_cd
                                       (new OrmData(this.getOrm()),
                                       ((SRF_TransverseMercator)this).getSRFParameters(),
                                       coord_tgt);
                         break;
                    case SRFSCOD_GTRS_GLOBAL_COORDINATE_SYSTEM:
                         retValidity = CoordCheck.forGTRS_cd
                                       (this.getSRFSetMemberCode(), coord_tgt);
                         break;
                    case SRFSCOD_JAPAN_RECTANGULAR_PLANE_CS:
                         retValidity = CoordCheck.forJapan_cd
                                       (
                                           new OrmData(this.getOrm()),
                                           (SRM_SRFSM_Japan_Rectangular_Plane_CS_Code)this.getSRFSetMemberCode(),
                                           ((SRF_TransverseMercator)this).getSRFParameters(),
                                           coord_tgt
                                       );
                         break;
                    case SRFSCOD_LAMBERT_NTF:
                         retValidity = CoordCheck.forLNTF_cd
                                       (
                                           new OrmData(this.getOrm()),
                                           (SRM_SRFSM_Lambert_NTF_Code)this.getSRFSetMemberCode(),
                                           coord_tgt
                                       );
                         break;
                    case SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC:
                         retValidity = CoordCheck.forUPS_cd
                                       (((SRF_PolarStereographic)this).getSRFParameters(),
                                        coord_tgt);
                         break;
                    case SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR:
                         retValidity = CoordCheck.forUTM_cd
                                       (new OrmData(this.getOrm()),
                                        ((SRF_TransverseMercator)this).getSRFParameters(),
                                       (SRM_SRFSM_UTM_Code)this.getSRFSetMemberCode(),
                                       coord_tgt);
                         break;
                    case SRFSCOD_WISCONSIN_SPCS:
                         retValidity = CoordCheck.forWISP_cd
                                       (new OrmData(this.getOrm()), coord_tgt);
                         break;
                    default:
                         throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                                new String("checkCoordinate: Unsupported SRM_SRFS_Code"));
                }
            }
            // This case takes care of the template and the predefined SRFs
            // Note:  As for now, all the boundary SRFs are Celestiodetic, thus the only case.
            // Since we are getting the validation result from the conversion to CD_3D, we
            // just need to pass that result to the caller and no more checking is needed.
            //     else
            //     {
            //         if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_CELESTIODETIC)
            //             retValidity = CoordCheck.forCelestiodetic(new OrmData(tmpSrf.getOrm()), coord_tgt);
            //         else
            //             throw new SrmException(SrmException._INVALID_SOURCE_SRF,
            //                                     new String("Unsupported validity"));
            //     }
        }
        else
        {
            /*!\note this is the easy case where the boundaries are in the same srf*/
            // Notice that only the non projection based SRFs fall into this category
            if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_CELESTIODETIC)
            {
                OrmData ormData = new OrmData(this.getOrm());

                retValidity = CoordCheck.forCelestiodetic(ormData, src.getValues());
                ormData = null;
            }
            else if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_3D ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCOCENTRIC_EUCLIDEAN_3D ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_SOLAR_MAGNETIC_ECLIPTIC ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_SOLAR_MAGNETIC_DIPOLE)
            {
                retValidity = CoordCheck.forNaN_3D(src.getValues());
            }
            else if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL)
            {
                retValidity = CoordCheck.forCylindrical(src.getValues());
            }
            else if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL)
            {
                retValidity = CoordCheck.forAzSpherical(src.getValues());
            }
            else if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_CELESTIOMAGNETIC ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_EQUATORIAL_INERTIAL ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_SOLAR_ECLIPTIC ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_SOLAR_EQUATORIAL ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_HELIOSPHERIC_ARIES_ECLIPTIC ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_ECLIPTIC ||
                     myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_HELIOSPHER_EARTH_EQUATORIAL)
            {
                retValidity = CoordCheck.forSpherical(src.getValues());
            }
            else if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_RECT_2D)
            {
                retValidity = CoordCheck.forNaN_2D(src.getValues());
            }
            else if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_AZIMUTHAL_2D)
            {
                retValidity = CoordCheck.forLocalSpaceAzimuthal2D(src.getValues());
            }
            else if (myBoundaryTemplateSrf == SRM_SRFT_Code.SRFTCOD_LOCAL_SPACE_POLAR_2D)
            {
                retValidity = CoordCheck.forLocalSpacePolar(src.getValues());
            }
            // shouldn't fall through past here
        }
        return retValidity;
    }


    /** Returns the Euclidean distance between two coordinates.
        @param coord1 in: a coordinate in some SRF
        @param coord2 in: a coordinate in some SRF
        @return the Euclidean distance between the two coordinates (in meters).
        @note The input coordinates do not need to be from the same SRF, but must have the
              same dimensionality, i.e., both 2D, 3D, or Surface.
        @note This method will make (and cache) internal conversions when the inputs coordinates
              are from SRFs other than SRF_Celestiocentric.
     */
    public static double calculateEuclideanDistance(Coord coord1,
                                                    Coord coord2) throws SrmException
    {
        double[] tempCcSrcCoord;
        double[] tempCcTgtCoord;

        double delta_x,delta_y,delta_z;

        /*Check for null reference*/
        if (coord1 == null || coord2 == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("calculateEuclideanDistance: null reference input parameter"));

        // !!! raise unimplemented exception if these are 2D coordinates Need Fix for future version
        if ((coord1.getSRF() instanceof BaseSRF_2D) ||
            (coord2.getSRF() instanceof BaseSRF_2D))
            throw new SrmException(SrmException._NOT_IMPLEMENTED,
                                    new String("calculateEuclideanDistance: Not implemented for 2D coordinates" +
                                               " in this release"));

        /*Test to see if the source and target SRF's are both for the same body*/
        if (OrmDataSet.getElem(coord1.getSRF().getOrm())._reference_orm !=
            OrmDataSet.getElem(coord2.getSRF().getOrm())._reference_orm)
            throw new SrmException(SrmException._INVALID_INPUT,
                                    new String("calculateEuclideanDistance: coordinates" +
                                               " associated with different reference ORMs"));

        // convert src coordinate to interim CC_3D SRF
        tempCcSrcCoord = interimConv(coord1, SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);

        // converting target coordinate to celestiocentric SRF
        tempCcTgtCoord = interimConv(coord2, SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);

        delta_x = tempCcSrcCoord[0] - tempCcTgtCoord[0];
        delta_y = tempCcSrcCoord[1] - tempCcTgtCoord[1];
        delta_z = tempCcSrcCoord[2] - tempCcTgtCoord[2];

        return Math.sqrt(Const.square(delta_x) +
                          Const.square(delta_y) +
                          Const.square(delta_z));
    }


    /** Returns the string for this version of SRM Java implementation.
        @return This SRM Java implementation version.
     */
    public static String getImplVerInfo()
    {
        return new String("4.4.0");
    }


    /** Returns a string representation of this SRF.
    */
    public String toString()
    {
        String retString = new String();

        retString = retString + "orm: " + _orm + "\n";
        retString = retString + "rt: " + _rt;

        return retString;
    }

    /** @return TRUE if the SRF parameters are equal.
        @note  This method returns FALSE if the input srf is null
    */
    public abstract boolean isEqual (BaseSRF srf);


    /** Returns the shallow copy of this object instance.
        @note The cloned object will reference the same object as the
        original object.
    */
    public BaseSRF makeClone() throws SrmException
    {
        try
        {
            return (BaseSRF)super.clone();
        }
        catch (java.lang.CloneNotSupportedException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
                                    new String("BaseSRF.makeClone(): failed"));
        }
    }

    protected void setSrfCode (SRM_SRF_Code srfCode)
    {
        _mySrfCode = srfCode;
    }

    protected void setSrfSetCode (SRM_SRFS_Code srfSetCode)
    {
        _mySrfsCode = srfSetCode;
    }

    protected void setSrfSetMemberCode (SRM_SRFSM_Code srfSetMemberCode)
    {
        _mySrfsMemberCode = srfSetMemberCode;
    }

    // converts a Coord to a vector of coordinate component values in the target SRF
    protected static double[] interimConv (Coord src_coord, SRM_SRFT_Code tgt_srft) throws SrmException
    {
        BaseSRF tmpTgtSrf;
        BaseSRF src_srf = src_coord.getSRF();
        double[] tmpTgtCoord = new double[4];
        double[] tmpSrcCoord = new double[4];

        // instantiate cache for the interim SRFs
        if (src_srf._internalSRFs == null)
            src_srf._internalSRFs = new HashMap<String, BaseSRF>();

        if (tgt_srft == SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC)
        {
            tmpTgtSrf = (BaseSRF)src_srf._internalSRFs.get("Interim_Cc");

            // create an interim Celestiocentric SRF
            if (tmpTgtSrf== null)
                tmpTgtSrf = new SRF_Celestiocentric(src_srf.getOrm(), src_srf.getRt());

            // cache the interim Celestiocentric in the (source) SRF for
            // coordinate 1.  We use the same one for coordinate 2.
            src_srf._internalSRFs.put("Interim_Cc", tmpTgtSrf);
        }
        else if (tgt_srft == SRM_SRFT_Code.SRFTCOD_CELESTIODETIC)
        {
            tmpTgtSrf = (BaseSRF)src_srf._internalSRFs.get("Interim_Cd");

            // create an interim Celestiocentric SRF
            if (tmpTgtSrf== null)
                tmpTgtSrf = new SRF_Celestiodetic(src_srf.getOrm(), src_srf.getRt());

            // cache the interim Celestiocentric in the (source) SRF for
            // coordinate 1.  We use the same one for coordinate 2.
            src_srf._internalSRFs.put("Interim_Cd", tmpTgtSrf);
        }
        else
            throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                   "Operation not supported due to SRF incompatibility");

        tmpSrcCoord[0] = src_coord.getValues()[0];
        tmpSrcCoord[1] = src_coord.getValues()[1];

        if (src_coord instanceof Coord3D)
            tmpSrcCoord[2] = src_coord.getValues()[2];
        else
            tmpSrcCoord[2] = 0.0;

        // converting source coordinate to celestiocentric SRF
        OpManager.instance().computeAsArray(src_srf,
                                            tmpTgtSrf,
                                            tmpSrcCoord,
                                            tmpTgtCoord,
                                            null);

        return tmpTgtCoord;
    }
}
