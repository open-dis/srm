/**
@author David Shen
@brief Declaration of Base SRF 2D class.
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

/** The BaseSRF_2D abstract class is the base class for the 2D SRFs.
@author David Shen
@see BaseSRF, BaseSRF_3D
*/
public abstract class BaseSRF_2D extends BaseSRF
{
    /** Creates a 2D coordinate object.
        @return a 2D coordinate object
        @note The initial coordinate value is defaulted to [ Double.NaN, Double.NaN ].
    */
    public abstract Coord2D createCoordinate2D();


    /** Creates a 2D coordinate object.
        @param coord_comp1 in: the values of the first component of the 2D coordinate
        @param coord_comp2 in: the values of the second component of the 2D coordinate
        @return a 2D coordinate object
    */
    public abstract Coord2D createCoordinate2D(double coord_comp1,
                                               double coord_comp2);

    /** Retrieves the 2D coordinate component values.
        @note The input coordinate must have been created using this SRF.
        @param coord in: a 2D coordinate, which must have been created using this SRF
        @return an array of size 2 containing the component values for the 2D coordinate
    */
    public double[] getCoordinate2DValues(Coord2D coord) throws SrmException
    {
        if (coord == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("getCoordinate2DValues: null reference input parameter"));

        return coord.getValues();
    }


    /** Changes a coordinate's values to this SRF.
        @param src in: the source coordinate in some other 2D SRF
        @param tgt out: the target coordinate in this 2D SRF
    */
    public void changeCoordinate2DSRF(Coord2D src,
                                      Coord2D tgt)  throws SrmException
    {
         double[] tgtValues = new double[2];

        if (src == null || tgt == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinate2DSRF: null reference input parameters"));

        OpManager.instance().computeAsArray
            (src.getSRF(), this, src.getValues(), tgtValues, null);

        tgt.setValues(tgtValues);
    }

    /** Changes a array of 2D coordinates to this SRF.
        @note all the arrays must be of same length.
        @note all the coordinate in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus
              one to indicate that the operation successfully converted all the
              coordinates in the source array.  Otherwise, the return value is
              the index of the offending coordinate in the source array.
        @param src in: the array of source 3D coordinate in some other 3D SRF
        @param tgt out: the array of target coordinate in this 3D SRF
        @return the index of the offending coordinate in the source array
                when an error condition occurs.  Otherwise, it is the
                size of the source array plus one.
    */
    public int changeCoordinate2DArraySRF(Coord2D[] src,
                                          Coord2D[] tgt) throws SrmException
    {
        boolean has_no_failure = true;
        double[] tgtValues = new double[2];

        if (src.length != tgt.length)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinate2DArraySRF: inconsistent array size"));

        int retIndex = src.length+1;

        for (int i=0; i<src.length && has_no_failure; i++)
        {
            try
            {
                if (src[i] == null || tgt[i] == null)
                {
                    throw new SrmException(SrmException._INVALID_INPUT,
                                           new String("changeCoordinate2DArraySRF: null array element"));
                }
                OpManager.instance().computeAsArray
                    (src[i].getSRF(), this, src[i].getValues(), tgtValues, null);

                tgt[i].setValues(tgtValues);
            }
            catch (SrmException ex)
            {
                retIndex = i;
                has_no_failure = false;
            }
        }
        return retIndex;
    }


    /** Changes a coordinate's values to this SRF using tranformation object.
        @note The target coordinate must have been created using this SRF.
        @note The value of omega for hst must be within the range (-2_PI, 2_PI).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src in: the source coordinate in some other 2D SRF
        @param hst in: the ORM 2D transformation
        @param tgt out: the target coordinate in this 2D SRF
    */
    public void changeCoordinate2DSRFObject(Coord2D src,
                                            SRM_ORM_Trans_2D_Params hst,
                                            Coord2D tgt)  throws SrmException
    {
         double[] tgtValues = new double[2];

        if (src == null || tgt == null || hst == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinate2DSRFObject: null reference input parameters"));

        OpManager.instance().computeAsArray
            (src.getSRF(), this, src.getValues(), tgtValues, hst);

        tgt.setValues(tgtValues);
    }



    /** Changes an array of 2D coordinates to this SRF using tranformation object.
        @note all the arrays must be of same length.
        @note all the coordinate in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus
              one to indicate that the operation successfully converted all
              the coordinates in the source array.  Otherwise, the return
              value is the index of the offending coordinate in the source
              array.
        @note The value of omega for hst must be within the range (-2_PI, 2_PI).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src in: the array of source 3D coordinate in some other 3D SRF
        @param hst in: the ORM 2D transformation
        @param tgt out: the array of target coordinate in this 3D SRF
        @return the index of the offending coordinate in the source array when
                an error condition occurs. Otherwise, it is the size of the
                source array plus one.
    */
    public int changeCoordinate2DArraySRFObject(Coord2D[] src,
                                                SRM_ORM_Trans_2D_Params hst,
                                                Coord2D[] tgt) throws SrmException
    {
        boolean has_no_failure = true;
        double[] tgtValues = new double[2];

        if (hst == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinate2DArraySRFObject: null reference input parameters"));

        if (src.length != tgt.length)
            throw new SrmException(SrmException._INVALID_INPUT,
                                   new String("changeCoordinate2DArraySRFObject: inconsistent array size"));

        int retIndex = src.length+1;

        for (int i=0; i<src.length && has_no_failure; i++)
        {
            try
            {
                if (src[i] == null || tgt[i] == null)
                {
                    throw new SrmException(SrmException._INVALID_INPUT,
                                           new String("changeCoordinate2DArraySRFObject: null array element"));
                }
                OpManager.instance().computeAsArray
                    (src[i].getSRF(), this, src[i].getValues(), tgtValues, hst);

                tgt[i].setValues(tgtValues);
            }
            catch (SrmException ex)
            {
                retIndex = i;
                has_no_failure = false;
            }
        }
        return retIndex;
    }


    /** Returns the Euclidean distance between two coordinates.
        @param coord1 in: a coordinate in some SRF
        @param coord2 in: a coordinate in some SRF
        @return the Euclidean distance between the two Coord2D coordinates (in metres).
        @note The input coordinates do not need to be from the same SRF.
        @note This method will make (and cache) internal conversions when the
              input coordinates are from SRFs other than SRF_Celestiocentric.
     */
    public static double calculateEuclideanDistance(Coord2D coord1,
                                                    Coord2D coord2) throws SrmException
    {
        throw new SrmException(SrmException._NOT_IMPLEMENTED,
                               new String("calculateEuclideanDistance: Not implemented" +
                                          " for 2D coordinates in this release"));
    }
}
