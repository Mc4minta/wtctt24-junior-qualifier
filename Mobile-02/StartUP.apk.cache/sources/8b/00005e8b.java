package org.apache.http.util;

import java.util.Collection;

/* loaded from: classes3.dex */
public class Args {
    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T extends CharSequence> T containsNoBlanks(T t, String str) {
        if (t != null) {
            if (t.length() != 0) {
                if (TextUtils.containsBlanks(t)) {
                    throw new IllegalArgumentException(str + " may not contain blanks");
                }
                return t;
            }
            throw new IllegalArgumentException(str + " may not be empty");
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static <T extends CharSequence> T notBlank(T t, String str) {
        if (t != null) {
            if (TextUtils.isBlank(t)) {
                throw new IllegalArgumentException(str + " may not be blank");
            }
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static <T extends CharSequence> T notEmpty(T t, String str) {
        if (t != null) {
            if (TextUtils.isEmpty(t)) {
                throw new IllegalArgumentException(str + " may not be empty");
            }
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static int notNegative(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static <T> T notNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static int positive(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static long notNegative(long j2, String str) {
        if (j2 >= 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static long positive(long j2, String str) {
        if (j2 > 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static void check(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }

    public static <E, T extends Collection<E>> T notEmpty(T t, String str) {
        if (t != null) {
            if (t.isEmpty()) {
                throw new IllegalArgumentException(str + " may not be empty");
            }
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }
}