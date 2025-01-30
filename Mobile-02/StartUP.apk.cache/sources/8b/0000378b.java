package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.h;
import androidx.appcompat.widget.k;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.l;
import c.h.k.u;
import c.h.k.v;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.j;
import e.g.a.f.d;
import java.util.List;

@CoordinatorLayout.d(Behavior.class)
/* loaded from: classes2.dex */
public class FloatingActionButton extends j implements u, l, e.g.a.f.o.a {

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f8141b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f8142c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f8143d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f8144e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f8145f;

    /* renamed from: g  reason: collision with root package name */
    private int f8146g;

    /* renamed from: h  reason: collision with root package name */
    private int f8147h;

    /* renamed from: j  reason: collision with root package name */
    private int f8148j;

    /* renamed from: k  reason: collision with root package name */
    private int f8149k;

    /* renamed from: l  reason: collision with root package name */
    boolean f8150l;
    final Rect m;
    private final Rect n;
    private final k p;
    private com.google.android.material.floatingactionbutton.a q;

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean D(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.l(coordinatorLayout, floatingActionButton, i2);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.f fVar) {
            super.g(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements a.g {
        a(b bVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.a.g
        public void a() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.a.g
        public void b() {
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements e.g.a.f.s.b {
        c() {
        }

        @Override // e.g.a.f.s.b
        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.m.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f8148j, i3 + FloatingActionButton.this.f8148j, i4 + FloatingActionButton.this.f8148j, i5 + FloatingActionButton.this.f8148j);
        }

        @Override // e.g.a.f.s.b
        public void b(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // e.g.a.f.s.b
        public boolean c() {
            return FloatingActionButton.this.f8150l;
        }

        @Override // e.g.a.f.s.b
        public float d() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }
    }

    private com.google.android.material.floatingactionbutton.a g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.material.floatingactionbutton.b(this, new c());
        }
        return new com.google.android.material.floatingactionbutton.a(this, new c());
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.q == null) {
            this.q = g();
        }
        return this.q;
    }

    private int j(int i2) {
        int i3 = this.f8147h;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(d.f13251k);
            }
            return resources.getDimensionPixelSize(d.f13250j);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return j(1);
        } else {
            return j(0);
        }
    }

    private void m(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.m;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void n() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f8143d;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f8144e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(h.e(colorForState, mode));
    }

    private static int q(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i2;
        }
        return Math.min(i2, size);
    }

    private a.g s(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // e.g.a.f.o.a
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().w(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f8141b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f8142c;
    }

    public float getCompatElevation() {
        return getImpl().j();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().l();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().n();
    }

    public Drawable getContentBackground() {
        return getImpl().g();
    }

    public int getCustomSize() {
        return this.f8147h;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public e.g.a.f.l.h getHideMotionSpec() {
        return getImpl().k();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f8145f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f8145f;
    }

    public e.g.a.f.l.h getShowMotionSpec() {
        return getImpl().o();
    }

    public int getSize() {
        return this.f8146g;
    }

    int getSizeDimension() {
        return j(this.f8146g);
    }

    @Override // c.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // c.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        return this.f8143d;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f8144e;
    }

    public boolean getUseCompatPadding() {
        return this.f8150l;
    }

    @Deprecated
    public boolean h(Rect rect) {
        if (v.S(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            m(rect);
            return true;
        }
        return false;
    }

    public void i(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().s();
    }

    void k(b bVar, boolean z) {
        getImpl().p(s(bVar), z);
    }

    public boolean l() {
        return getImpl().r();
    }

    public void o(Animator.AnimatorListener animatorListener) {
        getImpl().A(animatorListener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().t();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().v();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f8148j = (sizeDimension - this.f8149k) / 2;
        getImpl().Q();
        int min = Math.min(q(sizeDimension, i2), q(sizeDimension, i3));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e.g.a.f.u.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e.g.a.f.u.a aVar = (e.g.a.f.u.a) parcelable;
        super.onRestoreInstanceState(aVar.a());
        aVar.f13337c.get("expandableWidgetHelper");
        throw null;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        new e.g.a.f.u.a(super.onSaveInstanceState());
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && h(this.n) && !this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(Animator.AnimatorListener animatorListener) {
        getImpl().B(animatorListener);
    }

    void r(b bVar, boolean z) {
        getImpl().N(s(bVar), z);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8141b != colorStateList) {
            this.f8141b = colorStateList;
            getImpl().D(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f8142c != mode) {
            this.f8142c = mode;
            getImpl().E(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().F(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().H(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().J(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 >= 0) {
            this.f8147h = i2;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int i2) {
        throw null;
    }

    public void setHideMotionSpec(e.g.a.f.l.h hVar) {
        getImpl().G(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(e.g.a.f.l.h.b(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().P();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.p.g(i2);
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setShowMotionSpec(e.g.a.f.l.h hVar) {
        getImpl().L(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(e.g.a.f.l.h.b(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f8147h = 0;
        if (i2 != this.f8146g) {
            this.f8146g = i2;
            requestLayout();
        }
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f8143d != colorStateList) {
            this.f8143d = colorStateList;
            n();
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f8144e != mode) {
            this.f8144e = mode;
            n();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f8150l != z) {
            this.f8150l = z;
            getImpl().u();
        }
    }

    /* loaded from: classes2.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {
        private Rect a;

        /* renamed from: b  reason: collision with root package name */
        private b f8151b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8152c;

        public BaseBehavior() {
            this.f8152c = true;
        }

        private static boolean E(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void F(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i3 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                v.Y(floatingActionButton, i3);
            }
            if (i2 != 0) {
                v.X(floatingActionButton, i2);
            }
        }

        private boolean I(View view, FloatingActionButton floatingActionButton) {
            return this.f8152c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean J(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (I(appBarLayout, floatingActionButton)) {
                if (this.a == null) {
                    this.a = new Rect();
                }
                Rect rect = this.a;
                com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    floatingActionButton.k(this.f8151b, false);
                    return true;
                }
                floatingActionButton.r(this.f8151b, false);
                return true;
            }
            return false;
        }

        private boolean K(View view, FloatingActionButton floatingActionButton) {
            if (I(view, floatingActionButton)) {
                if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                    floatingActionButton.k(this.f8151b, false);
                    return true;
                }
                floatingActionButton.r(this.f8151b, false);
                return true;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: D */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: G */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                J(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (E(view)) {
                K(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List<View> l2 = coordinatorLayout.l(floatingActionButton);
            int size = l2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = l2.get(i3);
                if (view instanceof AppBarLayout) {
                    if (J(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (E(view) && K(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.C(floatingActionButton, i2);
            F(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f1371h == 0) {
                fVar.f1371h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.g.a.f.k.s0);
            this.f8152c = obtainStyledAttributes.getBoolean(e.g.a.f.k.t0, true);
            obtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f8145f != colorStateList) {
            this.f8145f = colorStateList;
            getImpl().K(this.f8145f);
        }
    }
}