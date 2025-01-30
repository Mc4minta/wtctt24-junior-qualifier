package e.a.a.w.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import e.a.a.u.c.a;
import e.a.a.u.c.o;
import e.a.a.w.k.g;
import e.a.a.w.k.l;
import e.a.a.w.l.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a implements e.a.a.u.b.e, a.b, e.a.a.w.f {
    private final Path a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f11877b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f11878c = new e.a.a.u.a(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f11879d = new e.a.a.u.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f11880e = new e.a.a.u.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f11881f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f11882g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f11883h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f11884i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f11885j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f11886k;

    /* renamed from: l  reason: collision with root package name */
    private final String f11887l;
    final Matrix m;
    final e.a.a.g n;
    final d o;
    private e.a.a.u.c.g p;
    private e.a.a.u.c.c q;
    private a r;
    private a s;
    private List<a> t;
    private final List<e.a.a.u.c.a<?, ?>> u;
    final o v;
    private boolean w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* renamed from: e.a.a.w.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0257a implements a.b {
        C0257a() {
        }

        @Override // e.a.a.u.c.a.b
        public void a() {
            a aVar = a.this;
            aVar.H(aVar.q.o() == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f11888b;

        static {
            int[] iArr = new int[g.a.values().length];
            f11888b = iArr;
            try {
                iArr[g.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11888b[g.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11888b[g.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11888b[g.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.a.values().length];
            a = iArr2;
            try {
                iArr2[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e.a.a.g gVar, d dVar) {
        e.a.a.u.a aVar = new e.a.a.u.a(1);
        this.f11881f = aVar;
        this.f11882g = new e.a.a.u.a(PorterDuff.Mode.CLEAR);
        this.f11883h = new RectF();
        this.f11884i = new RectF();
        this.f11885j = new RectF();
        this.f11886k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.n = gVar;
        this.o = dVar;
        this.f11887l = dVar.g() + "#draw";
        if (dVar.f() == d.b.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o b2 = dVar.u().b();
        this.v = b2;
        b2.b(this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            e.a.a.u.c.g gVar2 = new e.a.a.u.c.g(dVar.e());
            this.p = gVar2;
            for (e.a.a.u.c.a<l, Path> aVar2 : gVar2.a()) {
                aVar2.a(this);
            }
            for (e.a.a.u.c.a<Integer, Integer> aVar3 : this.p.c()) {
                i(aVar3);
                aVar3.a(this);
            }
        }
        I();
    }

    private void A() {
        this.n.invalidateSelf();
    }

    private void B(float f2) {
        this.n.n().m().a(this.o.g(), f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z) {
        if (z != this.w) {
            this.w = z;
            A();
        }
    }

    private void I() {
        if (!this.o.c().isEmpty()) {
            e.a.a.u.c.c cVar = new e.a.a.u.c.c(this.o.c());
            this.q = cVar;
            cVar.k();
            this.q.a(new C0257a());
            H(this.q.h().floatValue() == 1.0f);
            i(this.q);
            return;
        }
        H(true);
    }

    private void j(Canvas canvas, Matrix matrix, e.a.a.w.k.g gVar, e.a.a.u.c.a<l, Path> aVar, e.a.a.u.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.f11878c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f11878c);
    }

    private void k(Canvas canvas, Matrix matrix, e.a.a.w.k.g gVar, e.a.a.u.c.a<l, Path> aVar, e.a.a.u.c.a<Integer, Integer> aVar2) {
        e.a.a.z.h.m(canvas, this.f11883h, this.f11879d);
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.f11878c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f11878c);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, e.a.a.w.k.g gVar, e.a.a.u.c.a<l, Path> aVar, e.a.a.u.c.a<Integer, Integer> aVar2) {
        e.a.a.z.h.m(canvas, this.f11883h, this.f11878c);
        canvas.drawRect(this.f11883h, this.f11878c);
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.f11878c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f11880e);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, e.a.a.w.k.g gVar, e.a.a.u.c.a<l, Path> aVar, e.a.a.u.c.a<Integer, Integer> aVar2) {
        e.a.a.z.h.m(canvas, this.f11883h, this.f11879d);
        canvas.drawRect(this.f11883h, this.f11878c);
        this.f11880e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f11880e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, e.a.a.w.k.g gVar, e.a.a.u.c.a<l, Path> aVar, e.a.a.u.c.a<Integer, Integer> aVar2) {
        e.a.a.z.h.m(canvas, this.f11883h, this.f11880e);
        canvas.drawRect(this.f11883h, this.f11878c);
        this.f11880e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f11880e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        e.a.a.c.a("Layer#saveLayer");
        e.a.a.z.h.n(canvas, this.f11883h, this.f11879d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        e.a.a.c.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            e.a.a.w.k.g gVar = this.p.b().get(i2);
            e.a.a.u.c.a<l, Path> aVar = this.p.a().get(i2);
            e.a.a.u.c.a<Integer, Integer> aVar2 = this.p.c().get(i2);
            int i3 = b.f11888b[gVar.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.f11878c.setColor(-16777216);
                        this.f11878c.setAlpha(255);
                        canvas.drawRect(this.f11883h, this.f11878c);
                    }
                    if (gVar.d()) {
                        n(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        p(canvas, matrix, gVar, aVar, aVar2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (gVar.d()) {
                            l(canvas, matrix, gVar, aVar, aVar2);
                        } else {
                            j(canvas, matrix, gVar, aVar, aVar2);
                        }
                    }
                } else if (gVar.d()) {
                    m(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    k(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (q()) {
                this.f11878c.setAlpha(255);
                canvas.drawRect(this.f11883h, this.f11878c);
            }
        }
        e.a.a.c.a("Layer#restoreLayer");
        canvas.restore();
        e.a.a.c.b("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, e.a.a.w.k.g gVar, e.a.a.u.c.a<l, Path> aVar, e.a.a.u.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f11880e);
    }

    private boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            if (this.p.b().get(i2).a() != g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (a aVar = this.s; aVar != null; aVar = aVar.s) {
            this.t.add(aVar);
        }
    }

    private void s(Canvas canvas) {
        e.a.a.c.a("Layer#clearLayer");
        RectF rectF = this.f11883h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f11882g);
        e.a.a.c.b("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a u(d dVar, e.a.a.g gVar, e.a.a.e eVar) {
        switch (b.a[dVar.d().ordinal()]) {
            case 1:
                return new f(gVar, dVar);
            case 2:
                return new e.a.a.w.l.b(gVar, dVar, eVar.n(dVar.k()), eVar);
            case 3:
                return new g(gVar, dVar);
            case 4:
                return new c(gVar, dVar);
            case 5:
                return new e(gVar, dVar);
            case 6:
                return new h(gVar, dVar);
            default:
                e.a.a.z.d.c("Unknown layer type " + dVar.d());
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix) {
        this.f11884i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                e.a.a.w.k.g gVar = this.p.b().get(i2);
                this.a.set(this.p.a().get(i2).h());
                this.a.transform(matrix);
                int i3 = b.f11888b[gVar.a().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                if ((i3 == 3 || i3 == 4) && gVar.d()) {
                    return;
                }
                this.a.computeBounds(this.f11886k, false);
                if (i2 == 0) {
                    this.f11884i.set(this.f11886k);
                } else {
                    RectF rectF2 = this.f11884i;
                    rectF2.set(Math.min(rectF2.left, this.f11886k.left), Math.min(this.f11884i.top, this.f11886k.top), Math.max(this.f11884i.right, this.f11886k.right), Math.max(this.f11884i.bottom, this.f11886k.bottom));
                }
            }
            if (rectF.intersect(this.f11884i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        if (x() && this.o.f() != d.b.INVERT) {
            this.f11885j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.d(this.f11885j, matrix, true);
            if (rectF.intersect(this.f11885j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void C(e.a.a.u.c.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    void D(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(a aVar) {
        this.r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(a aVar) {
        this.s = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(float f2) {
        this.v.j(f2);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        e.a.a.u.c.c cVar = this.q;
        if (cVar != null) {
            cVar.l(f2 / this.o.t());
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.G(aVar.o.t() * f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).l(f2);
        }
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        A();
    }

    @Override // e.a.a.u.b.c
    public void b(List<e.a.a.u.b.c> list, List<e.a.a.u.b.c> list2) {
    }

    @Override // e.a.a.w.f
    public void c(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        if (eVar.g(getName(), i2)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i2)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(getName(), i2)) {
                D(eVar, i2 + eVar.e(getName(), i2), list, eVar2);
            }
        }
    }

    @Override // e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f11883h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.m.set(matrix);
        if (z) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.f());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.m.preConcat(aVar.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        e.a.a.c.a(this.f11887l);
        if (this.w && !this.o.v()) {
            r();
            e.a.a.c.a("Layer#parentMatrix");
            this.f11877b.reset();
            this.f11877b.set(matrix);
            for (int size = this.t.size() - 1; size >= 0; size--) {
                this.f11877b.preConcat(this.t.get(size).v.f());
            }
            e.a.a.c.b("Layer#parentMatrix");
            int intValue = (int) ((((i2 / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
            if (!x() && !w()) {
                this.f11877b.preConcat(this.v.f());
                e.a.a.c.a("Layer#drawLayer");
                t(canvas, this.f11877b, intValue);
                e.a.a.c.b("Layer#drawLayer");
                B(e.a.a.c.b(this.f11887l));
                return;
            }
            e.a.a.c.a("Layer#computeBounds");
            d(this.f11883h, this.f11877b, false);
            z(this.f11883h, matrix);
            this.f11877b.preConcat(this.v.f());
            y(this.f11883h, this.f11877b);
            if (!this.f11883h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f11883h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            e.a.a.c.b("Layer#computeBounds");
            if (!this.f11883h.isEmpty()) {
                e.a.a.c.a("Layer#saveLayer");
                this.f11878c.setAlpha(255);
                e.a.a.z.h.m(canvas, this.f11883h, this.f11878c);
                e.a.a.c.b("Layer#saveLayer");
                s(canvas);
                e.a.a.c.a("Layer#drawLayer");
                t(canvas, this.f11877b, intValue);
                e.a.a.c.b("Layer#drawLayer");
                if (w()) {
                    o(canvas, this.f11877b);
                }
                if (x()) {
                    e.a.a.c.a("Layer#drawMatte");
                    e.a.a.c.a("Layer#saveLayer");
                    e.a.a.z.h.n(canvas, this.f11883h, this.f11881f, 19);
                    e.a.a.c.b("Layer#saveLayer");
                    s(canvas);
                    this.r.f(canvas, matrix, intValue);
                    e.a.a.c.a("Layer#restoreLayer");
                    canvas.restore();
                    e.a.a.c.b("Layer#restoreLayer");
                    e.a.a.c.b("Layer#drawMatte");
                }
                e.a.a.c.a("Layer#restoreLayer");
                canvas.restore();
                e.a.a.c.b("Layer#restoreLayer");
            }
            B(e.a.a.c.b(this.f11887l));
            return;
        }
        e.a.a.c.b(this.f11887l);
    }

    @Override // e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        this.v.c(t, cVar);
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.o.g();
    }

    public void i(e.a.a.u.c.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    abstract void t(Canvas canvas, Matrix matrix, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d v() {
        return this.o;
    }

    boolean w() {
        e.a.a.u.c.g gVar = this.p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    boolean x() {
        return this.r != null;
    }
}