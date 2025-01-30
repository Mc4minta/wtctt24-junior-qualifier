package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PatternView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class u extends l {
    private static final float[] P0 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private c0 Q0;
    private c0 R0;
    private c0 S0;
    private c0 T0;
    private a.b U0;
    private a.b V0;
    private float W0;
    private float X0;
    private float Y0;
    private float Z0;
    String a1;
    int b1;
    private Matrix c1;

    public u(ReactContext reactContext) {
        super(reactContext);
        this.c1 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l, com.horcrux.svg.x0
    public void O() {
        if (this.T != null) {
            a aVar = new a(a.EnumC0214a.PATTERN, new c0[]{this.Q0, this.R0, this.S0, this.T0}, this.U0);
            aVar.d(this.V0);
            aVar.g(this);
            Matrix matrix = this.c1;
            if (matrix != null) {
                aVar.f(matrix);
            }
            f0 svgView = getSvgView();
            a.b bVar = this.U0;
            a.b bVar2 = a.b.USER_SPACE_ON_USE;
            if (bVar == bVar2 || this.V0 == bVar2) {
                aVar.h(svgView.getCanvasBounds());
            }
            svgView.z(aVar, this.T);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF getViewBox() {
        float f2 = this.W0;
        float f3 = this.P;
        float f4 = this.X0;
        return new RectF(f2 * f3, f4 * f3, (f2 + this.Y0) * f3, (f4 + this.Z0) * f3);
    }

    @com.facebook.react.uimanager.c1.a(name = "align")
    public void setAlign(String str) {
        this.a1 = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.T0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
    public void setMeetOrSlice(int i2) {
        this.b1 = i2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "minX")
    public void setMinX(float f2) {
        this.W0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "minY")
    public void setMinY(float f2) {
        this.X0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "patternContentUnits")
    public void setPatternContentUnits(int i2) {
        if (i2 == 0) {
            this.V0 = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.V0 = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "patternTransform")
    public void setPatternTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = P0;
            int c2 = w.c(readableArray, fArr, this.P);
            if (c2 == 6) {
                if (this.c1 == null) {
                    this.c1 = new Matrix();
                }
                this.c1.setValues(fArr);
            } else if (c2 != -1) {
                e.f.d.d.a.A("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.c1 = null;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "patternUnits")
    public void setPatternUnits(int i2) {
        if (i2 == 0) {
            this.U0 = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.U0 = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "vbHeight")
    public void setVbHeight(float f2) {
        this.Z0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "vbWidth")
    public void setVbWidth(float f2) {
        this.Y0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.S0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x")
    public void setX(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y")
    public void setY(Dynamic dynamic) {
        this.R0 = c0.b(dynamic);
        invalidate();
    }
}