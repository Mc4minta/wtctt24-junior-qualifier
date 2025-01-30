package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.resources.PaymentMethod;
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

/* compiled from: AutopaySetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-BI\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010\u000fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;", "type", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "payment_method", "Lcom/google/protobuf/u;", "next_scheduled", "submit_on", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/google/protobuf/u;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/lang/String;", "getSubmit_on", "Lcom/google/protobuf/u;", "getNext_scheduled", "()Lcom/google/protobuf/u;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/google/protobuf/u;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AutopaySetting extends a {
    public static final ProtoAdapter<AutopaySetting> ADAPTER;
    public static final Parcelable.Creator<AutopaySetting> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 2)
    private final Amount amount;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "nextScheduled", tag = 4)
    private final u next_scheduled;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "paymentMethod", tag = 3)
    private final PaymentMethod payment_method;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "submitOn", tag = 5)
    private final String submit_on;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopayType#ADAPTER", tag = 1)
    private final AutopayType type;

    /* compiled from: AutopaySetting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(AutopaySetting.class);
        ProtoAdapter<AutopaySetting> protoAdapter = new ProtoAdapter<AutopaySetting>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loans.AutopaySetting") { // from class: com.coinbase.android.apiv3.generated.authed.loans.AutopaySetting$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AutopaySetting decode(k reader) {
                m.h(reader, "reader");
                AutopayType autopayType = AutopayType.NONE;
                long d2 = reader.d();
                AutopayType autopayType2 = autopayType;
                Amount amount = null;
                PaymentMethod paymentMethod = null;
                u uVar = null;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AutopaySetting(autopayType2, amount, paymentMethod, uVar, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            autopayType2 = AutopayType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                    } else if (g2 == 4) {
                        uVar = u.a.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AutopaySetting value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != AutopayType.NONE) {
                    AutopayType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getAmount());
                }
                if (value.getPayment_method() != null) {
                    PaymentMethod.ADAPTER.encodeWithTag(writer, 3, value.getPayment_method());
                }
                if (value.getNext_scheduled() != null) {
                    u.a.encodeWithTag(writer, 4, value.getNext_scheduled());
                }
                if (!m.c(value.getSubmit_on(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getSubmit_on());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AutopaySetting value) {
                m.h(value, "value");
                if (value.getType() == AutopayType.NONE) {
                    return 0;
                }
                int encodedSizeWithTag = AutopayType.ADAPTER.encodedSizeWithTag(1, value.getType());
                if (value.getAmount() != null) {
                    int encodedSizeWithTag2 = Amount.ADAPTER.encodedSizeWithTag(2, value.getAmount());
                    if (value.getPayment_method() != null) {
                        int encodedSizeWithTag3 = PaymentMethod.ADAPTER.encodedSizeWithTag(3, value.getPayment_method());
                        if (value.getNext_scheduled() != null) {
                            r2 = (m.c(value.getSubmit_on(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(5, value.getSubmit_on()) + value.unknownFields().Q()) + u.a.encodedSizeWithTag(4, value.getNext_scheduled());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AutopaySetting redact(AutopaySetting value) {
                m.h(value, "value");
                Amount amount = value.getAmount();
                Amount redact = amount != null ? Amount.ADAPTER.redact(amount) : null;
                PaymentMethod payment_method = value.getPayment_method();
                PaymentMethod redact2 = payment_method != null ? PaymentMethod.ADAPTER.redact(payment_method) : null;
                u next_scheduled = value.getNext_scheduled();
                return AutopaySetting.copy$default(value, null, redact, redact2, next_scheduled != null ? u.a.redact(next_scheduled) : null, null, i.a, 17, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AutopaySetting() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ AutopaySetting(AutopayType autopayType, Amount amount, PaymentMethod paymentMethod, u uVar, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? AutopayType.NONE : autopayType, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? null : paymentMethod, (i2 & 8) == 0 ? uVar : null, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AutopaySetting copy$default(AutopaySetting autopaySetting, AutopayType autopayType, Amount amount, PaymentMethod paymentMethod, u uVar, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            autopayType = autopaySetting.type;
        }
        if ((i2 & 2) != 0) {
            amount = autopaySetting.amount;
        }
        Amount amount2 = amount;
        if ((i2 & 4) != 0) {
            paymentMethod = autopaySetting.payment_method;
        }
        PaymentMethod paymentMethod2 = paymentMethod;
        if ((i2 & 8) != 0) {
            uVar = autopaySetting.next_scheduled;
        }
        u uVar2 = uVar;
        if ((i2 & 16) != 0) {
            str = autopaySetting.submit_on;
        }
        String str2 = str;
        if ((i2 & 32) != 0) {
            iVar = autopaySetting.unknownFields();
        }
        return autopaySetting.copy(autopayType, amount2, paymentMethod2, uVar2, str2, iVar);
    }

    public final AutopaySetting copy(AutopayType type, Amount amount, PaymentMethod paymentMethod, u uVar, String submit_on, i unknownFields) {
        m.h(type, "type");
        m.h(submit_on, "submit_on");
        m.h(unknownFields, "unknownFields");
        return new AutopaySetting(type, amount, paymentMethod, uVar, submit_on, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutopaySetting) {
            AutopaySetting autopaySetting = (AutopaySetting) obj;
            return m.c(unknownFields(), autopaySetting.unknownFields()) && this.type == autopaySetting.type && m.c(this.amount, autopaySetting.amount) && m.c(this.payment_method, autopaySetting.payment_method) && m.c(this.next_scheduled, autopaySetting.next_scheduled) && m.c(this.submit_on, autopaySetting.submit_on);
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final u getNext_scheduled() {
        return this.next_scheduled;
    }

    public final PaymentMethod getPayment_method() {
        return this.payment_method;
    }

    public final String getSubmit_on() {
        return this.submit_on;
    }

    public final AutopayType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37;
            Amount amount = this.amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            PaymentMethod paymentMethod = this.payment_method;
            int hashCode3 = (hashCode2 + (paymentMethod != null ? paymentMethod.hashCode() : 0)) * 37;
            u uVar = this.next_scheduled;
            int hashCode4 = ((hashCode3 + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.submit_on.hashCode();
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m339newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        if (this.payment_method != null) {
            arrayList.add("payment_method=" + this.payment_method);
        }
        if (this.next_scheduled != null) {
            arrayList.add("next_scheduled=" + this.next_scheduled);
        }
        arrayList.add("submit_on=" + b.c(this.submit_on));
        h0 = z.h0(arrayList, ", ", "AutopaySetting{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m339newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutopaySetting(AutopayType type, Amount amount, PaymentMethod paymentMethod, u uVar, String submit_on, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(submit_on, "submit_on");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.amount = amount;
        this.payment_method = paymentMethod;
        this.next_scheduled = uVar;
        this.submit_on = submit_on;
    }
}