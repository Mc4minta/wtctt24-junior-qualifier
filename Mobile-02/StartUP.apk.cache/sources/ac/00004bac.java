package h.c.k0;

import h.c.n0.j.j;
import h.c.n0.j.o;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;

/* compiled from: CompositeDisposable.java */
/* loaded from: classes2.dex */
public final class a implements b, h.c.n0.a.b {
    o<b> a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f14090b;

    @Override // h.c.n0.a.b
    public boolean a(b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // h.c.n0.a.b
    public boolean b(b bVar) {
        h.c.n0.b.b.e(bVar, "disposable is null");
        if (!this.f14090b) {
            synchronized (this) {
                if (!this.f14090b) {
                    o<b> oVar = this.a;
                    if (oVar == null) {
                        oVar = new o<>();
                        this.a = oVar;
                    }
                    oVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // h.c.n0.a.b
    public boolean c(b bVar) {
        h.c.n0.b.b.e(bVar, "disposables is null");
        if (this.f14090b) {
            return false;
        }
        synchronized (this) {
            if (this.f14090b) {
                return false;
            }
            o<b> oVar = this.a;
            if (oVar != null && oVar.e(bVar)) {
                return true;
            }
            return false;
        }
    }

    public void d() {
        if (this.f14090b) {
            return;
        }
        synchronized (this) {
            if (this.f14090b) {
                return;
            }
            o<b> oVar = this.a;
            this.a = null;
            e(oVar);
        }
    }

    @Override // h.c.k0.b
    public void dispose() {
        if (this.f14090b) {
            return;
        }
        synchronized (this) {
            if (this.f14090b) {
                return;
            }
            this.f14090b = true;
            o<b> oVar = this.a;
            this.a = null;
            e(oVar);
        }
    }

    void e(o<b> oVar) {
        Object[] b2;
        if (oVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : oVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw j.e((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    public int f() {
        if (this.f14090b) {
            return 0;
        }
        synchronized (this) {
            if (this.f14090b) {
                return 0;
            }
            o<b> oVar = this.a;
            return oVar != null ? oVar.g() : 0;
        }
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f14090b;
    }
}