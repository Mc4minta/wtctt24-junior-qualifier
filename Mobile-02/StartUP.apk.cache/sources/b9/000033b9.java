package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;
import com.google.android.gms.internal.p000firebaseperf.m4.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.m4  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class m4<MessageType extends m4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends c3<MessageType, BuilderType> {
    private static Map<Object, m4<?, ?>> zzqx = new ConcurrentHashMap();
    protected c7 zzqv = c7.h();
    private int zzqw = -1;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.m4$a */
    /* loaded from: classes2.dex */
    public static abstract class a<MessageType extends m4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b3<MessageType, BuilderType> {
        private final MessageType a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f6823b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f6824c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(MessageType messagetype) {
            this.a = messagetype;
            this.f6823b = (MessageType) messagetype.i(d.NEW_MUTABLE_INSTANCE, null, null);
        }

        private static void i(MessageType messagetype, MessageType messagetype2) {
            h6.b().c(messagetype).g(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.p000firebaseperf.b3
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) this.a.i(d.NEW_BUILDER, null, null);
            aVar.f((m4) m());
            return aVar;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.x5
        public final /* synthetic */ v5 d() {
            return this.a;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.b3
        /* renamed from: h */
        public final BuilderType f(MessageType messagetype) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            i(this.f6823b, messagetype);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void k() {
            MessageType messagetype = (MessageType) this.f6823b.i(d.NEW_MUTABLE_INSTANCE, null, null);
            i(messagetype, this.f6823b);
            this.f6823b = messagetype;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.u5
        /* renamed from: l */
        public MessageType m() {
            if (this.f6824c) {
                return this.f6823b;
            }
            MessageType messagetype = this.f6823b;
            h6.b().c(messagetype).a(messagetype);
            this.f6824c = true;
            return this.f6823b;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.u5
        /* renamed from: n */
        public final MessageType O() {
            MessageType messagetype = (MessageType) m();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzhx(messagetype);
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.m4$b */
    /* loaded from: classes2.dex */
    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType> extends m4<MessageType, BuilderType> implements x5 {
        protected e4<e> zzqy = e4.r();
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.m4$c */
    /* loaded from: classes2.dex */
    public static class c<T extends m4<T, ?>> extends e3<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f6825b;

        public c(T t) {
            this.f6825b = t;
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.m4$d */
    /* loaded from: classes2.dex */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.m4$e */
    /* loaded from: classes2.dex */
    static final class e implements g4<e> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.g4
        public final s7 f() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.g4
        public final int getNumber() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.g4
        public final v7 k() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.g4
        public final u5 p(u5 u5Var, v5 v5Var) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.g4
        public final b6 t(b6 b6Var, b6 b6Var2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.g4
        public final boolean w() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.g4
        public final boolean x() {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> t4<E> j(t4<E> t4Var) {
        int size = t4Var.size();
        return t4Var.J0(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object k(v5 v5Var, String str, Object[] objArr) {
        return new j6(v5Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object l(Method method, Object obj, Object... objArr) {
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
    public static <T extends m4<?, ?>> void n(Class<T> cls, T t) {
        zzqx.put(cls, t);
    }

    protected static final <T extends m4<T, ?>> boolean o(T t, boolean z) {
        byte byteValue = ((Byte) t.i(d.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = h6.b().c(t).d(t);
        if (z) {
            t.i(d.SET_MEMOIZED_IS_INITIALIZED, d2 ? t : null, null);
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends m4<?, ?>> T p(Class<T> cls) {
        m4<?, ?> m4Var = zzqx.get(cls);
        if (m4Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                m4Var = zzqx.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (m4Var == null) {
            m4Var = (T) ((m4) k7.r(cls)).i(d.GET_DEFAULT_INSTANCE, null, null);
            if (m4Var != null) {
                zzqx.put(cls, m4Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) m4Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static r4 r() {
        return o4.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> t4<E> s() {
        return k6.l();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.v5
    public final /* synthetic */ u5 b() {
        a aVar = (a) i(d.NEW_BUILDER, null, null);
        aVar.f(this);
        return aVar;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.x5
    public final /* synthetic */ v5 d() {
        return (m4) i(d.GET_DEFAULT_INSTANCE, null, null);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.v5
    public void e(zzev zzevVar) throws IOException {
        h6.b().c(this).b(this, a4.a(zzevVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return h6.b().c(this).e(this, (m4) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.c3
    final int g() {
        return this.zzqw;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.v5
    public int getSerializedSize() {
        if (this.zzqw == -1) {
            this.zzqw = h6.b().c(this).c(this);
        }
        return this.zzqw;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.c3
    final void h(int i2) {
        this.zzqw = i2;
    }

    public int hashCode() {
        int i2 = this.zzmu;
        if (i2 != 0) {
            return i2;
        }
        int f2 = h6.b().c(this).f(this);
        this.zzmu = f2;
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object i(d dVar, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p000firebaseperf.x5
    public final boolean isInitialized() {
        return o(this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends m4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType q() {
        return (BuilderType) i(d.NEW_BUILDER, null, null);
    }

    public String toString() {
        return w5.a(this, super.toString());
    }
}