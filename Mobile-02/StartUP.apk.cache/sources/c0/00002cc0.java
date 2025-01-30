package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import e.f.d.c.i;
import e.f.d.c.n;
import java.util.Locale;

@e.f.d.c.d
/* loaded from: classes2.dex */
public abstract class DalvikPurgeableDecoder implements com.facebook.imagepipeline.platform.f {
    protected static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.imagepipeline.memory.a f4624b = com.facebook.imagepipeline.memory.b.a();

    /* JADX INFO: Access modifiers changed from: private */
    @com.facebook.soloader.d
    /* loaded from: classes2.dex */
    public static class OreoUtils {
        private OreoUtils() {
        }

        @TargetApi(26)
        static void a(BitmapFactory.Options options, ColorSpace colorSpace) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
    }

    static {
        a.a();
        a = new byte[]{-1, -39};
    }

    public static boolean f(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2) {
        PooledByteBuffer n = aVar.n();
        return i2 >= 2 && n.k(i2 + (-2)) == -1 && n.k(i2 - 1) == -39;
    }

    public static BitmapFactory.Options g(int i2, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        if (Build.VERSION.SDK_INT >= 11) {
            options.inMutable = true;
        }
        return options;
    }

    @e.f.d.c.d
    private static native void nativePinBitmap(Bitmap bitmap);

    @Override // com.facebook.imagepipeline.platform.f
    public com.facebook.common.references.a<Bitmap> a(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options g2 = g(dVar.G(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.a(g2, colorSpace);
        }
        com.facebook.common.references.a<PooledByteBuffer> e2 = dVar.e();
        i.g(e2);
        try {
            return h(d(e2, g2));
        } finally {
            com.facebook.common.references.a.f(e2);
        }
    }

    @Override // com.facebook.imagepipeline.platform.f
    public com.facebook.common.references.a<Bitmap> b(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, int i2) {
        return c(dVar, config, rect, i2, null);
    }

    @Override // com.facebook.imagepipeline.platform.f
    public com.facebook.common.references.a<Bitmap> c(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, int i2, ColorSpace colorSpace) {
        BitmapFactory.Options g2 = g(dVar.G(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.a(g2, colorSpace);
        }
        com.facebook.common.references.a<PooledByteBuffer> e2 = dVar.e();
        i.g(e2);
        try {
            return h(e(e2, i2, g2));
        } finally {
            com.facebook.common.references.a.f(e2);
        }
    }

    protected abstract Bitmap d(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    protected abstract Bitmap e(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, BitmapFactory.Options options);

    public com.facebook.common.references.a<Bitmap> h(Bitmap bitmap) {
        i.g(bitmap);
        try {
            nativePinBitmap(bitmap);
            if (this.f4624b.g(bitmap)) {
                return com.facebook.common.references.a.e0(bitmap, this.f4624b.e());
            }
            int e2 = com.facebook.imageutils.a.e(bitmap);
            bitmap.recycle();
            throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(e2), Integer.valueOf(this.f4624b.b()), Long.valueOf(this.f4624b.f()), Integer.valueOf(this.f4624b.c()), Integer.valueOf(this.f4624b.d())));
        } catch (Exception e3) {
            bitmap.recycle();
            throw n.a(e3);
        }
    }
}