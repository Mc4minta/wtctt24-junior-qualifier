package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UseView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class v0 extends b0 {
    private String N0;
    private c0 O0;
    private c0 P0;
    private c0 Q0;
    private c0 R0;

    public v0(ReactContext reactContext) {
        super(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.b0, com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
        x0 L = getSvgView().L(this.N0);
        if (L == null) {
            e.f.d.d.a.A("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.N0 + " is not defined.");
            return;
        }
        L.y();
        canvas.translate((float) K(this.O0), (float) I(this.P0));
        boolean z = L instanceof b0;
        if (z) {
            ((b0) L).S(this);
        }
        int N = L.N(canvas, this.z);
        B(canvas, paint);
        if (L instanceof g0) {
            ((g0) L).i0(canvas, paint, f2, (float) K(this.Q0), (float) I(this.R0));
        } else {
            L.C(canvas, paint, f2 * this.y);
        }
        setClientRect(L.getClientRect());
        L.M(canvas, N);
        if (z) {
            ((b0) L).U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public Path F(Canvas canvas, Paint paint) {
        x0 L = getSvgView().L(this.N0);
        if (L == null) {
            e.f.d.d.a.A("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.N0 + " is not defined.");
            return null;
        }
        Path F = L.F(canvas, paint);
        Path path = new Path();
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) K(this.O0), (float) I(this.P0));
        F.transform(matrix, path);
        return path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.b0, com.horcrux.svg.x0
    public int G(float[] fArr) {
        if (this.F && this.H) {
            float[] fArr2 = new float[2];
            this.D.mapPoints(fArr2, fArr);
            this.E.mapPoints(fArr2);
            x0 L = getSvgView().L(this.N0);
            if (L == null) {
                e.f.d.d.a.A("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.N0 + " is not defined.");
                return -1;
            }
            int G = L.G(fArr2);
            if (G != -1) {
                return (L.H() || G != L.getId()) ? G : getId();
            }
        }
        return -1;
    }

    @com.facebook.react.uimanager.c1.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.R0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = SVGParser.XML_STYLESHEET_ATTR_HREF)
    public void setHref(String str) {
        this.N0 = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x")
    public void setX(Dynamic dynamic) {
        this.O0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y")
    public void setY(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }
}