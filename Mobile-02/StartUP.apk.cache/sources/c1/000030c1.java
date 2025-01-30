package com.google.android.datatransport.cct.b;

import android.util.SparseArray;
import com.google.android.datatransport.cct.b.i;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class o {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract a a(b bVar);

        public abstract a b(c cVar);

        public abstract o c();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b {
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f5777b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f5778c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f5779d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f5780e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f5781f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f5782g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f5783h;

        /* renamed from: j  reason: collision with root package name */
        public static final b f5784j;

        /* renamed from: k  reason: collision with root package name */
        public static final b f5785k;

        /* renamed from: l  reason: collision with root package name */
        public static final b f5786l;
        public static final b m;
        public static final b n;
        public static final b p;
        public static final b q;
        public static final b t;
        public static final b u;
        public static final b v;
        public static final b w;
        public static final b x;
        public static final b y;
        private static final SparseArray<b> z;
        private final int A;

        static {
            b bVar = new b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
            a = bVar;
            b bVar2 = new b("GPRS", 1, 1);
            f5777b = bVar2;
            b bVar3 = new b("EDGE", 2, 2);
            f5778c = bVar3;
            b bVar4 = new b("UMTS", 3, 3);
            f5779d = bVar4;
            b bVar5 = new b("CDMA", 4, 4);
            f5780e = bVar5;
            b bVar6 = new b("EVDO_0", 5, 5);
            f5781f = bVar6;
            b bVar7 = new b("EVDO_A", 6, 6);
            f5782g = bVar7;
            b bVar8 = new b("RTT", 7, 7);
            f5783h = bVar8;
            b bVar9 = new b("HSDPA", 8, 8);
            f5784j = bVar9;
            b bVar10 = new b("HSUPA", 9, 9);
            f5785k = bVar10;
            b bVar11 = new b("HSPA", 10, 10);
            f5786l = bVar11;
            b bVar12 = new b("IDEN", 11, 11);
            m = bVar12;
            b bVar13 = new b("EVDO_B", 12, 12);
            n = bVar13;
            b bVar14 = new b("LTE", 13, 13);
            p = bVar14;
            b bVar15 = new b("EHRPD", 14, 14);
            q = bVar15;
            b bVar16 = new b("HSPAP", 15, 15);
            t = bVar16;
            b bVar17 = new b("GSM", 16, 16);
            u = bVar17;
            b bVar18 = new b("TD_SCDMA", 17, 17);
            v = bVar18;
            b bVar19 = new b("IWLAN", 18, 18);
            w = bVar19;
            b bVar20 = new b("LTE_CA", 19, 19);
            x = bVar20;
            y = new b("COMBINED", 20, 100);
            SparseArray<b> sparseArray = new SparseArray<>();
            z = sparseArray;
            sparseArray.put(0, bVar);
            sparseArray.put(1, bVar2);
            sparseArray.put(2, bVar3);
            sparseArray.put(3, bVar4);
            sparseArray.put(4, bVar5);
            sparseArray.put(5, bVar6);
            sparseArray.put(6, bVar7);
            sparseArray.put(7, bVar8);
            sparseArray.put(8, bVar9);
            sparseArray.put(9, bVar10);
            sparseArray.put(10, bVar11);
            sparseArray.put(11, bVar12);
            sparseArray.put(12, bVar13);
            sparseArray.put(13, bVar14);
            sparseArray.put(14, bVar15);
            sparseArray.put(15, bVar16);
            sparseArray.put(16, bVar17);
            sparseArray.put(17, bVar18);
            sparseArray.put(18, bVar19);
            sparseArray.put(19, bVar20);
        }

        private b(String str, int i2, int i3) {
            this.A = i3;
        }

        public static b h(int i2) {
            return z.get(i2);
        }

        public int a() {
            return this.A;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class c {
        public static final c a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f5787b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f5788c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f5789d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f5790e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f5791f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f5792g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f5793h;

        /* renamed from: j  reason: collision with root package name */
        public static final c f5794j;

        /* renamed from: k  reason: collision with root package name */
        public static final c f5795k;

        /* renamed from: l  reason: collision with root package name */
        public static final c f5796l;
        public static final c m;
        public static final c n;
        public static final c p;
        public static final c q;
        public static final c t;
        public static final c u;
        public static final c v;
        public static final c w;
        private static final SparseArray<c> x;
        private final int y;

        static {
            c cVar = new c("MOBILE", 0, 0);
            a = cVar;
            c cVar2 = new c("WIFI", 1, 1);
            f5787b = cVar2;
            c cVar3 = new c("MOBILE_MMS", 2, 2);
            f5788c = cVar3;
            c cVar4 = new c("MOBILE_SUPL", 3, 3);
            f5789d = cVar4;
            c cVar5 = new c("MOBILE_DUN", 4, 4);
            f5790e = cVar5;
            c cVar6 = new c("MOBILE_HIPRI", 5, 5);
            f5791f = cVar6;
            c cVar7 = new c("WIMAX", 6, 6);
            f5792g = cVar7;
            c cVar8 = new c("BLUETOOTH", 7, 7);
            f5793h = cVar8;
            c cVar9 = new c("DUMMY", 8, 8);
            f5794j = cVar9;
            c cVar10 = new c("ETHERNET", 9, 9);
            f5795k = cVar10;
            c cVar11 = new c("MOBILE_FOTA", 10, 10);
            f5796l = cVar11;
            c cVar12 = new c("MOBILE_IMS", 11, 11);
            m = cVar12;
            c cVar13 = new c("MOBILE_CBS", 12, 12);
            n = cVar13;
            c cVar14 = new c("WIFI_P2P", 13, 13);
            p = cVar14;
            c cVar15 = new c("MOBILE_IA", 14, 14);
            q = cVar15;
            c cVar16 = new c("MOBILE_EMERGENCY", 15, 15);
            t = cVar16;
            c cVar17 = new c("PROXY", 16, 16);
            u = cVar17;
            c cVar18 = new c("VPN", 17, 17);
            v = cVar18;
            c cVar19 = new c("NONE", 18, -1);
            w = cVar19;
            SparseArray<c> sparseArray = new SparseArray<>();
            x = sparseArray;
            sparseArray.put(0, cVar);
            sparseArray.put(1, cVar2);
            sparseArray.put(2, cVar3);
            sparseArray.put(3, cVar4);
            sparseArray.put(4, cVar5);
            sparseArray.put(5, cVar6);
            sparseArray.put(6, cVar7);
            sparseArray.put(7, cVar8);
            sparseArray.put(8, cVar9);
            sparseArray.put(9, cVar10);
            sparseArray.put(10, cVar11);
            sparseArray.put(11, cVar12);
            sparseArray.put(12, cVar13);
            sparseArray.put(13, cVar14);
            sparseArray.put(14, cVar15);
            sparseArray.put(15, cVar16);
            sparseArray.put(16, cVar17);
            sparseArray.put(17, cVar18);
            sparseArray.put(-1, cVar19);
        }

        private c(String str, int i2, int i3) {
            this.y = i3;
        }

        public static c h(int i2) {
            return x.get(i2);
        }

        public int a() {
            return this.y;
        }
    }

    public static a a() {
        return new i.b();
    }

    public abstract b b();

    public abstract c c();
}