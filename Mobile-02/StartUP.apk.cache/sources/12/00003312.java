package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x3 {
    private static final Logger a = Logger.getLogger(x3.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f6623b;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f6624c;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f6625d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f6626e;

    /* renamed from: f  reason: collision with root package name */
    private static final d f6627f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f6628g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f6629h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f6630i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f6631j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f6632k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f6633l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final long w;
    private static final boolean x;

    /* loaded from: classes2.dex */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void b(long j2, byte b2) {
            Memory.pokeByte((int) (j2 & (-1)), b2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void c(Object obj, long j2, double d2) {
            f(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void d(Object obj, long j2, float f2) {
            e(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void g(Object obj, long j2, boolean z) {
            if (x3.x) {
                x3.r(obj, j2, z);
            } else {
                x3.t(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void h(byte[] bArr, long j2, long j3, long j4) {
            Memory.pokeByteArray((int) (j3 & (-1)), bArr, (int) j2, (int) j4);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void i(Object obj, long j2, byte b2) {
            if (x3.x) {
                x3.d(obj, j2, b2);
            } else {
                x3.q(obj, j2, b2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final boolean l(Object obj, long j2) {
            return x3.x ? x3.P(obj, j2) : x3.Q(obj, j2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final float m(Object obj, long j2) {
            return Float.intBitsToFloat(j(obj, j2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final double n(Object obj, long j2) {
            return Double.longBitsToDouble(k(obj, j2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final byte o(Object obj, long j2) {
            return x3.x ? x3.N(obj, j2) : x3.O(obj, j2);
        }
    }

    /* loaded from: classes2.dex */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void b(long j2, byte b2) {
            Memory.pokeByte(j2, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void c(Object obj, long j2, double d2) {
            f(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void d(Object obj, long j2, float f2) {
            e(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void g(Object obj, long j2, boolean z) {
            if (x3.x) {
                x3.r(obj, j2, z);
            } else {
                x3.t(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void h(byte[] bArr, long j2, long j3, long j4) {
            Memory.pokeByteArray(j3, bArr, (int) j2, (int) j4);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void i(Object obj, long j2, byte b2) {
            if (x3.x) {
                x3.d(obj, j2, b2);
            } else {
                x3.q(obj, j2, b2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final boolean l(Object obj, long j2) {
            return x3.x ? x3.P(obj, j2) : x3.Q(obj, j2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final float m(Object obj, long j2) {
            return Float.intBitsToFloat(j(obj, j2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final double n(Object obj, long j2) {
            return Double.longBitsToDouble(k(obj, j2));
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final byte o(Object obj, long j2) {
            return x3.x ? x3.N(obj, j2) : x3.O(obj, j2);
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void b(long j2, byte b2) {
            this.a.putByte(j2, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void c(Object obj, long j2, double d2) {
            this.a.putDouble(obj, j2, d2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void d(Object obj, long j2, float f2) {
            this.a.putFloat(obj, j2, f2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void g(Object obj, long j2, boolean z) {
            this.a.putBoolean(obj, j2, z);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void h(byte[] bArr, long j2, long j3, long j4) {
            this.a.copyMemory(bArr, x3.f6630i + j2, (Object) null, j3, j4);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final void i(Object obj, long j2, byte b2) {
            this.a.putByte(obj, j2, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final boolean l(Object obj, long j2) {
            return this.a.getBoolean(obj, j2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final float m(Object obj, long j2) {
            return this.a.getFloat(obj, j2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final double n(Object obj, long j2) {
            return this.a.getDouble(obj, j2);
        }

        @Override // com.google.android.gms.internal.clearcut.x3.d
        public final byte o(Object obj, long j2) {
            return this.a.getByte(obj, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class d {
        Unsafe a;

        d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final long a(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void b(long j2, byte b2);

        public abstract void c(Object obj, long j2, double d2);

        public abstract void d(Object obj, long j2, float f2);

        public final void e(Object obj, long j2, int i2) {
            this.a.putInt(obj, j2, i2);
        }

        public final void f(Object obj, long j2, long j3) {
            this.a.putLong(obj, j2, j3);
        }

        public abstract void g(Object obj, long j2, boolean z);

        public abstract void h(byte[] bArr, long j2, long j3, long j4);

        public abstract void i(Object obj, long j2, byte b2);

        public final int j(Object obj, long j2) {
            return this.a.getInt(obj, j2);
        }

        public final long k(Object obj, long j2) {
            return this.a.getLong(obj, j2);
        }

        public abstract boolean l(Object obj, long j2);

        public abstract float m(Object obj, long j2);

        public abstract double n(Object obj, long j2);

        public abstract byte o(Object obj, long j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ec  */
    static {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.x3.<clinit>():void");
    }

    private x3() {
    }

    private static boolean A() {
        Unsafe unsafe = f6623b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (u.b()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean B() {
        Unsafe unsafe = f6623b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (C() == null) {
                return false;
            }
            if (u.b()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field C() {
        Field p2;
        if (!u.b() || (p2 = p(Buffer.class, "effectiveDirectAddress")) == null) {
            Field p3 = p(Buffer.class, "address");
            if (p3 == null || p3.getType() != Long.TYPE) {
                return null;
            }
            return p3;
        }
        return p2;
    }

    private static int E(Class<?> cls) {
        if (f6629h) {
            return f6627f.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int F(Class<?> cls) {
        if (f6629h) {
            return f6627f.a.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean G(Class<?> cls) {
        if (u.b()) {
            try {
                Class<?> cls2 = f6624c;
                Class<?> cls3 = Boolean.TYPE;
                cls2.getMethod("peekLong", cls, cls3);
                cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
                Class<?> cls4 = Integer.TYPE;
                cls2.getMethod("pokeInt", cls, cls4, cls3);
                cls2.getMethod("peekInt", cls, cls3);
                cls2.getMethod("pokeByte", cls, Byte.TYPE);
                cls2.getMethod("peekByte", cls);
                cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
                cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(Object obj, long j2) {
        return f6627f.j(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long I(Object obj, long j2) {
        return f6627f.k(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J(Object obj, long j2) {
        return f6627f.l(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float K(Object obj, long j2) {
        return f6627f.m(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double L(Object obj, long j2) {
        return f6627f.n(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object M(Object obj, long j2) {
        return f6627f.a.getObject(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte N(Object obj, long j2) {
        return (byte) (H(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte O(Object obj, long j2) {
        return (byte) (H(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(Object obj, long j2) {
        return N(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Q(Object obj, long j2) {
        return O(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j2) {
        return f6627f.o(bArr, f6630i + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(Field field) {
        return f6627f.a(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(long j2, byte b2) {
        f6627f.b(j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int H = H(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        g(obj, j3, ((255 & b2) << i2) | (H & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Object obj, long j2, double d2) {
        f6627f.c(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Object obj, long j2, float f2) {
        f6627f.d(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Object obj, long j2, int i2) {
        f6627f.e(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Object obj, long j2, long j3) {
        f6627f.f(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Object obj, long j2, Object obj2) {
        f6627f.a.putObject(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(Object obj, long j2, boolean z) {
        f6627f.g(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(byte[] bArr, long j2, byte b2) {
        f6627f.i(bArr, f6630i + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(byte[] bArr, long j2, long j3, long j4) {
        f6627f.h(bArr, j2, j3, j4);
    }

    private static long n(Field field) {
        d dVar;
        if (field == null || (dVar = f6627f) == null) {
            return -1L;
        }
        return dVar.a(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long o(ByteBuffer byteBuffer) {
        return f6627f.k(byteBuffer, v);
    }

    private static Field p(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        g(obj, j3, ((255 & b2) << i2) | (H(obj, j3) & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(Object obj, long j2, boolean z) {
        q(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return f6629h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y() {
        return f6628g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe z() {
        try {
            return (Unsafe) AccessController.doPrivileged(new y3());
        } catch (Throwable unused) {
            return null;
        }
    }
}