package androidx.recyclerview.widget;

import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class u {
    final c.e.g<RecyclerView.e0, a> a = new c.e.g<>();

    /* renamed from: b  reason: collision with root package name */
    final c.e.d<RecyclerView.e0> f2214b = new c.e.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public static class a {
        static androidx.core.util.f<a> a = new Pools$SimplePool(20);

        /* renamed from: b  reason: collision with root package name */
        int f2215b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.l.c f2216c;

        /* renamed from: d  reason: collision with root package name */
        RecyclerView.l.c f2217d;

        private a() {
        }

        static void a() {
            do {
            } while (a.acquire() != null);
        }

        static a b() {
            a acquire = a.acquire();
            return acquire == null ? new a() : acquire;
        }

        static void c(a aVar) {
            aVar.f2215b = 0;
            aVar.f2216c = null;
            aVar.f2217d = null;
            a.release(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.e0 e0Var);

        void b(RecyclerView.e0 e0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.e0 e0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.e0 e0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    private RecyclerView.l.c l(RecyclerView.e0 e0Var, int i2) {
        a valueAt;
        RecyclerView.l.c cVar;
        int indexOfKey = this.a.indexOfKey(e0Var);
        if (indexOfKey >= 0 && (valueAt = this.a.valueAt(indexOfKey)) != null) {
            int i3 = valueAt.f2215b;
            if ((i3 & i2) != 0) {
                int i4 = (~i2) & i3;
                valueAt.f2215b = i4;
                if (i2 == 4) {
                    cVar = valueAt.f2216c;
                } else if (i2 == 8) {
                    cVar = valueAt.f2217d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i4 & 12) == 0) {
                    this.a.removeAt(indexOfKey);
                    a.c(valueAt);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.e0 e0Var, RecyclerView.l.c cVar) {
        a aVar = this.a.get(e0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(e0Var, aVar);
        }
        aVar.f2215b |= 2;
        aVar.f2216c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.e0 e0Var) {
        a aVar = this.a.get(e0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(e0Var, aVar);
        }
        aVar.f2215b |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j2, RecyclerView.e0 e0Var) {
        this.f2214b.n(j2, e0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.e0 e0Var, RecyclerView.l.c cVar) {
        a aVar = this.a.get(e0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(e0Var, aVar);
        }
        aVar.f2217d = cVar;
        aVar.f2215b |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.e0 e0Var, RecyclerView.l.c cVar) {
        a aVar = this.a.get(e0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(e0Var, aVar);
        }
        aVar.f2216c = cVar;
        aVar.f2215b |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.a.clear();
        this.f2214b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.e0 g(long j2) {
        return this.f2214b.h(j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.e0 e0Var) {
        a aVar = this.a.get(e0Var);
        return (aVar == null || (aVar.f2215b & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.e0 e0Var) {
        a aVar = this.a.get(e0Var);
        return (aVar == null || (aVar.f2215b & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.e0 e0Var) {
        p(e0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.e0 e0Var) {
        return l(e0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.e0 e0Var) {
        return l(e0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.e0 keyAt = this.a.keyAt(size);
            a removeAt = this.a.removeAt(size);
            int i2 = removeAt.f2215b;
            if ((i2 & 3) == 3) {
                bVar.a(keyAt);
            } else if ((i2 & 1) != 0) {
                RecyclerView.l.c cVar = removeAt.f2216c;
                if (cVar == null) {
                    bVar.a(keyAt);
                } else {
                    bVar.c(keyAt, cVar, removeAt.f2217d);
                }
            } else if ((i2 & 14) == 14) {
                bVar.b(keyAt, removeAt.f2216c, removeAt.f2217d);
            } else if ((i2 & 12) == 12) {
                bVar.d(keyAt, removeAt.f2216c, removeAt.f2217d);
            } else if ((i2 & 4) != 0) {
                bVar.c(keyAt, removeAt.f2216c, null);
            } else if ((i2 & 8) != 0) {
                bVar.b(keyAt, removeAt.f2216c, removeAt.f2217d);
            }
            a.c(removeAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.e0 e0Var) {
        a aVar = this.a.get(e0Var);
        if (aVar == null) {
            return;
        }
        aVar.f2215b &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.e0 e0Var) {
        int q = this.f2214b.q() - 1;
        while (true) {
            if (q < 0) {
                break;
            } else if (e0Var == this.f2214b.r(q)) {
                this.f2214b.p(q);
                break;
            } else {
                q--;
            }
        }
        a remove = this.a.remove(e0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}