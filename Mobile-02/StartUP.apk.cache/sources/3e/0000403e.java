package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.o;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: ScreenStackFragment.java */
/* loaded from: classes2.dex */
public class i extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final float f11032c = o.c(4.0f);

    /* renamed from: d  reason: collision with root package name */
    private AppBarLayout f11033d;

    /* renamed from: e  reason: collision with root package name */
    private Toolbar f11034e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11035f;

    /* compiled from: ScreenStackFragment.java */
    /* loaded from: classes2.dex */
    private static class a extends CoordinatorLayout {
        private final g C;
        private Animation.AnimationListener D;

        /* compiled from: ScreenStackFragment.java */
        /* renamed from: com.swmansion.rnscreens.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class animation.Animation$AnimationListenerC0238a implements Animation.AnimationListener {
            animation.Animation$AnimationListenerC0238a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.C.i();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                a.this.C.j();
            }
        }

        public a(Context context, g gVar) {
            super(context);
            this.D = new animation.Animation$AnimationListenerC0238a();
            this.C = gVar;
        }

        @Override // android.view.View
        public void startAnimation(Animation animation) {
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(animation);
            animationSet.setAnimationListener(this.D);
            super.startAnimation(animationSet);
        }
    }

    @SuppressLint({"ValidFragment"})
    public i(b bVar) {
        super(bVar);
    }

    private void p() {
        ViewParent parent = getView().getParent();
        if (parent instanceof h) {
            ((h) parent).C();
        }
    }

    public void dismiss() {
        d container = this.a.getContainer();
        if (container instanceof h) {
            ((h) container).A(this);
            return;
        }
        throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
    }

    @Override // com.swmansion.rnscreens.g
    public void i() {
        super.i();
        p();
    }

    public boolean n() {
        d container = this.a.getContainer();
        if (container instanceof h) {
            if (((h) container).getRootScreen() == h()) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof i) {
                    return ((i) parentFragment).n();
                }
                return false;
            }
            return true;
        }
        throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
    }

    public boolean o() {
        return this.a.c();
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        if (i2 != 0 || isHidden()) {
            return null;
        }
        d container = h().getContainer();
        boolean z2 = container != null && container.k();
        if (z) {
            if (z2) {
                return null;
            }
            f();
            d();
            return null;
        }
        if (!z2) {
            g();
            e();
        }
        p();
        return null;
    }

    @Override // com.swmansion.rnscreens.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a aVar = new a(getContext(), this);
        CoordinatorLayout.f fVar = new CoordinatorLayout.f(-1, -1);
        fVar.o(new AppBarLayout.ScrollingViewBehavior());
        this.a.setLayoutParams(fVar);
        aVar.addView(g.k(this.a));
        AppBarLayout appBarLayout = new AppBarLayout(getContext());
        this.f11033d = appBarLayout;
        appBarLayout.setBackgroundColor(0);
        this.f11033d.setLayoutParams(new AppBarLayout.c(-1, -2));
        aVar.addView(this.f11033d);
        if (this.f11035f) {
            this.f11033d.setTargetElevation(0.0f);
        }
        Toolbar toolbar = this.f11034e;
        if (toolbar != null) {
            this.f11033d.addView(g.k(toolbar));
        }
        return aVar;
    }

    public void q() {
        View childAt = this.a.getChildAt(0);
        if (childAt instanceof j) {
            ((j) childAt).g();
        }
    }

    public void r() {
        Toolbar toolbar;
        if (this.f11033d != null && (toolbar = this.f11034e) != null) {
            ViewParent parent = toolbar.getParent();
            AppBarLayout appBarLayout = this.f11033d;
            if (parent == appBarLayout) {
                appBarLayout.removeView(this.f11034e);
            }
        }
        this.f11034e = null;
    }

    public void s(Toolbar toolbar) {
        AppBarLayout appBarLayout = this.f11033d;
        if (appBarLayout != null) {
            appBarLayout.addView(toolbar);
        }
        this.f11034e = toolbar;
        AppBarLayout.c cVar = new AppBarLayout.c(-1, -2);
        cVar.d(0);
        this.f11034e.setLayoutParams(cVar);
    }

    public void t(boolean z) {
        if (this.f11035f != z) {
            this.f11033d.setTargetElevation(z ? 0.0f : f11032c);
            this.f11035f = z;
        }
    }

    public i() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }
}