package c.s;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class r0 extends q0 {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f3347g = true;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f3348h = true;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f3349i = true;

    @Override // c.s.v0
    @SuppressLint({"NewApi"})
    public void e(View view, Matrix matrix) {
        if (f3347g) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f3347g = false;
            }
        }
    }

    @Override // c.s.v0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f3348h) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f3348h = false;
            }
        }
    }

    @Override // c.s.v0
    @SuppressLint({"NewApi"})
    public void j(View view, Matrix matrix) {
        if (f3349i) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f3349i = false;
            }
        }
    }
}