package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GroupView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class l extends b0 {
    ReadableMap N0;
    private j O0;

    public l(ReactContext reactContext) {
        super(reactContext);
    }

    private static <T> T g0(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.b0, com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
        h0(canvas);
        B(canvas, paint);
        Z(canvas, paint, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public Path F(Canvas canvas, Paint paint) {
        Path path = this.f0;
        if (path != null) {
            return path;
        }
        this.f0 = new Path();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof q) && (childAt instanceof x0)) {
                x0 x0Var = (x0) childAt;
                this.f0.addPath(x0Var.F(canvas, paint), x0Var.A);
            }
        }
        return this.f0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.b0, com.horcrux.svg.x0
    public int G(float[] fArr) {
        int c2;
        x0 x0Var;
        int G;
        if (this.F && this.H) {
            float[] fArr2 = new float[2];
            this.D.mapPoints(fArr2, fArr);
            this.E.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            Path clipPath = getClipPath();
            if (clipPath != null) {
                if (this.j0 != clipPath) {
                    this.j0 = clipPath;
                    RectF rectF = new RectF();
                    this.o0 = rectF;
                    clipPath.computeBounds(rectF, true);
                    this.s0 = P(clipPath, this.o0);
                }
                if (!this.s0.contains(round, round2)) {
                    return -1;
                }
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof x0) {
                    if (!(childAt instanceof q) && (G = (x0Var = (x0) childAt).G(fArr2)) != -1) {
                        return (x0Var.H() || G != childAt.getId()) ? G : getId();
                    }
                } else if ((childAt instanceof f0) && (c2 = ((f0) childAt).c(fArr2[0], fArr2[1])) != childAt.getId()) {
                    return c2;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public void O() {
        if (this.T != null) {
            getSvgView().D(this, this.T);
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof x0) {
                ((x0) childAt).O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.b0
    public void U() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof b0) {
                ((b0) childAt).U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
                }
            }
        }
        setClientRect(rectF);
        e0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(Canvas canvas, Paint paint, float f2) {
        super.C(canvas, paint, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j b0() {
        return this.O0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path c0(Canvas canvas, Paint paint, Region.Op op) {
        Path F;
        Path F2;
        Path path = new Path();
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 19) {
            Path.Op valueOf = Path.Op.valueOf(op.name());
            while (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (!(childAt instanceof q) && (childAt instanceof x0)) {
                    x0 x0Var = (x0) childAt;
                    Matrix matrix = x0Var.A;
                    if (x0Var instanceof l) {
                        F2 = ((l) x0Var).c0(canvas, paint, op);
                    } else {
                        F2 = x0Var.F(canvas, paint);
                    }
                    F2.transform(matrix);
                    path.op(F2, valueOf);
                }
                i2++;
            }
        } else {
            Region region = new Region(canvas.getClipBounds());
            Region region2 = new Region();
            while (i2 < getChildCount()) {
                View childAt2 = getChildAt(i2);
                if (!(childAt2 instanceof q) && (childAt2 instanceof x0)) {
                    x0 x0Var2 = (x0) childAt2;
                    Matrix matrix2 = x0Var2.A;
                    if (x0Var2 instanceof l) {
                        F = ((l) x0Var2).c0(canvas, paint, op);
                    } else {
                        F = x0Var2.F(canvas, paint);
                    }
                    if (matrix2 != null) {
                        F.transform(matrix2);
                    }
                    Region region3 = new Region();
                    region3.setPath(F, region);
                    region2.op(region3, op);
                }
                i2++;
            }
            path.addPath(region2.getBoundaryPath());
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j d0() {
        return ((l) g0(getTextRoot())).b0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0() {
        d0().n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0() {
        d0().o(this, this.N0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(Canvas canvas) {
        RectF rectF = new RectF(canvas.getClipBounds());
        Matrix matrix = this.A;
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        Matrix matrix2 = this.B;
        if (matrix2 != null) {
            matrix2.mapRect(rectF);
        }
        this.O0 = new j(this.P, rectF.width(), rectF.height());
    }

    @com.facebook.react.uimanager.c1.a(name = "font")
    public void setFont(ReadableMap readableMap) {
        this.N0 = readableMap;
        invalidate();
    }
}