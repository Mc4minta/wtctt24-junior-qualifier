package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.v;
import org.apache.http.HttpStatus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastScroller.java */
/* loaded from: classes.dex */
public class i extends RecyclerView.n implements RecyclerView.s {
    private static final int[] a = {16842919};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2166b = new int[0];
    final ValueAnimator B;
    int C;
    private final Runnable D;
    private final RecyclerView.t E;

    /* renamed from: c  reason: collision with root package name */
    private final int f2167c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2168d;

    /* renamed from: e  reason: collision with root package name */
    final StateListDrawable f2169e;

    /* renamed from: f  reason: collision with root package name */
    final Drawable f2170f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2171g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2172h;

    /* renamed from: i  reason: collision with root package name */
    private final StateListDrawable f2173i;

    /* renamed from: j  reason: collision with root package name */
    private final Drawable f2174j;

    /* renamed from: k  reason: collision with root package name */
    private final int f2175k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2176l;
    int m;
    int n;
    float o;
    int p;
    int q;
    float r;
    private RecyclerView u;
    private int s = 0;
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = 0;
    private final int[] z = new int[2];
    private final int[] A = new int[2];

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.h(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            i.this.s(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    private class c extends AnimatorListenerAdapter {
        private boolean a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                this.a = false;
            } else if (((Float) i.this.B.getAnimatedValue()).floatValue() == 0.0f) {
                i iVar = i.this;
                iVar.C = 0;
                iVar.p(0);
            } else {
                i iVar2 = i.this;
                iVar2.C = 2;
                iVar2.m();
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            i.this.f2169e.setAlpha(floatValue);
            i.this.f2170f.setAlpha(floatValue);
            i.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.B = ofFloat;
        this.C = 0;
        this.D = new a();
        this.E = new b();
        this.f2169e = stateListDrawable;
        this.f2170f = drawable;
        this.f2173i = stateListDrawable2;
        this.f2174j = drawable2;
        this.f2171g = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f2172h = Math.max(i2, drawable.getIntrinsicWidth());
        this.f2175k = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f2176l = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f2167c = i3;
        this.f2168d = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        a(recyclerView);
    }

    private void b() {
        this.u.removeCallbacks(this.D);
    }

    private void c() {
        this.u.removeItemDecoration(this);
        this.u.removeOnItemTouchListener(this);
        this.u.removeOnScrollListener(this.E);
        b();
    }

    private void d(Canvas canvas) {
        int i2 = this.t;
        int i3 = this.f2175k;
        int i4 = i2 - i3;
        int i5 = this.q;
        int i6 = this.p;
        int i7 = i5 - (i6 / 2);
        this.f2173i.setBounds(0, 0, i6, i3);
        this.f2174j.setBounds(0, 0, this.s, this.f2176l);
        canvas.translate(0.0f, i4);
        this.f2174j.draw(canvas);
        canvas.translate(i7, 0.0f);
        this.f2173i.draw(canvas);
        canvas.translate(-i7, -i4);
    }

    private void e(Canvas canvas) {
        int i2 = this.s;
        int i3 = this.f2171g;
        int i4 = i2 - i3;
        int i5 = this.n;
        int i6 = this.m;
        int i7 = i5 - (i6 / 2);
        this.f2169e.setBounds(0, 0, i3, i6);
        this.f2170f.setBounds(0, 0, this.f2172h, this.t);
        if (j()) {
            this.f2170f.draw(canvas);
            canvas.translate(this.f2171g, i7);
            canvas.scale(-1.0f, 1.0f);
            this.f2169e.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.f2171g, -i7);
            return;
        }
        canvas.translate(i4, 0.0f);
        this.f2170f.draw(canvas);
        canvas.translate(0.0f, i7);
        this.f2169e.draw(canvas);
        canvas.translate(-i4, -i7);
    }

    private int[] f() {
        int[] iArr = this.A;
        int i2 = this.f2168d;
        iArr[0] = i2;
        iArr[1] = this.s - i2;
        return iArr;
    }

    private int[] g() {
        int[] iArr = this.z;
        int i2 = this.f2168d;
        iArr[0] = i2;
        iArr[1] = this.t - i2;
        return iArr;
    }

    private void i(float f2) {
        int[] f3 = f();
        float max = Math.max(f3[0], Math.min(f3[1], f2));
        if (Math.abs(this.q - max) < 2.0f) {
            return;
        }
        int o = o(this.r, max, f3, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
        if (o != 0) {
            this.u.scrollBy(o, 0);
        }
        this.r = max;
    }

    private boolean j() {
        return v.y(this.u) == 1;
    }

    private void n(int i2) {
        b();
        this.u.postDelayed(this.D, i2);
    }

    private int o(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void q() {
        this.u.addItemDecoration(this);
        this.u.addOnItemTouchListener(this);
        this.u.addOnScrollListener(this.E);
    }

    private void t(float f2) {
        int[] g2 = g();
        float max = Math.max(g2[0], Math.min(g2[1], f2));
        if (Math.abs(this.n - max) < 2.0f) {
            return;
        }
        int o = o(this.o, max, g2, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
        if (o != 0) {
            this.u.scrollBy(0, o);
        }
        this.o = max;
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            c();
        }
        this.u = recyclerView;
        if (recyclerView != null) {
            q();
        }
    }

    void h(int i2) {
        int i3 = this.C;
        if (i3 == 1) {
            this.B.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.C = 3;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.B.setDuration(i2);
        this.B.start();
    }

    boolean k(float f2, float f3) {
        if (f3 >= this.t - this.f2175k) {
            int i2 = this.q;
            int i3 = this.p;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean l(float f2, float f3) {
        if (!j() ? f2 >= this.s - this.f2171g : f2 <= this.f2171g / 2) {
            int i2 = this.n;
            int i3 = this.m;
            if (f3 >= i2 - (i3 / 2) && f3 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    void m() {
        this.u.invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        if (this.s == this.u.getWidth() && this.t == this.u.getHeight()) {
            if (this.C != 0) {
                if (this.v) {
                    e(canvas);
                }
                if (this.w) {
                    d(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.s = this.u.getWidth();
        this.t = this.u.getHeight();
        p(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.x;
        if (i2 == 1) {
            boolean l2 = l(motionEvent.getX(), motionEvent.getY());
            boolean k2 = k(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!l2 && !k2) {
                return false;
            }
            if (k2) {
                this.y = 1;
                this.r = (int) motionEvent.getX();
            } else if (l2) {
                this.y = 2;
                this.o = (int) motionEvent.getY();
            }
            p(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.x == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean l2 = l(motionEvent.getX(), motionEvent.getY());
            boolean k2 = k(motionEvent.getX(), motionEvent.getY());
            if (l2 || k2) {
                if (k2) {
                    this.y = 1;
                    this.r = (int) motionEvent.getX();
                } else if (l2) {
                    this.y = 2;
                    this.o = (int) motionEvent.getY();
                }
                p(2);
            }
        } else if (motionEvent.getAction() == 1 && this.x == 2) {
            this.o = 0.0f;
            this.r = 0.0f;
            p(1);
            this.y = 0;
        } else if (motionEvent.getAction() == 2 && this.x == 2) {
            r();
            if (this.y == 1) {
                i(motionEvent.getX());
            }
            if (this.y == 2) {
                t(motionEvent.getY());
            }
        }
    }

    void p(int i2) {
        if (i2 == 2 && this.x != 2) {
            this.f2169e.setState(a);
            b();
        }
        if (i2 == 0) {
            m();
        } else {
            r();
        }
        if (this.x == 2 && i2 != 2) {
            this.f2169e.setState(f2166b);
            n(1200);
        } else if (i2 == 1) {
            n(1500);
        }
        this.x = i2;
    }

    public void r() {
        int i2 = this.C;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            }
            this.B.cancel();
        }
        this.C = 1;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.B.setDuration(500L);
        this.B.setStartDelay(0L);
        this.B.start();
    }

    void s(int i2, int i3) {
        int computeVerticalScrollRange = this.u.computeVerticalScrollRange();
        int i4 = this.t;
        this.v = computeVerticalScrollRange - i4 > 0 && i4 >= this.f2167c;
        int computeHorizontalScrollRange = this.u.computeHorizontalScrollRange();
        int i5 = this.s;
        boolean z = computeHorizontalScrollRange - i5 > 0 && i5 >= this.f2167c;
        this.w = z;
        boolean z2 = this.v;
        if (!z2 && !z) {
            if (this.x != 0) {
                p(0);
                return;
            }
            return;
        }
        if (z2) {
            float f2 = i4;
            this.n = (int) ((f2 * (i3 + (f2 / 2.0f))) / computeVerticalScrollRange);
            this.m = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
        }
        if (this.w) {
            float f3 = i5;
            this.q = (int) ((f3 * (i2 + (f3 / 2.0f))) / computeHorizontalScrollRange);
            this.p = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
        }
        int i6 = this.x;
        if (i6 == 0 || i6 == 1) {
            p(1);
        }
    }
}