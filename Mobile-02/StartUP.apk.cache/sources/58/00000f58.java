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

/* compiled from: TradingActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "value", "updated_at", "Lj/i;", "unknownFields", "copy", "(DLjava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;", "Ljava/lang/String;", "getUpdated_at", "D", "getValue", "()D", "<init>", "(DLjava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class TradingActivity extends com.squareup.wire.a {
    public static final ProtoAdapter<TradingActivity> ADAPTER;
    public static final Parcelable.Creator<TradingActivity> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "updatedAt", tag = 2)
    private final String updated_at;
    @p(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    private final double value;

    /* compiled from: TradingActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<TradingActivity> protoAdapter = new ProtoAdapter<TradingActivity>(c.LENGTH_DELIMITED, e0.b(TradingActivity.class), "type.googleapis.com/coinbase.public_api.unauthed.hydrated_view_service_unauthed.TradingActivity") { // from class: com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.TradingActivity$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TradingActivity decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                double d3 = 0.0d;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new TradingActivity(d3, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        d3 = ProtoAdapter.DOUBLE.decode(reader).doubleValue();
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, TradingActivity value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getValue() != 0.0d) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 1, Double.valueOf(value.getValue()));
                }
                if (!m.c(value.getUpdated_at(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getUpdated_at());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(TradingActivity value) {
                m.h(value, "value");
                if (value.getValue() == 0.0d) {
                    return 0;
                }
                return (m.c(value.getUpdated_at(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getUpdated_at()) + value.unknownFields().Q()) + ProtoAdapter.DOUBLE.encodedSizeWithTag(1, Double.valueOf(value.getValue()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public TradingActivity redact(TradingActivity value) {
                m.h(value, "value");
                return TradingActivity.copy$default(value, 0.0d, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public TradingActivity() {
        this(0.0d, null, null, 7, null);
    }

    public /* synthetic */ TradingActivity(double d2, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0d : d2, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ TradingActivity copy$default(TradingActivity tradingActivity, double d2, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = tradingActivity.value;
        }
        if ((i2 & 2) != 0) {
            str = tradingActivity.updated_at;
        }
        if ((i2 & 4) != 0) {
            iVar = tradingActivity.unknownFields();
        }
        return tradingActivity.copy(d2, str, iVar);
    }

    public final TradingActivity copy(double d2, String updated_at, i unknownFields) {
        m.h(updated_at, "updated_at");
        m.h(unknownFields, "unknownFields");
        return new TradingActivity(d2, updated_at, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TradingActivity) {
            TradingActivity tradingActivity = (TradingActivity) obj;
            return m.c(unknownFields(), tradingActivity.unknownFields()) && this.value == tradingActivity.value && m.c(this.updated_at, tradingActivity.updated_at);
        }
        return false;
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
            int hashCode = (((unknownFields().hashCode() * 37) + a.a(this.value)) * 37) + this.updated_at.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m560newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("value=" + this.value);
        arrayList.add("updated_at=" + b.c(this.updated_at));
        h0 = z.h0(arrayList, ", ", "TradingActivity{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TradingActivity(double d2, String updated_at, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(updated_at, "updated_at");
        m.h(unknownFields, "unknownFields");
        this.value = d2;
        this.updated_at = updated_at;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m560newBuilder() {
        throw new AssertionError();
    }
}