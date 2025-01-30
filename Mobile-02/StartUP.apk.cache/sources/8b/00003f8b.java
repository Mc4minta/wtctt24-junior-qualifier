package com.squareup.wire;

import java.io.IOException;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.e0;

/* compiled from: ProtoAdapter.kt */
/* loaded from: classes2.dex */
public final class i<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ProtoAdapter<E> originalAdapter) {
        super(c.LENGTH_DELIMITED, e0.b(List.class), (String) null);
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
    public void encode(l writer, List<? extends E> value) throws IOException {
        kotlin.jvm.internal.m.h(writer, "writer");
        kotlin.jvm.internal.m.h(value, "value");
        int size = value.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.encode(writer, (l) value.get(i2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: c */
    public void encodeWithTag(l writer, int i2, List<? extends E> list) throws IOException {
        kotlin.jvm.internal.m.h(writer, "writer");
        if (list == 0 || !(!list.isEmpty())) {
            return;
        }
        super.encodeWithTag(writer, i2, list);
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: d */
    public int encodedSize(List<? extends E> value) {
        kotlin.jvm.internal.m.h(value, "value");
        int size = value.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.a.encodedSize(value.get(i3));
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    /* renamed from: e */
    public int encodedSizeWithTag(int i2, List<? extends E> list) {
        if (list == 0 || list.isEmpty()) {
            return 0;
        }
        return super.encodedSizeWithTag(i2, list);
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