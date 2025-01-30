package e.g.a.c;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* loaded from: classes2.dex */
public abstract class c<T> {
    public static <T> c<T> d(T t) {
        return new a(null, t, d.VERY_LOW);
    }

    public static <T> c<T> e(T t) {
        return new a(null, t, d.HIGHEST);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract d c();
}