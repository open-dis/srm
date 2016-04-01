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
@brief Reference Datum data table containing initial parameters assciated with each RD.
*/
package SRM;

class RdDataSet
{
    public String       _label;
    public String       _description;
    public SRM_RD_Code  _rd_code;
    public String       _rd_category;
    public double       _A;
    public double       _inv_F;
    public double       _R;
    public double       _B;
    public double       _C;

    private RdDataSet( String label,
                       String description,
                       SRM_RD_Code code,
                       String rd_category,
                       double A,
                       double inv_F,
                       double R,
                       double B,
                       double C )
    {
       _label =label;
       _description = description;
       _rd_code = code;
       _rd_category = rd_category;
       _A = A;
       _inv_F = inv_F;
       _R = R;
       _B = B;
       _C = C;
    }

    public static RdDataSet getElem(SRM_RD_Code index)
    {
        int indexInt = index.toInt();

        if (indexInt >= 0)
            return table[index.toInt()];
        else if (index == SRM_RD_Code.RDCOD_EXPERIMENTAL_NGA_SRM_MAX)
        {
            return table[SRM_RD_Code._totalEnum+1];
        }
        else if (index == SRM_RD_Code.RDCOD_EXPERIMENTAL_NGA_SPHERE)
        {
            return table[SRM_RD_Code._totalEnum+2];
        }
        return null;
    }

    public static RdDataSet[] table =
    {
        new RdDataSet
        (
               new String ("RDCOD_NULL"), /*!<ISO18026 label*/
               new String ("Null"), /*!<RD Description*/
               SRM_RD_Code.RDCOD_UNSPECIFIED, /*!<ISO18026 Code*/
               new String ("Null"), /*!<RD category*/
               Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
               Double.NaN, /*!<F (Inverse Flattening Ratio)*/
               Double.NaN, /*!<R (Spherical Radius)*/
               Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
               Double.NaN /*!<C (Semi-Axis C Not Used for Earth(*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ORIGIN_2D"), /*!< ISO18026 Label */
             new String("Origin in 2D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ORIGIN_2D, /*!< RD Code enum */
             "POINT", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_X_UNIT_POINT_2D"), /*!< ISO18026 Label */
             new String("x-axis unit point in 2D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_X_UNIT_POINT_2D, /*!< RD Code enum */
             "POINT", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_Y_UNIT_POINT_2D"), /*!< ISO18026 Label */
             new String("y-axis unit point in 2D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_Y_UNIT_POINT_2D, /*!< RD Code enum */
             "POINT", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ORIGIN_3D"), /*!< ISO18026 Label */
             new String("Origin in 3D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ORIGIN_3D, /*!< RD Code enum */
             "POINT", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_X_UNIT_POINT_3D"), /*!< ISO18026 Label */
             new String("x-axis unit point in 3D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_X_UNIT_POINT_3D, /*!< RD Code enum */
             "POINT", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_Y_UNIT_POINT_3D"), /*!< ISO18026 Label */
             new String("y-axis unit point in 3D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_Y_UNIT_POINT_3D, /*!< RD Code enum */
             "POINT", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_Z_UNIT_POINT_3D"), /*!< ISO18026 Label */
             new String("z-axis unit point in 3D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_Z_UNIT_POINT_3D, /*!< RD Code enum */
             "POINT", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_X_AXIS_2D"), /*!< ISO18026 Label */
             new String("x-axis in 2D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_X_AXIS_2D, /*!< RD Code enum */
             "CURVE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_Y_AXIS_2D"), /*!< ISO18026 Label */
             new String("y-axis in 2D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_Y_AXIS_2D, /*!< RD Code enum */
             "CURVE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_X_AXIS_3D"), /*!< ISO18026 Label */
             new String("x-axis in 3D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_X_AXIS_3D, /*!< RD Code enum */
             "CURVE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_Y_AXIS_3D"), /*!< ISO18026 Label */
             new String("y-axis in 3D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_Y_AXIS_3D, /*!< RD Code enum */
             "CURVE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_Z_AXIS_3D"), /*!< ISO18026 Label */
             new String("z-axis in 3D"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_Z_AXIS_3D, /*!< RD Code enum */
             "CURVE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_XY_PLANE_3D"), /*!< ISO18026 Label */
             new String("xy-plane"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_XY_PLANE_3D, /*!< RD Code enum */
             "PLANE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_XZ_PLANE_3D"), /*!< ISO18026 Label */
             new String("xz-plane"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_XZ_PLANE_3D, /*!< RD Code enum */
             "PLANE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_YZ_PLANE_3D"), /*!< ISO18026 Label */
             new String("yz-plane"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_YZ_PLANE_3D, /*!< RD Code enum */
             "PLANE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ADRASTEA_2000"), /*!< ISO18026 Label */
             new String("Adrastea (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ADRASTEA_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.0000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             8.0000000000000e3, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             7.0000000000000e3 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_AIRY_1830"), /*!< ISO18026 Label */
             new String("Airy"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_AIRY_1830, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3775633960000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9932496460000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_AMALTHEA_2000"), /*!< ISO18026 Label */
             new String("Amalthea (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_AMALTHEA_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.2500000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             7.3000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             6.4000000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ANANKE_1988"), /*!< ISO18026 Label */
             new String("Ananke (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ANANKE_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.0000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_APL_4r5_1968"), /*!< ISO18026 Label */
             new String("APL 4.5"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_APL_4r5_1968, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781440000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9823000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ARIEL_1988"), /*!< ISO18026 Label */
             new String("Ariel (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ARIEL_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             5.8110000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             5.7790000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             5.7770000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ATLAS_1988"), /*!< ISO18026 Label */
             new String("Atlas (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ATLAS_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.8500000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.7200000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             1.3500000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_AUSTRALIAN_NATIONAL_1966"), /*!< ISO18026 Label */
             new String("Australian national"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_AUSTRALIAN_NATIONAL_1966, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781600000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_AVERAGE_TERRESTRIAL_1977"), /*!< ISO18026 Label */
             new String("Average terrestrial system"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_AVERAGE_TERRESTRIAL_1977, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781350000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825700000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_BELINDA_1988"), /*!< ISO18026 Label */
             new String("Belinda (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_BELINDA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             3.3000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_BESSEL_1841_ETHIOPIA"), /*!< ISO18026 Label */
             new String("Bessel (Ethiopia, Indonesia, Japan, and Korea)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_BESSEL_1841_ETHIOPIA, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3773971550000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9915281280000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_BESSEL_1841_NAMIBIA"), /*!< ISO18026 Label */
             new String("Bessel (Namibia)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_BESSEL_1841_NAMIBIA, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3774838650000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9915281280000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_BIANCA_1988"), /*!< ISO18026 Label */
             new String("Bianca (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_BIANCA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             2.1000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CALLISTO_2000"), /*!< ISO18026 Label */
             new String("Callisto (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CALLISTO_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             2.4094000000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             2.4092000000000e6, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             2.4093000000000e6 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CALYPSO_1988"), /*!< ISO18026 Label */
             new String("Calypso (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CALYPSO_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.5000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             8.0000000000000e3, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             8.0000000000000e3 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CARME_1988"), /*!< ISO18026 Label */
             new String("Carme (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CARME_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.5000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CHARON_1991"), /*!< ISO18026 Label */
             new String("Charon (satellite of Pluto)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CHARON_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             5.9300000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1858"), /*!< ISO18026 Label */
             new String("Clarke"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1858, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782356000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9426067680000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1858_MODIFIED"), /*!< ISO18026 Label */
             new String("Clarke - modified"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1858_MODIFIED, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782936450000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9426000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1866"), /*!< ISO18026 Label */
             new String("Clarke"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1866, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782064000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9497869820000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1880"), /*!< ISO18026 Label */
             new String("Clarke"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1880, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782491450000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9346500000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1880_CAPE"), /*!< ISO18026 Label */
             new String("Clarke - Cape"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1880_CAPE, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782491450000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9346630770000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1880_FIJI"), /*!< ISO18026 Label */
             new String("Clarke - Fiji"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1880_FIJI, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3783010000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9346500000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1880_IGN"), /*!< ISO18026 Label */
             new String("Clarke - IGN"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1880_IGN, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782492000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9346602080000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1880_PALESTINE"), /*!< ISO18026 Label */
             new String("Clarke - Palestine"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1880_PALESTINE, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3783007820000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9346630770000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CLARKE_1880_SYRIA"), /*!< ISO18026 Label */
             new String("Clarke - Syria"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CLARKE_1880_SYRIA, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782478420000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9346635170000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_COAMPS_1998"), /*!< ISO18026 Label */
             new String("Coupled Ocean/Atmospheric Mesoscale Prediction System (COAMPSTM)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_COAMPS_1998, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3712290000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CORDELIA_1988"), /*!< ISO18026 Label */
             new String("Cordelia (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CORDELIA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.3000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_CRESSIDA_1988"), /*!< ISO18026 Label */
             new String("Cressida (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_CRESSIDA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             3.1000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_DANISH_1876"), /*!< ISO18026 Label */
             new String("Danish - Andrae"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_DANISH_1876, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3771044300000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0000000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_DEIMOS_1988"), /*!< ISO18026 Label */
             new String("Deimos (satellite of Mars)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_DEIMOS_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             7.5000000000000e3, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             6.1000000000000e3, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             5.2000000000000e3 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_DELAMBRE_1810"), /*!< ISO18026 Label */
             new String("Delambre"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_DELAMBRE_1810, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3769852280000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0864000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_DESDEMONA_1988"), /*!< ISO18026 Label */
             new String("Desdemona (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_DESDEMONA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             2.7000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_DESPINA_1991"), /*!< ISO18026 Label */
             new String("Despina (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_DESPINA_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.4000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_DIONE_1982"), /*!< ISO18026 Label */
             new String("Dione (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_DIONE_1982, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             5.6000000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ELARA_1988"), /*!< ISO18026 Label */
             new String("Elara (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ELARA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             4.0000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ENCELADUS_1994"), /*!< ISO18026 Label */
             new String("Enceladus (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ENCELADUS_1994, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             2.5630000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             2.4730000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             2.4460000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EPIMETHEUS_1988"), /*!< ISO18026 Label */
             new String("Epimetheus (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EPIMETHEUS_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             6.9000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             5.5000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             5.5000000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EROS_2000"), /*!< ISO18026 Label */
             new String("Eros (asteroid 433, a minor planet)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EROS_2000, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.3110000000000e3, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EUROPA_2000"), /*!< ISO18026 Label */
             new String("Europa (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EUROPA_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.5641300000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.5612300000000e6, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             1.5609300000000e6 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EVEREST_ADJ_1937"), /*!< ISO18026 Label */
             new String("Everest 1830 - adjusted"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EVEREST_ADJ_1937, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3772763450000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0080170000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EVEREST_1948"), /*!< ISO18026 Label */
             new String("Everest"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EVEREST_1948, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3773040630000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0080170000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EVEREST_1956"), /*!< ISO18026 Label */
             new String("Everest"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EVEREST_1956, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3773012430000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0080170000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EVEREST_REVISED_1962"), /*!< ISO18026 Label */
             new String("Everest 1830 - revised definition"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EVEREST_REVISED_1962, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3773096130000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0080170000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EVEREST_1969"), /*!< ISO18026 Label */
             new String("Everest"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EVEREST_1969, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3772956640000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0080170000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EVEREST_BRUNEI_1967"), /*!< ISO18026 Label */
             new String("Everest 1830 - 1967 definition (Brunei and East Malaysia - Sabah and Sarawak)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EVEREST_BRUNEI_1967, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3772985560000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0080170000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_FISCHER_1960"), /*!< ISO18026 Label */
             new String("Fischer - Mercury"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_FISCHER_1960, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781660000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9830000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_FISCHER_1968"), /*!< ISO18026 Label */
             new String("Fischer"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_FISCHER_1968, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781500000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9830000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_GALATEA_1991"), /*!< ISO18026 Label */
             new String("Galatea (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_GALATEA_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.9000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_GANYMEDE_2000"), /*!< ISO18026 Label */
             new String("Ganymede (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_GANYMEDE_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             2.6324000000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             2.6322900000000e6, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             2.6323500000000e6 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_GASPRA_1991"), /*!< ISO18026 Label */
             new String("Gaspra (asteroid 951, a minor planet)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_GASPRA_1991, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             9.1000000000000e3, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             5.2000000000000e3, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             4.4000000000000e3 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_GRS_1967"), /*!< ISO18026 Label */
             new String("Geodetic Reference System (GRS)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_GRS_1967, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781600000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9824716740000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_GRS_1980"), /*!< ISO18026 Label */
             new String("Geodetic Reference System (GRS)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_GRS_1980, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781370000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825722210100e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_HELENE_1992"), /*!< ISO18026 Label */
             new String("Helene (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_HELENE_1992, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.8000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.6000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             1.5000000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_HELMERT_1906"), /*!< ISO18026 Label */
             new String("Helmert"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_HELMERT_1906, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782000000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9830000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_HIMALIA_1988"), /*!< ISO18026 Label */
             new String("Himalia (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_HIMALIA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             8.5000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_HOUGH_1960"), /*!< ISO18026 Label */
             new String("Hough"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_HOUGH_1960, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782700000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9700000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_HYPERION_2000"), /*!< ISO18026 Label */
             new String("Hyperion (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_HYPERION_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.6400000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.3000000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             1.0700000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_IAG_1975"), /*!< ISO18026 Label */
             new String("International Association of Geodesy (IAG) best estimate"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_IAG_1975, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781400000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825700000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_IAPETUS_1988"), /*!< ISO18026 Label */
             new String("Iapetus (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_IAPETUS_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.1800000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_IDA_1991"), /*!< ISO18026 Label */
             new String("Ida (asteroid 293, a minor planet)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_IDA_1991, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             2.6800000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.2000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             7.6000000000000e3 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_INDONESIAN_1974"), /*!< ISO18026 Label */
             new String("Indonesian"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_INDONESIAN_1974, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781600000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9824700000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_INTERNATIONAL_1924"), /*!< ISO18026 Label */
             new String("International"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_INTERNATIONAL_1924, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3783880000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9700000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_IO_2000"), /*!< ISO18026 Label */
             new String("Io (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_IO_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.8294000000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.8293000000000e6, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             1.8157000000000e6 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_JANUS_1988"), /*!< ISO18026 Label */
             new String("Janus (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_JANUS_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             9.7000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             9.5000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             7.7000000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_JULIET_1988"), /*!< ISO18026 Label */
             new String("Juliet (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_JULIET_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             4.2000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_JUPITER_1988"), /*!< ISO18026 Label */
             new String("Jupiter"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_JUPITER_1988, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             7.1492000000000e7, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             1.5414000000000e1, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_KLEOPATRA_2000"), /*!< ISO18026 Label */
             new String("Kleopatra (asteroid 216, a minor planet)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_KLEOPATRA_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.0850000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             4.7000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             4.0500000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_KRASSOVSKY_1940"), /*!< ISO18026 Label */
             new String("Krassovsky"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_KRASSOVSKY_1940, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782450000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9830000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_KRAYENHOFF_1827"), /*!< ISO18026 Label */
             new String("Krayenhoff"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_KRAYENHOFF_1827, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3769504000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0965000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_LARISSA_1991"), /*!< ISO18026 Label */
             new String("Larissa (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_LARISSA_1991, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             1.0400000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             6.9300000000000e0, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_LEDA_1988"), /*!< ISO18026 Label */
             new String("Leda (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_LEDA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             5.0000000000000e3, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_LYSITHEA_1988"), /*!< ISO18026 Label */
             new String("Lysithea (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_LYSITHEA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.2000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MARS_2000"), /*!< ISO18026 Label */
             new String("Mars"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MARS_2000, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             3.3961900000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             1.6989400000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MARS_SPHERE_2000"), /*!< ISO18026 Label */
             new String("Mars"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MARS_SPHERE_2000, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             3.3895000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MASS_1999"), /*!< ISO18026 Label */
             new String("MASS"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MASS_1999, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3712213000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MERCURY_1988"), /*!< ISO18026 Label */
             new String("Mercury"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MERCURY_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             2.4397000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_METIS_2000"), /*!< ISO18026 Label */
             new String("Metis (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_METIS_2000, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             3.0000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0000000000000e0, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MIMAS_1994"), /*!< ISO18026 Label */
             new String("Mimas (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MIMAS_1994, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             2.0910000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.9620000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             1.9140000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MIRANDA_1988"), /*!< ISO18026 Label */
             new String("Miranda (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MIRANDA_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             2.4040000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             2.3420000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             2.3290000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MM5_1997"), /*!< ISO18026 Label */
             new String("Mesoscale (weather) Model 5 (MM5), Air Force Weather Agency (AFWA), US"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MM5_1997, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3700000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MODIFIED_AIRY_1849"), /*!< ISO18026 Label */
             new String("Modified Airy"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MODIFIED_AIRY_1849, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3773401890000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9932496460000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MODIFIED_FISCHER_1960"), /*!< ISO18026 Label */
             new String("Modified Fischer"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MODIFIED_FISCHER_1960, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781550000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9830000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MODTRAN_MIDLATITUDE_1989"), /*!< ISO18026 Label */
             new String("MODTRAN (midlatitude regions)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MODTRAN_MIDLATITUDE_1989, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3712300000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MODTRAN_SUBARCTIC_1989"), /*!< ISO18026 Label */
             new String("MODTRAN (subarctic regions)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MODTRAN_SUBARCTIC_1989, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3569100000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MODTRAN_TROPICAL_1989"), /*!< ISO18026 Label */
             new String("MODTRAN (tropical regions)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MODTRAN_TROPICAL_1989, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3783900000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MOON_1991"), /*!< ISO18026 Label */
             new String("Moon (satellite of Earth)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MOON_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.7374000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_MULTIGEN_FLAT_EARTH_1989"), /*!< ISO18026 Label */
             new String("Multigen flat Earth"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_MULTIGEN_FLAT_EARTH_1989, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3667070200000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_NAIAD_1991"), /*!< ISO18026 Label */
             new String("Naiad (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_NAIAD_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             2.9000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_NEPTUNE_1991"), /*!< ISO18026 Label */
             new String("Neptune"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_NEPTUNE_1991, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             2.4764000000000e7, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             5.8544000000000e1, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_NEREID_1991"), /*!< ISO18026 Label */
             new String("Nereid (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_NEREID_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.7000000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_NOGAPS_1988"), /*!< ISO18026 Label */
             new String("Navy Operational Global Atmospheric Prediction System (NOGAPS), US"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_NOGAPS_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.3710000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_OBERON_1988"), /*!< ISO18026 Label */
             new String("Oberon (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_OBERON_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.6140000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_OPHELIA_1988"), /*!< ISO18026 Label */
             new String("Ophelia (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_OPHELIA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.5000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PAN_1991"), /*!< ISO18026 Label */
             new String("Pan (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PAN_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.0000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PANDORA_1988"), /*!< ISO18026 Label */
             new String("Pandora (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PANDORA_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             5.5000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             4.4000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             3.1000000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PASIPHAE_1988"), /*!< ISO18026 Label */
             new String("Pasiphae (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PASIPHAE_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.8000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PHOBOS_1988"), /*!< ISO18026 Label */
             new String("Phobos (satellite of Mars)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PHOBOS_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.3400000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.1200000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             9.2000000000000e3 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PHOEBE_1988"), /*!< ISO18026 Label */
             new String("Phoebe (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PHOEBE_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.1500000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.1000000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             1.0500000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PLESSIS_MODIFIED_1817"), /*!< ISO18026 Label */
             new String("Plessis - Modified"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PLESSIS_MODIFIED_1817, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3765230000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0864000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PLUTO_1994"), /*!< ISO18026 Label */
             new String("Pluto"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PLUTO_1994, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.1950000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PORTIA_1988"), /*!< ISO18026 Label */
             new String("Portia (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PORTIA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             5.4000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PROMETHEUS_1988"), /*!< ISO18026 Label */
             new String("Prometheus (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PROMETHEUS_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             7.4000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             5.0000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             3.4000000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PROTEUS_1991"), /*!< ISO18026 Label */
             new String("Proteus (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PROTEUS_1991, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             2.1800000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             2.0800000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             2.0100000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_PUCK_1988"), /*!< ISO18026 Label */
             new String("Puck (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_PUCK_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.7000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_RHEA_1988"), /*!< ISO18026 Label */
             new String("Rhea (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_RHEA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.6400000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_ROSALIND_1988"), /*!< ISO18026 Label */
             new String("Rosalind (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_ROSALIND_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             2.7000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_SATURN_1988"), /*!< ISO18026 Label */
             new String("Saturn"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_SATURN_1988, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.0268000000000e7, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             1.0208000000000e1, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_SINOPE_1988"), /*!< ISO18026 Label */
             new String("Sinope (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_SINOPE_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.4000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_SOUTH_AMERICAN_1969"), /*!< ISO18026 Label */
             new String("South american"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_SOUTH_AMERICAN_1969, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781600000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_SOVIET_GEODETIC_1985"), /*!< ISO18026 Label */
             new String("Soviet geodetic system"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_SOVIET_GEODETIC_1985, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781360000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825700000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_SOVIET_GEODETIC_1990"), /*!< ISO18026 Label */
             new String("Soviet geodetic system"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_SOVIET_GEODETIC_1990, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781360000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825783930000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_STRUVE_1860"), /*!< ISO18026 Label */
             new String("Struve"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_STRUVE_1860, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3782983000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9473000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_SUN_1992"), /*!< ISO18026 Label */
             new String("Sun"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_SUN_1992, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.9600000000000e8, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_TELESTO_1988"), /*!< ISO18026 Label */
             new String("Telesto (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_TELESTO_1988, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             1.5000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             1.2500000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             7.5000000000000e3 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_TETHYS_1991"), /*!< ISO18026 Label */
             new String("Tethys (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_TETHYS_1991, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             5.3560000000000e5, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             5.2820000000000e5, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             5.2580000000000e5 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_THALASSA_1991"), /*!< ISO18026 Label */
             new String("Thalassa (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_THALASSA_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             4.0000000000000e4, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_THEBE_2000"), /*!< ISO18026 Label */
             new String("Thebe (satellite of Jupiter)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_THEBE_2000, /*!< RD Code enum */
             "TRI_AXIAL_ELLIPSOID", /*!< RD Category */
             5.8000000000000e4, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             4.9000000000000e4, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             4.2000000000000e4 /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_TITAN_1982"), /*!< ISO18026 Label */
             new String("Titan (satellite of Saturn)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_TITAN_1982, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             2.5750000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_TITANIA_1988"), /*!< ISO18026 Label */
             new String("Titania (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_TITANIA_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             7.8890000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_TRITON_1991"), /*!< ISO18026 Label */
             new String("Triton (satellite of Neptune)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_TRITON_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             1.3526000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_UMBRIEL_1988"), /*!< ISO18026 Label */
             new String("Umbriel (satellite of Uranus)"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_UMBRIEL_1988, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             5.8470000000000e5, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_URANUS_1988"), /*!< ISO18026 Label */
             new String("Uranus"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_URANUS_1988, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             2.5559000000000e7, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             4.3616000000000e1, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_VENUS_1991"), /*!< ISO18026 Label */
             new String("Venus"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_VENUS_1991, /*!< RD Code enum */
             "SPHERE", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             6.0518000000000e6, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_WALBECK_AMS_1963"), /*!< ISO18026 Label */
             new String("Walbeck 1819 - AMS"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_WALBECK_AMS_1963, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3768960000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0278000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_WALBECK_PLANHEFT_1942"), /*!< ISO18026 Label */
             new String("Walbeck 1819 - Planheft"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_WALBECK_PLANHEFT_1942, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3768950000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             3.0278215650000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_WAR_OFFICE_1924"), /*!< ISO18026 Label */
             new String("War Office - McCaw"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_WAR_OFFICE_1924, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3783000000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9600000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_WGS_1960"), /*!< ISO18026 Label */
             new String("World Geodetic System 1960"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_WGS_1960, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781650000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9830000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_WGS_1966"), /*!< ISO18026 Label */
             new String("World Geodetic System 1966"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_WGS_1966, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781450000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_WGS_1984"), /*!< ISO18026 Label */
             new String("World geodetic system"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_WGS_1984, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781370000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9825722356300e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_WGS_1972"), /*!< ISO18026 Label */
             new String("World geodetic system"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_WGS_1972, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.3781350000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             2.9826000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EXPERIMENTAL_NGA_SRM_MAX"), /*!< ISO18026 Label */
             new String("NGA_SRM_MAX"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EXPERIMENTAL_NGA_SRM_MAX, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             6.4000000000000e6, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             1.5000000000000e2, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        ),

        new RdDataSet
        (
             new String("RDCOD_EXPERIMENTAL_NGA_SPHERE"), /*!< ISO18026 Label */
             new String("EXPERIMENTAL_NGA_SPHERE"), /*!< ISO18026 Description */
             SRM_RD_Code.RDCOD_EXPERIMENTAL_NGA_SPHERE, /*!< RD Code enum */
             "OBLATE_ELLIPSOID", /*!< RD Category */
             Double.NaN, /*!<A (Semi-Axis A Semi-Major for Earth)*/
             Double.NaN, /*!<F (Inverse Flattening Ratio)*/
             Double.NaN, /*!<R (Spherical Radius)*/
             Double.NaN, /*!<B (Semi-Axis B Semi-Minor for Earth)*/
             Double.NaN /*!<C (Semi-Axis C Not used for earth)*/
        )

    };
}
