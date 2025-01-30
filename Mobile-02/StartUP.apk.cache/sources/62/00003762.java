package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f8067b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPropertyAnimator f8068c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f8068c = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.f8067b = 2;
    }

    private void E(V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f8068c = v.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f8068c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f8067b = 1;
        E(v, this.a, 175L, e.g.a.f.l.a.f13293c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f8068c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f8067b = 2;
        E(v, 0, 225L, e.g.a.f.l.a.f13294d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.a = v.getMeasuredHeight();
        return super.l(coordinatorLayout, v, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f8067b;
        if (i6 != 1 && i3 > 0) {
            F(v);
        } else if (i6 == 2 || i3 >= 0) {
        } else {
            G(v);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean y(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.f8067b = 2;
    }
}