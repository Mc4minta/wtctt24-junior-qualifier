package e.f.j.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.memory.PooledByteBuffer;

/* compiled from: HoneycombBitmapFactory.java */
@TargetApi(11)
/* loaded from: classes2.dex */
public class e extends f {
    private static final String a = "e";

    /* renamed from: b  reason: collision with root package name */
    private final b f12416b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.imagepipeline.platform.f f12417c;

    /* renamed from: d  reason: collision with root package name */
    private final e.f.j.e.a f12418d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12419e;

    public e(b bVar, com.facebook.imagepipeline.platform.f fVar, e.f.j.e.a aVar) {
        this.f12416b = bVar;
        this.f12417c = fVar;
        this.f12418d = aVar;
    }

    private com.facebook.common.references.a<Bitmap> e(int i2, int i3, Bitmap.Config config) {
        return this.f12418d.c(Bitmap.createBitmap(i2, i3, config), h.a());
    }

    @Override // e.f.j.c.f
    @TargetApi(12)
    public com.facebook.common.references.a<Bitmap> d(int i2, int i3, Bitmap.Config config) {
        if (this.f12419e) {
            return e(i2, i3, config);
        }
        com.facebook.common.references.a<PooledByteBuffer> a2 = this.f12416b.a((short) i2, (short) i3);
        try {
            e.f.j.i.d dVar = new e.f.j.i.d(a2);
            dVar.w0(e.f.i.b.a);
            com.facebook.common.references.a<Bitmap> b2 = this.f12417c.b(dVar, config, null, a2.n().size());
            if (!b2.n().isMutable()) {
                com.facebook.common.references.a.f(b2);
                this.f12419e = true;
                e.f.d.d.a.F(a, "Immutable bitmap returned by decoder");
                com.facebook.common.references.a<Bitmap> e2 = e(i2, i3, config);
                e.f.j.i.d.c(dVar);
                return e2;
            }
            b2.n().setHasAlpha(true);
            b2.n().eraseColor(0);
            e.f.j.i.d.c(dVar);
            return b2;
        } finally {
            a2.close();
        }
    }
}