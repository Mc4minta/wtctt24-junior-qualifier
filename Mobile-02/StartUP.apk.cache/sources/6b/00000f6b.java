package com.coinbase.android.apiv3.generated.unauthed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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

/* compiled from: ListCampaignsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B-\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/ListCampaignsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "cumulative_reward_amount", "", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/Campaign;", "campaigns", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/ListCampaignsResponse;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getCumulative_reward_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/util/List;", "getCampaigns", "()Ljava/util/List;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListCampaignsResponse extends a {
    public static final ProtoAdapter<ListCampaignsResponse> ADAPTER;
    public static final Parcelable.Creator<ListCampaignsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.loyalty.Campaign#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<Campaign> campaigns;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "cumulativeRewardAmount", tag = 1)
    private final Amount cumulative_reward_amount;

    /* compiled from: ListCampaignsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/ListCampaignsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/ListCampaignsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListCampaignsResponse> protoAdapter = new ProtoAdapter<ListCampaignsResponse>(c.LENGTH_DELIMITED, e0.b(ListCampaignsResponse.class), "type.googleapis.com/coinbase.public_api.unauthed.loyalty.ListCampaignsResponse") { // from class: com.coinbase.android.apiv3.generated.unauthed.loyalty.ListCampaignsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListCampaignsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                Amount amount = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListCampaignsResponse(amount, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        arrayList.add(Campaign.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListCampaignsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCumulative_reward_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getCumulative_reward_amount());
                }
                Campaign.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getCampaigns());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListCampaignsResponse value) {
                m.h(value, "value");
                if (value.getCumulative_reward_amount() == null) {
                    return 0;
                }
                return value.unknownFields().Q() + Amount.ADAPTER.encodedSizeWithTag(1, value.getCumulative_reward_amount()) + Campaign.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getCampaigns());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListCampaignsResponse redact(ListCampaignsResponse value) {
                m.h(value, "value");
                Amount cumulative_reward_amount = value.getCumulative_reward_amount();
                return value.copy(cumulative_reward_amount != null ? Amount.ADAPTER.redact(cumulative_reward_amount) : null, b.a(value.getCampaigns(), Campaign.ADAPTER), i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ListCampaignsResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ ListCampaignsResponse(Amount amount, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListCampaignsResponse copy$default(ListCampaignsResponse listCampaignsResponse, Amount amount, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            amount = listCampaignsResponse.cumulative_reward_amount;
        }
        if ((i2 & 2) != 0) {
            list = listCampaignsResponse.campaigns;
        }
        if ((i2 & 4) != 0) {
            iVar = listCampaignsResponse.unknownFields();
        }
        return listCampaignsResponse.copy(amount, list, iVar);
    }

    public final ListCampaignsResponse copy(Amount amount, List<Campaign> campaigns, i unknownFields) {
        m.h(campaigns, "campaigns");
        m.h(unknownFields, "unknownFields");
        return new ListCampaignsResponse(amount, campaigns, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListCampaignsResponse) {
            ListCampaignsResponse listCampaignsResponse = (ListCampaignsResponse) obj;
            return m.c(unknownFields(), listCampaignsResponse.unknownFields()) && m.c(this.cumulative_reward_amount, listCampaignsResponse.cumulative_reward_amount) && m.c(this.campaigns, listCampaignsResponse.campaigns);
        }
        return false;
    }

    public final List<Campaign> getCampaigns() {
        return this.campaigns;
    }

    public final Amount getCumulative_reward_amount() {
        return this.cumulative_reward_amount;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.cumulative_reward_amount;
            int hashCode2 = ((hashCode + (amount != null ? amount.hashCode() : 0)) * 37) + this.campaigns.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m565newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.cumulative_reward_amount != null) {
            arrayList.add("cumulative_reward_amount=" + this.cumulative_reward_amount);
        }
        if (!this.campaigns.isEmpty()) {
            arrayList.add("campaigns=" + this.campaigns);
        }
        h0 = z.h0(arrayList, ", ", "ListCampaignsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m565newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListCampaignsResponse(Amount amount, List<Campaign> campaigns, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(campaigns, "campaigns");
        m.h(unknownFields, "unknownFields");
        this.cumulative_reward_amount = amount;
        this.campaigns = campaigns;
    }
}