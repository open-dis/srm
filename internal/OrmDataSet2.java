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

class OrmDataSet2 extends OrmDataSet
{
    private OrmDataSet2(String label,
                        String description,
                        SRM_ORM_Code  orm_code,
                        SRM_ORMT_Code orm_template,
                        SRM_OBRS_Code obrs_code,
                        SRM_RD_Code  rd_code,
                        SRM_ORM_Code reference_orm,
                        int          rt_count)
    {
        super(label, description, orm_code,
              orm_template, obrs_code, rd_code,
              reference_orm, rt_count);
    }

    public static OrmDataSet getElem(SRM_ORM_Code code)
    {
        if (code == SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_SPHERE)
        {
            return table[(SRM_ORM_Code._totalEnum - 242)+1];
        }
        else if (code == SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_MAX)
        {
            return table[(SRM_ORM_Code._totalEnum - 242)+2];
        }
        else
            return table[code.toInt() - 242];
    }

    public static OrmDataSet2[] table =
    {
        new OrmDataSet2
        (
             new String("ORMCOD_VITI_LEVU_1916"), /*!< ISO18026 Label */
             new String("Viti Levu"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_VITI_LEVU_1916, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_VOIROL_1874"), /*!< ISO18026 Label */
             new String("Voirol"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_VOIROL_1874, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_VOIROL_1874_PM_PARIS"), /*!< ISO18026 Label */
             new String("Voirol (with the Prime Meridian at Paris)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_VOIROL_1874_PM_PARIS, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_VOIROL_1960"), /*!< ISO18026 Label */
             new String("Voirol - Revised"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_VOIROL_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_VOIROL_1960_PM_PARIS"), /*!< ISO18026 Label */
             new String("Voirol - Revised (with the Prime Meridian at Paris)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_VOIROL_1960_PM_PARIS, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_WAKE_1952"), /*!< ISO18026 Label */
             new String("Wake (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_WAKE_1952, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_WAKE_ENIWETOK_1960"), /*!< ISO18026 Label */
             new String("Wake-Eniwetok"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_WAKE_ENIWETOK_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_HOUGH_1960, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_WGS_1972"), /*!< ISO18026 Label */
             new String("World Geodetic System"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_WGS_1972, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_WGS_1972, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_WGS_1984"), /*!< ISO18026 Label */
             new String("World Geodetic System"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_WGS_1984, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_YACARE_1987"), /*!< ISO18026 Label */
             new String("Yacare (Uruguay)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_YACARE_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_ZANDERIJ_1987"), /*!< ISO18026 Label */
             new String("Zanderij (Suriname)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ZANDERIJ_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_EXPERIMENTAL_NGA_SPHERE"), /*!< ISO18026 Label */
             new String("EXPERIMENTAL_NGA_SPHERE)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_SPHERE, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EXPERIMENTAL_NGA_SPHERE, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_SPHERE, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORMCOD_EXPERIMENTAL_NGA_MAX"), /*!< ISO18026 Label */
             new String("EXPERIMENTAL_NGA_MAX"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_MAX, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EXPERIMENTAL_NGA_SRM_MAX, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_MAX, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        )
    };
}
