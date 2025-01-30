package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private final int T;
    private final e.g.a.f.t.a U;
    private Animator V;
    private Animator W;
    private Animator a0;
    private int b0;
    private boolean c0;
    private boolean d0;
    AnimatorListenerAdapter e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.W = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.a0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f8083b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8084c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f8085d;

        c(ActionMenuView actionMenuView, int i2, boolean z) {
            this.f8083b = actionMenuView;
            this.f8084c = i2;
            this.f8085d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            BottomAppBar.this.l0(this.f8083b, this.f8084c, this.f8085d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d extends c.j.a.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f8087c;

        /* renamed from: d  reason: collision with root package name */
        boolean f8088d;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f8087c);
            parcel.writeInt(this.f8088d ? 1 : 0);
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8087c = parcel.readInt();
            this.f8088d = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(FloatingActionButton floatingActionButton) {
        j0(floatingActionButton);
        floatingActionButton.e(this.e0);
        floatingActionButton.f(this.e0);
    }

    private void Y() {
        Animator animator = this.V;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.a0;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.W;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    private void Z(int i2, List<Animator> list) {
        if (this.d0) {
            throw null;
        }
    }

    private void a0(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c0(), "translationX", d0(i2));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void b0(int i2, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.d0 && (!z || !g0())) || (this.b0 != 1 && i2 != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
                return;
            }
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
        ofFloat2.addListener(new c(actionMenuView, i2, z));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.playSequentially(ofFloat2, ofFloat);
        list.add(animatorSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton c0() {
        if (getParent() instanceof CoordinatorLayout) {
            for (View view : ((CoordinatorLayout) getParent()).m(this)) {
                if (view instanceof FloatingActionButton) {
                    return (FloatingActionButton) view;
                }
            }
            return null;
        }
        return null;
    }

    private int d0(int i2) {
        boolean z = v.y(this) == 1;
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - this.T) * (z ? -1 : 1);
        }
        return 0;
    }

    private float e0(boolean z) {
        FloatingActionButton c0 = c0();
        if (c0 == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        c0.h(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = c0.getMeasuredHeight();
        }
        float height2 = c0.getHeight() - rect.height();
        float height3 = (-getCradleVerticalOffset()) + (height / 2.0f) + (c0.getHeight() - rect.bottom);
        float paddingBottom = height2 - c0.getPaddingBottom();
        float f2 = -getMeasuredHeight();
        if (!z) {
            height3 = paddingBottom;
        }
        return f2 + height3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f0() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.V;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.a0) != null && animator.isRunning()) || ((animator2 = this.W) != null && animator2.isRunning());
    }

    private boolean g0() {
        FloatingActionButton c0 = c0();
        return c0 != null && c0.l();
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return d0(this.b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return e0(this.d0);
    }

    private void h0(int i2, boolean z) {
        if (v.S(this)) {
            Animator animator = this.a0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!g0()) {
                i2 = 0;
                z = false;
            }
            b0(i2, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.a0 = animatorSet;
            animatorSet.addListener(new b());
            this.a0.start();
        }
    }

    private void i0(int i2) {
        if (this.b0 == i2 || !v.S(this)) {
            return;
        }
        Animator animator = this.W;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        Z(i2, arrayList);
        a0(i2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.W = animatorSet;
        animatorSet.addListener(new a());
        this.W.start();
    }

    private void j0(FloatingActionButton floatingActionButton) {
        floatingActionButton.o(this.e0);
        floatingActionButton.p(this.e0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        getFabTranslationX();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(ActionMenuView actionMenuView, int i2, boolean z) {
        boolean z2 = v.y(this) == 1;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                i3 = Math.max(i3, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i2 == 1 && z) ? i3 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        throw null;
    }

    public int getFabAlignmentMode() {
        return this.b0;
    }

    public float getFabCradleMargin() {
        throw null;
    }

    public float getFabCradleRoundedCornerRadius() {
        throw null;
    }

    public boolean getHideOnScroll() {
        return this.c0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        Y();
        k0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        this.b0 = dVar.f8087c;
        this.d0 = dVar.f8088d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f8087c = this.b0;
        dVar.f8088d = this.d0;
        return dVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.o(this.U, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            throw null;
        }
    }

    public void setFabAlignmentMode(int i2) {
        i0(i2);
        h0(i2, this.d0);
        this.b0 = i2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            throw null;
        }
    }

    void setFabDiameter(int i2) {
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.c0 = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f8082d;

        public Behavior() {
            this.f8082d = new Rect();
        }

        private boolean L(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f1367d = 17;
            bottomAppBar.X(floatingActionButton);
            return true;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            FloatingActionButton c0 = bottomAppBar.c0();
            if (c0 != null) {
                L(c0, bottomAppBar);
                c0.i(this.f8082d);
                bottomAppBar.setFabDiameter(this.f8082d.height());
            }
            if (!bottomAppBar.f0()) {
                bottomAppBar.k0();
            }
            coordinatorLayout.C(bottomAppBar, i2);
            return super.l(coordinatorLayout, bottomAppBar, i2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: I */
        public boolean z(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.z(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        /* renamed from: J */
        public void F(BottomAppBar bottomAppBar) {
            super.F(bottomAppBar);
            FloatingActionButton c0 = bottomAppBar.c0();
            if (c0 != null) {
                c0.h(this.f8082d);
                c0.clearAnimation();
                c0.animate().translationY((-c0.getPaddingBottom()) + (c0.getMeasuredHeight() - this.f8082d.height())).setInterpolator(e.g.a.f.l.a.f13293c).setDuration(175L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        /* renamed from: K */
        public void G(BottomAppBar bottomAppBar) {
            super.G(bottomAppBar);
            FloatingActionButton c0 = bottomAppBar.c0();
            if (c0 != null) {
                c0.clearAnimation();
                c0.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(e.g.a.f.l.a.f13294d).setDuration(225L);
            }
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8082d = new Rect();
        }
    }
}