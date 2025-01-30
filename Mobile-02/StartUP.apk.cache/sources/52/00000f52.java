package com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import com.squareup.wire.q.b;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: PercentHolding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "rank", "", "value", "updated_at", "Lj/i;", "unknownFields", "copy", "(IDLjava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;", "I", "getRank", "Ljava/lang/String;", "getUpdated_at", "D", "getValue", "()D", "<init>", "(IDLjava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PercentHolding extends com.squareup.wire.a {
    public static final ProtoAdapter<PercentHolding> ADAPTER;
    public static final Parcelable.Creator<PercentHolding> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    private final int rank;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "updatedAt", tag = 3)
    private final String updated_at;
    @p(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    private final double value;

    /* compiled from: PercentHolding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PercentHolding> protoAdapter = new ProtoAdapter<PercentHolding>(c.LENGTH_DELIMITED, e0.b(PercentHolding.class), "type.googleapis.com/coinbase.public_api.unauthed.hydrated_view_service_unauthed.PercentHolding") { // from class: com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.PercentHolding$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PercentHolding decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                int i2 = 0;
                double d3 = 0.0d;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PercentHolding(i2, d3, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        i2 = ProtoAdapter.INT32.decode(reader).intValue();
                    } else if (g2 == 2) {
                        d3 = ProtoAdapter.DOUBLE.decode(reader).doubleValue();
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PercentHolding value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getRank() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 1, Integer.valueOf(value.getRank()));
                }
                if (value.getValue() != 0.0d) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 2, Double.valueOf(value.getValue()));
                }
                if (!m.c(value.getUpdated_at(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getUpdated_at());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PercentHolding value) {
                m.h(value, "value");
                if (value.getRank() == 0) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(value.getRank()));
                if (value.getValue() != 0.0d) {
                    r1 = (m.c(value.getUpdated_at(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(3, value.getUpdated_at()) + value.unknownFields().Q()) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, Double.valueOf(value.getValue()));
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PercentHolding redact(PercentHolding value) {
                m.h(value, "value");
                return PercentHolding.copy$default(value, 0, 0.0d, null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public PercentHolding() {
        this(0, 0.0d, null, null, 15, null);
    }

    public /* synthetic */ PercentHolding(int i2, double d2, String str, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? 0.0d : d2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PercentHolding copy$default(PercentHolding percentHolding, int i2, double d2, String str, i iVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = percentHolding.rank;
        }
        if ((i3 & 2) != 0) {
            d2 = percentHolding.value;
        }
        double d3 = d2;
        if ((i3 & 4) != 0) {
            str = percentHolding.updated_at;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            iVar = percentHolding.unknownFields();
        }
        return percentHolding.copy(i2, d3, str2, iVar);
    }

    public final PercentHolding copy(int i2, double d2, String updated_at, i unknownFields) {
        m.h(updated_at, "updated_at");
        m.h(unknownFields, "unknownFields");
        return new PercentHolding(i2, d2, updated_at, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PercentHolding) {
            PercentHolding percentHolding = (PercentHolding) obj;
            return m.c(unknownFields(), percentHolding.unknownFields()) && this.rank == percentHolding.rank && this.value == percentHolding.value && m.c(this.updated_at, percentHolding.updated_at);
        }
        return false;
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getUpdated_at() {
        return this.updated_at;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.rank) * 37) + a.a(this.value)) * 37) + this.updated_at.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m558newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("rank=" + this.rank);
        arrayList.add("value=" + this.value);
        arrayList.add("updated_at=" + b.c(this.updated_at));
        h0 = z.h0(arrayList, ", ", "PercentHolding{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PercentHolding(int i2, double d2, String updated_at, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(updated_at, "updated_at");
        m.h(unknownFields, "unknownFields");
        this.rank = i2;
        this.value = d2;
        this.updated_at = updated_at;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m558newBuilder() {
        throw new AssertionError();
    }
}