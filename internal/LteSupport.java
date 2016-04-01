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
@brief class implementing the support functions specifically for the LTE creation and
       intermidiate LTE used in Direction/Orientation conversions.
*/

package SRM;

class LteSupport
{
    protected static SRF_LocalTangentSpaceEuclidean createLtesSRF
    (
        BaseSRF  srf_org,
        double[] coord_org, //surface coord
        double   azimuth,
        double   x_false_origin,
        double   y_false_origin,
        double   height_offset
    ) throws SrmException
    {
        SRF_Celestiodetic cd_srf_obj;
        double[] my_3D_org = { coord_org[0], coord_org[1], 0.0 };
        double[] my_3D_tgt = new double[3];

        // First create Celestiodetic SRF using the same ORM/RT
        cd_srf_obj = new SRF_Celestiodetic ( srf_org.getOrm(),
                                             srf_org.getRt() );

        // Convert the source coordinate ( 0.0, 0.0 ) to Celestiodetic
        OpManager.instance().computeAsArray( srf_org, cd_srf_obj, my_3D_org, my_3D_tgt, null );

        // Instantiate the LTE SRF using the lon and lat obtained from the above conversion
        return new SRF_LocalTangentSpaceEuclidean( srf_org.getOrm(), srf_org.getRt(),  my_3D_tgt[0],
                                                   my_3D_tgt[1], azimuth, x_false_origin, y_false_origin,
                                                   height_offset);
    }


    // computes the LTE rotation matrix F.
    // The inv_F can be obtained by using Const.invert()
    protected static void LTP_Rotation_Matrix_F( double[][] T,
                                                 double lambda, // lon
                                                 double phi,    // lat
                                                 double alpha)  // azimuth
    {
        double cl=Math.cos(lambda);
        double sl=Math.sin(lambda);

        double cp=Math.cos(phi);
        double sp=Math.sin(phi);

        double ca=Math.cos(alpha);
        double sa=Math.sin(alpha);


        T[0][0]= -sl * ca + cl * sp * sa;
        T[0][1]= -sl * sa + -cl *sp *ca;
        T[0][2]=  cl * cp;
        T[0][3]=  0;

        T[1][0]= cl * ca + sl * sp * sa;
        T[1][1]= cl * sa + -sl * sp * ca;
        T[1][2]= sl * cp;
        T[1][3]=  0;

        T[2][0]= cp * -sa;
        T[2][1]= cp *  ca;
        T[2][2]= sp;
        T[2][3]=  0;

        T[3][0]= 0;
        T[3][1]= 0;
        T[3][2]= 0;
        T[3][3]= 1;
    }
}
