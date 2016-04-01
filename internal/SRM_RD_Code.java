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

/**
@author David Shen, Michele L. Worley
@brief Declaration of RD enumeration class.
*/
public enum SRM_RD_Code
{
    RDCOD_UNSPECIFIED (0), /// Unspecified
    RDCOD_ORIGIN_2D (1),   /// Origin in 2D
    RDCOD_X_UNIT_POINT_2D (2), /// x-axis unit point in 2D
    RDCOD_Y_UNIT_POINT_2D (3), /// y-axis unit point in 2D
    RDCOD_ORIGIN_3D (4), /// Origin in 3D
    RDCOD_X_UNIT_POINT_3D (5), /// x-axis unit point in 3D
    RDCOD_Y_UNIT_POINT_3D (6), /// y-axis unit point in 3D
    RDCOD_Z_UNIT_POINT_3D (7), /// z-axis unit point in 3D
    RDCOD_X_AXIS_2D (8), /// x-axis in 2D
    RDCOD_Y_AXIS_2D (9), /// y-axis in 2D
    RDCOD_X_AXIS_3D (10), /// x-axis in 3D
    RDCOD_Y_AXIS_3D (11), /// y-axis in 3D
    RDCOD_Z_AXIS_3D (12), /// z-axis in 3D
    RDCOD_XY_PLANE_3D (13), /// xy-plane
    RDCOD_XZ_PLANE_3D (14), /// xz-plane
    RDCOD_YZ_PLANE_3D (15), /// yz-plane
    RDCOD_ADRASTEA_2000 (16), /// Adrastea (satellite of Jupiter)
    RDCOD_AIRY_1830 (17), /// Airy
    RDCOD_AMALTHEA_2000 (18), /// Amalthea (satellite of Jupiter)
    RDCOD_ANANKE_1988 (19), /// Ananke (satellite of Jupiter)
    RDCOD_APL_4r5_1968 (20), /// APL 4.5
    RDCOD_ARIEL_1988 (21), /// Ariel (satellite of Uranus)
    RDCOD_ATLAS_1988 (22), /// Atlas (satellite of Saturn)
    RDCOD_AUSTRALIAN_NATIONAL_1966 (23), /// Australian national
    RDCOD_AVERAGE_TERRESTRIAL_1977 (24), /// Average terrestrial system
    RDCOD_BELINDA_1988 (25), /// Belinda (satellite of Uranus)
    RDCOD_BESSEL_1841_ETHIOPIA (26), /// Bessel (Ethiopia, Indonesia, Japan, and Korea)
    RDCOD_BESSEL_1841_NAMIBIA (27), /// Bessel (Namibia)
    RDCOD_BIANCA_1988 (28), /// Bianca (satellite of Uranus)
    RDCOD_CALLISTO_2000 (29), /// Callisto (satellite of Jupiter)
    RDCOD_CALYPSO_1988 (30), /// Calypso (satellite of Saturn)
    RDCOD_CARME_1988 (31), /// Carme (satellite of Jupiter)
    RDCOD_CHARON_1991 (32), /// Charon (satellite of Pluto)
    RDCOD_CLARKE_1858 (33), /// Clarke
    RDCOD_CLARKE_1858_MODIFIED (34), /// Clarke - modified
    RDCOD_CLARKE_1866 (35), /// Clarke
    RDCOD_CLARKE_1880 (36), /// Clarke
    RDCOD_CLARKE_1880_CAPE (37), /// Clarke - Cape
    RDCOD_CLARKE_1880_FIJI (38), /// Clarke - Fiji
    RDCOD_CLARKE_1880_IGN (39), /// Clarke - IGN
    RDCOD_CLARKE_1880_PALESTINE (40), /// Clarke - Palestine
    RDCOD_CLARKE_1880_SYRIA (41), /// Clarke - Syria
    RDCOD_COAMPS_1998 (42), /// Coupled Ocean/Atmospheric Mesoscale Prediction System (COAMPSTM)
    RDCOD_CORDELIA_1988 (43), /// Cordelia (satellite of Uranus)
    RDCOD_CRESSIDA_1988 (44), /// Cressida (satellite of Uranus)
    RDCOD_DANISH_1876 (45), /// Danish - Andrae
    RDCOD_DEIMOS_1988 (46), /// Deimos (satellite of Mars)
    RDCOD_DELAMBRE_1810 (47), /// Delambre
    RDCOD_DESDEMONA_1988 (48), /// Desdemona (satellite of Uranus)
    RDCOD_DESPINA_1991 (49), /// Despina (satellite of Neptune)
    RDCOD_DIONE_1982 (50), /// Dione (satellite of Saturn)
    RDCOD_ELARA_1988 (51), /// Elara (satellite of Jupiter)
    RDCOD_ENCELADUS_1994 (52), /// Enceladus (satellite of Saturn)
    RDCOD_EPIMETHEUS_1988 (53), /// Epimetheus (satellite of Saturn)
    RDCOD_EROS_2000 (54), /// Eros (asteroid 433, a minor planet)
    RDCOD_EUROPA_2000 (55), /// Europa (satellite of Jupiter)
    RDCOD_EVEREST_ADJ_1937 (56), /// Everest 1830 - adjusted
    RDCOD_EVEREST_1948 (57), /// Everest
    RDCOD_EVEREST_1956 (58), /// Everest
    RDCOD_EVEREST_REVISED_1962 (59), /// Everest 1830 - revised definition
    RDCOD_EVEREST_1969 (60), /// Everest
    RDCOD_EVEREST_BRUNEI_1967 (61), /// Everest 1830 - 1967 definition (Brunei and East Malaysia - Sabah and Sarawak)
    RDCOD_FISCHER_1960 (62), /// Fischer - Mercury
    RDCOD_FISCHER_1968 (63), /// Fischer
    RDCOD_GALATEA_1991 (64), /// Galatea (satellite of Neptune)
    RDCOD_GANYMEDE_2000 (65), /// Ganymede (satellite of Jupiter)
    RDCOD_GASPRA_1991 (66), /// Gaspra (asteroid 951, a minor planet)
    RDCOD_GRS_1967 (67), /// Geodetic Reference System (GRS)
    RDCOD_GRS_1980 (68), /// Geodetic Reference System (GRS)
    RDCOD_HELENE_1992 (69), /// Helene (satellite of Saturn)
    RDCOD_HELMERT_1906 (70), /// Helmert
    RDCOD_HIMALIA_1988 (71), /// Himalia (satellite of Jupiter)
    RDCOD_HOUGH_1960 (72), /// Hough
    RDCOD_HYPERION_2000 (73), /// Hyperion (satellite of Saturn)
    RDCOD_IAG_1975 (74), /// International Association of Geodesy (IAG) best estimate
    RDCOD_IAPETUS_1988 (75), /// Iapetus (satellite of Saturn)
    RDCOD_IDA_1991 (76), /// Ida (asteroid 293, a minor planet)
    RDCOD_INDONESIAN_1974 (77), /// Indonesian
    RDCOD_INTERNATIONAL_1924 (78), /// International
    RDCOD_IO_2000 (79), /// Io (satellite of Jupiter)
    RDCOD_JANUS_1988 (80), /// Janus (satellite of Saturn)
    RDCOD_JULIET_1988 (81), /// Juliet (satellite of Uranus)
    RDCOD_JUPITER_1988 (82), /// Jupiter
    RDCOD_KLEOPATRA_2000 (83), /// Kleopatra (asteroid 216, a minor planet)
    RDCOD_KRASSOVSKY_1940 (84), /// Krassovsky
    RDCOD_KRAYENHOFF_1827 (85), /// Krayenhoff
    RDCOD_LARISSA_1991 (86), /// Larissa (satellite of Neptune)
    RDCOD_LEDA_1988 (87), /// Leda (satellite of Jupiter)
    RDCOD_LYSITHEA_1988 (88), /// Lysithea (satellite of Jupiter)
    RDCOD_MARS_2000 (89), /// Mars
    RDCOD_MARS_SPHERE_2000 (90), /// Mars
    RDCOD_MASS_1999 (91), /// MASS
    RDCOD_MERCURY_1988 (92), /// Mercury
    RDCOD_METIS_2000 (93), /// Metis (satellite of Jupiter)
    RDCOD_MIMAS_1994 (94), /// Mimas (satellite of Saturn)
    RDCOD_MIRANDA_1988 (95), /// Miranda (satellite of Uranus)
    RDCOD_MM5_1997 (96), /// Mesoscale (weather) Model 5 (MM5), Air Force Weather Agency (AFWA), US
    RDCOD_MODIFIED_AIRY_1849 (97), /// Modified Airy
    RDCOD_MODIFIED_FISCHER_1960 (98), /// Modified Fischer
    RDCOD_MODTRAN_MIDLATITUDE_1989 (99), /// MODTRAN (midlatitude regions)
    RDCOD_MODTRAN_SUBARCTIC_1989 (100), /// MODTRAN (subarctic regions)
    RDCOD_MODTRAN_TROPICAL_1989 (101), /// MODTRAN (tropical regions)
    RDCOD_MOON_1991 (102), /// Moon (satellite of Earth)
    RDCOD_MULTIGEN_FLAT_EARTH_1989 (103), /// Multigen flat Earth
    RDCOD_NAIAD_1991 (104), /// Naiad (satellite of Neptune)
    RDCOD_NEPTUNE_1991 (105), /// Neptune
    RDCOD_NEREID_1991 (106), /// Nereid (satellite of Neptune)
    RDCOD_NOGAPS_1988 (107), /// Navy Operational Global Atmospheric Prediction System (NOGAPS), US
    RDCOD_OBERON_1988 (108), /// Oberon (satellite of Uranus)
    RDCOD_OPHELIA_1988 (109), /// Ophelia (satellite of Uranus)
    RDCOD_PAN_1991 (110), /// Pan (satellite of Saturn)
    RDCOD_PANDORA_1988 (111), /// Pandora (satellite of Saturn)
    RDCOD_PASIPHAE_1988 (112), /// Pasiphae (satellite of Jupiter)
    RDCOD_PHOBOS_1988 (113), /// Phobos (satellite of Mars)
    RDCOD_PHOEBE_1988 (114), /// Phoebe (satellite of Saturn)
    RDCOD_PLESSIS_MODIFIED_1817 (115), /// Plessis - Modified
    RDCOD_PLUTO_1994 (116), /// Pluto
    RDCOD_PORTIA_1988 (117), /// Portia (satellite of Uranus)
    RDCOD_PROMETHEUS_1988 (118), /// Prometheus (satellite of Saturn)
    RDCOD_PROTEUS_1991 (119), /// Proteus (satellite of Neptune)
    RDCOD_PUCK_1988 (120), /// Puck (satellite of Uranus)
    RDCOD_RHEA_1988 (121), /// Rhea (satellite of Saturn)
    RDCOD_ROSALIND_1988 (122), /// Rosalind (satellite of Uranus)
    RDCOD_SATURN_1988 (123), /// Saturn
    RDCOD_SINOPE_1988 (124), /// Sinope (satellite of Jupiter)
    RDCOD_SOUTH_AMERICAN_1969 (125), /// South american
    RDCOD_SOVIET_GEODETIC_1985 (126), /// Soviet geodetic system
    RDCOD_SOVIET_GEODETIC_1990 (127), /// Soviet geodetic system
    RDCOD_STRUVE_1860 (128), /// Struve
    RDCOD_SUN_1992 (129), /// Sun
    RDCOD_TELESTO_1988 (130), /// Telesto (satellite of Saturn)
    RDCOD_TETHYS_1991 (131), /// Tethys (satellite of Saturn)
    RDCOD_THALASSA_1991 (132), /// Thalassa (satellite of Neptune)
    RDCOD_THEBE_2000 (133), /// Thebe (satellite of Jupiter)
    RDCOD_TITAN_1982 (134), /// Titan (satellite of Saturn)
    RDCOD_TITANIA_1988 (135), /// Titania (satellite of Uranus)
    RDCOD_TRITON_1991 (136), /// Triton (satellite of Neptune)
    RDCOD_UMBRIEL_1988 (137), /// Umbriel (satellite of Uranus)
    RDCOD_URANUS_1988 (138), /// Uranus
    RDCOD_VENUS_1991 (139), /// Venus
    RDCOD_WALBECK_AMS_1963 (140), /// Walbeck 1819 - AMS
    RDCOD_WALBECK_PLANHEFT_1942 (141), /// Walbeck 1819 - Planheft
    RDCOD_WAR_OFFICE_1924 (142), /// War Office - McCaw
    RDCOD_WGS_1960 (143), /// World Geodetic System 1960
    RDCOD_WGS_1966 (144), /// World Geodetic System 1966
    RDCOD_WGS_1984 (145), /// World geodetic system
    RDCOD_WGS_1972 (146), /// World geodetic system
    RDCOD_EXPERIMENTAL_NGA_SRM_MAX(-1000),
    RDCOD_EXPERIMENTAL_NGA_SPHERE(-1001);

    public static final int _totalEnum = 146;

    private int    _enumInt;

    private static Vector<SRM_RD_Code> _enumVec = new Vector<SRM_RD_Code>( );

    static
    {
        for (SRM_RD_Code x : SRM_RD_Code.values())
        {
            if (x._enumInt == -1000)
                 _enumVec.add( _totalEnum+1, x);
            else if (x._enumInt == -1001)
                 _enumVec.add( _totalEnum+2, x);
            else
                _enumVec.add(x._enumInt, x);
        }
    }

    private SRM_RD_Code(int enumInt)
    {
        _enumInt = enumInt;
    }

    /** returns the integer code value for the enumerant
     */
    public int toInt()
    {
        return _enumInt;
    }

    /** @return the SRM_RD_Code object from its enumerant value
     */
    public static SRM_RD_Code getEnum(int item) throws SrmException
    {
        if (item >= 0 && item <= _totalEnum)
            return _enumVec.elementAt( item );
        else if (item == -1000)
            return _enumVec.elementAt( _totalEnum+1 );
        else if (item == -1001)
            return _enumVec.elementAt( _totalEnum+2 );
        else
            throw new SrmException( SrmException._INVALID_INPUT,
                                    new String("SRM_RD_Code.getEnum: enumerant out of range") );
    }
}
