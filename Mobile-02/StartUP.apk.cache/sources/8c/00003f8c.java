package com.squareup.wire;

import com.squareup.wire.l;
import j.g0;
import java.io.IOException;
import kotlin.jvm.internal.e0;
import kotlin.l0.y;

/* compiled from: ProtoAdapter.kt */
/* loaded from: classes2.dex */
public final class j {

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ProtoAdapter<Boolean> {
        a(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Boolean decode(com.squareup.wire.k reader) throws IOException {
            int a;
            String u0;
            kotlin.jvm.internal.m.h(reader, "reader");
            int n = reader.n();
            boolean z = true;
            if (n == 0) {
                z = false;
            } else if (n != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid boolean value 0x");
                a = kotlin.l0.b.a(16);
                String num = Integer.toString(n, a);
                kotlin.jvm.internal.m.d(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                u0 = y.u0(num, 2, '0');
                sb.append(u0);
                throw new IOException(sb.toString());
            }
            return Boolean.valueOf(z);
        }

        public void b(com.squareup.wire.l writer, boolean z) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.g(z ? 1 : 0);
        }

        public int c(boolean z) {
            return 1;
        }

        public Boolean d(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Boolean bool) {
            b(lVar, bool.booleanValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Boolean bool) {
            return c(bool.booleanValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Boolean redact(Boolean bool) {
            return d(bool.booleanValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b extends ProtoAdapter<j.i> {
        b(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public j.i decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return reader.i();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(com.squareup.wire.l writer, j.i value) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            kotlin.jvm.internal.m.h(value, "value");
            writer.a(value);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(j.i value) {
            kotlin.jvm.internal.m.h(value, "value");
            return value.Q();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public j.i redact(j.i value) {
            kotlin.jvm.internal.m.h(value, "value");
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class c extends ProtoAdapter<Double> {
        c(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Double decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            kotlin.jvm.internal.g gVar = kotlin.jvm.internal.g.a;
            return Double.valueOf(Double.longBitsToDouble(reader.k()));
        }

        public void b(com.squareup.wire.l writer, double d2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.c(Double.doubleToLongBits(d2));
        }

        public int c(double d2) {
            return 8;
        }

        public Double d(double d2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Double d2) {
            b(lVar, d2.doubleValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Double d2) {
            return c(d2.doubleValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Double redact(Double d2) {
            return d(d2.doubleValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class d extends ProtoAdapter<Integer> {
        d(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Integer decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Integer.valueOf(reader.j());
        }

        public void b(com.squareup.wire.l writer, int i2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.b(i2);
        }

        public int c(int i2) {
            return 4;
        }

        public Integer d(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Integer num) {
            b(lVar, num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
            return c(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Integer redact(Integer num) {
            return d(num.intValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class e extends ProtoAdapter<Long> {
        e(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Long decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Long.valueOf(reader.k());
        }

        public void b(com.squareup.wire.l writer, long j2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.c(j2);
        }

        public int c(long j2) {
            return 8;
        }

        public Long d(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Long l2) {
            b(lVar, l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Long l2) {
            return c(l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Long redact(Long l2) {
            return d(l2.longValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class f extends ProtoAdapter<Float> {
        f(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Float decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            kotlin.jvm.internal.h hVar = kotlin.jvm.internal.h.a;
            return Float.valueOf(Float.intBitsToFloat(reader.j()));
        }

        public void b(com.squareup.wire.l writer, float f2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.b(Float.floatToIntBits(f2));
        }

        public int c(float f2) {
            return 4;
        }

        public Float d(float f2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Float f2) {
            b(lVar, f2.floatValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Float f2) {
            return c(f2.floatValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Float redact(Float f2) {
            return d(f2.floatValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class g extends ProtoAdapter<Integer> {
        g(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Integer decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Integer.valueOf(reader.n());
        }

        public void b(com.squareup.wire.l writer, int i2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.d(i2);
        }

        public int c(int i2) {
            return com.squareup.wire.l.a.f(i2);
        }

        public Integer d(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Integer num) {
            b(lVar, num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
            return c(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Integer redact(Integer num) {
            return d(num.intValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class h extends ProtoAdapter<Long> {
        h(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Long decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Long.valueOf(reader.o());
        }

        public void b(com.squareup.wire.l writer, long j2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.h(j2);
        }

        public int c(long j2) {
            return com.squareup.wire.l.a.j(j2);
        }

        public Long d(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Long l2) {
            b(lVar, l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Long l2) {
            return c(l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Long redact(Long l2) {
            return d(l2.longValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class i extends ProtoAdapter<Integer> {
        i(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Integer decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Integer.valueOf(com.squareup.wire.l.a.b(reader.n()));
        }

        public void b(com.squareup.wire.l writer, int i2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.g(com.squareup.wire.l.a.d(i2));
        }

        public int c(int i2) {
            l.a aVar = com.squareup.wire.l.a;
            return aVar.i(aVar.d(i2));
        }

        public Integer d(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Integer num) {
            b(lVar, num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
            return c(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Integer redact(Integer num) {
            return d(num.intValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* renamed from: com.squareup.wire.j$j  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0234j extends ProtoAdapter<Long> {
        C0234j(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Long decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Long.valueOf(com.squareup.wire.l.a.c(reader.o()));
        }

        public void b(com.squareup.wire.l writer, long j2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.h(com.squareup.wire.l.a.e(j2));
        }

        public int c(long j2) {
            l.a aVar = com.squareup.wire.l.a;
            return aVar.j(aVar.e(j2));
        }

        public Long d(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Long l2) {
            b(lVar, l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Long l2) {
            return c(l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Long redact(Long l2) {
            return d(l2.longValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class k extends ProtoAdapter<String> {
        k(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public String decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return reader.l();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(com.squareup.wire.l writer, String value) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            kotlin.jvm.internal.m.h(value, "value");
            writer.e(value);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(String value) {
            kotlin.jvm.internal.m.h(value, "value");
            return (int) g0.b(value, 0, 0, 3, null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public String redact(String value) {
            kotlin.jvm.internal.m.h(value, "value");
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class l extends ProtoAdapter<Integer> {
        l(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Integer decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Integer.valueOf(reader.n());
        }

        public void b(com.squareup.wire.l writer, int i2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.g(i2);
        }

        public int c(int i2) {
            return com.squareup.wire.l.a.i(i2);
        }

        public Integer d(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Integer num) {
            b(lVar, num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
            return c(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Integer redact(Integer num) {
            return d(num.intValue());
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class m extends ProtoAdapter<Long> {
        m(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Long decode(com.squareup.wire.k reader) throws IOException {
            kotlin.jvm.internal.m.h(reader, "reader");
            return Long.valueOf(reader.o());
        }

        public void b(com.squareup.wire.l writer, long j2) throws IOException {
            kotlin.jvm.internal.m.h(writer, "writer");
            writer.h(j2);
        }

        public int c(long j2) {
            return com.squareup.wire.l.a.j(j2);
        }

        public Long d(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(com.squareup.wire.l lVar, Long l2) {
            b(lVar, l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Long l2) {
            return c(l2.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Long redact(Long l2) {
            return d(l2.longValue());
        }
    }

    public static final ProtoAdapter<Boolean> a() {
        return new a(com.squareup.wire.c.VARINT, e0.b(Boolean.TYPE), null);
    }

    public static final ProtoAdapter<j.i> b() {
        return new b(com.squareup.wire.c.LENGTH_DELIMITED, e0.b(j.i.class), null);
    }

    public static final ProtoAdapter<Double> c() {
        return new c(com.squareup.wire.c.FIXED64, e0.b(Double.TYPE), null);
    }

    public static final ProtoAdapter<Integer> d() {
        return new d(com.squareup.wire.c.FIXED32, e0.b(Integer.TYPE), null);
    }

    public static final ProtoAdapter<Long> e() {
        return new e(com.squareup.wire.c.FIXED64, e0.b(Long.TYPE), null);
    }

    public static final ProtoAdapter<Float> f() {
        return new f(com.squareup.wire.c.FIXED32, e0.b(Float.TYPE), null);
    }

    public static final ProtoAdapter<Integer> g() {
        return new g(com.squareup.wire.c.VARINT, e0.b(Integer.TYPE), null);
    }

    public static final ProtoAdapter<Long> h() {
        return new h(com.squareup.wire.c.VARINT, e0.b(Long.TYPE), null);
    }

    public static final ProtoAdapter<Integer> i() {
        return d();
    }

    public static final ProtoAdapter<Long> j() {
        return e();
    }

    public static final ProtoAdapter<Integer> k() {
        return new i(com.squareup.wire.c.VARINT, e0.b(Integer.TYPE), null);
    }

    public static final ProtoAdapter<Long> l() {
        return new C0234j(com.squareup.wire.c.VARINT, e0.b(Long.TYPE), null);
    }

    public static final ProtoAdapter<String> m() {
        return new k(com.squareup.wire.c.LENGTH_DELIMITED, e0.b(String.class), null);
    }

    public static final ProtoAdapter<Integer> n() {
        return new l(com.squareup.wire.c.VARINT, e0.b(Integer.TYPE), null);
    }

    public static final ProtoAdapter<Long> o() {
        return new m(com.squareup.wire.c.VARINT, e0.b(Long.TYPE), null);
    }
}