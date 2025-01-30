package e.f.j.k;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import e.f.b.a.d;
import e.f.b.a.i;

/* compiled from: IterativeBoxBlurPostProcessor.java */
/* loaded from: classes2.dex */
public class a extends com.facebook.imagepipeline.request.a {

    /* renamed from: b  reason: collision with root package name */
    private final int f12581b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12582c;

    /* renamed from: d  reason: collision with root package name */
    private d f12583d;

    public a(int i2) {
        this(3, i2);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.c
    public d c() {
        if (this.f12583d == null) {
            this.f12583d = new i(String.format(null, "i%dr%d", Integer.valueOf(this.f12581b), Integer.valueOf(this.f12582c)));
        }
        return this.f12583d;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void e(Bitmap bitmap) {
        NativeBlurFilter.a(bitmap, this.f12581b, this.f12582c);
    }

    public a(int i2, int i3) {
        e.f.d.c.i.b(i2 > 0);
        e.f.d.c.i.b(i3 > 0);
        this.f12581b = i2;
        this.f12582c = i3;
    }
}