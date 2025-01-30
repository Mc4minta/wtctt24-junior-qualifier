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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: CalculateResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B?\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\u000f¨\u0006)"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/CalculateResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "latest_value", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;", "values", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;", "costs", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;", "gains", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/CalculateResponse;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;", "getCosts", "()Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;", "getValues", "()Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;", "getGains", "()Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;", "Ljava/lang/String;", "getLatest_value", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Values;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Costs;Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/Gains;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CalculateResponse extends a {
    public static final ProtoAdapter<CalculateResponse> ADAPTER;
    public static final Parcelable.Creator<CalculateResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Costs#ADAPTER", tag = 3)
    private final Costs costs;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Gains#ADAPTER", tag = 4)
    private final Gains gains;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "latestValue", tag = 1)
    private final String latest_value;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.portfolio_performance.Values#ADAPTER", tag = 2)
    private final Values values;

    /* compiled from: CalculateResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/CalculateResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/CalculateResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<CalculateResponse> protoAdapter = new ProtoAdapter<CalculateResponse>(c.LENGTH_DELIMITED, e0.b(CalculateResponse.class), "type.googleapis.com/coinbase.public_api.authed.portfolio_performance.CalculateResponse") { // from class: com.coinbase.android.apiv3.generated.authed.portfolio_performance.CalculateResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CalculateResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Values values = null;
                Costs costs = null;
                Gains gains = null;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CalculateResponse(str, values, costs, gains, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        values = Values.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        costs = Costs.ADAPTER.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        gains = Gains.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CalculateResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getLatest_value(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getLatest_value());
                }
                if (value.getValues() != null) {
                    Values.ADAPTER.encodeWithTag(writer, 2, value.getValues());
                }
                if (value.getCosts() != null) {
                    Costs.ADAPTER.encodeWithTag(writer, 3, value.getCosts());
                }
                if (value.getGains() != null) {
                    Gains.ADAPTER.encodeWithTag(writer, 4, value.getGains());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CalculateResponse value) {
                m.h(value, "value");
                if (m.c(value.getLatest_value(), "")) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, value.getLatest_value());
                if (value.getValues() != null) {
                    int encodedSizeWithTag2 = Values.ADAPTER.encodedSizeWithTag(2, value.getValues());
                    if (value.getCosts() != null) {
                        r1 = (value.getGains() != null ? Gains.ADAPTER.encodedSizeWithTag(4, value.getGains()) + value.unknownFields().Q() : 0) + Costs.ADAPTER.encodedSizeWithTag(3, value.getCosts());
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CalculateResponse redact(CalculateResponse value) {
                m.h(value, "value");
                Values values = value.getValues();
                Values redact = values != null ? Values.ADAPTER.redact(values) : null;
                Costs costs = value.getCosts();
                Costs redact2 = costs != null ? Costs.ADAPTER.redact(costs) : null;
                Gains gains = value.getGains();
                return CalculateResponse.copy$default(value, null, redact, redact2, gains != null ? Gains.ADAPTER.redact(gains) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CalculateResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ CalculateResponse(String str, Values values, Costs costs, Gains gains, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : values, (i2 & 4) != 0 ? null : costs, (i2 & 8) == 0 ? gains : null, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ CalculateResponse copy$default(CalculateResponse calculateResponse, String str, Values values, Costs costs, Gains gains, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = calculateResponse.latest_value;
        }
        if ((i2 & 2) != 0) {
            values = calculateResponse.values;
        }
        Values values2 = values;
        if ((i2 & 4) != 0) {
            costs = calculateResponse.costs;
        }
        Costs costs2 = costs;
        if ((i2 & 8) != 0) {
            gains = calculateResponse.gains;
        }
        Gains gains2 = gains;
        if ((i2 & 16) != 0) {
            iVar = calculateResponse.unknownFields();
        }
        return calculateResponse.copy(str, values2, costs2, gains2, iVar);
    }

    public final CalculateResponse copy(String latest_value, Values values, Costs costs, Gains gains, i unknownFields) {
        m.h(latest_value, "latest_value");
        m.h(unknownFields, "unknownFields");
        return new CalculateResponse(latest_value, values, costs, gains, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CalculateResponse) {
            CalculateResponse calculateResponse = (CalculateResponse) obj;
            return m.c(unknownFields(), calculateResponse.unknownFields()) && m.c(this.latest_value, calculateResponse.latest_value) && m.c(this.values, calculateResponse.values) && m.c(this.costs, calculateResponse.costs) && m.c(this.gains, calculateResponse.gains);
        }
        return false;
    }

    public final Costs getCosts() {
        return this.costs;
    }

    public final Gains getGains() {
        return this.gains;
    }

    public final String getLatest_value() {
        return this.latest_value;
    }

    public final Values getValues() {
        return this.values;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.latest_value.hashCode()) * 37;
            Values values = this.values;
            int hashCode2 = (hashCode + (values != null ? values.hashCode() : 0)) * 37;
            Costs costs = this.costs;
            int hashCode3 = (hashCode2 + (costs != null ? costs.hashCode() : 0)) * 37;
            Gains gains = this.gains;
            int hashCode4 = hashCode3 + (gains != null ? gains.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m445newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("latest_value=" + b.c(this.latest_value));
        if (this.values != null) {
            arrayList.add("values=" + this.values);
        }
        if (this.costs != null) {
            arrayList.add("costs=" + this.costs);
        }
        if (this.gains != null) {
            arrayList.add("gains=" + this.gains);
        }
        h0 = z.h0(arrayList, ", ", "CalculateResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalculateResponse(String latest_value, Values values, Costs costs, Gains gains, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(latest_value, "latest_value");
        m.h(unknownFields, "unknownFields");
        this.latest_value = latest_value;
        this.values = values;
        this.costs = costs;
        this.gains = gains;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m445newBuilder() {
        throw new AssertionError();
    }
}