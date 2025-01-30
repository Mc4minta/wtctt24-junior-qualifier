package c.j.b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import c.h.k.v;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class a {
    private static final Interpolator a = new animation.InterpolatorC0073a();

    /* renamed from: b  reason: collision with root package name */
    private int f3091b;

    /* renamed from: c  reason: collision with root package name */
    private int f3092c;

    /* renamed from: e  reason: collision with root package name */
    private float[] f3094e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f3095f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f3096g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f3097h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f3098i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f3099j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f3100k;

    /* renamed from: l  reason: collision with root package name */
    private int f3101l;
    private VelocityTracker m;
    private float n;
    private float o;
    private int p;
    private final int q;
    private int r;
    private OverScroller s;
    private final c t;
    private View u;
    private boolean v;
    private final ViewGroup w;

    /* renamed from: d  reason: collision with root package name */
    private int f3093d = -1;
    private final Runnable x = new b();

    /* compiled from: ViewDragHelper.java */
    /* renamed from: c.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class animation.InterpolatorC0073a implements Interpolator {
        animation.InterpolatorC0073a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.K(0);
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public int c(int i2) {
            return i2;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i2, int i3) {
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
        }

        public void i(View view, int i2) {
        }

        public abstract void j(int i2);

        public abstract void k(View view, int i2, int i3, int i4, int i5);

        public abstract void l(View view, float f2, float f3);

        public abstract boolean m(View view, int i2);
    }

    private a(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar != null) {
            this.w = viewGroup;
            this.t = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.q = i2;
            this.p = i2;
            this.f3092c = viewConfiguration.getScaledTouchSlop();
            this.n = viewConfiguration.getScaledMaximumFlingVelocity();
            this.o = viewConfiguration.getScaledMinimumFlingVelocity();
            this.s = new OverScroller(context, a);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    private boolean D(int i2) {
        if (C(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void G() {
        this.m.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.n);
        p(g(this.m.getXVelocity(this.f3093d), this.o, this.n), g(this.m.getYVelocity(this.f3093d), this.o, this.n));
    }

    private void H(float f2, float f3, int i2) {
        int i3 = c(f2, f3, i2, 1) ? 1 : 0;
        if (c(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (c(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (c(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f3099j;
            iArr[i2] = iArr[i2] | i3;
            this.t.f(i3, i2);
        }
    }

    private void I(float f2, float f3, int i2) {
        s(i2);
        float[] fArr = this.f3094e;
        this.f3096g[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f3095f;
        this.f3097h[i2] = f3;
        fArr2[i2] = f3;
        this.f3098i[i2] = y((int) f2, (int) f3);
        this.f3101l |= 1 << i2;
    }

    private void J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (D(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f3096g[pointerId] = x;
                this.f3097h[pointerId] = y;
            }
        }
    }

    private boolean c(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f3098i[i2] & i3) != i3 || (this.r & i3) == 0 || (this.f3100k[i2] & i3) == i3 || (this.f3099j[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f3092c;
        if (abs > i4 || abs2 > i4) {
            if (abs >= abs2 * 0.5f || !this.t.g(i3)) {
                return (this.f3099j[i2] & i3) == 0 && abs > ((float) this.f3092c);
            }
            int[] iArr = this.f3100k;
            iArr[i2] = iArr[i2] | i3;
            return false;
        }
        return false;
    }

    private boolean f(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.t.d(view) > 0;
        boolean z2 = this.t.e(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f3092c) : z2 && Math.abs(f3) > ((float) this.f3092c);
        }
        int i2 = this.f3092c;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    private float g(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int h(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void i() {
        float[] fArr = this.f3094e;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f3095f, 0.0f);
        Arrays.fill(this.f3096g, 0.0f);
        Arrays.fill(this.f3097h, 0.0f);
        Arrays.fill(this.f3098i, 0);
        Arrays.fill(this.f3099j, 0);
        Arrays.fill(this.f3100k, 0);
        this.f3101l = 0;
    }

    private void j(int i2) {
        if (this.f3094e == null || !C(i2)) {
            return;
        }
        this.f3094e[i2] = 0.0f;
        this.f3095f[i2] = 0.0f;
        this.f3096g[i2] = 0.0f;
        this.f3097h[i2] = 0.0f;
        this.f3098i[i2] = 0;
        this.f3099j[i2] = 0;
        this.f3100k[i2] = 0;
        this.f3101l = (~(1 << i2)) & this.f3101l;
    }

    private int k(int i2, int i3, int i4) {
        int abs;
        if (i2 == 0) {
            return 0;
        }
        int width = this.w.getWidth();
        float f2 = width / 2;
        float q = f2 + (q(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(q / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int l(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int h2 = h(i4, (int) this.o, (int) this.n);
        int h3 = h(i5, (int) this.o, (int) this.n);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(h2);
        int abs4 = Math.abs(h3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (h2 != 0) {
            f2 = abs3;
            f3 = i6;
        } else {
            f2 = abs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (h3 != 0) {
            f4 = abs4;
            f5 = i6;
        } else {
            f4 = abs2;
            f5 = i7;
        }
        return (int) ((k(i2, h2, this.t.d(view)) * f6) + (k(i3, h3, this.t.e(view)) * (f4 / f5)));
    }

    public static a n(ViewGroup viewGroup, float f2, c cVar) {
        a o = o(viewGroup, cVar);
        o.f3092c = (int) (o.f3092c * (1.0f / f2));
        return o;
    }

    public static a o(ViewGroup viewGroup, c cVar) {
        return new a(viewGroup.getContext(), viewGroup, cVar);
    }

    private void p(float f2, float f3) {
        this.v = true;
        this.t.l(this.u, f2, f3);
        this.v = false;
        if (this.f3091b == 1) {
            K(0);
        }
    }

    private float q(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private void r(int i2, int i3, int i4, int i5) {
        int left = this.u.getLeft();
        int top = this.u.getTop();
        if (i4 != 0) {
            i2 = this.t.a(this.u, i2, i4);
            v.X(this.u, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.t.b(this.u, i3, i5);
            v.Y(this.u, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.t.k(this.u, i6, i7, i6 - left, i7 - top);
    }

    private void s(int i2) {
        float[] fArr = this.f3094e;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f3095f;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f3096g;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f3097h;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f3098i;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3099j;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3100k;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3094e = fArr2;
            this.f3095f = fArr3;
            this.f3096g = fArr4;
            this.f3097h = fArr5;
            this.f3098i = iArr;
            this.f3099j = iArr2;
            this.f3100k = iArr3;
        }
    }

    private boolean u(int i2, int i3, int i4, int i5) {
        int left = this.u.getLeft();
        int top = this.u.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.s.abortAnimation();
            K(0);
            return false;
        }
        this.s.startScroll(left, top, i6, i7, l(this.u, i6, i7, i4, i5));
        K(2);
        return true;
    }

    private int y(int i2, int i3) {
        int i4 = i2 < this.w.getLeft() + this.p ? 1 : 0;
        if (i3 < this.w.getTop() + this.p) {
            i4 |= 4;
        }
        if (i2 > this.w.getRight() - this.p) {
            i4 |= 2;
        }
        return i3 > this.w.getBottom() - this.p ? i4 | 8 : i4;
    }

    public int A() {
        return this.f3091b;
    }

    public boolean B(int i2, int i3) {
        return E(this.u, i2, i3);
    }

    public boolean C(int i2) {
        return ((1 << i2) & this.f3101l) != 0;
    }

    public boolean E(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void F(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View t = t((int) x, (int) y);
            I(x, y, pointerId);
            R(t, pointerId);
            int i4 = this.f3098i[pointerId];
            int i5 = this.r;
            if ((i4 & i5) != 0) {
                this.t.h(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f3091b == 1) {
                G();
            }
            a();
        } else if (actionMasked == 2) {
            if (this.f3091b == 1) {
                if (D(this.f3093d)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f3093d);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f3096g;
                    int i6 = this.f3093d;
                    int i7 = (int) (x2 - fArr[i6]);
                    int i8 = (int) (y2 - this.f3097h[i6]);
                    r(this.u.getLeft() + i7, this.u.getTop() + i8, i7, i8);
                    J(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i3 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if (D(pointerId2)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.f3094e[pointerId2];
                    float f3 = y3 - this.f3095f[pointerId2];
                    H(f2, f3, pointerId2);
                    if (this.f3091b != 1) {
                        View t2 = t((int) x3, (int) y3);
                        if (f(t2, f2, f3) && R(t2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            J(motionEvent);
        } else if (actionMasked == 3) {
            if (this.f3091b == 1) {
                p(0.0f, 0.0f);
            }
            a();
        } else if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            I(x4, y4, pointerId3);
            if (this.f3091b == 0) {
                R(t((int) x4, (int) y4), pointerId3);
                int i9 = this.f3098i[pointerId3];
                int i10 = this.r;
                if ((i9 & i10) != 0) {
                    this.t.h(i9 & i10, pointerId3);
                }
            } else if (B((int) x4, (int) y4)) {
                R(this.u, pointerId3);
            }
        } else if (actionMasked != 6) {
        } else {
            int pointerId4 = motionEvent.getPointerId(actionIndex);
            if (this.f3091b == 1 && pointerId4 == this.f3093d) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i3 >= pointerCount2) {
                        i2 = -1;
                        break;
                    }
                    int pointerId5 = motionEvent.getPointerId(i3);
                    if (pointerId5 != this.f3093d) {
                        View t3 = t((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                        View view = this.u;
                        if (t3 == view && R(view, pointerId5)) {
                            i2 = this.f3093d;
                            break;
                        }
                    }
                    i3++;
                }
                if (i2 == -1) {
                    G();
                }
            }
            j(pointerId4);
        }
    }

    void K(int i2) {
        this.w.removeCallbacks(this.x);
        if (this.f3091b != i2) {
            this.f3091b = i2;
            this.t.j(i2);
            if (this.f3091b == 0) {
                this.u = null;
            }
        }
    }

    public void L(int i2) {
        this.p = i2;
    }

    public void M(int i2) {
        this.r = i2;
    }

    public void N(float f2) {
        this.o = f2;
    }

    public boolean O(int i2, int i3) {
        if (this.v) {
            return u(i2, i3, (int) this.m.getXVelocity(this.f3093d), (int) this.m.getYVelocity(this.f3093d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean P(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.j.b.a.P(android.view.MotionEvent):boolean");
    }

    public boolean Q(View view, int i2, int i3) {
        this.u = view;
        this.f3093d = -1;
        boolean u = u(i2, i3, 0, 0);
        if (!u && this.f3091b == 0 && this.u != null) {
            this.u = null;
        }
        return u;
    }

    boolean R(View view, int i2) {
        if (view == this.u && this.f3093d == i2) {
            return true;
        }
        if (view == null || !this.t.m(view, i2)) {
            return false;
        }
        this.f3093d = i2;
        b(view, i2);
        return true;
    }

    public void a() {
        this.f3093d = -1;
        i();
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public void b(View view, int i2) {
        if (view.getParent() == this.w) {
            this.u = view;
            this.f3093d = i2;
            this.t.i(view, i2);
            K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.w + ")");
    }

    public boolean d(int i2) {
        int length = this.f3094e.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (e(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i2, int i3) {
        if (C(i3)) {
            boolean z = (i2 & 1) == 1;
            boolean z2 = (i2 & 2) == 2;
            float f2 = this.f3096g[i3] - this.f3094e[i3];
            float f3 = this.f3097h[i3] - this.f3095f[i3];
            if (!z || !z2) {
                return z ? Math.abs(f2) > ((float) this.f3092c) : z2 && Math.abs(f3) > ((float) this.f3092c);
            }
            int i4 = this.f3092c;
            return (f2 * f2) + (f3 * f3) > ((float) (i4 * i4));
        }
        return false;
    }

    public boolean m(boolean z) {
        if (this.f3091b == 2) {
            boolean computeScrollOffset = this.s.computeScrollOffset();
            int currX = this.s.getCurrX();
            int currY = this.s.getCurrY();
            int left = currX - this.u.getLeft();
            int top = currY - this.u.getTop();
            if (left != 0) {
                v.X(this.u, left);
            }
            if (top != 0) {
                v.Y(this.u, top);
            }
            if (left != 0 || top != 0) {
                this.t.k(this.u, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.s.getFinalX() && currY == this.s.getFinalY()) {
                this.s.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.w.post(this.x);
                } else {
                    K(0);
                }
            }
        }
        return this.f3091b == 2;
    }

    public View t(int i2, int i3) {
        for (int childCount = this.w.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.w.getChildAt(this.t.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.u;
    }

    public int w() {
        return this.q;
    }

    public int x() {
        return this.p;
    }

    public int z() {
        return this.f3092c;
    }
}