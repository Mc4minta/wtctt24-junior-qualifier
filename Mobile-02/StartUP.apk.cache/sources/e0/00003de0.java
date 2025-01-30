package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class u0 extends l {
    c0 P0;
    c0 Q0;
    private String R0;
    p0 S0;
    private j0 T0;
    private ArrayList<c0> U0;
    private ArrayList<c0> V0;
    private ArrayList<c0> W0;
    private ArrayList<c0> X0;
    private ArrayList<c0> Y0;
    double Z0;

    public u0(ReactContext reactContext) {
        super(reactContext);
        this.P0 = null;
        this.Q0 = null;
        this.R0 = null;
        this.S0 = p0.spacing;
        this.Z0 = Double.NaN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l, com.horcrux.svg.b0, com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
        h0(canvas);
        B(canvas, paint);
        k0(canvas, paint);
        f0();
        Z(canvas, paint, f2);
        e0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l, com.horcrux.svg.x0
    public Path F(Canvas canvas, Paint paint) {
        Path path = this.f0;
        if (path != null) {
            return path;
        }
        h0(canvas);
        return k0(canvas, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l
    public Path c0(Canvas canvas, Paint paint, Region.Op op) {
        return F(canvas, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l
    public void f0() {
        d0().p(((this instanceof i0) || (this instanceof h0)) ? false : true, this, this.N0, this.U0, this.V0, this.X0, this.Y0, this.W0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0 i0() {
        j0 j0Var;
        if (this.T0 == null) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if ((parent instanceof u0) && (j0Var = ((u0) parent).T0) != null) {
                    this.T0 = j0Var;
                    return j0Var;
                }
            }
        }
        if (this.T0 == null) {
            this.T0 = j0.baseline;
        }
        return this.T0;
    }

    @Override // com.horcrux.svg.x0, android.view.View
    public void invalidate() {
        if (this.f0 == null) {
            return;
        }
        super.invalidate();
        n0().z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j0() {
        String str;
        if (this.R0 == null) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if ((parent instanceof u0) && (str = ((u0) parent).R0) != null) {
                    this.R0 = str;
                    return str;
                }
            }
        }
        return this.R0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path k0(Canvas canvas, Paint paint) {
        Path path = this.f0;
        if (path != null) {
            return path;
        }
        f0();
        this.f0 = super.F(canvas, paint);
        e0();
        return this.f0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double l0(Paint paint) {
        if (!Double.isNaN(this.Z0)) {
            return this.Z0;
        }
        double d2 = 0.0d;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof u0) {
                d2 += ((u0) childAt).l0(paint);
            }
        }
        this.Z0 = d2;
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0 m0() {
        ArrayList<h> arrayList = d0().a;
        ViewParent parent = getParent();
        u0 u0Var = this;
        for (int size = arrayList.size() - 1; size >= 0 && (parent instanceof u0) && arrayList.get(size).f10238k != n0.start && u0Var.U0 == null; size--) {
            u0Var = (u0) parent;
            parent = u0Var.getParent();
        }
        return u0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0 n0() {
        ViewParent parent = getParent();
        u0 u0Var = this;
        while (parent instanceof u0) {
            u0Var = (u0) parent;
            parent = u0Var.getParent();
        }
        return u0Var;
    }

    @com.facebook.react.uimanager.c1.a(name = "baselineShift")
    public void setBaselineShift(Dynamic dynamic) {
        this.R0 = c0.c(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "dx")
    public void setDeltaX(Dynamic dynamic) {
        this.X0 = c0.a(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "dy")
    public void setDeltaY(Dynamic dynamic) {
        this.Y0 = c0.a(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "inlineSize")
    public void setInlineSize(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "lengthAdjust")
    public void setLengthAdjust(String str) {
        this.S0 = p0.valueOf(str);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "alignmentBaseline")
    public void setMethod(String str) {
        this.T0 = j0.h(str);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x")
    public void setPositionX(Dynamic dynamic) {
        this.U0 = c0.a(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y")
    public void setPositionY(Dynamic dynamic) {
        this.V0 = c0.a(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "rotate")
    public void setRotate(Dynamic dynamic) {
        this.W0 = c0.a(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "textLength")
    public void setTextLength(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "verticalAlign")
    public void setVerticalAlign(String str) {
        if (str != null) {
            String trim = str.trim();
            int lastIndexOf = trim.lastIndexOf(32);
            try {
                this.T0 = j0.h(trim.substring(lastIndexOf));
            } catch (IllegalArgumentException unused) {
                this.T0 = j0.baseline;
            }
            try {
                this.R0 = trim.substring(0, lastIndexOf);
            } catch (IndexOutOfBoundsException unused2) {
                this.R0 = null;
            }
        } else {
            this.T0 = j0.baseline;
            this.R0 = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public void y() {
        this.Z0 = Double.NaN;
        super.y();
    }
}