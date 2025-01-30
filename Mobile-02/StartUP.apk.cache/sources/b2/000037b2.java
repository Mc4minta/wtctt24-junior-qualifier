package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.e;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes2.dex */
public class a {
    private e.b a;

    public a(SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.J(0.1f);
        swipeDismissBehavior.I(0.6f);
        swipeDismissBehavior.K(0);
    }

    public boolean a(View view) {
        return view instanceof d;
    }

    public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (coordinatorLayout.v(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                e.b().e(this.a);
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            e.b().f(this.a);
        }
    }
}