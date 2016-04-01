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
@brief class that computes the Natural SRF Set Member code.
*/

package SRM;

class NaturalSetMember
{

    protected static SRM_SRFSM_Code forUPS( double[] coord ) throws SrmException
    {
	throw new SrmException( SrmException._NOT_IMPLEMENTED, 
				new String("Natural Set Member Code for UPS not implemented") );
    }

    // Be careful!! This routine assume input in radians
    protected static SRM_SRFSM_Code forUTM( double[] coord ) throws SrmException
    {
	SRM_SRFSM_Code ret_zone;
	int zone;
	double[] my_coord = {Math.toDegrees(coord[0]), Math.toDegrees(coord[1])};
	
	if( (my_coord[1]>=84.5) || (my_coord[1]<= -80.5))
	    {
		/*Nether Region*/
		throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
					new String("Source coordinate not defined within UTM zones") );
	    }
	else
	    {
		// get UTM zone from 1 to 60 in the classical UTM definition
		zone = (int)Math.floor( 31.0 +  my_coord[0] *
					0.16666666666666666666666666666666666666666666666666);

		if ( my_coord[0] < -180.0 )
		    zone = 60;
		else if ( my_coord[0] > 180.0 )
		    zone = 1;

		// add 60 to make it southern hemisphere in SRM UTM definition.
		if(my_coord[1]<0.0)
		    zone += 60;
	    }

	ret_zone = SRM_SRFSM_UTM_Code.getEnum( zone );
	
	return ret_zone;    
    }
    
    protected static SRM_SRFSM_Code forGTRS( double[] coord ) throws SrmException
    {
	SRM_SRFSM_GTRS_GCS_Code ret_cell = SRM_SRFSM_GTRS_GCS_Code.getEnum( GtrsDataSet.getNaturalCell( coord ) );

	return ret_cell;
    }

    protected static SRM_SRFSM_Code forALSP( double[] coord ) throws SrmException
    {
	throw new SrmException( SrmException._NOT_IMPLEMENTED, 
				new String("Natural Set Member Code for ALABAMA SPCS not implemented") );
    }

    protected static SRM_SRFSM_Code forLAMBERT_NTF( double[] coord ) throws SrmException
    {
	throw new SrmException( SrmException._NOT_IMPLEMENTED, 
				new String("Natural Set Member Code for LAMBERT NTF not implemented") );
    }

    protected static SRM_SRFSM_Code forJPRP( double[] coord ) throws SrmException
    {
	throw new SrmException( SrmException._NOT_IMPLEMENTED, 
				new String("Natural Set Member Code for JAPAN RECTANGULAR PLACE CS not implemented") );
    }

    protected static SRM_SRFSM_Code forWISP( double[] coord ) throws SrmException
    {
	throw new SrmException( SrmException._NOT_IMPLEMENTED, 
				new String("Natural Set Member Code for WISCONSIN SPCS not implemented") );
    }




    
}
