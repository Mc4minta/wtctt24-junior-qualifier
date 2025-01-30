package e.f.j.i;

import android.graphics.Bitmap;
import e.f.d.c.i;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: CloseableStaticBitmap.java */
/* loaded from: classes2.dex */
public class c extends a {
    private com.facebook.common.references.a<Bitmap> a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Bitmap f12564b;

    /* renamed from: c  reason: collision with root package name */
    private final g f12565c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12566d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12567e;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i2) {
        this(bitmap, cVar, gVar, i2, 0);
    }

    private synchronized com.facebook.common.references.a<Bitmap> e() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.a;
        this.a = null;
        this.f12564b = null;
        return aVar;
    }

    private static int f(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    private static int g(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    @Override // e.f.j.i.b
    public g a() {
        return this.f12565c;
    }

    @Override // e.f.j.i.b
    public int b() {
        return com.facebook.imageutils.a.e(this.f12564b);
    }

    @Override // e.f.j.i.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> e2 = e();
        if (e2 != null) {
            e2.close();
        }
    }

    @Override // e.f.j.i.a
    public Bitmap d() {
        return this.f12564b;
    }

    @Override // e.f.j.i.e
    public int getHeight() {
        int i2;
        if (this.f12566d % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 0 && (i2 = this.f12567e) != 5 && i2 != 7) {
            return f(this.f12564b);
        }
        return g(this.f12564b);
    }

    @Override // e.f.j.i.e
    public int getWidth() {
        int i2;
        if (this.f12566d % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 0 && (i2 = this.f12567e) != 5 && i2 != 7) {
            return g(this.f12564b);
        }
        return f(this.f12564b);
    }

    @Override // e.f.j.i.b
    public synchronized boolean isClosed() {
        return this.a == null;
    }

    public int j() {
        return this.f12567e;
    }

    public int m() {
        return this.f12566d;
    }

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i2, int i3) {
        this.f12564b = (Bitmap) i.g(bitmap);
        this.a = com.facebook.common.references.a.e0(this.f12564b, (com.facebook.common.references.c) i.g(cVar));
        this.f12565c = gVar;
        this.f12566d = i2;
        this.f12567e = i3;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> aVar2 = (com.facebook.common.references.a) i.g(aVar.d());
        this.a = aVar2;
        this.f12564b = aVar2.n();
        this.f12565c = gVar;
        this.f12566d = i2;
        this.f12567e = i3;
    }
}