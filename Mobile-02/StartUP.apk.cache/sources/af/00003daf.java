package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.c0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Brush.java */
/* loaded from: classes2.dex */
public class a {
    private final EnumC0214a a;

    /* renamed from: b  reason: collision with root package name */
    private final c0[] f10199b;

    /* renamed from: c  reason: collision with root package name */
    private ReadableArray f10200c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10201d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10202e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f10203f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f10204g;

    /* renamed from: h  reason: collision with root package name */
    private u f10205h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Brush.java */
    /* renamed from: com.horcrux.svg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0214a {
        LINEAR_GRADIENT,
        RADIAL_GRADIENT,
        PATTERN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Brush.java */
    /* loaded from: classes2.dex */
    public enum b {
        OBJECT_BOUNDING_BOX,
        USER_SPACE_ON_USE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(EnumC0214a enumC0214a, c0[] c0VarArr, b bVar) {
        this.a = enumC0214a;
        this.f10199b = c0VarArr;
        this.f10201d = bVar == b.OBJECT_BOUNDING_BOX;
    }

    private RectF a(RectF rectF) {
        float f2;
        if (!this.f10201d) {
            rectF = new RectF(this.f10204g);
        }
        float width = rectF.width();
        float height = rectF.height();
        float f3 = 0.0f;
        if (this.f10201d) {
            f3 = rectF.left;
            f2 = rectF.top;
        } else {
            f2 = 0.0f;
        }
        return new RectF(f3, f2, width + f3, height + f2);
    }

    private double b(c0 c0Var, double d2, float f2, float f3) {
        double d3;
        if (this.f10201d && c0Var.f10211b == c0.b.NUMBER) {
            d3 = d2;
            return w.a(c0Var, d2, 0.0d, d3, f3);
        }
        d3 = f2;
        return w.a(c0Var, d2, 0.0d, d3, f3);
    }

    private static void c(ReadableArray readableArray, int i2, float[] fArr, int[] iArr, float f2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            fArr[i3] = (float) readableArray.getDouble(i4);
            int i5 = readableArray.getInt(i4 + 1);
            iArr[i3] = (i5 & 16777215) | (Math.round((i5 >>> 24) * f2) << 24);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(b bVar) {
        this.f10202e = bVar == b.OBJECT_BOUNDING_BOX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ReadableArray readableArray) {
        this.f10200c = readableArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Matrix matrix) {
        this.f10203f = matrix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(u uVar) {
        this.f10205h = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Rect rect) {
        this.f10204g = rect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Paint paint, RectF rectF, float f2, float f3) {
        int[] iArr;
        float[] fArr;
        RectF a = a(rectF);
        float width = a.width();
        float height = a.height();
        float f4 = a.left;
        float f5 = a.top;
        float textSize = paint.getTextSize();
        if (this.a == EnumC0214a.PATTERN) {
            double d2 = width;
            double b2 = b(this.f10199b[0], d2, f2, textSize);
            double d3 = height;
            double b3 = b(this.f10199b[1], d3, f2, textSize);
            double b4 = b(this.f10199b[2], d2, f2, textSize);
            double b5 = b(this.f10199b[3], d3, f2, textSize);
            if (b4 <= 1.0d || b5 <= 1.0d) {
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap((int) b4, (int) b5, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            RectF viewBox = this.f10205h.getViewBox();
            if (viewBox != null && viewBox.width() > 0.0f && viewBox.height() > 0.0f) {
                RectF rectF2 = new RectF((float) b2, (float) b3, (float) b4, (float) b5);
                u uVar = this.f10205h;
                canvas.concat(w0.a(viewBox, rectF2, uVar.a1, uVar.b1));
            }
            if (this.f10202e) {
                canvas.scale(width / f2, height / f2);
            }
            this.f10205h.C(canvas, new Paint(), f3);
            Matrix matrix = new Matrix();
            Matrix matrix2 = this.f10203f;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            return;
        }
        int size = this.f10200c.size();
        if (size == 0) {
            e.f.d.d.a.A("ReactNative", "Gradient contains no stops");
            return;
        }
        int i2 = size / 2;
        int[] iArr2 = new int[i2];
        float[] fArr2 = new float[i2];
        c(this.f10200c, i2, fArr2, iArr2, f3);
        if (i2 == 1) {
            int[] iArr3 = {iArr2[0], iArr2[0]};
            float[] fArr3 = {fArr2[0], fArr2[0]};
            e.f.d.d.a.A("ReactNative", "Gradient contains only one stop");
            iArr = iArr3;
            fArr = fArr3;
        } else {
            iArr = iArr2;
            fArr = fArr2;
        }
        EnumC0214a enumC0214a = this.a;
        if (enumC0214a == EnumC0214a.LINEAR_GRADIENT) {
            double d4 = width;
            double b6 = b(this.f10199b[0], d4, f2, textSize);
            double d5 = f4;
            double d6 = height;
            double d7 = f5;
            Shader linearGradient = new LinearGradient((float) (b6 + d5), (float) (b(this.f10199b[1], d6, f2, textSize) + d7), (float) (b(this.f10199b[2], d4, f2, textSize) + d5), (float) (b(this.f10199b[3], d6, f2, textSize) + d7), iArr, fArr, Shader.TileMode.CLAMP);
            if (this.f10203f != null) {
                Matrix matrix3 = new Matrix();
                matrix3.preConcat(this.f10203f);
                linearGradient.setLocalMatrix(matrix3);
            }
            paint.setShader(linearGradient);
        } else if (enumC0214a == EnumC0214a.RADIAL_GRADIENT) {
            double d8 = width;
            double b7 = b(this.f10199b[2], d8, f2, textSize);
            double d9 = height;
            double b8 = b(this.f10199b[3], d9, f2, textSize) / b7;
            Shader radialGradient = new RadialGradient((float) (b(this.f10199b[4], d8, f2, textSize) + f4), (float) (b(this.f10199b[5], d9 / b8, f2, textSize) + (f5 / b8)), (float) b7, iArr, fArr, Shader.TileMode.CLAMP);
            Matrix matrix4 = new Matrix();
            matrix4.preScale(1.0f, (float) b8);
            Matrix matrix5 = this.f10203f;
            if (matrix5 != null) {
                matrix4.preConcat(matrix5);
            }
            radialGradient.setLocalMatrix(matrix4);
            paint.setShader(radialGradient);
        }
    }
}