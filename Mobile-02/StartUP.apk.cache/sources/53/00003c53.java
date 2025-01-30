package com.google.gson.u.n;

import com.google.gson.s;
import com.google.gson.u.n.i;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes2.dex */
public final class m<T> extends s<T> {
    private final com.google.gson.f a;

    /* renamed from: b  reason: collision with root package name */
    private final s<T> f9658b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f9659c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.google.gson.f fVar, s<T> sVar, Type type) {
        this.a = fVar;
        this.f9658b = sVar;
        this.f9659c = type;
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.s
    public T read(com.google.gson.stream.a aVar) throws IOException {
        return this.f9658b.read(aVar);
    }

    @Override // com.google.gson.s
    public void write(com.google.gson.stream.c cVar, T t) throws IOException {
        s<T> sVar = this.f9658b;
        Type a = a(this.f9659c, t);
        if (a != this.f9659c) {
            sVar = this.a.l(com.google.gson.v.a.get(a));
            if (sVar instanceof i.b) {
                s<T> sVar2 = this.f9658b;
                if (!(sVar2 instanceof i.b)) {
                    sVar = sVar2;
                }
            }
        }
        sVar.write(cVar, t);
    }
}