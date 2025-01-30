package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import c.h.k.k;
import c.h.k.l;
import c.h.k.o;
import c.h.k.p;
import c.h.k.v;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements o, k {
    private static final String a = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2329b = {16842766};
    androidx.swiperefreshlayout.widget.a A;
    private int B;
    protected int C;
    float D;
    protected int E;
    int F;
    int G;
    androidx.swiperefreshlayout.widget.b H;
    private Animation I;
    private Animation J;
    private Animation K;
    private Animation L;
    private Animation M;
    boolean N;
    private int O;
    boolean P;
    private i Q;
    private Animation.AnimationListener R;
    private final Animation S;
    private final Animation T;

    /* renamed from: c  reason: collision with root package name */
    private View f2330c;

    /* renamed from: d  reason: collision with root package name */
    j f2331d;

    /* renamed from: e  reason: collision with root package name */
    boolean f2332e;

    /* renamed from: f  reason: collision with root package name */
    private int f2333f;

    /* renamed from: g  reason: collision with root package name */
    private float f2334g;

    /* renamed from: h  reason: collision with root package name */
    private float f2335h;

    /* renamed from: j  reason: collision with root package name */
    private final p f2336j;

    /* renamed from: k  reason: collision with root package name */
    private final l f2337k;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f2338l;
    private final int[] m;
    private boolean n;
    private int p;
    int q;
    private float t;
    private float u;
    private boolean v;
    private int w;
    boolean x;
    private boolean y;
    private final DecelerateInterpolator z;

    /* loaded from: classes.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f2332e) {
                swipeRefreshLayout.H.setAlpha(255);
                SwipeRefreshLayout.this.H.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.N && (jVar = swipeRefreshLayout2.f2331d) != null) {
                    jVar.a();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.q = swipeRefreshLayout3.A.getTop();
                return;
            }
            swipeRefreshLayout.l();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends Animation {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2339b;

        d(int i2, int i3) {
            this.a = i2;
            this.f2339b = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            androidx.swiperefreshlayout.widget.b bVar = SwipeRefreshLayout.this.H;
            int i2 = this.a;
            bVar.setAlpha((int) (i2 + ((this.f2339b - i2) * f2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.x) {
                return;
            }
            swipeRefreshLayout.s(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.P) {
                i2 = swipeRefreshLayout.F - Math.abs(swipeRefreshLayout.E);
            } else {
                i2 = swipeRefreshLayout.F;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i3 = swipeRefreshLayout2.C;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i3 + ((int) ((i2 - i3) * f2))) - swipeRefreshLayout2.A.getTop());
            SwipeRefreshLayout.this.H.e(1.0f - f2);
        }
    }

    /* loaded from: classes.dex */
    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.j(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f3 = swipeRefreshLayout.D;
            swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
            SwipeRefreshLayout.this.j(f2);
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* loaded from: classes.dex */
    public interface j {
        void a();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.C = i2;
        this.S.reset();
        this.S.setDuration(200L);
        this.S.setInterpolator(this.z);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.S);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.x) {
            t(i2, animationListener);
            return;
        }
        this.C = i2;
        this.T.reset();
        this.T.setDuration(200L);
        this.T.setInterpolator(this.z);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.T);
    }

    private void d() {
        this.A = new androidx.swiperefreshlayout.widget.a(getContext(), -328966);
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.H = bVar;
        bVar.l(1);
        this.A.setImageDrawable(this.H);
        this.A.setVisibility(8);
        addView(this.A);
    }

    private void e() {
        if (this.f2330c == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.A)) {
                    this.f2330c = childAt;
                    return;
                }
            }
        }
    }

    private void f(float f2) {
        if (f2 > this.f2334g) {
            n(true, true);
            return;
        }
        this.f2332e = false;
        this.H.j(0.0f, 0.0f);
        b(this.q, this.x ? null : new e());
        this.H.d(false);
    }

    private boolean g(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void i(float f2) {
        this.H.d(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f2334g));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f2334g;
        int i2 = this.G;
        if (i2 <= 0) {
            i2 = this.P ? this.F - this.E : this.F;
        }
        float f3 = i2;
        double max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.E + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
        }
        if (!this.x) {
            this.A.setScaleX(1.0f);
            this.A.setScaleY(1.0f);
        }
        if (this.x) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f2334g));
        }
        if (f2 < this.f2334g) {
            if (this.H.getAlpha() > 76 && !g(this.K)) {
                r();
            }
        } else if (this.H.getAlpha() < 255 && !g(this.L)) {
            q();
        }
        this.H.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.H.e(Math.min(1.0f, max));
        this.H.g((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.q);
    }

    private void k(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.w) {
            this.w = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void n(boolean z, boolean z2) {
        if (this.f2332e != z) {
            this.N = z2;
            e();
            this.f2332e = z;
            if (z) {
                a(this.q, this.R);
            } else {
                s(this.R);
            }
        }
    }

    private Animation o(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.A.b(null);
        this.A.clearAnimation();
        this.A.startAnimation(dVar);
        return dVar;
    }

    private void p(float f2) {
        float f3 = this.u;
        int i2 = this.f2333f;
        if (f2 - f3 <= i2 || this.v) {
            return;
        }
        this.t = f3 + i2;
        this.v = true;
        this.H.setAlpha(76);
    }

    private void q() {
        this.L = o(this.H.getAlpha(), 255);
    }

    private void r() {
        this.K = o(this.H.getAlpha(), 76);
    }

    private void setColorViewAlpha(int i2) {
        this.A.getBackground().setAlpha(i2);
        this.H.setAlpha(i2);
    }

    private void t(int i2, Animation.AnimationListener animationListener) {
        this.C = i2;
        this.D = this.A.getScaleX();
        h hVar = new h();
        this.M = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.M);
    }

    private void u(Animation.AnimationListener animationListener) {
        this.A.setVisibility(0);
        this.H.setAlpha(255);
        b bVar = new b();
        this.I = bVar;
        bVar.setDuration(this.p);
        if (animationListener != null) {
            this.A.b(animationListener);
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.I);
    }

    public boolean c() {
        i iVar = this.Q;
        if (iVar != null) {
            return iVar.a(this, this.f2330c);
        }
        View view = this.f2330c;
        if (view instanceof ListView) {
            return androidx.core.widget.g.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f2337k.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2337k.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f2337k.c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f2337k.f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.B;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2336j.a();
    }

    public int getProgressCircleDiameter() {
        return this.O;
    }

    public int getProgressViewEndOffset() {
        return this.F;
    }

    public int getProgressViewStartOffset() {
        return this.E;
    }

    public boolean h() {
        return this.f2332e;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f2337k.k();
    }

    @Override // android.view.View, c.h.k.k
    public boolean isNestedScrollingEnabled() {
        return this.f2337k.m();
    }

    void j(float f2) {
        int i2 = this.C;
        setTargetOffsetTopAndBottom((i2 + ((int) ((this.E - i2) * f2))) - this.A.getTop());
    }

    void l() {
        this.A.clearAnimation();
        this.H.stop();
        this.A.setVisibility(8);
        setColorViewAlpha(255);
        if (this.x) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.E - this.q);
        }
        this.q = this.A.getTop();
    }

    public void m(boolean z, int i2, int i3) {
        this.x = z;
        this.E = i2;
        this.F = i3;
        this.P = true;
        l();
        this.f2332e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e();
        int actionMasked = motionEvent.getActionMasked();
        if (this.y && actionMasked == 0) {
            this.y = false;
        }
        if (!isEnabled() || this.y || c() || this.f2332e || this.n) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.w;
                    if (i2 == -1) {
                        Log.e(a, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    p(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        k(motionEvent);
                    }
                }
            }
            this.v = false;
            this.w = -1;
        } else {
            setTargetOffsetTopAndBottom(this.E - this.A.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.w = pointerId;
            this.v = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.u = motionEvent.getY(findPointerIndex2);
        }
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f2330c == null) {
            e();
        }
        View view = this.f2330c;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.A.getMeasuredWidth();
        int measuredHeight2 = this.A.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.q;
        this.A.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2330c == null) {
            e();
        }
        View view = this.f2330c;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.A.measure(View.MeasureSpec.makeMeasureSpec(this.O, 1073741824), View.MeasureSpec.makeMeasureSpec(this.O, 1073741824));
        this.B = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.A) {
                this.B = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f2335h;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f2335h = 0.0f;
                } else {
                    this.f2335h = f2 - f3;
                    iArr[1] = i3;
                }
                i(this.f2335h);
            }
        }
        if (this.P && i3 > 0 && this.f2335h == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.A.setVisibility(8);
        }
        int[] iArr2 = this.f2338l;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.m);
        int i6 = i5 + this.m[1];
        if (i6 >= 0 || c()) {
            return;
        }
        float abs = this.f2335h + Math.abs(i6);
        this.f2335h = abs;
        i(abs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f2336j.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f2335h = 0.0f;
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.y || this.f2332e || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onStopNestedScroll(View view) {
        this.f2336j.d(view);
        this.n = false;
        float f2 = this.f2335h;
        if (f2 > 0.0f) {
            f(f2);
            this.f2335h = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.y && actionMasked == 0) {
            this.y = false;
        }
        if (!isEnabled() || this.y || c() || this.f2332e || this.n) {
            return false;
        }
        if (actionMasked == 0) {
            this.w = motionEvent.getPointerId(0);
            this.v = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.w);
            if (findPointerIndex < 0) {
                Log.e(a, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.v) {
                this.v = false;
                f((motionEvent.getY(findPointerIndex) - this.t) * 0.5f);
            }
            this.w = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.w);
            if (findPointerIndex2 < 0) {
                Log.e(a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            p(y);
            if (this.v) {
                float f2 = (y - this.t) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                i(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(a, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.w = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                k(motionEvent);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f2330c instanceof AbsListView)) {
            View view = this.f2330c;
            if (view == null || v.T(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    void s(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.J = cVar;
        cVar.setDuration(150L);
        this.A.b(animationListener);
        this.A.clearAnimation();
        this.A.startAnimation(this.J);
    }

    void setAnimationProgress(float f2) {
        this.A.setScaleX(f2);
        this.A.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        e();
        this.H.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = androidx.core.content.a.d(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f2334g = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        l();
    }

    @Override // android.view.View, c.h.k.k
    public void setNestedScrollingEnabled(boolean z) {
        this.f2337k.n(z);
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.Q = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.f2331d = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.A.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.d(getContext(), i2));
    }

    public void setRefreshing(boolean z) {
        int i2;
        if (z && this.f2332e != z) {
            this.f2332e = z;
            if (!this.P) {
                i2 = this.F + this.E;
            } else {
                i2 = this.F;
            }
            setTargetOffsetTopAndBottom(i2 - this.q);
            this.N = false;
            u(this.R);
            return;
        }
        n(z, false);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.O = (int) (displayMetrics.density * 56.0f);
            } else {
                this.O = (int) (displayMetrics.density * 40.0f);
            }
            this.A.setImageDrawable(null);
            this.H.l(i2);
            this.A.setImageDrawable(this.H);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.G = i2;
    }

    void setTargetOffsetTopAndBottom(int i2) {
        this.A.bringToFront();
        v.Y(this.A, i2);
        this.q = this.A.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.f2337k.p(i2);
    }

    @Override // android.view.View, c.h.k.k
    public void stopNestedScroll() {
        this.f2337k.r();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2332e = false;
        this.f2334g = -1.0f;
        this.f2338l = new int[2];
        this.m = new int[2];
        this.w = -1;
        this.B = -1;
        this.R = new a();
        this.S = new f();
        this.T = new g();
        this.f2333f = ViewConfiguration.get(context).getScaledTouchSlop();
        this.p = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.z = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.O = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.F = i2;
        this.f2334g = i2;
        this.f2336j = new p(this);
        this.f2337k = new l(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.O;
        this.q = i3;
        this.E = i3;
        j(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2329b);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}