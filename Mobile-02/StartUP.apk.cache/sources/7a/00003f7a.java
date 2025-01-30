package com.squareup.wire;

import com.squareup.wire.g;
import com.squareup.wire.p;
import j.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.l0.y;

/* compiled from: ProtoAdapter.kt */
/* loaded from: classes2.dex */
public abstract class ProtoAdapter<E> {
    private final c fieldEncoding;
    private final ProtoAdapter<List<E>> packedAdapter;
    private final ProtoAdapter<List<E>> repeatedAdapter;
    private final kotlin.j0.d<?> type;
    private final String typeUrl;
    public static final a Companion = new a(null);
    public static final ProtoAdapter<Boolean> BOOL = j.a();
    public static final ProtoAdapter<Integer> INT32 = j.g();
    public static final ProtoAdapter<Integer> UINT32 = j.n();
    public static final ProtoAdapter<Integer> SINT32 = j.k();
    public static final ProtoAdapter<Integer> FIXED32 = j.d();
    public static final ProtoAdapter<Integer> SFIXED32 = j.i();
    public static final ProtoAdapter<Long> INT64 = j.h();
    public static final ProtoAdapter<Long> UINT64 = j.o();
    public static final ProtoAdapter<Long> SINT64 = j.l();
    public static final ProtoAdapter<Long> FIXED64 = j.e();
    public static final ProtoAdapter<Long> SFIXED64 = j.j();
    public static final ProtoAdapter<Float> FLOAT = j.f();
    public static final ProtoAdapter<Double> DOUBLE = j.c();
    public static final ProtoAdapter<j.i> BYTES = j.b();
    public static final ProtoAdapter<String> STRING = j.m();

    /* compiled from: ProtoAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$EnumConstantNotFoundException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "", "a", "I", "value", "Lkotlin/j0/d;", "type", "<init>", "(ILkotlin/j0/d;)V", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes2.dex */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public EnumConstantNotFoundException(int r3, kotlin.j0.d<?> r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unknown enum tag "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " for "
                r0.append(r1)
                if (r4 == 0) goto L1f
                java.lang.Class r4 = kotlin.e0.a.b(r4)
                if (r4 == 0) goto L1f
                java.lang.String r4 = r4.getName()
                goto L20
            L1f:
                r4 = 0
            L20:
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4)
                r2.a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException.<init>(int, kotlin.j0.d):void");
        }
    }

    /* compiled from: ProtoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final <M extends g<?, ?>> ProtoAdapter<M> a(M message) {
            kotlin.jvm.internal.m.h(message, "message");
            return b(message.getClass());
        }

        public final <M> ProtoAdapter<M> b(Class<M> type) {
            kotlin.jvm.internal.m.h(type, "type");
            try {
                Object obj = type.getField("ADAPTER").get(null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<M>");
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException("failed to access " + type.getName() + "#ADAPTER", e2);
            } catch (NoSuchFieldException e3) {
                throw new IllegalArgumentException("failed to access " + type.getName() + "#ADAPTER", e3);
            }
        }

        public final ProtoAdapter<?> c(String adapterString) {
            int h0;
            kotlin.jvm.internal.m.h(adapterString, "adapterString");
            try {
                h0 = y.h0(adapterString, '#', 0, false, 6, null);
                String substring = adapterString.substring(0, h0);
                kotlin.jvm.internal.m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = adapterString.substring(h0 + 1);
                kotlin.jvm.internal.m.d(substring2, "(this as java.lang.String).substring(startIndex)");
                Object obj = Class.forName(substring).getField(substring2).get(null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException("failed to access " + adapterString, e2);
            } catch (IllegalAccessException e3) {
                throw new IllegalArgumentException("failed to access " + adapterString, e3);
            } catch (NoSuchFieldException e4) {
                throw new IllegalArgumentException("failed to access " + adapterString, e4);
            }
        }

        public final <E extends o> b<E> d(Class<E> type) {
            kotlin.jvm.internal.m.h(type, "type");
            return new n(type);
        }

        public final <K, V> ProtoAdapter<Map<K, V>> e(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
            kotlin.jvm.internal.m.h(keyAdapter, "keyAdapter");
            kotlin.jvm.internal.m.h(valueAdapter, "valueAdapter");
            return new f(keyAdapter, valueAdapter);
        }

        public final <M extends g<M, B>, B extends g.a<M, B>> ProtoAdapter<M> f(Class<M> type) {
            kotlin.jvm.internal.m.h(type, "type");
            return com.squareup.wire.q.d.a.a(type, null);
        }

        public final <M extends g<M, B>, B extends g.a<M, B>> ProtoAdapter<M> g(Class<M> type, String typeUrl) {
            kotlin.jvm.internal.m.h(type, "type");
            kotlin.jvm.internal.m.h(typeUrl, "typeUrl");
            return com.squareup.wire.q.d.a.a(type, typeUrl);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProtoAdapter(c fieldEncoding, kotlin.j0.d<?> dVar, String str) {
        i iVar;
        c cVar;
        kotlin.jvm.internal.m.h(fieldEncoding, "fieldEncoding");
        this.fieldEncoding = fieldEncoding;
        this.type = dVar;
        this.typeUrl = str;
        boolean z = this instanceof i;
        m mVar = null;
        if (z || (this instanceof m) || fieldEncoding == (cVar = c.LENGTH_DELIMITED)) {
            iVar = null;
        } else {
            if (getFieldEncoding$wire_runtime() != cVar) {
                iVar = new i(this);
            } else {
                throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
            }
        }
        this.packedAdapter = iVar;
        if (!(this instanceof m) && !z) {
            mVar = new m(this);
        }
        this.repeatedAdapter = mVar;
    }

    public static final <M extends g<?, ?>> ProtoAdapter<M> get(M m) {
        return Companion.a(m);
    }

    public static final <M> ProtoAdapter<M> get(Class<M> cls) {
        return Companion.b(cls);
    }

    public static final ProtoAdapter<?> get(String str) {
        return Companion.c(str);
    }

    public static final <E extends o> b<E> newEnumAdapter(Class<E> cls) {
        return Companion.d(cls);
    }

    public static final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return Companion.e(protoAdapter, protoAdapter2);
    }

    public static final <M extends g<M, B>, B extends g.a<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return Companion.f(cls);
    }

    public static final <M extends g<M, B>, B extends g.a<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str) {
        return Companion.g(cls, str);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        if (this.fieldEncoding != c.LENGTH_DELIMITED) {
            ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            throw new UnsupportedOperationException("Can't create a packed adapter from a packed or repeated adapter.");
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        throw new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter.");
    }

    public abstract E decode(k kVar) throws IOException;

    public final E decode(InputStream stream) throws IOException {
        kotlin.jvm.internal.m.h(stream, "stream");
        return decode(q.d(q.k(stream)));
    }

    public abstract void encode(l lVar, E e2) throws IOException;

    public final void encode(OutputStream stream, E e2) throws IOException {
        kotlin.jvm.internal.m.h(stream, "stream");
        j.g c2 = q.c(q.g(stream));
        encode(c2, (j.g) e2);
        c2.w();
    }

    public final j.i encodeByteString(E e2) {
        j.f fVar = new j.f();
        encode((j.g) fVar, (j.f) e2);
        return fVar.v0();
    }

    public void encodeWithTag(l writer, int i2, E e2) throws IOException {
        kotlin.jvm.internal.m.h(writer, "writer");
        if (e2 == null) {
            return;
        }
        writer.f(i2, getFieldEncoding$wire_runtime());
        if (getFieldEncoding$wire_runtime() == c.LENGTH_DELIMITED) {
            writer.g(encodedSize(e2));
        }
        encode(writer, (l) e2);
    }

    public abstract int encodedSize(E e2);

    public int encodedSizeWithTag(int i2, E e2) {
        if (e2 == null) {
            return 0;
        }
        int encodedSize = encodedSize(e2);
        if (getFieldEncoding$wire_runtime() == c.LENGTH_DELIMITED) {
            encodedSize += l.a.i(encodedSize);
        }
        return l.a.h(i2) + encodedSize;
    }

    public final c getFieldEncoding$wire_runtime() {
        return this.fieldEncoding;
    }

    public final ProtoAdapter<List<E>> getPackedAdapter$wire_runtime() {
        return this.packedAdapter;
    }

    public final ProtoAdapter<List<E>> getRepeatedAdapter$wire_runtime() {
        return this.repeatedAdapter;
    }

    public final kotlin.j0.d<?> getType() {
        return this.type;
    }

    public final String getTypeUrl() {
        return this.typeUrl;
    }

    public abstract E redact(E e2);

    public String toString(E e2) {
        return String.valueOf(e2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ProtoAdapter<?> withLabel$wire_runtime(p.a label) {
        kotlin.jvm.internal.m.h(label, "label");
        return label.isRepeated() ? label.isPacked() ? asPacked() : asRepeated() : this;
    }

    public final E decode(byte[] bytes) throws IOException {
        kotlin.jvm.internal.m.h(bytes, "bytes");
        return decode(new j.f().write(bytes));
    }

    public final E decode(j.i bytes) throws IOException {
        kotlin.jvm.internal.m.h(bytes, "bytes");
        return decode(new j.f().K0(bytes));
    }

    public final E decode(j.h source) throws IOException {
        kotlin.jvm.internal.m.h(source, "source");
        return decode(new k(source));
    }

    public final void encode(j.g sink, E e2) throws IOException {
        kotlin.jvm.internal.m.h(sink, "sink");
        encode(new l(sink), (l) e2);
    }

    public final byte[] encode(E e2) {
        j.f fVar = new j.f();
        encode((j.g) fVar, (j.f) e2);
        return fVar.J();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(c fieldEncoding, Class<?> type) {
        this(fieldEncoding, kotlin.e0.a.e(type));
        kotlin.jvm.internal.m.h(fieldEncoding, "fieldEncoding");
        kotlin.jvm.internal.m.h(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(c fieldEncoding, kotlin.j0.d<?> dVar) {
        this(fieldEncoding, dVar, (String) null);
        kotlin.jvm.internal.m.h(fieldEncoding, "fieldEncoding");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(c fieldEncoding, Class<?> type, String str) {
        this(fieldEncoding, kotlin.e0.a.e(type), str);
        kotlin.jvm.internal.m.h(fieldEncoding, "fieldEncoding");
        kotlin.jvm.internal.m.h(type, "type");
    }
}