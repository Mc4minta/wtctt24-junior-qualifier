package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.facebook.react.bridge.ReactContext;

/* compiled from: SymbolView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
class g0 extends l {
    private float P0;
    private float Q0;
    private float R0;
    private float S0;
    private String T0;
    private int U0;

    public g0(ReactContext reactContext) {
        super(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l, com.horcrux.svg.b0, com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
        O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(Canvas canvas, Paint paint, float f2, float f3, float f4) {
        if (this.T0 != null) {
            float f5 = this.P0;
            float f6 = this.P;
            float f7 = this.Q0;
            canvas.concat(w0.a(new RectF(f5 * f6, f7 * f6, (f5 + this.R0) * f6, (f7 + this.S0) * f6), new RectF(0.0f, 0.0f, f3, f4), this.T0, this.U0));
            super.C(canvas, paint, f2);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "align")
    public void setAlign(String str) {
        this.T0 = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
    public void setMeetOrSlice(int i2) {
        this.U0 = i2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "minX")
    public void setMinX(float f2) {
        this.P0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "minY")
    public void setMinY(float f2) {
        this.Q0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "vbHeight")
    public void setVbHeight(float f2) {
        this.S0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "vbWidth")
    public void setVbWidth(float f2) {
        this.R0 = f2;
        invalidate();
    }
}