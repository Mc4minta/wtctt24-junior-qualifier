package e.f.j.i;

import java.io.Closeable;

/* compiled from: CloseableImage.java */
/* loaded from: classes2.dex */
public abstract class b implements Closeable, e {
    public g a() {
        return f.a;
    }

    public abstract int b();

    public boolean c() {
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    protected void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        e.f.d.d.a.C("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public abstract boolean isClosed();
}