package com.coinbase.android.apiv3.generated.authed.hydrated_view_service_authed;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.LatestPrice;
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
import org.spongycastle.asn1.eac.EACTags;

/* compiled from: WatchListAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B_\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJe\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b$\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b(\u0010\u000f¨\u0006,"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListAsset;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;", "latest_price", "icon", ApiConstants.NAME, "", ApiConstants.PRICES, "symbol", "color", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListAsset;", "Ljava/lang/String;", "getSymbol", "getColor", "getId", "Ljava/util/List;", "getPrices", "()Ljava/util/List;", "getName", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;", "getLatest_price", "()Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;", "getIcon", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class WatchListAsset extends a {
    public static final ProtoAdapter<WatchListAsset> ADAPTER;
    public static final Parcelable.Creator<WatchListAsset> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    private final String color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String icon;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.LatestPrice#ADAPTER", jsonName = "latestPrice", tag = 2)
    private final LatestPrice latest_price;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String name;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = p.a.REPEATED, tag = 5)
    private final List<String> prices;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String symbol;

    /* compiled from: WatchListAsset.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListAsset$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListAsset;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<WatchListAsset> protoAdapter = new ProtoAdapter<WatchListAsset>(c.LENGTH_DELIMITED, e0.b(WatchListAsset.class), "type.googleapis.com/coinbase.public_api.authed.hydrated_view_service_authed.WatchListAsset") { // from class: com.coinbase.android.apiv3.generated.authed.hydrated_view_service_authed.WatchListAsset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WatchListAsset decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                LatestPrice latestPrice = null;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new WatchListAsset(str, latestPrice, str2, str3, arrayList, str4, str5, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            latestPrice = LatestPrice.ADAPTER.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            arrayList.add(ProtoAdapter.STRING.decode(reader));
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, WatchListAsset value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (value.getLatest_price() != null) {
                    LatestPrice.ADAPTER.encodeWithTag(writer, 2, value.getLatest_price());
                }
                if (!m.c(value.getIcon(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getIcon());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getName());
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.asRepeated().encodeWithTag(writer, 5, value.getPrices());
                if (!m.c(value.getSymbol(), "")) {
                    protoAdapter2.encodeWithTag(writer, 6, value.getSymbol());
                }
                if (!m.c(value.getColor(), "")) {
                    protoAdapter2.encodeWithTag(writer, 7, value.getColor());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(WatchListAsset value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (value.getLatest_price() != null) {
                    int encodedSizeWithTag2 = LatestPrice.ADAPTER.encodedSizeWithTag(2, value.getLatest_price());
                    if (!m.c(value.getIcon(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getIcon());
                        if (!m.c(value.getName(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getName()) + protoAdapter2.asRepeated().encodedSizeWithTag(5, value.getPrices());
                            if (!m.c(value.getSymbol(), "")) {
                                r2 = (m.c(value.getColor(), "") ? 0 : protoAdapter2.encodedSizeWithTag(7, value.getColor()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(6, value.getSymbol());
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public WatchListAsset redact(WatchListAsset value) {
                m.h(value, "value");
                LatestPrice latest_price = value.getLatest_price();
                return WatchListAsset.copy$default(value, null, latest_price != null ? LatestPrice.ADAPTER.redact(latest_price) : null, null, null, null, null, null, i.a, EACTags.SECURE_MESSAGING_TEMPLATE, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public WatchListAsset() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ WatchListAsset(String str, LatestPrice latestPrice, String str2, String str3, List list, String str4, String str5, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : latestPrice, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? r.g() : list, (i2 & 32) != 0 ? "" : str4, (i2 & 64) == 0 ? str5 : "", (i2 & 128) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WatchListAsset copy$default(WatchListAsset watchListAsset, String str, LatestPrice latestPrice, String str2, String str3, List list, String str4, String str5, i iVar, int i2, Object obj) {
        return watchListAsset.copy((i2 & 1) != 0 ? watchListAsset.id : str, (i2 & 2) != 0 ? watchListAsset.latest_price : latestPrice, (i2 & 4) != 0 ? watchListAsset.icon : str2, (i2 & 8) != 0 ? watchListAsset.name : str3, (i2 & 16) != 0 ? watchListAsset.prices : list, (i2 & 32) != 0 ? watchListAsset.symbol : str4, (i2 & 64) != 0 ? watchListAsset.color : str5, (i2 & 128) != 0 ? watchListAsset.unknownFields() : iVar);
    }

    public final WatchListAsset copy(String id, LatestPrice latestPrice, String icon, String name, List<String> prices, String symbol, String color, i unknownFields) {
        m.h(id, "id");
        m.h(icon, "icon");
        m.h(name, "name");
        m.h(prices, "prices");
        m.h(symbol, "symbol");
        m.h(color, "color");
        m.h(unknownFields, "unknownFields");
        return new WatchListAsset(id, latestPrice, icon, name, prices, symbol, color, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WatchListAsset) {
            WatchListAsset watchListAsset = (WatchListAsset) obj;
            return m.c(unknownFields(), watchListAsset.unknownFields()) && m.c(this.id, watchListAsset.id) && m.c(this.latest_price, watchListAsset.latest_price) && m.c(this.icon, watchListAsset.icon) && m.c(this.name, watchListAsset.name) && m.c(this.prices, watchListAsset.prices) && m.c(this.symbol, watchListAsset.symbol) && m.c(this.color, watchListAsset.color);
        }
        return false;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final LatestPrice getLatest_price() {
        return this.latest_price;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getPrices() {
        return this.prices;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37;
            LatestPrice latestPrice = this.latest_price;
            int hashCode2 = ((((((((((hashCode + (latestPrice != null ? latestPrice.hashCode() : 0)) * 37) + this.icon.hashCode()) * 37) + this.name.hashCode()) * 37) + this.prices.hashCode()) * 37) + this.symbol.hashCode()) * 37) + this.color.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m334newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        if (this.latest_price != null) {
            arrayList.add("latest_price=" + this.latest_price);
        }
        arrayList.add("icon=" + b.c(this.icon));
        arrayList.add("name=" + b.c(this.name));
        if (!this.prices.isEmpty()) {
            arrayList.add("prices=" + b.d(this.prices));
        }
        arrayList.add("symbol=" + b.c(this.symbol));
        arrayList.add("color=" + b.c(this.color));
        h0 = z.h0(arrayList, ", ", "WatchListAsset{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m334newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchListAsset(String id, LatestPrice latestPrice, String icon, String name, List<String> prices, String symbol, String color, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(icon, "icon");
        m.h(name, "name");
        m.h(prices, "prices");
        m.h(symbol, "symbol");
        m.h(color, "color");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.latest_price = latestPrice;
        this.icon = icon;
        this.name = name;
        this.prices = prices;
        this.symbol = symbol;
        this.color = color;
    }
}