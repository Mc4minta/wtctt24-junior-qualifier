package h.c.n0.b;

import h.c.m0.d;
import java.util.Objects;

/* compiled from: ObjectHelper.java */
/* loaded from: classes.dex */
public final class b {
    static final d<Object, Object> a = new a();

    /* compiled from: ObjectHelper.java */
    /* loaded from: classes.dex */
    static final class a implements d<Object, Object> {
        a() {
        }

        @Override // h.c.m0.d
        public boolean a(Object obj, Object obj2) {
            return b.c(obj, obj2);
        }
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int b(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> d<T, T> d() {
        return (d<T, T>) a;
    }

    public static <T> T e(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int f(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    public static long g(long j2, String str) {
        if (j2 > 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j2);
    }
}