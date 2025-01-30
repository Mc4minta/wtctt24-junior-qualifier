package f.c;

import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class h {
    public static <T> void a(T t, Class<T> cls) {
        if (t != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T c(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static <T> T d(T t, String str, Object obj) {
        String valueOf;
        if (t == null) {
            if (str.contains("%s")) {
                if (str.indexOf("%s") == str.lastIndexOf("%s")) {
                    if (obj instanceof Class) {
                        valueOf = ((Class) obj).getCanonicalName();
                    } else {
                        valueOf = String.valueOf(obj);
                    }
                    throw new NullPointerException(str.replace("%s", valueOf));
                }
                throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
            }
            throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
        }
        return t;
    }

    public static <T> T e(T t) {
        Objects.requireNonNull(t, "Cannot return null from a non-@Nullable component method");
        return t;
    }

    public static <T> T f(T t) {
        Objects.requireNonNull(t, "Cannot return null from a non-@Nullable @Provides method");
        return t;
    }
}