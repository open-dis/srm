/**
@author David Shen
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
import SRM.*;

public class CdToCcConv
{
    public static void main (String args[])
    {	
	System.out.println( "*** Sample program using SRM Java API to convert a 3D coordinate" );
	System.out.println( "*** from a Celestiodetic SRF to a Celestiocentric SRF." );
	
	// Declare reference variables for the CD and CC SRFs
	SRF_Celestiodetic CdSrf = null;
	SRF_Celestiocentric CcSrf = null;

	try {
	    // Create a Celestiodetic SRF with WGS 1984
	    CdSrf = new SRF_Celestiodetic(SRM_ORM_Code.ORMCOD_WGS_1984,
	    				  SRM_RT_Code.RTCOD_WGS_1984_IDENTITY);

	    // Create a Celesticentric SRF with WGS 1984
	    CcSrf = new SRF_Celestiocentric(SRM_ORM_Code.ORMCOD_WGS_1984,
					    SRM_RT_Code.RTCOD_WGS_1984_IDENTITY);

	    // Create a 3D Celestiodetic coordinate with
	    // longitude           => 10.0 degrees (note: this input parameter is converted to radians)
	    // latitude            => 20.0 degrees (note: this input parameter is converted to radians)
	    // ellipsopidal height => 100.0 meters
	    Coord3D_Celestiodetic CdCoord =
		(Coord3D_Celestiodetic)CdSrf.createCoordinate3D(Math.toRadians(10.0),
								Math.toRadians(20.0),
								100.0);

	    // Instantiate a 3D Celestiocentric coordinate
	    // This is an alternative method for instantiate a 3D coordinate
	    Coord3D_Celestiocentric CcCoord = new Coord3D_Celestiocentric( CcSrf );
	
	    // print out the SRF parameter calues and the coordinate component values
	    System.out.println("CdSrf parameter =>  \n" + CdSrf);
	    System.out.println("CcSrf parameter =>  \n" + CcSrf);
	    System.out.println("CdCoord components (source) => \n" + CdCoord);

	    // convert the 3D Celestiodetic coordinate to 3D Celestiocentric coordinate
	    SRM_Coordinate_Valid_Region_Code valRegion =
		CcSrf.changeCoordinateSRF( CdCoord, CcCoord );
	
	    // print out the values of the resulting 3D Celestiocentric coordinate
	    System.out.println("CcCoord components (destination) => \n" + CcCoord + " is " + valRegion );

	}
	catch (SrmException ex)
        {
	    // catch SrmException and print out the error code and text.
	    System.out.println("Exception caught=> " + ex.what() + ", " + ex);
	}	
    }
}
