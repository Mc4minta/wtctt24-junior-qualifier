package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.n4.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class n4<MessageType extends n4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends x2<MessageType, BuilderType> {
    private static Map<Object, n4<?, ?>> zzd = new ConcurrentHashMap();
    protected c7 zzb = c7.a();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    public static abstract class a<MessageType extends n4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends w2<MessageType, BuilderType> {
        private final MessageType a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f7252b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f7253c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(MessageType messagetype) {
            this.a = messagetype;
            this.f7252b = (MessageType) messagetype.r(f.f7257d, null, null);
        }

        private static void p(MessageType messagetype, MessageType messagetype2) {
            j6.a().c(messagetype).g(messagetype, messagetype2);
        }

        private final BuilderType q(byte[] bArr, int i2, int i3, z3 z3Var) throws zzfm {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            try {
                j6.a().c(this.f7252b).h(this.f7252b, bArr, 0, i3 + 0, new c3(z3Var));
                return this;
            } catch (zzfm e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzfm.a();
            }
        }

        @Override // com.google.android.gms.internal.measurement.w5
        public final /* synthetic */ u5 b() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.w2
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) this.a.r(f.f7258e, null, null);
            aVar.k((n4) g());
            return aVar;
        }

        @Override // com.google.android.gms.internal.measurement.w2
        public final /* synthetic */ w2 l(byte[] bArr, int i2, int i3) throws zzfm {
            return q(bArr, 0, i3, z3.a());
        }

        @Override // com.google.android.gms.internal.measurement.w2
        public final /* synthetic */ w2 n(byte[] bArr, int i2, int i3, z3 z3Var) throws zzfm {
            return q(bArr, 0, i3, z3Var);
        }

        @Override // com.google.android.gms.internal.measurement.w2
        /* renamed from: o */
        public final BuilderType k(MessageType messagetype) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            p(this.f7252b, messagetype);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void r() {
            MessageType messagetype = (MessageType) this.f7252b.r(f.f7257d, null, null);
            p(messagetype, this.f7252b);
            this.f7252b = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.x5
        /* renamed from: s */
        public MessageType g() {
            if (this.f7253c) {
                return this.f7252b;
            }
            MessageType messagetype = this.f7252b;
            j6.a().c(messagetype).b(messagetype);
            this.f7253c = true;
            return this.f7252b;
        }

        @Override // com.google.android.gms.internal.measurement.x5
        /* renamed from: t */
        public final MessageType j() {
            MessageType messagetype = (MessageType) g();
            if (messagetype.h()) {
                return messagetype;
            }
            throw new zzhu(messagetype);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType> extends n4<MessageType, BuilderType> implements w5 {
        protected c4<e> zzc = c4.c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final c4<e> B() {
            if (this.zzc.n()) {
                this.zzc = (c4) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    public static class c<T extends n4<T, ?>> extends y2<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f7254b;

        public c(T t) {
            this.f7254b = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    public static class d<ContainingType extends u5, Type> extends x3<ContainingType, Type> {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    static final class e implements e4<e> {
        @Override // com.google.android.gms.internal.measurement.e4
        public final int a() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.e4
        public final q7 b() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.e4
        public final x7 c() {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.e4
        public final boolean d() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.e4
        public final boolean e() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.e4
        public final x5 i(x5 x5Var, u5 u5Var) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.e4
        public final c6 l(c6 c6Var, c6 c6Var2) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    public enum f {
        public static final int a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f7255b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f7256c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f7257d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f7258e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f7259f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f7260g = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final int f7262i = 1;

        /* renamed from: j  reason: collision with root package name */
        public static final int f7263j = 2;

        /* renamed from: l  reason: collision with root package name */
        public static final int f7265l = 1;
        public static final int m = 2;

        /* renamed from: h  reason: collision with root package name */
        private static final /* synthetic */ int[] f7261h = {1, 2, 3, 4, 5, 6, 7};

        /* renamed from: k  reason: collision with root package name */
        private static final /* synthetic */ int[] f7264k = {1, 2};
        private static final /* synthetic */ int[] n = {1, 2};

        public static int[] a() {
            return (int[]) f7261h.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> v4<E> A() {
        return i6.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends n4<?, ?>> T o(Class<T> cls) {
        n4<?, ?> n4Var = zzd.get(cls);
        if (n4Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                n4Var = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (n4Var == null) {
            n4Var = (T) ((n4) j7.c(cls)).r(f.f7259f, null, null);
            if (n4Var != null) {
                zzd.put(cls, n4Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) n4Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static t4 p(t4 t4Var) {
        int size = t4Var.size();
        return t4Var.e0(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> v4<E> q(v4<E> v4Var) {
        int size = v4Var.size();
        return v4Var.f(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object s(u5 u5Var, String str, Object[] objArr) {
        return new k6(u5Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object t(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends n4<?, ?>> void u(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static final <T extends n4<T, ?>> boolean v(T t, boolean z) {
        byte byteValue = ((Byte) t.r(f.a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = j6.a().c(t).d(t);
        if (z) {
            t.r(f.f7255b, d2 ? t : null, null);
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static u4 y() {
        return o4.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static t4 z() {
        return i5.k();
    }

    @Override // com.google.android.gms.internal.measurement.w5
    public final /* synthetic */ u5 b() {
        return (n4) r(f.f7259f, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.u5
    public final /* synthetic */ x5 c() {
        a aVar = (a) r(f.f7258e, null, null);
        aVar.k(this);
        return aVar;
    }

    @Override // com.google.android.gms.internal.measurement.u5
    public final /* synthetic */ x5 e() {
        return (a) r(f.f7258e, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return j6.a().c(this).f(this, (n4) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.u5
    public final void f(zzel zzelVar) throws IOException {
        j6.a().c(this).i(this, w3.P(zzelVar));
    }

    @Override // com.google.android.gms.internal.measurement.w5
    public final boolean h() {
        return v(this, true);
    }

    public int hashCode() {
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int c2 = j6.a().c(this).c(this);
        this.zza = c2;
        return c2;
    }

    @Override // com.google.android.gms.internal.measurement.u5
    public final int i() {
        if (this.zzc == -1) {
            this.zzc = j6.a().c(this).e(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.x2
    final int m() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.x2
    final void n(int i2) {
        this.zzc = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object r(int i2, Object obj, Object obj2);

    public String toString() {
        return z5.a(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends n4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType w() {
        return (BuilderType) r(f.f7258e, null, null);
    }

    public final BuilderType x() {
        BuilderType buildertype = (BuilderType) r(f.f7258e, null, null);
        buildertype.k(this);
        return buildertype;
    }
}