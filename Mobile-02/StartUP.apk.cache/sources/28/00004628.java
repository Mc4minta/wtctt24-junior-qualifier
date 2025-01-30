package e.f.j.d;

import com.facebook.common.memory.PooledByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StagingArea.java */
/* loaded from: classes2.dex */
public class u {
    private static final Class<?> a = u.class;

    /* renamed from: b  reason: collision with root package name */
    private Map<e.f.b.a.d, e.f.j.i.d> f12463b = new HashMap();

    private u() {
    }

    public static u d() {
        return new u();
    }

    private synchronized void e() {
        e.f.d.d.a.q(a, "Count = %d", Integer.valueOf(this.f12463b.size()));
    }

    public void a() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f12463b.values());
            this.f12463b.clear();
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            e.f.j.i.d dVar = (e.f.j.i.d) arrayList.get(i2);
            if (dVar != null) {
                dVar.close();
            }
        }
    }

    public synchronized boolean b(e.f.b.a.d dVar) {
        e.f.d.c.i.g(dVar);
        if (this.f12463b.containsKey(dVar)) {
            e.f.j.i.d dVar2 = this.f12463b.get(dVar);
            synchronized (dVar2) {
                if (e.f.j.i.d.d0(dVar2)) {
                    return true;
                }
                this.f12463b.remove(dVar);
                e.f.d.d.a.y(a, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(dVar2)), dVar.b(), Integer.valueOf(System.identityHashCode(dVar)));
                return false;
            }
        }
        return false;
    }

    public synchronized e.f.j.i.d c(e.f.b.a.d dVar) {
        e.f.d.c.i.g(dVar);
        e.f.j.i.d dVar2 = this.f12463b.get(dVar);
        if (dVar2 != null) {
            synchronized (dVar2) {
                if (!e.f.j.i.d.d0(dVar2)) {
                    this.f12463b.remove(dVar);
                    e.f.d.d.a.y(a, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(dVar2)), dVar.b(), Integer.valueOf(System.identityHashCode(dVar)));
                    return null;
                }
                dVar2 = e.f.j.i.d.b(dVar2);
            }
        }
        return dVar2;
    }

    public synchronized void f(e.f.b.a.d dVar, e.f.j.i.d dVar2) {
        e.f.d.c.i.g(dVar);
        e.f.d.c.i.b(e.f.j.i.d.d0(dVar2));
        e.f.j.i.d.c(this.f12463b.put(dVar, e.f.j.i.d.b(dVar2)));
        e();
    }

    public boolean g(e.f.b.a.d dVar) {
        e.f.j.i.d remove;
        e.f.d.c.i.g(dVar);
        synchronized (this) {
            remove = this.f12463b.remove(dVar);
        }
        if (remove == null) {
            return false;
        }
        try {
            return remove.a0();
        } finally {
            remove.close();
        }
    }

    public synchronized boolean h(e.f.b.a.d dVar, e.f.j.i.d dVar2) {
        e.f.d.c.i.g(dVar);
        e.f.d.c.i.g(dVar2);
        e.f.d.c.i.b(e.f.j.i.d.d0(dVar2));
        e.f.j.i.d dVar3 = this.f12463b.get(dVar);
        if (dVar3 == null) {
            return false;
        }
        com.facebook.common.references.a<PooledByteBuffer> e2 = dVar3.e();
        com.facebook.common.references.a<PooledByteBuffer> e3 = dVar2.e();
        if (e2 != null && e3 != null && e2.n() == e3.n()) {
            this.f12463b.remove(dVar);
            com.facebook.common.references.a.f(e3);
            com.facebook.common.references.a.f(e2);
            e.f.j.i.d.c(dVar3);
            e();
            return true;
        }
        com.facebook.common.references.a.f(e3);
        com.facebook.common.references.a.f(e2);
        e.f.j.i.d.c(dVar3);
        return false;
    }
}