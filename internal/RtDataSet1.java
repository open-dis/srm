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
package SRM;

class RtDataSet1 extends RtDataSet
{
    private RtDataSet1(String       label,
                       String       description,
                       SRM_ORM_Code orm_code,
                       SRM_RT_Code  rt_code,
                       double       delta_x,
                       double       delta_y,
                       double       delta_z,
                       double       omega_1,
                       double       omega_2,
                       double       omega_3,
                       double       delta_scale,
                       double       region_ll_lat,
                       double       region_ll_long,
                       double       region_ur_lat,
                       double       region_ur_long )
    {
        super(label, description, orm_code,
              rt_code, delta_x, delta_y, delta_z,
              omega_1, omega_2, omega_3, delta_scale,
              region_ll_lat, region_ll_long, region_ur_lat, region_ur_long);
    }

    public static RtDataSet getElem(SRM_RT_Code code)
    {
        return table[code.toInt()];
    }

    public static RtDataSet1[] table =
    {

        new RtDataSet1
        (
             new String("RTCOD_UNSPECIFIED"), /*!< ISO18026 Label */
             new String("UNSPECIFIED"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_UNSPECIFIED, /*!< ORM Code */
             SRM_RT_Code.RTCOD_UNSPECIFIED, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             Double.NaN, /* Region lower-left latitude */
             Double.NaN, /* Region lower-left longitude */
             Double.NaN, /* Region upper-right latitude */
             Double.NaN /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ABSTRACT_2D_IDENTITY"), /*!< ISO18026 Label */
             new String("Universal"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ABSTRACT_2D, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ABSTRACT_2D_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             Double.NaN, /* Region lower-left latitude */
             Double.NaN, /* Region lower-left longitude */
             Double.NaN, /* Region upper-right latitude */
             Double.NaN /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ABSTRACT_3D_IDENTITY"), /*!< ISO18026 Label */
             new String("Universal"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ABSTRACT_3D, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ABSTRACT_3D_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             Double.NaN, /* Region lower-left latitude */
             Double.NaN, /* Region lower-left longitude */
             Double.NaN, /* Region upper-right latitude */
             Double.NaN /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADINDAN_1991_BURKINA_FASO"), /*!< ISO18026 Label */
             new String("Burkina Faso"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADINDAN_1991_BURKINA_FASO, /*!< RT Code enum */
             -1.1800000000000e2, /* delta x */
             -1.4000000000000e1, /* delta y */
             2.1800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.0000000000000e0, /* Region lower-left latitude */
             -5.0000000000000e0, /* Region lower-left longitude */
             2.2000000000000e1, /* Region upper-right latitude */
             8.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADINDAN_1991_CAMEROON"), /*!< ISO18026 Label */
             new String("Cameroon"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADINDAN_1991_CAMEROON, /*!< RT Code enum */
             -1.3400000000000e2, /* delta x */
             -2.0000000000000e0, /* delta y */
             2.1000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.0000000000000e0, /* Region lower-left latitude */
             3.0000000000000e0, /* Region lower-left longitude */
             1.9000000000000e1, /* Region upper-right latitude */
             2.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADINDAN_1991_ETHIOPIA"), /*!< ISO18026 Label */
             new String("Ethiopia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADINDAN_1991_ETHIOPIA, /*!< RT Code enum */
             -1.6500000000000e2, /* delta x */
             -1.1000000000000e1, /* delta y */
             2.0600000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.0000000000000e0, /* Region lower-left latitude */
             2.6000000000000e1, /* Region lower-left longitude */
             2.5000000000000e1, /* Region upper-right latitude */
             5.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADINDAN_1991_MALI"), /*!< ISO18026 Label */
             new String("Mali"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADINDAN_1991_MALI, /*!< RT Code enum */
             -1.2300000000000e2, /* delta x */
             -2.0000000000000e1, /* delta y */
             2.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e0, /* Region lower-left latitude */
             -2.0000000000000e1, /* Region lower-left longitude */
             3.1000000000000e1, /* Region upper-right latitude */
             1.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADINDAN_1991_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Ethiopia and Sudan)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADINDAN_1991_MEAN_SOLUTION, /*!< RT Code enum */
             -1.6600000000000e2, /* delta x */
             -1.5000000000000e1, /* delta y */
             2.0400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.0000000000000e0, /* Region lower-left latitude */
             1.5000000000000e1, /* Region lower-left longitude */
             3.1000000000000e1, /* Region upper-right latitude */
             5.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADINDAN_1991_SENEGAL"), /*!< ISO18026 Label */
             new String("Senegal"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADINDAN_1991_SENEGAL, /*!< RT Code enum */
             -1.2800000000000e2, /* delta x */
             -1.8000000000000e1, /* delta y */
             2.2400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.0000000000000e0, /* Region lower-left latitude */
             -2.4000000000000e1, /* Region lower-left longitude */
             2.3000000000000e1, /* Region upper-right latitude */
             -5.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADINDAN_1991_SUDAN"), /*!< ISO18026 Label */
             new String("Sudan"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADINDAN_1991_SUDAN, /*!< RT Code enum */
             -1.6100000000000e2, /* delta x */
             -1.4000000000000e1, /* delta y */
             2.0500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.0000000000000e0, /* Region lower-left latitude */
             1.5000000000000e1, /* Region lower-left longitude */
             3.1000000000000e1, /* Region upper-right latitude */
             4.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ADRASTEA_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Adrastea)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ADRASTEA_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ADRASTEA_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AFGOOYE_1987_SOMALIA"), /*!< ISO18026 Label */
             new String("Somalia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AFGOOYE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AFGOOYE_1987_SOMALIA, /*!< RT Code enum */
             -4.3000000000000e1, /* delta x */
             -1.6300000000000e2, /* delta y */
             4.5000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -8.0000000000000e0, /* Region lower-left latitude */
             3.5000000000000e1, /* Region lower-left longitude */
             1.9000000000000e1, /* Region upper-right latitude */
             6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AIN_EL_ABD_1970_BAHRAIN_ISLAND"), /*!< ISO18026 Label */
             new String("Bahrain Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AIN_EL_ABD_1970, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AIN_EL_ABD_1970_BAHRAIN_ISLAND, /*!< RT Code enum */
             -1.5000000000000e2, /* delta x */
             -2.5000000000000e2, /* delta y */
             -1.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.4000000000000e1, /* Region lower-left latitude */
             4.9000000000000e1, /* Region lower-left longitude */
             2.8000000000000e1, /* Region upper-right latitude */
             5.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AIN_EL_ABD_1970_SAUDI_ARABIA"), /*!< ISO18026 Label */
             new String("Saudi Arabia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AIN_EL_ABD_1970, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AIN_EL_ABD_1970_SAUDI_ARABIA, /*!< RT Code enum */
             -1.4300000000000e2, /* delta x */
             -2.3600000000000e2, /* delta y */
             7.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             8.0000000000000e0, /* Region lower-left latitude */
             2.8000000000000e1, /* Region lower-left longitude */
             3.8000000000000e1, /* Region upper-right latitude */
             6.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AMALTHEA_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Amalthea)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AMALTHEA_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AMALTHEA_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS"), /*!< ISO18026 Label */
             new String("American Samoa Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AMERICAN_SAMOA_1962, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS, /*!< RT Code enum */
             -1.1500000000000e2, /* delta x */
             1.1800000000000e2, /* delta y */
             4.2600000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.9000000000000e1, /* Region lower-left latitude */
             -1.7400000000000e2, /* Region lower-left longitude */
             -9.0000000000000e0, /* Region upper-right latitude */
             -1.6500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ANNA_1_1965_COCOS_ISLANDS"), /*!< ISO18026 Label */
             new String("Cocos Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ANNA_1_1965, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ANNA_1_1965_COCOS_ISLANDS, /*!< RT Code enum */
             -4.9100000000000e2, /* delta x */
             -2.2000000000000e1, /* delta y */
             4.3500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.4000000000000e1, /* Region lower-left latitude */
             9.4000000000000e1, /* Region lower-left longitude */
             -1.0000000000000e1, /* Region upper-right latitude */
             9.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS"), /*!< ISO18026 Label */
             new String("Antigua and Leeward Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ANTIGUA_1943, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS, /*!< RT Code enum */
             -2.7000000000000e2, /* delta x */
             1.3000000000000e1, /* delta y */
             6.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.6000000000000e1, /* Region lower-left latitude */
             -6.5000000000000e1, /* Region lower-left longitude */
             2.0000000000000e1, /* Region upper-right latitude */
             -6.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_3_ZIMBABWE"), /*!< ISO18026 Label */
             new String("Zimbabwe"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_3_ZIMBABWE, /*!< RT Code enum */
             -1.4200000000000e2, /* delta x */
             -9.6000000000000e1, /* delta y */
             -2.9300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.9000000000000e1, /* Region lower-left latitude */
             1.9000000000000e1, /* Region lower-left longitude */
             -9.0000000000000e0, /* Region upper-right latitude */
             3.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_BOTSWANA"), /*!< ISO18026 Label */
             new String("Botswana"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_BOTSWANA, /*!< RT Code enum */
             -1.3800000000000e2, /* delta x */
             -1.0500000000000e2, /* delta y */
             -2.8900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.3000000000000e1, /* Region lower-left latitude */
             1.3000000000000e1, /* Region lower-left longitude */
             -1.3000000000000e1, /* Region upper-right latitude */
             3.6000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_BURUNDI"), /*!< ISO18026 Label */
             new String("Burundi"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_BURUNDI, /*!< RT Code enum */
             -1.5300000000000e2, /* delta x */
             -5.0000000000000e0, /* delta y */
             -2.9200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.1000000000000e1, /* Region lower-left latitude */
             2.1000000000000e1, /* Region lower-left longitude */
             4.0000000000000e0, /* Region upper-right latitude */
             3.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_LESOTHO"), /*!< ISO18026 Label */
             new String("Lesotho"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_LESOTHO, /*!< RT Code enum */
             -1.2500000000000e2, /* delta x */
             -1.0800000000000e2, /* delta y */
             -2.9500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.6000000000000e1, /* Region lower-left latitude */
             2.1000000000000e1, /* Region lower-left longitude */
             -2.3000000000000e1, /* Region upper-right latitude */
             3.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_MALAWI"), /*!< ISO18026 Label */
             new String("Malawi"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_MALAWI, /*!< RT Code enum */
             -1.6100000000000e2, /* delta x */
             -7.3000000000000e1, /* delta y */
             -3.1700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.1000000000000e1, /* Region lower-left latitude */
             2.6000000000000e1, /* Region lower-left longitude */
             -3.0000000000000e0, /* Region upper-right latitude */
             4.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Botswana, Lesotho, Malawi, Swaziland, Zaire, Zambia and Zimbabwe)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_MEAN_SOLUTION, /*!< RT Code enum */
             -1.4300000000000e2, /* delta x */
             -9.0000000000000e1, /* delta y */
             -2.9400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.6000000000000e1, /* Region lower-left latitude */
             4.0000000000000e0, /* Region lower-left longitude */
             1.0000000000000e1, /* Region upper-right latitude */
             4.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_SWAZILAND"), /*!< ISO18026 Label */
             new String("Swaziland"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_SWAZILAND, /*!< RT Code enum */
             -1.3400000000000e2, /* delta x */
             -1.0500000000000e2, /* delta y */
             -2.9500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.3000000000000e1, /* Region lower-left latitude */
             2.5000000000000e1, /* Region lower-left longitude */
             -2.0000000000000e1, /* Region upper-right latitude */
             4.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_ZAIRE"), /*!< ISO18026 Label */
             new String("Zaire"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_ZAIRE, /*!< RT Code enum */
             -1.6900000000000e2, /* delta x */
             -1.9000000000000e1, /* delta y */
             -2.7800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.1000000000000e1, /* Region lower-left latitude */
             4.0000000000000e0, /* Region lower-left longitude */
             1.0000000000000e1, /* Region upper-right latitude */
             3.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1950_ZAMBIA"), /*!< ISO18026 Label */
             new String("Zambia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1950_ZAMBIA, /*!< RT Code enum */
             -1.4700000000000e2, /* delta x */
             -7.4000000000000e1, /* delta y */
             -2.8300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.4000000000000e1, /* Region lower-left latitude */
             1.5000000000000e1, /* Region lower-left longitude */
             -1.0000000000000e0, /* Region upper-right latitude */
             4.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1960_3_KENYA"), /*!< ISO18026 Label */
             new String("Kenya"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1960_3_KENYA, /*!< RT Code enum */
             -1.5700000000000e2, /* delta x */
             -2.0000000000000e0, /* delta y */
             -2.9900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.1000000000000e1, /* Region lower-left latitude */
             2.8000000000000e1, /* Region lower-left longitude */
             8.0000000000000e0, /* Region upper-right latitude */
             4.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1960_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Kenya and Tanzania)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1960_MEAN_SOLUTION, /*!< RT Code enum */
             -1.6000000000000e2, /* delta x */
             -6.0000000000000e0, /* delta y */
             -3.0200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.8000000000000e1, /* Region lower-left latitude */
             2.3000000000000e1, /* Region lower-left longitude */
             8.0000000000000e0, /* Region upper-right latitude */
             4.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARC_1960_TANZANIA"), /*!< ISO18026 Label */
             new String("Tanzania"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARC_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARC_1960_TANZANIA, /*!< RT Code enum */
             -1.7500000000000e2, /* delta x */
             -2.3000000000000e1, /* delta y */
             -3.0300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.8000000000000e1, /* Region lower-left latitude */
             2.3000000000000e1, /* Region lower-left longitude */
             5.0000000000000e0, /* Region upper-right latitude */
             4.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ARIEL_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Ariel)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ARIEL_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ARIEL_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ASCENSION_1958_ASCENSION_ISLAND"), /*!< ISO18026 Label */
             new String("Ascension Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ASCENSION_1958, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ASCENSION_1958_ASCENSION_ISLAND, /*!< RT Code enum */
             -2.0500000000000e2, /* delta x */
             1.0700000000000e2, /* delta y */
             5.3000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e0, /* Region lower-left latitude */
             -1.6000000000000e1, /* Region lower-left longitude */
             -6.0000000000000e0, /* Region upper-right latitude */
             -1.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ATLAS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Atlas)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ATLAS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ATLAS_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA"), /*!< ISO18026 Label */
             new String("Australia and Tasmania"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AUSTRALIAN_GEOD_1966, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA, /*!< RT Code enum */
             -1.3300000000000e2, /* delta x */
             -4.8000000000000e1, /* delta y */
             1.4800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.6000000000000e1, /* Region lower-left latitude */
             1.0900000000000e2, /* Region lower-left longitude */
             -4.0000000000000e0, /* Region upper-right latitude */
             1.6100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AUSTRALIA_GEOD_1984_3_AUSTRALIA_TASMANIA"), /*!< ISO18026 Label */
             new String("Australia and Tasmania"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AUSTRALIAN_GEOD_1984, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AUSTRALIA_GEOD_1984_3_AUSTRALIA_TASMANIA, /*!< RT Code enum */
             -1.3400000000000e2, /* delta x */
             -4.8000000000000e1, /* delta y */
             1.4900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.6000000000000e1, /* Region lower-left latitude */
             1.0900000000000e2, /* Region lower-left longitude */
             -4.0000000000000e0, /* Region upper-right latitude */
             1.6100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AUSTRALIA_GEOD_1984_7_AUSTRALIA_TASMANIA"), /*!< ISO18026 Label */
             new String("Australia and Tasmania"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AUSTRALIAN_GEOD_1984, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AUSTRALIA_GEOD_1984_7_AUSTRALIA_TASMANIA, /*!< RT Code enum */
             -1.1600000000000e2, /* delta x */
             -5.0470000000000e1, /* delta y */
             1.4169000000000e2, /* delta z */
             1.1150714665519e-6, /* omega 1 */
             1.8907733563272e-6, /* omega 2 */
             1.6677590630168e-6, /* omega 3 */
             9.8300000000000e-2, /* delta scale */
             -4.6000000000000e1, /* Region lower-left latitude */
             1.0900000000000e2, /* Region lower-left longitude */
             -4.0000000000000e0, /* Region upper-right latitude */
             1.6100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI"), /*!< ISO18026 Label */
             new String("Djibouti"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_AYABELLE_LIGHTHOUSE_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI, /*!< RT Code enum */
             -7.9000000000000e1, /* delta x */
             -1.2900000000000e2, /* delta y */
             1.4500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.0000000000000e0, /* Region lower-left latitude */
             3.6000000000000e1, /* Region lower-left longitude */
             2.0000000000000e1, /* Region upper-right latitude */
             4.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BEACON_E_1945_IWO_JIMA_ISLAND"), /*!< ISO18026 Label */
             new String("Iwo Jima Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BEACON_E_1945, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BEACON_E_1945_IWO_JIMA_ISLAND, /*!< RT Code enum */
             1.4500000000000e2, /* delta x */
             7.5000000000000e1, /* delta y */
             -2.7200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.2000000000000e1, /* Region lower-left latitude */
             1.4000000000000e2, /* Region lower-left longitude */
             2.6000000000000e1, /* Region upper-right latitude */
             1.4400000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BELINDA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Belinda)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BELINDA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BELINDA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS"), /*!< ISO18026 Label */
             new String("Efate and Erromango Islands (Vanuatu)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BELLEVUE_IGN_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS, /*!< RT Code enum */
             -1.2700000000000e2, /* delta x */
             -7.6900000000000e2, /* delta y */
             4.7200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.0000000000000e1, /* Region lower-left latitude */
             1.6700000000000e2, /* Region lower-left longitude */
             -1.6000000000000e1, /* Region upper-right latitude */
             1.7100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BERMUDA_1957_BERMUDA"), /*!< ISO18026 Label */
             new String("Bermuda"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BERMUDA_1957, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BERMUDA_1957_BERMUDA, /*!< RT Code enum */
             -7.3000000000000e1, /* delta x */
             2.1300000000000e2, /* delta y */
             2.9600000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.1000000000000e1, /* Region lower-left latitude */
             -6.6000000000000e1, /* Region lower-left longitude */
             3.4000000000000e1, /* Region upper-right latitude */
             -6.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BIANCA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Bianca)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BIANCA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BIANCA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BISSAU_1991_GUINEA_BISSAU"), /*!< ISO18026 Label */
             new String("Guinea-Bissau"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BISSAU_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BISSAU_1991_GUINEA_BISSAU, /*!< RT Code enum */
             -1.7300000000000e2, /* delta x */
             2.5300000000000e2, /* delta y */
             2.7000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.0000000000000e0, /* Region lower-left latitude */
             -2.3000000000000e1, /* Region lower-left longitude */
             1.9000000000000e1, /* Region upper-right latitude */
             -7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BOGOTA_OBS_1987_COLOMBIA"), /*!< ISO18026 Label */
             new String("Colombia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BOGOTA_OBS_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BOGOTA_OBS_1987_COLOMBIA, /*!< RT Code enum */
             3.0700000000000e2, /* delta x */
             3.0400000000000e2, /* delta y */
             -3.1800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             -8.5000000000000e1, /* Region lower-left longitude */
             1.6000000000000e1, /* Region upper-right latitude */
             -6.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA"), /*!< ISO18026 Label */
             new String("Colombia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BOGOTA_OBS_1987_PM_BOGOTA, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA, /*!< RT Code enum */
             3.0700000000000e2, /* delta x */
             3.0400000000000e2, /* delta y */
             -3.1800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             4.9902293984507e0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             -1.1000000000000e1, /* Region lower-left longitude */
             1.6000000000000e1, /* Region upper-right latitude */
             1.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS"), /*!< ISO18026 Label */
             new String("Bangka and Belitung Islands (Indonesia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_BUKIT_RIMPAH_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS, /*!< RT Code enum */
             -3.8400000000000e2, /* delta x */
             6.6400000000000e2, /* delta y */
             -4.8000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.0000000000000e0, /* Region lower-left latitude */
             1.0300000000000e2, /* Region lower-left longitude */
             0.0, /* Region upper-right latitude */
             1.1000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CALLISTO_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Callisto)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CALLISTO_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CALLISTO_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CALYPSO_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Calypso)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CALYPSO_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CALYPSO_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CAMP_AREA_1987_MCMURDO_CAMP"), /*!< ISO18026 Label */
             new String("McMurdo Camp Area (Antarctica)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CAMP_AREA_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CAMP_AREA_1987_MCMURDO_CAMP, /*!< RT Code enum */
             -1.0400000000000e2, /* delta x */
             -1.2900000000000e2, /* delta y */
             2.3900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -8.5000000000000e1, /* Region lower-left latitude */
             1.3500000000000e2, /* Region lower-left longitude */
             -7.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CAMPO_INCHAUSPE_1969_ARGENTINA"), /*!< ISO18026 Label */
             new String("Argentina"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CAMPO_INCHAUSPE_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CAMPO_INCHAUSPE_1969_ARGENTINA, /*!< RT Code enum */
             -1.4800000000000e2, /* delta x */
             1.3600000000000e2, /* delta y */
             9.0000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.8000000000000e1, /* Region lower-left latitude */
             -7.2000000000000e1, /* Region lower-left longitude */
             -2.7000000000000e1, /* Region upper-right latitude */
             -5.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CANTON_1966_PHOENIX_ISLANDS"), /*!< ISO18026 Label */
             new String("Phoenix Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CANTON_1966, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CANTON_1966_PHOENIX_ISLANDS, /*!< RT Code enum */
             2.9800000000000e2, /* delta x */
             -3.0400000000000e2, /* delta y */
             -3.7500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.3000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             3.0000000000000e0, /* Region upper-right latitude */
             -1.6500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CAPE_1987_SOUTH_AFRICA"), /*!< ISO18026 Label */
             new String("South Africa"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CAPE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CAPE_1987_SOUTH_AFRICA, /*!< RT Code enum */
             -1.3600000000000e2, /* delta x */
             -1.0800000000000e2, /* delta y */
             -2.9200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.3000000000000e1, /* Region lower-left latitude */
             1.0000000000000e1, /* Region lower-left longitude */
             -1.5000000000000e1, /* Region upper-right latitude */
             4.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CAPE_CANAVERAL_1991_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Bahamas and Florida)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CAPE_CANAVERAL_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CAPE_CANAVERAL_1991_MEAN_SOLUTION, /*!< RT Code enum */
             -2.0000000000000e0, /* delta x */
             1.5100000000000e2, /* delta y */
             1.8100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.5000000000000e1, /* Region lower-left latitude */
             -9.4000000000000e1, /* Region lower-left longitude */
             3.8000000000000e1, /* Region upper-right latitude */
             -1.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CARTHAGE_1987_TUNISIA"), /*!< ISO18026 Label */
             new String("Tunisia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CARTHAGE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CARTHAGE_1987_TUNISIA, /*!< RT Code enum */
             -2.6300000000000e2, /* delta x */
             6.0000000000000e0, /* delta y */
             4.3100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.4000000000000e1, /* Region lower-left latitude */
             2.0000000000000e0, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             1.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CHARON_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Charon)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CHARON_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CHARON_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CHATHAM_1971_CHATHAM_ISLANDS"), /*!< ISO18026 Label */
             new String("Chatham Islands (New Zealand)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CHATHAM_1971, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CHATHAM_1971_CHATHAM_ISLANDS, /*!< RT Code enum */
             1.7500000000000e2, /* delta x */
             -3.8000000000000e1, /* delta y */
             1.1300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.6000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             -4.2000000000000e1, /* Region upper-right latitude */
             -1.7400000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CHUA_1987_PARAGUAY"), /*!< ISO18026 Label */
             new String("Paraguay"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CHUA_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CHUA_1987_PARAGUAY, /*!< RT Code enum */
             -1.3400000000000e2, /* delta x */
             2.2900000000000e2, /* delta y */
             -2.9000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.3000000000000e1, /* Region lower-left latitude */
             -6.9000000000000e1, /* Region lower-left longitude */
             -1.4000000000000e1, /* Region upper-right latitude */
             -4.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_COAMPS_1998_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_COAMPS_1998, /*!< ORM Code */
             SRM_RT_Code.RTCOD_COAMPS_1998_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CORDELIA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Cordelia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CORDELIA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CORDELIA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CORREGO_ALEGRE_1987_BRAZIL"), /*!< ISO18026 Label */
             new String("Brazil"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CORREGO_ALEGRE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CORREGO_ALEGRE_1987_BRAZIL, /*!< RT Code enum */
             -2.0600000000000e2, /* delta x */
             1.7200000000000e2, /* delta y */
             -6.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.9000000000000e1, /* Region lower-left latitude */
             -8.0000000000000e1, /* Region lower-left longitude */
             -2.0000000000000e0, /* Region upper-right latitude */
             -2.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_CRESSIDA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Cressida)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_CRESSIDA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_CRESSIDA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DABOLA_1991_GUINEA"), /*!< ISO18026 Label */
             new String("Guinea"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DABOLA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DABOLA_1991_GUINEA, /*!< RT Code enum */
             -8.3000000000000e1, /* delta x */
             3.7000000000000e1, /* delta y */
             1.2400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.0000000000000e0, /* Region lower-left latitude */
             -1.7000000000000e1, /* Region lower-left longitude */
             1.9000000000000e1, /* Region upper-right latitude */
             -7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DECEPTION_1993_DECEPTION_ISLAND"), /*!< ISO18026 Label */
             new String("Deception Island (Antarctica)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DECEPTION_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DECEPTION_1993_DECEPTION_ISLAND, /*!< RT Code enum */
             2.6000000000000e2, /* delta x */
             1.2000000000000e1, /* delta y */
             -1.4700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.5000000000000e1, /* Region lower-left latitude */
             5.8000000000000e1, /* Region lower-left longitude */
             -6.2000000000000e1, /* Region upper-right latitude */
             6.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DEIMOS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Deimos)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DEIMOS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DEIMOS_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DESDEMONA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Desdemona)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DESDEMONA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DESDEMONA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DESPINA_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Despina)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DESPINA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DESPINA_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DIONE_1982_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Dione)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DIONE_1982, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DIONE_1982_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DJAKARTA_1987_PM_DJAKARTA_SUMATRA"), /*!< ISO18026 Label */
             new String("Sumatra (Indonesia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DJAKARTA_1987_PM_DJAKARTA, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DJAKARTA_1987_PM_DJAKARTA_SUMATRA, /*!< RT Code enum */
             -3.7700000000000e2, /* delta x */
             6.8100000000000e2, /* delta y */
             -5.0000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             1.8641463708519e0, /* omega 3 */
             0.0, /* delta scale */
             -1.6000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e1, /* Region lower-left longitude */
             1.1000000000000e1, /* Region upper-right latitude */
             3.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DJAKARTA_1987_SUMATRA"), /*!< ISO18026 Label */
             new String("Sumatra (Indonesia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DJAKARTA_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DJAKARTA_1987_SUMATRA, /*!< RT Code enum */
             -3.7700000000000e2, /* delta x */
             6.8100000000000e2, /* delta y */
             -5.0000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.6000000000000e1, /* Region lower-left latitude */
             8.9000000000000e1, /* Region lower-left longitude */
             1.1000000000000e1, /* Region upper-right latitude */
             1.4600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DOS_1968_GIZO_ISLAND"), /*!< ISO18026 Label */
             new String("Gizo Island (New Georgia Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DOS_1968, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DOS_1968_GIZO_ISLAND, /*!< RT Code enum */
             2.3000000000000e2, /* delta x */
             -1.9900000000000e2, /* delta y */
             -7.5200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             1.5500000000000e2, /* Region lower-left longitude */
             -7.0000000000000e0, /* Region upper-right latitude */
             1.5800000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_DOS_71_4_1987_ST_HELENA_ISLAND"), /*!< ISO18026 Label */
             new String("St. Helena Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_DOS_71_4_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_DOS_71_4_1987_ST_HELENA_ISLAND, /*!< RT Code enum */
             -3.2000000000000e2, /* delta x */
             5.5000000000000e2, /* delta y */
             -4.9400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.8000000000000e1, /* Region lower-left latitude */
             -7.0000000000000e0, /* Region lower-left longitude */
             -1.4000000000000e1, /* Region upper-right latitude */
             -4.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EASTER_1967_EASTER_ISLAND"), /*!< ISO18026 Label */
             new String("Easter Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EASTER_1967, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EASTER_1967_EASTER_ISLAND, /*!< RT Code enum */
             2.1100000000000e2, /* delta x */
             1.4700000000000e2, /* delta y */
             1.1100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.9000000000000e1, /* Region lower-left latitude */
             -1.1100000000000e2, /* Region lower-left longitude */
             -2.6000000000000e1, /* Region upper-right latitude */
             -1.0800000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ENCELADUS_1994_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Enceladus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ENCELADUS_1994, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ENCELADUS_1994_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EPIMETHEUS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Epimetheus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EPIMETHEUS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EPIMETHEUS_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EROS_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Eros)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EROS_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EROS_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ESTONIA_1937_ESTONIA"), /*!< ISO18026 Label */
             new String("Estonia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ESTONIA_1937, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ESTONIA_1937_ESTONIA, /*!< RT Code enum */
             3.7400000000000e2, /* delta x */
             1.5000000000000e2, /* delta y */
             5.8800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.2000000000000e1, /* Region lower-left latitude */
             1.6000000000000e1, /* Region lower-left longitude */
             6.5000000000000e1, /* Region upper-right latitude */
             3.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ETRS_1989_IDENTITY_BY_MEASUREMENT"), /*!< ISO18026 Label */
             new String("Europe"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ETRS_1989, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ETRS_1989_IDENTITY_BY_MEASUREMENT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.4000000000000e1, /* Region lower-left latitude */
             -1.2000000000000e1, /* Region lower-left longitude */
             7.3000000000000e1, /* Region upper-right latitude */
             3.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPA_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Europa)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPA_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPA_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_3_CYPRUS"), /*!< ISO18026 Label */
             new String("Cyprus"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_3_CYPRUS, /*!< RT Code enum */
             -1.0400000000000e2, /* delta x */
             -1.0100000000000e2, /* delta y */
             -1.4000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.3000000000000e1, /* Region lower-left latitude */
             3.1000000000000e1, /* Region lower-left longitude */
             3.7000000000000e1, /* Region upper-right latitude */
             3.6000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_CHANNEL_ISLANDS"), /*!< ISO18026 Label */
             new String("Channel Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_CHANNEL_ISLANDS, /*!< RT Code enum */
             -8.3901000000000e1, /* delta x */
             -9.8127000000000e1, /* delta y */
             -1.1863500000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.8000000000000e1, /* Region lower-left latitude */
             -4.0000000000000e0, /* Region lower-left longitude */
             5.0000000000000e1, /* Region upper-right latitude */
             -1.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_EGYPT"), /*!< ISO18026 Label */
             new String("Egypt"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_EGYPT, /*!< RT Code enum */
             -1.3000000000000e2, /* delta x */
             -1.1700000000000e2, /* delta y */
             -1.5100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.6000000000000e1, /* Region lower-left latitude */
             1.9000000000000e1, /* Region lower-left longitude */
             3.8000000000000e1, /* Region upper-right latitude */
             4.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_ENGLAND_SCOTLAND"), /*!< ISO18026 Label */
             new String("England, Scotland, Channel Islands and Shetland Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_ENGLAND_SCOTLAND, /*!< RT Code enum */
             -8.6000000000000e1, /* delta x */
             -9.6000000000000e1, /* delta y */
             -1.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.8000000000000e1, /* Region lower-left latitude */
             -1.0000000000000e1, /* Region lower-left longitude */
             6.2000000000000e1, /* Region upper-right latitude */
             3.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_GREECE"), /*!< ISO18026 Label */
             new String("Greece"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_GREECE, /*!< RT Code enum */
             -8.4000000000000e1, /* delta x */
             -9.5000000000000e1, /* delta y */
             -1.3000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e1, /* Region lower-left latitude */
             1.4000000000000e1, /* Region lower-left longitude */
             4.8000000000000e1, /* Region upper-right latitude */
             3.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_IRAN"), /*!< ISO18026 Label */
             new String("Iran"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_IRAN, /*!< RT Code enum */
             -1.1700000000000e2, /* delta x */
             -1.3200000000000e2, /* delta y */
             -1.6400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             3.7000000000000e1, /* Region lower-left longitude */
             4.7000000000000e1, /* Region upper-right latitude */
             6.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_IRAQ"), /*!< ISO18026 Label */
             new String("Iraq"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_IRAQ, /*!< RT Code enum */
             -1.0300000000000e2, /* delta x */
             -1.0600000000000e2, /* delta y */
             -1.4100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.8000000000000e1, /* Region lower-left latitude */
             3.6000000000000e1, /* Region lower-left longitude */
             -4.0000000000000e0, /* Region upper-right latitude */
             5.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_IRELAND"), /*!< ISO18026 Label */
             new String("Ireland, Northern Ireland, Wales, England, Scotland, Channel Islands, and Shetland Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_IRELAND, /*!< RT Code enum */
             -8.6000000000000e1, /* delta x */
             -9.6000000000000e1, /* delta y */
             -1.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.8000000000000e1, /* Region lower-left latitude */
             -1.2000000000000e1, /* Region lower-left longitude */
             6.2000000000000e1, /* Region upper-right latitude */
             3.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_MALTA"), /*!< ISO18026 Label */
             new String("Malta"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_MALTA, /*!< RT Code enum */
             -1.0700000000000e2, /* delta x */
             -8.8000000000000e1, /* delta y */
             -1.4900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.4000000000000e1, /* Region lower-left latitude */
             1.2000000000000e1, /* Region lower-left longitude */
             3.8000000000000e1, /* Region upper-right latitude */
             1.6000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Austria, Belgium, Denmark, Finland, France, FRG, Gibraltar, Greece, Italy, Luxembourg, Netherlands, Norway, Portugal, Spain, Sweden and Switzerland)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_MEAN_SOLUTION, /*!< RT Code enum */
             -8.7000000000000e1, /* delta x */
             -9.8000000000000e1, /* delta y */
             -1.2100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e1, /* Region lower-left latitude */
             5.0000000000000e0, /* Region lower-left longitude */
             8.0000000000000e1, /* Region upper-right latitude */
             3.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_NORWAY"), /*!< ISO18026 Label */
             new String("Finland and Norway"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_NORWAY, /*!< RT Code enum */
             -8.7000000000000e1, /* delta x */
             -9.5000000000000e1, /* delta y */
             -1.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.2000000000000e1, /* Region lower-left latitude */
             -2.0000000000000e0, /* Region lower-left longitude */
             8.0000000000000e1, /* Region upper-right latitude */
             3.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_PORTUGAL_SPAIN"), /*!< ISO18026 Label */
             new String("Portugal and Spain"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_PORTUGAL_SPAIN, /*!< RT Code enum */
             -8.4000000000000e1, /* delta x */
             -1.0700000000000e2, /* delta y */
             -1.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e1, /* Region lower-left longitude */
             4.9000000000000e1, /* Region upper-right latitude */
             1.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_SARDINIA"), /*!< ISO18026 Label */
             new String("Sardinia (Italy)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_SARDINIA, /*!< RT Code enum */
             -9.7000000000000e1, /* delta x */
             -1.0300000000000e2, /* delta y */
             -1.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.7000000000000e1, /* Region lower-left latitude */
             6.0000000000000e0, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             1.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_SICILY"), /*!< ISO18026 Label */
             new String("Sicily (Italy)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_SICILY, /*!< RT Code enum */
             -9.7000000000000e1, /* delta x */
             -8.8000000000000e1, /* delta y */
             -1.3500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.5000000000000e1, /* Region lower-left latitude */
             1.0000000000000e1, /* Region lower-left longitude */
             4.0000000000000e1, /* Region upper-right latitude */
             1.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_TUNISIA"), /*!< ISO18026 Label */
             new String("Tunisia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_TUNISIA, /*!< RT Code enum */
             -1.1200000000000e2, /* delta x */
             -7.7000000000000e1, /* delta y */
             -1.4500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.4000000000000e1, /* Region lower-left latitude */
             2.0000000000000e0, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             1.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1950_W_EUROPE_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Western Europe Mean Solution (Austria, Denmark, France, FRG, Netherlands and Switzerland)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1950_W_EUROPE_MEAN_SOLUTION, /*!< RT Code enum */
             -8.7000000000000e1, /* delta x */
             -9.6000000000000e1, /* delta y */
             -1.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e1, /* Region lower-left longitude */
             7.8000000000000e1, /* Region upper-right latitude */
             2.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_EUROPE_1979_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Austria, Finland, Netherlands, Norway, Spain, Sweden and Switzerland)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EUROPE_1979, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EUROPE_1979_MEAN_SOLUTION, /*!< RT Code enum */
             -8.6000000000000e1, /* delta x */
             -9.8000000000000e1, /* delta y */
             -1.1900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e1, /* Region lower-left longitude */
             8.0000000000000e1, /* Region upper-right latitude */
             2.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_FAHUD_1987_3_OMAN"), /*!< ISO18026 Label */
             new String("Oman"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_FAHUD_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_FAHUD_1987_3_OMAN, /*!< RT Code enum */
             -3.4600000000000e2, /* delta x */
             -1.0000000000000e0, /* delta y */
             2.2400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.0000000000000e1, /* Region lower-left latitude */
             4.6000000000000e1, /* Region lower-left longitude */
             3.2000000000000e1, /* Region upper-right latitude */
             6.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_FAHUD_1987_7_OMAN"), /*!< ISO18026 Label */
             new String("Oman"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_FAHUD_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_FAHUD_1987_7_OMAN, /*!< RT Code enum */
             -1.7369000000000e2, /* delta x */
             -2.4771000000000e2, /* delta y */
             1.6208000000000e2, /* delta z */
             -5.5317241014598e-6, /* omega 1 */
             -1.3239292003739e-5, /* omega 2 */
             4.1860267668041e-5, /* omega 3 */
             1.9727000000000e1, /* delta scale */
             1.0000000000000e1, /* Region lower-left latitude */
             4.6000000000000e1, /* Region lower-left longitude */
             3.2000000000000e1, /* Region upper-right latitude */
             6.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS"), /*!< ISO18026 Label */
             new String("St. Kitts, Nevis and Leeward Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_FORT_THOMAS_1955, /*!< ORM Code */
             SRM_RT_Code.RTCOD_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS, /*!< RT Code enum */
             -7.0000000000000e0, /* delta x */
             2.1500000000000e2, /* delta y */
             2.2500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.6000000000000e1, /* Region lower-left latitude */
             -6.4000000000000e1, /* Region lower-left longitude */
             1.9000000000000e1, /* Region upper-right latitude */
             -6.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GALATEA_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Galatea)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GALATEA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GALATEA_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GAN_1970_MALDIVES"), /*!< ISO18026 Label */
             new String("Republic of Maldives"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GAN_1970, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GAN_1970_MALDIVES, /*!< RT Code enum */
             -1.3300000000000e2, /* delta x */
             -3.2100000000000e2, /* delta y */
             5.0000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.0000000000000e0, /* Region lower-left latitude */
             7.1000000000000e1, /* Region lower-left longitude */
             9.0000000000000e0, /* Region upper-right latitude */
             7.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GANYMEDE_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Ganymede)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GANYMEDE_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GANYMEDE_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GASPRA_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Gaspra)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GASPRA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GASPRA_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GDA_1994_IDENTITY_BY_MEASUREMENT"), /*!< ISO18026 Label */
             new String("Australia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GDA_1994, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GDA_1994_IDENTITY_BY_MEASUREMENT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.2000000000000e1, /* Region lower-left latitude */
             1.1000000000000e2, /* Region lower-left longitude */
             -8.0000000000000e0, /* Region upper-right latitude */
             1.5500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEODETIC_DATUM_1949_3_NEW_ZEALAND"), /*!< ISO18026 Label */
             new String("New Zealand"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEODETIC_DATUM_1949, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEODETIC_DATUM_1949_3_NEW_ZEALAND, /*!< RT Code enum */
             8.4000000000000e1, /* delta x */
             -2.2000000000000e1, /* delta y */
             2.0900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.8000000000000e1, /* Region lower-left latitude */
             1.6500000000000e2, /* Region lower-left longitude */
             -3.3000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEODETIC_DATUM_1949_7_NEW_ZEALAND"), /*!< ISO18026 Label */
             new String("New Zealand"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEODETIC_DATUM_1949, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEODETIC_DATUM_1949_7_NEW_ZEALAND, /*!< RT Code enum */
             5.9470000000000e1, /* delta x */
             -5.0400000000000e0, /* delta y */
             1.8744000000000e2, /* delta z */
             2.2786243012148e-6, /* omega 1 */
             -4.8481368110954e-7, /* omega 2 */
             4.9644920945617e-6, /* omega 3 */
             -4.5993000000000e0, /* delta scale */
             -4.8000000000000e1, /* Region lower-left latitude */
             1.6500000000000e2, /* Region lower-left longitude */
             -3.3000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1945_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1945, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1945_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             2.0123646275495e-1, /* omega 2 */
             -1.1960741363917e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1950_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1950, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1950_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             2.0123646275495e-1, /* omega 2 */
             -1.2016591899981e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1955_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1955, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1955_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             2.0141099568015e-1, /* omega 2 */
             -1.2070697106793e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1960_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1960_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             2.0053833105415e-1, /* omega 2 */
             -1.2124802313605e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1965_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1965, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1965_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             2.0018926520375e-1, /* omega 2 */
             -1.2191124825180e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1970_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1970, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1970_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.9914206765255e-1, /* omega 2 */
             -1.2248720690496e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1975_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1975, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1975_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.9739673840056e-1, /* omega 2 */
             -1.2299335238804e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1980_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1980, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1980_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.9530234329817e-1, /* omega 2 */
             -1.2349949787112e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1985_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1985, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1985_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.9250981649498e-1, /* omega 2 */
             -1.2374384396640e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1990_DGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1990, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1990_DGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.8971728969178e-1, /* omega 2 */
             -1.2411036310932e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_1995_IGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1995, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_1995_IGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.8675022996339e-1, /* omega 2 */
             -1.2463396188492e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GEOMAGNETIC_2000_IGRF"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GEOMAGNETIC_2000_IGRF, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.8256143975861e-1, /* omega 2 */
             -1.2491321456523e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES"), /*!< ISO18026 Label */
             new String("Central Azores (Faial, Graciosa, Pico, Sao Jorge and Terceira Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GRACIOSA_BASE_SW_1948, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES, /*!< RT Code enum */
             -1.0400000000000e2, /* delta x */
             1.6700000000000e2, /* delta y */
             -3.8000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.7000000000000e1, /* Region lower-left latitude */
             -3.0000000000000e1, /* Region lower-left longitude */
             4.1000000000000e1, /* Region upper-right latitude */
             -2.6000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GUAM_1963_GUAM"), /*!< ISO18026 Label */
             new String("Guam"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GUAM_1963, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GUAM_1963_GUAM, /*!< RT Code enum */
             -1.0000000000000e2, /* delta x */
             -2.4800000000000e2, /* delta y */
             2.5900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.2000000000000e1, /* Region lower-left latitude */
             1.4300000000000e2, /* Region lower-left longitude */
             1.5000000000000e1, /* Region upper-right latitude */
             1.4600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND"), /*!< ISO18026 Label */
             new String("Kalimantan Island (Indonesia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GUNONG_SEGARA_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND, /*!< RT Code enum */
             -4.0300000000000e2, /* delta x */
             6.8400000000000e2, /* delta y */
             4.1000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.0000000000000e0, /* Region lower-left latitude */
             1.0600000000000e2, /* Region lower-left longitude */
             9.0000000000000e0, /* Region upper-right latitude */
             1.2100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_GUX_1_1987_GUADALCANAL_ISLAND"), /*!< ISO18026 Label */
             new String("Guadalcanal Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_GUX_1_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_GUX_1_1987_GUADALCANAL_ISLAND, /*!< RT Code enum */
             2.5200000000000e2, /* delta x */
             -2.0900000000000e2, /* delta y */
             -7.5100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.2000000000000e1, /* Region lower-left latitude */
             1.5800000000000e2, /* Region lower-left longitude */
             -8.0000000000000e0, /* Region upper-right latitude */
             1.6300000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_HELENE_1992_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Helene)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_HELENE_1992, /*!< ORM Code */
             SRM_RT_Code.RTCOD_HELENE_1992_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_HERAT_NORTH_1987_AFGHANISTAN"), /*!< ISO18026 Label */
             new String("Afghanistan"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_HERAT_NORTH_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_HERAT_NORTH_1987_AFGHANISTAN, /*!< RT Code enum */
             -3.3300000000000e2, /* delta x */
             -2.2200000000000e2, /* delta y */
             1.1400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.3000000000000e1, /* Region lower-left latitude */
             5.5000000000000e1, /* Region lower-left longitude */
             4.4000000000000e1, /* Region upper-right latitude */
             8.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_HERMANNSKOGEL_1871_3_YUGOSLAVIA"), /*!< ISO18026 Label */
             new String("Yugoslavia (prior to 1990), Slovenia, Croatia, Bosnia and Herzegovina, and Serbia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_HERMANNSKOGEL_1871, /*!< ORM Code */
             SRM_RT_Code.RTCOD_HERMANNSKOGEL_1871_3_YUGOSLAVIA, /*!< RT Code enum */
             6.8200000000000e2, /* delta x */
             -2.0300000000000e2, /* delta y */
             4.8000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.5000000000000e1, /* Region lower-left latitude */
             7.0000000000000e0, /* Region lower-left longitude */
             5.2000000000000e1, /* Region upper-right latitude */
             2.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_HJORSEY_1955_ICELAND"), /*!< ISO18026 Label */
             new String("Iceland"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_HJORSEY_1955, /*!< ORM Code */
             SRM_RT_Code.RTCOD_HJORSEY_1955_ICELAND, /*!< RT Code enum */
             -7.3000000000000e1, /* delta x */
             4.6000000000000e1, /* delta y */
             -8.6000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             6.1000000000000e1, /* Region lower-left latitude */
             -2.4000000000000e1, /* Region lower-left longitude */
             6.9000000000000e1, /* Region upper-right latitude */
             -1.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_HONG_KONG_1963_HONG_KONG"), /*!< ISO18026 Label */
             new String("Hong Kong"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_HONG_KONG_1963, /*!< ORM Code */
             SRM_RT_Code.RTCOD_HONG_KONG_1963_HONG_KONG, /*!< RT Code enum */
             -1.5600000000000e2, /* delta x */
             -2.7100000000000e2, /* delta y */
             -1.8900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.1000000000000e1, /* Region lower-left latitude */
             1.1200000000000e2, /* Region lower-left longitude */
             2.4000000000000e1, /* Region upper-right latitude */
             1.1600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_HU_TZU_SHAN_1991_TAIWAN"), /*!< ISO18026 Label */
             new String("Taiwan"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_HU_TZU_SHAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_HU_TZU_SHAN_1991_TAIWAN, /*!< RT Code enum */
             -6.3700000000000e2, /* delta x */
             -5.4900000000000e2, /* delta y */
             -2.0300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.0000000000000e1, /* Region lower-left latitude */
             1.1700000000000e2, /* Region lower-left longitude */
             2.8000000000000e1, /* Region upper-right latitude */
             1.2400000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_IAPETUS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Iapetus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_IAPETUS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_IAPETUS_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_IDA_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Ida)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_IDA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_IDA_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1916_3_BANGLADESH"), /*!< ISO18026 Label */
             new String("Bangladesh"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1916, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1916_3_BANGLADESH, /*!< RT Code enum */
             2.8200000000000e2, /* delta x */
             7.2600000000000e2, /* delta y */
             2.5400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.5000000000000e1, /* Region lower-left latitude */
             8.0000000000000e1, /* Region lower-left longitude */
             3.3000000000000e1, /* Region upper-right latitude */
             1.0000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1916_7_BANGLADESH"), /*!< ISO18026 Label */
             new String("Bangladesh"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1916, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1916_7_BANGLADESH, /*!< RT Code enum */
             7.9200000000000e1, /* delta x */
             6.7030000000000e2, /* delta y */
             2.3000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             -3.5265347163908e-5, /* omega 3 */
             1.1034000000000e1, /* delta scale */
             1.5000000000000e1, /* Region lower-left latitude */
             8.0000000000000e1, /* Region lower-left longitude */
             3.3000000000000e1, /* Region upper-right latitude */
             1.0000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1954_THAILAND"), /*!< ISO18026 Label */
             new String("Thailand"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1954, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1954_THAILAND, /*!< RT Code enum */
             2.1700000000000e2, /* delta x */
             8.2300000000000e2, /* delta y */
             2.9900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             0.0, /* Region lower-left latitude */
             9.1000000000000e1, /* Region lower-left longitude */
             2.7000000000000e1, /* Region upper-right latitude */
             1.1100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1956_INDIA_NEPAL"), /*!< ISO18026 Label */
             new String("India and Nepal"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1956_INDIA_NEPAL, /*!< RT Code enum */
             2.9500000000000e2, /* delta x */
             7.3600000000000e2, /* delta y */
             2.5700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.0000000000000e0, /* Region lower-left latitude */
             6.2000000000000e1, /* Region lower-left longitude */
             4.4000000000000e1, /* Region upper-right latitude */
             1.0500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1960_CON_SON_ISLAND"), /*!< ISO18026 Label */
             new String("Con Son Island (Vietnam)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1960_CON_SON_ISLAND, /*!< RT Code enum */
             1.8200000000000e2, /* delta x */
             9.1500000000000e2, /* delta y */
             3.4400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             6.0000000000000e0, /* Region lower-left latitude */
             1.0400000000000e2, /* Region lower-left longitude */
             1.1000000000000e1, /* Region upper-right latitude */
             1.0900000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1960_VIETNAM_16_N"), /*!< ISO18026 Label */
             new String("Vietnam (near 16 deg. N)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1960_VIETNAM_16_N, /*!< RT Code enum */
             1.9800000000000e2, /* delta x */
             8.8100000000000e2, /* delta y */
             3.1700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.1000000000000e1, /* Region lower-left latitude */
             1.0100000000000e2, /* Region lower-left longitude */
             2.3000000000000e1, /* Region upper-right latitude */
             1.1500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1962_PAKISTAN"), /*!< ISO18026 Label */
             new String("Pakistan"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1962, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1962_PAKISTAN, /*!< RT Code enum */
             2.8300000000000e2, /* delta x */
             6.8200000000000e2, /* delta y */
             2.3100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             5.5000000000000e1, /* Region lower-left longitude */
             4.4000000000000e1, /* Region upper-right latitude */
             8.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1975_1991_THAILAND"), /*!< ISO18026 Label */
             new String("Thailand"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1975, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1975_1991_THAILAND, /*!< RT Code enum */
             2.0900000000000e2, /* delta x */
             8.1800000000000e2, /* delta y */
             2.9000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             0.0, /* Region lower-left latitude */
             9.1000000000000e1, /* Region lower-left longitude */
             2.7000000000000e1, /* Region upper-right latitude */
             1.1100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDIAN_1975_1997_THAILAND"), /*!< ISO18026 Label */
             new String("Thailand"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDIAN_1975, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDIAN_1975_1997_THAILAND, /*!< RT Code enum */
             2.1000000000000e2, /* delta x */
             8.1400000000000e2, /* delta y */
             2.8900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             0.0, /* Region lower-left latitude */
             9.1000000000000e1, /* Region lower-left longitude */
             2.7000000000000e1, /* Region upper-right latitude */
             1.1100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_INDONESIAN_1974_INDONESIA"), /*!< ISO18026 Label */
             new String("Indonesia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_INDONESIAN_1974, /*!< ORM Code */
             SRM_RT_Code.RTCOD_INDONESIAN_1974_INDONESIA, /*!< RT Code enum */
             -2.4000000000000e1, /* delta x */
             -1.5000000000000e1, /* delta y */
             5.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.6000000000000e1, /* Region lower-left latitude */
             8.9000000000000e1, /* Region lower-left longitude */
             1.1000000000000e1, /* Region upper-right latitude */
             1.4600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_IO_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Io)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_IO_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_IO_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_IRELAND_1965_3_IRELAND"), /*!< ISO18026 Label */
             new String("Ireland"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_IRELAND_1965, /*!< ORM Code */
             SRM_RT_Code.RTCOD_IRELAND_1965_3_IRELAND, /*!< RT Code enum */
             5.0600000000000e2, /* delta x */
             -1.2200000000000e2, /* delta y */
             6.1100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.0000000000000e1, /* Region lower-left latitude */
             -1.2000000000000e1, /* Region lower-left longitude */
             5.7000000000000e1, /* Region upper-right latitude */
             -4.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_IRELAND_1965_7_IRELAND"), /*!< ISO18026 Label */
             new String("Ireland"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_IRELAND_1965, /*!< ORM Code */
             SRM_RT_Code.RTCOD_IRELAND_1965_7_IRELAND, /*!< RT Code enum */
             4.8253000000000e2, /* delta x */
             -1.3059600000000e2, /* delta y */
             5.6455700000000e2, /* delta z */
             -5.0517585571614e-6, /* omega 1 */
             -1.0375012775744e-6, /* omega 2 */
             -3.0591743278012e-6, /* omega 3 */
             8.1500000000000e0, /* delta scale */
             5.0000000000000e1, /* Region lower-left latitude */
             -1.2000000000000e1, /* Region lower-left longitude */
             5.7000000000000e1, /* Region upper-right latitude */
             -4.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ISTS_061_1968_SOUTH_GEORGIA_ISLAND"), /*!< ISO18026 Label */
             new String("South Georgia Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ISTS_061_1968, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ISTS_061_1968_SOUTH_GEORGIA_ISLAND, /*!< RT Code enum */
             -7.9400000000000e2, /* delta x */
             1.1900000000000e2, /* delta y */
             -2.9800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.6000000000000e1, /* Region lower-left latitude */
             -3.8000000000000e1, /* Region lower-left longitude */
             -5.2000000000000e1, /* Region upper-right latitude */
             -3.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_ISTS_073_1969_DIEGO_GARCIA"), /*!< ISO18026 Label */
             new String("Diego Garcia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ISTS_073_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ISTS_073_1969_DIEGO_GARCIA, /*!< RT Code enum */
             2.0800000000000e2, /* delta x */
             -4.3500000000000e2, /* delta y */
             -2.2900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             6.9000000000000e1, /* Region lower-left longitude */
             -4.0000000000000e0, /* Region upper-right latitude */
             7.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_JANUS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Janus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_JANUS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_JANUS_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_JGD_2000_IDENTITY_BY_MEASUREMENT"), /*!< ISO18026 Label */
             new String("Japan"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_JGD_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_JGD_2000_IDENTITY_BY_MEASUREMENT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             1.1900000000000e2, /* Region lower-left longitude */
             5.1000000000000e1, /* Region upper-right latitude */
             1.5600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_JOHNSTON_1961_JOHNSTON_ISLAND"), /*!< ISO18026 Label */
             new String("Johnston Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_JOHNSTON_1961, /*!< ORM Code */
             SRM_RT_Code.RTCOD_JOHNSTON_1961_JOHNSTON_ISLAND, /*!< RT Code enum */
             1.8900000000000e2, /* delta x */
             -7.9000000000000e1, /* delta y */
             -2.0200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.6000000000000e1, /* Region lower-left latitude */
             -7.6000000000000e1, /* Region lower-left longitude */
             -4.3000000000000e1, /* Region upper-right latitude */
             -7.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_JULIET_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Juliet)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_JULIET_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_JULIET_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_JUPITER_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Jupiter)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_JUPITER_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_JUPITER_MAGNETIC_1993_VOYAGER"), /*!< ISO18026 Label */
             new String("Global (Jupiter)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_JUPITER_MAGNETIC_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_JUPITER_MAGNETIC_1993_VOYAGER, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.6406094968747e-1, /* omega 2 */
             2.7907814739389e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_KANDAWALA_1987_3_SRI_LANKA"), /*!< ISO18026 Label */
             new String("Sri Lanka"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_KANDAWALA_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_KANDAWALA_1987_3_SRI_LANKA, /*!< RT Code enum */
             -9.7000000000000e1, /* delta x */
             7.8700000000000e2, /* delta y */
             8.6000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.0000000000000e0, /* Region lower-left latitude */
             7.7000000000000e1, /* Region lower-left longitude */
             1.2000000000000e1, /* Region upper-right latitude */
             8.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_KERGUELEN_1949_KERGUELEN_ISLAND"), /*!< ISO18026 Label */
             new String("Kerguelen Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_KERGUELEN_1949, /*!< ORM Code */
             SRM_RT_Code.RTCOD_KERGUELEN_1949_KERGUELEN_ISLAND, /*!< RT Code enum */
             1.4500000000000e2, /* delta x */
             -1.8700000000000e2, /* delta y */
             1.0300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -8.1000000000000e1, /* Region lower-left latitude */
             1.3900000000000e2, /* Region lower-left longitude */
             -7.4000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_KERTAU_1948_3_W_MALAYSIA_SINGAPORE"), /*!< ISO18026 Label */
             new String("West Malaysia and Singapore"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_KERTAU_1948, /*!< ORM Code */
             SRM_RT_Code.RTCOD_KERTAU_1948_3_W_MALAYSIA_SINGAPORE, /*!< RT Code enum */
             -1.1000000000000e1, /* delta x */
             8.5100000000000e2, /* delta y */
             5.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.0000000000000e0, /* Region lower-left latitude */
             9.4000000000000e1, /* Region lower-left longitude */
             1.2000000000000e1, /* Region upper-right latitude */
             1.1200000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_KOREAN_GEODETIC_1995_SOUTH_KOREA"), /*!< ISO18026 Label */
             new String("South Korea"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_KOREAN_GEODETIC_1995, /*!< ORM Code */
             SRM_RT_Code.RTCOD_KOREAN_GEODETIC_1995_SOUTH_KOREA, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.7000000000000e1, /* Region lower-left latitude */
             1.2000000000000e2, /* Region lower-left longitude */
             4.5000000000000e1, /* Region upper-right latitude */
             1.3900000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_KUSAIE_1951_CAROLINE_ISLANDS"), /*!< ISO18026 Label */
             new String("Caroline Islands (Federated States of Micronesia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_KUSAIE_1951, /*!< ORM Code */
             SRM_RT_Code.RTCOD_KUSAIE_1951_CAROLINE_ISLANDS, /*!< RT Code enum */
             6.4700000000000e2, /* delta x */
             1.7770000000000e3, /* delta y */
             -1.1240000000000e3, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e0, /* Region lower-left latitude */
             1.3400000000000e2, /* Region lower-left longitude */
             1.2000000000000e1, /* Region upper-right latitude */
             1.6700000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_LARISSA_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Larissa)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_LARISSA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_LARISSA_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_LC5_1961_CAYMAN_BRAC_ISLAND"), /*!< ISO18026 Label */
             new String("Cayman Brac Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_LC5_1961, /*!< ORM Code */
             SRM_RT_Code.RTCOD_LC5_1961_CAYMAN_BRAC_ISLAND, /*!< RT Code enum */
             4.2000000000000e1, /* delta x */
             1.2400000000000e2, /* delta y */
             1.4700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.8000000000000e1, /* Region lower-left latitude */
             -8.1000000000000e1, /* Region lower-left longitude */
             2.1000000000000e1, /* Region upper-right latitude */
             -7.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_LEIGON_1991_3_GHANA"), /*!< ISO18026 Label */
             new String("Ghana"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_LEIGON_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_LEIGON_1991_3_GHANA, /*!< RT Code enum */
             -1.3000000000000e2, /* delta x */
             2.9000000000000e1, /* delta y */
             3.6400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e0, /* Region lower-left latitude */
             -9.0000000000000e0, /* Region lower-left longitude */
             1.7000000000000e1, /* Region upper-right latitude */
             7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_LEIGON_1991_7_GHANA"), /*!< ISO18026 Label */
             new String("Ghana"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_LEIGON_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_LEIGON_1991_7_GHANA, /*!< RT Code enum */
             -1.3558000000000e2, /* delta x */
             1.3230000000000e1, /* delta y */
             3.6413000000000e2, /* delta z */
             9.7777223206171e-6, /* omega 1 */
             -1.2411230236404e-7, /* omega 2 */
             3.9226274938573e-6, /* omega 3 */
             7.1900000000000e-1, /* delta scale */
             -1.0000000000000e0, /* Region lower-left latitude */
             -9.0000000000000e0, /* Region lower-left longitude */
             1.7000000000000e1, /* Region upper-right latitude */
             7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_LIBERIA_1964_LIBERIA"), /*!< ISO18026 Label */
             new String("Liberia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_LIBERIA_1964, /*!< ORM Code */
             SRM_RT_Code.RTCOD_LIBERIA_1964_LIBERIA, /*!< RT Code enum */
             -9.0000000000000e1, /* delta x */
             4.0000000000000e1, /* delta y */
             8.8000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e0, /* Region lower-left latitude */
             -1.7000000000000e1, /* Region lower-left longitude */
             1.4000000000000e1, /* Region upper-right latitude */
             -1.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_LUZON_1987_MINDANAO_ISLAND"), /*!< ISO18026 Label */
             new String("Mindanao Island (Philippines)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_LUZON_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_LUZON_1987_MINDANAO_ISLAND, /*!< RT Code enum */
             -1.3300000000000e2, /* delta x */
             -7.9000000000000e1, /* delta y */
             -7.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.0000000000000e0, /* Region lower-left latitude */
             1.2000000000000e2, /* Region lower-left longitude */
             1.2000000000000e1, /* Region upper-right latitude */
             1.2800000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND"), /*!< ISO18026 Label */
             new String("Philippines (excluding Mindanao Island)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_LUZON_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND, /*!< RT Code enum */
             -1.3300000000000e2, /* delta x */
             -7.7000000000000e1, /* delta y */
             -5.1000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e0, /* Region lower-left latitude */
             1.1500000000000e2, /* Region lower-left longitude */
             2.3000000000000e1, /* Region upper-right latitude */
             1.2800000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_M_PORALOKO_1991_GABON"), /*!< ISO18026 Label */
             new String("Gabon"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_M_PORALOKO_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_M_PORALOKO_1991_GABON, /*!< RT Code enum */
             -7.4000000000000e1, /* delta x */
             -1.3000000000000e2, /* delta y */
             4.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             3.0000000000000e0, /* Region lower-left longitude */
             8.0000000000000e0, /* Region upper-right latitude */
             2.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MAHE_1971_MAHE_ISLAND"), /*!< ISO18026 Label */
             new String("Mahe Island (Seychelles)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MAHE_1971, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MAHE_1971_MAHE_ISLAND, /*!< RT Code enum */
             4.1000000000000e1, /* delta x */
             -2.2000000000000e2, /* delta y */
             -1.3400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.0000000000000e0, /* Region lower-left latitude */
             5.4000000000000e1, /* Region lower-left longitude */
             -3.0000000000000e0, /* Region upper-right latitude */
             5.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MARCUS_STATION_1952_MARCUS_ISLANDS"), /*!< ISO18026 Label */
             new String("Marcus Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MARCUS_STATION_1952, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MARCUS_STATION_1952_MARCUS_ISLANDS, /*!< RT Code enum */
             1.2400000000000e2, /* delta x */
             -2.3400000000000e2, /* delta y */
             -2.5000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.2000000000000e1, /* Region lower-left latitude */
             1.5200000000000e2, /* Region lower-left longitude */
             2.6000000000000e1, /* Region upper-right latitude */
             1.5600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MARS_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Mars)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MARS_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MARS_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MARS_SPHERE_2000_GLOBAL"), /*!< ISO18026 Label */
             new String("Global (Mars)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MARS_SPHERE_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MARS_SPHERE_2000_GLOBAL, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MASS_1999_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MASS_1999, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MASS_1999_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MASSAWA_1987_ERITREA_ETHIOPIA"), /*!< ISO18026 Label */
             new String("Eritrea and Ethiopia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MASSAWA_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MASSAWA_1987_ERITREA_ETHIOPIA, /*!< RT Code enum */
             6.3900000000000e2, /* delta x */
             4.0500000000000e2, /* delta y */
             6.0000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             7.0000000000000e0, /* Region lower-left latitude */
             3.7000000000000e1, /* Region lower-left longitude */
             2.5000000000000e1, /* Region upper-right latitude */
             5.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MERCHICH_1987_MOROCCO"), /*!< ISO18026 Label */
             new String("Morocco"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MERCHICH_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MERCHICH_1987_MOROCCO, /*!< RT Code enum */
             3.1000000000000e1, /* delta x */
             1.4600000000000e2, /* delta y */
             4.7000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.2000000000000e1, /* Region lower-left latitude */
             -1.9000000000000e1, /* Region lower-left longitude */
             4.2000000000000e1, /* Region upper-right latitude */
             5.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MERCURY_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Mercury)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MERCURY_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MERCURY_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_METIS_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Metis)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_METIS_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_METIS_2000_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MIDWAY_1961_MIDWAY_ISLANDS"), /*!< ISO18026 Label */
             new String("Midway Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MIDWAY_1961, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MIDWAY_1961_MIDWAY_ISLANDS, /*!< RT Code enum */
             4.0300000000000e2, /* delta x */
             -8.1000000000000e1, /* delta y */
             2.7700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.5000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             3.0000000000000e1, /* Region upper-right latitude */
             -1.6900000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MIMAS_1994_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Mimas)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MIMAS_1994, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MIMAS_1994_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MINNA_1991_CAMEROON"), /*!< ISO18026 Label */
             new String("Cameroon"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MINNA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MINNA_1991_CAMEROON, /*!< RT Code enum */
             -8.1000000000000e1, /* delta x */
             -8.4000000000000e1, /* delta y */
             1.1500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.0000000000000e0, /* Region lower-left latitude */
             3.0000000000000e0, /* Region lower-left longitude */
             1.9000000000000e1, /* Region upper-right latitude */
             2.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MINNA_1991_NIGERIA"), /*!< ISO18026 Label */
             new String("Nigeria"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MINNA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MINNA_1991_NIGERIA, /*!< RT Code enum */
             -9.2000000000000e1, /* delta x */
             -9.3000000000000e1, /* delta y */
             1.2200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e0, /* Region lower-left latitude */
             -4.0000000000000e0, /* Region lower-left longitude */
             2.1000000000000e1, /* Region upper-right latitude */
             2.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MIRANDA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Miranda)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MIRANDA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MIRANDA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MM5_1997_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MM5_1997, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MM5_1997_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Northern midlatitude regions (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MODTRAN_MIDLAT_N_1989, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             6.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Southern midlatitude regions (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MODTRAN_MIDLAT_S_1989, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             -3.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Northern subarctic regions (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MODTRAN_SUBARCTIC_N_1989, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             6.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             7.5000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Southern subarctic regions (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MODTRAN_SUBARCTIC_S_1989, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -7.5000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             -6.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Tropical regions (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MODTRAN_TROPICAL_1989, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             3.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS"), /*!< ISO18026 Label */
             new String("Montserrat and Leeward Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MONTSERRAT_1958, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS, /*!< RT Code enum */
             1.7400000000000e2, /* delta x */
             3.5900000000000e2, /* delta y */
             3.6500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.5000000000000e1, /* Region lower-left latitude */
             -6.4000000000000e1, /* Region lower-left longitude */
             1.8000000000000e1, /* Region upper-right latitude */
             -6.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MOON_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Moon)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MOON_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MOON_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_MULTIGEN_FLAT_EARTH_1989, /*!< ORM Code */
             SRM_RT_Code.RTCOD_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS"), /*!< ISO18026 Label */
             new String("Alaska (excluding Aleutian Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS, /*!< RT Code enum */
             -5.0000000000000e0, /* delta x */
             1.3500000000000e2, /* delta y */
             1.7200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.7000000000000e1, /* Region lower-left latitude */
             -1.7500000000000e2, /* Region lower-left longitude */
             7.8000000000000e1, /* Region upper-right latitude */
             -1.3000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_ALBERTA_BRITISH_COLUMBIA"), /*!< ISO18026 Label */
             new String("Canada (Alberta and British Columbia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_ALBERTA_BRITISH_COLUMBIA, /*!< RT Code enum */
             -7.0000000000000e0, /* delta x */
             1.6200000000000e2, /* delta y */
             1.8800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.3000000000000e1, /* Region lower-left latitude */
             -1.4500000000000e2, /* Region lower-left longitude */
             6.5000000000000e1, /* Region upper-right latitude */
             -1.0500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND"), /*!< ISO18026 Label */
             new String("Bahamas (excluding San Salvador Island)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND, /*!< RT Code enum */
             -4.0000000000000e0, /* delta x */
             1.5400000000000e2, /* delta y */
             1.7800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             -8.3000000000000e1, /* Region lower-left longitude */
             2.9000000000000e1, /* Region upper-right latitude */
             -7.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_CANADA"), /*!< ISO18026 Label */
             new String("Canada"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_CANADA, /*!< RT Code enum */
             -1.0000000000000e1, /* delta x */
             1.5800000000000e2, /* delta y */
             1.8700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.6000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             -5.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_CANAL_ZONE"), /*!< ISO18026 Label */
             new String("Canal Zone"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_CANAL_ZONE, /*!< RT Code enum */
             0.0, /* delta x */
             1.2500000000000e2, /* delta y */
             2.0100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e0, /* Region lower-left latitude */
             -8.6000000000000e1, /* Region lower-left longitude */
             1.5000000000000e1, /* Region upper-right latitude */
             -7.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_CARIBBEAN"), /*!< ISO18026 Label */
             new String("Caribbean (Antigua Island, Barbados, Barbuda, Caicos Islands, Cuba, Dominican Republic, Grand Cayman, Jamaica and Turks Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_CARIBBEAN, /*!< RT Code enum */
             -3.0000000000000e0, /* delta x */
             1.4200000000000e2, /* delta y */
             1.8300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             8.0000000000000e0, /* Region lower-left latitude */
             -8.7000000000000e1, /* Region lower-left longitude */
             2.9000000000000e1, /* Region upper-right latitude */
             -5.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_CENTRAL_AMERICA"), /*!< ISO18026 Label */
             new String("Central America (Belize, Costa Rica, El Salvador, Guatemala, Honduras and Nicaragua)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_CENTRAL_AMERICA, /*!< RT Code enum */
             0.0, /* delta x */
             1.2500000000000e2, /* delta y */
             1.9400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.0000000000000e0, /* Region lower-left latitude */
             -9.8000000000000e1, /* Region lower-left longitude */
             2.5000000000000e1, /* Region upper-right latitude */
             -7.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_CONTINENTAL_US"), /*!< ISO18026 Label */
             new String("Continental United States Mean Solution"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_CONTINENTAL_US, /*!< RT Code enum */
             -8.0000000000000e0, /* delta x */
             1.6000000000000e2, /* delta y */
             1.7600000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.5000000000000e1, /* Region lower-left latitude */
             -1.3500000000000e2, /* Region lower-left longitude */
             6.0000000000000e1, /* Region upper-right latitude */
             -6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_CUBA"), /*!< ISO18026 Label */
             new String("Cuba"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_CUBA, /*!< RT Code enum */
             -9.0000000000000e0, /* delta x */
             1.5200000000000e2, /* delta y */
             1.7800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.8000000000000e1, /* Region lower-left latitude */
             -8.7000000000000e1, /* Region lower-left longitude */
             2.5000000000000e1, /* Region upper-right latitude */
             -7.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_EAST_ALEUTIAN_ISLANDS"), /*!< ISO18026 Label */
             new String("Aleutian Islands (east of 180 deg. W)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_EAST_ALEUTIAN_ISLANDS, /*!< RT Code enum */
             -2.0000000000000e0, /* delta x */
             1.5200000000000e2, /* delta y */
             1.4900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             5.8000000000000e1, /* Region upper-right latitude */
             -1.6100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_EASTERN_CANADA"), /*!< ISO18026 Label */
             new String("Eastern Canada (New Brunswick, Newfoundland, Nova Scotia and Quebec)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_EASTERN_CANADA, /*!< RT Code enum */
             -2.2000000000000e1, /* delta x */
             1.6000000000000e2, /* delta y */
             1.9000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.8000000000000e1, /* Region lower-left latitude */
             -8.5000000000000e1, /* Region lower-left longitude */
             6.8000000000000e1, /* Region upper-right latitude */
             -4.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_EASTERN_US"), /*!< ISO18026 Label */
             new String("Eastern United States (Alabama, Connecticut, Delaware, District of Columbia, Florida, Georgia, Illinois, Indiana, Kentucky, Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, New Hampshire, New Jersey, New York, North Carolina, Ohio, Pennsylvania, Rhode Island, South Carolina, Tennessee, Vermont, Virginia, West Virginia and Wisconsin)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_EASTERN_US, /*!< RT Code enum */
             -9.0000000000000e0, /* delta x */
             1.6100000000000e2, /* delta y */
             1.7900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.8000000000000e1, /* Region lower-left latitude */
             -1.0200000000000e2, /* Region lower-left longitude */
             5.5000000000000e1, /* Region upper-right latitude */
             -6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_HAYES_PENINSULA"), /*!< ISO18026 Label */
             new String("Hayes Peninsula (Greenland)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_HAYES_PENINSULA, /*!< RT Code enum */
             1.1000000000000e1, /* delta x */
             1.1400000000000e2, /* delta y */
             1.9500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             7.4000000000000e1, /* Region lower-left latitude */
             -7.4000000000000e1, /* Region lower-left longitude */
             8.1000000000000e1, /* Region upper-right latitude */
             -5.6000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_MANITOBA_ONTARIO"), /*!< ISO18026 Label */
             new String("Canada (Manitoba and Ontario)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_MANITOBA_ONTARIO, /*!< RT Code enum */
             -9.0000000000000e0, /* delta x */
             1.5700000000000e2, /* delta y */
             1.8400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.6000000000000e1, /* Region lower-left latitude */
             -1.0800000000000e2, /* Region lower-left longitude */
             6.3000000000000e1, /* Region upper-right latitude */
             -6.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_MEXICO"), /*!< ISO18026 Label */
             new String("Mexico"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_MEXICO, /*!< RT Code enum */
             -1.2000000000000e1, /* delta x */
             1.3000000000000e2, /* delta y */
             1.9000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.0000000000000e1, /* Region lower-left latitude */
             -1.2200000000000e2, /* Region lower-left longitude */
             3.8000000000000e1, /* Region upper-right latitude */
             -8.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN"), /*!< ISO18026 Label */
             new String("Canada (Northwest Territories and Saskatchewan)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN, /*!< RT Code enum */
             4.0000000000000e0, /* delta x */
             1.5900000000000e2, /* delta y */
             1.8800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.3000000000000e1, /* Region lower-left latitude */
             -1.4400000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             -5.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_SAN_SALVADOR_ISLAND"), /*!< ISO18026 Label */
             new String("San Salvador Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_SAN_SALVADOR_ISLAND, /*!< RT Code enum */
             1.0000000000000e0, /* delta x */
             1.4000000000000e2, /* delta y */
             1.6500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.3000000000000e1, /* Region lower-left latitude */
             -7.5000000000000e1, /* Region lower-left longitude */
             2.6000000000000e1, /* Region upper-right latitude */
             -7.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_WEST_ALEUTIAN_ISLANDS"), /*!< ISO18026 Label */
             new String("Aleutian Islands (west of 180 deg. W)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_WEST_ALEUTIAN_ISLANDS, /*!< RT Code enum */
             2.0000000000000e0, /* delta x */
             2.0400000000000e2, /* delta y */
             1.0500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.0000000000000e1, /* Region lower-left latitude */
             1.6900000000000e2, /* Region lower-left longitude */
             5.8000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_WESTERN_US"), /*!< ISO18026 Label */
             new String("Western United States (Arizona, Arkansas, California, Colorado, Idaho, Iowa, Kansas, Montana, Nebraska, Nevada, New Mexico, North Dakota, Oklahoma, Oregon, South Dakota, Texas, Utah, Washington and Wyoming)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_WESTERN_US, /*!< RT Code enum */
             -8.0000000000000e0, /* delta x */
             1.5900000000000e2, /* delta y */
             1.7500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             -1.3200000000000e2, /* Region lower-left longitude */
             5.5000000000000e1, /* Region upper-right latitude */
             -8.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1927_YUKON"), /*!< ISO18026 Label */
             new String("Canada (Yukon)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1927_YUKON, /*!< RT Code enum */
             -7.0000000000000e0, /* delta x */
             1.3900000000000e2, /* delta y */
             1.8100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.3000000000000e1, /* Region lower-left latitude */
             -1.4700000000000e2, /* Region lower-left longitude */
             7.5000000000000e1, /* Region upper-right latitude */
             -1.1700000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS"), /*!< ISO18026 Label */
             new String("Alaska (excluding Aleutian Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1983, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.8000000000000e1, /* Region lower-left latitude */
             -1.7500000000000e2, /* Region lower-left longitude */
             7.8000000000000e1, /* Region upper-right latitude */
             -1.3500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1983_ALEUTIAN_ISLANDS"), /*!< ISO18026 Label */
             new String("Aleutian Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1983, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1983_ALEUTIAN_ISLANDS, /*!< RT Code enum */
             -2.0000000000000e0, /* delta x */
             0.0, /* delta y */
             4.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.1000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             7.4000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1983_CANADA"), /*!< ISO18026 Label */
             new String("Canada"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1983, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1983_CANADA, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.6000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             -5.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1983_CONTINENTAL_US"), /*!< ISO18026 Label */
             new String("Continental United States"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1983, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1983_CONTINENTAL_US, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.5000000000000e1, /* Region lower-left latitude */
             -1.3500000000000e2, /* Region lower-left longitude */
             6.0000000000000e1, /* Region upper-right latitude */
             -6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1983_HAWAII"), /*!< ISO18026 Label */
             new String("Hawaii"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1983, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1983_HAWAII, /*!< RT Code enum */
             1.0000000000000e0, /* delta x */
             1.0000000000000e0, /* delta y */
             -1.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             -1.6400000000000e2, /* Region lower-left longitude */
             2.4000000000000e1, /* Region upper-right latitude */
             -1.5300000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_AM_1983_MEXICO_CENTRAL_AMERICA"), /*!< ISO18026 Label */
             new String("Mexico and Central America"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_AM_1983, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_AM_1983_MEXICO_CENTRAL_AMERICA, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.1000000000000e1, /* Region lower-left latitude */
             -1.2200000000000e2, /* Region lower-left longitude */
             3.5000000000000e1, /* Region upper-right latitude */
             -7.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_N_SAHARA_1959_ALGERIA"), /*!< ISO18026 Label */
             new String("Algeria"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_N_SAHARA_1959, /*!< ORM Code */
             SRM_RT_Code.RTCOD_N_SAHARA_1959_ALGERIA, /*!< RT Code enum */
             -1.8600000000000e2, /* delta x */
             -9.3000000000000e1, /* delta y */
             3.1000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.3000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e1, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             1.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NAHRWAN_1987_MASIRAH_ISLAND"), /*!< ISO18026 Label */
             new String("Masirah Island (Oman)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NAHRWAN_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NAHRWAN_1987_MASIRAH_ISLAND, /*!< RT Code enum */
             -2.4700000000000e2, /* delta x */
             -1.4800000000000e2, /* delta y */
             3.6900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             5.7000000000000e1, /* Region lower-left longitude */
             2.2000000000000e1, /* Region upper-right latitude */
             6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NAHRWAN_1987_SAUDI_ARABIA"), /*!< ISO18026 Label */
             new String("Saudi Arabia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NAHRWAN_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NAHRWAN_1987_SAUDI_ARABIA, /*!< RT Code enum */
             -2.4300000000000e2, /* delta x */
             -1.9200000000000e2, /* delta y */
             4.7700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             8.0000000000000e0, /* Region lower-left latitude */
             2.8000000000000e1, /* Region lower-left longitude */
             3.8000000000000e1, /* Region upper-right latitude */
             6.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NAHRWAN_1987_UNITED_ARAB_EMIRATES"), /*!< ISO18026 Label */
             new String("United Arab Emirates"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NAHRWAN_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NAHRWAN_1987_UNITED_ARAB_EMIRATES, /*!< RT Code enum */
             -2.4900000000000e2, /* delta x */
             -1.5600000000000e2, /* delta y */
             3.8100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             4.5000000000000e1, /* Region lower-left longitude */
             3.2000000000000e1, /* Region upper-right latitude */
             6.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NAIAD_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Naiad)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NAIAD_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NAIAD_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NAPARIMA_1991_TRINIDAD_TOBAGO"), /*!< ISO18026 Label */
             new String("Trinidad and Tobago (British West Indies)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NAPARIMA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NAPARIMA_1991_TRINIDAD_TOBAGO, /*!< RT Code enum */
             -1.0000000000000e1, /* delta x */
             3.7500000000000e2, /* delta y */
             1.6500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             8.0000000000000e0, /* Region lower-left latitude */
             -6.4000000000000e1, /* Region lower-left longitude */
             1.3000000000000e1, /* Region upper-right latitude */
             -5.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NEPTUNE_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Neptune)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NEPTUNE_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NEPTUNE_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NEPTUNE_MAGNETIC_1993_VOYAGER"), /*!< ISO18026 Label */
             new String("Global (Neptune)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NEPTUNE_MAGNETIC_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NEPTUNE_MAGNETIC_1993_VOYAGER, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             8.1855941918534e-1, /* omega 2 */
             -1.2566370614359e0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NOGAPS_1988_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NOGAPS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NOGAPS_1988_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NTF_1896_FRANCE"), /*!< ISO18026 Label */
             new String("France"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NTF_1896, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NTF_1896_FRANCE, /*!< RT Code enum */
             -1.6800000000000e2, /* delta x */
             -6.0000000000000e1, /* delta y */
             3.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.2000000000000e1, /* Region lower-left latitude */
             -6.0000000000000e0, /* Region lower-left longitude */
             5.2000000000000e1, /* Region upper-right latitude */
             1.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_NTF_1896_PM_PARIS_FRANCE"), /*!< ISO18026 Label */
             new String("France"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_NTF_1896_PM_PARIS, /*!< ORM Code */
             SRM_RT_Code.RTCOD_NTF_1896_PM_PARIS_FRANCE, /*!< RT Code enum */
             -1.6800000000000e2, /* delta x */
             -6.0000000000000e1, /* delta y */
             3.2000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             4.0792344331977e-2, /* omega 3 */
             0.0, /* delta scale */
             4.2000000000000e1, /* Region lower-left latitude */
             -8.0000000000000e0, /* Region lower-left longitude */
             5.2000000000000e1, /* Region upper-right latitude */
             8.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OBERON_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Oberon)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OBERON_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OBERON_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS"), /*!< ISO18026 Label */
             new String("Corvo Flores Islands (Azores)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OBSERV_METEORO_1939, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS, /*!< RT Code enum */
             -4.2500000000000e2, /* delta x */
             -1.6900000000000e2, /* delta y */
             8.1000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.8000000000000e1, /* Region lower-left latitude */
             -3.3000000000000e1, /* Region lower-left longitude */
             4.1000000000000e1, /* Region upper-right latitude */
             -3.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_EGYPTIAN_1907_EGYPT"), /*!< ISO18026 Label */
             new String("Egypt"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_EGYPTIAN_1907, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_EGYPTIAN_1907_EGYPT, /*!< RT Code enum */
             -1.3000000000000e2, /* delta x */
             1.1000000000000e2, /* delta y */
             -1.3000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.6000000000000e1, /* Region lower-left latitude */
             1.9000000000000e1, /* Region lower-left longitude */
             3.8000000000000e1, /* Region upper-right latitude */
             4.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_C_1987_HAWAII"), /*!< ISO18026 Label */
             new String("Hawaii (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_CLARKE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_C_1987_HAWAII, /*!< RT Code enum */
             8.9000000000000e1, /* delta x */
             -2.7900000000000e2, /* delta y */
             -1.8300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             -1.5800000000000e2, /* Region lower-left longitude */
             2.2000000000000e1, /* Region upper-right latitude */
             -1.5300000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_C_1987_KAUAI"), /*!< ISO18026 Label */
             new String("Kauai (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_CLARKE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_C_1987_KAUAI, /*!< RT Code enum */
             4.5000000000000e1, /* delta x */
             -2.9000000000000e2, /* delta y */
             -1.7200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.0000000000000e1, /* Region lower-left latitude */
             -1.6100000000000e2, /* Region lower-left longitude */
             2.4000000000000e1, /* Region upper-right latitude */
             -1.5800000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_C_1987_MAUI"), /*!< ISO18026 Label */
             new String("Maui (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_CLARKE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_C_1987_MAUI, /*!< RT Code enum */
             6.5000000000000e1, /* delta x */
             -2.9000000000000e2, /* delta y */
             -1.9000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             -1.5800000000000e2, /* Region lower-left longitude */
             2.3000000000000e1, /* Region upper-right latitude */
             -1.5400000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_C_1987_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Hawaii (US))"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_CLARKE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_C_1987_MEAN_SOLUTION, /*!< RT Code enum */
             6.1000000000000e1, /* delta x */
             -2.8500000000000e2, /* delta y */
             -1.8100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             -1.6400000000000e2, /* Region lower-left longitude */
             2.4000000000000e1, /* Region upper-right latitude */
             -1.5300000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_C_1987_OAHU"), /*!< ISO18026 Label */
             new String("Oahu (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_CLARKE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_C_1987_OAHU, /*!< RT Code enum */
             5.8000000000000e1, /* delta x */
             -2.8300000000000e2, /* delta y */
             -1.8200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.0000000000000e1, /* Region lower-left latitude */
             -1.6000000000000e2, /* Region lower-left longitude */
             2.3000000000000e1, /* Region upper-right latitude */
             -1.5600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_I_1987_HAWAII"), /*!< ISO18026 Label */
             new String("Hawaii (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_INT_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_I_1987_HAWAII, /*!< RT Code enum */
             2.2900000000000e2, /* delta x */
             -2.2200000000000e2, /* delta y */
             -3.4800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             -1.5800000000000e2, /* Region lower-left longitude */
             2.2000000000000e1, /* Region upper-right latitude */
             -1.5300000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_I_1987_KAUAI"), /*!< ISO18026 Label */
             new String("Kauai (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_INT_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_I_1987_KAUAI, /*!< RT Code enum */
             1.8500000000000e2, /* delta x */
             -2.3300000000000e2, /* delta y */
             -3.3700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.0000000000000e1, /* Region lower-left latitude */
             -1.6100000000000e2, /* Region lower-left longitude */
             2.4000000000000e1, /* Region upper-right latitude */
             -1.5800000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_I_1987_MAUI"), /*!< ISO18026 Label */
             new String("Maui (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_INT_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_I_1987_MAUI, /*!< RT Code enum */
             2.0500000000000e2, /* delta x */
             -2.3300000000000e2, /* delta y */
             -3.5500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             -1.5800000000000e2, /* Region lower-left longitude */
             2.3000000000000e1, /* Region upper-right latitude */
             -1.5400000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_I_1987_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Hawaii (US))"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_INT_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_I_1987_MEAN_SOLUTION, /*!< RT Code enum */
             2.0100000000000e2, /* delta x */
             -2.2800000000000e2, /* delta y */
             -3.4600000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             -1.6400000000000e2, /* Region lower-left longitude */
             2.4000000000000e1, /* Region upper-right latitude */
             -1.5300000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OLD_HAWAII_I_1987_OAHU"), /*!< ISO18026 Label */
             new String("Oahu (US)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_INT_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OLD_HAWAII_I_1987_OAHU, /*!< RT Code enum */
             1.9800000000000e2, /* delta x */
             -2.2600000000000e2, /* delta y */
             -3.4700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.0000000000000e1, /* Region lower-left latitude */
             -1.6000000000000e2, /* Region lower-left longitude */
             2.3000000000000e1, /* Region upper-right latitude */
             -1.5600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OPHELIA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Ophelia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OPHELIA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OPHELIA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OSGB_1936_3_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (England, Isle of Man, Scotland, Shetland, and Wales)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OSGB_1936, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OSGB_1936_3_MEAN_SOLUTION, /*!< RT Code enum */
             3.7500000000000e2, /* delta x */
             -1.1100000000000e2, /* delta y */
             4.3100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.4000000000000e1, /* Region lower-left latitude */
             -1.4000000000000e1, /* Region lower-left longitude */
             6.6000000000000e1, /* Region upper-right latitude */
             7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OSGB_1936_7_GREAT_BRITAIN"), /*!< ISO18026 Label */
             new String("Great Britain"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OSGB_1936, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OSGB_1936_7_GREAT_BRITAIN, /*!< RT Code enum */
             4.4644800000000e2, /* delta x */
             -1.2515700000000e2, /* delta y */
             5.4206000000000e2, /* delta z */
             7.2722052166430e-7, /* omega 1 */
             1.1974897923406e-6, /* omega 2 */
             4.0826160086234e-6, /* omega 3 */
             -2.0490000000000e1, /* delta scale */
             4.9000000000000e1, /* Region lower-left latitude */
             -9.0000000000000e0, /* Region lower-left longitude */
             6.0000000000000e1, /* Region upper-right latitude */
             3.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OSGB_1936_ENGLAND"), /*!< ISO18026 Label */
             new String("England"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OSGB_1936, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OSGB_1936_ENGLAND, /*!< RT Code enum */
             3.7100000000000e2, /* delta x */
             -1.1200000000000e2, /* delta y */
             4.3400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.4000000000000e1, /* Region lower-left latitude */
             -1.2000000000000e1, /* Region lower-left longitude */
             6.1000000000000e1, /* Region upper-right latitude */
             7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES"), /*!< ISO18026 Label */
             new String("England, Isle of Man, and Wales"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OSGB_1936, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES, /*!< RT Code enum */
             3.7100000000000e2, /* delta x */
             -1.1100000000000e2, /* delta y */
             4.3400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.4000000000000e1, /* Region lower-left latitude */
             -1.2000000000000e1, /* Region lower-left longitude */
             6.1000000000000e1, /* Region upper-right latitude */
             7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS"), /*!< ISO18026 Label */
             new String("Scotland and Shetland Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OSGB_1936, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS, /*!< RT Code enum */
             3.8400000000000e2, /* delta x */
             -1.1100000000000e2, /* delta y */
             4.2500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.9000000000000e1, /* Region lower-left latitude */
             -1.4000000000000e1, /* Region lower-left longitude */
             6.6000000000000e1, /* Region upper-right latitude */
             4.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_OSGB_1936_WALES"), /*!< ISO18026 Label */
             new String("Wales"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_OSGB_1936, /*!< ORM Code */
             SRM_RT_Code.RTCOD_OSGB_1936_WALES, /*!< RT Code enum */
             3.7000000000000e2, /* delta x */
             -1.0800000000000e2, /* delta y */
             4.3400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.6000000000000e1, /* Region lower-left latitude */
             -1.1000000000000e1, /* Region lower-left longitude */
             5.9000000000000e1, /* Region upper-right latitude */
             3.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PAN_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Pan)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PAN_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PAN_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PANDORA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Pandora)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PANDORA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PANDORA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PHOBOS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Phobos)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PHOBOS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PHOBOS_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PHOEBE_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Phoebe)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PHOEBE_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PHOEBE_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS"), /*!< ISO18026 Label */
             new String("Canary Islands (Spain)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PICO_DE_LAS_NIEVES_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS, /*!< RT Code enum */
             -3.0700000000000e2, /* delta x */
             -9.2000000000000e1, /* delta y */
             1.2700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.6000000000000e1, /* Region lower-left latitude */
             -2.0000000000000e1, /* Region lower-left longitude */
             3.1000000000000e1, /* Region upper-right latitude */
             -1.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PITCAIRN_1967_PITCAIRN_ISLAND"), /*!< ISO18026 Label */
             new String("Pitcairn Island"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PITCAIRN_1967, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PITCAIRN_1967_PITCAIRN_ISLAND, /*!< RT Code enum */
             1.8500000000000e2, /* delta x */
             1.6500000000000e2, /* delta y */
             4.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.7000000000000e1, /* Region lower-left latitude */
             -1.3400000000000e2, /* Region lower-left longitude */
             -2.1000000000000e1, /* Region upper-right latitude */
             -1.1900000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PLUTO_1994_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Pluto)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PLUTO_1994, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PLUTO_1994_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_POINT_58_1991_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Burkina Faso and Niger)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_POINT_58_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_POINT_58_1991_MEAN_SOLUTION, /*!< RT Code enum */
             -1.0600000000000e2, /* delta x */
             -1.2900000000000e2, /* delta y */
             1.6500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             0.0, /* Region lower-left latitude */
             -1.5000000000000e1, /* Region lower-left longitude */
             1.0000000000000e1, /* Region upper-right latitude */
             2.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_POINTE_NOIRE_1948_CONGO"), /*!< ISO18026 Label */
             new String("Congo"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_POINTE_NOIRE_1948, /*!< ORM Code */
             SRM_RT_Code.RTCOD_POINTE_NOIRE_1948_CONGO, /*!< RT Code enum */
             -1.4800000000000e2, /* delta x */
             5.1000000000000e1, /* delta y */
             -2.9100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.1000000000000e1, /* Region lower-left latitude */
             5.0000000000000e0, /* Region lower-left longitude */
             1.0000000000000e1, /* Region upper-right latitude */
             2.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PORTIA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Portia)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PORTIA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PORTIA_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS"), /*!< ISO18026 Label */
             new String("Porto Santo and Madeira Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PORTO_SANTO_1936, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS, /*!< RT Code enum */
             -4.9900000000000e2, /* delta x */
             -2.4900000000000e2, /* delta y */
             3.1400000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.1000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e1, /* Region lower-left longitude */
             3.5000000000000e1, /* Region upper-right latitude */
             -1.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROMETHEUS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Prometheus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROMETHEUS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROMETHEUS_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROTEUS_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Proteus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROTEUS_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROTEUS_1991_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_3_VENEZUELA"), /*!< ISO18026 Label */
             new String("Venezuela"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_3_VENEZUELA, /*!< RT Code enum */
             -2.9500000000000e2, /* delta x */
             1.7300000000000e2, /* delta y */
             -3.7100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.0000000000000e0, /* Region lower-left latitude */
             -7.9000000000000e1, /* Region lower-left longitude */
             1.8000000000000e1, /* Region upper-right latitude */
             -5.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_7_VENEZUELA"), /*!< ISO18026 Label */
             new String("Venezuela"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_7_VENEZUELA, /*!< RT Code enum */
             -1.9743000000000e2, /* delta x */
             1.3939000000000e2, /* delta y */
             -1.9280000000000e2, /* delta z */
             2.5530288447228e-5, /* omega 1 */
             6.0019933721361e-6, /* omega 2 */
             -1.1543413747218e-5, /* omega 3 */
             -5.1090000000000e0, /* delta scale */
             -5.0000000000000e0, /* Region lower-left latitude */
             -7.9000000000000e1, /* Region lower-left longitude */
             1.8000000000000e1, /* Region upper-right latitude */
             -5.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_BOLIVIA"), /*!< ISO18026 Label */
             new String("Bolivia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_BOLIVIA, /*!< RT Code enum */
             -2.7000000000000e2, /* delta x */
             1.8800000000000e2, /* delta y */
             -3.8800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.8000000000000e1, /* Region lower-left latitude */
             -7.5000000000000e1, /* Region lower-left longitude */
             -4.0000000000000e0, /* Region upper-right latitude */
             -5.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_COLOMBIA"), /*!< ISO18026 Label */
             new String("Colombia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_COLOMBIA, /*!< RT Code enum */
             -2.8200000000000e2, /* delta x */
             1.6900000000000e2, /* delta y */
             -3.7100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             -8.5000000000000e1, /* Region lower-left longitude */
             1.6000000000000e1, /* Region upper-right latitude */
             -6.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_ECUADOR"), /*!< ISO18026 Label */
             new String("Ecuador"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_ECUADOR, /*!< RT Code enum */
             -2.7800000000000e2, /* delta x */
             1.7100000000000e2, /* delta y */
             -3.6700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.1000000000000e1, /* Region lower-left latitude */
             -8.5000000000000e1, /* Region lower-left longitude */
             7.0000000000000e0, /* Region upper-right latitude */
             -7.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_GUYANA"), /*!< ISO18026 Label */
             new String("Guyana"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_GUYANA, /*!< RT Code enum */
             -2.9800000000000e2, /* delta x */
             1.5900000000000e2, /* delta y */
             -3.6900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.0000000000000e0, /* Region lower-left latitude */
             -6.7000000000000e1, /* Region lower-left longitude */
             1.4000000000000e1, /* Region upper-right latitude */
             -5.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Bolivia, Chile, Colombia, Ecuador, Guyana, Peru and Venezuela)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_MEAN_SOLUTION, /*!< RT Code enum */
             -2.8800000000000e2, /* delta x */
             1.7500000000000e2, /* delta y */
             -3.7600000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.4000000000000e1, /* Region lower-left latitude */
             -8.7000000000000e1, /* Region lower-left longitude */
             1.8000000000000e1, /* Region upper-right latitude */
             -5.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_N_CHILE_19_S"), /*!< ISO18026 Label */
             new String("Northern Chile (near 19 deg. S)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_N_CHILE_19_S, /*!< RT Code enum */
             -2.7000000000000e2, /* delta x */
             1.8300000000000e2, /* delta y */
             -3.9000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.5000000000000e1, /* Region lower-left latitude */
             -8.3000000000000e1, /* Region lower-left longitude */
             -1.2000000000000e1, /* Region upper-right latitude */
             -6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_PERU"), /*!< ISO18026 Label */
             new String("Peru"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_PERU, /*!< RT Code enum */
             -2.7900000000000e2, /* delta x */
             1.7500000000000e2, /* delta y */
             -3.7900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.4000000000000e1, /* Region lower-left latitude */
             -8.7000000000000e1, /* Region lower-left longitude */
             5.0000000000000e0, /* Region upper-right latitude */
             -6.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_AM_1956_S_CHILE_43_S"), /*!< ISO18026 Label */
             new String("Southern Chile (near 43 deg. S)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_AM_1956_S_CHILE_43_S, /*!< RT Code enum */
             -3.0500000000000e2, /* delta x */
             2.4300000000000e2, /* delta y */
             -4.4200000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.4000000000000e1, /* Region lower-left latitude */
             -8.3000000000000e1, /* Region lower-left longitude */
             -2.0000000000000e1, /* Region upper-right latitude */
             -6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PROV_S_CHILEAN_1963_SOUTH_CHILE"), /*!< ISO18026 Label */
             new String("South Chile (near 53 deg. S)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PROV_S_CHILEAN_1963, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PROV_S_CHILEAN_1963_SOUTH_CHILE, /*!< RT Code enum */
             1.6000000000000e1, /* delta x */
             1.9600000000000e2, /* delta y */
             9.3000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.4000000000000e1, /* Region lower-left latitude */
             -8.3000000000000e1, /* Region lower-left longitude */
             -2.5000000000000e1, /* Region upper-right latitude */
             -6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PUCK_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Puck)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PUCK_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PUCK_1988_IDENTITY, /*!< RT Code enum */
             Double.NaN, /* delta x */
             Double.NaN, /* delta y */
             Double.NaN, /* delta z */
             Double.NaN, /* omega 1 */
             Double.NaN, /* omega 2 */
             Double.NaN, /* omega 3 */
             Double.NaN, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS"), /*!< ISO18026 Label */
             new String("Puerto Rico and Virgin Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PUERTO_RICO_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS, /*!< RT Code enum */
             1.1000000000000e1, /* delta x */
             7.2000000000000e1, /* delta y */
             -1.0100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.6000000000000e1, /* Region lower-left latitude */
             -6.9000000000000e1, /* Region lower-left longitude */
             2.0000000000000e1, /* Region upper-right latitude */
             -6.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet1
        (
             new String("RTCOD_PULKOVO_1942_RUSSIA"), /*!< ISO18026 Label */
             new String("Russia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_PULKOVO_1942, /*!< ORM Code */
             SRM_RT_Code.RTCOD_PULKOVO_1942_RUSSIA, /*!< RT Code enum */
             2.8000000000000e1, /* delta x */
             -1.3000000000000e2, /* delta y */
             -9.5000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.6000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             8.9000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        )

    };
}

