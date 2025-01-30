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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: PercentChange.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BM\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJS\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b \u0010\u000f¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "hour", "day", "week", "month", "year", "all", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "Ljava/lang/String;", "getYear", "getAll", "getDay", "getWeek", "getMonth", "getHour", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PercentChange extends a {
    public static final ProtoAdapter<PercentChange> ADAPTER;
    public static final Parcelable.Creator<PercentChange> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String all;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String day;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String hour;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String month;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String week;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String year;

    /* compiled from: PercentChange.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PercentChange$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PercentChange> protoAdapter = new ProtoAdapter<PercentChange>(c.LENGTH_DELIMITED, e0.b(PercentChange.class), "type.googleapis.com/coinbase.public_api.common.PercentChange") { // from class: com.coinbase.android.apiv3.generated.common.PercentChange$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PercentChange decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PercentChange(str, str2, str3, str4, str5, str6, reader.e(d2));
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
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PercentChange value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getHour(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getHour());
                }
                if (!m.c(value.getDay(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDay());
                }
                if (!m.c(value.getWeek(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getWeek());
                }
                if (!m.c(value.getMonth(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getMonth());
                }
                if (!m.c(value.getYear(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getYear());
                }
                if (!m.c(value.getAll(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getAll());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PercentChange value) {
                m.h(value, "value");
                if (m.c(value.getHour(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getHour());
                if (!m.c(value.getDay(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getDay());
                    if (!m.c(value.getWeek(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getWeek());
                        if (!m.c(value.getMonth(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getMonth());
                            if (!m.c(value.getYear(), "")) {
                                r2 = (m.c(value.getAll(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getAll()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(5, value.getYear());
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
            public PercentChange redact(PercentChange value) {
                m.h(value, "value");
                return PercentChange.copy$default(value, null, null, null, null, null, null, i.a, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PercentChange() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ PercentChange(String str, String str2, String str3, String str4, String str5, String str6, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) == 0 ? str6 : "", (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PercentChange copy$default(PercentChange percentChange, String str, String str2, String str3, String str4, String str5, String str6, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = percentChange.hour;
        }
        if ((i2 & 2) != 0) {
            str2 = percentChange.day;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = percentChange.week;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = percentChange.month;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = percentChange.year;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = percentChange.all;
        }
        String str11 = str6;
        if ((i2 & 64) != 0) {
            iVar = percentChange.unknownFields();
        }
        return percentChange.copy(str, str7, str8, str9, str10, str11, iVar);
    }

    public final PercentChange copy(String hour, String day, String week, String month, String year, String all, i unknownFields) {
        m.h(hour, "hour");
        m.h(day, "day");
        m.h(week, "week");
        m.h(month, "month");
        m.h(year, "year");
        m.h(all, "all");
        m.h(unknownFields, "unknownFields");
        return new PercentChange(hour, day, week, month, year, all, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PercentChange) {
            PercentChange percentChange = (PercentChange) obj;
            return m.c(unknownFields(), percentChange.unknownFields()) && m.c(this.hour, percentChange.hour) && m.c(this.day, percentChange.day) && m.c(this.week, percentChange.week) && m.c(this.month, percentChange.month) && m.c(this.year, percentChange.year) && m.c(this.all, percentChange.all);
        }
        return false;
    }

    public final String getAll() {
        return this.all;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getHour() {
        return this.hour;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getWeek() {
        return this.week;
    }

    public final String getYear() {
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
        return (g.a) m513newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("hour=" + b.c(this.hour));
        arrayList.add("day=" + b.c(this.day));
        arrayList.add("week=" + b.c(this.week));
        arrayList.add("month=" + b.c(this.month));
        arrayList.add("year=" + b.c(this.year));
        arrayList.add("all=" + b.c(this.all));
        h0 = z.h0(arrayList, ", ", "PercentChange{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PercentChange(String hour, String day, String week, String month, String year, String all, i unknownFields) {
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

    /* renamed from: newBuilder */
    public /* synthetic */ Void m513newBuilder() {
        throw new AssertionError();
    }
}