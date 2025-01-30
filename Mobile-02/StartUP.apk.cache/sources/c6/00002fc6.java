package com.facebook.react.views.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import c.h.k.v;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.o;
import com.facebook.react.uimanager.r;
import com.facebook.react.uimanager.s;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: ReactHorizontalScrollView.java */
/* loaded from: classes2.dex */
public class d extends HorizontalScrollView implements r {
    private static Field a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5354b;
    private List<Integer> A;
    private boolean B;
    private boolean C;
    private com.facebook.react.views.view.e D;
    private boolean E;
    private h0 F;
    private final Rect G;

    /* renamed from: c  reason: collision with root package name */
    private final b f5355c;

    /* renamed from: d  reason: collision with root package name */
    private final OverScroller f5356d;

    /* renamed from: e  reason: collision with root package name */
    private final j f5357e;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f5358f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5359g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f5360h;

    /* renamed from: j  reason: collision with root package name */
    private String f5361j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5362k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5363l;
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
    /* compiled from: ReactHorizontalScrollView.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean a = false;

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f5359g) {
                d.this.f5359g = false;
                v.d0(d.this, this, 20L);
                return;
            }
            d dVar = d.this;
            dVar.E(dVar.getScrollX(), d.this.getScrollY());
            if (!d.this.f5363l || this.a) {
                if (d.this.q) {
                    g.g(d.this);
                }
                d.this.m = null;
                d.this.k();
                return;
            }
            this.a = true;
            d.this.n(0);
            v.d0(d.this, this, 20L);
        }
    }

    public d(Context context, com.facebook.react.views.scroll.a aVar) {
        super(context);
        this.f5355c = new b();
        this.f5357e = new j();
        this.f5358f = new Rect();
        this.f5361j = "hidden";
        this.f5363l = false;
        this.p = true;
        this.t = null;
        this.w = 0;
        this.x = false;
        this.y = 0;
        this.z = 0.985f;
        this.B = true;
        this.C = true;
        this.E = false;
        this.G = new Rect();
        this.D = new com.facebook.react.views.view.e(this);
        this.t = aVar;
        this.f5356d = getOverScrollerFromParent();
    }

    private void B(int i2) {
        double snapInterval = getSnapInterval();
        double scrollX = getScrollX();
        double d2 = scrollX / snapInterval;
        int floor = (int) Math.floor(d2);
        int ceil = (int) Math.ceil(d2);
        int round = (int) Math.round(d2);
        int round2 = (int) Math.round(u(i2) / snapInterval);
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
        if (d3 != scrollX) {
            this.f5359g = true;
            w((int) d3, getScrollY());
        }
    }

    private void C(int i2) {
        int width = getWidth();
        int scrollX = getScrollX();
        int i3 = scrollX / width;
        if (scrollX % width != 0) {
            i3++;
        }
        int i4 = i2 == 17 ? i3 - 1 : i3 + 1;
        if (i4 < 0) {
            i4 = 0;
        }
        w(i4 * width, getScrollY());
        p(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i2, int i3) {
        if (this.F == null) {
            return;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("contentOffsetLeft", o.a(i2));
        writableNativeMap.putDouble("contentOffsetTop", o.a(i3));
        this.F.a(writableNativeMap);
    }

    private OverScroller getOverScrollerFromParent() {
        if (!f5354b) {
            f5354b = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                e.f.d.d.a.A("ReactNative", "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
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
                    e.f.d.d.a.A("ReactNative", "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e2);
            }
        }
        return overScroller;
    }

    private int getSnapInterval() {
        int i2 = this.y;
        return i2 != 0 ? i2 : getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (s()) {
            e.f.k.a.a.c(this.t);
            e.f.k.a.a.c(this.u);
            this.t.b(this.u);
        }
    }

    private void l() {
        if (s()) {
            e.f.k.a.a.c(this.t);
            e.f.k.a.a.c(this.u);
            this.t.a(this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i2) {
        int i3;
        int i4;
        int floor;
        int min;
        int i5;
        if (getChildCount() <= 0) {
            return;
        }
        if (this.y == 0 && this.A == null) {
            B(i2);
            return;
        }
        int i6 = 0;
        int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
        int u = u(i2);
        if (this.x) {
            u = getScrollX();
        }
        int width = (getWidth() - v.D(this)) - v.C(this);
        boolean z = c.h.j.e.b(Locale.getDefault()) == 1;
        if (z) {
            u = max - u;
            i3 = -i2;
        } else {
            i3 = i2;
        }
        List<Integer> list = this.A;
        if (list != null) {
            i5 = list.get(0).intValue();
            List<Integer> list2 = this.A;
            i4 = list2.get(list2.size() - 1).intValue();
            min = max;
            floor = 0;
            for (int i7 = 0; i7 < this.A.size(); i7++) {
                int intValue = this.A.get(i7).intValue();
                if (intValue <= u && u - intValue < u - floor) {
                    floor = intValue;
                }
                if (intValue >= u && intValue - u < min - u) {
                    min = intValue;
                }
            }
        } else {
            double snapInterval = getSnapInterval();
            double d2 = u / snapInterval;
            i4 = max;
            floor = (int) (Math.floor(d2) * snapInterval);
            min = Math.min((int) (Math.ceil(d2) * snapInterval), max);
            i5 = 0;
        }
        int i8 = u - floor;
        int i9 = min - u;
        int i10 = i8 < i9 ? floor : min;
        int scrollX = getScrollX();
        if (z) {
            scrollX = max - scrollX;
        }
        if (this.C || u < i4) {
            if (this.B || u > i5) {
                if (i3 > 0) {
                    i3 += (int) (i9 * 10.0d);
                    u = min;
                } else if (i3 < 0) {
                    i3 -= (int) (i8 * 10.0d);
                    u = floor;
                } else {
                    u = i10;
                }
            } else if (scrollX > i5) {
                u = i5;
            }
        } else if (scrollX < i4) {
            u = i4;
        }
        int min2 = Math.min(Math.max(0, u), max);
        if (z) {
            min2 = max - min2;
            i3 = -i3;
        }
        OverScroller overScroller = this.f5356d;
        if (overScroller != null) {
            this.f5359g = true;
            int scrollX2 = getScrollX();
            int scrollY = getScrollY();
            int scrollX3 = i3 != 0 ? i3 : min2 - getScrollX();
            if (min2 == 0 || min2 == max) {
                i6 = width / 2;
            }
            overScroller.fling(scrollX2, scrollY, scrollX3, 0, min2, min2, 0, 0, i6, 0);
            postInvalidateOnAnimation();
            return;
        }
        w(min2, getScrollY());
    }

    private int o(View view) {
        view.getDrawingRect(this.G);
        offsetDescendantRectToMyCoords(view, this.G);
        return computeScrollDeltaToGetChildRectOnScreen(this.G);
    }

    private void p(int i2, int i3) {
        if ((this.q || this.f5363l || s()) && this.m == null) {
            if (this.q) {
                g.f(this, i2, i3);
            }
            this.f5359g = false;
            a aVar = new a();
            this.m = aVar;
            v.d0(this, aVar, 20L);
        }
    }

    private boolean q(View view) {
        int o = o(view);
        view.getDrawingRect(this.G);
        return o != 0 && Math.abs(o) < this.G.width() / 2;
    }

    private boolean r(View view) {
        int o = o(view);
        view.getDrawingRect(this.G);
        return o != 0 && Math.abs(o) < this.G.width();
    }

    private boolean s() {
        String str;
        return (this.t == null || (str = this.u) == null || str.isEmpty()) ? false : true;
    }

    private boolean t(View view) {
        return o(view) == 0;
    }

    private int u(int i2) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.z);
        overScroller.fling(getScrollX(), getScrollY(), i2, 0, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0, 0, ((getWidth() - v.D(this)) - v.C(this)) / 2, 0);
        return overScroller.getFinalX();
    }

    private void x(View view) {
        int o = o(view);
        if (o != 0) {
            scrollBy(o, 0);
        }
    }

    public void A(int i2, float f2) {
        this.D.g(i2, f2);
    }

    public void D(h0 h0Var) {
        this.F = h0Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (this.f5363l && !this.E) {
            ArrayList arrayList2 = new ArrayList();
            super.addFocusables(arrayList2, i2, i3);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                if (t(view) || r(view) || view.isFocused()) {
                    arrayList.add(view);
                }
            }
            return;
        }
        super.addFocusables(arrayList, i2, i3);
    }

    @Override // android.widget.HorizontalScrollView
    public boolean arrowScroll(int i2) {
        if (this.f5363l) {
            boolean z = true;
            this.E = true;
            if (getChildCount() > 0) {
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus(), i2);
                View childAt = getChildAt(0);
                if (childAt != null && findNextFocus != null && findNextFocus.getParent() == childAt) {
                    if (!t(findNextFocus) && !q(findNextFocus)) {
                        C(i2);
                    }
                    findNextFocus.requestFocus();
                } else {
                    C(i2);
                }
            } else {
                z = false;
            }
            this.E = false;
            return z;
        }
        return super.arrowScroll(i2);
    }

    @Override // com.facebook.react.uimanager.r
    public void b() {
        if (this.n) {
            e.f.k.a.a.c(this.f5360h);
            s.a(this, this.f5360h);
            View childAt = getChildAt(0);
            if (childAt instanceof r) {
                ((r) childAt).b();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void draw(Canvas canvas) {
        if (this.w != 0) {
            View childAt = getChildAt(0);
            if (this.v != null && childAt != null && childAt.getRight() < getWidth()) {
                this.v.setBounds(childAt.getRight(), 0, getWidth(), getHeight());
                this.v.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.HorizontalScrollView
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.p || !(keyCode == 21 || keyCode == 22)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.r
    public void f(Rect rect) {
        rect.set((Rect) e.f.k.a.a.c(this.f5360h));
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i2) {
        int abs = (int) (Math.abs(i2) * Math.signum(this.f5355c.a()));
        if (this.f5363l) {
            n(abs);
        } else if (this.f5356d != null) {
            this.f5356d.fling(getScrollX(), getScrollY(), abs, 0, 0, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, 0, 0, ((getWidth() - v.D(this)) - v.C(this)) / 2, 0);
            v.b0(this);
        } else {
            super.fling(abs);
        }
        p(abs, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        if (e.f.m.v.a.f12893g) {
            return s.b(view, rect, point, this, this.f5361j);
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

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.f5358f);
        String str = this.f5361j;
        str.hashCode();
        if (!str.equals("visible")) {
            canvas.clipRect(this.f5358f);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.p) {
            try {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    com.facebook.react.uimanager.events.f.a(this, motionEvent);
                    g.a(this);
                    this.f5362k = true;
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

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        v(getScrollX(), getScrollY());
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        com.facebook.react.uimanager.j.a(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        int computeHorizontalScrollRange;
        OverScroller overScroller = this.f5356d;
        if (overScroller != null && !overScroller.isFinished() && this.f5356d.getCurrX() != this.f5356d.getFinalX() && i2 >= (computeHorizontalScrollRange = computeHorizontalScrollRange() - getWidth())) {
            this.f5356d.abortAnimation();
            i2 = computeHorizontalScrollRange;
        }
        super.onOverScrolled(i2, i3, z, z2);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        this.f5359g = true;
        if (this.f5355c.c(i2, i3)) {
            if (this.n) {
                b();
            }
            g.c(this, this.f5355c.a(), this.f5355c.b());
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.n) {
            b();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p) {
            this.f5357e.a(motionEvent);
            if ((motionEvent.getAction() & 255) == 1 && this.f5362k) {
                E(getScrollX(), getScrollY());
                float b2 = this.f5357e.b();
                float c2 = this.f5357e.c();
                g.b(this, b2, c2);
                this.f5362k = false;
                p(Math.round(b2), Math.round(c2));
            }
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView
    public boolean pageScroll(int i2) {
        boolean pageScroll = super.pageScroll(i2);
        if (this.f5363l && pageScroll) {
            p(0, 0);
        }
        return pageScroll;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 != null && !this.f5363l) {
            x(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.D.b(i2);
    }

    public void setBorderRadius(float f2) {
        this.D.d(f2);
    }

    public void setBorderStyle(String str) {
        this.D.f(str);
    }

    public void setDecelerationRate(float f2) {
        this.z = f2;
        OverScroller overScroller = this.f5356d;
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
        this.f5361j = str;
        invalidate();
    }

    public void setPagingEnabled(boolean z) {
        this.f5363l = z;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.f5360h == null) {
            this.f5360h = new Rect();
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

    public void v(int i2, int i3) {
        scrollTo(i2, i3);
        E(i2, i3);
    }

    public void w(int i2, int i3) {
        smoothScrollTo(i2, i3);
        E(i2, i3);
    }

    public void y(int i2, float f2, float f3) {
        this.D.c(i2, f2, f3);
    }

    public void z(float f2, int i2) {
        this.D.e(f2, i2);
    }
}