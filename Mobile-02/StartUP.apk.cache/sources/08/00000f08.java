package com.coinbase.android.apiv3.generated.unauthed;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.resources.Asset;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: AssetSummary.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*BE\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJK\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/AssetSummary;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "asset", "Lcom/coinbase/android/apiv3/generated/unauthed/Stats;", "stats", "Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;", "price_info", "", "related_assets", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/resources/Asset;Lcom/coinbase/android/apiv3/generated/unauthed/Stats;Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/AssetSummary;", "Ljava/util/List;", "getRelated_assets", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/unauthed/Stats;", "getStats", "()Lcom/coinbase/android/apiv3/generated/unauthed/Stats;", "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "getAsset", "()Lcom/coinbase/android/apiv3/generated/resources/Asset;", "Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;", "getPrice_info", "()Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;", "<init>", "(Lcom/coinbase/android/apiv3/generated/resources/Asset;Lcom/coinbase/android/apiv3/generated/unauthed/Stats;Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AssetSummary extends a {
    public static final ProtoAdapter<AssetSummary> ADAPTER;
    public static final Parcelable.Creator<AssetSummary> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Asset#ADAPTER", tag = 1)
    private final Asset asset;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.PriceInfo#ADAPTER", jsonName = "priceInfo", tag = 3)
    private final PriceInfo price_info;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Asset#ADAPTER", jsonName = "relatedAssets", label = p.a.REPEATED, tag = 4)
    private final List<Asset> related_assets;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.Stats#ADAPTER", tag = 2)
    private final Stats stats;

    /* compiled from: AssetSummary.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/AssetSummary$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/AssetSummary;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final c cVar = c.LENGTH_DELIMITED;
        final d b2 = e0.b(AssetSummary.class);
        ProtoAdapter<AssetSummary> protoAdapter = new ProtoAdapter<AssetSummary>(cVar, b2, "type.googleapis.com/coinbase.public_api.unauthed.AssetSummary") { // from class: com.coinbase.android.apiv3.generated.unauthed.AssetSummary$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AssetSummary decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                Asset asset = null;
                Stats stats = null;
                PriceInfo priceInfo = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AssetSummary(asset, stats, priceInfo, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        asset = Asset.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        stats = Stats.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        priceInfo = PriceInfo.ADAPTER.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        arrayList.add(Asset.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AssetSummary value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAsset() != null) {
                    Asset.ADAPTER.encodeWithTag(writer, 1, value.getAsset());
                }
                if (value.getStats() != null) {
                    Stats.ADAPTER.encodeWithTag(writer, 2, value.getStats());
                }
                if (value.getPrice_info() != null) {
                    PriceInfo.ADAPTER.encodeWithTag(writer, 3, value.getPrice_info());
                }
                Asset.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.getRelated_assets());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AssetSummary value) {
                m.h(value, "value");
                if (value.getAsset() == null) {
                    return 0;
                }
                ProtoAdapter<Asset> protoAdapter2 = Asset.ADAPTER;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getAsset());
                if (value.getStats() != null) {
                    r1 = (value.getPrice_info() != null ? PriceInfo.ADAPTER.encodedSizeWithTag(3, value.getPrice_info()) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.getRelated_assets()) + value.unknownFields().Q() : 0) + Stats.ADAPTER.encodedSizeWithTag(2, value.getStats());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AssetSummary redact(AssetSummary value) {
                m.h(value, "value");
                Asset asset = value.getAsset();
                Asset redact = asset != null ? Asset.ADAPTER.redact(asset) : null;
                Stats stats = value.getStats();
                Stats redact2 = stats != null ? Stats.ADAPTER.redact(stats) : null;
                PriceInfo price_info = value.getPrice_info();
                return value.copy(redact, redact2, price_info != null ? PriceInfo.ADAPTER.redact(price_info) : null, b.a(value.getRelated_assets(), Asset.ADAPTER), i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AssetSummary() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ AssetSummary(Asset asset, Stats stats, PriceInfo priceInfo, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : asset, (i2 & 2) != 0 ? null : stats, (i2 & 4) == 0 ? priceInfo : null, (i2 & 8) != 0 ? r.g() : list, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AssetSummary copy$default(AssetSummary assetSummary, Asset asset, Stats stats, PriceInfo priceInfo, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            asset = assetSummary.asset;
        }
        if ((i2 & 2) != 0) {
            stats = assetSummary.stats;
        }
        Stats stats2 = stats;
        if ((i2 & 4) != 0) {
            priceInfo = assetSummary.price_info;
        }
        PriceInfo priceInfo2 = priceInfo;
        List<Asset> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = assetSummary.related_assets;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            iVar = assetSummary.unknownFields();
        }
        return assetSummary.copy(asset, stats2, priceInfo2, list3, iVar);
    }

    public final AssetSummary copy(Asset asset, Stats stats, PriceInfo priceInfo, List<Asset> related_assets, i unknownFields) {
        m.h(related_assets, "related_assets");
        m.h(unknownFields, "unknownFields");
        return new AssetSummary(asset, stats, priceInfo, related_assets, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetSummary) {
            AssetSummary assetSummary = (AssetSummary) obj;
            return m.c(unknownFields(), assetSummary.unknownFields()) && m.c(this.asset, assetSummary.asset) && m.c(this.stats, assetSummary.stats) && m.c(this.price_info, assetSummary.price_info) && m.c(this.related_assets, assetSummary.related_assets);
        }
        return false;
    }

    public final Asset getAsset() {
        return this.asset;
    }

    public final PriceInfo getPrice_info() {
        return this.price_info;
    }

    public final List<Asset> getRelated_assets() {
        return this.related_assets;
    }

    public final Stats getStats() {
        return this.stats;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Asset asset = this.asset;
            int hashCode2 = (hashCode + (asset != null ? asset.hashCode() : 0)) * 37;
            Stats stats = this.stats;
            int hashCode3 = (hashCode2 + (stats != null ? stats.hashCode() : 0)) * 37;
            PriceInfo priceInfo = this.price_info;
            int hashCode4 = ((hashCode3 + (priceInfo != null ? priceInfo.hashCode() : 0)) * 37) + this.related_assets.hashCode();
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m535newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.asset != null) {
            arrayList.add("asset=" + this.asset);
        }
        if (this.stats != null) {
            arrayList.add("stats=" + this.stats);
        }
        if (this.price_info != null) {
            arrayList.add("price_info=" + this.price_info);
        }
        if (!this.related_assets.isEmpty()) {
            arrayList.add("related_assets=" + this.related_assets);
        }
        h0 = z.h0(arrayList, ", ", "AssetSummary{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m535newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetSummary(Asset asset, Stats stats, PriceInfo priceInfo, List<Asset> related_assets, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(related_assets, "related_assets");
        m.h(unknownFields, "unknownFields");
        this.asset = asset;
        this.stats = stats;
        this.price_info = priceInfo;
        this.related_assets = related_assets;
    }
}