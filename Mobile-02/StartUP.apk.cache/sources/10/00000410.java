package androidx.room;

/* compiled from: EntityDeletionOrUpdateAdapter.java */
/* loaded from: classes.dex */
public abstract class b<T> extends q {
    public b(j jVar) {
        super(jVar);
    }

    protected abstract void bind(c.r.a.f fVar, T t);

    @Override // androidx.room.q
    protected abstract String createQuery();

    public final int handle(T t) {
        c.r.a.f acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.y();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        c.r.a.f acquire = acquire();
        int i2 = 0;
        try {
            for (T t : iterable) {
                bind(acquire, t);
                i2 += acquire.y();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        c.r.a.f acquire = acquire();
        try {
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                i2 += acquire.y();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }
}