package c.k.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import c.h.k.d0;
import c.h.k.e0.d;
import c.h.k.e0.g;
import c.h.k.v;
import c.j.b.a;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: DrawerLayout.java */
/* loaded from: classes.dex */
public class a extends ViewGroup {
    private static final int[] a = {16843828};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f3108b = {16842931};

    /* renamed from: c  reason: collision with root package name */
    static final boolean f3109c;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f3110d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f3111e;
    private boolean A;
    private e B;
    private List<e> C;
    private float D;
    private float E;
    private Drawable F;
    private Drawable G;
    private Drawable H;
    private CharSequence I;
    private CharSequence J;
    private Object K;
    private boolean L;
    private Drawable M;
    private Drawable N;
    private Drawable O;
    private Drawable P;
    private final ArrayList<View> Q;
    private Rect R;
    private Matrix S;
    private final c.h.k.e0.g T;

    /* renamed from: f  reason: collision with root package name */
    private final d f3112f;

    /* renamed from: g  reason: collision with root package name */
    private float f3113g;

    /* renamed from: h  reason: collision with root package name */
    private int f3114h;

    /* renamed from: j  reason: collision with root package name */
    private int f3115j;

    /* renamed from: k  reason: collision with root package name */
    private float f3116k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f3117l;
    private final c.j.b.a m;
    private final c.j.b.a n;
    private final h p;
    private final h q;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* compiled from: DrawerLayout.java */
    /* renamed from: c.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0074a implements c.h.k.e0.g {
        C0074a() {
        }

        @Override // c.h.k.e0.g
        public boolean a(View view, g.a aVar) {
            if (!a.this.C(view) || a.this.r(view) == 2) {
                return false;
            }
            a.this.f(view);
            return true;
        }
    }

    /* compiled from: DrawerLayout.java */
    /* loaded from: classes.dex */
    class b implements View.OnApplyWindowInsetsListener {
        b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((a) view).Q(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* compiled from: DrawerLayout.java */
    /* loaded from: classes.dex */
    class c extends c.h.k.a {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f3118d = new Rect();

        c() {
        }

        private void n(c.h.k.e0.d dVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (a.A(childAt)) {
                    dVar.c(childAt);
                }
            }
        }

        private void o(c.h.k.e0.d dVar, c.h.k.e0.d dVar2) {
            Rect rect = this.f3118d;
            dVar2.l(rect);
            dVar.Q(rect);
            dVar.s0(dVar2.I());
            dVar.g0(dVar2.r());
            dVar.T(dVar2.m());
            dVar.X(dVar2.o());
            dVar.a0(dVar2.B());
            dVar.d0(dVar2.D());
            dVar.O(dVar2.x());
            dVar.n0(dVar2.H());
            dVar.a(dVar2.j());
        }

        @Override // c.h.k.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View p = a.this.p();
                if (p != null) {
                    CharSequence s = a.this.s(a.this.t(p));
                    if (s != null) {
                        text.add(s);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // c.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            if (a.f3109c) {
                super.g(view, dVar);
            } else {
                c.h.k.e0.d J = c.h.k.e0.d.J(dVar);
                super.g(view, J);
                dVar.p0(view);
                ViewParent E = v.E(view);
                if (E instanceof View) {
                    dVar.i0((View) E);
                }
                o(dVar, J);
                J.L();
                n(dVar, (ViewGroup) view);
            }
            dVar.T("androidx.drawerlayout.widget.DrawerLayout");
            dVar.c0(false);
            dVar.d0(false);
            dVar.M(d.a.a);
            dVar.M(d.a.f3033b);
        }

        @Override // c.h.k.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (a.f3109c || a.A(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* compiled from: DrawerLayout.java */
    /* loaded from: classes.dex */
    static final class d extends c.h.k.a {
        d() {
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            super.g(view, dVar);
            if (a.A(view)) {
                return;
            }
            dVar.i0(null);
        }
    }

    /* compiled from: DrawerLayout.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(View view);

        void b(View view);

        void c(int i2);

        void d(View view, float f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DrawerLayout.java */
    /* loaded from: classes.dex */
    public class h extends a.c {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private c.j.b.a f3128b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f3129c = new RunnableC0076a();

        /* compiled from: DrawerLayout.java */
        /* renamed from: c.k.d.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0076a implements Runnable {
            RunnableC0076a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.o();
            }
        }

        h(int i2) {
            this.a = i2;
        }

        private void n() {
            View n = a.this.n(this.a == 3 ? 5 : 3);
            if (n != null) {
                a.this.f(n);
            }
        }

        @Override // c.j.b.a.c
        public int a(View view, int i2, int i3) {
            if (a.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = a.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        @Override // c.j.b.a.c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // c.j.b.a.c
        public int d(View view) {
            if (a.this.D(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // c.j.b.a.c
        public void f(int i2, int i3) {
            View n;
            if ((i2 & 1) == 1) {
                n = a.this.n(3);
            } else {
                n = a.this.n(5);
            }
            if (n == null || a.this.r(n) != 0) {
                return;
            }
            this.f3128b.b(n, i3);
        }

        @Override // c.j.b.a.c
        public boolean g(int i2) {
            return false;
        }

        @Override // c.j.b.a.c
        public void h(int i2, int i3) {
            a.this.postDelayed(this.f3129c, 160L);
        }

        @Override // c.j.b.a.c
        public void i(View view, int i2) {
            ((f) view.getLayoutParams()).f3121c = false;
            n();
        }

        @Override // c.j.b.a.c
        public void j(int i2) {
            a.this.V(i2, this.f3128b.v());
        }

        @Override // c.j.b.a.c
        public void k(View view, int i2, int i3, int i4, int i5) {
            int width = view.getWidth();
            float width2 = (a.this.c(view, 3) ? i2 + width : a.this.getWidth() - i2) / width;
            a.this.S(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            a.this.invalidate();
        }

        @Override // c.j.b.a.c
        public void l(View view, float f2, float f3) {
            int i2;
            float u = a.this.u(view);
            int width = view.getWidth();
            if (a.this.c(view, 3)) {
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                i2 = (i3 > 0 || (i3 == 0 && u > 0.5f)) ? 0 : -width;
            } else {
                int width2 = a.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && u > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f3128b.O(i2, view.getTop());
            a.this.invalidate();
        }

        @Override // c.j.b.a.c
        public boolean m(View view, int i2) {
            return a.this.D(view) && a.this.c(view, this.a) && a.this.r(view) == 0;
        }

        void o() {
            View n;
            int width;
            int x = this.f3128b.x();
            boolean z = this.a == 3;
            if (z) {
                n = a.this.n(3);
                width = (n != null ? -n.getWidth() : 0) + x;
            } else {
                n = a.this.n(5);
                width = a.this.getWidth() - x;
            }
            if (n != null) {
                if (((!z || n.getLeft() >= width) && (z || n.getLeft() <= width)) || a.this.r(n) != 0) {
                    return;
                }
                this.f3128b.Q(n, width, n.getTop());
                ((f) n.getLayoutParams()).f3121c = true;
                a.this.invalidate();
                n();
                a.this.b();
            }
        }

        public void p() {
            a.this.removeCallbacks(this.f3129c);
        }

        public void q(c.j.b.a aVar) {
            this.f3128b = aVar;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f3109c = i2 >= 19;
        f3110d = i2 >= 21;
        f3111e = i2 >= 29;
    }

    public a(Context context) {
        this(context, null);
    }

    static boolean A(View view) {
        return (v.w(view) == 4 || v.w(view) == 2) ? false : true;
    }

    private boolean F(float f2, float f3, View view) {
        if (this.R == null) {
            this.R = new Rect();
        }
        view.getHitRect(this.R);
        return this.R.contains((int) f2, (int) f3);
    }

    private void G(Drawable drawable, int i2) {
        if (drawable == null || !androidx.core.graphics.drawable.a.h(drawable)) {
            return;
        }
        androidx.core.graphics.drawable.a.m(drawable, i2);
    }

    private Drawable N() {
        int y = v.y(this);
        if (y == 0) {
            Drawable drawable = this.M;
            if (drawable != null) {
                G(drawable, y);
                return this.M;
            }
        } else {
            Drawable drawable2 = this.N;
            if (drawable2 != null) {
                G(drawable2, y);
                return this.N;
            }
        }
        return this.O;
    }

    private Drawable O() {
        int y = v.y(this);
        if (y == 0) {
            Drawable drawable = this.N;
            if (drawable != null) {
                G(drawable, y);
                return this.N;
            }
        } else {
            Drawable drawable2 = this.M;
            if (drawable2 != null) {
                G(drawable2, y);
                return this.M;
            }
        }
        return this.P;
    }

    private void P() {
        if (f3110d) {
            return;
        }
        this.G = N();
        this.H = O();
    }

    private void T(View view) {
        d.a aVar = d.a.u;
        v.e0(view, aVar.b());
        if (!C(view) || r(view) == 2) {
            return;
        }
        v.g0(view, aVar, null, this.T);
    }

    private void U(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((!z && !D(childAt)) || (z && childAt == view)) {
                v.t0(childAt, 1);
            } else {
                v.t0(childAt, 4);
            }
        }
    }

    private boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent v = v(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(v);
            v.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent v(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(getScrollX() - view.getLeft(), getScrollY() - view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.S == null) {
                this.S = new Matrix();
            }
            matrix.invert(this.S);
            obtain.transform(this.S);
        }
        return obtain;
    }

    static String w(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    private static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean y() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((f) getChildAt(i2).getLayoutParams()).f3121c) {
                return true;
            }
        }
        return false;
    }

    private boolean z() {
        return p() != null;
    }

    boolean B(View view) {
        return ((f) view.getLayoutParams()).a == 0;
    }

    public boolean C(View view) {
        if (D(view)) {
            return (((f) view.getLayoutParams()).f3122d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean D(View view) {
        int b2 = c.h.k.d.b(((f) view.getLayoutParams()).a, v.y(view));
        return ((b2 & 3) == 0 && (b2 & 5) == 0) ? false : true;
    }

    public boolean E(View view) {
        if (D(view)) {
            return ((f) view.getLayoutParams()).f3120b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void H(View view, float f2) {
        float u = u(view);
        float width = view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (u * width));
        if (!c(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        S(view, f2);
    }

    public void I(int i2) {
        J(i2, true);
    }

    public void J(int i2, boolean z) {
        View n = n(i2);
        if (n != null) {
            L(n, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void K(View view) {
        L(view, true);
    }

    public void L(View view, boolean z) {
        if (D(view)) {
            f fVar = (f) view.getLayoutParams();
            if (this.v) {
                fVar.f3120b = 1.0f;
                fVar.f3122d = 1;
                U(view, true);
                T(view);
            } else if (z) {
                fVar.f3122d |= 2;
                if (c(view, 3)) {
                    this.m.Q(view, 0, view.getTop());
                } else {
                    this.n.Q(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                H(view, 1.0f);
                V(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void M(e eVar) {
        List<e> list;
        if (eVar == null || (list = this.C) == null) {
            return;
        }
        list.remove(eVar);
    }

    public void Q(Object obj, boolean z) {
        this.K = obj;
        this.L = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void R(int i2, int i3) {
        View n;
        int b2 = c.h.k.d.b(i3, v.y(this));
        if (i3 == 3) {
            this.w = i2;
        } else if (i3 == 5) {
            this.x = i2;
        } else if (i3 == 8388611) {
            this.y = i2;
        } else if (i3 == 8388613) {
            this.z = i2;
        }
        if (i2 != 0) {
            (b2 == 3 ? this.m : this.n).a();
        }
        if (i2 != 1) {
            if (i2 == 2 && (n = n(b2)) != null) {
                K(n);
                return;
            }
            return;
        }
        View n2 = n(b2);
        if (n2 != null) {
            f(n2);
        }
    }

    void S(View view, float f2) {
        f fVar = (f) view.getLayoutParams();
        if (f2 == fVar.f3120b) {
            return;
        }
        fVar.f3120b = f2;
        l(view, f2);
    }

    void V(int i2, View view) {
        int A = this.m.A();
        int A2 = this.n.A();
        int i3 = 2;
        if (A == 1 || A2 == 1) {
            i3 = 1;
        } else if (A != 2 && A2 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f2 = ((f) view.getLayoutParams()).f3120b;
            if (f2 == 0.0f) {
                j(view);
            } else if (f2 == 1.0f) {
                k(view);
            }
        }
        if (i3 != this.t) {
            this.t = i3;
            List<e> list = this.C;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.C.get(size).c(i3);
                }
            }
        }
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (D(childAt)) {
                if (C(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z = true;
                }
            } else {
                this.Q.add(childAt);
            }
        }
        if (!z) {
            int size = this.Q.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = this.Q.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i2, i3);
                }
            }
        }
        this.Q.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (o() == null && !D(view)) {
            v.t0(view, 1);
        } else {
            v.t0(view, 4);
        }
        if (f3109c) {
            return;
        }
        v.k0(view, this.f3112f);
    }

    void b() {
        if (this.A) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.A = true;
    }

    boolean c(View view, int i2) {
        return (t(view) & i2) == i2;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((f) getChildAt(i2).getLayoutParams()).f3120b);
        }
        this.f3116k = f2;
        boolean m = this.m.m(true);
        boolean m2 = this.n.m(true);
        if (m || m2) {
            v.b0(this);
        }
    }

    public void d(int i2) {
        e(i2, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.f3116k > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    if (F(x, y, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        int i2;
        int height = getHeight();
        boolean B = B(view);
        int width = getWidth();
        int save = canvas.save();
        int i3 = 0;
        if (B) {
            int childCount = getChildCount();
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != view && childAt.getVisibility() == 0 && x(childAt) && D(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i4) {
                            i4 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i4, 0, width, getHeight());
            i3 = i4;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f2 = this.f3116k;
        if (f2 > 0.0f && B) {
            this.f3117l.setColor((this.f3115j & 16777215) | (((int) ((((-16777216) & i2) >>> 24) * f2)) << 24));
            canvas.drawRect(i3, 0.0f, width, getHeight(), this.f3117l);
        } else if (this.G != null && c(view, 3)) {
            int intrinsicWidth = this.G.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.m.x(), 1.0f));
            this.G.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.G.setAlpha((int) (max * 255.0f));
            this.G.draw(canvas);
        } else if (this.H != null && c(view, 5)) {
            int intrinsicWidth2 = this.H.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.n.x(), 1.0f));
            this.H.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.H.setAlpha((int) (max2 * 255.0f));
            this.H.draw(canvas);
        }
        return drawChild;
    }

    public void e(int i2, boolean z) {
        View n = n(i2);
        if (n != null) {
            g(n, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void f(View view) {
        g(view, true);
    }

    public void g(View view, boolean z) {
        if (D(view)) {
            f fVar = (f) view.getLayoutParams();
            if (this.v) {
                fVar.f3120b = 0.0f;
                fVar.f3122d = 0;
            } else if (z) {
                fVar.f3122d |= 4;
                if (c(view, 3)) {
                    this.m.Q(view, -view.getWidth(), view.getTop());
                } else {
                    this.n.Q(view, getWidth(), view.getTop());
                }
            } else {
                H(view, 0.0f);
                V(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (f3110d) {
            return this.f3113g;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.F;
    }

    public void h() {
        i(false);
    }

    void i(boolean z) {
        boolean Q;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f fVar = (f) childAt.getLayoutParams();
            if (D(childAt) && (!z || fVar.f3121c)) {
                int width = childAt.getWidth();
                if (c(childAt, 3)) {
                    Q = this.m.Q(childAt, -width, childAt.getTop());
                } else {
                    Q = this.n.Q(childAt, getWidth(), childAt.getTop());
                }
                z2 |= Q;
                fVar.f3121c = false;
            }
        }
        this.p.p();
        this.q.p();
        if (z2) {
            invalidate();
        }
    }

    void j(View view) {
        View rootView;
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f3122d & 1) == 1) {
            fVar.f3122d = 0;
            List<e> list = this.C;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.C.get(size).b(view);
                }
            }
            U(view, false);
            T(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void k(View view) {
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f3122d & 1) == 0) {
            fVar.f3122d = 1;
            List<e> list = this.C;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.C.get(size).a(view);
                }
            }
            U(view, true);
            T(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void l(View view, float f2) {
        List<e> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).d(view, f2);
            }
        }
    }

    View n(int i2) {
        int b2 = c.h.k.d.b(i2, v.y(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((t(childAt) & 7) == b2) {
                return childAt;
            }
        }
        return null;
    }

    View o() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((f) childAt.getLayoutParams()).f3122d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.v = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.v = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.L || this.F == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.K) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.F.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.F.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            c.j.b.a r1 = r6.m
            boolean r1 = r1.P(r7)
            c.j.b.a r2 = r6.n
            boolean r2 = r2.P(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            c.j.b.a r7 = r6.m
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L36
            c.k.d.a$h r7 = r6.p
            r7.p()
            c.k.d.a$h r7 = r6.q
            r7.p()
            goto L36
        L31:
            r6.i(r2)
            r6.A = r3
        L36:
            r7 = r3
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.D = r0
            r6.E = r7
            float r4 = r6.f3116k
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            c.j.b.a r4 = r6.m
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.t(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.B(r7)
            if (r7 == 0) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            r6.A = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.y()
            if (r7 != 0) goto L70
            boolean r7 = r6.A
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.a.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && z()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            View p = p();
            if (p != null && r(p) == 0) {
                h();
            }
            return p != null;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        WindowInsets rootWindowInsets;
        int i6;
        float f2;
        int i7;
        boolean z2 = true;
        this.u = true;
        int i8 = i4 - i2;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i10 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i10, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i10, ((ViewGroup.MarginLayoutParams) fVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = measuredWidth;
                        i7 = (-measuredWidth) + ((int) (fVar.f3120b * f3));
                        f2 = (measuredWidth + i7) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i8 - i6) / f4;
                        i7 = i8 - ((int) (fVar.f3120b * f4));
                    }
                    boolean z3 = f2 != fVar.f3120b ? z2 : false;
                    int i11 = fVar.a & 112;
                    if (i11 == 16) {
                        int i12 = i5 - i3;
                        int i13 = (i12 - measuredHeight) / 2;
                        int i14 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i13 < i14) {
                            i13 = i14;
                        } else {
                            int i15 = i13 + measuredHeight;
                            int i16 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i15 > i12 - i16) {
                                i13 = (i12 - i16) - measuredHeight;
                            }
                        }
                        childAt.layout(i7, i13, measuredWidth + i7, measuredHeight + i13);
                    } else if (i11 != 80) {
                        int i17 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        childAt.layout(i7, i17, measuredWidth + i7, measuredHeight + i17);
                    } else {
                        int i18 = i5 - i3;
                        childAt.layout(i7, (i18 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i18 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    }
                    if (z3) {
                        S(childAt, f2);
                    }
                    int i19 = fVar.f3120b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
            i9++;
            z2 = true;
        }
        if (f3111e && (rootWindowInsets = getRootWindowInsets()) != null) {
            c.h.e.b h2 = d0.v(rootWindowInsets).h();
            c.j.b.a aVar = this.m;
            aVar.L(Math.max(aVar.w(), h2.f2925b));
            c.j.b.a aVar2 = this.n;
            aVar2.L(Math.max(aVar2.w(), h2.f2927d));
        }
        this.u = false;
        this.v = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i2, int i3) {
        int t;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i4 = 0;
        boolean z = this.K != null && v.v(this);
        int y = v.y(this);
        int childCount = getChildCount();
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z) {
                    int b2 = c.h.k.d.b(fVar.a, y);
                    if (v.v(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.K;
                            if (b2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i4, windowInsets.getSystemWindowInsetBottom());
                            } else if (b2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i4, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.K;
                        if (b2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i4, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i4, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else if (D(childAt)) {
                    if (f3110d) {
                        float t2 = v.t(childAt);
                        float f2 = this.f3113g;
                        if (t2 != f2) {
                            v.q0(childAt, f2);
                        }
                    }
                    int i6 = (t(childAt) & 7) == 3 ? 1 : i4;
                    if ((i6 != 0 && z2) || (i6 == 0 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(t) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (i6 != 0) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.f3114h + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i3, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                    i5++;
                    i4 = 0;
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i5++;
            i4 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View n;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        int i2 = gVar.f3123c;
        if (i2 != 0 && (n = n(i2)) != null) {
            K(n);
        }
        int i3 = gVar.f3124d;
        if (i3 != 3) {
            R(i3, 3);
        }
        int i4 = gVar.f3125e;
        if (i4 != 3) {
            R(i4, 5);
        }
        int i5 = gVar.f3126f;
        if (i5 != 3) {
            R(i5, 8388611);
        }
        int i6 = gVar.f3127g;
        if (i6 != 3) {
            R(i6, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        P();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            f fVar = (f) getChildAt(i2).getLayoutParams();
            int i3 = fVar.f3122d;
            boolean z = i3 == 1;
            boolean z2 = i3 == 2;
            if (z || z2) {
                gVar.f3123c = fVar.a;
                break;
            }
        }
        gVar.f3124d = this.w;
        gVar.f3125e = this.x;
        gVar.f3126f = this.y;
        gVar.f3127g = this.z;
        return gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            c.j.b.a r0 = r6.m
            r0.F(r7)
            c.j.b.a r0 = r6.n
            r0.F(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6d
        L1a:
            r6.i(r2)
            r6.A = r1
            goto L6d
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            c.j.b.a r3 = r6.m
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.t(r4, r5)
            if (r3 == 0) goto L5a
            boolean r3 = r6.B(r3)
            if (r3 == 0) goto L5a
            float r3 = r6.D
            float r0 = r0 - r3
            float r3 = r6.E
            float r7 = r7 - r3
            c.j.b.a r3 = r6.m
            int r3 = r3.z()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5a
            android.view.View r7 = r6.o()
            if (r7 == 0) goto L5a
            int r7 = r6.r(r7)
            r0 = 2
            if (r7 != r0) goto L5b
        L5a:
            r1 = r2
        L5b:
            r6.i(r1)
            goto L6d
        L5f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.D = r0
            r6.E = r7
            r6.A = r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.a.onTouchEvent(android.view.MotionEvent):boolean");
    }

    View p() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (D(childAt) && E(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i2) {
        int y = v.y(this);
        if (i2 == 3) {
            int i3 = this.w;
            if (i3 != 3) {
                return i3;
            }
            int i4 = y == 0 ? this.y : this.z;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        } else if (i2 == 5) {
            int i5 = this.x;
            if (i5 != 3) {
                return i5;
            }
            int i6 = y == 0 ? this.z : this.y;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i7 = this.y;
            if (i7 != 3) {
                return i7;
            }
            int i8 = y == 0 ? this.w : this.x;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i9 = this.z;
            if (i9 != 3) {
                return i9;
            }
            int i10 = y == 0 ? this.x : this.w;
            if (i10 != 3) {
                return i10;
            }
            return 0;
        }
    }

    public int r(View view) {
        if (D(view)) {
            return q(((f) view.getLayoutParams()).a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            i(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.u) {
            return;
        }
        super.requestLayout();
    }

    public CharSequence s(int i2) {
        int b2 = c.h.k.d.b(i2, v.y(this));
        if (b2 == 3) {
            return this.I;
        }
        if (b2 == 5) {
            return this.J;
        }
        return null;
    }

    public void setDrawerElevation(float f2) {
        this.f3113g = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (D(childAt)) {
                v.q0(childAt, this.f3113g);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.B;
        if (eVar2 != null) {
            M(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.B = eVar;
    }

    public void setDrawerLockMode(int i2) {
        R(i2, 3);
        R(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.f3115j = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.F = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.F = new ColorDrawable(i2);
        invalidate();
    }

    int t(View view) {
        return c.h.k.d.b(((f) view.getLayoutParams()).a, v.y(this));
    }

    float u(View view) {
        return ((f) view.getLayoutParams()).f3120b;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.k.a.a);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3112f = new d();
        this.f3115j = -1728053248;
        this.f3117l = new Paint();
        this.v = true;
        this.w = 3;
        this.x = 3;
        this.y = 3;
        this.z = 3;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.T = new C0074a();
        setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        float f2 = getResources().getDisplayMetrics().density;
        this.f3114h = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        h hVar = new h(3);
        this.p = hVar;
        h hVar2 = new h(5);
        this.q = hVar2;
        c.j.b.a n = c.j.b.a.n(this, 1.0f, hVar);
        this.m = n;
        n.M(1);
        n.N(f3);
        hVar.q(n);
        c.j.b.a n2 = c.j.b.a.n(this, 1.0f, hVar2);
        this.n = n2;
        n2.M(2);
        n2.N(f3);
        hVar2.q(n2);
        setFocusableInTouchMode(true);
        v.t0(this, 1);
        v.k0(this, new c());
        setMotionEventSplittingEnabled(false);
        if (v.v(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new b());
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
                try {
                    this.F = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.F = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, c.k.c.f3102b, i2, 0);
        try {
            int i3 = c.k.c.f3103c;
            if (obtainStyledAttributes2.hasValue(i3)) {
                this.f3113g = obtainStyledAttributes2.getDimension(i3, 0.0f);
            } else {
                this.f3113g = getResources().getDimension(c.k.b.a);
            }
            obtainStyledAttributes2.recycle();
            this.Q = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setStatusBarBackground(int i2) {
        this.F = i2 != 0 ? androidx.core.content.a.f(getContext(), i2) : null;
        invalidate();
    }

    /* compiled from: DrawerLayout.java */
    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        float f3120b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3121c;

        /* renamed from: d  reason: collision with root package name */
        int f3122d;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f3108b);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public f(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.a = 0;
            this.a = fVar.a;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: DrawerLayout.java */
    /* loaded from: classes.dex */
    public static class g extends c.j.a.a {
        public static final Parcelable.Creator<g> CREATOR = new C0075a();

        /* renamed from: c  reason: collision with root package name */
        int f3123c;

        /* renamed from: d  reason: collision with root package name */
        int f3124d;

        /* renamed from: e  reason: collision with root package name */
        int f3125e;

        /* renamed from: f  reason: collision with root package name */
        int f3126f;

        /* renamed from: g  reason: collision with root package name */
        int f3127g;

        /* compiled from: DrawerLayout.java */
        /* renamed from: c.k.d.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0075a implements Parcelable.ClassLoaderCreator<g> {
            C0075a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3123c = 0;
            this.f3123c = parcel.readInt();
            this.f3124d = parcel.readInt();
            this.f3125e = parcel.readInt();
            this.f3126f = parcel.readInt();
            this.f3127g = parcel.readInt();
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3123c);
            parcel.writeInt(this.f3124d);
            parcel.writeInt(this.f3125e);
            parcel.writeInt(this.f3126f);
            parcel.writeInt(this.f3127g);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
            this.f3123c = 0;
        }
    }
}