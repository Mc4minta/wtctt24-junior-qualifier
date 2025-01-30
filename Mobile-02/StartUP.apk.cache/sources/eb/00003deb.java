package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RadialGradientView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class z extends d {
    private static final float[] v0 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private c0 A0;
    private c0 B0;
    private ReadableArray C0;
    private a.b D0;
    private Matrix E0;
    private c0 w0;
    private c0 x0;
    private c0 y0;
    private c0 z0;

    public z(ReactContext reactContext) {
        super(reactContext);
        this.E0 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public void O() {
        if (this.T != null) {
            a aVar = new a(a.EnumC0214a.RADIAL_GRADIENT, new c0[]{this.w0, this.x0, this.y0, this.z0, this.A0, this.B0}, this.D0);
            aVar.e(this.C0);
            Matrix matrix = this.E0;
            if (matrix != null) {
                aVar.f(matrix);
            }
            f0 svgView = getSvgView();
            if (this.D0 == a.b.USER_SPACE_ON_USE) {
                aVar.h(svgView.getCanvasBounds());
            }
            svgView.z(aVar, this.T);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "cx")
    public void setCx(Dynamic dynamic) {
        this.A0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "cy")
    public void setCy(Dynamic dynamic) {
        this.B0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "fx")
    public void setFx(Dynamic dynamic) {
        this.w0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "fy")
    public void setFy(Dynamic dynamic) {
        this.x0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "gradient")
    public void setGradient(ReadableArray readableArray) {
        this.C0 = readableArray;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "gradientTransform")
    public void setGradientTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = v0;
            int c2 = w.c(readableArray, fArr, this.P);
            if (c2 == 6) {
                if (this.E0 == null) {
                    this.E0 = new Matrix();
                }
                this.E0.setValues(fArr);
            } else if (c2 != -1) {
                e.f.d.d.a.A("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.E0 = null;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "gradientUnits")
    public void setGradientUnits(int i2) {
        if (i2 == 0) {
            this.D0 = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.D0 = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.y0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.z0 = c0.b(dynamic);
        invalidate();
    }
}