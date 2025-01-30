package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
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

/* compiled from: GetLoyaltyCardV2Request.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B1\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Request;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "card_name", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "card_location", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "features", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Request;", "Ljava/lang/String;", "getCard_name", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "getCard_location", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "getFeatures", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardLocation;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetLoyaltyCardV2Request extends a {
    public static final ProtoAdapter<GetLoyaltyCardV2Request> ADAPTER;
    public static final Parcelable.Creator<GetLoyaltyCardV2Request> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardLocation#ADAPTER", jsonName = "cardLocation", tag = 2)
    private final LoyaltyCardLocation card_location;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardName", tag = 1)
    private final String card_name;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardFeatures#ADAPTER", tag = 3)
    private final LoyaltyCardFeatures features;

    /* compiled from: GetLoyaltyCardV2Request.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Request$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Request;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetLoyaltyCardV2Request> protoAdapter = new ProtoAdapter<GetLoyaltyCardV2Request>(c.LENGTH_DELIMITED, e0.b(GetLoyaltyCardV2Request.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.GetLoyaltyCardV2Request") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.GetLoyaltyCardV2Request$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetLoyaltyCardV2Request decode(k reader) {
                m.h(reader, "reader");
                LoyaltyCardLocation loyaltyCardLocation = LoyaltyCardLocation.HOME_CAROUSEL;
                long d2 = reader.d();
                String str = "";
                LoyaltyCardFeatures loyaltyCardFeatures = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetLoyaltyCardV2Request(str, loyaltyCardLocation, loyaltyCardFeatures, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
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
            public void encode(l writer, GetLoyaltyCardV2Request value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getCard_name(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getCard_name());
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
            public int encodedSize(GetLoyaltyCardV2Request value) {
                m.h(value, "value");
                if (m.c(value.getCard_name(), "")) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, value.getCard_name());
                if (value.getCard_location() != LoyaltyCardLocation.HOME_CAROUSEL) {
                    r1 = (value.getFeatures() != null ? LoyaltyCardFeatures.ADAPTER.encodedSizeWithTag(3, value.getFeatures()) + value.unknownFields().Q() : 0) + LoyaltyCardLocation.ADAPTER.encodedSizeWithTag(2, value.getCard_location());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetLoyaltyCardV2Request redact(GetLoyaltyCardV2Request value) {
                m.h(value, "value");
                LoyaltyCardFeatures features = value.getFeatures();
                return GetLoyaltyCardV2Request.copy$default(value, null, null, features != null ? LoyaltyCardFeatures.ADAPTER.redact(features) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetLoyaltyCardV2Request() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ GetLoyaltyCardV2Request(String str, LoyaltyCardLocation loyaltyCardLocation, LoyaltyCardFeatures loyaltyCardFeatures, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? LoyaltyCardLocation.HOME_CAROUSEL : loyaltyCardLocation, (i2 & 4) != 0 ? null : loyaltyCardFeatures, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetLoyaltyCardV2Request copy$default(GetLoyaltyCardV2Request getLoyaltyCardV2Request, String str, LoyaltyCardLocation loyaltyCardLocation, LoyaltyCardFeatures loyaltyCardFeatures, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getLoyaltyCardV2Request.card_name;
        }
        if ((i2 & 2) != 0) {
            loyaltyCardLocation = getLoyaltyCardV2Request.card_location;
        }
        if ((i2 & 4) != 0) {
            loyaltyCardFeatures = getLoyaltyCardV2Request.features;
        }
        if ((i2 & 8) != 0) {
            iVar = getLoyaltyCardV2Request.unknownFields();
        }
        return getLoyaltyCardV2Request.copy(str, loyaltyCardLocation, loyaltyCardFeatures, iVar);
    }

    public final GetLoyaltyCardV2Request copy(String card_name, LoyaltyCardLocation card_location, LoyaltyCardFeatures loyaltyCardFeatures, i unknownFields) {
        m.h(card_name, "card_name");
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        return new GetLoyaltyCardV2Request(card_name, card_location, loyaltyCardFeatures, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetLoyaltyCardV2Request) {
            GetLoyaltyCardV2Request getLoyaltyCardV2Request = (GetLoyaltyCardV2Request) obj;
            return m.c(unknownFields(), getLoyaltyCardV2Request.unknownFields()) && m.c(this.card_name, getLoyaltyCardV2Request.card_name) && this.card_location == getLoyaltyCardV2Request.card_location && m.c(this.features, getLoyaltyCardV2Request.features);
        }
        return false;
    }

    public final LoyaltyCardLocation getCard_location() {
        return this.card_location;
    }

    public final String getCard_name() {
        return this.card_name;
    }

    public final LoyaltyCardFeatures getFeatures() {
        return this.features;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.card_name.hashCode()) * 37) + this.card_location.hashCode()) * 37;
            LoyaltyCardFeatures loyaltyCardFeatures = this.features;
            int hashCode2 = hashCode + (loyaltyCardFeatures != null ? loyaltyCardFeatures.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m402newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("card_name=" + b.c(this.card_name));
        arrayList.add("card_location=" + this.card_location);
        if (this.features != null) {
            arrayList.add("features=" + this.features);
        }
        h0 = z.h0(arrayList, ", ", "GetLoyaltyCardV2Request{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m402newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLoyaltyCardV2Request(String card_name, LoyaltyCardLocation card_location, LoyaltyCardFeatures loyaltyCardFeatures, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(card_name, "card_name");
        m.h(card_location, "card_location");
        m.h(unknownFields, "unknownFields");
        this.card_name = card_name;
        this.card_location = card_location;
        this.features = loyaltyCardFeatures;
    }
}