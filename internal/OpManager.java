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

import java.util.*;

public class OpManager
{
    // Steps to add a new SRF or new conversion routines for an existing SRF
    // 1) If new SRF
    //    - Add the SRF to the SrrfEnum
    //    - Create a XXConv.java like existing with new conversion routines
    //    - Register the new XXConv object in the OpManager constructor
    //      (below)
    // 2) New conversion routines for an existing SRF
    //    -  Add the conversion routines to its corresponding XXConv class
    //    -  Add the target SRF to the list of destinations in XXConc
    //    -  Add a case for the new conversion routine in XXConc

    private static OpManager _mngr  = new OpManager();

    public static OpManager instance()
    {
        return  _mngr;
    }

    private OpManager()
    {
        // create and register all conversion objects with the Function
        //  map for future search and chaining purpose
        FunctionMap.instance().register(new CcenConv());
        FunctionMap.instance().register(new Lsr2Conv());
        FunctionMap.instance().register(new Lsr3Conv());
        FunctionMap.instance().register(new CdetConv());
        FunctionMap.instance().register(new MercConv());
        FunctionMap.instance().register(new TmConv());
        FunctionMap.instance().register(new LccConv());
        FunctionMap.instance().register(new LteConv());
        FunctionMap.instance().register(new LctpConv());
        FunctionMap.instance().register(new LtasConv());
        FunctionMap.instance().register(new CmagConv());
        FunctionMap.instance().register(new EqinConv());
        FunctionMap.instance().register(new SeclConv());
        FunctionMap.instance().register(new SeqtConv());
//        FunctionMap.instance().register(new SmagConv()); // edition 2 changed from spherical to Euclidean 3D
//        FunctionMap.instance().register(new SmtpConv()); // edition 2 changed from spherical to Euclidean 3D
        FunctionMap.instance().register(new HaecConv());
        FunctionMap.instance().register(new HeecConv());
        FunctionMap.instance().register(new HeeqConv());
        FunctionMap.instance().register(new AzConv());
        FunctionMap.instance().register(new PolConv());
        FunctionMap.instance().register(new PdetConv());
        FunctionMap.instance().register(new OmConv());
        FunctionMap.instance().register(new LceConv());
        FunctionMap.instance().register(new PostConv());
        FunctionMap.instance().register(new EqcyConv());
    }

    private Vector buildOpSeq
    (
        BaseSRF              srcSrf,
        SRM_ORM_Trans_Params hst,
        BaseSRF              tgtSrf
    ) throws SrmException
    {
        Vector<Conversions> opList = new Vector<Conversions>();

        //simply find path from the source to the target when
        // the ORMs and RTs are the same
        if (srcSrf.getOrm() == tgtSrf.getOrm()  &&
            srcSrf.getRt() == tgtSrf.getRt() &&
            hst == null)
        { // this case is the case for user supplied xformation params.
            // find path is SRFs are different
            if (srcSrf.getClass() != tgtSrf.getClass())
            {
                Vector<SRM_SRFT_Code> path = Bfs.instance().GetConversionPath
                                      (srcSrf.getSRFTemplateCode(),
                                       tgtSrf.getSRFTemplateCode());

                if (path != null)
                {
                    for (int i=0; i < path.size(); i++)
                    {
                        try
                        { // get the conversion object (if exists)
                            // set the ORM to the source ORM
                            // Add the conversion object to the operation chain
                            Conversions conv = (Conversions) FunctionMap.instance().
                                               get((SRM_SRFT_Code)path.elementAt(i));
                            if (i == 0)  // set the first conversion to indicate it is source
                                conv.setIsSource();
                            else if (i == path.size() - 1) // set the last conversion to indicate it is target
                                conv.setIsTarget();
                            conv.setOrmData(srcSrf.getOrm());
                            opList.add(conv);
                        }
                        catch (Exception e)
                        {
                            throw new SrmException(SrmException._INACTIONABLE,
                                                   new String("Conversion not supported"));
                        }
                        // place the operation sequence in the repository for future use.
                        tgtSrf._myOpSeq.put(new Integer(srcSrf.hashCode()), opList);
                    }
                }
                else // no conversion possible
                    throw new SrmException(SrmException._INACTIONABLE,
                                           new String("Conversion not supported"));
            }
            // both the SRF type and the ORM are the same
            else
            {
                // if other parameters are also identical then apply identical matrix
                if (srcSrf.isEqual(tgtSrf))
                {
                    try
                    {   // this should always work
                        // we need to add two of these because the Compute
                        // method expects one conversion object for every node
                        // in the path, in this case, 2 for the source and the
                        // target.  Although the second conversion object is
                        // never used.
                        opList.add(new IdentConv());
                        opList.add(new IdentConv());
                    }
                    catch (Exception e)
                    {
                        throw new SrmException(SrmException._INACTIONABLE,
                                               new String("Inactionable failure"));
                    }
                    // place the operation sequence in the repository for future use.
                    tgtSrf._myOpSeq.put(new Integer(srcSrf.hashCode()), opList);
                }

                // otherwise find path as usual and it shoudl go through the CDET for
                // most cases
                else
                {
                    Vector<SRM_SRFT_Code> path = null;

                    // this is to handle the special case with both src and tgt LTSC_3D
                    if (srcSrf instanceof SRF_LocalTangentSpaceCylindrical)
                    {
                        path = new Vector<SRM_SRFT_Code>();
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL);
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN);
                        path.add(SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN);
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_CYLINDRICAL);
                    }
                    // this is to handle the special case with both src and tgt LTSAS_3D
                    else if (srcSrf instanceof SRF_LocalTangentSpaceAzimuthalSpherical)
                    {
                        path = new Vector<SRM_SRFT_Code>();
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL);
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN);
                        path.add(SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_EUCLIDEAN);
                        path.add(SRM_SRFT_Code.SRFTCOD_LOCAL_TANGENT_SPC_AZIMUTHAL_SPHERICAL);
                    }
                    // use the general approach to find the path
                    else
                        path = Bfs.instance().GetConversionPath
                               (srcSrf.getSRFTemplateCode(),
                                tgtSrf.getSRFTemplateCode());

                    if (path != null)
                    {
                        for (int i=0; i < path.size(); i++)
                        {
                            try
                            {   // get the conversion object (if exists)
                                // set the ORM to the source ORM
                                // Add the conversion object to the operation chain
                                Conversions conv = (Conversions) FunctionMap.instance().
                                    get((SRM_SRFT_Code)path.elementAt(i));
                                if (i == 0)  // set the first conversion to indicate it is source
                                    conv.setIsSource();
                                else if (i == path.size() - 1) // set the last conversion to indicate it is target
                                    conv.setIsTarget();
                                conv.setOrmData(srcSrf.getOrm());
                                opList.add(conv);
                            }
                            catch (Exception e)
                            {
                                throw  new SrmException(SrmException._INACTIONABLE,
                                                        new String("Inactionable failure"));
                            }
                        }
                        // place the operation sequence in the repository for future use.
                        tgtSrf._myOpSeq.put(new Integer(srcSrf.hashCode()), opList);
                    }
                    else // no conversion possible
                        throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                               new String("No conversion possible"));
                }
            }
        }

        // find the path from source to CCEN and then from CCEN to target when
        // the ORMs and RTs are different
        else
        {
            // find path from source to CCEN for datum shitf
            Vector<SRM_SRFT_Code> path1 = Bfs.instance().GetConversionPath
                                          (srcSrf.getSRFTemplateCode(),
                                           SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC);
            if (path1 == null)
            {
                throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                       new String("No conversion possible"));
            }

            // find path from CCEN to target
            Vector<SRM_SRFT_Code> path2 = Bfs.instance().GetConversionPath
                                          (SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC,
                                           tgtSrf.getSRFTemplateCode());
            if (path2 == null)
            {
                throw new SrmException(SrmException._OPERATION_UNSUPPORTED,
                                       new String("No conversion possible"));
            }

            // skip if the source is already Celestiocentric
            if (srcSrf.getSRFTemplateCode() != SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC)
            {
                // compose the operation seq. from source to CCEN using ORM from source
                for (int i=0; i < path1.size(); i++)
                {
                    try
                    {
                        // get the conversion object (if exists)
                        // set the ORM to the source ORM
                        // Add the conversion object to the operation chain
                        Conversions conv = (Conversions) FunctionMap.instance().
                            get((SRM_SRFT_Code)path1.elementAt(i));
                        conv.setOrmData(srcSrf.getOrm());
                    if (i == 0)  // set the first conversion to indicate it is source
                            conv.setIsSource();
                        opList.add(conv);
                    }
                    catch (Exception e)
                    {
                        throw new SrmException(SrmException._INACTIONABLE,
                                               new String("Inactionable failure"));
                    }
                }
            }

            // insert the datum shift conversion object in here
            opList.add((Conversions) new DShiftConv());

            // skip if the target is already Celestiocentric
            if (tgtSrf.getSRFTemplateCode() != SRM_SRFT_Code.SRFTCOD_CELESTIOCENTRIC)
            {
                // compose the operation seq. from CCEN to target using ORM from target
                for (int i=0; i < path2.size(); i++)
                {
                    try
                    {
                        // get the conversion object (if exists)
                        // set the ORM to the target ORM
                        // Add the conversion object to the operation chain
                        Conversions conv = (Conversions) FunctionMap.instance().
                            get((SRM_SRFT_Code)path2.elementAt(i));
                        if (i == path2.size() - 1) // set the last conversion to indicate it is target
                            conv.setIsTarget();
                        conv.setOrmData(tgtSrf.getOrm());
                        opList.add(conv);
                    }
                    catch (Exception e)
                    {
                        throw new SrmException(SrmException._INACTIONABLE,
                                               new String("Inactionable failure"));
                    }
                }
            }
            // place the operation sequence in the repository for future use.
            tgtSrf._myOpSeq.put(new Integer(srcSrf.hashCode()), opList);
        }
        return opList;
    }

    protected SRM_Coordinate_Valid_Region_Code
        computeAsArray(BaseSRF              srcSrf,
                       BaseSRF              tgtSrf,
                       double[]             src,
                       double[]             dest,
                       SRM_ORM_Trans_Params hst) throws SrmException
    {
        SRM_Coordinate_Valid_Region_Code retValid =
            SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        SRM_Coordinate_Valid_Region_Code thisValid =
            SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID;
        Vector<Conversions> opList = null;
        SRM_SRFT_Code nextSrf;

        // reject the conversion if one RT is UNSPECIFIED and the other is not.
        if ((srcSrf.getOrm() != tgtSrf.getOrm()) && hst == null &&
            (srcSrf.getRt() == SRM_RT_Code.RTCOD_UNSPECIFIED ||
             tgtSrf.getRt() == SRM_RT_Code.RTCOD_UNSPECIFIED))
            throw new SrmException(SrmException._INVALID_SOURCE_SRF,
                                   new String("changeCoordinateXX: SRFs with different ORMs and RT unspecified " +
                                               "require tranformation object"));

        // instantiate an Operation sequence repository for the target SRF if
        // not already created.  We use the target SRF because that is the one that
        // computes the changeCoordinateSRF
        if (tgtSrf._myOpSeq == null)
            tgtSrf._myOpSeq = new CacheManager();

        opList = (Vector<Conversions>)tgtSrf._myOpSeq.get(new Integer(srcSrf.hashCode()));

        if (opList == null)
            opList = buildOpSeq(srcSrf, hst, tgtSrf);

        // if the src and tgt ORM and RT are the same, then no need to
        // perform the last datum shift, which is the latest conversion of the
        // sequence (this is mainly for efficiency)
        // The datum shift must be applied is the hst is supplied (not null)
        int srf_iterations;
        if (srcSrf.getRt() == tgtSrf.getRt() &&  // $$$ Need to verify if cover all cases.
            hst == null)
            srf_iterations = opList.size() - 1;
        else
            srf_iterations = opList.size();

        // perform computation
        // go through n-1 operations where n are number of SRFs in the conversion seq.
        for (int i=0; i<srf_iterations; i++)
        {
            if (i < opList.size() - 1)
                nextSrf = ((Conversions) (opList.elementAt(i+1))).getSrc();
            else // the last SRF is the target SRFs.  NO conversion for the last one
                  // except for datum shift.
                nextSrf = SRM_SRFT_Code.SRFTCOD_UNSPECIFIED;

            thisValid = ((Conversions) (opList.elementAt(i))).
                convert(nextSrf, srcSrf, tgtSrf, src, dest, hst);

            // copy destination coord to source coord
            System.arraycopy(dest, 0, src, 0, src.length);

            // this checks that all the validations along the way are
            // consistent, meaning that the valid regions should, at most,
            // go from valid (1) to extended valid (2) and to defined
            // (3) and never the way around. It can only happen at the last
            // conversion, which is a simple copy and therefore would always
            // return Valid, which should be ignored
            if (i != opList.size() - 1)
            {
                if ((retValid == SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID  &&
                     thisValid != SRM_Coordinate_Valid_Region_Code.COORDVALRGN_VALID) ||
                    (retValid == SRM_Coordinate_Valid_Region_Code.COORDVALRGN_DEFINED  &&
                     thisValid == SRM_Coordinate_Valid_Region_Code.COORDVALRGN_EXTENDED_VALID))
                    retValid = thisValid;
            }
        }
        return retValid;
    }
}
