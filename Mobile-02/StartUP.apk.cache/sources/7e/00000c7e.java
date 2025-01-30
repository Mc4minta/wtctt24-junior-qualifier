package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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

/* compiled from: GetAutopayOptionsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+BU\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ[\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010&R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b'\u0010#R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b(\u0010&¨\u0006,"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetAutopayOptionsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "autopay_setting", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;", "options", "Lcom/coinbase/android/apiv3/generated/authed/loans/DepositPaymentMethod;", "deposit_payment_methods", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "min", "max", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/GetAutopayOptionsResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "getAutopay_setting", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "Ljava/util/List;", "getDeposit_payment_methods", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getMin", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getOptions", "getMax", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetAutopayOptionsResponse extends a {
    public static final ProtoAdapter<GetAutopayOptionsResponse> ADAPTER;
    public static final Parcelable.Creator<GetAutopayOptionsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopaySetting#ADAPTER", jsonName = "autopaySetting", tag = 1)
    private final AutopaySetting autopay_setting;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.DepositPaymentMethod#ADAPTER", jsonName = "depositPaymentMethods", label = p.a.REPEATED, tag = 3)
    private final List<DepositPaymentMethod> deposit_payment_methods;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 5)
    private final Amount max;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 4)
    private final Amount min;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopayOption#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<AutopayOption> options;

    /* compiled from: GetAutopayOptionsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetAutopayOptionsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetAutopayOptionsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetAutopayOptionsResponse> protoAdapter = new ProtoAdapter<GetAutopayOptionsResponse>(c.LENGTH_DELIMITED, e0.b(GetAutopayOptionsResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.GetAutopayOptionsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.GetAutopayOptionsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetAutopayOptionsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long d2 = reader.d();
                AutopaySetting autopaySetting = null;
                Amount amount = null;
                Amount amount2 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetAutopayOptionsResponse(autopaySetting, arrayList, arrayList2, amount, amount2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        autopaySetting = AutopaySetting.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        arrayList.add(AutopayOption.ADAPTER.decode(reader));
                    } else if (g2 == 3) {
                        arrayList2.add(DepositPaymentMethod.ADAPTER.decode(reader));
                    } else if (g2 == 4) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        amount2 = Amount.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetAutopayOptionsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAutopay_setting() != null) {
                    AutopaySetting.ADAPTER.encodeWithTag(writer, 1, value.getAutopay_setting());
                }
                AutopayOption.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getOptions());
                DepositPaymentMethod.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getDeposit_payment_methods());
                if (value.getMin() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getMin());
                }
                if (value.getMax() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getMax());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetAutopayOptionsResponse value) {
                m.h(value, "value");
                if (value.getAutopay_setting() == null) {
                    return 0;
                }
                int encodedSizeWithTag = AutopaySetting.ADAPTER.encodedSizeWithTag(1, value.getAutopay_setting()) + AutopayOption.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getOptions()) + DepositPaymentMethod.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getDeposit_payment_methods());
                if (value.getMin() != null) {
                    ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                    r1 = (value.getMax() != null ? protoAdapter2.encodedSizeWithTag(5, value.getMax()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(4, value.getMin());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetAutopayOptionsResponse redact(GetAutopayOptionsResponse value) {
                m.h(value, "value");
                AutopaySetting autopay_setting = value.getAutopay_setting();
                AutopaySetting redact = autopay_setting != null ? AutopaySetting.ADAPTER.redact(autopay_setting) : null;
                List<AutopayOption> a = b.a(value.getOptions(), AutopayOption.ADAPTER);
                List<DepositPaymentMethod> a2 = b.a(value.getDeposit_payment_methods(), DepositPaymentMethod.ADAPTER);
                Amount min = value.getMin();
                Amount redact2 = min != null ? Amount.ADAPTER.redact(min) : null;
                Amount max = value.getMax();
                return value.copy(redact, a, a2, redact2, max != null ? Amount.ADAPTER.redact(max) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetAutopayOptionsResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ GetAutopayOptionsResponse(AutopaySetting autopaySetting, List list, List list2, Amount amount, Amount amount2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : autopaySetting, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? r.g() : list2, (i2 & 8) != 0 ? null : amount, (i2 & 16) == 0 ? amount2 : null, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetAutopayOptionsResponse copy$default(GetAutopayOptionsResponse getAutopayOptionsResponse, AutopaySetting autopaySetting, List list, List list2, Amount amount, Amount amount2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            autopaySetting = getAutopayOptionsResponse.autopay_setting;
        }
        List<AutopayOption> list3 = list;
        if ((i2 & 2) != 0) {
            list3 = getAutopayOptionsResponse.options;
        }
        List list4 = list3;
        List<DepositPaymentMethod> list5 = list2;
        if ((i2 & 4) != 0) {
            list5 = getAutopayOptionsResponse.deposit_payment_methods;
        }
        List list6 = list5;
        if ((i2 & 8) != 0) {
            amount = getAutopayOptionsResponse.min;
        }
        Amount amount3 = amount;
        if ((i2 & 16) != 0) {
            amount2 = getAutopayOptionsResponse.max;
        }
        Amount amount4 = amount2;
        if ((i2 & 32) != 0) {
            iVar = getAutopayOptionsResponse.unknownFields();
        }
        return getAutopayOptionsResponse.copy(autopaySetting, list4, list6, amount3, amount4, iVar);
    }

    public final GetAutopayOptionsResponse copy(AutopaySetting autopaySetting, List<AutopayOption> options, List<DepositPaymentMethod> deposit_payment_methods, Amount amount, Amount amount2, i unknownFields) {
        m.h(options, "options");
        m.h(deposit_payment_methods, "deposit_payment_methods");
        m.h(unknownFields, "unknownFields");
        return new GetAutopayOptionsResponse(autopaySetting, options, deposit_payment_methods, amount, amount2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetAutopayOptionsResponse) {
            GetAutopayOptionsResponse getAutopayOptionsResponse = (GetAutopayOptionsResponse) obj;
            return m.c(unknownFields(), getAutopayOptionsResponse.unknownFields()) && m.c(this.autopay_setting, getAutopayOptionsResponse.autopay_setting) && m.c(this.options, getAutopayOptionsResponse.options) && m.c(this.deposit_payment_methods, getAutopayOptionsResponse.deposit_payment_methods) && m.c(this.min, getAutopayOptionsResponse.min) && m.c(this.max, getAutopayOptionsResponse.max);
        }
        return false;
    }

    public final AutopaySetting getAutopay_setting() {
        return this.autopay_setting;
    }

    public final List<DepositPaymentMethod> getDeposit_payment_methods() {
        return this.deposit_payment_methods;
    }

    public final Amount getMax() {
        return this.max;
    }

    public final Amount getMin() {
        return this.min;
    }

    public final List<AutopayOption> getOptions() {
        return this.options;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AutopaySetting autopaySetting = this.autopay_setting;
            int hashCode2 = (((((hashCode + (autopaySetting != null ? autopaySetting.hashCode() : 0)) * 37) + this.options.hashCode()) * 37) + this.deposit_payment_methods.hashCode()) * 37;
            Amount amount = this.min;
            int hashCode3 = (hashCode2 + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.max;
            int hashCode4 = hashCode3 + (amount2 != null ? amount2.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m355newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.autopay_setting != null) {
            arrayList.add("autopay_setting=" + this.autopay_setting);
        }
        if (!this.options.isEmpty()) {
            arrayList.add("options=" + this.options);
        }
        if (!this.deposit_payment_methods.isEmpty()) {
            arrayList.add("deposit_payment_methods=" + this.deposit_payment_methods);
        }
        if (this.min != null) {
            arrayList.add("min=" + this.min);
        }
        if (this.max != null) {
            arrayList.add("max=" + this.max);
        }
        h0 = z.h0(arrayList, ", ", "GetAutopayOptionsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m355newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAutopayOptionsResponse(AutopaySetting autopaySetting, List<AutopayOption> options, List<DepositPaymentMethod> deposit_payment_methods, Amount amount, Amount amount2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(options, "options");
        m.h(deposit_payment_methods, "deposit_payment_methods");
        m.h(unknownFields, "unknownFields");
        this.autopay_setting = autopaySetting;
        this.options = options;
        this.deposit_payment_methods = deposit_payment_methods;
        this.min = amount;
        this.max = amount2;
    }
}