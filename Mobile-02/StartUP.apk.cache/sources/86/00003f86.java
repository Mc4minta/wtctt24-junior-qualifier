package com.squareup.wire;

import com.squareup.wire.g;
import com.squareup.wire.g.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Message.kt */
/* loaded from: classes2.dex */
public abstract class g<M extends g<M, B>, B extends a<M, B>> implements Serializable {
    public static final b Companion = new b(null);
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    private transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient j.i unknownFields;

    /* compiled from: Message.kt */
    /* loaded from: classes2.dex */
    public static abstract class a<M extends g<M, B>, B extends a<M, B>> {
        private transient j.i a = j.i.a;

        /* renamed from: b  reason: collision with root package name */
        private transient j.f f10861b;

        /* renamed from: c  reason: collision with root package name */
        private transient l f10862c;

        protected a() {
        }

        private final void d() {
            if (this.f10861b == null) {
                this.f10861b = new j.f();
                j.f fVar = this.f10861b;
                if (fVar == null) {
                    kotlin.jvm.internal.m.q();
                }
                l lVar = new l(fVar);
                this.f10862c = lVar;
                if (lVar == null) {
                    kotlin.jvm.internal.m.q();
                }
                lVar.a(this.a);
                this.a = j.i.a;
            }
        }

        public final a<M, B> a(int i2, c fieldEncoding, Object obj) {
            kotlin.jvm.internal.m.h(fieldEncoding, "fieldEncoding");
            d();
            ProtoAdapter<?> n = fieldEncoding.n();
            if (n != null) {
                l lVar = this.f10862c;
                if (lVar == null) {
                    kotlin.jvm.internal.m.q();
                }
                n.encodeWithTag(lVar, i2, obj);
                return this;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        }

        public abstract M b();

        public final a<M, B> c() {
            this.a = j.i.a;
            j.f fVar = this.f10861b;
            if (fVar != null) {
                if (fVar == null) {
                    kotlin.jvm.internal.m.q();
                }
                fVar.b();
                this.f10861b = null;
            }
            this.f10862c = null;
            return this;
        }
    }

    /* compiled from: Message.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(ProtoAdapter<M> adapter, j.i unknownFields) {
        kotlin.jvm.internal.m.h(adapter, "adapter");
        kotlin.jvm.internal.m.h(unknownFields, "unknownFields");
        this.adapter = adapter;
        this.unknownFields = unknownFields;
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(j.g sink) throws IOException {
        kotlin.jvm.internal.m.h(sink, "sink");
        this.adapter.encode(sink, (j.g) this);
    }

    public final j.i encodeByteString() {
        return this.adapter.encodeByteString(this);
    }

    public final int getCachedSerializedSize$wire_runtime() {
        return this.cachedSerializedSize;
    }

    public abstract B newBuilder();

    public final void setCachedSerializedSize$wire_runtime(int i2) {
        this.cachedSerializedSize = i2;
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    public final j.i unknownFields() {
        j.i iVar = this.unknownFields;
        return iVar == null ? j.i.a : iVar;
    }

    public final M withoutUnknownFields() {
        return newBuilder().c().b();
    }

    protected final Object writeReplace() throws ObjectStreamException {
        byte[] encode = encode();
        Class<?> cls = getClass();
        if (cls != null) {
            return new h(encode, cls);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<M>");
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream stream) throws IOException {
        kotlin.jvm.internal.m.h(stream, "stream");
        this.adapter.encode(stream, (OutputStream) this);
    }
}