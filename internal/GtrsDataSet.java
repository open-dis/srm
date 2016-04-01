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

class GtrsDataSet extends GcsGtrsDataSet
{

    public static int TABLE_SIZE = 49896;
    private static int ROWS = 180;

    private GtrsDataSet(int minimum_cell_id,
		       double row_lat,
		       double starting_lon,
		       double cell_width,
		       double cell_width_inv,
		       int maximum_cell_id,
		       double irreg_cell_lon,
		       double irreg_cell_width) 
    {
	super ( minimum_cell_id, row_lat, starting_lon, 
		cell_width, cell_width_inv, maximum_cell_id,
		irreg_cell_lon, irreg_cell_width);
    }

 
    // Binary search of the table for the row containing the specific cell id
    protected static GtrsDataSet getElem(int GtrsCellId) throws SrmException
    {
        int lower = 0;
	int upper = ROWS - 1;
	int current = 0;
	boolean found = false;
	
	if ( GtrsCellId < 1 || GtrsCellId > TABLE_SIZE )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("Invalid GTRS Cell id (Valid range [1; 49896])"));

	// this while loop assumes that the cell will always be found
	// within the valid range from 1 to TABLE_SIZE
	while (! found )
	    {

		current = lower + ((upper - lower) / 2);
		
//  		System.out.println( current + ", " + upper + ", " + lower);

		if ( GtrsCellId >= table[current]._minimum_cell_id && 
		     GtrsCellId <= table[current]._maximum_cell_id )
		    found = true;

		else if ( GtrsCellId > table[current]._maximum_cell_id )
		    lower = current + 1;

		else upper = current - 1;
	    }

	if ( !found ) 
	    throw new SrmException( SrmException._INACTIONABLE, 
				    new String("Internal Error (find GTRS cell)") );

	return table[current];
    }


    protected static int getNaturalCell( double[] coord ) throws SrmException
    {
	int lat_index;

	/*
	 * The GTRS GCS table is indexed by latitude + 90 degrees
	 * because to look up latitude in the table with latitude lines numbered 0 is 
         * -90 through 179 is 90 one must add 90 degrees to an SRM latitude.
	 * EX: a latitude of -90 degrees will show up in the table as row 0 while a 
	 * latitude of plus 90 will show up as row 179
	 * 
	 */
	
	lat_index = (int) (Math.floor(coord[1] * Const.DEGREES_PER_RADIAN) + 90.0);

	return ( table[lat_index]._minimum_cell_id +
		 (int)(Math.floor( (coord[0] * Const.DEGREES_PER_RADIAN + 180.0) 
			     * table[lat_index]._cell_width_inv)) );	
    }

    protected static double getCellOrigLon( int GtrsCellId, GtrsDataSet data ) throws SrmException
    {
	// if the cell is not the last one in this row then
	// compute as one of the regular cells
	if(GtrsCellId != data._maximum_cell_id)
	    return ( ( (GtrsCellId - data._minimum_cell_id) * 
		       data._cell_width + data._starting_lon )
		     * Const.RADIANS_PER_DEGREE );
	
	// else this is the last of the row and its size is irregular
	else
	    return data._irreg_cell_lon * Const.RADIANS_PER_DEGREE;
    
    }

   
    protected static double getCellOrigLat( GtrsDataSet data ) throws SrmException
    {
	return data._row_lat * Const.RADIANS_PER_DEGREE;
	
    }


    protected static double getCellOrigLonMinExtent( int GtrsCellId, GtrsDataSet data ) throws SrmException
    {
	// if the cell is not the last one in this row then
	// compute as one of the regular cells
	if(GtrsCellId != data._maximum_cell_id)
	    return (((GtrsCellId - data._minimum_cell_id) 
		     * data._cell_width + data._starting_lon ) // originLon computation
		    - data._cell_width * 0.5 ) * Const.RADIANS_PER_DEGREE;

	// else this is the last of the row and its size is irregular
	else
	    return (((GtrsCellId - data._minimum_cell_id) 
		     * data._cell_width + data._starting_lon ) // originLon computation		   
		    - data._irreg_cell_width * 0.5) * Const.RADIANS_PER_DEGREE;	
    }


    protected static double getCellOrigLonMaxExtent( int GtrsCellId, GtrsDataSet data ) throws SrmException
    {
	// if the cell is not the last one in this row then
	// compute as one of the regular cells
	if(GtrsCellId != data._maximum_cell_id)
	    return (((GtrsCellId - data._minimum_cell_id) 
		     * data._cell_width + data._starting_lon ) // originLon computation
		    + data._cell_width * 0.5 ) * Const.RADIANS_PER_DEGREE;

	// else this is the last of the row and its size is irregular
	else 
	    return (((GtrsCellId - data._minimum_cell_id) 
		     * data._cell_width + data._starting_lon ) // originLon computation		   
		    + data._irreg_cell_width * 0.5) * Const.RADIANS_PER_DEGREE;	
    }


    private static GtrsDataSet[] table =
    {
	new GtrsDataSet
	    (1,-89.50,-165.00,30.00,0.03333333333333333287,12,165.00,30.00),    
	new GtrsDataSet
	    (13,-88.50,-165.00,30.00,0.03333333333333333287,24,165.00,30.00),
	new GtrsDataSet
	    (25,-87.50,-172.50,15.00,0.06666666666666666574,48,172.50,15.00),
	new GtrsDataSet
	    (49,-86.50,-172.50,15.00,0.06666666666666666574,72,172.50,15.00),
	new GtrsDataSet
	    (73,-85.50,-175.00,10.00,0.10000000000000000555,108,175.00,10.00),
	new GtrsDataSet
	    (109,-84.50,-175.00,10.00,0.10000000000000000555,144,175.00,10.00),
	new GtrsDataSet
	    (145,-83.50,-177.00,6.00,0.16666666666666665741,204,177.00,6.00),
	new GtrsDataSet
	    (205,-82.50,-177.00,6.00,0.16666666666666665741,264,177.00,6.00),
	new GtrsDataSet
	    (265,-81.50,-177.00,6.00,0.16666666666666665741,324,177.00,6.00),
	new GtrsDataSet
	    (325,-80.50,-177.00,6.00,0.16666666666666665741,384,177.00,6.00),
	new GtrsDataSet
	    (385,-79.50,-177.50,5.00,0.20000000000000001110,456,177.50,5.00),
	new GtrsDataSet
	    (457,-78.50,-177.50,5.00,0.20000000000000001110,528,177.50,5.00),
	new GtrsDataSet
	    (529,-77.50,-178.50,3.00,0.33333333333333331483,648,178.50,3.00),
	new GtrsDataSet
	    (649,-76.50,-178.50,3.00,0.33333333333333331483,768,178.50,3.00),
	new GtrsDataSet
	    (769,-75.50,-178.50,3.00,0.33333333333333331483,888,178.50,3.00),
	new GtrsDataSet
	    (889,-74.50,-178.50,3.00,0.33333333333333331483,1008,178.50,3.00),
	new GtrsDataSet
	    (1009,-73.50,-178.50,3.00,0.33333333333333331483,1128,178.50,3.00),
	new GtrsDataSet
	    (1129,-72.50,-178.50,3.00,0.33333333333333331483,1248,178.50,3.00),
	new GtrsDataSet
	    (1249,-71.50,-178.50,3.00,0.33333333333333331483,1368,178.50,3.00),
	new GtrsDataSet
	    (1369,-70.50,-179.00,2.00,0.50000000000000000000,1548,179.00,2.00),
	new GtrsDataSet
	    (1549,-69.50,-179.00,2.00,0.50000000000000000000,1728,179.00,2.00),
	new GtrsDataSet
	    (1729,-68.50,-179.00,2.00,0.50000000000000000000,1908,179.00,2.00),
	new GtrsDataSet
	    (1909,-67.50,-179.00,2.00,0.50000000000000000000,2088,179.00,2.00),
	new GtrsDataSet
	    (2089,-66.50,-179.00,2.00,0.50000000000000000000,2268,179.00,2.00),
	new GtrsDataSet
	    (2269,-65.50,-179.00,2.00,0.50000000000000000000,2448,179.00,2.00),
	new GtrsDataSet
	    (2449,-64.50,-179.00,2.00,0.50000000000000000000,2628,179.00,2.00),
	new GtrsDataSet
	    (2629,-63.50,-179.00,2.00,0.50000000000000000000,2808,179.00,2.00),
	new GtrsDataSet
	    (2809,-62.50,-179.00,2.00,0.50000000000000000000,2988,179.00,2.00),
	new GtrsDataSet
	    (2989,-61.50,-179.00,2.00,0.50000000000000000000,3168,179.00,2.00),
	new GtrsDataSet
	    (3169,-60.50,-179.00,2.00,0.50000000000000000000,3348,179.00,2.00),
	new GtrsDataSet
	    (3349,-59.50,-179.50,1.00,1.00000000000000000000,3708,179.50,1.00),
	new GtrsDataSet
	    (3709,-58.50,-179.50,1.00,1.00000000000000000000,4068,179.50,1.00),
	new GtrsDataSet
	    (4069,-57.50,-179.50,1.00,1.00000000000000000000,4428,179.50,1.00),
	new GtrsDataSet
	    (4429,-56.50,-179.50,1.00,1.00000000000000000000,4788,179.50,1.00),
	new GtrsDataSet
	    (4789,-55.50,-179.50,1.00,1.00000000000000000000,5148,179.50,1.00),
	new GtrsDataSet
	    (5149,-54.50,-179.50,1.00,1.00000000000000000000,5508,179.50,1.00),
	new GtrsDataSet
	    (5509,-53.50,-179.50,1.00,1.00000000000000000000,5868,179.50,1.00),
	new GtrsDataSet
	    (5869,-52.50,-179.50,1.00,1.00000000000000000000,6228,179.50,1.00),
	new GtrsDataSet
	    (6229,-51.50,-179.50,1.00,1.00000000000000000000,6588,179.50,1.00),
	new GtrsDataSet
	    (6589,-50.50,-179.50,1.00,1.00000000000000000000,6948,179.50,1.00),
	new GtrsDataSet
	    (6949,-49.50,-179.50,1.00,1.00000000000000000000,7308,179.50,1.00),
	new GtrsDataSet
	    (7309,-48.50,-179.50,1.00,1.00000000000000000000,7668,179.50,1.00),
	new GtrsDataSet
	    (7669,-47.50,-179.50,1.00,1.00000000000000000000,8028,179.50,1.00),
	new GtrsDataSet
	    (8029,-46.50,-179.50,1.00,1.00000000000000000000,8388,179.50,1.00),
	new GtrsDataSet
	    (8389,-45.50,-179.50,1.00,1.00000000000000000000,8748,179.50,1.00),
	new GtrsDataSet
	    (8749,-44.50,-179.50,1.00,1.00000000000000000000,9108,179.50,1.00),
	new GtrsDataSet
	    (9109,-43.50,-179.50,1.00,1.00000000000000000000,9468,179.50,1.00),
	new GtrsDataSet
	    (9469,-42.50,-179.50,1.00,1.00000000000000000000,9828,179.50,1.00),
	new GtrsDataSet
	    (9829,-41.50,-179.50,1.00,1.00000000000000000000,10188,179.50,1.00),
	new GtrsDataSet
	    (10189,-40.50,-179.50,1.00,1.00000000000000000000,10548,179.50,1.00),
	new GtrsDataSet
	    (10549,-39.50,-179.50,1.00,1.00000000000000000000,10908,179.50,1.00),
	new GtrsDataSet
	    (10909,-38.50,-179.50,1.00,1.00000000000000000000,11268,179.50,1.00),
	new GtrsDataSet
	    (11269,-37.50,-179.50,1.00,1.00000000000000000000,11628,179.50,1.00),
	new GtrsDataSet
	    (11629,-36.50,-179.50,1.00,1.00000000000000000000,11988,179.50,1.00),
	new GtrsDataSet
	    (11989,-35.50,-179.50,1.00,1.00000000000000000000,12348,179.50,1.00),
	new GtrsDataSet
	    (12349,-34.50,-179.50,1.00,1.00000000000000000000,12708,179.50,1.00),
	new GtrsDataSet
	    (12709,-33.50,-179.50,1.00,1.00000000000000000000,13068,179.50,1.00),
	new GtrsDataSet
	    (13069,-32.50,-179.50,1.00,1.00000000000000000000,13428,179.50,1.00),
	new GtrsDataSet
	    (13429,-31.50,-179.50,1.00,1.00000000000000000000,13788,179.50,1.00),
	new GtrsDataSet
	    (13789,-30.50,-179.50,1.00,1.00000000000000000000,14148,179.50,1.00),
	new GtrsDataSet
	    (14149,-29.50,-179.50,1.00,1.00000000000000000000,14508,179.50,1.00),
	new GtrsDataSet
	    (14509,-28.50,-179.50,1.00,1.00000000000000000000,14868,179.50,1.00),
	new GtrsDataSet
	    (14869,-27.50,-179.50,1.00,1.00000000000000000000,15228,179.50,1.00),
	new GtrsDataSet
	    (15229,-26.50,-179.50,1.00,1.00000000000000000000,15588,179.50,1.00),
	new GtrsDataSet
	    (15589,-25.50,-179.50,1.00,1.00000000000000000000,15948,179.50,1.00),
	new GtrsDataSet
	    (15949,-24.50,-179.50,1.00,1.00000000000000000000,16308,179.50,1.00),
	new GtrsDataSet
	    (16309,-23.50,-179.50,1.00,1.00000000000000000000,16668,179.50,1.00),
	new GtrsDataSet
	    (16669,-22.50,-179.50,1.00,1.00000000000000000000,17028,179.50,1.00),
	new GtrsDataSet
	    (17029,-21.50,-179.50,1.00,1.00000000000000000000,17388,179.50,1.00),
	new GtrsDataSet
	    (17389,-20.50,-179.50,1.00,1.00000000000000000000,17748,179.50,1.00),
	new GtrsDataSet
	    (17749,-19.50,-179.50,1.00,1.00000000000000000000,18108,179.50,1.00),
	new GtrsDataSet
	    (18109,-18.50,-179.50,1.00,1.00000000000000000000,18468,179.50,1.00),
	new GtrsDataSet
	    (18469,-17.50,-179.50,1.00,1.00000000000000000000,18828,179.50,1.00),
	new GtrsDataSet
	    (18829,-16.50,-179.50,1.00,1.00000000000000000000,19188,179.50,1.00),
	new GtrsDataSet
	    (19189,-15.50,-179.50,1.00,1.00000000000000000000,19548,179.50,1.00),
	new GtrsDataSet
	    (19549,-14.50,-179.50,1.00,1.00000000000000000000,19908,179.50,1.00),
	new GtrsDataSet
	    (19909,-13.50,-179.50,1.00,1.00000000000000000000,20268,179.50,1.00),
	new GtrsDataSet
	    (20269,-12.50,-179.50,1.00,1.00000000000000000000,20628,179.50,1.00),
	new GtrsDataSet
	    (20629,-11.50,-179.50,1.00,1.00000000000000000000,20988,179.50,1.00),
	new GtrsDataSet
	    (20989,-10.50,-179.50,1.00,1.00000000000000000000,21348,179.50,1.00),
	new GtrsDataSet
	    (21349,-9.50,-179.50,1.00,1.00000000000000000000,21708,179.50,1.00),
	new GtrsDataSet
	    (21709,-8.50,-179.50,1.00,1.00000000000000000000,22068,179.50,1.00),
	new GtrsDataSet
	    (22069,-7.50,-179.50,1.00,1.00000000000000000000,22428,179.50,1.00),
	new GtrsDataSet
	    (22429,-6.50,-179.50,1.00,1.00000000000000000000,22788,179.50,1.00),
	new GtrsDataSet
	    (22789,-5.50,-179.50,1.00,1.00000000000000000000,23148,179.50,1.00),
	new GtrsDataSet
	    (23149,-4.50,-179.50,1.00,1.00000000000000000000,23508,179.50,1.00),
	new GtrsDataSet
	    (23509,-3.50,-179.50,1.00,1.00000000000000000000,23868,179.50,1.00),
	new GtrsDataSet
	    (23869,-2.50,-179.50,1.00,1.00000000000000000000,24228,179.50,1.00),
	new GtrsDataSet
	    (24229,-1.50,-179.50,1.00,1.00000000000000000000,24588,179.50,1.00),
	new GtrsDataSet
	    (24589,-0.50,-179.50,1.00,1.00000000000000000000,24948,179.50,1.00),
	new GtrsDataSet
	    (24949,0.50,-179.50,1.00,1.00000000000000000000,25308,179.50,1.00),
	new GtrsDataSet
	    (25309,1.50,-179.50,1.00,1.00000000000000000000,25668,179.50,1.00),
	new GtrsDataSet
	    (25669,2.50,-179.50,1.00,1.00000000000000000000,26028,179.50,1.00),
	new GtrsDataSet
	    (26029,3.50,-179.50,1.00,1.00000000000000000000,26388,179.50,1.00),
	new GtrsDataSet
	    (26389,4.50,-179.50,1.00,1.00000000000000000000,26748,179.50,1.00),
	new GtrsDataSet
	    (26749,5.50,-179.50,1.00,1.00000000000000000000,27108,179.50,1.00),
	new GtrsDataSet
	    (27109,6.50,-179.50,1.00,1.00000000000000000000,27468,179.50,1.00),
	new GtrsDataSet
	    (27469,7.50,-179.50,1.00,1.00000000000000000000,27828,179.50,1.00),
	new GtrsDataSet
	    (27829,8.50,-179.50,1.00,1.00000000000000000000,28188,179.50,1.00),
	new GtrsDataSet
	    (28189,9.50,-179.50,1.00,1.00000000000000000000,28548,179.50,1.00),
	new GtrsDataSet
	    (28549,10.50,-179.50,1.00,1.00000000000000000000,28908,179.50,1.00),
	new GtrsDataSet
	    (28909,11.50,-179.50,1.00,1.00000000000000000000,29268,179.50,1.00),
	new GtrsDataSet
	    (29269,12.50,-179.50,1.00,1.00000000000000000000,29628,179.50,1.00),
	new GtrsDataSet
	    (29629,13.50,-179.50,1.00,1.00000000000000000000,29988,179.50,1.00),
	new GtrsDataSet
	    (29989,14.50,-179.50,1.00,1.00000000000000000000,30348,179.50,1.00),
	new GtrsDataSet
	    (30349,15.50,-179.50,1.00,1.00000000000000000000,30708,179.50,1.00),
	new GtrsDataSet
	    (30709,16.50,-179.50,1.00,1.00000000000000000000,31068,179.50,1.00),
	new GtrsDataSet
	    (31069,17.50,-179.50,1.00,1.00000000000000000000,31428,179.50,1.00),
	new GtrsDataSet
	    (31429,18.50,-179.50,1.00,1.00000000000000000000,31788,179.50,1.00),
	new GtrsDataSet
	    (31789,19.50,-179.50,1.00,1.00000000000000000000,32148,179.50,1.00),
	new GtrsDataSet
	    (32149,20.50,-179.50,1.00,1.00000000000000000000,32508,179.50,1.00),
	new GtrsDataSet
	    (32509,21.50,-179.50,1.00,1.00000000000000000000,32868,179.50,1.00),
	new GtrsDataSet
	    (32869,22.50,-179.50,1.00,1.00000000000000000000,33228,179.50,1.00),
	new GtrsDataSet
	    (33229,23.50,-179.50,1.00,1.00000000000000000000,33588,179.50,1.00),
	new GtrsDataSet
	    (33589,24.50,-179.50,1.00,1.00000000000000000000,33948,179.50,1.00),
	new GtrsDataSet
	    (33949,25.50,-179.50,1.00,1.00000000000000000000,34308,179.50,1.00),
	new GtrsDataSet
	    (34309,26.50,-179.50,1.00,1.00000000000000000000,34668,179.50,1.00),
	new GtrsDataSet
	    (34669,27.50,-179.50,1.00,1.00000000000000000000,35028,179.50,1.00),
	new GtrsDataSet
	    (35029,28.50,-179.50,1.00,1.00000000000000000000,35388,179.50,1.00),
	new GtrsDataSet
	    (35389,29.50,-179.50,1.00,1.00000000000000000000,35748,179.50,1.00),
	new GtrsDataSet
	    (35749,30.50,-179.50,1.00,1.00000000000000000000,36108,179.50,1.00),
	new GtrsDataSet
	    (36109,31.50,-179.50,1.00,1.00000000000000000000,36468,179.50,1.00),
	new GtrsDataSet
	    (36469,32.50,-179.50,1.00,1.00000000000000000000,36828,179.50,1.00),
	new GtrsDataSet
	    (36829,33.50,-179.50,1.00,1.00000000000000000000,37188,179.50,1.00),
	new GtrsDataSet
	    (37189,34.50,-179.50,1.00,1.00000000000000000000,37548,179.50,1.00),
	new GtrsDataSet
	    (37549,35.50,-179.50,1.00,1.00000000000000000000,37908,179.50,1.00),
	new GtrsDataSet
	    (37909,36.50,-179.50,1.00,1.00000000000000000000,38268,179.50,1.00),
	new GtrsDataSet
	    (38269,37.50,-179.50,1.00,1.00000000000000000000,38628,179.50,1.00),
	new GtrsDataSet
	    (38629,38.50,-179.50,1.00,1.00000000000000000000,38988,179.50,1.00),
	new GtrsDataSet
	    (38989,39.50,-179.50,1.00,1.00000000000000000000,39348,179.50,1.00),
	new GtrsDataSet
	    (39349,40.50,-179.50,1.00,1.00000000000000000000,39708,179.50,1.00),
	new GtrsDataSet
	    (39709,41.50,-179.50,1.00,1.00000000000000000000,40068,179.50,1.00),
	new GtrsDataSet
	    (40069,42.50,-179.50,1.00,1.00000000000000000000,40428,179.50,1.00),
	new GtrsDataSet
	    (40429,43.50,-179.50,1.00,1.00000000000000000000,40788,179.50,1.00),
	new GtrsDataSet
	    (40789,44.50,-179.50,1.00,1.00000000000000000000,41148,179.50,1.00),
	new GtrsDataSet
	    (41149,45.50,-179.50,1.00,1.00000000000000000000,41508,179.50,1.00),
	new GtrsDataSet
	    (41509,46.50,-179.50,1.00,1.00000000000000000000,41868,179.50,1.00),
	new GtrsDataSet
	    (41869,47.50,-179.50,1.00,1.00000000000000000000,42228,179.50,1.00),
	new GtrsDataSet
	    (42229,48.50,-179.50,1.00,1.00000000000000000000,42588,179.50,1.00),
	new GtrsDataSet
	    (42589,49.50,-179.50,1.00,1.00000000000000000000,42948,179.50,1.00),
	new GtrsDataSet
	    (42949,50.50,-179.50,1.00,1.00000000000000000000,43308,179.50,1.00),
	new GtrsDataSet
	    (43309,51.50,-179.50,1.00,1.00000000000000000000,43668,179.50,1.00),
	new GtrsDataSet
	    (43669,52.50,-179.50,1.00,1.00000000000000000000,44028,179.50,1.00),
	new GtrsDataSet
	    (44029,53.50,-179.50,1.00,1.00000000000000000000,44388,179.50,1.00),
	new GtrsDataSet
	    (44389,54.50,-179.50,1.00,1.00000000000000000000,44748,179.50,1.00),
	new GtrsDataSet
	    (44749,55.50,-179.50,1.00,1.00000000000000000000,45108,179.50,1.00),
	new GtrsDataSet
	    (45109,56.50,-179.50,1.00,1.00000000000000000000,45468,179.50,1.00),
	new GtrsDataSet
	    (45469,57.50,-179.50,1.00,1.00000000000000000000,45828,179.50,1.00),
	new GtrsDataSet
	    (45829,58.50,-179.50,1.00,1.00000000000000000000,46188,179.50,1.00),
	new GtrsDataSet
	    (46189,59.50,-179.50,1.00,1.00000000000000000000,46548,179.50,1.00),
	new GtrsDataSet
	    (46549,60.50,-179.00,2.00,0.50000000000000000000,46728,179.00,2.00),
	new GtrsDataSet
	    (46729,61.50,-179.00,2.00,0.50000000000000000000,46908,179.00,2.00),
	new GtrsDataSet
	    (46909,62.50,-179.00,2.00,0.50000000000000000000,47088,179.00,2.00),
	new GtrsDataSet
	    (47089,63.50,-179.00,2.00,0.50000000000000000000,47268,179.00,2.00),
	new GtrsDataSet
	    (47269,64.50,-179.00,2.00,0.50000000000000000000,47448,179.00,2.00),
	new GtrsDataSet
	    (47449,65.50,-179.00,2.00,0.50000000000000000000,47628,179.00,2.00),
	new GtrsDataSet
	    (47629,66.50,-179.00,2.00,0.50000000000000000000,47808,179.00,2.00),
	new GtrsDataSet
	    (47809,67.50,-179.00,2.00,0.50000000000000000000,47988,179.00,2.00),
	new GtrsDataSet
	    (47989,68.50,-179.00,2.00,0.50000000000000000000,48168,179.00,2.00),
	new GtrsDataSet
	    (48169,69.50,-179.00,2.00,0.50000000000000000000,48348,179.00,2.00),
	new GtrsDataSet
	    (48349,70.50,-179.00,2.00,0.50000000000000000000,48528,179.00,2.00),
	new GtrsDataSet
	    (48529,71.50,-178.50,3.00,0.33333333333333331483,48648,178.50,3.00),
	new GtrsDataSet
	    (48649,72.50,-178.50,3.00,0.33333333333333331483,48768,178.50,3.00),
	new GtrsDataSet
	    (48769,73.50,-178.50,3.00,0.33333333333333331483,48888,178.50,3.00),
	new GtrsDataSet
	    (48889,74.50,-178.50,3.00,0.33333333333333331483,49008,178.50,3.00),
	new GtrsDataSet
	    (49009,75.50,-178.50,3.00,0.33333333333333331483,49128,178.50,3.00),
	new GtrsDataSet
	    (49129,76.50,-178.50,3.00,0.33333333333333331483,49248,178.50,3.00),
	new GtrsDataSet
	    (49249,77.50,-178.50,3.00,0.33333333333333331483,49368,178.50,3.00),
	new GtrsDataSet
	    (49369,78.50,-177.50,5.00,0.20000000000000001110,49440,177.50,5.00),
	new GtrsDataSet
	    (49441,79.50,-177.50,5.00,0.20000000000000001110,49512,177.50,5.00),
	new GtrsDataSet
	    (49513,80.50,-177.00,6.00,0.16666666666666665741,49572,177.00,6.00),
	new GtrsDataSet
	    (49573,81.50,-177.00,6.00,0.16666666666666665741,49632,177.00,6.00),
	new GtrsDataSet
	    (49633,82.50,-177.00,6.00,0.16666666666666665741,49692,177.00,6.00),
	new GtrsDataSet
	    (49693,83.50,-177.00,6.00,0.16666666666666665741,49752,177.00,6.00),
	new GtrsDataSet
	    (49753,84.50,-175.00,10.00,0.10000000000000000555,49788,175.00,10.00),
	new GtrsDataSet
	    (49789,85.50,-175.00,10.00,0.10000000000000000555,49824,175.00,10.00),
	new GtrsDataSet
	    (49825,86.50,-172.50,15.00,0.06666666666666666574,49848,172.50,15.00),
	new GtrsDataSet
	    (49849,87.50,-172.50,15.00,0.06666666666666666574,49872,172.50,15.00),
	new GtrsDataSet
	    (49873,88.50,-165.00,30.00,0.03333333333333333287,49884,165.00,30.00),
	new GtrsDataSet
	    (49885,89.50,-165.00,30.00,0.03333333333333333287,49896,165.00,30.00)
     };

}
