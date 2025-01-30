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

/* compiled from: Values.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B{\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0081\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b \u0010\u001fR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u000fR\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b$\u0010\u001fR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b%\u0010\u001fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b&\u0010\u001f¨\u0006*"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "latest", "", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Value;", "hour", "day", "week", "month", "year", "all", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;", "Ljava/util/List;", "getHour", "()Ljava/util/List;", "getDay", "getYear", "Ljava/lang/String;", "getLatest", "getAll", "getWeek", "getMonth", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Values extends a {
    public static final ProtoAdapter<Values> ADAPTER;
    public static final Parcelable.Creator<Values> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Value#ADAPTER", label = p.a.REPEATED, tag = 7)
    private final List<Value> all;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Value#ADAPTER", label = p.a.REPEATED, tag = 3)
    private final List<Value> day;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Value#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<Value> hour;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String latest;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Value#ADAPTER", label = p.a.REPEATED, tag = 5)
    private final List<Value> month;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Value#ADAPTER", label = p.a.REPEATED, tag = 4)
    private final List<Value> week;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Value#ADAPTER", label = p.a.REPEATED, tag = 6)
    private final List<Value> year;

    /* compiled from: Values.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Values> protoAdapter = new ProtoAdapter<Values>(c.LENGTH_DELIMITED, e0.b(Values.class), "type.googleapis.com/coinbase.public_api.authed.portfolio_performance.Values") { // from class: com.coinbase.android.apiv3.generated.authed.portfolio_performance.Values$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Values decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Values(str, arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            arrayList.add(Value.ADAPTER.decode(reader));
                            break;
                        case 3:
                            arrayList2.add(Value.ADAPTER.decode(reader));
                            break;
                        case 4:
                            arrayList3.add(Value.ADAPTER.decode(reader));
                            break;
                        case 5:
                            arrayList4.add(Value.ADAPTER.decode(reader));
                            break;
                        case 6:
                            arrayList5.add(Value.ADAPTER.decode(reader));
                            break;
                        case 7:
                            arrayList6.add(Value.ADAPTER.decode(reader));
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Values value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getLatest(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getLatest());
                }
                ProtoAdapter<Value> protoAdapter2 = Value.ADAPTER;
                protoAdapter2.asRepeated().encodeWithTag(writer, 2, value.getHour());
                protoAdapter2.asRepeated().encodeWithTag(writer, 3, value.getDay());
                protoAdapter2.asRepeated().encodeWithTag(writer, 4, value.getWeek());
                protoAdapter2.asRepeated().encodeWithTag(writer, 5, value.getMonth());
                protoAdapter2.asRepeated().encodeWithTag(writer, 6, value.getYear());
                protoAdapter2.asRepeated().encodeWithTag(writer, 7, value.getAll());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Values value) {
                m.h(value, "value");
                if (m.c(value.getLatest(), "")) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, value.getLatest());
                ProtoAdapter<Value> protoAdapter2 = Value.ADAPTER;
                return value.unknownFields().Q() + encodedSizeWithTag + protoAdapter2.asRepeated().encodedSizeWithTag(2, value.getHour()) + protoAdapter2.asRepeated().encodedSizeWithTag(3, value.getDay()) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.getWeek()) + protoAdapter2.asRepeated().encodedSizeWithTag(5, value.getMonth()) + protoAdapter2.asRepeated().encodedSizeWithTag(6, value.getYear()) + protoAdapter2.asRepeated().encodedSizeWithTag(7, value.getAll());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Values redact(Values value) {
                m.h(value, "value");
                List<Value> hour = value.getHour();
                ProtoAdapter<Value> protoAdapter2 = Value.ADAPTER;
                return Values.copy$default(value, null, b.a(hour, protoAdapter2), b.a(value.getDay(), protoAdapter2), b.a(value.getWeek(), protoAdapter2), b.a(value.getMonth(), protoAdapter2), b.a(value.getYear(), protoAdapter2), b.a(value.getAll(), protoAdapter2), i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Values() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ Values(String str, List list, List list2, List list3, List list4, List list5, List list6, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? r.g() : list2, (i2 & 8) != 0 ? r.g() : list3, (i2 & 16) != 0 ? r.g() : list4, (i2 & 32) != 0 ? r.g() : list5, (i2 & 64) != 0 ? r.g() : list6, (i2 & 128) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Values copy$default(Values values, String str, List list, List list2, List list3, List list4, List list5, List list6, i iVar, int i2, Object obj) {
        return values.copy((i2 & 1) != 0 ? values.latest : str, (i2 & 2) != 0 ? values.hour : list, (i2 & 4) != 0 ? values.day : list2, (i2 & 8) != 0 ? values.week : list3, (i2 & 16) != 0 ? values.month : list4, (i2 & 32) != 0 ? values.year : list5, (i2 & 64) != 0 ? values.all : list6, (i2 & 128) != 0 ? values.unknownFields() : iVar);
    }

    public final Values copy(String latest, List<Value> hour, List<Value> day, List<Value> week, List<Value> month, List<Value> year, List<Value> all, i unknownFields) {
        m.h(latest, "latest");
        m.h(hour, "hour");
        m.h(day, "day");
        m.h(week, "week");
        m.h(month, "month");
        m.h(year, "year");
        m.h(all, "all");
        m.h(unknownFields, "unknownFields");
        return new Values(latest, hour, day, week, month, year, all, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Values) {
            Values values = (Values) obj;
            return m.c(unknownFields(), values.unknownFields()) && m.c(this.latest, values.latest) && m.c(this.hour, values.hour) && m.c(this.day, values.day) && m.c(this.week, values.week) && m.c(this.month, values.month) && m.c(this.year, values.year) && m.c(this.all, values.all);
        }
        return false;
    }

    public final List<Value> getAll() {
        return this.all;
    }

    public final List<Value> getDay() {
        return this.day;
    }

    public final List<Value> getHour() {
        return this.hour;
    }

    public final String getLatest() {
        return this.latest;
    }

    public final List<Value> getMonth() {
        return this.month;
    }

    public final List<Value> getWeek() {
        return this.week;
    }

    public final List<Value> getYear() {
        return this.year;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((((unknownFields().hashCode() * 37) + this.latest.hashCode()) * 37) + this.hour.hashCode()) * 37) + this.day.hashCode()) * 37) + this.week.hashCode()) * 37) + this.month.hashCode()) * 37) + this.year.hashCode()) * 37) + this.all.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m453newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("latest=" + b.c(this.latest));
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
        h0 = z.h0(arrayList, ", ", "Values{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m453newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Values(String latest, List<Value> hour, List<Value> day, List<Value> week, List<Value> month, List<Value> year, List<Value> all, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(latest, "latest");
        m.h(hour, "hour");
        m.h(day, "day");
        m.h(week, "week");
        m.h(month, "month");
        m.h(year, "year");
        m.h(all, "all");
        m.h(unknownFields, "unknownFields");
        this.latest = latest;
        this.hour = hour;
        this.day = day;
        this.week = week;
        this.month = month;
        this.year = year;
        this.all = all;
    }
}