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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: AssetStatsFull.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0095\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b5\u00106J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u009b\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010#\u001a\u0004\b)\u0010%R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b*\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b+\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b,\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b-\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b.\u0010%R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b0\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b1\u0010\u000fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFull;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "base", "base_id", ApiConstants.CURRENCY, "circulating_supply", "total_supply", "max_supply", "volume_24h", "market_cap", "all_time_high", "", "percent_change_1h", "percent_change_24h", "percent_change_7d", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;", "signals", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDLcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFull;", "D", "getPercent_change_1h", "()D", "Ljava/lang/String;", "getCurrency", "getTotal_supply", "getPercent_change_7d", "getAll_time_high", "getMax_supply", "getCirculating_supply", "getMarket_cap", "getPercent_change_24h", "getBase_id", "getVolume_24h", "getBase", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;", "getSignals", "()Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDLcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetSignalFull;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AssetStatsFull extends com.squareup.wire.a {
    public static final ProtoAdapter<AssetStatsFull> ADAPTER;
    public static final Parcelable.Creator<AssetStatsFull> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "allTimeHigh", tag = 9)
    private final String all_time_high;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String base;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "baseId", tag = 2)
    private final String base_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "circulatingSupply", tag = 4)
    private final String circulating_supply;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String currency;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "marketCap", tag = 8)
    private final String market_cap;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "maxSupply", tag = 6)
    private final String max_supply;
    @p(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", jsonName = "percentChange1h", tag = 10)
    private final double percent_change_1h;
    @p(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", jsonName = "percentChange24h", tag = 11)
    private final double percent_change_24h;
    @p(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", jsonName = "percentChange7d", tag = 12)
    private final double percent_change_7d;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.AssetSignalFull#ADAPTER", tag = 13)
    private final AssetSignalFull signals;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "totalSupply", tag = 5)
    private final String total_supply;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "volume24h", tag = 7)
    private final String volume_24h;

    /* compiled from: AssetStatsFull.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFull$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFull;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(AssetStatsFull.class);
        ProtoAdapter<AssetStatsFull> protoAdapter = new ProtoAdapter<AssetStatsFull>(cVar, b2, "type.googleapis.com/coinbase.public_api.unauthed.hydrated_view_service_unauthed.AssetStatsFull") { // from class: com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.AssetStatsFull$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AssetStatsFull decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                double d3 = 0.0d;
                double d4 = 0.0d;
                double d5 = 0.0d;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                String str9 = str8;
                AssetSignalFull assetSignalFull = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AssetStatsFull(str, str2, str3, str4, str5, str6, str7, str8, str9, d3, d4, d5, assetSignalFull, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            str9 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 10:
                            d3 = ProtoAdapter.DOUBLE.decode(reader).doubleValue();
                            break;
                        case 11:
                            d4 = ProtoAdapter.DOUBLE.decode(reader).doubleValue();
                            break;
                        case 12:
                            d5 = ProtoAdapter.DOUBLE.decode(reader).doubleValue();
                            break;
                        case 13:
                            assetSignalFull = AssetSignalFull.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AssetStatsFull value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getBase(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getBase());
                }
                if (!m.c(value.getBase_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getBase_id());
                }
                if (!m.c(value.getCurrency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getCurrency());
                }
                if (!m.c(value.getCirculating_supply(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getCirculating_supply());
                }
                if (!m.c(value.getTotal_supply(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getTotal_supply());
                }
                if (!m.c(value.getMax_supply(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getMax_supply());
                }
                if (!m.c(value.getVolume_24h(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getVolume_24h());
                }
                if (!m.c(value.getMarket_cap(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getMarket_cap());
                }
                if (!m.c(value.getAll_time_high(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 9, value.getAll_time_high());
                }
                if (value.getPercent_change_1h() != 0.0d) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 10, Double.valueOf(value.getPercent_change_1h()));
                }
                if (value.getPercent_change_24h() != 0.0d) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 11, Double.valueOf(value.getPercent_change_24h()));
                }
                if (value.getPercent_change_7d() != 0.0d) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 12, Double.valueOf(value.getPercent_change_7d()));
                }
                if (value.getSignals() != null) {
                    AssetSignalFull.ADAPTER.encodeWithTag(writer, 13, value.getSignals());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AssetStatsFull value) {
                int Q;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                m.h(value, "value");
                if (m.c(value.getBase(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getBase());
                if (m.c(value.getBase_id(), "")) {
                    i12 = 0;
                } else {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getBase_id());
                    if (m.c(value.getCurrency(), "")) {
                        i11 = 0;
                    } else {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getCurrency());
                        if (m.c(value.getCirculating_supply(), "")) {
                            i10 = 0;
                        } else {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getCirculating_supply());
                            if (m.c(value.getTotal_supply(), "")) {
                                i9 = 0;
                            } else {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getTotal_supply());
                                if (m.c(value.getMax_supply(), "")) {
                                    i8 = 0;
                                } else {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(6, value.getMax_supply());
                                    if (m.c(value.getVolume_24h(), "")) {
                                        i7 = 0;
                                    } else {
                                        int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(7, value.getVolume_24h());
                                        if (m.c(value.getMarket_cap(), "")) {
                                            i6 = 0;
                                        } else {
                                            int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(8, value.getMarket_cap());
                                            if (m.c(value.getAll_time_high(), "")) {
                                                i5 = 0;
                                            } else {
                                                int encodedSizeWithTag9 = protoAdapter2.encodedSizeWithTag(9, value.getAll_time_high());
                                                if (value.getPercent_change_1h() == 0.0d) {
                                                    i4 = 0;
                                                } else {
                                                    ProtoAdapter<Double> protoAdapter3 = ProtoAdapter.DOUBLE;
                                                    int encodedSizeWithTag10 = protoAdapter3.encodedSizeWithTag(10, Double.valueOf(value.getPercent_change_1h()));
                                                    if (value.getPercent_change_24h() == 0.0d) {
                                                        i3 = 0;
                                                    } else {
                                                        int encodedSizeWithTag11 = protoAdapter3.encodedSizeWithTag(11, Double.valueOf(value.getPercent_change_24h()));
                                                        if (value.getPercent_change_7d() == 0.0d) {
                                                            i2 = 0;
                                                        } else {
                                                            int encodedSizeWithTag12 = protoAdapter3.encodedSizeWithTag(12, Double.valueOf(value.getPercent_change_7d()));
                                                            if (value.getSignals() == null) {
                                                                Q = 0;
                                                            } else {
                                                                Q = value.unknownFields().Q() + AssetSignalFull.ADAPTER.encodedSizeWithTag(13, value.getSignals());
                                                            }
                                                            i2 = Q + encodedSizeWithTag12;
                                                        }
                                                        i3 = encodedSizeWithTag11 + i2;
                                                    }
                                                    i4 = i3 + encodedSizeWithTag10;
                                                }
                                                i5 = i4 + encodedSizeWithTag9;
                                            }
                                            i6 = i5 + encodedSizeWithTag8;
                                        }
                                        i7 = i6 + encodedSizeWithTag7;
                                    }
                                    i8 = i7 + encodedSizeWithTag6;
                                }
                                i9 = i8 + encodedSizeWithTag5;
                            }
                            i10 = i9 + encodedSizeWithTag4;
                        }
                        i11 = i10 + encodedSizeWithTag3;
                    }
                    i12 = i11 + encodedSizeWithTag2;
                }
                return i12 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AssetStatsFull redact(AssetStatsFull value) {
                AssetStatsFull copy;
                m.h(value, "value");
                AssetSignalFull signals = value.getSignals();
                copy = value.copy((r34 & 1) != 0 ? value.base : null, (r34 & 2) != 0 ? value.base_id : null, (r34 & 4) != 0 ? value.currency : null, (r34 & 8) != 0 ? value.circulating_supply : null, (r34 & 16) != 0 ? value.total_supply : null, (r34 & 32) != 0 ? value.max_supply : null, (r34 & 64) != 0 ? value.volume_24h : null, (r34 & 128) != 0 ? value.market_cap : null, (r34 & 256) != 0 ? value.all_time_high : null, (r34 & 512) != 0 ? value.percent_change_1h : 0.0d, (r34 & 1024) != 0 ? value.percent_change_24h : 0.0d, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? value.percent_change_7d : 0.0d, (r34 & 4096) != 0 ? value.signals : signals != null ? AssetSignalFull.ADAPTER.redact(signals) : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public AssetStatsFull() {
        this(null, null, null, null, null, null, null, null, null, 0.0d, 0.0d, 0.0d, null, null, 16383, null);
    }

    public /* synthetic */ AssetStatsFull(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, double d2, double d3, double d4, AssetSignalFull assetSignalFull, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) == 0 ? str9 : "", (i2 & 512) != 0 ? 0.0d : d2, (i2 & 1024) != 0 ? 0.0d : d3, (i2 & PKIFailureInfo.wrongIntegrity) == 0 ? d4 : 0.0d, (i2 & 4096) != 0 ? null : assetSignalFull, (i2 & PKIFailureInfo.certRevoked) != 0 ? i.a : iVar);
    }

    public final AssetStatsFull copy(String base, String base_id, String currency, String circulating_supply, String total_supply, String max_supply, String volume_24h, String market_cap, String all_time_high, double d2, double d3, double d4, AssetSignalFull assetSignalFull, i unknownFields) {
        m.h(base, "base");
        m.h(base_id, "base_id");
        m.h(currency, "currency");
        m.h(circulating_supply, "circulating_supply");
        m.h(total_supply, "total_supply");
        m.h(max_supply, "max_supply");
        m.h(volume_24h, "volume_24h");
        m.h(market_cap, "market_cap");
        m.h(all_time_high, "all_time_high");
        m.h(unknownFields, "unknownFields");
        return new AssetStatsFull(base, base_id, currency, circulating_supply, total_supply, max_supply, volume_24h, market_cap, all_time_high, d2, d3, d4, assetSignalFull, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetStatsFull) {
            AssetStatsFull assetStatsFull = (AssetStatsFull) obj;
            return m.c(unknownFields(), assetStatsFull.unknownFields()) && m.c(this.base, assetStatsFull.base) && m.c(this.base_id, assetStatsFull.base_id) && m.c(this.currency, assetStatsFull.currency) && m.c(this.circulating_supply, assetStatsFull.circulating_supply) && m.c(this.total_supply, assetStatsFull.total_supply) && m.c(this.max_supply, assetStatsFull.max_supply) && m.c(this.volume_24h, assetStatsFull.volume_24h) && m.c(this.market_cap, assetStatsFull.market_cap) && m.c(this.all_time_high, assetStatsFull.all_time_high) && this.percent_change_1h == assetStatsFull.percent_change_1h && this.percent_change_24h == assetStatsFull.percent_change_24h && this.percent_change_7d == assetStatsFull.percent_change_7d && m.c(this.signals, assetStatsFull.signals);
        }
        return false;
    }

    public final String getAll_time_high() {
        return this.all_time_high;
    }

    public final String getBase() {
        return this.base;
    }

    public final String getBase_id() {
        return this.base_id;
    }

    public final String getCirculating_supply() {
        return this.circulating_supply;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getMarket_cap() {
        return this.market_cap;
    }

    public final String getMax_supply() {
        return this.max_supply;
    }

    public final double getPercent_change_1h() {
        return this.percent_change_1h;
    }

    public final double getPercent_change_24h() {
        return this.percent_change_24h;
    }

    public final double getPercent_change_7d() {
        return this.percent_change_7d;
    }

    public final AssetSignalFull getSignals() {
        return this.signals;
    }

    public final String getTotal_supply() {
        return this.total_supply;
    }

    public final String getVolume_24h() {
        return this.volume_24h;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((((((((((((((((unknownFields().hashCode() * 37) + this.base.hashCode()) * 37) + this.base_id.hashCode()) * 37) + this.currency.hashCode()) * 37) + this.circulating_supply.hashCode()) * 37) + this.total_supply.hashCode()) * 37) + this.max_supply.hashCode()) * 37) + this.volume_24h.hashCode()) * 37) + this.market_cap.hashCode()) * 37) + this.all_time_high.hashCode()) * 37) + a.a(this.percent_change_1h)) * 37) + a.a(this.percent_change_24h)) * 37) + a.a(this.percent_change_7d)) * 37;
            AssetSignalFull assetSignalFull = this.signals;
            int hashCode2 = hashCode + (assetSignalFull != null ? assetSignalFull.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m551newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("base=" + b.c(this.base));
        arrayList.add("base_id=" + b.c(this.base_id));
        arrayList.add("currency=" + b.c(this.currency));
        arrayList.add("circulating_supply=" + b.c(this.circulating_supply));
        arrayList.add("total_supply=" + b.c(this.total_supply));
        arrayList.add("max_supply=" + b.c(this.max_supply));
        arrayList.add("volume_24h=" + b.c(this.volume_24h));
        arrayList.add("market_cap=" + b.c(this.market_cap));
        arrayList.add("all_time_high=" + b.c(this.all_time_high));
        arrayList.add("percent_change_1h=" + this.percent_change_1h);
        arrayList.add("percent_change_24h=" + this.percent_change_24h);
        arrayList.add("percent_change_7d=" + this.percent_change_7d);
        if (this.signals != null) {
            arrayList.add("signals=" + this.signals);
        }
        h0 = z.h0(arrayList, ", ", "AssetStatsFull{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetStatsFull(String base, String base_id, String currency, String circulating_supply, String total_supply, String max_supply, String volume_24h, String market_cap, String all_time_high, double d2, double d3, double d4, AssetSignalFull assetSignalFull, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(base, "base");
        m.h(base_id, "base_id");
        m.h(currency, "currency");
        m.h(circulating_supply, "circulating_supply");
        m.h(total_supply, "total_supply");
        m.h(max_supply, "max_supply");
        m.h(volume_24h, "volume_24h");
        m.h(market_cap, "market_cap");
        m.h(all_time_high, "all_time_high");
        m.h(unknownFields, "unknownFields");
        this.base = base;
        this.base_id = base_id;
        this.currency = currency;
        this.circulating_supply = circulating_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.volume_24h = volume_24h;
        this.market_cap = market_cap;
        this.all_time_high = all_time_high;
        this.percent_change_1h = d2;
        this.percent_change_24h = d3;
        this.percent_change_7d = d4;
        this.signals = assetSignalFull;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m551newBuilder() {
        throw new AssertionError();
    }
}