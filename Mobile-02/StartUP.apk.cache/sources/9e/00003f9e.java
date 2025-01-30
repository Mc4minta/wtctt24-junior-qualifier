package com.squareup.wire;

import java.io.IOException;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.e0;

/* compiled from: ProtoAdapter.kt */
/* loaded from: classes2.dex */
public final class m<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ProtoAdapter<E> originalAdapter) {
        super(originalAdapter.getFieldEncoding$wire_runtime(), e0.b(List.class), (String) null);
        kotlin.jvm.internal.m.h(originalAdapter, "originalAdapter");
        this.a = originalAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: a */
    public List<E> decode(k reader) throws IOException {
        List<E> b2;
        kotlin.jvm.internal.m.h(reader, "reader");
        b2 = q.b(this.a.decode(reader));
        return b2;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: b */
    public void encode(l writer, List<? extends E> value) {
        kotlin.jvm.internal.m.h(writer, "writer");
        kotlin.jvm.internal.m.h(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: c */
    public void encodeWithTag(l writer, int i2, List<? extends E> list) throws IOException {
        kotlin.jvm.internal.m.h(writer, "writer");
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.a.encodeWithTag(writer, i2, list.get(i3));
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: d */
    public int encodedSize(List<? extends E> value) {
        kotlin.jvm.internal.m.h(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: e */
    public int encodedSizeWithTag(int i2, List<? extends E> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += this.a.encodedSizeWithTag(i2, list.get(i4));
        }
        return i3;
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: f */
    public List<E> redact(List<? extends E> value) {
        List<E> g2;
        kotlin.jvm.internal.m.h(value, "value");
        g2 = r.g();
        return g2;
    }
}