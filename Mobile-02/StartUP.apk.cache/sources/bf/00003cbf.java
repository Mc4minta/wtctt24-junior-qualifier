package com.google.protobuf;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import java.util.ArrayList;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;

/* compiled from: Timestamp.kt */
/* loaded from: classes2.dex */
public final class u extends com.squareup.wire.a {
    public static final Parcelable.Creator<u> CREATOR;
    public static final ProtoAdapter<u> a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f9749b = new b(null);
    @com.squareup.wire.p(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)

    /* renamed from: c  reason: collision with root package name */
    private final long f9750c;
    @com.squareup.wire.p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)

    /* renamed from: d  reason: collision with root package name */
    private final int f9751d;

    /* compiled from: Timestamp.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ProtoAdapter<u> {
        a(com.squareup.wire.c cVar, kotlin.j0.d dVar, String str) {
            super(cVar, dVar, str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public u decode(com.squareup.wire.k reader) {
            kotlin.jvm.internal.m.h(reader, "reader");
            long d2 = reader.d();
            long j2 = 0;
            int i2 = 0;
            while (true) {
                int g2 = reader.g();
                if (g2 == -1) {
                    return new u(j2, i2, reader.e(d2));
                }
                if (g2 == 1) {
                    j2 = ProtoAdapter.INT64.decode(reader).longValue();
                } else if (g2 != 2) {
                    reader.m(g2);
                } else {
                    i2 = ProtoAdapter.INT32.decode(reader).intValue();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(com.squareup.wire.l writer, u value) {
            kotlin.jvm.internal.m.h(writer, "writer");
            kotlin.jvm.internal.m.h(value, "value");
            if (value.d() != 0) {
                ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(value.d()));
            }
            if (value.c() != 0) {
                ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(value.c()));
            }
            writer.a(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(u value) {
            kotlin.jvm.internal.m.h(value, "value");
            if (value.d() == 0) {
                return 0;
            }
            return (value.c() != 0 ? ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(value.c())) + value.unknownFields().Q() : 0) + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(value.d()));
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public u redact(u value) {
            kotlin.jvm.internal.m.h(value, "value");
            return u.b(value, 0L, 0, j.i.a, 3, null);
        }
    }

    /* compiled from: Timestamp.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        a aVar = new a(com.squareup.wire.c.LENGTH_DELIMITED, e0.b(u.class), "type.googleapis.com/google.protobuf.Timestamp");
        a = aVar;
        CREATOR = com.squareup.wire.a.Companion.a(aVar);
    }

    public u() {
        this(0L, 0, null, 7, null);
    }

    public /* synthetic */ u(long j2, int i2, j.i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j2, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? j.i.a : iVar);
    }

    public static /* synthetic */ u b(u uVar, long j2, int i2, j.i iVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j2 = uVar.f9750c;
        }
        if ((i3 & 2) != 0) {
            i2 = uVar.f9751d;
        }
        if ((i3 & 4) != 0) {
            iVar = uVar.unknownFields();
        }
        return uVar.a(j2, i2, iVar);
    }

    public final u a(long j2, int i2, j.i unknownFields) {
        kotlin.jvm.internal.m.h(unknownFields, "unknownFields");
        return new u(j2, i2, unknownFields);
    }

    public final int c() {
        return this.f9751d;
    }

    public final long d() {
        return this.f9750c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            return kotlin.jvm.internal.m.c(unknownFields(), uVar.unknownFields()) && this.f9750c == uVar.f9750c && this.f9751d == uVar.f9751d;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + com.coinbase.android.apiv3.generated.authed.b.a(this.f9750c)) * 37) + this.f9751d;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m2198newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("seconds=" + this.f9750c);
        arrayList.add("nanos=" + this.f9751d);
        h0 = z.h0(arrayList, ", ", "Timestamp{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(long j2, int i2, j.i unknownFields) {
        super(a, unknownFields);
        kotlin.jvm.internal.m.h(unknownFields, "unknownFields");
        this.f9750c = j2;
        this.f9751d = i2;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m2198newBuilder() {
        throw new AssertionError();
    }
}