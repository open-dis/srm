/**
@author David Shen
@brief SRM ORM code enumeration according to the SRM spec.
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

public class SRM_ORM_Code extends SrmEnum
{
    /// Unspecified
    public static final int _ORMCOD_UNSPECIFIED = 0;
    /// 2D modelling space
    public static final int _ORMCOD_ABSTRACT_2D = 1;
    /// 3D modelling space
    public static final int _ORMCOD_ABSTRACT_3D = 2;
    /// Adindan
    public static final int _ORMCOD_ADINDAN_1991 = 3;
    /// Adrastea
    public static final int _ORMCOD_ADRASTEA_2000 = 4;
    /// Afgooye (Somalia)
    public static final int _ORMCOD_AFGOOYE_1987 = 5;
    /// Ain el Abd
    public static final int _ORMCOD_AIN_EL_ABD_1970 = 6;
    /// Amalthea
    public static final int _ORMCOD_AMALTHEA_2000 = 7;
    /// American Samoa
    public static final int _ORMCOD_AMERICAN_SAMOA_1962 = 8;
    /// Anna 1 (astronomic)
    public static final int _ORMCOD_ANNA_1_1965 = 9;
    /// Antigua (astronomic)
    public static final int _ORMCOD_ANTIGUA_1943 = 10;
    /// Arc
    public static final int _ORMCOD_ARC_1950 = 11;
    /// Arc
    public static final int _ORMCOD_ARC_1960 = 12;
    /// Ariel
    public static final int _ORMCOD_ARIEL_1988 = 13;
    /// Ascension
    public static final int _ORMCOD_ASCENSION_1958 = 14;
    /// Atlas
    public static final int _ORMCOD_ATLAS_1988 = 15;
    /// Australian Geodetic
    public static final int _ORMCOD_AUSTRALIAN_GEOD_1966 = 16;
    /// Australian Geodetic
    public static final int _ORMCOD_AUSTRALIAN_GEOD_1984 = 17;
    /// Ayabelle Lighthouse (Djibouti)
    public static final int _ORMCOD_AYABELLE_LIGHTHOUSE_1991 = 18;
    /// Beacon E (Iwo-jima; astronomic)
    public static final int _ORMCOD_BEACON_E_1945 = 19;
    /// Belinda
    public static final int _ORMCOD_BELINDA_1988 = 20;
    /// Bellevue (IGN)
    public static final int _ORMCOD_BELLEVUE_IGN_1987 = 21;
    /// Bermuda
    public static final int _ORMCOD_BERMUDA_1957 = 22;
    /// Bianca
    public static final int _ORMCOD_BIANCA_1988 = 23;
    /// Bissau
    public static final int _ORMCOD_BISSAU_1991 = 24;
    /// Bogota Observatory
    public static final int _ORMCOD_BOGOTA_OBS_1987 = 25;
    /// Bogota Observatory (with the Prime Meridian at Bogota)
    public static final int _ORMCOD_BOGOTA_OBS_1987_PM_BOGOTA = 26;
    /// Bukit Rimpah
    public static final int _ORMCOD_BUKIT_RIMPAH_1987 = 27;
    /// Callisto
    public static final int _ORMCOD_CALLISTO_2000 = 28;
    /// Calypso
    public static final int _ORMCOD_CALYPSO_1988 = 29;
    /// Camp Area (astronomic)
    public static final int _ORMCOD_CAMP_AREA_1987 = 30;
    /// Campo Inchauspe
    public static final int _ORMCOD_CAMPO_INCHAUSPE_1969 = 31;
    /// Canton (astronomic)
    public static final int _ORMCOD_CANTON_1966 = 32;
    /// Cape
    public static final int _ORMCOD_CAPE_1987 = 33;
    /// Cape Canaveral
    public static final int _ORMCOD_CAPE_CANAVERAL_1991 = 34;
    /// Carthage
    public static final int _ORMCOD_CARTHAGE_1987 = 35;
    /// Charon
    public static final int _ORMCOD_CHARON_1991 = 36;
    /// Chatam (astronomic)
    public static final int _ORMCOD_CHATHAM_1971 = 37;
    /// Chua (astronomic)
    public static final int _ORMCOD_CHUA_1987 = 38;
    /// COAMPS^(TM)
    public static final int _ORMCOD_COAMPS_1998 = 39;
    /// Cordelia
    public static final int _ORMCOD_CORDELIA_1988 = 40;
    /// Corrego Alegre
    public static final int _ORMCOD_CORREGO_ALEGRE_1987 = 41;
    /// Cressida
    public static final int _ORMCOD_CRESSIDA_1988 = 42;
    /// Dabola
    public static final int _ORMCOD_DABOLA_1991 = 43;
    /// Deception
    public static final int _ORMCOD_DECEPTION_1993 = 44;
    /// Deimos
    public static final int _ORMCOD_DEIMOS_1988 = 45;
    /// Desdemona
    public static final int _ORMCOD_DESDEMONA_1988 = 46;
    /// Despina
    public static final int _ORMCOD_DESPINA_1991 = 47;
    /// Dione
    public static final int _ORMCOD_DIONE_1982 = 48;
    /// Djakarta (also known as Batavia)
    public static final int _ORMCOD_DJAKARTA_1987 = 49;
    /// Djakarta (also known as Batavia; with the Prime Meridian at Djakarta)
    public static final int _ORMCOD_DJAKARTA_1987_PM_DJAKARTA = 50;
    /// DOS
    public static final int _ORMCOD_DOS_1968 = 51;
    /// DOS 71/4 (St. Helena Island; astronomic)
    public static final int _ORMCOD_DOS_71_4_1987 = 52;
    /// Earth equatorial inertial, Aries mean of 1950
    public static final int _ORMCOD_EARTH_INERT_ARIES_1950 = 53;
    /// Earth equatorial inertial, Aries true of date
    public static final int _ORMCOD_EARTH_INERT_ARIES_TRUE_OF_DATE = 54;
    /// Earth equatorial inertial, J2000.0
    public static final int _ORMCOD_EARTH_INERTIAL_J2000r0 = 55;
    /// Solar ecliptic
    public static final int _ORMCOD_EARTH_SOLAR_ECLIPTIC = 56;
    /// Solar equatorial
    public static final int _ORMCOD_EARTH_SOLAR_EQUATORIAL = 57;
    /// Solar magnetic dipole
    public static final int _ORMCOD_EARTH_SOLAR_MAG_DIPOLE = 58;
    /// Solar magnetospheric
    public static final int _ORMCOD_EARTH_SOLAR_MAGNETOSPHERIC = 59;
    /// Easter
    public static final int _ORMCOD_EASTER_1967 = 60;
    /// Enceladus
    public static final int _ORMCOD_ENCELADUS_1994 = 61;
    /// Epimetheus
    public static final int _ORMCOD_EPIMETHEUS_1988 = 62;
    /// Eros (asteroid 433)
    public static final int _ORMCOD_EROS_2000 = 63;
    /// Estonia
    public static final int _ORMCOD_ESTONIA_1937 = 64;
    /// ETRS
    public static final int _ORMCOD_ETRS_1989 = 65;
    /// Europa
    public static final int _ORMCOD_EUROPA_2000 = 66;
    /// European
    public static final int _ORMCOD_EUROPE_1950 = 67;
    /// European
    public static final int _ORMCOD_EUROPE_1979 = 68;
    /// Fahud
    public static final int _ORMCOD_FAHUD_1987 = 69;
    /// Fort Thomas
    public static final int _ORMCOD_FORT_THOMAS_1955 = 70;
    /// Galatea
    public static final int _ORMCOD_GALATEA_1991 = 71;
    /// Gan
    public static final int _ORMCOD_GAN_1970 = 72;
    /// Ganymede
    public static final int _ORMCOD_GANYMEDE_2000 = 73;
    /// Gaspra (asteroid 951)
    public static final int _ORMCOD_GASPRA_1991 = 74;
    /// GDA
    public static final int _ORMCOD_GDA_1994 = 75;
    /// Geodetic Datum
    public static final int _ORMCOD_GEODETIC_DATUM_1949 = 76;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1945 = 77;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1950 = 78;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1955 = 79;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1960 = 80;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1965 = 81;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1970 = 82;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1975 = 83;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1980 = 84;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1985 = 85;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1990 = 86;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_1995 = 87;
    /// Geomagnetic
    public static final int _ORMCOD_GEOMAGNETIC_2000 = 88;
    /// Graciosa Base SW
    public static final int _ORMCOD_GRACIOSA_BASE_SW_1948 = 89;
    /// Guam
    public static final int _ORMCOD_GUAM_1963 = 90;
    /// Gunung Segara
    public static final int _ORMCOD_GUNONG_SEGARA_1987 = 91;
    /// GUX1 (astronomic)
    public static final int _ORMCOD_GUX_1_1987 = 92;
    /// Helene
    public static final int _ORMCOD_HELENE_1992 = 93;
    /// Heliocentric Aries ecliptic, J2000.0
    public static final int _ORMCOD_HELIO_ARIES_ECLIPT_J2000r0 = 94;
    /// Heliocentric Aries ecliptic, true of date
    public static final int _ORMCOD_HELIO_ARIES_ECLIPT_TRUE_OF_DATE = 95;
    /// Heliocentric Earth ecliptic
    public static final int _ORMCOD_HELIO_EARTH_ECLIPTIC = 96;
    /// Heliocentric Earth equatorial
    public static final int _ORMCOD_HELIO_EARTH_EQUATORIAL = 97;
    /// Herat North
    public static final int _ORMCOD_HERAT_NORTH_1987 = 98;
    /// Hermannskogel
    public static final int _ORMCOD_HERMANNSKOGEL_1871 = 99;
    /// Hjorsey
    public static final int _ORMCOD_HJORSEY_1955 = 100;
    /// Hong Kong
    public static final int _ORMCOD_HONG_KONG_1963 = 101;
    /// Hu-Tzu-Shan
    public static final int _ORMCOD_HU_TZU_SHAN_1991 = 102;
    /// Iapetus
    public static final int _ORMCOD_IAPETUS_1988 = 103;
    /// Ida (asteroid 243)
    public static final int _ORMCOD_IDA_1991 = 104;
    /// Indian
    public static final int _ORMCOD_INDIAN_1916 = 105;
    /// Indian
    public static final int _ORMCOD_INDIAN_1954 = 106;
    /// Indian
    public static final int _ORMCOD_INDIAN_1956 = 107;
    /// Indian
    public static final int _ORMCOD_INDIAN_1960 = 108;
    /// Indian
    public static final int _ORMCOD_INDIAN_1962 = 109;
    /// Indian
    public static final int _ORMCOD_INDIAN_1975 = 110;
    /// Indonesian
    public static final int _ORMCOD_INDONESIAN_1974 = 111;
    /// Io
    public static final int _ORMCOD_IO_2000 = 112;
    /// Ireland 1965
    public static final int _ORMCOD_IRELAND_1965 = 113;
    /// International Satellite Triangulation Station (ISTS) 061 (astronomic)
    public static final int _ORMCOD_ISTS_061_1968 = 114;
    /// International Satellite Triangulation Station (ISTS) 073 (astronomic)
    public static final int _ORMCOD_ISTS_073_1969 = 115;
    /// Janus
    public static final int _ORMCOD_JANUS_1988 = 116;
    /// Japanese Geodetic Datum 2000 (JGD2000)
    public static final int _ORMCOD_JGD_2000 = 117;
    /// Johnston
    public static final int _ORMCOD_JOHNSTON_1961 = 118;
    /// Juliet
    public static final int _ORMCOD_JULIET_1988 = 119;
    /// Jupiter
    public static final int _ORMCOD_JUPITER_1988 = 120;
    /// Jupiter equatorial inertial
    public static final int _ORMCOD_JUPITER_INERTIAL = 121;
    /// Jupiter magnetic
    public static final int _ORMCOD_JUPITER_MAGNETIC_1993 = 122;
    /// Jupiter solar ecliptic
    public static final int _ORMCOD_JUPITER_SOLAR_ECLIPTIC = 123;
    /// Jupiter solar equatorial
    public static final int _ORMCOD_JUPITER_SOLAR_EQUATORIAL = 124;
    /// Jupiter solar magnetic dipole
    public static final int _ORMCOD_JUPITER_SOLAR_MAG_DIPOLE = 125;
    /// Jupiter solar magnetic ecliptic
    public static final int _ORMCOD_JUPITER_SOLAR_MAG_ECLIPTIC = 126;
    /// Kandawala
    public static final int _ORMCOD_KANDAWALA_1987 = 127;
    /// Kerguelen
    public static final int _ORMCOD_KERGUELEN_1949 = 128;
    /// Kertau
    public static final int _ORMCOD_KERTAU_1948 = 129;
    /// Korean Geodetic System
    public static final int _ORMCOD_KOREAN_GEODETIC_1995 = 130;
    /// Kusaie 1951 (astronomic)
    public static final int _ORMCOD_KUSAIE_1951 = 131;
    /// Larissa
    public static final int _ORMCOD_LARISSA_1991 = 132;
    /// LC5 (astronomic)
    public static final int _ORMCOD_LC5_1961 = 133;
    /// Leigon
    public static final int _ORMCOD_LEIGON_1991 = 134;
    /// Liberia
    public static final int _ORMCOD_LIBERIA_1964 = 135;
    /// Luzon
    public static final int _ORMCOD_LUZON_1987 = 136;
    /// M'Poraloko
    public static final int _ORMCOD_M_PORALOKO_1991 = 137;
    /// Mahe
    public static final int _ORMCOD_MAHE_1971 = 138;
    /// Marcus Station (astronomic)
    public static final int _ORMCOD_MARCUS_STATION_1952 = 139;
    /// Mars
    public static final int _ORMCOD_MARS_2000 = 140;
    /// Mars equatorial inertial
    public static final int _ORMCOD_MARS_INERTIAL = 141;
    /// Mars (spherical)
    public static final int _ORMCOD_MARS_SPHERE_2000 = 142;
    /// MASS
    public static final int _ORMCOD_MASS_1999 = 143;
    /// Massawa
    public static final int _ORMCOD_MASSAWA_1987 = 144;
    /// Merchich
    public static final int _ORMCOD_MERCHICH_1987 = 145;
    /// Mercury
    public static final int _ORMCOD_MERCURY_1988 = 146;
    /// Mercury equatorial inertial
    public static final int _ORMCOD_MERCURY_INERTIAL = 147;
    /// Metis
    public static final int _ORMCOD_METIS_2000 = 148;
    /// Midway 1961 (astronomic)
    public static final int _ORMCOD_MIDWAY_1961 = 149;
    /// Mimas
    public static final int _ORMCOD_MIMAS_1994 = 150;
    /// Minna
    public static final int _ORMCOD_MINNA_1991 = 151;
    /// Miranda
    public static final int _ORMCOD_MIRANDA_1988 = 152;
    /// MM5 (AFWA)
    public static final int _ORMCOD_MM5_1997 = 153;
    /// MODTRAN
    public static final int _ORMCOD_MODTRAN_MIDLAT_N_1989 = 154;
    /// MODTRAN
    public static final int _ORMCOD_MODTRAN_MIDLAT_S_1989 = 155;
    /// MODTRAN
    public static final int _ORMCOD_MODTRAN_SUBARCTIC_N_1989 = 156;
    /// MODTRAN
    public static final int _ORMCOD_MODTRAN_SUBARCTIC_S_1989 = 157;
    /// MODTRAN
    public static final int _ORMCOD_MODTRAN_TROPICAL_1989 = 158;
    /// Montserrat (astronomic)
    public static final int _ORMCOD_MONTSERRAT_1958 = 159;
    /// Moon
    public static final int _ORMCOD_MOON_1991 = 160;
    /// Multigen flat Earth
    public static final int _ORMCOD_MULTIGEN_FLAT_EARTH_1989 = 161;
    /// North American
    public static final int _ORMCOD_N_AM_1927 = 162;
    /// North American
    public static final int _ORMCOD_N_AM_1983 = 163;
    /// North Sahara
    public static final int _ORMCOD_N_SAHARA_1959 = 164;
    /// Nahrwan
    public static final int _ORMCOD_NAHRWAN_1987 = 165;
    /// Naiad
    public static final int _ORMCOD_NAIAD_1991 = 166;
    /// Naparima BWI
    public static final int _ORMCOD_NAPARIMA_1991 = 167;
    /// Neptune
    public static final int _ORMCOD_NEPTUNE_1991 = 168;
    /// Neptune equatorial inertial
    public static final int _ORMCOD_NEPTUNE_INERTIAL = 169;
    /// Neptune magnetic
    public static final int _ORMCOD_NEPTUNE_MAGNETIC_1993 = 170;
    /// NOGAPS
    public static final int _ORMCOD_NOGAPS_1988 = 171;
    /// NTF
    public static final int _ORMCOD_NTF_1896 = 172;
    /// NTF (with the Prime Meridian at Paris)
    public static final int _ORMCOD_NTF_1896_PM_PARIS = 173;
    /// Oberon
    public static final int _ORMCOD_OBERON_1988 = 174;
    /// Observatorio Meteorologico
    public static final int _ORMCOD_OBSERV_METEORO_1939 = 175;
    /// Old Egyptian
    public static final int _ORMCOD_OLD_EGYPTIAN_1907 = 176;
    /// Old Hawaiian (Clarke)
    public static final int _ORMCOD_OLD_HAWAIIAN_CLARKE_1987 = 177;
    /// Old Hawaiian (International)
    public static final int _ORMCOD_OLD_HAWAIIAN_INT_1987 = 178;
    /// Ophelia
    public static final int _ORMCOD_OPHELIA_1988 = 179;
    /// Ordnance Survey of Great Britain
    public static final int _ORMCOD_OSGB_1936 = 180;
    /// Pan
    public static final int _ORMCOD_PAN_1991 = 181;
    /// Pandora
    public static final int _ORMCOD_PANDORA_1988 = 182;
    /// Phobos
    public static final int _ORMCOD_PHOBOS_1988 = 183;
    /// Phoebe
    public static final int _ORMCOD_PHOEBE_1988 = 184;
    /// Pico de las Nieves
    public static final int _ORMCOD_PICO_DE_LAS_NIEVES_1987 = 185;
    /// Pitcairn (astronomic)
    public static final int _ORMCOD_PITCAIRN_1967 = 186;
    /// Pluto
    public static final int _ORMCOD_PLUTO_1994 = 187;
    /// Pluto equatorial inertial
    public static final int _ORMCOD_PLUTO_INERTIAL = 188;
    /// Point 58
    public static final int _ORMCOD_POINT_58_1991 = 189;
    /// Pointe Noire
    public static final int _ORMCOD_POINTE_NOIRE_1948 = 190;
    /// Portia
    public static final int _ORMCOD_PORTIA_1988 = 191;
    /// Porto Santo
    public static final int _ORMCOD_PORTO_SANTO_1936 = 192;
    /// Prometheus
    public static final int _ORMCOD_PROMETHEUS_1988 = 193;
    /// Proteus
    public static final int _ORMCOD_PROTEUS_1991 = 194;
    /// Provisional South American
    public static final int _ORMCOD_PROV_S_AM_1956 = 195;
    /// Provisional South Chilean (Hito XVIII)
    public static final int _ORMCOD_PROV_S_CHILEAN_1963 = 196;
    /// Puck
    public static final int _ORMCOD_PUCK_1988 = 197;
    /// Puerto Rico
    public static final int _ORMCOD_PUERTO_RICO_1987 = 198;
    /// Pulkovo
    public static final int _ORMCOD_PULKOVO_1942 = 199;
    /// Qatar National
    public static final int _ORMCOD_QATAR_NATIONAL_1974 = 200;
    /// Qornoq
    public static final int _ORMCOD_QORNOQ_1987 = 201;
    /// Reunion
    public static final int _ORMCOD_REUNION_1947 = 202;
    /// Reseau Geodesique Francais
    public static final int _ORMCOD_RGF_1993 = 203;
    /// Rhea
    public static final int _ORMCOD_RHEA_1988 = 204;
    /// Rome (also known as Monte Mario)
    public static final int _ORMCOD_ROME_1940 = 205;
    /// Rome (also known as Monte Mario) (with the Prime Meridian at Rome)
    public static final int _ORMCOD_ROME_1940_PM_ROME = 206;
    /// Rosalind
    public static final int _ORMCOD_ROSALIND_1988 = 207;
    /// South American
    public static final int _ORMCOD_S_AM_1969 = 208;
    /// South Asia
    public static final int _ORMCOD_S_ASIA_1987 = 209;
    /// S-JTSK
    public static final int _ORMCOD_S_JTSK_1993 = 210;
    /// S-42 (Pulkovo)
    public static final int _ORMCOD_S42_PULKOVO = 211;
    /// Santo (DOS)
    public static final int _ORMCOD_SANTO_DOS_1965 = 212;
    /// Sao Braz
    public static final int _ORMCOD_SAO_BRAZ_1987 = 213;
    /// Sapper Hill
    public static final int _ORMCOD_SAPPER_HILL_1943 = 214;
    /// Saturn
    public static final int _ORMCOD_SATURN_1988 = 215;
    /// Saturn equatorial inertial
    public static final int _ORMCOD_SATURN_INERTIAL = 216;
    /// Saturn magnetic
    public static final int _ORMCOD_SATURN_MAGNETIC_1993 = 217;
    /// Schwarzeck
    public static final int _ORMCOD_SCHWARZECK_1991 = 218;
    /// Selvagem Grande
    public static final int _ORMCOD_SELVAGEM_GRANDE_1938 = 219;
    /// Sierra Leone
    public static final int _ORMCOD_SIERRA_LEONE_1960 = 220;
    /// SIRGAS
    public static final int _ORMCOD_SIRGAS_2000 = 221;
    /// Sun
    public static final int _ORMCOD_SUN_1992 = 222;
    /// Tananarive Observatory
    public static final int _ORMCOD_TANANARIVE_OBS_1925 = 223;
    /// Tananarive Observatory (with the Prime Meridian at Paris)
    public static final int _ORMCOD_TANANARIVE_OBS_1925_PM_PARIS = 224;
    /// Telesto
    public static final int _ORMCOD_TELESTO_1988 = 225;
    /// Tern (astronomic)
    public static final int _ORMCOD_TERN_1961 = 226;
    /// Tethys
    public static final int _ORMCOD_TETHYS_1991 = 227;
    /// Thalassa
    public static final int _ORMCOD_THALASSA_1991 = 228;
    /// Thebe
    public static final int _ORMCOD_THEBE_2000 = 229;
    /// Timbali (Everest)
    public static final int _ORMCOD_TIMBALAI_EVEREST_1948 = 230;
    /// Titan
    public static final int _ORMCOD_TITAN_1982 = 231;
    /// Titania
    public static final int _ORMCOD_TITANIA_1988 = 232;
    /// Tokyo
    public static final int _ORMCOD_TOKYO_1991 = 233;
    /// Tristan (astronomic)
    public static final int _ORMCOD_TRISTAN_1968 = 234;
    /// Triton
    public static final int _ORMCOD_TRITON_1991 = 235;
    /// Umbriel
    public static final int _ORMCOD_UMBRIEL_1988 = 236;
    /// Uranus
    public static final int _ORMCOD_URANUS_1988 = 237;
    /// Uranus equatorial inertial
    public static final int _ORMCOD_URANUS_INERTIAL = 238;
    /// Uranus magnetic
    public static final int _ORMCOD_URANUS_MAGNETIC_1993 = 239;
    /// Venus
    public static final int _ORMCOD_VENUS_1991 = 240;
    /// Venus equatorial inertial
    public static final int _ORMCOD_VENUS_INERTIAL = 241;
    /// Viti Levu
    public static final int _ORMCOD_VITI_LEVU_1916 = 242;
    /// Voirol
    public static final int _ORMCOD_VOIROL_1874 = 243;
    /// Voirol (with the Prime Meridian at Paris)
    public static final int _ORMCOD_VOIROL_1874_PM_PARIS = 244;
    /// Voirol - Revised
    public static final int _ORMCOD_VOIROL_1960 = 245;
    /// Voirol - Revised (with the Prime Meridian at Paris)
    public static final int _ORMCOD_VOIROL_1960_PM_PARIS = 246;
    /// Wake (astronomic)
    public static final int _ORMCOD_WAKE_1952 = 247;
    /// Wake-Eniwetok
    public static final int _ORMCOD_WAKE_ENIWETOK_1960 = 248;
    /// World Geodetic System
    public static final int _ORMCOD_WGS_1972 = 249;
    /// World Geodetic System
    public static final int _ORMCOD_WGS_1984 = 250;
    /// Yacare (Uruguay)
    public static final int _ORMCOD_YACARE_1987 = 251;
    /// Zanderij (Suriname)
    public static final int _ORMCOD_ZANDERIJ_1987 = 252;
    /// Added for the NGA Golden Data testing
    public static final int _ORMCOD_EXPERIMENTAL_NGA_SPHERE = -1001;
    /// Added for the NGA Golden Data testing
    public static final int _ORMCOD_EXPERIMENTAL_NGA_MAX = -1000;

    public static final int _totalEnum = 252;

    private static Vector<SRM_ORM_Code>  _enumVec = new Vector<SRM_ORM_Code>();
    private static HashMap<String, SRM_ORM_Code> _enumMap = new HashMap<String, SRM_ORM_Code>();

    public static final SRM_ORM_Code ORMCOD_UNSPECIFIED
        = new SRM_ORM_Code( _ORMCOD_UNSPECIFIED, "ORMCOD_UNSPECIFIED" );

    public static final SRM_ORM_Code ORMCOD_ABSTRACT_2D
        = new SRM_ORM_Code( _ORMCOD_ABSTRACT_2D, "ORMCOD_ABSTRACT_2D" );
    public static final SRM_ORM_Code ORMCOD_ABSTRACT_3D
        = new SRM_ORM_Code( _ORMCOD_ABSTRACT_3D, "ORMCOD_ABSTRACT_3D" );
    public static final SRM_ORM_Code ORMCOD_ADINDAN_1991
        = new SRM_ORM_Code( _ORMCOD_ADINDAN_1991, "ORMCOD_ADINDAN_1991" );
    public static final SRM_ORM_Code ORMCOD_ADRASTEA_2000
        = new SRM_ORM_Code( _ORMCOD_ADRASTEA_2000, "ORMCOD_ADRASTEA_2000" );
    public static final SRM_ORM_Code ORMCOD_AFGOOYE_1987
        = new SRM_ORM_Code( _ORMCOD_AFGOOYE_1987, "ORMCOD_AFGOOYE_1987" );
    public static final SRM_ORM_Code ORMCOD_AIN_EL_ABD_1970
        = new SRM_ORM_Code( _ORMCOD_AIN_EL_ABD_1970, "ORMCOD_AIN_EL_ABD_1970" );
    public static final SRM_ORM_Code ORMCOD_AMALTHEA_2000
        = new SRM_ORM_Code( _ORMCOD_AMALTHEA_2000, "ORMCOD_AMALTHEA_2000" );
    public static final SRM_ORM_Code ORMCOD_AMERICAN_SAMOA_1962
        = new SRM_ORM_Code( _ORMCOD_AMERICAN_SAMOA_1962, "ORMCOD_AMERICAN_SAMOA_1962" );
    public static final SRM_ORM_Code ORMCOD_ANNA_1_1965
        = new SRM_ORM_Code( _ORMCOD_ANNA_1_1965, "ORMCOD_ANNA_1_1965" );
    public static final SRM_ORM_Code ORMCOD_ANTIGUA_1943
        = new SRM_ORM_Code( _ORMCOD_ANTIGUA_1943, "ORMCOD_ANTIGUA_1943" );
    public static final SRM_ORM_Code ORMCOD_ARC_1950
        = new SRM_ORM_Code( _ORMCOD_ARC_1950, "ORMCOD_ARC_1950" );
    public static final SRM_ORM_Code ORMCOD_ARC_1960
        = new SRM_ORM_Code( _ORMCOD_ARC_1960, "ORMCOD_ARC_1960" );
    public static final SRM_ORM_Code ORMCOD_ARIEL_1988
        = new SRM_ORM_Code( _ORMCOD_ARIEL_1988, "ORMCOD_ARIEL_1988" );
    public static final SRM_ORM_Code ORMCOD_ASCENSION_1958
        = new SRM_ORM_Code( _ORMCOD_ASCENSION_1958, "ORMCOD_ASCENSION_1958" );
    public static final SRM_ORM_Code ORMCOD_ATLAS_1988
        = new SRM_ORM_Code( _ORMCOD_ATLAS_1988, "ORMCOD_ATLAS_1988" );
    public static final SRM_ORM_Code ORMCOD_AUSTRALIAN_GEOD_1966
        = new SRM_ORM_Code( _ORMCOD_AUSTRALIAN_GEOD_1966, "ORMCOD_AUSTRALIAN_GEOD_1966" );
    public static final SRM_ORM_Code ORMCOD_AUSTRALIAN_GEOD_1984
        = new SRM_ORM_Code( _ORMCOD_AUSTRALIAN_GEOD_1984, "ORMCOD_AUSTRALIAN_GEOD_1984" );
    public static final SRM_ORM_Code ORMCOD_AYABELLE_LIGHTHOUSE_1991
        = new SRM_ORM_Code( _ORMCOD_AYABELLE_LIGHTHOUSE_1991, "ORMCOD_AYABELLE_LIGHTHOUSE_1991" );
    public static final SRM_ORM_Code ORMCOD_BEACON_E_1945
        = new SRM_ORM_Code( _ORMCOD_BEACON_E_1945, "ORMCOD_BEACON_E_1945" );
    public static final SRM_ORM_Code ORMCOD_BELINDA_1988
        = new SRM_ORM_Code( _ORMCOD_BELINDA_1988, "ORMCOD_BELINDA_1988" );
    public static final SRM_ORM_Code ORMCOD_BELLEVUE_IGN_1987
        = new SRM_ORM_Code( _ORMCOD_BELLEVUE_IGN_1987, "ORMCOD_BELLEVUE_IGN_1987" );
    public static final SRM_ORM_Code ORMCOD_BERMUDA_1957
        = new SRM_ORM_Code( _ORMCOD_BERMUDA_1957, "ORMCOD_BERMUDA_1957" );
    public static final SRM_ORM_Code ORMCOD_BIANCA_1988
        = new SRM_ORM_Code( _ORMCOD_BIANCA_1988, "ORMCOD_BIANCA_1988" );
    public static final SRM_ORM_Code ORMCOD_BISSAU_1991
        = new SRM_ORM_Code( _ORMCOD_BISSAU_1991, "ORMCOD_BISSAU_1991" );
    public static final SRM_ORM_Code ORMCOD_BOGOTA_OBS_1987
        = new SRM_ORM_Code( _ORMCOD_BOGOTA_OBS_1987, "ORMCOD_BOGOTA_OBS_1987" );
    public static final SRM_ORM_Code ORMCOD_BOGOTA_OBS_1987_PM_BOGOTA
        = new SRM_ORM_Code( _ORMCOD_BOGOTA_OBS_1987_PM_BOGOTA, "ORMCOD_BOGOTA_OBS_1987_PM_BOGOTA" );
    public static final SRM_ORM_Code ORMCOD_BUKIT_RIMPAH_1987
        = new SRM_ORM_Code( _ORMCOD_BUKIT_RIMPAH_1987, "ORMCOD_BUKIT_RIMPAH_1987" );
    public static final SRM_ORM_Code ORMCOD_CALLISTO_2000
        = new SRM_ORM_Code( _ORMCOD_CALLISTO_2000, "ORMCOD_CALLISTO_2000" );
    public static final SRM_ORM_Code ORMCOD_CALYPSO_1988
        = new SRM_ORM_Code( _ORMCOD_CALYPSO_1988, "ORMCOD_CALYPSO_1988" );
    public static final SRM_ORM_Code ORMCOD_CAMP_AREA_1987
        = new SRM_ORM_Code( _ORMCOD_CAMP_AREA_1987, "ORMCOD_CAMP_AREA_1987" );
    public static final SRM_ORM_Code ORMCOD_CAMPO_INCHAUSPE_1969
        = new SRM_ORM_Code( _ORMCOD_CAMPO_INCHAUSPE_1969, "ORMCOD_CAMPO_INCHAUSPE_1969" );
    public static final SRM_ORM_Code ORMCOD_CANTON_1966
        = new SRM_ORM_Code( _ORMCOD_CANTON_1966, "ORMCOD_CANTON_1966" );
    public static final SRM_ORM_Code ORMCOD_CAPE_1987
        = new SRM_ORM_Code( _ORMCOD_CAPE_1987, "ORMCOD_CAPE_1987" );
    public static final SRM_ORM_Code ORMCOD_CAPE_CANAVERAL_1991
        = new SRM_ORM_Code( _ORMCOD_CAPE_CANAVERAL_1991, "ORMCOD_CAPE_CANAVERAL_1991" );
    public static final SRM_ORM_Code ORMCOD_CARTHAGE_1987
        = new SRM_ORM_Code( _ORMCOD_CARTHAGE_1987, "ORMCOD_CARTHAGE_1987" );
    public static final SRM_ORM_Code ORMCOD_CHARON_1991
        = new SRM_ORM_Code( _ORMCOD_CHARON_1991, "ORMCOD_CHARON_1991" );
    public static final SRM_ORM_Code ORMCOD_CHATHAM_1971
        = new SRM_ORM_Code( _ORMCOD_CHATHAM_1971, "ORMCOD_CHATHAM_1971" );
    public static final SRM_ORM_Code ORMCOD_CHUA_1987
        = new SRM_ORM_Code( _ORMCOD_CHUA_1987, "ORMCOD_CHUA_1987" );
    public static final SRM_ORM_Code ORMCOD_COAMPS_1998
        = new SRM_ORM_Code( _ORMCOD_COAMPS_1998, "ORMCOD_COAMPS_1998" );
    public static final SRM_ORM_Code ORMCOD_CORDELIA_1988
        = new SRM_ORM_Code( _ORMCOD_CORDELIA_1988, "ORMCOD_CORDELIA_1988" );
    public static final SRM_ORM_Code ORMCOD_CORREGO_ALEGRE_1987
        = new SRM_ORM_Code( _ORMCOD_CORREGO_ALEGRE_1987, "ORMCOD_CORREGO_ALEGRE_1987" );
    public static final SRM_ORM_Code ORMCOD_CRESSIDA_1988
        = new SRM_ORM_Code( _ORMCOD_CRESSIDA_1988, "ORMCOD_CRESSIDA_1988" );
    public static final SRM_ORM_Code ORMCOD_DABOLA_1991
        = new SRM_ORM_Code( _ORMCOD_DABOLA_1991, "ORMCOD_DABOLA_1991" );
    public static final SRM_ORM_Code ORMCOD_DECEPTION_1993
        = new SRM_ORM_Code( _ORMCOD_DECEPTION_1993, "ORMCOD_DECEPTION_1993" );
    public static final SRM_ORM_Code ORMCOD_DEIMOS_1988
        = new SRM_ORM_Code( _ORMCOD_DEIMOS_1988, "ORMCOD_DEIMOS_1988" );
    public static final SRM_ORM_Code ORMCOD_DESDEMONA_1988
        = new SRM_ORM_Code( _ORMCOD_DESDEMONA_1988, "ORMCOD_DESDEMONA_1988" );
    public static final SRM_ORM_Code ORMCOD_DESPINA_1991
        = new SRM_ORM_Code( _ORMCOD_DESPINA_1991, "ORMCOD_DESPINA_1991" );
    public static final SRM_ORM_Code ORMCOD_DIONE_1982
        = new SRM_ORM_Code( _ORMCOD_DIONE_1982, "ORMCOD_DIONE_1982" );
    public static final SRM_ORM_Code ORMCOD_DJAKARTA_1987
        = new SRM_ORM_Code( _ORMCOD_DJAKARTA_1987, "ORMCOD_DJAKARTA_1987" );
    public static final SRM_ORM_Code ORMCOD_DJAKARTA_1987_PM_DJAKARTA
        = new SRM_ORM_Code( _ORMCOD_DJAKARTA_1987_PM_DJAKARTA, "ORMCOD_DJAKARTA_1987_PM_DJAKARTA" );
    public static final SRM_ORM_Code ORMCOD_DOS_1968
        = new SRM_ORM_Code( _ORMCOD_DOS_1968, "ORMCOD_DOS_1968" );
    public static final SRM_ORM_Code ORMCOD_DOS_71_4_1987
        = new SRM_ORM_Code( _ORMCOD_DOS_71_4_1987, "ORMCOD_DOS_71_4_1987" );
    public static final SRM_ORM_Code ORMCOD_EARTH_INERT_ARIES_1950
        = new SRM_ORM_Code( _ORMCOD_EARTH_INERT_ARIES_1950, "ORMCOD_EARTH_INERT_ARIES_1950" );
    public static final SRM_ORM_Code ORMCOD_EARTH_INERT_ARIES_TRUE_OF_DATE
        = new SRM_ORM_Code( _ORMCOD_EARTH_INERT_ARIES_TRUE_OF_DATE, "ORMCOD_EARTH_INERT_ARIES_TRUE_OF_DATE" );
    public static final SRM_ORM_Code ORMCOD_EARTH_INERTIAL_J2000r0
        = new SRM_ORM_Code( _ORMCOD_EARTH_INERTIAL_J2000r0, "ORMCOD_EARTH_INERTIAL_J2000r0" );
    public static final SRM_ORM_Code ORMCOD_EARTH_SOLAR_ECLIPTIC
        = new SRM_ORM_Code( _ORMCOD_EARTH_SOLAR_ECLIPTIC, "ORMCOD_EARTH_SOLAR_ECLIPTIC" );
    public static final SRM_ORM_Code ORMCOD_EARTH_SOLAR_EQUATORIAL
        = new SRM_ORM_Code( _ORMCOD_EARTH_SOLAR_EQUATORIAL, "ORMCOD_EARTH_SOLAR_EQUATORIAL" );
    public static final SRM_ORM_Code ORMCOD_EARTH_SOLAR_MAG_DIPOLE
        = new SRM_ORM_Code( _ORMCOD_EARTH_SOLAR_MAG_DIPOLE, "ORMCOD_EARTH_SOLAR_MAG_DIPOLE" );
    public static final SRM_ORM_Code ORMCOD_EARTH_SOLAR_MAGNETOSPHERIC
        = new SRM_ORM_Code( _ORMCOD_EARTH_SOLAR_MAGNETOSPHERIC, "ORMCOD_EARTH_SOLAR_MAGNETOSPHERIC" );
    public static final SRM_ORM_Code ORMCOD_EASTER_1967
        = new SRM_ORM_Code( _ORMCOD_EASTER_1967, "ORMCOD_EASTER_1967" );
    public static final SRM_ORM_Code ORMCOD_ENCELADUS_1994
        = new SRM_ORM_Code( _ORMCOD_ENCELADUS_1994, "ORMCOD_ENCELADUS_1994" );
    public static final SRM_ORM_Code ORMCOD_EPIMETHEUS_1988
        = new SRM_ORM_Code( _ORMCOD_EPIMETHEUS_1988, "ORMCOD_EPIMETHEUS_1988" );
    public static final SRM_ORM_Code ORMCOD_EROS_2000
        = new SRM_ORM_Code( _ORMCOD_EROS_2000, "ORMCOD_EROS_2000" );
    public static final SRM_ORM_Code ORMCOD_ESTONIA_1937
        = new SRM_ORM_Code( _ORMCOD_ESTONIA_1937, "ORMCOD_ESTONIA_1937" );
    public static final SRM_ORM_Code ORMCOD_ETRS_1989
        = new SRM_ORM_Code( _ORMCOD_ETRS_1989, "ORMCOD_ETRS_1989" );
    public static final SRM_ORM_Code ORMCOD_EUROPA_2000
        = new SRM_ORM_Code( _ORMCOD_EUROPA_2000, "ORMCOD_EUROPA_2000" );
    public static final SRM_ORM_Code ORMCOD_EUROPE_1950
        = new SRM_ORM_Code( _ORMCOD_EUROPE_1950, "ORMCOD_EUROPE_1950" );
    public static final SRM_ORM_Code ORMCOD_EUROPE_1979
        = new SRM_ORM_Code( _ORMCOD_EUROPE_1979, "ORMCOD_EUROPE_1979" );
    public static final SRM_ORM_Code ORMCOD_FAHUD_1987
        = new SRM_ORM_Code( _ORMCOD_FAHUD_1987, "ORMCOD_FAHUD_1987" );
    public static final SRM_ORM_Code ORMCOD_FORT_THOMAS_1955
        = new SRM_ORM_Code( _ORMCOD_FORT_THOMAS_1955, "ORMCOD_FORT_THOMAS_1955" );
    public static final SRM_ORM_Code ORMCOD_GALATEA_1991
        = new SRM_ORM_Code( _ORMCOD_GALATEA_1991, "ORMCOD_GALATEA_1991" );
    public static final SRM_ORM_Code ORMCOD_GAN_1970
        = new SRM_ORM_Code( _ORMCOD_GAN_1970, "ORMCOD_GAN_1970" );
    public static final SRM_ORM_Code ORMCOD_GANYMEDE_2000
        = new SRM_ORM_Code( _ORMCOD_GANYMEDE_2000, "ORMCOD_GANYMEDE_2000" );
    public static final SRM_ORM_Code ORMCOD_GASPRA_1991
        = new SRM_ORM_Code( _ORMCOD_GASPRA_1991, "ORMCOD_GASPRA_1991" );
    public static final SRM_ORM_Code ORMCOD_GDA_1994
        = new SRM_ORM_Code( _ORMCOD_GDA_1994, "ORMCOD_GDA_1994" );
    public static final SRM_ORM_Code ORMCOD_GEODETIC_DATUM_1949
        = new SRM_ORM_Code( _ORMCOD_GEODETIC_DATUM_1949, "ORMCOD_GEODETIC_DATUM_1949" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1945
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1945, "ORMCOD_GEOMAGNETIC_1945" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1950
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1950, "ORMCOD_GEOMAGNETIC_1950" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1955
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1955, "ORMCOD_GEOMAGNETIC_1955" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1960
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1960, "ORMCOD_GEOMAGNETIC_1960" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1965
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1965, "ORMCOD_GEOMAGNETIC_1965" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1970
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1970, "ORMCOD_GEOMAGNETIC_1970" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1975
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1975, "ORMCOD_GEOMAGNETIC_1975" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1980
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1980, "ORMCOD_GEOMAGNETIC_1980" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1985
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1985, "ORMCOD_GEOMAGNETIC_1985" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1990
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1990, "ORMCOD_GEOMAGNETIC_1990" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_1995
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_1995, "ORMCOD_GEOMAGNETIC_1995" );
    public static final SRM_ORM_Code ORMCOD_GEOMAGNETIC_2000
        = new SRM_ORM_Code( _ORMCOD_GEOMAGNETIC_2000, "ORMCOD_GEOMAGNETIC_2000" );
    public static final SRM_ORM_Code ORMCOD_GRACIOSA_BASE_SW_1948
        = new SRM_ORM_Code( _ORMCOD_GRACIOSA_BASE_SW_1948, "ORMCOD_GRACIOSA_BASE_SW_1948" );
    public static final SRM_ORM_Code ORMCOD_GUAM_1963
        = new SRM_ORM_Code( _ORMCOD_GUAM_1963, "ORMCOD_GUAM_1963" );
    public static final SRM_ORM_Code ORMCOD_GUNONG_SEGARA_1987
        = new SRM_ORM_Code( _ORMCOD_GUNONG_SEGARA_1987, "ORMCOD_GUNONG_SEGARA_1987" );
    public static final SRM_ORM_Code ORMCOD_GUX_1_1987
        = new SRM_ORM_Code( _ORMCOD_GUX_1_1987, "ORMCOD_GUX_1_1987" );
    public static final SRM_ORM_Code ORMCOD_HELENE_1992
        = new SRM_ORM_Code( _ORMCOD_HELENE_1992, "ORMCOD_HELENE_1992" );
    public static final SRM_ORM_Code ORMCOD_HELIO_ARIES_ECLIPT_J2000r0
        = new SRM_ORM_Code( _ORMCOD_HELIO_ARIES_ECLIPT_J2000r0, "ORMCOD_HELIO_ARIES_ECLIPT_J2000r0" );
    public static final SRM_ORM_Code ORMCOD_HELIO_ARIES_ECLIPT_TRUE_OF_DATE
        = new SRM_ORM_Code( _ORMCOD_HELIO_ARIES_ECLIPT_TRUE_OF_DATE, "ORMCOD_HELIO_ARIES_ECLIPT_TRUE_OF_DATE" );
    public static final SRM_ORM_Code ORMCOD_HELIO_EARTH_ECLIPTIC
        = new SRM_ORM_Code( _ORMCOD_HELIO_EARTH_ECLIPTIC, "ORMCOD_HELIO_EARTH_ECLIPTIC" );
    public static final SRM_ORM_Code ORMCOD_HELIO_EARTH_EQUATORIAL
        = new SRM_ORM_Code( _ORMCOD_HELIO_EARTH_EQUATORIAL, "ORMCOD_HELIO_EARTH_EQUATORIAL" );
    public static final SRM_ORM_Code ORMCOD_HERAT_NORTH_1987
        = new SRM_ORM_Code( _ORMCOD_HERAT_NORTH_1987, "ORMCOD_HERAT_NORTH_1987" );
    public static final SRM_ORM_Code ORMCOD_HERMANNSKOGEL_1871
        = new SRM_ORM_Code( _ORMCOD_HERMANNSKOGEL_1871, "ORMCOD_HERMANNSKOGEL_1871" );
    public static final SRM_ORM_Code ORMCOD_HJORSEY_1955
        = new SRM_ORM_Code( _ORMCOD_HJORSEY_1955, "ORMCOD_HJORSEY_1955" );
    public static final SRM_ORM_Code ORMCOD_HONG_KONG_1963
        = new SRM_ORM_Code( _ORMCOD_HONG_KONG_1963, "ORMCOD_HONG_KONG_1963" );
    public static final SRM_ORM_Code ORMCOD_HU_TZU_SHAN_1991
        = new SRM_ORM_Code( _ORMCOD_HU_TZU_SHAN_1991, "ORMCOD_HU_TZU_SHAN_1991" );
    public static final SRM_ORM_Code ORMCOD_IAPETUS_1988
        = new SRM_ORM_Code( _ORMCOD_IAPETUS_1988, "ORMCOD_IAPETUS_1988" );
    public static final SRM_ORM_Code ORMCOD_IDA_1991
        = new SRM_ORM_Code( _ORMCOD_IDA_1991, "ORMCOD_IDA_1991" );
    public static final SRM_ORM_Code ORMCOD_INDIAN_1916
        = new SRM_ORM_Code( _ORMCOD_INDIAN_1916, "ORMCOD_INDIAN_1916" );
    public static final SRM_ORM_Code ORMCOD_INDIAN_1954
        = new SRM_ORM_Code( _ORMCOD_INDIAN_1954, "ORMCOD_INDIAN_1954" );
    public static final SRM_ORM_Code ORMCOD_INDIAN_1956
        = new SRM_ORM_Code( _ORMCOD_INDIAN_1956, "ORMCOD_INDIAN_1956" );
    public static final SRM_ORM_Code ORMCOD_INDIAN_1960
        = new SRM_ORM_Code( _ORMCOD_INDIAN_1960, "ORMCOD_INDIAN_1960" );
    public static final SRM_ORM_Code ORMCOD_INDIAN_1962
        = new SRM_ORM_Code( _ORMCOD_INDIAN_1962, "ORMCOD_INDIAN_1962" );
    public static final SRM_ORM_Code ORMCOD_INDIAN_1975
        = new SRM_ORM_Code( _ORMCOD_INDIAN_1975, "ORMCOD_INDIAN_1975" );
    public static final SRM_ORM_Code ORMCOD_INDONESIAN_1974
        = new SRM_ORM_Code( _ORMCOD_INDONESIAN_1974, "ORMCOD_INDONESIAN_1974" );
    public static final SRM_ORM_Code ORMCOD_IO_2000
        = new SRM_ORM_Code( _ORMCOD_IO_2000, "ORMCOD_IO_2000" );
    public static final SRM_ORM_Code ORMCOD_IRELAND_1965
        = new SRM_ORM_Code( _ORMCOD_IRELAND_1965, "ORMCOD_IRELAND_1965" );
    public static final SRM_ORM_Code ORMCOD_ISTS_061_1968
        = new SRM_ORM_Code( _ORMCOD_ISTS_061_1968, "ORMCOD_ISTS_061_1968" );
    public static final SRM_ORM_Code ORMCOD_ISTS_073_1969
        = new SRM_ORM_Code( _ORMCOD_ISTS_073_1969, "ORMCOD_ISTS_073_1969" );
    public static final SRM_ORM_Code ORMCOD_JANUS_1988
        = new SRM_ORM_Code( _ORMCOD_JANUS_1988, "ORMCOD_JANUS_1988" );
    public static final SRM_ORM_Code ORMCOD_JGD_2000
        = new SRM_ORM_Code( _ORMCOD_JGD_2000, "ORMCOD_JGD_2000" );
    public static final SRM_ORM_Code ORMCOD_JOHNSTON_1961
        = new SRM_ORM_Code( _ORMCOD_JOHNSTON_1961, "ORMCOD_JOHNSTON_1961" );
    public static final SRM_ORM_Code ORMCOD_JULIET_1988
        = new SRM_ORM_Code( _ORMCOD_JULIET_1988, "ORMCOD_JULIET_1988" );
    public static final SRM_ORM_Code ORMCOD_JUPITER_1988
        = new SRM_ORM_Code( _ORMCOD_JUPITER_1988, "ORMCOD_JUPITER_1988" );
    public static final SRM_ORM_Code ORMCOD_JUPITER_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_JUPITER_INERTIAL, "ORMCOD_JUPITER_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_JUPITER_MAGNETIC_1993
        = new SRM_ORM_Code( _ORMCOD_JUPITER_MAGNETIC_1993, "ORMCOD_JUPITER_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORMCOD_JUPITER_SOLAR_ECLIPTIC
        = new SRM_ORM_Code( _ORMCOD_JUPITER_SOLAR_ECLIPTIC, "ORMCOD_JUPITER_SOLAR_ECLIPTIC" );
    public static final SRM_ORM_Code ORMCOD_JUPITER_SOLAR_EQUATORIAL
        = new SRM_ORM_Code( _ORMCOD_JUPITER_SOLAR_EQUATORIAL, "ORMCOD_JUPITER_SOLAR_EQUATORIAL" );
    public static final SRM_ORM_Code ORMCOD_JUPITER_SOLAR_MAG_DIPOLE
        = new SRM_ORM_Code( _ORMCOD_JUPITER_SOLAR_MAG_DIPOLE, "ORMCOD_JUPITER_SOLAR_MAG_DIPOLE" );
    public static final SRM_ORM_Code ORMCOD_JUPITER_SOLAR_MAG_ECLIPTIC
        = new SRM_ORM_Code( _ORMCOD_JUPITER_SOLAR_MAG_ECLIPTIC, "ORMCOD_JUPITER_SOLAR_MAG_ECLIPTIC" );
    public static final SRM_ORM_Code ORMCOD_KANDAWALA_1987
        = new SRM_ORM_Code( _ORMCOD_KANDAWALA_1987, "ORMCOD_KANDAWALA_1987" );
    public static final SRM_ORM_Code ORMCOD_KERGUELEN_1949
        = new SRM_ORM_Code( _ORMCOD_KERGUELEN_1949, "ORMCOD_KERGUELEN_1949" );
    public static final SRM_ORM_Code ORMCOD_KERTAU_1948
        = new SRM_ORM_Code( _ORMCOD_KERTAU_1948, "ORMCOD_KERTAU_1948" );
    public static final SRM_ORM_Code ORMCOD_KOREAN_GEODETIC_1995
        = new SRM_ORM_Code( _ORMCOD_KOREAN_GEODETIC_1995, "ORMCOD_KOREAN_GEODETIC_1995" );
    public static final SRM_ORM_Code ORMCOD_KUSAIE_1951
        = new SRM_ORM_Code( _ORMCOD_KUSAIE_1951, "ORMCOD_KUSAIE_1951" );
    public static final SRM_ORM_Code ORMCOD_LARISSA_1991
        = new SRM_ORM_Code( _ORMCOD_LARISSA_1991, "ORMCOD_LARISSA_1991" );
    public static final SRM_ORM_Code ORMCOD_LC5_1961
        = new SRM_ORM_Code( _ORMCOD_LC5_1961, "ORMCOD_LC5_1961" );
    public static final SRM_ORM_Code ORMCOD_LEIGON_1991
        = new SRM_ORM_Code( _ORMCOD_LEIGON_1991, "ORMCOD_LEIGON_1991" );
    public static final SRM_ORM_Code ORMCOD_LIBERIA_1964
        = new SRM_ORM_Code( _ORMCOD_LIBERIA_1964, "ORMCOD_LIBERIA_1964" );
    public static final SRM_ORM_Code ORMCOD_LUZON_1987
        = new SRM_ORM_Code( _ORMCOD_LUZON_1987, "ORMCOD_LUZON_1987" );
    public static final SRM_ORM_Code ORMCOD_M_PORALOKO_1991
        = new SRM_ORM_Code( _ORMCOD_M_PORALOKO_1991, "ORMCOD_M_PORALOKO_1991" );
    public static final SRM_ORM_Code ORMCOD_MAHE_1971
        = new SRM_ORM_Code( _ORMCOD_MAHE_1971, "ORMCOD_MAHE_1971" );
    public static final SRM_ORM_Code ORMCOD_MARCUS_STATION_1952
        = new SRM_ORM_Code( _ORMCOD_MARCUS_STATION_1952, "ORMCOD_MARCUS_STATION_1952" );
    public static final SRM_ORM_Code ORMCOD_MARS_2000
        = new SRM_ORM_Code( _ORMCOD_MARS_2000, "ORMCOD_MARS_2000" );
    public static final SRM_ORM_Code ORMCOD_MARS_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_MARS_INERTIAL, "ORMCOD_MARS_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_MARS_SPHERE_2000
        = new SRM_ORM_Code( _ORMCOD_MARS_SPHERE_2000, "ORMCOD_MARS_SPHERE_2000" );
    public static final SRM_ORM_Code ORMCOD_MASS_1999
        = new SRM_ORM_Code( _ORMCOD_MASS_1999, "ORMCOD_MASS_1999" );
    public static final SRM_ORM_Code ORMCOD_MASSAWA_1987
        = new SRM_ORM_Code( _ORMCOD_MASSAWA_1987, "ORMCOD_MASSAWA_1987" );
    public static final SRM_ORM_Code ORMCOD_MERCHICH_1987
        = new SRM_ORM_Code( _ORMCOD_MERCHICH_1987, "ORMCOD_MERCHICH_1987" );
    public static final SRM_ORM_Code ORMCOD_MERCURY_1988
        = new SRM_ORM_Code( _ORMCOD_MERCURY_1988, "ORMCOD_MERCURY_1988" );
    public static final SRM_ORM_Code ORMCOD_MERCURY_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_MERCURY_INERTIAL, "ORMCOD_MERCURY_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_METIS_2000
        = new SRM_ORM_Code( _ORMCOD_METIS_2000, "ORMCOD_METIS_2000" );
    public static final SRM_ORM_Code ORMCOD_MIDWAY_1961
        = new SRM_ORM_Code( _ORMCOD_MIDWAY_1961, "ORMCOD_MIDWAY_1961" );
    public static final SRM_ORM_Code ORMCOD_MIMAS_1994
        = new SRM_ORM_Code( _ORMCOD_MIMAS_1994, "ORMCOD_MIMAS_1994" );
    public static final SRM_ORM_Code ORMCOD_MINNA_1991
        = new SRM_ORM_Code( _ORMCOD_MINNA_1991, "ORMCOD_MINNA_1991" );
    public static final SRM_ORM_Code ORMCOD_MIRANDA_1988
        = new SRM_ORM_Code( _ORMCOD_MIRANDA_1988, "ORMCOD_MIRANDA_1988" );
    public static final SRM_ORM_Code ORMCOD_MM5_1997
        = new SRM_ORM_Code( _ORMCOD_MM5_1997, "ORMCOD_MM5_1997" );
    public static final SRM_ORM_Code ORMCOD_MODTRAN_MIDLAT_N_1989
        = new SRM_ORM_Code( _ORMCOD_MODTRAN_MIDLAT_N_1989, "ORMCOD_MODTRAN_MIDLAT_N_1989" );
    public static final SRM_ORM_Code ORMCOD_MODTRAN_MIDLAT_S_1989
        = new SRM_ORM_Code( _ORMCOD_MODTRAN_MIDLAT_S_1989, "ORMCOD_MODTRAN_MIDLAT_S_1989" );
    public static final SRM_ORM_Code ORMCOD_MODTRAN_SUBARCTIC_N_1989
        = new SRM_ORM_Code( _ORMCOD_MODTRAN_SUBARCTIC_N_1989, "ORMCOD_MODTRAN_SUBARCTIC_N_1989" );
    public static final SRM_ORM_Code ORMCOD_MODTRAN_SUBARCTIC_S_1989
        = new SRM_ORM_Code( _ORMCOD_MODTRAN_SUBARCTIC_S_1989, "ORMCOD_MODTRAN_SUBARCTIC_S_1989" );
    public static final SRM_ORM_Code ORMCOD_MODTRAN_TROPICAL_1989
        = new SRM_ORM_Code( _ORMCOD_MODTRAN_TROPICAL_1989, "ORMCOD_MODTRAN_TROPICAL_1989" );
    public static final SRM_ORM_Code ORMCOD_MONTSERRAT_1958
        = new SRM_ORM_Code( _ORMCOD_MONTSERRAT_1958, "ORMCOD_MONTSERRAT_1958" );
    public static final SRM_ORM_Code ORMCOD_MOON_1991
        = new SRM_ORM_Code( _ORMCOD_MOON_1991, "ORMCOD_MOON_1991" );
    public static final SRM_ORM_Code ORMCOD_MULTIGEN_FLAT_EARTH_1989
        = new SRM_ORM_Code( _ORMCOD_MULTIGEN_FLAT_EARTH_1989, "ORMCOD_MULTIGEN_FLAT_EARTH_1989" );
    public static final SRM_ORM_Code ORMCOD_N_AM_1927
        = new SRM_ORM_Code( _ORMCOD_N_AM_1927, "ORMCOD_N_AM_1927" );
    public static final SRM_ORM_Code ORMCOD_N_AM_1983
        = new SRM_ORM_Code( _ORMCOD_N_AM_1983, "ORMCOD_N_AM_1983" );
    public static final SRM_ORM_Code ORMCOD_N_SAHARA_1959
        = new SRM_ORM_Code( _ORMCOD_N_SAHARA_1959, "ORMCOD_N_SAHARA_1959" );
    public static final SRM_ORM_Code ORMCOD_NAHRWAN_1987
        = new SRM_ORM_Code( _ORMCOD_NAHRWAN_1987, "ORMCOD_NAHRWAN_1987" );
    public static final SRM_ORM_Code ORMCOD_NAIAD_1991
        = new SRM_ORM_Code( _ORMCOD_NAIAD_1991, "ORMCOD_NAIAD_1991" );
    public static final SRM_ORM_Code ORMCOD_NAPARIMA_1991
        = new SRM_ORM_Code( _ORMCOD_NAPARIMA_1991, "ORMCOD_NAPARIMA_1991" );
    public static final SRM_ORM_Code ORMCOD_NEPTUNE_1991
        = new SRM_ORM_Code( _ORMCOD_NEPTUNE_1991, "ORMCOD_NEPTUNE_1991" );
    public static final SRM_ORM_Code ORMCOD_NEPTUNE_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_NEPTUNE_INERTIAL, "ORMCOD_NEPTUNE_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_NEPTUNE_MAGNETIC_1993
        = new SRM_ORM_Code( _ORMCOD_NEPTUNE_MAGNETIC_1993, "ORMCOD_NEPTUNE_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORMCOD_NOGAPS_1988
        = new SRM_ORM_Code( _ORMCOD_NOGAPS_1988, "ORMCOD_NOGAPS_1988" );
    public static final SRM_ORM_Code ORMCOD_NTF_1896
        = new SRM_ORM_Code( _ORMCOD_NTF_1896, "ORMCOD_NTF_1896" );
    public static final SRM_ORM_Code ORMCOD_NTF_1896_PM_PARIS
        = new SRM_ORM_Code( _ORMCOD_NTF_1896_PM_PARIS, "ORMCOD_NTF_1896_PM_PARIS" );
    public static final SRM_ORM_Code ORMCOD_OBERON_1988
        = new SRM_ORM_Code( _ORMCOD_OBERON_1988, "ORMCOD_OBERON_1988" );
    public static final SRM_ORM_Code ORMCOD_OBSERV_METEORO_1939
        = new SRM_ORM_Code( _ORMCOD_OBSERV_METEORO_1939, "ORMCOD_OBSERV_METEORO_1939" );
    public static final SRM_ORM_Code ORMCOD_OLD_EGYPTIAN_1907
        = new SRM_ORM_Code( _ORMCOD_OLD_EGYPTIAN_1907, "ORMCOD_OLD_EGYPTIAN_1907" );
    public static final SRM_ORM_Code ORMCOD_OLD_HAWAIIAN_CLARKE_1987
        = new SRM_ORM_Code( _ORMCOD_OLD_HAWAIIAN_CLARKE_1987, "ORMCOD_OLD_HAWAIIAN_CLARKE_1987" );
    public static final SRM_ORM_Code ORMCOD_OLD_HAWAIIAN_INT_1987
        = new SRM_ORM_Code( _ORMCOD_OLD_HAWAIIAN_INT_1987, "ORMCOD_OLD_HAWAIIAN_INT_1987" );
    public static final SRM_ORM_Code ORMCOD_OPHELIA_1988
        = new SRM_ORM_Code( _ORMCOD_OPHELIA_1988, "ORMCOD_OPHELIA_1988" );
    public static final SRM_ORM_Code ORMCOD_OSGB_1936
        = new SRM_ORM_Code( _ORMCOD_OSGB_1936, "ORMCOD_OSGB_1936" );
    public static final SRM_ORM_Code ORMCOD_PAN_1991
        = new SRM_ORM_Code( _ORMCOD_PAN_1991, "ORMCOD_PAN_1991" );
    public static final SRM_ORM_Code ORMCOD_PANDORA_1988
        = new SRM_ORM_Code( _ORMCOD_PANDORA_1988, "ORMCOD_PANDORA_1988" );
    public static final SRM_ORM_Code ORMCOD_PHOBOS_1988
        = new SRM_ORM_Code( _ORMCOD_PHOBOS_1988, "ORMCOD_PHOBOS_1988" );
    public static final SRM_ORM_Code ORMCOD_PHOEBE_1988
        = new SRM_ORM_Code( _ORMCOD_PHOEBE_1988, "ORMCOD_PHOEBE_1988" );
    public static final SRM_ORM_Code ORMCOD_PICO_DE_LAS_NIEVES_1987
        = new SRM_ORM_Code( _ORMCOD_PICO_DE_LAS_NIEVES_1987, "ORMCOD_PICO_DE_LAS_NIEVES_1987" );
    public static final SRM_ORM_Code ORMCOD_PITCAIRN_1967
        = new SRM_ORM_Code( _ORMCOD_PITCAIRN_1967, "ORMCOD_PITCAIRN_1967" );
    public static final SRM_ORM_Code ORMCOD_PLUTO_1994
        = new SRM_ORM_Code( _ORMCOD_PLUTO_1994, "ORMCOD_PLUTO_1994" );
    public static final SRM_ORM_Code ORMCOD_PLUTO_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_PLUTO_INERTIAL, "ORMCOD_PLUTO_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_POINT_58_1991
        = new SRM_ORM_Code( _ORMCOD_POINT_58_1991, "ORMCOD_POINT_58_1991" );
    public static final SRM_ORM_Code ORMCOD_POINTE_NOIRE_1948
        = new SRM_ORM_Code( _ORMCOD_POINTE_NOIRE_1948, "ORMCOD_POINTE_NOIRE_1948" );
    public static final SRM_ORM_Code ORMCOD_PORTIA_1988
        = new SRM_ORM_Code( _ORMCOD_PORTIA_1988, "ORMCOD_PORTIA_1988" );
    public static final SRM_ORM_Code ORMCOD_PORTO_SANTO_1936
        = new SRM_ORM_Code( _ORMCOD_PORTO_SANTO_1936, "ORMCOD_PORTO_SANTO_1936" );
    public static final SRM_ORM_Code ORMCOD_PROMETHEUS_1988
        = new SRM_ORM_Code( _ORMCOD_PROMETHEUS_1988, "ORMCOD_PROMETHEUS_1988" );
    public static final SRM_ORM_Code ORMCOD_PROTEUS_1991
        = new SRM_ORM_Code( _ORMCOD_PROTEUS_1991, "ORMCOD_PROTEUS_1991" );
    public static final SRM_ORM_Code ORMCOD_PROV_S_AM_1956
        = new SRM_ORM_Code( _ORMCOD_PROV_S_AM_1956, "ORMCOD_PROV_S_AM_1956" );
    public static final SRM_ORM_Code ORMCOD_PROV_S_CHILEAN_1963
        = new SRM_ORM_Code( _ORMCOD_PROV_S_CHILEAN_1963, "ORMCOD_PROV_S_CHILEAN_1963" );
    public static final SRM_ORM_Code ORMCOD_PUCK_1988
        = new SRM_ORM_Code( _ORMCOD_PUCK_1988, "ORMCOD_PUCK_1988" );
    public static final SRM_ORM_Code ORMCOD_PUERTO_RICO_1987
        = new SRM_ORM_Code( _ORMCOD_PUERTO_RICO_1987, "ORMCOD_PUERTO_RICO_1987" );
    public static final SRM_ORM_Code ORMCOD_PULKOVO_1942
        = new SRM_ORM_Code( _ORMCOD_PULKOVO_1942, "ORMCOD_PULKOVO_1942" );
    public static final SRM_ORM_Code ORMCOD_QATAR_NATIONAL_1974
        = new SRM_ORM_Code( _ORMCOD_QATAR_NATIONAL_1974, "ORMCOD_QATAR_NATIONAL_1974" );
    public static final SRM_ORM_Code ORMCOD_QORNOQ_1987
        = new SRM_ORM_Code( _ORMCOD_QORNOQ_1987, "ORMCOD_QORNOQ_1987" );
    public static final SRM_ORM_Code ORMCOD_REUNION_1947
        = new SRM_ORM_Code( _ORMCOD_REUNION_1947, "ORMCOD_REUNION_1947" );
    public static final SRM_ORM_Code ORMCOD_RGF_1993
        = new SRM_ORM_Code( _ORMCOD_RGF_1993, "ORMCOD_RGF_1993" );
    public static final SRM_ORM_Code ORMCOD_RHEA_1988
        = new SRM_ORM_Code( _ORMCOD_RHEA_1988, "ORMCOD_RHEA_1988" );
    public static final SRM_ORM_Code ORMCOD_ROME_1940
        = new SRM_ORM_Code( _ORMCOD_ROME_1940, "ORMCOD_ROME_1940" );
    public static final SRM_ORM_Code ORMCOD_ROME_1940_PM_ROME
        = new SRM_ORM_Code( _ORMCOD_ROME_1940_PM_ROME, "ORMCOD_ROME_1940_PM_ROME" );
    public static final SRM_ORM_Code ORMCOD_ROSALIND_1988
        = new SRM_ORM_Code( _ORMCOD_ROSALIND_1988, "ORMCOD_ROSALIND_1988" );
    public static final SRM_ORM_Code ORMCOD_S_AM_1969
        = new SRM_ORM_Code( _ORMCOD_S_AM_1969, "ORMCOD_S_AM_1969" );
    public static final SRM_ORM_Code ORMCOD_S_ASIA_1987
        = new SRM_ORM_Code( _ORMCOD_S_ASIA_1987, "ORMCOD_S_ASIA_1987" );
    public static final SRM_ORM_Code ORMCOD_S_JTSK_1993
        = new SRM_ORM_Code( _ORMCOD_S_JTSK_1993, "ORMCOD_S_JTSK_1993" );
    public static final SRM_ORM_Code ORMCOD_S42_PULKOVO
        = new SRM_ORM_Code( _ORMCOD_S42_PULKOVO, "ORMCOD_S42_PULKOVO" );
    public static final SRM_ORM_Code ORMCOD_SANTO_DOS_1965
        = new SRM_ORM_Code( _ORMCOD_SANTO_DOS_1965, "ORMCOD_SANTO_DOS_1965" );
    public static final SRM_ORM_Code ORMCOD_SAO_BRAZ_1987
        = new SRM_ORM_Code( _ORMCOD_SAO_BRAZ_1987, "ORMCOD_SAO_BRAZ_1987" );
    public static final SRM_ORM_Code ORMCOD_SAPPER_HILL_1943
        = new SRM_ORM_Code( _ORMCOD_SAPPER_HILL_1943, "ORMCOD_SAPPER_HILL_1943" );
    public static final SRM_ORM_Code ORMCOD_SATURN_1988
        = new SRM_ORM_Code( _ORMCOD_SATURN_1988, "ORMCOD_SATURN_1988" );
    public static final SRM_ORM_Code ORMCOD_SATURN_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_SATURN_INERTIAL, "ORMCOD_SATURN_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_SATURN_MAGNETIC_1993
        = new SRM_ORM_Code( _ORMCOD_SATURN_MAGNETIC_1993, "ORMCOD_SATURN_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORMCOD_SCHWARZECK_1991
        = new SRM_ORM_Code( _ORMCOD_SCHWARZECK_1991, "ORMCOD_SCHWARZECK_1991" );
    public static final SRM_ORM_Code ORMCOD_SELVAGEM_GRANDE_1938
        = new SRM_ORM_Code( _ORMCOD_SELVAGEM_GRANDE_1938, "ORMCOD_SELVAGEM_GRANDE_1938" );
    public static final SRM_ORM_Code ORMCOD_SIERRA_LEONE_1960
        = new SRM_ORM_Code( _ORMCOD_SIERRA_LEONE_1960, "ORMCOD_SIERRA_LEONE_1960" );
    public static final SRM_ORM_Code ORMCOD_SIRGAS_2000
        = new SRM_ORM_Code( _ORMCOD_SIRGAS_2000, "ORMCOD_SIRGAS_2000" );
    public static final SRM_ORM_Code ORMCOD_SUN_1992
        = new SRM_ORM_Code( _ORMCOD_SUN_1992, "ORMCOD_SUN_1992" );
    public static final SRM_ORM_Code ORMCOD_TANANARIVE_OBS_1925
        = new SRM_ORM_Code( _ORMCOD_TANANARIVE_OBS_1925, "ORMCOD_TANANARIVE_OBS_1925" );
    public static final SRM_ORM_Code ORMCOD_TANANARIVE_OBS_1925_PM_PARIS
        = new SRM_ORM_Code( _ORMCOD_TANANARIVE_OBS_1925_PM_PARIS, "ORMCOD_TANANARIVE_OBS_1925_PM_PARIS" );
    public static final SRM_ORM_Code ORMCOD_TELESTO_1988
        = new SRM_ORM_Code( _ORMCOD_TELESTO_1988, "ORMCOD_TELESTO_1988" );
    public static final SRM_ORM_Code ORMCOD_TERN_1961
        = new SRM_ORM_Code( _ORMCOD_TERN_1961, "ORMCOD_TERN_1961" );
    public static final SRM_ORM_Code ORMCOD_TETHYS_1991
        = new SRM_ORM_Code( _ORMCOD_TETHYS_1991, "ORMCOD_TETHYS_1991" );
    public static final SRM_ORM_Code ORMCOD_THALASSA_1991
        = new SRM_ORM_Code( _ORMCOD_THALASSA_1991, "ORMCOD_THALASSA_1991" );
    public static final SRM_ORM_Code ORMCOD_THEBE_2000
        = new SRM_ORM_Code( _ORMCOD_THEBE_2000, "ORMCOD_THEBE_2000" );
    public static final SRM_ORM_Code ORMCOD_TIMBALAI_EVEREST_1948
        = new SRM_ORM_Code( _ORMCOD_TIMBALAI_EVEREST_1948, "ORMCOD_TIMBALAI_EVEREST_1948" );
    public static final SRM_ORM_Code ORMCOD_TITAN_1982
        = new SRM_ORM_Code( _ORMCOD_TITAN_1982, "ORMCOD_TITAN_1982" );
    public static final SRM_ORM_Code ORMCOD_TITANIA_1988
        = new SRM_ORM_Code( _ORMCOD_TITANIA_1988, "ORMCOD_TITANIA_1988" );
    public static final SRM_ORM_Code ORMCOD_TOKYO_1991
        = new SRM_ORM_Code( _ORMCOD_TOKYO_1991, "ORMCOD_TOKYO_1991" );
    public static final SRM_ORM_Code ORMCOD_TRISTAN_1968
        = new SRM_ORM_Code( _ORMCOD_TRISTAN_1968, "ORMCOD_TRISTAN_1968" );
    public static final SRM_ORM_Code ORMCOD_TRITON_1991
        = new SRM_ORM_Code( _ORMCOD_TRITON_1991, "ORMCOD_TRITON_1991" );
    public static final SRM_ORM_Code ORMCOD_UMBRIEL_1988
        = new SRM_ORM_Code( _ORMCOD_UMBRIEL_1988, "ORMCOD_UMBRIEL_1988" );
    public static final SRM_ORM_Code ORMCOD_URANUS_1988
        = new SRM_ORM_Code( _ORMCOD_URANUS_1988, "ORMCOD_URANUS_1988" );
    public static final SRM_ORM_Code ORMCOD_URANUS_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_URANUS_INERTIAL, "ORMCOD_URANUS_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_URANUS_MAGNETIC_1993
        = new SRM_ORM_Code( _ORMCOD_URANUS_MAGNETIC_1993, "ORMCOD_URANUS_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORMCOD_VENUS_1991
        = new SRM_ORM_Code( _ORMCOD_VENUS_1991, "ORMCOD_VENUS_1991" );
    public static final SRM_ORM_Code ORMCOD_VENUS_INERTIAL
        = new SRM_ORM_Code( _ORMCOD_VENUS_INERTIAL, "ORMCOD_VENUS_INERTIAL" );
    public static final SRM_ORM_Code ORMCOD_VITI_LEVU_1916
        = new SRM_ORM_Code( _ORMCOD_VITI_LEVU_1916, "ORMCOD_VITI_LEVU_1916" );
    public static final SRM_ORM_Code ORMCOD_VOIROL_1874
        = new SRM_ORM_Code( _ORMCOD_VOIROL_1874, "ORMCOD_VOIROL_1874" );
    public static final SRM_ORM_Code ORMCOD_VOIROL_1874_PM_PARIS
        = new SRM_ORM_Code( _ORMCOD_VOIROL_1874_PM_PARIS, "ORMCOD_VOIROL_1874_PM_PARIS" );
    public static final SRM_ORM_Code ORMCOD_VOIROL_1960
        = new SRM_ORM_Code( _ORMCOD_VOIROL_1960, "ORMCOD_VOIROL_1960" );
    public static final SRM_ORM_Code ORMCOD_VOIROL_1960_PM_PARIS
        = new SRM_ORM_Code( _ORMCOD_VOIROL_1960_PM_PARIS, "ORMCOD_VOIROL_1960_PM_PARIS" );
    public static final SRM_ORM_Code ORMCOD_WAKE_1952
        = new SRM_ORM_Code( _ORMCOD_WAKE_1952, "ORMCOD_WAKE_1952" );
    public static final SRM_ORM_Code ORMCOD_WAKE_ENIWETOK_1960
        = new SRM_ORM_Code( _ORMCOD_WAKE_ENIWETOK_1960, "ORMCOD_WAKE_ENIWETOK_1960" );
    public static final SRM_ORM_Code ORMCOD_WGS_1972
        = new SRM_ORM_Code( _ORMCOD_WGS_1972, "ORMCOD_WGS_1972" );
    public static final SRM_ORM_Code ORMCOD_WGS_1984
        = new SRM_ORM_Code( _ORMCOD_WGS_1984, "ORMCOD_WGS_1984" );
    public static final SRM_ORM_Code ORMCOD_YACARE_1987
        = new SRM_ORM_Code( _ORMCOD_YACARE_1987, "ORMCOD_YACARE_1987" );
    public static final SRM_ORM_Code ORMCOD_ZANDERIJ_1987
        = new SRM_ORM_Code( _ORMCOD_ZANDERIJ_1987, "ORMCOD_ZANDERIJ_1987" );

    public static final SRM_ORM_Code ORMCOD_EXPERIMENTAL_NGA_MAX
        = new SRM_ORM_Code( _ORMCOD_EXPERIMENTAL_NGA_MAX, "ORMCOD_EXPERIMENTAL_NGA_MAX" );
    public static final SRM_ORM_Code ORMCOD_EXPERIMENTAL_NGA_SPHERE
        = new SRM_ORM_Code( _ORMCOD_EXPERIMENTAL_NGA_SPHERE, "ORMCOD_EXPERIMENTAL_NGA_SPHERE" );

    private SRM_ORM_Code(int code, String name)
    {
        super (code, name);
        _enumMap.put( name, this );
        if (code >= 0 && code < _totalEnum)
        {
            _enumVec.add( code, this );
        }
        else if (code == _ORMCOD_EXPERIMENTAL_NGA_MAX)
        {
            _enumVec.add( _totalEnum, this );
        }
        else if (code == _ORMCOD_EXPERIMENTAL_NGA_SPHERE)
        {
            _enumVec.add( _totalEnum+1, this );
        }
    }

    /** @return the SRM_ORM_Code from its enumerant value */
    public static SRM_ORM_Code getEnum( int enum_value ) throws SrmException
    {
        if (enum_value >= 0 && enum_value < _totalEnum )
            return (SRM_ORM_Code)(_enumVec.elementAt( enum_value ));
        else if (enum_value == _ORMCOD_EXPERIMENTAL_NGA_MAX)
            return (SRM_ORM_Code)(_enumVec.elementAt( _totalEnum ));
        else if (enum_value == _ORMCOD_EXPERIMENTAL_NGA_SPHERE)
            return (SRM_ORM_Code)(_enumVec.elementAt( _totalEnum+1 ));
        else
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_ORM_Code.getEnum: enumerant out of range") );
    }

    /** @return the SRM_ORM_Code from its string name */
    public static SRM_ORM_Code getEnum( String name ) throws SrmException
    {
        SRM_ORM_Code retCode = (SRM_ORM_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_ORM_Code.getEnum: enum. string not found") );

        return retCode;
    }
}
