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

public class OrmData
{
    public double A, A_inv, B, B_inv, F, F_inv, C, Eps2, Eps, Epps2;
    public double EpsH, Eps25, A2,  A2_inv, C2;

    public OrmData(SRM_ORM_Code orm)
    {
        SRM_RD_Code   rdCode  = OrmDataSet.getElem(orm)._rd_code;
        SRM_ORMT_Code tmpORMT = OrmDataSet.getElem(orm)._orm_template;

        if (orm.toInt() >= 0)
        {
            if (rdCode != SRM_RD_Code.RDCOD_UNSPECIFIED)
            {
                RdDataSet rdSet = RdDataSet.getElem(rdCode);

                switch (tmpORMT)
                {
                    case ORMTCOD_SPHERE:
                    case ORMTCOD_SPHERE_ORIGIN:
                    {
                         A      = rdSet._R;
                         F_inv  = Double.NaN;
                         F      = 0.0;

                         A_inv  = 1.0/A;
                         A2     = (A*A);
                         A2_inv = 1.0/A2;
                         B      = (A)*(1.0 - F);
                         B_inv  = A_inv;

                         C      = (A) * (1.0-F);
                         Eps2   = 0.0;
                         Eps    = Math.sqrt(Eps2);
                         Eps25  = .25 * (Eps2);
                         Epps2  = (Eps2) / (1.0 - Eps2);
                         EpsH   = (Eps) * 0.5;
                         C2     = C * C;
                         break;
                    }
                    case ORMTCOD_OBLATE_ELLIPSOID:
                    case ORMTCOD_OBLATE_ELLIPSOID_ORIGIN:
                    case ORMTCOD_TRI_AXIAL_ELLIPSOID:
                    {
                         A     = rdSet._A;
                         F_inv = rdSet._inv_F;
                         F     = 1.0/F_inv;

                         A_inv  = 1.0/A;
                         A2     = (A*A);
                         A2_inv = 1.0/A2;
                         B      = A * (1.0 - F);
                         B_inv  = 1.0/B;

                         C      = A * (1.0-F);
                         Eps2   = F * (2.0-F);
                         Eps    = Math.sqrt(Eps2);
                         Eps25  = .25 * (Eps2);
                         Epps2  = Eps2 / (1.0 - Eps2);
                         EpsH   = Eps * 0.5;
                         C2     = C * C;
                         break;
                    }
                    default:
                    {
                         A      = 0.0;
                         F_inv  = 0.0;
                         F      = 0.0;
                         A_inv  = 0.0;
                         A2     = 0.0;
                         A2_inv = 0.0;
                         B      = 0.0;
                         B_inv  = 0.0;
                         C      = 0.0;
                         Eps2   = 0.0;
                         Eps    = 0.0;
                         Eps25  = 0.0;
                         Epps2  = 0.0;
                         EpsH   = 0.0;
                         C2     = 0.0;
                         break;
                    }
                }
            }
            // else all the values initialized to zero.
        }
        else
        {
            if (orm == SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_MAX)
            {
                A     = 6400000.0;
                F_inv = 150.0;
                F     = 1.0/F_inv;
            }
            else if (orm == SRM_ORM_Code.ORMCOD_EXPERIMENTAL_NGA_SPHERE)
            {
                A     = 20000000.0/Const.PI;
                F_inv = Double.NaN;
                F     = 0.0;
            }
            else
            {
                A     = Double.NaN;
                F_inv = Double.NaN;
                F     = Double.NaN;
            }
            A_inv  = 1.0/(A);
            A2     = A*A;
            A2_inv = 1.0/A2;
            B      = A * (1.0- F);
            B_inv  = 1.0/B;
            C      = A * (1.0 - F);
            Eps2   = F * (2.0 - F);
            Eps    = Math.sqrt(Eps2);
            Eps25  =.25 * Eps2;
            Epps2  = Eps2 / (1.0 - Eps2);
            EpsH   = Eps * 0.5;
            C2     = C * C;
        }
    }
}
