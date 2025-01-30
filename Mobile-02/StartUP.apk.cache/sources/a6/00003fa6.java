package com.squareup.wire.q;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import com.squareup.wire.g.a;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: RuntimeMessageAdapter.kt */
/* loaded from: classes2.dex */
public final class d<M extends g<M, B>, B extends g.a<M, B>> extends ProtoAdapter<M> {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final Class<M> f10892b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<B> f10893c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Integer, com.squareup.wire.q.a<M, B>> f10894d;

    /* compiled from: RuntimeMessageAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        private final <M extends g<M, B>, B extends g.a<M, B>> Class<B> b(Class<M> cls) {
            try {
                return (Class<B>) Class.forName(cls.getName() + "$Builder");
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
            }
        }

        public final <M extends g<M, B>, B extends g.a<M, B>> d<M, B> a(Class<M> messageType, String str) {
            Field[] declaredFields;
            m.h(messageType, "messageType");
            Class<B> b2 = b(messageType);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Field messageField : messageType.getDeclaredFields()) {
                p pVar = (p) messageField.getAnnotation(p.class);
                if (pVar != null) {
                    Integer valueOf = Integer.valueOf(pVar.tag());
                    m.d(messageField, "messageField");
                    linkedHashMap.put(valueOf, new com.squareup.wire.q.a(pVar, messageField, b2));
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
            m.d(unmodifiableMap, "Collections.unmodifiableMap(fieldBindings)");
            return new d<>(messageType, b2, unmodifiableMap, str);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Class<M> messageType, Class<B> builderType, Map<Integer, com.squareup.wire.q.a<M, B>> fieldBindings, String str) {
        super(com.squareup.wire.c.LENGTH_DELIMITED, kotlin.e0.a.e(messageType), str);
        m.h(messageType, "messageType");
        m.h(builderType, "builderType");
        m.h(fieldBindings, "fieldBindings");
        this.f10892b = messageType;
        this.f10893c = builderType;
        this.f10894d = fieldBindings;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: a */
    public M decode(k reader) throws IOException {
        ProtoAdapter<?> m;
        m.h(reader, "reader");
        B d2 = d();
        long d3 = reader.d();
        while (true) {
            int g2 = reader.g();
            if (g2 == -1) {
                reader.e(d3);
                return (M) d2.b();
            }
            com.squareup.wire.q.a<M, B> aVar = this.f10894d.get(Integer.valueOf(g2));
            if (aVar != null) {
                try {
                    if (aVar.j()) {
                        m = aVar.a();
                    } else {
                        m = aVar.m();
                    }
                    Object decode = m.decode(reader);
                    if (decode == null) {
                        m.q();
                    }
                    aVar.n(d2, decode);
                } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                    d2.a(g2, com.squareup.wire.c.VARINT, Long.valueOf(e2.a));
                }
            } else {
                com.squareup.wire.c h2 = reader.h();
                if (h2 == null) {
                    m.q();
                }
                d2.a(g2, h2, h2.n().decode(reader));
            }
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: b */
    public void encode(l writer, M value) throws IOException {
        m.h(writer, "writer");
        m.h(value, "value");
        for (com.squareup.wire.q.a<M, B> aVar : this.f10894d.values()) {
            Object b2 = aVar.b(value);
            if (b2 != null) {
                aVar.a().encodeWithTag(writer, aVar.i(), b2);
            }
        }
        writer.a(value.unknownFields());
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: c */
    public int encodedSize(M value) {
        m.h(value, "value");
        int cachedSerializedSize$wire_runtime = value.getCachedSerializedSize$wire_runtime();
        if (cachedSerializedSize$wire_runtime != 0) {
            return cachedSerializedSize$wire_runtime;
        }
        int i2 = 0;
        for (com.squareup.wire.q.a<M, B> aVar : this.f10894d.values()) {
            Object b2 = aVar.b(value);
            if (b2 != null) {
                i2 += aVar.a().encodedSizeWithTag(aVar.i(), b2);
            }
        }
        int Q = i2 + value.unknownFields().Q();
        value.setCachedSerializedSize$wire_runtime(Q);
        return Q;
    }

    public final B d() {
        B newInstance = this.f10893c.newInstance();
        m.d(newInstance, "builderType.newInstance()");
        return newInstance;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: e */
    public M redact(M value) {
        Class c2;
        m.h(value, "value");
        g.a newBuilder = value.newBuilder();
        for (com.squareup.wire.q.a<M, B> aVar : this.f10894d.values()) {
            r3 = null;
            String str = null;
            if (aVar.h() && aVar.f() == p.a.REQUIRED) {
                StringBuilder sb = new StringBuilder();
                sb.append("Field '");
                sb.append(aVar.g());
                sb.append("' in ");
                kotlin.j0.d<?> type = getType();
                if (type != null && (c2 = kotlin.e0.a.c(type)) != null) {
                    str = c2.getName();
                }
                sb.append(str);
                sb.append(" is required and ");
                sb.append("cannot be redacted.");
                throw new UnsupportedOperationException(sb.toString());
            }
            kotlin.j0.d<?> type2 = aVar.m().getType();
            boolean isAssignableFrom = g.class.isAssignableFrom(type2 != null ? kotlin.e0.a.c(type2) : null);
            if (!aVar.h() && (!isAssignableFrom || aVar.f().isRepeated())) {
                if (isAssignableFrom && aVar.f().isRepeated()) {
                    Object e2 = aVar.e(newBuilder);
                    if (e2 != null) {
                        List list = (List) e2;
                        ProtoAdapter<?> m = aVar.m();
                        if (m != null) {
                            aVar.l(newBuilder, b.a(list, m));
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                    }
                }
            } else {
                Object e3 = aVar.e(newBuilder);
                if (e3 != null) {
                    aVar.l(newBuilder, aVar.a().redact(e3));
                }
            }
        }
        newBuilder.c();
        return (M) newBuilder.b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && m.c(((d) obj).f10892b, this.f10892b);
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: f */
    public String toString(M value) {
        m.h(value, "value");
        StringBuilder sb = new StringBuilder();
        for (com.squareup.wire.q.a<M, B> aVar : this.f10894d.values()) {
            Object b2 = aVar.b(value);
            if (b2 != null) {
                sb.append(", ");
                sb.append(aVar.g());
                sb.append('=');
                if (aVar.h()) {
                    b2 = "██";
                }
                sb.append(b2);
            }
        }
        sb.replace(0, 2, this.f10892b.getSimpleName() + '{');
        String sb2 = sb.toString();
        m.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        return this.f10892b.hashCode();
    }
}