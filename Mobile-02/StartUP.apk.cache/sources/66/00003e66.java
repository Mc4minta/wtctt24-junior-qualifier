package com.rd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import c.h.j.e;
import com.rd.a;
import com.rd.c.b.b;
import com.rd.c.c.d;

/* loaded from: classes2.dex */
public class PageIndicatorView extends View implements ViewPager.j, a.InterfaceC0223a, ViewPager.i, View.OnTouchListener {
    private static final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private com.rd.a f10551b;

    /* renamed from: c  reason: collision with root package name */
    private DataSetObserver f10552c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPager f10553d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10554e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f10555f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PageIndicatorView.this.x();
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PageIndicatorView.this.f10551b.d().H(true);
            PageIndicatorView.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.Auto.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10555f = new b();
        k(attributeSet);
    }

    private int f(int i2) {
        int c2 = this.f10551b.d().c() - 1;
        if (i2 < 0) {
            return 0;
        }
        return i2 > c2 ? c2 : i2;
    }

    private void g() {
        animate().cancel();
        animate().alpha(1.0f).setDuration(250L);
    }

    private ViewPager h(ViewGroup viewGroup, int i2) {
        View findViewById;
        if (viewGroup.getChildCount() > 0 && (findViewById = viewGroup.findViewById(i2)) != null && (findViewById instanceof ViewPager)) {
            return (ViewPager) findViewById;
        }
        return null;
    }

    private void i(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup) && ((ViewGroup) viewParent).getChildCount() > 0) {
            ViewPager h2 = h((ViewGroup) viewParent, this.f10551b.d().u());
            if (h2 != null) {
                setViewPager(h2);
            } else {
                i(viewParent.getParent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        animate().cancel();
        animate().alpha(0.0f).setDuration(250L);
    }

    private void k(AttributeSet attributeSet) {
        t();
        l(attributeSet);
        if (this.f10551b.d().y()) {
            u();
        }
    }

    private void l(AttributeSet attributeSet) {
        com.rd.a aVar = new com.rd.a(this);
        this.f10551b = aVar;
        aVar.c().c(getContext(), attributeSet);
        com.rd.c.c.a d2 = this.f10551b.d();
        d2.O(getPaddingLeft());
        d2.Q(getPaddingTop());
        d2.P(getPaddingRight());
        d2.N(getPaddingBottom());
        this.f10554e = d2.z();
    }

    private boolean m() {
        int i2 = c.a[this.f10551b.d().n().ordinal()];
        if (i2 != 1) {
            return i2 == 3 && e.b(getContext().getResources().getConfiguration().locale) == 1;
        }
        return true;
    }

    private boolean n() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    private void o(int i2, float f2) {
        com.rd.c.c.a d2 = this.f10551b.d();
        if (n() && d2.z() && d2.b() != com.rd.b.d.a.NONE) {
            Pair<Integer, Float> e2 = com.rd.e.a.e(d2, i2, f2, m());
            s(((Integer) e2.first).intValue(), ((Float) e2.second).floatValue());
        }
    }

    private void p(int i2) {
        com.rd.c.c.a d2 = this.f10551b.d();
        boolean n = n();
        int c2 = d2.c();
        if (n) {
            if (m()) {
                i2 = (c2 - 1) - i2;
            }
            setSelection(i2);
        }
    }

    private void q() {
        ViewPager viewPager;
        if (this.f10552c != null || (viewPager = this.f10553d) == null || viewPager.getAdapter() == null) {
            return;
        }
        this.f10552c = new a();
        try {
            this.f10553d.getAdapter().registerDataSetObserver(this.f10552c);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    private void t() {
        if (getId() == -1) {
            setId(com.rd.e.c.b());
        }
    }

    private void u() {
        Handler handler = a;
        handler.removeCallbacks(this.f10555f);
        handler.postDelayed(this.f10555f, this.f10551b.d().e());
    }

    private void v() {
        a.removeCallbacks(this.f10555f);
        g();
    }

    private void w() {
        ViewPager viewPager;
        if (this.f10552c == null || (viewPager = this.f10553d) == null || viewPager.getAdapter() == null) {
            return;
        }
        try {
            this.f10553d.getAdapter().unregisterDataSetObserver(this.f10552c);
            this.f10552c = null;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ViewPager viewPager = this.f10553d;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        int count = this.f10553d.getAdapter().getCount();
        int currentItem = m() ? (count - 1) - this.f10553d.getCurrentItem() : this.f10553d.getCurrentItem();
        this.f10551b.d().V(currentItem);
        this.f10551b.d().W(currentItem);
        this.f10551b.d().K(currentItem);
        this.f10551b.d().D(count);
        this.f10551b.b().b();
        y();
        requestLayout();
    }

    private void y() {
        if (this.f10551b.d().w()) {
            int c2 = this.f10551b.d().c();
            int visibility = getVisibility();
            if (visibility != 0 && c2 > 1) {
                setVisibility(0);
            } else if (visibility == 4 || c2 > 1) {
            } else {
                setVisibility(4);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.i
    public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        DataSetObserver dataSetObserver;
        if (this.f10551b.d().x()) {
            if (aVar != null && (dataSetObserver = this.f10552c) != null) {
                aVar.unregisterDataSetObserver(dataSetObserver);
                this.f10552c = null;
            }
            q();
        }
        x();
    }

    @Override // com.rd.a.InterfaceC0223a
    public void b() {
        invalidate();
    }

    public long getAnimationDuration() {
        return this.f10551b.d().a();
    }

    public int getCount() {
        return this.f10551b.d().c();
    }

    public int getPadding() {
        return this.f10551b.d().h();
    }

    public int getRadius() {
        return this.f10551b.d().m();
    }

    public float getScaleFactor() {
        return this.f10551b.d().o();
    }

    public int getSelectedColor() {
        return this.f10551b.d().p();
    }

    public int getSelection() {
        return this.f10551b.d().q();
    }

    public int getStrokeWidth() {
        return this.f10551b.d().s();
    }

    public int getUnselectedColor() {
        return this.f10551b.d().t();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i(getParent());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        w();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f10551b.c().a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        Pair<Integer, Integer> d2 = this.f10551b.c().d(i2, i3);
        setMeasuredDimension(((Integer) d2.first).intValue(), ((Integer) d2.second).intValue());
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i2) {
        if (i2 == 0) {
            this.f10551b.d().J(this.f10554e);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i2, float f2, int i3) {
        o(i2, f2);
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i2) {
        p(i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof com.rd.c.c.c) {
            com.rd.c.c.a d2 = this.f10551b.d();
            com.rd.c.c.c cVar = (com.rd.c.c.c) parcelable;
            d2.V(cVar.b());
            d2.W(cVar.c());
            d2.K(cVar.a());
            super.onRestoreInstanceState(cVar.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        com.rd.c.c.a d2 = this.f10551b.d();
        com.rd.c.c.c cVar = new com.rd.c.c.c(super.onSaveInstanceState());
        cVar.e(d2.q());
        cVar.f(d2.r());
        cVar.d(d2.f());
        return cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f10551b.d().y()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                v();
            } else if (action == 1) {
                u();
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f10551b.c().f(motionEvent);
        return true;
    }

    public void r() {
        ViewPager viewPager = this.f10553d;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this);
            this.f10553d.removeOnAdapterChangeListener(this);
            this.f10553d = null;
        }
    }

    public void s(int i2, float f2) {
        com.rd.c.c.a d2 = this.f10551b.d();
        if (d2.z()) {
            int c2 = d2.c();
            if (c2 <= 0 || i2 < 0) {
                i2 = 0;
            } else {
                int i3 = c2 - 1;
                if (i2 > i3) {
                    i2 = i3;
                }
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            if (f2 == 1.0f) {
                d2.K(d2.q());
                d2.V(i2);
            }
            d2.W(i2);
            this.f10551b.b().c(f2);
        }
    }

    public void setAnimationDuration(long j2) {
        this.f10551b.d().A(j2);
    }

    public void setAnimationType(com.rd.b.d.a aVar) {
        this.f10551b.a(null);
        if (aVar != null) {
            this.f10551b.d().B(aVar);
        } else {
            this.f10551b.d().B(com.rd.b.d.a.NONE);
        }
        invalidate();
    }

    public void setAutoVisibility(boolean z) {
        if (!z) {
            setVisibility(0);
        }
        this.f10551b.d().C(z);
        y();
    }

    public void setClickListener(b.InterfaceC0225b interfaceC0225b) {
        this.f10551b.c().e(interfaceC0225b);
    }

    public void setCount(int i2) {
        if (i2 < 0 || this.f10551b.d().c() == i2) {
            return;
        }
        this.f10551b.d().D(i2);
        y();
        requestLayout();
    }

    public void setDynamicCount(boolean z) {
        this.f10551b.d().E(z);
        if (z) {
            q();
        } else {
            w();
        }
    }

    public void setFadeOnIdle(boolean z) {
        this.f10551b.d().F(z);
        if (z) {
            u();
        } else {
            v();
        }
    }

    public void setIdleDuration(long j2) {
        this.f10551b.d().I(j2);
        if (this.f10551b.d().y()) {
            u();
        } else {
            v();
        }
    }

    public void setInteractiveAnimation(boolean z) {
        this.f10551b.d().J(z);
        this.f10554e = z;
    }

    public void setOrientation(com.rd.c.c.b bVar) {
        if (bVar != null) {
            this.f10551b.d().L(bVar);
            requestLayout();
        }
    }

    public void setPadding(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f10551b.d().M(com.rd.e.b.a(i2));
        invalidate();
    }

    public void setRadius(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f10551b.d().R(com.rd.e.b.a(i2));
        invalidate();
    }

    public void setRtlMode(d dVar) {
        com.rd.c.c.a d2 = this.f10551b.d();
        if (dVar == null) {
            d2.S(d.Off);
        } else {
            d2.S(dVar);
        }
        if (this.f10553d == null) {
            return;
        }
        int q = d2.q();
        if (m()) {
            q = (d2.c() - 1) - q;
        } else {
            ViewPager viewPager = this.f10553d;
            if (viewPager != null) {
                q = viewPager.getCurrentItem();
            }
        }
        d2.K(q);
        d2.W(q);
        d2.V(q);
        invalidate();
    }

    public void setScaleFactor(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.3f) {
            f2 = 0.3f;
        }
        this.f10551b.d().T(f2);
    }

    public void setSelected(int i2) {
        com.rd.c.c.a d2 = this.f10551b.d();
        com.rd.b.d.a b2 = d2.b();
        d2.B(com.rd.b.d.a.NONE);
        setSelection(i2);
        d2.B(b2);
    }

    public void setSelectedColor(int i2) {
        this.f10551b.d().U(i2);
        invalidate();
    }

    public void setSelection(int i2) {
        com.rd.c.c.a d2 = this.f10551b.d();
        int f2 = f(i2);
        if (f2 == d2.q() || f2 == d2.r()) {
            return;
        }
        d2.J(false);
        d2.K(d2.q());
        d2.W(f2);
        d2.V(f2);
        this.f10551b.b().a();
    }

    public void setStrokeWidth(float f2) {
        int m = this.f10551b.d().m();
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else {
            float f3 = m;
            if (f2 > f3) {
                f2 = f3;
            }
        }
        this.f10551b.d().X((int) f2);
        invalidate();
    }

    public void setUnselectedColor(int i2) {
        this.f10551b.d().Y(i2);
        invalidate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setViewPager(ViewPager viewPager) {
        r();
        if (viewPager == null) {
            return;
        }
        this.f10553d = viewPager;
        viewPager.addOnPageChangeListener(this);
        this.f10553d.addOnAdapterChangeListener(this);
        this.f10553d.setOnTouchListener(this);
        this.f10551b.d().Z(this.f10553d.getId());
        setDynamicCount(this.f10551b.d().x());
        x();
    }

    public void setPadding(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f10551b.d().M((int) f2);
        invalidate();
    }

    public void setRadius(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f10551b.d().R((int) f2);
        invalidate();
    }

    public void setStrokeWidth(int i2) {
        int a2 = com.rd.e.b.a(i2);
        int m = this.f10551b.d().m();
        if (a2 < 0) {
            a2 = 0;
        } else if (a2 > m) {
            a2 = m;
        }
        this.f10551b.d().X(a2);
        invalidate();
    }
}