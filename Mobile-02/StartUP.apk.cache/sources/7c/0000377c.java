package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import c.j.b.a;
import com.reactnativecommunity.webview.RNCWebViewManager;
import e.g.a.f.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private float f8118b;

    /* renamed from: c  reason: collision with root package name */
    private int f8119c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8120d;

    /* renamed from: e  reason: collision with root package name */
    private int f8121e;

    /* renamed from: f  reason: collision with root package name */
    private int f8122f;

    /* renamed from: g  reason: collision with root package name */
    int f8123g;

    /* renamed from: h  reason: collision with root package name */
    int f8124h;

    /* renamed from: i  reason: collision with root package name */
    int f8125i;

    /* renamed from: j  reason: collision with root package name */
    boolean f8126j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8127k;

    /* renamed from: l  reason: collision with root package name */
    int f8128l;
    c.j.b.a m;
    private boolean n;
    private int o;
    private boolean p;
    int q;
    WeakReference<V> r;
    WeakReference<View> s;
    private c t;
    private VelocityTracker u;
    int v;
    private int w;
    boolean x;
    private Map<View, Integer> y;
    private final a.c z;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8129b;

        a(View view, int i2) {
            this.a = view;
            this.f8129b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.V(this.a, this.f8129b);
        }
    }

    /* loaded from: classes2.dex */
    class b extends a.c {
        b() {
        }

        @Override // c.j.b.a.c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // c.j.b.a.c
        public int b(View view, int i2, int i3) {
            int J = BottomSheetBehavior.this.J();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return c.h.h.a.b(i2, J, bottomSheetBehavior.f8126j ? bottomSheetBehavior.q : bottomSheetBehavior.f8125i);
        }

        @Override // c.j.b.a.c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.f8126j) {
                return bottomSheetBehavior.q;
            }
            return bottomSheetBehavior.f8125i;
        }

        @Override // c.j.b.a.c
        public void j(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior.this.T(1);
            }
        }

        @Override // c.j.b.a.c
        public void k(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.G(i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
        @Override // c.j.b.a.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.b.l(android.view.View, float, float):void");
        }

        @Override // c.j.b.a.c
        public boolean m(View view, int i2) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.f8128l;
            if (i3 == 1 || bottomSheetBehavior.x) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.v == i2 && (view2 = bottomSheetBehavior.s.get()) != null && view2.canScrollVertically(-1)) {
                return false;
            }
            WeakReference<V> weakReference = BottomSheetBehavior.this.r;
            return weakReference != null && weakReference.get() == view;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class c {
        public abstract void onSlide(View view, float f2);

        public abstract void onStateChanged(View view, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private final View a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8132b;

        e(View view, int i2) {
            this.a = view;
            this.f8132b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.j.b.a aVar = BottomSheetBehavior.this.m;
            if (aVar != null && aVar.m(true)) {
                v.c0(this.a, this);
            } else {
                BottomSheetBehavior.this.T(this.f8132b);
            }
        }
    }

    public BottomSheetBehavior() {
        this.a = true;
        this.f8128l = 4;
        this.z = new b();
    }

    private void F() {
        if (this.a) {
            this.f8125i = Math.max(this.q - this.f8122f, this.f8123g);
        } else {
            this.f8125i = this.q - this.f8122f;
        }
    }

    public static <V extends View> BottomSheetBehavior<V> I(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c f2 = ((CoordinatorLayout.f) layoutParams).f();
            if (f2 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f2;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int J() {
        if (this.a) {
            return this.f8123g;
        }
        return 0;
    }

    private float L() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.f8118b);
        return this.u.getYVelocity(this.v);
    }

    private void M() {
        this.v = -1;
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.u = null;
        }
    }

    private void W(boolean z) {
        WeakReference<V> weakReference = this.r;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.y != null) {
                    return;
                }
                this.y = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.r.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.y;
                        if (map != null && map.containsKey(childAt)) {
                            v.t0(childAt, this.y.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        v.t0(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.y = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void B(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        int i3;
        int i4 = 3;
        if (v.getTop() == J()) {
            T(3);
        } else if (view == this.s.get() && this.p) {
            if (this.o > 0) {
                i3 = J();
            } else if (this.f8126j && U(v, L())) {
                i3 = this.q;
                i4 = 5;
            } else {
                if (this.o == 0) {
                    int top = v.getTop();
                    if (this.a) {
                        if (Math.abs(top - this.f8123g) < Math.abs(top - this.f8125i)) {
                            i3 = this.f8123g;
                        } else {
                            i3 = this.f8125i;
                        }
                    } else {
                        int i5 = this.f8124h;
                        if (top < i5) {
                            if (top < Math.abs(top - this.f8125i)) {
                                i3 = 0;
                            } else {
                                i3 = this.f8124h;
                            }
                        } else if (Math.abs(top - i5) < Math.abs(top - this.f8125i)) {
                            i3 = this.f8124h;
                        } else {
                            i3 = this.f8125i;
                        }
                        i4 = 6;
                    }
                } else {
                    i3 = this.f8125i;
                }
                i4 = 4;
            }
            if (this.m.Q(v, v.getLeft(), i3)) {
                T(2);
                v.c0(v, new e(v, i4));
            } else {
                T(i4);
            }
            this.p = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean C(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.f8128l == 1 && actionMasked == 0) {
                return true;
            }
            c.j.b.a aVar = this.m;
            if (aVar != null) {
                aVar.F(motionEvent);
            }
            if (actionMasked == 0) {
                M();
            }
            if (this.u == null) {
                this.u = VelocityTracker.obtain();
            }
            this.u.addMovement(motionEvent);
            if (actionMasked == 2 && !this.n && Math.abs(this.w - motionEvent.getY()) > this.m.z()) {
                this.m.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.n;
        }
        return false;
    }

    void G(int i2) {
        c cVar;
        V v = this.r.get();
        if (v == null || (cVar = this.t) == null) {
            return;
        }
        int i3 = this.f8125i;
        if (i2 > i3) {
            cVar.onSlide(v, (i3 - i2) / (this.q - i3));
        } else {
            cVar.onSlide(v, (i3 - i2) / (i3 - J()));
        }
    }

    View H(View view) {
        if (v.T(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View H = H(viewGroup.getChildAt(i2));
                if (H != null) {
                    return H;
                }
            }
            return null;
        }
        return null;
    }

    public final int K() {
        return this.f8128l;
    }

    public void N(c cVar) {
        this.t = cVar;
    }

    public void O(boolean z) {
        if (this.a == z) {
            return;
        }
        this.a = z;
        if (this.r != null) {
            F();
        }
        T((this.a && this.f8128l == 6) ? 3 : this.f8128l);
    }

    public void P(boolean z) {
        this.f8126j = z;
    }

    public final void Q(int i2) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i2 == -1) {
            if (!this.f8120d) {
                this.f8120d = true;
            }
            z = false;
        } else {
            if (this.f8120d || this.f8119c != i2) {
                this.f8120d = false;
                this.f8119c = Math.max(0, i2);
                this.f8125i = this.q - i2;
            }
            z = false;
        }
        if (!z || this.f8128l != 4 || (weakReference = this.r) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public void R(boolean z) {
        this.f8127k = z;
    }

    public final void S(int i2) {
        if (i2 == this.f8128l) {
            return;
        }
        WeakReference<V> weakReference = this.r;
        if (weakReference == null) {
            if (i2 == 4 || i2 == 3 || i2 == 6 || (this.f8126j && i2 == 5)) {
                this.f8128l = i2;
                return;
            }
            return;
        }
        V v = weakReference.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && v.Q(v)) {
            v.post(new a(v, i2));
        } else {
            V(v, i2);
        }
    }

    void T(int i2) {
        c cVar;
        if (this.f8128l == i2) {
            return;
        }
        this.f8128l = i2;
        if (i2 == 6 || i2 == 3) {
            W(true);
        } else if (i2 == 5 || i2 == 4) {
            W(false);
        }
        V v = this.r.get();
        if (v == null || (cVar = this.t) == null) {
            return;
        }
        cVar.onStateChanged(v, i2);
    }

    boolean U(View view, float f2) {
        if (this.f8127k) {
            return true;
        }
        return view.getTop() >= this.f8125i && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f8125i)) / ((float) this.f8119c) > 0.5f;
    }

    void V(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.f8125i;
        } else if (i2 == 6) {
            int i5 = this.f8124h;
            if (!this.a || i5 > (i4 = this.f8123g)) {
                i3 = i5;
            } else {
                i2 = 3;
                i3 = i4;
            }
        } else if (i2 == 3) {
            i3 = J();
        } else if (this.f8126j && i2 == 5) {
            i3 = this.q;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        }
        if (this.m.Q(view, view.getLeft(), i3)) {
            T(2);
            v.c0(view, new e(view, i2));
            return;
        }
        T(i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        c.j.b.a aVar;
        if (!v.isShown()) {
            this.n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            M();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.s;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.v(view, x, this.w)) {
                this.v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.x = true;
            }
            this.n = this.v == -1 && !coordinatorLayout.v(v, x, this.w);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.x = false;
            this.v = -1;
            if (this.n) {
                this.n = false;
                return false;
            }
        }
        if (this.n || (aVar = this.m) == null || !aVar.P(motionEvent)) {
            WeakReference<View> weakReference2 = this.s;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            return (actionMasked != 2 || view2 == null || this.n || this.f8128l == 1 || coordinatorLayout.v(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.m == null || Math.abs(((float) this.w) - motionEvent.getY()) <= ((float) this.m.z())) ? false : true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        if (v.v(coordinatorLayout) && !v.v(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.C(v, i2);
        this.q = coordinatorLayout.getHeight();
        if (this.f8120d) {
            if (this.f8121e == 0) {
                this.f8121e = coordinatorLayout.getResources().getDimensionPixelSize(e.g.a.f.d.f13249i);
            }
            this.f8122f = Math.max(this.f8121e, this.q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f8122f = this.f8119c;
        }
        this.f8123g = Math.max(0, this.q - v.getHeight());
        this.f8124h = this.q / 2;
        F();
        int i3 = this.f8128l;
        if (i3 == 3) {
            v.Y(v, J());
        } else if (i3 == 6) {
            v.Y(v, this.f8124h);
        } else if (this.f8126j && i3 == 5) {
            v.Y(v, this.q);
        } else if (i3 == 4) {
            v.Y(v, this.f8125i);
        } else if (i3 == 1 || i3 == 2) {
            v.Y(v, top - v.getTop());
        }
        if (this.m == null) {
            this.m = c.j.b.a.o(coordinatorLayout, this.z);
        }
        this.r = new WeakReference<>(v);
        this.s = new WeakReference<>(H(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        return view == this.s.get() && (this.f8128l != 3 || super.o(coordinatorLayout, v, view, f2, f3));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view == this.s.get()) {
            int top = v.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < J()) {
                    iArr[1] = top - J();
                    v.Y(v, -iArr[1]);
                    T(3);
                } else {
                    iArr[1] = i3;
                    v.Y(v, -i3);
                    T(1);
                }
            } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.f8125i;
                if (i5 > i6 && !this.f8126j) {
                    iArr[1] = top - i6;
                    v.Y(v, -iArr[1]);
                    T(4);
                } else {
                    iArr[1] = i3;
                    v.Y(v, -i3);
                    T(1);
                }
            }
            G(v.getTop());
            this.o = i3;
            this.p = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void w(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        d dVar = (d) parcelable;
        super.w(coordinatorLayout, v, dVar.a());
        int i2 = dVar.f8131c;
        if (i2 != 1 && i2 != 2) {
            this.f8128l = i2;
        } else {
            this.f8128l = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable x(CoordinatorLayout coordinatorLayout, V v) {
        return new d(super.x(coordinatorLayout, v), this.f8128l);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean z(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        this.o = 0;
        this.p = false;
        return (i2 & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class d extends c.j.a.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        final int f8131c;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8131c = parcel.readInt();
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f8131c);
        }

        public d(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f8131c = i2;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.a = true;
        this.f8128l = 4;
        this.z = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.I);
        int i3 = k.L;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i3);
        if (peekValue != null && (i2 = peekValue.data) == -1) {
            Q(i2);
        } else {
            Q(obtainStyledAttributes.getDimensionPixelSize(i3, -1));
        }
        P(obtainStyledAttributes.getBoolean(k.K, false));
        O(obtainStyledAttributes.getBoolean(k.J, true));
        R(obtainStyledAttributes.getBoolean(k.M, false));
        obtainStyledAttributes.recycle();
        this.f8118b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}