package com.facebook.react.views.scroll;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import android.widget.ScrollView;
import c.h.k.v;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.o;
import com.facebook.react.uimanager.r;
import com.facebook.react.uimanager.s;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: ReactScrollView.java */
/* loaded from: classes2.dex */
public class e extends ScrollView implements r, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener {
    private static Field a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5365b;
    private List<Integer> A;
    private boolean B;
    private boolean C;
    private View D;
    private com.facebook.react.views.view.e E;
    private h0 F;

    /* renamed from: c  reason: collision with root package name */
    private final b f5366c;

    /* renamed from: d  reason: collision with root package name */
    private final OverScroller f5367d;

    /* renamed from: e  reason: collision with root package name */
    private final j f5368e;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f5369f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5370g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f5371h;

    /* renamed from: j  reason: collision with root package name */
    private String f5372j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5373k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5374l;
    private Runnable m;
    private boolean n;
    private boolean p;
    private boolean q;
    private com.facebook.react.views.scroll.a t;
    private String u;
    private Drawable v;
    private int w;
    private boolean x;
    private int y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactScrollView.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean a = false;

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f5370g) {
                e.this.f5370g = false;
                v.d0(e.this, this, 20L);
                return;
            }
            e eVar = e.this;
            eVar.z(eVar.getScrollX(), e.this.getScrollY());
            if (!e.this.f5374l || this.a) {
                if (e.this.q) {
                    g.g(e.this);
                }
                e.this.m = null;
                e.this.k();
                return;
            }
            this.a = true;
            e.this.n(0);
            v.d0(e.this, this, 20L);
        }
    }

    public e(ReactContext reactContext, com.facebook.react.views.scroll.a aVar) {
        super(reactContext);
        this.f5366c = new b();
        this.f5368e = new j();
        this.f5369f = new Rect();
        this.f5372j = "hidden";
        this.f5374l = false;
        this.p = true;
        this.t = null;
        this.w = 0;
        this.x = false;
        this.y = 0;
        this.z = 0.985f;
        this.B = true;
        this.C = true;
        this.t = aVar;
        this.E = new com.facebook.react.views.view.e(this);
        this.f5367d = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
    }

    private int getMaxScrollY() {
        return Math.max(0, this.D.getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    private OverScroller getOverScrollerFromParent() {
        if (!f5365b) {
            f5365b = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                e.f.d.d.a.A("ReactNative", "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = a;
        OverScroller overScroller = null;
        if (field != null) {
            try {
                Object obj = field.get(this);
                if (obj instanceof OverScroller) {
                    overScroller = (OverScroller) obj;
                } else {
                    e.f.d.d.a.A("ReactNative", "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to get mScroller from ScrollView!", e2);
            }
        }
        return overScroller;
    }

    private int getSnapInterval() {
        int i2 = this.y;
        return i2 != 0 ? i2 : getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (p()) {
            e.f.k.a.a.c(this.t);
            e.f.k.a.a.c(this.u);
            this.t.b(this.u);
        }
    }

    private void l() {
        if (p()) {
            e.f.k.a.a.c(this.t);
            e.f.k.a.a.c(this.u);
            this.t.a(this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:
        if (getScrollY() <= r4) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(int r19) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.e.n(int):void");
    }

    private void o(int i2, int i3) {
        if ((this.q || this.f5374l || p()) && this.m == null) {
            if (this.q) {
                l();
                g.f(this, i2, i3);
            }
            this.f5370g = false;
            a aVar = new a();
            this.m = aVar;
            v.d0(this, aVar, 20L);
        }
    }

    private boolean p() {
        String str;
        return (this.t == null || (str = this.u) == null || str.isEmpty()) ? false : true;
    }

    private int q(int i2) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.z);
        overScroller.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, 0, getMaxScrollY(), 0, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        return overScroller.getFinalY();
    }

    private void t(View view) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private void x(int i2) {
        double snapInterval = getSnapInterval();
        double scrollY = getScrollY();
        double d2 = scrollY / snapInterval;
        int floor = (int) Math.floor(d2);
        int ceil = (int) Math.ceil(d2);
        int round = (int) Math.round(d2);
        int round2 = (int) Math.round(q(i2) / snapInterval);
        if (i2 > 0 && ceil == floor) {
            ceil++;
        } else if (i2 < 0 && floor == ceil) {
            floor--;
        }
        if (i2 > 0 && round < ceil && round2 > floor) {
            round = ceil;
        } else if (i2 < 0 && round > floor && round2 < ceil) {
            round = floor;
        }
        double d3 = round * snapInterval;
        if (d3 != scrollY) {
            this.f5370g = true;
            s(getScrollX(), (int) d3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i2, int i3) {
        if (this.F == null) {
            return;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("contentOffsetLeft", o.a(i2));
        writableNativeMap.putDouble("contentOffsetTop", o.a(i3));
        this.F.a(writableNativeMap);
    }

    @Override // com.facebook.react.uimanager.r
    public void b() {
        if (this.n) {
            e.f.k.a.a.c(this.f5371h);
            s.a(this, this.f5371h);
            View childAt = getChildAt(0);
            if (childAt instanceof r) {
                ((r) childAt).b();
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void draw(Canvas canvas) {
        if (this.w != 0) {
            View childAt = getChildAt(0);
            if (this.v != null && childAt != null && childAt.getBottom() < getHeight()) {
                this.v.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.v.draw(canvas);
            }
        }
        getDrawingRect(this.f5369f);
        String str = this.f5372j;
        str.hashCode();
        if (!str.equals("visible")) {
            canvas.clipRect(this.f5369f);
        }
        super.draw(canvas);
    }

    @Override // android.widget.ScrollView
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.p || !(keyCode == 19 || keyCode == 20)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.r
    public void f(Rect rect) {
        rect.set((Rect) e.f.k.a.a.c(this.f5371h));
    }

    @Override // android.widget.ScrollView
    public void fling(int i2) {
        float signum = Math.signum(this.f5366c.b());
        if (signum == 0.0f) {
            signum = Math.signum(i2);
        }
        int abs = (int) (Math.abs(i2) * signum);
        if (this.f5374l) {
            n(abs);
        } else if (this.f5367d != null) {
            this.f5367d.fling(getScrollX(), getScrollY(), 0, abs, 0, 0, 0, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, 0, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            v.b0(this);
        } else {
            super.fling(abs);
        }
        o(0, abs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        if (e.f.m.v.a.f12893g) {
            return s.b(view, rect, point, this, this.f5372j);
        }
        return super.getChildVisibleRect(view, rect, point);
    }

    @Override // com.facebook.react.uimanager.r
    public boolean getRemoveClippedSubviews() {
        return this.n;
    }

    public void m() {
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n) {
            b();
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        this.D = view2;
        view2.addOnLayoutChangeListener(this);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        this.D.removeOnLayoutChangeListener(this);
        this.D = null;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.p) {
            try {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    com.facebook.react.uimanager.events.f.a(this, motionEvent);
                    g.a(this);
                    this.f5373k = true;
                    l();
                    return true;
                }
            } catch (IllegalArgumentException e2) {
                e.f.d.d.a.B("ReactNative", "Error intercepting touch event.", e2);
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        r(getScrollX(), getScrollY());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.D == null) {
            return;
        }
        int scrollY = getScrollY();
        int maxScrollY = getMaxScrollY();
        if (scrollY > maxScrollY) {
            r(getScrollX(), maxScrollY);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        com.facebook.react.uimanager.j.a(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        int maxScrollY;
        OverScroller overScroller = this.f5367d;
        if (overScroller != null && this.D != null && !overScroller.isFinished() && this.f5367d.getCurrY() != this.f5367d.getFinalY() && i3 >= (maxScrollY = getMaxScrollY())) {
            this.f5367d.abortAnimation();
            i3 = maxScrollY;
        }
        super.onOverScrolled(i2, i3, z, z2);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        this.f5370g = true;
        if (this.f5366c.c(i2, i3)) {
            if (this.n) {
                b();
            }
            g.c(this, this.f5366c.a(), this.f5366c.b());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.n) {
            b();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p) {
            this.f5368e.a(motionEvent);
            if ((motionEvent.getAction() & 255) == 1 && this.f5373k) {
                z(getScrollX(), getScrollY());
                float b2 = this.f5368e.b();
                float c2 = this.f5368e.c();
                g.b(this, b2, c2);
                this.f5373k = false;
                o(Math.round(b2), Math.round(c2));
            }
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void r(int i2, int i3) {
        scrollTo(i2, i3);
        z(i2, i3);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 != null) {
            t(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void s(int i2, int i3) {
        smoothScrollTo(i2, i3);
        z(i2, i3);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.E.b(i2);
    }

    public void setBorderRadius(float f2) {
        this.E.d(f2);
    }

    public void setBorderStyle(String str) {
        this.E.f(str);
    }

    public void setDecelerationRate(float f2) {
        this.z = f2;
        OverScroller overScroller = this.f5367d;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f2);
        }
    }

    public void setDisableIntervalMomentum(boolean z) {
        this.x = z;
    }

    public void setEndFillColor(int i2) {
        if (i2 != this.w) {
            this.w = i2;
            this.v = new ColorDrawable(this.w);
        }
    }

    public void setOverflow(String str) {
        this.f5372j = str;
        invalidate();
    }

    public void setPagingEnabled(boolean z) {
        this.f5374l = z;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.f5371h == null) {
            this.f5371h = new Rect();
        }
        this.n = z;
        b();
    }

    public void setScrollEnabled(boolean z) {
        this.p = z;
    }

    public void setScrollPerfTag(String str) {
        this.u = str;
    }

    public void setSendMomentumEvents(boolean z) {
        this.q = z;
    }

    public void setSnapInterval(int i2) {
        this.y = i2;
    }

    public void setSnapOffsets(List<Integer> list) {
        this.A = list;
    }

    public void setSnapToEnd(boolean z) {
        this.C = z;
    }

    public void setSnapToStart(boolean z) {
        this.B = z;
    }

    public void u(int i2, float f2, float f3) {
        this.E.c(i2, f2, f3);
    }

    public void v(float f2, int i2) {
        this.E.e(f2, i2);
    }

    public void w(int i2, float f2) {
        this.E.g(i2, f2);
    }

    public void y(h0 h0Var) {
        this.F = h0Var;
    }
}