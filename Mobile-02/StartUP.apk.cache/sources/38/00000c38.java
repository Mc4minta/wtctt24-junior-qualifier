package com.coinbase.android.apiv3.generated.authed.fees;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.Ref;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: MinimumFee.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$BA\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/fees/MinimumFee;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Ref;", ApiConstants.CURRENCY, "Lcom/coinbase/android/apiv3/generated/common/Amount;", "buy_fee", "sell_fee", "convert_minimum", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/fees/MinimumFee;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getBuy_fee", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getSell_fee", "getConvert_minimum", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getCurrency", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class MinimumFee extends a {
    public static final ProtoAdapter<MinimumFee> ADAPTER;
    public static final Parcelable.Creator<MinimumFee> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "buyFee", tag = 2)
    private final Amount buy_fee;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "convertMinimum", tag = 4)
    private final Amount convert_minimum;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", tag = 1)
    private final Ref currency;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "sellFee", tag = 3)
    private final Amount sell_fee;

    /* compiled from: MinimumFee.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/fees/MinimumFee$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/fees/MinimumFee;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(MinimumFee.class);
        ProtoAdapter<MinimumFee> protoAdapter = new ProtoAdapter<MinimumFee>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.fees.MinimumFee") { // from class: com.coinbase.android.apiv3.generated.authed.fees.MinimumFee$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MinimumFee decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Ref ref = null;
                Amount amount = null;
                Amount amount2 = null;
                Amount amount3 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new MinimumFee(ref, amount, amount2, amount3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        ref = Ref.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        amount2 = Amount.ADAPTER.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        amount3 = Amount.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, MinimumFee value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCurrency() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 1, value.getCurrency());
                }
                if (value.getBuy_fee() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getBuy_fee());
                }
                if (value.getSell_fee() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getSell_fee());
                }
                if (value.getConvert_minimum() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getConvert_minimum());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(MinimumFee value) {
                m.h(value, "value");
                if (value.getCurrency() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Ref.ADAPTER.encodedSizeWithTag(1, value.getCurrency());
                if (value.getBuy_fee() != null) {
                    ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getBuy_fee());
                    if (value.getSell_fee() != null) {
                        r1 = (value.getConvert_minimum() != null ? protoAdapter2.encodedSizeWithTag(4, value.getConvert_minimum()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, value.getSell_fee());
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public MinimumFee redact(MinimumFee value) {
                m.h(value, "value");
                Ref currency = value.getCurrency();
                Ref redact = currency != null ? Ref.ADAPTER.redact(currency) : null;
                Amount buy_fee = value.getBuy_fee();
                Amount redact2 = buy_fee != null ? Amount.ADAPTER.redact(buy_fee) : null;
                Amount sell_fee = value.getSell_fee();
                Amount redact3 = sell_fee != null ? Amount.ADAPTER.redact(sell_fee) : null;
                Amount convert_minimum = value.getConvert_minimum();
                return value.copy(redact, redact2, redact3, convert_minimum != null ? Amount.ADAPTER.redact(convert_minimum) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public MinimumFee() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ MinimumFee(Ref ref, Amount amount, Amount amount2, Amount amount3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : ref, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? null : amount2, (i2 & 8) == 0 ? amount3 : null, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ MinimumFee copy$default(MinimumFee minimumFee, Ref ref, Amount amount, Amount amount2, Amount amount3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ref = minimumFee.currency;
        }
        if ((i2 & 2) != 0) {
            amount = minimumFee.buy_fee;
        }
        Amount amount4 = amount;
        if ((i2 & 4) != 0) {
            amount2 = minimumFee.sell_fee;
        }
        Amount amount5 = amount2;
        if ((i2 & 8) != 0) {
            amount3 = minimumFee.convert_minimum;
        }
        Amount amount6 = amount3;
        if ((i2 & 16) != 0) {
            iVar = minimumFee.unknownFields();
        }
        return minimumFee.copy(ref, amount4, amount5, amount6, iVar);
    }

    public final MinimumFee copy(Ref ref, Amount amount, Amount amount2, Amount amount3, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new MinimumFee(ref, amount, amount2, amount3, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MinimumFee) {
            MinimumFee minimumFee = (MinimumFee) obj;
            return m.c(unknownFields(), minimumFee.unknownFields()) && m.c(this.currency, minimumFee.currency) && m.c(this.buy_fee, minimumFee.buy_fee) && m.c(this.sell_fee, minimumFee.sell_fee) && m.c(this.convert_minimum, minimumFee.convert_minimum);
        }
        return false;
    }

    public final Amount getBuy_fee() {
        return this.buy_fee;
    }

    public final Amount getConvert_minimum() {
        return this.convert_minimum;
    }

    public final Ref getCurrency() {
        return this.currency;
    }

    public final Amount getSell_fee() {
        return this.sell_fee;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Ref ref = this.currency;
            int hashCode2 = (hashCode + (ref != null ? ref.hashCode() : 0)) * 37;
            Amount amount = this.buy_fee;
            int hashCode3 = (hashCode2 + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.sell_fee;
            int hashCode4 = (hashCode3 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.convert_minimum;
            int hashCode5 = hashCode4 + (amount3 != null ? amount3.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m333newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.currency != null) {
            arrayList.add("currency=" + this.currency);
        }
        if (this.buy_fee != null) {
            arrayList.add("buy_fee=" + this.buy_fee);
        }
        if (this.sell_fee != null) {
            arrayList.add("sell_fee=" + this.sell_fee);
        }
        if (this.convert_minimum != null) {
            arrayList.add("convert_minimum=" + this.convert_minimum);
        }
        h0 = z.h0(arrayList, ", ", "MinimumFee{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinimumFee(Ref ref, Amount amount, Amount amount2, Amount amount3, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.currency = ref;
        this.buy_fee = amount;
        this.sell_fee = amount2;
        this.convert_minimum = amount3;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m333newBuilder() {
        throw new AssertionError();
    }
}