package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class b extends b0 {
    private c0 N0;
    private c0 O0;
    private c0 P0;

    public b(ReactContext reactContext) {
        super(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public Path F(Canvas canvas, Paint paint) {
        Path path = new Path();
        path.addCircle((float) K(this.N0), (float) I(this.O0), (float) J(this.P0), Path.Direction.CW);
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

    @com.facebook.react.uimanager.c1.a(name = "r")
    public void setR(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }
}