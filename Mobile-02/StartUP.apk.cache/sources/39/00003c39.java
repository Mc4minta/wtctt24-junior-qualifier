package com.google.gson.u.n;

import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class b implements t {
    private final com.google.gson.u.c a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    private static final class a<E> extends s<Collection<E>> {
        private final s<E> a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.gson.u.i<? extends Collection<E>> f9625b;

        public a(com.google.gson.f fVar, Type type, s<E> sVar, com.google.gson.u.i<? extends Collection<E>> iVar) {
            this.a = new m(fVar, sVar, type);
            this.f9625b = iVar;
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Collection<E> read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            Collection<E> a = this.f9625b.a();
            aVar.a();
            while (aVar.m()) {
                a.add(this.a.read(aVar));
            }
            aVar.f();
            return a;
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.A();
                return;
            }
            cVar.c();
            for (E e2 : collection) {
                this.a.write(cVar, e2);
            }
            cVar.f();
        }
    }

    public b(com.google.gson.u.c cVar) {
        this.a = cVar;
    }

    @Override // com.google.gson.t
    public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (Collection.class.isAssignableFrom(rawType)) {
            Type h2 = com.google.gson.u.b.h(type, rawType);
            return new a(fVar, h2, fVar.l(com.google.gson.v.a.get(h2)), this.a.a(aVar));
        }
        return null;
    }
}