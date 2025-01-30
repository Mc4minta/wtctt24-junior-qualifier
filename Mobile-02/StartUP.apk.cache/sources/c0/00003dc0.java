package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EllipseView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class g extends b0 {
    private c0 N0;
    private c0 O0;
    private c0 P0;
    private c0 Q0;

    public g(ReactContext reactContext) {
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
        path.addOval(new RectF((float) (K - K2), (float) (I - I2), (float) (K + K2), (float) (I + I2)), Path.Direction.CW);
        return path;
    }

    @com.facebook.react.uimanager.c1.a(name = "cx")
    public void setCx(Dynamic dynamic) {
        this.N0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "cy")
    public void setCy(Dynamic dynamic) {
        this.O0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }
}