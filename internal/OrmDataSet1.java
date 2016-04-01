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

class OrmDataSet1 extends OrmDataSet
{
    private OrmDataSet1(String        label,
                        String        description,
                        SRM_ORM_Code  orm_code,
                        SRM_ORMT_Code orm_template,
                        SRM_OBRS_Code obrs_code,
                        SRM_RD_Code   rd_code,
                        SRM_ORM_Code  reference_orm,
                        int           rt_count)
    {
        super ( label, description, orm_code,
                orm_template, obrs_code, rd_code,
                reference_orm, rt_count );
    }

    public static OrmDataSet getElem(SRM_ORM_Code code)
    {
        return table[code.toInt()];
    }

    public static OrmDataSet1[] table =
    {
        new OrmDataSet1
        (
             // Dummy entry for UNSPECIFIED
             new String("Null ORM"), /*!< ISO18026 Label */
             new String("Empty ORM data entry"), /*!< ISO18026 Description */
             SRM_ORM_Code.ORMCOD_UNSPECIFIED, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_UNSPECIFIED, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_UNSPECIFIED, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),
        new OrmDataSet1
        (
             new String("ORMCOD_ABSTRACT_2D"), /*!< ISO18026 Label */
             new String("2D modelling space"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ABSTRACT_2D, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_2D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_UNSPECIFIED, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ABSTRACT_3D"), /*!< ISO18026 Label */
             new String("3D modelling space"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ABSTRACT_3D, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_PLANE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_UNSPECIFIED, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ADINDAN_1991"), /*!< ISO18026 Label */
             new String("Adindan"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ADINDAN_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ADRASTEA_2000"), /*!< ISO18026 Label */
             new String("Adrastea"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ADRASTEA_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_ADRASTEA_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_ADRASTEA_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_AFGOOYE_1987"), /*!< ISO18026 Label */
             new String("Afgooye (Somalia)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_AFGOOYE_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_KRASSOVSKY_1940, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_AIN_EL_ABD_1970"), /*!< ISO18026 Label */
             new String("Ain el Abd"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_AIN_EL_ABD_1970, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_AMALTHEA_2000"), /*!< ISO18026 Label */
             new String("Amalthea"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_AMALTHEA_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_AMALTHEA_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_AMALTHEA_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_AMERICAN_SAMOA_1962"), /*!< ISO18026 Label */
             new String("American Samoa"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_AMERICAN_SAMOA_1962, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ANNA_1_1965"), /*!< ISO18026 Label */
             new String("Anna 1 (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ANNA_1_1965, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_AUSTRALIAN_NATIONAL_1966, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ANTIGUA_1943"), /*!< ISO18026 Label */
             new String("Antigua (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ANTIGUA_1943, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ARC_1950"), /*!< ISO18026 Label */
             new String("Arc"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ARC_1950, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ARC_1960"), /*!< ISO18026 Label */
             new String("Arc"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ARC_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ARIEL_1988"), /*!< ISO18026 Label */
             new String("Ariel"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ARIEL_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_ARIEL_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_ARIEL_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ASCENSION_1958"), /*!< ISO18026 Label */
             new String("Ascension"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ASCENSION_1958, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ATLAS_1988"), /*!< ISO18026 Label */
             new String("Atlas"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ATLAS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_ATLAS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_ATLAS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_AUSTRALIAN_GEOD_1966"), /*!< ISO18026 Label */
             new String("Australian Geodetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_AUSTRALIAN_GEOD_1966, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_AUSTRALIAN_NATIONAL_1966, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_AUSTRALIAN_GEOD_1984"), /*!< ISO18026 Label */
             new String("Australian Geodetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_AUSTRALIAN_GEOD_1984, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_AUSTRALIAN_NATIONAL_1966, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_AYABELLE_LIGHTHOUSE_1991"), /*!< ISO18026 Label */
             new String("Ayabelle Lighthouse (Djibouti)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_AYABELLE_LIGHTHOUSE_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BEACON_E_1945"), /*!< ISO18026 Label */
             new String("Beacon E (Iwo-jima; astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BEACON_E_1945, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BELINDA_1988"), /*!< ISO18026 Label */
             new String("Belinda"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BELINDA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BELINDA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_BELINDA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BELLEVUE_IGN_1987"), /*!< ISO18026 Label */
             new String("Bellevue (IGN)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BELLEVUE_IGN_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BERMUDA_1957"), /*!< ISO18026 Label */
             new String("Bermuda"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BERMUDA_1957, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BIANCA_1988"), /*!< ISO18026 Label */
             new String("Bianca"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BIANCA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BIANCA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_BIANCA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BISSAU_1991"), /*!< ISO18026 Label */
             new String("Bissau"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BISSAU_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BOGOTA_OBS_1987"), /*!< ISO18026 Label */
             new String("Bogota Observatory"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BOGOTA_OBS_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BOGOTA_OBS_1987_PM_BOGOTA"), /*!< ISO18026 Label */
             new String("Bogota Observatory (with the Prime Meridian at Bogota)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BOGOTA_OBS_1987_PM_BOGOTA, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_BUKIT_RIMPAH_1987"), /*!< ISO18026 Label */
             new String("Bukit Rimpah"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_BUKIT_RIMPAH_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CALLISTO_2000"), /*!< ISO18026 Label */
             new String("Callisto"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CALLISTO_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CALLISTO_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_CALLISTO_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CALYPSO_1988"), /*!< ISO18026 Label */
             new String("Calypso"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CALYPSO_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CALYPSO_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_CALYPSO_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CAMP_AREA_1987"), /*!< ISO18026 Label */
             new String("Camp Area (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CAMP_AREA_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CAMPO_INCHAUSPE_1969"), /*!< ISO18026 Label */
             new String("Campo Inchauspe"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CAMPO_INCHAUSPE_1969, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CANTON_1966"), /*!< ISO18026 Label */
             new String("Canton (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CANTON_1966, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CAPE_1987"), /*!< ISO18026 Label */
             new String("Cape"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CAPE_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CAPE_CANAVERAL_1991"), /*!< ISO18026 Label */
             new String("Cape Canaveral"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CAPE_CANAVERAL_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CARTHAGE_1987"), /*!< ISO18026 Label */
             new String("Carthage"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CARTHAGE_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CHARON_1991"), /*!< ISO18026 Label */
             new String("Charon"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CHARON_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CHARON_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_CHARON_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CHATHAM_1971"), /*!< ISO18026 Label */
             new String("Chatam (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CHATHAM_1971, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CHUA_1987"), /*!< ISO18026 Label */
             new String("Chua (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CHUA_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_COAMPS_1998"), /*!< ISO18026 Label */
             new String("COAMPS^(TM)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_COAMPS_1998, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_COAMPS_1998, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CORDELIA_1988"), /*!< ISO18026 Label */
             new String("Cordelia"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CORDELIA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CORDELIA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_CORDELIA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CORREGO_ALEGRE_1987"), /*!< ISO18026 Label */
             new String("Corrego Alegre"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CORREGO_ALEGRE_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_CRESSIDA_1988"), /*!< ISO18026 Label */
             new String("Cressida"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_CRESSIDA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CRESSIDA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_CRESSIDA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DABOLA_1991"), /*!< ISO18026 Label */
             new String("Dabola"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DABOLA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DECEPTION_1993"), /*!< ISO18026 Label */
             new String("Deception"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DECEPTION_1993, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DEIMOS_1988"), /*!< ISO18026 Label */
             new String("Deimos"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DEIMOS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_DEIMOS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_DEIMOS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DESDEMONA_1988"), /*!< ISO18026 Label */
             new String("Desdemona"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DESDEMONA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_DESDEMONA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_DESDEMONA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DESPINA_1991"), /*!< ISO18026 Label */
             new String("Despina"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DESPINA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_DESPINA_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_DESPINA_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DIONE_1982"), /*!< ISO18026 Label */
             new String("Dione"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DIONE_1982, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_DIONE_1982, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_DIONE_1982, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DJAKARTA_1987"), /*!< ISO18026 Label */
             new String("Djakarta (also known as Batavia)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DJAKARTA_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DJAKARTA_1987_PM_DJAKARTA"), /*!< ISO18026 Label */
             new String("Djakarta (also known as Batavia; with the Prime Meridian at Djakarta)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DJAKARTA_1987_PM_DJAKARTA, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DOS_1968"), /*!< ISO18026 Label */
             new String("DOS"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DOS_1968, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_DOS_71_4_1987"), /*!< ISO18026 Label */
             new String("DOS 71/4 (St. Helena Island; astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_DOS_71_4_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EARTH_INERT_ARIES_1950"), /*!< ISO18026 Label */
             new String("Earth equatorial inertial, Aries mean of 1950"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EARTH_INERT_ARIES_1950, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EARTH_INERT_ARIES_TRUE_OF_DATE"), /*!< ISO18026 Label */
             new String("Earth equatorial inertial, Aries true of date"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EARTH_INERT_ARIES_TRUE_OF_DATE, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EARTH_INERTIAL_J2000r0"), /*!< ISO18026 Label */
             new String("Earth equatorial inertial, J2000.0"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EARTH_INERTIAL_J2000r0, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EARTH_SOLAR_ECLIPTIC"), /*!< ISO18026 Label */
             new String("Solar ecliptic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EARTH_SOLAR_ECLIPTIC, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_ECLIPTIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EARTH_SOLAR_EQUATORIAL"), /*!< ISO18026 Label */
             new String("Solar equatorial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EARTH_SOLAR_EQUATORIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_EQUATORIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EARTH_SOLAR_MAG_DIPOLE"), /*!< ISO18026 Label */
             new String("Solar magnetic dipole"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EARTH_SOLAR_MAG_DIPOLE, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_MAGNETIC_DIPOLE, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EARTH_SOLAR_MAGNETOSPHERIC"), /*!< ISO18026 Label */
             new String("Solar magnetospheric"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EARTH_SOLAR_MAGNETOSPHERIC, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_MAGNETIC_ECLIPTIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EASTER_1967"), /*!< ISO18026 Label */
             new String("Easter"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EASTER_1967, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ENCELADUS_1994"), /*!< ISO18026 Label */
             new String("Enceladus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ENCELADUS_1994, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_ENCELADUS_1994, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_ENCELADUS_1994, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EPIMETHEUS_1988"), /*!< ISO18026 Label */
             new String("Epimetheus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EPIMETHEUS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EPIMETHEUS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_EPIMETHEUS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EROS_2000"), /*!< ISO18026 Label */
             new String("Eros (asteroid 433)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EROS_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EROS_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_EROS_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ESTONIA_1937"), /*!< ISO18026 Label */
             new String("Estonia"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ESTONIA_1937, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ETRS_1989"), /*!< ISO18026 Label */
             new String("ETRS"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ETRS_1989, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GRS_1980, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EUROPA_2000"), /*!< ISO18026 Label */
             new String("Europa"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EUROPA_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EUROPA_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_EUROPA_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EUROPE_1950"), /*!< ISO18026 Label */
             new String("European"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EUROPE_1950, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_EUROPE_1979"), /*!< ISO18026 Label */
             new String("European"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_EUROPE_1979, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_FAHUD_1987"), /*!< ISO18026 Label */
             new String("Fahud"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_FAHUD_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_FORT_THOMAS_1955"), /*!< ISO18026 Label */
             new String("Fort Thomas"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_FORT_THOMAS_1955, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GALATEA_1991"), /*!< ISO18026 Label */
             new String("Galatea"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GALATEA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GALATEA_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_GALATEA_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GAN_1970"), /*!< ISO18026 Label */
             new String("Gan"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GAN_1970, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GANYMEDE_2000"), /*!< ISO18026 Label */
             new String("Ganymede"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GANYMEDE_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GANYMEDE_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_GANYMEDE_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GASPRA_1991"), /*!< ISO18026 Label */
             new String("Gaspra (asteroid 951)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GASPRA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GASPRA_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_GASPRA_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GDA_1994"), /*!< ISO18026 Label */
             new String("GDA"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GDA_1994, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GRS_1980, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEODETIC_DATUM_1949"), /*!< ISO18026 Label */
             new String("Geodetic Datum"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEODETIC_DATUM_1949, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1945"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1945, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1950"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1950, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1955"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1955, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1960"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1965"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1965, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1970"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1970, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1975"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1975, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1980"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1980, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1985"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1985, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1990"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1990, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_1995"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_1995, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GEOMAGNETIC_2000"), /*!< ISO18026 Label */
             new String("Geomagnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GEOMAGNETIC_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GRACIOSA_BASE_SW_1948"), /*!< ISO18026 Label */
             new String("Graciosa Base SW"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GRACIOSA_BASE_SW_1948, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GUAM_1963"), /*!< ISO18026 Label */
             new String("Guam"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GUAM_1963, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GUNONG_SEGARA_1987"), /*!< ISO18026 Label */
             new String("Gunung Segara"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GUNONG_SEGARA_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_GUX_1_1987"), /*!< ISO18026 Label */
             new String("GUX1 (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_GUX_1_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HELENE_1992"), /*!< ISO18026 Label */
             new String("Helene"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HELENE_1992, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_HELENE_1992, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_HELENE_1992, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HELIO_ARIES_ECLIPT_J2000r0"), /*!< ISO18026 Label */
             new String("Heliocentric Aries ecliptic, J2000.0"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HELIO_ARIES_ECLIPT_J2000r0, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_HELIOCENTRIC_ARIES_ECLIPTIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SUN_1992, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HELIO_ARIES_ECLIPT_TRUE_OF_DATE"), /*!< ISO18026 Label */
             new String("Heliocentric Aries ecliptic, true of date"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HELIO_ARIES_ECLIPT_TRUE_OF_DATE, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_HELIOCENTRIC_ARIES_ECLIPTIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SUN_1992, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HELIO_EARTH_ECLIPTIC"), /*!< ISO18026 Label */
             new String("Heliocentric Earth ecliptic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HELIO_EARTH_ECLIPTIC, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_HELIOCENT_PLANET_ECLIPTIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SUN_1992, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HELIO_EARTH_EQUATORIAL"), /*!< ISO18026 Label */
             new String("Heliocentric Earth equatorial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HELIO_EARTH_EQUATORIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_HELIOCENT_PLANET_EQUATORIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SUN_1992, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HERAT_NORTH_1987"), /*!< ISO18026 Label */
             new String("Herat North"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HERAT_NORTH_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HERMANNSKOGEL_1871"), /*!< ISO18026 Label */
             new String("Hermannskogel"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HERMANNSKOGEL_1871, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HJORSEY_1955"), /*!< ISO18026 Label */
             new String("Hjorsey"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HJORSEY_1955, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HONG_KONG_1963"), /*!< ISO18026 Label */
             new String("Hong Kong"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HONG_KONG_1963, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_HU_TZU_SHAN_1991"), /*!< ISO18026 Label */
             new String("Hu-Tzu-Shan"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_HU_TZU_SHAN_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_IAPETUS_1988"), /*!< ISO18026 Label */
             new String("Iapetus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_IAPETUS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_IAPETUS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_IAPETUS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_IDA_1991"), /*!< ISO18026 Label */
             new String("Ida (asteroid 243)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_IDA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_IDA_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_IDA_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_INDIAN_1916"), /*!< ISO18026 Label */
             new String("Indian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_INDIAN_1916, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_ADJ_1937, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_INDIAN_1954"), /*!< ISO18026 Label */
             new String("Indian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_INDIAN_1954, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_ADJ_1937, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_INDIAN_1956"), /*!< ISO18026 Label */
             new String("Indian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_INDIAN_1956, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_1956, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_INDIAN_1960"), /*!< ISO18026 Label */
             new String("Indian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_INDIAN_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_ADJ_1937, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_INDIAN_1962"), /*!< ISO18026 Label */
             new String("Indian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_INDIAN_1962, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_REVISED_1962, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_INDIAN_1975"), /*!< ISO18026 Label */
             new String("Indian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_INDIAN_1975, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_ADJ_1937, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_INDONESIAN_1974"), /*!< ISO18026 Label */
             new String("Indonesian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_INDONESIAN_1974, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INDONESIAN_1974, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_IO_2000"), /*!< ISO18026 Label */
             new String("Io"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_IO_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_IO_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_IO_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_IRELAND_1965"), /*!< ISO18026 Label */
             new String("Ireland 1965"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_IRELAND_1965, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MODIFIED_AIRY_1849, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ISTS_061_1968"), /*!< ISO18026 Label */
             new String("International Satellite Triangulation Station (ISTS) 061 (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ISTS_061_1968, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ISTS_073_1969"), /*!< ISO18026 Label */
             new String("International Satellite Triangulation Station (ISTS) 073 (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ISTS_073_1969, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JANUS_1988"), /*!< ISO18026 Label */
             new String("Janus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JANUS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_JANUS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JANUS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JGD_2000"), /*!< ISO18026 Label */
             new String("Japanese Geodetic Datum 2000 (JGD2000)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JGD_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GRS_1980, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JOHNSTON_1961"), /*!< ISO18026 Label */
             new String("Johnston"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JOHNSTON_1961, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JULIET_1988"), /*!< ISO18026 Label */
             new String("Juliet"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JULIET_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_JULIET_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JULIET_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JUPITER_1988"), /*!< ISO18026 Label */
             new String("Jupiter"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_JUPITER_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JUPITER_INERTIAL"), /*!< ISO18026 Label */
             new String("Jupiter equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JUPITER_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JUPITER_MAGNETIC_1993"), /*!< ISO18026 Label */
             new String("Jupiter magnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JUPITER_MAGNETIC_1993, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JUPITER_SOLAR_ECLIPTIC"), /*!< ISO18026 Label */
             new String("Jupiter solar ecliptic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JUPITER_SOLAR_ECLIPTIC, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_ECLIPTIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JUPITER_SOLAR_EQUATORIAL"), /*!< ISO18026 Label */
             new String("Jupiter solar equatorial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JUPITER_SOLAR_EQUATORIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_EQUATORIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JUPITER_SOLAR_MAG_DIPOLE"), /*!< ISO18026 Label */
             new String("Jupiter solar magnetic dipole"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JUPITER_SOLAR_MAG_DIPOLE, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_MAGNETIC_DIPOLE, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_JUPITER_SOLAR_MAG_ECLIPTIC"), /*!< ISO18026 Label */
             new String("Jupiter solar magnetic ecliptic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_JUPITER_SOLAR_MAG_ECLIPTIC, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_SOLAR_MAGNETIC_ECLIPTIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_JUPITER_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_KANDAWALA_1987"), /*!< ISO18026 Label */
             new String("Kandawala"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_KANDAWALA_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_ADJ_1937, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_KERGUELEN_1949"), /*!< ISO18026 Label */
             new String("Kerguelen"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_KERGUELEN_1949, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_KERTAU_1948"), /*!< ISO18026 Label */
             new String("Kertau"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_KERTAU_1948, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_1948, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_KOREAN_GEODETIC_1995"), /*!< ISO18026 Label */
             new String("Korean Geodetic System"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_KOREAN_GEODETIC_1995, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_WGS_1984, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_KUSAIE_1951"), /*!< ISO18026 Label */
             new String("Kusaie 1951 (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_KUSAIE_1951, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_LARISSA_1991"), /*!< ISO18026 Label */
             new String("Larissa"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_LARISSA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_LARISSA_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_LARISSA_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_LC5_1961"), /*!< ISO18026 Label */
             new String("LC5 (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_LC5_1961, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_LEIGON_1991"), /*!< ISO18026 Label */
             new String("Leigon"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_LEIGON_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_LIBERIA_1964"), /*!< ISO18026 Label */
             new String("Liberia"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_LIBERIA_1964, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_LUZON_1987"), /*!< ISO18026 Label */
             new String("Luzon"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_LUZON_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_M_PORALOKO_1991"), /*!< ISO18026 Label */
             new String("M'Poraloko"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_M_PORALOKO_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MAHE_1971"), /*!< ISO18026 Label */
             new String("Mahe"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MAHE_1971, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MARCUS_STATION_1952"), /*!< ISO18026 Label */
             new String("Marcus Station (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MARCUS_STATION_1952, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MARS_2000"), /*!< ISO18026 Label */
             new String("Mars"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MARS_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MARS_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MARS_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MARS_INERTIAL"), /*!< ISO18026 Label */
             new String("Mars equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MARS_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MARS_2000, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MARS_SPHERE_2000"), /*!< ISO18026 Label */
             new String("Mars (spherical)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MARS_SPHERE_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MARS_SPHERE_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MARS_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MASS_1999"), /*!< ISO18026 Label */
             new String("MASS"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MASS_1999, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MASS_1999, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MASSAWA_1987"), /*!< ISO18026 Label */
             new String("Massawa"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MASSAWA_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MERCHICH_1987"), /*!< ISO18026 Label */
             new String("Merchich"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MERCHICH_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MERCURY_1988"), /*!< ISO18026 Label */
             new String("Mercury"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MERCURY_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MERCURY_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MERCURY_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MERCURY_INERTIAL"), /*!< ISO18026 Label */
             new String("Mercury equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MERCURY_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MERCURY_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_METIS_2000"), /*!< ISO18026 Label */
             new String("Metis"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_METIS_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_METIS_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_METIS_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MIDWAY_1961"), /*!< ISO18026 Label */
             new String("Midway 1961 (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MIDWAY_1961, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MIMAS_1994"), /*!< ISO18026 Label */
             new String("Mimas"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MIMAS_1994, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MIMAS_1994, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MIMAS_1994, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MINNA_1991"), /*!< ISO18026 Label */
             new String("Minna"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MINNA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MIRANDA_1988"), /*!< ISO18026 Label */
             new String("Miranda"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MIRANDA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MIRANDA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MIRANDA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MM5_1997"), /*!< ISO18026 Label */
             new String("MM5 (AFWA)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MM5_1997, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MM5_1997, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MODTRAN_MIDLAT_N_1989"), /*!< ISO18026 Label */
             new String("MODTRAN"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MODTRAN_MIDLAT_N_1989, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MODTRAN_MIDLATITUDE_1989, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MODTRAN_MIDLAT_S_1989"), /*!< ISO18026 Label */
             new String("MODTRAN"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MODTRAN_MIDLAT_S_1989, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MODTRAN_MIDLATITUDE_1989, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MODTRAN_SUBARCTIC_N_1989"), /*!< ISO18026 Label */
             new String("MODTRAN"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MODTRAN_SUBARCTIC_N_1989, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MODTRAN_SUBARCTIC_1989, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MODTRAN_SUBARCTIC_S_1989"), /*!< ISO18026 Label */
             new String("MODTRAN"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MODTRAN_SUBARCTIC_S_1989, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MODTRAN_SUBARCTIC_1989, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MODTRAN_TROPICAL_1989"), /*!< ISO18026 Label */
             new String("MODTRAN"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MODTRAN_TROPICAL_1989, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MODTRAN_TROPICAL_1989, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MONTSERRAT_1958"), /*!< ISO18026 Label */
             new String("Montserrat (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MONTSERRAT_1958, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MOON_1991"), /*!< ISO18026 Label */
             new String("Moon"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MOON_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MOON_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_MOON_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_MULTIGEN_FLAT_EARTH_1989"), /*!< ISO18026 Label */
             new String("Multigen flat Earth"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_MULTIGEN_FLAT_EARTH_1989, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MULTIGEN_FLAT_EARTH_1989, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_N_AM_1927"), /*!< ISO18026 Label */
             new String("North American"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_N_AM_1927, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_N_AM_1983"), /*!< ISO18026 Label */
             new String("North American"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_N_AM_1983, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GRS_1980, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_N_SAHARA_1959"), /*!< ISO18026 Label */
             new String("North Sahara"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_N_SAHARA_1959, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NAHRWAN_1987"), /*!< ISO18026 Label */
             new String("Nahrwan"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NAHRWAN_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NAIAD_1991"), /*!< ISO18026 Label */
             new String("Naiad"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NAIAD_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_NAIAD_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_NAIAD_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NAPARIMA_1991"), /*!< ISO18026 Label */
             new String("Naparima BWI"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NAPARIMA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NEPTUNE_1991"), /*!< ISO18026 Label */
             new String("Neptune"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NEPTUNE_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_NEPTUNE_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_NEPTUNE_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NEPTUNE_INERTIAL"), /*!< ISO18026 Label */
             new String("Neptune equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NEPTUNE_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_NEPTUNE_1991, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NEPTUNE_MAGNETIC_1993"), /*!< ISO18026 Label */
             new String("Neptune magnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NEPTUNE_MAGNETIC_1993, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_NEPTUNE_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NOGAPS_1988"), /*!< ISO18026 Label */
             new String("NOGAPS"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NOGAPS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_NOGAPS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NTF_1896"), /*!< ISO18026 Label */
             new String("NTF"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NTF_1896, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880_IGN, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_NTF_1896_PM_PARIS"), /*!< ISO18026 Label */
             new String("NTF (with the Prime Meridian at Paris)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_NTF_1896_PM_PARIS, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880_IGN, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_OBERON_1988"), /*!< ISO18026 Label */
             new String("Oberon"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_OBERON_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_OBERON_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_OBERON_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_OBSERV_METEORO_1939"), /*!< ISO18026 Label */
             new String("Observatorio Meteorologico"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_OBSERV_METEORO_1939, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_OLD_EGYPTIAN_1907"), /*!< ISO18026 Label */
             new String("Old Egyptian"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_OLD_EGYPTIAN_1907, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_HELMERT_1906, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_OLD_HAWAIIAN_CLARKE_1987"), /*!< ISO18026 Label */
             new String("Old Hawaiian (Clarke)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_CLARKE_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_OLD_HAWAIIAN_INT_1987"), /*!< ISO18026 Label */
             new String("Old Hawaiian (International)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_OLD_HAWAIIAN_INT_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_OPHELIA_1988"), /*!< ISO18026 Label */
             new String("Ophelia"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_OPHELIA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_OPHELIA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_OPHELIA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_OSGB_1936"), /*!< ISO18026 Label */
             new String("Ordnance Survey of Great Britain"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_OSGB_1936, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_AIRY_1830, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PAN_1991"), /*!< ISO18026 Label */
             new String("Pan"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PAN_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PAN_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PAN_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PANDORA_1988"), /*!< ISO18026 Label */
             new String("Pandora"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PANDORA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PANDORA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PANDORA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PHOBOS_1988"), /*!< ISO18026 Label */
             new String("Phobos"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PHOBOS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PHOBOS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PHOBOS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PHOEBE_1988"), /*!< ISO18026 Label */
             new String("Phoebe"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PHOEBE_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PHOEBE_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PHOEBE_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PICO_DE_LAS_NIEVES_1987"), /*!< ISO18026 Label */
             new String("Pico de las Nieves"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PICO_DE_LAS_NIEVES_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PITCAIRN_1967"), /*!< ISO18026 Label */
             new String("Pitcairn (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PITCAIRN_1967, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PLUTO_1994"), /*!< ISO18026 Label */
             new String("Pluto"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PLUTO_1994, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PLUTO_1994, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PLUTO_1994, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PLUTO_INERTIAL"), /*!< ISO18026 Label */
             new String("Pluto equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PLUTO_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PLUTO_1994, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_POINT_58_1991"), /*!< ISO18026 Label */
             new String("Point 58"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_POINT_58_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_POINTE_NOIRE_1948"), /*!< ISO18026 Label */
             new String("Pointe Noire"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_POINTE_NOIRE_1948, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PORTIA_1988"), /*!< ISO18026 Label */
             new String("Portia"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PORTIA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PORTIA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PORTIA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PORTO_SANTO_1936"), /*!< ISO18026 Label */
             new String("Porto Santo"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PORTO_SANTO_1936, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PROMETHEUS_1988"), /*!< ISO18026 Label */
             new String("Prometheus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PROMETHEUS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PROMETHEUS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PROMETHEUS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PROTEUS_1991"), /*!< ISO18026 Label */
             new String("Proteus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PROTEUS_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PROTEUS_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PROTEUS_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PROV_S_AM_1956"), /*!< ISO18026 Label */
             new String("Provisional South American"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PROV_S_AM_1956, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PROV_S_CHILEAN_1963"), /*!< ISO18026 Label */
             new String("Provisional South Chilean (Hito XVIII)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PROV_S_CHILEAN_1963, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PUCK_1988"), /*!< ISO18026 Label */
             new String("Puck"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PUCK_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_PUCK_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_PUCK_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PUERTO_RICO_1987"), /*!< ISO18026 Label */
             new String("Puerto Rico"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PUERTO_RICO_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_PULKOVO_1942"), /*!< ISO18026 Label */
             new String("Pulkovo"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_PULKOVO_1942, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_KRASSOVSKY_1940, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_QATAR_NATIONAL_1974"), /*!< ISO18026 Label */
             new String("Qatar National"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_QATAR_NATIONAL_1974, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_QORNOQ_1987"), /*!< ISO18026 Label */
             new String("Qornoq"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_QORNOQ_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_REUNION_1947"), /*!< ISO18026 Label */
             new String("Reunion"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_REUNION_1947, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_RGF_1993"), /*!< ISO18026 Label */
             new String("Reseau Geodesique Francais"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_RGF_1993, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GRS_1980, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_RHEA_1988"), /*!< ISO18026 Label */
             new String("Rhea"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_RHEA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_RHEA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_RHEA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ROME_1940"), /*!< ISO18026 Label */
             new String("Rome (also known as Monte Mario)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ROME_1940, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ROME_1940_PM_ROME"), /*!< ISO18026 Label */
             new String("Rome (also known as Monte Mario) (with the Prime Meridian at Rome)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ROME_1940_PM_ROME, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_ROSALIND_1988"), /*!< ISO18026 Label */
             new String("Rosalind"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_ROSALIND_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_ROSALIND_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_ROSALIND_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_S_AM_1969"), /*!< ISO18026 Label */
             new String("South American"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_S_AM_1969, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_SOUTH_AMERICAN_1969, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_S_ASIA_1987"), /*!< ISO18026 Label */
             new String("South Asia"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_S_ASIA_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_MODIFIED_FISCHER_1960, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_S_JTSK_1993"), /*!< ISO18026 Label */
             new String("S-JTSK"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_S_JTSK_1993, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_S42_PULKOVO"), /*!< ISO18026 Label */
             new String("S-42 (Pulkovo)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_S42_PULKOVO, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_KRASSOVSKY_1940, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SANTO_DOS_1965"), /*!< ISO18026 Label */
             new String("Santo (DOS)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SANTO_DOS_1965, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SAO_BRAZ_1987"), /*!< ISO18026 Label */
             new String("Sao Braz"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SAO_BRAZ_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SAPPER_HILL_1943"), /*!< ISO18026 Label */
             new String("Sapper Hill"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SAPPER_HILL_1943, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SATURN_1988"), /*!< ISO18026 Label */
             new String("Saturn"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SATURN_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_SATURN_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SATURN_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SATURN_INERTIAL"), /*!< ISO18026 Label */
             new String("Saturn equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SATURN_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SATURN_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SATURN_MAGNETIC_1993"), /*!< ISO18026 Label */
             new String("Saturn magnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SATURN_MAGNETIC_1993, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SATURN_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SCHWARZECK_1991"), /*!< ISO18026 Label */
             new String("Schwarzeck"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SCHWARZECK_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_NAMIBIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SELVAGEM_GRANDE_1938"), /*!< ISO18026 Label */
             new String("Selvagem Grande"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SELVAGEM_GRANDE_1938, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SIERRA_LEONE_1960"), /*!< ISO18026 Label */
             new String("Sierra Leone"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SIERRA_LEONE_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SIRGAS_2000"), /*!< ISO18026 Label */
             new String("SIRGAS"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SIRGAS_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_GRS_1980, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_SUN_1992"), /*!< ISO18026 Label */
             new String("Sun"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_SUN_1992, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_SUN_1992, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_SUN_1992, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TANANARIVE_OBS_1925"), /*!< ISO18026 Label */
             new String("Tananarive Observatory"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TANANARIVE_OBS_1925, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TANANARIVE_OBS_1925_PM_PARIS"), /*!< ISO18026 Label */
             new String("Tananarive Observatory (with the Prime Meridian at Paris)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TANANARIVE_OBS_1925_PM_PARIS, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TELESTO_1988"), /*!< ISO18026 Label */
             new String("Telesto"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TELESTO_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_TRI_AXIAL_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_TELESTO_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_TELESTO_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TERN_1961"), /*!< ISO18026 Label */
             new String("Tern (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TERN_1961, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TETHYS_1991"), /*!< ISO18026 Label */
             new String("Tethys"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TETHYS_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_TETHYS_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_TETHYS_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_THALASSA_1991"), /*!< ISO18026 Label */
             new String("Thalassa"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_THALASSA_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_THALASSA_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_THALASSA_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_THEBE_2000"), /*!< ISO18026 Label */
             new String("Thebe"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_THEBE_2000, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_THEBE_2000, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_THEBE_2000, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TIMBALAI_EVEREST_1948"), /*!< ISO18026 Label */
             new String("Timbali (Everest)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TIMBALAI_EVEREST_1948, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_EVEREST_BRUNEI_1967, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TITAN_1982"), /*!< ISO18026 Label */
             new String("Titan"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TITAN_1982, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_TITAN_1982, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_TITAN_1982, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TITANIA_1988"), /*!< ISO18026 Label */
             new String("Titania"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TITANIA_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_TITANIA_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_TITANIA_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TOKYO_1991"), /*!< ISO18026 Label */
             new String("Tokyo"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TOKYO_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TRISTAN_1968"), /*!< ISO18026 Label */
             new String("Tristan (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TRISTAN_1968, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_TRITON_1991"), /*!< ISO18026 Label */
             new String("Triton"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_TRITON_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_TRITON_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_TRITON_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_UMBRIEL_1988"), /*!< ISO18026 Label */
             new String("Umbriel"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_UMBRIEL_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UMBRIEL_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_UMBRIEL_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_URANUS_1988"), /*!< ISO18026 Label */
             new String("Uranus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_URANUS_1988, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_URANUS_1988, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_URANUS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_URANUS_INERTIAL"), /*!< ISO18026 Label */
             new String("Uranus equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_URANUS_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_URANUS_1988, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_URANUS_MAGNETIC_1993"), /*!< ISO18026 Label */
             new String("Uranus magnetic"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_URANUS_MAGNETIC_1993, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_CELESTIOMAGNETIC, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_URANUS_1988, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_VENUS_1991"), /*!< ISO18026 Label */
             new String("Venus"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_VENUS_1991, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_SPHERE, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_UNSPECIFIED, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_VENUS_1991, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_VENUS_1991, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet1
        (
             new String("ORMCOD_VENUS_INERTIAL"), /*!< ISO18026 Label */
             new String("Venus equatorial inertial"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORMCOD_VENUS_INERTIAL, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMTCOD_BI_AXIS_ORIGIN_3D, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRSCOD_EQUATORIAL_INERTIAL, /*!< OBRS Code */
             SRM_RD_Code.RDCOD_UNSPECIFIED, /*!< RD parameterization code */
             SRM_ORM_Code.ORMCOD_VENUS_1991, /*!< Reference ORM */
             0 /*!< RT count for this ORM */
        )
    };
}
