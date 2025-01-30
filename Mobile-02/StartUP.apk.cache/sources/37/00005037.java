package h.c.n0.j;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AtomicThrowable.java */
/* loaded from: classes3.dex */
public final class c extends AtomicReference<Throwable> {
    public boolean a(Throwable th) {
        return j.a(this, th);
    }

    public Throwable b() {
        return j.b(this);
    }
}