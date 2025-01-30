package com.coinbase.android.apiv3.generated.authed.asset_page_promotions;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
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
import org.spongycastle.i18n.MessageBundle;

/* compiled from: AssetPagePromotion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B;\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001f\u0010\u000f¨\u0006#"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "image_url", "Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotionCTA;", "cta", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotionCTA;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;", "Ljava/lang/String;", "getImage_url", "Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotionCTA;", "getCta", "()Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotionCTA;", "getDescription", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotionCTA;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AssetPagePromotion extends a {
    public static final ProtoAdapter<AssetPagePromotion> ADAPTER;
    public static final Parcelable.Creator<AssetPagePromotion> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.asset_page_promotions.AssetPagePromotionCTA#ADAPTER", tag = 4)
    private final AssetPagePromotionCTA cta;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 3)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;

    /* compiled from: AssetPagePromotion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/asset_page_promotions/AssetPagePromotion;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AssetPagePromotion> protoAdapter = new ProtoAdapter<AssetPagePromotion>(c.LENGTH_DELIMITED, e0.b(AssetPagePromotion.class), "type.googleapis.com/coinbase.public_api.authed.asset_page_promotions.AssetPagePromotion") { // from class: com.coinbase.android.apiv3.generated.authed.asset_page_promotions.AssetPagePromotion$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AssetPagePromotion decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                AssetPagePromotionCTA assetPagePromotionCTA = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AssetPagePromotion(str, str2, str3, assetPagePromotionCTA, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        assetPagePromotionCTA = AssetPagePromotionCTA.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AssetPagePromotion value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDescription());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getImage_url());
                }
                if (value.getCta() != null) {
                    AssetPagePromotionCTA.ADAPTER.encodeWithTag(writer, 4, value.getCta());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AssetPagePromotion value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getDescription(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getDescription());
                    if (!m.c(value.getImage_url(), "")) {
                        r2 = (value.getCta() != null ? AssetPagePromotionCTA.ADAPTER.encodedSizeWithTag(4, value.getCta()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, value.getImage_url());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AssetPagePromotion redact(AssetPagePromotion value) {
                m.h(value, "value");
                AssetPagePromotionCTA cta = value.getCta();
                return AssetPagePromotion.copy$default(value, null, null, null, cta != null ? AssetPagePromotionCTA.ADAPTER.redact(cta) : null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AssetPagePromotion() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ AssetPagePromotion(String str, String str2, String str3, AssetPagePromotionCTA assetPagePromotionCTA, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? null : assetPagePromotionCTA, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AssetPagePromotion copy$default(AssetPagePromotion assetPagePromotion, String str, String str2, String str3, AssetPagePromotionCTA assetPagePromotionCTA, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = assetPagePromotion.title;
        }
        if ((i2 & 2) != 0) {
            str2 = assetPagePromotion.description;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = assetPagePromotion.image_url;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            assetPagePromotionCTA = assetPagePromotion.cta;
        }
        AssetPagePromotionCTA assetPagePromotionCTA2 = assetPagePromotionCTA;
        if ((i2 & 16) != 0) {
            iVar = assetPagePromotion.unknownFields();
        }
        return assetPagePromotion.copy(str, str4, str5, assetPagePromotionCTA2, iVar);
    }

    public final AssetPagePromotion copy(String title, String description, String image_url, AssetPagePromotionCTA assetPagePromotionCTA, i unknownFields) {
        m.h(title, "title");
        m.h(description, "description");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        return new AssetPagePromotion(title, description, image_url, assetPagePromotionCTA, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPagePromotion) {
            AssetPagePromotion assetPagePromotion = (AssetPagePromotion) obj;
            return m.c(unknownFields(), assetPagePromotion.unknownFields()) && m.c(this.title, assetPagePromotion.title) && m.c(this.description, assetPagePromotion.description) && m.c(this.image_url, assetPagePromotion.image_url) && m.c(this.cta, assetPagePromotion.cta);
        }
        return false;
    }

    public final AssetPagePromotionCTA getCta() {
        return this.cta;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.description.hashCode()) * 37) + this.image_url.hashCode()) * 37;
            AssetPagePromotionCTA assetPagePromotionCTA = this.cta;
            int hashCode2 = hashCode + (assetPagePromotionCTA != null ? assetPagePromotionCTA.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m289newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("image_url=" + b.c(this.image_url));
        if (this.cta != null) {
            arrayList.add("cta=" + this.cta);
        }
        h0 = z.h0(arrayList, ", ", "AssetPagePromotion{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetPagePromotion(String title, String description, String image_url, AssetPagePromotionCTA assetPagePromotionCTA, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(description, "description");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.description = description;
        this.image_url = image_url;
        this.cta = assetPagePromotionCTA;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m289newBuilder() {
        throw new AssertionError();
    }
}