package e.f.d.c;

/* compiled from: Throwables.java */
/* loaded from: classes2.dex */
public final class n {
    public static RuntimeException a(Throwable th) {
        c((Throwable) i.g(th));
        throw new RuntimeException(th);
    }

    public static <X extends Throwable> void b(Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void c(Throwable th) {
        b(th, Error.class);
        b(th, RuntimeException.class);
    }
}