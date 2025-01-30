package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LinearGradientView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class o extends d {
    private static final float[] v0 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private ReadableArray A0;
    private a.b B0;
    private Matrix C0;
    private c0 w0;
    private c0 x0;
    private c0 y0;
    private c0 z0;

    public o(ReactContext reactContext) {
        super(reactContext);
        this.C0 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public void O() {
        if (this.T != null) {
            a aVar = new a(a.EnumC0214a.LINEAR_GRADIENT, new c0[]{this.w0, this.x0, this.y0, this.z0}, this.B0);
            aVar.e(this.A0);
            Matrix matrix = this.C0;
            if (matrix != null) {
                aVar.f(matrix);
            }
            f0 svgView = getSvgView();
            if (this.B0 == a.b.USER_SPACE_ON_USE) {
                aVar.h(svgView.getCanvasBounds());
            }
            svgView.z(aVar, this.T);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "gradient")
    public void setGradient(ReadableArray readableArray) {
        this.A0 = readableArray;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "gradientTransform")
    public void setGradientTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = v0;
            int c2 = w.c(readableArray, fArr, this.P);
            if (c2 == 6) {
                if (this.C0 == null) {
                    this.C0 = new Matrix();
                }
                this.C0.setValues(fArr);
            } else if (c2 != -1) {
                e.f.d.d.a.A("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.C0 = null;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "gradientUnits")
    public void setGradientUnits(int i2) {
        if (i2 == 0) {
            this.B0 = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.B0 = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x1")
    public void setX1(Dynamic dynamic) {
        this.w0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x2")
    public void setX2(Dynamic dynamic) {
        this.y0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y1")
    public void setY1(Dynamic dynamic) {
        this.x0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y2")
    public void setY2(Dynamic dynamic) {
        this.z0 = c0.b(dynamic);
        invalidate();
    }
}