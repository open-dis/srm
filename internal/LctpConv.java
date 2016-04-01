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
*/

package SRM;

class LctpConv extends Conversions
{
    protected LctpConv()
    {
        super (SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL,
               new SRM_SRFT_Code[] {SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN,
                                    SRM_SRFT_Code.SRFTCOD_UNSPECIFIED });
    }

    protected Conversions makeClone()
    {
        return (Conversions) new LctpConv();
    }


    // Function dispatcher keyed on the destination SRF
    protected SRM_Coordinate_Valid_Region_Code convert
    (
        SRM_SRFT_Code destSrfType,
        BaseSRF               srcSrf,
        BaseSRF               destSrf,
        double[]              src,
        double[]              dest,
        SRM_ORM_Trans_Params  hst
    ) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid =
           SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;

        if ( destSrfType == SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN )
        {
            // perform pre validation
            retValid = CoordCheck.forCylindrical( src );
            toLte(srcSrf, destSrf, src, dest);
        }
        else if ( destSrfType == SRM_SRFT_Code.SRFTCOD_UNSPECIFIED )
        {
            // just pass the coordinate through.  This is a datum shift case
            // or this is the last conversion in the chain
            dest[0] = src[0];
            dest[1] = src[1];
            dest[2] = src[2];
        }
        return retValid;
    }


/*
 *----------------------------------------------------------------------------
 *
 * Cylindrical to celestiocentric routines and classes
 *
 *----------------------------------------------------------------------------
 */
    protected void toLte (BaseSRF  srcSrf,
                          BaseSRF  destSrf,
                          double[] source_generic_coord,
                          double[] dest_generic_coord) throws SrmException
    {
        // the source coordinate is interpreted as
        // source_generic_coord[0] => theta
        // source_generic_coord[1] => rho
        // source_generic_coord[2] => zeta

        // output x
        dest_generic_coord[0] = source_generic_coord[1] * Math.cos(source_generic_coord[0]);

        // output y
        dest_generic_coord[1] = source_generic_coord[1] * Math.sin(source_generic_coord[0]);

        // output z
        dest_generic_coord[2] = source_generic_coord[2];
    }
}
