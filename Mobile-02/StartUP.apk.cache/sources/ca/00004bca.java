package h.c.n0.a;

import h.c.n0.j.j;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes.dex */
public final class e implements h.c.k0.b, b {
    List<h.c.k0.b> a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f14094b;

    @Override // h.c.n0.a.b
    public boolean a(h.c.k0.b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // h.c.n0.a.b
    public boolean b(h.c.k0.b bVar) {
        h.c.n0.b.b.e(bVar, "d is null");
        if (!this.f14094b) {
            synchronized (this) {
                if (!this.f14094b) {
                    List list = this.a;
                    if (list == null) {
                        list = new LinkedList();
                        this.a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // h.c.n0.a.b
    public boolean c(h.c.k0.b bVar) {
        h.c.n0.b.b.e(bVar, "Disposable item is null");
        if (this.f14094b) {
            return false;
        }
        synchronized (this) {
            if (this.f14094b) {
                return false;
            }
            List<h.c.k0.b> list = this.a;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    void d(List<h.c.k0.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (h.c.k0.b bVar : list) {
            try {
                bVar.dispose();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw j.e((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    @Override // h.c.k0.b
    public void dispose() {
        if (this.f14094b) {
            return;
        }
        synchronized (this) {
            if (this.f14094b) {
                return;
            }
            this.f14094b = true;
            List<h.c.k0.b> list = this.a;
            this.a = null;
            d(list);
        }
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f14094b;
    }
}