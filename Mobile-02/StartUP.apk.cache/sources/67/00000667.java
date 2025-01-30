package c.s;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class q0 extends v0 {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f3346f = true;

    @Override // c.s.v0
    public void a(View view) {
    }

    @Override // c.s.v0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f3346f) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f3346f = false;
            }
        }
        return view.getAlpha();
    }

    @Override // c.s.v0
    public void d(View view) {
    }

    @Override // c.s.v0
    @SuppressLint({"NewApi"})
    public void g(View view, float f2) {
        if (f3346f) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f3346f = false;
            }
        }
        view.setAlpha(f2);
    }
}