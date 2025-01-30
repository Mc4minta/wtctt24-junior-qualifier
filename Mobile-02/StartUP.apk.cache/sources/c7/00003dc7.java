package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextPathView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class i0 extends u0 {
    private String a1;
    private s0 b1;
    private r0 c1;
    private c0 d1;
    private q0 e1;
    private t0 f1;

    public i0(ReactContext reactContext) {
        super(reactContext);
        this.e1 = q0.align;
        this.f1 = t0.exact;
    }

    @Override // com.horcrux.svg.u0, com.horcrux.svg.l, com.horcrux.svg.b0, com.horcrux.svg.x0
    void C(Canvas canvas, Paint paint, float f2) {
        Z(canvas, paint, f2);
    }

    @Override // com.horcrux.svg.u0, com.horcrux.svg.l, com.horcrux.svg.x0
    Path F(Canvas canvas, Paint paint) {
        return k0(canvas, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l
    public void e0() {
    }

    @Override // com.horcrux.svg.u0, com.horcrux.svg.l
    void f0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0 o0() {
        return this.c1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0 p0() {
        return this.b1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0 q0() {
        return this.d1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path r0(Canvas canvas, Paint paint) {
        x0 L = getSvgView().L(this.a1);
        if (L instanceof b0) {
            return ((b0) L).F(canvas, paint);
        }
        return null;
    }

    @com.facebook.react.uimanager.c1.a(name = SVGParser.XML_STYLESHEET_ATTR_HREF)
    public void setHref(String str) {
        this.a1 = str;
        invalidate();
    }

    @Override // com.horcrux.svg.u0
    @com.facebook.react.uimanager.c1.a(name = "method")
    public void setMethod(String str) {
        this.e1 = q0.valueOf(str);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "midLine")
    public void setSharp(String str) {
        this.c1 = r0.valueOf(str);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "side")
    public void setSide(String str) {
        this.b1 = s0.valueOf(str);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "spacing")
    public void setSpacing(String str) {
        this.f1 = t0.valueOf(str);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "startOffset")
    public void setStartOffset(Dynamic dynamic) {
        this.d1 = c0.b(dynamic);
        invalidate();
    }
}