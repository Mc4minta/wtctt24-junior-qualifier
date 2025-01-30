package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.p;
import com.google.android.flexbox.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FlexboxLayoutManager extends RecyclerView.o implements com.google.android.flexbox.a, RecyclerView.a0.b {
    private static final Rect w = new Rect();
    private int A;
    private boolean C;
    private boolean D;
    private RecyclerView.v G;
    private RecyclerView.b0 H;
    private d I;
    private p K;
    private p L;
    private e M;
    private boolean R;
    private final Context T;
    private View U;
    private int x;
    private int y;
    private int z;
    private int B = -1;
    private List<com.google.android.flexbox.c> E = new ArrayList();
    private final com.google.android.flexbox.d F = new com.google.android.flexbox.d(this);
    private b J = new b();
    private int N = -1;
    private int O = Integer.MIN_VALUE;
    private int P = Integer.MIN_VALUE;
    private int Q = Integer.MIN_VALUE;
    private SparseArray<View> S = new SparseArray<>();
    private int V = -1;
    private d.b W = new d.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f5892b;

        /* renamed from: c  reason: collision with root package name */
        private int f5893c;

        /* renamed from: d  reason: collision with root package name */
        private int f5894d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5895e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5896f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5897g;

        private b() {
            this.f5894d = 0;
        }

        static /* synthetic */ int l(b bVar, int i2) {
            int i3 = bVar.f5894d + i2;
            bVar.f5894d = i3;
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            if (!FlexboxLayoutManager.this.j() && FlexboxLayoutManager.this.C) {
                this.f5893c = this.f5895e ? FlexboxLayoutManager.this.K.i() : FlexboxLayoutManager.this.t0() - FlexboxLayoutManager.this.K.m();
            } else {
                this.f5893c = this.f5895e ? FlexboxLayoutManager.this.K.i() : FlexboxLayoutManager.this.K.m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            p pVar = FlexboxLayoutManager.this.y == 0 ? FlexboxLayoutManager.this.L : FlexboxLayoutManager.this.K;
            if (!FlexboxLayoutManager.this.j() && FlexboxLayoutManager.this.C) {
                if (this.f5895e) {
                    this.f5893c = pVar.g(view) + pVar.o();
                } else {
                    this.f5893c = pVar.d(view);
                }
            } else if (this.f5895e) {
                this.f5893c = pVar.d(view) + pVar.o();
            } else {
                this.f5893c = pVar.g(view);
            }
            this.a = FlexboxLayoutManager.this.m0(view);
            this.f5897g = false;
            int[] iArr = FlexboxLayoutManager.this.F.f5928c;
            int i2 = this.a;
            if (i2 == -1) {
                i2 = 0;
            }
            int i3 = iArr[i2];
            this.f5892b = i3 != -1 ? i3 : 0;
            if (FlexboxLayoutManager.this.E.size() > this.f5892b) {
                this.a = ((com.google.android.flexbox.c) FlexboxLayoutManager.this.E.get(this.f5892b)).o;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            this.a = -1;
            this.f5892b = -1;
            this.f5893c = Integer.MIN_VALUE;
            this.f5896f = false;
            this.f5897g = false;
            if (FlexboxLayoutManager.this.j()) {
                if (FlexboxLayoutManager.this.y == 0) {
                    this.f5895e = FlexboxLayoutManager.this.x == 1;
                } else {
                    this.f5895e = FlexboxLayoutManager.this.y == 2;
                }
            } else if (FlexboxLayoutManager.this.y == 0) {
                this.f5895e = FlexboxLayoutManager.this.x == 3;
            } else {
                this.f5895e = FlexboxLayoutManager.this.y == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mFlexLinePosition=" + this.f5892b + ", mCoordinate=" + this.f5893c + ", mPerpendicularCoordinate=" + this.f5894d + ", mLayoutFromEnd=" + this.f5895e + ", mValid=" + this.f5896f + ", mAssignedFromSavedState=" + this.f5897g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5906b;

        /* renamed from: c  reason: collision with root package name */
        private int f5907c;

        /* renamed from: d  reason: collision with root package name */
        private int f5908d;

        /* renamed from: e  reason: collision with root package name */
        private int f5909e;

        /* renamed from: f  reason: collision with root package name */
        private int f5910f;

        /* renamed from: g  reason: collision with root package name */
        private int f5911g;

        /* renamed from: h  reason: collision with root package name */
        private int f5912h;

        /* renamed from: i  reason: collision with root package name */
        private int f5913i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f5914j;

        private d() {
            this.f5912h = 1;
            this.f5913i = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean D(RecyclerView.b0 b0Var, List<com.google.android.flexbox.c> list) {
            int i2;
            int i3 = this.f5908d;
            return i3 >= 0 && i3 < b0Var.b() && (i2 = this.f5907c) >= 0 && i2 < list.size();
        }

        static /* synthetic */ int c(d dVar, int i2) {
            int i3 = dVar.f5909e + i2;
            dVar.f5909e = i3;
            return i3;
        }

        static /* synthetic */ int d(d dVar, int i2) {
            int i3 = dVar.f5909e - i2;
            dVar.f5909e = i3;
            return i3;
        }

        static /* synthetic */ int i(d dVar, int i2) {
            int i3 = dVar.a - i2;
            dVar.a = i3;
            return i3;
        }

        static /* synthetic */ int l(d dVar) {
            int i2 = dVar.f5907c;
            dVar.f5907c = i2 + 1;
            return i2;
        }

        static /* synthetic */ int m(d dVar) {
            int i2 = dVar.f5907c;
            dVar.f5907c = i2 - 1;
            return i2;
        }

        static /* synthetic */ int n(d dVar, int i2) {
            int i3 = dVar.f5907c + i2;
            dVar.f5907c = i3;
            return i3;
        }

        static /* synthetic */ int q(d dVar, int i2) {
            int i3 = dVar.f5910f + i2;
            dVar.f5910f = i3;
            return i3;
        }

        static /* synthetic */ int u(d dVar, int i2) {
            int i3 = dVar.f5908d + i2;
            dVar.f5908d = i3;
            return i3;
        }

        static /* synthetic */ int v(d dVar, int i2) {
            int i3 = dVar.f5908d - i2;
            dVar.f5908d = i3;
            return i3;
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.a + ", mFlexLinePosition=" + this.f5907c + ", mPosition=" + this.f5908d + ", mOffset=" + this.f5909e + ", mScrollingOffset=" + this.f5910f + ", mLastScrollDelta=" + this.f5911g + ", mItemDirection=" + this.f5912h + ", mLayoutDirection=" + this.f5913i + '}';
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.d n0 = RecyclerView.o.n0(context, attributeSet, i2, i3);
        int i4 = n0.a;
        if (i4 != 0) {
            if (i4 == 1) {
                if (n0.f2038c) {
                    L2(3);
                } else {
                    L2(2);
                }
            }
        } else if (n0.f2038c) {
            L2(1);
        } else {
            L2(0);
        }
        M2(1);
        K2(4);
        this.T = context;
    }

    private boolean A2(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int t0 = t0() - getPaddingRight();
        int g0 = g0() - getPaddingBottom();
        int v2 = v2(view);
        int x2 = x2(view);
        int w2 = w2(view);
        int t2 = t2(view);
        return z ? (paddingLeft <= v2 && t0 >= w2) && (paddingTop <= x2 && g0 >= t2) : (v2 >= t0 || w2 >= paddingLeft) && (x2 >= g0 || t2 >= paddingTop);
    }

    private int B2(com.google.android.flexbox.c cVar, d dVar) {
        if (j()) {
            return C2(cVar, dVar);
        }
        return D2(cVar, dVar);
    }

    private static boolean C0(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 <= 0 || i2 == i4) {
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            } else if (mode != 0) {
                return mode == 1073741824 && size == i2;
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int C2(com.google.android.flexbox.c r22, com.google.android.flexbox.FlexboxLayoutManager.d r23) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.C2(com.google.android.flexbox.c, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int D2(com.google.android.flexbox.c r26, com.google.android.flexbox.FlexboxLayoutManager.d r27) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.D2(com.google.android.flexbox.c, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    private void E2(RecyclerView.v vVar, d dVar) {
        if (dVar.f5914j) {
            if (dVar.f5913i == -1) {
                G2(vVar, dVar);
            } else {
                H2(vVar, dVar);
            }
        }
    }

    private void F2(RecyclerView.v vVar, int i2, int i3) {
        while (i3 >= i2) {
            u1(i3, vVar);
            i3--;
        }
    }

    private void G2(RecyclerView.v vVar, d dVar) {
        int T;
        int i2;
        View S;
        int i3;
        if (dVar.f5910f < 0 || (T = T()) == 0 || (S = S(T - 1)) == null || (i3 = this.F.f5928c[m0(S)]) == -1) {
            return;
        }
        com.google.android.flexbox.c cVar = this.E.get(i3);
        int i4 = i2;
        while (true) {
            if (i4 < 0) {
                break;
            }
            View S2 = S(i4);
            if (S2 != null) {
                if (!a2(S2, dVar.f5910f)) {
                    break;
                } else if (cVar.o != m0(S2)) {
                    continue;
                } else if (i3 <= 0) {
                    T = i4;
                    break;
                } else {
                    i3 += dVar.f5913i;
                    cVar = this.E.get(i3);
                    T = i4;
                }
            }
            i4--;
        }
        F2(vVar, T, i2);
    }

    private void H2(RecyclerView.v vVar, d dVar) {
        int T;
        View S;
        if (dVar.f5910f < 0 || (T = T()) == 0 || (S = S(0)) == null) {
            return;
        }
        int i2 = this.F.f5928c[m0(S)];
        int i3 = -1;
        if (i2 == -1) {
            return;
        }
        com.google.android.flexbox.c cVar = this.E.get(i2);
        int i4 = 0;
        while (true) {
            if (i4 >= T) {
                break;
            }
            View S2 = S(i4);
            if (S2 != null) {
                if (!b2(S2, dVar.f5910f)) {
                    break;
                } else if (cVar.p != m0(S2)) {
                    continue;
                } else if (i2 >= this.E.size() - 1) {
                    i3 = i4;
                    break;
                } else {
                    i2 += dVar.f5913i;
                    cVar = this.E.get(i2);
                    i3 = i4;
                }
            }
            i4++;
        }
        F2(vVar, 0, i3);
    }

    private void I2() {
        int u0;
        if (j()) {
            u0 = h0();
        } else {
            u0 = u0();
        }
        this.I.f5906b = u0 == 0 || u0 == Integer.MIN_VALUE;
    }

    private void J2() {
        int i0 = i0();
        int i2 = this.x;
        if (i2 == 0) {
            this.C = i0 == 1;
            this.D = this.y == 2;
        } else if (i2 == 1) {
            this.C = i0 != 1;
            this.D = this.y == 2;
        } else if (i2 == 2) {
            boolean z = i0 == 1;
            this.C = z;
            if (this.y == 2) {
                this.C = !z;
            }
            this.D = false;
        } else if (i2 != 3) {
            this.C = false;
            this.D = false;
        } else {
            boolean z2 = i0 == 1;
            this.C = z2;
            if (this.y == 2) {
                this.C = !z2;
            }
            this.D = true;
        }
    }

    private boolean M1(View view, int i2, int i3, RecyclerView.p pVar) {
        return (!view.isLayoutRequested() && B0() && C0(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && C0(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
    }

    private boolean N2(RecyclerView.b0 b0Var, b bVar) {
        View j2;
        int m;
        boolean z = false;
        if (T() == 0) {
            return false;
        }
        if (bVar.f5895e) {
            j2 = m2(b0Var.b());
        } else {
            j2 = j2(b0Var.b());
        }
        if (j2 != null) {
            bVar.s(j2);
            if (!b0Var.e() && S1()) {
                if (this.K.g(j2) >= this.K.i() || this.K.d(j2) < this.K.m()) {
                    z = true;
                }
                if (z) {
                    if (bVar.f5895e) {
                        m = this.K.i();
                    } else {
                        m = this.K.m();
                    }
                    bVar.f5893c = m;
                }
            }
            return true;
        }
        return false;
    }

    private boolean O2(RecyclerView.b0 b0Var, b bVar, e eVar) {
        int i2;
        View S;
        int g2;
        if (!b0Var.e() && (i2 = this.N) != -1) {
            if (i2 >= 0 && i2 < b0Var.b()) {
                bVar.a = this.N;
                bVar.f5892b = this.F.f5928c[bVar.a];
                e eVar2 = this.M;
                if (eVar2 != null && eVar2.g(b0Var.b())) {
                    bVar.f5893c = this.K.m() + eVar.f5915b;
                    bVar.f5897g = true;
                    bVar.f5892b = -1;
                    return true;
                } else if (this.O == Integer.MIN_VALUE) {
                    View M = M(this.N);
                    if (M != null) {
                        if (this.K.e(M) > this.K.n()) {
                            bVar.r();
                            return true;
                        } else if (this.K.g(M) - this.K.m() < 0) {
                            bVar.f5893c = this.K.m();
                            bVar.f5895e = false;
                            return true;
                        } else if (this.K.i() - this.K.d(M) < 0) {
                            bVar.f5893c = this.K.i();
                            bVar.f5895e = true;
                            return true;
                        } else {
                            if (bVar.f5895e) {
                                g2 = this.K.d(M) + this.K.o();
                            } else {
                                g2 = this.K.g(M);
                            }
                            bVar.f5893c = g2;
                        }
                    } else {
                        if (T() > 0 && (S = S(0)) != null) {
                            bVar.f5895e = this.N < m0(S);
                        }
                        bVar.r();
                    }
                    return true;
                } else {
                    if (j() || !this.C) {
                        bVar.f5893c = this.K.m() + this.O;
                    } else {
                        bVar.f5893c = this.O - this.K.j();
                    }
                    return true;
                }
            }
            this.N = -1;
            this.O = Integer.MIN_VALUE;
        }
        return false;
    }

    private void P2(RecyclerView.b0 b0Var, b bVar) {
        if (O2(b0Var, bVar, this.M) || N2(b0Var, bVar)) {
            return;
        }
        bVar.r();
        bVar.a = 0;
        bVar.f5892b = 0;
    }

    private void Q2(int i2) {
        if (i2 >= o2()) {
            return;
        }
        int T = T();
        this.F.t(T);
        this.F.u(T);
        this.F.s(T);
        if (i2 >= this.F.f5928c.length) {
            return;
        }
        this.V = i2;
        View u2 = u2();
        if (u2 == null) {
            return;
        }
        this.N = m0(u2);
        if (!j() && this.C) {
            this.O = this.K.d(u2) + this.K.j();
        } else {
            this.O = this.K.g(u2) - this.K.m();
        }
    }

    private void R2(int i2) {
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(t0(), u0());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(g0(), h0());
        int t0 = t0();
        int g0 = g0();
        boolean z = true;
        if (j()) {
            int i4 = this.P;
            if (i4 == Integer.MIN_VALUE || i4 == t0) {
                z = false;
            }
            i3 = this.I.f5906b ? this.T.getResources().getDisplayMetrics().heightPixels : this.I.a;
        } else {
            int i5 = this.Q;
            if (i5 == Integer.MIN_VALUE || i5 == g0) {
                z = false;
            }
            if (!this.I.f5906b) {
                i3 = this.I.a;
            } else {
                i3 = this.T.getResources().getDisplayMetrics().widthPixels;
            }
        }
        int i6 = i3;
        this.P = t0;
        this.Q = g0;
        int i7 = this.V;
        if (i7 != -1 || (this.N == -1 && !z)) {
            int min = i7 != -1 ? Math.min(i7, this.J.a) : this.J.a;
            this.W.a();
            if (j()) {
                if (this.E.size() > 0) {
                    this.F.j(this.E, min);
                    this.F.b(this.W, makeMeasureSpec, makeMeasureSpec2, i6, min, this.J.a, this.E);
                } else {
                    this.F.s(i2);
                    this.F.d(this.W, makeMeasureSpec, makeMeasureSpec2, i6, 0, this.E);
                }
            } else if (this.E.size() > 0) {
                this.F.j(this.E, min);
                this.F.b(this.W, makeMeasureSpec2, makeMeasureSpec, i6, min, this.J.a, this.E);
            } else {
                this.F.s(i2);
                this.F.g(this.W, makeMeasureSpec, makeMeasureSpec2, i6, 0, this.E);
            }
            this.E = this.W.a;
            this.F.q(makeMeasureSpec, makeMeasureSpec2, min);
            this.F.Y(min);
        } else if (this.J.f5895e) {
        } else {
            this.E.clear();
            this.W.a();
            if (j()) {
                this.F.e(this.W, makeMeasureSpec, makeMeasureSpec2, i6, this.J.a, this.E);
            } else {
                this.F.h(this.W, makeMeasureSpec, makeMeasureSpec2, i6, this.J.a, this.E);
            }
            this.E = this.W.a;
            this.F.p(makeMeasureSpec, makeMeasureSpec2);
            this.F.X();
            b bVar = this.J;
            bVar.f5892b = this.F.f5928c[bVar.a];
            this.I.f5907c = this.J.f5892b;
        }
    }

    private void S2(int i2, int i3) {
        this.I.f5913i = i2;
        boolean j2 = j();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(t0(), u0());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(g0(), h0());
        boolean z = !j2 && this.C;
        if (i2 == 1) {
            View S = S(T() - 1);
            if (S == null) {
                return;
            }
            this.I.f5909e = this.K.d(S);
            int m0 = m0(S);
            View n2 = n2(S, this.E.get(this.F.f5928c[m0]));
            this.I.f5912h = 1;
            d dVar = this.I;
            dVar.f5908d = m0 + dVar.f5912h;
            if (this.F.f5928c.length <= this.I.f5908d) {
                this.I.f5907c = -1;
            } else {
                d dVar2 = this.I;
                dVar2.f5907c = this.F.f5928c[dVar2.f5908d];
            }
            if (z) {
                this.I.f5909e = this.K.g(n2);
                this.I.f5910f = (-this.K.g(n2)) + this.K.m();
                d dVar3 = this.I;
                dVar3.f5910f = Math.max(dVar3.f5910f, 0);
            } else {
                this.I.f5909e = this.K.d(n2);
                this.I.f5910f = this.K.d(n2) - this.K.i();
            }
            if ((this.I.f5907c == -1 || this.I.f5907c > this.E.size() - 1) && this.I.f5908d <= getFlexItemCount()) {
                int i4 = i3 - this.I.f5910f;
                this.W.a();
                if (i4 > 0) {
                    if (j2) {
                        this.F.d(this.W, makeMeasureSpec, makeMeasureSpec2, i4, this.I.f5908d, this.E);
                    } else {
                        this.F.g(this.W, makeMeasureSpec, makeMeasureSpec2, i4, this.I.f5908d, this.E);
                    }
                    this.F.q(makeMeasureSpec, makeMeasureSpec2, this.I.f5908d);
                    this.F.Y(this.I.f5908d);
                }
            }
        } else {
            View S2 = S(0);
            if (S2 == null) {
                return;
            }
            this.I.f5909e = this.K.g(S2);
            int m02 = m0(S2);
            View k2 = k2(S2, this.E.get(this.F.f5928c[m02]));
            this.I.f5912h = 1;
            int i5 = this.F.f5928c[m02];
            if (i5 == -1) {
                i5 = 0;
            }
            if (i5 > 0) {
                this.I.f5908d = m02 - this.E.get(i5 - 1).b();
            } else {
                this.I.f5908d = -1;
            }
            this.I.f5907c = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.I.f5909e = this.K.d(k2);
                this.I.f5910f = this.K.d(k2) - this.K.i();
                d dVar4 = this.I;
                dVar4.f5910f = Math.max(dVar4.f5910f, 0);
            } else {
                this.I.f5909e = this.K.g(k2);
                this.I.f5910f = (-this.K.g(k2)) + this.K.m();
            }
        }
        d dVar5 = this.I;
        dVar5.a = i3 - dVar5.f5910f;
    }

    private void T2(b bVar, boolean z, boolean z2) {
        if (z2) {
            I2();
        } else {
            this.I.f5906b = false;
        }
        if (!j() && this.C) {
            this.I.a = bVar.f5893c - getPaddingRight();
        } else {
            this.I.a = this.K.i() - bVar.f5893c;
        }
        this.I.f5908d = bVar.a;
        this.I.f5912h = 1;
        this.I.f5913i = 1;
        this.I.f5909e = bVar.f5893c;
        this.I.f5910f = Integer.MIN_VALUE;
        this.I.f5907c = bVar.f5892b;
        if (!z || this.E.size() <= 1 || bVar.f5892b < 0 || bVar.f5892b >= this.E.size() - 1) {
            return;
        }
        d.l(this.I);
        d.u(this.I, this.E.get(bVar.f5892b).b());
    }

    private void U2(b bVar, boolean z, boolean z2) {
        if (z2) {
            I2();
        } else {
            this.I.f5906b = false;
        }
        if (!j() && this.C) {
            this.I.a = (this.U.getWidth() - bVar.f5893c) - this.K.m();
        } else {
            this.I.a = bVar.f5893c - this.K.m();
        }
        this.I.f5908d = bVar.a;
        this.I.f5912h = 1;
        this.I.f5913i = -1;
        this.I.f5909e = bVar.f5893c;
        this.I.f5910f = Integer.MIN_VALUE;
        this.I.f5907c = bVar.f5892b;
        if (!z || bVar.f5892b <= 0 || this.E.size() <= bVar.f5892b) {
            return;
        }
        d.m(this.I);
        d.v(this.I, this.E.get(bVar.f5892b).b());
    }

    private boolean a2(View view, int i2) {
        return (j() || !this.C) ? this.K.g(view) >= this.K.h() - i2 : this.K.d(view) <= i2;
    }

    private boolean b2(View view, int i2) {
        return (j() || !this.C) ? this.K.d(view) <= i2 : this.K.h() - this.K.g(view) <= i2;
    }

    private void c2() {
        this.E.clear();
        this.J.t();
        this.J.f5894d = 0;
    }

    private int d2(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        int b2 = b0Var.b();
        h2();
        View j2 = j2(b2);
        View m2 = m2(b2);
        if (b0Var.b() == 0 || j2 == null || m2 == null) {
            return 0;
        }
        return Math.min(this.K.n(), this.K.d(m2) - this.K.g(j2));
    }

    private int e2(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        int b2 = b0Var.b();
        View j2 = j2(b2);
        View m2 = m2(b2);
        if (b0Var.b() != 0 && j2 != null && m2 != null) {
            int m0 = m0(j2);
            int m02 = m0(m2);
            int abs = Math.abs(this.K.d(m2) - this.K.g(j2));
            int[] iArr = this.F.f5928c;
            int i2 = iArr[m0];
            if (i2 != 0 && i2 != -1) {
                return Math.round((i2 * (abs / ((iArr[m02] - i2) + 1))) + (this.K.m() - this.K.g(j2)));
            }
        }
        return 0;
    }

    private int f2(RecyclerView.b0 b0Var) {
        if (T() == 0) {
            return 0;
        }
        int b2 = b0Var.b();
        View j2 = j2(b2);
        View m2 = m2(b2);
        if (b0Var.b() == 0 || j2 == null || m2 == null) {
            return 0;
        }
        int l2 = l2();
        return (int) ((Math.abs(this.K.d(m2) - this.K.g(j2)) / ((o2() - l2) + 1)) * b0Var.b());
    }

    private void g2() {
        if (this.I == null) {
            this.I = new d();
        }
    }

    private void h2() {
        if (this.K != null) {
            return;
        }
        if (j()) {
            if (this.y == 0) {
                this.K = p.a(this);
                this.L = p.c(this);
                return;
            }
            this.K = p.c(this);
            this.L = p.a(this);
        } else if (this.y == 0) {
            this.K = p.c(this);
            this.L = p.a(this);
        } else {
            this.K = p.a(this);
            this.L = p.c(this);
        }
    }

    private int i2(RecyclerView.v vVar, RecyclerView.b0 b0Var, d dVar) {
        if (dVar.f5910f != Integer.MIN_VALUE) {
            if (dVar.a < 0) {
                d.q(dVar, dVar.a);
            }
            E2(vVar, dVar);
        }
        int i2 = dVar.a;
        int i3 = dVar.a;
        int i4 = 0;
        boolean j2 = j();
        while (true) {
            if ((i3 > 0 || this.I.f5906b) && dVar.D(b0Var, this.E)) {
                com.google.android.flexbox.c cVar = this.E.get(dVar.f5907c);
                dVar.f5908d = cVar.o;
                i4 += B2(cVar, dVar);
                if (j2 || !this.C) {
                    d.c(dVar, cVar.a() * dVar.f5913i);
                } else {
                    d.d(dVar, cVar.a() * dVar.f5913i);
                }
                i3 -= cVar.a();
            }
        }
        d.i(dVar, i4);
        if (dVar.f5910f != Integer.MIN_VALUE) {
            d.q(dVar, i4);
            if (dVar.a < 0) {
                d.q(dVar, dVar.a);
            }
            E2(vVar, dVar);
        }
        return i2 - dVar.a;
    }

    private View j2(int i2) {
        View q2 = q2(0, T(), i2);
        if (q2 == null) {
            return null;
        }
        int i3 = this.F.f5928c[m0(q2)];
        if (i3 == -1) {
            return null;
        }
        return k2(q2, this.E.get(i3));
    }

    private View k2(View view, com.google.android.flexbox.c cVar) {
        boolean j2 = j();
        int i2 = cVar.f5922h;
        for (int i3 = 1; i3 < i2; i3++) {
            View S = S(i3);
            if (S != null && S.getVisibility() != 8) {
                if (this.C && !j2) {
                    if (this.K.d(view) >= this.K.d(S)) {
                    }
                    view = S;
                } else {
                    if (this.K.g(view) <= this.K.g(S)) {
                    }
                    view = S;
                }
            }
        }
        return view;
    }

    private View m2(int i2) {
        View q2 = q2(T() - 1, -1, i2);
        if (q2 == null) {
            return null;
        }
        return n2(q2, this.E.get(this.F.f5928c[m0(q2)]));
    }

    private View n2(View view, com.google.android.flexbox.c cVar) {
        boolean j2 = j();
        int T = (T() - cVar.f5922h) - 1;
        for (int T2 = T() - 2; T2 > T; T2--) {
            View S = S(T2);
            if (S != null && S.getVisibility() != 8) {
                if (this.C && !j2) {
                    if (this.K.g(view) <= this.K.g(S)) {
                    }
                    view = S;
                } else {
                    if (this.K.d(view) >= this.K.d(S)) {
                    }
                    view = S;
                }
            }
        }
        return view;
    }

    private View p2(int i2, int i3, boolean z) {
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View S = S(i2);
            if (A2(S, z)) {
                return S;
            }
            i2 += i4;
        }
        return null;
    }

    private View q2(int i2, int i3, int i4) {
        int m0;
        h2();
        g2();
        int m = this.K.m();
        int i5 = this.K.i();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View S = S(i2);
            if (S != null && (m0 = m0(S)) >= 0 && m0 < i4) {
                if (((RecyclerView.p) S.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = S;
                    }
                } else if (this.K.g(S) >= m && this.K.d(S) <= i5) {
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

    private int r2(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var, boolean z) {
        int i3;
        int i4;
        if (!j() && this.C) {
            int m = i2 - this.K.m();
            if (m <= 0) {
                return 0;
            }
            i3 = y2(m, vVar, b0Var);
        } else {
            int i5 = this.K.i() - i2;
            if (i5 <= 0) {
                return 0;
            }
            i3 = -y2(-i5, vVar, b0Var);
        }
        int i6 = i2 + i3;
        if (!z || (i4 = this.K.i() - i6) <= 0) {
            return i3;
        }
        this.K.r(i4);
        return i4 + i3;
    }

    private int s2(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var, boolean z) {
        int i3;
        int m;
        if (!j() && this.C) {
            int i4 = this.K.i() - i2;
            if (i4 <= 0) {
                return 0;
            }
            i3 = y2(-i4, vVar, b0Var);
        } else {
            int m2 = i2 - this.K.m();
            if (m2 <= 0) {
                return 0;
            }
            i3 = -y2(m2, vVar, b0Var);
        }
        int i5 = i2 + i3;
        if (!z || (m = i5 - this.K.m()) <= 0) {
            return i3;
        }
        this.K.r(-m);
        return i3 - m;
    }

    private int t2(View view) {
        return Y(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    private View u2() {
        return S(0);
    }

    private int v2(View view) {
        return a0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }

    private int w2(View view) {
        return d0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }

    private int x2(View view) {
        return e0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    private int y2(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (T() == 0 || i2 == 0) {
            return 0;
        }
        h2();
        int i3 = 1;
        this.I.f5914j = true;
        boolean z = !j() && this.C;
        if (!z ? i2 <= 0 : i2 >= 0) {
            i3 = -1;
        }
        int abs = Math.abs(i2);
        S2(i3, abs);
        int i22 = this.I.f5910f + i2(vVar, b0Var, this.I);
        if (i22 < 0) {
            return 0;
        }
        if (z) {
            if (abs > i22) {
                i2 = (-i3) * i22;
            }
        } else if (abs > i22) {
            i2 = i3 * i22;
        }
        this.K.r(-i2);
        this.I.f5911g = i2;
        return i2;
    }

    private int z2(int i2) {
        int i3;
        if (T() == 0 || i2 == 0) {
            return 0;
        }
        h2();
        boolean j2 = j();
        View view = this.U;
        int width = j2 ? view.getWidth() : view.getHeight();
        int t0 = j2 ? t0() : g0();
        if (i0() == 1) {
            int abs = Math.abs(i2);
            if (i2 >= 0) {
                if (this.J.f5894d + i2 <= 0) {
                    return i2;
                }
                i3 = this.J.f5894d;
            } else {
                i3 = Math.min((t0 + this.J.f5894d) - width, abs);
            }
        } else if (i2 <= 0) {
            if (this.J.f5894d + i2 >= 0) {
                return i2;
            }
            i3 = this.J.f5894d;
        } else {
            return Math.min((t0 - this.J.f5894d) - width, i2);
        }
        return -i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.b0 b0Var) {
        return d2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        return e2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        return f2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        return d2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (j() && this.y != 0) {
            int z2 = z2(i2);
            b.l(this.J, z2);
            this.L.r(-z2);
            return z2;
        }
        int y2 = y2(i2, vVar, b0Var);
        this.S.clear();
        return y2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        return e2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void E1(int i2) {
        this.N = i2;
        this.O = Integer.MIN_VALUE;
        e eVar = this.M;
        if (eVar != null) {
            eVar.h();
        }
        A1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        return f2(b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F1(int i2, RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        if (!j() && (this.y != 0 || j())) {
            int z2 = z2(i2);
            b.l(this.J, z2);
            this.L.r(-z2);
            return z2;
        }
        int y2 = y2(i2, vVar, b0Var);
        this.S.clear();
        return y2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(RecyclerView.g gVar, RecyclerView.g gVar2) {
        q1();
    }

    public void K2(int i2) {
        int i3 = this.A;
        if (i3 != i2) {
            if (i3 == 4 || i2 == 4) {
                q1();
                c2();
            }
            this.A = i2;
            A1();
        }
    }

    public void L2(int i2) {
        if (this.x != i2) {
            q1();
            this.x = i2;
            this.K = null;
            this.L = null;
            c2();
            A1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M0(RecyclerView recyclerView) {
        super.M0(recyclerView);
        this.U = (View) recyclerView.getParent();
    }

    public void M2(int i2) {
        if (i2 != 2) {
            int i3 = this.y;
            if (i3 != i2) {
                if (i3 == 0 || i2 == 0) {
                    q1();
                    c2();
                }
                this.y = i2;
                this.K = null;
                this.L = null;
                A1();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        return new c(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p O(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.O0(recyclerView, vVar);
        if (this.R) {
            r1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P1(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i2) {
        l lVar = new l(recyclerView.getContext());
        lVar.p(i2);
        Q1(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i2, int i3) {
        super.X0(recyclerView, i2, i3);
        Q2(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, int i2, int i3, int i4) {
        super.Z0(recyclerView, i2, i3, i4);
        Q2(Math.min(i2, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0.b
    public PointF a(int i2) {
        View S;
        if (T() == 0 || (S = S(0)) == null) {
            return null;
        }
        int i3 = i2 < m0(S) ? -1 : 1;
        if (j()) {
            return new PointF(0.0f, i3);
        }
        return new PointF(i3, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i2, int i3) {
        super.a1(recyclerView, i2, i3);
        Q2(i2);
    }

    @Override // com.google.android.flexbox.a
    public void b(View view, int i2, int i3, com.google.android.flexbox.c cVar) {
        t(view, w);
        if (j()) {
            int j0 = j0(view) + o0(view);
            cVar.f5919e += j0;
            cVar.f5920f += j0;
            return;
        }
        int r0 = r0(view) + R(view);
        cVar.f5919e += r0;
        cVar.f5920f += r0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView recyclerView, int i2, int i3) {
        super.b1(recyclerView, i2, i3);
        Q2(i2);
    }

    @Override // com.google.android.flexbox.a
    public void c(com.google.android.flexbox.c cVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView recyclerView, int i2, int i3, Object obj) {
        super.c1(recyclerView, i2, i3, obj);
        Q2(i2);
    }

    @Override // com.google.android.flexbox.a
    public View d(int i2) {
        return g(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.b0 b0Var) {
        int i2;
        int i3;
        this.G = vVar;
        this.H = b0Var;
        int b2 = b0Var.b();
        if (b2 == 0 && b0Var.e()) {
            return;
        }
        J2();
        h2();
        g2();
        this.F.t(b2);
        this.F.u(b2);
        this.F.s(b2);
        this.I.f5914j = false;
        e eVar = this.M;
        if (eVar != null && eVar.g(b2)) {
            this.N = this.M.a;
        }
        if (!this.J.f5896f || this.N != -1 || this.M != null) {
            this.J.t();
            P2(b0Var, this.J);
            this.J.f5896f = true;
        }
        G(vVar);
        if (this.J.f5895e) {
            U2(this.J, false, true);
        } else {
            T2(this.J, false, true);
        }
        R2(b2);
        i2(vVar, b0Var, this.I);
        if (this.J.f5895e) {
            i3 = this.I.f5909e;
            T2(this.J, true, false);
            i2(vVar, b0Var, this.I);
            i2 = this.I.f5909e;
        } else {
            i2 = this.I.f5909e;
            U2(this.J, true, false);
            i2(vVar, b0Var, this.I);
            i3 = this.I.f5909e;
        }
        if (T() > 0) {
            if (this.J.f5895e) {
                s2(i3 + r2(i2, vVar, b0Var, true), vVar, b0Var, false);
            } else {
                r2(i2 + s2(i3, vVar, b0Var, true), vVar, b0Var, false);
            }
        }
    }

    @Override // com.google.android.flexbox.a
    public int e(int i2, int i3, int i4) {
        return RecyclerView.o.U(t0(), u0(), i3, i4, u());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.b0 b0Var) {
        super.e1(b0Var);
        this.M = null;
        this.N = -1;
        this.O = Integer.MIN_VALUE;
        this.V = -1;
        this.J.t();
        this.S.clear();
    }

    @Override // com.google.android.flexbox.a
    public void f(int i2, View view) {
        this.S.put(i2, view);
    }

    @Override // com.google.android.flexbox.a
    public View g(int i2) {
        View view = this.S.get(i2);
        return view != null ? view : this.G.o(i2);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.A;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.x;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.H.b();
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.c> getFlexLinesInternal() {
        return this.E;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.y;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.E.size() == 0) {
            return 0;
        }
        int i2 = Integer.MIN_VALUE;
        int size = this.E.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = Math.max(i2, this.E.get(i3).f5919e);
        }
        return i2;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.B;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.E.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.E.get(i3).f5921g;
        }
        return i2;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view, int i2, int i3) {
        int r0;
        int R;
        if (j()) {
            r0 = j0(view);
            R = o0(view);
        } else {
            r0 = r0(view);
            R = R(view);
        }
        return r0 + R;
    }

    @Override // com.google.android.flexbox.a
    public int i(int i2, int i3, int i4) {
        return RecyclerView.o.U(g0(), h0(), i3, i4, v());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.M = (e) parcelable;
            A1();
        }
    }

    @Override // com.google.android.flexbox.a
    public boolean j() {
        int i2 = this.x;
        return i2 == 0 || i2 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable j1() {
        if (this.M != null) {
            return new e(this.M);
        }
        e eVar = new e();
        if (T() <= 0) {
            eVar.h();
        } else {
            View u2 = u2();
            eVar.a = m0(u2);
            eVar.f5915b = this.K.g(u2) - this.K.m();
        }
        return eVar;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view) {
        int j0;
        int o0;
        if (j()) {
            j0 = r0(view);
            o0 = R(view);
        } else {
            j0 = j0(view);
            o0 = o0(view);
        }
        return j0 + o0;
    }

    public int l2() {
        View p2 = p2(0, T(), false);
        if (p2 == null) {
            return -1;
        }
        return m0(p2);
    }

    public int o2() {
        View p2 = p2(T() - 1, -1, false);
        if (p2 == null) {
            return -1;
        }
        return m0(p2);
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.c> list) {
        this.E = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        if (this.y == 0) {
            return j();
        }
        if (j()) {
            int t0 = t0();
            View view = this.U;
            if (t0 <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        if (this.y == 0) {
            return !j();
        }
        if (j()) {
            return true;
        }
        int g0 = g0();
        View view = this.U;
        return g0 > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f5915b;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<e> {
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

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g(int i2) {
            int i3 = this.a;
            return i3 >= 0 && i3 < i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.a + ", mAnchorOffset=" + this.f5915b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.f5915b);
        }

        e() {
        }

        private e(Parcel parcel) {
            this.a = parcel.readInt();
            this.f5915b = parcel.readInt();
        }

        private e(e eVar) {
            this.a = eVar.a;
            this.f5915b = eVar.f5915b;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.p implements com.google.android.flexbox.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        private float f5899e;

        /* renamed from: f  reason: collision with root package name */
        private float f5900f;

        /* renamed from: g  reason: collision with root package name */
        private int f5901g;

        /* renamed from: h  reason: collision with root package name */
        private float f5902h;

        /* renamed from: j  reason: collision with root package name */
        private int f5903j;

        /* renamed from: k  reason: collision with root package name */
        private int f5904k;

        /* renamed from: l  reason: collision with root package name */
        private int f5905l;
        private int m;
        private boolean n;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int i2) {
                return new c[i2];
            }
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5899e = 0.0f;
            this.f5900f = 1.0f;
            this.f5901g = -1;
            this.f5902h = -1.0f;
            this.f5905l = 16777215;
            this.m = 16777215;
        }

        @Override // com.google.android.flexbox.b
        public int I0() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.b
        public int M0() {
            return this.f5904k;
        }

        @Override // com.google.android.flexbox.b
        public float O() {
            return this.f5900f;
        }

        @Override // com.google.android.flexbox.b
        public boolean O0() {
            return this.n;
        }

        @Override // com.google.android.flexbox.b
        public int V() {
            return this.f5903j;
        }

        @Override // com.google.android.flexbox.b
        public int W0() {
            return this.m;
        }

        @Override // com.google.android.flexbox.b
        public void a0(int i2) {
            this.f5903j = i2;
        }

        @Override // com.google.android.flexbox.b
        public int d0() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.b
        public int f1() {
            return this.f5905l;
        }

        @Override // com.google.android.flexbox.b
        public int g0() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.b
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.b
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.b
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.b
        public int o0() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.b
        public void s0(int i2) {
            this.f5904k = i2;
        }

        @Override // com.google.android.flexbox.b
        public float w0() {
            return this.f5899e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeFloat(this.f5899e);
            parcel.writeFloat(this.f5900f);
            parcel.writeInt(this.f5901g);
            parcel.writeFloat(this.f5902h);
            parcel.writeInt(this.f5903j);
            parcel.writeInt(this.f5904k);
            parcel.writeInt(this.f5905l);
            parcel.writeInt(this.m);
            parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.b
        public int z() {
            return this.f5901g;
        }

        @Override // com.google.android.flexbox.b
        public float z0() {
            return this.f5902h;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f5899e = 0.0f;
            this.f5900f = 1.0f;
            this.f5901g = -1;
            this.f5902h = -1.0f;
            this.f5905l = 16777215;
            this.m = 16777215;
        }

        protected c(Parcel parcel) {
            super(-2, -2);
            this.f5899e = 0.0f;
            this.f5900f = 1.0f;
            this.f5901g = -1;
            this.f5902h = -1.0f;
            this.f5905l = 16777215;
            this.m = 16777215;
            this.f5899e = parcel.readFloat();
            this.f5900f = parcel.readFloat();
            this.f5901g = parcel.readInt();
            this.f5902h = parcel.readFloat();
            this.f5903j = parcel.readInt();
            this.f5904k = parcel.readInt();
            this.f5905l = parcel.readInt();
            this.m = parcel.readInt();
            this.n = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}