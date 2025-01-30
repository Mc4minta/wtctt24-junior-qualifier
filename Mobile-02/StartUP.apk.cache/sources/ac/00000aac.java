package com.coinbase.android.apiv3;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.google.protobuf.d;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import com.squareup.wire.q.b;
import j.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.ErrorBundle;

/* compiled from: V3Error.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B9\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/V3Error;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "code", ApiConstants.MESSAGE, "", "Lcom/google/protobuf/d;", ErrorBundle.DETAIL_ENTRY, "Lj/i;", "unknownFields", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/V3Error;", "Ljava/lang/String;", "getMessage", "Ljava/util/List;", "getDetails", "()Ljava/util/List;", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class V3Error extends a {
    public static final ProtoAdapter<V3Error> ADAPTER;
    public static final Parcelable.Creator<V3Error> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    private final Integer code;
    @p(adapter = "com.google.protobuf.Any#ADAPTER", label = p.a.REPEATED, tag = 3)
    private final List<d> details;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String message;

    /* compiled from: V3Error.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/V3Error$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/V3Error;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final c cVar = c.LENGTH_DELIMITED;
        final kotlin.j0.d b2 = e0.b(V3Error.class);
        ProtoAdapter<V3Error> protoAdapter = new ProtoAdapter<V3Error>(cVar, b2) { // from class: com.coinbase.android.apiv3.V3Error$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public V3Error decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                Integer num = null;
                String str = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new V3Error(num, str, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        num = ProtoAdapter.UINT32.decode(reader);
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        arrayList.add(d.a.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, V3Error value) {
                m.h(writer, "writer");
                m.h(value, "value");
                ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.getCode());
                ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getMessage());
                d.a.asRepeated().encodeWithTag(writer, 3, value.getDetails());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(V3Error value) {
                m.h(value, "value");
                return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.getCode()) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.getMessage()) + d.a.asRepeated().encodedSizeWithTag(3, value.getDetails()) + value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public V3Error redact(V3Error value) {
                m.h(value, "value");
                return V3Error.copy$default(value, null, null, b.a(value.getDetails(), d.a), i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public V3Error() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ V3Error(Integer num, String str, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? r.g() : list, (i2 & 8) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ V3Error copy$default(V3Error v3Error, Integer num, String str, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = v3Error.code;
        }
        if ((i2 & 2) != 0) {
            str = v3Error.message;
        }
        if ((i2 & 4) != 0) {
            list = v3Error.details;
        }
        if ((i2 & 8) != 0) {
            iVar = v3Error.unknownFields();
        }
        return v3Error.copy(num, str, list, iVar);
    }

    public final V3Error copy(Integer num, String str, List<d> details, i unknownFields) {
        m.h(details, "details");
        m.h(unknownFields, "unknownFields");
        return new V3Error(num, str, details, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof V3Error) {
            V3Error v3Error = (V3Error) obj;
            return m.c(unknownFields(), v3Error.unknownFields()) && m.c(this.code, v3Error.code) && m.c(this.message, v3Error.message) && m.c(this.details, v3Error.details);
        }
        return false;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final List<d> getDetails() {
        return this.details;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            Integer num = this.code;
            int hashCode = (num != null ? num.hashCode() : 0) * 37;
            String str = this.message;
            int hashCode2 = ((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.details.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m217newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.code != null) {
            arrayList.add("code=" + this.code);
        }
        if (this.message != null) {
            arrayList.add("message=" + this.message);
        }
        if (!this.details.isEmpty()) {
            arrayList.add("details=" + this.details);
        }
        h0 = z.h0(arrayList, ", ", "V3Error{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m217newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V3Error(Integer num, String str, List<d> details, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(details, "details");
        m.h(unknownFields, "unknownFields");
        this.code = num;
        this.message = str;
        this.details = details;
    }
}