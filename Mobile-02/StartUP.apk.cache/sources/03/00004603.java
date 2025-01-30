package e.f.j.c;

import android.graphics.Bitmap;

/* compiled from: PlatformBitmapFactory.java */
/* loaded from: classes2.dex */
public abstract class f {
    public com.facebook.common.references.a<Bitmap> a(int i2, int i3) {
        return b(i2, i3, Bitmap.Config.ARGB_8888);
    }

    public com.facebook.common.references.a<Bitmap> b(int i2, int i3, Bitmap.Config config) {
        return c(i2, i3, config, null);
    }

    public com.facebook.common.references.a<Bitmap> c(int i2, int i3, Bitmap.Config config, Object obj) {
        return d(i2, i3, config);
    }

    public abstract com.facebook.common.references.a<Bitmap> d(int i2, int i3, Bitmap.Config config);
}