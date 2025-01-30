package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* compiled from: UnsafeUtil.java */
/* loaded from: classes2.dex */
final class w {
    private static final Unsafe a = g();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f9757b = k();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f9758c = j();

    /* renamed from: d  reason: collision with root package name */
    private static final long f9759d = a();

    /* renamed from: e  reason: collision with root package name */
    private static final long f9760e = c(b(Buffer.class, "address"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnsafeUtil.java */
    /* loaded from: classes2.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    private static int a() {
        if (f9758c) {
            return a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static Field b(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long c(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = a) == null) {
            return -1L;
        }
        return unsafe.objectFieldOffset(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long d() {
        return f9759d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte e(byte[] bArr, long j2) {
        return a.getByte(bArr, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long f(byte[] bArr, long j2) {
        return a.getLong(bArr, j2);
    }

    private static Unsafe g() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h() {
        return f9758c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return f9757b;
    }

    private static boolean j() {
        Unsafe unsafe = a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("arrayBaseOffset", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean k() {
        Unsafe unsafe = a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}