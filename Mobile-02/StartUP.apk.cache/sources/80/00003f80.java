package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.o;
import java.io.IOException;

/* compiled from: EnumAdapter.kt */
/* loaded from: classes2.dex */
public abstract class b<E extends o> extends ProtoAdapter<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(kotlin.j0.d<E> type) {
        super(c.VARINT, (kotlin.j0.d<?>) type, (String) null);
        kotlin.jvm.internal.m.h(type, "type");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(l lVar, Object obj) {
        encode(lVar, (l) ((o) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((b<E>) ((o) obj));
    }

    protected abstract E fromValue(int i2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact((b<E>) ((o) obj));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Class<E> type) {
        this(kotlin.e0.a.e(type));
        kotlin.jvm.internal.m.h(type, "type");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E decode(k reader) throws IOException {
        kotlin.jvm.internal.m.h(reader, "reader");
        int n = reader.n();
        E fromValue = fromValue(n);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(n, getType());
    }

    public void encode(l writer, E value) throws IOException {
        kotlin.jvm.internal.m.h(writer, "writer");
        kotlin.jvm.internal.m.h(value, "value");
        writer.g(value.getValue());
    }

    public int encodedSize(E value) {
        kotlin.jvm.internal.m.h(value, "value");
        return l.a.i(value.getValue());
    }

    public E redact(E value) {
        kotlin.jvm.internal.m.h(value, "value");
        throw new UnsupportedOperationException();
    }
}