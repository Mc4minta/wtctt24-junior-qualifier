package c.s;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
class u0 extends t0 {
    @Override // c.s.q0, c.s.v0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // c.s.r0, c.s.v0
    public void e(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // c.s.s0, c.s.v0
    public void f(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // c.s.q0, c.s.v0
    public void g(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // c.s.t0, c.s.v0
    public void h(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // c.s.r0, c.s.v0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // c.s.r0, c.s.v0
    public void j(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}