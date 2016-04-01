/**
@author David Shen
@brief Declaration of 3D coordinate base class.
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

import java.util.HashMap;

/** The Coord3D abstract class is used for representing 3D coordinates.
@see Coord
*/
public abstract class Coord3D extends Coord
{
    /** An array to store the coordinate component values
     */
    protected double[] _values = new double[3];

    /** Constructor setting the associated SRF and the concrete class type
     */
    protected Coord3D(BaseSRF assocSRF, Coord_ClassType type)
    {
        super(assocSRF, type);
    }

    /** Returns the coordinate component values as an array
        @return an array of size 3 containing the 3D coordinate component values
    */
    public double[] getValues()
    {
        double[] retVal = new double[3];

        retVal[0] = _values[0];
        retVal[1] = _values[1];
        retVal[2] = _values[2];

        return retVal;
    }

    /** Sets the coordinate component values as an array
        @param values in: array of size 3 containing the 3D coordinate component values
    */
    public void setValues(double[] values) throws SrmException
    {
        try
        {
            _values[0] = values[0];
            _values[1] = values[1];
            _values[2] = values[2];
        }
        catch (RuntimeException primary_axis)
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("Coord3D.setValues: " +
                                   "Input array size different than 3"));
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
                 Const.isEqual(this._values[1], tmp[1], Const.EPSILON) &&
                 Const.isEqual(this._values[2], tmp[2], Const.EPSILON));
    }

    /** Copies the component values from this coordinate to the parameter coordinate.
        @note The parameter coordinate and this coordinate must be associated
              with the same SRF.
    */
    public void copyTo(Coord3D coord) throws SrmException
    {
        if (coord == null)
          throw new SrmException(SrmException._INVALID_INPUT,
                                 new String("Coord3D.copyTo: " +
                                 "Input coordinate reference is null"));

        if (this.getSRF() != coord.getSRF())
          throw new SrmException(SrmException._INVALID_SOURCE_COORDINATE,
                                 new String("Coord3D.copyTo: " +
                                 "Input coordinate not of the same SRF"));

        coord._values[0] = this._values[0];
        coord._values[1] = this._values[1];
        coord._values[2] = this._values[2];
    }

   public String getMGRS(int precision) throws SrmException
   {
       try
       {
           return impl_get_mgrs(precision);
       }
       catch (SrmException se)
       {
           throw new SrmException (SrmException._INVALID_INPUT,
                 "Coord3D.getMGRS(): Invalid input for conversion to MGRS");
       }
   }

   public void setCoord(String strMGRS) throws SrmException
   {
       try
       {
           impl_set_coord (strMGRS);
       }
       catch (SrmException se)
       {
           throw new SrmException (SrmException._INVALID_INPUT,
                 "Coord3D.setCoord(): " +
                 "Invalid input for MGRS conversion to coordinate");
       }
   }

   protected String impl_get_mgrs(int precision) throws SrmException
   {
       SRM_RD_Code rdCode = OrmDataSet.getElem(this.getSRF().getOrm())._rd_code;

       String ellipsoid_id = new String ("WE");
       if (rdCode == SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA ||
           rdCode == SRM_RD_Code.RDCOD_BESSEL_1841_NAMIBIA ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1858 ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1858_MODIFIED ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1866 ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880 ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_CAPE ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_FIJI ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_IGN ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_PALESTINE ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_SYRIA)
           // "BR" (BESSEL_1841) is used to represent all the RD using the
           // "AL" pattern for the "if" clause in the GEOTRANS mgrs routine.
           //System.arraycopy(ellipsoid_id, 0, "BR", 0, 2);
           ellipsoid_id = MGRS.BESSEL_1841;

       MGRS MGRSHelper = new MGRS(ellipsoid_id, (BaseSRF_3D) this.getSRF());

       String strMGRS = "ERROR";

       if (this.getClassType() == Coord_ClassType.CD_3D)
       {
           // ssf, Needs a try block when exception handling is added
           strMGRS = MGRSHelper.Convert_Geodetic_To_MGRS
           (((Coord3D_Celestiodetic)this).get_latitude(),
            ((Coord3D_Celestiodetic)this).get_longitude(),
            precision);
       }
       // Need to convert to celestiodetic
       else
       {
           // instantiate cache for the interim CD SRFs
           double[] tempTgtCoord = BaseSRF.interimConv(this,
                                   SRM_SRFT_Code.SRFTCOD_CELESTIODETIC);

           // NOTE: lat/lon parameter order, i.e., [1], then [0]
           strMGRS = MGRSHelper.Convert_Geodetic_To_MGRS
                       (tempTgtCoord[1], tempTgtCoord[0], precision);
       }
       return strMGRS;
   }

   protected void impl_set_coord(String strMGRS) throws SrmException
   {
       SRM_RD_Code rdCode;

       rdCode = OrmDataSet.getElem(this.getSRF().getOrm())._rd_code;

       String ellipsoid_id = "WE";
       if (rdCode == SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA ||
           rdCode == SRM_RD_Code.RDCOD_BESSEL_1841_NAMIBIA ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1858 ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1858_MODIFIED ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1866 ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880 ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_CAPE ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_FIJI ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_IGN ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_PALESTINE ||
           rdCode == SRM_RD_Code.RDCOD_CLARKE_1880_SYRIA)
           // "BR" (BESSEL_1841) is used to represent all the RD using the
           // "AL" pattern for the "if" clause in the GEOTRANS mgrs routine.
           //System.arraycopy(ellipsoid_id, 0, "BR", 0, 2);
           ellipsoid_id = MGRS.BESSEL_1841;

       MGRS MGRSHelper = new MGRS(ellipsoid_id, (BaseSRF_3D) this.getSRF());

       // NOTE: indices 0 and 1 denote lon/lat (not lat/lon)!
       double[] tgtLatLon = MGRSHelper.Convert_MGRS_To_Geodetic (strMGRS);

       if (this.getClassType() == Coord_ClassType.CD_3D)
       {
           this.setValues(tgtLatLon);
       }
       // need to convert from celestiodetic
       else
       {
           // Setup cache for the interim SRFs
           if (this.getSRF()._internalSRFs == null)
               this.getSRF()._internalSRFs = new HashMap<String, BaseSRF>();

           SRF_Celestiodetic tempTgtCdSrf;
           tempTgtCdSrf = (SRF_Celestiodetic)this.getSRF().
                          _internalSRFs.get("Interim_Cd");

           // Create an interim Celestiodetic SRF if not already created
           if (tempTgtCdSrf == null)
           {
               tempTgtCdSrf = new SRF_Celestiodetic(this.getSRF().getOrm(),
                                                    this.getSRF().getRt());

               // cache the interim celestiodetic in the (source) SRF for
               // this coordinate.
               this.getSRF()._internalSRFs.put("Interim_Cd", tempTgtCdSrf);
           }
           // Convert source coordinate to celestiocentric SRF
           double[] tempTgtCoord = new double[3];
           OpManager.instance().computeAsArray(tempTgtCdSrf,
                                               this.getSRF(),
                                               tgtLatLon,
                                               tempTgtCoord, null);

           this.setValues(tempTgtCoord);
       }
   }
}
