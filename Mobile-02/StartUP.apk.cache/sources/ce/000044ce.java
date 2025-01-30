package e.a.a.w.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import e.a.a.l;
import e.a.a.u.c.p;
import e.a.a.w.l.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class b extends e.a.a.w.l.a {
    private final RectF A;
    private Paint B;
    private e.a.a.u.c.a<Float, Float> x;
    private final List<e.a.a.w.l.a> y;
    private final RectF z;

    /* compiled from: CompositionLayer.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.b.values().length];
            a = iArr;
            try {
                iArr[d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(e.a.a.g gVar, d dVar, List<d> list, e.a.a.e eVar) {
        super(gVar, dVar);
        int i2;
        e.a.a.w.l.a aVar;
        this.y = new ArrayList();
        this.z = new RectF();
        this.A = new RectF();
        this.B = new Paint();
        e.a.a.w.j.b s = dVar.s();
        if (s != null) {
            e.a.a.u.c.a<Float, Float> a2 = s.a();
            this.x = a2;
            i(a2);
            this.x.a(this);
        } else {
            this.x = null;
        }
        c.e.d dVar2 = new c.e.d(eVar.j().size());
        int size = list.size() - 1;
        e.a.a.w.l.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar3 = list.get(size);
            e.a.a.w.l.a u = e.a.a.w.l.a.u(dVar3, gVar, eVar);
            if (u != null) {
                dVar2.n(u.v().b(), u);
                if (aVar2 != null) {
                    aVar2.E(u);
                    aVar2 = null;
                } else {
                    this.y.add(0, u);
                    int i3 = a.a[dVar3.f().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        aVar2 = u;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < dVar2.q(); i2++) {
            e.a.a.w.l.a aVar3 = (e.a.a.w.l.a) dVar2.h(dVar2.l(i2));
            if (aVar3 != null && (aVar = (e.a.a.w.l.a) dVar2.h(aVar3.v().h())) != null) {
                aVar3.F(aVar);
            }
        }
    }

    @Override // e.a.a.w.l.a
    protected void D(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        for (int i3 = 0; i3 < this.y.size(); i3++) {
            this.y.get(i3).c(eVar, i2, list, eVar2);
        }
    }

    @Override // e.a.a.w.l.a
    public void G(float f2) {
        super.G(f2);
        if (this.x != null) {
            f2 = ((this.x.h().floatValue() * this.o.a().h()) - this.o.a().o()) / (this.n.n().e() + 0.01f);
        }
        if (this.x == null) {
            f2 -= this.o.p();
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.y.get(size).G(f2);
        }
    }

    @Override // e.a.a.w.l.a, e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.y.get(size).d(this.z, this.m, true);
            rectF.union(this.z);
        }
    }

    @Override // e.a.a.w.l.a, e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        super.g(t, cVar);
        if (t == l.A) {
            if (cVar == null) {
                e.a.a.u.c.a<Float, Float> aVar = this.x;
                if (aVar != null) {
                    aVar.m(null);
                    return;
                }
                return;
            }
            p pVar = new p(cVar);
            this.x = pVar;
            pVar.a(this);
            i(this.x);
        }
    }

    @Override // e.a.a.w.l.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        e.a.a.c.a("CompositionLayer#draw");
        this.A.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.A);
        boolean z = this.n.G() && this.y.size() > 1 && i2 != 255;
        if (z) {
            this.B.setAlpha(i2);
            e.a.a.z.h.m(canvas, this.A, this.B);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            if (!this.A.isEmpty() ? canvas.clipRect(this.A) : true) {
                this.y.get(size).f(canvas, matrix, i2);
            }
        }
        canvas.restore();
        e.a.a.c.b("CompositionLayer#draw");
    }
}