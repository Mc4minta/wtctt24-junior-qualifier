package c.s;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: ViewUtilsApi23.java */
/* loaded from: classes.dex */
class t0 extends s0 {

    /* renamed from: k  reason: collision with root package name */
    private static boolean f3359k = true;

    @Override // c.s.v0
    @SuppressLint({"NewApi"})
    public void h(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.h(view, i2);
        } else if (f3359k) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f3359k = false;
            }
        }
    }
}