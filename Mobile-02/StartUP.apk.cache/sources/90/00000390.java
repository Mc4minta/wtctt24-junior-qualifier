package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.a0.b {
    private boolean A;
    boolean B;
    private boolean C;
    private boolean D;
    int E;
    int F;
    private boolean G;
    d H;
    final a I;
    private final b J;
    private int K;
    private int[] L;
    int w;
    private c x;
    p y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        p a;

        /* renamed from: b  reason: collision with root package name */
        int f1969b;

        /* renamed from: c  reason: collision with root package name */
        int f1970c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1971d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1972e;

        a() {
            e();
        }

        void a() {
            int m;
            if (this.f1971d) {
                m = this.a.i();
            } else {
                m = this.a.m();
            }
            this.f1970c = m;
        }

        public void b(View view, int i2) {
            if (this.f1971d) {
                this.f1970c = this.a.d(view) + this.a.o();
            } else {
                this.f1970c = this.a.g(view);
            }
            this.f1969b = i2;
        }

        public void c(View view, int i2) {
            int o = this.a.o();
            if (o >= 0) {
                b(view, i2);
                return;
            }
            this.f1969b = i2;
            if (this.f1971d) {
                int i3 = (this.a.i() - o) - this.a.d(view);
                this.f1970c = this.a.i() - i3;
                if (i3 > 0) {
                    int e2 = this.f1970c - this.a.e(view);
                    int m = this.a.m();
                    int min = e2 - (m + Math.min(this.a.g(view) - m, 0));
                    if (min < 0) {
                        this.f1970c += Math.min(i3, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g2 = this.a.g(view);
            int m2 = g2 - this.a.m();
            this.f1970c = g2;
            if (m2 > 0) {
                int i4 = (this.a.i() - Math.min(0, (this.a.i() - o) - this.a.d(view))) - (g2 + this.a.e(view));
                if (i4 < 0) {
                    this.f1970c -= Math.min(m2, -i4);
                }
            }
        }

        boolean d(View view, RecyclerView.b0 b0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < b0Var.b();
        }

        void e() {
            this.f1969b = -1;
            this.f1970c = Integer.MIN_VALUE;
            this.f1971d = false;
            this.f1972e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1969b + ", mCoordinate=" + this.f1970c + ", mLayoutFromEnd=" + this.f1971d + ", mValid=" + this.f1972e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1973b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1974c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1975d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.f1973b = false;
            this.f1974c = false;
            this.f1975d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        int f1976b;

        /* renamed from: c  reason: collision with root package name */
        int f1977c;

        /* renamed from: d  reason: collision with root package name */
        int f1978d;

        /* renamed from: e  reason: collision with root package name */
        int f1979e;

        /* renamed from: f  reason: collision with root package name */
        int f1980f;

        /* renamed from: g  reason: collision with root package name */
        int f1981g;

        /* renamed from: k  reason: collision with root package name */
        int f1985k;
        boolean m;
        boolean a = true;

        /* renamed from: h  reason: collision with root package name */
        int f1982h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f1983i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f1984j = false;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.e0> f1986l = null;

        c() {
        }

        private View e() {
            int size = this.f1986l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.f1986l.get(i2).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1978d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f2 = f(view);
            if (f2 == null) {
                this.f1978d = -1;
            } else {
                this.f1978d = ((RecyclerView.p) f2.getLayoutParams()).a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.b0 b0Var) {
            int i2 = this.f1978d;
            return i2 >= 0 && i2 < b0Var.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.v vVar) {
            if (this.f1986l != null) {
                return e();
            }
            View o = vVar.o(this.f1978d);
            this.f1978d += this.f1979e;
            return o;
        }

        public View f(View view) {
            int a;
            int size = this.f1986l.size();
            View view2 = null;
            int i2 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.f1986l.get(i3).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a = (pVar.a() - this.f1978d) * this.f1979e) >= 0 && a < i2) {
                    view2 = view3;
                    if (a == 0) {
                        break;
                    }
                    i2 = a;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f1987b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1988c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d() {
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.f1987b);
            parcel.writeInt(this.f1988c ? 1 : 0);
        }

        d(Parcel parcel) {
            this.a = parcel.readInt();
            this.f1987b = parcel.readInt();
            this.f1988c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.a = dVar.a;
            this.f1987b = dVar.f1987b;
            this.f1988c = dVar.f1988c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void C2(RecyclerView.v vVar, RecyclerView.b0 b0Var, int i2, int i3) {
        if (!b0Var.g() || T() == 0 || b0Var.e() || !S1()) {
            return;
        }
        List<RecyclerView.e0> k2 = vVar.k();
        int size = k2.size();
        int m0 = m0(S(0));
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView.e0 e0Var = k2.get(i6);
            if (!e0Var.isRemoved()) {
                if ((e0Var.getLayoutPosition() < m0) != this.B ? true : true) {
                    i4 += this.y.e(e0Var.itemView);
                } else {
                    i5 += this.y.e(e0Var.itemView);
                }
            }
        }
        this.x.f1986l = k2;
        if (i4 > 0) {
            U2(m0(w2()), i2);
            c cVar = this.x;
            cVar.f1982h = i4;
            cVar.f1977c = 0;
            cVar.a();
            b2(vVar, this.x, b0Var, false);
        }
        if (i5 > 0) {
            S2(m0(v2()), i3);
            c cVar2 = this.x;
            cVar2.f1982h = i5;
            cVar2.f1977c = 0;
            cVar2.a();
            b2(vVar, this.x, b0Var, false);
        }
        this.x.f1986l = null;
    }

    private void E2(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i2 = cVar.f1981g;
        int i3 = cVar.f1983i;
        if (cVar.f1980f == -1) {
            G2(vVar, i2, i3);
        } else {
            H2(vVar, i2, i3);
        }
    }

    private void F2(RecyclerView.v vVar, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                u1(i2, vVar);
                i2--;
            }
            return;
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            u1(i4, vVar);
        }
    }

    private void G2(RecyclerView.v vVar, int i2, int i3) {
        int T = T();
        if (i2 < 0) {
            return;
        }
        int h2 = (this.y.h() - i2) + i3;
        if (this.B) {
            for (int i4 = 0; i4 < T; i4++) {
                View S = S(i4);
                if (this.y.g(S) < h2 || this.y.q(S) < h2) {
                    F2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = T - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View S2 = S(i6);
            if (this.y.g(S2) < h2 || this.y.q(S2) < h2) {
                F2(vVar, i5, i6);
                return;
            }
        }
    }

    private void H2(RecyclerView.v vVar, int i2, int i3) {
        if (i2 < 0) {
            return;
        }
        int i4 = i2 - i3;
        int T = T();
        if (!this.B) {
            for (int i5 = 0; i5 < T; i5++) {
                View S = S(i5);
                if (this.y.d(S) > i4 || this.y.p(S) > i4) {
                    F2(vVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = T - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View S2 = S(i7);
            if (this.y.d(S2) > i4 || this.y.p(S2) > i4) {
                F2(vVar, i6, i7);
                return;
            }
        }
    }

    private void J2() {
        if (this.w != 1 && z2()) {
            this.B = !this.A;
        } else {
            this.B = this.A;
        }
    }

    private boolean O2(RecyclerView.v vVar, RecyclerView.b0 b0Var, a aVar) {
        View s2;
        int m;
        boolean z = false;
        if (T() == 0) {
            return false;
        }
        View f0 = f0();
        if (f0 != null && aVar.d(f0, b0Var)) {
            aVar.c(f0, m0(f0));
            return true;
        } else if (this.z != this.C) {
            return false;
        } else {
            if (aVar.f1971d) {
                s2 = r2(vVar, b0Var);
            } else {
                s2 = s2(vVar, b0Var);
            }
            if (s2 != null) {
                aVar.b(s2, m0(s2));
                if (!b0Var.e() && S1()) {
                    if (this.y.g(s2) >= this.y.i() || this.y.d(s2) < this.y.m()) {
                        z = true;
                    }
                    if (z) {
                        if (aVar.f1971d) {
                            m = this.y.i();
                        } else {
                            m = this.y.m();
                        }
                        aVar.f1970c = m;
                    }
                }
                return true;
            }
            return false;
        }
    }

    private boolean P2(RecyclerView.b0 b0Var, a aVar) {
        int i2;
        int g2;
        if (!b0Var.e() && (i2 = this.E) != -1) {
            if (i2 >= 0 && i2 < b0Var.b()) {
                aVar.f1969b = this.E;
                d dVar = this.H;
                if (dVar != null && dVar.a()) {
                    boolean z = this.H.f1988c;
                    aVar.f1971d = z;
                    if (z) {
                        aVar.f1970c = this.y.i() - this.H.f1987b;
                    } else {
                        aVar.f1970c = this.y.m() + this.H.f1987b;
                    }
                    return true;
                } else if (this.F == Integer.MIN_VALUE) {
                    View M = M(this.E);
                    if (M != null) {
                        if (this.y.e(M) > this.y.n()) {
                            aVar.a();
                            return true;
                        } else if (this.y.g(M) - this.y.m() < 0) {
                            aVar.f1970c = this.y.m();
                            aVar.f1971d = false;
                            return true;
                        } else if (this.y.i() - this.y.d(M) < 0) {
                            aVar.f1970c = this.y.i();
                            aVar.f1971d = true;
                            return true;
                        } else {
                            if (aVar.f1971d) {
                                g2 = this.y.d(M) + this.y.o();
                            } else {
                                g2 = this.y.g(M);
                            }
                            aVar.f1970c = g2;
                        }
                    } else {
                        if (T() > 0) {
                            aVar.f1971d = (this.E < m0(S(0))) == this.B;
                        }
                        aVar.a();
                    }
                    return true;
                } else {
                    boolean z2 = this.B;
                    aVar.f1971d = z2;
                    if (z2) {
                        aVar.f1970c = this.y.i() - this.F;
                    } else {
                        aVar.f1970c = this.y.m() + this.F;
                    }
                    return true;
                }
            }
            this.E = -1;
            this.F = Integer.MIN_VALUE;
        }
        return false;
    }

    private void Q2(RecyclerView.v vVar, RecyclerView.b0 b0Var, a aVar) {
        if (P2(b0Var, aVar) || O2(vVar, b0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1969b = this.C ? b0Var.b() - 1 : 0;
    }

    private void R2(int i2, int i3, boolean z, RecyclerView.b0 b0Var) {
        int m;
        this.x.m = I2();
        this.x.f1980f = i2;
        int[] iArr = this.L;
        iArr[0] = 0;
        iArr[1] = 0;
        T1(b0Var, iArr);
        int max = Math.max(0, this.L[0]);
        int max2 = Math.max(0, this.L[1]);
        boolean z2 = i2 == 1;
        c cVar = this.x;
        int i4 = z2 ? max2 : max;
        cVar.f1982h = i4;
        if (!z2) {
            max = max2;
        }
        cVar.f1983i = max;
        if (z2) {
            cVar.f1982h = i4 + this.y.j();
            View v2 = v2();
            c cVar2 = this.x;
            cVar2.f1979e = this.B ? -1 : 1;
            int m0 = m0(v2);
            c cVar3 = this.x;
            cVar2.f1978d = m0 + cVar3.f1979e;
            cVar3.f1976b = this.y.d(v2);
            m = this.y.d(v2) - this.y.i();
        } else {
            View w2 = w2();
            this.x.f1982h += this.y.m();
            c cVar4 = this.x;
            cVar4.f1979e = this.B ? 1 : -1;
            int m02 = m0(w2);
            c cVar5 = this.x;
            cVar4.f1978d = m02 + cVar5.f1979e;
            cVar5.f1976b = this.y.g(w2);
            m = (-this.y.g(w2)) + this.y.m();
        }
        c cVar6 = this.x;
        cVar6.f1977c = i3;
        if (z) {
            cVar6.f1977c = i3 - m;
        }
        cVar6.f1981g = m;
    }

    private void S2(int i2, int i3) {
        this.x.f1977c = this.y.i() - i3;
        c cVar = this.x;
        cVar.f1979e = this.B ? -1 : 1;
        cVar.f1978d = i2;
        cVar.f1980f = 1;
        cVar.f1976b = i3;
        cVar.f1981g = Integer.MIN_VALUE;
    }

    private void T2(a aVar) {
        S2(aVar.f1969b, aVar.f1970c);
    }

    private void U2(int i2, int i3) {
        this.x.f1977c = i3 - this.y.m();
        c cVar = this.x;
        cVar.f1978d = i2;
        cVar.f1979e = this.B ? 1 : -1;
        cVar.f1980f = -1;
        cVar.f1976b = i3;
        cVar.f1981g = Integer.MIN_VALUE;
    }

    private int V1(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        a2();
        return r.a(b0Var, this.y, g2(!this.D, true), f2(!this.D, true), this, this.D);
    }

    private void V2(a aVar) {
        U2(aVar.f1969b, aVar.f1970c);
    }

    private int W1(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        a2();
        return r.b(b0Var, this.y, g2(!this.D, true), f2(!this.D, true), this, this.D, this.B);
    }

    private int X1(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        a2();
        return r.c(b0Var, this.y, g2(!this.D, true), f2(!this.D, true), this, this.D);
    }

    private View d2() {
        return m2(0, T());
    }

    private View e2(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        return q2(vVar, b0Var, 0, T(), b0Var.b());
    }

    private View j2() {
        return m2(T() - 1, -1);
    }

    private View k2(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        return q2(vVar, b0Var, T() - 1, -1, b0Var.b());
    }

    private View o2() {
        return this.B ? d2() : j2();
    }

    private View p2() {
        return this.B ? j2() : d2();
    }

    private View r2(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        return this.B ? e2(vVar, b0Var) : k2(vVar, b0Var);
    }

    private View s2(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        return this.B ? k2(vVar, b0Var) : e2(vVar, b0Var);
    }

    private int t2(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var, boolean z) {
        int i3;
        int i4 = this.y.i() - i2;
        if (i4 > 0) {
            int i5 = -K2(-i4, vVar, b0Var);
            int i6 = i2 + i5;
            if (!z || (i3 = this.y.i() - i6) <= 0) {
                return i5;
            }
            this.y.r(i3);
            return i3 + i5;
        }
        return 0;
    }

    private int u2(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var, boolean z) {
        int m;
        int m2 = i2 - this.y.m();
        if (m2 > 0) {
            int i3 = -K2(m2, vVar, b0Var);
            int i4 = i2 + i3;
            if (!z || (m = i4 - this.y.m()) <= 0) {
                return i3;
            }
            this.y.r(-m);
            return i3 - m;
        }
        return 0;
    }

    private View v2() {
        return S(this.B ? 0 : T() - 1);
    }

    private View w2() {
        return S(this.B ? T() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.b0 b0Var) {
        return V1(b0Var);
    }

    public boolean A2() {
        return this.D;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        return W1(b0Var);
    }

    void B2(RecyclerView.v vVar, RecyclerView.b0 b0Var, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int f2;
        View d2 = cVar.d(vVar);
        if (d2 == null) {
            bVar.f1973b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d2.getLayoutParams();
        if (cVar.f1986l == null) {
            if (this.B == (cVar.f1980f == -1)) {
                n(d2);
            } else {
                o(d2, 0);
            }
        } else {
            if (this.B == (cVar.f1980f == -1)) {
                l(d2);
            } else {
                m(d2, 0);
            }
        }
        G0(d2, 0, 0);
        bVar.a = this.y.e(d2);
        if (this.w == 1) {
            if (z2()) {
                f2 = t0() - getPaddingRight();
                i5 = f2 - this.y.f(d2);
            } else {
                i5 = getPaddingLeft();
                f2 = this.y.f(d2) + i5;
            }
            if (cVar.f1980f == -1) {
                int i6 = cVar.f1976b;
                i4 = i6;
                i3 = f2;
                i2 = i6 - bVar.a;
            } else {
                int i7 = cVar.f1976b;
                i2 = i7;
                i3 = f2;
                i4 = bVar.a + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f3 = this.y.f(d2) + paddingTop;
            if (cVar.f1980f == -1) {
                int i8 = cVar.f1976b;
                i3 = i8;
                i2 = paddingTop;
                i4 = f3;
                i5 = i8 - bVar.a;
            } else {
                int i9 = cVar.f1976b;
                i2 = paddingTop;
                i3 = bVar.a + i9;
                i4 = f3;
                i5 = i9;
            }
        }
        F0(d2, i5, i2, i3, i4);
        if (pVar.c() || pVar.b()) {
            bVar.f1974c = true;
        }
        bVar.f1975d = d2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        return X1(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        return V1(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (this.w == 1) {
            return 0;
        }
        return K2(i2, vVar, b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D2(RecyclerView.v vVar, RecyclerView.b0 b0Var, a aVar, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        return W1(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void E1(int i2) {
        this.E = i2;
        this.F = Integer.MIN_VALUE;
        d dVar = this.H;
        if (dVar != null) {
            dVar.b();
        }
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        return X1(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (this.w == 0) {
            return 0;
        }
        return K2(i2, vVar, b0Var);
    }

    boolean I2() {
        return this.y.k() == 0 && this.y.h() == 0;
    }

    int K2(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (T() == 0 || i2 == 0) {
            return 0;
        }
        a2();
        this.x.a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        R2(i3, abs, true, b0Var);
        c cVar = this.x;
        int b2 = cVar.f1981g + b2(vVar, cVar, b0Var, false);
        if (b2 < 0) {
            return 0;
        }
        if (abs > b2) {
            i2 = i3 * b2;
        }
        this.y.r(-i2);
        this.x.f1985k = i2;
        return i2;
    }

    public void L2(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i2);
        }
        q(null);
        if (i2 != this.w || this.y == null) {
            p b2 = p.b(this, i2);
            this.y = b2;
            this.I.a = b2;
            this.w = i2;
            A1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View M(int i2) {
        int T = T();
        if (T == 0) {
            return null;
        }
        int m0 = i2 - m0(S(0));
        if (m0 >= 0 && m0 < T) {
            View S = S(m0);
            if (m0(S) == i2) {
                return S;
            }
        }
        return super.M(i2);
    }

    public void M2(boolean z) {
        q(null);
        if (z == this.A) {
            return;
        }
        this.A = z;
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean N1() {
        return (h0() == 1073741824 || u0() == 1073741824 || !v0()) ? false : true;
    }

    public void N2(boolean z) {
        q(null);
        if (this.C == z) {
            return;
        }
        this.C = z;
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.O0(recyclerView, vVar);
        if (this.G) {
            r1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View P0(View view, int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        int Y1;
        View o2;
        View v2;
        J2();
        if (T() == 0 || (Y1 = Y1(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        a2();
        R2(Y1, (int) (this.y.n() * 0.33333334f), false, b0Var);
        c cVar = this.x;
        cVar.f1981g = Integer.MIN_VALUE;
        cVar.a = false;
        b2(vVar, cVar, b0Var, true);
        if (Y1 == -1) {
            o2 = p2();
        } else {
            o2 = o2();
        }
        if (Y1 == -1) {
            v2 = w2();
        } else {
            v2 = v2();
        }
        if (v2.hasFocusable()) {
            if (o2 == null) {
                return null;
            }
            return v2;
        }
        return o2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P1(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i2) {
        l lVar = new l(recyclerView.getContext());
        lVar.p(i2);
        Q1(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(AccessibilityEvent accessibilityEvent) {
        super.Q0(accessibilityEvent);
        if (T() > 0) {
            accessibilityEvent.setFromIndex(h2());
            accessibilityEvent.setToIndex(l2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean S1() {
        return this.H == null && this.z == this.C;
    }

    protected void T1(RecyclerView.b0 b0Var, int[] iArr) {
        int i2;
        int x2 = x2(b0Var);
        if (this.x.f1980f == -1) {
            i2 = 0;
        } else {
            i2 = x2;
            x2 = 0;
        }
        iArr[0] = x2;
        iArr[1] = i2;
    }

    void U1(RecyclerView.b0 b0Var, c cVar, RecyclerView.o.c cVar2) {
        int i2 = cVar.f1978d;
        if (i2 < 0 || i2 >= b0Var.b()) {
            return;
        }
        cVar2.a(i2, Math.max(0, cVar.f1981g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Y1(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && z2()) ? -1 : 1 : (this.w != 1 && z2()) ? 1 : -1;
    }

    c Z1() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0.b
    public PointF a(int i2) {
        if (T() == 0) {
            return null;
        }
        int i3 = (i2 < m0(S(0))) != this.B ? -1 : 1;
        if (this.w == 0) {
            return new PointF(i3, 0.0f);
        }
        return new PointF(0.0f, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a2() {
        if (this.x == null) {
            this.x = Z1();
        }
    }

    int b2(RecyclerView.v vVar, c cVar, RecyclerView.b0 b0Var, boolean z) {
        int i2 = cVar.f1977c;
        int i3 = cVar.f1981g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f1981g = i3 + i2;
            }
            E2(vVar, cVar);
        }
        int i4 = cVar.f1977c + cVar.f1982h;
        b bVar = this.J;
        while (true) {
            if ((!cVar.m && i4 <= 0) || !cVar.c(b0Var)) {
                break;
            }
            bVar.a();
            B2(vVar, b0Var, cVar, bVar);
            if (!bVar.f1973b) {
                cVar.f1976b += bVar.a * cVar.f1980f;
                if (!bVar.f1974c || cVar.f1986l != null || !b0Var.e()) {
                    int i5 = cVar.f1977c;
                    int i6 = bVar.a;
                    cVar.f1977c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.f1981g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + bVar.a;
                    cVar.f1981g = i8;
                    int i9 = cVar.f1977c;
                    if (i9 < 0) {
                        cVar.f1981g = i8 + i9;
                    }
                    E2(vVar, cVar);
                }
                if (z && bVar.f1975d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f1977c;
    }

    public int c2() {
        View n2 = n2(0, T(), true, false);
        if (n2 == null) {
            return -1;
        }
        return m0(n2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        int t2;
        int i6;
        View M;
        int g2;
        int i7;
        int i8 = -1;
        if ((this.H != null || this.E != -1) && b0Var.b() == 0) {
            r1(vVar);
            return;
        }
        d dVar = this.H;
        if (dVar != null && dVar.a()) {
            this.E = this.H.a;
        }
        a2();
        this.x.a = false;
        J2();
        View f0 = f0();
        a aVar = this.I;
        if (aVar.f1972e && this.E == -1 && this.H == null) {
            if (f0 != null && (this.y.g(f0) >= this.y.i() || this.y.d(f0) <= this.y.m())) {
                this.I.c(f0, m0(f0));
            }
        } else {
            aVar.e();
            a aVar2 = this.I;
            aVar2.f1971d = this.B ^ this.C;
            Q2(vVar, b0Var, aVar2);
            this.I.f1972e = true;
        }
        c cVar = this.x;
        cVar.f1980f = cVar.f1985k >= 0 ? 1 : -1;
        int[] iArr = this.L;
        iArr[0] = 0;
        iArr[1] = 0;
        T1(b0Var, iArr);
        int max = Math.max(0, this.L[0]) + this.y.m();
        int max2 = Math.max(0, this.L[1]) + this.y.j();
        if (b0Var.e() && (i6 = this.E) != -1 && this.F != Integer.MIN_VALUE && (M = M(i6)) != null) {
            if (this.B) {
                i7 = this.y.i() - this.y.d(M);
                g2 = this.F;
            } else {
                g2 = this.y.g(M) - this.y.m();
                i7 = this.F;
            }
            int i9 = i7 - g2;
            if (i9 > 0) {
                max += i9;
            } else {
                max2 -= i9;
            }
        }
        a aVar3 = this.I;
        if (!aVar3.f1971d ? !this.B : this.B) {
            i8 = 1;
        }
        D2(vVar, b0Var, aVar3, i8);
        G(vVar);
        this.x.m = I2();
        this.x.f1984j = b0Var.e();
        this.x.f1983i = 0;
        a aVar4 = this.I;
        if (aVar4.f1971d) {
            V2(aVar4);
            c cVar2 = this.x;
            cVar2.f1982h = max;
            b2(vVar, cVar2, b0Var, false);
            c cVar3 = this.x;
            i3 = cVar3.f1976b;
            int i10 = cVar3.f1978d;
            int i11 = cVar3.f1977c;
            if (i11 > 0) {
                max2 += i11;
            }
            T2(this.I);
            c cVar4 = this.x;
            cVar4.f1982h = max2;
            cVar4.f1978d += cVar4.f1979e;
            b2(vVar, cVar4, b0Var, false);
            c cVar5 = this.x;
            i2 = cVar5.f1976b;
            int i12 = cVar5.f1977c;
            if (i12 > 0) {
                U2(i10, i3);
                c cVar6 = this.x;
                cVar6.f1982h = i12;
                b2(vVar, cVar6, b0Var, false);
                i3 = this.x.f1976b;
            }
        } else {
            T2(aVar4);
            c cVar7 = this.x;
            cVar7.f1982h = max2;
            b2(vVar, cVar7, b0Var, false);
            c cVar8 = this.x;
            i2 = cVar8.f1976b;
            int i13 = cVar8.f1978d;
            int i14 = cVar8.f1977c;
            if (i14 > 0) {
                max += i14;
            }
            V2(this.I);
            c cVar9 = this.x;
            cVar9.f1982h = max;
            cVar9.f1978d += cVar9.f1979e;
            b2(vVar, cVar9, b0Var, false);
            c cVar10 = this.x;
            i3 = cVar10.f1976b;
            int i15 = cVar10.f1977c;
            if (i15 > 0) {
                S2(i13, i2);
                c cVar11 = this.x;
                cVar11.f1982h = i15;
                b2(vVar, cVar11, b0Var, false);
                i2 = this.x.f1976b;
            }
        }
        if (T() > 0) {
            if (this.B ^ this.C) {
                int t22 = t2(i2, vVar, b0Var, true);
                i4 = i3 + t22;
                i5 = i2 + t22;
                t2 = u2(i4, vVar, b0Var, false);
            } else {
                int u2 = u2(i3, vVar, b0Var, true);
                i4 = i3 + u2;
                i5 = i2 + u2;
                t2 = t2(i5, vVar, b0Var, false);
            }
            i3 = i4 + t2;
            i2 = i5 + t2;
        }
        C2(vVar, b0Var, i3, i2);
        if (!b0Var.e()) {
            this.y.s();
        } else {
            this.I.e();
        }
        this.z = this.C;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.b0 b0Var) {
        super.e1(b0Var);
        this.H = null;
        this.E = -1;
        this.F = Integer.MIN_VALUE;
        this.I.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f2(boolean z, boolean z2) {
        if (this.B) {
            return n2(0, T(), z, z2);
        }
        return n2(T() - 1, -1, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View g2(boolean z, boolean z2) {
        if (this.B) {
            return n2(T() - 1, -1, z, z2);
        }
        return n2(0, T(), z, z2);
    }

    public int h2() {
        View n2 = n2(0, T(), false, true);
        if (n2 == null) {
            return -1;
        }
        return m0(n2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.H = (d) parcelable;
            A1();
        }
    }

    public int i2() {
        View n2 = n2(T() - 1, -1, true, false);
        if (n2 == null) {
            return -1;
        }
        return m0(n2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable j1() {
        if (this.H != null) {
            return new d(this.H);
        }
        d dVar = new d();
        if (T() > 0) {
            a2();
            boolean z = this.z ^ this.B;
            dVar.f1988c = z;
            if (z) {
                View v2 = v2();
                dVar.f1987b = this.y.i() - this.y.d(v2);
                dVar.a = m0(v2);
            } else {
                View w2 = w2();
                dVar.a = m0(w2);
                dVar.f1987b = this.y.g(w2) - this.y.m();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    public int l2() {
        View n2 = n2(T() - 1, -1, false, true);
        if (n2 == null) {
            return -1;
        }
        return m0(n2);
    }

    View m2(int i2, int i3) {
        int i4;
        int i5;
        a2();
        if ((i3 > i2 ? (char) 1 : i3 < i2 ? (char) 65535 : (char) 0) == 0) {
            return S(i2);
        }
        if (this.y.g(S(i2)) < this.y.m()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        if (this.w == 0) {
            return this.f2030e.a(i2, i3, i4, i5);
        }
        return this.f2031f.a(i2, i3, i4, i5);
    }

    View n2(int i2, int i3, boolean z, boolean z2) {
        a2();
        int i4 = z ? 24579 : 320;
        int i5 = z2 ? 320 : 0;
        if (this.w == 0) {
            return this.f2030e.a(i2, i3, i4, i5);
        }
        return this.f2031f.a(i2, i3, i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q(String str) {
        if (this.H == null) {
            super.q(str);
        }
    }

    View q2(RecyclerView.v vVar, RecyclerView.b0 b0Var, int i2, int i3, int i4) {
        a2();
        int m = this.y.m();
        int i5 = this.y.i();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View S = S(i2);
            int m0 = m0(S);
            if (m0 >= 0 && m0 < i4) {
                if (((RecyclerView.p) S.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = S;
                    }
                } else if (this.y.g(S) < i5 && this.y.d(S) >= m) {
                    return S;
                } else {
                    if (view == null) {
                        view = S;
                    }
                }
            }
            i2 += i6;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x0() {
        return true;
    }

    @Deprecated
    protected int x2(RecyclerView.b0 b0Var) {
        if (b0Var.d()) {
            return this.y.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y(int i2, int i3, RecyclerView.b0 b0Var, RecyclerView.o.c cVar) {
        if (this.w != 0) {
            i2 = i3;
        }
        if (T() == 0 || i2 == 0) {
            return;
        }
        a2();
        R2(i2 > 0 ? 1 : -1, Math.abs(i2), true, b0Var);
        U1(b0Var, this.x, cVar);
    }

    public int y2() {
        return this.w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void z(int i2, RecyclerView.o.c cVar) {
        boolean z;
        int i3;
        d dVar = this.H;
        if (dVar != null && dVar.a()) {
            d dVar2 = this.H;
            z = dVar2.f1988c;
            i3 = dVar2.a;
        } else {
            J2();
            z = this.B;
            i3 = this.E;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        }
        int i4 = z ? -1 : 1;
        for (int i5 = 0; i5 < this.K && i3 >= 0 && i3 < i2; i5++) {
            cVar.a(i3, 0);
            i3 += i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z2() {
        return i0() == 1;
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.w = 1;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.E = -1;
        this.F = Integer.MIN_VALUE;
        this.H = null;
        this.I = new a();
        this.J = new b();
        this.K = 2;
        this.L = new int[2];
        L2(i2);
        M2(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.w = 1;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.E = -1;
        this.F = Integer.MIN_VALUE;
        this.H = null;
        this.I = new a();
        this.J = new b();
        this.K = 2;
        this.L = new int[2];
        RecyclerView.o.d n0 = RecyclerView.o.n0(context, attributeSet, i2, i3);
        L2(n0.a);
        M2(n0.f2038c);
        N2(n0.f2039d);
    }
}