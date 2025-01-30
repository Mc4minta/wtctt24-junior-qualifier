package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import c.h.k.d0;
import c.h.k.m;
import c.h.k.p;
import c.h.k.q;
import c.h.k.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements m {
    static final String a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f1355b;

    /* renamed from: c  reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<c>>> f1356c;

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<View> f1357d;

    /* renamed from: e  reason: collision with root package name */
    private static final androidx.core.util.f<Rect> f1358e;
    private q A;
    private final p B;

    /* renamed from: f  reason: collision with root package name */
    private final List<View> f1359f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a<View> f1360g;

    /* renamed from: h  reason: collision with root package name */
    private final List<View> f1361h;

    /* renamed from: j  reason: collision with root package name */
    private final List<View> f1362j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f1363k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f1364l;
    private boolean m;
    private boolean n;
    private int[] p;
    private View q;
    private View t;
    private g u;
    private boolean v;
    private d0 w;
    private boolean x;
    private Drawable y;
    ViewGroup.OnHierarchyChangeListener z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements q {
        a() {
        }

        @Override // c.h.k.q
        public d0 a(View view, d0 d0Var) {
            return CoordinatorLayout.this.Q(d0Var);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        c getBehavior();
    }

    /* loaded from: classes.dex */
    public static abstract class c<V extends View> {
        public c() {
        }

        @Deprecated
        public void A(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void B(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                A(coordinatorLayout, v, view);
            }
        }

        public boolean C(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public d0 f(CoordinatorLayout coordinatorLayout, V v, d0 d0Var) {
            return d0Var;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                p(coordinatorLayout, v, view, i2, i3, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        }

        public void s(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                r(coordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        @Deprecated
        public void t(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        }

        public void u(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                t(coordinatorLayout, v, view, view2, i2);
            }
        }

        public boolean v(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void w(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable x(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean y(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
            return false;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return y(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface d {
        Class<? extends c> value();
    }

    /* loaded from: classes.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.z;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.B(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.z;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.B(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class i implements Comparator<View> {
        i() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float K = v.K(view);
            float K2 = v.K(view2);
            if (K > K2) {
                return -1;
            }
            return K < K2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f1357d = new i();
        } else {
            f1357d = null;
        }
        f1355b = new Class[]{Context.class, AttributeSet.class};
        f1356c = new ThreadLocal<>();
        f1358e = new androidx.core.util.g(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static c E(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = a;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f1356c;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f1355b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (c) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean F(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f1361h;
        t(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            f fVar = (f) view.getLayoutParams();
            c f2 = fVar.f();
            if (!(z || z2) || actionMasked == 0) {
                if (!z && f2 != null) {
                    if (i2 == 0) {
                        z = f2.k(this, view, motionEvent);
                    } else if (i2 == 1) {
                        z = f2.C(this, view, motionEvent);
                    }
                    if (z) {
                        this.q = view;
                    }
                }
                boolean c2 = fVar.c();
                boolean i4 = fVar.i(this, view);
                z2 = i4 && !c2;
                if (i4 && !z2) {
                    break;
                }
            } else if (f2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    f2.k(this, view, motionEvent2);
                } else if (i2 == 1) {
                    f2.C(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z;
    }

    private void G() {
        this.f1359f.clear();
        this.f1360g.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f s = s(childAt);
            s.d(this, childAt);
            this.f1360g.b(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (s.b(this, childAt, childAt2)) {
                        if (!this.f1360g.d(childAt2)) {
                            this.f1360g.b(childAt2);
                        }
                        this.f1360g.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f1359f.addAll(this.f1360g.i());
        Collections.reverse(this.f1359f);
    }

    private static void I(Rect rect) {
        rect.setEmpty();
        f1358e.release(rect);
    }

    private void K(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c f2 = ((f) childAt.getLayoutParams()).f();
            if (f2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    f2.k(this, childAt, obtain);
                } else {
                    f2.C(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).m();
        }
        this.q = null;
        this.m = false;
    }

    private static int L(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int M(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int N(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void O(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f1372i;
        if (i3 != i2) {
            v.X(view, i2 - i3);
            fVar.f1372i = i2;
        }
    }

    private void P(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f1373j;
        if (i3 != i2) {
            v.Y(view, i2 - i3);
            fVar.f1373j = i2;
        }
    }

    private void R() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (v.v(this)) {
            if (this.A == null) {
                this.A = new a();
            }
            v.w0(this, this.A);
            setSystemUiVisibility(1280);
            return;
        }
        v.w0(this, null);
    }

    private static Rect a() {
        Rect acquire = f1358e.acquire();
        return acquire == null ? new Rect() : acquire;
    }

    private static int c(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private void d(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    private d0 e(d0 d0Var) {
        c f2;
        if (d0Var.o()) {
            return d0Var;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (v.v(childAt) && (f2 = ((f) childAt.getLayoutParams()).f()) != null) {
                d0Var = f2.f(this, childAt, d0Var);
                if (d0Var.o()) {
                    break;
                }
            }
        }
        return d0Var;
    }

    private void p(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int width;
        int height;
        int b2 = c.h.k.d.b(L(fVar.f1366c), i2);
        int b3 = c.h.k.d.b(M(fVar.f1367d), i2);
        int i5 = b2 & 7;
        int i6 = b2 & 112;
        int i7 = b3 & 7;
        int i8 = b3 & 112;
        if (i7 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i7 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i8 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i8 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i5 == 1) {
            width -= i3 / 2;
        } else if (i5 != 5) {
            width -= i3;
        }
        if (i6 == 16) {
            height -= i4 / 2;
        } else if (i6 != 80) {
            height -= i4;
        }
        rect2.set(width, height, i3 + width, i4 + height);
    }

    private int q(int i2) {
        int[] iArr = this.p;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
            return 0;
        }
    }

    private void t(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = f1357d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean u(View view) {
        return this.f1360g.j(view);
    }

    private void w(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        Rect a2 = a();
        a2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.w != null && v.v(this) && !v.v(view)) {
            a2.left += this.w.j();
            a2.top += this.w.l();
            a2.right -= this.w.k();
            a2.bottom -= this.w.i();
        }
        Rect a3 = a();
        c.h.k.d.a(M(fVar.f1366c), view.getMeasuredWidth(), view.getMeasuredHeight(), a2, a3, i2);
        view.layout(a3.left, a3.top, a3.right, a3.bottom);
        I(a2);
        I(a3);
    }

    private void x(View view, View view2, int i2) {
        Rect a2 = a();
        Rect a3 = a();
        try {
            n(view2, a2);
            o(view, i2, a2, a3);
            view.layout(a3.left, a3.top, a3.right, a3.bottom);
        } finally {
            I(a2);
            I(a3);
        }
    }

    private void y(View view, int i2, int i3) {
        f fVar = (f) view.getLayoutParams();
        int b2 = c.h.k.d.b(N(fVar.f1366c), i3);
        int i4 = b2 & 7;
        int i5 = b2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int q = q(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            q += measuredWidth / 2;
        } else if (i4 == 5) {
            q += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(q, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void z(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (v.S(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c f2 = fVar.f();
            Rect a2 = a();
            Rect a3 = a();
            a3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f2 != null && f2.b(this, view, a2)) {
                if (!a3.contains(a2)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a2.toShortString() + " | Bounds:" + a3.toShortString());
                }
            } else {
                a2.set(a3);
            }
            I(a3);
            if (a2.isEmpty()) {
                I(a2);
                return;
            }
            int b2 = c.h.k.d.b(fVar.f1371h, i2);
            boolean z3 = true;
            if ((b2 & 48) != 48 || (i7 = (a2.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f1373j) >= (i8 = rect.top)) {
                z = false;
            } else {
                P(view, i8 - i7);
                z = true;
            }
            if ((b2 & 80) == 80 && (height = ((getHeight() - a2.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f1373j) < (i6 = rect.bottom)) {
                P(view, height - i6);
                z = true;
            }
            if (!z) {
                P(view, 0);
            }
            if ((b2 & 3) != 3 || (i4 = (a2.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f1372i) >= (i5 = rect.left)) {
                z2 = false;
            } else {
                O(view, i5 - i4);
                z2 = true;
            }
            if ((b2 & 5) != 5 || (width = ((getWidth() - a2.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f1372i) >= (i3 = rect.right)) {
                z3 = z2;
            } else {
                O(view, width - i3);
            }
            if (!z3) {
                O(view, 0);
            }
            I(a2);
        }
    }

    void A(View view, int i2) {
        c f2;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f1374k != null) {
            Rect a2 = a();
            Rect a3 = a();
            Rect a4 = a();
            n(fVar.f1374k, a2);
            boolean z = false;
            k(view, false, a3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            p(view, i2, a2, a4, fVar, measuredWidth, measuredHeight);
            z = (a4.left == a3.left && a4.top == a3.top) ? true : true;
            d(fVar, a4, measuredWidth, measuredHeight);
            int i3 = a4.left - a3.left;
            int i4 = a4.top - a3.top;
            if (i3 != 0) {
                v.X(view, i3);
            }
            if (i4 != 0) {
                v.Y(view, i4);
            }
            if (z && (f2 = fVar.f()) != null) {
                f2.h(this, view, fVar.f1374k);
            }
            I(a2);
            I(a3);
            I(a4);
        }
    }

    final void B(int i2) {
        boolean z;
        int y = v.y(this);
        int size = this.f1359f.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f1359f.get(i3);
            f fVar = (f) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (fVar.f1375l == this.f1359f.get(i4)) {
                        A(view, y);
                    }
                }
                k(view, true, a3);
                if (fVar.f1370g != 0 && !a3.isEmpty()) {
                    int b2 = c.h.k.d.b(fVar.f1370g, y);
                    int i5 = b2 & 112;
                    if (i5 == 48) {
                        a2.top = Math.max(a2.top, a3.bottom);
                    } else if (i5 == 80) {
                        a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                    }
                    int i6 = b2 & 7;
                    if (i6 == 3) {
                        a2.left = Math.max(a2.left, a3.right);
                    } else if (i6 == 5) {
                        a2.right = Math.max(a2.right, getWidth() - a3.left);
                    }
                }
                if (fVar.f1371h != 0 && view.getVisibility() == 0) {
                    z(view, a2, y);
                }
                if (i2 != 2) {
                    r(view, a4);
                    if (!a4.equals(a3)) {
                        H(view, a3);
                    }
                }
                for (int i7 = i3 + 1; i7 < size; i7++) {
                    View view2 = this.f1359f.get(i7);
                    f fVar2 = (f) view2.getLayoutParams();
                    c f2 = fVar2.f();
                    if (f2 != null && f2.e(this, view2, view)) {
                        if (i2 == 0 && fVar2.g()) {
                            fVar2.k();
                        } else {
                            if (i2 != 2) {
                                z = f2.h(this, view2, view);
                            } else {
                                f2.i(this, view2, view);
                                z = true;
                            }
                            if (i2 == 1) {
                                fVar2.p(z);
                            }
                        }
                    }
                }
            }
        }
        I(a2);
        I(a3);
        I(a4);
    }

    public void C(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.a()) {
            View view2 = fVar.f1374k;
            if (view2 != null) {
                x(view, view2, i2);
                return;
            }
            int i3 = fVar.f1368e;
            if (i3 >= 0) {
                y(view, i3, i2);
                return;
            } else {
                w(view, i2);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public void D(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    void H(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    void J() {
        if (this.n && this.u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.u);
        }
        this.v = false;
    }

    final d0 Q(d0 d0Var) {
        if (androidx.core.util.d.a(this.w, d0Var)) {
            return d0Var;
        }
        this.w = d0Var;
        boolean z = true;
        boolean z2 = d0Var != null && d0Var.l() > 0;
        this.x = z2;
        if (z2 || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        d0 e2 = e(d0Var);
        requestLayout();
        return e2;
    }

    void b() {
        if (this.n) {
            if (this.u == null) {
                this.u = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.u);
        }
        this.v = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.a;
        if (cVar != null) {
            float d2 = cVar.d(this, view);
            if (d2 > 0.0f) {
                if (this.f1364l == null) {
                    this.f1364l = new Paint();
                }
                this.f1364l.setColor(fVar.a.c(this, view));
                this.f1364l.setAlpha(c(Math.round(d2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f1364l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.y;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public void f(View view) {
        List g2 = this.f1360g.g(view);
        if (g2 == null || g2.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < g2.size(); i2++) {
            View view2 = (View) g2.get(i2);
            c f2 = ((f) view2.getLayoutParams()).f();
            if (f2 != null) {
                f2.h(this, view2, view);
            }
        }
    }

    void g() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (u(getChildAt(i2))) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z != this.v) {
            if (z) {
                b();
            } else {
                J();
            }
        }
    }

    final List<View> getDependencySortedChildren() {
        G();
        return Collections.unmodifiableList(this.f1359f);
    }

    public final d0 getLastWindowInsets() {
        return this.w;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public Drawable getStatusBarBackground() {
        return this.y;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: h */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: i */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    void k(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            n(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> l(View view) {
        List<View> h2 = this.f1360g.h(view);
        this.f1362j.clear();
        if (h2 != null) {
            this.f1362j.addAll(h2);
        }
        return this.f1362j;
    }

    public List<View> m(View view) {
        List g2 = this.f1360g.g(view);
        this.f1362j.clear();
        if (g2 != null) {
            this.f1362j.addAll(g2);
        }
        return this.f1362j;
    }

    void n(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void o(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        p(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        K(false);
        if (this.v) {
            if (this.u == null) {
                this.u = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.u);
        }
        if (this.w == null && v.v(this)) {
            v.h0(this);
        }
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        K(false);
        if (this.v && this.u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.u);
        }
        View view = this.t;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.n = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.x || this.y == null) {
            return;
        }
        d0 d0Var = this.w;
        int l2 = d0Var != null ? d0Var.l() : 0;
        if (l2 > 0) {
            this.y.setBounds(0, 0, getWidth(), l2);
            this.y.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            K(true);
        }
        boolean F = F(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            K(true);
        }
        return F;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c f2;
        int y = v.y(this);
        int size = this.f1359f.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f1359f.get(i6);
            if (view.getVisibility() != 8 && ((f2 = ((f) view.getLayoutParams()).f()) == null || !f2.l(this, view, y))) {
                C(view, y);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        c f4;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f4 = fVar.f()) != null) {
                    z2 |= f4.n(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            B(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        c f4;
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f4 = fVar.f()) != null) {
                    z |= f4.o(this, childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        onNestedPreScroll(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        onNestedScrollAccepted(view, view2, i2, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.a());
        SparseArray<Parcelable> sparseArray = hVar.f1376c;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c f2 = s(childAt).f();
            if (id != -1 && f2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                f2.w(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable x;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c f2 = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && f2 != null && (x = f2.x(this, childAt)) != null) {
                sparseArray.append(id, x);
            }
        }
        hVar.f1376c = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return onStartNestedScroll(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.q
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.F(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = r5
        L16:
            android.view.View r6 = r0.q
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.q
            boolean r6 = r6.C(r0, r7, r1)
            goto L2c
        L2b:
            r6 = r5
        L2c:
            android.view.View r7 = r0.q
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.K(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void r(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        c f2 = ((f) view.getLayoutParams()).f();
        if (f2 == null || !f2.v(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.m) {
            return;
        }
        K(false);
        this.m = true;
    }

    f s(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f1365b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f1365b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                fVar.f1365b = true;
            }
        }
        return fVar;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        R();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.z = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.y;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.y = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.y.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.y, v.y(this));
                this.y.setVisible(getVisibility() == 0, false);
                this.y.setCallback(this);
            }
            v.b0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? androidx.core.content.a.f(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.y;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.y.setVisible(z, false);
    }

    public boolean v(View view, int i2, int i3) {
        Rect a2 = a();
        n(view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            I(a2);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.y;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.g.a.a);
    }

    @Override // c.h.k.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        c f2;
        int childCount = getChildCount();
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i4) && (f2 = fVar.f()) != null) {
                    int[] iArr2 = this.f1363k;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    f2.q(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f1363k;
                    i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.f1363k;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z) {
            B(1);
        }
    }

    @Override // c.h.k.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        c f2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i6) && (f2 = fVar.f()) != null) {
                    f2.s(this, childAt, view, i2, i3, i4, i5, i6);
                    z = true;
                }
            }
        }
        if (z) {
            B(1);
        }
    }

    @Override // c.h.k.m
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        c f2;
        this.B.c(view, view2, i2, i3);
        this.t = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i3) && (f2 = fVar.f()) != null) {
                f2.u(this, childAt, view, view2, i2, i3);
            }
        }
    }

    @Override // c.h.k.m
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c f2 = fVar.f();
                if (f2 != null) {
                    boolean z2 = f2.z(this, childAt, view, view2, i2, i3);
                    z |= z2;
                    fVar.r(i3, z2);
                } else {
                    fVar.r(i3, false);
                }
            }
        }
        return z;
    }

    @Override // c.h.k.m
    public void onStopNestedScroll(View view, int i2) {
        this.B.e(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i2)) {
                c f2 = fVar.f();
                if (f2 != null) {
                    f2.B(this, childAt, view, i2);
                }
                fVar.l(i2);
                fVar.k();
            }
        }
        this.t = null;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        this.f1359f = new ArrayList();
        this.f1360g = new androidx.coordinatorlayout.widget.a<>();
        this.f1361h = new ArrayList();
        this.f1362j = new ArrayList();
        this.f1363k = new int[2];
        this.B = new p(this);
        if (i2 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.g.c.f2891b, 0, c.g.b.a);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.g.c.f2891b, i2, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(c.g.c.f2892c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.p = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.p.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.p;
                iArr[i3] = (int) (iArr[i3] * f2);
            }
        }
        this.y = obtainStyledAttributes.getDrawable(c.g.c.f2893d);
        obtainStyledAttributes.recycle();
        R();
        super.setOnHierarchyChangeListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class h extends c.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        SparseArray<Parcelable> f1376c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public h[] newArray(int i2) {
                return new h[i2];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1376c = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f1376c.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f1376c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f1376c.keyAt(i3);
                parcelableArr[i3] = this.f1376c.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {
        c a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1365b;

        /* renamed from: c  reason: collision with root package name */
        public int f1366c;

        /* renamed from: d  reason: collision with root package name */
        public int f1367d;

        /* renamed from: e  reason: collision with root package name */
        public int f1368e;

        /* renamed from: f  reason: collision with root package name */
        int f1369f;

        /* renamed from: g  reason: collision with root package name */
        public int f1370g;

        /* renamed from: h  reason: collision with root package name */
        public int f1371h;

        /* renamed from: i  reason: collision with root package name */
        int f1372i;

        /* renamed from: j  reason: collision with root package name */
        int f1373j;

        /* renamed from: k  reason: collision with root package name */
        View f1374k;

        /* renamed from: l  reason: collision with root package name */
        View f1375l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;

        public f(int i2, int i3) {
            super(i2, i3);
            this.f1365b = false;
            this.f1366c = 0;
            this.f1367d = 0;
            this.f1368e = -1;
            this.f1369f = -1;
            this.f1370g = 0;
            this.f1371h = 0;
            this.q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f1369f);
            this.f1374k = findViewById;
            if (findViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f1375l = null;
                    this.f1374k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1369f) + " to anchor view " + view);
            } else if (findViewById == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f1375l = null;
                    this.f1374k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            } else {
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f1375l = null;
                            this.f1374k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = (View) parent;
                    }
                }
                this.f1375l = findViewById;
            }
        }

        private boolean s(View view, int i2) {
            int b2 = c.h.k.d.b(((f) view.getLayoutParams()).f1370g, i2);
            return b2 != 0 && (c.h.k.d.b(this.f1371h, i2) & b2) == b2;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1374k.getId() != this.f1369f) {
                return false;
            }
            View view2 = this.f1374k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                } else {
                    this.f1375l = null;
                    this.f1374k = null;
                    return false;
                }
            }
            this.f1375l = view2;
            return true;
        }

        boolean a() {
            return this.f1374k == null && this.f1369f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f1375l || s(view2, v.y(coordinatorLayout)) || ((cVar = this.a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.a == null) {
                this.m = false;
            }
            return this.m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1369f == -1) {
                this.f1375l = null;
                this.f1374k = null;
                return null;
            }
            if (this.f1374k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f1374k;
        }

        public int e() {
            return this.f1369f;
        }

        public c f() {
            return this.a;
        }

        boolean g() {
            return this.p;
        }

        Rect h() {
            return this.q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            c cVar = this.a;
            boolean a = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z;
            this.m = a;
            return a;
        }

        boolean j(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return false;
                }
                return this.o;
            }
            return this.n;
        }

        void k() {
            this.p = false;
        }

        void l(int i2) {
            r(i2, false);
        }

        void m() {
            this.m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.a = cVar;
                this.r = null;
                this.f1365b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        void p(boolean z) {
            this.p = z;
        }

        void q(Rect rect) {
            this.q.set(rect);
        }

        void r(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else if (i2 != 1) {
            } else {
                this.o = z;
            }
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1365b = false;
            this.f1366c = 0;
            this.f1367d = 0;
            this.f1368e = -1;
            this.f1369f = -1;
            this.f1370g = 0;
            this.f1371h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.g.c.f2894e);
            this.f1366c = obtainStyledAttributes.getInteger(c.g.c.f2895f, 0);
            this.f1369f = obtainStyledAttributes.getResourceId(c.g.c.f2896g, -1);
            this.f1367d = obtainStyledAttributes.getInteger(c.g.c.f2897h, 0);
            this.f1368e = obtainStyledAttributes.getInteger(c.g.c.f2901l, -1);
            this.f1370g = obtainStyledAttributes.getInt(c.g.c.f2900k, 0);
            this.f1371h = obtainStyledAttributes.getInt(c.g.c.f2899j, 0);
            int i2 = c.g.c.f2898i;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            this.f1365b = hasValue;
            if (hasValue) {
                this.a = CoordinatorLayout.E(context, attributeSet, obtainStyledAttributes.getString(i2));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f1365b = false;
            this.f1366c = 0;
            this.f1367d = 0;
            this.f1368e = -1;
            this.f1369f = -1;
            this.f1370g = 0;
            this.f1371h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1365b = false;
            this.f1366c = 0;
            this.f1367d = 0;
            this.f1368e = -1;
            this.f1369f = -1;
            this.f1370g = 0;
            this.f1371h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1365b = false;
            this.f1366c = 0;
            this.f1367d = 0;
            this.f1368e = -1;
            this.f1369f = -1;
            this.f1370g = 0;
            this.f1371h = 0;
            this.q = new Rect();
        }
    }
}