package e.f.h.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import e.f.d.c.h;
import e.f.d.c.i;
import e.f.h.b.b;
import e.f.h.e.t;
import e.f.h.e.u;
import e.f.h.h.b;

/* compiled from: DraweeHolder.java */
/* loaded from: classes2.dex */
public class b<DH extends e.f.h.h.b> implements u {

    /* renamed from: d  reason: collision with root package name */
    private DH f12367d;
    private boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12365b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12366c = true;

    /* renamed from: e  reason: collision with root package name */
    private e.f.h.h.a f12368e = null;

    /* renamed from: f  reason: collision with root package name */
    private final e.f.h.b.b f12369f = e.f.h.b.b.a();

    public b(DH dh) {
        if (dh != null) {
            p(dh);
        }
    }

    private void c() {
        if (this.a) {
            return;
        }
        this.f12369f.b(b.a.ON_ATTACH_CONTROLLER);
        this.a = true;
        e.f.h.h.a aVar = this.f12368e;
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f12368e.f();
    }

    private void d() {
        if (this.f12365b && this.f12366c) {
            c();
        } else {
            f();
        }
    }

    public static <DH extends e.f.h.h.b> b<DH> e(DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.n(context);
        return bVar;
    }

    private void f() {
        if (this.a) {
            this.f12369f.b(b.a.ON_DETACH_CONTROLLER);
            this.a = false;
            if (j()) {
                this.f12368e.b();
            }
        }
    }

    private void q(u uVar) {
        Drawable i2 = i();
        if (i2 instanceof t) {
            ((t) i2).j(uVar);
        }
    }

    @Override // e.f.h.e.u
    public void a() {
        if (this.a) {
            return;
        }
        e.f.d.d.a.y(e.f.h.b.b.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f12368e)), toString());
        this.f12365b = true;
        this.f12366c = true;
        d();
    }

    @Override // e.f.h.e.u
    public void b(boolean z) {
        if (this.f12366c == z) {
            return;
        }
        this.f12369f.b(z ? b.a.ON_DRAWABLE_SHOW : b.a.ON_DRAWABLE_HIDE);
        this.f12366c = z;
        d();
    }

    public e.f.h.h.a g() {
        return this.f12368e;
    }

    public DH h() {
        return (DH) i.g(this.f12367d);
    }

    public Drawable i() {
        DH dh = this.f12367d;
        if (dh == null) {
            return null;
        }
        return dh.e();
    }

    public boolean j() {
        e.f.h.h.a aVar = this.f12368e;
        return aVar != null && aVar.c() == this.f12367d;
    }

    public void k() {
        this.f12369f.b(b.a.ON_HOLDER_ATTACH);
        this.f12365b = true;
        d();
    }

    public void l() {
        this.f12369f.b(b.a.ON_HOLDER_DETACH);
        this.f12365b = false;
        d();
    }

    public boolean m(MotionEvent motionEvent) {
        if (j()) {
            return this.f12368e.d(motionEvent);
        }
        return false;
    }

    public void n(Context context) {
    }

    public void o(e.f.h.h.a aVar) {
        boolean z = this.a;
        if (z) {
            f();
        }
        if (j()) {
            this.f12369f.b(b.a.ON_CLEAR_OLD_CONTROLLER);
            this.f12368e.g(null);
        }
        this.f12368e = aVar;
        if (aVar != null) {
            this.f12369f.b(b.a.ON_SET_CONTROLLER);
            this.f12368e.g(this.f12367d);
        } else {
            this.f12369f.b(b.a.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            c();
        }
    }

    public void p(DH dh) {
        this.f12369f.b(b.a.ON_SET_HIERARCHY);
        boolean j2 = j();
        q(null);
        DH dh2 = (DH) i.g(dh);
        this.f12367d = dh2;
        Drawable e2 = dh2.e();
        b(e2 == null || e2.isVisible());
        q(this);
        if (j2) {
            this.f12368e.g(dh);
        }
    }

    public String toString() {
        return h.d(this).c("controllerAttached", this.a).c("holderAttached", this.f12365b).c("drawableVisible", this.f12366c).b("events", this.f12369f.toString()).toString();
    }
}