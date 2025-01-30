package org.spongycastle.crypto.engines;

import java.lang.reflect.Array;
import org.spongycastle.asn1.eac.EACTags;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.ec.Tnaf;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class AESEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int m1 = -2139062144;
    private static final int m2 = 2139062143;
    private static final int m3 = 27;
    private static final int m4 = -1061109568;
    private static final int m5 = 1061109567;
    private int C0;
    private int C1;
    private int C2;
    private int C3;
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 77, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 47, 94, 188, 99, 198, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 53, 106, 212, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, EACTags.SECURE_MESSAGING_TEMPLATE, 250, 239, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};
    private static final int[] T0 = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
    private static final int[] Tinv0 = {1353184337, 1399144830, -1012656358, -1772214470, -882136261, -247096033, -1420232020, -1828461749, 1442459680, -160598355, -1854485368, 625738485, -52959921, -674551099, -2143013594, -1885117771, 1230680542, 1729870373, -1743852987, -507445667, 41234371, 317738113, -1550367091, -956705941, -413167869, -1784901099, -344298049, -631680363, 763608788, -752782248, 694804553, 1154009486, 1787413109, 2021232372, 1799248025, -579749593, -1236278850, 397248752, 1722556617, -1271214467, 407560035, -2110711067, 1613975959, 1165972322, -529046351, -2068943941, 480281086, -1809118983, 1483229296, 436028815, -2022908268, -1208452270, 601060267, -503166094, 1468997603, 715871590, 120122290, 63092015, -1703164538, -1526188077, -226023376, -1297760477, -1167457534, 1552029421, 723308426, -1833666137, -252573709, -1578997426, -839591323, -708967162, 526529745, -1963022652, -1655493068, -1604979806, 853641733, 1978398372, 971801355, -1427152832, 111112542, 1360031421, -108388034, 1023860118, -1375387939, 1186850381, -1249028975, 90031217, 1876166148, -15380384, 620468249, -1746289194, -868007799, 2006899047, -1119688528, -2004121337, 945494503, -605108103, 1191869601, -384875908, -920746760, 0, -2088337399, 1223502642, -1401941730, 1316117100, -67170563, 1446544655, 517320253, 658058550, 1691946762, 564550760, -783000677, 976107044, -1318647284, 266819475, -761860428, -1634624741, 1338359936, -1574904735, 1766553434, 370807324, 179999714, -450191168, 1138762300, 488053522, 185403662, -1379431438, -1180125651, -928440812, -2061897385, 1275557295, -1143105042, -44007517, -1624899081, -1124765092, -985962940, 880737115, 1982415755, -590994485, 1761406390, 1676797112, -891538985, 277177154, 1076008723, 538035844, 2099530373, -130171950, 288553390, 1839278535, 1261411869, -214912292, -330136051, -790380169, 1813426987, -1715900247, -95906799, 577038663, -997393240, 440397984, -668172970, -275762398, -951170681, -1043253031, -22885748, 906744984, -813566554, 685669029, 646887386, -1530942145, -459458004, 227702864, -1681105046, 1648787028, -1038905866, -390539120, 1593260334, -173030526, -1098883681, 2090061929, -1456614033, -1290656305, 999926984, -1484974064, 1852021992, 2075868123, 158869197, -199730834, 28809964, -1466282109, 1701746150, 2129067946, 147831841, -420997649, -644094022, -835293366, -737566742, -696471511, -1347247055, 824393514, 815048134, -1067015627, 935087732, -1496677636, -1328508704, 366520115, 1251476721, -136647615, 240176511, 804688151, -1915335306, 1303441219, 1414376140, -553347356, -474623586, 461924940, -1205916479, 2136040774, 82468509, 1563790337, 1937016826, 776014843, 1511876531, 1389550482, 861278441, 323475053, -1939744870, 2047648055, -1911228327, -1992551445, -299390514, 902390199, -303751967, 1018251130, 1507840668, 1064563285, 2043548696, -1086863501, -355600557, 1537932639, 342834655, -2032450440, -2114736182, 1053059257, 741614648, 1598071746, 1925389590, 203809468, -1958134744, 1100287487, 1895934009, -558691320, -1662733096, -1866377628, 1636092795, 1890988757, 1952214088, 1113045200};

    private static int FFmulX(int i2) {
        return (((i2 & m1) >>> 7) * 27) ^ ((m2 & i2) << 1);
    }

    private static int FFmulX2(int i2) {
        int i3 = i2 & m4;
        int i4 = i3 ^ (i3 >>> 1);
        return (i4 >>> 5) ^ (((m5 & i2) << 2) ^ (i4 >>> 2));
    }

    private void decryptBlock(int[][] iArr) {
        int i2 = this.C0;
        int i3 = this.ROUNDS;
        char c2 = 0;
        int i4 = i2 ^ iArr[i3][0];
        int i5 = 1;
        int i6 = this.C1 ^ iArr[i3][1];
        int i7 = this.C2 ^ iArr[i3][2];
        int i8 = i3 - 1;
        int i9 = iArr[i3][3] ^ this.C3;
        while (i8 > i5) {
            int[] iArr2 = Tinv0;
            int shift = (((iArr2[i4 & 255] ^ shift(iArr2[(i9 >> 8) & 255], 24)) ^ shift(iArr2[(i7 >> 16) & 255], 16)) ^ shift(iArr2[(i6 >> 24) & 255], 8)) ^ iArr[i8][c2];
            int shift2 = (((shift(iArr2[(i4 >> 8) & 255], 24) ^ iArr2[i6 & 255]) ^ shift(iArr2[(i9 >> 16) & 255], 16)) ^ shift(iArr2[(i7 >> 24) & 255], 8)) ^ iArr[i8][i5];
            int shift3 = (((shift(iArr2[(i6 >> 8) & 255], 24) ^ iArr2[i7 & 255]) ^ shift(iArr2[(i4 >> 16) & 255], 16)) ^ shift(iArr2[(i9 >> 24) & 255], 8)) ^ iArr[i8][2];
            int shift4 = shift(iArr2[(i4 >> 24) & 255], 8) ^ ((iArr2[i9 & 255] ^ shift(iArr2[(i7 >> 8) & 255], 24)) ^ shift(iArr2[(i6 >> 16) & 255], 16));
            int i10 = i8 - 1;
            int i11 = shift4 ^ iArr[i8][3];
            int shift5 = (((iArr2[shift & 255] ^ shift(iArr2[(i11 >> 8) & 255], 24)) ^ shift(iArr2[(shift3 >> 16) & 255], 16)) ^ shift(iArr2[(shift2 >> 24) & 255], 8)) ^ iArr[i10][0];
            int shift6 = (((iArr2[shift2 & 255] ^ shift(iArr2[(shift >> 8) & 255], 24)) ^ shift(iArr2[(i11 >> 16) & 255], 16)) ^ shift(iArr2[(shift3 >> 24) & 255], 8)) ^ iArr[i10][1];
            int shift7 = ((iArr2[i11 & 255] ^ shift(iArr2[(shift3 >> 8) & 255], 24)) ^ shift(iArr2[(shift2 >> 16) & 255], 16)) ^ shift(iArr2[(shift >> 24) & 255], 8);
            int i12 = i10 - 1;
            i9 = iArr[i10][3] ^ shift7;
            i4 = shift5;
            i6 = shift6;
            i7 = (((iArr2[shift3 & 255] ^ shift(iArr2[(shift2 >> 8) & 255], 24)) ^ shift(iArr2[(shift >> 16) & 255], 16)) ^ shift(iArr2[(i11 >> 24) & 255], 8)) ^ iArr[i10][2];
            i5 = 1;
            i8 = i12;
            c2 = 0;
        }
        int[] iArr3 = Tinv0;
        int shift8 = (((iArr3[i4 & 255] ^ shift(iArr3[(i9 >> 8) & 255], 24)) ^ shift(iArr3[(i7 >> 16) & 255], 16)) ^ shift(iArr3[(i6 >> 24) & 255], 8)) ^ iArr[i8][0];
        int shift9 = (((iArr3[i6 & 255] ^ shift(iArr3[(i4 >> 8) & 255], 24)) ^ shift(iArr3[(i9 >> 16) & 255], 16)) ^ shift(iArr3[(i7 >> 24) & 255], 8)) ^ iArr[i8][1];
        int shift10 = (((iArr3[i7 & 255] ^ shift(iArr3[(i6 >> 8) & 255], 24)) ^ shift(iArr3[(i4 >> 16) & 255], 16)) ^ shift(iArr3[(i9 >> 24) & 255], 8)) ^ iArr[i8][2];
        int shift11 = (shift(iArr3[(i4 >> 24) & 255], 8) ^ ((iArr3[i9 & 255] ^ shift(iArr3[(i7 >> 8) & 255], 24)) ^ shift(iArr3[(i6 >> 16) & 255], 16))) ^ iArr[i8][3];
        byte[] bArr = Si;
        this.C0 = ((((bArr[shift8 & 255] & 255) ^ ((bArr[(shift11 >> 8) & 255] & 255) << 8)) ^ ((bArr[(shift10 >> 16) & 255] & 255) << 16)) ^ (bArr[(shift9 >> 24) & 255] << 24)) ^ iArr[0][0];
        this.C1 = ((((bArr[shift9 & 255] & 255) ^ ((bArr[(shift8 >> 8) & 255] & 255) << 8)) ^ ((bArr[(shift11 >> 16) & 255] & 255) << 16)) ^ (bArr[(shift10 >> 24) & 255] << 24)) ^ iArr[0][1];
        this.C2 = ((((bArr[shift10 & 255] & 255) ^ ((bArr[(shift9 >> 8) & 255] & 255) << 8)) ^ ((bArr[(shift8 >> 16) & 255] & 255) << 16)) ^ (bArr[(shift11 >> 24) & 255] << 24)) ^ iArr[0][2];
        this.C3 = ((((bArr[shift11 & 255] & 255) ^ ((bArr[(shift10 >> 8) & 255] & 255) << 8)) ^ ((bArr[(shift9 >> 16) & 255] & 255) << 16)) ^ (bArr[(shift8 >> 24) & 255] << 24)) ^ iArr[0][3];
    }

    private void encryptBlock(int[][] iArr) {
        char c2 = 0;
        int i2 = this.C0 ^ iArr[0][0];
        int i3 = 1;
        int i4 = this.C1 ^ iArr[0][1];
        int i5 = this.C2 ^ iArr[0][2];
        int i6 = this.C3 ^ iArr[0][3];
        int i7 = 1;
        while (i7 < this.ROUNDS - i3) {
            int[] iArr2 = T0;
            int shift = (((iArr2[i2 & 255] ^ shift(iArr2[(i4 >> 8) & 255], 24)) ^ shift(iArr2[(i5 >> 16) & 255], 16)) ^ shift(iArr2[(i6 >> 24) & 255], 8)) ^ iArr[i7][c2];
            int shift2 = (((shift(iArr2[(i5 >> 8) & 255], 24) ^ iArr2[i4 & 255]) ^ shift(iArr2[(i6 >> 16) & 255], 16)) ^ shift(iArr2[(i2 >> 24) & 255], 8)) ^ iArr[i7][i3];
            int shift3 = (((shift(iArr2[(i6 >> 8) & 255], 24) ^ iArr2[i5 & 255]) ^ shift(iArr2[(i2 >> 16) & 255], 16)) ^ shift(iArr2[(i4 >> 24) & 255], 8)) ^ iArr[i7][2];
            int shift4 = ((shift(iArr2[(i2 >> 8) & 255], 24) ^ iArr2[i6 & 255]) ^ shift(iArr2[(i4 >> 16) & 255], 16)) ^ shift(iArr2[(i5 >> 24) & 255], 8);
            int i8 = i7 + 1;
            int i9 = shift4 ^ iArr[i7][3];
            int shift5 = (((iArr2[shift & 255] ^ shift(iArr2[(shift2 >> 8) & 255], 24)) ^ shift(iArr2[(shift3 >> 16) & 255], 16)) ^ shift(iArr2[(i9 >> 24) & 255], 8)) ^ iArr[i8][0];
            int shift6 = (((iArr2[shift2 & 255] ^ shift(iArr2[(shift3 >> 8) & 255], 24)) ^ shift(iArr2[(i9 >> 16) & 255], 16)) ^ shift(iArr2[(shift >> 24) & 255], 8)) ^ iArr[i8][1];
            int shift7 = ((iArr2[i9 & 255] ^ shift(iArr2[(shift >> 8) & 255], 24)) ^ shift(iArr2[(shift2 >> 16) & 255], 16)) ^ shift(iArr2[(shift3 >> 24) & 255], 8);
            int i10 = i8 + 1;
            int i11 = shift7 ^ iArr[i8][3];
            i4 = shift6;
            i3 = 1;
            i6 = i11;
            i2 = shift5;
            i5 = (((iArr2[shift3 & 255] ^ shift(iArr2[(i9 >> 8) & 255], 24)) ^ shift(iArr2[(shift >> 16) & 255], 16)) ^ shift(iArr2[(shift2 >> 24) & 255], 8)) ^ iArr[i8][2];
            i7 = i10;
            c2 = 0;
        }
        int[] iArr3 = T0;
        int shift8 = (((iArr3[i2 & 255] ^ shift(iArr3[(i4 >> 8) & 255], 24)) ^ shift(iArr3[(i5 >> 16) & 255], 16)) ^ shift(iArr3[(i6 >> 24) & 255], 8)) ^ iArr[i7][0];
        int shift9 = (((iArr3[i4 & 255] ^ shift(iArr3[(i5 >> 8) & 255], 24)) ^ shift(iArr3[(i6 >> 16) & 255], 16)) ^ shift(iArr3[(i2 >> 24) & 255], 8)) ^ iArr[i7][1];
        int shift10 = (((iArr3[i5 & 255] ^ shift(iArr3[(i6 >> 8) & 255], 24)) ^ shift(iArr3[(i2 >> 16) & 255], 16)) ^ shift(iArr3[(i4 >> 24) & 255], 8)) ^ iArr[i7][2];
        int shift11 = ((shift(iArr3[(i2 >> 8) & 255], 24) ^ iArr3[i6 & 255]) ^ shift(iArr3[(i4 >> 16) & 255], 16)) ^ shift(iArr3[(i5 >> 24) & 255], 8);
        int i12 = i7 + 1;
        int i13 = shift11 ^ iArr[i7][3];
        byte[] bArr = S;
        this.C0 = ((((bArr[shift8 & 255] & 255) ^ ((bArr[(shift9 >> 8) & 255] & 255) << 8)) ^ ((bArr[(shift10 >> 16) & 255] & 255) << 16)) ^ (bArr[(i13 >> 24) & 255] << 24)) ^ iArr[i12][0];
        this.C1 = ((((bArr[shift9 & 255] & 255) ^ ((bArr[(shift10 >> 8) & 255] & 255) << 8)) ^ ((bArr[(i13 >> 16) & 255] & 255) << 16)) ^ (bArr[(shift8 >> 24) & 255] << 24)) ^ iArr[i12][1];
        this.C2 = ((((bArr[shift10 & 255] & 255) ^ ((bArr[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr[(shift8 >> 16) & 255] & 255) << 16)) ^ (bArr[(shift9 >> 24) & 255] << 24)) ^ iArr[i12][2];
        this.C3 = ((((bArr[i13 & 255] & 255) ^ ((bArr[(shift8 >> 8) & 255] & 255) << 8)) ^ ((bArr[(shift9 >> 16) & 255] & 255) << 16)) ^ (bArr[(shift10 >> 24) & 255] << 24)) ^ iArr[i12][3];
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z) {
        int length = bArr.length;
        if (length >= 16 && length <= 32 && (length & 7) == 0) {
            int i2 = length >>> 2;
            int i3 = i2 + 6;
            this.ROUNDS = i3;
            int[][] iArr = (int[][]) Array.newInstance(int.class, i3 + 1, 4);
            if (i2 == 4) {
                int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
                iArr[0][0] = littleEndianToInt;
                int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
                iArr[0][1] = littleEndianToInt2;
                int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
                iArr[0][2] = littleEndianToInt3;
                int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
                iArr[0][3] = littleEndianToInt4;
                for (int i4 = 1; i4 <= 10; i4++) {
                    littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i4 - 1];
                    iArr[i4][0] = littleEndianToInt;
                    littleEndianToInt2 ^= littleEndianToInt;
                    iArr[i4][1] = littleEndianToInt2;
                    littleEndianToInt3 ^= littleEndianToInt2;
                    iArr[i4][2] = littleEndianToInt3;
                    littleEndianToInt4 ^= littleEndianToInt3;
                    iArr[i4][3] = littleEndianToInt4;
                }
            } else if (i2 == 6) {
                int littleEndianToInt5 = Pack.littleEndianToInt(bArr, 0);
                iArr[0][0] = littleEndianToInt5;
                int littleEndianToInt6 = Pack.littleEndianToInt(bArr, 4);
                iArr[0][1] = littleEndianToInt6;
                int littleEndianToInt7 = Pack.littleEndianToInt(bArr, 8);
                iArr[0][2] = littleEndianToInt7;
                int littleEndianToInt8 = Pack.littleEndianToInt(bArr, 12);
                iArr[0][3] = littleEndianToInt8;
                int littleEndianToInt9 = Pack.littleEndianToInt(bArr, 16);
                iArr[1][0] = littleEndianToInt9;
                int littleEndianToInt10 = Pack.littleEndianToInt(bArr, 20);
                iArr[1][1] = littleEndianToInt10;
                int subWord = littleEndianToInt5 ^ (subWord(shift(littleEndianToInt10, 8)) ^ 1);
                iArr[1][2] = subWord;
                int i5 = littleEndianToInt6 ^ subWord;
                iArr[1][3] = i5;
                int i6 = littleEndianToInt7 ^ i5;
                iArr[2][0] = i6;
                int i7 = littleEndianToInt8 ^ i6;
                iArr[2][1] = i7;
                int i8 = littleEndianToInt9 ^ i7;
                iArr[2][2] = i8;
                int i9 = littleEndianToInt10 ^ i8;
                iArr[2][3] = i9;
                int i10 = 2;
                for (int i11 = 3; i11 < 12; i11 += 3) {
                    int subWord2 = subWord(shift(i9, 8)) ^ i10;
                    int i12 = i10 << 1;
                    int i13 = subWord ^ subWord2;
                    iArr[i11][0] = i13;
                    int i14 = i5 ^ i13;
                    iArr[i11][1] = i14;
                    int i15 = i6 ^ i14;
                    iArr[i11][2] = i15;
                    int i16 = i7 ^ i15;
                    iArr[i11][3] = i16;
                    int i17 = i8 ^ i16;
                    int i18 = i11 + 1;
                    iArr[i18][0] = i17;
                    int i19 = i9 ^ i17;
                    iArr[i18][1] = i19;
                    int subWord3 = subWord(shift(i19, 8)) ^ i12;
                    i10 = i12 << 1;
                    subWord = i13 ^ subWord3;
                    iArr[i18][2] = subWord;
                    i5 = i14 ^ subWord;
                    iArr[i18][3] = i5;
                    i6 = i15 ^ i5;
                    int i20 = i11 + 2;
                    iArr[i20][0] = i6;
                    i7 = i16 ^ i6;
                    iArr[i20][1] = i7;
                    i8 = i17 ^ i7;
                    iArr[i20][2] = i8;
                    i9 = i19 ^ i8;
                    iArr[i20][3] = i9;
                }
                int subWord4 = (subWord(shift(i9, 8)) ^ i10) ^ subWord;
                iArr[12][0] = subWord4;
                int i21 = subWord4 ^ i5;
                iArr[12][1] = i21;
                int i22 = i21 ^ i6;
                iArr[12][2] = i22;
                iArr[12][3] = i22 ^ i7;
            } else if (i2 == 8) {
                int littleEndianToInt11 = Pack.littleEndianToInt(bArr, 0);
                iArr[0][0] = littleEndianToInt11;
                int littleEndianToInt12 = Pack.littleEndianToInt(bArr, 4);
                iArr[0][1] = littleEndianToInt12;
                int littleEndianToInt13 = Pack.littleEndianToInt(bArr, 8);
                iArr[0][2] = littleEndianToInt13;
                int littleEndianToInt14 = Pack.littleEndianToInt(bArr, 12);
                iArr[0][3] = littleEndianToInt14;
                int littleEndianToInt15 = Pack.littleEndianToInt(bArr, 16);
                iArr[1][0] = littleEndianToInt15;
                int littleEndianToInt16 = Pack.littleEndianToInt(bArr, 20);
                iArr[1][1] = littleEndianToInt16;
                int littleEndianToInt17 = Pack.littleEndianToInt(bArr, 24);
                iArr[1][2] = littleEndianToInt17;
                int littleEndianToInt18 = Pack.littleEndianToInt(bArr, 28);
                iArr[1][3] = littleEndianToInt18;
                int i23 = 1;
                for (int i24 = 2; i24 < 14; i24 += 2) {
                    int subWord5 = subWord(shift(littleEndianToInt18, 8)) ^ i23;
                    i23 <<= 1;
                    littleEndianToInt11 ^= subWord5;
                    iArr[i24][0] = littleEndianToInt11;
                    littleEndianToInt12 ^= littleEndianToInt11;
                    iArr[i24][1] = littleEndianToInt12;
                    littleEndianToInt13 ^= littleEndianToInt12;
                    iArr[i24][2] = littleEndianToInt13;
                    littleEndianToInt14 ^= littleEndianToInt13;
                    iArr[i24][3] = littleEndianToInt14;
                    littleEndianToInt15 ^= subWord(littleEndianToInt14);
                    int i25 = i24 + 1;
                    iArr[i25][0] = littleEndianToInt15;
                    littleEndianToInt16 ^= littleEndianToInt15;
                    iArr[i25][1] = littleEndianToInt16;
                    littleEndianToInt17 ^= littleEndianToInt16;
                    iArr[i25][2] = littleEndianToInt17;
                    littleEndianToInt18 ^= littleEndianToInt17;
                    iArr[i25][3] = littleEndianToInt18;
                }
                int subWord6 = (subWord(shift(littleEndianToInt18, 8)) ^ i23) ^ littleEndianToInt11;
                iArr[14][0] = subWord6;
                int i26 = subWord6 ^ littleEndianToInt12;
                iArr[14][1] = i26;
                int i27 = i26 ^ littleEndianToInt13;
                iArr[14][2] = i27;
                iArr[14][3] = i27 ^ littleEndianToInt14;
            } else {
                throw new IllegalStateException("Should never get here");
            }
            if (!z) {
                for (int i28 = 1; i28 < this.ROUNDS; i28++) {
                    for (int i29 = 0; i29 < 4; i29++) {
                        iArr[i28][i29] = inv_mcol(iArr[i28][i29]);
                    }
                }
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    private static int inv_mcol(int i2) {
        int shift = shift(i2, 8) ^ i2;
        int FFmulX = i2 ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private void packBlock(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = this.C0;
        bArr[i2] = (byte) i4;
        int i5 = i3 + 1;
        bArr[i3] = (byte) (i4 >> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i4 >> 16);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i4 >> 24);
        int i8 = i7 + 1;
        int i9 = this.C1;
        bArr[i7] = (byte) i9;
        int i10 = i8 + 1;
        bArr[i8] = (byte) (i9 >> 8);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i9 >> 16);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i9 >> 24);
        int i13 = i12 + 1;
        int i14 = this.C2;
        bArr[i12] = (byte) i14;
        int i15 = i13 + 1;
        bArr[i13] = (byte) (i14 >> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i14 >> 16);
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i14 >> 24);
        int i18 = i17 + 1;
        int i19 = this.C3;
        bArr[i17] = (byte) i19;
        int i20 = i18 + 1;
        bArr[i18] = (byte) (i19 >> 8);
        bArr[i20] = (byte) (i19 >> 16);
        bArr[i20 + 1] = (byte) (i19 >> 24);
    }

    private static int shift(int i2, int i3) {
        return (i2 << (-i3)) | (i2 >>> i3);
    }

    private static int subWord(int i2) {
        byte[] bArr = S;
        return (bArr[(i2 >> 24) & 255] << 24) | (bArr[i2 & 255] & 255) | ((bArr[(i2 >> 8) & 255] & 255) << 8) | ((bArr[(i2 >> 16) & 255] & 255) << 16);
    }

    private void unpackBlock(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = bArr[i2] & 255;
        this.C0 = i4;
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.C0 = i6;
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 16);
        this.C0 = i8;
        int i9 = i7 + 1;
        this.C0 = i8 | (bArr[i7] << 24);
        int i10 = i9 + 1;
        int i11 = bArr[i9] & 255;
        this.C1 = i11;
        int i12 = i10 + 1;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        this.C1 = i13;
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.C1 = i15;
        int i16 = i14 + 1;
        this.C1 = i15 | (bArr[i14] << 24);
        int i17 = i16 + 1;
        int i18 = bArr[i16] & 255;
        this.C2 = i18;
        int i19 = i17 + 1;
        int i20 = ((bArr[i17] & 255) << 8) | i18;
        this.C2 = i20;
        int i21 = i19 + 1;
        int i22 = i20 | ((bArr[i19] & 255) << 16);
        this.C2 = i22;
        int i23 = i21 + 1;
        this.C2 = i22 | (bArr[i21] << 24);
        int i24 = i23 + 1;
        int i25 = bArr[i23] & 255;
        this.C3 = i25;
        int i26 = i24 + 1;
        int i27 = ((bArr[i24] & 255) << 8) | i25;
        this.C3 = i27;
        int i28 = i27 | ((bArr[i26] & 255) << 16);
        this.C3 = i28;
        this.C3 = (bArr[i26 + 1] << 24) | i28;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "AES";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z);
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (this.WorkingKey != null) {
            if (i2 + 16 <= bArr.length) {
                if (i3 + 16 <= bArr2.length) {
                    if (this.forEncryption) {
                        unpackBlock(bArr, i2);
                        encryptBlock(this.WorkingKey);
                        packBlock(bArr2, i3);
                        return 16;
                    }
                    unpackBlock(bArr, i2);
                    decryptBlock(this.WorkingKey);
                    packBlock(bArr2, i3);
                    return 16;
                }
                throw new OutputLengthException("output buffer too short");
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException("AES engine not initialised");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}