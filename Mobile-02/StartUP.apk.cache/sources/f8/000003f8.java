package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LinearSmoothScroller.java */
/* loaded from: classes.dex */
public class l extends RecyclerView.a0 {

    /* renamed from: k  reason: collision with root package name */
    protected PointF f2200k;

    /* renamed from: l  reason: collision with root package name */
    private final DisplayMetrics f2201l;
    private float n;

    /* renamed from: i  reason: collision with root package name */
    protected final LinearInterpolator f2198i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    protected final DecelerateInterpolator f2199j = new DecelerateInterpolator();
    private boolean m = false;
    protected int o = 0;
    protected int p = 0;

    public l(Context context) {
        this.f2201l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.m) {
            this.n = v(this.f2201l);
            this.m = true;
        }
        return this.n;
    }

    private int y(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    protected int B() {
        PointF pointF = this.f2200k;
        if (pointF != null) {
            float f2 = pointF.y;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.a0.a aVar) {
        PointF a = a(f());
        if (a != null && (a.x != 0.0f || a.y != 0.0f)) {
            i(a);
            this.f2200k = a;
            this.o = (int) (a.x * 10000.0f);
            this.p = (int) (a.y * 10000.0f);
            aVar.d((int) (this.o * 1.2f), (int) (this.p * 1.2f), (int) (x(10000) * 1.2f), this.f2198i);
            return;
        }
        aVar.b(f());
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    protected void l(int i2, int i3, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.o = y(this.o, i2);
        int y = y(this.p, i3);
        this.p = y;
        if (this.o == 0 && y == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    protected void n() {
        this.p = 0;
        this.o = 0;
        this.f2200k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    protected void o(View view, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
        int t = t(view, z());
        int u = u(view, B());
        int w = w((int) Math.sqrt((t * t) + (u * u)));
        if (w > 0) {
            aVar.d(-t, -u, w, this.f2199j);
        }
    }

    public int s(int i2, int i3, int i4, int i5, int i6) {
        if (i6 != -1) {
            if (i6 != 0) {
                if (i6 == 1) {
                    return i5 - i3;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        }
        return i4 - i2;
    }

    public int t(View view, int i2) {
        RecyclerView.o e2 = e();
        if (e2 == null || !e2.u()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e2.a0(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, e2.d0(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, e2.getPaddingLeft(), e2.t0() - e2.getPaddingRight(), i2);
    }

    public int u(View view, int i2) {
        RecyclerView.o e2 = e();
        if (e2 == null || !e2.v()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e2.e0(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, e2.Y(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, e2.getPaddingTop(), e2.g0() - e2.getPaddingBottom(), i2);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int w(int i2) {
        return (int) Math.ceil(x(i2) / 0.3356d);
    }

    protected int x(int i2) {
        return (int) Math.ceil(Math.abs(i2) * A());
    }

    protected int z() {
        PointF pointF = this.f2200k;
        if (pointF != null) {
            float f2 = pointF.x;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}