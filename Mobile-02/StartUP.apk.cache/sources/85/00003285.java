package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;
import com.google.android.gms.internal.clearcut.e1.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class e1<MessageType extends e1<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends q<MessageType, BuilderType> {
    private static Map<Object, e1<?, ?>> zzjr = new ConcurrentHashMap();
    protected r3 zzjp = r3.h();
    private int zzjq = -1;

    /* loaded from: classes2.dex */
    public static abstract class a<MessageType extends e1<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends r<MessageType, BuilderType> {
        private final MessageType a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f6398b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f6399c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(MessageType messagetype) {
            this.a = messagetype;
            this.f6398b = (MessageType) messagetype.e(e.f6404d, null, null);
        }

        private static void e(MessageType messagetype, MessageType messagetype2) {
            u2.a().d(messagetype).c(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.clearcut.k2
        public final /* synthetic */ i2 b() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) this.a.e(e.f6405e, null, null);
            aVar.c((e1) g0());
            return aVar;
        }

        @Override // com.google.android.gms.internal.clearcut.r
        /* renamed from: d */
        public final BuilderType c(MessageType messagetype) {
            n();
            e(this.f6398b, messagetype);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void n() {
            if (this.f6399c) {
                MessageType messagetype = (MessageType) this.f6398b.e(e.f6404d, null, null);
                e(messagetype, this.f6398b);
                this.f6398b = messagetype;
                this.f6399c = false;
            }
        }

        @Override // com.google.android.gms.internal.clearcut.j2
        /* renamed from: o */
        public MessageType g0() {
            if (this.f6399c) {
                return this.f6398b;
            }
            MessageType messagetype = this.f6398b;
            u2.a().d(messagetype).b(messagetype);
            this.f6399c = true;
            return this.f6398b;
        }

        public final MessageType p() {
            MessageType messagetype = (MessageType) g0();
            byte byteValue = ((Byte) messagetype.e(e.a, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = u2.a().d(messagetype).j(messagetype);
                    messagetype.e(e.f6402b, z ? messagetype : null, null);
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzew(messagetype);
        }

        @Override // com.google.android.gms.internal.clearcut.j2
        public final /* synthetic */ i2 z() {
            e1 e1Var = (e1) g0();
            byte byteValue = ((Byte) e1Var.e(e.a, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = u2.a().d(e1Var).j(e1Var);
                    e1Var.e(e.f6402b, z ? e1Var : null, null);
                }
            }
            if (z) {
                return e1Var;
            }
            throw new zzew(e1Var);
        }
    }

    /* loaded from: classes2.dex */
    public static class b<T extends e1<T, ?>> extends s<T> {

        /* renamed from: b  reason: collision with root package name */
        private T f6400b;

        public b(T t) {
            this.f6400b = t;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends e1<MessageType, BuilderType> implements k2 {
        protected v0<d> zzjv = v0.k();
    }

    /* loaded from: classes2.dex */
    static final class d implements y0<d> {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final f4 f6401b;

        @Override // com.google.android.gms.internal.clearcut.y0
        public final int c() {
            return this.a;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.a - ((d) obj).a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.clearcut.y0
        public final j2 g(j2 j2Var, i2 i2Var) {
            return ((a) j2Var).c((e1) i2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.y0
        public final boolean j() {
            return false;
        }

        @Override // com.google.android.gms.internal.clearcut.y0
        public final k4 o() {
            return this.f6401b.h();
        }

        @Override // com.google.android.gms.internal.clearcut.y0
        public final boolean r() {
            return false;
        }

        @Override // com.google.android.gms.internal.clearcut.y0
        public final f4 u() {
            return this.f6401b;
        }

        @Override // com.google.android.gms.internal.clearcut.y0
        public final o2 v(o2 o2Var, o2 o2Var2) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes2.dex */
    public enum e {
        public static final int a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f6402b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6403c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6404d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f6405e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f6406f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f6407g = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final int f6409i = 1;

        /* renamed from: j  reason: collision with root package name */
        public static final int f6410j = 2;

        /* renamed from: l  reason: collision with root package name */
        public static final int f6412l = 1;
        public static final int m = 2;

        /* renamed from: h  reason: collision with root package name */
        private static final /* synthetic */ int[] f6408h = {1, 2, 3, 4, 5, 6, 7};

        /* renamed from: k  reason: collision with root package name */
        private static final /* synthetic */ int[] f6411k = {1, 2};
        private static final /* synthetic */ int[] n = {1, 2};

        public static int[] a() {
            return (int[]) f6408h.clone();
        }
    }

    private static <T extends e1<T, ?>> T d(T t, byte[] bArr) throws zzco {
        T t2 = (T) t.e(e.f6404d, null, null);
        try {
            u2.a().d(t2).h(t2, bArr, 0, bArr.length, new w());
            u2.a().d(t2).b(t2);
            if (t2.zzex == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzco) {
                throw ((zzco) e2.getCause());
            }
            throw new zzco(e2.getMessage()).f(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzco.a().f(t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object g(i2 i2Var, String str, Object[] objArr) {
        return new w2(i2Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object j(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends e1<?, ?>> void m(Class<T> cls, T t) {
        zzjr.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends e1<T, ?>> T n(T t, byte[] bArr) throws zzco {
        T t2 = (T) d(t, bArr);
        if (t2 != null) {
            byte byteValue = ((Byte) t2.e(e.a, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = u2.a().d(t2).j(t2);
                    t2.e(e.f6402b, z ? t2 : null, null);
                }
            }
            if (!z) {
                throw new zzco(new zzew(t2).getMessage()).f(t2);
            }
        }
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> j1<E> o() {
        return v2.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends e1<?, ?>> T p(Class<T> cls) {
        T t = (T) zzjr.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzjr.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            String name = cls.getName();
            throw new IllegalStateException(name.length() != 0 ? "Unable to get default instance for: ".concat(name) : new String("Unable to get default instance for: "));
        }
        return t;
    }

    @Override // com.google.android.gms.internal.clearcut.q
    final void a(int i2) {
        this.zzjq = i2;
    }

    @Override // com.google.android.gms.internal.clearcut.k2
    public final /* synthetic */ i2 b() {
        return (e1) e(e.f6406f, null, null);
    }

    @Override // com.google.android.gms.internal.clearcut.q
    final int c() {
        return this.zzjq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object e(int i2, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((e1) e(e.f6406f, null, null)).getClass().isInstance(obj)) {
            return u2.a().d(this).e(this, (e1) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.i2
    public final /* synthetic */ j2 h() {
        a aVar = (a) e(e.f6405e, null, null);
        aVar.c(this);
        return aVar;
    }

    public int hashCode() {
        int i2 = this.zzex;
        if (i2 != 0) {
            return i2;
        }
        int f2 = u2.a().d(this).f(this);
        this.zzex = f2;
        return f2;
    }

    @Override // com.google.android.gms.internal.clearcut.i2
    public final void i(zzbn zzbnVar) throws IOException {
        u2.a().b(getClass()).g(this, n0.a(zzbnVar));
    }

    @Override // com.google.android.gms.internal.clearcut.k2
    public final boolean isInitialized() {
        byte byteValue = ((Byte) e(e.a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean j2 = u2.a().d(this).j(this);
        e(e.f6402b, j2 ? this : null, null);
        return j2;
    }

    @Override // com.google.android.gms.internal.clearcut.i2
    public final /* synthetic */ j2 k() {
        return (a) e(e.f6405e, null, null);
    }

    @Override // com.google.android.gms.internal.clearcut.i2
    public final int l() {
        if (this.zzjq == -1) {
            this.zzjq = u2.a().d(this).d(this);
        }
        return this.zzjq;
    }

    public String toString() {
        return l2.a(this, super.toString());
    }
}