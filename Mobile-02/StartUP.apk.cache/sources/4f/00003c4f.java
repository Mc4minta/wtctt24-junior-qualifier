package com.google.gson.u.n;

import com.google.gson.JsonParseException;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes2.dex */
public final class l<T> extends s<T> {
    private final q<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.k<T> f9648b;

    /* renamed from: c  reason: collision with root package name */
    final com.google.gson.f f9649c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.v.a<T> f9650d;

    /* renamed from: e  reason: collision with root package name */
    private final t f9651e;

    /* renamed from: f  reason: collision with root package name */
    private final l<T>.b f9652f = new b();

    /* renamed from: g  reason: collision with root package name */
    private s<T> f9653g;

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes2.dex */
    private final class b implements p, com.google.gson.j {
        private b() {
        }

        @Override // com.google.gson.j
        public <R> R a(com.google.gson.l lVar, Type type) throws JsonParseException {
            return (R) l.this.f9649c.g(lVar, type);
        }

        @Override // com.google.gson.p
        public com.google.gson.l b(Object obj, Type type) {
            return l.this.f9649c.s(obj, type);
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes2.dex */
    private static final class c implements t {
        private final com.google.gson.v.a<?> a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9654b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f9655c;

        /* renamed from: d  reason: collision with root package name */
        private final q<?> f9656d;

        /* renamed from: e  reason: collision with root package name */
        private final com.google.gson.k<?> f9657e;

        c(Object obj, com.google.gson.v.a<?> aVar, boolean z, Class<?> cls) {
            q<?> qVar = obj instanceof q ? (q) obj : null;
            this.f9656d = qVar;
            com.google.gson.k<?> kVar = obj instanceof com.google.gson.k ? (com.google.gson.k) obj : null;
            this.f9657e = kVar;
            com.google.gson.u.a.a((qVar == null && kVar == null) ? false : true);
            this.a = aVar;
            this.f9654b = z;
            this.f9655c = cls;
        }

        @Override // com.google.gson.t
        public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            boolean isAssignableFrom;
            com.google.gson.v.a<?> aVar2 = this.a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f9654b && this.a.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.f9655c.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.f9656d, this.f9657e, fVar, aVar, this);
            }
            return null;
        }
    }

    public l(q<T> qVar, com.google.gson.k<T> kVar, com.google.gson.f fVar, com.google.gson.v.a<T> aVar, t tVar) {
        this.a = qVar;
        this.f9648b = kVar;
        this.f9649c = fVar;
        this.f9650d = aVar;
        this.f9651e = tVar;
    }

    private s<T> a() {
        s<T> sVar = this.f9653g;
        if (sVar != null) {
            return sVar;
        }
        s<T> n = this.f9649c.n(this.f9651e, this.f9650d);
        this.f9653g = n;
        return n;
    }

    public static t b(com.google.gson.v.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    @Override // com.google.gson.s
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.f9648b == null) {
            return a().read(aVar);
        }
        com.google.gson.l a2 = com.google.gson.u.l.a(aVar);
        if (a2.o()) {
            return null;
        }
        return this.f9648b.deserialize(a2, this.f9650d.getType(), this.f9652f);
    }

    @Override // com.google.gson.s
    public void write(com.google.gson.stream.c cVar, T t) throws IOException {
        q<T> qVar = this.a;
        if (qVar == null) {
            a().write(cVar, t);
        } else if (t == null) {
            cVar.A();
        } else {
            com.google.gson.u.l.b(qVar.serialize(t, this.f9650d.getType(), this.f9652f), cVar);
        }
    }
}