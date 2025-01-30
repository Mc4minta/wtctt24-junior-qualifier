package com.google.gson.u.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.o;
import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class g implements t {
    private final com.google.gson.u.c a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f9627b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    private final class a<K, V> extends s<Map<K, V>> {
        private final s<K> a;

        /* renamed from: b  reason: collision with root package name */
        private final s<V> f9628b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.gson.u.i<? extends Map<K, V>> f9629c;

        public a(com.google.gson.f fVar, Type type, s<K> sVar, Type type2, s<V> sVar2, com.google.gson.u.i<? extends Map<K, V>> iVar) {
            this.a = new m(fVar, sVar, type);
            this.f9628b = new m(fVar, sVar2, type2);
            this.f9629c = iVar;
        }

        private String a(com.google.gson.l lVar) {
            if (lVar.q()) {
                o k2 = lVar.k();
                if (k2.B()) {
                    return String.valueOf(k2.x());
                }
                if (k2.y()) {
                    return Boolean.toString(k2.r());
                }
                if (k2.D()) {
                    return k2.l();
                }
                throw new AssertionError();
            } else if (lVar.o()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b k0 = aVar.k0();
            if (k0 == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            Map<K, V> a = this.f9629c.a();
            if (k0 == com.google.gson.stream.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.m()) {
                    aVar.a();
                    K read = this.a.read(aVar);
                    if (a.put(read, this.f9628b.read(aVar)) == null) {
                        aVar.f();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                }
                aVar.f();
            } else {
                aVar.b();
                while (aVar.m()) {
                    com.google.gson.u.f.a.a(aVar);
                    K read2 = this.a.read(aVar);
                    if (a.put(read2, this.f9628b.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                }
                aVar.g();
            }
            return a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.s
        /* renamed from: c */
        public void write(com.google.gson.stream.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.A();
            } else if (!g.this.f9627b) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.v(String.valueOf(entry.getKey()));
                    this.f9628b.write(cVar, entry.getValue());
                }
                cVar.g();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.l jsonTree = this.a.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z |= jsonTree.m() || jsonTree.p();
                }
                if (z) {
                    cVar.c();
                    int size = arrayList.size();
                    while (i2 < size) {
                        cVar.c();
                        com.google.gson.u.l.b((com.google.gson.l) arrayList.get(i2), cVar);
                        this.f9628b.write(cVar, arrayList2.get(i2));
                        cVar.f();
                        i2++;
                    }
                    cVar.f();
                    return;
                }
                cVar.d();
                int size2 = arrayList.size();
                while (i2 < size2) {
                    cVar.v(a((com.google.gson.l) arrayList.get(i2)));
                    this.f9628b.write(cVar, arrayList2.get(i2));
                    i2++;
                }
                cVar.g();
            }
        }
    }

    public g(com.google.gson.u.c cVar, boolean z) {
        this.a = cVar;
        this.f9627b = z;
    }

    private s<?> a(com.google.gson.f fVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return fVar.l(com.google.gson.v.a.get(type));
        }
        return n.f9664f;
    }

    @Override // com.google.gson.t
    public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
        Type type = aVar.getType();
        if (Map.class.isAssignableFrom(aVar.getRawType())) {
            Type[] j2 = com.google.gson.u.b.j(type, com.google.gson.u.b.k(type));
            return new a(fVar, j2[0], a(fVar, j2[0]), j2[1], fVar.l(com.google.gson.v.a.get(j2[1])), this.a.a(aVar));
        }
        return null;
    }
}