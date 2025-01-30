package com.coinbase.android.apiv3.generated.authed.portfolio_performance;

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

/* compiled from: Costs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&Bq\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJw\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b \u0010\u001eR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b!\u0010\u001eR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b#\u0010\u001e¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Cost;", "hour", "day", "week", "month", "year", "all", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;", "Ljava/util/List;", "getYear", "()Ljava/util/List;", "getAll", "getHour", "getDay", "getWeek", "getMonth", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Costs extends a {
    public static final ProtoAdapter<Costs> ADAPTER;
    public static final Parcelable.Creator<Costs> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Cost#ADAPTER", label = p.a.REPEATED, tag = 6)
    private final List<Cost> all;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Cost#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<Cost> day;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Cost#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<Cost> hour;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Cost#ADAPTER", label = p.a.REPEATED, tag = 4)
    private final List<Cost> month;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Cost#ADAPTER", label = p.a.REPEATED, tag = 3)
    private final List<Cost> week;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Cost#ADAPTER", label = p.a.REPEATED, tag = 5)
    private final List<Cost> year;

    /* compiled from: Costs.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Costs> protoAdapter = new ProtoAdapter<Costs>(c.LENGTH_DELIMITED, e0.b(Costs.class), "type.googleapis.com/coinbase.public_api.authed.portfolio_performance.Costs") { // from class: com.coinbase.android.apiv3.generated.authed.portfolio_performance.Costs$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Costs decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Costs(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            arrayList.add(Cost.ADAPTER.decode(reader));
                            break;
                        case 2:
                            arrayList2.add(Cost.ADAPTER.decode(reader));
                            break;
                        case 3:
                            arrayList3.add(Cost.ADAPTER.decode(reader));
                            break;
                        case 4:
                            arrayList4.add(Cost.ADAPTER.decode(reader));
                            break;
                        case 5:
                            arrayList5.add(Cost.ADAPTER.decode(reader));
                            break;
                        case 6:
                            arrayList6.add(Cost.ADAPTER.decode(reader));
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Costs value) {
                m.h(writer, "writer");
                m.h(value, "value");
                ProtoAdapter<Cost> protoAdapter2 = Cost.ADAPTER;
                protoAdapter2.asRepeated().encodeWithTag(writer, 1, value.getHour());
                protoAdapter2.asRepeated().encodeWithTag(writer, 2, value.getDay());
                protoAdapter2.asRepeated().encodeWithTag(writer, 3, value.getWeek());
                protoAdapter2.asRepeated().encodeWithTag(writer, 4, value.getMonth());
                protoAdapter2.asRepeated().encodeWithTag(writer, 5, value.getYear());
                protoAdapter2.asRepeated().encodeWithTag(writer, 6, value.getAll());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Costs value) {
                m.h(value, "value");
                ProtoAdapter<Cost> protoAdapter2 = Cost.ADAPTER;
                return protoAdapter2.asRepeated().encodedSizeWithTag(1, value.getHour()) + protoAdapter2.asRepeated().encodedSizeWithTag(2, value.getDay()) + protoAdapter2.asRepeated().encodedSizeWithTag(3, value.getWeek()) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.getMonth()) + protoAdapter2.asRepeated().encodedSizeWithTag(5, value.getYear()) + protoAdapter2.asRepeated().encodedSizeWithTag(6, value.getAll()) + value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Costs redact(Costs value) {
                m.h(value, "value");
                List<Cost> hour = value.getHour();
                ProtoAdapter<Cost> protoAdapter2 = Cost.ADAPTER;
                return value.copy(b.a(hour, protoAdapter2), b.a(value.getDay(), protoAdapter2), b.a(value.getWeek(), protoAdapter2), b.a(value.getMonth(), protoAdapter2), b.a(value.getYear(), protoAdapter2), b.a(value.getAll(), protoAdapter2), i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Costs() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ Costs(List list, List list2, List list3, List list4, List list5, List list6, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? r.g() : list2, (i2 & 4) != 0 ? r.g() : list3, (i2 & 8) != 0 ? r.g() : list4, (i2 & 16) != 0 ? r.g() : list5, (i2 & 32) != 0 ? r.g() : list6, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Costs copy$default(Costs costs, List list, List list2, List list3, List list4, List list5, List list6, i iVar, int i2, Object obj) {
        List<Cost> list7 = list;
        if ((i2 & 1) != 0) {
            list7 = costs.hour;
        }
        List<Cost> list8 = list2;
        if ((i2 & 2) != 0) {
            list8 = costs.day;
        }
        List list9 = list8;
        List<Cost> list10 = list3;
        if ((i2 & 4) != 0) {
            list10 = costs.week;
        }
        List list11 = list10;
        List<Cost> list12 = list4;
        if ((i2 & 8) != 0) {
            list12 = costs.month;
        }
        List list13 = list12;
        List<Cost> list14 = list5;
        if ((i2 & 16) != 0) {
            list14 = costs.year;
        }
        List list15 = list14;
        List<Cost> list16 = list6;
        if ((i2 & 32) != 0) {
            list16 = costs.all;
        }
        List list17 = list16;
        if ((i2 & 64) != 0) {
            iVar = costs.unknownFields();
        }
        return costs.copy(list7, list9, list11, list13, list15, list17, iVar);
    }

    public final Costs copy(List<Cost> hour, List<Cost> day, List<Cost> week, List<Cost> month, List<Cost> year, List<Cost> all, i unknownFields) {
        m.h(hour, "hour");
        m.h(day, "day");
        m.h(week, "week");
        m.h(month, "month");
        m.h(year, "year");
        m.h(all, "all");
        m.h(unknownFields, "unknownFields");
        return new Costs(hour, day, week, month, year, all, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Costs) {
            Costs costs = (Costs) obj;
            return m.c(unknownFields(), costs.unknownFields()) && m.c(this.hour, costs.hour) && m.c(this.day, costs.day) && m.c(this.week, costs.week) && m.c(this.month, costs.month) && m.c(this.year, costs.year) && m.c(this.all, costs.all);
        }
        return false;
    }

    public final List<Cost> getAll() {
        return this.all;
    }

    public final List<Cost> getDay() {
        return this.day;
    }

    public final List<Cost> getHour() {
        return this.hour;
    }

    public final List<Cost> getMonth() {
        return this.month;
    }

    public final List<Cost> getWeek() {
        return this.week;
    }

    public final List<Cost> getYear() {
        return this.year;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.hour.hashCode()) * 37) + this.day.hashCode()) * 37) + this.week.hashCode()) * 37) + this.month.hashCode()) * 37) + this.year.hashCode()) * 37) + this.all.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m447newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.hour.isEmpty()) {
            arrayList.add("hour=" + this.hour);
        }
        if (!this.day.isEmpty()) {
            arrayList.add("day=" + this.day);
        }
        if (!this.week.isEmpty()) {
            arrayList.add("week=" + this.week);
        }
        if (!this.month.isEmpty()) {
            arrayList.add("month=" + this.month);
        }
        if (!this.year.isEmpty()) {
            arrayList.add("year=" + this.year);
        }
        if (!this.all.isEmpty()) {
            arrayList.add("all=" + this.all);
        }
        h0 = z.h0(arrayList, ", ", "Costs{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m447newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Costs(List<Cost> hour, List<Cost> day, List<Cost> week, List<Cost> month, List<Cost> year, List<Cost> all, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(hour, "hour");
        m.h(day, "day");
        m.h(week, "week");
        m.h(month, "month");
        m.h(year, "year");
        m.h(all, "all");
        m.h(unknownFields, "unknownFields");
        this.hour = hour;
        this.day = day;
        this.week = week;
        this.month = month;
        this.year = year;
        this.all = all;
    }
}