package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class j7 {
    private static final Logger a = Logger.getLogger(j7.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f7200b;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f7201c;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f7202d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f7203e;

    /* renamed from: f  reason: collision with root package name */
    private static final c f7204f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f7205g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f7206h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f7207i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f7208j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f7209k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f7210l;
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

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    static final class a extends c {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final byte a(Object obj, long j2) {
            return j7.x ? j7.L(obj, j2) : j7.M(obj, j2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void b(Object obj, long j2, byte b2) {
            if (j7.x) {
                j7.u(obj, j2, b2);
            } else {
                j7.y(obj, j2, b2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void c(Object obj, long j2, double d2) {
            f(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void d(Object obj, long j2, float f2) {
            e(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void g(Object obj, long j2, boolean z) {
            if (j7.x) {
                j7.z(obj, j2, z);
            } else {
                j7.D(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final boolean h(Object obj, long j2) {
            return j7.x ? j7.N(obj, j2) : j7.O(obj, j2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final float i(Object obj, long j2) {
            return Float.intBitsToFloat(k(obj, j2));
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final double j(Object obj, long j2) {
            return Double.longBitsToDouble(l(obj, j2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    static final class b extends c {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final byte a(Object obj, long j2) {
            return j7.x ? j7.L(obj, j2) : j7.M(obj, j2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void b(Object obj, long j2, byte b2) {
            if (j7.x) {
                j7.u(obj, j2, b2);
            } else {
                j7.y(obj, j2, b2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void c(Object obj, long j2, double d2) {
            f(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void d(Object obj, long j2, float f2) {
            e(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void g(Object obj, long j2, boolean z) {
            if (j7.x) {
                j7.z(obj, j2, z);
            } else {
                j7.D(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final boolean h(Object obj, long j2) {
            return j7.x ? j7.N(obj, j2) : j7.O(obj, j2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final float i(Object obj, long j2) {
            return Float.intBitsToFloat(k(obj, j2));
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final double j(Object obj, long j2) {
            return Double.longBitsToDouble(l(obj, j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    public static abstract class c {
        Unsafe a;

        c(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract byte a(Object obj, long j2);

        public abstract void b(Object obj, long j2, byte b2);

        public abstract void c(Object obj, long j2, double d2);

        public abstract void d(Object obj, long j2, float f2);

        public final void e(Object obj, long j2, int i2) {
            this.a.putInt(obj, j2, i2);
        }

        public final void f(Object obj, long j2, long j3) {
            this.a.putLong(obj, j2, j3);
        }

        public abstract void g(Object obj, long j2, boolean z);

        public abstract boolean h(Object obj, long j2);

        public abstract float i(Object obj, long j2);

        public abstract double j(Object obj, long j2);

        public final int k(Object obj, long j2) {
            return this.a.getInt(obj, j2);
        }

        public final long l(Object obj, long j2) {
            return this.a.getLong(obj, j2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    static final class d extends c {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final byte a(Object obj, long j2) {
            return this.a.getByte(obj, j2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void b(Object obj, long j2, byte b2) {
            this.a.putByte(obj, j2, b2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void c(Object obj, long j2, double d2) {
            this.a.putDouble(obj, j2, d2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void d(Object obj, long j2, float f2) {
            this.a.putFloat(obj, j2, f2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final void g(Object obj, long j2, boolean z) {
            this.a.putBoolean(obj, j2, z);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final boolean h(Object obj, long j2) {
            return this.a.getBoolean(obj, j2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final float i(Object obj, long j2) {
            return this.a.getFloat(obj, j2);
        }

        @Override // com.google.android.gms.internal.measurement.j7.c
        public final double j(Object obj, long j2) {
            return this.a.getDouble(obj, j2);
        }
    }

    static {
        Unsafe t2 = t();
        f7200b = t2;
        f7201c = a3.c();
        boolean B = B(Long.TYPE);
        f7202d = B;
        boolean B2 = B(Integer.TYPE);
        f7203e = B2;
        c cVar = null;
        if (t2 != null) {
            if (!a3.b()) {
                cVar = new d(t2);
            } else if (B) {
                cVar = new a(t2);
            } else if (B2) {
                cVar = new b(t2);
            }
        }
        f7204f = cVar;
        f7205g = E();
        f7206h = A();
        long n2 = n(byte[].class);
        f7207i = n2;
        f7208j = n(boolean[].class);
        f7209k = s(boolean[].class);
        f7210l = n(int[].class);
        m = s(int[].class);
        n = n(long[].class);
        o = s(long[].class);
        p = n(float[].class);
        q = s(float[].class);
        r = n(double[].class);
        s = s(double[].class);
        t = n(Object[].class);
        u = s(Object[].class);
        Field G = G();
        v = (G == null || cVar == null) ? -1L : cVar.a.objectFieldOffset(G);
        w = (int) (7 & n2);
        x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private j7() {
    }

    private static boolean A() {
        Unsafe unsafe = f7200b;
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
            if (a3.b()) {
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

    private static boolean B(Class<?> cls) {
        if (a3.b()) {
            try {
                Class<?> cls2 = f7201c;
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
    public static double C(Object obj, long j2) {
        return f7204f.j(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(Object obj, long j2, boolean z) {
        y(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    private static boolean E() {
        Unsafe unsafe = f7200b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (G() == null) {
                return false;
            }
            if (a3.b()) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object F(Object obj, long j2) {
        return f7204f.a.getObject(obj, j2);
    }

    private static Field G() {
        Field d2;
        if (!a3.b() || (d2 = d(Buffer.class, "effectiveDirectAddress")) == null) {
            Field d3 = d(Buffer.class, "address");
            if (d3 == null || d3.getType() != Long.TYPE) {
                return null;
            }
            return d3;
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte L(Object obj, long j2) {
        return (byte) (b(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte M(Object obj, long j2) {
        return (byte) (b(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean N(Object obj, long j2) {
        return L(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O(Object obj, long j2) {
        return M(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j2) {
        return f7204f.a(bArr, f7207i + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Object obj, long j2) {
        return f7204f.k(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(Class<T> cls) {
        try {
            return (T) f7200b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static Field d(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Object obj, long j2, double d2) {
        f7204f.c(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Object obj, long j2, float f2) {
        f7204f.d(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Object obj, long j2, int i2) {
        f7204f.e(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Object obj, long j2, long j3) {
        f7204f.f(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(Object obj, long j2, Object obj2) {
        f7204f.a.putObject(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Object obj, long j2, boolean z) {
        f7204f.g(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(byte[] bArr, long j2, byte b2) {
        f7204f.b(bArr, f7207i + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m() {
        return f7206h;
    }

    private static int n(Class<?> cls) {
        if (f7206h) {
            return f7204f.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long o(Object obj, long j2) {
        return f7204f.l(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        return f7205g;
    }

    private static int s(Class<?> cls) {
        if (f7206h) {
            return f7204f.a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe t() {
        try {
            return (Unsafe) AccessController.doPrivileged(new i7());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int b3 = b(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        h(obj, j3, ((255 & b2) << i2) | (b3 & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w(Object obj, long j2) {
        return f7204f.h(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float x(Object obj, long j2) {
        return f7204f.i(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        h(obj, j3, ((255 & b2) << i2) | (b(obj, j3) & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Object obj, long j2, boolean z) {
        u(obj, j2, z ? (byte) 1 : (byte) 0);
    }
}