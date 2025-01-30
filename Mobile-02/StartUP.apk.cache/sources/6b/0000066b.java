package c.s;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
class s0 extends r0 {

    /* renamed from: j  reason: collision with root package name */
    private static boolean f3358j = true;

    @Override // c.s.v0
    @SuppressLint({"NewApi"})
    public void f(View view, int i2, int i3, int i4, int i5) {
        if (f3358j) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f3358j = false;
            }
        }
    }
}