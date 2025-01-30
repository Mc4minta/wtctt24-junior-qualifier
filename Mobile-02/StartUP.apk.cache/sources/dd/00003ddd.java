package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PathView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class t extends b0 {
    private Path N0;

    public t(ReactContext reactContext) {
        super(reactContext);
        s.a = this.P;
        this.N0 = new Path();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public Path F(Canvas canvas, Paint paint) {
        return this.N0;
    }

    @com.facebook.react.uimanager.c1.a(name = "d")
    public void setD(String str) {
        this.N0 = s.o(str);
        this.t0 = s.f10302f;
        invalidate();
    }
}