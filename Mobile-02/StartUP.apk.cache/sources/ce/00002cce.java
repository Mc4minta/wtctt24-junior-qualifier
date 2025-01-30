package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import e.f.d.c.i;
import java.nio.ByteBuffer;

/* compiled from: DefaultDecoder.java */
@TargetApi(21)
/* loaded from: classes2.dex */
public abstract class b implements f {
    private static final Class<?> a = b.class;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f4629b = {-1, -39};

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.imagepipeline.memory.c f4630c;

    /* renamed from: d  reason: collision with root package name */
    private final PreverificationHelper f4631d;

    /* renamed from: e  reason: collision with root package name */
    final androidx.core.util.g<ByteBuffer> f4632e;

    public b(com.facebook.imagepipeline.memory.c cVar, int i2, androidx.core.util.g gVar) {
        this.f4631d = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.f4630c = cVar;
        this.f4632e = gVar;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f4632e.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8 A[Catch: all -> 0x00cb, RuntimeException -> 0x00cd, IllegalArgumentException -> 0x00d6, TRY_LEAVE, TryCatch #7 {IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd, blocks: (B:29:0x006e, B:34:0x0085, B:49:0x00a8, B:41:0x0099, B:45:0x00a1, B:46:0x00a4), top: B:78:0x006e, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.common.references.a<android.graphics.Bitmap> d(java.io.InputStream r10, android.graphics.BitmapFactory.Options r11, android.graphics.Rect r12, android.graphics.ColorSpace r13) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.b.d(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):com.facebook.common.references.a");
    }

    private static BitmapFactory.Options f(e.f.j.i.d dVar, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = dVar.G();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(dVar.z(), null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPreferredConfig = config;
            options.inMutable = true;
            return options;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.facebook.imagepipeline.platform.f
    public com.facebook.common.references.a<Bitmap> a(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options f2 = f(dVar, config);
        boolean z = f2.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return d(dVar.z(), f2, rect, colorSpace);
        } catch (RuntimeException e2) {
            if (z) {
                return a(dVar, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e2;
        }
    }

    @Override // com.facebook.imagepipeline.platform.f
    public com.facebook.common.references.a<Bitmap> b(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, int i2) {
        return c(dVar, config, rect, i2, null);
    }

    @Override // com.facebook.imagepipeline.platform.f
    public com.facebook.common.references.a<Bitmap> c(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, int i2, ColorSpace colorSpace) {
        boolean O = dVar.O(i2);
        BitmapFactory.Options f2 = f(dVar, config);
        e.f.d.g.b z = dVar.z();
        i.g(z);
        if (dVar.K() > i2) {
            z = new e.f.d.g.a(z, i2);
        }
        if (!O) {
            z = new e.f.d.g.b(z, f4629b);
        }
        boolean z2 = f2.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return d(z, f2, rect, colorSpace);
        } catch (RuntimeException e2) {
            if (z2) {
                return c(dVar, Bitmap.Config.ARGB_8888, rect, i2, colorSpace);
            }
            throw e2;
        }
    }

    public abstract int e(int i2, int i3, BitmapFactory.Options options);
}