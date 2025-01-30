package com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.squareup.wire.ProtoAdapter;
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

/* compiled from: CorrelatedAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)BO\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b&\u0010\u000f¨\u0006*"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/CorrelatedAsset;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "correlation", "icon", "id", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;", "latest_price", ApiConstants.NAME, "symbol", "Lj/i;", "unknownFields", "copy", "(DLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/CorrelatedAsset;", "Ljava/lang/String;", "getIcon", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;", "getLatest_price", "()Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;", "getId", "D", "getCorrelation", "()D", "getName", "getSymbol", "<init>", "(DLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/LatestPrice;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CorrelatedAsset extends com.squareup.wire.a {
    public static final ProtoAdapter<CorrelatedAsset> ADAPTER;
    public static final Parcelable.Creator<CorrelatedAsset> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    private final double correlation;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String icon;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.LatestPrice#ADAPTER", jsonName = "latestPrice", tag = 4)
    private final LatestPrice latest_price;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String name;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String symbol;

    /* compiled from: CorrelatedAsset.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/CorrelatedAsset$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/CorrelatedAsset;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<CorrelatedAsset> protoAdapter = new ProtoAdapter<CorrelatedAsset>(c.LENGTH_DELIMITED, e0.b(CorrelatedAsset.class), "type.googleapis.com/coinbase.public_api.unauthed.hydrated_view_service_unauthed.CorrelatedAsset") { // from class: com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.CorrelatedAsset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CorrelatedAsset decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                double d3 = 0.0d;
                LatestPrice latestPrice = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CorrelatedAsset(d3, str, str2, latestPrice, str3, str4, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            d3 = ProtoAdapter.DOUBLE.decode(reader).doubleValue();
                            break;
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            latestPrice = LatestPrice.ADAPTER.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CorrelatedAsset value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCorrelation() != 0.0d) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 1, Double.valueOf(value.getCorrelation()));
                }
                if (!m.c(value.getIcon(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getIcon());
                }
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getId());
                }
                if (value.getLatest_price() != null) {
                    LatestPrice.ADAPTER.encodeWithTag(writer, 4, value.getLatest_price());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getName());
                }
                if (!m.c(value.getSymbol(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getSymbol());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CorrelatedAsset value) {
                m.h(value, "value");
                if (value.getCorrelation() == 0.0d) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, Double.valueOf(value.getCorrelation()));
                if (!m.c(value.getIcon(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getIcon());
                    if (!m.c(value.getId(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getId());
                        if (value.getLatest_price() != null) {
                            int encodedSizeWithTag4 = LatestPrice.ADAPTER.encodedSizeWithTag(4, value.getLatest_price());
                            if (!m.c(value.getName(), "")) {
                                r1 = (m.c(value.getSymbol(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getSymbol()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(5, value.getName());
                            }
                            r1 += encodedSizeWithTag4;
                        }
                        r1 += encodedSizeWithTag3;
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CorrelatedAsset redact(CorrelatedAsset value) {
                m.h(value, "value");
                LatestPrice latest_price = value.getLatest_price();
                return CorrelatedAsset.copy$default(value, 0.0d, null, null, latest_price != null ? LatestPrice.ADAPTER.redact(latest_price) : null, null, null, i.a, 55, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public CorrelatedAsset() {
        this(0.0d, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ CorrelatedAsset(double d2, String str, String str2, LatestPrice latestPrice, String str3, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0d : d2, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? null : latestPrice, (i2 & 16) != 0 ? "" : str3, (i2 & 32) == 0 ? str4 : "", (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ CorrelatedAsset copy$default(CorrelatedAsset correlatedAsset, double d2, String str, String str2, LatestPrice latestPrice, String str3, String str4, i iVar, int i2, Object obj) {
        return correlatedAsset.copy((i2 & 1) != 0 ? correlatedAsset.correlation : d2, (i2 & 2) != 0 ? correlatedAsset.icon : str, (i2 & 4) != 0 ? correlatedAsset.id : str2, (i2 & 8) != 0 ? correlatedAsset.latest_price : latestPrice, (i2 & 16) != 0 ? correlatedAsset.name : str3, (i2 & 32) != 0 ? correlatedAsset.symbol : str4, (i2 & 64) != 0 ? correlatedAsset.unknownFields() : iVar);
    }

    public final CorrelatedAsset copy(double d2, String icon, String id, LatestPrice latestPrice, String name, String symbol, i unknownFields) {
        m.h(icon, "icon");
        m.h(id, "id");
        m.h(name, "name");
        m.h(symbol, "symbol");
        m.h(unknownFields, "unknownFields");
        return new CorrelatedAsset(d2, icon, id, latestPrice, name, symbol, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CorrelatedAsset) {
            CorrelatedAsset correlatedAsset = (CorrelatedAsset) obj;
            return m.c(unknownFields(), correlatedAsset.unknownFields()) && this.correlation == correlatedAsset.correlation && m.c(this.icon, correlatedAsset.icon) && m.c(this.id, correlatedAsset.id) && m.c(this.latest_price, correlatedAsset.latest_price) && m.c(this.name, correlatedAsset.name) && m.c(this.symbol, correlatedAsset.symbol);
        }
        return false;
    }

    public final double getCorrelation() {
        return this.correlation;
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

    public final String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + a.a(this.correlation)) * 37) + this.icon.hashCode()) * 37) + this.id.hashCode()) * 37;
            LatestPrice latestPrice = this.latest_price;
            int hashCode2 = ((((hashCode + (latestPrice != null ? latestPrice.hashCode() : 0)) * 37) + this.name.hashCode()) * 37) + this.symbol.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m554newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("correlation=" + this.correlation);
        arrayList.add("icon=" + b.c(this.icon));
        arrayList.add("id=" + b.c(this.id));
        if (this.latest_price != null) {
            arrayList.add("latest_price=" + this.latest_price);
        }
        arrayList.add("name=" + b.c(this.name));
        arrayList.add("symbol=" + b.c(this.symbol));
        h0 = z.h0(arrayList, ", ", "CorrelatedAsset{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CorrelatedAsset(double d2, String icon, String id, LatestPrice latestPrice, String name, String symbol, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(icon, "icon");
        m.h(id, "id");
        m.h(name, "name");
        m.h(symbol, "symbol");
        m.h(unknownFields, "unknownFields");
        this.correlation = d2;
        this.icon = icon;
        this.id = id;
        this.latest_price = latestPrice;
        this.name = name;
        this.symbol = symbol;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m554newBuilder() {
        throw new AssertionError();
    }
}