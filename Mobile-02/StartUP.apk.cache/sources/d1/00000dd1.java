package com.coinbase.android.apiv3.generated.authed.portfolio_performance;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: Gains.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%BY\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ_\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\"\u0010\u001d¨\u0006&"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;", "hour", "day", "week", "month", "year", "all", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;", "getDay", "()Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;", "getMonth", "getWeek", "getHour", "getYear", "getAll", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gain;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Gains extends a {
    public static final ProtoAdapter<Gains> ADAPTER;
    public static final Parcelable.Creator<Gains> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gain#ADAPTER", tag = 6)
    private final Gain all;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gain#ADAPTER", tag = 2)
    private final Gain day;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gain#ADAPTER", tag = 1)
    private final Gain hour;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gain#ADAPTER", tag = 4)
    private final Gain month;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gain#ADAPTER", tag = 3)
    private final Gain week;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gain#ADAPTER", tag = 5)
    private final Gain year;

    /* compiled from: Gains.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Gains> protoAdapter = new ProtoAdapter<Gains>(c.LENGTH_DELIMITED, e0.b(Gains.class), "type.googleapis.com/coinbase.public_api.authed.portfolio_performance.Gains") { // from class: com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gains$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Gains decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Gain gain = null;
                Gain gain2 = null;
                Gain gain3 = null;
                Gain gain4 = null;
                Gain gain5 = null;
                Gain gain6 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Gains(gain, gain2, gain3, gain4, gain5, gain6, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            gain = Gain.ADAPTER.decode(reader);
                            break;
                        case 2:
                            gain2 = Gain.ADAPTER.decode(reader);
                            break;
                        case 3:
                            gain3 = Gain.ADAPTER.decode(reader);
                            break;
                        case 4:
                            gain4 = Gain.ADAPTER.decode(reader);
                            break;
                        case 5:
                            gain5 = Gain.ADAPTER.decode(reader);
                            break;
                        case 6:
                            gain6 = Gain.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Gains value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getHour() != null) {
                    Gain.ADAPTER.encodeWithTag(writer, 1, value.getHour());
                }
                if (value.getDay() != null) {
                    Gain.ADAPTER.encodeWithTag(writer, 2, value.getDay());
                }
                if (value.getWeek() != null) {
                    Gain.ADAPTER.encodeWithTag(writer, 3, value.getWeek());
                }
                if (value.getMonth() != null) {
                    Gain.ADAPTER.encodeWithTag(writer, 4, value.getMonth());
                }
                if (value.getYear() != null) {
                    Gain.ADAPTER.encodeWithTag(writer, 5, value.getYear());
                }
                if (value.getAll() != null) {
                    Gain.ADAPTER.encodeWithTag(writer, 6, value.getAll());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Gains value) {
                m.h(value, "value");
                if (value.getHour() == null) {
                    return 0;
                }
                ProtoAdapter<Gain> protoAdapter2 = Gain.ADAPTER;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getHour());
                if (value.getDay() != null) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getDay());
                    if (value.getWeek() != null) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getWeek());
                        if (value.getMonth() != null) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getMonth());
                            if (value.getYear() != null) {
                                r1 = (value.getAll() != null ? protoAdapter2.encodedSizeWithTag(6, value.getAll()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(5, value.getYear());
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
            public Gains redact(Gains value) {
                m.h(value, "value");
                Gain hour = value.getHour();
                Gain redact = hour != null ? Gain.ADAPTER.redact(hour) : null;
                Gain day = value.getDay();
                Gain redact2 = day != null ? Gain.ADAPTER.redact(day) : null;
                Gain week = value.getWeek();
                Gain redact3 = week != null ? Gain.ADAPTER.redact(week) : null;
                Gain month = value.getMonth();
                Gain redact4 = month != null ? Gain.ADAPTER.redact(month) : null;
                Gain year = value.getYear();
                Gain redact5 = year != null ? Gain.ADAPTER.redact(year) : null;
                Gain all = value.getAll();
                return value.copy(redact, redact2, redact3, redact4, redact5, all != null ? Gain.ADAPTER.redact(all) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Gains() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ Gains(Gain gain, Gain gain2, Gain gain3, Gain gain4, Gain gain5, Gain gain6, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : gain, (i2 & 2) != 0 ? null : gain2, (i2 & 4) != 0 ? null : gain3, (i2 & 8) != 0 ? null : gain4, (i2 & 16) != 0 ? null : gain5, (i2 & 32) == 0 ? gain6 : null, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Gains copy$default(Gains gains, Gain gain, Gain gain2, Gain gain3, Gain gain4, Gain gain5, Gain gain6, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gain = gains.hour;
        }
        if ((i2 & 2) != 0) {
            gain2 = gains.day;
        }
        Gain gain7 = gain2;
        if ((i2 & 4) != 0) {
            gain3 = gains.week;
        }
        Gain gain8 = gain3;
        if ((i2 & 8) != 0) {
            gain4 = gains.month;
        }
        Gain gain9 = gain4;
        if ((i2 & 16) != 0) {
            gain5 = gains.year;
        }
        Gain gain10 = gain5;
        if ((i2 & 32) != 0) {
            gain6 = gains.all;
        }
        Gain gain11 = gain6;
        if ((i2 & 64) != 0) {
            iVar = gains.unknownFields();
        }
        return gains.copy(gain, gain7, gain8, gain9, gain10, gain11, iVar);
    }

    public final Gains copy(Gain gain, Gain gain2, Gain gain3, Gain gain4, Gain gain5, Gain gain6, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new Gains(gain, gain2, gain3, gain4, gain5, gain6, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Gains) {
            Gains gains = (Gains) obj;
            return m.c(unknownFields(), gains.unknownFields()) && m.c(this.hour, gains.hour) && m.c(this.day, gains.day) && m.c(this.week, gains.week) && m.c(this.month, gains.month) && m.c(this.year, gains.year) && m.c(this.all, gains.all);
        }
        return false;
    }

    public final Gain getAll() {
        return this.all;
    }

    public final Gain getDay() {
        return this.day;
    }

    public final Gain getHour() {
        return this.hour;
    }

    public final Gain getMonth() {
        return this.month;
    }

    public final Gain getWeek() {
        return this.week;
    }

    public final Gain getYear() {
        return this.year;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Gain gain = this.hour;
            int hashCode2 = (hashCode + (gain != null ? gain.hashCode() : 0)) * 37;
            Gain gain2 = this.day;
            int hashCode3 = (hashCode2 + (gain2 != null ? gain2.hashCode() : 0)) * 37;
            Gain gain3 = this.week;
            int hashCode4 = (hashCode3 + (gain3 != null ? gain3.hashCode() : 0)) * 37;
            Gain gain4 = this.month;
            int hashCode5 = (hashCode4 + (gain4 != null ? gain4.hashCode() : 0)) * 37;
            Gain gain5 = this.year;
            int hashCode6 = (hashCode5 + (gain5 != null ? gain5.hashCode() : 0)) * 37;
            Gain gain6 = this.all;
            int hashCode7 = hashCode6 + (gain6 != null ? gain6.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m449newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.hour != null) {
            arrayList.add("hour=" + this.hour);
        }
        if (this.day != null) {
            arrayList.add("day=" + this.day);
        }
        if (this.week != null) {
            arrayList.add("week=" + this.week);
        }
        if (this.month != null) {
            arrayList.add("month=" + this.month);
        }
        if (this.year != null) {
            arrayList.add("year=" + this.year);
        }
        if (this.all != null) {
            arrayList.add("all=" + this.all);
        }
        h0 = z.h0(arrayList, ", ", "Gains{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Gains(Gain gain, Gain gain2, Gain gain3, Gain gain4, Gain gain5, Gain gain6, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.hour = gain;
        this.day = gain2;
        this.week = gain3;
        this.month = gain4;
        this.year = gain5;
        this.all = gain6;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m449newBuilder() {
        throw new AssertionError();
    }
}