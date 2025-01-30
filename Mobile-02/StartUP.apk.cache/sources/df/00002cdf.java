package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.g;
import e.f.d.c.i;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: BitmapUtil.java */
/* loaded from: classes2.dex */
public final class a {
    private static final g<ByteBuffer> a = new g<>(12);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapUtil.java */
    /* renamed from: com.facebook.imageutils.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0110a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Pair<Integer, Integer> a(InputStream inputStream) {
        i.g(inputStream);
        g<ByteBuffer> gVar = a;
        ByteBuffer acquire = gVar.acquire();
        if (acquire == null) {
            acquire = ByteBuffer.allocate(16384);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = acquire.array();
            Pair<Integer, Integer> pair = null;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outWidth != -1 && options.outHeight != -1) {
                pair = new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
            }
            gVar.release(acquire);
            return pair;
        } catch (Throwable th) {
            a.release(acquire);
            throw th;
        }
    }

    public static b b(InputStream inputStream) {
        i.g(inputStream);
        g<ByteBuffer> gVar = a;
        ByteBuffer acquire = gVar.acquire();
        if (acquire == null) {
            acquire = ByteBuffer.allocate(16384);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = acquire.array();
            BitmapFactory.decodeStream(inputStream, null, options);
            b bVar = new b(options.outWidth, options.outHeight, Build.VERSION.SDK_INT >= 26 ? options.outColorSpace : null);
            gVar.release(acquire);
            return bVar;
        } catch (Throwable th) {
            a.release(acquire);
            throw th;
        }
    }

    public static int c(Bitmap.Config config) {
        int i2 = C0110a.a[config.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return 2;
                }
                if (i2 == 5) {
                    return 8;
                }
                throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
            }
            return 1;
        }
        return 4;
    }

    public static int d(int i2, int i3, Bitmap.Config config) {
        return i2 * i3 * c(config);
    }

    @SuppressLint({"NewApi"})
    public static int e(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT > 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}