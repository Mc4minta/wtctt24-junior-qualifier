package com.google.gson.u.n;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters.java */
/* loaded from: classes2.dex */
public final class n {
    public static final com.google.gson.s<String> A;
    public static final com.google.gson.s<BigDecimal> B;
    public static final com.google.gson.s<BigInteger> C;
    public static final com.google.gson.t D;
    public static final com.google.gson.s<StringBuilder> E;
    public static final com.google.gson.t F;
    public static final com.google.gson.s<StringBuffer> G;
    public static final com.google.gson.t H;
    public static final com.google.gson.s<URL> I;
    public static final com.google.gson.t J;
    public static final com.google.gson.s<URI> K;
    public static final com.google.gson.t L;
    public static final com.google.gson.s<InetAddress> M;
    public static final com.google.gson.t N;
    public static final com.google.gson.s<UUID> O;
    public static final com.google.gson.t P;
    public static final com.google.gson.s<Currency> Q;
    public static final com.google.gson.t R;
    public static final com.google.gson.t S;
    public static final com.google.gson.s<Calendar> T;
    public static final com.google.gson.t U;
    public static final com.google.gson.s<Locale> V;
    public static final com.google.gson.t W;
    public static final com.google.gson.s<com.google.gson.l> X;
    public static final com.google.gson.t Y;
    public static final com.google.gson.t Z;
    public static final com.google.gson.s<Class> a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.google.gson.t f9660b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.gson.s<BitSet> f9661c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.google.gson.t f9662d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.gson.s<Boolean> f9663e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.gson.s<Boolean> f9664f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.gson.t f9665g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.gson.s<Number> f9666h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.google.gson.t f9667i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.google.gson.s<Number> f9668j;

    /* renamed from: k  reason: collision with root package name */
    public static final com.google.gson.t f9669k;

    /* renamed from: l  reason: collision with root package name */
    public static final com.google.gson.s<Number> f9670l;
    public static final com.google.gson.t m;
    public static final com.google.gson.s<AtomicInteger> n;
    public static final com.google.gson.t o;
    public static final com.google.gson.s<AtomicBoolean> p;
    public static final com.google.gson.t q;
    public static final com.google.gson.s<AtomicIntegerArray> r;
    public static final com.google.gson.t s;
    public static final com.google.gson.s<Number> t;
    public static final com.google.gson.s<Number> u;
    public static final com.google.gson.s<Number> v;
    public static final com.google.gson.s<Number> w;
    public static final com.google.gson.t x;
    public static final com.google.gson.s<Character> y;
    public static final com.google.gson.t z;

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class a extends com.google.gson.s<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.m()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.K()));
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }
            aVar.f();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.c();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.n0(atomicIntegerArray.get(i2));
            }
            cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class a0 implements com.google.gson.t {
        final /* synthetic */ Class a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f9671b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.s f9672c;

        a0(Class cls, Class cls2, com.google.gson.s sVar) {
            this.a = cls;
            this.f9671b = cls2;
            this.f9672c = sVar;
        }

        @Override // com.google.gson.t
        public <T> com.google.gson.s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.a || rawType == this.f9671b) {
                return this.f9672c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + "+" + this.f9671b.getName() + ",adapter=" + this.f9672c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class b extends com.google.gson.s<Number> {
        b() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            try {
                return Long.valueOf(aVar.N());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.r0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class b0 implements com.google.gson.t {
        final /* synthetic */ Class a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.s f9673b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* compiled from: TypeAdapters.java */
        /* loaded from: classes2.dex */
        class a<T1> extends com.google.gson.s<T1> {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // com.google.gson.s
            public T1 read(com.google.gson.stream.a aVar) throws IOException {
                T1 t1 = (T1) b0.this.f9673b.read(aVar);
                if (t1 == null || this.a.isInstance(t1)) {
                    return t1;
                }
                throw new JsonSyntaxException("Expected a " + this.a.getName() + " but was " + t1.getClass().getName());
            }

            @Override // com.google.gson.s
            public void write(com.google.gson.stream.c cVar, T1 t1) throws IOException {
                b0.this.f9673b.write(cVar, t1);
            }
        }

        b0(Class cls, com.google.gson.s sVar) {
            this.a = cls;
            this.f9673b = sVar;
        }

        @Override // com.google.gson.t
        public <T2> com.google.gson.s<T2> create(com.google.gson.f fVar, com.google.gson.v.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (this.a.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.f9673b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class c extends com.google.gson.s<Number> {
        c() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return Float.valueOf((float) aVar.G());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.r0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c0 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.gson.stream.b.values().length];
            a = iArr;
            try {
                iArr[com.google.gson.stream.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.stream.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.stream.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.gson.stream.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.gson.stream.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.gson.stream.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.google.gson.stream.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.google.gson.stream.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.google.gson.stream.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.google.gson.stream.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class d extends com.google.gson.s<Number> {
        d() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return Double.valueOf(aVar.G());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.r0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class d0 extends com.google.gson.s<Boolean> {
        d0() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b k0 = aVar.k0();
            if (k0 == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            } else if (k0 == com.google.gson.stream.b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.e0()));
            } else {
                return Boolean.valueOf(aVar.A());
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            cVar.o0(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class e extends com.google.gson.s<Number> {
        e() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b k0 = aVar.k0();
            int i2 = c0.a[k0.ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new com.google.gson.u.g(aVar.e0());
            }
            if (i2 == 4) {
                aVar.a0();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + k0);
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.r0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class e0 extends com.google.gson.s<Boolean> {
        e0() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return Boolean.valueOf(aVar.e0());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            cVar.s0(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class f extends com.google.gson.s<Character> {
        f() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            String e0 = aVar.e0();
            if (e0.length() == 1) {
                return Character.valueOf(e0.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + e0);
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Character ch) throws IOException {
            cVar.s0(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class f0 extends com.google.gson.s<Number> {
        f0() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.K());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.r0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class g extends com.google.gson.s<String> {
        g() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b k0 = aVar.k0();
            if (k0 == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            } else if (k0 == com.google.gson.stream.b.BOOLEAN) {
                return Boolean.toString(aVar.A());
            } else {
                return aVar.e0();
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, String str) throws IOException {
            cVar.s0(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class g0 extends com.google.gson.s<Number> {
        g0() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.K());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.r0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class h extends com.google.gson.s<BigDecimal> {
        h() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            try {
                return new BigDecimal(aVar.e0());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.r0(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class h0 extends com.google.gson.s<Number> {
        h0() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.K());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.r0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class i extends com.google.gson.s<BigInteger> {
        i() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            try {
                return new BigInteger(aVar.e0());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, BigInteger bigInteger) throws IOException {
            cVar.r0(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class i0 extends com.google.gson.s<AtomicInteger> {
        i0() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public AtomicInteger read(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.K());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.n0(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class j extends com.google.gson.s<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return new StringBuilder(aVar.e0());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, StringBuilder sb) throws IOException {
            cVar.s0(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class j0 extends com.google.gson.s<AtomicBoolean> {
        j0() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public AtomicBoolean read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.A());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.w0(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class k extends com.google.gson.s<Class> {
        k() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Class read(com.google.gson.stream.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    private static final class k0<T extends Enum<T>> extends com.google.gson.s<T> {
        private final Map<String, T> a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f9675b = new HashMap();

        public k0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.annotations.b bVar = (com.google.gson.annotations.b) cls.getField(name).getAnnotation(com.google.gson.annotations.b.class);
                    if (bVar != null) {
                        name = bVar.value();
                        for (String str : bVar.alternate()) {
                            this.a.put(str, t);
                        }
                    }
                    this.a.put(name, t);
                    this.f9675b.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return this.a.get(aVar.e0());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            cVar.s0(t == null ? null : this.f9675b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class l extends com.google.gson.s<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return new StringBuffer(aVar.e0());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.s0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class m extends com.google.gson.s<URL> {
        m() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            String e0 = aVar.e0();
            if ("null".equals(e0)) {
                return null;
            }
            return new URL(e0);
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, URL url) throws IOException {
            cVar.s0(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.u.n.n$n  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0200n extends com.google.gson.s<URI> {
        C0200n() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            try {
                String e0 = aVar.e0();
                if ("null".equals(e0)) {
                    return null;
                }
                return new URI(e0);
            } catch (URISyntaxException e2) {
                throw new JsonIOException(e2);
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, URI uri) throws IOException {
            cVar.s0(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class o extends com.google.gson.s<InetAddress> {
        o() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return InetAddress.getByName(aVar.e0());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, InetAddress inetAddress) throws IOException {
            cVar.s0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class p extends com.google.gson.s<UUID> {
        p() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            return UUID.fromString(aVar.e0());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, UUID uuid) throws IOException {
            cVar.s0(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class q extends com.google.gson.s<Currency> {
        q() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.e0());
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Currency currency) throws IOException {
            cVar.s0(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class r implements com.google.gson.t {

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes2.dex */
        class a extends com.google.gson.s<Timestamp> {
            final /* synthetic */ com.google.gson.s a;

            a(com.google.gson.s sVar) {
                this.a = sVar;
            }

            @Override // com.google.gson.s
            /* renamed from: a */
            public Timestamp read(com.google.gson.stream.a aVar) throws IOException {
                Date date = (Date) this.a.read(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.s
            /* renamed from: b */
            public void write(com.google.gson.stream.c cVar, Timestamp timestamp) throws IOException {
                this.a.write(cVar, timestamp);
            }
        }

        r() {
        }

        @Override // com.google.gson.t
        public <T> com.google.gson.s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            return new a(fVar.m(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class s extends com.google.gson.s<Calendar> {
        s() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            aVar.b();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.k0() != com.google.gson.stream.b.END_OBJECT) {
                String O = aVar.O();
                int K = aVar.K();
                if ("year".equals(O)) {
                    i2 = K;
                } else if ("month".equals(O)) {
                    i3 = K;
                } else if ("dayOfMonth".equals(O)) {
                    i4 = K;
                } else if ("hourOfDay".equals(O)) {
                    i5 = K;
                } else if ("minute".equals(O)) {
                    i6 = K;
                } else if ("second".equals(O)) {
                    i7 = K;
                }
            }
            aVar.g();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.A();
                return;
            }
            cVar.d();
            cVar.v("year");
            cVar.n0(calendar.get(1));
            cVar.v("month");
            cVar.n0(calendar.get(2));
            cVar.v("dayOfMonth");
            cVar.n0(calendar.get(5));
            cVar.v("hourOfDay");
            cVar.n0(calendar.get(11));
            cVar.v("minute");
            cVar.n0(calendar.get(12));
            cVar.v("second");
            cVar.n0(calendar.get(13));
            cVar.g();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class t extends com.google.gson.s<Locale> {
        t() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == com.google.gson.stream.b.NULL) {
                aVar.a0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.e0(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Locale locale) throws IOException {
            cVar.s0(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class u extends com.google.gson.s<com.google.gson.l> {
        u() {
        }

        @Override // com.google.gson.s
        /* renamed from: a */
        public com.google.gson.l read(com.google.gson.stream.a aVar) throws IOException {
            switch (c0.a[aVar.k0().ordinal()]) {
                case 1:
                    return new com.google.gson.o(new com.google.gson.u.g(aVar.e0()));
                case 2:
                    return new com.google.gson.o(Boolean.valueOf(aVar.A()));
                case 3:
                    return new com.google.gson.o(aVar.e0());
                case 4:
                    aVar.a0();
                    return com.google.gson.m.a;
                case 5:
                    com.google.gson.i iVar = new com.google.gson.i();
                    aVar.a();
                    while (aVar.m()) {
                        iVar.r(read(aVar));
                    }
                    aVar.f();
                    return iVar;
                case 6:
                    com.google.gson.n nVar = new com.google.gson.n();
                    aVar.b();
                    while (aVar.m()) {
                        nVar.r(aVar.O(), read(aVar));
                    }
                    aVar.g();
                    return nVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, com.google.gson.l lVar) throws IOException {
            if (lVar != null && !lVar.o()) {
                if (lVar.q()) {
                    com.google.gson.o k2 = lVar.k();
                    if (k2.B()) {
                        cVar.r0(k2.x());
                        return;
                    } else if (k2.y()) {
                        cVar.w0(k2.r());
                        return;
                    } else {
                        cVar.s0(k2.l());
                        return;
                    }
                } else if (lVar.m()) {
                    cVar.c();
                    Iterator<com.google.gson.l> it = lVar.h().iterator();
                    while (it.hasNext()) {
                        write(cVar, it.next());
                    }
                    cVar.f();
                    return;
                } else if (lVar.p()) {
                    cVar.d();
                    for (Map.Entry<String, com.google.gson.l> entry : lVar.i().s()) {
                        cVar.v(entry.getKey());
                        write(cVar, entry.getValue());
                    }
                    cVar.g();
                    return;
                } else {
                    throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
                }
            }
            cVar.A();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class v extends com.google.gson.s<BitSet> {
        v() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
            if (r8.K() != 0) goto L15;
         */
        @Override // com.google.gson.s
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet read(com.google.gson.stream.a r8) throws java.io.IOException {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.a()
                com.google.gson.stream.b r1 = r8.k0()
                r2 = 0
                r3 = r2
            Le:
                com.google.gson.stream.b r4 = com.google.gson.stream.b.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = com.google.gson.u.n.n.c0.a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.e0()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
                if (r1 == 0) goto L2e
                goto L69
            L2e:
                r5 = r2
                goto L69
            L30:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L47:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5e:
                boolean r5 = r8.A()
                goto L69
            L63:
                int r1 = r8.K()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                com.google.gson.stream.b r1 = r8.k0()
                goto Le
            L75:
                r8.f()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.u.n.n.v.read(com.google.gson.stream.a):java.util.BitSet");
        }

        @Override // com.google.gson.s
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, BitSet bitSet) throws IOException {
            cVar.c();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.n0(bitSet.get(i2) ? 1L : 0L);
            }
            cVar.f();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class w implements com.google.gson.t {
        w() {
        }

        @Override // com.google.gson.t
        public <T> com.google.gson.s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            Class rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = (Class<? super Object>) rawType.getSuperclass();
            }
            return new k0(rawType);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class x implements com.google.gson.t {
        final /* synthetic */ com.google.gson.v.a a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.s f9677b;

        x(com.google.gson.v.a aVar, com.google.gson.s sVar) {
            this.a = aVar;
            this.f9677b = sVar;
        }

        @Override // com.google.gson.t
        public <T> com.google.gson.s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.equals(this.a)) {
                return this.f9677b;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class y implements com.google.gson.t {
        final /* synthetic */ Class a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.s f9678b;

        y(Class cls, com.google.gson.s sVar) {
            this.a = cls;
            this.f9678b = sVar;
        }

        @Override // com.google.gson.t
        public <T> com.google.gson.s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.getRawType() == this.a) {
                return this.f9678b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + ",adapter=" + this.f9678b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class z implements com.google.gson.t {
        final /* synthetic */ Class a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f9679b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.s f9680c;

        z(Class cls, Class cls2, com.google.gson.s sVar) {
            this.a = cls;
            this.f9679b = cls2;
            this.f9680c = sVar;
        }

        @Override // com.google.gson.t
        public <T> com.google.gson.s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.a || rawType == this.f9679b) {
                return this.f9680c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9679b.getName() + "+" + this.a.getName() + ",adapter=" + this.f9680c + "]";
        }
    }

    static {
        com.google.gson.s<Class> nullSafe = new k().nullSafe();
        a = nullSafe;
        f9660b = b(Class.class, nullSafe);
        com.google.gson.s<BitSet> nullSafe2 = new v().nullSafe();
        f9661c = nullSafe2;
        f9662d = b(BitSet.class, nullSafe2);
        d0 d0Var = new d0();
        f9663e = d0Var;
        f9664f = new e0();
        f9665g = c(Boolean.TYPE, Boolean.class, d0Var);
        f0 f0Var = new f0();
        f9666h = f0Var;
        f9667i = c(Byte.TYPE, Byte.class, f0Var);
        g0 g0Var = new g0();
        f9668j = g0Var;
        f9669k = c(Short.TYPE, Short.class, g0Var);
        h0 h0Var = new h0();
        f9670l = h0Var;
        m = c(Integer.TYPE, Integer.class, h0Var);
        com.google.gson.s<AtomicInteger> nullSafe3 = new i0().nullSafe();
        n = nullSafe3;
        o = b(AtomicInteger.class, nullSafe3);
        com.google.gson.s<AtomicBoolean> nullSafe4 = new j0().nullSafe();
        p = nullSafe4;
        q = b(AtomicBoolean.class, nullSafe4);
        com.google.gson.s<AtomicIntegerArray> nullSafe5 = new a().nullSafe();
        r = nullSafe5;
        s = b(AtomicIntegerArray.class, nullSafe5);
        t = new b();
        u = new c();
        v = new d();
        e eVar = new e();
        w = eVar;
        x = b(Number.class, eVar);
        f fVar = new f();
        y = fVar;
        z = c(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        B = new h();
        C = new i();
        D = b(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = b(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = b(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        J = b(URL.class, mVar);
        C0200n c0200n = new C0200n();
        K = c0200n;
        L = b(URI.class, c0200n);
        o oVar = new o();
        M = oVar;
        N = e(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = b(UUID.class, pVar);
        com.google.gson.s<Currency> nullSafe6 = new q().nullSafe();
        Q = nullSafe6;
        R = b(Currency.class, nullSafe6);
        S = new r();
        s sVar = new s();
        T = sVar;
        U = d(Calendar.class, GregorianCalendar.class, sVar);
        t tVar = new t();
        V = tVar;
        W = b(Locale.class, tVar);
        u uVar = new u();
        X = uVar;
        Y = e(com.google.gson.l.class, uVar);
        Z = new w();
    }

    public static <TT> com.google.gson.t a(com.google.gson.v.a<TT> aVar, com.google.gson.s<TT> sVar) {
        return new x(aVar, sVar);
    }

    public static <TT> com.google.gson.t b(Class<TT> cls, com.google.gson.s<TT> sVar) {
        return new y(cls, sVar);
    }

    public static <TT> com.google.gson.t c(Class<TT> cls, Class<TT> cls2, com.google.gson.s<? super TT> sVar) {
        return new z(cls, cls2, sVar);
    }

    public static <TT> com.google.gson.t d(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.s<? super TT> sVar) {
        return new a0(cls, cls2, sVar);
    }

    public static <T1> com.google.gson.t e(Class<T1> cls, com.google.gson.s<T1> sVar) {
        return new b0(cls, sVar);
    }
}