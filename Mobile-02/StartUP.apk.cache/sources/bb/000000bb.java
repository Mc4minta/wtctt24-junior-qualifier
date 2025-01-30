package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.m;
import c.h.k.d0;
import com.lwansbrough.RCTCamera.RCTCameraModule;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements x, c.h.k.o, c.h.k.m, c.h.k.n {
    static final int[] a = {c.a.a.f2420b, 16842841};
    private c.h.k.d0 A;
    private c.h.k.d0 B;
    private c.h.k.d0 C;
    private d D;
    private OverScroller E;
    ViewPropertyAnimator F;
    final AnimatorListenerAdapter G;
    private final Runnable H;
    private final Runnable I;
    private final c.h.k.p J;

    /* renamed from: b  reason: collision with root package name */
    private int f664b;

    /* renamed from: c  reason: collision with root package name */
    private int f665c;

    /* renamed from: d  reason: collision with root package name */
    private ContentFrameLayout f666d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f667e;

    /* renamed from: f  reason: collision with root package name */
    private y f668f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f669g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f670h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f671j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f672k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f673l;
    boolean m;
    private int n;
    private int p;
    private final Rect q;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private final Rect x;
    private final Rect y;
    private c.h.k.d0 z;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.m = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.m = false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.f667e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.f667e.animate().translationY(-ActionBarOverlayLayout.this.f667e.getHeight()).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();

        void c(boolean z);

        void d();

        void e();

        void f(int i2);
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f665c = 0;
        this.q = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.x = new Rect();
        this.y = new Rect();
        c.h.k.d0 d0Var = c.h.k.d0.a;
        this.z = d0Var;
        this.A = d0Var;
        this.B = d0Var;
        this.C = d0Var;
        this.G = new a();
        this.H = new b();
        this.I = new c();
        p(context);
        this.J = new c.h.k.p(this);
    }

    private void e() {
        o();
        this.I.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean k(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.k(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private y n(View view) {
        if (view instanceof y) {
            return (y) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void p(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(a);
        this.f664b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f669g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f670h = context.getApplicationInfo().targetSdkVersion < 19;
        this.E = new OverScroller(context);
    }

    private void r() {
        o();
        postDelayed(this.I, 600L);
    }

    private void s() {
        o();
        postDelayed(this.H, 600L);
    }

    private void u() {
        o();
        this.H.run();
    }

    private boolean v(float f2) {
        this.E.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
        return this.E.getFinalY() > this.f667e.getHeight();
    }

    @Override // androidx.appcompat.widget.x
    public void a(Menu menu, m.a aVar) {
        t();
        this.f668f.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.x
    public boolean b() {
        t();
        return this.f668f.b();
    }

    @Override // androidx.appcompat.widget.x
    public void c() {
        t();
        this.f668f.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.x
    public boolean d() {
        t();
        return this.f668f.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f669g == null || this.f670h) {
            return;
        }
        int bottom = this.f667e.getVisibility() == 0 ? (int) (this.f667e.getBottom() + this.f667e.getTranslationY() + 0.5f) : 0;
        this.f669g.setBounds(0, bottom, getWidth(), this.f669g.getIntrinsicHeight() + bottom);
        this.f669g.draw(canvas);
    }

    @Override // androidx.appcompat.widget.x
    public boolean f() {
        t();
        return this.f668f.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        t();
        boolean k2 = k(this.f667e, rect, true, true, false, true);
        this.v.set(rect);
        y0.a(this, this.v, this.q);
        if (!this.w.equals(this.v)) {
            this.w.set(this.v);
            k2 = true;
        }
        if (!this.t.equals(this.q)) {
            this.t.set(this.q);
            k2 = true;
        }
        if (k2) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.x
    public boolean g() {
        t();
        return this.f668f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f667e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.J.a();
    }

    public CharSequence getTitle() {
        t();
        return this.f668f.getTitle();
    }

    @Override // androidx.appcompat.widget.x
    public boolean h() {
        t();
        return this.f668f.h();
    }

    @Override // androidx.appcompat.widget.x
    public void i(int i2) {
        t();
        if (i2 == 2) {
            this.f668f.u();
        } else if (i2 == 5) {
            this.f668f.v();
        } else if (i2 != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.x
    public void j() {
        t();
        this.f668f.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: l */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: m */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    void o() {
        removeCallbacks(this.H);
        removeCallbacks(this.I);
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        t();
        c.h.k.d0 v = c.h.k.d0.v(windowInsets);
        boolean k2 = k(this.f667e, new Rect(v.j(), v.l(), v.k(), v.i()), true, true, false, true);
        c.h.k.v.f(this, v, this.q);
        Rect rect = this.q;
        c.h.k.d0 m = v.m(rect.left, rect.top, rect.right, rect.bottom);
        this.z = m;
        boolean z = true;
        if (!this.A.equals(m)) {
            this.A = this.z;
            k2 = true;
        }
        if (this.t.equals(this.q)) {
            z = k2;
        } else {
            this.t.set(this.q);
        }
        if (z) {
            requestLayout();
        }
        return v.a().c().b().u();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p(getContext());
        c.h.k.v.h0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredHeight;
        t();
        measureChildWithMargins(this.f667e, i2, 0, i3, 0);
        e eVar = (e) this.f667e.getLayoutParams();
        int max = Math.max(0, this.f667e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f667e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f667e.getMeasuredState());
        boolean z = (c.h.k.v.J(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f664b;
            if (this.f672k && this.f667e.getTabContainer() != null) {
                measuredHeight += this.f664b;
            }
        } else {
            measuredHeight = this.f667e.getVisibility() != 8 ? this.f667e.getMeasuredHeight() : 0;
        }
        this.u.set(this.q);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            this.B = this.z;
        } else {
            this.x.set(this.v);
        }
        if (!this.f671j && !z) {
            Rect rect = this.u;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (i4 >= 21) {
                this.B = this.B.m(0, measuredHeight, 0, 0);
            }
        } else if (i4 >= 21) {
            this.B = new d0.b(this.B).c(c.h.e.b.b(this.B.j(), this.B.l() + measuredHeight, this.B.k(), this.B.i() + 0)).a();
        } else {
            Rect rect2 = this.x;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        k(this.f666d, this.u, true, true, true, true);
        if (i4 >= 21 && !this.C.equals(this.B)) {
            c.h.k.d0 d0Var = this.B;
            this.C = d0Var;
            c.h.k.v.g(this.f666d, d0Var);
        } else if (i4 < 21 && !this.y.equals(this.x)) {
            this.y.set(this.x);
            this.f666d.a(this.x);
        }
        measureChildWithMargins(this.f666d, i2, 0, i3, 0);
        e eVar2 = (e) this.f666d.getLayoutParams();
        int max3 = Math.max(max, this.f666d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f666d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f666d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (this.f673l && z) {
            if (v(f3)) {
                e();
            } else {
                u();
            }
            this.m = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // c.h.k.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // c.h.k.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        onNestedScroll(view, i2, i3, i4, i5, i6);
    }

    @Override // c.h.k.m
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // c.h.k.m
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // c.h.k.m
    public void onStopNestedScroll(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        t();
        int i3 = this.p ^ i2;
        this.p = i2;
        boolean z = (i2 & 4) == 0;
        boolean z2 = (i2 & 256) != 0;
        d dVar = this.D;
        if (dVar != null) {
            dVar.c(!z2);
            if (!z && z2) {
                this.D.d();
            } else {
                this.D.a();
            }
        }
        if ((i3 & 256) == 0 || this.D == null) {
            return;
        }
        c.h.k.v.h0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f665c = i2;
        d dVar = this.D;
        if (dVar != null) {
            dVar.f(i2);
        }
    }

    public boolean q() {
        return this.f671j;
    }

    public void setActionBarHideOffset(int i2) {
        o();
        this.f667e.setTranslationY(-Math.max(0, Math.min(i2, this.f667e.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.D = dVar;
        if (getWindowToken() != null) {
            this.D.f(this.f665c);
            int i2 = this.p;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                c.h.k.v.h0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f672k = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f673l) {
            this.f673l = z;
            if (z) {
                return;
            }
            o();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        t();
        this.f668f.setIcon(i2);
    }

    public void setLogo(int i2) {
        t();
        this.f668f.n(i2);
    }

    public void setOverlayMode(boolean z) {
        this.f671j = z;
        this.f670h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.x
    public void setWindowCallback(Window.Callback callback) {
        t();
        this.f668f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.x
    public void setWindowTitle(CharSequence charSequence) {
        t();
        this.f668f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void t() {
        if (this.f666d == null) {
            this.f666d = (ContentFrameLayout) findViewById(c.a.f.f2460b);
            this.f667e = (ActionBarContainer) findViewById(c.a.f.f2461c);
            this.f668f = n(findViewById(c.a.f.a));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    @Override // c.h.k.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.J.b(view, view2, i2);
        this.n = getActionBarHideOffset();
        o();
        d dVar = this.D;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f667e.getVisibility() != 0) {
            return false;
        }
        return this.f673l;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onStopNestedScroll(View view) {
        if (this.f673l && !this.m) {
            if (this.n <= this.f667e.getHeight()) {
                s();
            } else {
                r();
            }
        }
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.n + i3;
        this.n = i6;
        setActionBarHideOffset(i6);
    }

    public void setIcon(Drawable drawable) {
        t();
        this.f668f.setIcon(drawable);
    }
}