package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class s extends RecyclerView.l {

    /* renamed from: g  reason: collision with root package name */
    boolean f2208g = true;

    public final void A(RecyclerView.e0 e0Var) {
        I(e0Var);
        h(e0Var);
    }

    public final void B(RecyclerView.e0 e0Var) {
        J(e0Var);
    }

    public final void C(RecyclerView.e0 e0Var, boolean z) {
        K(e0Var, z);
        h(e0Var);
    }

    public final void D(RecyclerView.e0 e0Var, boolean z) {
        L(e0Var, z);
    }

    public final void E(RecyclerView.e0 e0Var) {
        M(e0Var);
        h(e0Var);
    }

    public final void F(RecyclerView.e0 e0Var) {
        N(e0Var);
    }

    public final void G(RecyclerView.e0 e0Var) {
        O(e0Var);
        h(e0Var);
    }

    public final void H(RecyclerView.e0 e0Var) {
        P(e0Var);
    }

    public void I(RecyclerView.e0 e0Var) {
    }

    public void J(RecyclerView.e0 e0Var) {
    }

    public void K(RecyclerView.e0 e0Var, boolean z) {
    }

    public void L(RecyclerView.e0 e0Var, boolean z) {
    }

    public void M(RecyclerView.e0 e0Var) {
    }

    public void N(RecyclerView.e0 e0Var) {
    }

    public void O(RecyclerView.e0 e0Var) {
    }

    public void P(RecyclerView.e0 e0Var) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.e0 e0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2;
        int i3;
        if (cVar != null && ((i2 = cVar.a) != (i3 = cVar2.a) || cVar.f2024b != cVar2.f2024b)) {
            return y(e0Var, i2, cVar.f2024b, i3, cVar2.f2024b);
        }
        return w(e0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.a;
        int i5 = cVar.f2024b;
        if (e0Var2.shouldIgnore()) {
            int i6 = cVar.a;
            i3 = cVar.f2024b;
            i2 = i6;
        } else {
            i2 = cVar2.a;
            i3 = cVar2.f2024b;
        }
        return x(e0Var, e0Var2, i4, i5, i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.e0 e0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2 = cVar.a;
        int i3 = cVar.f2024b;
        View view = e0Var.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.f2024b;
        if (!e0Var.isRemoved() && (i2 != left || i3 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return y(e0Var, i2, i3, left, top);
        }
        return z(e0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.e0 e0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2 = cVar.a;
        int i3 = cVar2.a;
        if (i2 == i3 && cVar.f2024b == cVar2.f2024b) {
            E(e0Var);
            return false;
        }
        return y(e0Var, i2, cVar.f2024b, i3, cVar2.f2024b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.e0 e0Var) {
        return !this.f2208g || e0Var.isInvalid();
    }

    public abstract boolean w(RecyclerView.e0 e0Var);

    public abstract boolean x(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2, int i2, int i3, int i4, int i5);

    public abstract boolean y(RecyclerView.e0 e0Var, int i2, int i3, int i4, int i5);

    public abstract boolean z(RecyclerView.e0 e0Var);
}