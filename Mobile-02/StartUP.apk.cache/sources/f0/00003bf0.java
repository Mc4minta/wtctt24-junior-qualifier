package com.google.gson;

import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* loaded from: classes2.dex */
public final class f {
    private static final com.google.gson.v.a<?> a = com.google.gson.v.a.get(Object.class);

    /* renamed from: b  reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.v.a<?>, C0195f<?>>> f9522b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<com.google.gson.v.a<?>, s<?>> f9523c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.u.c f9524d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.gson.u.n.d f9525e;

    /* renamed from: f  reason: collision with root package name */
    final List<t> f9526f;

    /* renamed from: g  reason: collision with root package name */
    final com.google.gson.u.d f9527g;

    /* renamed from: h  reason: collision with root package name */
    final com.google.gson.e f9528h;

    /* renamed from: i  reason: collision with root package name */
    final Map<Type, h<?>> f9529i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f9530j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f9531k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f9532l;
    final boolean m;
    final boolean n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final r t;
    final List<t> u;
    final List<t> v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public class a extends s<Number> {
        a() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Double read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return Double.valueOf(aVar.G());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.A();
                return;
            }
            f.d(number.doubleValue());
            cVar.r0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public class b extends s<Number> {
        b() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Float read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return Float.valueOf((float) aVar.G());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.A();
                return;
            }
            f.d(number.floatValue());
            cVar.r0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public static class c extends s<Number> {
        c() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return Long.valueOf(aVar.N());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.A();
            } else {
                cVar.s0(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public static class d extends s<AtomicLong> {
        final /* synthetic */ s a;

        d(s sVar) {
            this.a = sVar;
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public AtomicLong read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicLong(((Number) this.a.read(aVar)).longValue());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, AtomicLong atomicLong) throws IOException {
            this.a.write(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public static class e extends s<AtomicLongArray> {
        final /* synthetic */ s a;

        e(s sVar) {
            this.a = sVar;
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public AtomicLongArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.m()) {
                arrayList.add(Long.valueOf(((Number) this.a.read(aVar)).longValue()));
            }
            aVar.f();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.c();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.a.write(cVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0195f<T> extends s<T> {
        private s<T> a;

        C0195f() {
        }

        public void a(s<T> sVar) {
            if (this.a == null) {
                this.a = sVar;
                return;
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.s
        public T read(com.google.gson.stream.a aVar) throws IOException {
            s<T> sVar = this.a;
            if (sVar != null) {
                return sVar.read(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.s
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            s<T> sVar = this.a;
            if (sVar != null) {
                sVar.write(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.google.gson.u.d dVar, com.google.gson.e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, r rVar, String str, int i2, int i3, List<t> list, List<t> list2, List<t> list3) {
        this.f9527g = dVar;
        this.f9528h = eVar;
        this.f9529i = map;
        com.google.gson.u.c cVar = new com.google.gson.u.c(map);
        this.f9524d = cVar;
        this.f9530j = z;
        this.f9531k = z2;
        this.f9532l = z3;
        this.m = z4;
        this.n = z5;
        this.o = z6;
        this.p = z7;
        this.t = rVar;
        this.q = str;
        this.r = i2;
        this.s = i3;
        this.u = list;
        this.v = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.u.n.n.Y);
        arrayList.add(com.google.gson.u.n.h.a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.google.gson.u.n.n.D);
        arrayList.add(com.google.gson.u.n.n.m);
        arrayList.add(com.google.gson.u.n.n.f9665g);
        arrayList.add(com.google.gson.u.n.n.f9667i);
        arrayList.add(com.google.gson.u.n.n.f9669k);
        s<Number> o = o(rVar);
        arrayList.add(com.google.gson.u.n.n.c(Long.TYPE, Long.class, o));
        arrayList.add(com.google.gson.u.n.n.c(Double.TYPE, Double.class, e(z7)));
        arrayList.add(com.google.gson.u.n.n.c(Float.TYPE, Float.class, f(z7)));
        arrayList.add(com.google.gson.u.n.n.x);
        arrayList.add(com.google.gson.u.n.n.o);
        arrayList.add(com.google.gson.u.n.n.q);
        arrayList.add(com.google.gson.u.n.n.b(AtomicLong.class, b(o)));
        arrayList.add(com.google.gson.u.n.n.b(AtomicLongArray.class, c(o)));
        arrayList.add(com.google.gson.u.n.n.s);
        arrayList.add(com.google.gson.u.n.n.z);
        arrayList.add(com.google.gson.u.n.n.F);
        arrayList.add(com.google.gson.u.n.n.H);
        arrayList.add(com.google.gson.u.n.n.b(BigDecimal.class, com.google.gson.u.n.n.B));
        arrayList.add(com.google.gson.u.n.n.b(BigInteger.class, com.google.gson.u.n.n.C));
        arrayList.add(com.google.gson.u.n.n.J);
        arrayList.add(com.google.gson.u.n.n.L);
        arrayList.add(com.google.gson.u.n.n.P);
        arrayList.add(com.google.gson.u.n.n.R);
        arrayList.add(com.google.gson.u.n.n.W);
        arrayList.add(com.google.gson.u.n.n.N);
        arrayList.add(com.google.gson.u.n.n.f9662d);
        arrayList.add(com.google.gson.u.n.c.a);
        arrayList.add(com.google.gson.u.n.n.U);
        arrayList.add(com.google.gson.u.n.k.a);
        arrayList.add(com.google.gson.u.n.j.a);
        arrayList.add(com.google.gson.u.n.n.S);
        arrayList.add(com.google.gson.u.n.a.a);
        arrayList.add(com.google.gson.u.n.n.f9660b);
        arrayList.add(new com.google.gson.u.n.b(cVar));
        arrayList.add(new com.google.gson.u.n.g(cVar, z2));
        com.google.gson.u.n.d dVar2 = new com.google.gson.u.n.d(cVar);
        this.f9525e = dVar2;
        arrayList.add(dVar2);
        arrayList.add(com.google.gson.u.n.n.Z);
        arrayList.add(new com.google.gson.u.n.i(cVar, eVar, dVar, dVar2));
        this.f9526f = Collections.unmodifiableList(arrayList);
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.k0() == com.google.gson.stream.b.END_DOCUMENT) {
                    return;
                }
                throw new JsonIOException("JSON document was not fully consumed.");
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    private static s<AtomicLong> b(s<Number> sVar) {
        return new d(sVar).nullSafe();
    }

    private static s<AtomicLongArray> c(s<Number> sVar) {
        return new e(sVar).nullSafe();
    }

    static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private s<Number> e(boolean z) {
        if (z) {
            return com.google.gson.u.n.n.v;
        }
        return new a();
    }

    private s<Number> f(boolean z) {
        if (z) {
            return com.google.gson.u.n.n.u;
        }
        return new b();
    }

    private static s<Number> o(r rVar) {
        if (rVar == r.a) {
            return com.google.gson.u.n.n.t;
        }
        return new c();
    }

    public <T> T g(l lVar, Type type) throws JsonSyntaxException {
        if (lVar == null) {
            return null;
        }
        return (T) h(new com.google.gson.u.n.e(lVar), type);
    }

    public <T> T h(com.google.gson.stream.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean n = aVar.n();
        boolean z = true;
        aVar.w0(true);
        try {
            try {
                try {
                    aVar.k0();
                    z = false;
                    T read = l(com.google.gson.v.a.get(type)).read(aVar);
                    aVar.w0(n);
                    return read;
                } catch (EOFException e2) {
                    if (z) {
                        aVar.w0(n);
                        return null;
                    }
                    throw new JsonSyntaxException(e2);
                } catch (AssertionError e3) {
                    throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
                }
            } catch (IOException e4) {
                throw new JsonSyntaxException(e4);
            } catch (IllegalStateException e5) {
                throw new JsonSyntaxException(e5);
            }
        } catch (Throwable th) {
            aVar.w0(n);
            throw th;
        }
    }

    public <T> T i(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        com.google.gson.stream.a p = p(reader);
        T t = (T) h(p, type);
        a(t, p);
        return t;
    }

    public <T> T j(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) com.google.gson.u.k.c(cls).cast(k(str, cls));
    }

    public <T> T k(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) i(new StringReader(str), type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> s<T> l(com.google.gson.v.a<T> aVar) {
        s<T> sVar = (s<T>) this.f9523c.get(aVar == null ? a : aVar);
        if (sVar != null) {
            return sVar;
        }
        Map<com.google.gson.v.a<?>, C0195f<?>> map = this.f9522b.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f9522b.set(map);
            z = true;
        }
        C0195f<?> c0195f = map.get(aVar);
        if (c0195f != null) {
            return c0195f;
        }
        try {
            C0195f<?> c0195f2 = new C0195f<>();
            map.put(aVar, c0195f2);
            for (t tVar : this.f9526f) {
                s sVar2 = (s<T>) tVar.create(this, aVar);
                if (sVar2 != null) {
                    c0195f2.a(sVar2);
                    this.f9523c.put(aVar, sVar2);
                    return sVar2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.f9522b.remove();
            }
        }
    }

    public <T> s<T> m(Class<T> cls) {
        return l(com.google.gson.v.a.get((Class) cls));
    }

    public <T> s<T> n(t tVar, com.google.gson.v.a<T> aVar) {
        if (!this.f9526f.contains(tVar)) {
            tVar = this.f9525e;
        }
        boolean z = false;
        for (t tVar2 : this.f9526f) {
            if (z) {
                s<T> create = tVar2.create(this, aVar);
                if (create != null) {
                    return create;
                }
            } else if (tVar2 == tVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public com.google.gson.stream.a p(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.w0(this.o);
        return aVar;
    }

    public com.google.gson.stream.c q(Writer writer) throws IOException {
        if (this.f9532l) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.c cVar = new com.google.gson.stream.c(writer);
        if (this.n) {
            cVar.a0("  ");
        }
        cVar.e0(this.f9530j);
        return cVar;
    }

    public void r(Object obj, Type type, com.google.gson.stream.c cVar) throws JsonIOException {
        s l2 = l(com.google.gson.v.a.get(type));
        boolean n = cVar.n();
        cVar.d0(true);
        boolean m = cVar.m();
        cVar.V(this.m);
        boolean j2 = cVar.j();
        cVar.e0(this.f9530j);
        try {
            try {
                l2.write(cVar, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            cVar.d0(n);
            cVar.V(m);
            cVar.e0(j2);
        }
    }

    public l s(Object obj, Type type) {
        com.google.gson.u.n.f fVar = new com.google.gson.u.n.f();
        r(obj, type, fVar);
        return fVar.y0();
    }

    public String toString() {
        return "{serializeNulls:" + this.f9530j + ",factories:" + this.f9526f + ",instanceCreators:" + this.f9524d + "}";
    }
}