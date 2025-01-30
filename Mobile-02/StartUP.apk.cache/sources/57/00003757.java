package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import c.a.i;
import c.h.k.d0;
import c.h.k.q;
import c.h.k.v;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.h;
import e.g.a.f.f;
import e.g.a.f.j;
import e.g.a.f.k;

/* loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    d0 A;
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private int f8037b;

    /* renamed from: c  reason: collision with root package name */
    private Toolbar f8038c;

    /* renamed from: d  reason: collision with root package name */
    private View f8039d;

    /* renamed from: e  reason: collision with root package name */
    private View f8040e;

    /* renamed from: f  reason: collision with root package name */
    private int f8041f;

    /* renamed from: g  reason: collision with root package name */
    private int f8042g;

    /* renamed from: h  reason: collision with root package name */
    private int f8043h;

    /* renamed from: j  reason: collision with root package name */
    private int f8044j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f8045k;

    /* renamed from: l  reason: collision with root package name */
    final com.google.android.material.internal.b f8046l;
    private boolean m;
    private boolean n;
    private Drawable p;
    Drawable q;
    private int t;
    private boolean u;
    private ValueAnimator v;
    private long w;
    private int x;
    private AppBarLayout.d y;
    int z;

    /* loaded from: classes2.dex */
    class a implements q {
        a() {
        }

        @Override // c.h.k.q
        public d0 a(View view, d0 d0Var) {
            return CollapsingToolbarLayout.this.j(d0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes2.dex */
    private class d implements AppBarLayout.d {
        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.z = i2;
            d0 d0Var = collapsingToolbarLayout.A;
            int l2 = d0Var != null ? d0Var.l() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                c cVar = (c) childAt.getLayoutParams();
                com.google.android.material.appbar.d h2 = CollapsingToolbarLayout.h(childAt);
                int i4 = cVar.a;
                if (i4 == 1) {
                    h2.e(c.h.h.a.b(-i2, 0, CollapsingToolbarLayout.this.g(childAt)));
                } else if (i4 == 2) {
                    h2.e(Math.round((-i2) * cVar.f8047b));
                }
            }
            CollapsingToolbarLayout.this.n();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.q != null && l2 > 0) {
                v.b0(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.f8046l.P(Math.abs(i2) / ((CollapsingToolbarLayout.this.getHeight() - v.z(CollapsingToolbarLayout.this)) - l2));
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i2) {
        b();
        ValueAnimator valueAnimator = this.v;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.v = valueAnimator2;
            valueAnimator2.setDuration(this.w);
            this.v.setInterpolator(i2 > this.t ? e.g.a.f.l.a.f13293c : e.g.a.f.l.a.f13294d);
            this.v.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.v.cancel();
        }
        this.v.setIntValues(this.t, i2);
        this.v.start();
    }

    private void b() {
        if (this.a) {
            Toolbar toolbar = null;
            this.f8038c = null;
            this.f8039d = null;
            int i2 = this.f8037b;
            if (i2 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i2);
                this.f8038c = toolbar2;
                if (toolbar2 != null) {
                    this.f8039d = c(toolbar2);
                }
            }
            if (this.f8038c == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i3++;
                }
                this.f8038c = toolbar;
            }
            m();
            this.a = false;
        }
    }

    private View c(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return view;
    }

    private static int f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    static com.google.android.material.appbar.d h(View view) {
        int i2 = f.p;
        com.google.android.material.appbar.d dVar = (com.google.android.material.appbar.d) view.getTag(i2);
        if (dVar == null) {
            com.google.android.material.appbar.d dVar2 = new com.google.android.material.appbar.d(view);
            view.setTag(i2, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private boolean i(View view) {
        View view2 = this.f8039d;
        if (view2 == null || view2 == this) {
            if (view == this.f8038c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void l() {
        setContentDescription(getTitle());
    }

    private void m() {
        View view;
        if (!this.m && (view = this.f8040e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8040e);
            }
        }
        if (!this.m || this.f8038c == null) {
            return;
        }
        if (this.f8040e == null) {
            this.f8040e = new View(getContext());
        }
        if (this.f8040e.getParent() == null) {
            this.f8038c.addView(this.f8040e, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: d */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f8038c == null && (drawable = this.p) != null && this.t > 0) {
            drawable.mutate().setAlpha(this.t);
            this.p.draw(canvas);
        }
        if (this.m && this.n) {
            this.f8046l.i(canvas);
        }
        if (this.q == null || this.t <= 0) {
            return;
        }
        d0 d0Var = this.A;
        int l2 = d0Var != null ? d0Var.l() : 0;
        if (l2 > 0) {
            this.q.setBounds(0, -this.z, getWidth(), l2 - this.z);
            this.q.mutate().setAlpha(this.t);
            this.q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.p == null || this.t <= 0 || !i(view)) {
            z = false;
        } else {
            this.p.mutate().setAlpha(this.t);
            this.p.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j2) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.p;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.f8046l;
        if (bVar != null) {
            z |= bVar.S(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    final int g(View view) {
        return ((getHeight() - h(view).a()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    public int getCollapsedTitleGravity() {
        return this.f8046l.m();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f8046l.o();
    }

    public Drawable getContentScrim() {
        return this.p;
    }

    public int getExpandedTitleGravity() {
        return this.f8046l.r();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f8044j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f8043h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f8041f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f8042g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f8046l.s();
    }

    int getScrimAlpha() {
        return this.t;
    }

    public long getScrimAnimationDuration() {
        return this.w;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.x;
        if (i2 >= 0) {
            return i2;
        }
        d0 d0Var = this.A;
        int l2 = d0Var != null ? d0Var.l() : 0;
        int z = v.z(this);
        if (z > 0) {
            return Math.min((z * 2) + l2, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.q;
    }

    public CharSequence getTitle() {
        if (this.m) {
            return this.f8046l.u();
        }
        return null;
    }

    d0 j(d0 d0Var) {
        d0 d0Var2 = v.v(this) ? d0Var : null;
        if (!androidx.core.util.d.a(this.A, d0Var2)) {
            this.A = d0Var2;
            requestLayout();
        }
        return d0Var.c();
    }

    public void k(boolean z, boolean z2) {
        if (this.u != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.u = z;
        }
    }

    final void n() {
        if (this.p == null && this.q == null) {
            return;
        }
        setScrimsShown(getHeight() + this.z < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            v.r0(this, v.v((View) parent));
            if (this.y == null) {
                this.y = new d();
            }
            ((AppBarLayout) parent).b(this.y);
            v.h0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.d dVar = this.y;
        if (dVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).n(dVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        d0 d0Var = this.A;
        if (d0Var != null) {
            int l2 = d0Var.l();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!v.v(childAt) && childAt.getTop() < l2) {
                    v.Y(childAt, l2);
                }
            }
        }
        if (this.m && (view = this.f8040e) != null) {
            boolean z2 = v.Q(view) && this.f8040e.getVisibility() == 0;
            this.n = z2;
            if (z2) {
                boolean z3 = v.y(this) == 1;
                View view2 = this.f8039d;
                if (view2 == null) {
                    view2 = this.f8038c;
                }
                int g2 = g(view2);
                com.google.android.material.internal.c.a(this, this.f8040e, this.f8045k);
                this.f8046l.E(this.f8045k.left + (z3 ? this.f8038c.getTitleMarginEnd() : this.f8038c.getTitleMarginStart()), this.f8045k.top + g2 + this.f8038c.getTitleMarginTop(), this.f8045k.right + (z3 ? this.f8038c.getTitleMarginStart() : this.f8038c.getTitleMarginEnd()), (this.f8045k.bottom + g2) - this.f8038c.getTitleMarginBottom());
                this.f8046l.J(z3 ? this.f8043h : this.f8041f, this.f8045k.top + this.f8042g, (i4 - i2) - (z3 ? this.f8041f : this.f8043h), (i5 - i3) - this.f8044j);
                this.f8046l.C();
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            h(getChildAt(i7)).c();
        }
        if (this.f8038c != null) {
            if (this.m && TextUtils.isEmpty(this.f8046l.u())) {
                setTitle(this.f8038c.getTitle());
            }
            View view3 = this.f8039d;
            if (view3 != null && view3 != this) {
                setMinimumHeight(f(view3));
            } else {
                setMinimumHeight(f(this.f8038c));
            }
        }
        n();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        d0 d0Var = this.A;
        int l2 = d0Var != null ? d0Var.l() : 0;
        if (mode != 0 || l2 <= 0) {
            return;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + l2, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f8046l.H(i2);
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.f8046l.F(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f8046l.I(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.p = mutate;
            if (mutate != null) {
                mutate.setBounds(0, 0, getWidth(), getHeight());
                this.p.setCallback(this);
                this.p.setAlpha(this.t);
            }
            v.b0(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(androidx.core.content.a.f(getContext(), i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.f8046l.M(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f8044j = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f8043h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f8041f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f8042g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.f8046l.K(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f8046l.L(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f8046l.O(typeface);
    }

    void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.t) {
            if (this.p != null && (toolbar = this.f8038c) != null) {
                v.b0(toolbar);
            }
            this.t = i2;
            v.b0(this);
        }
    }

    public void setScrimAnimationDuration(long j2) {
        this.w = j2;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.x != i2) {
            this.x = i2;
            n();
        }
    }

    public void setScrimsShown(boolean z) {
        k(z, v.S(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.q = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.q, v.y(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
                this.q.setAlpha(this.t);
            }
            v.b0(this);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(androidx.core.content.a.f(getContext(), i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.f8046l.T(charSequence);
        l();
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            l();
            m();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable != null && drawable.isVisible() != z) {
            this.q.setVisible(z, false);
        }
        Drawable drawable2 = this.p;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.p.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p || drawable == this.q;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        this.f8045k = new Rect();
        this.x = -1;
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f8046l = bVar;
        bVar.U(e.g.a.f.l.a.f13295e);
        TypedArray h2 = h.h(context, attributeSet, k.R, i2, j.f13276g, new int[0]);
        bVar.M(h2.getInt(k.V, 8388691));
        bVar.H(h2.getInt(k.S, 8388627));
        int dimensionPixelSize = h2.getDimensionPixelSize(k.W, 0);
        this.f8044j = dimensionPixelSize;
        this.f8043h = dimensionPixelSize;
        this.f8042g = dimensionPixelSize;
        this.f8041f = dimensionPixelSize;
        int i3 = k.Z;
        if (h2.hasValue(i3)) {
            this.f8041f = h2.getDimensionPixelSize(i3, 0);
        }
        int i4 = k.Y;
        if (h2.hasValue(i4)) {
            this.f8043h = h2.getDimensionPixelSize(i4, 0);
        }
        int i5 = k.a0;
        if (h2.hasValue(i5)) {
            this.f8042g = h2.getDimensionPixelSize(i5, 0);
        }
        int i6 = k.X;
        if (h2.hasValue(i6)) {
            this.f8044j = h2.getDimensionPixelSize(i6, 0);
        }
        this.m = h2.getBoolean(k.g0, true);
        setTitle(h2.getText(k.f0));
        bVar.K(j.f13271b);
        bVar.F(i.f2493b);
        int i7 = k.b0;
        if (h2.hasValue(i7)) {
            bVar.K(h2.getResourceId(i7, 0));
        }
        int i8 = k.T;
        if (h2.hasValue(i8)) {
            bVar.F(h2.getResourceId(i8, 0));
        }
        this.x = h2.getDimensionPixelSize(k.d0, -1);
        this.w = h2.getInt(k.c0, 600);
        setContentScrim(h2.getDrawable(k.U));
        setStatusBarScrim(h2.getDrawable(k.e0));
        this.f8037b = h2.getResourceId(k.h0, -1);
        h2.recycle();
        setWillNotDraw(false);
        v.w0(this, new a());
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f8046l.G(colorStateList);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* loaded from: classes2.dex */
    public static class c extends FrameLayout.LayoutParams {
        int a;

        /* renamed from: b  reason: collision with root package name */
        float f8047b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.f8047b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.i0);
            this.a = obtainStyledAttributes.getInt(k.j0, 0);
            a(obtainStyledAttributes.getFloat(k.k0, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f2) {
            this.f8047b = f2;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
            this.f8047b = 0.5f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.f8047b = 0.5f;
        }
    }
}