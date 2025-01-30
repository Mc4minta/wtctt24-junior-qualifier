package com.google.gson.u.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class i implements t {
    private final com.google.gson.u.c a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.e f9632b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.u.d f9633c;

    /* renamed from: d  reason: collision with root package name */
    private final d f9634d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.gson.u.o.b f9635e = com.google.gson.u.o.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public class a extends c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Field f9636d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f9637e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ s f9638f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.google.gson.f f9639g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ com.google.gson.v.a f9640h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f9641i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, Field field, boolean z3, s sVar, com.google.gson.f fVar, com.google.gson.v.a aVar, boolean z4) {
            super(str, z, z2);
            this.f9636d = field;
            this.f9637e = z3;
            this.f9638f = sVar;
            this.f9639g = fVar;
            this.f9640h = aVar;
            this.f9641i = z4;
        }

        @Override // com.google.gson.u.n.i.c
        void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object read = this.f9638f.read(aVar);
            if (read == null && this.f9641i) {
                return;
            }
            this.f9636d.set(obj, read);
        }

        @Override // com.google.gson.u.n.i.c
        void b(com.google.gson.stream.c cVar, Object obj) throws IOException, IllegalAccessException {
            (this.f9637e ? this.f9638f : new m(this.f9639g, this.f9638f, this.f9640h.getType())).write(cVar, this.f9636d.get(obj));
        }

        @Override // com.google.gson.u.n.i.c
        public boolean c(Object obj) throws IOException, IllegalAccessException {
            return this.f9644b && this.f9636d.get(obj) != obj;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public static final class b<T> extends s<T> {
        private final com.google.gson.u.i<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, c> f9643b;

        b(com.google.gson.u.i<T> iVar, Map<String, c> map) {
            this.a = iVar;
            this.f9643b = map;
        }

        @Override // com.google.gson.s
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            T a = this.a.a();
            try {
                aVar.b();
                while (aVar.m()) {
                    c cVar = this.f9643b.get(aVar.O());
                    if (cVar != null && cVar.f9645c) {
                        cVar.a(aVar, a);
                    }
                    aVar.J0();
                }
                aVar.g();
                return a;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.s
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.A();
                return;
            }
            cVar.d();
            try {
                for (c cVar2 : this.f9643b.values()) {
                    if (cVar2.c(t)) {
                        cVar.v(cVar2.a);
                        cVar2.b(cVar, t);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public static abstract class c {
        final String a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f9644b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f9645c;

        protected c(String str, boolean z, boolean z2) {
            this.a = str;
            this.f9644b = z;
            this.f9645c = z2;
        }

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void b(com.google.gson.stream.c cVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public i(com.google.gson.u.c cVar, com.google.gson.e eVar, com.google.gson.u.d dVar, d dVar2) {
        this.a = cVar;
        this.f9632b = eVar;
        this.f9633c = dVar;
        this.f9634d = dVar2;
    }

    private c a(com.google.gson.f fVar, Field field, String str, com.google.gson.v.a<?> aVar, boolean z, boolean z2) {
        boolean b2 = com.google.gson.u.k.b(aVar.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        s<?> a2 = jsonAdapter != null ? this.f9634d.a(this.a, fVar, aVar, jsonAdapter) : null;
        boolean z3 = a2 != null;
        if (a2 == null) {
            a2 = fVar.l(aVar);
        }
        return new a(str, z, z2, field, z3, a2, fVar, aVar, b2);
    }

    static boolean c(Field field, boolean z, com.google.gson.u.d dVar) {
        return (dVar.c(field.getType(), z) || dVar.f(field, z)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    private Map<String, c> d(com.google.gson.f fVar, com.google.gson.v.a<?> aVar, Class<?> cls) {
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.v.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean b2 = b(field, true);
                boolean b3 = b(field, z);
                if (b2 || b3) {
                    this.f9635e.b(field);
                    Type p = com.google.gson.u.b.p(aVar2.getType(), cls2, field.getGenericType());
                    List<String> e2 = e(field);
                    int size = e2.size();
                    c cVar2 = null;
                    int i3 = z;
                    while (i3 < size) {
                        String str = e2.get(i3);
                        boolean z2 = i3 != 0 ? z : b2;
                        int i4 = i3;
                        c cVar3 = cVar2;
                        int i5 = size;
                        List<String> list = e2;
                        Field field2 = field;
                        cVar2 = cVar3 == null ? (c) linkedHashMap.put(str, a(fVar, field, str, com.google.gson.v.a.get(p), z2, b3)) : cVar3;
                        b2 = z2;
                        e2 = list;
                        size = i5;
                        field = field2;
                        z = false;
                        i3 = i4 + 1;
                    }
                    if (cVar2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar.a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = com.google.gson.v.a.get(com.google.gson.u.b.p(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> e(Field field) {
        com.google.gson.annotations.b bVar = (com.google.gson.annotations.b) field.getAnnotation(com.google.gson.annotations.b.class);
        if (bVar == null) {
            return Collections.singletonList(this.f9632b.h(field));
        }
        String value = bVar.value();
        String[] alternate = bVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public boolean b(Field field, boolean z) {
        return c(field, z, this.f9633c);
    }

    @Override // com.google.gson.t
    public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new b(this.a.a(aVar), d(fVar, aVar, rawType));
        }
        return null;
    }
}