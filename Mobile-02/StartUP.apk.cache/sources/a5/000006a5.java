package com.BV.LinearGradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.o;

/* compiled from: LinearGradientView.java */
/* loaded from: classes.dex */
public class b extends View {
    private final Paint a;

    /* renamed from: b  reason: collision with root package name */
    private Path f3481b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f3482c;

    /* renamed from: d  reason: collision with root package name */
    private LinearGradient f3483d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f3484e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f3485f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f3486g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f3487h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3488j;

    /* renamed from: k  reason: collision with root package name */
    private float[] f3489k;

    /* renamed from: l  reason: collision with root package name */
    private float f3490l;
    private int[] m;
    private float[] n;

    public b(Context context) {
        super(context);
        this.a = new Paint(1);
        this.f3485f = new float[]{0.0f, 0.0f};
        this.f3486g = new float[]{0.0f, 1.0f};
        this.f3488j = false;
        this.f3489k = new float[]{0.5f, 0.5f};
        this.f3490l = 45.0f;
        this.m = new int[]{0, 0};
        this.n = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] a(float f2) {
        float sqrt = (float) Math.sqrt(2.0d);
        double d2 = (f2 - 90.0f) * 0.017453292f;
        return new float[]{((float) Math.cos(d2)) * sqrt, ((float) Math.sin(d2)) * sqrt};
    }

    private void b() {
        int[] iArr = this.f3487h;
        if (iArr != null) {
            float[] fArr = this.f3484e;
            if (fArr == null || iArr.length == fArr.length) {
                float[] fArr2 = this.f3485f;
                float[] fArr3 = this.f3486g;
                if (this.f3488j && this.f3489k != null) {
                    float[] a = a(this.f3490l);
                    float[] fArr4 = this.f3489k;
                    float[] fArr5 = {fArr4[0] - (a[0] / 2.0f), fArr4[1] - (a[1] / 2.0f)};
                    fArr3 = new float[]{fArr4[0] + (a[0] / 2.0f), fArr4[1] + (a[1] / 2.0f)};
                    fArr2 = fArr5;
                }
                float f2 = fArr2[0];
                int[] iArr2 = this.m;
                LinearGradient linearGradient = new LinearGradient(iArr2[0] * f2, fArr2[1] * iArr2[1], fArr3[0] * iArr2[0], fArr3[1] * iArr2[1], this.f3487h, this.f3484e, Shader.TileMode.CLAMP);
                this.f3483d = linearGradient;
                this.a.setShader(linearGradient);
                invalidate();
            }
        }
    }

    private void c() {
        if (this.f3481b == null) {
            this.f3481b = new Path();
            this.f3482c = new RectF();
        }
        this.f3481b.reset();
        RectF rectF = this.f3482c;
        int[] iArr = this.m;
        rectF.set(0.0f, 0.0f, iArr[0], iArr[1]);
        this.f3481b.addRoundRect(this.f3482c, this.n, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.f3481b;
        if (path == null) {
            canvas.drawPaint(this.a);
        } else {
            canvas.drawPath(path, this.a);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.m = new int[]{i2, i3};
        c();
        b();
    }

    public void setAngle(float f2) {
        this.f3490l = f2;
        b();
    }

    public void setAngleCenter(ReadableArray readableArray) {
        this.f3489k = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        b();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = o.c((float) readableArray.getDouble(i2));
        }
        this.n = fArr;
        c();
        b();
    }

    public void setColors(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = readableArray.getInt(i2);
        }
        this.f3487h = iArr;
        b();
    }

    public void setEndPosition(ReadableArray readableArray) {
        this.f3486g = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        b();
    }

    public void setLocations(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = (float) readableArray.getDouble(i2);
        }
        this.f3484e = fArr;
        b();
    }

    public void setStartPosition(ReadableArray readableArray) {
        this.f3485f = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        b();
    }

    public void setUseAngle(boolean z) {
        this.f3488j = z;
        b();
    }
}