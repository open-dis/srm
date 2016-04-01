/**
@author David Shen
@brief Declaration of RT enumeration class.
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

public class SRM_RT_Code extends SrmEnum
{
    /// Unspecified
    public static final int _RTCOD_UNSPECIFIED = 0;
    /// Universal
    public static final int _RTCOD_ABSTRACT_2D_IDENTITY = 1;
    /// Universal
    public static final int _RTCOD_ABSTRACT_3D_IDENTITY = 2;
    /// Burkina Faso
    public static final int _RTCOD_ADINDAN_1991_BURKINA_FASO = 3;
    /// Cameroon
    public static final int _RTCOD_ADINDAN_1991_CAMEROON = 4;
    /// Ethiopia
    public static final int _RTCOD_ADINDAN_1991_ETHIOPIA = 5;
    /// Mali
    public static final int _RTCOD_ADINDAN_1991_MALI = 6;
    /// Mean Solution (Ethiopia and Sudan)
    public static final int _RTCOD_ADINDAN_1991_MEAN_SOLUTION = 7;
    /// Senegal
    public static final int _RTCOD_ADINDAN_1991_SENEGAL = 8;
    /// Sudan
    public static final int _RTCOD_ADINDAN_1991_SUDAN = 9;
    /// Global (Adrastea)
    public static final int _RTCOD_ADRASTEA_2000_IDENTITY = 10;
    /// Somalia
    public static final int _RTCOD_AFGOOYE_1987_SOMALIA = 11;
    /// Bahrain Island
    public static final int _RTCOD_AIN_EL_ABD_1970_BAHRAIN_ISLAND = 12;
    /// Saudi Arabia
    public static final int _RTCOD_AIN_EL_ABD_1970_SAUDI_ARABIA = 13;
    /// Global (Amalthea)
    public static final int _RTCOD_AMALTHEA_2000_IDENTITY = 14;
    /// American Samoa Islands
    public static final int _RTCOD_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS = 15;
    /// Cocos Islands
    public static final int _RTCOD_ANNA_1_1965_COCOS_ISLANDS = 16;
    /// Antigua and Leeward Islands
    public static final int _RTCOD_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS = 17;
    /// Zimbabwe
    public static final int _RTCOD_ARC_1950_3_ZIMBABWE = 18;
    /// Botswana
    public static final int _RTCOD_ARC_1950_BOTSWANA = 19;
    /// Burundi
    public static final int _RTCOD_ARC_1950_BURUNDI = 20;
    /// Lesotho
    public static final int _RTCOD_ARC_1950_LESOTHO = 21;
    /// Malawi
    public static final int _RTCOD_ARC_1950_MALAWI = 22;
    /// Mean Solution (Botswana, Lesotho, Malawi, Swaziland, Zaire, Zambia and Zimbabwe)
    public static final int _RTCOD_ARC_1950_MEAN_SOLUTION = 23;
    /// Swaziland
    public static final int _RTCOD_ARC_1950_SWAZILAND = 24;
    /// Zaire
    public static final int _RTCOD_ARC_1950_ZAIRE = 25;
    /// Zambia
    public static final int _RTCOD_ARC_1950_ZAMBIA = 26;
    /// Kenya
    public static final int _RTCOD_ARC_1960_3_KENYA = 27;
    /// Mean Solution (Kenya and Tanzania)
    public static final int _RTCOD_ARC_1960_MEAN_SOLUTION = 28;
    /// Tanzania
    public static final int _RTCOD_ARC_1960_TANZANIA = 29;
    /// Global (Ariel)
    public static final int _RTCOD_ARIEL_1988_IDENTITY = 30;
    /// Ascension Island
    public static final int _RTCOD_ASCENSION_1958_ASCENSION_ISLAND = 31;
    /// Global (Atlas)
    public static final int _RTCOD_ATLAS_1988_IDENTITY = 32;
    /// Australia and Tasmania
    public static final int _RTCOD_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA = 33;
    /// Australia and Tasmania
    public static final int _RTCOD_AUSTRALIA_GEOD_1984_3_AUSTRALIA_TASMANIA = 34;
    /// Australia and Tasmania
    public static final int _RTCOD_AUSTRALIA_GEOD_1984_7_AUSTRALIA_TASMANIA = 35;
    /// Djibouti
    public static final int _RTCOD_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI = 36;
    /// Iwo Jima Island
    public static final int _RTCOD_BEACON_E_1945_IWO_JIMA_ISLAND = 37;
    /// Global (Belinda)
    public static final int _RTCOD_BELINDA_1988_IDENTITY = 38;
    /// Efate and Erromango Islands (Vanuatu)
    public static final int _RTCOD_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS = 39;
    /// Bermuda
    public static final int _RTCOD_BERMUDA_1957_BERMUDA = 40;
    /// Global (Bianca)
    public static final int _RTCOD_BIANCA_1988_IDENTITY = 41;
    /// Guinea-Bissau
    public static final int _RTCOD_BISSAU_1991_GUINEA_BISSAU = 42;
    /// Colombia
    public static final int _RTCOD_BOGOTA_OBS_1987_COLOMBIA = 43;
    /// Colombia
    public static final int _RTCOD_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA = 44;
    /// Bangka and Belitung Islands (Indonesia)
    public static final int _RTCOD_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS = 45;
    /// Global (Callisto)
    public static final int _RTCOD_CALLISTO_2000_IDENTITY = 46;
    /// Global (Calypso)
    public static final int _RTCOD_CALYPSO_1988_IDENTITY = 47;
    /// McMurdo Camp Area (Antarctica)
    public static final int _RTCOD_CAMP_AREA_1987_MCMURDO_CAMP = 48;
    /// Argentina
    public static final int _RTCOD_CAMPO_INCHAUSPE_1969_ARGENTINA = 49;
    /// Phoenix Islands
    public static final int _RTCOD_CANTON_1966_PHOENIX_ISLANDS = 50;
    /// South Africa
    public static final int _RTCOD_CAPE_1987_SOUTH_AFRICA = 51;
    /// Mean Solution (Bahamas and Florida)
    public static final int _RTCOD_CAPE_CANAVERAL_1991_MEAN_SOLUTION = 52;
    /// Tunisia
    public static final int _RTCOD_CARTHAGE_1987_TUNISIA = 53;
    /// Global (Charon)
    public static final int _RTCOD_CHARON_1991_IDENTITY = 54;
    /// Chatham Islands (New Zealand)
    public static final int _RTCOD_CHATHAM_1971_CHATHAM_ISLANDS = 55;
   /// Paraguay
    public static final int _RTCOD_CHUA_1987_PARAGUAY = 56;
    /// Global (Earth)
    public static final int _RTCOD_COAMPS_1998_IDENTITY_BY_DEFAULT = 57;
    /// Global (Cordelia)
    public static final int _RTCOD_CORDELIA_1988_IDENTITY = 58;
    /// Brazil
    public static final int _RTCOD_CORREGO_ALEGRE_1987_BRAZIL = 59;
    /// Global (Cressida)
    public static final int _RTCOD_CRESSIDA_1988_IDENTITY = 60;
    /// Guinea
    public static final int _RTCOD_DABOLA_1991_GUINEA = 61;
    /// Deception Island (Antarctica)
    public static final int _RTCOD_DECEPTION_1993_DECEPTION_ISLAND = 62;
    /// Global (Deimos)
    public static final int _RTCOD_DEIMOS_1988_IDENTITY = 63;
    /// Global (Desdemona)
    public static final int _RTCOD_DESDEMONA_1988_IDENTITY = 64;
    /// Global (Despina)
    public static final int _RTCOD_DESPINA_1991_IDENTITY = 65;
    /// Global (Dione)
    public static final int _RTCOD_DIONE_1982_IDENTITY = 66;
    /// Sumatra (Indonesia)
    public static final int _RTCOD_DJAKARTA_1987_PM_DJAKARTA_SUMATRA = 67;
    /// Sumatra (Indonesia)
    public static final int _RTCOD_DJAKARTA_1987_SUMATRA = 68;
    /// Gizo Island (New Georgia Islands)
    public static final int _RTCOD_DOS_1968_GIZO_ISLAND = 69;
    /// St. Helena Island
    public static final int _RTCOD_DOS_71_4_1987_ST_HELENA_ISLAND = 70;
    /// Easter Island
    public static final int _RTCOD_EASTER_1967_EASTER_ISLAND = 71;
    /// Global (Enceladus)
    public static final int _RTCOD_ENCELADUS_1994_IDENTITY = 72;
    /// Global (Epimetheus)
    public static final int _RTCOD_EPIMETHEUS_1988_IDENTITY = 73;
    /// Global (Eros)
    public static final int _RTCOD_EROS_2000_IDENTITY = 74;
    /// Estonia
    public static final int _RTCOD_ESTONIA_1937_ESTONIA = 75;
    /// Europe
    public static final int _RTCOD_ETRS_1989_IDENTITY_BY_MEASUREMENT = 76;
    /// Global (Europa)
    public static final int _RTCOD_EUROPA_2000_IDENTITY = 77;
    /// Cyprus
    public static final int _RTCOD_EUROPE_1950_3_CYPRUS = 78;
    /// Channel Islands
    public static final int _RTCOD_EUROPE_1950_CHANNEL_ISLANDS = 79;
    /// Egypt
    public static final int _RTCOD_EUROPE_1950_EGYPT = 80;
    /// England, Scotland, Channel Islands and Shetland Islands
    public static final int _RTCOD_EUROPE_1950_ENGLAND_SCOTLAND = 81;
    /// Greece
    public static final int _RTCOD_EUROPE_1950_GREECE = 82;
    /// Iran
    public static final int _RTCOD_EUROPE_1950_IRAN = 83;
    /// Iraq
    public static final int _RTCOD_EUROPE_1950_IRAQ = 84;
    /// Ireland, Northern Ireland, Wales, England, Scotland, Channel Islands, and Shetland Islands
    public static final int _RTCOD_EUROPE_1950_IRELAND = 85;
    /// Malta
    public static final int _RTCOD_EUROPE_1950_MALTA = 86;
    /// Mean Solution (Austria, Belgium, Denmark, Finland, France, FRG, Gibraltar, Greece, Italy, Luxembourg, Netherlands, Norway, Portugal, Spain, Sweden and Switzerland)
    public static final int _RTCOD_EUROPE_1950_MEAN_SOLUTION = 87;
    /// Finland and Norway
    public static final int _RTCOD_EUROPE_1950_NORWAY = 88;
    /// Portugal and Spain
    public static final int _RTCOD_EUROPE_1950_PORTUGAL_SPAIN = 89;
    /// Sardinia (Italy)
    public static final int _RTCOD_EUROPE_1950_SARDINIA = 90;
    /// Sicily (Italy)
    public static final int _RTCOD_EUROPE_1950_SICILY = 91;
    /// Tunisia
    public static final int _RTCOD_EUROPE_1950_TUNISIA = 92;
    /// Western Europe Mean Solution (Austria, Denmark, France, FRG, Netherlands and Switzerland)
    public static final int _RTCOD_EUROPE_1950_W_EUROPE_MEAN_SOLUTION = 93;
    /// Mean Solution (Austria, Finland, Netherlands, Norway, Spain, Sweden and Switzerland)
    public static final int _RTCOD_EUROPE_1979_MEAN_SOLUTION = 94;
    /// Oman
    public static final int _RTCOD_FAHUD_1987_3_OMAN = 95;
    /// Oman
    public static final int _RTCOD_FAHUD_1987_7_OMAN = 96;
    /// St. Kitts, Nevis and Leeward Islands
    public static final int _RTCOD_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS = 97;
    /// Global (Galatea)
    public static final int _RTCOD_GALATEA_1991_IDENTITY = 98;
    /// Republic of Maldives
    public static final int _RTCOD_GAN_1970_MALDIVES = 99;
    /// Global (Ganymede)
    public static final int _RTCOD_GANYMEDE_2000_IDENTITY = 100;
    /// Global (Gaspra)
    public static final int _RTCOD_GASPRA_1991_IDENTITY = 101;
    /// Australia
    public static final int _RTCOD_GDA_1994_IDENTITY_BY_MEASUREMENT = 102;
    /// New Zealand
    public static final int _RTCOD_GEODETIC_DATUM_1949_3_NEW_ZEALAND = 103;
    /// New Zealand
    public static final int _RTCOD_GEODETIC_DATUM_1949_7_NEW_ZEALAND = 104;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1945_DGRF = 105;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1950_DGRF = 106;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1955_DGRF = 107;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1960_DGRF = 108;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1965_DGRF = 109;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1970_DGRF = 110;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1975_DGRF = 111;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1980_DGRF = 112;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1985_DGRF = 113;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1990_DGRF = 114;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_1995_IGRF = 115;
    /// Global (Earth)
    public static final int _RTCOD_GEOMAGNETIC_2000_IGRF = 116;
    /// Central Azores (Faial, Graciosa, Pico, Sao Jorge and Terceira Islands)
    public static final int _RTCOD_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES = 117;
    /// Guam
    public static final int _RTCOD_GUAM_1963_GUAM = 118;
    /// Kalimantan Island (Indonesia)
    public static final int _RTCOD_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND = 119;
    /// Guadalcanal Island
    public static final int _RTCOD_GUX_1_1987_GUADALCANAL_ISLAND = 120;
    /// Global (Helene)
    public static final int _RTCOD_HELENE_1992_IDENTITY = 121;
    /// Afghanistan
    public static final int _RTCOD_HERAT_NORTH_1987_AFGHANISTAN = 122;
    /// Yugoslavia (prior to 1990), Slovenia, Croatia, Bosnia and Herzegovina, and Serbia
    public static final int _RTCOD_HERMANNSKOGEL_1871_3_YUGOSLAVIA = 123;
    /// Iceland
    public static final int _RTCOD_HJORSEY_1955_ICELAND = 124;
    /// Hong Kong
    public static final int _RTCOD_HONG_KONG_1963_HONG_KONG = 125;
    /// Taiwan
    public static final int _RTCOD_HU_TZU_SHAN_1991_TAIWAN = 126;
    /// Global (Iapetus)
    public static final int _RTCOD_IAPETUS_1988_IDENTITY = 127;
    /// Global (Ida)
    public static final int _RTCOD_IDA_1991_IDENTITY = 128;
    /// Bangladesh
    public static final int _RTCOD_INDIAN_1916_3_BANGLADESH = 129;
    /// Bangladesh
    public static final int _RTCOD_INDIAN_1916_7_BANGLADESH = 130;
    /// Thailand
    public static final int _RTCOD_INDIAN_1954_THAILAND = 131;
    /// India and Nepal
    public static final int _RTCOD_INDIAN_1956_INDIA_NEPAL = 132;
    /// Con Son Island (Vietnam)
    public static final int _RTCOD_INDIAN_1960_CON_SON_ISLAND = 133;
    /// Vietnam (near 16 deg. N)
    public static final int _RTCOD_INDIAN_1960_VIETNAM_16_N = 134;
    /// Pakistan
    public static final int _RTCOD_INDIAN_1962_PAKISTAN = 135;
    /// Thailand
    public static final int _RTCOD_INDIAN_1975_1991_THAILAND = 136;
    /// Thailand
    public static final int _RTCOD_INDIAN_1975_1997_THAILAND = 137;
    /// Indonesia
    public static final int _RTCOD_INDONESIAN_1974_INDONESIA = 138;
    /// Global (Io)
    public static final int _RTCOD_IO_2000_IDENTITY = 139;
    /// Ireland
    public static final int _RTCOD_IRELAND_1965_3_IRELAND = 140;
    /// Ireland
    public static final int _RTCOD_IRELAND_1965_7_IRELAND = 141;
    /// South Georgia Island
    public static final int _RTCOD_ISTS_061_1968_SOUTH_GEORGIA_ISLAND = 142;
    /// Diego Garcia
    public static final int _RTCOD_ISTS_073_1969_DIEGO_GARCIA = 143;
    /// Global (Janus)
    public static final int _RTCOD_JANUS_1988_IDENTITY = 144;
    /// Japan
    public static final int _RTCOD_JGD_2000_IDENTITY_BY_MEASUREMENT = 145;
    /// Johnston Island
    public static final int _RTCOD_JOHNSTON_1961_JOHNSTON_ISLAND = 146;
    /// Global (Juliet)
    public static final int _RTCOD_JULIET_1988_IDENTITY = 147;
    /// Global (Jupiter)
    public static final int _RTCOD_JUPITER_1988_IDENTITY = 148;
    /// Global (Jupiter)
    public static final int _RTCOD_JUPITER_MAGNETIC_1993_VOYAGER = 149;
    /// Sri Lanka
    public static final int _RTCOD_KANDAWALA_1987_3_SRI_LANKA = 150;
    /// Kerguelen Island
    public static final int _RTCOD_KERGUELEN_1949_KERGUELEN_ISLAND = 151;
    /// West Malaysia and Singapore
    public static final int _RTCOD_KERTAU_1948_3_W_MALAYSIA_SINGAPORE = 152;
    /// South Korea
    public static final int _RTCOD_KOREAN_GEODETIC_1995_SOUTH_KOREA = 153;
    /// Caroline Islands (Federated States of Micronesia)
    public static final int _RTCOD_KUSAIE_1951_CAROLINE_ISLANDS = 154;
    /// Global (Larissa)
    public static final int _RTCOD_LARISSA_1991_IDENTITY = 155;
    /// Cayman Brac Island
    public static final int _RTCOD_LC5_1961_CAYMAN_BRAC_ISLAND = 156;
    /// Ghana
    public static final int _RTCOD_LEIGON_1991_3_GHANA = 157;
    /// Ghana
    public static final int _RTCOD_LEIGON_1991_7_GHANA = 158;
    /// Liberia
    public static final int _RTCOD_LIBERIA_1964_LIBERIA = 159;
    /// Mindanao Island (Philippines)
    public static final int _RTCOD_LUZON_1987_MINDANAO_ISLAND = 160;
    /// Philippines (excluding Mindanao Island)
    public static final int _RTCOD_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND = 161;
    /// Gabon
    public static final int _RTCOD_M_PORALOKO_1991_GABON = 162;
    /// Mahe Island (Seychelles)
    public static final int _RTCOD_MAHE_1971_MAHE_ISLAND = 163;
    /// Marcus Islands
    public static final int _RTCOD_MARCUS_STATION_1952_MARCUS_ISLANDS = 164;
    /// Global (Mars)
    public static final int _RTCOD_MARS_2000_IDENTITY = 165;
    /// Global (Mars)
    public static final int _RTCOD_MARS_SPHERE_2000_GLOBAL = 166;
    /// Global (Earth)
    public static final int _RTCOD_MASS_1999_IDENTITY_BY_DEFAULT = 167;
    /// Eritrea and Ethiopia
    public static final int _RTCOD_MASSAWA_1987_ERITREA_ETHIOPIA = 168;
    /// Morocco
    public static final int _RTCOD_MERCHICH_1987_MOROCCO = 169;
    /// Global (Mercury)
    public static final int _RTCOD_MERCURY_1988_IDENTITY = 170;
    /// Global (Metis)
    public static final int _RTCOD_METIS_2000_IDENTITY = 171;
    /// Midway Islands
    public static final int _RTCOD_MIDWAY_1961_MIDWAY_ISLANDS = 172;
    /// Global (Mimas)
    public static final int _RTCOD_MIMAS_1994_IDENTITY = 173;
    /// Cameroon
    public static final int _RTCOD_MINNA_1991_CAMEROON = 174;
    /// Nigeria
    public static final int _RTCOD_MINNA_1991_NIGERIA = 175;
    /// Global (Miranda)
    public static final int _RTCOD_MIRANDA_1988_IDENTITY = 176;
    /// Global (Earth)
    public static final int _RTCOD_MM5_1997_IDENTITY_BY_DEFAULT = 177;
    /// Northern midlatitude regions (Earth)
    public static final int _RTCOD_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT = 178;
    /// Southern midlatitude regions (Earth)
    public static final int _RTCOD_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT = 179;
    /// Northern subarctic regions (Earth)
    public static final int _RTCOD_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT = 180;
    /// Southern subarctic regions (Earth)
    public static final int _RTCOD_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT = 181;
    /// Tropical regions (Earth)
    public static final int _RTCOD_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT = 182;
    /// Montserrat and Leeward Islands
    public static final int _RTCOD_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS = 183;
    /// Global (Moon)
    public static final int _RTCOD_MOON_1991_IDENTITY = 184;
    /// Global (Earth)
    public static final int _RTCOD_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT = 185;
    /// Alaska (excluding Aleutian Islands)
    public static final int _RTCOD_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS = 186;
    /// Canada (Alberta and British Columbia)
    public static final int _RTCOD_N_AM_1927_ALBERTA_BRITISH_COLUMBIA = 187;
    /// Bahamas (excluding San Salvador Island)
    public static final int _RTCOD_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND = 188;
    /// Canada
    public static final int _RTCOD_N_AM_1927_CANADA = 189;
    /// Canal Zone
    public static final int _RTCOD_N_AM_1927_CANAL_ZONE = 190;
    /// Caribbean (Antigua Island, Barbados, Barbuda, Caicos Islands, Cuba, Dominican Republic, Grand Cayman, Jamaica and Turks Islands)
    public static final int _RTCOD_N_AM_1927_CARIBBEAN = 191;
    /// Central America (Belize, Costa Rica, El Salvador, Guatemala, Honduras and Nicaragua)
    public static final int _RTCOD_N_AM_1927_CENTRAL_AMERICA = 192;
    /// Continental United States Mean Solution
    public static final int _RTCOD_N_AM_1927_CONTINENTAL_US = 193;
    /// Cuba
    public static final int _RTCOD_N_AM_1927_CUBA = 194;
    /// Aleutian Islands (east of 180 deg. W)
    public static final int _RTCOD_N_AM_1927_EAST_ALEUTIAN_ISLANDS = 195;
    /// Eastern Canada (New Brunswick, Newfoundland, Nova Scotia and Quebec)
    public static final int _RTCOD_N_AM_1927_EASTERN_CANADA = 196;
    /// Eastern United States (Alabama, Connecticut, Delaware, District of Columbia, Florida, Georgia, Illinois, Indiana, Kentucky, Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, New Hampshire, New Jersey, New York, North Carolina, Ohio, Pennsylvania, Rhode Island, South Carolina, Tennessee, Vermont, Virginia, West Virginia and Wisconsin)
    public static final int _RTCOD_N_AM_1927_EASTERN_US = 197;
    /// Hayes Peninsula (Greenland)
    public static final int _RTCOD_N_AM_1927_HAYES_PENINSULA = 198;
    /// Canada (Manitoba and Ontario)
    public static final int _RTCOD_N_AM_1927_MANITOBA_ONTARIO = 199;
    /// Mexico
    public static final int _RTCOD_N_AM_1927_MEXICO = 200;
    /// Canada (Northwest Territories and Saskatchewan)
    public static final int _RTCOD_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN = 201;
    /// San Salvador Island
    public static final int _RTCOD_N_AM_1927_SAN_SALVADOR_ISLAND = 202;
    /// Aleutian Islands (west of 180 deg. W)
    public static final int _RTCOD_N_AM_1927_WEST_ALEUTIAN_ISLANDS = 203;
    /// Western United States (Arizona, Arkansas, California, Colorado, Idaho, Iowa, Kansas, Montana, Nebraska, Nevada, New Mexico, North Dakota, Oklahoma, Oregon, South Dakota, Texas, Utah, Washington and Wyoming)
    public static final int _RTCOD_N_AM_1927_WESTERN_US = 204;
    /// Canada (Yukon)
    public static final int _RTCOD_N_AM_1927_YUKON = 205;
    /// Alaska (excluding Aleutian Islands)
    public static final int _RTCOD_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS = 206;
    /// Aleutian Islands
    public static final int _RTCOD_N_AM_1983_ALEUTIAN_ISLANDS = 207;
    /// Canada
    public static final int _RTCOD_N_AM_1983_CANADA = 208;
    /// Continental United States
    public static final int _RTCOD_N_AM_1983_CONTINENTAL_US = 209;
    /// Hawaii
    public static final int _RTCOD_N_AM_1983_HAWAII = 210;
    /// Mexico and Central America
    public static final int _RTCOD_N_AM_1983_MEXICO_CENTRAL_AMERICA = 211;
    /// Algeria
    public static final int _RTCOD_N_SAHARA_1959_ALGERIA = 212;
    /// Masirah Island (Oman)
    public static final int _RTCOD_NAHRWAN_1987_MASIRAH_ISLAND = 213;
    /// Saudi Arabia
    public static final int _RTCOD_NAHRWAN_1987_SAUDI_ARABIA = 214;
    /// United Arab Emirates
    public static final int _RTCOD_NAHRWAN_1987_UNITED_ARAB_EMIRATES = 215;
    /// Global (Naiad)
    public static final int _RTCOD_NAIAD_1991_IDENTITY = 216;
    /// Trinidad and Tobago (British West Indies)
    public static final int _RTCOD_NAPARIMA_1991_TRINIDAD_TOBAGO = 217;
    /// Global (Neptune)
    public static final int _RTCOD_NEPTUNE_1991_IDENTITY = 218;
    /// Global (Neptune)
    public static final int _RTCOD_NEPTUNE_MAGNETIC_1993_VOYAGER = 219;
    /// Global (Earth)
    public static final int _RTCOD_NOGAPS_1988_IDENTITY_BY_DEFAULT = 220;
    /// France
    public static final int _RTCOD_NTF_1896_FRANCE = 221;
    /// France
    public static final int _RTCOD_NTF_1896_PM_PARIS_FRANCE = 222;
    /// Global (Oberon)
    public static final int _RTCOD_OBERON_1988_IDENTITY = 223;
    /// Corvo Flores Islands (Azores)
    public static final int _RTCOD_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS = 224;
    /// Egypt
    public static final int _RTCOD_OLD_EGYPTIAN_1907_EGYPT = 225;
    /// Hawaii (US)
    public static final int _RTCOD_OLD_HAWAII_C_1987_HAWAII = 226;
    /// Kauai (US)
    public static final int _RTCOD_OLD_HAWAII_C_1987_KAUAI = 227;
    /// Maui (US)
    public static final int _RTCOD_OLD_HAWAII_C_1987_MAUI = 228;
    /// Mean Solution (Hawaii (US))
    public static final int _RTCOD_OLD_HAWAII_C_1987_MEAN_SOLUTION = 229;
    /// Oahu (US)
    public static final int _RTCOD_OLD_HAWAII_C_1987_OAHU = 230;
    /// Hawaii (US)
    public static final int _RTCOD_OLD_HAWAII_I_1987_HAWAII = 231;
    /// Kauai (US)
    public static final int _RTCOD_OLD_HAWAII_I_1987_KAUAI = 232;
    /// Maui (US)
    public static final int _RTCOD_OLD_HAWAII_I_1987_MAUI = 233;
    /// Mean Solution (Hawaii (US))
    public static final int _RTCOD_OLD_HAWAII_I_1987_MEAN_SOLUTION = 234;
    /// Oahu (US)
    public static final int _RTCOD_OLD_HAWAII_I_1987_OAHU = 235;
    /// Global (Ophelia)
    public static final int _RTCOD_OPHELIA_1988_IDENTITY = 236;
    /// Mean Solution (England, Isle of Man, Scotland, Shetland, and Wales)
    public static final int _RTCOD_OSGB_1936_3_MEAN_SOLUTION = 237;
    /// Great Britain
    public static final int _RTCOD_OSGB_1936_7_GREAT_BRITAIN = 238;
    /// England
    public static final int _RTCOD_OSGB_1936_ENGLAND = 239;
    /// England, Isle of Man, and Wales
    public static final int _RTCOD_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES = 240;
    /// Scotland and Shetland Islands
    public static final int _RTCOD_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS = 241;
    /// Wales
    public static final int _RTCOD_OSGB_1936_WALES = 242;
    /// Global (Pan)
    public static final int _RTCOD_PAN_1991_IDENTITY = 243;
    /// Global (Pandora)
    public static final int _RTCOD_PANDORA_1988_IDENTITY = 244;
    /// Global (Phobos)
    public static final int _RTCOD_PHOBOS_1988_IDENTITY = 245;
    /// Global (Phoebe)
    public static final int _RTCOD_PHOEBE_1988_IDENTITY = 246;
    /// Canary Islands (Spain)
    public static final int _RTCOD_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS = 247;
    /// Pitcairn Island
    public static final int _RTCOD_PITCAIRN_1967_PITCAIRN_ISLAND = 248;
    /// Global (Pluto)
    public static final int _RTCOD_PLUTO_1994_IDENTITY = 249;
    /// Mean Solution (Burkina Faso and Niger)
    public static final int _RTCOD_POINT_58_1991_MEAN_SOLUTION = 250;
    /// Congo
    public static final int _RTCOD_POINTE_NOIRE_1948_CONGO = 251;
    /// Global (Portia)
    public static final int _RTCOD_PORTIA_1988_IDENTITY = 252;
    /// Porto Santo and Madeira Islands
    public static final int _RTCOD_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS = 253;
    /// Global (Prometheus)
    public static final int _RTCOD_PROMETHEUS_1988_IDENTITY = 254;
    /// Global (Proteus)
    public static final int _RTCOD_PROTEUS_1991_IDENTITY = 255;
    /// Venezuela
    public static final int _RTCOD_PROV_S_AM_1956_3_VENEZUELA = 256;
    /// Venezuela
    public static final int _RTCOD_PROV_S_AM_1956_7_VENEZUELA = 257;
    /// Bolivia
    public static final int _RTCOD_PROV_S_AM_1956_BOLIVIA = 258;
    /// Colombia
    public static final int _RTCOD_PROV_S_AM_1956_COLOMBIA = 259;
    /// Ecuador
    public static final int _RTCOD_PROV_S_AM_1956_ECUADOR = 260;
    /// Guyana
    public static final int _RTCOD_PROV_S_AM_1956_GUYANA = 261;
    /// Mean Solution (Bolivia, Chile, Colombia, Ecuador, Guyana, Peru and Venezuela)
    public static final int _RTCOD_PROV_S_AM_1956_MEAN_SOLUTION = 262;
    /// Northern Chile (near 19 deg. S)
    public static final int _RTCOD_PROV_S_AM_1956_N_CHILE_19_S = 263;
    /// Peru
    public static final int _RTCOD_PROV_S_AM_1956_PERU = 264;
    /// Southern Chile (near 43 deg. S)
    public static final int _RTCOD_PROV_S_AM_1956_S_CHILE_43_S = 265;
    /// South Chile (near 53 deg. S)
    public static final int _RTCOD_PROV_S_CHILEAN_1963_SOUTH_CHILE = 266;
    /// Global (Puck)
    public static final int _RTCOD_PUCK_1988_IDENTITY = 267;
    /// Puerto Rico and Virgin Islands
    public static final int _RTCOD_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS = 268;
    /// Russia
    public static final int _RTCOD_PULKOVO_1942_RUSSIA = 269;
    /// Qatar
    public static final int _RTCOD_QATAR_NATIONAL_1974_3_QATAR = 270;
    /// South Greenland
    public static final int _RTCOD_QORNOQ_1987_SOUTH_GREENLAND = 271;
    /// Mascarene Islands
    public static final int _RTCOD_REUNION_1947_MASCARENE_ISLANDS = 272;
    /// France
    public static final int _RTCOD_RGF_1993_IDENTITY_BY_MEASUREMENT = 273;
    /// Global (Rhea)
    public static final int _RTCOD_RHEA_1988_IDENTITY = 274;
    /// Sardinia (Italy)
    public static final int _RTCOD_ROME_1940_PM_ROME_SARDINIA = 275;
    /// Sardinia (Italy)
    public static final int _RTCOD_ROME_1940_SARDINIA = 276;
    /// Global (Rosalind)
    public static final int _RTCOD_ROSALIND_1988_IDENTITY = 277;
    /// Argentina
    public static final int _RTCOD_S_AM_1969_ARGENTINA = 278;
    /// Baltra and Galapagos Islands (Ecuador)
    public static final int _RTCOD_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS = 279;
    /// Bolivia
    public static final int _RTCOD_S_AM_1969_BOLIVIA = 280;
    /// Brazil
    public static final int _RTCOD_S_AM_1969_BRAZIL = 281;
    /// Chile
    public static final int _RTCOD_S_AM_1969_CHILE = 282;
    /// Colombia
    public static final int _RTCOD_S_AM_1969_COLOMBIA = 283;
    /// Ecuador (excluding Galapagos Islands)
    public static final int _RTCOD_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS = 284;
    /// Guyana
    public static final int _RTCOD_S_AM_1969_GUYANA = 285;
    /// Mean Solution (Argentina, Bolivia, Brazil, Chile, Colombia, Ecuador, Guyana, Paraguay, Peru, Trinidad and Tobago, and Venezuela)
    public static final int _RTCOD_S_AM_1969_MEAN_SOLUTION = 286;
    /// Paraguay
    public static final int _RTCOD_S_AM_1969_PARAGUAY = 287;
    /// Peru
    public static final int _RTCOD_S_AM_1969_PERU = 288;
    /// Trinidad and Tobago (British West Indies)
    public static final int _RTCOD_S_AM_1969_TRINIDAD_TOBAGO = 289;
    /// Venezuela
    public static final int _RTCOD_S_AM_1969_VENEZUELA = 290;
    /// Singapore
    public static final int _RTCOD_S_ASIA_1987_SINGAPORE = 291;
    /// Czech Republic
    public static final int _RTCOD_S_JTSK_1993_CZECH_REPUBLIC = 292;
    /// Czech Republic and Slovakia
    public static final int _RTCOD_S_JTSK_1993_CZECH_SLOVAKIA = 293;
    /// Poland
    public static final int _RTCOD_S42_PULKOVO_3_POLAND = 294;
    /// Albania
    public static final int _RTCOD_S42_PULKOVO_ALBANIA = 295;
    /// Czech Republic and Slovakia
    public static final int _RTCOD_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA = 296;
    /// Romania
    public static final int _RTCOD_S42_PULKOVO_G_ROMANIA = 297;
    /// Hungary
    public static final int _RTCOD_S42_PULKOVO_HUNGARY = 298;
    /// Kazakhstan
    public static final int _RTCOD_S42_PULKOVO_KAZAKHSTAN = 299;
    /// Latvia
    public static final int _RTCOD_S42_PULKOVO_LATVIA = 300;
    /// Espirito Santo Island (Vanuatu)
    public static final int _RTCOD_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND = 301;
    /// Sao Miguel and Santa Maria Islands (Azores)
    public static final int _RTCOD_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS = 302;
    /// East Falkland Islands
    public static final int _RTCOD_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS = 303;
    /// Global (Saturn)
    public static final int _RTCOD_SATURN_1988_IDENTITY = 304;
    /// Global (Saturn)
    public static final int _RTCOD_SATURN_MAGNETIC_1993_VOYAGER_IDENTITY_BY_MEASUREMENT = 305;
    /// Namibia
    public static final int _RTCOD_SCHWARZECK_1991_NAMIBIA = 306;
    /// Salvage Islands (Ilhas Selvagens; Savage Islands)
    public static final int _RTCOD_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS = 307;
    /// Sierra Leone
    public static final int _RTCOD_SIERRA_LEONE_1960_SIERRA_LEONE = 308;
    /// South America
    public static final int _RTCOD_SIRGAS_2000_IDENTITY_BY_MEASUREMENT = 309;
    /// Global (Sun)
    public static final int _RTCOD_SUN_1992_IDENTITY = 310;
    /// Madagascar
    public static final int _RTCOD_TANANARIVE_OBS_1925_3_MADAGASCAR = 311;
    /// Madagascar
    public static final int _RTCOD_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR = 312;
    /// Global (Telesto)
    public static final int _RTCOD_TELESTO_1988_IDENTITY = 313;
    /// Tern Island (French Frigate Shoals, Hawaiian Islands)
    public static final int _RTCOD_TERN_1961_TERN_ISLAND = 314;
    /// Global (Tethys)
    public static final int _RTCOD_TETHYS_1991_IDENTITY = 315;
    /// Global (Thalassa)
    public static final int _RTCOD_THALASSA_1991_IDENTITY = 316;
    /// Global (Thebe)
    public static final int _RTCOD_THEBE_2000_IDENTITY = 317;
    /// Brunei and East Malaysia (Sabah and Sarawak)
    public static final int _RTCOD_TIMBALAI_EVRST_1948_3_BRUNEI_E_MALAYSIA = 318;
    /// Brunei and East Malaysia (Sabah and Sarawak)
    public static final int _RTCOD_TIMBALAI_EVRST_1948_7_BRUNEI_E_MALAYSIA = 319;
    /// Global (Titan)
    public static final int _RTCOD_TITAN_1982_IDENTITY = 320;
    /// Global (Titania)
    public static final int _RTCOD_TITANIA_1988_IDENTITY = 321;
    /// Japan
    public static final int _RTCOD_TOKYO_1991_JAPAN = 322;
    /// Mean Solution (Japan, Korea, and Okinawa)
    public static final int _RTCOD_TOKYO_1991_MEAN_SOLUTION = 323;
    /// Okinawa (Japan)
    public static final int _RTCOD_TOKYO_1991_OKINAWA = 324;
    /// South Korea
    public static final int _RTCOD_TOKYO_1991_1991_SOUTH_KOREA = 325;
    /// South Korea
    public static final int _RTCOD_TOKYO_1991_1997_SOUTH_KOREA = 326;
    /// Tristan da Cunha
    public static final int _RTCOD_TRISTAN_1968_TRISTAN_DA_CUNHA = 327;
    /// Global (Triton)
    public static final int _RTCOD_TRITON_1991_IDENTITY = 328;
    /// Global (Umbriel)
    public static final int _RTCOD_UMBRIEL_1988_IDENTITY = 329;
    /// Global (Uranus)
    public static final int _RTCOD_URANUS_1988_IDENTITY = 330;
    /// Global (Uranus)
    public static final int _RTCOD_URANUS_MAGNETIC_1993_VOYAGER = 331;
    /// Global (Venus)
    public static final int _RTCOD_VENUS_1991_IDENTITY = 332;
    /// Viti Levu Island (Fiji Islands)
    public static final int _RTCOD_VITI_LEVU_1916_VITI_LEVU_ISLANDS = 333;
    /// Algeria
    public static final int _RTCOD_VOIROL_1874_ALGERIA = 334;
    /// Algeria
    public static final int _RTCOD_VOIROL_1874_PM_PARIS_ALGERIA = 335;
    /// Algeria
    public static final int _RTCOD_VOIROL_1960_ALGERIA = 336;
    /// Algeria
    public static final int _RTCOD_VOIROL_1960_PM_PARIS_ALGERIA = 337;
   /// Wake Atoll
    public static final int _RTCOD_WAKE_1952_WAKE_ATOLL = 338;
    /// Marshall Islands
    public static final int _RTCOD_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS = 339;
    /// Global (Earth)
    public static final int _RTCOD_WGS_1972_GLOBAL = 340;
    /// Global (Earth)
    public static final int _RTCOD_WGS_1984_IDENTITY = 341;
    /// Uruguay
    public static final int _RTCOD_YACARE_1987_URUGUAY = 342;
    /// Suriname
    public static final int _RTCOD_ZANDERIJ_1987_SURINAME = 343;

    // Added for the NGA Golden Data testing
    public static final int _RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT = -1001;
    // Added for the NGA Golden Data testing
    public static final int _RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT = -1000;

    public static final int _totalEnum = 343;

    private static Vector<SRM_RT_Code> _enumVec = new Vector<SRM_RT_Code>( );

    private static HashMap<String, SRM_RT_Code> _enumMap = new HashMap<String, SRM_RT_Code>( );

    public static final SRM_RT_Code RTCOD_UNSPECIFIED
        = new SRM_RT_Code( _RTCOD_UNSPECIFIED, "RTCOD_UNSPECIFIED" );

    public static final SRM_RT_Code RTCOD_ABSTRACT_2D_IDENTITY
        = new SRM_RT_Code( _RTCOD_ABSTRACT_2D_IDENTITY, "RTCOD_ABSTRACT_2D_IDENTITY" );
    public static final SRM_RT_Code RTCOD_ABSTRACT_3D_IDENTITY
        = new SRM_RT_Code( _RTCOD_ABSTRACT_3D_IDENTITY, "RTCOD_ABSTRACT_3D_IDENTITY" );
    public static final SRM_RT_Code RTCOD_ADINDAN_1991_BURKINA_FASO
        = new SRM_RT_Code( _RTCOD_ADINDAN_1991_BURKINA_FASO, "RTCOD_ADINDAN_1991_BURKINA_FASO" );
    public static final SRM_RT_Code RTCOD_ADINDAN_1991_CAMEROON
        = new SRM_RT_Code( _RTCOD_ADINDAN_1991_CAMEROON, "RTCOD_ADINDAN_1991_CAMEROON" );
    public static final SRM_RT_Code RTCOD_ADINDAN_1991_ETHIOPIA
        = new SRM_RT_Code( _RTCOD_ADINDAN_1991_ETHIOPIA, "RTCOD_ADINDAN_1991_ETHIOPIA" );
    public static final SRM_RT_Code RTCOD_ADINDAN_1991_MALI
        = new SRM_RT_Code( _RTCOD_ADINDAN_1991_MALI, "RTCOD_ADINDAN_1991_MALI" );
    public static final SRM_RT_Code RTCOD_ADINDAN_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_ADINDAN_1991_MEAN_SOLUTION, "RTCOD_ADINDAN_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_ADINDAN_1991_SENEGAL
        = new SRM_RT_Code( _RTCOD_ADINDAN_1991_SENEGAL, "RTCOD_ADINDAN_1991_SENEGAL" );
    public static final SRM_RT_Code RTCOD_ADINDAN_1991_SUDAN
        = new SRM_RT_Code( _RTCOD_ADINDAN_1991_SUDAN, "RTCOD_ADINDAN_1991_SUDAN" );
    public static final SRM_RT_Code RTCOD_ADRASTEA_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_ADRASTEA_2000_IDENTITY, "RTCOD_ADRASTEA_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_AFGOOYE_1987_SOMALIA
        = new SRM_RT_Code( _RTCOD_AFGOOYE_1987_SOMALIA, "RTCOD_AFGOOYE_1987_SOMALIA" );
    public static final SRM_RT_Code RTCOD_AIN_EL_ABD_1970_BAHRAIN_ISLAND
        = new SRM_RT_Code( _RTCOD_AIN_EL_ABD_1970_BAHRAIN_ISLAND, "RTCOD_AIN_EL_ABD_1970_BAHRAIN_ISLAND" );
    public static final SRM_RT_Code RTCOD_AIN_EL_ABD_1970_SAUDI_ARABIA
        = new SRM_RT_Code( _RTCOD_AIN_EL_ABD_1970_SAUDI_ARABIA, "RTCOD_AIN_EL_ABD_1970_SAUDI_ARABIA" );
    public static final SRM_RT_Code RTCOD_AMALTHEA_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_AMALTHEA_2000_IDENTITY, "RTCOD_AMALTHEA_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS
        = new SRM_RT_Code( _RTCOD_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS, "RTCOD_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS" );
    public static final SRM_RT_Code RTCOD_ANNA_1_1965_COCOS_ISLANDS
        = new SRM_RT_Code( _RTCOD_ANNA_1_1965_COCOS_ISLANDS, "RTCOD_ANNA_1_1965_COCOS_ISLANDS" );
    public static final SRM_RT_Code RTCOD_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS
        = new SRM_RT_Code( _RTCOD_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS, "RTCOD_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS" );
    public static final SRM_RT_Code RTCOD_ARC_1950_3_ZIMBABWE
        = new SRM_RT_Code( _RTCOD_ARC_1950_3_ZIMBABWE, "RTCOD_ARC_1950_3_ZIMBABWE" );
    public static final SRM_RT_Code RTCOD_ARC_1950_BOTSWANA
        = new SRM_RT_Code( _RTCOD_ARC_1950_BOTSWANA, "RTCOD_ARC_1950_BOTSWANA" );
    public static final SRM_RT_Code RTCOD_ARC_1950_BURUNDI
        = new SRM_RT_Code( _RTCOD_ARC_1950_BURUNDI, "RTCOD_ARC_1950_BURUNDI" );
    public static final SRM_RT_Code RTCOD_ARC_1950_LESOTHO
        = new SRM_RT_Code( _RTCOD_ARC_1950_LESOTHO, "RTCOD_ARC_1950_LESOTHO" );
    public static final SRM_RT_Code RTCOD_ARC_1950_MALAWI
        = new SRM_RT_Code( _RTCOD_ARC_1950_MALAWI, "RTCOD_ARC_1950_MALAWI" );
    public static final SRM_RT_Code RTCOD_ARC_1950_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_ARC_1950_MEAN_SOLUTION, "RTCOD_ARC_1950_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_ARC_1950_SWAZILAND
        = new SRM_RT_Code( _RTCOD_ARC_1950_SWAZILAND, "RTCOD_ARC_1950_SWAZILAND" );
    public static final SRM_RT_Code RTCOD_ARC_1950_ZAIRE
        = new SRM_RT_Code( _RTCOD_ARC_1950_ZAIRE, "RTCOD_ARC_1950_ZAIRE" );
    public static final SRM_RT_Code RTCOD_ARC_1950_ZAMBIA
        = new SRM_RT_Code( _RTCOD_ARC_1950_ZAMBIA, "RTCOD_ARC_1950_ZAMBIA" );
    public static final SRM_RT_Code RTCOD_ARC_1960_3_KENYA
        = new SRM_RT_Code( _RTCOD_ARC_1960_3_KENYA, "RTCOD_ARC_1960_3_KENYA" );
    public static final SRM_RT_Code RTCOD_ARC_1960_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_ARC_1960_MEAN_SOLUTION, "RTCOD_ARC_1960_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_ARC_1960_TANZANIA
        = new SRM_RT_Code( _RTCOD_ARC_1960_TANZANIA, "RTCOD_ARC_1960_TANZANIA" );
    public static final SRM_RT_Code RTCOD_ARIEL_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_ARIEL_1988_IDENTITY, "RTCOD_ARIEL_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_ASCENSION_1958_ASCENSION_ISLAND
        = new SRM_RT_Code( _RTCOD_ASCENSION_1958_ASCENSION_ISLAND, "RTCOD_ASCENSION_1958_ASCENSION_ISLAND" );
    public static final SRM_RT_Code RTCOD_ATLAS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_ATLAS_1988_IDENTITY, "RTCOD_ATLAS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA
        = new SRM_RT_Code( _RTCOD_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA, "RTCOD_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA" );
    public static final SRM_RT_Code RTCOD_AUSTRALIA_GEOD_1984_3_AUSTRALIA_TASMANIA
        = new SRM_RT_Code( _RTCOD_AUSTRALIA_GEOD_1984_3_AUSTRALIA_TASMANIA, "RTCOD_AUSTRALIA_GEOD_1984_3_AUSTRALIA_TASMANIA" );
    public static final SRM_RT_Code RTCOD_AUSTRALIA_GEOD_1984_7_AUSTRALIA_TASMANIA
        = new SRM_RT_Code( _RTCOD_AUSTRALIA_GEOD_1984_7_AUSTRALIA_TASMANIA, "RTCOD_AUSTRALIA_GEOD_1984_7_AUSTRALIA_TASMANIA" );
    public static final SRM_RT_Code RTCOD_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI
        = new SRM_RT_Code( _RTCOD_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI, "RTCOD_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI" );
    public static final SRM_RT_Code RTCOD_BEACON_E_1945_IWO_JIMA_ISLAND
        = new SRM_RT_Code( _RTCOD_BEACON_E_1945_IWO_JIMA_ISLAND, "RTCOD_BEACON_E_1945_IWO_JIMA_ISLAND" );
    public static final SRM_RT_Code RTCOD_BELINDA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_BELINDA_1988_IDENTITY, "RTCOD_BELINDA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS
        = new SRM_RT_Code( _RTCOD_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS, "RTCOD_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS" );
    public static final SRM_RT_Code RTCOD_BERMUDA_1957_BERMUDA
        = new SRM_RT_Code( _RTCOD_BERMUDA_1957_BERMUDA, "RTCOD_BERMUDA_1957_BERMUDA" );
    public static final SRM_RT_Code RTCOD_BIANCA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_BIANCA_1988_IDENTITY, "RTCOD_BIANCA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_BISSAU_1991_GUINEA_BISSAU
        = new SRM_RT_Code( _RTCOD_BISSAU_1991_GUINEA_BISSAU, "RTCOD_BISSAU_1991_GUINEA_BISSAU" );
    public static final SRM_RT_Code RTCOD_BOGOTA_OBS_1987_COLOMBIA
        = new SRM_RT_Code( _RTCOD_BOGOTA_OBS_1987_COLOMBIA, "RTCOD_BOGOTA_OBS_1987_COLOMBIA" );
    public static final SRM_RT_Code RTCOD_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA
        = new SRM_RT_Code( _RTCOD_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA, "RTCOD_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA" );
    public static final SRM_RT_Code RTCOD_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS
        = new SRM_RT_Code( _RTCOD_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS, "RTCOD_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS" );
    public static final SRM_RT_Code RTCOD_CALLISTO_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_CALLISTO_2000_IDENTITY, "RTCOD_CALLISTO_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_CALYPSO_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_CALYPSO_1988_IDENTITY, "RTCOD_CALYPSO_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_CAMP_AREA_1987_MCMURDO_CAMP
        = new SRM_RT_Code( _RTCOD_CAMP_AREA_1987_MCMURDO_CAMP, "RTCOD_CAMP_AREA_1987_MCMURDO_CAMP" );
    public static final SRM_RT_Code RTCOD_CAMPO_INCHAUSPE_1969_ARGENTINA
        = new SRM_RT_Code( _RTCOD_CAMPO_INCHAUSPE_1969_ARGENTINA, "RTCOD_CAMPO_INCHAUSPE_1969_ARGENTINA" );
    public static final SRM_RT_Code RTCOD_CANTON_1966_PHOENIX_ISLANDS
        = new SRM_RT_Code( _RTCOD_CANTON_1966_PHOENIX_ISLANDS, "RTCOD_CANTON_1966_PHOENIX_ISLANDS" );
    public static final SRM_RT_Code RTCOD_CAPE_1987_SOUTH_AFRICA
        = new SRM_RT_Code( _RTCOD_CAPE_1987_SOUTH_AFRICA, "RTCOD_CAPE_1987_SOUTH_AFRICA" );
    public static final SRM_RT_Code RTCOD_CAPE_CANAVERAL_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_CAPE_CANAVERAL_1991_MEAN_SOLUTION, "RTCOD_CAPE_CANAVERAL_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_CARTHAGE_1987_TUNISIA
        = new SRM_RT_Code( _RTCOD_CARTHAGE_1987_TUNISIA, "RTCOD_CARTHAGE_1987_TUNISIA" );
    public static final SRM_RT_Code RTCOD_CHARON_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_CHARON_1991_IDENTITY, "RTCOD_CHARON_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_CHATHAM_1971_CHATHAM_ISLANDS
        = new SRM_RT_Code( _RTCOD_CHATHAM_1971_CHATHAM_ISLANDS, "RTCOD_CHATHAM_1971_CHATHAM_ISLANDS" );
    public static final SRM_RT_Code RTCOD_CHUA_1987_PARAGUAY
        = new SRM_RT_Code( _RTCOD_CHUA_1987_PARAGUAY, "RTCOD_CHUA_1987_PARAGUAY" );
    public static final SRM_RT_Code RTCOD_COAMPS_1998_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_COAMPS_1998_IDENTITY_BY_DEFAULT, "RTCOD_COAMPS_1998_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_CORDELIA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_CORDELIA_1988_IDENTITY, "RTCOD_CORDELIA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_CORREGO_ALEGRE_1987_BRAZIL
        = new SRM_RT_Code( _RTCOD_CORREGO_ALEGRE_1987_BRAZIL, "RTCOD_CORREGO_ALEGRE_1987_BRAZIL" );
    public static final SRM_RT_Code RTCOD_CRESSIDA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_CRESSIDA_1988_IDENTITY, "RTCOD_CRESSIDA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_DABOLA_1991_GUINEA
        = new SRM_RT_Code( _RTCOD_DABOLA_1991_GUINEA, "RTCOD_DABOLA_1991_GUINEA" );
    public static final SRM_RT_Code RTCOD_DECEPTION_1993_DECEPTION_ISLAND
        = new SRM_RT_Code( _RTCOD_DECEPTION_1993_DECEPTION_ISLAND, "RTCOD_DECEPTION_1993_DECEPTION_ISLAND" );
    public static final SRM_RT_Code RTCOD_DEIMOS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_DEIMOS_1988_IDENTITY, "RTCOD_DEIMOS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_DESDEMONA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_DESDEMONA_1988_IDENTITY, "RTCOD_DESDEMONA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_DESPINA_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_DESPINA_1991_IDENTITY, "RTCOD_DESPINA_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_DIONE_1982_IDENTITY
        = new SRM_RT_Code( _RTCOD_DIONE_1982_IDENTITY, "RTCOD_DIONE_1982_IDENTITY" );
    public static final SRM_RT_Code RTCOD_DJAKARTA_1987_PM_DJAKARTA_SUMATRA
        = new SRM_RT_Code( _RTCOD_DJAKARTA_1987_PM_DJAKARTA_SUMATRA, "RTCOD_DJAKARTA_1987_PM_DJAKARTA_SUMATRA" );
    public static final SRM_RT_Code RTCOD_DJAKARTA_1987_SUMATRA
        = new SRM_RT_Code( _RTCOD_DJAKARTA_1987_SUMATRA, "RTCOD_DJAKARTA_1987_SUMATRA" );
    public static final SRM_RT_Code RTCOD_DOS_1968_GIZO_ISLAND
        = new SRM_RT_Code( _RTCOD_DOS_1968_GIZO_ISLAND, "RTCOD_DOS_1968_GIZO_ISLAND" );
    public static final SRM_RT_Code RTCOD_DOS_71_4_1987_ST_HELENA_ISLAND
        = new SRM_RT_Code( _RTCOD_DOS_71_4_1987_ST_HELENA_ISLAND, "RTCOD_DOS_71_4_1987_ST_HELENA_ISLAND" );
    public static final SRM_RT_Code RTCOD_EASTER_1967_EASTER_ISLAND
        = new SRM_RT_Code( _RTCOD_EASTER_1967_EASTER_ISLAND, "RTCOD_EASTER_1967_EASTER_ISLAND" );
    public static final SRM_RT_Code RTCOD_ENCELADUS_1994_IDENTITY
        = new SRM_RT_Code( _RTCOD_ENCELADUS_1994_IDENTITY, "RTCOD_ENCELADUS_1994_IDENTITY" );
    public static final SRM_RT_Code RTCOD_EPIMETHEUS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_EPIMETHEUS_1988_IDENTITY, "RTCOD_EPIMETHEUS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_EROS_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_EROS_2000_IDENTITY, "RTCOD_EROS_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_ESTONIA_1937_ESTONIA
        = new SRM_RT_Code( _RTCOD_ESTONIA_1937_ESTONIA, "RTCOD_ESTONIA_1937_ESTONIA" );
    public static final SRM_RT_Code RTCOD_ETRS_1989_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RTCOD_ETRS_1989_IDENTITY_BY_MEASUREMENT, "RTCOD_ETRS_1989_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RTCOD_EUROPA_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_EUROPA_2000_IDENTITY, "RTCOD_EUROPA_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_3_CYPRUS
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_3_CYPRUS, "RTCOD_EUROPE_1950_3_CYPRUS" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_CHANNEL_ISLANDS
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_CHANNEL_ISLANDS, "RTCOD_EUROPE_1950_CHANNEL_ISLANDS" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_EGYPT
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_EGYPT, "RTCOD_EUROPE_1950_EGYPT" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_ENGLAND_SCOTLAND
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_ENGLAND_SCOTLAND, "RTCOD_EUROPE_1950_ENGLAND_SCOTLAND" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_GREECE
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_GREECE, "RTCOD_EUROPE_1950_GREECE" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_IRAN
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_IRAN, "RTCOD_EUROPE_1950_IRAN" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_IRAQ
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_IRAQ, "RTCOD_EUROPE_1950_IRAQ" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_IRELAND
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_IRELAND, "RTCOD_EUROPE_1950_IRELAND" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_MALTA
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_MALTA, "RTCOD_EUROPE_1950_MALTA" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_MEAN_SOLUTION, "RTCOD_EUROPE_1950_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_NORWAY
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_NORWAY, "RTCOD_EUROPE_1950_NORWAY" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_PORTUGAL_SPAIN
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_PORTUGAL_SPAIN, "RTCOD_EUROPE_1950_PORTUGAL_SPAIN" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_SARDINIA
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_SARDINIA, "RTCOD_EUROPE_1950_SARDINIA" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_SICILY
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_SICILY, "RTCOD_EUROPE_1950_SICILY" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_TUNISIA
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_TUNISIA, "RTCOD_EUROPE_1950_TUNISIA" );
    public static final SRM_RT_Code RTCOD_EUROPE_1950_W_EUROPE_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_EUROPE_1950_W_EUROPE_MEAN_SOLUTION, "RTCOD_EUROPE_1950_W_EUROPE_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_EUROPE_1979_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_EUROPE_1979_MEAN_SOLUTION, "RTCOD_EUROPE_1979_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_FAHUD_1987_3_OMAN
        = new SRM_RT_Code( _RTCOD_FAHUD_1987_3_OMAN, "RTCOD_FAHUD_1987_3_OMAN" );
    public static final SRM_RT_Code RTCOD_FAHUD_1987_7_OMAN
        = new SRM_RT_Code( _RTCOD_FAHUD_1987_7_OMAN, "RTCOD_FAHUD_1987_7_OMAN" );
    public static final SRM_RT_Code RTCOD_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS
        = new SRM_RT_Code( _RTCOD_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS, "RTCOD_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS" );
    public static final SRM_RT_Code RTCOD_GALATEA_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_GALATEA_1991_IDENTITY, "RTCOD_GALATEA_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_GAN_1970_MALDIVES
        = new SRM_RT_Code( _RTCOD_GAN_1970_MALDIVES, "RTCOD_GAN_1970_MALDIVES" );
    public static final SRM_RT_Code RTCOD_GANYMEDE_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_GANYMEDE_2000_IDENTITY, "RTCOD_GANYMEDE_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_GASPRA_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_GASPRA_1991_IDENTITY, "RTCOD_GASPRA_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_GDA_1994_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RTCOD_GDA_1994_IDENTITY_BY_MEASUREMENT, "RTCOD_GDA_1994_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RTCOD_GEODETIC_DATUM_1949_3_NEW_ZEALAND
        = new SRM_RT_Code( _RTCOD_GEODETIC_DATUM_1949_3_NEW_ZEALAND, "RTCOD_GEODETIC_DATUM_1949_3_NEW_ZEALAND" );
    public static final SRM_RT_Code RTCOD_GEODETIC_DATUM_1949_7_NEW_ZEALAND
        = new SRM_RT_Code( _RTCOD_GEODETIC_DATUM_1949_7_NEW_ZEALAND, "RTCOD_GEODETIC_DATUM_1949_7_NEW_ZEALAND" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1945_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1945_DGRF, "RTCOD_GEOMAGNETIC_1945_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1950_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1950_DGRF, "RTCOD_GEOMAGNETIC_1950_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1955_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1955_DGRF, "RTCOD_GEOMAGNETIC_1955_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1960_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1960_DGRF, "RTCOD_GEOMAGNETIC_1960_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1965_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1965_DGRF, "RTCOD_GEOMAGNETIC_1965_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1970_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1970_DGRF, "RTCOD_GEOMAGNETIC_1970_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1975_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1975_DGRF, "RTCOD_GEOMAGNETIC_1975_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1980_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1980_DGRF, "RTCOD_GEOMAGNETIC_1980_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1985_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1985_DGRF, "RTCOD_GEOMAGNETIC_1985_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1990_DGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1990_DGRF, "RTCOD_GEOMAGNETIC_1990_DGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_1995_IGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_1995_IGRF, "RTCOD_GEOMAGNETIC_1995_IGRF" );
    public static final SRM_RT_Code RTCOD_GEOMAGNETIC_2000_IGRF
        = new SRM_RT_Code( _RTCOD_GEOMAGNETIC_2000_IGRF, "RTCOD_GEOMAGNETIC_2000_IGRF" );
    public static final SRM_RT_Code RTCOD_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES
        = new SRM_RT_Code( _RTCOD_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES, "RTCOD_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES" );
    public static final SRM_RT_Code RTCOD_GUAM_1963_GUAM
        = new SRM_RT_Code( _RTCOD_GUAM_1963_GUAM, "RTCOD_GUAM_1963_GUAM" );
    public static final SRM_RT_Code RTCOD_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND
        = new SRM_RT_Code( _RTCOD_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND, "RTCOD_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND" );
    public static final SRM_RT_Code RTCOD_GUX_1_1987_GUADALCANAL_ISLAND
        = new SRM_RT_Code( _RTCOD_GUX_1_1987_GUADALCANAL_ISLAND, "RTCOD_GUX_1_1987_GUADALCANAL_ISLAND" );
    public static final SRM_RT_Code RTCOD_HELENE_1992_IDENTITY
        = new SRM_RT_Code( _RTCOD_HELENE_1992_IDENTITY, "RTCOD_HELENE_1992_IDENTITY" );
    public static final SRM_RT_Code RTCOD_HERAT_NORTH_1987_AFGHANISTAN
        = new SRM_RT_Code( _RTCOD_HERAT_NORTH_1987_AFGHANISTAN, "RTCOD_HERAT_NORTH_1987_AFGHANISTAN" );
    public static final SRM_RT_Code RTCOD_HERMANNSKOGEL_1871_3_YUGOSLAVIA
        = new SRM_RT_Code( _RTCOD_HERMANNSKOGEL_1871_3_YUGOSLAVIA, "RTCOD_HERMANNSKOGEL_1871_3_YUGOSLAVIA" );
    public static final SRM_RT_Code RTCOD_HJORSEY_1955_ICELAND
        = new SRM_RT_Code( _RTCOD_HJORSEY_1955_ICELAND, "RTCOD_HJORSEY_1955_ICELAND" );
    public static final SRM_RT_Code RTCOD_HONG_KONG_1963_HONG_KONG
        = new SRM_RT_Code( _RTCOD_HONG_KONG_1963_HONG_KONG, "RTCOD_HONG_KONG_1963_HONG_KONG" );
    public static final SRM_RT_Code RTCOD_HU_TZU_SHAN_1991_TAIWAN
        = new SRM_RT_Code( _RTCOD_HU_TZU_SHAN_1991_TAIWAN, "RTCOD_HU_TZU_SHAN_1991_TAIWAN" );
    public static final SRM_RT_Code RTCOD_IAPETUS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_IAPETUS_1988_IDENTITY, "RTCOD_IAPETUS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_IDA_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_IDA_1991_IDENTITY, "RTCOD_IDA_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_INDIAN_1916_3_BANGLADESH
        = new SRM_RT_Code( _RTCOD_INDIAN_1916_3_BANGLADESH, "RTCOD_INDIAN_1916_3_BANGLADESH" );
    public static final SRM_RT_Code RTCOD_INDIAN_1916_7_BANGLADESH
        = new SRM_RT_Code( _RTCOD_INDIAN_1916_7_BANGLADESH, "RTCOD_INDIAN_1916_7_BANGLADESH" );
    public static final SRM_RT_Code RTCOD_INDIAN_1954_THAILAND
        = new SRM_RT_Code( _RTCOD_INDIAN_1954_THAILAND, "RTCOD_INDIAN_1954_THAILAND" );
    public static final SRM_RT_Code RTCOD_INDIAN_1956_INDIA_NEPAL
        = new SRM_RT_Code( _RTCOD_INDIAN_1956_INDIA_NEPAL, "RTCOD_INDIAN_1956_INDIA_NEPAL" );
    public static final SRM_RT_Code RTCOD_INDIAN_1960_CON_SON_ISLAND
        = new SRM_RT_Code( _RTCOD_INDIAN_1960_CON_SON_ISLAND, "RTCOD_INDIAN_1960_CON_SON_ISLAND" );
    public static final SRM_RT_Code RTCOD_INDIAN_1960_VIETNAM_16_N
        = new SRM_RT_Code( _RTCOD_INDIAN_1960_VIETNAM_16_N, "RTCOD_INDIAN_1960_VIETNAM_16_N" );
    public static final SRM_RT_Code RTCOD_INDIAN_1962_PAKISTAN
        = new SRM_RT_Code( _RTCOD_INDIAN_1962_PAKISTAN, "RTCOD_INDIAN_1962_PAKISTAN" );
    public static final SRM_RT_Code RTCOD_INDIAN_1975_1991_THAILAND
        = new SRM_RT_Code( _RTCOD_INDIAN_1975_1991_THAILAND, "RTCOD_INDIAN_1975_1991_THAILAND" );
    public static final SRM_RT_Code RTCOD_INDIAN_1975_1997_THAILAND
        = new SRM_RT_Code( _RTCOD_INDIAN_1975_1997_THAILAND, "RTCOD_INDIAN_1975_1997_THAILAND" );
    public static final SRM_RT_Code RTCOD_INDONESIAN_1974_INDONESIA
        = new SRM_RT_Code( _RTCOD_INDONESIAN_1974_INDONESIA, "RTCOD_INDONESIAN_1974_INDONESIA" );
    public static final SRM_RT_Code RTCOD_IO_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_IO_2000_IDENTITY, "RTCOD_IO_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_IRELAND_1965_3_IRELAND
        = new SRM_RT_Code( _RTCOD_IRELAND_1965_3_IRELAND, "RTCOD_IRELAND_1965_3_IRELAND" );
    public static final SRM_RT_Code RTCOD_IRELAND_1965_7_IRELAND
        = new SRM_RT_Code( _RTCOD_IRELAND_1965_7_IRELAND, "RTCOD_IRELAND_1965_7_IRELAND" );
    public static final SRM_RT_Code RTCOD_ISTS_061_1968_SOUTH_GEORGIA_ISLAND
        = new SRM_RT_Code( _RTCOD_ISTS_061_1968_SOUTH_GEORGIA_ISLAND, "RTCOD_ISTS_061_1968_SOUTH_GEORGIA_ISLAND" );
    public static final SRM_RT_Code RTCOD_ISTS_073_1969_DIEGO_GARCIA
        = new SRM_RT_Code( _RTCOD_ISTS_073_1969_DIEGO_GARCIA, "RTCOD_ISTS_073_1969_DIEGO_GARCIA" );
    public static final SRM_RT_Code RTCOD_JANUS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_JANUS_1988_IDENTITY, "RTCOD_JANUS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_JGD_2000_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RTCOD_JGD_2000_IDENTITY_BY_MEASUREMENT, "RTCOD_JGD_2000_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RTCOD_JOHNSTON_1961_JOHNSTON_ISLAND
        = new SRM_RT_Code( _RTCOD_JOHNSTON_1961_JOHNSTON_ISLAND, "RTCOD_JOHNSTON_1961_JOHNSTON_ISLAND" );
    public static final SRM_RT_Code RTCOD_JULIET_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_JULIET_1988_IDENTITY, "RTCOD_JULIET_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_JUPITER_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_JUPITER_1988_IDENTITY, "RTCOD_JUPITER_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_JUPITER_MAGNETIC_1993_VOYAGER
        = new SRM_RT_Code( _RTCOD_JUPITER_MAGNETIC_1993_VOYAGER, "RTCOD_JUPITER_MAGNETIC_1993_VOYAGER" );
    public static final SRM_RT_Code RTCOD_KANDAWALA_1987_3_SRI_LANKA
        = new SRM_RT_Code( _RTCOD_KANDAWALA_1987_3_SRI_LANKA, "RTCOD_KANDAWALA_1987_3_SRI_LANKA" );
    public static final SRM_RT_Code RTCOD_KERGUELEN_1949_KERGUELEN_ISLAND
        = new SRM_RT_Code( _RTCOD_KERGUELEN_1949_KERGUELEN_ISLAND, "RTCOD_KERGUELEN_1949_KERGUELEN_ISLAND" );
    public static final SRM_RT_Code RTCOD_KERTAU_1948_3_W_MALAYSIA_SINGAPORE
        = new SRM_RT_Code( _RTCOD_KERTAU_1948_3_W_MALAYSIA_SINGAPORE, "RTCOD_KERTAU_1948_3_W_MALAYSIA_SINGAPORE" );
    public static final SRM_RT_Code RTCOD_KOREAN_GEODETIC_1995_SOUTH_KOREA
        = new SRM_RT_Code( _RTCOD_KOREAN_GEODETIC_1995_SOUTH_KOREA, "RTCOD_KOREAN_GEODETIC_1995_SOUTH_KOREA" );
    public static final SRM_RT_Code RTCOD_KUSAIE_1951_CAROLINE_ISLANDS
        = new SRM_RT_Code( _RTCOD_KUSAIE_1951_CAROLINE_ISLANDS, "RTCOD_KUSAIE_1951_CAROLINE_ISLANDS" );
    public static final SRM_RT_Code RTCOD_LARISSA_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_LARISSA_1991_IDENTITY, "RTCOD_LARISSA_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_LC5_1961_CAYMAN_BRAC_ISLAND
        = new SRM_RT_Code( _RTCOD_LC5_1961_CAYMAN_BRAC_ISLAND, "RTCOD_LC5_1961_CAYMAN_BRAC_ISLAND" );
    public static final SRM_RT_Code RTCOD_LEIGON_1991_3_GHANA
        = new SRM_RT_Code( _RTCOD_LEIGON_1991_3_GHANA, "RTCOD_LEIGON_1991_3_GHANA" );
    public static final SRM_RT_Code RTCOD_LEIGON_1991_7_GHANA
        = new SRM_RT_Code( _RTCOD_LEIGON_1991_7_GHANA, "RTCOD_LEIGON_1991_7_GHANA" );
    public static final SRM_RT_Code RTCOD_LIBERIA_1964_LIBERIA
        = new SRM_RT_Code( _RTCOD_LIBERIA_1964_LIBERIA, "RTCOD_LIBERIA_1964_LIBERIA" );
    public static final SRM_RT_Code RTCOD_LUZON_1987_MINDANAO_ISLAND
        = new SRM_RT_Code( _RTCOD_LUZON_1987_MINDANAO_ISLAND, "RTCOD_LUZON_1987_MINDANAO_ISLAND" );
    public static final SRM_RT_Code RTCOD_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND
        = new SRM_RT_Code( _RTCOD_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND, "RTCOD_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND" );
    public static final SRM_RT_Code RTCOD_M_PORALOKO_1991_GABON
        = new SRM_RT_Code( _RTCOD_M_PORALOKO_1991_GABON, "RTCOD_M_PORALOKO_1991_GABON" );
    public static final SRM_RT_Code RTCOD_MAHE_1971_MAHE_ISLAND
        = new SRM_RT_Code( _RTCOD_MAHE_1971_MAHE_ISLAND, "RTCOD_MAHE_1971_MAHE_ISLAND" );
    public static final SRM_RT_Code RTCOD_MARCUS_STATION_1952_MARCUS_ISLANDS
        = new SRM_RT_Code( _RTCOD_MARCUS_STATION_1952_MARCUS_ISLANDS, "RTCOD_MARCUS_STATION_1952_MARCUS_ISLANDS" );
    public static final SRM_RT_Code RTCOD_MARS_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_MARS_2000_IDENTITY, "RTCOD_MARS_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_MARS_SPHERE_2000_GLOBAL
        = new SRM_RT_Code( _RTCOD_MARS_SPHERE_2000_GLOBAL, "RTCOD_MARS_SPHERE_2000_GLOBAL" );
    public static final SRM_RT_Code RTCOD_MASS_1999_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MASS_1999_IDENTITY_BY_DEFAULT, "RTCOD_MASS_1999_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_MASSAWA_1987_ERITREA_ETHIOPIA
        = new SRM_RT_Code( _RTCOD_MASSAWA_1987_ERITREA_ETHIOPIA, "RTCOD_MASSAWA_1987_ERITREA_ETHIOPIA" );
    public static final SRM_RT_Code RTCOD_MERCHICH_1987_MOROCCO
        = new SRM_RT_Code( _RTCOD_MERCHICH_1987_MOROCCO, "RTCOD_MERCHICH_1987_MOROCCO" );
    public static final SRM_RT_Code RTCOD_MERCURY_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_MERCURY_1988_IDENTITY, "RTCOD_MERCURY_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_METIS_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_METIS_2000_IDENTITY, "RTCOD_METIS_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_MIDWAY_1961_MIDWAY_ISLANDS
        = new SRM_RT_Code( _RTCOD_MIDWAY_1961_MIDWAY_ISLANDS, "RTCOD_MIDWAY_1961_MIDWAY_ISLANDS" );
    public static final SRM_RT_Code RTCOD_MIMAS_1994_IDENTITY
        = new SRM_RT_Code( _RTCOD_MIMAS_1994_IDENTITY, "RTCOD_MIMAS_1994_IDENTITY" );
    public static final SRM_RT_Code RTCOD_MINNA_1991_CAMEROON
        = new SRM_RT_Code( _RTCOD_MINNA_1991_CAMEROON, "RTCOD_MINNA_1991_CAMEROON" );
    public static final SRM_RT_Code RTCOD_MINNA_1991_NIGERIA
        = new SRM_RT_Code( _RTCOD_MINNA_1991_NIGERIA, "RTCOD_MINNA_1991_NIGERIA" );
    public static final SRM_RT_Code RTCOD_MIRANDA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_MIRANDA_1988_IDENTITY, "RTCOD_MIRANDA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_MM5_1997_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MM5_1997_IDENTITY_BY_DEFAULT, "RTCOD_MM5_1997_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT, "RTCOD_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT, "RTCOD_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT, "RTCOD_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT, "RTCOD_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT, "RTCOD_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS
        = new SRM_RT_Code( _RTCOD_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS, "RTCOD_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS" );
    public static final SRM_RT_Code RTCOD_MOON_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_MOON_1991_IDENTITY, "RTCOD_MOON_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT, "RTCOD_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RTCOD_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS, "RTCOD_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_ALBERTA_BRITISH_COLUMBIA
        = new SRM_RT_Code( _RTCOD_N_AM_1927_ALBERTA_BRITISH_COLUMBIA, "RTCOD_N_AM_1927_ALBERTA_BRITISH_COLUMBIA" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND
        = new SRM_RT_Code( _RTCOD_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND, "RTCOD_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_CANADA
        = new SRM_RT_Code( _RTCOD_N_AM_1927_CANADA, "RTCOD_N_AM_1927_CANADA" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_CANAL_ZONE
        = new SRM_RT_Code( _RTCOD_N_AM_1927_CANAL_ZONE, "RTCOD_N_AM_1927_CANAL_ZONE" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_CARIBBEAN
        = new SRM_RT_Code( _RTCOD_N_AM_1927_CARIBBEAN, "RTCOD_N_AM_1927_CARIBBEAN" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_CENTRAL_AMERICA
        = new SRM_RT_Code( _RTCOD_N_AM_1927_CENTRAL_AMERICA, "RTCOD_N_AM_1927_CENTRAL_AMERICA" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_CONTINENTAL_US
        = new SRM_RT_Code( _RTCOD_N_AM_1927_CONTINENTAL_US, "RTCOD_N_AM_1927_CONTINENTAL_US" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_CUBA
        = new SRM_RT_Code( _RTCOD_N_AM_1927_CUBA, "RTCOD_N_AM_1927_CUBA" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_EAST_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RTCOD_N_AM_1927_EAST_ALEUTIAN_ISLANDS, "RTCOD_N_AM_1927_EAST_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_EASTERN_CANADA
        = new SRM_RT_Code( _RTCOD_N_AM_1927_EASTERN_CANADA, "RTCOD_N_AM_1927_EASTERN_CANADA" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_EASTERN_US
        = new SRM_RT_Code( _RTCOD_N_AM_1927_EASTERN_US, "RTCOD_N_AM_1927_EASTERN_US" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_HAYES_PENINSULA
        = new SRM_RT_Code( _RTCOD_N_AM_1927_HAYES_PENINSULA, "RTCOD_N_AM_1927_HAYES_PENINSULA" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_MANITOBA_ONTARIO
        = new SRM_RT_Code( _RTCOD_N_AM_1927_MANITOBA_ONTARIO, "RTCOD_N_AM_1927_MANITOBA_ONTARIO" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_MEXICO
        = new SRM_RT_Code( _RTCOD_N_AM_1927_MEXICO, "RTCOD_N_AM_1927_MEXICO" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN
        = new SRM_RT_Code( _RTCOD_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN, "RTCOD_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_SAN_SALVADOR_ISLAND
        = new SRM_RT_Code( _RTCOD_N_AM_1927_SAN_SALVADOR_ISLAND, "RTCOD_N_AM_1927_SAN_SALVADOR_ISLAND" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_WEST_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RTCOD_N_AM_1927_WEST_ALEUTIAN_ISLANDS, "RTCOD_N_AM_1927_WEST_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_WESTERN_US
        = new SRM_RT_Code( _RTCOD_N_AM_1927_WESTERN_US, "RTCOD_N_AM_1927_WESTERN_US" );
    public static final SRM_RT_Code RTCOD_N_AM_1927_YUKON
        = new SRM_RT_Code( _RTCOD_N_AM_1927_YUKON, "RTCOD_N_AM_1927_YUKON" );
    public static final SRM_RT_Code RTCOD_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RTCOD_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS, "RTCOD_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RTCOD_N_AM_1983_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RTCOD_N_AM_1983_ALEUTIAN_ISLANDS, "RTCOD_N_AM_1983_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RTCOD_N_AM_1983_CANADA
        = new SRM_RT_Code( _RTCOD_N_AM_1983_CANADA, "RTCOD_N_AM_1983_CANADA" );
    public static final SRM_RT_Code RTCOD_N_AM_1983_CONTINENTAL_US
        = new SRM_RT_Code( _RTCOD_N_AM_1983_CONTINENTAL_US, "RTCOD_N_AM_1983_CONTINENTAL_US" );
    public static final SRM_RT_Code RTCOD_N_AM_1983_HAWAII
        = new SRM_RT_Code( _RTCOD_N_AM_1983_HAWAII, "RTCOD_N_AM_1983_HAWAII" );
    public static final SRM_RT_Code RTCOD_N_AM_1983_MEXICO_CENTRAL_AMERICA
        = new SRM_RT_Code( _RTCOD_N_AM_1983_MEXICO_CENTRAL_AMERICA, "RTCOD_N_AM_1983_MEXICO_CENTRAL_AMERICA" );
    public static final SRM_RT_Code RTCOD_N_SAHARA_1959_ALGERIA
        = new SRM_RT_Code( _RTCOD_N_SAHARA_1959_ALGERIA, "RTCOD_N_SAHARA_1959_ALGERIA" );
    public static final SRM_RT_Code RTCOD_NAHRWAN_1987_MASIRAH_ISLAND
        = new SRM_RT_Code( _RTCOD_NAHRWAN_1987_MASIRAH_ISLAND, "RTCOD_NAHRWAN_1987_MASIRAH_ISLAND" );
    public static final SRM_RT_Code RTCOD_NAHRWAN_1987_SAUDI_ARABIA
        = new SRM_RT_Code( _RTCOD_NAHRWAN_1987_SAUDI_ARABIA, "RTCOD_NAHRWAN_1987_SAUDI_ARABIA" );
    public static final SRM_RT_Code RTCOD_NAHRWAN_1987_UNITED_ARAB_EMIRATES
        = new SRM_RT_Code( _RTCOD_NAHRWAN_1987_UNITED_ARAB_EMIRATES, "RTCOD_NAHRWAN_1987_UNITED_ARAB_EMIRATES" );
    public static final SRM_RT_Code RTCOD_NAIAD_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_NAIAD_1991_IDENTITY, "RTCOD_NAIAD_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_NAPARIMA_1991_TRINIDAD_TOBAGO
        = new SRM_RT_Code( _RTCOD_NAPARIMA_1991_TRINIDAD_TOBAGO, "RTCOD_NAPARIMA_1991_TRINIDAD_TOBAGO" );
    public static final SRM_RT_Code RTCOD_NEPTUNE_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_NEPTUNE_1991_IDENTITY, "RTCOD_NEPTUNE_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_NEPTUNE_MAGNETIC_1993_VOYAGER
        = new SRM_RT_Code( _RTCOD_NEPTUNE_MAGNETIC_1993_VOYAGER, "RTCOD_NEPTUNE_MAGNETIC_1993_VOYAGER" );
    public static final SRM_RT_Code RTCOD_NOGAPS_1988_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_NOGAPS_1988_IDENTITY_BY_DEFAULT, "RTCOD_NOGAPS_1988_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_NTF_1896_FRANCE
        = new SRM_RT_Code( _RTCOD_NTF_1896_FRANCE, "RTCOD_NTF_1896_FRANCE" );
    public static final SRM_RT_Code RTCOD_NTF_1896_PM_PARIS_FRANCE
        = new SRM_RT_Code( _RTCOD_NTF_1896_PM_PARIS_FRANCE, "RTCOD_NTF_1896_PM_PARIS_FRANCE" );
    public static final SRM_RT_Code RTCOD_OBERON_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_OBERON_1988_IDENTITY, "RTCOD_OBERON_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS
        = new SRM_RT_Code( _RTCOD_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS, "RTCOD_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS" );
    public static final SRM_RT_Code RTCOD_OLD_EGYPTIAN_1907_EGYPT
        = new SRM_RT_Code( _RTCOD_OLD_EGYPTIAN_1907_EGYPT, "RTCOD_OLD_EGYPTIAN_1907_EGYPT" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_C_1987_HAWAII
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_C_1987_HAWAII, "RTCOD_OLD_HAWAII_C_1987_HAWAII" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_C_1987_KAUAI
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_C_1987_KAUAI, "RTCOD_OLD_HAWAII_C_1987_KAUAI" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_C_1987_MAUI
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_C_1987_MAUI, "RTCOD_OLD_HAWAII_C_1987_MAUI" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_C_1987_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_C_1987_MEAN_SOLUTION, "RTCOD_OLD_HAWAII_C_1987_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_C_1987_OAHU
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_C_1987_OAHU, "RTCOD_OLD_HAWAII_C_1987_OAHU" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_I_1987_HAWAII
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_I_1987_HAWAII, "RTCOD_OLD_HAWAII_I_1987_HAWAII" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_I_1987_KAUAI
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_I_1987_KAUAI, "RTCOD_OLD_HAWAII_I_1987_KAUAI" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_I_1987_MAUI
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_I_1987_MAUI, "RTCOD_OLD_HAWAII_I_1987_MAUI" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_I_1987_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_I_1987_MEAN_SOLUTION, "RTCOD_OLD_HAWAII_I_1987_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_OLD_HAWAII_I_1987_OAHU
        = new SRM_RT_Code( _RTCOD_OLD_HAWAII_I_1987_OAHU, "RTCOD_OLD_HAWAII_I_1987_OAHU" );
    public static final SRM_RT_Code RTCOD_OPHELIA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_OPHELIA_1988_IDENTITY, "RTCOD_OPHELIA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_OSGB_1936_3_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_OSGB_1936_3_MEAN_SOLUTION, "RTCOD_OSGB_1936_3_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_OSGB_1936_7_GREAT_BRITAIN
        = new SRM_RT_Code( _RTCOD_OSGB_1936_7_GREAT_BRITAIN, "RTCOD_OSGB_1936_7_GREAT_BRITAIN" );
    public static final SRM_RT_Code RTCOD_OSGB_1936_ENGLAND
        = new SRM_RT_Code( _RTCOD_OSGB_1936_ENGLAND, "RTCOD_OSGB_1936_ENGLAND" );
    public static final SRM_RT_Code RTCOD_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES
        = new SRM_RT_Code( _RTCOD_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES, "RTCOD_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES" );
    public static final SRM_RT_Code RTCOD_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS
        = new SRM_RT_Code( _RTCOD_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS, "RTCOD_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS" );
    public static final SRM_RT_Code RTCOD_OSGB_1936_WALES
        = new SRM_RT_Code( _RTCOD_OSGB_1936_WALES, "RTCOD_OSGB_1936_WALES" );
    public static final SRM_RT_Code RTCOD_PAN_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_PAN_1991_IDENTITY, "RTCOD_PAN_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PANDORA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_PANDORA_1988_IDENTITY, "RTCOD_PANDORA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PHOBOS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_PHOBOS_1988_IDENTITY, "RTCOD_PHOBOS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PHOEBE_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_PHOEBE_1988_IDENTITY, "RTCOD_PHOEBE_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS
        = new SRM_RT_Code( _RTCOD_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS, "RTCOD_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS" );
    public static final SRM_RT_Code RTCOD_PITCAIRN_1967_PITCAIRN_ISLAND
        = new SRM_RT_Code( _RTCOD_PITCAIRN_1967_PITCAIRN_ISLAND, "RTCOD_PITCAIRN_1967_PITCAIRN_ISLAND" );
    public static final SRM_RT_Code RTCOD_PLUTO_1994_IDENTITY
        = new SRM_RT_Code( _RTCOD_PLUTO_1994_IDENTITY, "RTCOD_PLUTO_1994_IDENTITY" );
    public static final SRM_RT_Code RTCOD_POINT_58_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_POINT_58_1991_MEAN_SOLUTION, "RTCOD_POINT_58_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_POINTE_NOIRE_1948_CONGO
        = new SRM_RT_Code( _RTCOD_POINTE_NOIRE_1948_CONGO, "RTCOD_POINTE_NOIRE_1948_CONGO" );
    public static final SRM_RT_Code RTCOD_PORTIA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_PORTIA_1988_IDENTITY, "RTCOD_PORTIA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS
        = new SRM_RT_Code( _RTCOD_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS, "RTCOD_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS" );
    public static final SRM_RT_Code RTCOD_PROMETHEUS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_PROMETHEUS_1988_IDENTITY, "RTCOD_PROMETHEUS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PROTEUS_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_PROTEUS_1991_IDENTITY, "RTCOD_PROTEUS_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_3_VENEZUELA
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_3_VENEZUELA, "RTCOD_PROV_S_AM_1956_3_VENEZUELA" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_7_VENEZUELA
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_7_VENEZUELA, "RTCOD_PROV_S_AM_1956_7_VENEZUELA" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_BOLIVIA
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_BOLIVIA, "RTCOD_PROV_S_AM_1956_BOLIVIA" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_COLOMBIA
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_COLOMBIA, "RTCOD_PROV_S_AM_1956_COLOMBIA" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_ECUADOR
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_ECUADOR, "RTCOD_PROV_S_AM_1956_ECUADOR" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_GUYANA
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_GUYANA, "RTCOD_PROV_S_AM_1956_GUYANA" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_MEAN_SOLUTION, "RTCOD_PROV_S_AM_1956_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_N_CHILE_19_S
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_N_CHILE_19_S, "RTCOD_PROV_S_AM_1956_N_CHILE_19_S" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_PERU
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_PERU, "RTCOD_PROV_S_AM_1956_PERU" );
    public static final SRM_RT_Code RTCOD_PROV_S_AM_1956_S_CHILE_43_S
        = new SRM_RT_Code( _RTCOD_PROV_S_AM_1956_S_CHILE_43_S, "RTCOD_PROV_S_AM_1956_S_CHILE_43_S" );
    public static final SRM_RT_Code RTCOD_PROV_S_CHILEAN_1963_SOUTH_CHILE
        = new SRM_RT_Code( _RTCOD_PROV_S_CHILEAN_1963_SOUTH_CHILE, "RTCOD_PROV_S_CHILEAN_1963_SOUTH_CHILE" );
    public static final SRM_RT_Code RTCOD_PUCK_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_PUCK_1988_IDENTITY, "RTCOD_PUCK_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS
        = new SRM_RT_Code( _RTCOD_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS, "RTCOD_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS" );
    public static final SRM_RT_Code RTCOD_PULKOVO_1942_RUSSIA
        = new SRM_RT_Code( _RTCOD_PULKOVO_1942_RUSSIA, "RTCOD_PULKOVO_1942_RUSSIA" );
    public static final SRM_RT_Code RTCOD_QATAR_NATIONAL_1974_3_QATAR
        = new SRM_RT_Code( _RTCOD_QATAR_NATIONAL_1974_3_QATAR, "RTCOD_QATAR_NATIONAL_1974_3_QATAR" );
    public static final SRM_RT_Code RTCOD_QORNOQ_1987_SOUTH_GREENLAND
        = new SRM_RT_Code( _RTCOD_QORNOQ_1987_SOUTH_GREENLAND, "RTCOD_QORNOQ_1987_SOUTH_GREENLAND" );
    public static final SRM_RT_Code RTCOD_REUNION_1947_MASCARENE_ISLANDS
        = new SRM_RT_Code( _RTCOD_REUNION_1947_MASCARENE_ISLANDS, "RTCOD_REUNION_1947_MASCARENE_ISLANDS" );
    public static final SRM_RT_Code RTCOD_RGF_1993_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RTCOD_RGF_1993_IDENTITY_BY_MEASUREMENT, "RTCOD_RGF_1993_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RTCOD_RHEA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_RHEA_1988_IDENTITY, "RTCOD_RHEA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_ROME_1940_PM_ROME_SARDINIA
        = new SRM_RT_Code( _RTCOD_ROME_1940_PM_ROME_SARDINIA, "RTCOD_ROME_1940_PM_ROME_SARDINIA" );
    public static final SRM_RT_Code RTCOD_ROME_1940_SARDINIA
        = new SRM_RT_Code( _RTCOD_ROME_1940_SARDINIA, "RTCOD_ROME_1940_SARDINIA" );
    public static final SRM_RT_Code RTCOD_ROSALIND_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_ROSALIND_1988_IDENTITY, "RTCOD_ROSALIND_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_ARGENTINA
        = new SRM_RT_Code( _RTCOD_S_AM_1969_ARGENTINA, "RTCOD_S_AM_1969_ARGENTINA" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS
        = new SRM_RT_Code( _RTCOD_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS, "RTCOD_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_BOLIVIA
        = new SRM_RT_Code( _RTCOD_S_AM_1969_BOLIVIA, "RTCOD_S_AM_1969_BOLIVIA" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_BRAZIL
        = new SRM_RT_Code( _RTCOD_S_AM_1969_BRAZIL, "RTCOD_S_AM_1969_BRAZIL" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_CHILE
        = new SRM_RT_Code( _RTCOD_S_AM_1969_CHILE, "RTCOD_S_AM_1969_CHILE" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_COLOMBIA
        = new SRM_RT_Code( _RTCOD_S_AM_1969_COLOMBIA, "RTCOD_S_AM_1969_COLOMBIA" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS
        = new SRM_RT_Code( _RTCOD_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS, "RTCOD_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_GUYANA
        = new SRM_RT_Code( _RTCOD_S_AM_1969_GUYANA, "RTCOD_S_AM_1969_GUYANA" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_S_AM_1969_MEAN_SOLUTION, "RTCOD_S_AM_1969_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_PARAGUAY
        = new SRM_RT_Code( _RTCOD_S_AM_1969_PARAGUAY, "RTCOD_S_AM_1969_PARAGUAY" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_PERU
        = new SRM_RT_Code( _RTCOD_S_AM_1969_PERU, "RTCOD_S_AM_1969_PERU" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_TRINIDAD_TOBAGO
        = new SRM_RT_Code( _RTCOD_S_AM_1969_TRINIDAD_TOBAGO, "RTCOD_S_AM_1969_TRINIDAD_TOBAGO" );
    public static final SRM_RT_Code RTCOD_S_AM_1969_VENEZUELA
        = new SRM_RT_Code( _RTCOD_S_AM_1969_VENEZUELA, "RTCOD_S_AM_1969_VENEZUELA" );
    public static final SRM_RT_Code RTCOD_S_ASIA_1987_SINGAPORE
        = new SRM_RT_Code( _RTCOD_S_ASIA_1987_SINGAPORE, "RTCOD_S_ASIA_1987_SINGAPORE" );
    public static final SRM_RT_Code RTCOD_S_JTSK_1993_CZECH_REPUBLIC
        = new SRM_RT_Code( _RTCOD_S_JTSK_1993_CZECH_REPUBLIC, "RTCOD_S_JTSK_1993_CZECH_REPUBLIC" );
    public static final SRM_RT_Code RTCOD_S_JTSK_1993_CZECH_SLOVAKIA
        = new SRM_RT_Code( _RTCOD_S_JTSK_1993_CZECH_SLOVAKIA, "RTCOD_S_JTSK_1993_CZECH_SLOVAKIA" );
    public static final SRM_RT_Code RTCOD_S42_PULKOVO_3_POLAND
        = new SRM_RT_Code( _RTCOD_S42_PULKOVO_3_POLAND, "RTCOD_S42_PULKOVO_3_POLAND" );
    public static final SRM_RT_Code RTCOD_S42_PULKOVO_ALBANIA
        = new SRM_RT_Code( _RTCOD_S42_PULKOVO_ALBANIA, "RTCOD_S42_PULKOVO_ALBANIA" );
    public static final SRM_RT_Code RTCOD_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA
        = new SRM_RT_Code( _RTCOD_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA, "RTCOD_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA" );
    public static final SRM_RT_Code RTCOD_S42_PULKOVO_G_ROMANIA
        = new SRM_RT_Code( _RTCOD_S42_PULKOVO_G_ROMANIA, "RTCOD_S42_PULKOVO_G_ROMANIA" );
    public static final SRM_RT_Code RTCOD_S42_PULKOVO_HUNGARY
        = new SRM_RT_Code( _RTCOD_S42_PULKOVO_HUNGARY, "RTCOD_S42_PULKOVO_HUNGARY" );
    public static final SRM_RT_Code RTCOD_S42_PULKOVO_KAZAKHSTAN
        = new SRM_RT_Code( _RTCOD_S42_PULKOVO_KAZAKHSTAN, "RTCOD_S42_PULKOVO_KAZAKHSTAN" );
    public static final SRM_RT_Code RTCOD_S42_PULKOVO_LATVIA
        = new SRM_RT_Code( _RTCOD_S42_PULKOVO_LATVIA, "RTCOD_S42_PULKOVO_LATVIA" );
    public static final SRM_RT_Code RTCOD_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND
        = new SRM_RT_Code( _RTCOD_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND, "RTCOD_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND" );
    public static final SRM_RT_Code RTCOD_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS
        = new SRM_RT_Code( _RTCOD_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS, "RTCOD_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS" );
    public static final SRM_RT_Code RTCOD_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS
        = new SRM_RT_Code( _RTCOD_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS, "RTCOD_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS" );
    public static final SRM_RT_Code RTCOD_SATURN_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_SATURN_1988_IDENTITY, "RTCOD_SATURN_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_SATURN_MAGNETIC_1993_VOYAGER_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RTCOD_SATURN_MAGNETIC_1993_VOYAGER_IDENTITY_BY_MEASUREMENT, "RTCOD_SATURN_MAGNETIC_1993_VOYAGER_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RTCOD_SCHWARZECK_1991_NAMIBIA
        = new SRM_RT_Code( _RTCOD_SCHWARZECK_1991_NAMIBIA, "RTCOD_SCHWARZECK_1991_NAMIBIA" );
    public static final SRM_RT_Code RTCOD_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS
        = new SRM_RT_Code( _RTCOD_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS, "RTCOD_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS" );
    public static final SRM_RT_Code RTCOD_SIERRA_LEONE_1960_SIERRA_LEONE
        = new SRM_RT_Code( _RTCOD_SIERRA_LEONE_1960_SIERRA_LEONE, "RTCOD_SIERRA_LEONE_1960_SIERRA_LEONE" );
    public static final SRM_RT_Code RTCOD_SIRGAS_2000_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RTCOD_SIRGAS_2000_IDENTITY_BY_MEASUREMENT, "RTCOD_SIRGAS_2000_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RTCOD_SUN_1992_IDENTITY
        = new SRM_RT_Code( _RTCOD_SUN_1992_IDENTITY, "RTCOD_SUN_1992_IDENTITY" );
    public static final SRM_RT_Code RTCOD_TANANARIVE_OBS_1925_3_MADAGASCAR
        = new SRM_RT_Code( _RTCOD_TANANARIVE_OBS_1925_3_MADAGASCAR, "RTCOD_TANANARIVE_OBS_1925_3_MADAGASCAR" );
    public static final SRM_RT_Code RTCOD_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR
        = new SRM_RT_Code( _RTCOD_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR, "RTCOD_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR" );
    public static final SRM_RT_Code RTCOD_TELESTO_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_TELESTO_1988_IDENTITY, "RTCOD_TELESTO_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_TERN_1961_TERN_ISLAND
        = new SRM_RT_Code( _RTCOD_TERN_1961_TERN_ISLAND, "RTCOD_TERN_1961_TERN_ISLAND" );
    public static final SRM_RT_Code RTCOD_TETHYS_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_TETHYS_1991_IDENTITY, "RTCOD_TETHYS_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_THALASSA_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_THALASSA_1991_IDENTITY, "RTCOD_THALASSA_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_THEBE_2000_IDENTITY
        = new SRM_RT_Code( _RTCOD_THEBE_2000_IDENTITY, "RTCOD_THEBE_2000_IDENTITY" );
    public static final SRM_RT_Code RTCOD_TIMBALAI_EVRST_1948_3_BRUNEI_E_MALAYSIA
        = new SRM_RT_Code( _RTCOD_TIMBALAI_EVRST_1948_3_BRUNEI_E_MALAYSIA, "RTCOD_TIMBALAI_EVRST_1948_3_BRUNEI_E_MALAYSIA" );
    public static final SRM_RT_Code RTCOD_TIMBALAI_EVRST_1948_7_BRUNEI_E_MALAYSIA
        = new SRM_RT_Code( _RTCOD_TIMBALAI_EVRST_1948_7_BRUNEI_E_MALAYSIA, "RTCOD_TIMBALAI_EVRST_1948_7_BRUNEI_E_MALAYSIA" );
    public static final SRM_RT_Code RTCOD_TITAN_1982_IDENTITY
        = new SRM_RT_Code( _RTCOD_TITAN_1982_IDENTITY, "RTCOD_TITAN_1982_IDENTITY" );
    public static final SRM_RT_Code RTCOD_TITANIA_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_TITANIA_1988_IDENTITY, "RTCOD_TITANIA_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_TOKYO_1991_JAPAN
        = new SRM_RT_Code( _RTCOD_TOKYO_1991_JAPAN, "RTCOD_TOKYO_1991_JAPAN" );
    public static final SRM_RT_Code RTCOD_TOKYO_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RTCOD_TOKYO_1991_MEAN_SOLUTION, "RTCOD_TOKYO_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RTCOD_TOKYO_1991_OKINAWA
        = new SRM_RT_Code( _RTCOD_TOKYO_1991_OKINAWA, "RTCOD_TOKYO_1991_OKINAWA" );
    public static final SRM_RT_Code RTCOD_TOKYO_1991_1991_SOUTH_KOREA
        = new SRM_RT_Code( _RTCOD_TOKYO_1991_1991_SOUTH_KOREA, "RTCOD_TOKYO_1991_1991_SOUTH_KOREA" );
    public static final SRM_RT_Code RTCOD_TOKYO_1991_1997_SOUTH_KOREA
        = new SRM_RT_Code( _RTCOD_TOKYO_1991_1997_SOUTH_KOREA, "RTCOD_TOKYO_1991_1997_SOUTH_KOREA" );
    public static final SRM_RT_Code RTCOD_TRISTAN_1968_TRISTAN_DA_CUNHA
        = new SRM_RT_Code( _RTCOD_TRISTAN_1968_TRISTAN_DA_CUNHA, "RTCOD_TRISTAN_1968_TRISTAN_DA_CUNHA" );
    public static final SRM_RT_Code RTCOD_TRITON_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_TRITON_1991_IDENTITY, "RTCOD_TRITON_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_UMBRIEL_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_UMBRIEL_1988_IDENTITY, "RTCOD_UMBRIEL_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_URANUS_1988_IDENTITY
        = new SRM_RT_Code( _RTCOD_URANUS_1988_IDENTITY, "RTCOD_URANUS_1988_IDENTITY" );
    public static final SRM_RT_Code RTCOD_URANUS_MAGNETIC_1993_VOYAGER
        = new SRM_RT_Code( _RTCOD_URANUS_MAGNETIC_1993_VOYAGER, "RTCOD_URANUS_MAGNETIC_1993_VOYAGER" );
    public static final SRM_RT_Code RTCOD_VENUS_1991_IDENTITY
        = new SRM_RT_Code( _RTCOD_VENUS_1991_IDENTITY, "RTCOD_VENUS_1991_IDENTITY" );
    public static final SRM_RT_Code RTCOD_VITI_LEVU_1916_VITI_LEVU_ISLANDS
        = new SRM_RT_Code( _RTCOD_VITI_LEVU_1916_VITI_LEVU_ISLANDS, "RTCOD_VITI_LEVU_1916_VITI_LEVU_ISLANDS" );
    public static final SRM_RT_Code RTCOD_VOIROL_1874_ALGERIA
        = new SRM_RT_Code( _RTCOD_VOIROL_1874_ALGERIA, "RTCOD_VOIROL_1874_ALGERIA" );
    public static final SRM_RT_Code RTCOD_VOIROL_1874_PM_PARIS_ALGERIA
        = new SRM_RT_Code( _RTCOD_VOIROL_1874_PM_PARIS_ALGERIA, "RTCOD_VOIROL_1874_PM_PARIS_ALGERIA" );
    public static final SRM_RT_Code RTCOD_VOIROL_1960_ALGERIA
        = new SRM_RT_Code( _RTCOD_VOIROL_1960_ALGERIA, "RTCOD_VOIROL_1960_ALGERIA" );
    public static final SRM_RT_Code RTCOD_VOIROL_1960_PM_PARIS_ALGERIA
        = new SRM_RT_Code( _RTCOD_VOIROL_1960_PM_PARIS_ALGERIA, "RTCOD_VOIROL_1960_PM_PARIS_ALGERIA" );
    public static final SRM_RT_Code RTCOD_WAKE_1952_WAKE_ATOLL
        = new SRM_RT_Code( _RTCOD_WAKE_1952_WAKE_ATOLL, "RTCOD_WAKE_1952_WAKE_ATOLL" );
    public static final SRM_RT_Code RTCOD_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS
        = new SRM_RT_Code( _RTCOD_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS, "RTCOD_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS" );
    public static final SRM_RT_Code RTCOD_WGS_1972_GLOBAL
        = new SRM_RT_Code( _RTCOD_WGS_1972_GLOBAL, "RTCOD_WGS_1972_GLOBAL" );
    public static final SRM_RT_Code RTCOD_WGS_1984_IDENTITY
        = new SRM_RT_Code( _RTCOD_WGS_1984_IDENTITY, "RTCOD_WGS_1984_IDENTITY" );
    public static final SRM_RT_Code RTCOD_YACARE_1987_URUGUAY
        = new SRM_RT_Code( _RTCOD_YACARE_1987_URUGUAY, "RTCOD_YACARE_1987_URUGUAY" );
    public static final SRM_RT_Code RTCOD_ZANDERIJ_1987_SURINAME
        = new SRM_RT_Code( _RTCOD_ZANDERIJ_1987_SURINAME, "RTCOD_ZANDERIJ_1987_SURINAME" );

    public static final SRM_RT_Code RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT, "RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT, "RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT" );

    private SRM_RT_Code(int code, String name)
    {
        super (code, name);
        _enumMap.put( name, this );
        if (code >= 0 && code < _totalEnum)
        {
            _enumVec.add( code, this );
        }
        else if (code == _RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT)
        {
            _enumVec.add( _totalEnum, this );
        }
        else if (code == _RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT)
        {
            _enumVec.add( _totalEnum+1, this );
        }
    }

    /** @return the SRM_RT_Code from its enumerant value
     */
    public static SRM_RT_Code getEnum(int enum_value) throws SrmException
    {
        if (enum_value >= 0 && enum_value < _totalEnum)
            return (SRM_RT_Code)(_enumVec.elementAt( enum_value ));
        else if (enum_value == _RTCOD_EXPERIMENTAL_NGA_MAX_IDENTITY_BY_DEFAULT)
            return (SRM_RT_Code)(_enumVec.elementAt( _totalEnum ));
        else if (enum_value == _RTCOD_EXPERIMENTAL_NGA_SPHERE_IDENTITY_BY_DEFAULT)
            return (SRM_RT_Code)(_enumVec.elementAt( _totalEnum+1 ));
        else
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_RT_Code.getEnum: enumerant out of range"));
    }

    /** @return the SRM_RT_Code from its string name
     */
    public static SRM_RT_Code getEnum(String name) throws SrmException
    {
        SRM_RT_Code retCode = (SRM_RT_Code)_enumMap.get(name);

        if (retCode == null)
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_RT_Code.getEnum: enum. string not found"));

        return retCode;
    }
}
