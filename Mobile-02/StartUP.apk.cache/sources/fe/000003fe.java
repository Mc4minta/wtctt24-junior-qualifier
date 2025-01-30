package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class p {
    protected final RecyclerView.o a;

    /* renamed from: b  reason: collision with root package name */
    private int f2202b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f2203c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public static class a extends p {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.p
        public int d(View view) {
            return this.a.d0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.c0(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.b0(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int g(View view) {
            return this.a.a0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int h() {
            return this.a.t0();
        }

        @Override // androidx.recyclerview.widget.p
        public int i() {
            return this.a.t0() - this.a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.p
        public int j() {
            return this.a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.p
        public int k() {
            return this.a.u0();
        }

        @Override // androidx.recyclerview.widget.p
        public int l() {
            return this.a.h0();
        }

        @Override // androidx.recyclerview.widget.p
        public int m() {
            return this.a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.p
        public int n() {
            return (this.a.t0() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.p
        public int p(View view) {
            this.a.s0(view, true, this.f2203c);
            return this.f2203c.right;
        }

        @Override // androidx.recyclerview.widget.p
        public int q(View view) {
            this.a.s0(view, true, this.f2203c);
            return this.f2203c.left;
        }

        @Override // androidx.recyclerview.widget.p
        public void r(int i2) {
            this.a.I0(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public static class b extends p {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.p
        public int d(View view) {
            return this.a.Y(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.b0(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.c0(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int g(View view) {
            return this.a.e0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.p
        public int h() {
            return this.a.g0();
        }

        @Override // androidx.recyclerview.widget.p
        public int i() {
            return this.a.g0() - this.a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.p
        public int j() {
            return this.a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.p
        public int k() {
            return this.a.h0();
        }

        @Override // androidx.recyclerview.widget.p
        public int l() {
            return this.a.u0();
        }

        @Override // androidx.recyclerview.widget.p
        public int m() {
            return this.a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.p
        public int n() {
            return (this.a.g0() - this.a.getPaddingTop()) - this.a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.p
        public int p(View view) {
            this.a.s0(view, true, this.f2203c);
            return this.f2203c.bottom;
        }

        @Override // androidx.recyclerview.widget.p
        public int q(View view) {
            this.a.s0(view, true, this.f2203c);
            return this.f2203c.top;
        }

        @Override // androidx.recyclerview.widget.p
        public void r(int i2) {
            this.a.J0(i2);
        }
    }

    /* synthetic */ p(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static p a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static p b(RecyclerView.o oVar, int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return c(oVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(oVar);
    }

    public static p c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f2202b) {
            return 0;
        }
        return n() - this.f2202b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i2);

    public void s() {
        this.f2202b = n();
    }

    private p(RecyclerView.o oVar) {
        this.f2202b = Integer.MIN_VALUE;
        this.f2203c = new Rect();
        this.a = oVar;
    }
}