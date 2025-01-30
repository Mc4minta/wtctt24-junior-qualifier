package com.squareup.wire;

import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.e0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProtoAdapter.kt */
/* loaded from: classes2.dex */
public final class e<K, V> extends ProtoAdapter<Map.Entry<? extends K, ? extends V>> {
    private final ProtoAdapter<K> a;

    /* renamed from: b  reason: collision with root package name */
    private final ProtoAdapter<V> f10860b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
        super(c.LENGTH_DELIMITED, e0.b(Map.Entry.class), (String) null);
        kotlin.jvm.internal.m.h(keyAdapter, "keyAdapter");
        kotlin.jvm.internal.m.h(valueAdapter, "valueAdapter");
        this.a = keyAdapter;
        this.f10860b = valueAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: a */
    public Map.Entry<K, V> decode(k reader) {
        kotlin.jvm.internal.m.h(reader, "reader");
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: b */
    public void encode(l writer, Map.Entry<? extends K, ? extends V> value) throws IOException {
        kotlin.jvm.internal.m.h(writer, "writer");
        kotlin.jvm.internal.m.h(value, "value");
        this.a.encodeWithTag(writer, 1, value.getKey());
        this.f10860b.encodeWithTag(writer, 2, value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: c */
    public int encodedSize(Map.Entry<? extends K, ? extends V> value) {
        kotlin.jvm.internal.m.h(value, "value");
        return this.a.encodedSizeWithTag(1, value.getKey()) + this.f10860b.encodedSizeWithTag(2, value.getValue());
    }

    public final ProtoAdapter<K> d() {
        return this.a;
    }

    public final ProtoAdapter<V> e() {
        return this.f10860b;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: f */
    public Map.Entry<K, V> redact(Map.Entry<? extends K, ? extends V> value) {
        kotlin.jvm.internal.m.h(value, "value");
        throw new UnsupportedOperationException();
    }
}