package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.resources.paymentmethods.models.Limits;
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

/* compiled from: GetLoyaltyCardV2Response.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B'\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Response;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;", Limits.TYPE_CARD, "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "card_location", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Response;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;", "getCard", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "getCard_location", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetLoyaltyCardV2Response extends a {
    public static final ProtoAdapter<GetLoyaltyCardV2Response> ADAPTER;
    public static final Parcelable.Creator<GetLoyaltyCardV2Response> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCard#ADAPTER", tag = 1)
    private final LoyaltyCard card;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardLocation#ADAPTER", jsonName = "cardLocation", tag = 2)
    private final LoyaltyCardLocation card_location;

    /* compiled from: GetLoyaltyCardV2Response.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Response$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Response;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetLoyaltyCardV2Response> protoAdapter = new ProtoAdapter<GetLoyaltyCardV2Response>(c.LENGTH_DELIMITED, e0.b(GetLoyaltyCardV2Response.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.GetLoyaltyCardV2Response") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.GetLoyaltyCardV2Response$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetLoyaltyCardV2Response decode(k reader) {
                m.h(reader, "reader");
                LoyaltyCardLocation loyaltyCardLocation = LoyaltyCardLocation.HOME_CAROUSEL;
                long d2 = reader.d();
                LoyaltyCard loyaltyCard = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetLoyaltyCardV2Response(loyaltyCard, loyaltyCardLocation, reader.e(d2));
                    }
                    if (g2 == 1) {
                        loyaltyCard = LoyaltyCard.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        try {
                            loyaltyCardLocation = LoyaltyCardLocation.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetLoyaltyCardV2Response value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCard() != null) {
                    LoyaltyCard.ADAPTER.encodeWithTag(writer, 1, value.getCard());
                }
                if (value.getCard_location() != LoyaltyCardLocation.HOME_CAROUSEL) {
                    LoyaltyCardLocation.ADAPTER.encodeWithTag(writer, 2, value.getCard_location());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetLoyaltyCardV2Response value) {
                m.h(value, "value");
                if (value.getCard() == null) {
                    return 0;
                }
                return (value.getCard_location() != LoyaltyCardLocation.HOME_CAROUSEL ? LoyaltyCardLocation.ADAPTER.encodedSizeWithTag(2, value.getCard_location()) + value.unknownFields().Q() : 0) + LoyaltyCard.ADAPTER.encodedSizeWithTag(1, value.getCard());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetLoyaltyCardV2Response redact(GetLoyaltyCardV2Response value) {
                m.h(value, "value");
                LoyaltyCard card = value.getCard();
                return GetLoyaltyCardV2Response.copy$default(value, card != null ? LoyaltyCard.ADAPTER.redact(card) : null, null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetLoyaltyCardV2Response() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetLoyaltyCardV2Response(LoyaltyCard loyaltyCard, LoyaltyCardLocation loyaltyCardLocation, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : loyaltyCard, (i2 & 2) != 0 ? LoyaltyCardLocation.HOME_CAROUSEL : loyaltyCardLocation, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetLoyaltyCardV2Response copy$default(GetLoyaltyCardV2Response getLoyaltyCardV2Response, LoyaltyCard loyaltyCard, LoyaltyCardLocation loyaltyCardLocation, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loyaltyCard = getLoyaltyCardV2Response.card;
        }
        if ((i2 & 2) != 0) {
            loyaltyCardLocation = getLoyaltyCardV2Response.card_location;
        }
        if ((i2 & 4) != 0) {
            iVar = getLoyaltyCardV2Response.unknownFields();
        }
        return getLoyaltyCardV2Response.copy(loyaltyCard, loyaltyCardLocation, iVar);
    }

    public final GetLoyaltyCardV2Response copy(LoyaltyCard loyaltyCard, LoyaltyCardLocation card_location, i unknownFields) {
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        return new GetLoyaltyCardV2Response(loyaltyCard, card_location, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetLoyaltyCardV2Response) {
            GetLoyaltyCardV2Response getLoyaltyCardV2Response = (GetLoyaltyCardV2Response) obj;
            return m.c(unknownFields(), getLoyaltyCardV2Response.unknownFields()) && m.c(this.card, getLoyaltyCardV2Response.card) && this.card_location == getLoyaltyCardV2Response.card_location;
        }
        return false;
    }

    public final LoyaltyCard getCard() {
        return this.card;
    }

    public final LoyaltyCardLocation getCard_location() {
        return this.card_location;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            LoyaltyCard loyaltyCard = this.card;
            int hashCode2 = ((hashCode + (loyaltyCard != null ? loyaltyCard.hashCode() : 0)) * 37) + this.card_location.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m403newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.card != null) {
            arrayList.add("card=" + this.card);
        }
        arrayList.add("card_location=" + this.card_location);
        h0 = z.h0(arrayList, ", ", "GetLoyaltyCardV2Response{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m403newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLoyaltyCardV2Response(LoyaltyCard loyaltyCard, LoyaltyCardLocation card_location, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        this.card = loyaltyCard;
        this.card_location = card_location;
    }
}