package com.coinbase.android.apiv3.generated.authed.announcement_cards;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetBuyUpsellCardResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001d\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetBuyUpsellCardResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/UpsellCard;", "upsell_card", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/UpsellCard;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetBuyUpsellCardResponse;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/UpsellCard;", "getUpsell_card", "()Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/UpsellCard;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/UpsellCard;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetBuyUpsellCardResponse extends a {
    public static final ProtoAdapter<GetBuyUpsellCardResponse> ADAPTER;
    public static final Parcelable.Creator<GetBuyUpsellCardResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.announcement_cards.UpsellCard#ADAPTER", jsonName = "upsellCard", tag = 1)
    private final UpsellCard upsell_card;

    /* compiled from: GetBuyUpsellCardResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetBuyUpsellCardResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetBuyUpsellCardResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetBuyUpsellCardResponse> protoAdapter = new ProtoAdapter<GetBuyUpsellCardResponse>(c.LENGTH_DELIMITED, e0.b(GetBuyUpsellCardResponse.class), "type.googleapis.com/coinbase.public_api.authed.announcement_cards.GetBuyUpsellCardResponse") { // from class: com.coinbase.android.apiv3.generated.authed.announcement_cards.GetBuyUpsellCardResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetBuyUpsellCardResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                UpsellCard upsellCard = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetBuyUpsellCardResponse(upsellCard, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        upsellCard = UpsellCard.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetBuyUpsellCardResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getUpsell_card() != null) {
                    UpsellCard.ADAPTER.encodeWithTag(writer, 1, value.getUpsell_card());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetBuyUpsellCardResponse value) {
                m.h(value, "value");
                if (value.getUpsell_card() == null) {
                    return 0;
                }
                return value.unknownFields().Q() + UpsellCard.ADAPTER.encodedSizeWithTag(1, value.getUpsell_card());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetBuyUpsellCardResponse redact(GetBuyUpsellCardResponse value) {
                m.h(value, "value");
                UpsellCard upsell_card = value.getUpsell_card();
                return value.copy(upsell_card != null ? UpsellCard.ADAPTER.redact(upsell_card) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetBuyUpsellCardResponse() {
        this(null, null, 3, null);
    }

    public /* synthetic */ GetBuyUpsellCardResponse(UpsellCard upsellCard, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : upsellCard, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetBuyUpsellCardResponse copy$default(GetBuyUpsellCardResponse getBuyUpsellCardResponse, UpsellCard upsellCard, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            upsellCard = getBuyUpsellCardResponse.upsell_card;
        }
        if ((i2 & 2) != 0) {
            iVar = getBuyUpsellCardResponse.unknownFields();
        }
        return getBuyUpsellCardResponse.copy(upsellCard, iVar);
    }

    public final GetBuyUpsellCardResponse copy(UpsellCard upsellCard, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new GetBuyUpsellCardResponse(upsellCard, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetBuyUpsellCardResponse) {
            GetBuyUpsellCardResponse getBuyUpsellCardResponse = (GetBuyUpsellCardResponse) obj;
            return m.c(unknownFields(), getBuyUpsellCardResponse.unknownFields()) && m.c(this.upsell_card, getBuyUpsellCardResponse.upsell_card);
        }
        return false;
    }

    public final UpsellCard getUpsell_card() {
        return this.upsell_card;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            UpsellCard upsellCard = this.upsell_card;
            int hashCode2 = hashCode + (upsellCard != null ? upsellCard.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m285newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.upsell_card != null) {
            arrayList.add("upsell_card=" + this.upsell_card);
        }
        h0 = z.h0(arrayList, ", ", "GetBuyUpsellCardResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBuyUpsellCardResponse(UpsellCard upsellCard, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.upsell_card = upsellCard;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m285newBuilder() {
        throw new AssertionError();
    }
}