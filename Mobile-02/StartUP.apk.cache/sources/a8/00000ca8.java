package com.coinbase.android.apiv3.generated.authed.loans;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetPaymentDetailsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B}\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b4\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0083\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b%\u0010$R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b&\u0010$R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010,R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010/R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b0\u0010$R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u00101\u001a\u0004\b2\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b3\u0010\u000f¨\u00067"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetPaymentDetailsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "payoff_amount", "minimum_due", "health_ratio_required", "amount_required", "health_ratio_recommended", "amount_recommended", "Lcom/google/protobuf/u;", "next_due", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/DepositPaymentMethod;", "deposit_payment_methods", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "autopay_setting", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/GetPaymentDetailsResponse;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getPayoff_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount_recommended", "getAmount_required", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "getAutopay_setting", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "Lcom/google/protobuf/u;", "getNext_due", "()Lcom/google/protobuf/u;", "Ljava/util/List;", "getDeposit_payment_methods", "()Ljava/util/List;", "getMinimum_due", "Ljava/lang/String;", "getHealth_ratio_required", "getHealth_ratio_recommended", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetPaymentDetailsResponse extends a {
    public static final ProtoAdapter<GetPaymentDetailsResponse> ADAPTER;
    public static final Parcelable.Creator<GetPaymentDetailsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "amountRecommended", tag = 6)
    private final Amount amount_recommended;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "amountRequired", tag = 4)
    private final Amount amount_required;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopaySetting#ADAPTER", jsonName = "autopaySetting", tag = 9)
    private final AutopaySetting autopay_setting;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.DepositPaymentMethod#ADAPTER", jsonName = "depositPaymentMethods", label = p.a.REPEATED, tag = 8)
    private final List<DepositPaymentMethod> deposit_payment_methods;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "healthRatioRecommended", tag = 5)
    private final String health_ratio_recommended;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "healthRatioRequired", tag = 3)
    private final String health_ratio_required;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "minimumDue", tag = 2)
    private final Amount minimum_due;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "nextDue", tag = 7)
    private final u next_due;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "payoffAmount", tag = 1)
    private final Amount payoff_amount;

    /* compiled from: GetPaymentDetailsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetPaymentDetailsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetPaymentDetailsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetPaymentDetailsResponse> protoAdapter = new ProtoAdapter<GetPaymentDetailsResponse>(c.LENGTH_DELIMITED, e0.b(GetPaymentDetailsResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.GetPaymentDetailsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.GetPaymentDetailsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetPaymentDetailsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                Amount amount = null;
                String str = "";
                String str2 = str;
                Amount amount2 = null;
                Amount amount3 = null;
                Amount amount4 = null;
                u uVar = null;
                AutopaySetting autopaySetting = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetPaymentDetailsResponse(amount2, amount, str, amount3, str2, amount4, uVar, arrayList, autopaySetting, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 2:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 3:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            uVar = u.a.decode(reader);
                            break;
                        case 8:
                            arrayList.add(DepositPaymentMethod.ADAPTER.decode(reader));
                            break;
                        case 9:
                            autopaySetting = AutopaySetting.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetPaymentDetailsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getPayoff_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getPayoff_amount());
                }
                if (value.getMinimum_due() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getMinimum_due());
                }
                if (!m.c(value.getHealth_ratio_required(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getHealth_ratio_required());
                }
                if (value.getAmount_required() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getAmount_required());
                }
                if (!m.c(value.getHealth_ratio_recommended(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getHealth_ratio_recommended());
                }
                if (value.getAmount_recommended() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getAmount_recommended());
                }
                if (value.getNext_due() != null) {
                    u.a.encodeWithTag(writer, 7, value.getNext_due());
                }
                DepositPaymentMethod.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.getDeposit_payment_methods());
                if (value.getAutopay_setting() != null) {
                    AutopaySetting.ADAPTER.encodeWithTag(writer, 9, value.getAutopay_setting());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetPaymentDetailsResponse value) {
                m.h(value, "value");
                if (value.getPayoff_amount() == null) {
                    return 0;
                }
                ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getPayoff_amount());
                if (value.getMinimum_due() != null) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getMinimum_due());
                    if (!m.c(value.getHealth_ratio_required(), "")) {
                        ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getHealth_ratio_required());
                        if (value.getAmount_required() != null) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getAmount_required());
                            if (!m.c(value.getHealth_ratio_recommended(), "")) {
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getHealth_ratio_recommended());
                                if (value.getAmount_recommended() != null) {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(6, value.getAmount_recommended());
                                    if (value.getNext_due() != null) {
                                        r1 = (value.getAutopay_setting() != null ? AutopaySetting.ADAPTER.encodedSizeWithTag(9, value.getAutopay_setting()) + value.unknownFields().Q() : 0) + u.a.encodedSizeWithTag(7, value.getNext_due()) + DepositPaymentMethod.ADAPTER.asRepeated().encodedSizeWithTag(8, value.getDeposit_payment_methods());
                                    }
                                    r1 += encodedSizeWithTag6;
                                }
                                r1 += encodedSizeWithTag5;
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
            public GetPaymentDetailsResponse redact(GetPaymentDetailsResponse value) {
                m.h(value, "value");
                Amount payoff_amount = value.getPayoff_amount();
                Amount redact = payoff_amount != null ? Amount.ADAPTER.redact(payoff_amount) : null;
                Amount minimum_due = value.getMinimum_due();
                Amount redact2 = minimum_due != null ? Amount.ADAPTER.redact(minimum_due) : null;
                Amount amount_required = value.getAmount_required();
                Amount redact3 = amount_required != null ? Amount.ADAPTER.redact(amount_required) : null;
                Amount amount_recommended = value.getAmount_recommended();
                Amount redact4 = amount_recommended != null ? Amount.ADAPTER.redact(amount_recommended) : null;
                u next_due = value.getNext_due();
                u redact5 = next_due != null ? u.a.redact(next_due) : null;
                List a = b.a(value.getDeposit_payment_methods(), DepositPaymentMethod.ADAPTER);
                AutopaySetting autopay_setting = value.getAutopay_setting();
                return GetPaymentDetailsResponse.copy$default(value, redact, redact2, null, redact3, null, redact4, redact5, a, autopay_setting != null ? AutopaySetting.ADAPTER.redact(autopay_setting) : null, i.a, 20, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetPaymentDetailsResponse() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ GetPaymentDetailsResponse(Amount amount, Amount amount2, String str, Amount amount3, String str2, Amount amount4, u uVar, List list, AutopaySetting autopaySetting, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? null : amount2, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? null : amount3, (i2 & 16) == 0 ? str2 : "", (i2 & 32) != 0 ? null : amount4, (i2 & 64) != 0 ? null : uVar, (i2 & 128) != 0 ? r.g() : list, (i2 & 256) == 0 ? autopaySetting : null, (i2 & 512) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetPaymentDetailsResponse copy$default(GetPaymentDetailsResponse getPaymentDetailsResponse, Amount amount, Amount amount2, String str, Amount amount3, String str2, Amount amount4, u uVar, List list, AutopaySetting autopaySetting, i iVar, int i2, Object obj) {
        return getPaymentDetailsResponse.copy((i2 & 1) != 0 ? getPaymentDetailsResponse.payoff_amount : amount, (i2 & 2) != 0 ? getPaymentDetailsResponse.minimum_due : amount2, (i2 & 4) != 0 ? getPaymentDetailsResponse.health_ratio_required : str, (i2 & 8) != 0 ? getPaymentDetailsResponse.amount_required : amount3, (i2 & 16) != 0 ? getPaymentDetailsResponse.health_ratio_recommended : str2, (i2 & 32) != 0 ? getPaymentDetailsResponse.amount_recommended : amount4, (i2 & 64) != 0 ? getPaymentDetailsResponse.next_due : uVar, (i2 & 128) != 0 ? getPaymentDetailsResponse.deposit_payment_methods : list, (i2 & 256) != 0 ? getPaymentDetailsResponse.autopay_setting : autopaySetting, (i2 & 512) != 0 ? getPaymentDetailsResponse.unknownFields() : iVar);
    }

    public final GetPaymentDetailsResponse copy(Amount amount, Amount amount2, String health_ratio_required, Amount amount3, String health_ratio_recommended, Amount amount4, u uVar, List<DepositPaymentMethod> deposit_payment_methods, AutopaySetting autopaySetting, i unknownFields) {
        m.h(health_ratio_required, "health_ratio_required");
        m.h(health_ratio_recommended, "health_ratio_recommended");
        m.h(deposit_payment_methods, "deposit_payment_methods");
        m.h(unknownFields, "unknownFields");
        return new GetPaymentDetailsResponse(amount, amount2, health_ratio_required, amount3, health_ratio_recommended, amount4, uVar, deposit_payment_methods, autopaySetting, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetPaymentDetailsResponse) {
            GetPaymentDetailsResponse getPaymentDetailsResponse = (GetPaymentDetailsResponse) obj;
            return m.c(unknownFields(), getPaymentDetailsResponse.unknownFields()) && m.c(this.payoff_amount, getPaymentDetailsResponse.payoff_amount) && m.c(this.minimum_due, getPaymentDetailsResponse.minimum_due) && m.c(this.health_ratio_required, getPaymentDetailsResponse.health_ratio_required) && m.c(this.amount_required, getPaymentDetailsResponse.amount_required) && m.c(this.health_ratio_recommended, getPaymentDetailsResponse.health_ratio_recommended) && m.c(this.amount_recommended, getPaymentDetailsResponse.amount_recommended) && m.c(this.next_due, getPaymentDetailsResponse.next_due) && m.c(this.deposit_payment_methods, getPaymentDetailsResponse.deposit_payment_methods) && m.c(this.autopay_setting, getPaymentDetailsResponse.autopay_setting);
        }
        return false;
    }

    public final Amount getAmount_recommended() {
        return this.amount_recommended;
    }

    public final Amount getAmount_required() {
        return this.amount_required;
    }

    public final AutopaySetting getAutopay_setting() {
        return this.autopay_setting;
    }

    public final List<DepositPaymentMethod> getDeposit_payment_methods() {
        return this.deposit_payment_methods;
    }

    public final String getHealth_ratio_recommended() {
        return this.health_ratio_recommended;
    }

    public final String getHealth_ratio_required() {
        return this.health_ratio_required;
    }

    public final Amount getMinimum_due() {
        return this.minimum_due;
    }

    public final u getNext_due() {
        return this.next_due;
    }

    public final Amount getPayoff_amount() {
        return this.payoff_amount;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.payoff_amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.minimum_due;
            int hashCode3 = (((hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37) + this.health_ratio_required.hashCode()) * 37;
            Amount amount3 = this.amount_required;
            int hashCode4 = (((hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37) + this.health_ratio_recommended.hashCode()) * 37;
            Amount amount4 = this.amount_recommended;
            int hashCode5 = (hashCode4 + (amount4 != null ? amount4.hashCode() : 0)) * 37;
            u uVar = this.next_due;
            int hashCode6 = (((hashCode5 + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.deposit_payment_methods.hashCode()) * 37;
            AutopaySetting autopaySetting = this.autopay_setting;
            int hashCode7 = hashCode6 + (autopaySetting != null ? autopaySetting.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m369newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.payoff_amount != null) {
            arrayList.add("payoff_amount=" + this.payoff_amount);
        }
        if (this.minimum_due != null) {
            arrayList.add("minimum_due=" + this.minimum_due);
        }
        arrayList.add("health_ratio_required=" + b.c(this.health_ratio_required));
        if (this.amount_required != null) {
            arrayList.add("amount_required=" + this.amount_required);
        }
        arrayList.add("health_ratio_recommended=" + b.c(this.health_ratio_recommended));
        if (this.amount_recommended != null) {
            arrayList.add("amount_recommended=" + this.amount_recommended);
        }
        if (this.next_due != null) {
            arrayList.add("next_due=" + this.next_due);
        }
        if (!this.deposit_payment_methods.isEmpty()) {
            arrayList.add("deposit_payment_methods=" + this.deposit_payment_methods);
        }
        if (this.autopay_setting != null) {
            arrayList.add("autopay_setting=" + this.autopay_setting);
        }
        h0 = z.h0(arrayList, ", ", "GetPaymentDetailsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m369newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPaymentDetailsResponse(Amount amount, Amount amount2, String health_ratio_required, Amount amount3, String health_ratio_recommended, Amount amount4, u uVar, List<DepositPaymentMethod> deposit_payment_methods, AutopaySetting autopaySetting, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(health_ratio_required, "health_ratio_required");
        m.h(health_ratio_recommended, "health_ratio_recommended");
        m.h(deposit_payment_methods, "deposit_payment_methods");
        m.h(unknownFields, "unknownFields");
        this.payoff_amount = amount;
        this.minimum_due = amount2;
        this.health_ratio_required = health_ratio_required;
        this.amount_required = amount3;
        this.health_ratio_recommended = health_ratio_recommended;
        this.amount_recommended = amount4;
        this.next_due = uVar;
        this.deposit_payment_methods = deposit_payment_methods;
        this.autopay_setting = autopaySetting;
    }
}