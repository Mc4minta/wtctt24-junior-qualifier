package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class l {
    private static String a(int i2, int i3, String str) {
        if (i2 < 0) {
            return s("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return s("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }

    private static String b(int i2, int i3, String str) {
        if (i2 < 0) {
            return s("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return s("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }

    private static String c(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > i4) {
            return b(i2, i4, "start index");
        }
        return (i3 < 0 || i3 > i4) ? b(i3, i4, "end index") : s("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(s(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static int g(int i2, int i3) {
        return h(i2, i3, "index");
    }

    @CanIgnoreReturnValue
    public static int h(int i2, int i3, String str) {
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException(a(i2, i3, str));
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public static <T> T i(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    @CanIgnoreReturnValue
    public static <T> T j(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static <T> T k(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(s(str, objArr));
    }

    @CanIgnoreReturnValue
    public static int l(int i2, int i3) {
        return m(i2, i3, "index");
    }

    @CanIgnoreReturnValue
    public static int m(int i2, int i3, String str) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(b(i2, i3, str));
        }
        return i2;
    }

    public static void n(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException(c(i2, i3, i4));
        }
    }

    public static void o(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void p(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void q(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(s(str, obj));
        }
    }

    public static void r(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(s(str, objArr));
        }
    }

    static String s(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i2]);
            i3 = indexOf + 2;
            i2++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i4 = i2 + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}