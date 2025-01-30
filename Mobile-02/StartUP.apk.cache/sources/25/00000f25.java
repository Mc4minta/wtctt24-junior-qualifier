package com.coinbase.android.apiv3.generated.unauthed;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.TimestampedScaledAmount;
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

/* compiled from: LatestPriceInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&BO\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b#\u0010\u000f¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", ApiConstants.PRICE, "percent_change_hour", "percent_change_day", "percent_change_week", "percent_change_month", "percent_change_year", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;", "Ljava/lang/String;", "getPercent_change_hour", "Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "getPrice", "()Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "getPercent_change_day", "getPercent_change_week", "getPercent_change_year", "getPercent_change_month", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LatestPriceInfo extends a {
    public static final ProtoAdapter<LatestPriceInfo> ADAPTER;
    public static final Parcelable.Creator<LatestPriceInfo> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "percentChangeDay", tag = 3)
    private final String percent_change_day;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "percentChangeHour", tag = 2)
    private final String percent_change_hour;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "percentChangeMonth", tag = 5)
    private final String percent_change_month;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "percentChangeWeek", tag = 4)
    private final String percent_change_week;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "percentChangeYear", tag = 6)
    private final String percent_change_year;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.TimestampedScaledAmount#ADAPTER", tag = 1)
    private final TimestampedScaledAmount price;

    /* compiled from: LatestPriceInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/LatestPriceInfo;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LatestPriceInfo> protoAdapter = new ProtoAdapter<LatestPriceInfo>(c.LENGTH_DELIMITED, e0.b(LatestPriceInfo.class), "type.googleapis.com/coinbase.public_api.unauthed.LatestPriceInfo") { // from class: com.coinbase.android.apiv3.generated.unauthed.LatestPriceInfo$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LatestPriceInfo decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                TimestampedScaledAmount timestampedScaledAmount = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LatestPriceInfo(timestampedScaledAmount, str, str2, str3, str4, str5, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            timestampedScaledAmount = TimestampedScaledAmount.ADAPTER.decode(reader);
                            break;
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LatestPriceInfo value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getPrice() != null) {
                    TimestampedScaledAmount.ADAPTER.encodeWithTag(writer, 1, value.getPrice());
                }
                if (!m.c(value.getPercent_change_hour(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPercent_change_hour());
                }
                if (!m.c(value.getPercent_change_day(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getPercent_change_day());
                }
                if (!m.c(value.getPercent_change_week(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getPercent_change_week());
                }
                if (!m.c(value.getPercent_change_month(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getPercent_change_month());
                }
                if (!m.c(value.getPercent_change_year(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getPercent_change_year());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LatestPriceInfo value) {
                m.h(value, "value");
                if (value.getPrice() == null) {
                    return 0;
                }
                int encodedSizeWithTag = TimestampedScaledAmount.ADAPTER.encodedSizeWithTag(1, value.getPrice());
                if (!m.c(value.getPercent_change_hour(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getPercent_change_hour());
                    if (!m.c(value.getPercent_change_day(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getPercent_change_day());
                        if (!m.c(value.getPercent_change_week(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getPercent_change_week());
                            if (!m.c(value.getPercent_change_month(), "")) {
                                r1 = (m.c(value.getPercent_change_year(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getPercent_change_year()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(5, value.getPercent_change_month());
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
            public LatestPriceInfo redact(LatestPriceInfo value) {
                m.h(value, "value");
                TimestampedScaledAmount price = value.getPrice();
                return LatestPriceInfo.copy$default(value, price != null ? TimestampedScaledAmount.ADAPTER.redact(price) : null, null, null, null, null, null, i.a, 62, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LatestPriceInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ LatestPriceInfo(TimestampedScaledAmount timestampedScaledAmount, String str, String str2, String str3, String str4, String str5, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : timestampedScaledAmount, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "", (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LatestPriceInfo copy$default(LatestPriceInfo latestPriceInfo, TimestampedScaledAmount timestampedScaledAmount, String str, String str2, String str3, String str4, String str5, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            timestampedScaledAmount = latestPriceInfo.price;
        }
        if ((i2 & 2) != 0) {
            str = latestPriceInfo.percent_change_hour;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = latestPriceInfo.percent_change_day;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = latestPriceInfo.percent_change_week;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = latestPriceInfo.percent_change_month;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = latestPriceInfo.percent_change_year;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            iVar = latestPriceInfo.unknownFields();
        }
        return latestPriceInfo.copy(timestampedScaledAmount, str6, str7, str8, str9, str10, iVar);
    }

    public final LatestPriceInfo copy(TimestampedScaledAmount timestampedScaledAmount, String percent_change_hour, String percent_change_day, String percent_change_week, String percent_change_month, String percent_change_year, i unknownFields) {
        m.h(percent_change_hour, "percent_change_hour");
        m.h(percent_change_day, "percent_change_day");
        m.h(percent_change_week, "percent_change_week");
        m.h(percent_change_month, "percent_change_month");
        m.h(percent_change_year, "percent_change_year");
        m.h(unknownFields, "unknownFields");
        return new LatestPriceInfo(timestampedScaledAmount, percent_change_hour, percent_change_day, percent_change_week, percent_change_month, percent_change_year, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LatestPriceInfo) {
            LatestPriceInfo latestPriceInfo = (LatestPriceInfo) obj;
            return m.c(unknownFields(), latestPriceInfo.unknownFields()) && m.c(this.price, latestPriceInfo.price) && m.c(this.percent_change_hour, latestPriceInfo.percent_change_hour) && m.c(this.percent_change_day, latestPriceInfo.percent_change_day) && m.c(this.percent_change_week, latestPriceInfo.percent_change_week) && m.c(this.percent_change_month, latestPriceInfo.percent_change_month) && m.c(this.percent_change_year, latestPriceInfo.percent_change_year);
        }
        return false;
    }

    public final String getPercent_change_day() {
        return this.percent_change_day;
    }

    public final String getPercent_change_hour() {
        return this.percent_change_hour;
    }

    public final String getPercent_change_month() {
        return this.percent_change_month;
    }

    public final String getPercent_change_week() {
        return this.percent_change_week;
    }

    public final String getPercent_change_year() {
        return this.percent_change_year;
    }

    public final TimestampedScaledAmount getPrice() {
        return this.price;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            TimestampedScaledAmount timestampedScaledAmount = this.price;
            int hashCode2 = ((((((((((hashCode + (timestampedScaledAmount != null ? timestampedScaledAmount.hashCode() : 0)) * 37) + this.percent_change_hour.hashCode()) * 37) + this.percent_change_day.hashCode()) * 37) + this.percent_change_week.hashCode()) * 37) + this.percent_change_month.hashCode()) * 37) + this.percent_change_year.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m544newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.price != null) {
            arrayList.add("price=" + this.price);
        }
        arrayList.add("percent_change_hour=" + b.c(this.percent_change_hour));
        arrayList.add("percent_change_day=" + b.c(this.percent_change_day));
        arrayList.add("percent_change_week=" + b.c(this.percent_change_week));
        arrayList.add("percent_change_month=" + b.c(this.percent_change_month));
        arrayList.add("percent_change_year=" + b.c(this.percent_change_year));
        h0 = z.h0(arrayList, ", ", "LatestPriceInfo{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LatestPriceInfo(TimestampedScaledAmount timestampedScaledAmount, String percent_change_hour, String percent_change_day, String percent_change_week, String percent_change_month, String percent_change_year, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(percent_change_hour, "percent_change_hour");
        m.h(percent_change_day, "percent_change_day");
        m.h(percent_change_week, "percent_change_week");
        m.h(percent_change_month, "percent_change_month");
        m.h(percent_change_year, "percent_change_year");
        m.h(unknownFields, "unknownFields");
        this.price = timestampedScaledAmount;
        this.percent_change_hour = percent_change_hour;
        this.percent_change_day = percent_change_day;
        this.percent_change_week = percent_change_week;
        this.percent_change_month = percent_change_month;
        this.percent_change_year = percent_change_year;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m544newBuilder() {
        throw new AssertionError();
    }
}