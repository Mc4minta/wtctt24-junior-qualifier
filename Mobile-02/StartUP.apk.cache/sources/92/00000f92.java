package com.coinbase.android.apiv3.generated.unauthed.push;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PercentChange;
import com.coinbase.android.apiv3.generated.unauthed.SpotRate;
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

/* compiled from: PricePercentChange.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B)\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/push/PricePercentChange;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;", "rate", "Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "percent_change", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;Lcom/coinbase/android/apiv3/generated/common/PercentChange;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/push/PricePercentChange;", "Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "getPercent_change", "()Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;", "getRate", "()Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;", "<init>", "(Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;Lcom/coinbase/android/apiv3/generated/common/PercentChange;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PricePercentChange extends a {
    public static final ProtoAdapter<PricePercentChange> ADAPTER;
    public static final Parcelable.Creator<PricePercentChange> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PercentChange#ADAPTER", jsonName = "percentChange", tag = 2)
    private final PercentChange percent_change;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.SpotRate#ADAPTER", tag = 1)
    private final SpotRate rate;

    /* compiled from: PricePercentChange.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/push/PricePercentChange$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/push/PricePercentChange;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PricePercentChange> protoAdapter = new ProtoAdapter<PricePercentChange>(c.LENGTH_DELIMITED, e0.b(PricePercentChange.class), "type.googleapis.com/coinbase.public_api.unauthed.push.PricePercentChange") { // from class: com.coinbase.android.apiv3.generated.unauthed.push.PricePercentChange$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PricePercentChange decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                SpotRate spotRate = null;
                PercentChange percentChange = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PricePercentChange(spotRate, percentChange, reader.e(d2));
                    }
                    if (g2 == 1) {
                        spotRate = SpotRate.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        percentChange = PercentChange.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PricePercentChange value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getRate() != null) {
                    SpotRate.ADAPTER.encodeWithTag(writer, 1, value.getRate());
                }
                if (value.getPercent_change() != null) {
                    PercentChange.ADAPTER.encodeWithTag(writer, 2, value.getPercent_change());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PricePercentChange value) {
                m.h(value, "value");
                if (value.getRate() == null) {
                    return 0;
                }
                return (value.getPercent_change() != null ? PercentChange.ADAPTER.encodedSizeWithTag(2, value.getPercent_change()) + value.unknownFields().Q() : 0) + SpotRate.ADAPTER.encodedSizeWithTag(1, value.getRate());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PricePercentChange redact(PricePercentChange value) {
                m.h(value, "value");
                SpotRate rate = value.getRate();
                SpotRate redact = rate != null ? SpotRate.ADAPTER.redact(rate) : null;
                PercentChange percent_change = value.getPercent_change();
                return value.copy(redact, percent_change != null ? PercentChange.ADAPTER.redact(percent_change) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PricePercentChange() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ PricePercentChange(SpotRate spotRate, PercentChange percentChange, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : spotRate, (i2 & 2) != 0 ? null : percentChange, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PricePercentChange copy$default(PricePercentChange pricePercentChange, SpotRate spotRate, PercentChange percentChange, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            spotRate = pricePercentChange.rate;
        }
        if ((i2 & 2) != 0) {
            percentChange = pricePercentChange.percent_change;
        }
        if ((i2 & 4) != 0) {
            iVar = pricePercentChange.unknownFields();
        }
        return pricePercentChange.copy(spotRate, percentChange, iVar);
    }

    public final PricePercentChange copy(SpotRate spotRate, PercentChange percentChange, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new PricePercentChange(spotRate, percentChange, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PricePercentChange) {
            PricePercentChange pricePercentChange = (PricePercentChange) obj;
            return m.c(unknownFields(), pricePercentChange.unknownFields()) && m.c(this.rate, pricePercentChange.rate) && m.c(this.percent_change, pricePercentChange.percent_change);
        }
        return false;
    }

    public final PercentChange getPercent_change() {
        return this.percent_change;
    }

    public final SpotRate getRate() {
        return this.rate;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            SpotRate spotRate = this.rate;
            int hashCode2 = (hashCode + (spotRate != null ? spotRate.hashCode() : 0)) * 37;
            PercentChange percentChange = this.percent_change;
            int hashCode3 = hashCode2 + (percentChange != null ? percentChange.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m576newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.rate != null) {
            arrayList.add("rate=" + this.rate);
        }
        if (this.percent_change != null) {
            arrayList.add("percent_change=" + this.percent_change);
        }
        h0 = z.h0(arrayList, ", ", "PricePercentChange{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PricePercentChange(SpotRate spotRate, PercentChange percentChange, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.rate = spotRate;
        this.percent_change = percentChange;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m576newBuilder() {
        throw new AssertionError();
    }
}