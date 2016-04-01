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
@author Steve Farsai
@brief Utility class for converting between geodetic and Military Grid Reference System (MGRS)
       coordinates (source:  NGC, GEOTRANS code).
*/

package SRM;

import java.util.*;

//
// The contents of this file are an almost verbatim port of the C-code
// to Java-code for the source in files mgrs.c and mgrs.h from GEOTRANS
// via Kevin Trott of NGC.
//
// The source of this particular version of mgrs.c and mgrs.h contains
// a few minor fixes since the SEDRIS SDK 4.1.1 release.
//

/***************************************************************************
 *
 * RSC IDENTIFIER:  MGRS
 *
 * ABSTRACT
 *
 *    This component converts between geodetic coordinates (latitude and
 *    longitude) and Military Grid Reference System (MGRS) coordinates.
 *
 * ERROR HANDLING
 *
 *    This component checks parameters for valid values.  If an invalid value
 *    is found, the error code is combined with the current error code using
 *    the bitwise or.  This combining allows multiple error codes to be
 *    returned. The possible error codes are:
 *
 *          MGRS_NO_ERROR          : No errors occurred in function
 *          MGRS_LAT_ERROR         : Latitude outside of valid range
 *                                    (-90 to 90 degrees)
 *          MGRS_LON_ERROR         : Longitude outside of valid range
 *                                    (-180 to 360 degrees)
 *          MGRS_STR_ERROR         : An MGRS string error: string too long,
 *                                    too short, or badly formed
 *          MGRS_PRECISION_ERROR   : The precision must be between 0 and 5
 *                                    inclusive.
 *          MGRS_A_ERROR           : Semi-major axis less than or equal to zero
 *          MGRS_INV_F_ERROR       : Inverse flattening outside of valid range
 *                                      (250 to 350)
 *          MGRS_EASTING_ERROR     : Easting outside of valid range
 *                                    (100,000 to 900,000 meters for UTM)
 *                                    (0 to 4,000,000 meters for UPS)
 *          MGRS_NORTHING_ERROR    : Northing outside of valid range
 *                                    (0 to 10,000,000 meters for UTM)
 *                                    (0 to 4,000,000 meters for UPS)
 *          MGRS_ZONE_ERROR        : Zone outside of valid range (1 to 60)
 *          MGRS_HEMISPHERE_ERROR  : Invalid hemisphere ('N' or 'S')
 *
 * REUSE NOTES
 *
 *    MGRS is intended for reuse by any application that does conversions
 *    between geodetic coordinates and MGRS coordinates.
 *
 * REFERENCES
 *
 *    Further information on MGRS can be found in the Reuse Manual.
 *
 *    MGRS originated from : U.S. Army Topographic Engineering Center
 *                           Geospatial Information Division
 *                           7701 Telegraph Road
 *                           Alexandria, VA  22310-3864
 *
 * LICENSES
 *
 *    None apply to this component.
 *
 * RESTRICTIONS
 *
 *
 * ENVIRONMENT
 *
 *    MGRS was tested and certified in the following environments:
 *
 *    1. Solaris 2.5 with GCC version 2.8.1
 *    2. Windows 95 with MS Visual C++ version 6
 *
 * MODIFICATIONS
 *
 *    Date              Description
 *    ----              -----------
 *    16-11-94          Original Code
 *    15-09-99          Reengineered upper layers
 *    02-05-03          Corrected latitude band bug in GRID_UTM
 *    08-20-03          Reengineered lower layers
 */

class MGRS
{
    private static final double DEG_TO_RAD = 0.017453292519943295; // PI/180
    private static final double RAD_TO_DEG = 57.29577951308232087; // 180/PI

    // Error codes/masks
    protected static final int MGRS_NO_ERROR         = 0x0000;
    protected static final int MGRS_LAT_ERROR        = 0x0001;
    protected static final int MGRS_LON_ERROR        = 0x0002;
    protected static final int MGRS_STRING_ERROR     = 0x0004;
    protected static final int MGRS_PRECISION_ERROR  = 0x0008;
    protected static final int MGRS_A_ERROR          = 0x0010;
    protected static final int MGRS_INV_F_ERROR      = 0x0020;
    protected static final int MGRS_EASTING_ERROR    = 0x0040;
    protected static final int MGRS_NORTHING_ERROR   = 0x0080;
    protected static final int MGRS_ZONE_ERROR       = 0x0100;
    protected static final int MGRS_HEMISPHERE_ERROR = 0x0200;
    // ssf, Interesting: They changed names to be warnings from here
    protected static final int MGRS_LAT_WARNING      = 0x0400;

    // Array indices
    private static final int LETTER_A = 0;
    private static final int LETTER_B = 1;
    private static final int LETTER_C = 2;
    private static final int LETTER_D = 3;
    private static final int LETTER_E = 4;
    private static final int LETTER_F = 5;
    private static final int LETTER_G = 6;
    private static final int LETTER_H = 7;
    private static final int LETTER_I = 8;
    private static final int LETTER_J = 9;
    private static final int LETTER_K = 10;
    private static final int LETTER_L = 11;
    private static final int LETTER_M = 12;
    private static final int LETTER_N = 13;
    private static final int LETTER_O = 14;
    private static final int LETTER_P = 15;
    private static final int LETTER_Q = 16;
    private static final int LETTER_R = 17;
    private static final int LETTER_S = 18;
    private static final int LETTER_T = 19;
    private static final int LETTER_U = 20;
    private static final int LETTER_V = 21;
    private static final int LETTER_W = 22;
    private static final int LETTER_X = 23;
    private static final int LETTER_Y = 24;
    private static final int LETTER_Z = 25;

    private static final int MGRS_LETTERS = 3;      // Number of letters in MGRS
    private static final double ONEHT = 100000.e0;  // One hundred thousand
    private static final double TWOMIL = 2000000.e0;// Two million
    private static final double PI = 3.14159265358979323e0; // Pi
    private static final double PI_OVER_2 = (PI / 2.0);
    private static final double PI_OVER_30 = (PI / 30.0);

    private static final double MIN_EASTING = 100000;
    private static final double MAX_EASTING = 900000;
    private static final double MIN_NORTHING = 0;
    private static final double MAX_NORTHING = 10000000;

    // Maximum precision of easting & northing
    private static final int MAX_PRECISION = 5;

    private static final double MIN_UTM_LAT = ((-80 * PI) / 180.0); // -80 deg in rads
    private static final double MAX_UTM_LAT = (( 84 * PI) / 180.0); //  84 deg in rads

    private static final double MIN_EAST_NORTH = 0;
    private static final double MAX_EAST_NORTH = 4000000;

    // Ellipsoid parameters, default to WGS 84
//  private double MGRS_a = 6378137.0;    // Semi-major axis of ellipsoid in meters
//  private double MGRS_f = 1 / 298.257223563; // Flattening of ellipsoid
    private String MGRS_Ellipsoid_Code = "WE";
    private BaseSRF_3D MGRS_srf;

    /*
     *    CLARKE_1866 : Ellipsoid code for CLARKE_1866
     *    CLARKE_1880 : Ellipsoid code for CLARKE_1880
     *    BESSEL_1841 : Ellipsoid code for BESSEL_1841
     *    BESSEL_1841_NAMIBIA : Ellipsoid code for BESSEL 1841 (NAMIBIA)
     */
    protected static final String CLARKE_1866         = "CC";
    protected static final String CLARKE_1880         = "CD";
    protected static final String BESSEL_1841         = "BR";
    protected static final String BESSEL_1841_NAMIBIA = "BN";

    private static class Latitude_Band
    {
        int    letter;          /* letter representing latitude band  */
        double min_northing;    /* minimum northing for latitude band */
        double north;           /* upper latitude for latitude band   */
        double south;           /* lower latitude for latitude band   */
        double northing_offset; /* latitude band northing offset      */

        // constructor
        protected Latitude_Band
        (
            int    iLetter,
            double MinNorthing,
            double NorthBand,
            double SouthBand,
            double NorthingOffset
        )
        {
            letter          = iLetter;
            min_northing    = MinNorthing;
            north           = NorthBand;
            south           = SouthBand;
            northing_offset = NorthingOffset;
        }
    }

    private static Latitude_Band[] Latitude_Band_Table = new Latitude_Band[]
    {
        new Latitude_Band (LETTER_C, 1100000.0, -72.0, -80.5, 0.0),
        new Latitude_Band (LETTER_D, 2000000.0, -64.0, -72.0, 2000000.0),
        new Latitude_Band (LETTER_E, 2800000.0, -56.0, -64.0, 2000000.0),
        new Latitude_Band (LETTER_F, 3700000.0, -48.0, -56.0, 2000000.0),
        new Latitude_Band (LETTER_G, 4600000.0, -40.0, -48.0, 4000000.0),
        new Latitude_Band (LETTER_H, 5500000.0, -32.0, -40.0, 4000000.0),
        new Latitude_Band (LETTER_J, 6400000.0, -24.0, -32.0, 6000000.0),
        new Latitude_Band (LETTER_K, 7300000.0, -16.0, -24.0, 6000000.0),
        new Latitude_Band (LETTER_L, 8200000.0, -8.0, -16.0, 8000000.0),
        new Latitude_Band (LETTER_M, 9100000.0, 0.0, -8.0, 8000000.0),
        new Latitude_Band (LETTER_N, 0.0, 8.0, 0.0, 0.0),
        new Latitude_Band (LETTER_P, 800000.0, 16.0, 8.0, 0.0),
        new Latitude_Band (LETTER_Q, 1700000.0, 24.0, 16.0, 0.0),
        new Latitude_Band (LETTER_R, 2600000.0, 32.0, 24.0, 2000000.0),
        new Latitude_Band (LETTER_S, 3500000.0, 40.0, 32.0, 2000000.0),
        new Latitude_Band (LETTER_T, 4400000.0, 48.0, 40.0, 4000000.0),
        new Latitude_Band (LETTER_U, 5300000.0, 56.0, 48.0, 4000000.0),
        new Latitude_Band (LETTER_V, 6200000.0, 64.0, 56.0, 6000000.0),
        new Latitude_Band (LETTER_W, 7000000.0, 72.0, 64.0, 6000000.0),
        new Latitude_Band (LETTER_X, 7900000.0, 84.5, 72.0, 6000000.0)
    };

    private static class UPS_Constant
    {
        int letter;            /* letter representing latitude band    */
        int ltr2_low_value;    /* 2nd letter range - low number        */
        int ltr2_high_value;   /* 2nd letter range - high number       */
        int ltr3_high_value;   /* 3rd letter range - high number (UPS) */
        double false_easting;  /* False easting based on 2nd letter    */
        double false_northing; /* False northing based on 3rd letter   */

        private UPS_Constant
        (
            int    iLetter,
            int    iLetter2_low_value,
            int    iLetter2_high_value,
            int    iLetter3_high_value,
            double FalseEasting,
            double FalseNorthing
        )
        {
            letter = iLetter;
            ltr2_low_value = iLetter2_low_value;
            ltr2_high_value = iLetter2_high_value;
            ltr3_high_value = iLetter3_high_value;
            false_easting = FalseEasting;
            false_northing = FalseNorthing;
        }
    }

    private static UPS_Constant[] UPS_Constant_Table =  new UPS_Constant[]
    {
        new UPS_Constant (LETTER_A, LETTER_J, LETTER_Z, LETTER_Z, 800000.0, 800000.0),
        new UPS_Constant (LETTER_B, LETTER_A, LETTER_R, LETTER_Z, 2000000.0, 800000.0),
        new UPS_Constant (LETTER_Y, LETTER_J, LETTER_Z, LETTER_P, 800000.0, 1300000.0),
        new UPS_Constant (LETTER_Z, LETTER_A, LETTER_J, LETTER_P, 2000000.0, 1300000.0)
    };

    // Used with Get_Grid_Values()
    private class GridValues
    {
        int    ltr2_low_value;
        int    ltr2_high_value;
        double pattern_offset;
    }

    // Used with Convert_MGRS_To_UPS()
    private class UPSComponents
    {
        char   Hemisphere;
        double Easting;
        double Northing;
    }

    // Used with Break_MGRS_String()
    private class MGRSComponents
    {
        int    Zone;
        int[]  Letters = new int[MGRS_LETTERS];
        double Easting;
        double Northing;
        int    Precision;
    }

    private class UTMComponents
    {
        int    Zone;
        char   Hemisphere;
        double Easting;
        double Northing;
    }

    // Methods:

    /*
     * The method Get_Latitude_Band_Min_Northing receives a latitude band letter
     * and uses the Latitude_Band_Table to determine the minimum northing and
     * northing offset for that latitude band letter.
     *
     *   letter        : Latitude band letter             (input)
     *
     */
    // The return type double [] represent "min_northing" and "northing_offset" in that order.
    private double[] Get_Latitude_Band_Min_Northing (int letter) throws SrmException
    {
        double[] ret = new double[2];

        if ((letter >= LETTER_C) && (letter <= LETTER_H))
        {
            ret[0] = Latitude_Band_Table[letter - 2].min_northing;
            ret[1] = Latitude_Band_Table[letter - 2].northing_offset;
        }
        else if ((letter >= LETTER_J) && (letter <= LETTER_N))
        {
            ret[0] = Latitude_Band_Table[letter - 3].min_northing;
            ret[1] = Latitude_Band_Table[letter - 3].northing_offset;
        }
        else if ((letter >= LETTER_P) && (letter <= LETTER_X))
        {
            ret[0] = Latitude_Band_Table[letter - 4].min_northing;
            ret[1] = Latitude_Band_Table[letter - 4].northing_offset;
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT, "MGRS_STRING_ERROR");
        }
        return ret;
    }

    /*
     * The method Get_Latitude_Range receives a latitude band letter
     * and uses the Latitude_Band_Table to determine the latitude band
     * boundaries for that latitude band letter.
     *
     *   letter   : Latitude band letter                        (input)
     */
    // The return type double [] represent "north" and "south" in that order.
    private double[] Get_Latitude_Range(int letter) throws SrmException
    {
        double[] ret = new double[2];

        if ((letter >= LETTER_C) && (letter <= LETTER_H))
        {
            ret[0] = Latitude_Band_Table[letter - 2].north * DEG_TO_RAD;
            ret[1] = Latitude_Band_Table[letter - 2].south * DEG_TO_RAD;
        }
        else if ((letter >= LETTER_J) && (letter <= LETTER_N))
        {
            ret[0] = Latitude_Band_Table[letter - 3].north * DEG_TO_RAD;
            ret[1] = Latitude_Band_Table[letter - 3].south * DEG_TO_RAD;
        }
        else if ((letter >= LETTER_P) && (letter <= LETTER_X))
        {
            ret[0] = Latitude_Band_Table[letter - 4].north * DEG_TO_RAD;
            ret[1] = Latitude_Band_Table[letter - 4].south * DEG_TO_RAD;
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT, "MGRS_STRING_ERROR");
        }
        return ret;
    }

    // Constructor (inputs already checked by caller)
    protected MGRS (String Ellipsoid_Code, BaseSRF_3D srf) throws SrmException
    {
        MGRS_Ellipsoid_Code = Ellipsoid_Code;
        MGRS_srf            = srf;

        SRM_RD_Code rdCode = OrmDataSet.getElem(srf.getOrm())._rd_code;
        RdDataSet   rdData = RdDataSet.getElem(rdCode);

        // the MGRS routines received from GEOTRANS only handles A > 0.0 and
        // F_inv > 250 and F_inv < 350
        if (rdData._inv_F < 250.0 && rdData._inv_F > 350.0)
        {
            throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                   "MGRS: INV_F<250.0 or INV_F >350");
        }
    }

    /*
     * The method Get_Latitude_Letter receives a latitude value
     * and uses the Latitude_Band_Table to determine the latitude band
     * letter for that latitude.
     *
     *   latitude   : Latitude              (input)
     */
    protected int Get_Latitude_Letter(final double latitude) throws SrmException
    {
        double lat_deg = latitude * RAD_TO_DEG;
        final double EIGHTY_DEG_RAD = 80.0 * DEG_TO_RAD;
        final double EIGHT_DEG_RAD = 8.0 * DEG_TO_RAD;

        int letter;
        if (lat_deg >= 72. && lat_deg < 84.5)
        {
            letter = LETTER_X;
        }
        // DS changed the lower limit from >-80.5 to >=-80.0
        // to avoid creating negative array index "temp" below.
        else if (lat_deg >= -80.0 && lat_deg < 72)
        {
            double temp =
                    ((latitude + EIGHTY_DEG_RAD) / EIGHT_DEG_RAD) + 1.0e-12;
            letter = Latitude_Band_Table[(int)temp].letter;
        }
        else
        {
            throw new SrmException(SrmException._INVALID_INPUT,
                      "MGRS.Get_Latitude_Letter(): Invalid latitude");
        }
        return letter;
    }

    /*
     * The method Check_Zone receives an MGRS coordinate string.
     * If a zone is given, TRUE is returned. Otherwise, FALSE
     * is returned.
     *
     *   MGRS           : MGRS coordinate string        (input)
     */
     private boolean Check_Zone(String strMGRS) throws SrmException
     {
        int i = 0;
        int j = 0;
        int num_digits = 0;

        /* skip any leading blanks */
        while (strMGRS.charAt(i) == ' ')
            i++;

        j = i;
        while (Character.isDigit(strMGRS.charAt(i)))
            i++;

        num_digits = i - j;

        if (num_digits <= 2)
            if (num_digits > 0)
                return true;
            else
                return false;
        else
            throw new SrmException(SrmException._INVALID_INPUT, "MGRS.Check_Zone(): invalid input string");
    }

    /*
     * The method Round_MGRS rounds the input value to the
     * nearest integer, using the standard engineering rule.
     * The rounded integer value is then returned.
     *
     *   value           : Value to be rounded  (input)
     */
    private int Round_MGRS (double value)
    {
        // ssf, what is the equivalent to modf()?
        //                double ivalue;
        //                long ival;
        //                double fraction = modf (value, ivalue);
        //                ival = (long)(ivalue);
        //                if ((fraction > 0.5) || ((fraction == 0.5) && (ival % 2 == 1)))
        //                        ival++;
        //                return (ival);

        // ssf, Can't use Math.round() because it's not an exact mimic since
        // the result of Round_MGRS(6.5) = 6, while Round_MGRS(3.5) = 4
        // So, I chose to do this by hand myself but there could be some
        // precision loss in the computation of "fraction = value - ival"
        int ival = (int)value;
        double fraction = value - ival;
        if ((fraction > 0.5) || ((fraction == 0.5) && (ival % 2 == 1)))
            ival++;
        return (ival);
    }

    /*
     * The method Make_MGRS_String constructs an MGRS string
     * from its component parts.
     *
     *   Zone           : UTM Zone                        (input)
     *   Letters        : MGRS coordinate string letters  (input)
     *   Easting        : Easting value                   (input)
     *   Northing       : Northing value                  (input)
     *   Precision      : Precision level of MGRS string  (input)
     */
    private String Make_MGRS_String
    (
        int         Zone,
        final int[] Letters,
        double      Easting,
        double      Northing,
        int         Precision
    )
    {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String strMGRS = new String();

        if (Zone > 0)
            // add a "zero" digit if only one digit for zone (zone = 0~9)
            if (Zone > 9)
                strMGRS += Zone;
            else
                strMGRS = "0" + Zone;
        else
            strMGRS = strMGRS + "  ";  // 2 spaces

        for (int jj = 0; jj < 3; jj++)
            strMGRS = strMGRS + alphabet.charAt(Letters[jj]);

        double divisor = Math.pow (10.0, (5. - Precision));
        Easting = Easting % 100000.0;
        if (Easting >= 99999.5)
            Easting = 99999.0;
        int east = (int)(Easting / divisor);

        String east_str = "0000";
        east_str += Integer.toString(east);
        strMGRS += east_str.substring(east_str.length()-Precision, east_str.length());

        Northing = Northing % 100000.0;
        if (Northing >= 99999.5)
            Northing = 99999.0;
        int north = (int)(Northing / divisor);

        String north_str = "0000";
        north_str += Integer.toString(north);
        strMGRS += north_str.substring(north_str.length()-Precision, north_str.length());

        return strMGRS;
    }

    /*
     * The method Break_MGRS_String breaks down an MGRS
     * coordinate string into its component parts.
     *
     *   MGRS           : MGRS coordinate string          (input)
     *   MGRSComponents : with member data                (output)
     *     Zone         : UTM Zone
     *     Letters      : MGRS coordinate string letters
     *     Easting      : Easting value
     *     Northing     : Northing value
     *     Precision    : Precision level of MGRS string
     */
    private MGRSComponents Break_MGRS_String (final String MGRS) throws SrmException
    {
        int num_digits = 0;
        int num_letters = 0;
        int i = 0;

        MGRSComponents Comps = new MGRSComponents();

        // Skip any leading blanks
        String iMGRS = MGRS.trim();

        while (Character.isDigit(iMGRS.charAt(num_digits)))
            num_digits++;

        if (num_digits <= 2)
            if (num_digits > 0)
            {
                /* get zone */
                Comps.Zone = Integer.parseInt(iMGRS.substring(i, i+2));

                if ((Comps.Zone < 1) || (Comps.Zone > 60))
                    throw new SrmException (SrmException._INVALID_INPUT, "MGRS.Break_MGRS_String():  Invalid zone");
            }
            else
                Comps.Zone = 0;
        else
            throw new SrmException (SrmException._INVALID_INPUT, "MGRS.Break_MGRS_String():  Invalid number of digits in MGRS string");

        i = num_digits;

        while (i < iMGRS.length() && Character.isLetter(iMGRS.charAt(i)))
            i++;

        num_letters = i - num_digits;

        if (num_letters == 3)
        {
            Comps.Letters[0] = (Character.toUpperCase(iMGRS.charAt(i-3)) - (int)'A');
            if ((Comps.Letters[0] == LETTER_I) || (Comps.Letters[0] == LETTER_O))
                throw new SrmException (SrmException._INACTIONABLE, "MGRS.Break_MGRS_String():  MGRS_STRING_ERROR");
            Comps.Letters[1] = (Character.toUpperCase(iMGRS.charAt(i-2)) - (int)'A');
            if ((Comps.Letters[1] == LETTER_I) || (Comps.Letters[1] == LETTER_O))
                throw new SrmException (SrmException._INACTIONABLE, "MGRS.Break_MGRS_String():  MGRS_STRING_ERROR");
            Comps.Letters[2] = (Character.toUpperCase(iMGRS.charAt(i-1)) - (int)'A');
            if ((Comps.Letters[2] == LETTER_I) || (Comps.Letters[2] == LETTER_O))
                throw new SrmException (SrmException._INACTIONABLE, "MGRS.Break_MGRS_String():  MGRS_STRING_ERROR");
        }
        else
            throw new SrmException (SrmException._INVALID_INPUT, "MGRS.Break_MGRS_String():  Invalid number of letters in MGRS string");

//      j = i;

//      while (i < iMGRS.length())
//          i++;

        num_digits = iMGRS.length() - i;

        if ((num_digits <= 10) && (num_digits % 2 == 0))
        {
            Comps.Precision = num_digits / 2;

            if (Comps.Precision > 0)
            {
                int east = Integer.parseInt (iMGRS.substring(i, i+Comps.Precision));
                int north = Integer.parseInt (iMGRS.substring(i+Comps.Precision, i+2*Comps.Precision));
                double multiplier = Math.pow (10.0, 5 - Comps.Precision);
                Comps.Easting  = east  * multiplier;
                Comps.Northing = north * multiplier;
            }
            else
            {
                Comps.Easting = 0.0;
                Comps.Northing = 0.0;
            }
            return Comps;
        }
        else
            throw new SrmException (SrmException._INVALID_INPUT, "MGRS.Break_MGRS_String():  Invalid number of digits in MGRS string");
    }


    /*
     * The method getGridValues sets the letter range used for
     * the 2nd letter in the MGRS coordinate string, based on the set
     * number of the utm zone. It also sets the pattern offset using a
     * value of A for the second letter of the grid square, based on
     * the grid pattern and set number of the utm zone.
     *
     *    zone            : Zone number             (input)
     *    GridValues      : return value containing (output)
     *      ltr2_low_value  : 2nd letter low number
     *      ltr2_high_value : 2nd letter high number
     *      pattern_offset  : Pattern offset
     */
    private GridValues Get_Grid_Values (int zone)
    {
        int     set_number; /* Set number (1-6) based on UTM zone number */
        boolean aa_pattern; /* Pattern based on ellipsoid code */

        set_number = zone % 6;

        if (set_number == 0)
            set_number = 6;

        if (MGRS_Ellipsoid_Code.equals (CLARKE_1866) ||
            MGRS_Ellipsoid_Code.equals (CLARKE_1880) ||
            MGRS_Ellipsoid_Code.equals (BESSEL_1841) ||
            MGRS_Ellipsoid_Code.equals (BESSEL_1841_NAMIBIA))
            aa_pattern = false;
        else
            aa_pattern = true;

        // ssf, The last 3 output parameters became rtn-vals via this new class
        GridValues gv = new GridValues();

        if ((set_number == 1) || (set_number == 4))
        {
            gv.ltr2_low_value = LETTER_A;
            gv.ltr2_high_value = LETTER_H;
        }
        else if ((set_number == 2) || (set_number == 5))
        {
            gv.ltr2_low_value = LETTER_J;
            gv.ltr2_high_value = LETTER_R;
        }
        else if ((set_number == 3) || (set_number == 6))
        {
            gv.ltr2_low_value = LETTER_S;
            gv.ltr2_high_value = LETTER_Z;
        }

        /* False northing at A for second letter of grid square */
        if (aa_pattern)
        {
            if ((set_number % 2) ==  0)
                gv.pattern_offset = 500000.0;
            else
                gv.pattern_offset = 0.0;
        }
        else
        {
            if ((set_number % 2) == 0)
                gv.pattern_offset = 1500000.0;
            else
                gv.pattern_offset = 1000000.0;
        }
        return gv;
    }


    /*
     * The method UTM_To_MGRS calculates an MGRS coordinate string
     * based on the zone, latitude, easting and northing.
     *
     *    Zone      : Zone number             (input)
     *    Hemisphere: Hemisphere              (input)
     *    Longitude : Longitude in radians    (input)
     *    Latitude  : Latitude in radians     (input)
     *    Easting   : Easting                 (input)
     *    Northing  : Northing                (input)
     *    Precision : Precision               (input)
     *    MGRS      : MGRS coordinate string  (output)
     */
    private String UTM_To_MGRS (
                int Zone,
                char Hemisphere,
                double Longitude,
                double Latitude,
                double Easting,
                double Northing,
                int Precision) throws SrmException
    {
        double grid_easting;        /* Easting used to derive 2nd letter of MGRS   */
        double grid_northing;       /* Northing used to derive 3rd letter of MGRS  */
        int[] letters = new int[MGRS_LETTERS];  /* Number location of 3 letters in alphabet */
        double divisor;
        double rounded_easting;

        divisor = Math.pow (10.0, (5 - Precision));
        rounded_easting = Round_MGRS (Easting/divisor) * divisor;

        boolean do_special_cases = false;

        // Special check for rounding to (truncated) eastern edge of zone 31V
        if ((Zone == 31) &&
            (((Latitude >= 56.0 * DEG_TO_RAD) && (Latitude < 64.0 * DEG_TO_RAD)) &&
             ((Longitude >= 3.0 * DEG_TO_RAD) || (rounded_easting >= 500000.0))))
        {
            Zone = 32;
            do_special_cases = true;
        }
        else if ((Latitude > 72.0  * DEG_TO_RAD) &&
                 (Longitude >= 0.0) && (Longitude <= 39.0 * DEG_TO_RAD))
        {
            if ((Longitude >= 0.0) && (Longitude < 9.0 * DEG_TO_RAD))
                Zone=31;
            else if ((Longitude >= 9.0 * DEG_TO_RAD) && (Longitude < 21.0 * DEG_TO_RAD))
                Zone=33;
            else if ((Longitude >= 21.0 * DEG_TO_RAD) && (Longitude < 33.0 * DEG_TO_RAD))
                Zone=35;
            else if ((Longitude >= 33.0 * DEG_TO_RAD) && (Longitude < 39.0 * DEG_TO_RAD))
                Zone=37;
            do_special_cases = true;
        }

        if (do_special_cases)
        {
            /* Reconvert to UTM for special cases */
            if (MGRS_srf._internalSRFs == null)
                MGRS_srf._internalSRFs = new HashMap<String, BaseSRF>();

            SRF_Celestiodetic tempCdSrf = (SRF_Celestiodetic)MGRS_srf._internalSRFs.get("Interim_Cd");

            // create an intetim Celestiodetic SRF if not already created
            if (tempCdSrf == null) {
                tempCdSrf = new SRF_Celestiodetic(MGRS_srf.getOrm(), MGRS_srf.getRt());

            // cache the interim celestiodetic in the (source) SRF for
            // this coordinate.
            MGRS_srf._internalSRFs.put("Interim_Cd", tempCdSrf);
        }
        SRF_TransverseMercator tempUtmSrf;

        tempUtmSrf = (SRF_TransverseMercator)MGRS_srf._internalSRFs.get("Interim_Utm"+Zone);

        // create an intetim UTM SRF if not already created
        if (tempUtmSrf == null)
        {
            tempUtmSrf = (SRF_TransverseMercator) BaseSRF.createSRFSetMember(
                            SRM_SRFS_Code.SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR,
                            SRM_SRFSM_UTM_Code.getEnum(Zone),
                            MGRS_srf.getOrm(),
                            MGRS_srf.getRt());

            // cache the interim celestiodetic in the (source) SRF for
            // this coordinate.
            MGRS_srf._internalSRFs.put("Interim_Utm"+Zone, tempUtmSrf);
        }
        double[] tempCdCoord = { Longitude, Latitude, 0.0 };
        double[] tempUtmCoord = {0.0, 0.0, 0.0};

        // convert from UTM to CD
        OpManager.instance().computeAsArray(tempCdSrf,
                        tempUtmSrf,
                        tempCdCoord,
                        tempUtmCoord,
                        null);

        Easting = Round_MGRS (tempUtmCoord[0]/divisor) * divisor;
        Northing = tempUtmCoord[1];
    }
         else
                Easting = rounded_easting;

        /* Round northing values */
        Northing = Round_MGRS (Northing / divisor) * divisor;

        if (Latitude <= 0.0 && Northing == 1.0e7)
        {
            Latitude = 0.0;
            Northing = 0.0;
        }
        GridValues gv = Get_Grid_Values(Zone);

        try
        {
            letters[0] = Get_Latitude_Letter(Latitude);
            grid_northing = Northing;

            while (grid_northing >= TWOMIL)
                grid_northing = grid_northing - TWOMIL;

            grid_northing = grid_northing + gv.pattern_offset;

            if (grid_northing >= TWOMIL)
                grid_northing = grid_northing - TWOMIL;

            letters[2] = (int)(grid_northing / ONEHT);
            if (letters[2] > LETTER_H)
                letters[2] = letters[2] + 1;

            if (letters[2] > LETTER_N)
                letters[2] = letters[2] + 1;

            grid_easting = Easting;
            if (((letters[0] == LETTER_V) && (Zone == 31)) && (grid_easting == 500000.0))
                grid_easting = grid_easting - 1.0; // Subtract 1 meter

             letters[1] = gv.ltr2_low_value + ((int)(grid_easting / ONEHT) - 1);
            if ((gv.ltr2_low_value == LETTER_J) && (letters[1] > LETTER_N))
                letters[1] = letters[1] + 1;

            return Make_MGRS_String (Zone, letters, grid_easting, Northing, Precision);
        }
        catch (SrmException se)
        {
            throw new SrmException (SrmException._INVALID_INPUT, "MGRS.UTM_To_MGRS(): Invalid latitude");
        }
    }

    /*
     * The method SET_MGRS_PARAMETERS receives the ellipsoid parameters and sets
     * the corresponding state variables. If any errors occur, the error code(s)
     * are returned by the method, otherwise MGRS_NO_ERROR is returned.
     *
     *   a                : Semi-major axis of ellipsoid in meters  (input)
     *   f                : Flattening of ellipsoid                 (input)
     *   Ellipsoid_Code   : 2-letter code for ellipsoid             (input)
     */
    // No longer needed as replaced by the MGRS constructor
//    protected int Set_MGRS_Parameters
//    (double a, double f, final String Ellipsoid_Code)
//    {
//        double inv_f = 1 / f;
//        int Error_Code = MGRS_NO_ERROR;
//
//        /* Semi-major axis must be greater than zero */
//        if (a <= 0.0)
//            Error_Code |= MGRS_A_ERROR;
//
//        /* Inverse flattening must be between 250 and 350 */
//        if ((inv_f < 250) || (inv_f > 350))
//            Error_Code |= MGRS_INV_F_ERROR;
//
//        if (Error_Code == MGRS_NO_ERROR)
//        {
//            MGRS_a = a;
//            MGRS_f = f;
//            // ssf, This should work but I'm a little skeptical
//            // ds. This is fine.
//            MGRS_Ellipsoid_Code = Ellipsoid_Code;
//        }
//        return (Error_Code);
//    }

    /*
     * The method Get_MGRS_Parameters returns the current ellipsoid
     * parameters.
     *
     *  a                : Semi-major axis of ellipsoid, in meters (output)
     *  f                : Flattening of ellipsoid                 (output)
     *  Ellipsoid_Code   : 2-letter code for ellipsoid             (output)
     */
    // ssf, This method is not used anywhere, so it's nort ported for now
//  private void Get_MGRS_Parameters (double a, double f, char[] Ellipsoid_Code)
//  {
//  ssf, Needs work
//  a = MGRS_a;
//  f = MGRS_f;
//  strcpy (Ellipsoid_Code, MGRS_Ellipsoid_Code);
//  }

    /*
     * The method Convert_Geodetic_To_MGRS converts Geodetic (latitude and
     * longitude) coordinates to an MGRS coordinate string, according to the
     * current ellipsoid parameters.  If any errors occur, the error code(s)
     * are returned by the method, otherwise MGRS_NO_ERROR is returned.
     *
     *    Latitude   : Latitude in radians              (input)
     *    Longitude  : Longitude in radians             (input)
     *    Precision  : Precision level of MGRS string   (input)
     *
     */
    protected String Convert_Geodetic_To_MGRS
    (double Latitude, double Longitude, int Precision) throws SrmException
    {
            int zone;

            // DS re-visit later for accuracy
            if (Longitude >= 0.0)
                zone = (int)Math.floor(Longitude/PI_OVER_30) + 31;
            else
                zone = (int)Math.floor((Longitude+PI)/PI_OVER_30) + 1;

            // ssf, These next 3 vars are temporarily set to dummy vals
            // until Convert_Geodetic_To_UPS() call below is UNcommented
            char hemisphere;
            double easting = 0.0;
            double northing = 0.0;

            SRF_Celestiodetic tempCdSrf;

            if (Latitude>=0.0)
                hemisphere = 'N';
            else
                hemisphere = 'S';

             String strMGRS = "ERROR";

            if ((Latitude < -PI_OVER_2) || (Latitude > PI_OVER_2)) /* Latitude out of range */
                throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_Geodetic_To_MGRS():  MGRS_LAT_ERROR");
            if ((Longitude < -PI) || (Longitude > (2*PI)))
                throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_Geodetic_To_MGRS():  MGRS_LON_ERROR");
            if ((Precision < 0) || (Precision > MAX_PRECISION))
                throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_Geodetic_To_MGRS():  MGRS_PRECISION_ERROR");

            // This is the UPS case
            if ((Latitude < MIN_UTM_LAT) || (Latitude > MAX_UTM_LAT))
            {
                SRF_PolarStereographic tempUpsSrf;
                int srm_ups_zone;

                if (MGRS_srf._internalSRFs == null)
                    MGRS_srf._internalSRFs = new HashMap<String, BaseSRF>();

                tempCdSrf = (SRF_Celestiodetic)MGRS_srf._internalSRFs.get("Interim_Cd");

                // create an intetim Celestiodetic SRF if not already created
                if (tempCdSrf == null)
                {
                    tempCdSrf = new SRF_Celestiodetic(MGRS_srf.getOrm(), MGRS_srf.getRt());

                    // cache the interim celestiodetic in the (source) SRF for
                    // this coordinate.
                    MGRS_srf._internalSRFs.put("Interim_Cd", tempCdSrf);
                }

                if (Latitude >= 0.0) // for northern hemisphere
                    srm_ups_zone=1;
                else // for southern hemisphere
                    srm_ups_zone=2;

                if (MGRS_srf._internalSRFs == null)
                    MGRS_srf._internalSRFs = new HashMap<String, BaseSRF>();

                tempUpsSrf = (SRF_PolarStereographic)MGRS_srf._internalSRFs.get("Interim_Ups"+srm_ups_zone);

                // create an intetim UPS SRF if not already created
                if (tempUpsSrf == null)
                {
                    tempUpsSrf = (SRF_PolarStereographic) BaseSRF.createSRFSetMember(
                                 SRM_SRFS_Code.SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC,
                                 SRM_SRFSM_UPS_Code.getEnum(srm_ups_zone),
                                 MGRS_srf.getOrm(),
                                 MGRS_srf.getRt());

                    // cache the interim celestiodetic in the (source) SRF for
                    // this coordinate.
                    MGRS_srf._internalSRFs.put("Interim_Ups"+srm_ups_zone, tempUpsSrf);
                }
                double[] tempCdCoord = { Longitude, Latitude, 0.0 };
                double[] tempUpsCoord = {0.0, 0.0, 0.0};

                // convert from UTM to CD
                OpManager.instance().computeAsArray(tempCdSrf,
                                tempUpsSrf,
                                tempCdCoord,
                                tempUpsCoord,
                                null);

                easting = tempUpsCoord[0];
                northing = tempUpsCoord[1];

                try
                {
                    strMGRS = Convert_UPS_To_MGRS (hemisphere, easting, northing, Precision);
                }
                catch (SrmException se)
                {
                    // ssf, Need better error message
                    throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_Geodetic_To_MGRS():  error");
                }
            }
            else // This is the UTM case
            {
                int srm_utm_zone = zone;

                // the srm_utm_zone ranges from 1 to 120
                if (hemisphere == 'S')
                    srm_utm_zone = srm_utm_zone + 60;

                if (MGRS_srf._internalSRFs == null)
                    MGRS_srf._internalSRFs = new HashMap<String, BaseSRF>();

                tempCdSrf = (SRF_Celestiodetic)MGRS_srf._internalSRFs.get("Interim_Cd");

                // create an intetim Celestiodetic SRF if not already created
                if (tempCdSrf == null) {
                    tempCdSrf = new SRF_Celestiodetic(MGRS_srf.getOrm(), MGRS_srf.getRt());

                // cache the interim celestiodetic in the (source) SRF for
                // this coordinate.
                MGRS_srf._internalSRFs.put("Interim_Cd", tempCdSrf);
            }

            SRF_TransverseMercator tempUtmSrf;

                tempUtmSrf = (SRF_TransverseMercator)MGRS_srf._internalSRFs.get("Interim_Utm"+srm_utm_zone);

                // create an intetim UTM SRF if not already created
                if (tempUtmSrf == null)
                {
                    tempUtmSrf = (SRF_TransverseMercator) BaseSRF.createSRFSetMember(
                                 SRM_SRFS_Code.SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR,
                                 SRM_SRFSM_UTM_Code.getEnum(srm_utm_zone),
                                 MGRS_srf.getOrm(),
                                 MGRS_srf.getRt());

                    // cache the interim celestiodetic in the (source) SRF for
                    // this coordinate.
                    MGRS_srf._internalSRFs.put("Interim_Utm"+srm_utm_zone, tempUtmSrf);
                }
                double[] tempCdCoord = { Longitude, Latitude, 0.0 };
                double[] tempUtmCoord = {0.0, 0.0, 0.0};

                // convert from UTM to CD
                OpManager.instance().computeAsArray(tempCdSrf,
                                tempUtmSrf,
                                tempCdCoord,
                                tempUtmCoord,
                                null);

                easting = tempUtmCoord[0];
                northing = tempUtmCoord[1];

                try
                {
                    strMGRS = Convert_UTM_To_MGRS (
                                    zone, hemisphere,
                                    Longitude, Latitude,
                                    easting, northing,
                                    Precision);
                }
                catch (SrmException se)
                {
                    throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_Geodetic_To_MGRS():  Unsuccessful MGRS computation from interim UTM coord.");
                }
        }
        return strMGRS;
    }


    /*
     * The method Convert_MGRS_To_Geodetic converts an MGRS coordinate string
     * to Geodetic (latitude and longitude) coordinates
     * according to the current ellipsoid parameters.  If any errors occur,
     * the error code(s) are returned by the method, otherwise UTM_NO_ERROR
     * is returned.
     *
     *    MGRS       : MGRS coordinate string           (input)
     *    Latitude   : Latitude in radians (index 0)    (output)
     *    Longitude  : Longitude in radians (index 1)   (output)
     *
     */
    protected double[] Convert_MGRS_To_Geodetic (final String strMGRS) throws SrmException
    {
        double Latitude = 0.0;
        double Longitude = 0.0;

        try
        {
            boolean zone_exists = Check_Zone(strMGRS);

            if (zone_exists)
            {
                 UTMComponents utm_coord = Convert_MGRS_To_UTM(strMGRS);

                // UTM to geodetic to be done via native SRM
                SRF_TransverseMercator tempUtmSrf;
                SRF_Celestiodetic tempCdSrf;

                if (MGRS_srf._internalSRFs == null)
                    MGRS_srf._internalSRFs = new HashMap<String, BaseSRF>();

                tempCdSrf = (SRF_Celestiodetic)MGRS_srf._internalSRFs.get("Interim_Cd");

                // create an intetim Celestiodetic SRF if not already created
                if (tempCdSrf == null)
                {
                    tempCdSrf = new SRF_Celestiodetic(MGRS_srf.getOrm(), MGRS_srf.getRt());

                    // cache the interim celestiodetic in the (source) SRF for
                    // this coordinate.
                    MGRS_srf._internalSRFs.put("Interim_Cd", tempCdSrf);
                }
                int srm_utm_zone = (int)utm_coord.Zone;

                if (utm_coord.Hemisphere == 'S')
                    srm_utm_zone = srm_utm_zone + 60;

                tempUtmSrf = (SRF_TransverseMercator)MGRS_srf._internalSRFs.get("Interim_Utm"+srm_utm_zone);

                // create an intetim UTM SRF if not already created
                if (tempUtmSrf == null)
                {
                    tempUtmSrf = (SRF_TransverseMercator) BaseSRF.createSRFSetMember(
                                    SRM_SRFS_Code.SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR,
                                    SRM_SRFSM_UTM_Code.getEnum(srm_utm_zone),
                                MGRS_srf.getOrm(),
                                MGRS_srf.getRt());

                    // cache the interim celestiodetic in the (source) SRF for
                    // this coordinate.
                    MGRS_srf._internalSRFs.put("Interim_Utm"+srm_utm_zone, tempUtmSrf);
                }
                double[] tempCdCoord = { 0.0, 0.0, 0.0 };
                double[] tempUtmCoord = { utm_coord.Easting, utm_coord.Northing, 0.0};

                // convert from UTM to CD
                OpManager.instance().computeAsArray(tempUtmSrf,
                                tempCdSrf,
                                tempUtmCoord,
                                tempCdCoord,
                                null);

                Longitude = tempCdCoord[0];
                Latitude = tempCdCoord[1];
            }
            else
            {
                UPSComponents ups_coord = Convert_MGRS_To_UPS (strMGRS);

                // ssf, UPS to geodetic to be done via native SRM
                SRF_PolarStereographic tempUpsSrf;
                SRF_Celestiodetic tempCdSrf;

                if (MGRS_srf._internalSRFs == null)
                        MGRS_srf._internalSRFs = new HashMap<String, BaseSRF>();

                tempCdSrf = (SRF_Celestiodetic)MGRS_srf._internalSRFs.get("Interim_Cd");

                // create an intetim Celestiodetic SRF if not already created
                if (tempCdSrf == null)
                {
                    tempCdSrf = new SRF_Celestiodetic(MGRS_srf.getOrm(), MGRS_srf.getRt());

                    // cache the interim celestiodetic in the (source) SRF for
                    // this coordinate.
                    MGRS_srf._internalSRFs.put("Interim_Cd", tempCdSrf);
                }
                int srm_ups_zone = 1; // defaulted to northern hemisphere

                if (ups_coord.Hemisphere == 'S')
                    srm_ups_zone = 2;

                tempUpsSrf = (SRF_PolarStereographic)MGRS_srf._internalSRFs.get("Interim_Ups"+srm_ups_zone);

                // create an intetim UPS SRF if not already created
                if (tempUpsSrf == null)
                {
                    tempUpsSrf = (SRF_PolarStereographic) BaseSRF.createSRFSetMember(
                                    SRM_SRFS_Code.SRFSCOD_UNIVERSAL_POLAR_STEREOGRAPHIC,
                                    SRM_SRFSM_UPS_Code.getEnum(srm_ups_zone),
                                MGRS_srf.getOrm(),
                                MGRS_srf.getRt());

                    // cache the interim celestiodetic in the (source) SRF for
                    // this coordinate.
                    MGRS_srf._internalSRFs.put("Interim_Ups"+srm_ups_zone, tempUpsSrf);
                }
                double[] tempCdCoord = { 0.0, 0.0, 0.0 };
                double[] tempUpsCoord = { ups_coord.Easting, ups_coord.Northing, 0.0};

                // convert from UTM to CD
                OpManager.instance().computeAsArray(tempUpsSrf,
                                tempCdSrf,
                                tempUpsCoord,
                                tempCdCoord,
                                null);

                Longitude = tempCdCoord[0];
                Latitude = tempCdCoord[1];
            }
            double[] GeoCoords = new double[]{Longitude, Latitude, 0.0};

            return GeoCoords;
        }
        catch (SrmException se)
        {
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_MGRS_To_Geodetic(): Unable to convert");
        }
    }


    /*
     * The method Convert_UTM_To_MGRS converts UTM (zone, easting, and
     * northing) coordinates to an MGRS coordinate string, according to the
     * current ellipsoid parameters.  If any errors occur, the error code(s)
     * are returned by the method, otherwise MGRS_NO_ERROR is returned.
     *
     *    Zone       : UTM zone                         (input)
     *    Hemisphere : North or South hemisphere        (input)
     *    cd_lon     : CD longitude (rad)               (input)
     *    cd_lat     : CD latitude (rad)                (input)
     *    Easting    : Easting (X) in meters            (input)
     *    Northing   : Northing (Y) in meters           (input)
     *    Precision  : Precision level of MGRS string   (input)
     *    MGRS       : MGRS coordinate string           (output)
     */
    private String Convert_UTM_To_MGRS
    (
        int    Zone,
        char   Hemisphere,
        double cd_lon,
        double cd_lat,
        double Easting,
        double Northing,
        int    Precision
    ) throws SrmException
    {
        if ((Zone < 1) || (Zone > 60))
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_UTM_To_MGRS():  MGRS_ZONE_ERROR");
        if ((Hemisphere != 'S') && (Hemisphere != 'N'))
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_UTM_To_MGRS():  MGRS_HEMISPHERE_ERROR");
        if ((Easting < MIN_EASTING) || (Easting > MAX_EASTING))
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_UTM_To_MGRS():  MGRS_EASTING_ERROR");
        if ((Northing < MIN_NORTHING) || (Northing > MAX_NORTHING))
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_UTM_To_MGRS():  MGRS_NORTHING_ERROR");
        if ((Precision < 0) || (Precision > MAX_PRECISION))
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_UTM_To_MGRS():  MGRS_PRECISION_ERROR");

         return UTM_To_MGRS (
                        Zone, Hemisphere,
                        cd_lon, cd_lat,
                        Easting, Northing,
                        Precision);
    }


    /*
     * The method Convert_MGRS_To_UTM converts an MGRS coordinate string
     * to UTM projection (zone, hemisphere, easting and northing) coordinates
     * according to the current ellipsoid parameters.  If any errors occur,
     * the error code(s) are returned by the function, otherwise UTM_NO_ERROR
     * is returned.
     *
     *    MGRS       : MGRS coordinate string           (input)
     *    UTMComponents: return value contains:         (output)
     *      Zone       : UTM zone
     *      Hemisphere : North or South hemisphere
     *      Easting    : Easting (X) in meters
     *      Northing   : Northing (Y) in meters
     */
    private UTMComponents Convert_MGRS_To_UTM (final String MGRS) throws SrmException
    {
        double grid_easting;        /* Easting for 100,000 meter grid square      */
        double grid_northing;       /* Northing for 100,000 meter grid square     */
        double row_letter_northing = 0.0;
        double latitude = 0.0;
        double divisor = 1.0;
//      int utm_error_code = MGRS_NO_ERROR;
//      int  error_code = MGRS_NO_ERROR;

        MGRSComponents MGRSComps = Break_MGRS_String (MGRS);

        if (MGRSComps.Zone == 0)
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_MGRS_To_UTM():  Invalid zone after breaking MGRS string");

        if ((MGRSComps.Letters[0] == LETTER_X) &&
            ((MGRSComps.Zone == 32) || (MGRSComps.Zone == 34) || (MGRSComps.Zone == 36)))
            throw new SrmException (SrmException._INACTIONABLE, "MGRS.Convert_MGRS_To_UTM():  Invalid zone in MGRS string");

        UTMComponents UTMComps = new UTMComponents();

        if (MGRSComps.Letters[0] < LETTER_N)
            UTMComps.Hemisphere = 'S';
        else
            UTMComps.Hemisphere = 'N';

        UTMComps.Zone = MGRSComps.Zone;

        GridValues gv = Get_Grid_Values (MGRSComps.Zone);

        // Check that the second letter of the MGRS string is
        // within the range of valid second letter values.
        // Also check that the third letter is valid
        if ((MGRSComps.Letters[1] < gv.ltr2_low_value)
         || (MGRSComps.Letters[1] > gv.ltr2_high_value)
         || (MGRSComps.Letters[2] > LETTER_V))
            throw new SrmException (SrmException._INVALID_INPUT, "MGRS.Convert_MGRS_To_UTM():  Invalid range for 2nd and 3rd letters of MGRS string");

        grid_easting = (double)((MGRSComps.Letters[1]) - gv.ltr2_low_value + 1) * ONEHT;
        if ((gv.ltr2_low_value == LETTER_J) && (MGRSComps.Letters[1] > LETTER_O))
            grid_easting -= ONEHT;

        row_letter_northing = (double)(MGRSComps.Letters[2]) * ONEHT;
        if (MGRSComps.Letters[2] > LETTER_O)
            row_letter_northing -= ONEHT;

        if (MGRSComps.Letters[2] > LETTER_I)
            row_letter_northing -= ONEHT;

        if (row_letter_northing >= TWOMIL)
            row_letter_northing -= TWOMIL;

        double[] northing_data;

        try
        {
            northing_data = Get_Latitude_Band_Min_Northing(MGRSComps.Letters[0]);
        }
        catch (SrmException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
                "Internal Error: Convert_MGRS_To_UTM: Get_Latitude_Band_Min_Northing");
        }
        grid_northing = row_letter_northing - gv.pattern_offset;

        if (grid_northing < 0.0)
            grid_northing += TWOMIL;

        grid_northing += northing_data[1];

        if (grid_northing < northing_data[0])
            grid_northing += TWOMIL;

        UTMComps.Easting  = grid_easting  + MGRSComps.Easting;
        UTMComps.Northing = grid_northing + MGRSComps.Northing;

        // check that point is within Zone Letter bounds
        // For the UTM to geodetic conversions below use native SRM
        SRF_TransverseMercator tempUtmSrf;
        SRF_Celestiodetic tempCdSrf;

        int srm_utm_zone = (int)MGRSComps.Zone;

        if (UTMComps.Hemisphere == 'S')
            srm_utm_zone = srm_utm_zone + 60;

        if (MGRS_srf._internalSRFs == null)
            MGRS_srf._internalSRFs = new HashMap<String, BaseSRF>();

        tempCdSrf = (SRF_Celestiodetic)MGRS_srf._internalSRFs.get("Interim_Cd");

        // create an intetim Celestiodetic SRF if not already created
        if (tempCdSrf == null)
        {
            tempCdSrf = new SRF_Celestiodetic(MGRS_srf.getOrm(), MGRS_srf.getRt());

            // cache the interim celestiodetic in the (source) SRF for
            // this coordinate.
            MGRS_srf._internalSRFs.put("Interim_Cd", tempCdSrf);
        }
        tempUtmSrf = (SRF_TransverseMercator)MGRS_srf._internalSRFs.get("Interim_Utm"+srm_utm_zone);

        // create an intetim UTM SRF if not already created
        if (tempUtmSrf == null)
        {
            tempUtmSrf = (SRF_TransverseMercator) BaseSRF.createSRFSetMember(
                         SRM_SRFS_Code.SRFSCOD_UNIVERSAL_TRANSVERSE_MERCATOR,
                            SRM_SRFSM_UTM_Code.getEnum(srm_utm_zone),
                            MGRS_srf.getOrm(),
                            MGRS_srf.getRt());

            // cache the interim celestiodetic in the (source) SRF for
            // this coordinate.
            MGRS_srf._internalSRFs.put("Interim_Utm"+srm_utm_zone, tempUtmSrf);
        }

        double[] tempCdCoord = { 0.0, 0.0, 0.0 };
        double[] tempUtmCoord = { UTMComps.Easting, UTMComps.Northing, 0.0};

        // convert from UTM to CD
        OpManager.instance().computeAsArray(tempUtmSrf,
                        tempCdSrf,
                        tempUtmCoord,
                        tempCdCoord,
                        null);

        latitude = tempCdCoord[1];

        double[] lat_limits;

        divisor = Math.pow (10.0, MGRSComps.Precision);
        // ssf, Change Get_Latitude_Range() to have a class rtn-val,
        // otherwise, last 2 args won't get modified
        // ds. fixed
        try
        {
            lat_limits = Get_Latitude_Range(MGRSComps.Letters[0]);
        }
        catch (SrmException ex)
        {
            throw new SrmException(SrmException._INACTIONABLE,
            "MGRS: Convert_MGRS_To_UTM(): Get_Latitude_Range");
        }

        if (!(((lat_limits[1] - DEG_TO_RAD/divisor) <= latitude) &&
               (latitude <= (lat_limits[0] + DEG_TO_RAD/divisor))))
            throw new SrmException(SrmException._INACTIONABLE,
                "MGRS: Convert_MGRS_To_UTM(): MGRS_LAT_WARNING");

        return UTMComps;
    }


    /*
     *  The method Convert_UPS_To_MGRS converts UPS (hemisphere, easting,
     *  and northing) coordinates to an MGRS coordinate string according to
     *  the current ellipsoid parameters.  If any errors occur, the error
     *  code(s) are returned by the method, otherwise UPS_NO_ERROR is
     *  returned.
     *
     *    Hemisphere    : Hemisphere either 'N' or 'S'     (input)
     *    Easting       : Easting/X in meters              (input)
     *    Northing      : Northing/Y in meters             (input)
     *    Precision     : Precision level of MGRS string   (input)
     *    MGRS          : MGRS coordinate string           (output)
     */
    protected String Convert_UPS_To_MGRS
    (char Hemisphere, double Easting, double Northing, int Precision) throws SrmException
    {
        double false_easting;  /* False easting for 2nd letter  */
        double false_northing; /* False northing for 3rd letter */
        double grid_easting;   /* Easting used to derive 2nd letter of MGRS */
        double grid_northing;  /* Northing used to derive 3rd letter of MGRS */
        int    ltr2_low_value; /* 2nd letter range - low number */
        int[] letters = new int[MGRS_LETTERS];/* Number location of 3 letters in alphabet */
        int index = 0;

        if ((Hemisphere != 'N') && (Hemisphere != 'S'))
            throw new SrmException(SrmException._INACTIONABLE,
                "MGRS::Convert_UPS_To_MGRS(): MGRS_HEMISPHERE_ERROR");
        if ((Easting < MIN_EAST_NORTH) || (Easting > MAX_EAST_NORTH))
            throw new SrmException(SrmException._INACTIONABLE,
                "MGRS::Convert_UPS_To_MGRS(): MGRS_EASTING_ERROR");
        if ((Northing < MIN_EAST_NORTH) || (Northing > MAX_EAST_NORTH))
            throw new SrmException(SrmException._INACTIONABLE,
                "MGRS::Convert_UPS_To_MGRS(): MGRS_NORTHING_ERROR");
        if ((Precision < 0) || (Precision > MAX_PRECISION))
            throw new SrmException(SrmException._INACTIONABLE,
                "MGRS::Convert_UPS_To_MGRS(): MGRS_PRECISION_ERROR");

        double divisor = Math.pow (10.0, (5 - Precision));
        Easting = Round_MGRS (Easting/divisor) * divisor;
        Northing = Round_MGRS (Northing/divisor) * divisor;

        if (Hemisphere == 'N')
        {
            if (Easting >= TWOMIL)
                letters[0] = LETTER_Z;
            else
                letters[0] = LETTER_Y;

            index = letters[0] - 22;
            ltr2_low_value = UPS_Constant_Table[index].ltr2_low_value;
            false_easting = UPS_Constant_Table[index].false_easting;
            false_northing = UPS_Constant_Table[index].false_northing;
        }
        else
        {
            if (Easting >= TWOMIL)
                letters[0] = LETTER_B;
            else
                letters[0] = LETTER_A;

            ltr2_low_value = UPS_Constant_Table[letters[0]].ltr2_low_value;
            false_easting = UPS_Constant_Table[letters[0]].false_easting;
            false_northing = UPS_Constant_Table[letters[0]].false_northing;
        }
        grid_northing = Northing;
        grid_northing = grid_northing - false_northing;

        letters[2] = (int)(grid_northing / ONEHT);

        if (letters[2] > LETTER_H)
            letters[2] = letters[2] + 1;

        if (letters[2] > LETTER_N)
            letters[2] = letters[2] + 1;

        grid_easting = Easting;
        grid_easting = grid_easting - false_easting;

        letters[1] = ltr2_low_value + ((int)(grid_easting / ONEHT));

        if (Easting < TWOMIL)
        {
            if (letters[1] > LETTER_L)
                letters[1] = letters[1] + 3;

            if (letters[1] > LETTER_U)
                letters[1] = letters[1] + 2;
        }
        else
        {
            if (letters[1] > LETTER_C)
                letters[1] = letters[1] + 2;

            if (letters[1] > LETTER_H)
                letters[1] = letters[1] + 1;

            if (letters[1] > LETTER_L)
                letters[1] = letters[1] + 3;
        }
        return Make_MGRS_String (0, letters, Easting, Northing, Precision);
    }


    /*
     *  The function Convert_MGRS_To_UPS converts an MGRS coordinate string
     *  to UPS (hemisphere, easting, and northing) coordinates, according
     *  to the current ellipsoid parameters. If any errors occur, the error
     *  code(s) are returned by the function, otherwide UPS_NO_ERROR is returned.
     *
     *    MGRS          : MGRS coordinate string           (input)
     *    Hemisphere    : Hemisphere either 'N' or 'S'     (output)
     *    Easting       : Easting/X in meters              (output)
     *    Northing      : Northing/Y in meters             (output)
     */
    private UPSComponents Convert_MGRS_To_UPS (final String MGRS) throws SrmException
    {
        int    ltr2_high_value; /* 2nd letter range - high number         */
        int    ltr3_high_value; /* 3rd letter range - high number (UPS)   */
        int    ltr2_low_value;  /* 2nd letter range - low number          */
        double false_easting;   /* False easting for 2nd letter           */
        double false_northing;  /* False northing for 3rd letter          */
        double grid_easting;    /* easting for 100,000 meter grid square  */
        double grid_northing;   /* northing for 100,000 meter grid square */
        int    index = 0;

        UPSComponents UPSComps = new UPSComponents();

        MGRSComponents MGRSComps = new MGRSComponents();

        MGRSComps = Break_MGRS_String (MGRS);

        if (MGRSComps.Zone > 0)
            throw new SrmException (SrmException._INVALID_INPUT, "MGRS.Convert_MGRS_To_UPS():  Invalid zone in MGRS input string");

        if (MGRSComps.Letters[0] >= LETTER_Y)
        {
            UPSComps.Hemisphere = 'N';

            index = MGRSComps.Letters[0] - 22;
            ltr2_low_value = UPS_Constant_Table[index].ltr2_low_value;
            ltr2_high_value = UPS_Constant_Table[index].ltr2_high_value;
            ltr3_high_value = UPS_Constant_Table[index].ltr3_high_value;
            false_easting = UPS_Constant_Table[index].false_easting;
            false_northing = UPS_Constant_Table[index].false_northing;
        }
        else
        {
            UPSComps.Hemisphere = 'S';

            int Let0 = MGRSComps.Letters[0];
            ltr2_low_value = UPS_Constant_Table[Let0].ltr2_low_value;
            ltr2_high_value = UPS_Constant_Table[Let0].ltr2_high_value;
            ltr3_high_value = UPS_Constant_Table[Let0].ltr3_high_value;
            false_easting = UPS_Constant_Table[Let0].false_easting;
            false_northing = UPS_Constant_Table[Let0].false_northing;
        }

        // Check that the second letter of the MGRS string is
        // within the range of valid second letter values.
        // Also check that the third letter is valid
        if ((MGRSComps.Letters[1] < ltr2_low_value) ||
            (MGRSComps.Letters[1] > ltr2_high_value) ||
            ((MGRSComps.Letters[1] == LETTER_D) || (MGRSComps.Letters[1] == LETTER_E) ||
             (MGRSComps.Letters[1] == LETTER_M) || (MGRSComps.Letters[1] == LETTER_N) ||
             (MGRSComps.Letters[1] == LETTER_V) || (MGRSComps.Letters[1] == LETTER_W)) ||
             (MGRSComps.Letters[2] > ltr3_high_value))
            throw new SrmException (SrmException._INVALID_INPUT, "MGRS.Convert_MGRS_To_UPS():  Invalid range for 2nd and 3rd letters of MGRS string");

        grid_northing = (double)MGRSComps.Letters[2] * ONEHT + false_northing;
        if (MGRSComps.Letters[2] > LETTER_I)
            grid_northing = grid_northing - ONEHT;

        if (MGRSComps.Letters[2] > LETTER_O)
            grid_northing = grid_northing - ONEHT;

        grid_easting = (double)((MGRSComps.Letters[1]) - ltr2_low_value) * ONEHT + false_easting;
        if (ltr2_low_value != LETTER_A)
        {
            if (MGRSComps.Letters[1] > LETTER_L)
                grid_easting = grid_easting - 300000.0;

            if (MGRSComps.Letters[1] > LETTER_U)
                grid_easting = grid_easting - 200000.0;
        }
        else
        {
            if (MGRSComps.Letters[1] > LETTER_C)
                grid_easting = grid_easting - 200000.0;

            if (MGRSComps.Letters[1] > LETTER_I)
                grid_easting = grid_easting - ONEHT;

            if (MGRSComps.Letters[1] > LETTER_L)
                grid_easting = grid_easting - 300000.0;
        }
        UPSComps.Easting  = grid_easting  + MGRSComps.Easting;
        UPSComps.Northing = grid_northing + MGRSComps.Northing;

        return UPSComps;
    }
}
