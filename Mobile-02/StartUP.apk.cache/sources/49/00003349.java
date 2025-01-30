package com.google.android.gms.internal.p000firebaseperf;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.c2  reason: invalid package */
/* loaded from: classes2.dex */
public final class c2 {
    public static void a(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @NonNullDecl
    public static <T> T b(@NonNullDecl T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int c(int i2, int i3) {
        String b2;
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                b2 = c5.b("%s (%s) must not be negative", "index", Integer.valueOf(i2));
            } else if (i3 < 0) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            } else {
                b2 = c5.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(b2);
        }
        return i2;
    }

    private static String d(int i2, int i3, @NullableDecl String str) {
        if (i2 < 0) {
            return c5.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return c5.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void e(int i2, int i3, int i4) {
        String d2;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 >= 0 && i2 <= i4) {
                d2 = (i3 < 0 || i3 > i4) ? d(i3, i4, "end index") : c5.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            } else {
                d2 = d(i2, i4, "start index");
            }
            throw new IndexOutOfBoundsException(d2);
        }
    }

    public static int f(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(d(i2, i3, "index"));
        }
        return i2;
    }
}