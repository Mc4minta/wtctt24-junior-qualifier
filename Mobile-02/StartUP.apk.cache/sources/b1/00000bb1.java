package com.coinbase.android.apiv3.generated.authed.asset_page_promotions;

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

/* compiled from: GetAssetPagePromotionResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001d\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/GetAssetPagePromotionResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;", "promotion", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/GetAssetPagePromotionResponse;", "Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;", "getPromotion", "()Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetAssetPagePromotionResponse extends a {
    public static final ProtoAdapter<GetAssetPagePromotionResponse> ADAPTER;
    public static final Parcelable.Creator<GetAssetPagePromotionResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.asset_page_promotions.AssetPagePromotion#ADAPTER", tag = 1)
    private final AssetPagePromotion promotion;

    /* compiled from: GetAssetPagePromotionResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/GetAssetPagePromotionResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/GetAssetPagePromotionResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetAssetPagePromotionResponse> protoAdapter = new ProtoAdapter<GetAssetPagePromotionResponse>(c.LENGTH_DELIMITED, e0.b(GetAssetPagePromotionResponse.class), "type.googleapis.com/coinbase.public_api.authed.asset_page_promotions.GetAssetPagePromotionResponse") { // from class: com.coinbase.android.apiv3.generated.authed.asset_page_promotions.GetAssetPagePromotionResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetAssetPagePromotionResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                AssetPagePromotion assetPagePromotion = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetAssetPagePromotionResponse(assetPagePromotion, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        assetPagePromotion = AssetPagePromotion.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetAssetPagePromotionResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getPromotion() != null) {
                    AssetPagePromotion.ADAPTER.encodeWithTag(writer, 1, value.getPromotion());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetAssetPagePromotionResponse value) {
                m.h(value, "value");
                if (value.getPromotion() == null) {
                    return 0;
                }
                return value.unknownFields().Q() + AssetPagePromotion.ADAPTER.encodedSizeWithTag(1, value.getPromotion());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetAssetPagePromotionResponse redact(GetAssetPagePromotionResponse value) {
                m.h(value, "value");
                AssetPagePromotion promotion = value.getPromotion();
                return value.copy(promotion != null ? AssetPagePromotion.ADAPTER.redact(promotion) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetAssetPagePromotionResponse() {
        this(null, null, 3, null);
    }

    public /* synthetic */ GetAssetPagePromotionResponse(AssetPagePromotion assetPagePromotion, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : assetPagePromotion, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetAssetPagePromotionResponse copy$default(GetAssetPagePromotionResponse getAssetPagePromotionResponse, AssetPagePromotion assetPagePromotion, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            assetPagePromotion = getAssetPagePromotionResponse.promotion;
        }
        if ((i2 & 2) != 0) {
            iVar = getAssetPagePromotionResponse.unknownFields();
        }
        return getAssetPagePromotionResponse.copy(assetPagePromotion, iVar);
    }

    public final GetAssetPagePromotionResponse copy(AssetPagePromotion assetPagePromotion, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new GetAssetPagePromotionResponse(assetPagePromotion, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetAssetPagePromotionResponse) {
            GetAssetPagePromotionResponse getAssetPagePromotionResponse = (GetAssetPagePromotionResponse) obj;
            return m.c(unknownFields(), getAssetPagePromotionResponse.unknownFields()) && m.c(this.promotion, getAssetPagePromotionResponse.promotion);
        }
        return false;
    }

    public final AssetPagePromotion getPromotion() {
        return this.promotion;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AssetPagePromotion assetPagePromotion = this.promotion;
            int hashCode2 = hashCode + (assetPagePromotion != null ? assetPagePromotion.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m292newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.promotion != null) {
            arrayList.add("promotion=" + this.promotion);
        }
        h0 = z.h0(arrayList, ", ", "GetAssetPagePromotionResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAssetPagePromotionResponse(AssetPagePromotion assetPagePromotion, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.promotion = assetPagePromotion;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m292newBuilder() {
        throw new AssertionError();
    }
}