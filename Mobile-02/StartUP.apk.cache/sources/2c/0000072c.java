package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import com.coinbase.wallet.core.extensions.Strings;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpStatus;
import org.apache.http.message.TokenParser;
import org.spongycastle.asn1.eac.EACTags;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: ǃ  reason: contains not printable characters */
    private static int f225 = 0;

    /* renamed from: ι  reason: contains not printable characters */
    private static int f227 = 1;

    /* renamed from: ı  reason: contains not printable characters */
    private static char[] f224 = {61163, 22514, 40130, 50618, 2749, 29581, 47210, 57662, 9806, 28457, 54330, 7453, 17394, 35068, 61905, 13998, 32659, 42194, 60754, 21069, 39774, 49185, 2334, 19992, 46325, 64962, 8911, 27541, 53379, 6554, 24191, 34631, 52271, 13614, 52353, 60956, 4935, 43601, 24939, 14341, 63307, 36381, 17911, 7305, 56298, 37532, 10685, 57476, 48766, 30029, 3175, 51975, 33325, 22802, 21602, 60791, 9806, 32551, 45113, 51467, 692, 23471, 40073, 54690, 28393, 42945, 63849, 12924, 19213, 35961, 50516, 7696, 22456, 59591, 8588, 31403, 46032, 62666, 3700, 18207, 38925, 53556, 27226, 41806, 58533, 15771, 47429, TokenParser.ESCAPE, 52076, 37396, 23827, 9251, 61380, 46736, 29179, 14481, 33750, 19092, 5197, 57166, 42596, 24843, 10294, 62251, 47845, 1511, 52466, 38795, 24231, 6587, 58182, 30898, 49579, 2715, 21475, 40164, 58836, 11827, 30567, 45067, 63860, 17021, 35653, 54700, 7852, 26517, 41212, 59805, 13046, 31546, 50207, 3352, 22130, 40773, 42262, 7183, 55103, 36423, 16704, 14448, 62359, 43715, 28072, 9410, 40837, 22212, 2060, 49936, 47661, 32094, 13379, 61280, 42632, 6590, 'a', 47480, 29256, 11056, 58423, 40199, 22240, 4020, 51422, 33187, 15016, 62428, 44381, 26220, 8029, 49716, 45998, 2762, 64061, 17184, 34829, 53620, 7713, 26448, 44220, 62947, 12947, 31740, 49403, 2497, 22326, 39995, '/', 47477, 29261, 11041, 58416, 40203, 13489, 36259, 18076, 8065, 53428, 43483, 25139, 15147, 64517, 46448, 'C', 47486, 29257, 11041, 58419, 40221, 22257, 4087, 51445, 33214, 15039, 62359, 44408, 26218, 8029, 55333, 37134, 50529, 31824, 46946, 60937, 8474, 22573, 37763, 51913, 3576, 17601, 65436, 14000, 26715, 41753, 55920, 7436, 21540, 36665, 50894, 31141, 45295, 60296, 8887, 26037, 40727, 54902, 2418, 16385, 64295, 12921, 30166, 44277, 59268, 7828, 20923, 35665, 49750, 1382, 48141, 63303, 11895, 17313, 64181, 12702, 26829, 42992, 57051, 5430, 19517, 35610, 49772, 31103, 45136, 61071, 9640, 23682, 39904, 53967, 2515, 16427, 65296, 13847, 28007, 42060, 58191, 48803, 1950, 52393, 38337, 23251, 9213, 59409, 45335, 30210, 16195, 33882, 19838, 5005, 55453, 41376, 26351, 12280, 62709, 48393, 562, 52012, 36935, 22891, 7796, 48359, 1494, 52964, 38799, 22684, 8619, 59909, 45906, 29823, 15633, 34322, 20280, 4556, 55967, 41959, 25742, 11687, 63163, 48968, '`', 51565, 37386, 23329, 7291, 59100, 45026, 28905, 14747, 33446, 19387, 3093, 54652, 40456, 26371, 10277, 62083, 48092, 31991, 50566, 36510, 22433, 6227, 57684, 43644, 29447, 13381, 64885};

    /* renamed from: Ι  reason: contains not printable characters */
    private static long f226 = 5583085843407419670L;

    c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b4  */
    /* renamed from: ı  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m158(android.content.Context r15, long r16) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.c.m158(android.content.Context, long):java.lang.String");
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static String m160(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            int i2 = f225 + 83;
            int i3 = i2 % 128;
            f227 = i3;
            int i4 = i2 % 2;
            int i5 = i3 + 79;
            f225 = i5 % 128;
            int i6 = i5 % 2;
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m162(String str) {
        int i2 = f227 + 65;
        f225 = i2 % 128;
        int i3 = i2 % 2;
        if (!(str.contains(m163(CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, (char) 49690, 1).intern()))) {
            return str;
        }
        String[] split = str.split(m163(CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, (char) 46066, 2).intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i4 = length - 1;
        sb.append(split[i4]);
        sb.append(m163(CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, (char) 49690, 1).intern());
        int i5 = f225 + 103;
        f227 = i5 % 128;
        int i6 = i5 % 2;
        int i7 = 1;
        while (true) {
            if (i7 < i4) {
                int i8 = f225 + 61;
                f227 = i8 % 128;
                int i9 = i8 % 2;
                sb.append(split[i7]);
                sb.append(m163(CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, (char) 49690, 1).intern());
                i7++;
            } else {
                sb.append(split[0]);
                return sb.toString();
            }
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static String m164(String str, Long l2) {
        if (!(str == null)) {
            int i2 = f227 + EACTags.SECURE_MESSAGING_TEMPLATE;
            int i3 = i2 % 128;
            f225 = i3;
            int i4 = i2 % 2;
            if (!(l2 == null)) {
                int i5 = i3 + 59;
                f227 = i5 % 128;
                int i6 = i5 % 2;
                if (str.length() == 32) {
                    StringBuilder sb = new StringBuilder(str);
                    String obj = l2.toString();
                    long j2 = 0;
                    int i7 = 0;
                    for (int i8 = 0; i8 < obj.length(); i8++) {
                        i7 += Character.getNumericValue(obj.charAt(i8));
                    }
                    String hexString = Integer.toHexString(i7);
                    sb.replace(7, hexString.length() + 7, hexString);
                    for (int i9 = 0; i9 < sb.length(); i9++) {
                        j2 += Character.getNumericValue(sb.charAt(i9));
                    }
                    while (true) {
                        if (!(j2 > 100)) {
                            break;
                        }
                        j2 %= 100;
                    }
                    sb.insert(23, (int) j2);
                    if ((j2 < 10 ? 'Q' : '`') != '`') {
                        sb.insert(23, m163(35, (char) 60972, 1).intern());
                    }
                    return sb.toString();
                }
            }
        }
        return m163(54, (char) 21504, 32).intern();
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m161(Context context, String str) {
        Iterator it;
        boolean z;
        int i2 = f227 + 27;
        f225 = i2 % 128;
        int i3 = i2 % 2;
        try {
            it = ((List) PackageManager.class.getDeclaredMethod(m163(260, (char) 17350, 24).intern(), Integer.TYPE).invoke(context.getPackageManager(), 0)).iterator();
            int i4 = f227 + 1;
            f225 = i4 % 128;
            int i5 = i4 % 2;
        } catch (IllegalAccessException e2) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai aiVar = ai.f183;
            String intern = m163(284, (char) 48864, 24).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m163(StatusLine.HTTP_PERM_REDIRECT, (char) 48289, 47).intern());
            sb.append(e2);
            aiVar.m141(null, intern, sb.toString());
        } catch (NoSuchMethodException e3) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
                int i6 = f225 + 25;
                f227 = i6 % 128;
                int i7 = i6 % 2;
            }
            ai aiVar2 = ai.f183;
            String intern2 = m163(284, (char) 48864, 24).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m163(StatusLine.HTTP_PERM_REDIRECT, (char) 48289, 47).intern());
            sb2.append(e3);
            aiVar2.m141(null, intern2, sb2.toString());
        } catch (InvocationTargetException e4) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai aiVar3 = ai.f183;
            String intern3 = m163(284, (char) 48864, 24).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m163(StatusLine.HTTP_PERM_REDIRECT, (char) 48289, 47).intern());
            sb3.append(e4);
            aiVar3.m141(null, intern3, sb3.toString());
        }
        do {
            if ((it.hasNext() ? '7' : (char) 7) == '7') {
                if (((PackageItemInfo) ((ApplicationInfo) it.next())).packageName.equals(str)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else {
                return Boolean.FALSE.toString();
            }
        } while (!z);
        int i8 = f225 + 101;
        f227 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 75 / 0;
            return Boolean.TRUE.toString();
        }
        return Boolean.TRUE.toString();
    }

    /* loaded from: classes.dex */
    public static class a extends HashMap<String, Object> {

        /* renamed from: Ι  reason: contains not printable characters */
        private static int f229 = 0;

        /* renamed from: І  reason: contains not printable characters */
        private static int f231 = 1;

        /* renamed from: ı  reason: contains not printable characters */
        private final Map<String, Object> f232;

        /* renamed from: ɩ  reason: contains not printable characters */
        private final Context f233;

        /* renamed from: ι  reason: contains not printable characters */
        private static char[] f230 = {'a', 61894, 58143, 54420, 50921, 47181, 43429, 39699, 36212, 32449, 28717, 24976, 'b', 61906, 58145, 54414, 50916, 'N', 61935, 58143, 54434, 50898, 47201, 43406, 39716, 'k', 61893, 58150, 'f', 61889, 58153, 54412, 50917, 47172, 43488, 39687, 36197, 32462, 28709, 24978, 21473, 17748, 13993, 10254, 6759, 2944, 64811, 61061, 57574, 53760, 50091, 46341, 42873, 39040, 35383, 31625, 28148, 24392, 20704, 16901, 13432, 9667, 5925, 2192, 64244, 60489, 56751, 53006, 49466, 45696, 14536, 51558, 56197, 60538, 65050, 32954, 37210, 'f', 61897, 58162, 54419, 50932, 47212, 43425, 39701, 36206, 32451, 28712, 24996, 21473, 17748, 13989, '5', 61838, 58228, 54478, 50864, 24553, 44566, 48359, 35594, 39278, 14334, 50777, 54449, 58132, 61821, 36828, 40568, 44191, 47869, 18774, 18365, 22026, 25721, 29388, 305, 8086, 11775, 15384, 51891, 55581, 55166, 58776, 62510, 33433, 37108, 44877, 48573, 19544, 23151, 26833, 26412, 30096, 952, 4701, 8352, 16155, 52605, 56264, 59948, 63633, 63223, 34134, 37858, 41560, 51824, 15315, 10544, 7831, 3315, 29271, 25570, 20807, 18214, 46210, 47670, 43979, 39331, 36692, 64736, 57922, 53283, 49546, 'a', 61902, 58148, 54418, 50927, 47177, 43428, 39758, 36201, 32462, 28724, 24965, 21486, 17748, 14062, 10241, 6755, 3028, 64809, 61071, 57582, 53774, 50050, 46369, 42836, 39156, 35333, 31666, 28121, 24447, 20611, 16936, 13377, 9710, 5895, 2213, 64196, 't', 61893, 58157, 54416, 50917, 47186, 43425, 39700, 36213, 32466, 28709, 64752, 3344, 8190, 26734, 39384, 35635, 48270, 44786, 53327, 24021, 33232, 28718, '&', 61907, '&', 61904, 'f', 61840, 58161, 54480, 50929, 47121, 43440, 39761, 36208, 32402, 28786, 24963, 21480, 17748, 13985, 10253};

        /* renamed from: ǃ  reason: contains not printable characters */
        private static long f228 = -8771784815112425056L;

        /* renamed from: com.appsflyer.internal.c$a$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0099c {

            /* renamed from: ı  reason: contains not printable characters */
            private final Object f234;

            /* renamed from: ɩ  reason: contains not printable characters */
            public String f235;

            /* renamed from: Ι  reason: contains not printable characters */
            private long f236;

            C0099c() {
            }

            /* renamed from: ı  reason: contains not printable characters */
            private boolean m169(long j2, String str) {
                synchronized (this.f234) {
                    if (str != null) {
                        if (!str.equals(this.f235) && m174(j2)) {
                            this.f236 = j2;
                            this.f235 = str;
                            return true;
                        }
                    }
                    return false;
                }
            }

            /* renamed from: ɩ  reason: contains not printable characters */
            static byte[] m170(String str) throws Exception {
                return str.getBytes();
            }

            /* renamed from: Ι  reason: contains not printable characters */
            static byte[] m171(byte[] bArr) throws Exception {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ ((i2 % 2) + 42));
                }
                return bArr;
            }

            /* renamed from: ι  reason: contains not printable characters */
            static String m173(byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2);
                    if (hexString.length() == 1) {
                        hexString = Strings.zero.concat(hexString);
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f236);
                sb.append(",");
                sb.append(this.f235);
                return sb.toString();
            }

            public C0099c(long j2, String str) {
                this.f234 = new Object();
                this.f236 = 0L;
                this.f235 = "";
                this.f236 = j2;
                this.f235 = str;
            }

            /* renamed from: ɩ  reason: contains not printable characters */
            public final boolean m175(C0099c c0099c) {
                return m169(c0099c.f236, c0099c.f235);
            }

            /* renamed from: ι  reason: contains not printable characters */
            public static C0099c m172(String str) {
                if (str == null) {
                    return new C0099c(0L, "");
                }
                String[] split = str.split(",");
                if (split.length < 2) {
                    return new C0099c(0L, "");
                }
                return new C0099c(Long.parseLong(split[0]), split[1]);
            }

            /* renamed from: ι  reason: contains not printable characters */
            private boolean m174(long j2) {
                return j2 - this.f236 > 2000;
            }
        }

        public a(Map<String, Object> map, Context context) {
            this.f232 = map;
            this.f233 = context;
            put(m167(), m165());
        }

        /* renamed from: ı  reason: contains not printable characters */
        private String m165() {
            String obj;
            int i2;
            int intExtra;
            try {
                String obj2 = this.f232.get(m166(0, (char) 0, 12).intern()).toString();
                String obj3 = this.f232.get(m166(77, (char) 0, 15).intern()).toString();
                String replaceAll = m166(92, (char) 0, 5).intern().replaceAll(m166(97, (char) 24516, 5).intern(), "");
                StringBuilder sb = new StringBuilder();
                sb.append(obj2);
                sb.append(obj3);
                sb.append(replaceAll);
                String m207 = z.m207(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(m207.substring(0, 16));
                obj = sb2.toString();
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(m166(102, (char) 14232, 44).intern());
                sb3.append(e2);
                AFLogger.afRDLog(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(m166(CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, (char) 51730, 18).intern());
                obj = sb4.toString();
            }
            try {
                Intent registerReceiver = this.f233.registerReceiver(null, new IntentFilter(m166(CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, (char) 0, 37).intern()));
                int i3 = -2700;
                if (registerReceiver != null) {
                    int i4 = f231 + 51;
                    f229 = i4 % 128;
                    if (i4 % 2 != 0) {
                        intExtra = registerReceiver.getIntExtra(m166(15579, (char) 0, 109).intern(), 25996);
                    } else {
                        intExtra = registerReceiver.getIntExtra(m166(HttpStatus.SC_CREATED, (char) 0, 11).intern(), -2700);
                    }
                    i3 = intExtra;
                }
                String str = this.f233.getApplicationInfo().nativeLibraryDir;
                if ((str != null ? '0' : 'V') == '0') {
                    int i5 = f231 + 15;
                    f229 = i5 % 128;
                    int i6 = i5 % 2;
                    if (str.contains(m166(212, (char) 64648, 3).intern())) {
                        int i7 = f231 + 111;
                        f229 = i7 % 128;
                        if ((i7 % 2 != 0 ? '4' : 'O') == 'O') {
                            i2 = 1;
                            int size = ((SensorManager) this.f233.getSystemService(m166(215, (char) 26653, 6).intern())).getSensorList(-1).size();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(m166(221, (char) 23991, 1).intern());
                            sb5.append(i3);
                            sb5.append(m166(222, (char) 33270, 2).intern());
                            sb5.append(i2);
                            sb5.append(m166(224, (char) 0, 2).intern());
                            sb5.append(size);
                            sb5.append(m166(226, (char) 0, 2).intern());
                            sb5.append(this.f232.size());
                            String obj4 = sb5.toString();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(obj);
                            sb6.append(C0099c.m173(C0099c.m171(C0099c.m170(obj4))));
                            String obj5 = sb6.toString();
                            int i8 = f231 + 13;
                            f229 = i8 % 128;
                            int i9 = i8 % 2;
                            return obj5;
                        }
                    }
                }
                i2 = 0;
                int size2 = ((SensorManager) this.f233.getSystemService(m166(215, (char) 26653, 6).intern())).getSensorList(-1).size();
                StringBuilder sb52 = new StringBuilder();
                sb52.append(m166(221, (char) 23991, 1).intern());
                sb52.append(i3);
                sb52.append(m166(222, (char) 33270, 2).intern());
                sb52.append(i2);
                sb52.append(m166(224, (char) 0, 2).intern());
                sb52.append(size2);
                sb52.append(m166(226, (char) 0, 2).intern());
                sb52.append(this.f232.size());
                String obj42 = sb52.toString();
                StringBuilder sb62 = new StringBuilder();
                sb62.append(obj);
                sb62.append(C0099c.m173(C0099c.m171(C0099c.m170(obj42))));
                String obj52 = sb62.toString();
                int i82 = f231 + 13;
                f229 = i82 % 128;
                int i92 = i82 % 2;
                return obj52;
            } catch (Exception e3) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(m166(102, (char) 14232, 44).intern());
                sb7.append(e3);
                AFLogger.afRDLog(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(obj);
                sb8.append(m166(228, (char) 0, 16).intern());
                return sb8.toString();
            }
        }

        /* renamed from: ɩ  reason: contains not printable characters */
        private static String m166(int i2, char c2, int i3) {
            int i4 = f229 + 19;
            f231 = i4 % 128;
            int i5 = i4 % 2;
            char[] cArr = new char[i3];
            int i6 = 0;
            while (true) {
                if (!(i6 < i3)) {
                    return new String(cArr);
                }
                int i7 = f231 + 95;
                int i8 = i7 % 128;
                f229 = i8;
                int i9 = i7 % 2;
                cArr[i6] = (char) ((f230[i2 + i6] ^ (i6 * f228)) ^ c2);
                i6++;
                int i10 = i8 + EACTags.SECURE_MESSAGING_TEMPLATE;
                f231 = i10 % 128;
                int i11 = i10 % 2;
            }
        }

        /* renamed from: Ι  reason: contains not printable characters */
        private static StringBuilder m168(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                if ((i2 < 3 ? (char) 22 : '\r') == '\r') {
                    break;
                }
                arrayList.add(Integer.valueOf(strArr[i2].length()));
                i2++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < intValue; i3++) {
                int i4 = f229 + 105;
                f231 = i4 % 128;
                int i5 = i4 % 2;
                Integer num = null;
                int i6 = 0;
                while (true) {
                    if (!(i6 < 3)) {
                        break;
                    }
                    int charAt = strArr[i6].charAt(i3);
                    if (num == null) {
                        int i7 = f229 + 95;
                        f231 = i7 % 128;
                        int i8 = i7 % 2;
                    } else {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                    i6++;
                    int i9 = f229 + 87;
                    f231 = i9 % 128;
                    int i10 = i9 % 2;
                }
                sb.append(Integer.toHexString(num.intValue()));
            }
            return sb;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* renamed from: Ι  reason: contains not printable characters */
        private String m167() {
            int i2 = f231 + 49;
            f229 = i2 % 128;
            int i3 = i2 % 2;
            char c2 = 0;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.f232.get(m166(0, (char) 0, 12).intern()).toString();
                String obj2 = this.f232.get(m166(12, (char) 0, 5).intern()).toString();
                if (obj2 == null) {
                    obj2 = m166(17, (char) 0, 8).intern();
                    int i4 = f231 + 117;
                    f229 = i4 % 128;
                    int i5 = i4 % 2;
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder m168 = m168(num, obj2, sb.toString());
                int length = m168.length();
                if (length > 4) {
                    int i6 = f231 + 73;
                    f229 = i6 % 128;
                    if (!(i6 % 2 == 0)) {
                        m168.delete(3, length);
                    } else {
                        m168.delete(4, length);
                    }
                } else {
                    while (true) {
                        if (length >= 4) {
                            break;
                        }
                        length++;
                        m168.append('1');
                        int i7 = f231 + 67;
                        f229 = i7 % 128;
                        int i8 = i7 % 2;
                    }
                }
                m168.insert(0, m166(25, (char) 0, 3).intern());
                c2 = m168.toString();
                return c2;
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m166(28, c2, 42).intern());
                sb2.append(e2);
                AFLogger.afRDLog(sb2.toString());
                return m166(70, (char) 14499, 7).intern();
            }
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static String m163(int i2, char c2, int i3) {
        char[] cArr = new char[i3];
        int i4 = 0;
        while (true) {
            if ((i4 < i3 ? 'J' : 'Y') == 'Y') {
                return new String(cArr);
            }
            int i5 = f227;
            int i6 = i5 + 85;
            f225 = i6 % 128;
            if (i6 % 2 != 0) {
                cArr[i4] = (char) ((f224[i2 + i4] | (i4 % f226)) * c2);
                i4 += 37;
            } else {
                cArr[i4] = (char) ((f224[i2 + i4] ^ (i4 * f226)) ^ c2);
                i4++;
            }
            int i7 = i5 + 109;
            f225 = i7 % 128;
            int i8 = i7 % 2;
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static boolean m159(String str) {
        int i2 = f225 + 89;
        f227 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Class.forName(str);
            int i4 = f227 + 49;
            f225 = i4 % 128;
            int i5 = i4 % 2;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static String m157(Context context) {
        if ((System.getProperties().containsKey(m163(CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, (char) 64087, 14).intern()) ? '.' : 'C') != 'C') {
            int i2 = f225 + 51;
            f227 = i2 % 128;
            int i3 = i2 % 2;
            try {
                Matcher matcher = Pattern.compile(m163(192, (char) 13471, 10).intern()).matcher(context.getCacheDir().getPath().replace(m163(CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, (char) 0, 6).intern(), ""));
                if ((matcher.find() ? ')' : 'c') != ')') {
                    return null;
                }
                int i4 = f227 + 89;
                f225 = i4 % 128;
                if (i4 % 2 != 0) {
                }
                return matcher.group(1);
            } catch (Exception e2) {
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                    int i5 = f225 + 87;
                    f227 = i5 % 128;
                    int i6 = i5 % 2;
                }
                ai aiVar = ai.f183;
                String intern = m163(HttpStatus.SC_ACCEPTED, (char) 0, 17).intern();
                StringBuilder sb = new StringBuilder();
                sb.append(m163(219, (char) 50471, 41).intern());
                sb.append(e2);
                aiVar.m141(null, intern, sb.toString());
                return null;
            }
        }
        return null;
    }
}