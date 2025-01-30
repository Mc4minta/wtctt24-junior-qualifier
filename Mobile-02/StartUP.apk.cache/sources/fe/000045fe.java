package e.f.j.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import e.f.d.c.i;

/* compiled from: ArtBitmapFactory.java */
@TargetApi(21)
/* loaded from: classes2.dex */
public class a extends f {
    private final com.facebook.imagepipeline.memory.c a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.e.a f12412b;

    public a(com.facebook.imagepipeline.memory.c cVar, e.f.j.e.a aVar) {
        this.a = cVar;
        this.f12412b = aVar;
    }

    @Override // e.f.j.c.f
    public com.facebook.common.references.a<Bitmap> d(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap = this.a.get(com.facebook.imageutils.a.d(i2, i3, config));
        i.b(bitmap.getAllocationByteCount() >= (i2 * i3) * com.facebook.imageutils.a.c(config));
        bitmap.reconfigure(i2, i3, config);
        return this.f12412b.c(bitmap, this.a);
    }
}