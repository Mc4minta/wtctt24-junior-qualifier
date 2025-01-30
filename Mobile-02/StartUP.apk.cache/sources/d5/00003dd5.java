package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MarkerView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class p extends l {
    private c0 P0;
    private c0 Q0;
    private c0 R0;
    private c0 S0;
    private String T0;
    private String U0;
    private float V0;
    private float W0;
    private float X0;
    private float Y0;
    String Z0;
    int a1;
    Matrix b1;

    public p(ReactContext reactContext) {
        super(reactContext);
        this.b1 = new Matrix();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l, com.horcrux.svg.x0
    public void O() {
        if (this.T != null) {
            getSvgView().B(this, this.T);
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x0) {
                    ((x0) childAt).O();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(Canvas canvas, Paint paint, float f2, x xVar, float f3) {
        int N = N(canvas, this.z);
        this.b1.reset();
        v vVar = xVar.f10321i;
        Matrix matrix = this.b1;
        float f4 = this.P;
        matrix.setTranslate(((float) vVar.a) * f4, ((float) vVar.f10313b) * f4);
        double parseDouble = "auto".equals(this.U0) ? -1.0d : Double.parseDouble(this.U0);
        if (parseDouble == -1.0d) {
            parseDouble = xVar.f10322j;
        }
        this.b1.preRotate(((float) parseDouble) + 180.0f);
        if ("strokeWidth".equals(this.T0)) {
            this.b1.preScale(f3, f3);
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) (K(this.R0) / this.P), (float) (I(this.S0) / this.P));
        if (this.Z0 != null) {
            float f5 = this.V0;
            float f6 = this.P;
            float f7 = this.W0;
            Matrix a = w0.a(new RectF(f5 * f6, f7 * f6, (f5 + this.X0) * f6, (f7 + this.Y0) * f6), rectF, this.Z0, this.a1);
            float[] fArr = new float[9];
            a.getValues(fArr);
            this.b1.preScale(fArr[0], fArr[4]);
        }
        this.b1.preTranslate((float) (-K(this.P0)), (float) (-I(this.Q0)));
        canvas.concat(this.b1);
        Z(canvas, paint, f2);
        M(canvas, N);
    }

    @com.facebook.react.uimanager.c1.a(name = "align")
    public void setAlign(String str) {
        this.Z0 = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "markerHeight")
    public void setMarkerHeight(Dynamic dynamic) {
        this.S0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "markerUnits")
    public void setMarkerUnits(String str) {
        this.T0 = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "markerWidth")
    public void setMarkerWidth(Dynamic dynamic) {
        this.R0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
    public void setMeetOrSlice(int i2) {
        this.a1 = i2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "minX")
    public void setMinX(float f2) {
        this.V0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "minY")
    public void setMinY(float f2) {
        this.W0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "orient")
    public void setOrient(String str) {
        this.U0 = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "refX")
    public void setRefX(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "refY")
    public void setRefY(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "vbHeight")
    public void setVbHeight(float f2) {
        this.Y0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "vbWidth")
    public void setVbWidth(float f2) {
        this.X0 = f2;
        invalidate();
    }
}