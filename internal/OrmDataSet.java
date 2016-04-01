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

import java.util.*;

class OrmDataSet
{
    public String        _label;
    public String        _description;
    public SRM_ORM_Code  _orm_code;
    public SRM_ORMT_Code _orm_template;
    public SRM_OBRS_Code _obrs_code;
    public SRM_RD_Code   _rd_code;
    public SRM_ORM_Code  _reference_orm;
    public int           _rt_count;
    public Vector        _rt_vector;

    protected OrmDataSet( String        label,
                          String        description,
                          SRM_ORM_Code  orm_code,
                          SRM_ORMT_Code orm_template,
                          SRM_OBRS_Code obrs_code,
                          SRM_RD_Code   rd_code,
                          SRM_ORM_Code  reference_orm,
                          int           rt_count )
    {
        _label = label;
        _description = description;
        _orm_code = orm_code;
        _orm_template = orm_template;
        _obrs_code = obrs_code;
        _rd_code = rd_code;
        _reference_orm = reference_orm;
        _rt_count = rt_count;
    }

    // The actual data has to be split to two tables in the children classes
    // OrmDataSet1 and OrmDataSet2 so that the compiler can handle the large
    // number of cases.
    public static OrmDataSet getElem(SRM_ORM_Code code)
    {
        if (code.toInt() >= 0 && code.toInt() <= 241 )  // this table has ORM from 0 to 241
        {
            return OrmDataSet1.getElem( code );
        }
        else // this table has ORM from 242 to 482
        {
            return OrmDataSet2.getElem( code );
        }
    }
}

