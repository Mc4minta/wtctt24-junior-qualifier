package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PageOptions;
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

/* compiled from: ListLoyaltyCardsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B3\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "page_options", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "card_location", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "features", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "getCard_location", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "getFeatures", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "getPage_options", "()Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListLoyaltyCardsRequest extends a {
    public static final ProtoAdapter<ListLoyaltyCardsRequest> ADAPTER;
    public static final Parcelable.Creator<ListLoyaltyCardsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardLocation#ADAPTER", jsonName = "cardLocation", tag = 2)
    private final LoyaltyCardLocation card_location;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardFeatures#ADAPTER", tag = 3)
    private final LoyaltyCardFeatures features;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageOptions#ADAPTER", jsonName = "pageOptions", tag = 1)
    private final PageOptions page_options;

    /* compiled from: ListLoyaltyCardsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListLoyaltyCardsRequest> protoAdapter = new ProtoAdapter<ListLoyaltyCardsRequest>(c.LENGTH_DELIMITED, e0.b(ListLoyaltyCardsRequest.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.ListLoyaltyCardsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.ListLoyaltyCardsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListLoyaltyCardsRequest decode(k reader) {
                m.h(reader, "reader");
                LoyaltyCardLocation loyaltyCardLocation = LoyaltyCardLocation.HOME_CAROUSEL;
                long d2 = reader.d();
                PageOptions pageOptions = null;
                LoyaltyCardFeatures loyaltyCardFeatures = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListLoyaltyCardsRequest(pageOptions, loyaltyCardLocation, loyaltyCardFeatures, reader.e(d2));
                    }
                    if (g2 == 1) {
                        pageOptions = PageOptions.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        try {
                            loyaltyCardLocation = LoyaltyCardLocation.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        loyaltyCardFeatures = LoyaltyCardFeatures.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListLoyaltyCardsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getPage_options() != null) {
                    PageOptions.ADAPTER.encodeWithTag(writer, 1, value.getPage_options());
                }
                if (value.getCard_location() != LoyaltyCardLocation.HOME_CAROUSEL) {
                    LoyaltyCardLocation.ADAPTER.encodeWithTag(writer, 2, value.getCard_location());
                }
                if (value.getFeatures() != null) {
                    LoyaltyCardFeatures.ADAPTER.encodeWithTag(writer, 3, value.getFeatures());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListLoyaltyCardsRequest value) {
                m.h(value, "value");
                if (value.getPage_options() == null) {
                    return 0;
                }
                int encodedSizeWithTag = PageOptions.ADAPTER.encodedSizeWithTag(1, value.getPage_options());
                if (value.getCard_location() != LoyaltyCardLocation.HOME_CAROUSEL) {
                    r1 = (value.getFeatures() != null ? LoyaltyCardFeatures.ADAPTER.encodedSizeWithTag(3, value.getFeatures()) + value.unknownFields().Q() : 0) + LoyaltyCardLocation.ADAPTER.encodedSizeWithTag(2, value.getCard_location());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListLoyaltyCardsRequest redact(ListLoyaltyCardsRequest value) {
                m.h(value, "value");
                PageOptions page_options = value.getPage_options();
                PageOptions redact = page_options != null ? PageOptions.ADAPTER.redact(page_options) : null;
                LoyaltyCardFeatures features = value.getFeatures();
                return ListLoyaltyCardsRequest.copy$default(value, redact, null, features != null ? LoyaltyCardFeatures.ADAPTER.redact(features) : null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ListLoyaltyCardsRequest() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ ListLoyaltyCardsRequest(PageOptions pageOptions, LoyaltyCardLocation loyaltyCardLocation, LoyaltyCardFeatures loyaltyCardFeatures, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : pageOptions, (i2 & 2) != 0 ? LoyaltyCardLocation.HOME_CAROUSEL : loyaltyCardLocation, (i2 & 4) != 0 ? null : loyaltyCardFeatures, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ListLoyaltyCardsRequest copy$default(ListLoyaltyCardsRequest listLoyaltyCardsRequest, PageOptions pageOptions, LoyaltyCardLocation loyaltyCardLocation, LoyaltyCardFeatures loyaltyCardFeatures, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pageOptions = listLoyaltyCardsRequest.page_options;
        }
        if ((i2 & 2) != 0) {
            loyaltyCardLocation = listLoyaltyCardsRequest.card_location;
        }
        if ((i2 & 4) != 0) {
            loyaltyCardFeatures = listLoyaltyCardsRequest.features;
        }
        if ((i2 & 8) != 0) {
            iVar = listLoyaltyCardsRequest.unknownFields();
        }
        return listLoyaltyCardsRequest.copy(pageOptions, loyaltyCardLocation, loyaltyCardFeatures, iVar);
    }

    public final ListLoyaltyCardsRequest copy(PageOptions pageOptions, LoyaltyCardLocation card_location, LoyaltyCardFeatures loyaltyCardFeatures, i unknownFields) {
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        return new ListLoyaltyCardsRequest(pageOptions, card_location, loyaltyCardFeatures, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListLoyaltyCardsRequest) {
            ListLoyaltyCardsRequest listLoyaltyCardsRequest = (ListLoyaltyCardsRequest) obj;
            return m.c(unknownFields(), listLoyaltyCardsRequest.unknownFields()) && m.c(this.page_options, listLoyaltyCardsRequest.page_options) && this.card_location == listLoyaltyCardsRequest.card_location && m.c(this.features, listLoyaltyCardsRequest.features);
        }
        return false;
    }

    public final LoyaltyCardLocation getCard_location() {
        return this.card_location;
    }

    public final LoyaltyCardFeatures getFeatures() {
        return this.features;
    }

    public final PageOptions getPage_options() {
        return this.page_options;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            PageOptions pageOptions = this.page_options;
            int hashCode2 = (((hashCode + (pageOptions != null ? pageOptions.hashCode() : 0)) * 37) + this.card_location.hashCode()) * 37;
            LoyaltyCardFeatures loyaltyCardFeatures = this.features;
            int hashCode3 = hashCode2 + (loyaltyCardFeatures != null ? loyaltyCardFeatures.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m406newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.page_options != null) {
            arrayList.add("page_options=" + this.page_options);
        }
        arrayList.add("card_location=" + this.card_location);
        if (this.features != null) {
            arrayList.add("features=" + this.features);
        }
        h0 = z.h0(arrayList, ", ", "ListLoyaltyCardsRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m406newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListLoyaltyCardsRequest(PageOptions pageOptions, LoyaltyCardLocation card_location, LoyaltyCardFeatures loyaltyCardFeatures, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        this.page_options = pageOptions;
        this.card_location = card_location;
        this.features = loyaltyCardFeatures;
    }
}