package com.google.zxing.r.b;

import com.google.zxing.FormatException;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: Version.java */
/* loaded from: classes2.dex */
public final class e {
    private static final e[] a = a();

    /* renamed from: b  reason: collision with root package name */
    private final int f9972b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9973c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9974d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9975e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9976f;

    /* renamed from: g  reason: collision with root package name */
    private final c f9977g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9978h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Version.java */
    /* loaded from: classes2.dex */
    public static final class b {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9979b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f9979b;
        }

        private b(int i2, int i3) {
            this.a = i2;
            this.f9979b = i3;
        }
    }

    private e(int i2, int i3, int i4, int i5, int i6, c cVar) {
        b[] a2;
        this.f9972b = i2;
        this.f9973c = i3;
        this.f9974d = i4;
        this.f9975e = i5;
        this.f9976f = i6;
        this.f9977g = cVar;
        int b2 = cVar.b();
        int i7 = 0;
        for (b bVar : cVar.a()) {
            i7 += bVar.a() * (bVar.b() + b2);
        }
        this.f9978h = i7;
    }

    private static e[] a() {
        return new e[]{new e(1, 10, 10, 8, 8, new c(5, new b(1, 3))), new e(2, 12, 12, 10, 10, new c(7, new b(1, 5))), new e(3, 14, 14, 12, 12, new c(10, new b(1, 8))), new e(4, 16, 16, 14, 14, new c(12, new b(1, 12))), new e(5, 18, 18, 16, 16, new c(14, new b(1, 18))), new e(6, 20, 20, 18, 18, new c(18, new b(1, 22))), new e(7, 22, 22, 20, 20, new c(20, new b(1, 30))), new e(8, 24, 24, 22, 22, new c(24, new b(1, 36))), new e(9, 26, 26, 24, 24, new c(28, new b(1, 44))), new e(10, 32, 32, 14, 14, new c(36, new b(1, 62))), new e(11, 36, 36, 16, 16, new c(42, new b(1, 86))), new e(12, 40, 40, 18, 18, new c(48, new b(1, 114))), new e(13, 44, 44, 20, 20, new c(56, new b(1, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA))), new e(14, 48, 48, 22, 22, new c(68, new b(1, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256))), new e(15, 52, 52, 24, 24, new c(42, new b(2, 102))), new e(16, 64, 64, 14, 14, new c(56, new b(2, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA))), new e(17, 72, 72, 16, 16, new c(36, new b(4, 92))), new e(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new e(19, 88, 88, 20, 20, new c(56, new b(4, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA))), new e(20, 96, 96, 22, 22, new c(68, new b(4, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256))), new e(21, 104, 104, 24, 24, new c(56, new b(6, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA))), new e(22, 120, 120, 18, 18, new c(68, new b(6, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384))), new e(23, CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, 20, 20, new c(62, new b(8, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384))), new e(24, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 22, 22, new c(62, new b(8, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256), new b(2, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA))), new e(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new e(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new e(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new e(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new e(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new e(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static e h(int i2, int i3) throws FormatException {
        e[] eVarArr;
        if ((i2 & 1) == 0 && (i3 & 1) == 0) {
            for (e eVar : a) {
                if (eVar.f9973c == i2 && eVar.f9974d == i3) {
                    return eVar;
                }
            }
            throw FormatException.a();
        }
        throw FormatException.a();
    }

    public int b() {
        return this.f9976f;
    }

    public int c() {
        return this.f9975e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f9977g;
    }

    public int e() {
        return this.f9974d;
    }

    public int f() {
        return this.f9973c;
    }

    public int g() {
        return this.f9978h;
    }

    public int i() {
        return this.f9972b;
    }

    public String toString() {
        return String.valueOf(this.f9972b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Version.java */
    /* loaded from: classes2.dex */
    public static final class c {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f9980b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b[] a() {
            return this.f9980b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.a;
        }

        private c(int i2, b bVar) {
            this.a = i2;
            this.f9980b = new b[]{bVar};
        }

        private c(int i2, b bVar, b bVar2) {
            this.a = i2;
            this.f9980b = new b[]{bVar, bVar2};
        }
    }
}