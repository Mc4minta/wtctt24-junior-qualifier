package com.coinbase.android.apiv3.generated.unauthed;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.PriceChartData;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: PriceInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/By\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u007f\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b\"\u0010!R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b#\u0010!R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b&\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b'\u0010!R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b(\u0010!R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010+R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b,\u0010!¨\u00060"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", ApiConstants.CURRENCY, "unit_price_scale", "Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;", "latest_price_info", "Lcom/coinbase/android/apiv3/generated/common/PriceChartData;", "chart_hour", "chart_day", "chart_week", "chart_month", "chart_year", "chart_all", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;", "Lcom/coinbase/android/apiv3/generated/common/PriceChartData;", "getChart_month", "()Lcom/coinbase/android/apiv3/generated/common/PriceChartData;", "getChart_week", "getChart_year", "Ljava/lang/String;", "getCurrency", "getUnit_price_scale", "getChart_day", "getChart_hour", "Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;", "getLatest_price_info", "()Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;", "getChart_all", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lcom/coinbase/android/apiv3/generated/common/PriceChartData;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PriceInfo extends a {
    public static final ProtoAdapter<PriceInfo> ADAPTER;
    public static final Parcelable.Creator<PriceInfo> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PriceChartData#ADAPTER", jsonName = "chartAll", tag = 9)
    private final PriceChartData chart_all;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PriceChartData#ADAPTER", jsonName = "chartDay", tag = 5)
    private final PriceChartData chart_day;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PriceChartData#ADAPTER", jsonName = "chartHour", tag = 4)
    private final PriceChartData chart_hour;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PriceChartData#ADAPTER", jsonName = "chartMonth", tag = 7)
    private final PriceChartData chart_month;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PriceChartData#ADAPTER", jsonName = "chartWeek", tag = 6)
    private final PriceChartData chart_week;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PriceChartData#ADAPTER", jsonName = "chartYear", tag = 8)
    private final PriceChartData chart_year;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String currency;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.LatestPriceInfo#ADAPTER", jsonName = "latestPriceInfo", tag = 3)
    private final LatestPriceInfo latest_price_info;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "unitPriceScale", tag = 2)
    private final String unit_price_scale;

    /* compiled from: PriceInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/PriceInfo;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(PriceInfo.class);
        ProtoAdapter<PriceInfo> protoAdapter = new ProtoAdapter<PriceInfo>(cVar, b2, "type.googleapis.com/coinbase.public_api.unauthed.PriceInfo") { // from class: com.coinbase.android.apiv3.generated.unauthed.PriceInfo$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PriceInfo decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                LatestPriceInfo latestPriceInfo = null;
                PriceChartData priceChartData = null;
                PriceChartData priceChartData2 = null;
                PriceChartData priceChartData3 = null;
                PriceChartData priceChartData4 = null;
                PriceChartData priceChartData5 = null;
                PriceChartData priceChartData6 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PriceInfo(str, str2, latestPriceInfo, priceChartData, priceChartData2, priceChartData3, priceChartData4, priceChartData5, priceChartData6, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            latestPriceInfo = LatestPriceInfo.ADAPTER.decode(reader);
                            break;
                        case 4:
                            priceChartData = PriceChartData.ADAPTER.decode(reader);
                            break;
                        case 5:
                            priceChartData2 = PriceChartData.ADAPTER.decode(reader);
                            break;
                        case 6:
                            priceChartData3 = PriceChartData.ADAPTER.decode(reader);
                            break;
                        case 7:
                            priceChartData4 = PriceChartData.ADAPTER.decode(reader);
                            break;
                        case 8:
                            priceChartData5 = PriceChartData.ADAPTER.decode(reader);
                            break;
                        case 9:
                            priceChartData6 = PriceChartData.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PriceInfo value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getCurrency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getCurrency());
                }
                if (!m.c(value.getUnit_price_scale(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getUnit_price_scale());
                }
                if (value.getLatest_price_info() != null) {
                    LatestPriceInfo.ADAPTER.encodeWithTag(writer, 3, value.getLatest_price_info());
                }
                if (value.getChart_hour() != null) {
                    PriceChartData.ADAPTER.encodeWithTag(writer, 4, value.getChart_hour());
                }
                if (value.getChart_day() != null) {
                    PriceChartData.ADAPTER.encodeWithTag(writer, 5, value.getChart_day());
                }
                if (value.getChart_week() != null) {
                    PriceChartData.ADAPTER.encodeWithTag(writer, 6, value.getChart_week());
                }
                if (value.getChart_month() != null) {
                    PriceChartData.ADAPTER.encodeWithTag(writer, 7, value.getChart_month());
                }
                if (value.getChart_year() != null) {
                    PriceChartData.ADAPTER.encodeWithTag(writer, 8, value.getChart_year());
                }
                if (value.getChart_all() != null) {
                    PriceChartData.ADAPTER.encodeWithTag(writer, 9, value.getChart_all());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PriceInfo value) {
                m.h(value, "value");
                if (m.c(value.getCurrency(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getCurrency());
                if (!m.c(value.getUnit_price_scale(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getUnit_price_scale());
                    if (value.getLatest_price_info() != null) {
                        int encodedSizeWithTag3 = LatestPriceInfo.ADAPTER.encodedSizeWithTag(3, value.getLatest_price_info());
                        if (value.getChart_hour() != null) {
                            ProtoAdapter<PriceChartData> protoAdapter3 = PriceChartData.ADAPTER;
                            int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(4, value.getChart_hour());
                            if (value.getChart_day() != null) {
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getChart_day());
                                if (value.getChart_week() != null) {
                                    int encodedSizeWithTag6 = protoAdapter3.encodedSizeWithTag(6, value.getChart_week());
                                    if (value.getChart_month() != null) {
                                        int encodedSizeWithTag7 = protoAdapter3.encodedSizeWithTag(7, value.getChart_month());
                                        if (value.getChart_year() != null) {
                                            r2 = (value.getChart_all() != null ? protoAdapter3.encodedSizeWithTag(9, value.getChart_all()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(8, value.getChart_year());
                                        }
                                        r2 += encodedSizeWithTag7;
                                    }
                                    r2 += encodedSizeWithTag6;
                                }
                                r2 += encodedSizeWithTag5;
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
            public PriceInfo redact(PriceInfo value) {
                PriceInfo copy;
                m.h(value, "value");
                LatestPriceInfo latest_price_info = value.getLatest_price_info();
                LatestPriceInfo redact = latest_price_info != null ? LatestPriceInfo.ADAPTER.redact(latest_price_info) : null;
                PriceChartData chart_hour = value.getChart_hour();
                PriceChartData redact2 = chart_hour != null ? PriceChartData.ADAPTER.redact(chart_hour) : null;
                PriceChartData chart_day = value.getChart_day();
                PriceChartData redact3 = chart_day != null ? PriceChartData.ADAPTER.redact(chart_day) : null;
                PriceChartData chart_week = value.getChart_week();
                PriceChartData redact4 = chart_week != null ? PriceChartData.ADAPTER.redact(chart_week) : null;
                PriceChartData chart_month = value.getChart_month();
                PriceChartData redact5 = chart_month != null ? PriceChartData.ADAPTER.redact(chart_month) : null;
                PriceChartData chart_year = value.getChart_year();
                PriceChartData redact6 = chart_year != null ? PriceChartData.ADAPTER.redact(chart_year) : null;
                PriceChartData chart_all = value.getChart_all();
                copy = value.copy((r22 & 1) != 0 ? value.currency : null, (r22 & 2) != 0 ? value.unit_price_scale : null, (r22 & 4) != 0 ? value.latest_price_info : redact, (r22 & 8) != 0 ? value.chart_hour : redact2, (r22 & 16) != 0 ? value.chart_day : redact3, (r22 & 32) != 0 ? value.chart_week : redact4, (r22 & 64) != 0 ? value.chart_month : redact5, (r22 & 128) != 0 ? value.chart_year : redact6, (r22 & 256) != 0 ? value.chart_all : chart_all != null ? PriceChartData.ADAPTER.redact(chart_all) : null, (r22 & 512) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PriceInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ PriceInfo(String str, String str2, LatestPriceInfo latestPriceInfo, PriceChartData priceChartData, PriceChartData priceChartData2, PriceChartData priceChartData3, PriceChartData priceChartData4, PriceChartData priceChartData5, PriceChartData priceChartData6, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? null : latestPriceInfo, (i2 & 8) != 0 ? null : priceChartData, (i2 & 16) != 0 ? null : priceChartData2, (i2 & 32) != 0 ? null : priceChartData3, (i2 & 64) != 0 ? null : priceChartData4, (i2 & 128) != 0 ? null : priceChartData5, (i2 & 256) == 0 ? priceChartData6 : null, (i2 & 512) != 0 ? i.a : iVar);
    }

    public final PriceInfo copy(String currency, String unit_price_scale, LatestPriceInfo latestPriceInfo, PriceChartData priceChartData, PriceChartData priceChartData2, PriceChartData priceChartData3, PriceChartData priceChartData4, PriceChartData priceChartData5, PriceChartData priceChartData6, i unknownFields) {
        m.h(currency, "currency");
        m.h(unit_price_scale, "unit_price_scale");
        m.h(unknownFields, "unknownFields");
        return new PriceInfo(currency, unit_price_scale, latestPriceInfo, priceChartData, priceChartData2, priceChartData3, priceChartData4, priceChartData5, priceChartData6, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PriceInfo) {
            PriceInfo priceInfo = (PriceInfo) obj;
            return m.c(unknownFields(), priceInfo.unknownFields()) && m.c(this.currency, priceInfo.currency) && m.c(this.unit_price_scale, priceInfo.unit_price_scale) && m.c(this.latest_price_info, priceInfo.latest_price_info) && m.c(this.chart_hour, priceInfo.chart_hour) && m.c(this.chart_day, priceInfo.chart_day) && m.c(this.chart_week, priceInfo.chart_week) && m.c(this.chart_month, priceInfo.chart_month) && m.c(this.chart_year, priceInfo.chart_year) && m.c(this.chart_all, priceInfo.chart_all);
        }
        return false;
    }

    public final PriceChartData getChart_all() {
        return this.chart_all;
    }

    public final PriceChartData getChart_day() {
        return this.chart_day;
    }

    public final PriceChartData getChart_hour() {
        return this.chart_hour;
    }

    public final PriceChartData getChart_month() {
        return this.chart_month;
    }

    public final PriceChartData getChart_week() {
        return this.chart_week;
    }

    public final PriceChartData getChart_year() {
        return this.chart_year;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final LatestPriceInfo getLatest_price_info() {
        return this.latest_price_info;
    }

    public final String getUnit_price_scale() {
        return this.unit_price_scale;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.currency.hashCode()) * 37) + this.unit_price_scale.hashCode()) * 37;
            LatestPriceInfo latestPriceInfo = this.latest_price_info;
            int hashCode2 = (hashCode + (latestPriceInfo != null ? latestPriceInfo.hashCode() : 0)) * 37;
            PriceChartData priceChartData = this.chart_hour;
            int hashCode3 = (hashCode2 + (priceChartData != null ? priceChartData.hashCode() : 0)) * 37;
            PriceChartData priceChartData2 = this.chart_day;
            int hashCode4 = (hashCode3 + (priceChartData2 != null ? priceChartData2.hashCode() : 0)) * 37;
            PriceChartData priceChartData3 = this.chart_week;
            int hashCode5 = (hashCode4 + (priceChartData3 != null ? priceChartData3.hashCode() : 0)) * 37;
            PriceChartData priceChartData4 = this.chart_month;
            int hashCode6 = (hashCode5 + (priceChartData4 != null ? priceChartData4.hashCode() : 0)) * 37;
            PriceChartData priceChartData5 = this.chart_year;
            int hashCode7 = (hashCode6 + (priceChartData5 != null ? priceChartData5.hashCode() : 0)) * 37;
            PriceChartData priceChartData6 = this.chart_all;
            int hashCode8 = hashCode7 + (priceChartData6 != null ? priceChartData6.hashCode() : 0);
            this.hashCode = hashCode8;
            return hashCode8;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m545newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("currency=" + b.c(this.currency));
        arrayList.add("unit_price_scale=" + b.c(this.unit_price_scale));
        if (this.latest_price_info != null) {
            arrayList.add("latest_price_info=" + this.latest_price_info);
        }
        if (this.chart_hour != null) {
            arrayList.add("chart_hour=" + this.chart_hour);
        }
        if (this.chart_day != null) {
            arrayList.add("chart_day=" + this.chart_day);
        }
        if (this.chart_week != null) {
            arrayList.add("chart_week=" + this.chart_week);
        }
        if (this.chart_month != null) {
            arrayList.add("chart_month=" + this.chart_month);
        }
        if (this.chart_year != null) {
            arrayList.add("chart_year=" + this.chart_year);
        }
        if (this.chart_all != null) {
            arrayList.add("chart_all=" + this.chart_all);
        }
        h0 = z.h0(arrayList, ", ", "PriceInfo{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceInfo(String currency, String unit_price_scale, LatestPriceInfo latestPriceInfo, PriceChartData priceChartData, PriceChartData priceChartData2, PriceChartData priceChartData3, PriceChartData priceChartData4, PriceChartData priceChartData5, PriceChartData priceChartData6, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(currency, "currency");
        m.h(unit_price_scale, "unit_price_scale");
        m.h(unknownFields, "unknownFields");
        this.currency = currency;
        this.unit_price_scale = unit_price_scale;
        this.latest_price_info = latestPriceInfo;
        this.chart_hour = priceChartData;
        this.chart_day = priceChartData2;
        this.chart_week = priceChartData3;
        this.chart_month = priceChartData4;
        this.chart_year = priceChartData5;
        this.chart_all = priceChartData6;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m545newBuilder() {
        throw new AssertionError();
    }
}