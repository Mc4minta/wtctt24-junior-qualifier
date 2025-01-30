package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ForeignObjectView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class i extends l {
    c0 P0;
    c0 Q0;
    c0 R0;
    c0 S0;
    Bitmap T0;
    Canvas U0;

    public i(ReactContext reactContext) {
        super(reactContext);
        this.T0 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        this.U0 = new Canvas(this.T0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l, com.horcrux.svg.b0, com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
        canvas.translate((float) K(this.P0), (float) I(this.Q0));
        canvas.clipRect(0.0f, 0.0f, (float) K(this.R0), (float) I(this.S0));
        super.C(canvas, paint, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l
    public void Z(Canvas canvas, Paint paint, float f2) {
        f0();
        f0 svgView = getSvgView();
        RectF rectF = new RectF();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof q)) {
                if (childAt instanceof x0) {
                    x0 x0Var = (x0) childAt;
                    if (!"none".equals(x0Var.S)) {
                        boolean z = x0Var instanceof b0;
                        if (z) {
                            ((b0) x0Var).S(this);
                        }
                        int N = x0Var.N(canvas, this.z);
                        x0Var.L(canvas, paint, this.y * f2);
                        RectF clientRect = x0Var.getClientRect();
                        if (clientRect != null) {
                            rectF.union(clientRect);
                        }
                        x0Var.M(canvas, N);
                        if (z) {
                            ((b0) x0Var).U();
                        }
                        if (x0Var.H()) {
                            svgView.G();
                        }
                    }
                } else if (childAt instanceof f0) {
                    f0 f0Var = (f0) childAt;
                    f0Var.E(canvas);
                    if (f0Var.N()) {
                        svgView.G();
                    }
                } else {
                    childAt.draw(canvas);
                }
            }
        }
        setClientRect(rectF);
        e0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.view.f, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(this.U0);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(this.U0, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.S0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.R0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x")
    public void setX(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y")
    public void setY(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }
}