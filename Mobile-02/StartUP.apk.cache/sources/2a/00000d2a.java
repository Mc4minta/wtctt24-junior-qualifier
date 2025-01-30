package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Tooltip;
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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetLoyaltySummaryResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltySummaryResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "lifetime_loyalty_amount", "Lcom/coinbase/android/apiv3/generated/common/Tooltip;", "tooltip", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Tooltip;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltySummaryResponse;", "Lcom/coinbase/android/apiv3/generated/common/Tooltip;", "getTooltip", "()Lcom/coinbase/android/apiv3/generated/common/Tooltip;", "Ljava/lang/String;", "getLifetime_loyalty_amount", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Tooltip;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetLoyaltySummaryResponse extends a {
    public static final ProtoAdapter<GetLoyaltySummaryResponse> ADAPTER;
    public static final Parcelable.Creator<GetLoyaltySummaryResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "lifetimeLoyaltyAmount", tag = 1)
    private final String lifetime_loyalty_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Tooltip#ADAPTER", tag = 2)
    private final Tooltip tooltip;

    /* compiled from: GetLoyaltySummaryResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltySummaryResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltySummaryResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetLoyaltySummaryResponse> protoAdapter = new ProtoAdapter<GetLoyaltySummaryResponse>(c.LENGTH_DELIMITED, e0.b(GetLoyaltySummaryResponse.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.GetLoyaltySummaryResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.GetLoyaltySummaryResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetLoyaltySummaryResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                Tooltip tooltip = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetLoyaltySummaryResponse(str, tooltip, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        tooltip = Tooltip.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetLoyaltySummaryResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getLifetime_loyalty_amount(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getLifetime_loyalty_amount());
                }
                if (value.getTooltip() != null) {
                    Tooltip.ADAPTER.encodeWithTag(writer, 2, value.getTooltip());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetLoyaltySummaryResponse value) {
                m.h(value, "value");
                if (m.c(value.getLifetime_loyalty_amount(), "")) {
                    return 0;
                }
                return (value.getTooltip() != null ? Tooltip.ADAPTER.encodedSizeWithTag(2, value.getTooltip()) + value.unknownFields().Q() : 0) + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getLifetime_loyalty_amount());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetLoyaltySummaryResponse redact(GetLoyaltySummaryResponse value) {
                m.h(value, "value");
                Tooltip tooltip = value.getTooltip();
                return GetLoyaltySummaryResponse.copy$default(value, null, tooltip != null ? Tooltip.ADAPTER.redact(tooltip) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetLoyaltySummaryResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetLoyaltySummaryResponse(String str, Tooltip tooltip, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : tooltip, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetLoyaltySummaryResponse copy$default(GetLoyaltySummaryResponse getLoyaltySummaryResponse, String str, Tooltip tooltip, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getLoyaltySummaryResponse.lifetime_loyalty_amount;
        }
        if ((i2 & 2) != 0) {
            tooltip = getLoyaltySummaryResponse.tooltip;
        }
        if ((i2 & 4) != 0) {
            iVar = getLoyaltySummaryResponse.unknownFields();
        }
        return getLoyaltySummaryResponse.copy(str, tooltip, iVar);
    }

    public final GetLoyaltySummaryResponse copy(String lifetime_loyalty_amount, Tooltip tooltip, i unknownFields) {
        m.h(lifetime_loyalty_amount, "lifetime_loyalty_amount");
        m.h(unknownFields, "unknownFields");
        return new GetLoyaltySummaryResponse(lifetime_loyalty_amount, tooltip, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetLoyaltySummaryResponse) {
            GetLoyaltySummaryResponse getLoyaltySummaryResponse = (GetLoyaltySummaryResponse) obj;
            return m.c(unknownFields(), getLoyaltySummaryResponse.unknownFields()) && m.c(this.lifetime_loyalty_amount, getLoyaltySummaryResponse.lifetime_loyalty_amount) && m.c(this.tooltip, getLoyaltySummaryResponse.tooltip);
        }
        return false;
    }

    public final String getLifetime_loyalty_amount() {
        return this.lifetime_loyalty_amount;
    }

    public final Tooltip getTooltip() {
        return this.tooltip;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.lifetime_loyalty_amount.hashCode()) * 37;
            Tooltip tooltip = this.tooltip;
            int hashCode2 = hashCode + (tooltip != null ? tooltip.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m405newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("lifetime_loyalty_amount=" + b.c(this.lifetime_loyalty_amount));
        if (this.tooltip != null) {
            arrayList.add("tooltip=" + this.tooltip);
        }
        h0 = z.h0(arrayList, ", ", "GetLoyaltySummaryResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLoyaltySummaryResponse(String lifetime_loyalty_amount, Tooltip tooltip, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(lifetime_loyalty_amount, "lifetime_loyalty_amount");
        m.h(unknownFields, "unknownFields");
        this.lifetime_loyalty_amount = lifetime_loyalty_amount;
        this.tooltip = tooltip;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m405newBuilder() {
        throw new AssertionError();
    }
}