package e.f.i;

import e.f.d.c.g;
import e.f.d.c.i;
import e.f.i.c;

/* compiled from: DefaultImageFormatChecker.java */
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f12377b;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f12378c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12379d;

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f12380e = e.a("GIF87a");

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f12381f = e.a("GIF89a");

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f12382g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f12383h;

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f12384i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f12385j;

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f12386k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f12387l;
    final int m = g.a(21, 20, f12377b, f12379d, 6, f12383h, f12385j, f12387l);

    static {
        String[] strArr;
        byte[] bArr = {-1, -40, -1};
        a = bArr;
        f12377b = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        f12378c = bArr2;
        f12379d = bArr2.length;
        byte[] a2 = e.a("BM");
        f12382g = a2;
        f12383h = a2.length;
        byte[] bArr3 = {0, 0, 1, 0};
        f12384i = bArr3;
        f12385j = bArr3.length;
        f12386k = new String[]{"heic", "heix", "hevc", "hevx", "mif1", "msf1"};
        f12387l = e.a("ftyp" + strArr[0]).length;
    }

    private static c c(byte[] bArr, int i2) {
        i.b(e.f.d.h.c.h(bArr, 0, i2));
        if (e.f.d.h.c.g(bArr, 0)) {
            return b.f12392f;
        }
        if (e.f.d.h.c.f(bArr, 0)) {
            return b.f12393g;
        }
        if (e.f.d.h.c.c(bArr, 0, i2)) {
            if (e.f.d.h.c.b(bArr, 0)) {
                return b.f12396j;
            }
            if (e.f.d.h.c.d(bArr, 0)) {
                return b.f12395i;
            }
            return b.f12394h;
        }
        return c.a;
    }

    private static boolean d(byte[] bArr, int i2) {
        byte[] bArr2 = f12382g;
        if (i2 < bArr2.length) {
            return false;
        }
        return e.c(bArr, bArr2);
    }

    private static boolean e(byte[] bArr, int i2) {
        if (i2 < 6) {
            return false;
        }
        return e.c(bArr, f12380e) || e.c(bArr, f12381f);
    }

    private static boolean f(byte[] bArr, int i2) {
        String[] strArr;
        if (i2 >= f12387l && bArr[3] >= 8) {
            for (String str : f12386k) {
                if (e.b(bArr, bArr.length, e.a("ftyp" + str), f12387l) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean g(byte[] bArr, int i2) {
        byte[] bArr2 = f12384i;
        if (i2 < bArr2.length) {
            return false;
        }
        return e.c(bArr, bArr2);
    }

    private static boolean h(byte[] bArr, int i2) {
        byte[] bArr2 = a;
        return i2 >= bArr2.length && e.c(bArr, bArr2);
    }

    private static boolean i(byte[] bArr, int i2) {
        byte[] bArr2 = f12378c;
        return i2 >= bArr2.length && e.c(bArr, bArr2);
    }

    @Override // e.f.i.c.a
    public int a() {
        return this.m;
    }

    @Override // e.f.i.c.a
    public final c b(byte[] bArr, int i2) {
        i.g(bArr);
        if (e.f.d.h.c.h(bArr, 0, i2)) {
            return c(bArr, i2);
        }
        if (h(bArr, i2)) {
            return b.a;
        }
        if (i(bArr, i2)) {
            return b.f12388b;
        }
        if (e(bArr, i2)) {
            return b.f12389c;
        }
        if (d(bArr, i2)) {
            return b.f12390d;
        }
        if (g(bArr, i2)) {
            return b.f12391e;
        }
        if (f(bArr, i2)) {
            return b.f12397k;
        }
        return c.a;
    }
}