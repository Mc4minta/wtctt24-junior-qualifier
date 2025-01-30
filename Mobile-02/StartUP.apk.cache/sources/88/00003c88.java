package com.google.protobuf;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import java.util.ArrayList;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;

/* compiled from: Any.kt */
/* loaded from: classes2.dex */
public final class d extends com.squareup.wire.a {
    public static final Parcelable.Creator<d> CREATOR;
    public static final ProtoAdapter<d> a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f9684b = new b(null);
    @com.squareup.wire.p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)

    /* renamed from: c  reason: collision with root package name */
    private final String f9685c;
    @com.squareup.wire.p(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)

    /* renamed from: d  reason: collision with root package name */
    private final j.i f9686d;

    /* compiled from: Any.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ProtoAdapter<d> {
        a(com.squareup.wire.c cVar, kotlin.j0.d dVar) {
            super(cVar, dVar);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public d decode(com.squareup.wire.k reader) {
            kotlin.jvm.internal.m.h(reader, "reader");
            long d2 = reader.d();
            String str = null;
            j.i iVar = null;
            while (true) {
                int g2 = reader.g();
                if (g2 == -1) {
                    return new d(str, iVar, reader.e(d2));
                }
                if (g2 == 1) {
                    str = ProtoAdapter.STRING.decode(reader);
                } else if (g2 != 2) {
                    reader.m(g2);
                } else {
                    iVar = ProtoAdapter.BYTES.decode(reader);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(com.squareup.wire.l writer, d value) {
            kotlin.jvm.internal.m.h(writer, "writer");
            kotlin.jvm.internal.m.h(value, "value");
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.c());
            ProtoAdapter.BYTES.encodeWithTag(writer, 2, value.d());
            writer.a(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(d value) {
            kotlin.jvm.internal.m.h(value, "value");
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.c()) + ProtoAdapter.BYTES.encodedSizeWithTag(2, value.d()) + value.unknownFields().Q();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public d redact(d value) {
            kotlin.jvm.internal.m.h(value, "value");
            return d.b(value, null, null, j.i.a, 3, null);
        }
    }

    /* compiled from: Any.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        a aVar = new a(com.squareup.wire.c.LENGTH_DELIMITED, e0.b(d.class));
        a = aVar;
        CREATOR = com.squareup.wire.a.Companion.a(aVar);
    }

    public d() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ d(String str, j.i iVar, j.i iVar2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : iVar, (i2 & 4) != 0 ? j.i.a : iVar2);
    }

    public static /* synthetic */ d b(d dVar, String str, j.i iVar, j.i iVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dVar.f9685c;
        }
        if ((i2 & 2) != 0) {
            iVar = dVar.f9686d;
        }
        if ((i2 & 4) != 0) {
            iVar2 = dVar.unknownFields();
        }
        return dVar.a(str, iVar, iVar2);
    }

    public final d a(String str, j.i iVar, j.i unknownFields) {
        kotlin.jvm.internal.m.h(unknownFields, "unknownFields");
        return new d(str, iVar, unknownFields);
    }

    public final String c() {
        return this.f9685c;
    }

    public final j.i d() {
        return this.f9686d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return kotlin.jvm.internal.m.c(unknownFields(), dVar.unknownFields()) && kotlin.jvm.internal.m.c(this.f9685c, dVar.f9685c) && kotlin.jvm.internal.m.c(this.f9686d, dVar.f9686d);
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.f9685c;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            j.i iVar = this.f9686d;
            int hashCode3 = hashCode2 + (iVar != null ? iVar.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m2197newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.f9685c != null) {
            arrayList.add("type_url=" + this.f9685c);
        }
        if (this.f9686d != null) {
            arrayList.add("value=" + this.f9686d);
        }
        h0 = z.h0(arrayList, ", ", "Any{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, j.i iVar, j.i unknownFields) {
        super(a, unknownFields);
        kotlin.jvm.internal.m.h(unknownFields, "unknownFields");
        this.f9685c = str;
        this.f9686d = iVar;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m2197newBuilder() {
        throw new AssertionError();
    }
}