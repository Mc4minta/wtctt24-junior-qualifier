package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.e0.d;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean M;
    int N;
    int[] O;
    View[] P;
    final SparseIntArray Q;
    final SparseIntArray R;
    c S;
    final Rect T;
    private boolean U;

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i2, int i3) {
            return i2 % i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i2) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        final SparseIntArray a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f1966b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f1967c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1968d = false;

        static int a(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        int b(int i2, int i3) {
            if (!this.f1968d) {
                return d(i2, i3);
            }
            int i4 = this.f1966b.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int d2 = d(i2, i3);
            this.f1966b.put(i2, d2);
            return d2;
        }

        int c(int i2, int i3) {
            if (!this.f1967c) {
                return e(i2, i3);
            }
            int i4 = this.a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int e2 = e(i2, i3);
            this.a.put(i2, e2);
            return e2;
        }

        public int d(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int a;
            if (!this.f1968d || (a = a(this.f1966b, i2)) == -1) {
                i4 = 0;
                i5 = 0;
                i6 = 0;
            } else {
                i4 = this.f1966b.get(a);
                i5 = a + 1;
                i6 = c(a, i3) + f(a);
                if (i6 == i3) {
                    i4++;
                    i6 = 0;
                }
            }
            int f2 = f(i2);
            while (i5 < i2) {
                int f3 = f(i5);
                i6 += f3;
                if (i6 == i3) {
                    i4++;
                    i6 = 0;
                } else if (i6 > i3) {
                    i4++;
                    i6 = f3;
                }
                i5++;
            }
            return i6 + f2 > i3 ? i4 + 1 : i4;
        }

        public abstract int e(int i2, int i3);

        public abstract int f(int i2);

        public void g() {
            this.f1966b.clear();
        }

        public void h() {
            this.a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.M = false;
        this.N = -1;
        this.Q = new SparseIntArray();
        this.R = new SparseIntArray();
        this.S = new a();
        this.T = new Rect();
        n3(RecyclerView.o.n0(context, attributeSet, i2, i3).f2037b);
    }

    private void W2(RecyclerView.v vVar, RecyclerView.b0 b0Var, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i4 = 1;
            i6 = i2;
            i3 = 0;
        } else {
            i3 = i2 - 1;
            i4 = -1;
        }
        while (i3 != i6) {
            View view = this.P[i3];
            b bVar = (b) view.getLayoutParams();
            int j3 = j3(vVar, b0Var, m0(view));
            bVar.f1965f = j3;
            bVar.f1964e = i5;
            i5 += j3;
            i3 += i4;
        }
    }

    private void X2() {
        int T = T();
        for (int i2 = 0; i2 < T; i2++) {
            b bVar = (b) S(i2).getLayoutParams();
            int a2 = bVar.a();
            this.Q.put(a2, bVar.f());
            this.R.put(a2, bVar.e());
        }
    }

    private void Y2(int i2) {
        this.O = Z2(this.O, this.N, i2);
    }

    static int[] Z2(int[] iArr, int i2, int i3) {
        int i4;
        if (iArr == null || iArr.length != i2 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i2 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private void a3() {
        this.Q.clear();
        this.R.clear();
    }

    private int b3(RecyclerView.b0 b0Var) {
        int max;
        if (T() != 0 && b0Var.b() != 0) {
            a2();
            boolean A2 = A2();
            View g2 = g2(!A2, true);
            View f2 = f2(!A2, true);
            if (g2 != null && f2 != null) {
                int b2 = this.S.b(m0(g2), this.N);
                int b3 = this.S.b(m0(f2), this.N);
                int min = Math.min(b2, b3);
                int max2 = Math.max(b2, b3);
                int b4 = this.S.b(b0Var.b() - 1, this.N) + 1;
                if (this.B) {
                    max = Math.max(0, (b4 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (A2) {
                    return Math.round((max * (Math.abs(this.y.d(f2) - this.y.g(g2)) / ((this.S.b(m0(f2), this.N) - this.S.b(m0(g2), this.N)) + 1))) + (this.y.m() - this.y.g(g2)));
                }
                return max;
            }
        }
        return 0;
    }

    private int c3(RecyclerView.b0 b0Var) {
        if (T() != 0 && b0Var.b() != 0) {
            a2();
            View g2 = g2(!A2(), true);
            View f2 = f2(!A2(), true);
            if (g2 != null && f2 != null) {
                if (!A2()) {
                    return this.S.b(b0Var.b() - 1, this.N) + 1;
                }
                int d2 = this.y.d(f2) - this.y.g(g2);
                int b2 = this.S.b(m0(g2), this.N);
                return (int) ((d2 / ((this.S.b(m0(f2), this.N) - b2) + 1)) * (this.S.b(b0Var.b() - 1, this.N) + 1));
            }
        }
        return 0;
    }

    private void d3(RecyclerView.v vVar, RecyclerView.b0 b0Var, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int i3 = i3(vVar, b0Var, aVar.f1969b);
        if (z) {
            while (i3 > 0) {
                int i4 = aVar.f1969b;
                if (i4 <= 0) {
                    return;
                }
                int i5 = i4 - 1;
                aVar.f1969b = i5;
                i3 = i3(vVar, b0Var, i5);
            }
            return;
        }
        int b2 = b0Var.b() - 1;
        int i6 = aVar.f1969b;
        while (i6 < b2) {
            int i7 = i6 + 1;
            int i32 = i3(vVar, b0Var, i7);
            if (i32 <= i3) {
                break;
            }
            i6 = i7;
            i3 = i32;
        }
        aVar.f1969b = i6;
    }

    private void e3() {
        View[] viewArr = this.P;
        if (viewArr == null || viewArr.length != this.N) {
            this.P = new View[this.N];
        }
    }

    private int h3(RecyclerView.v vVar, RecyclerView.b0 b0Var, int i2) {
        if (!b0Var.e()) {
            return this.S.b(i2, this.N);
        }
        int f2 = vVar.f(i2);
        if (f2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
            return 0;
        }
        return this.S.b(f2, this.N);
    }

    private int i3(RecyclerView.v vVar, RecyclerView.b0 b0Var, int i2) {
        if (!b0Var.e()) {
            return this.S.c(i2, this.N);
        }
        int i3 = this.R.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = vVar.f(i2);
        if (f2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 0;
        }
        return this.S.c(f2, this.N);
    }

    private int j3(RecyclerView.v vVar, RecyclerView.b0 b0Var, int i2) {
        if (!b0Var.e()) {
            return this.S.f(i2);
        }
        int i3 = this.Q.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = vVar.f(i2);
        if (f2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 1;
        }
        return this.S.f(f2);
    }

    private void k3(float f2, int i2) {
        Y2(Math.max(Math.round(f2 * this.N), i2));
    }

    private void l3(View view, int i2, boolean z) {
        int i3;
        int i4;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f2040b;
        int i5 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i6 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int f3 = f3(bVar.f1964e, bVar.f1965f);
        if (this.w == 1) {
            i4 = RecyclerView.o.U(f3, i2, i6, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i3 = RecyclerView.o.U(this.y.n(), h0(), i5, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int U = RecyclerView.o.U(f3, i2, i5, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int U2 = RecyclerView.o.U(this.y.n(), u0(), i6, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i3 = U;
            i4 = U2;
        }
        m3(view, i4, i3, z);
    }

    private void m3(View view, int i2, int i3, boolean z) {
        boolean M1;
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z) {
            M1 = O1(view, i2, i3, pVar);
        } else {
            M1 = M1(view, i2, i3, pVar);
        }
        if (M1) {
            view.measure(i2, i3);
        }
    }

    private void o3() {
        int g0;
        int paddingTop;
        if (y2() == 1) {
            g0 = t0() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            g0 = g0() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        Y2(g0 - paddingTop);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        if (this.U) {
            return b3(b0Var);
        }
        return super.B(b0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r21.f1973b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void B2(androidx.recyclerview.widget.RecyclerView.v r18, androidx.recyclerview.widget.RecyclerView.b0 r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.B2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$b0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        if (this.U) {
            return c3(b0Var);
        }
        return super.C(b0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int D1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        o3();
        e3();
        return super.D1(i2, vVar, b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void D2(RecyclerView.v vVar, RecyclerView.b0 b0Var, LinearLayoutManager.a aVar, int i2) {
        super.D2(vVar, b0Var, aVar, i2);
        o3();
        if (b0Var.b() > 0 && !b0Var.e()) {
            d3(vVar, b0Var, aVar, i2);
        }
        e3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        if (this.U) {
            return b3(b0Var);
        }
        return super.E(b0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        if (this.U) {
            return c3(b0Var);
        }
        return super.F(b0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int F1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        o3();
        e3();
        return super.F1(i2, vVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J1(Rect rect, int i2, int i3) {
        int x;
        int x2;
        if (this.O == null) {
            super.J1(rect, i2, i3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.w == 1) {
            x2 = RecyclerView.o.x(i3, rect.height() + paddingTop, k0());
            int[] iArr = this.O;
            x = RecyclerView.o.x(i2, iArr[iArr.length - 1] + paddingLeft, l0());
        } else {
            x = RecyclerView.o.x(i2, rect.width() + paddingLeft, l0());
            int[] iArr2 = this.O;
            x2 = RecyclerView.o.x(i3, iArr2[iArr2.length - 1] + paddingTop, k0());
        }
        I1(x, x2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        if (this.w == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void N2(boolean z) {
        if (!z) {
            super.N2(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p O(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p P(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f6, code lost:
        if (r13 == (r2 > r7)) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View P0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.b0 r27) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.P0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$b0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean S1() {
        return this.H == null && !this.M;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void U1(RecyclerView.b0 b0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i2 = this.N;
        for (int i3 = 0; i3 < this.N && cVar.c(b0Var) && i2 > 0; i3++) {
            int i4 = cVar.f1978d;
            cVar2.a(i4, Math.max(0, cVar.f1981g));
            i2 -= this.S.f(i4);
            cVar.f1978d += cVar.f1979e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView.v vVar, RecyclerView.b0 b0Var, View view, c.h.k.e0.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.U0(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int h3 = h3(vVar, b0Var, bVar.a());
        if (this.w == 0) {
            dVar.W(d.c.b(bVar.e(), bVar.f(), h3, 1, false, false));
        } else {
            dVar.W(d.c.b(h3, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int X(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (this.w == 1) {
            return this.N;
        }
        if (b0Var.b() < 1) {
            return 0;
        }
        return h3(vVar, b0Var, b0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i2, int i3) {
        this.S.h();
        this.S.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView recyclerView) {
        this.S.h();
        this.S.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.S.h();
        this.S.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i2, int i3) {
        this.S.h();
        this.S.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.S.h();
        this.S.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (b0Var.e()) {
            X2();
        }
        super.d1(vVar, b0Var);
        a3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.b0 b0Var) {
        super.e1(b0Var);
        this.M = false;
    }

    int f3(int i2, int i3) {
        if (this.w == 1 && z2()) {
            int[] iArr = this.O;
            int i4 = this.N;
            return iArr[i4 - i2] - iArr[(i4 - i2) - i3];
        }
        int[] iArr2 = this.O;
        return iArr2[i3 + i2] - iArr2[i2];
    }

    public int g3() {
        return this.N;
    }

    public void n3(int i2) {
        if (i2 == this.N) {
            return;
        }
        this.M = true;
        if (i2 >= 1) {
            this.N = i2;
            this.S.h();
            A1();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p0(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (this.w == 0) {
            return this.N;
        }
        if (b0Var.b() < 1) {
            return 0;
        }
        return h3(vVar, b0Var, b0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (m0 >= 0 && m0 < i4 && i3(vVar, b0Var, m0) == 0) {
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
    public boolean w(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        int f1964e;

        /* renamed from: f  reason: collision with root package name */
        int f1965f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1964e = -1;
            this.f1965f = 0;
        }

        public int e() {
            return this.f1964e;
        }

        public int f() {
            return this.f1965f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.f1964e = -1;
            this.f1965f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1964e = -1;
            this.f1965f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1964e = -1;
            this.f1965f = 0;
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        this.M = false;
        this.N = -1;
        this.Q = new SparseIntArray();
        this.R = new SparseIntArray();
        this.S = new a();
        this.T = new Rect();
        n3(i2);
    }
}