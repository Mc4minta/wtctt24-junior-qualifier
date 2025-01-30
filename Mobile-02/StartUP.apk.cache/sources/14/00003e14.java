package com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: SourceData.java */
/* loaded from: classes2.dex */
public class o {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f10388b;

    /* renamed from: c  reason: collision with root package name */
    private int f10389c;

    /* renamed from: d  reason: collision with root package name */
    private int f10390d;

    /* renamed from: e  reason: collision with root package name */
    private int f10391e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f10392f;

    public o(byte[] bArr, int i2, int i3, int i4, int i5) {
        this.a = bArr;
        this.f10388b = i2;
        this.f10389c = i3;
        this.f10391e = i5;
        this.f10390d = i4;
        if (i2 * i3 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i2 + "x" + i3 + " > " + bArr.length);
    }

    private Bitmap c(Rect rect, int i2) {
        if (d()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.a, this.f10390d, this.f10388b, this.f10389c, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i2;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f10391e != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(this.f10391e);
            return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
        }
        return decodeByteArray;
    }

    public static byte[] e(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        byte[] bArr2 = new byte[i4];
        int i5 = i4 - 1;
        for (int i6 = 0; i6 < i4; i6++) {
            bArr2[i5] = bArr[i6];
            i5--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        byte[] bArr2 = new byte[i4];
        int i5 = i4 - 1;
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = i3 - 1; i7 >= 0; i7--) {
                bArr2[i5] = bArr[(i7 * i2) + i6];
                i5--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i2 * i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = i3 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i2) + i5];
                i4++;
            }
        }
        return bArr2;
    }

    public static byte[] h(int i2, byte[] bArr, int i3, int i4) {
        if (i2 != 90) {
            if (i2 != 180) {
                return i2 != 270 ? bArr : f(bArr, i3, i4);
            }
            return e(bArr, i3, i4);
        }
        return g(bArr, i3, i4);
    }

    public com.google.zxing.i a() {
        byte[] h2 = h(this.f10391e, this.a, this.f10388b, this.f10389c);
        if (d()) {
            int i2 = this.f10389c;
            int i3 = this.f10388b;
            Rect rect = this.f10392f;
            return new com.google.zxing.i(h2, i2, i3, rect.left, rect.top, rect.width(), this.f10392f.height(), false);
        }
        int i4 = this.f10388b;
        int i5 = this.f10389c;
        Rect rect2 = this.f10392f;
        return new com.google.zxing.i(h2, i4, i5, rect2.left, rect2.top, rect2.width(), this.f10392f.height(), false);
    }

    public Bitmap b(int i2) {
        return c(this.f10392f, i2);
    }

    public boolean d() {
        return this.f10391e % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 != 0;
    }

    public void i(Rect rect) {
        this.f10392f = rect;
    }
}