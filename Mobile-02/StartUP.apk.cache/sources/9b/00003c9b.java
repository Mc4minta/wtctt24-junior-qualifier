package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.i;
import com.google.protobuf.j;
import com.google.protobuf.j.b;
import com.google.protobuf.k;
import com.google.protobuf.n;
import com.google.protobuf.y;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: GeneratedMessageLite.java */
/* loaded from: classes2.dex */
public abstract class j<MessageType extends j<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends com.google.protobuf.a<MessageType, BuilderType> {

    /* renamed from: b  reason: collision with root package name */
    protected v f9711b = v.c();

    /* renamed from: c  reason: collision with root package name */
    protected int f9712c = -1;

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    public static abstract class b<MessageType extends j<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends a.AbstractC0201a<MessageType, BuilderType> {
        private final MessageType a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f9713b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f9714c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(MessageType messagetype) {
            this.a = messagetype;
            this.f9713b = (MessageType) messagetype.c(i.NEW_MUTABLE_INSTANCE);
        }

        @Override // com.google.protobuf.n.a
        /* renamed from: e */
        public final MessageType build() {
            MessageType f2 = f();
            if (f2.isInitialized()) {
                return f2;
            }
            throw a.AbstractC0201a.d(f2);
        }

        public MessageType f() {
            if (this.f9714c) {
                return this.f9713b;
            }
            this.f9713b.l();
            this.f9714c = true;
            return this.f9713b;
        }

        /* renamed from: h */
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().n();
            buildertype.n(f());
            return buildertype;
        }

        protected void i() {
            if (this.f9714c) {
                MessageType messagetype = (MessageType) this.f9713b.c(i.NEW_MUTABLE_INSTANCE);
                messagetype.u(h.a, this.f9713b);
                this.f9713b = messagetype;
                this.f9714c = false;
            }
        }

        @Override // com.google.protobuf.o
        /* renamed from: k */
        public MessageType getDefaultInstanceForType() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.a.AbstractC0201a
        /* renamed from: l */
        public BuilderType b(MessageType messagetype) {
            return n(messagetype);
        }

        public BuilderType n(MessageType messagetype) {
            i();
            this.f9713b.u(h.a, messagetype);
            return this;
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    protected static class c<T extends j<T, ?>> extends com.google.protobuf.b<T> {

        /* renamed from: b  reason: collision with root package name */
        private T f9715b;

        public c(T t) {
            this.f9715b = t;
        }

        @Override // com.google.protobuf.q
        /* renamed from: g */
        public T b(com.google.protobuf.f fVar, com.google.protobuf.h hVar) throws InvalidProtocolBufferException {
            return (T) j.q(this.f9715b, fVar, hVar);
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    static class d implements InterfaceC0203j {
        static final d a = new d();

        /* renamed from: b  reason: collision with root package name */
        static final a f9716b = new a();

        /* compiled from: GeneratedMessageLite.java */
        /* loaded from: classes2.dex */
        static final class a extends RuntimeException {
            a() {
            }
        }

        private d() {
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public <T extends n> T a(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t != null && t2 != null) {
                ((j) t).h(this, t2);
                return t;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public com.google.protobuf.i<f> b(com.google.protobuf.i<f> iVar, com.google.protobuf.i<f> iVar2) {
            if (iVar.equals(iVar2)) {
                return iVar;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public int c(boolean z, int i2, boolean z2, int i3) {
            if (z == z2 && i2 == i3) {
                return i2;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public v d(v vVar, v vVar2) {
            if (vVar.equals(vVar2)) {
                return vVar;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public String e(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public <T> k.a<T> f(k.a<T> aVar, k.a<T> aVar2) {
            if (aVar.equals(aVar2)) {
                return aVar;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public boolean g(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public com.google.protobuf.e h(boolean z, com.google.protobuf.e eVar, boolean z2, com.google.protobuf.e eVar2) {
            if (z == z2 && eVar.equals(eVar2)) {
                return eVar;
            }
            throw f9716b;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public long i(boolean z, long j2, boolean z2, long j3) {
            if (z == z2 && j2 == j3) {
                return j2;
            }
            throw f9716b;
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    public static abstract class e<MessageType extends e<MessageType, BuilderType>, BuilderType> extends j<MessageType, BuilderType> implements o {

        /* renamed from: d  reason: collision with root package name */
        protected com.google.protobuf.i<f> f9717d = com.google.protobuf.i.i();

        @Override // com.google.protobuf.j, com.google.protobuf.o
        public /* bridge */ /* synthetic */ n getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.j
        protected final void l() {
            super.l();
            this.f9717d.f();
        }

        @Override // com.google.protobuf.j, com.google.protobuf.n
        public /* bridge */ /* synthetic */ n.a toBuilder() {
            return super.toBuilder();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.j
        /* renamed from: v */
        public final void u(InterfaceC0203j interfaceC0203j, MessageType messagetype) {
            super.u(interfaceC0203j, messagetype);
            this.f9717d = interfaceC0203j.b(this.f9717d, messagetype.f9717d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    public static final class f implements i.b<f> {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final y.b f9718b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f9719c;

        @Override // com.google.protobuf.i.b
        public y.c getLiteJavaType() {
            return this.f9718b.h();
        }

        @Override // com.google.protobuf.i.b
        public y.b getLiteType() {
            return this.f9718b;
        }

        public int getNumber() {
            return this.a;
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(f fVar) {
            return this.a - fVar.a;
        }

        @Override // com.google.protobuf.i.b
        public boolean isRepeated() {
            return this.f9719c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.i.b
        public n.a m(n.a aVar, n nVar) {
            return ((b) aVar).n((j) nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    public static class g implements InterfaceC0203j {
        private int a;

        private g() {
            this.a = 0;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public <T extends n> T a(T t, T t2) {
            int i2;
            if (t == null) {
                i2 = 37;
            } else if (t instanceof j) {
                i2 = ((j) t).j(this);
            } else {
                i2 = t.hashCode();
            }
            this.a = (this.a * 53) + i2;
            return t;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public com.google.protobuf.i<f> b(com.google.protobuf.i<f> iVar, com.google.protobuf.i<f> iVar2) {
            this.a = (this.a * 53) + iVar.hashCode();
            return iVar;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public int c(boolean z, int i2, boolean z2, int i3) {
            this.a = (this.a * 53) + i2;
            return i2;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public v d(v vVar, v vVar2) {
            this.a = (this.a * 53) + vVar.hashCode();
            return vVar;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public String e(boolean z, String str, boolean z2, String str2) {
            this.a = (this.a * 53) + str.hashCode();
            return str;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public <T> k.a<T> f(k.a<T> aVar, k.a<T> aVar2) {
            this.a = (this.a * 53) + aVar.hashCode();
            return aVar;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public boolean g(boolean z, boolean z2, boolean z3, boolean z4) {
            this.a = (this.a * 53) + k.a(z2);
            return z2;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public com.google.protobuf.e h(boolean z, com.google.protobuf.e eVar, boolean z2, com.google.protobuf.e eVar2) {
            this.a = (this.a * 53) + eVar.hashCode();
            return eVar;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public long i(boolean z, long j2, boolean z2, long j3) {
            this.a = (this.a * 53) + k.b(j2);
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    public static class h implements InterfaceC0203j {
        public static final h a = new h();

        private h() {
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public <T extends n> T a(T t, T t2) {
            if (t == null || t2 == null) {
                return t != null ? t : t2;
            }
            return (T) t.toBuilder().s0(t2).build();
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public com.google.protobuf.i<f> b(com.google.protobuf.i<f> iVar, com.google.protobuf.i<f> iVar2) {
            if (iVar.d()) {
                iVar = iVar.clone();
            }
            iVar.g(iVar2);
            return iVar;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public int c(boolean z, int i2, boolean z2, int i3) {
            return z2 ? i3 : i2;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public v d(v vVar, v vVar2) {
            return vVar2 == v.c() ? vVar : v.g(vVar, vVar2);
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public String e(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public <T> k.a<T> f(k.a<T> aVar, k.a<T> aVar2) {
            int size = aVar.size();
            int size2 = aVar2.size();
            if (size > 0 && size2 > 0) {
                if (!aVar.d1()) {
                    aVar = aVar.G(size2 + size);
                }
                aVar.addAll(aVar2);
            }
            return size > 0 ? aVar : aVar2;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public boolean g(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public com.google.protobuf.e h(boolean z, com.google.protobuf.e eVar, boolean z2, com.google.protobuf.e eVar2) {
            return z2 ? eVar2 : eVar;
        }

        @Override // com.google.protobuf.j.InterfaceC0203j
        public long i(boolean z, long j2, boolean z2, long j3) {
            return z2 ? j3 : j2;
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes2.dex */
    public enum i {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: GeneratedMessageLite.java */
    /* renamed from: com.google.protobuf.j$j  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0203j {
        <T extends n> T a(T t, T t2);

        com.google.protobuf.i<f> b(com.google.protobuf.i<f> iVar, com.google.protobuf.i<f> iVar2);

        int c(boolean z, int i2, boolean z2, int i3);

        v d(v vVar, v vVar2);

        String e(boolean z, String str, boolean z2, String str2);

        <T> k.a<T> f(k.a<T> aVar, k.a<T> aVar2);

        boolean g(boolean z, boolean z2, boolean z3, boolean z4);

        com.google.protobuf.e h(boolean z, com.google.protobuf.e eVar, boolean z2, com.google.protobuf.e eVar2);

        long i(boolean z, long j2, boolean z2, long j3);
    }

    private static <T extends j<T, ?>> T b(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.a().a().h(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> k.a<E> f() {
        return r.i();
    }

    private final void g() {
        if (this.f9711b == v.c()) {
            this.f9711b = v.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object k(Method method, Object obj, Object... objArr) {
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
    public static <E> k.a<E> m(k.a<E> aVar) {
        int size = aVar.size();
        return aVar.G(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends j<T, ?>> T o(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) b(q(t, com.google.protobuf.f.c(inputStream), com.google.protobuf.h.a()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends j<T, ?>> T p(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) b(r(t, bArr, com.google.protobuf.h.a()));
    }

    static <T extends j<T, ?>> T q(T t, com.google.protobuf.f fVar, com.google.protobuf.h hVar) throws InvalidProtocolBufferException {
        T t2 = (T) t.c(i.NEW_MUTABLE_INSTANCE);
        try {
            t2.e(i.MERGE_FROM_STREAM, fVar, hVar);
            t2.l();
            return t2;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends j<T, ?>> T r(T t, byte[] bArr, com.google.protobuf.h hVar) throws InvalidProtocolBufferException {
        try {
            com.google.protobuf.f d2 = com.google.protobuf.f.d(bArr);
            T t2 = (T) q(t, d2, hVar);
            try {
                d2.a(0);
                return t2;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.h(t2);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    protected Object c(i iVar) {
        return e(iVar, null, null);
    }

    protected Object d(i iVar, Object obj) {
        return e(iVar, obj, null);
    }

    protected abstract Object e(i iVar, Object obj, Object obj2);

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getDefaultInstanceForType().getClass().isInstance(obj)) {
            try {
                u(d.a, (j) obj);
                return true;
            } catch (d.a unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.n
    public final q<MessageType> getParserForType() {
        return (q) c(i.GET_PARSER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean h(d dVar, n nVar) {
        if (this == nVar) {
            return true;
        }
        if (getDefaultInstanceForType().getClass().isInstance(nVar)) {
            u(dVar, (j) nVar);
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.a == 0) {
            g gVar = new g();
            u(gVar, this);
            this.a = gVar.a;
        }
        return this.a;
    }

    @Override // com.google.protobuf.o
    /* renamed from: i */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) c(i.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.o
    public final boolean isInitialized() {
        return d(i.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    int j(g gVar) {
        if (this.a == 0) {
            int i2 = gVar.a;
            gVar.a = 0;
            u(gVar, this);
            this.a = gVar.a;
            gVar.a = i2;
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        c(i.MAKE_IMMUTABLE);
        this.f9711b.d();
    }

    public final BuilderType n() {
        return (BuilderType) c(i.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s(int i2, com.google.protobuf.f fVar) throws IOException {
        if (y.b(i2) == 4) {
            return false;
        }
        g();
        return this.f9711b.e(i2, fVar);
    }

    @Override // com.google.protobuf.n
    /* renamed from: t */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) c(i.NEW_BUILDER);
        buildertype.n(this);
        return buildertype;
    }

    public String toString() {
        return p.e(this, super.toString());
    }

    void u(InterfaceC0203j interfaceC0203j, MessageType messagetype) {
        e(i.VISIT, interfaceC0203j, messagetype);
        this.f9711b = interfaceC0203j.d(this.f9711b, messagetype.f9711b);
    }
}