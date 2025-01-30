package e.f.j.l;

/* compiled from: BaseConsumer.java */
/* loaded from: classes2.dex */
public abstract class b<T> implements k<T> {
    private boolean a = false;

    public static boolean d(int i2) {
        return (i2 & 1) == 1;
    }

    public static boolean e(int i2) {
        return !d(i2);
    }

    public static int k(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean l(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static boolean m(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static int n(int i2, int i3) {
        return i2 & (~i3);
    }

    @Override // e.f.j.l.k
    public synchronized void a() {
        if (this.a) {
            return;
        }
        this.a = true;
        try {
            f();
        } catch (Exception e2) {
            j(e2);
        }
    }

    @Override // e.f.j.l.k
    public synchronized void b(float f2) {
        if (this.a) {
            return;
        }
        try {
            i(f2);
        } catch (Exception e2) {
            j(e2);
        }
    }

    @Override // e.f.j.l.k
    public synchronized void c(T t, int i2) {
        if (this.a) {
            return;
        }
        this.a = d(i2);
        try {
            h(t, i2);
        } catch (Exception e2) {
            j(e2);
        }
    }

    protected abstract void f();

    protected abstract void g(Throwable th);

    protected abstract void h(T t, int i2);

    protected abstract void i(float f2);

    protected void j(Exception exc) {
        e.f.d.d.a.E(getClass(), "unhandled exception", exc);
    }

    @Override // e.f.j.l.k
    public synchronized void onFailure(Throwable th) {
        if (this.a) {
            return;
        }
        this.a = true;
        try {
            g(th);
        } catch (Exception e2) {
            j(e2);
        }
    }
}