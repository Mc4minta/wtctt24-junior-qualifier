package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.d0;
import c.h.k.q;
import c.h.k.v;
import com.google.android.material.internal.h;
import e.g.a.f.j;
import e.g.a.f.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.d(Behavior.class)
/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f8019b;

    /* renamed from: c  reason: collision with root package name */
    private int f8020c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8021d;

    /* renamed from: e  reason: collision with root package name */
    private int f8022e;

    /* renamed from: f  reason: collision with root package name */
    private d0 f8023f;

    /* renamed from: g  reason: collision with root package name */
    private List<b> f8024g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8025h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8026j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8027k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8028l;
    private int[] m;

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int D() {
            return super.D();
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean F(int i2) {
            return super.F(i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean d0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.l(coordinatorLayout, appBarLayout, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean e0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.m(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void f0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.q(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void g0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
            super.s(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void h0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.w(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable i0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.x(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean j0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.z(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void k0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.B(coordinatorLayout, appBarLayout, view, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes2.dex */
    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        private static int P(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f2 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                return ((BaseBehavior) f2).L();
            }
            return 0;
        }

        private void Q(View view, View view2) {
            CoordinatorLayout.c f2 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                v.Y(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f2).f8029k) + L()) - H(view2));
            }
        }

        private void R(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.k()) {
                    appBarLayout.s(view.getScrollY() > 0);
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        float I(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int P = P(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + P > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (P / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        public int K(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.K(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* renamed from: O */
        public AppBarLayout G(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Q(view, view2);
            R(view, view2);
            return false;
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.l(coordinatorLayout, view, i2);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.m(coordinatorLayout, view, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean v(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout G = G(coordinatorLayout.l(view));
            if (G != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f8057d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    G.p(false, !z);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.i1);
            N(obtainStyledAttributes.getDimensionPixelSize(k.j1, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes2.dex */
    class a implements q {
        a() {
        }

        @Override // c.h.k.q
        public d0 a(View view, d0 d0Var) {
            return AppBarLayout.this.l(d0Var);
        }
    }

    /* loaded from: classes2.dex */
    public interface b<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    /* loaded from: classes2.dex */
    public interface d extends b<AppBarLayout> {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((c) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        this.a = -1;
        this.f8019b = -1;
        this.f8020c = -1;
    }

    private void q(boolean z, boolean z2, boolean z3) {
        this.f8022e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    private boolean r(boolean z) {
        if (this.f8026j != z) {
            this.f8026j = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    public void a(b bVar) {
        if (this.f8024g == null) {
            this.f8024g = new ArrayList();
        }
        if (bVar == null || this.f8024g.contains(bVar)) {
            return;
        }
        this.f8024g.add(bVar);
    }

    public void b(d dVar) {
        a(dVar);
    }

    void c(int i2) {
        List<b> list = this.f8024g;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f8024g.get(i3);
                if (bVar != null) {
                    bVar.a(this, i2);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d */
    public c generateDefaultLayoutParams() {
        return new c(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: e */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: f */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new c((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    boolean g() {
        return this.f8021d;
    }

    int getDownNestedPreScrollRange() {
        int topInset;
        int i2 = this.f8019b;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = cVar.a;
            if ((i4 & 5) == 5) {
                int i5 = i3 + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                if ((i4 & 8) != 0) {
                    i3 = i5 + v.z(childAt);
                } else {
                    if ((i4 & 2) != 0) {
                        topInset = v.z(childAt);
                    } else {
                        topInset = getTopInset();
                    }
                    i3 = i5 + (measuredHeight - topInset);
                }
            } else if (i3 > 0) {
                break;
            }
        }
        int max = Math.max(0, i3);
        this.f8019b = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i2 = this.f8020c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            int i5 = cVar.a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= v.z(childAt) + getTopInset();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f8020c = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int z = v.z(this);
        if (z == 0) {
            int childCount = getChildCount();
            z = childCount >= 1 ? v.z(getChildAt(childCount - 1)) : 0;
            if (z == 0) {
                return getHeight() / 3;
            }
        }
        return (z * 2) + topInset;
    }

    int getPendingAction() {
        return this.f8022e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        d0 d0Var = this.f8023f;
        if (d0Var != null) {
            return d0Var.l();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.a;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = cVar.a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            if ((i5 & 2) != 0) {
                i4 -= v.z(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4 - getTopInset());
        this.a = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean i() {
        return getTotalScrollRange() != 0;
    }

    public boolean k() {
        return this.f8028l;
    }

    d0 l(d0 d0Var) {
        d0 d0Var2 = v.v(this) ? d0Var : null;
        if (!androidx.core.util.d.a(this.f8023f, d0Var2)) {
            this.f8023f = d0Var2;
            j();
        }
        return d0Var;
    }

    public void m(b bVar) {
        List<b> list = this.f8024g;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void n(d dVar) {
        m(dVar);
    }

    void o() {
        this.f8022e = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.m == null) {
            this.m = new int[4];
        }
        int[] iArr = this.m;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.f8026j;
        int i3 = e.g.a.f.b.f13235j;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (z && this.f8027k) ? e.g.a.f.b.f13236k : -e.g.a.f.b.f13236k;
        int i4 = e.g.a.f.b.f13234i;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (z && this.f8027k) ? e.g.a.f.b.f13233h : -e.g.a.f.b.f13233h;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        j();
        boolean z2 = false;
        this.f8021d = false;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (((c) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f8021d = true;
                break;
            } else {
                i6++;
            }
        }
        if (this.f8025h) {
            return;
        }
        if (this.f8028l || h()) {
            z2 = true;
        }
        r(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        j();
    }

    public void p(boolean z, boolean z2) {
        q(z, z2, true);
    }

    boolean s(boolean z) {
        if (this.f8027k != z) {
            this.f8027k = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    public void setExpanded(boolean z) {
        p(z, v.S(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.f8028l = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.b(this, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* renamed from: k  reason: collision with root package name */
        private int f8029k;

        /* renamed from: l  reason: collision with root package name */
        private int f8030l;
        private ValueAnimator m;
        private int n;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private b r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ CoordinatorLayout a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f8031b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.f8031b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.O(this.a, this.f8031b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes2.dex */
        public static abstract class b<T extends AppBarLayout> {
        }

        public BaseBehavior() {
            this.n = -1;
        }

        private void R(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int height;
            int abs = Math.abs(L() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            S(coordinatorLayout, t, i2, height);
        }

        private void S(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            int L = L();
            if (L == i2) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(e.g.a.f.l.a.f13295e);
                this.m.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i3, 600));
            this.m.setIntValues(L, i2);
            this.m.start();
        }

        private boolean U(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.i() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        private static boolean V(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        private View W(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt instanceof c.h.k.k) {
                    return childAt;
                }
            }
            return null;
        }

        private static View X(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int Y(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                c cVar = (c) childAt.getLayoutParams();
                if (V(cVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) cVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) cVar).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private int b0(T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                c cVar = (c) childAt.getLayoutParams();
                Interpolator b2 = cVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = cVar.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= v.z(childAt);
                        }
                    }
                    if (v.v(childAt)) {
                        i3 -= t.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation((abs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i2;
        }

        private boolean m0(CoordinatorLayout coordinatorLayout, T t) {
            List<View> m = coordinatorLayout.m(t);
            int size = m.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.c f2 = ((CoordinatorLayout.f) m.get(i2).getLayoutParams()).f();
                if (f2 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) f2).J() != 0;
                }
            }
            return false;
        }

        private void n0(CoordinatorLayout coordinatorLayout, T t) {
            int L = L();
            int Y = Y(t, L);
            if (Y >= 0) {
                View childAt = t.getChildAt(Y);
                c cVar = (c) childAt.getLayoutParams();
                int a2 = cVar.a();
                if ((a2 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (Y == t.getChildCount() - 1) {
                        i3 += t.getTopInset();
                    }
                    if (V(a2, 2)) {
                        i3 += v.z(childAt);
                    } else if (V(a2, 5)) {
                        int z = v.z(childAt) + i3;
                        if (L < z) {
                            i2 = z;
                        } else {
                            i3 = z;
                        }
                    }
                    if (V(a2, 32)) {
                        i2 += ((LinearLayout.LayoutParams) cVar).topMargin;
                        i3 -= ((LinearLayout.LayoutParams) cVar).bottomMargin;
                    }
                    if (L < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    R(coordinatorLayout, t, c.h.h.a.b(i2, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void o0(int i2, T t, View view, int i3) {
            if (i3 == 1) {
                int L = L();
                if ((i2 >= 0 || L != 0) && (i2 <= 0 || L != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                v.F0(view, 1);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void p0(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = X(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$c r1 = (com.google.android.material.appbar.AppBarLayout.c) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = c.h.k.v.z(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = r3
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = r4
            L42:
                boolean r9 = r7.k()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.W(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L55
                goto L56
            L55:
                r3 = r4
            L56:
                r8 = r3
            L57:
                boolean r8 = r7.s(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.m0(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.p0(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // com.google.android.material.appbar.a
        int L() {
            return D() + this.f8029k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: T */
        public boolean G(T t) {
            if (this.r == null) {
                WeakReference<View> weakReference = this.q;
                if (weakReference != null) {
                    View view = weakReference.get();
                    return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
                }
                return true;
            }
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: Z */
        public int J(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: a0 */
        public int K(T t) {
            return t.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: c0 */
        public void M(CoordinatorLayout coordinatorLayout, T t) {
            n0(coordinatorLayout, t);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: d0 */
        public boolean l(CoordinatorLayout coordinatorLayout, T t, int i2) {
            int round;
            boolean l2 = super.l(coordinatorLayout, t, i2);
            int pendingAction = t.getPendingAction();
            int i3 = this.n;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.o) {
                    round = v.z(childAt) + t.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.p);
                }
                O(coordinatorLayout, t, i4 + round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        R(coordinatorLayout, t, i5, 0.0f);
                    } else {
                        O(coordinatorLayout, t, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        R(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        O(coordinatorLayout, t, 0);
                    }
                }
            }
            t.o();
            this.n = -1;
            F(c.h.h.a.b(D(), -t.getTotalScrollRange(), 0));
            p0(coordinatorLayout, t, D(), 0, true);
            t.c(D());
            return l2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: e0 */
        public boolean m(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t.getLayoutParams())).height == -2) {
                coordinatorLayout.D(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                return true;
            }
            return super.m(coordinatorLayout, t, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: f0 */
        public void q(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    i5 = -t.getTotalScrollRange();
                    i6 = t.getDownNestedPreScrollRange() + i5;
                } else {
                    i5 = -t.getUpNestedPreScrollRange();
                    i6 = 0;
                }
                int i7 = i5;
                int i8 = i6;
                if (i7 != i8) {
                    iArr[1] = N(coordinatorLayout, t, i3, i7, i8);
                    o0(i3, t, view, i4);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: g0 */
        public void s(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i5 < 0) {
                N(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
                o0(i5, t, view, i6);
            }
            if (t.k()) {
                t.s(view.getScrollY() > 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: h0 */
        public void w(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof c) {
                c cVar = (c) parcelable;
                super.w(coordinatorLayout, t, cVar.a());
                this.n = cVar.f8033c;
                this.p = cVar.f8034d;
                this.o = cVar.f8035e;
                return;
            }
            super.w(coordinatorLayout, t, parcelable);
            this.n = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: i0 */
        public Parcelable x(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable x = super.x(coordinatorLayout, t);
            int D = D();
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + D;
                if (childAt.getTop() + D <= 0 && bottom >= 0) {
                    c cVar = new c(x);
                    cVar.f8033c = i2;
                    cVar.f8035e = bottom == v.z(childAt) + t.getTopInset();
                    cVar.f8034d = bottom / childAt.getHeight();
                    return cVar;
                }
            }
            return x;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: j0 */
        public boolean z(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.k() || U(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.f8030l = i3;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: k0 */
        public void B(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.f8030l == 0 || i2 == 1) {
                n0(coordinatorLayout, t);
            }
            this.q = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: l0 */
        public int P(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int L = L();
            int i5 = 0;
            if (i3 != 0 && L >= i3 && L <= i4) {
                int b2 = c.h.h.a.b(i2, i3, i4);
                if (L != b2) {
                    int b0 = t.g() ? b0(t, b2) : b2;
                    boolean F = F(b0);
                    i5 = L - b2;
                    this.f8029k = b2 - b0;
                    if (!F && t.g()) {
                        coordinatorLayout.f(t);
                    }
                    t.c(D());
                    p0(coordinatorLayout, t, b2, b2 < L ? -1 : 1, false);
                }
            } else {
                this.f8029k = 0;
            }
            return i5;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes2.dex */
        public static class c extends c.j.a.a {
            public static final Parcelable.Creator<c> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            int f8033c;

            /* renamed from: d  reason: collision with root package name */
            float f8034d;

            /* renamed from: e  reason: collision with root package name */
            boolean f8035e;

            /* loaded from: classes2.dex */
            static class a implements Parcelable.ClassLoaderCreator<c> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public c createFromParcel(Parcel parcel) {
                    return new c(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b */
                public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new c(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c */
                public c[] newArray(int i2) {
                    return new c[i2];
                }
            }

            public c(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f8033c = parcel.readInt();
                this.f8034d = parcel.readFloat();
                this.f8035e = parcel.readByte() != 0;
            }

            @Override // c.j.a.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f8033c);
                parcel.writeFloat(this.f8034d);
                parcel.writeByte(this.f8035e ? (byte) 1 : (byte) 0);
            }

            public c(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.f8019b = -1;
        this.f8020c = -1;
        this.f8022e = 0;
        setOrientation(1);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            e.a(this);
            e.c(this, attributeSet, 0, j.f13274e);
        }
        TypedArray h2 = h.h(context, attributeSet, k.f13286g, 0, j.f13274e, new int[0]);
        v.m0(this, h2.getDrawable(k.f13287h));
        int i3 = k.f13291l;
        if (h2.hasValue(i3)) {
            q(h2.getBoolean(i3, false), false, false);
        }
        if (i2 >= 21) {
            int i4 = k.f13290k;
            if (h2.hasValue(i4)) {
                e.b(this, h2.getDimensionPixelSize(i4, 0));
            }
        }
        if (i2 >= 26) {
            int i5 = k.f13289j;
            if (h2.hasValue(i5)) {
                setKeyboardNavigationCluster(h2.getBoolean(i5, false));
            }
            int i6 = k.f13288i;
            if (h2.hasValue(i6)) {
                setTouchscreenBlocksFocus(h2.getBoolean(i6, false));
            }
        }
        this.f8028l = h2.getBoolean(k.m, false);
        h2.recycle();
        v.w0(this, new a());
    }

    /* loaded from: classes2.dex */
    public static class c extends LinearLayout.LayoutParams {
        int a;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f8036b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.o);
            this.a = obtainStyledAttributes.getInt(k.p, 0);
            int i2 = k.q;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f8036b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.f8036b;
        }

        boolean c() {
            int i2 = this.a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public void d(int i2) {
            this.a = i2;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.a = 1;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        public c(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }
}