package com.coinbase.android.apiv3.generated.unauthed;

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

/* compiled from: Stats.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/Stats;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "market_cap", "circulating_supply", "volume_24h", "all_time_high", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/Stats;", "Ljava/lang/String;", "getCirculating_supply", "getMarket_cap", "getAll_time_high", "getVolume_24h", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Stats extends a {
    public static final ProtoAdapter<Stats> ADAPTER;
    public static final Parcelable.Creator<Stats> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "allTimeHigh", tag = 4)
    private final String all_time_high;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "circulatingSupply", tag = 2)
    private final String circulating_supply;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "marketCap", tag = 1)
    private final String market_cap;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "volume24h", tag = 3)
    private final String volume_24h;

    /* compiled from: Stats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/Stats$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/Stats;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Stats> protoAdapter = new ProtoAdapter<Stats>(c.LENGTH_DELIMITED, e0.b(Stats.class), "type.googleapis.com/coinbase.public_api.unauthed.Stats") { // from class: com.coinbase.android.apiv3.generated.unauthed.Stats$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Stats decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Stats(str, str2, str3, str4, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        str4 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Stats value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getMarket_cap(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getMarket_cap());
                }
                if (!m.c(value.getCirculating_supply(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getCirculating_supply());
                }
                if (!m.c(value.getVolume_24h(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getVolume_24h());
                }
                if (!m.c(value.getAll_time_high(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getAll_time_high());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Stats value) {
                m.h(value, "value");
                if (m.c(value.getMarket_cap(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getMarket_cap());
                if (!m.c(value.getCirculating_supply(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getCirculating_supply());
                    if (!m.c(value.getVolume_24h(), "")) {
                        r2 = (m.c(value.getAll_time_high(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getAll_time_high()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(3, value.getVolume_24h());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Stats redact(Stats value) {
                m.h(value, "value");
                return Stats.copy$default(value, null, null, null, null, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Stats() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ Stats(String str, String str2, String str3, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Stats copy$default(Stats stats, String str, String str2, String str3, String str4, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stats.market_cap;
        }
        if ((i2 & 2) != 0) {
            str2 = stats.circulating_supply;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = stats.volume_24h;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = stats.all_time_high;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            iVar = stats.unknownFields();
        }
        return stats.copy(str, str5, str6, str7, iVar);
    }

    public final Stats copy(String market_cap, String circulating_supply, String volume_24h, String all_time_high, i unknownFields) {
        m.h(market_cap, "market_cap");
        m.h(circulating_supply, "circulating_supply");
        m.h(volume_24h, "volume_24h");
        m.h(all_time_high, "all_time_high");
        m.h(unknownFields, "unknownFields");
        return new Stats(market_cap, circulating_supply, volume_24h, all_time_high, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Stats) {
            Stats stats = (Stats) obj;
            return m.c(unknownFields(), stats.unknownFields()) && m.c(this.market_cap, stats.market_cap) && m.c(this.circulating_supply, stats.circulating_supply) && m.c(this.volume_24h, stats.volume_24h) && m.c(this.all_time_high, stats.all_time_high);
        }
        return false;
    }

    public final String getAll_time_high() {
        return this.all_time_high;
    }

    public final String getCirculating_supply() {
        return this.circulating_supply;
    }

    public final String getMarket_cap() {
        return this.market_cap;
    }

    public final String getVolume_24h() {
        return this.volume_24h;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.market_cap.hashCode()) * 37) + this.circulating_supply.hashCode()) * 37) + this.volume_24h.hashCode()) * 37) + this.all_time_high.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m549newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("market_cap=" + b.c(this.market_cap));
        arrayList.add("circulating_supply=" + b.c(this.circulating_supply));
        arrayList.add("volume_24h=" + b.c(this.volume_24h));
        arrayList.add("all_time_high=" + b.c(this.all_time_high));
        h0 = z.h0(arrayList, ", ", "Stats{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Stats(String market_cap, String circulating_supply, String volume_24h, String all_time_high, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(market_cap, "market_cap");
        m.h(circulating_supply, "circulating_supply");
        m.h(volume_24h, "volume_24h");
        m.h(all_time_high, "all_time_high");
        m.h(unknownFields, "unknownFields");
        this.market_cap = market_cap;
        this.circulating_supply = circulating_supply;
        this.volume_24h = volume_24h;
        this.all_time_high = all_time_high;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m549newBuilder() {
        throw new AssertionError();
    }
}