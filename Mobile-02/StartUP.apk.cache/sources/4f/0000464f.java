package e.f.j.i;

import android.graphics.ColorSpace;
import android.util.Pair;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.h;
import com.facebook.imageutils.HeifExifUtil;
import e.f.d.c.i;
import e.f.d.c.l;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: EncodedImage.java */
/* loaded from: classes2.dex */
public class d implements Closeable {
    private final com.facebook.common.references.a<PooledByteBuffer> a;

    /* renamed from: b  reason: collision with root package name */
    private final l<FileInputStream> f12568b;

    /* renamed from: c  reason: collision with root package name */
    private e.f.i.c f12569c;

    /* renamed from: d  reason: collision with root package name */
    private int f12570d;

    /* renamed from: e  reason: collision with root package name */
    private int f12571e;

    /* renamed from: f  reason: collision with root package name */
    private int f12572f;

    /* renamed from: g  reason: collision with root package name */
    private int f12573g;

    /* renamed from: h  reason: collision with root package name */
    private int f12574h;

    /* renamed from: j  reason: collision with root package name */
    private int f12575j;

    /* renamed from: k  reason: collision with root package name */
    private com.facebook.imagepipeline.common.a f12576k;

    /* renamed from: l  reason: collision with root package name */
    private ColorSpace f12577l;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.f12569c = e.f.i.c.a;
        this.f12570d = -1;
        this.f12571e = 0;
        this.f12572f = -1;
        this.f12573g = -1;
        this.f12574h = 1;
        this.f12575j = -1;
        i.b(com.facebook.common.references.a.G(aVar));
        this.a = aVar.clone();
        this.f12568b = null;
    }

    public static boolean V(d dVar) {
        return dVar.f12570d >= 0 && dVar.f12572f >= 0 && dVar.f12573g >= 0;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public static void c(d dVar) {
        if (dVar != null) {
            dVar.close();
        }
    }

    public static boolean d0(d dVar) {
        return dVar != null && dVar.a0();
    }

    private void g0() {
        if (this.f12572f < 0 || this.f12573g < 0) {
            e0();
        }
    }

    private com.facebook.imageutils.b k0() {
        InputStream inputStream;
        try {
            inputStream = z();
            try {
                com.facebook.imageutils.b b2 = com.facebook.imageutils.a.b(inputStream);
                this.f12577l = b2.a();
                Pair<Integer, Integer> b3 = b2.b();
                if (b3 != null) {
                    this.f12572f = ((Integer) b3.first).intValue();
                    this.f12573g = ((Integer) b3.second).intValue();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    private Pair<Integer, Integer> n0() {
        Pair<Integer, Integer> g2 = com.facebook.imageutils.f.g(z());
        if (g2 != null) {
            this.f12572f = ((Integer) g2.first).intValue();
            this.f12573g = ((Integer) g2.second).intValue();
        }
        return g2;
    }

    public int A() {
        g0();
        return this.f12570d;
    }

    public int G() {
        return this.f12574h;
    }

    public int K() {
        com.facebook.common.references.a<PooledByteBuffer> aVar = this.a;
        if (aVar != null && aVar.n() != null) {
            return this.a.n().size();
        }
        return this.f12575j;
    }

    public int N() {
        g0();
        return this.f12572f;
    }

    public boolean O(int i2) {
        if (this.f12569c == e.f.i.b.a && this.f12568b == null) {
            i.g(this.a);
            PooledByteBuffer n = this.a.n();
            return n.k(i2 + (-2)) == -1 && n.k(i2 - 1) == -39;
        }
        return true;
    }

    public d a() {
        d dVar;
        l<FileInputStream> lVar = this.f12568b;
        if (lVar != null) {
            dVar = new d(lVar, this.f12575j);
        } else {
            com.facebook.common.references.a e2 = com.facebook.common.references.a.e(this.a);
            if (e2 == null) {
                dVar = null;
            } else {
                try {
                    dVar = new d(e2);
                } finally {
                    com.facebook.common.references.a.f(e2);
                }
            }
        }
        if (dVar != null) {
            dVar.d(this);
        }
        return dVar;
    }

    public synchronized boolean a0() {
        boolean z;
        if (!com.facebook.common.references.a.G(this.a)) {
            z = this.f12568b != null;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.f(this.a);
    }

    public void d(d dVar) {
        this.f12569c = dVar.v();
        this.f12572f = dVar.N();
        this.f12573g = dVar.n();
        this.f12570d = dVar.A();
        this.f12571e = dVar.j();
        this.f12574h = dVar.G();
        this.f12575j = dVar.K();
        this.f12576k = dVar.f();
        this.f12577l = dVar.g();
    }

    public com.facebook.common.references.a<PooledByteBuffer> e() {
        return com.facebook.common.references.a.e(this.a);
    }

    public void e0() {
        Pair<Integer, Integer> b2;
        e.f.i.c c2 = e.f.i.d.c(z());
        this.f12569c = c2;
        if (e.f.i.b.b(c2)) {
            b2 = n0();
        } else {
            b2 = k0().b();
        }
        if (c2 == e.f.i.b.a && this.f12570d == -1) {
            if (b2 != null) {
                int b3 = com.facebook.imageutils.c.b(z());
                this.f12571e = b3;
                this.f12570d = com.facebook.imageutils.c.a(b3);
            }
        } else if (c2 == e.f.i.b.f12397k && this.f12570d == -1) {
            int a = HeifExifUtil.a(z());
            this.f12571e = a;
            this.f12570d = com.facebook.imageutils.c.a(a);
        } else {
            this.f12570d = 0;
        }
    }

    public com.facebook.imagepipeline.common.a f() {
        return this.f12576k;
    }

    public ColorSpace g() {
        g0();
        return this.f12577l;
    }

    public int j() {
        g0();
        return this.f12571e;
    }

    public String m(int i2) {
        com.facebook.common.references.a<PooledByteBuffer> e2 = e();
        if (e2 == null) {
            return "";
        }
        int min = Math.min(K(), i2);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer n = e2.n();
            if (n == null) {
                return "";
            }
            n.l(0, bArr, 0, min);
            e2.close();
            StringBuilder sb = new StringBuilder(min * 2);
            for (int i3 = 0; i3 < min; i3++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i3])));
            }
            return sb.toString();
        } finally {
            e2.close();
        }
    }

    public int n() {
        g0();
        return this.f12573g;
    }

    public void o0(com.facebook.imagepipeline.common.a aVar) {
        this.f12576k = aVar;
    }

    public void r0(int i2) {
        this.f12571e = i2;
    }

    public void s0(int i2) {
        this.f12573g = i2;
    }

    public e.f.i.c v() {
        g0();
        return this.f12569c;
    }

    public void w0(e.f.i.c cVar) {
        this.f12569c = cVar;
    }

    public void x0(int i2) {
        this.f12570d = i2;
    }

    public void y0(int i2) {
        this.f12574h = i2;
    }

    public InputStream z() {
        l<FileInputStream> lVar = this.f12568b;
        if (lVar != null) {
            return lVar.get();
        }
        com.facebook.common.references.a e2 = com.facebook.common.references.a.e(this.a);
        if (e2 != null) {
            try {
                return new h((PooledByteBuffer) e2.n());
            } finally {
                com.facebook.common.references.a.f(e2);
            }
        }
        return null;
    }

    public void z0(int i2) {
        this.f12572f = i2;
    }

    public d(l<FileInputStream> lVar) {
        this.f12569c = e.f.i.c.a;
        this.f12570d = -1;
        this.f12571e = 0;
        this.f12572f = -1;
        this.f12573g = -1;
        this.f12574h = 1;
        this.f12575j = -1;
        i.g(lVar);
        this.a = null;
        this.f12568b = lVar;
    }

    public d(l<FileInputStream> lVar, int i2) {
        this(lVar);
        this.f12575j = i2;
    }
}