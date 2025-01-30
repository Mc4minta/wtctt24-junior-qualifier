package com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: AssetSignalFull.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*BA\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/HoldTime;", "hold_time", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;", "percent_holding", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;", "price_correlations", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;", "trading_activity", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/HoldTime;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/HoldTime;", "getHold_time", "()Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/HoldTime;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;", "getTrading_activity", "()Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;", "getPercent_holding", "()Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;", "getPrice_correlations", "()Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;", "<init>", "(Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/HoldTime;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PercentHolding;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/TradingActivity;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AssetSignalFull extends com.squareup.wire.a {
    public static final ProtoAdapter<AssetSignalFull> ADAPTER;
    public static final Parcelable.Creator<AssetSignalFull> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.HoldTime#ADAPTER", jsonName = "holdTime", tag = 1)
    private final HoldTime hold_time;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.PercentHolding#ADAPTER", jsonName = "percentHolding", tag = 2)
    private final PercentHolding percent_holding;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.PriceCorrelations#ADAPTER", jsonName = "priceCorrelations", tag = 3)
    private final PriceCorrelations price_correlations;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.TradingActivity#ADAPTER", jsonName = "tradingActivity", tag = 4)
    private final TradingActivity trading_activity;

    /* compiled from: AssetSignalFull.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(AssetSignalFull.class);
        ProtoAdapter<AssetSignalFull> protoAdapter = new ProtoAdapter<AssetSignalFull>(cVar, b2, "type.googleapis.com/coinbase.public_api.unauthed.hydrated_view_service_unauthed.AssetSignalFull") { // from class: com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.AssetSignalFull$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AssetSignalFull decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                HoldTime holdTime = null;
                PercentHolding percentHolding = null;
                PriceCorrelations priceCorrelations = null;
                TradingActivity tradingActivity = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AssetSignalFull(holdTime, percentHolding, priceCorrelations, tradingActivity, reader.e(d2));
                    }
                    if (g2 == 1) {
                        holdTime = HoldTime.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        percentHolding = PercentHolding.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        priceCorrelations = PriceCorrelations.ADAPTER.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        tradingActivity = TradingActivity.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AssetSignalFull value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getHold_time() != null) {
                    HoldTime.ADAPTER.encodeWithTag(writer, 1, value.getHold_time());
                }
                if (value.getPercent_holding() != null) {
                    PercentHolding.ADAPTER.encodeWithTag(writer, 2, value.getPercent_holding());
                }
                if (value.getPrice_correlations() != null) {
                    PriceCorrelations.ADAPTER.encodeWithTag(writer, 3, value.getPrice_correlations());
                }
                if (value.getTrading_activity() != null) {
                    TradingActivity.ADAPTER.encodeWithTag(writer, 4, value.getTrading_activity());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AssetSignalFull value) {
                m.h(value, "value");
                if (value.getHold_time() == null) {
                    return 0;
                }
                int encodedSizeWithTag = HoldTime.ADAPTER.encodedSizeWithTag(1, value.getHold_time());
                if (value.getPercent_holding() != null) {
                    int encodedSizeWithTag2 = PercentHolding.ADAPTER.encodedSizeWithTag(2, value.getPercent_holding());
                    if (value.getPrice_correlations() != null) {
                        r1 = (value.getTrading_activity() != null ? TradingActivity.ADAPTER.encodedSizeWithTag(4, value.getTrading_activity()) + value.unknownFields().Q() : 0) + PriceCorrelations.ADAPTER.encodedSizeWithTag(3, value.getPrice_correlations());
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AssetSignalFull redact(AssetSignalFull value) {
                m.h(value, "value");
                HoldTime hold_time = value.getHold_time();
                HoldTime redact = hold_time != null ? HoldTime.ADAPTER.redact(hold_time) : null;
                PercentHolding percent_holding = value.getPercent_holding();
                PercentHolding redact2 = percent_holding != null ? PercentHolding.ADAPTER.redact(percent_holding) : null;
                PriceCorrelations price_correlations = value.getPrice_correlations();
                PriceCorrelations redact3 = price_correlations != null ? PriceCorrelations.ADAPTER.redact(price_correlations) : null;
                TradingActivity trading_activity = value.getTrading_activity();
                return value.copy(redact, redact2, redact3, trading_activity != null ? TradingActivity.ADAPTER.redact(trading_activity) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public AssetSignalFull() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ AssetSignalFull(HoldTime holdTime, PercentHolding percentHolding, PriceCorrelations priceCorrelations, TradingActivity tradingActivity, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : holdTime, (i2 & 2) != 0 ? null : percentHolding, (i2 & 4) != 0 ? null : priceCorrelations, (i2 & 8) == 0 ? tradingActivity : null, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AssetSignalFull copy$default(AssetSignalFull assetSignalFull, HoldTime holdTime, PercentHolding percentHolding, PriceCorrelations priceCorrelations, TradingActivity tradingActivity, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            holdTime = assetSignalFull.hold_time;
        }
        if ((i2 & 2) != 0) {
            percentHolding = assetSignalFull.percent_holding;
        }
        PercentHolding percentHolding2 = percentHolding;
        if ((i2 & 4) != 0) {
            priceCorrelations = assetSignalFull.price_correlations;
        }
        PriceCorrelations priceCorrelations2 = priceCorrelations;
        if ((i2 & 8) != 0) {
            tradingActivity = assetSignalFull.trading_activity;
        }
        TradingActivity tradingActivity2 = tradingActivity;
        if ((i2 & 16) != 0) {
            iVar = assetSignalFull.unknownFields();
        }
        return assetSignalFull.copy(holdTime, percentHolding2, priceCorrelations2, tradingActivity2, iVar);
    }

    public final AssetSignalFull copy(HoldTime holdTime, PercentHolding percentHolding, PriceCorrelations priceCorrelations, TradingActivity tradingActivity, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new AssetSignalFull(holdTime, percentHolding, priceCorrelations, tradingActivity, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetSignalFull) {
            AssetSignalFull assetSignalFull = (AssetSignalFull) obj;
            return m.c(unknownFields(), assetSignalFull.unknownFields()) && m.c(this.hold_time, assetSignalFull.hold_time) && m.c(this.percent_holding, assetSignalFull.percent_holding) && m.c(this.price_correlations, assetSignalFull.price_correlations) && m.c(this.trading_activity, assetSignalFull.trading_activity);
        }
        return false;
    }

    public final HoldTime getHold_time() {
        return this.hold_time;
    }

    public final PercentHolding getPercent_holding() {
        return this.percent_holding;
    }

    public final PriceCorrelations getPrice_correlations() {
        return this.price_correlations;
    }

    public final TradingActivity getTrading_activity() {
        return this.trading_activity;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            HoldTime holdTime = this.hold_time;
            int hashCode2 = (hashCode + (holdTime != null ? holdTime.hashCode() : 0)) * 37;
            PercentHolding percentHolding = this.percent_holding;
            int hashCode3 = (hashCode2 + (percentHolding != null ? percentHolding.hashCode() : 0)) * 37;
            PriceCorrelations priceCorrelations = this.price_correlations;
            int hashCode4 = (hashCode3 + (priceCorrelations != null ? priceCorrelations.hashCode() : 0)) * 37;
            TradingActivity tradingActivity = this.trading_activity;
            int hashCode5 = hashCode4 + (tradingActivity != null ? tradingActivity.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m550newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.hold_time != null) {
            arrayList.add("hold_time=" + this.hold_time);
        }
        if (this.percent_holding != null) {
            arrayList.add("percent_holding=" + this.percent_holding);
        }
        if (this.price_correlations != null) {
            arrayList.add("price_correlations=" + this.price_correlations);
        }
        if (this.trading_activity != null) {
            arrayList.add("trading_activity=" + this.trading_activity);
        }
        h0 = z.h0(arrayList, ", ", "AssetSignalFull{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetSignalFull(HoldTime holdTime, PercentHolding percentHolding, PriceCorrelations priceCorrelations, TradingActivity tradingActivity, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.hold_time = holdTime;
        this.percent_holding = percentHolding;
        this.price_correlations = priceCorrelations;
        this.trading_activity = tradingActivity;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m550newBuilder() {
        throw new AssertionError();
    }
}