package com.squareup.wire;

import java.io.IOException;
import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.e0;
import kotlin.u;

/* compiled from: ProtoAdapter.kt */
/* loaded from: classes2.dex */
public final class f<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    private final e<K, V> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
        super(c.LENGTH_DELIMITED, e0.b(Map.class), (String) null);
        kotlin.jvm.internal.m.h(keyAdapter, "keyAdapter");
        kotlin.jvm.internal.m.h(valueAdapter, "valueAdapter");
        this.a = new e<>(keyAdapter, valueAdapter);
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: a */
    public Map<K, V> decode(k reader) throws IOException {
        Map<K, V> e2;
        kotlin.jvm.internal.m.h(reader, "reader");
        long d2 = reader.d();
        K k2 = null;
        V v = null;
        while (true) {
            int g2 = reader.g();
            if (g2 == -1) {
                break;
            } else if (g2 == 1) {
                k2 = this.a.d().decode(reader);
            } else if (g2 == 2) {
                v = this.a.e().decode(reader);
            }
        }
        reader.e(d2);
        if (k2 != null) {
            if (v != null) {
                e2 = l0.e(u.a(k2, v));
                return e2;
            }
            throw new IllegalStateException("Map entry with null value".toString());
        }
        throw new IllegalStateException("Map entry with null key".toString());
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: b */
    public void encode(l writer, Map<K, ? extends V> value) {
        kotlin.jvm.internal.m.h(writer, "writer");
        kotlin.jvm.internal.m.h(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: c */
    public void encodeWithTag(l writer, int i2, Map<K, ? extends V> map) throws IOException {
        kotlin.jvm.internal.m.h(writer, "writer");
        if (map == null) {
            return;
        }
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            this.a.encodeWithTag(writer, i2, entry);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: d */
    public int encodedSize(Map<K, ? extends V> value) {
        kotlin.jvm.internal.m.h(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: e */
    public int encodedSizeWithTag(int i2, Map<K, ? extends V> map) {
        int i3 = 0;
        if (map == null) {
            return 0;
        }
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            i3 += this.a.encodedSizeWithTag(i2, entry);
        }
        return i3;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: f */
    public Map<K, V> redact(Map<K, ? extends V> value) {
        Map<K, V> i2;
        kotlin.jvm.internal.m.h(value, "value");
        i2 = m0.i();
        return i2;
    }
}