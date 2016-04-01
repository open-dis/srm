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

class RtDataSet2 extends RtDataSet
{
    private RtDataSet2(String       label,
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
                       double       region_ur_long)
    {
        super(label, description, orm_code,
              rt_code, delta_x, delta_y, delta_z,
              omega_1, omega_2, omega_3, delta_scale,
              region_ll_lat, region_ll_long, region_ur_lat, region_ur_long);
    }

    public static RtDataSet getElem(SRM_RT_Code code)
    {
        if (code.toInt() < 0)
        {
            if (code == SRM_RT_Code.RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT)
            {
                return table[(SRM_RT_Code._totalEnum - 270)+1];
            }
            else if (code == SRM_RT_Code.RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT)
            {
                return table[(SRM_RT_Code._totalEnum - 270)+2];
            }
            else
            {
                return null;
            }
        }
        else
        {
            return table[code.toInt() - 270];
        }
    }

    public static RtDataSet2[] table =
    {
        new RtDataSet2
        (
             new String("RTCOD_QATAR_NATIONAL_1974_3_QATAR"), /*!< ISO18026 Label */
             new String("Qatar"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_QATAR_NATIONAL_1974, /*!< ORM Code */
             SRM_RT_Code.RTCOD_QATAR_NATIONAL_1974_3_QATAR, /*!< RT Code enum */
             -1.2800000000000e2, /* delta x */
             -2.8300000000000e2, /* delta y */
             2.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             4.5000000000000e1, /* Region lower-left longitude */
             3.2000000000000e1, /* Region upper-right latitude */
             5.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_QORNOQ_1987_SOUTH_GREENLAND"), /*!< ISO18026 Label */
             new String("South Greenland"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_QORNOQ_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_QORNOQ_1987_SOUTH_GREENLAND, /*!< RT Code enum */
             1.6400000000000e2, /* delta x */
             1.3800000000000e2, /* delta y */
             -1.8900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.7000000000000e1, /* Region lower-left latitude */
             -7.7000000000000e1, /* Region lower-left longitude */
             8.5000000000000e1, /* Region upper-right latitude */
             -7.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_REUNION_1947_MASCARENE_ISLANDS"), /*!< ISO18026 Label */
             new String("Mascarene Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_REUNION_1947, /*!< ORM Code */
             SRM_RT_Code.RTCOD_REUNION_1947_MASCARENE_ISLANDS, /*!< RT Code enum */
             9.4000000000000e1, /* delta x */
             -9.4800000000000e2, /* delta y */
             -1.2620000000000e3, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.7000000000000e1, /* Region lower-left latitude */
             4.7000000000000e1, /* Region lower-left longitude */
             -1.2000000000000e1, /* Region upper-right latitude */
             6.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_RGF_1993_IDENTITY_BY_MEASUREMENT"), /*!< ISO18026 Label */
             new String("France"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_RGF_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_RGF_1993_IDENTITY_BY_MEASUREMENT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             4.0792344331977e-2, /* omega 3 */
             0.0, /* delta scale */
             4.2000000000000e1, /* Region lower-left latitude */
             -6.0000000000000e0, /* Region lower-left longitude */
             5.2000000000000e1, /* Region upper-right latitude */
             1.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_RHEA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Rhea)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_RHEA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_RHEA_1988_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_ROME_1940_PM_ROME_SARDINIA"), /*!< ISO18026 Label */
             new String("Sardinia (Italy)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ROME_1940_PM_ROME, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ROME_1940_PM_ROME_SARDINIA, /*!< RT Code enum */
             -2.2500000000000e2, /* delta x */
             -6.5000000000000e1, /* delta y */
             9.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             2.1733421622251e-1, /* omega 3 */
             0.0, /* delta scale */
             3.7000000000000e1, /* Region lower-left latitude */
             -8.0000000000000e0, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             8.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_ROME_1940_SARDINIA"), /*!< ISO18026 Label */
             new String("Sardinia (Italy)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ROME_1940, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ROME_1940_SARDINIA, /*!< RT Code enum */
             -2.2500000000000e2, /* delta x */
             -6.5000000000000e1, /* delta y */
             9.0000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.7000000000000e1, /* Region lower-left latitude */
             6.0000000000000e0, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             1.2000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_ROSALIND_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Rosalind)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ROSALIND_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ROSALIND_1988_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_ARGENTINA"), /*!< ISO18026 Label */
             new String("Argentina"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_ARGENTINA, /*!< RT Code enum */
             -6.2000000000000e1, /* delta x */
             -1.0000000000000e0, /* delta y */
             -3.7000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.2000000000000e1, /* Region lower-left latitude */
             -7.6000000000000e1, /* Region lower-left longitude */
             -2.3000000000000e1, /* Region upper-right latitude */
             -4.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS"), /*!< ISO18026 Label */
             new String("Baltra and Galapagos Islands (Ecuador)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS, /*!< RT Code enum */
             -4.7000000000000e1, /* delta x */
             2.6000000000000e1, /* delta y */
             -4.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.0000000000000e0, /* Region lower-left latitude */
             -9.2000000000000e1, /* Region lower-left longitude */
             1.0000000000000e0, /* Region upper-right latitude */
             -8.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_BOLIVIA"), /*!< ISO18026 Label */
             new String("Bolivia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_BOLIVIA, /*!< RT Code enum */
             -6.1000000000000e1, /* delta x */
             2.0000000000000e0, /* delta y */
             -4.8000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.8000000000000e1, /* Region lower-left latitude */
             -7.5000000000000e1, /* Region lower-left longitude */
             -4.0000000000000e0, /* Region upper-right latitude */
             -5.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_BRAZIL"), /*!< ISO18026 Label */
             new String("Brazil"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_BRAZIL, /*!< RT Code enum */
             -6.0000000000000e1, /* delta x */
             -2.0000000000000e0, /* delta y */
             -4.1000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.9000000000000e1, /* Region lower-left latitude */
             -8.0000000000000e1, /* Region lower-left longitude */
             -2.0000000000000e0, /* Region upper-right latitude */
             -2.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_CHILE"), /*!< ISO18026 Label */
             new String("Chile"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_CHILE, /*!< RT Code enum */
             -7.5000000000000e1, /* delta x */
             -1.0000000000000e0, /* delta y */
             -4.4000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.4000000000000e1, /* Region lower-left latitude */
             -8.3000000000000e1, /* Region lower-left longitude */
             -1.2000000000000e1, /* Region upper-right latitude */
             -6.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_COLOMBIA"), /*!< ISO18026 Label */
             new String("Colombia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_COLOMBIA, /*!< RT Code enum */
             -4.4000000000000e1, /* delta x */
             6.0000000000000e0, /* delta y */
             -3.6000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             -8.5000000000000e1, /* Region lower-left longitude */
             1.6000000000000e1, /* Region upper-right latitude */
             -6.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS"), /*!< ISO18026 Label */
             new String("Ecuador (excluding Galapagos Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS, /*!< RT Code enum */
             -4.8000000000000e1, /* delta x */
             3.0000000000000e0, /* delta y */
             -4.4000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.1000000000000e1, /* Region lower-left latitude */
             -8.5000000000000e1, /* Region lower-left longitude */
             7.0000000000000e0, /* Region upper-right latitude */
             -7.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_GUYANA"), /*!< ISO18026 Label */
             new String("Guyana"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_GUYANA, /*!< RT Code enum */
             -5.3000000000000e1, /* delta x */
             3.0000000000000e0, /* delta y */
             -4.7000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.0000000000000e0, /* Region lower-left latitude */
             -6.7000000000000e1, /* Region lower-left longitude */
             1.4000000000000e1, /* Region upper-right latitude */
             -5.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Argentina, Bolivia, Brazil, Chile, Colombia, Ecuador, Guyana, Paraguay, Peru, Trinidad and Tobago, and Venezuela)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_MEAN_SOLUTION, /*!< RT Code enum */
             -5.7000000000000e1, /* delta x */
             1.0000000000000e0, /* delta y */
             -4.1000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.5000000000000e1, /* Region lower-left latitude */
             -9.0000000000000e1, /* Region lower-left longitude */
             -5.0000000000000e1, /* Region upper-right latitude */
             -2.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_PARAGUAY"), /*!< ISO18026 Label */
             new String("Paraguay"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_PARAGUAY, /*!< RT Code enum */
             -6.1000000000000e1, /* delta x */
             2.0000000000000e0, /* delta y */
             -3.3000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.3000000000000e1, /* Region lower-left latitude */
             -6.9000000000000e1, /* Region lower-left longitude */
             -1.4000000000000e1, /* Region upper-right latitude */
             -4.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_PERU"), /*!< ISO18026 Label */
             new String("Peru"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_PERU, /*!< RT Code enum */
             -5.8000000000000e1, /* delta x */
             0.0, /* delta y */
             -4.4000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.4000000000000e1, /* Region lower-left latitude */
             -8.7000000000000e1, /* Region lower-left longitude */
             5.0000000000000e0, /* Region upper-right latitude */
             -6.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_TRINIDAD_TOBAGO"), /*!< ISO18026 Label */
             new String("Trinidad and Tobago (British West Indies)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_TRINIDAD_TOBAGO, /*!< RT Code enum */
             -4.5000000000000e1, /* delta x */
             1.2000000000000e1, /* delta y */
             -3.3000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.0000000000000e0, /* Region lower-left latitude */
             -6.8000000000000e1, /* Region lower-left longitude */
             1.7000000000000e1, /* Region upper-right latitude */
             -5.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_AM_1969_VENEZUELA"), /*!< ISO18026 Label */
             new String("Venezuela"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_AM_1969_VENEZUELA, /*!< RT Code enum */
             -4.5000000000000e1, /* delta x */
             8.0000000000000e0, /* delta y */
             -3.3000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.0000000000000e0, /* Region lower-left latitude */
             -7.9000000000000e1, /* Region lower-left longitude */
             1.8000000000000e1, /* Region upper-right latitude */
             -5.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_ASIA_1987_SINGAPORE"), /*!< ISO18026 Label */
             new String("Singapore"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_ASIA_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_ASIA_1987_SINGAPORE, /*!< RT Code enum */
             7.0000000000000e0, /* delta x */
             -1.0000000000000e1, /* delta y */
             -2.6000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             0.0, /* Region lower-left latitude */
             1.0200000000000e2, /* Region lower-left longitude */
             3.0000000000000e0, /* Region upper-right latitude */
             1.0600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_JTSK_1993_CZECH_REPUBLIC"), /*!< ISO18026 Label */
             new String("Czech Republic"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_JTSK_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_JTSK_1993_CZECH_REPUBLIC, /*!< RT Code enum */
             5.7080000000000e2, /* delta x */
             8.5700000000000e1, /* delta y */
             4.6280000000000e2, /* delta z */
             2.4230987781855e-5, /* omega 1 */
             7.6939931192083e-6, /* omega 2 */
             2.5506047763173e-5, /* omega 3 */
             3.5600000000000e0, /* delta scale */
             4.7000000000000e1, /* Region lower-left latitude */
             1.1000000000000e1, /* Region lower-left longitude */
             5.2000000000000e1, /* Region upper-right latitude */
             2.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S_JTSK_1993_CZECH_SLOVAKIA"), /*!< ISO18026 Label */
             new String("Czech Republic and Slovakia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S_JTSK_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S_JTSK_1993_CZECH_SLOVAKIA, /*!< RT Code enum */
             5.8900000000000e2, /* delta x */
             7.6000000000000e1, /* delta y */
             4.8000000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.3000000000000e1, /* Region lower-left latitude */
             6.0000000000000e0, /* Region lower-left longitude */
             5.6000000000000e1, /* Region upper-right latitude */
             2.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S42_PULKOVO_3_POLAND"), /*!< ISO18026 Label */
             new String("Poland"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S42_PULKOVO_3_POLAND, /*!< RT Code enum */
             2.3000000000000e1, /* delta x */
             -1.2400000000000e2, /* delta y */
             -8.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.3000000000000e1, /* Region lower-left latitude */
             8.0000000000000e0, /* Region lower-left longitude */
             6.0000000000000e1, /* Region upper-right latitude */
             3.0000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S42_PULKOVO_ALBANIA"), /*!< ISO18026 Label */
             new String("Albania"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S42_PULKOVO_ALBANIA, /*!< RT Code enum */
             2.4000000000000e1, /* delta x */
             -1.3000000000000e2, /* delta y */
             -9.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.4000000000000e1, /* Region lower-left latitude */
             1.4000000000000e1, /* Region lower-left longitude */
             4.8000000000000e1, /* Region upper-right latitude */
             2.6000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA"), /*!< ISO18026 Label */
             new String("Czech Republic and Slovakia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA, /*!< RT Code enum */
             2.6000000000000e1, /* delta x */
             -1.2100000000000e2, /* delta y */
             -7.8000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.2000000000000e1, /* Region lower-left latitude */
             6.0000000000000e0, /* Region lower-left longitude */
             5.7000000000000e1, /* Region upper-right latitude */
             2.8000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S42_PULKOVO_G_ROMANIA"), /*!< ISO18026 Label */
             new String("Romania"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S42_PULKOVO_G_ROMANIA, /*!< RT Code enum */
             2.8000000000000e1, /* delta x */
             -1.2100000000000e2, /* delta y */
             -7.7000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.8000000000000e1, /* Region lower-left latitude */
             1.5000000000000e1, /* Region lower-left longitude */
             5.4000000000000e1, /* Region upper-right latitude */
             3.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S42_PULKOVO_HUNGARY"), /*!< ISO18026 Label */
             new String("Hungary"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S42_PULKOVO_HUNGARY, /*!< RT Code enum */
             2.8000000000000e1, /* delta x */
             -1.2100000000000e2, /* delta y */
             -7.7000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             4.0000000000000e1, /* Region lower-left latitude */
             1.1000000000000e1, /* Region lower-left longitude */
             5.4000000000000e1, /* Region upper-right latitude */
             2.9000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S42_PULKOVO_KAZAKHSTAN"), /*!< ISO18026 Label */
             new String("Kazakhstan"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S42_PULKOVO_KAZAKHSTAN, /*!< RT Code enum */
             1.5000000000000e1, /* delta x */
             -1.3000000000000e2, /* delta y */
             -8.4000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.5000000000000e1, /* Region lower-left latitude */
             4.1000000000000e1, /* Region lower-left longitude */
             6.2000000000000e1, /* Region upper-right latitude */
             9.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_S42_PULKOVO_LATVIA"), /*!< ISO18026 Label */
             new String("Latvia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code */
             SRM_RT_Code.RTCOD_S42_PULKOVO_LATVIA, /*!< RT Code enum */
             2.4000000000000e1, /* delta x */
             -1.2400000000000e2, /* delta y */
             -8.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             5.0000000000000e1, /* Region lower-left latitude */
             1.5000000000000e1, /* Region lower-left longitude */
             6.4000000000000e1, /* Region upper-right latitude */
             3.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND"), /*!< ISO18026 Label */
             new String("Espirito Santo Island (Vanuatu)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SANTO_DOS_1965, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND, /*!< RT Code enum */
             1.7000000000000e2, /* delta x */
             4.2000000000000e1, /* delta y */
             8.4000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.7000000000000e1, /* Region lower-left latitude */
             1.6000000000000e2, /* Region lower-left longitude */
             -1.3000000000000e1, /* Region upper-right latitude */
             1.6900000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS"), /*!< ISO18026 Label */
             new String("Sao Miguel and Santa Maria Islands (Azores)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SAO_BRAZ_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS, /*!< RT Code enum */
             -2.0300000000000e2, /* delta x */
             1.4100000000000e2, /* delta y */
             5.3000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             3.5000000000000e1, /* Region lower-left latitude */
             -2.7000000000000e1, /* Region lower-left longitude */
             3.9000000000000e1, /* Region upper-right latitude */
             -2.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS"), /*!< ISO18026 Label */
             new String("East Falkland Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SAPPER_HILL_1943, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS, /*!< RT Code enum */
             -3.5500000000000e2, /* delta x */
             2.1000000000000e1, /* delta y */
             7.2000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.4000000000000e1, /* Region lower-left latitude */
             -6.1000000000000e1, /* Region lower-left longitude */
             -5.0000000000000e1, /* Region upper-right latitude */
             -5.6000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SATURN_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Saturn)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SATURN_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SATURN_1988_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_SATURN_MAGNETIC_1993_VOYAGER_IDENTITY_BY_MEASUREMENT"), /*!< ISO18026 Label */
             new String("Global (Saturn)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SATURN_MAGNETIC_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SATURN_MAGNETIC_1993_VOYAGER_IDENTITY_BY_MEASUREMENT, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_SCHWARZECK_1991_NAMIBIA"), /*!< ISO18026 Label */
             new String("Namibia"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SCHWARZECK_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SCHWARZECK_1991_NAMIBIA, /*!< RT Code enum */
             6.1600000000000e2, /* delta x */
             9.7000000000000e1, /* delta y */
             -2.5100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.5000000000000e1, /* Region lower-left latitude */
             5.0000000000000e0, /* Region lower-left longitude */
             -1.1000000000000e1, /* Region upper-right latitude */
             3.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS"), /*!< ISO18026 Label */
             new String("Salvage Islands (Ilhas Selvagens; Savage Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SELVAGEM_GRANDE_1938, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS, /*!< RT Code enum */
             -2.8900000000000e2, /* delta x */
             -1.2400000000000e2, /* delta y */
             6.0000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.8000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e1, /* Region lower-left longitude */
             3.2000000000000e1, /* Region upper-right latitude */
             -1.4000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SIERRA_LEONE_1960_SIERRA_LEONE"), /*!< ISO18026 Label */
             new String("Sierra Leone"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SIERRA_LEONE_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SIERRA_LEONE_1960_SIERRA_LEONE, /*!< RT Code enum */
             -8.8000000000000e1, /* delta x */
             4.0000000000000e0, /* delta y */
             1.0100000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.0000000000000e0, /* Region lower-left latitude */
             -1.9000000000000e1, /* Region lower-left longitude */
             1.6000000000000e1, /* Region upper-right latitude */
             -4.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SIRGAS_2000_IDENTITY_BY_MEASUREMENT"), /*!< ISO18026 Label */
             new String("South America"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SIRGAS_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SIRGAS_2000_IDENTITY_BY_MEASUREMENT, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -6.5000000000000e1, /* Region lower-left latitude */
             -9.0000000000000e1, /* Region lower-left longitude */
             -5.0000000000000e1, /* Region upper-right latitude */
             -2.5000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_SUN_1992_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Sun)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_SUN_1992, /*!< ORM Code */
             SRM_RT_Code.RTCOD_SUN_1992_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_TANANARIVE_OBS_1925_3_MADAGASCAR"), /*!< ISO18026 Label */
             new String("Madagascar"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TANANARIVE_OBS_1925, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TANANARIVE_OBS_1925_3_MADAGASCAR, /*!< RT Code enum */
             -1.8900000000000e2, /* delta x */
             -2.4200000000000e2, /* delta y */
             -9.1000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.4000000000000e1, /* Region lower-left latitude */
             4.0000000000000e1, /* Region lower-left longitude */
             -8.0000000000000e0, /* Region upper-right latitude */
             5.3000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR"), /*!< ISO18026 Label */
             new String("Madagascar"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TANANARIVE_OBS_1925_PM_PARIS, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR, /*!< RT Code enum */
             -1.8900000000000e2, /* delta x */
             -2.4200000000000e2, /* delta y */
             -9.1000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             4.0792344331977e-2, /* omega 3 */
             0.0, /* delta scale */
             -3.4000000000000e1, /* Region lower-left latitude */
             3.8000000000000e1, /* Region lower-left longitude */
             -8.0000000000000e0, /* Region upper-right latitude */
             5.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TELESTO_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Telesto)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TELESTO_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TELESTO_1988_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_TERN_1961_TERN_ISLAND"), /*!< ISO18026 Label */
             new String("Tern Island (French Frigate Shoals, Hawaiian Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TERN_1961, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TERN_1961_TERN_ISLAND, /*!< RT Code enum */
             1.1400000000000e2, /* delta x */
             -1.1600000000000e2, /* delta y */
             -3.3300000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.2000000000000e1, /* Region lower-left latitude */
             -1.6700000000000e2, /* Region lower-left longitude */
             2.6000000000000e1, /* Region upper-right latitude */
             -1.6500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TETHYS_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Tethys)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TETHYS_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TETHYS_1991_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_THALASSA_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Thalassa)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_THALASSA_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_THALASSA_1991_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_THEBE_2000_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Thebe)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_THEBE_2000, /*!< ORM Code */
             SRM_RT_Code.RTCOD_THEBE_2000_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_TIMBALAI_EVRST_1948_3_BRUNEI_E_MALAYSIA"), /*!< ISO18026 Label */
             new String("Brunei and East Malaysia (Sabah and Sarawak)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TIMBALAI_EVEREST_1948, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TIMBALAI_EVRST_1948_3_BRUNEI_E_MALAYSIA, /*!< RT Code enum */
             -6.7900000000000e2, /* delta x */
             6.6900000000000e2, /* delta y */
             -4.8000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -5.0000000000000e0, /* Region lower-left latitude */
             1.0100000000000e2, /* Region lower-left longitude */
             1.5000000000000e1, /* Region upper-right latitude */
             1.2500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TIMBALAI_EVRST_1948_7_BRUNEI_E_MALAYSIA"), /*!< ISO18026 Label */
             new String("Brunei and East Malaysia (Sabah and Sarawak)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TIMBALAI_EVEREST_1948, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TIMBALAI_EVRST_1948_7_BRUNEI_E_MALAYSIA, /*!< RT Code enum */
             -5.8233000000000e2, /* delta x */
             6.7157000000000e2, /* delta y */
             -1.0815000000000e2, /* delta z */
             8.4551505985503e-6, /* omega 1 */
             2.7149566142134e-6, /* omega 2 */
             1.3943241468710e-5, /* omega 3 */
             6.4950000000000e0, /* delta scale */
             -5.0000000000000e0, /* Region lower-left latitude */
             1.0100000000000e2, /* Region lower-left longitude */
             1.5000000000000e1, /* Region upper-right latitude */
             1.2500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TITAN_1982_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Titan)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TITAN_1982, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TITAN_1982_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_TITANIA_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Titania)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TITANIA_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TITANIA_1988_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_TOKYO_1991_JAPAN"), /*!< ISO18026 Label */
             new String("Japan"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TOKYO_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TOKYO_1991_JAPAN, /*!< RT Code enum */
             -1.4800000000000e2, /* delta x */
             5.0700000000000e2, /* delta y */
             6.8500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             1.1900000000000e2, /* Region lower-left longitude */
             5.1000000000000e1, /* Region upper-right latitude */
             1.5600000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TOKYO_1991_MEAN_SOLUTION"), /*!< ISO18026 Label */
             new String("Mean Solution (Japan, Korea, and Okinawa)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TOKYO_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TOKYO_1991_MEAN_SOLUTION, /*!< RT Code enum */
             -1.4800000000000e2, /* delta x */
             5.0700000000000e2, /* delta y */
             6.8500000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.3000000000000e1, /* Region lower-left latitude */
             1.2000000000000e2, /* Region lower-left longitude */
             5.3000000000000e1, /* Region upper-right latitude */
             1.5500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TOKYO_1991_OKINAWA"), /*!< ISO18026 Label */
             new String("Okinawa (Japan)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TOKYO_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TOKYO_1991_OKINAWA, /*!< RT Code enum */
             -1.5800000000000e2, /* delta x */
             5.0700000000000e2, /* delta y */
             6.7600000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.9000000000000e1, /* Region lower-left latitude */
             1.1900000000000e2, /* Region lower-left longitude */
             3.1000000000000e1, /* Region upper-right latitude */
             1.3400000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TOKYO_1991_1991_SOUTH_KOREA"), /*!< ISO18026 Label */
             new String("South Korea"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TOKYO_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TOKYO_1991_1991_SOUTH_KOREA, /*!< RT Code enum */
             -1.4600000000000e2, /* delta x */
             5.0700000000000e2, /* delta y */
             6.8700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.7000000000000e1, /* Region lower-left latitude */
             1.2000000000000e2, /* Region lower-left longitude */
             4.5000000000000e1, /* Region upper-right latitude */
             1.3900000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TOKYO_1991_1997_SOUTH_KOREA"), /*!< ISO18026 Label */
             new String("South Korea"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TOKYO_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TOKYO_1991_1997_SOUTH_KOREA, /*!< RT Code enum */
             -1.4700000000000e2, /* delta x */
             5.0600000000000e2, /* delta y */
             6.8700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             2.7000000000000e1, /* Region lower-left latitude */
             1.2000000000000e2, /* Region lower-left longitude */
             4.5000000000000e1, /* Region upper-right latitude */
             1.3900000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TRISTAN_1968_TRISTAN_DA_CUNHA"), /*!< ISO18026 Label */
             new String("Tristan da Cunha"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TRISTAN_1968, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TRISTAN_1968_TRISTAN_DA_CUNHA, /*!< RT Code enum */
             -6.3200000000000e2, /* delta x */
             4.3800000000000e2, /* delta y */
             -6.0900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -3.9000000000000e1, /* Region lower-left latitude */
             -1.4000000000000e1, /* Region lower-left longitude */
             -3.6000000000000e1, /* Region upper-right latitude */
             -1.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_TRITON_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Triton)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_TRITON_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_TRITON_1991_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_UMBRIEL_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Umbriel)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_UMBRIEL_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_UMBRIEL_1988_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_URANUS_1988_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Uranus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_URANUS_1988, /*!< ORM Code */
             SRM_RT_Code.RTCOD_URANUS_1988_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_URANUS_MAGNETIC_1993_VOYAGER"), /*!< ISO18026 Label */
             new String("Global (Uranus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_URANUS_MAGNETIC_1993, /*!< ORM Code */
             SRM_RT_Code.RTCOD_URANUS_MAGNETIC_1993_VOYAGER, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             0.0, /* delta z */
             0.0, /* omega 1 */
             1.0227629416687e0, /* omega 2 */
             -9.3549647906896e-1, /* omega 3 */
             0.0, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_VENUS_1991_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Venus)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_VENUS_1991, /*!< ORM Code */
             SRM_RT_Code.RTCOD_VENUS_1991_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_VITI_LEVU_1916_VITI_LEVU_ISLANDS"), /*!< ISO18026 Label */
             new String("Viti Levu Island (Fiji Islands)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_VITI_LEVU_1916, /*!< ORM Code */
             SRM_RT_Code.RTCOD_VITI_LEVU_1916_VITI_LEVU_ISLANDS, /*!< RT Code enum */
             5.1000000000000e1, /* delta x */
             3.9100000000000e2, /* delta y */
             -3.6000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -2.0000000000000e1, /* Region lower-left latitude */
             1.7600000000000e2, /* Region lower-left longitude */
             -1.6000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_VOIROL_1874_ALGERIA"), /*!< ISO18026 Label */
             new String("Algeria"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_VOIROL_1874, /*!< ORM Code */
             SRM_RT_Code.RTCOD_VOIROL_1874_ALGERIA, /*!< RT Code enum */
             -7.3000000000000e1, /* delta x */
             -2.4700000000000e2, /* delta y */
             2.2700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.3000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e1, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             1.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_VOIROL_1874_PM_PARIS_ALGERIA"), /*!< ISO18026 Label */
             new String("Algeria"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_VOIROL_1874_PM_PARIS, /*!< ORM Code */
             SRM_RT_Code.RTCOD_VOIROL_1874_PM_PARIS_ALGERIA, /*!< RT Code enum */
             -7.3000000000000e1, /* delta x */
             -2.4700000000000e2, /* delta y */
             2.2700000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             4.0792344331977e-2, /* omega 3 */
             0.0, /* delta scale */
             1.3000000000000e1, /* Region lower-left latitude */
             -1.7000000000000e1, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             9.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_VOIROL_1960_ALGERIA"), /*!< ISO18026 Label */
             new String("Algeria"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_VOIROL_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_VOIROL_1960_ALGERIA, /*!< RT Code enum */
             -1.2300000000000e2, /* delta x */
             -2.0600000000000e2, /* delta y */
             2.1900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.3000000000000e1, /* Region lower-left latitude */
             -1.5000000000000e1, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             1.1000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_VOIROL_1960_PM_PARIS_ALGERIA"), /*!< ISO18026 Label */
             new String("Algeria"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_VOIROL_1960_PM_PARIS, /*!< ORM Code */
             SRM_RT_Code.RTCOD_VOIROL_1960_PM_PARIS_ALGERIA, /*!< RT Code enum */
             -1.2300000000000e2, /* delta x */
             -2.0600000000000e2, /* delta y */
             2.1900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             4.0792344331977e-2, /* omega 3 */
             0.0, /* delta scale */
             1.3000000000000e1, /* Region lower-left latitude */
             -1.7000000000000e1, /* Region lower-left longitude */
             4.3000000000000e1, /* Region upper-right latitude */
             9.0000000000000e0 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_WAKE_1952_WAKE_ATOLL"), /*!< ISO18026 Label */
             new String("Wake Atoll"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_WAKE_1952, /*!< ORM Code */
             SRM_RT_Code.RTCOD_WAKE_1952_WAKE_ATOLL, /*!< RT Code enum */
             2.7600000000000e2, /* delta x */
             -5.7000000000000e1, /* delta y */
             1.4900000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.7000000000000e1, /* Region lower-left latitude */
             -1.7600000000000e2, /* Region lower-left longitude */
             2.1000000000000e1, /* Region upper-right latitude */
             -1.7100000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS"), /*!< ISO18026 Label */
             new String("Marshall Islands"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_WAKE_ENIWETOK_1960, /*!< ORM Code */
             SRM_RT_Code.RTCOD_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS, /*!< RT Code enum */
             1.0200000000000e2, /* delta x */
             5.2000000000000e1, /* delta y */
             -3.8000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             1.0000000000000e0, /* Region lower-left latitude */
             1.5900000000000e2, /* Region lower-left longitude */
             1.6000000000000e1, /* Region upper-right latitude */
             1.7500000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_WGS_1972_GLOBAL"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_WGS_1972, /*!< ORM Code */
             SRM_RT_Code.RTCOD_WGS_1972_GLOBAL, /*!< RT Code enum */
             0.0, /* delta x */
             0.0, /* delta y */
             4.5000000000000e0, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             2.6858677933468e-6, /* omega 3 */
             2.1900000000000e-1, /* delta scale */
             -9.0000000000000e1, /* Region lower-left latitude */
             -1.8000000000000e2, /* Region lower-left longitude */
             9.0000000000000e1, /* Region upper-right latitude */
             1.8000000000000e2 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_WGS_1984_IDENTITY"), /*!< ISO18026 Label */
             new String("Global (Earth)"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< ORM Code */
             SRM_RT_Code.RTCOD_WGS_1984_IDENTITY, /*!< RT Code enum */
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

        new RtDataSet2
        (
             new String("RTCOD_YACARE_1987_URUGUAY"), /*!< ISO18026 Label */
             new String("Uruguay"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_YACARE_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_YACARE_1987_URUGUAY, /*!< RT Code enum */
             -1.5500000000000e2, /* delta x */
             1.7100000000000e2, /* delta y */
             3.7000000000000e1, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -4.0000000000000e1, /* Region lower-left latitude */
             -6.5000000000000e1, /* Region lower-left longitude */
             -2.5000000000000e1, /* Region upper-right latitude */
             -4.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_ZANDERIJ_1987_SURINAME"), /*!< ISO18026 Label */
             new String("Suriname"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_ZANDERIJ_1987, /*!< ORM Code */
             SRM_RT_Code.RTCOD_ZANDERIJ_1987_SURINAME, /*!< RT Code enum */
             -2.6500000000000e2, /* delta x */
             1.2000000000000e2, /* delta y */
             -3.5800000000000e2, /* delta z */
             0.0, /* omega 1 */
             0.0, /* omega 2 */
             0.0, /* omega 3 */
             0.0, /* delta scale */
             -1.0000000000000e1, /* Region lower-left latitude */
             -7.6000000000000e1, /* Region lower-left longitude */
             2.0000000000000e1, /* Region upper-right latitude */
             -4.7000000000000e1 /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_SPHERE, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
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
             1.8000000000000e2  /* Region upper-right longitude */
        ),

        new RtDataSet2
        (
             new String("RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Label */
             new String("EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT"), /*!< ISO18026 Region */
             SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_MAX, /*!< ORM Code */
             SRM_RT_Code.RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT, /*!< RT Code enum */
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
             1.8000000000000e2  /* Region upper-right longitude */
        )
    };
}

