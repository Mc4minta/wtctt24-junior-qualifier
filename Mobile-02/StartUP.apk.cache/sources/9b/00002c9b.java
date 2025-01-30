package com.facebook.imagepipeline.memory;

/* compiled from: BitmapCounterProvider.java */
/* loaded from: classes2.dex */
public class b {
    private static final Class<?> a = b.class;

    /* renamed from: b  reason: collision with root package name */
    public static final int f4565b = b();

    /* renamed from: c  reason: collision with root package name */
    private static int f4566c = 384;

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f4567d;

    public static a a() {
        if (f4567d == null) {
            synchronized (b.class) {
                if (f4567d == null) {
                    f4567d = new a(f4566c, f4565b);
                }
            }
        }
        return f4567d;
    }

    private static int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min > 16777216) {
            return (min / 4) * 3;
        }
        return min / 2;
    }
}