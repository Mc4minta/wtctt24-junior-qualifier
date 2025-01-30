package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.views.view.ReactViewManager;

/* compiled from: NativeViewHierarchyOptimizer.java */
/* loaded from: classes2.dex */
public class m {
    private final t0 a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f5157b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseBooleanArray f5158c = new SparseBooleanArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeViewHierarchyOptimizer.java */
    /* loaded from: classes2.dex */
    public static class a {
        public final y a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5159b;

        a(y yVar, int i2) {
            this.a = yVar;
            this.f5159b = i2;
        }
    }

    public m(t0 t0Var, f0 f0Var) {
        this.a = t0Var;
        this.f5157b = f0Var;
    }

    private void a(y yVar, y yVar2, int i2) {
        e.f.k.a.a.a(yVar2.G() != k.PARENT);
        for (int i3 = 0; i3 < yVar2.b(); i3++) {
            y a2 = yVar2.a(i3);
            e.f.k.a.a.a(a2.X() == null);
            int v = yVar.v();
            if (a2.G() == k.NONE) {
                d(yVar, a2, i2);
            } else {
                b(yVar, a2, i2);
            }
            i2 += yVar.v() - v;
        }
    }

    private void b(y yVar, y yVar2, int i2) {
        yVar.x(yVar2, i2);
        this.a.I(yVar.q(), null, new u0[]{new u0(yVar2.q(), i2)}, null);
        if (yVar2.G() != k.PARENT) {
            a(yVar, yVar2, i2 + 1);
        }
    }

    private void c(y yVar, y yVar2, int i2) {
        int u = yVar.u(yVar.a(i2));
        if (yVar.G() != k.PARENT) {
            a s = s(yVar, u);
            if (s == null) {
                return;
            }
            y yVar3 = s.a;
            u = s.f5159b;
            yVar = yVar3;
        }
        if (yVar2.G() != k.NONE) {
            b(yVar, yVar2, u);
        } else {
            d(yVar, yVar2, u);
        }
    }

    private void d(y yVar, y yVar2, int i2) {
        a(yVar, yVar2, i2);
    }

    private void e(y yVar) {
        int q = yVar.q();
        if (this.f5158c.get(q)) {
            return;
        }
        this.f5158c.put(q, true);
        int Q = yVar.Q();
        int D = yVar.D();
        for (y parent = yVar.getParent(); parent != null && parent.G() != k.PARENT; parent = parent.getParent()) {
            if (!parent.t()) {
                Q += Math.round(parent.S());
                D += Math.round(parent.O());
            }
        }
        f(yVar, Q, D);
    }

    private void f(y yVar, int i2, int i3) {
        if (yVar.G() != k.NONE && yVar.X() != null) {
            this.a.S(yVar.V().q(), yVar.q(), i2, i3, yVar.B(), yVar.c());
            return;
        }
        for (int i4 = 0; i4 < yVar.b(); i4++) {
            y a2 = yVar.a(i4);
            int q = a2.q();
            if (!this.f5158c.get(q)) {
                this.f5158c.put(q, true);
                f(a2, a2.Q() + i2, a2.D() + i3);
            }
        }
    }

    public static void j(y yVar) {
        yVar.r();
    }

    private static boolean n(a0 a0Var) {
        if (a0Var == null) {
            return true;
        }
        if (!a0Var.g("collapsable") || a0Var.b("collapsable", true)) {
            ReadableMapKeySetIterator keySetIterator = a0Var.a.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                if (!a1.a(a0Var.a, keySetIterator.nextKey())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void q(y yVar, boolean z) {
        if (yVar.G() != k.PARENT) {
            for (int b2 = yVar.b() - 1; b2 >= 0; b2--) {
                q(yVar.a(b2), z);
            }
        }
        y X = yVar.X();
        if (X != null) {
            int w = X.w(yVar);
            X.R(w);
            this.a.I(X.q(), new int[]{w}, null, z ? new int[]{yVar.q()} : null);
        }
    }

    private void r(y yVar, a0 a0Var) {
        y parent = yVar.getParent();
        if (parent == null) {
            yVar.Y(false);
            return;
        }
        int K = parent.K(yVar);
        parent.e(K);
        q(yVar, false);
        yVar.Y(false);
        this.a.C(yVar.F(), yVar.q(), yVar.L(), a0Var);
        parent.I(yVar, K);
        c(parent, yVar, K);
        for (int i2 = 0; i2 < yVar.b(); i2++) {
            c(yVar, yVar.a(i2), i2);
        }
        if (e.f.m.v.a.f12894h) {
            StringBuilder sb = new StringBuilder();
            sb.append("Transitioning LayoutOnlyView - tag: ");
            sb.append(yVar.q());
            sb.append(" - rootTag: ");
            sb.append(yVar.H());
            sb.append(" - hasProps: ");
            sb.append(a0Var != null);
            sb.append(" - tagsWithLayout.size: ");
            sb.append(this.f5158c.size());
            e.f.d.d.a.n("NativeViewHierarchyOptimizer", sb.toString());
        }
        e.f.k.a.a.a(this.f5158c.size() == 0);
        e(yVar);
        for (int i3 = 0; i3 < yVar.b(); i3++) {
            e(yVar.a(i3));
        }
        this.f5158c.clear();
    }

    private a s(y yVar, int i2) {
        while (yVar.G() != k.PARENT) {
            y parent = yVar.getParent();
            if (parent == null) {
                return null;
            }
            i2 = i2 + (yVar.G() == k.LEAF ? 1 : 0) + parent.u(yVar);
            yVar = parent;
        }
        return new a(yVar, i2);
    }

    public void g(y yVar, i0 i0Var, a0 a0Var) {
        yVar.Y(yVar.L().equals(ReactViewManager.REACT_CLASS) && n(a0Var));
        if (yVar.G() != k.NONE) {
            this.a.C(i0Var, yVar.q(), yVar.L(), a0Var);
        }
    }

    public void h(y yVar) {
        if (yVar.a0()) {
            r(yVar, null);
        }
    }

    public void i(y yVar, int[] iArr, int[] iArr2, u0[] u0VarArr, int[] iArr3) {
        boolean z;
        for (int i2 : iArr2) {
            int i3 = 0;
            while (true) {
                if (i3 >= iArr3.length) {
                    z = false;
                    break;
                } else if (iArr3[i3] == i2) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            q(this.f5157b.c(i2), z);
        }
        for (u0 u0Var : u0VarArr) {
            c(yVar, this.f5157b.c(u0Var.f5266b), u0Var.f5267c);
        }
    }

    public void k(y yVar, ReadableArray readableArray) {
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            c(yVar, this.f5157b.c(readableArray.getInt(i2)), i2);
        }
    }

    public void l(y yVar) {
        e(yVar);
    }

    public void m(y yVar, String str, a0 a0Var) {
        if (yVar.a0() && !n(a0Var)) {
            r(yVar, a0Var);
        } else if (yVar.a0()) {
        } else {
            this.a.T(yVar.q(), str, a0Var);
        }
    }

    public void o() {
        this.f5158c.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(y yVar) {
        this.f5158c.clear();
    }
}