package androidx.room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: EntityInsertionAdapter.java */
/* loaded from: classes.dex */
public abstract class c<T> extends q {
    public c(j jVar) {
        super(jVar);
    }

    protected abstract void bind(c.r.a.f fVar, T t);

    public final void insert(T t) {
        c.r.a.f acquire = acquire();
        try {
            bind(acquire, t);
            acquire.b1();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        c.r.a.f acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.b1();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        c.r.a.f acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i2 = 0;
            for (T t : collection) {
                bind(acquire, t);
                jArr[i2] = acquire.b1();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        c.r.a.f acquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            int i2 = 0;
            for (T t : collection) {
                bind(acquire, t);
                lArr[i2] = Long.valueOf(acquire.b1());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        c.r.a.f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                arrayList.add(i2, Long.valueOf(acquire.b1()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        c.r.a.f acquire = acquire();
        try {
            for (T t : tArr) {
                bind(acquire, t);
                acquire.b1();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        c.r.a.f acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                jArr[i2] = acquire.b1();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        c.r.a.f acquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                lArr[i2] = Long.valueOf(acquire.b1());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        c.r.a.f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i2 = 0;
            for (T t : collection) {
                bind(acquire, t);
                arrayList.add(i2, Long.valueOf(acquire.b1()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        c.r.a.f acquire = acquire();
        try {
            for (T t : iterable) {
                bind(acquire, t);
                acquire.b1();
            }
        } finally {
            release(acquire);
        }
    }
}