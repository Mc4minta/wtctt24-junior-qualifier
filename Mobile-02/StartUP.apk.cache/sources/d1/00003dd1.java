package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LineView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class n extends b0 {
    private c0 N0;
    private c0 O0;
    private c0 P0;
    private c0 Q0;

    public n(ReactContext reactContext) {
        super(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public Path F(Canvas canvas, Paint paint) {
        Path path = new Path();
        double K = K(this.N0);
        double I = I(this.O0);
        double K2 = K(this.P0);
        double I2 = I(this.Q0);
        path.moveTo((float) K, (float) I);
        path.lineTo((float) K2, (float) I2);
        return path;
    }

    @com.facebook.react.uimanager.c1.a(name = "x1")
    public void setX1(Dynamic dynamic) {
        this.N0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x2")
    public void setX2(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y1")
    public void setY1(Dynamic dynamic) {
        this.O0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y2")
    public void setY2(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }
}