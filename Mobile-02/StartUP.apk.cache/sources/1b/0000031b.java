package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Lifecycle.java */
/* loaded from: classes.dex */
public abstract class i {
    AtomicReference<Object> a = new AtomicReference<>();

    /* compiled from: Lifecycle.java */
    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* compiled from: Lifecycle.java */
    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean h(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(n nVar);

    public abstract b b();

    public abstract void c(n nVar);
}