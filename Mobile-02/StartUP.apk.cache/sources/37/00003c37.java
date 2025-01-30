package com.google.gson.u.n;

import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes2.dex */
public final class a<E> extends s<Object> {
    public static final t a = new C0199a();

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f9623b;

    /* renamed from: c  reason: collision with root package name */
    private final s<E> f9624c;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: com.google.gson.u.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0199a implements t {
        C0199a() {
        }

        @Override // com.google.gson.t
        public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            Type type = aVar.getType();
            if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                Type g2 = com.google.gson.u.b.g(type);
                return new a(fVar, fVar.l(com.google.gson.v.a.get(g2)), com.google.gson.u.b.k(g2));
            }
            return null;
        }
    }

    public a(com.google.gson.f fVar, s<E> sVar, Class<E> cls) {
        this.f9624c = new m(fVar, sVar, cls);
        this.f9623b = cls;
    }

    @Override // com.google.gson.s
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == com.google.gson.stream.b.NULL) {
            aVar.a0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.m()) {
            arrayList.add(this.f9624c.read(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f9623b, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.s
    public void write(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.A();
            return;
        }
        cVar.c();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f9624c.write(cVar, Array.get(obj, i2));
        }
        cVar.f();
    }
}