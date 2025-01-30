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

/* compiled from: SpotRate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$BE\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJK\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b!\u0010\u000f¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "base", ApiConstants.CURRENCY, "amount", "Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "latest_price", "base_id", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;", "Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "getLatest_price", "()Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "Ljava/lang/String;", "getAmount", "getBase_id", "getCurrency", "getBase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class SpotRate extends a {
    public static final ProtoAdapter<SpotRate> ADAPTER;
    public static final Parcelable.Creator<SpotRate> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String base;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "baseId", tag = 5)
    private final String base_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String currency;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.TimestampedScaledAmount#ADAPTER", jsonName = "latestPrice", tag = 4)
    private final TimestampedScaledAmount latest_price;

    /* compiled from: SpotRate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/SpotRate;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<SpotRate> protoAdapter = new ProtoAdapter<SpotRate>(c.LENGTH_DELIMITED, e0.b(SpotRate.class), "type.googleapis.com/coinbase.public_api.unauthed.SpotRate") { // from class: com.coinbase.android.apiv3.generated.unauthed.SpotRate$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpotRate decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                TimestampedScaledAmount timestampedScaledAmount = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new SpotRate(str, str2, str3, timestampedScaledAmount, str4, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        timestampedScaledAmount = TimestampedScaledAmount.ADAPTER.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        str4 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, SpotRate value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getBase(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getBase());
                }
                if (!m.c(value.getCurrency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getCurrency());
                }
                if (!m.c(value.getAmount(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getAmount());
                }
                if (value.getLatest_price() != null) {
                    TimestampedScaledAmount.ADAPTER.encodeWithTag(writer, 4, value.getLatest_price());
                }
                if (!m.c(value.getBase_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getBase_id());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(SpotRate value) {
                m.h(value, "value");
                if (m.c(value.getBase(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getBase());
                if (!m.c(value.getCurrency(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getCurrency());
                    if (!m.c(value.getAmount(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getAmount());
                        if (value.getLatest_price() != null) {
                            r2 = (m.c(value.getBase_id(), "") ? 0 : protoAdapter2.encodedSizeWithTag(5, value.getBase_id()) + value.unknownFields().Q()) + TimestampedScaledAmount.ADAPTER.encodedSizeWithTag(4, value.getLatest_price());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public SpotRate redact(SpotRate value) {
                m.h(value, "value");
                TimestampedScaledAmount latest_price = value.getLatest_price();
                return SpotRate.copy$default(value, null, null, null, latest_price != null ? TimestampedScaledAmount.ADAPTER.redact(latest_price) : null, null, i.a, 23, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public SpotRate() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ SpotRate(String str, String str2, String str3, TimestampedScaledAmount timestampedScaledAmount, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? null : timestampedScaledAmount, (i2 & 16) == 0 ? str4 : "", (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ SpotRate copy$default(SpotRate spotRate, String str, String str2, String str3, TimestampedScaledAmount timestampedScaledAmount, String str4, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = spotRate.base;
        }
        if ((i2 & 2) != 0) {
            str2 = spotRate.currency;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = spotRate.amount;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            timestampedScaledAmount = spotRate.latest_price;
        }
        TimestampedScaledAmount timestampedScaledAmount2 = timestampedScaledAmount;
        if ((i2 & 16) != 0) {
            str4 = spotRate.base_id;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            iVar = spotRate.unknownFields();
        }
        return spotRate.copy(str, str5, str6, timestampedScaledAmount2, str7, iVar);
    }

    public final SpotRate copy(String base, String currency, String amount, TimestampedScaledAmount timestampedScaledAmount, String base_id, i unknownFields) {
        m.h(base, "base");
        m.h(currency, "currency");
        m.h(amount, "amount");
        m.h(base_id, "base_id");
        m.h(unknownFields, "unknownFields");
        return new SpotRate(base, currency, amount, timestampedScaledAmount, base_id, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpotRate) {
            SpotRate spotRate = (SpotRate) obj;
            return m.c(unknownFields(), spotRate.unknownFields()) && m.c(this.base, spotRate.base) && m.c(this.currency, spotRate.currency) && m.c(this.amount, spotRate.amount) && m.c(this.latest_price, spotRate.latest_price) && m.c(this.base_id, spotRate.base_id);
        }
        return false;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getBase() {
        return this.base;
    }

    public final String getBase_id() {
        return this.base_id;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final TimestampedScaledAmount getLatest_price() {
        return this.latest_price;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.base.hashCode()) * 37) + this.currency.hashCode()) * 37) + this.amount.hashCode()) * 37;
            TimestampedScaledAmount timestampedScaledAmount = this.latest_price;
            int hashCode2 = ((hashCode + (timestampedScaledAmount != null ? timestampedScaledAmount.hashCode() : 0)) * 37) + this.base_id.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m546newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("base=" + b.c(this.base));
        arrayList.add("currency=" + b.c(this.currency));
        arrayList.add("amount=" + b.c(this.amount));
        if (this.latest_price != null) {
            arrayList.add("latest_price=" + this.latest_price);
        }
        arrayList.add("base_id=" + b.c(this.base_id));
        h0 = z.h0(arrayList, ", ", "SpotRate{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotRate(String base, String currency, String amount, TimestampedScaledAmount timestampedScaledAmount, String base_id, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(base, "base");
        m.h(currency, "currency");
        m.h(amount, "amount");
        m.h(base_id, "base_id");
        m.h(unknownFields, "unknownFields");
        this.base = base;
        this.currency = currency;
        this.amount = amount;
        this.latest_price = timestampedScaledAmount;
        this.base_id = base_id;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m546newBuilder() {
        throw new AssertionError();
    }
}