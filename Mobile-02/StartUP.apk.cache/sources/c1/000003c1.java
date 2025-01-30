package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.e0.d;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.a0.b {
    private int A;
    private int B;
    private final k C;
    private BitSet F;
    private boolean K;
    private boolean L;
    private e M;
    private int N;
    private int[] S;
    f[] x;
    p y;
    p z;
    private int w = -1;
    boolean D = false;
    boolean E = false;
    int G = -1;
    int H = Integer.MIN_VALUE;
    d I = new d();
    private int J = 2;
    private final Rect O = new Rect();
    private final b P = new b();
    private boolean Q = false;
    private boolean R = true;
    private final Runnable T = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.Z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f2056b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2057c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2058d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2059e;

        /* renamed from: f  reason: collision with root package name */
        int[] f2060f;

        b() {
            c();
        }

        void a() {
            this.f2056b = this.f2057c ? StaggeredGridLayoutManager.this.y.i() : StaggeredGridLayoutManager.this.y.m();
        }

        void b(int i2) {
            if (this.f2057c) {
                this.f2056b = StaggeredGridLayoutManager.this.y.i() - i2;
            } else {
                this.f2056b = StaggeredGridLayoutManager.this.y.m() + i2;
            }
        }

        void c() {
            this.a = -1;
            this.f2056b = Integer.MIN_VALUE;
            this.f2057c = false;
            this.f2058d = false;
            this.f2059e = false;
            int[] iArr = this.f2060f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f2060f;
            if (iArr == null || iArr.length < length) {
                this.f2060f = new int[StaggeredGridLayoutManager.this.x.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f2060f[i2] = fVarArr[i2].p(Integer.MIN_VALUE);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        f f2062e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2063f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.f2062e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f2080e;
        }

        public boolean f() {
            return this.f2063f;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f2068b;

        /* renamed from: c  reason: collision with root package name */
        int f2069c;

        /* renamed from: d  reason: collision with root package name */
        int[] f2070d;

        /* renamed from: e  reason: collision with root package name */
        int f2071e;

        /* renamed from: f  reason: collision with root package name */
        int[] f2072f;

        /* renamed from: g  reason: collision with root package name */
        List<d.a> f2073g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2074h;

        /* renamed from: j  reason: collision with root package name */
        boolean f2075j;

        /* renamed from: k  reason: collision with root package name */
        boolean f2076k;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e() {
        }

        void a() {
            this.f2070d = null;
            this.f2069c = 0;
            this.a = -1;
            this.f2068b = -1;
        }

        void b() {
            this.f2070d = null;
            this.f2069c = 0;
            this.f2071e = 0;
            this.f2072f = null;
            this.f2073g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.f2068b);
            parcel.writeInt(this.f2069c);
            if (this.f2069c > 0) {
                parcel.writeIntArray(this.f2070d);
            }
            parcel.writeInt(this.f2071e);
            if (this.f2071e > 0) {
                parcel.writeIntArray(this.f2072f);
            }
            parcel.writeInt(this.f2074h ? 1 : 0);
            parcel.writeInt(this.f2075j ? 1 : 0);
            parcel.writeInt(this.f2076k ? 1 : 0);
            parcel.writeList(this.f2073g);
        }

        e(Parcel parcel) {
            this.a = parcel.readInt();
            this.f2068b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f2069c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2070d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f2071e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f2072f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f2074h = parcel.readInt() == 1;
            this.f2075j = parcel.readInt() == 1;
            this.f2076k = parcel.readInt() == 1;
            this.f2073g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f2069c = eVar.f2069c;
            this.a = eVar.a;
            this.f2068b = eVar.f2068b;
            this.f2070d = eVar.f2070d;
            this.f2071e = eVar.f2071e;
            this.f2072f = eVar.f2072f;
            this.f2074h = eVar.f2074h;
            this.f2075j = eVar.f2075j;
            this.f2076k = eVar.f2076k;
            this.f2073g = eVar.f2073g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f {
        ArrayList<View> a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f2077b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f2078c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f2079d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f2080e;

        f(int i2) {
            this.f2080e = i2;
        }

        void a(View view) {
            c n = n(view);
            n.f2062e = this;
            this.a.add(view);
            this.f2078c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.f2077b = Integer.MIN_VALUE;
            }
            if (n.c() || n.b()) {
                this.f2079d += StaggeredGridLayoutManager.this.y.e(view);
            }
        }

        void b(boolean z, int i2) {
            int p;
            if (z) {
                p = l(Integer.MIN_VALUE);
            } else {
                p = p(Integer.MIN_VALUE);
            }
            e();
            if (p == Integer.MIN_VALUE) {
                return;
            }
            if (!z || p >= StaggeredGridLayoutManager.this.y.i()) {
                if (z || p <= StaggeredGridLayoutManager.this.y.m()) {
                    if (i2 != Integer.MIN_VALUE) {
                        p += i2;
                    }
                    this.f2078c = p;
                    this.f2077b = p;
                }
            }
        }

        void c() {
            d.a f2;
            ArrayList<View> arrayList = this.a;
            View view = arrayList.get(arrayList.size() - 1);
            c n = n(view);
            this.f2078c = StaggeredGridLayoutManager.this.y.d(view);
            if (n.f2063f && (f2 = StaggeredGridLayoutManager.this.I.f(n.a())) != null && f2.f2065b == 1) {
                this.f2078c += f2.a(this.f2080e);
            }
        }

        void d() {
            d.a f2;
            View view = this.a.get(0);
            c n = n(view);
            this.f2077b = StaggeredGridLayoutManager.this.y.g(view);
            if (n.f2063f && (f2 = StaggeredGridLayoutManager.this.I.f(n.a())) != null && f2.f2065b == -1) {
                this.f2077b -= f2.a(this.f2080e);
            }
        }

        void e() {
            this.a.clear();
            q();
            this.f2079d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.D) {
                return i(this.a.size() - 1, -1, true);
            }
            return i(0, this.a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.D) {
                return i(0, this.a.size(), true);
            }
            return i(this.a.size() - 1, -1, true);
        }

        int h(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int m = StaggeredGridLayoutManager.this.y.m();
            int i4 = StaggeredGridLayoutManager.this.y.i();
            int i5 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.a.get(i2);
                int g2 = StaggeredGridLayoutManager.this.y.g(view);
                int d2 = StaggeredGridLayoutManager.this.y.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? g2 >= i4 : g2 > i4;
                if (!z3 ? d2 > m : d2 >= m) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (g2 >= m && d2 <= i4) {
                            return StaggeredGridLayoutManager.this.m0(view);
                        }
                    } else if (z2) {
                        return StaggeredGridLayoutManager.this.m0(view);
                    } else {
                        if (g2 < m || d2 > i4) {
                            return StaggeredGridLayoutManager.this.m0(view);
                        }
                    }
                }
                i2 += i5;
            }
            return -1;
        }

        int i(int i2, int i3, boolean z) {
            return h(i2, i3, false, false, z);
        }

        public int j() {
            return this.f2079d;
        }

        int k() {
            int i2 = this.f2078c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f2078c;
        }

        int l(int i2) {
            int i3 = this.f2078c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            c();
            return this.f2078c;
        }

        public View m(int i2, int i3) {
            View view = null;
            if (i3 == -1) {
                int size = this.a.size();
                int i4 = 0;
                while (i4 < size) {
                    View view2 = this.a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.D && staggeredGridLayoutManager.m0(view2) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.D && staggeredGridLayoutManager2.m0(view2) >= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view2;
                }
            } else {
                int size2 = this.a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.D && staggeredGridLayoutManager3.m0(view3) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.D && staggeredGridLayoutManager4.m0(view3) <= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i2 = this.f2077b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.f2077b;
        }

        int p(int i2) {
            int i3 = this.f2077b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            d();
            return this.f2077b;
        }

        void q() {
            this.f2077b = Integer.MIN_VALUE;
            this.f2078c = Integer.MIN_VALUE;
        }

        void r(int i2) {
            int i3 = this.f2077b;
            if (i3 != Integer.MIN_VALUE) {
                this.f2077b = i3 + i2;
            }
            int i4 = this.f2078c;
            if (i4 != Integer.MIN_VALUE) {
                this.f2078c = i4 + i2;
            }
        }

        void s() {
            int size = this.a.size();
            View remove = this.a.remove(size - 1);
            c n = n(remove);
            n.f2062e = null;
            if (n.c() || n.b()) {
                this.f2079d -= StaggeredGridLayoutManager.this.y.e(remove);
            }
            if (size == 1) {
                this.f2077b = Integer.MIN_VALUE;
            }
            this.f2078c = Integer.MIN_VALUE;
        }

        void t() {
            View remove = this.a.remove(0);
            c n = n(remove);
            n.f2062e = null;
            if (this.a.size() == 0) {
                this.f2078c = Integer.MIN_VALUE;
            }
            if (n.c() || n.b()) {
                this.f2079d -= StaggeredGridLayoutManager.this.y.e(remove);
            }
            this.f2077b = Integer.MIN_VALUE;
        }

        void u(View view) {
            c n = n(view);
            n.f2062e = this;
            this.a.add(0, view);
            this.f2077b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.f2078c = Integer.MIN_VALUE;
            }
            if (n.c() || n.b()) {
                this.f2079d += StaggeredGridLayoutManager.this.y.e(view);
            }
        }

        void v(int i2) {
            this.f2077b = i2;
            this.f2078c = i2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.d n0 = RecyclerView.o.n0(context, attributeSet, i2, i3);
        O2(n0.a);
        Q2(n0.f2037b);
        P2(n0.f2038c);
        this.C = new k();
        h2();
    }

    private void B2(View view, int i2, int i3, boolean z) {
        boolean M1;
        t(view, this.O);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.O;
        int Y2 = Y2(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.O;
        int Y22 = Y2(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z) {
            M1 = O1(view, Y2, Y22, cVar);
        } else {
            M1 = M1(view, Y2, Y22, cVar);
        }
        if (M1) {
            view.measure(Y2, Y22);
        }
    }

    private void C2(View view, c cVar, boolean z) {
        if (cVar.f2063f) {
            if (this.A == 1) {
                B2(view, this.N, RecyclerView.o.U(g0(), h0(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
            } else {
                B2(view, RecyclerView.o.U(t0(), u0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.N, z);
            }
        } else if (this.A == 1) {
            B2(view, RecyclerView.o.U(this.B, u0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.U(g0(), h0(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
        } else {
            B2(view, RecyclerView.o.U(t0(), u0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.U(this.B, h0(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0157, code lost:
        if (Z1() != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.b0 r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.D2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$b0, boolean):void");
    }

    private boolean E2(int i2) {
        if (this.A == 0) {
            return (i2 == -1) != this.E;
        }
        return ((i2 == -1) == this.E) == A2();
    }

    private void G2(View view) {
        for (int i2 = this.w - 1; i2 >= 0; i2--) {
            this.x[i2].u(view);
        }
    }

    private void H2(RecyclerView.v vVar, k kVar) {
        int min;
        int min2;
        if (!kVar.a || kVar.f2197i) {
            return;
        }
        if (kVar.f2190b == 0) {
            if (kVar.f2193e == -1) {
                I2(vVar, kVar.f2195g);
            } else {
                J2(vVar, kVar.f2194f);
            }
        } else if (kVar.f2193e == -1) {
            int i2 = kVar.f2194f;
            int t2 = i2 - t2(i2);
            if (t2 < 0) {
                min2 = kVar.f2195g;
            } else {
                min2 = kVar.f2195g - Math.min(t2, kVar.f2190b);
            }
            I2(vVar, min2);
        } else {
            int u2 = u2(kVar.f2195g) - kVar.f2195g;
            if (u2 < 0) {
                min = kVar.f2194f;
            } else {
                min = Math.min(u2, kVar.f2190b) + kVar.f2194f;
            }
            J2(vVar, min);
        }
    }

    private void I2(RecyclerView.v vVar, int i2) {
        for (int T = T() - 1; T >= 0; T--) {
            View S = S(T);
            if (this.y.g(S) < i2 || this.y.q(S) < i2) {
                return;
            }
            c cVar = (c) S.getLayoutParams();
            if (cVar.f2063f) {
                for (int i3 = 0; i3 < this.w; i3++) {
                    if (this.x[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.w; i4++) {
                    this.x[i4].s();
                }
            } else if (cVar.f2062e.a.size() == 1) {
                return;
            } else {
                cVar.f2062e.s();
            }
            t1(S, vVar);
        }
    }

    private void J2(RecyclerView.v vVar, int i2) {
        while (T() > 0) {
            View S = S(0);
            if (this.y.d(S) > i2 || this.y.p(S) > i2) {
                return;
            }
            c cVar = (c) S.getLayoutParams();
            if (cVar.f2063f) {
                for (int i3 = 0; i3 < this.w; i3++) {
                    if (this.x[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.w; i4++) {
                    this.x[i4].t();
                }
            } else if (cVar.f2062e.a.size() == 1) {
                return;
            } else {
                cVar.f2062e.t();
            }
            t1(S, vVar);
        }
    }

    private void K2() {
        if (this.z.k() == 1073741824) {
            return;
        }
        float f2 = 0.0f;
        int T = T();
        for (int i2 = 0; i2 < T; i2++) {
            View S = S(i2);
            float e2 = this.z.e(S);
            if (e2 >= f2) {
                if (((c) S.getLayoutParams()).f()) {
                    e2 = (e2 * 1.0f) / this.w;
                }
                f2 = Math.max(f2, e2);
            }
        }
        int i3 = this.B;
        int round = Math.round(f2 * this.w);
        if (this.z.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.z.n());
        }
        W2(round);
        if (this.B == i3) {
            return;
        }
        for (int i4 = 0; i4 < T; i4++) {
            View S2 = S(i4);
            c cVar = (c) S2.getLayoutParams();
            if (!cVar.f2063f) {
                if (A2() && this.A == 1) {
                    int i5 = this.w;
                    int i6 = cVar.f2062e.f2080e;
                    S2.offsetLeftAndRight(((-((i5 - 1) - i6)) * this.B) - ((-((i5 - 1) - i6)) * i3));
                } else {
                    int i7 = cVar.f2062e.f2080e;
                    int i8 = this.B * i7;
                    int i9 = i7 * i3;
                    if (this.A == 1) {
                        S2.offsetLeftAndRight(i8 - i9);
                    } else {
                        S2.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    private void L2() {
        if (this.A != 1 && A2()) {
            this.E = !this.D;
        } else {
            this.E = this.D;
        }
    }

    private void N2(int i2) {
        k kVar = this.C;
        kVar.f2193e = i2;
        kVar.f2192d = this.E != (i2 == -1) ? -1 : 1;
    }

    private void R2(int i2, int i3) {
        for (int i4 = 0; i4 < this.w; i4++) {
            if (!this.x[i4].a.isEmpty()) {
                X2(this.x[i4], i2, i3);
            }
        }
    }

    private boolean S2(RecyclerView.b0 b0Var, b bVar) {
        int j2;
        if (this.K) {
            j2 = n2(b0Var.b());
        } else {
            j2 = j2(b0Var.b());
        }
        bVar.a = j2;
        bVar.f2056b = Integer.MIN_VALUE;
        return true;
    }

    private void T1(View view) {
        for (int i2 = this.w - 1; i2 >= 0; i2--) {
            this.x[i2].a(view);
        }
    }

    private void U1(b bVar) {
        int m;
        e eVar = this.M;
        int i2 = eVar.f2069c;
        if (i2 > 0) {
            if (i2 == this.w) {
                for (int i3 = 0; i3 < this.w; i3++) {
                    this.x[i3].e();
                    e eVar2 = this.M;
                    int i4 = eVar2.f2070d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (eVar2.f2075j) {
                            m = this.y.i();
                        } else {
                            m = this.y.m();
                        }
                        i4 += m;
                    }
                    this.x[i3].v(i4);
                }
            } else {
                eVar.b();
                e eVar3 = this.M;
                eVar3.a = eVar3.f2068b;
            }
        }
        e eVar4 = this.M;
        this.L = eVar4.f2076k;
        P2(eVar4.f2074h);
        L2();
        e eVar5 = this.M;
        int i5 = eVar5.a;
        if (i5 != -1) {
            this.G = i5;
            bVar.f2057c = eVar5.f2075j;
        } else {
            bVar.f2057c = this.E;
        }
        if (eVar5.f2071e > 1) {
            d dVar = this.I;
            dVar.a = eVar5.f2072f;
            dVar.f2064b = eVar5.f2073g;
        }
    }

    private void V2(int i2, RecyclerView.b0 b0Var) {
        int i3;
        int i4;
        int c2;
        k kVar = this.C;
        boolean z = false;
        kVar.f2190b = 0;
        kVar.f2191c = i2;
        if (!D0() || (c2 = b0Var.c()) == -1) {
            i3 = 0;
            i4 = 0;
        } else {
            if (this.E == (c2 < i2)) {
                i3 = this.y.n();
                i4 = 0;
            } else {
                i4 = this.y.n();
                i3 = 0;
            }
        }
        if (W()) {
            this.C.f2194f = this.y.m() - i4;
            this.C.f2195g = this.y.i() + i3;
        } else {
            this.C.f2195g = this.y.h() + i3;
            this.C.f2194f = -i4;
        }
        k kVar2 = this.C;
        kVar2.f2196h = false;
        kVar2.a = true;
        if (this.y.k() == 0 && this.y.h() == 0) {
            z = true;
        }
        kVar2.f2197i = z;
    }

    private void X1(View view, c cVar, k kVar) {
        if (kVar.f2193e == 1) {
            if (cVar.f2063f) {
                T1(view);
            } else {
                cVar.f2062e.a(view);
            }
        } else if (cVar.f2063f) {
            G2(view);
        } else {
            cVar.f2062e.u(view);
        }
    }

    private void X2(f fVar, int i2, int i3) {
        int j2 = fVar.j();
        if (i2 == -1) {
            if (fVar.o() + j2 <= i3) {
                this.F.set(fVar.f2080e, false);
            }
        } else if (fVar.k() - j2 >= i3) {
            this.F.set(fVar.f2080e, false);
        }
    }

    private int Y1(int i2) {
        if (T() == 0) {
            return this.E ? 1 : -1;
        }
        return (i2 < q2()) != this.E ? -1 : 1;
    }

    private int Y2(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    private boolean a2(f fVar) {
        if (this.E) {
            if (fVar.k() < this.y.i()) {
                ArrayList<View> arrayList = fVar.a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).f2063f;
            }
        } else if (fVar.o() > this.y.m()) {
            return !fVar.n(fVar.a.get(0)).f2063f;
        }
        return false;
    }

    private int b2(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        return r.a(b0Var, this.y, l2(!this.R), k2(!this.R), this, this.R);
    }

    private int c2(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        return r.b(b0Var, this.y, l2(!this.R), k2(!this.R), this, this.R, this.E);
    }

    private int d2(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        return r.c(b0Var, this.y, l2(!this.R), k2(!this.R), this, this.R);
    }

    private int e2(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.A == 1) ? 1 : Integer.MIN_VALUE : this.A == 0 ? 1 : Integer.MIN_VALUE : this.A == 1 ? -1 : Integer.MIN_VALUE : this.A == 0 ? -1 : Integer.MIN_VALUE : (this.A != 1 && A2()) ? -1 : 1 : (this.A != 1 && A2()) ? 1 : -1;
    }

    private d.a f2(int i2) {
        d.a aVar = new d.a();
        aVar.f2066c = new int[this.w];
        for (int i3 = 0; i3 < this.w; i3++) {
            aVar.f2066c[i3] = i2 - this.x[i3].l(i2);
        }
        return aVar;
    }

    private d.a g2(int i2) {
        d.a aVar = new d.a();
        aVar.f2066c = new int[this.w];
        for (int i3 = 0; i3 < this.w; i3++) {
            aVar.f2066c[i3] = this.x[i3].p(i2) - i2;
        }
        return aVar;
    }

    private void h2() {
        this.y = p.b(this, this.A);
        this.z = p.b(this, 1 - this.A);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int i2(RecyclerView.v vVar, k kVar, RecyclerView.b0 b0Var) {
        int i2;
        int m;
        int s2;
        f fVar;
        int e2;
        int i3;
        int i4;
        int e3;
        boolean z;
        boolean W1;
        ?? r9 = 0;
        this.F.set(0, this.w, true);
        if (this.C.f2197i) {
            i2 = kVar.f2193e == 1 ? RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO : Integer.MIN_VALUE;
        } else if (kVar.f2193e == 1) {
            i2 = kVar.f2195g + kVar.f2190b;
        } else {
            i2 = kVar.f2194f - kVar.f2190b;
        }
        int i5 = i2;
        R2(kVar.f2193e, i5);
        if (this.E) {
            m = this.y.i();
        } else {
            m = this.y.m();
        }
        int i6 = m;
        boolean z2 = false;
        while (kVar.a(b0Var) && (this.C.f2197i || !this.F.isEmpty())) {
            View b2 = kVar.b(vVar);
            c cVar = (c) b2.getLayoutParams();
            int a2 = cVar.a();
            int g2 = this.I.g(a2);
            boolean z3 = g2 == -1 ? true : r9;
            if (z3) {
                fVar = cVar.f2063f ? this.x[r9] : w2(kVar);
                this.I.n(a2, fVar);
            } else {
                fVar = this.x[g2];
            }
            f fVar2 = fVar;
            cVar.f2062e = fVar2;
            if (kVar.f2193e == 1) {
                n(b2);
            } else {
                o(b2, r9);
            }
            C2(b2, cVar, r9);
            if (kVar.f2193e == 1) {
                int s22 = cVar.f2063f ? s2(i6) : fVar2.l(i6);
                int e4 = this.y.e(b2) + s22;
                if (z3 && cVar.f2063f) {
                    d.a f2 = f2(s22);
                    f2.f2065b = -1;
                    f2.a = a2;
                    this.I.a(f2);
                }
                i3 = e4;
                e2 = s22;
            } else {
                int v2 = cVar.f2063f ? v2(i6) : fVar2.p(i6);
                e2 = v2 - this.y.e(b2);
                if (z3 && cVar.f2063f) {
                    d.a g22 = g2(v2);
                    g22.f2065b = 1;
                    g22.a = a2;
                    this.I.a(g22);
                }
                i3 = v2;
            }
            if (cVar.f2063f && kVar.f2192d == -1) {
                if (z3) {
                    this.Q = true;
                } else {
                    if (kVar.f2193e == 1) {
                        W1 = V1();
                    } else {
                        W1 = W1();
                    }
                    if (!W1) {
                        d.a f3 = this.I.f(a2);
                        if (f3 != null) {
                            f3.f2067d = true;
                        }
                        this.Q = true;
                    }
                }
            }
            X1(b2, cVar, kVar);
            if (A2() && this.A == 1) {
                int i7 = cVar.f2063f ? this.z.i() : this.z.i() - (((this.w - 1) - fVar2.f2080e) * this.B);
                e3 = i7;
                i4 = i7 - this.z.e(b2);
            } else {
                int m2 = cVar.f2063f ? this.z.m() : (fVar2.f2080e * this.B) + this.z.m();
                i4 = m2;
                e3 = this.z.e(b2) + m2;
            }
            if (this.A == 1) {
                F0(b2, i4, e2, e3, i3);
            } else {
                F0(b2, e2, i4, i3, e3);
            }
            if (cVar.f2063f) {
                R2(this.C.f2193e, i5);
            } else {
                X2(fVar2, this.C.f2193e, i5);
            }
            H2(vVar, this.C);
            if (this.C.f2196h && b2.hasFocusable()) {
                if (cVar.f2063f) {
                    this.F.clear();
                } else {
                    z = false;
                    this.F.set(fVar2.f2080e, false);
                    r9 = z;
                    z2 = true;
                }
            }
            z = false;
            r9 = z;
            z2 = true;
        }
        int i8 = r9;
        if (!z2) {
            H2(vVar, this.C);
        }
        if (this.C.f2193e == -1) {
            s2 = this.y.m() - v2(this.y.m());
        } else {
            s2 = s2(this.y.i()) - this.y.i();
        }
        return s2 > 0 ? Math.min(kVar.f2190b, s2) : i8;
    }

    private int j2(int i2) {
        int T = T();
        for (int i3 = 0; i3 < T; i3++) {
            int m0 = m0(S(i3));
            if (m0 >= 0 && m0 < i2) {
                return m0;
            }
        }
        return 0;
    }

    private int n2(int i2) {
        for (int T = T() - 1; T >= 0; T--) {
            int m0 = m0(S(T));
            if (m0 >= 0 && m0 < i2) {
                return m0;
            }
        }
        return 0;
    }

    private void o2(RecyclerView.v vVar, RecyclerView.b0 b0Var, boolean z) {
        int i2;
        int s2 = s2(Integer.MIN_VALUE);
        if (s2 != Integer.MIN_VALUE && (i2 = this.y.i() - s2) > 0) {
            int i3 = i2 - (-M2(-i2, vVar, b0Var));
            if (!z || i3 <= 0) {
                return;
            }
            this.y.r(i3);
        }
    }

    private void p2(RecyclerView.v vVar, RecyclerView.b0 b0Var, boolean z) {
        int m;
        int v2 = v2(RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
        if (v2 != Integer.MAX_VALUE && (m = v2 - this.y.m()) > 0) {
            int M2 = m - M2(m, vVar, b0Var);
            if (!z || M2 <= 0) {
                return;
            }
            this.y.r(-M2);
        }
    }

    private int s2(int i2) {
        int l2 = this.x[0].l(i2);
        for (int i3 = 1; i3 < this.w; i3++) {
            int l3 = this.x[i3].l(i2);
            if (l3 > l2) {
                l2 = l3;
            }
        }
        return l2;
    }

    private int t2(int i2) {
        int p = this.x[0].p(i2);
        for (int i3 = 1; i3 < this.w; i3++) {
            int p2 = this.x[i3].p(i2);
            if (p2 > p) {
                p = p2;
            }
        }
        return p;
    }

    private int u2(int i2) {
        int l2 = this.x[0].l(i2);
        for (int i3 = 1; i3 < this.w; i3++) {
            int l3 = this.x[i3].l(i2);
            if (l3 < l2) {
                l2 = l3;
            }
        }
        return l2;
    }

    private int v2(int i2) {
        int p = this.x[0].p(i2);
        for (int i3 = 1; i3 < this.w; i3++) {
            int p2 = this.x[i3].p(i2);
            if (p2 < p) {
                p = p2;
            }
        }
        return p;
    }

    private f w2(k kVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (E2(kVar.f2193e)) {
            i2 = this.w - 1;
            i3 = -1;
        } else {
            i2 = 0;
            i4 = this.w;
            i3 = 1;
        }
        f fVar = null;
        if (kVar.f2193e == 1) {
            int i5 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
            int m = this.y.m();
            while (i2 != i4) {
                f fVar2 = this.x[i2];
                int l2 = fVar2.l(m);
                if (l2 < i5) {
                    fVar = fVar2;
                    i5 = l2;
                }
                i2 += i3;
            }
            return fVar;
        }
        int i6 = Integer.MIN_VALUE;
        int i7 = this.y.i();
        while (i2 != i4) {
            f fVar3 = this.x[i2];
            int p = fVar3.p(i7);
            if (p > i6) {
                fVar = fVar3;
                i6 = p;
            }
            i2 += i3;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void x2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.E
            if (r0 == 0) goto L9
            int r0 = r6.r2()
            goto Ld
        L9:
            int r0 = r6.q2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.I
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.I
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.I
            r7.j(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.I
            r9.k(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.I
            r9.j(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.E
            if (r7 == 0) goto L4d
            int r7 = r6.q2()
            goto L51
        L4d:
            int r7 = r6.r2()
        L51:
            if (r3 > r7) goto L56
            r6.A1()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.x2(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.b0 b0Var) {
        return b2(b0Var);
    }

    boolean A2() {
        return i0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        return c2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        return d2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        return b2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        return M2(i2, vVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        return c2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void E1(int i2) {
        e eVar = this.M;
        if (eVar != null && eVar.a != i2) {
            eVar.a();
        }
        this.G = i2;
        this.H = Integer.MIN_VALUE;
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        return d2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        return M2(i2, vVar, b0Var);
    }

    void F2(int i2, RecyclerView.b0 b0Var) {
        int i3;
        int q2;
        if (i2 > 0) {
            q2 = r2();
            i3 = 1;
        } else {
            i3 = -1;
            q2 = q2();
        }
        this.C.a = true;
        V2(q2, b0Var);
        N2(i3);
        k kVar = this.C;
        kVar.f2191c = q2 + kVar.f2192d;
        kVar.f2190b = Math.abs(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(int i2) {
        super.I0(i2);
        for (int i3 = 0; i3 < this.w; i3++) {
            this.x[i3].r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(int i2) {
        super.J0(i2);
        for (int i3 = 0; i3 < this.w; i3++) {
            this.x[i3].r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J1(Rect rect, int i2, int i3) {
        int x;
        int x2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.A == 1) {
            x2 = RecyclerView.o.x(i3, rect.height() + paddingTop, k0());
            x = RecyclerView.o.x(i2, (this.B * this.w) + paddingLeft, l0());
        } else {
            x = RecyclerView.o.x(i2, rect.width() + paddingLeft, l0());
            x2 = RecyclerView.o.x(i3, (this.B * this.w) + paddingTop, k0());
        }
        I1(x, x2);
    }

    int M2(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (T() == 0 || i2 == 0) {
            return 0;
        }
        F2(i2, b0Var);
        int i22 = i2(vVar, this.C, b0Var);
        if (this.C.f2190b >= i22) {
            i2 = i2 < 0 ? -i22 : i22;
        }
        this.y.r(-i2);
        this.K = this.E;
        k kVar = this.C;
        kVar.f2190b = 0;
        H2(vVar, kVar);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        if (this.A == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p O(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.O0(recyclerView, vVar);
        v1(this.T);
        for (int i2 = 0; i2 < this.w; i2++) {
            this.x[i2].e();
        }
        recyclerView.requestLayout();
    }

    public void O2(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        q(null);
        if (i2 == this.A) {
            return;
        }
        this.A = i2;
        p pVar = this.y;
        this.y = this.z;
        this.z = pVar;
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p P(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View P0(View view, int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        View L;
        int q2;
        int g2;
        int g3;
        int g4;
        View m;
        if (T() == 0 || (L = L(view)) == null) {
            return null;
        }
        L2();
        int e2 = e2(i2);
        if (e2 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) L.getLayoutParams();
        boolean z = cVar.f2063f;
        f fVar = cVar.f2062e;
        if (e2 == 1) {
            q2 = r2();
        } else {
            q2 = q2();
        }
        V2(q2, b0Var);
        N2(e2);
        k kVar = this.C;
        kVar.f2191c = kVar.f2192d + q2;
        kVar.f2190b = (int) (this.y.n() * 0.33333334f);
        k kVar2 = this.C;
        kVar2.f2196h = true;
        kVar2.a = false;
        i2(vVar, kVar2, b0Var);
        this.K = this.E;
        if (z || (m = fVar.m(q2, e2)) == null || m == L) {
            if (E2(e2)) {
                for (int i3 = this.w - 1; i3 >= 0; i3--) {
                    View m2 = this.x[i3].m(q2, e2);
                    if (m2 != null && m2 != L) {
                        return m2;
                    }
                }
            } else {
                for (int i4 = 0; i4 < this.w; i4++) {
                    View m3 = this.x[i4].m(q2, e2);
                    if (m3 != null && m3 != L) {
                        return m3;
                    }
                }
            }
            boolean z2 = (this.D ^ true) == (e2 == -1);
            if (!z) {
                if (z2) {
                    g4 = fVar.f();
                } else {
                    g4 = fVar.g();
                }
                View M = M(g4);
                if (M != null && M != L) {
                    return M;
                }
            }
            if (E2(e2)) {
                for (int i5 = this.w - 1; i5 >= 0; i5--) {
                    if (i5 != fVar.f2080e) {
                        if (z2) {
                            g3 = this.x[i5].f();
                        } else {
                            g3 = this.x[i5].g();
                        }
                        View M2 = M(g3);
                        if (M2 != null && M2 != L) {
                            return M2;
                        }
                    }
                }
            } else {
                for (int i6 = 0; i6 < this.w; i6++) {
                    if (z2) {
                        g2 = this.x[i6].f();
                    } else {
                        g2 = this.x[i6].g();
                    }
                    View M3 = M(g2);
                    if (M3 != null && M3 != L) {
                        return M3;
                    }
                }
            }
            return null;
        }
        return m;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P1(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i2) {
        l lVar = new l(recyclerView.getContext());
        lVar.p(i2);
        Q1(lVar);
    }

    public void P2(boolean z) {
        q(null);
        e eVar = this.M;
        if (eVar != null && eVar.f2074h != z) {
            eVar.f2074h = z;
        }
        this.D = z;
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(AccessibilityEvent accessibilityEvent) {
        super.Q0(accessibilityEvent);
        if (T() > 0) {
            View l2 = l2(false);
            View k2 = k2(false);
            if (l2 == null || k2 == null) {
                return;
            }
            int m0 = m0(l2);
            int m02 = m0(k2);
            if (m0 < m02) {
                accessibilityEvent.setFromIndex(m0);
                accessibilityEvent.setToIndex(m02);
                return;
            }
            accessibilityEvent.setFromIndex(m02);
            accessibilityEvent.setToIndex(m0);
        }
    }

    public void Q2(int i2) {
        q(null);
        if (i2 != this.w) {
            z2();
            this.w = i2;
            this.F = new BitSet(this.w);
            this.x = new f[this.w];
            for (int i3 = 0; i3 < this.w; i3++) {
                this.x[i3] = new f(i3);
            }
            A1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean S1() {
        return this.M == null;
    }

    boolean T2(RecyclerView.b0 b0Var, b bVar) {
        int i2;
        int m;
        if (!b0Var.e() && (i2 = this.G) != -1) {
            if (i2 >= 0 && i2 < b0Var.b()) {
                e eVar = this.M;
                if (eVar != null && eVar.a != -1 && eVar.f2069c >= 1) {
                    bVar.f2056b = Integer.MIN_VALUE;
                    bVar.a = this.G;
                } else {
                    View M = M(this.G);
                    if (M != null) {
                        bVar.a = this.E ? r2() : q2();
                        if (this.H != Integer.MIN_VALUE) {
                            if (bVar.f2057c) {
                                bVar.f2056b = (this.y.i() - this.H) - this.y.d(M);
                            } else {
                                bVar.f2056b = (this.y.m() + this.H) - this.y.g(M);
                            }
                            return true;
                        } else if (this.y.e(M) > this.y.n()) {
                            if (bVar.f2057c) {
                                m = this.y.i();
                            } else {
                                m = this.y.m();
                            }
                            bVar.f2056b = m;
                            return true;
                        } else {
                            int g2 = this.y.g(M) - this.y.m();
                            if (g2 < 0) {
                                bVar.f2056b = -g2;
                                return true;
                            }
                            int i3 = this.y.i() - this.y.d(M);
                            if (i3 < 0) {
                                bVar.f2056b = i3;
                                return true;
                            }
                            bVar.f2056b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i4 = this.G;
                        bVar.a = i4;
                        int i5 = this.H;
                        if (i5 == Integer.MIN_VALUE) {
                            bVar.f2057c = Y1(i4) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i5);
                        }
                        bVar.f2058d = true;
                    }
                }
                return true;
            }
            this.G = -1;
            this.H = Integer.MIN_VALUE;
        }
        return false;
    }

    void U2(RecyclerView.b0 b0Var, b bVar) {
        if (T2(b0Var, bVar) || S2(b0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView.v vVar, RecyclerView.b0 b0Var, View view, c.h.k.e0.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.U0(view, dVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.A == 0) {
            dVar.W(d.c.b(cVar.e(), cVar.f2063f ? this.w : 1, -1, -1, false, false));
        } else {
            dVar.W(d.c.b(-1, -1, cVar.e(), cVar.f2063f ? this.w : 1, false, false));
        }
    }

    boolean V1() {
        int l2 = this.x[0].l(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.w; i2++) {
            if (this.x[i2].l(Integer.MIN_VALUE) != l2) {
                return false;
            }
        }
        return true;
    }

    boolean W1() {
        int p = this.x[0].p(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.w; i2++) {
            if (this.x[i2].p(Integer.MIN_VALUE) != p) {
                return false;
            }
        }
        return true;
    }

    void W2(int i2) {
        this.B = i2 / this.w;
        this.N = View.MeasureSpec.makeMeasureSpec(i2, this.z.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int X(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (this.A == 1) {
            return this.w;
        }
        return super.X(vVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i2, int i3) {
        x2(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView recyclerView) {
        this.I.b();
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, int i2, int i3, int i4) {
        x2(i2, i3, 8);
    }

    boolean Z1() {
        int q2;
        int r2;
        if (T() == 0 || this.J == 0 || !w0()) {
            return false;
        }
        if (this.E) {
            q2 = r2();
            r2 = q2();
        } else {
            q2 = q2();
            r2 = r2();
        }
        if (q2 == 0 && y2() != null) {
            this.I.b();
            B1();
            A1();
            return true;
        } else if (this.Q) {
            int i2 = this.E ? -1 : 1;
            int i3 = r2 + 1;
            d.a e2 = this.I.e(q2, i3, i2, true);
            if (e2 == null) {
                this.Q = false;
                this.I.d(i3);
                return false;
            }
            d.a e3 = this.I.e(q2, e2.a, i2 * (-1), true);
            if (e3 == null) {
                this.I.d(e2.a);
            } else {
                this.I.d(e3.a + 1);
            }
            B1();
            A1();
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0.b
    public PointF a(int i2) {
        int Y1 = Y1(i2);
        PointF pointF = new PointF();
        if (Y1 == 0) {
            return null;
        }
        if (this.A == 0) {
            pointF.x = Y1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = Y1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i2, int i3) {
        x2(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView recyclerView, int i2, int i3, Object obj) {
        x2(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        D2(vVar, b0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.b0 b0Var) {
        super.e1(b0Var);
        this.G = -1;
        this.H = Integer.MIN_VALUE;
        this.M = null;
        this.P.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.M = (e) parcelable;
            A1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable j1() {
        int p;
        int m;
        int[] iArr;
        if (this.M != null) {
            return new e(this.M);
        }
        e eVar = new e();
        eVar.f2074h = this.D;
        eVar.f2075j = this.K;
        eVar.f2076k = this.L;
        d dVar = this.I;
        if (dVar != null && (iArr = dVar.a) != null) {
            eVar.f2072f = iArr;
            eVar.f2071e = iArr.length;
            eVar.f2073g = dVar.f2064b;
        } else {
            eVar.f2071e = 0;
        }
        if (T() > 0) {
            eVar.a = this.K ? r2() : q2();
            eVar.f2068b = m2();
            int i2 = this.w;
            eVar.f2069c = i2;
            eVar.f2070d = new int[i2];
            for (int i3 = 0; i3 < this.w; i3++) {
                if (this.K) {
                    p = this.x[i3].l(Integer.MIN_VALUE);
                    if (p != Integer.MIN_VALUE) {
                        m = this.y.i();
                        p -= m;
                        eVar.f2070d[i3] = p;
                    } else {
                        eVar.f2070d[i3] = p;
                    }
                } else {
                    p = this.x[i3].p(Integer.MIN_VALUE);
                    if (p != Integer.MIN_VALUE) {
                        m = this.y.m();
                        p -= m;
                        eVar.f2070d[i3] = p;
                    } else {
                        eVar.f2070d[i3] = p;
                    }
                }
            }
        } else {
            eVar.a = -1;
            eVar.f2068b = -1;
            eVar.f2069c = 0;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k1(int i2) {
        if (i2 == 0) {
            Z1();
        }
    }

    View k2(boolean z) {
        int m = this.y.m();
        int i2 = this.y.i();
        View view = null;
        for (int T = T() - 1; T >= 0; T--) {
            View S = S(T);
            int g2 = this.y.g(S);
            int d2 = this.y.d(S);
            if (d2 > m && g2 < i2) {
                if (d2 <= i2 || !z) {
                    return S;
                }
                if (view == null) {
                    view = S;
                }
            }
        }
        return view;
    }

    View l2(boolean z) {
        int m = this.y.m();
        int i2 = this.y.i();
        int T = T();
        View view = null;
        for (int i3 = 0; i3 < T; i3++) {
            View S = S(i3);
            int g2 = this.y.g(S);
            if (this.y.d(S) > m && g2 < i2) {
                if (g2 >= m || !z) {
                    return S;
                }
                if (view == null) {
                    view = S;
                }
            }
        }
        return view;
    }

    int m2() {
        View k2 = this.E ? k2(true) : l2(true);
        if (k2 == null) {
            return -1;
        }
        return m0(k2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p0(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (this.A == 0) {
            return this.w;
        }
        return super.p0(vVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q(String str) {
        if (this.M == null) {
            super.q(str);
        }
    }

    int q2() {
        if (T() == 0) {
            return 0;
        }
        return m0(S(0));
    }

    int r2() {
        int T = T();
        if (T == 0) {
            return 0;
        }
        return m0(S(T - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        return this.A == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return this.A == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x0() {
        return this.J != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y(int i2, int i3, RecyclerView.b0 b0Var, RecyclerView.o.c cVar) {
        int l2;
        int i4;
        if (this.A != 0) {
            i2 = i3;
        }
        if (T() == 0 || i2 == 0) {
            return;
        }
        F2(i2, b0Var);
        int[] iArr = this.S;
        if (iArr == null || iArr.length < this.w) {
            this.S = new int[this.w];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.w; i6++) {
            k kVar = this.C;
            if (kVar.f2192d == -1) {
                l2 = kVar.f2194f;
                i4 = this.x[i6].p(l2);
            } else {
                l2 = this.x[i6].l(kVar.f2195g);
                i4 = this.C.f2195g;
            }
            int i7 = l2 - i4;
            if (i7 >= 0) {
                this.S[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.S, 0, i5);
        for (int i8 = 0; i8 < i5 && this.C.a(b0Var); i8++) {
            cVar.a(this.C.f2191c, this.S[i8]);
            k kVar2 = this.C;
            kVar2.f2191c += kVar2.f2192d;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View y2() {
        /*
            r12 = this;
            int r0 = r12.T()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.w
            r2.<init>(r3)
            int r3 = r12.w
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.A
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.A2()
            if (r3 == 0) goto L20
            r3 = r1
            goto L21
        L20:
            r3 = r5
        L21:
            boolean r6 = r12.E
            if (r6 == 0) goto L27
            r6 = r5
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L2b:
            if (r0 >= r6) goto L2e
            r5 = r1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.S(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2062e
            int r9 = r9.f2080e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2062e
            boolean r9 = r12.a2(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2062e
            int r9 = r9.f2080e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f2063f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.S(r9)
            boolean r10 = r12.E
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.p r10 = r12.y
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.p r11 = r12.y
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.p r10 = r12.y
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.p r11 = r12.y
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = r1
            goto L8b
        L8a:
            r10 = r4
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f2062e
            int r8 = r8.f2080e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f2062e
            int r9 = r9.f2080e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = r1
            goto La1
        La0:
            r8 = r4
        La1:
            if (r3 >= 0) goto La5
            r9 = r1
            goto La6
        La5:
            r9 = r4
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.y2():android.view.View");
    }

    public void z2() {
        this.I.b();
        A1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        int[] a;

        /* renamed from: b  reason: collision with root package name */
        List<a> f2064b;

        d() {
        }

        private int i(int i2) {
            if (this.f2064b == null) {
                return -1;
            }
            a f2 = f(i2);
            if (f2 != null) {
                this.f2064b.remove(f2);
            }
            int size = this.f2064b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.f2064b.get(i3).a >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 != -1) {
                this.f2064b.remove(i3);
                return this.f2064b.get(i3).a;
            }
            return -1;
        }

        private void l(int i2, int i3) {
            List<a> list = this.f2064b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2064b.get(size);
                int i4 = aVar.a;
                if (i4 >= i2) {
                    aVar.a = i4 + i3;
                }
            }
        }

        private void m(int i2, int i3) {
            List<a> list = this.f2064b;
            if (list == null) {
                return;
            }
            int i4 = i2 + i3;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2064b.get(size);
                int i5 = aVar.a;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.f2064b.remove(size);
                    } else {
                        aVar.a = i5 - i3;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f2064b == null) {
                this.f2064b = new ArrayList();
            }
            int size = this.f2064b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = this.f2064b.get(i2);
                if (aVar2.a == aVar.a) {
                    this.f2064b.remove(i2);
                }
                if (aVar2.a >= aVar.a) {
                    this.f2064b.add(i2, aVar);
                    return;
                }
            }
            this.f2064b.add(aVar);
        }

        void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2064b = null;
        }

        void c(int i2) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[o(i2)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i2) {
            List<a> list = this.f2064b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f2064b.get(size).a >= i2) {
                        this.f2064b.remove(size);
                    }
                }
            }
            return h(i2);
        }

        public a e(int i2, int i3, int i4, boolean z) {
            List<a> list = this.f2064b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = this.f2064b.get(i5);
                int i6 = aVar.a;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || aVar.f2065b == i4 || (z && aVar.f2067d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i2) {
            List<a> list = this.f2064b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2064b.get(size);
                if (aVar.a == i2) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i2) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        int h(int i2) {
            int[] iArr = this.a;
            if (iArr != null && i2 < iArr.length) {
                int i3 = i(i2);
                if (i3 == -1) {
                    int[] iArr2 = this.a;
                    Arrays.fill(iArr2, i2, iArr2.length, -1);
                    return this.a.length;
                }
                int i4 = i3 + 1;
                Arrays.fill(this.a, i2, i4, -1);
                return i4;
            }
            return -1;
        }

        void j(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.a, i2, i4, -1);
            l(i2, i3);
        }

        void k(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            m(i2, i3);
        }

        void n(int i2, f fVar) {
            c(i2);
            this.a[i2] = fVar.f2080e;
        }

        int o(int i2) {
            int length = this.a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0037a();
            int a;

            /* renamed from: b  reason: collision with root package name */
            int f2065b;

            /* renamed from: c  reason: collision with root package name */
            int[] f2066c;

            /* renamed from: d  reason: collision with root package name */
            boolean f2067d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0037a implements Parcelable.Creator<a> {
                C0037a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public a[] newArray(int i2) {
                    return new a[i2];
                }
            }

            a(Parcel parcel) {
                this.a = parcel.readInt();
                this.f2065b = parcel.readInt();
                this.f2067d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2066c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i2) {
                int[] iArr = this.f2066c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.f2065b + ", mHasUnwantedGapAfter=" + this.f2067d + ", mGapPerSpan=" + Arrays.toString(this.f2066c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.f2065b);
                parcel.writeInt(this.f2067d ? 1 : 0);
                int[] iArr = this.f2066c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f2066c);
                    return;
                }
                parcel.writeInt(0);
            }

            a() {
            }
        }
    }
}