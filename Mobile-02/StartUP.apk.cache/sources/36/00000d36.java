package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PageDescription;
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
import kotlin.x;

/* compiled from: ListLoyaltyCardsV2Response.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B7\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsV2Response;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;", "cards", "Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "page_description", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "card_location", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/PageDescription;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsV2Response;", "Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "getPage_description", "()Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "getCard_location", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "Ljava/util/List;", "getCards", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/PageDescription;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListLoyaltyCardsV2Response extends a {
    public static final ProtoAdapter<ListLoyaltyCardsV2Response> ADAPTER;
    public static final Parcelable.Creator<ListLoyaltyCardsV2Response> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardLocation#ADAPTER", jsonName = "cardLocation", tag = 3)
    private final LoyaltyCardLocation card_location;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCard#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<LoyaltyCard> cards;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageDescription#ADAPTER", jsonName = "pageDescription", tag = 2)
    private final PageDescription page_description;

    /* compiled from: ListLoyaltyCardsV2Response.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsV2Response$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsV2Response;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListLoyaltyCardsV2Response> protoAdapter = new ProtoAdapter<ListLoyaltyCardsV2Response>(c.LENGTH_DELIMITED, e0.b(ListLoyaltyCardsV2Response.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.ListLoyaltyCardsV2Response") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.ListLoyaltyCardsV2Response$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListLoyaltyCardsV2Response decode(k reader) {
                LoyaltyCardLocation loyaltyCardLocation;
                ProtoAdapter.EnumConstantNotFoundException e2;
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                LoyaltyCardLocation loyaltyCardLocation2 = LoyaltyCardLocation.HOME_CAROUSEL;
                long d2 = reader.d();
                PageDescription pageDescription = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListLoyaltyCardsV2Response(arrayList, pageDescription, loyaltyCardLocation2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(LoyaltyCard.ADAPTER.decode(reader));
                    } else if (g2 == 2) {
                        pageDescription = PageDescription.ADAPTER.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        try {
                            loyaltyCardLocation = LoyaltyCardLocation.ADAPTER.decode(reader);
                            try {
                                x xVar = x.a;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                e2 = e3;
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                x xVar2 = x.a;
                                loyaltyCardLocation2 = loyaltyCardLocation;
                            }
                        } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                            loyaltyCardLocation = loyaltyCardLocation2;
                            e2 = e4;
                        }
                        loyaltyCardLocation2 = loyaltyCardLocation;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListLoyaltyCardsV2Response value) {
                m.h(writer, "writer");
                m.h(value, "value");
                LoyaltyCard.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getCards());
                if (value.getPage_description() != null) {
                    PageDescription.ADAPTER.encodeWithTag(writer, 2, value.getPage_description());
                }
                if (value.getCard_location() != LoyaltyCardLocation.HOME_CAROUSEL) {
                    LoyaltyCardLocation.ADAPTER.encodeWithTag(writer, 3, value.getCard_location());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListLoyaltyCardsV2Response value) {
                m.h(value, "value");
                int encodedSizeWithTag = LoyaltyCard.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getCards());
                if (value.getPage_description() != null) {
                    r2 = (value.getCard_location() != LoyaltyCardLocation.HOME_CAROUSEL ? LoyaltyCardLocation.ADAPTER.encodedSizeWithTag(3, value.getCard_location()) + value.unknownFields().Q() : 0) + PageDescription.ADAPTER.encodedSizeWithTag(2, value.getPage_description());
                }
                return encodedSizeWithTag + r2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListLoyaltyCardsV2Response redact(ListLoyaltyCardsV2Response value) {
                m.h(value, "value");
                List a = b.a(value.getCards(), LoyaltyCard.ADAPTER);
                PageDescription page_description = value.getPage_description();
                return ListLoyaltyCardsV2Response.copy$default(value, a, page_description != null ? PageDescription.ADAPTER.redact(page_description) : null, null, i.a, 4, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ListLoyaltyCardsV2Response() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ ListLoyaltyCardsV2Response(List list, PageDescription pageDescription, LoyaltyCardLocation loyaltyCardLocation, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? null : pageDescription, (i2 & 4) != 0 ? LoyaltyCardLocation.HOME_CAROUSEL : loyaltyCardLocation, (i2 & 8) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListLoyaltyCardsV2Response copy$default(ListLoyaltyCardsV2Response listLoyaltyCardsV2Response, List list, PageDescription pageDescription, LoyaltyCardLocation loyaltyCardLocation, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = listLoyaltyCardsV2Response.cards;
        }
        if ((i2 & 2) != 0) {
            pageDescription = listLoyaltyCardsV2Response.page_description;
        }
        if ((i2 & 4) != 0) {
            loyaltyCardLocation = listLoyaltyCardsV2Response.card_location;
        }
        if ((i2 & 8) != 0) {
            iVar = listLoyaltyCardsV2Response.unknownFields();
        }
        return listLoyaltyCardsV2Response.copy(list, pageDescription, loyaltyCardLocation, iVar);
    }

    public final ListLoyaltyCardsV2Response copy(List<LoyaltyCard> cards, PageDescription pageDescription, LoyaltyCardLocation card_location, i unknownFields) {
        m.h(cards, "cards");
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        return new ListLoyaltyCardsV2Response(cards, pageDescription, card_location, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListLoyaltyCardsV2Response) {
            ListLoyaltyCardsV2Response listLoyaltyCardsV2Response = (ListLoyaltyCardsV2Response) obj;
            return m.c(unknownFields(), listLoyaltyCardsV2Response.unknownFields()) && m.c(this.cards, listLoyaltyCardsV2Response.cards) && m.c(this.page_description, listLoyaltyCardsV2Response.page_description) && this.card_location == listLoyaltyCardsV2Response.card_location;
        }
        return false;
    }

    public final LoyaltyCardLocation getCard_location() {
        return this.card_location;
    }

    public final List<LoyaltyCard> getCards() {
        return this.cards;
    }

    public final PageDescription getPage_description() {
        return this.page_description;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.cards.hashCode()) * 37;
            PageDescription pageDescription = this.page_description;
            int hashCode2 = ((hashCode + (pageDescription != null ? pageDescription.hashCode() : 0)) * 37) + this.card_location.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m409newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.cards.isEmpty()) {
            arrayList.add("cards=" + this.cards);
        }
        if (this.page_description != null) {
            arrayList.add("page_description=" + this.page_description);
        }
        arrayList.add("card_location=" + this.card_location);
        h0 = z.h0(arrayList, ", ", "ListLoyaltyCardsV2Response{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m409newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListLoyaltyCardsV2Response(List<LoyaltyCard> cards, PageDescription pageDescription, LoyaltyCardLocation card_location, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(cards, "cards");
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        this.cards = cards;
        this.page_description = pageDescription;
        this.card_location = card_location;
    }
}