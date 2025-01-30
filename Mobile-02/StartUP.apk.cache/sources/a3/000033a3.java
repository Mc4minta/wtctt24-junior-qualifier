package com.google.android.gms.internal.p000firebaseperf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k7  reason: invalid package */
/* loaded from: classes2.dex */
public final class k7 {
    private static final Logger a = Logger.getLogger(k7.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f6797b;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f6798c;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f6799d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f6800e;

    /* renamed from: f  reason: collision with root package name */
    private static final c f6801f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f6802g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f6803h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f6804i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f6805j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f6806k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f6807l;
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
    private static final int w;
    static final boolean x;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.k7$a */
    /* loaded from: classes2.dex */
    static final class a extends c {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void a(Object obj, long j2, double d2) {
            d(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void b(Object obj, long j2, float f2) {
            c(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void e(Object obj, long j2, boolean z) {
            if (k7.x) {
                k7.l(obj, j2, z);
            } else {
                k7.n(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void f(Object obj, long j2, byte b2) {
            if (k7.x) {
                k7.b(obj, j2, b2);
            } else {
                k7.k(obj, j2, b2);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final boolean i(Object obj, long j2) {
            return k7.x ? k7.J(obj, j2) : k7.K(obj, j2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final float j(Object obj, long j2) {
            return Float.intBitsToFloat(g(obj, j2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final double k(Object obj, long j2) {
            return Double.longBitsToDouble(h(obj, j2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final byte l(Object obj, long j2) {
            return k7.x ? k7.H(obj, j2) : k7.I(obj, j2);
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.k7$b */
    /* loaded from: classes2.dex */
    static final class b extends c {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void a(Object obj, long j2, double d2) {
            d(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void b(Object obj, long j2, float f2) {
            c(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void e(Object obj, long j2, boolean z) {
            if (k7.x) {
                k7.l(obj, j2, z);
            } else {
                k7.n(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void f(Object obj, long j2, byte b2) {
            if (k7.x) {
                k7.b(obj, j2, b2);
            } else {
                k7.k(obj, j2, b2);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final boolean i(Object obj, long j2) {
            return k7.x ? k7.J(obj, j2) : k7.K(obj, j2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final float j(Object obj, long j2) {
            return Float.intBitsToFloat(g(obj, j2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final double k(Object obj, long j2) {
            return Double.longBitsToDouble(h(obj, j2));
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final byte l(Object obj, long j2) {
            return k7.x ? k7.H(obj, j2) : k7.I(obj, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.k7$c */
    /* loaded from: classes2.dex */
    public static abstract class c {
        Unsafe a;

        c(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract void a(Object obj, long j2, double d2);

        public abstract void b(Object obj, long j2, float f2);

        public final void c(Object obj, long j2, int i2) {
            this.a.putInt(obj, j2, i2);
        }

        public final void d(Object obj, long j2, long j3) {
            this.a.putLong(obj, j2, j3);
        }

        public abstract void e(Object obj, long j2, boolean z);

        public abstract void f(Object obj, long j2, byte b2);

        public final int g(Object obj, long j2) {
            return this.a.getInt(obj, j2);
        }

        public final long h(Object obj, long j2) {
            return this.a.getLong(obj, j2);
        }

        public abstract boolean i(Object obj, long j2);

        public abstract float j(Object obj, long j2);

        public abstract double k(Object obj, long j2);

        public abstract byte l(Object obj, long j2);
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.k7$d */
    /* loaded from: classes2.dex */
    static final class d extends c {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void a(Object obj, long j2, double d2) {
            this.a.putDouble(obj, j2, d2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void b(Object obj, long j2, float f2) {
            this.a.putFloat(obj, j2, f2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void e(Object obj, long j2, boolean z) {
            this.a.putBoolean(obj, j2, z);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final void f(Object obj, long j2, byte b2) {
            this.a.putByte(obj, j2, b2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final boolean i(Object obj, long j2) {
            return this.a.getBoolean(obj, j2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final float j(Object obj, long j2) {
            return this.a.getFloat(obj, j2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final double k(Object obj, long j2) {
            return this.a.getDouble(obj, j2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.k7.c
        public final byte l(Object obj, long j2) {
            return this.a.getByte(obj, j2);
        }
    }

    static {
        Unsafe y = y();
        f6797b = y;
        f6798c = g3.c();
        boolean v2 = v(Long.TYPE);
        f6799d = v2;
        boolean v3 = v(Integer.TYPE);
        f6800e = v3;
        c cVar = null;
        if (y != null) {
            if (!g3.b()) {
                cVar = new d(y);
            } else if (v2) {
                cVar = new a(y);
            } else if (v3) {
                cVar = new b(y);
            }
        }
        f6801f = cVar;
        f6802g = A();
        f6803h = z();
        long s2 = s(byte[].class);
        f6804i = s2;
        f6805j = s(boolean[].class);
        f6806k = t(boolean[].class);
        f6807l = s(int[].class);
        m = t(int[].class);
        n = s(long[].class);
        o = t(long[].class);
        p = s(float[].class);
        q = t(float[].class);
        r = s(double[].class);
        s = t(double[].class);
        t = s(Object[].class);
        u = t(Object[].class);
        Field B = B();
        v = (B == null || cVar == null) ? -1L : cVar.a.objectFieldOffset(B);
        w = (int) (7 & s2);
        x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private k7() {
    }

    private static boolean A() {
        Unsafe unsafe = f6797b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (B() == null) {
                return false;
            }
            if (g3.b()) {
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

    private static Field B() {
        Field j2;
        if (!g3.b() || (j2 = j(Buffer.class, "effectiveDirectAddress")) == null) {
            Field j3 = j(Buffer.class, "address");
            if (j3 == null || j3.getType() != Long.TYPE) {
                return null;
            }
            return j3;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long C(Object obj, long j2) {
        return f6801f.h(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean D(Object obj, long j2) {
        return f6801f.i(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float E(Object obj, long j2) {
        return f6801f.j(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double F(Object obj, long j2) {
        return f6801f.k(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object G(Object obj, long j2) {
        return f6801f.a.getObject(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte H(Object obj, long j2) {
        return (byte) (u(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte I(Object obj, long j2) {
        return (byte) (u(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean J(Object obj, long j2) {
        return H(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean K(Object obj, long j2) {
        return I(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j2) {
        return f6801f.l(bArr, f6804i + j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int u2 = u(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        e(obj, j3, ((255 & b2) << i2) | (u2 & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Object obj, long j2, double d2) {
        f6801f.a(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Object obj, long j2, float f2) {
        f6801f.b(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Object obj, long j2, int i2) {
        f6801f.c(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Object obj, long j2, long j3) {
        f6801f.d(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Object obj, long j2, Object obj2) {
        f6801f.a.putObject(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Object obj, long j2, boolean z) {
        f6801f.e(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(byte[] bArr, long j2, byte b2) {
        f6801f.f(bArr, f6804i + j2, b2);
    }

    private static Field j(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        e(obj, j3, ((255 & b2) << i2) | (u(obj, j3) & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Object obj, long j2, boolean z) {
        b(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(Object obj, long j2, boolean z) {
        k(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T r(Class<T> cls) {
        try {
            return (T) f6797b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int s(Class<?> cls) {
        if (f6803h) {
            return f6801f.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int t(Class<?> cls) {
        if (f6803h) {
            return f6801f.a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(Object obj, long j2) {
        return f6801f.g(obj, j2);
    }

    private static boolean v(Class<?> cls) {
        if (g3.b()) {
            try {
                Class<?> cls2 = f6798c;
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
    public static boolean w() {
        return f6803h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return f6802g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe y() {
        try {
            return (Unsafe) AccessController.doPrivileged(new j7());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean z() {
        Unsafe unsafe = f6797b;
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
            if (g3.b()) {
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
}