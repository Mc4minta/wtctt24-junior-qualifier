package com.coinbase.android.apiv3.generated.common;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: PriceChartData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B5\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u000f¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PriceChartData;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Period;", "period", "percent_change", "", "Lcom/coinbase/android/apiv3/generated/common/PricePoint;", "price_points", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Period;Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/PriceChartData;", "Ljava/util/List;", "getPrice_points", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/common/Period;", "getPeriod", "()Lcom/coinbase/android/apiv3/generated/common/Period;", "Ljava/lang/String;", "getPercent_change", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Period;Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PriceChartData extends a {
    public static final ProtoAdapter<PriceChartData> ADAPTER;
    public static final Parcelable.Creator<PriceChartData> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "percentChange", tag = 2)
    private final String percent_change;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Period#ADAPTER", tag = 1)
    private final Period period;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PricePoint#ADAPTER", jsonName = "pricePoints", label = p.a.REPEATED, tag = 3)
    private final List<PricePoint> price_points;

    /* compiled from: PriceChartData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PriceChartData$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/PriceChartData;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PriceChartData> protoAdapter = new ProtoAdapter<PriceChartData>(c.LENGTH_DELIMITED, e0.b(PriceChartData.class), "type.googleapis.com/coinbase.public_api.common.PriceChartData") { // from class: com.coinbase.android.apiv3.generated.common.PriceChartData$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PriceChartData decode(k reader) {
                Period period;
                ProtoAdapter.EnumConstantNotFoundException e2;
                m.h(reader, "reader");
                Period period2 = Period.ALL;
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PriceChartData(period2, str, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            period = Period.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                            period = period2;
                            e2 = e3;
                        }
                        try {
                            x xVar = x.a;
                        } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                            e2 = e4;
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                            x xVar2 = x.a;
                            period2 = period;
                        }
                        period2 = period;
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        arrayList.add(PricePoint.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PriceChartData value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getPeriod() != Period.ALL) {
                    Period.ADAPTER.encodeWithTag(writer, 1, value.getPeriod());
                }
                if (!m.c(value.getPercent_change(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPercent_change());
                }
                PricePoint.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getPrice_points());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PriceChartData value) {
                m.h(value, "value");
                if (value.getPeriod() == Period.ALL) {
                    return 0;
                }
                return (m.c(value.getPercent_change(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getPercent_change()) + PricePoint.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getPrice_points()) + value.unknownFields().Q()) + Period.ADAPTER.encodedSizeWithTag(1, value.getPeriod());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PriceChartData redact(PriceChartData value) {
                m.h(value, "value");
                return PriceChartData.copy$default(value, null, null, b.a(value.getPrice_points(), PricePoint.ADAPTER), i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PriceChartData() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ PriceChartData(Period period, String str, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Period.ALL : period, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? r.g() : list, (i2 & 8) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PriceChartData copy$default(PriceChartData priceChartData, Period period, String str, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            period = priceChartData.period;
        }
        if ((i2 & 2) != 0) {
            str = priceChartData.percent_change;
        }
        if ((i2 & 4) != 0) {
            list = priceChartData.price_points;
        }
        if ((i2 & 8) != 0) {
            iVar = priceChartData.unknownFields();
        }
        return priceChartData.copy(period, str, list, iVar);
    }

    public final PriceChartData copy(Period period, String percent_change, List<PricePoint> price_points, i unknownFields) {
        m.h(period, "period");
        m.h(percent_change, "percent_change");
        m.h(price_points, "price_points");
        m.h(unknownFields, "unknownFields");
        return new PriceChartData(period, percent_change, price_points, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PriceChartData) {
            PriceChartData priceChartData = (PriceChartData) obj;
            return m.c(unknownFields(), priceChartData.unknownFields()) && this.period == priceChartData.period && m.c(this.percent_change, priceChartData.percent_change) && m.c(this.price_points, priceChartData.price_points);
        }
        return false;
    }

    public final String getPercent_change() {
        return this.percent_change;
    }

    public final Period getPeriod() {
        return this.period;
    }

    public final List<PricePoint> getPrice_points() {
        return this.price_points;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.period.hashCode()) * 37) + this.percent_change.hashCode()) * 37) + this.price_points.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m514newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("period=" + this.period);
        arrayList.add("percent_change=" + b.c(this.percent_change));
        if (!this.price_points.isEmpty()) {
            arrayList.add("price_points=" + this.price_points);
        }
        h0 = z.h0(arrayList, ", ", "PriceChartData{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m514newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceChartData(Period period, String percent_change, List<PricePoint> price_points, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(period, "period");
        m.h(percent_change, "percent_change");
        m.h(price_points, "price_points");
        m.h(unknownFields, "unknownFields");
        this.period = period;
        this.percent_change = percent_change;
        this.price_points = price_points;
    }
}