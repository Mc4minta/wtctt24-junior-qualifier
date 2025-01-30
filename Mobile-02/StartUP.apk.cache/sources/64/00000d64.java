package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.google.protobuf.u;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: LoyaltyTicker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B3\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "initial_amount", "Lcom/google/protobuf/u;", "initial_amount_date", "ticker_daily_rate", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;", "Ljava/lang/String;", "getTicker_daily_rate", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getInitial_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Lcom/google/protobuf/u;", "getInitial_amount_date", "()Lcom/google/protobuf/u;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyTicker extends a {
    public static final ProtoAdapter<LoyaltyTicker> ADAPTER;
    public static final Parcelable.Creator<LoyaltyTicker> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "initialAmount", tag = 1)
    private final Amount initial_amount;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "initialAmountDate", tag = 2)
    private final u initial_amount_date;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "tickerDailyRate", tag = 3)
    private final String ticker_daily_rate;

    /* compiled from: LoyaltyTicker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final c cVar = c.LENGTH_DELIMITED;
        final d b2 = e0.b(LoyaltyTicker.class);
        ProtoAdapter<LoyaltyTicker> protoAdapter = new ProtoAdapter<LoyaltyTicker>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyTicker") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTicker$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyTicker decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Amount amount = null;
                String str = "";
                u uVar = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyTicker(amount, uVar, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        uVar = u.a.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyTicker value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getInitial_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getInitial_amount());
                }
                if (value.getInitial_amount_date() != null) {
                    u.a.encodeWithTag(writer, 2, value.getInitial_amount_date());
                }
                if (!m.c(value.getTicker_daily_rate(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTicker_daily_rate());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyTicker value) {
                m.h(value, "value");
                if (value.getInitial_amount() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Amount.ADAPTER.encodedSizeWithTag(1, value.getInitial_amount());
                if (value.getInitial_amount_date() != null) {
                    r1 = (m.c(value.getTicker_daily_rate(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(3, value.getTicker_daily_rate()) + value.unknownFields().Q()) + u.a.encodedSizeWithTag(2, value.getInitial_amount_date());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyTicker redact(LoyaltyTicker value) {
                m.h(value, "value");
                Amount initial_amount = value.getInitial_amount();
                Amount redact = initial_amount != null ? Amount.ADAPTER.redact(initial_amount) : null;
                u initial_amount_date = value.getInitial_amount_date();
                return LoyaltyTicker.copy$default(value, redact, initial_amount_date != null ? u.a.redact(initial_amount_date) : null, null, i.a, 4, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyTicker() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ LoyaltyTicker(Amount amount, u uVar, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? null : uVar, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoyaltyTicker copy$default(LoyaltyTicker loyaltyTicker, Amount amount, u uVar, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            amount = loyaltyTicker.initial_amount;
        }
        if ((i2 & 2) != 0) {
            uVar = loyaltyTicker.initial_amount_date;
        }
        if ((i2 & 4) != 0) {
            str = loyaltyTicker.ticker_daily_rate;
        }
        if ((i2 & 8) != 0) {
            iVar = loyaltyTicker.unknownFields();
        }
        return loyaltyTicker.copy(amount, uVar, str, iVar);
    }

    public final LoyaltyTicker copy(Amount amount, u uVar, String ticker_daily_rate, i unknownFields) {
        m.h(ticker_daily_rate, "ticker_daily_rate");
        m.h(unknownFields, "unknownFields");
        return new LoyaltyTicker(amount, uVar, ticker_daily_rate, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyTicker) {
            LoyaltyTicker loyaltyTicker = (LoyaltyTicker) obj;
            return m.c(unknownFields(), loyaltyTicker.unknownFields()) && m.c(this.initial_amount, loyaltyTicker.initial_amount) && m.c(this.initial_amount_date, loyaltyTicker.initial_amount_date) && m.c(this.ticker_daily_rate, loyaltyTicker.ticker_daily_rate);
        }
        return false;
    }

    public final Amount getInitial_amount() {
        return this.initial_amount;
    }

    public final u getInitial_amount_date() {
        return this.initial_amount_date;
    }

    public final String getTicker_daily_rate() {
        return this.ticker_daily_rate;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.initial_amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            u uVar = this.initial_amount_date;
            int hashCode3 = ((hashCode2 + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.ticker_daily_rate.hashCode();
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m419newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.initial_amount != null) {
            arrayList.add("initial_amount=" + this.initial_amount);
        }
        if (this.initial_amount_date != null) {
            arrayList.add("initial_amount_date=" + this.initial_amount_date);
        }
        arrayList.add("ticker_daily_rate=" + b.c(this.ticker_daily_rate));
        h0 = z.h0(arrayList, ", ", "LoyaltyTicker{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyTicker(Amount amount, u uVar, String ticker_daily_rate, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(ticker_daily_rate, "ticker_daily_rate");
        m.h(unknownFields, "unknownFields");
        this.initial_amount = amount;
        this.initial_amount_date = uVar;
        this.ticker_daily_rate = ticker_daily_rate;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m419newBuilder() {
        throw new AssertionError();
    }
}