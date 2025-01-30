package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.FeeDetails;
import com.coinbase.android.apiv3.generated.resources.PaymentMethod;
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

/* compiled from: QuotePaymentResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0081\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0087\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b&\u0010%R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b'\u0010%R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u00100R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b1\u00100R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\b3\u00104R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b5\u0010%¨\u00069"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/QuotePaymentResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "subtotal", "", "Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "fees", ApiConstants.TOTAL, "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "payment_method", "remaining_loan_balance", "remaining_amount_due", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "autopay_setting", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "status_before", "status_after", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/QuotePaymentResponse;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getRemaining_loan_balance", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getSubtotal", "getRemaining_amount_due", "Ljava/util/List;", "getFees", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "getAutopay_setting", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "getStatus_before", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "getStatus_after", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getTotal", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class QuotePaymentResponse extends a {
    public static final ProtoAdapter<QuotePaymentResponse> ADAPTER;
    public static final Parcelable.Creator<QuotePaymentResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopaySetting#ADAPTER", jsonName = "autopaySetting", tag = 7)
    private final AutopaySetting autopay_setting;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.FeeDetails#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<FeeDetails> fees;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "paymentMethod", tag = 4)
    private final PaymentMethod payment_method;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "remainingAmountDue", tag = 6)
    private final Amount remaining_amount_due;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "remainingLoanBalance", tag = 5)
    private final Amount remaining_loan_balance;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatus#ADAPTER", jsonName = "statusAfter", tag = 9)
    private final LoanStatus status_after;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatus#ADAPTER", jsonName = "statusBefore", tag = 8)
    private final LoanStatus status_before;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 1)
    private final Amount subtotal;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 3)
    private final Amount total;

    /* compiled from: QuotePaymentResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/QuotePaymentResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuotePaymentResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<QuotePaymentResponse> protoAdapter = new ProtoAdapter<QuotePaymentResponse>(c.LENGTH_DELIMITED, e0.b(QuotePaymentResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.QuotePaymentResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.QuotePaymentResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public QuotePaymentResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                Amount amount = null;
                Amount amount2 = null;
                PaymentMethod paymentMethod = null;
                Amount amount3 = null;
                Amount amount4 = null;
                AutopaySetting autopaySetting = null;
                LoanStatus loanStatus = null;
                LoanStatus loanStatus2 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new QuotePaymentResponse(amount, arrayList, amount2, paymentMethod, amount3, amount4, autopaySetting, loanStatus, loanStatus2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 2:
                            arrayList.add(FeeDetails.ADAPTER.decode(reader));
                            break;
                        case 3:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                            break;
                        case 5:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            autopaySetting = AutopaySetting.ADAPTER.decode(reader);
                            break;
                        case 8:
                            loanStatus = LoanStatus.ADAPTER.decode(reader);
                            break;
                        case 9:
                            loanStatus2 = LoanStatus.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, QuotePaymentResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getSubtotal() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getSubtotal());
                }
                FeeDetails.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getFees());
                if (value.getTotal() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getTotal());
                }
                if (value.getPayment_method() != null) {
                    PaymentMethod.ADAPTER.encodeWithTag(writer, 4, value.getPayment_method());
                }
                if (value.getRemaining_loan_balance() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getRemaining_loan_balance());
                }
                if (value.getRemaining_amount_due() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getRemaining_amount_due());
                }
                if (value.getAutopay_setting() != null) {
                    AutopaySetting.ADAPTER.encodeWithTag(writer, 7, value.getAutopay_setting());
                }
                if (value.getStatus_before() != null) {
                    LoanStatus.ADAPTER.encodeWithTag(writer, 8, value.getStatus_before());
                }
                if (value.getStatus_after() != null) {
                    LoanStatus.ADAPTER.encodeWithTag(writer, 9, value.getStatus_after());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(QuotePaymentResponse value) {
                m.h(value, "value");
                if (value.getSubtotal() == null) {
                    return 0;
                }
                ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getSubtotal()) + FeeDetails.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getFees());
                if (value.getTotal() != null) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(3, value.getTotal());
                    if (value.getPayment_method() != null) {
                        int encodedSizeWithTag3 = PaymentMethod.ADAPTER.encodedSizeWithTag(4, value.getPayment_method());
                        if (value.getRemaining_loan_balance() != null) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(5, value.getRemaining_loan_balance());
                            if (value.getRemaining_amount_due() != null) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(6, value.getRemaining_amount_due());
                                if (value.getAutopay_setting() != null) {
                                    int encodedSizeWithTag6 = AutopaySetting.ADAPTER.encodedSizeWithTag(7, value.getAutopay_setting());
                                    if (value.getStatus_before() != null) {
                                        ProtoAdapter<LoanStatus> protoAdapter3 = LoanStatus.ADAPTER;
                                        r1 = (value.getStatus_after() != null ? protoAdapter3.encodedSizeWithTag(9, value.getStatus_after()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(8, value.getStatus_before());
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
            public QuotePaymentResponse redact(QuotePaymentResponse value) {
                m.h(value, "value");
                Amount subtotal = value.getSubtotal();
                Amount redact = subtotal != null ? Amount.ADAPTER.redact(subtotal) : null;
                List<FeeDetails> a = b.a(value.getFees(), FeeDetails.ADAPTER);
                Amount total = value.getTotal();
                Amount redact2 = total != null ? Amount.ADAPTER.redact(total) : null;
                PaymentMethod payment_method = value.getPayment_method();
                PaymentMethod redact3 = payment_method != null ? PaymentMethod.ADAPTER.redact(payment_method) : null;
                Amount remaining_loan_balance = value.getRemaining_loan_balance();
                Amount redact4 = remaining_loan_balance != null ? Amount.ADAPTER.redact(remaining_loan_balance) : null;
                Amount remaining_amount_due = value.getRemaining_amount_due();
                Amount redact5 = remaining_amount_due != null ? Amount.ADAPTER.redact(remaining_amount_due) : null;
                AutopaySetting autopay_setting = value.getAutopay_setting();
                AutopaySetting redact6 = autopay_setting != null ? AutopaySetting.ADAPTER.redact(autopay_setting) : null;
                LoanStatus status_before = value.getStatus_before();
                LoanStatus redact7 = status_before != null ? LoanStatus.ADAPTER.redact(status_before) : null;
                LoanStatus status_after = value.getStatus_after();
                return value.copy(redact, a, redact2, redact3, redact4, redact5, redact6, redact7, status_after != null ? LoanStatus.ADAPTER.redact(status_after) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public QuotePaymentResponse() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ QuotePaymentResponse(Amount amount, List list, Amount amount2, PaymentMethod paymentMethod, Amount amount3, Amount amount4, AutopaySetting autopaySetting, LoanStatus loanStatus, LoanStatus loanStatus2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? null : amount2, (i2 & 8) != 0 ? null : paymentMethod, (i2 & 16) != 0 ? null : amount3, (i2 & 32) != 0 ? null : amount4, (i2 & 64) != 0 ? null : autopaySetting, (i2 & 128) != 0 ? null : loanStatus, (i2 & 256) == 0 ? loanStatus2 : null, (i2 & 512) != 0 ? i.a : iVar);
    }

    public final QuotePaymentResponse copy(Amount amount, List<FeeDetails> fees, Amount amount2, PaymentMethod paymentMethod, Amount amount3, Amount amount4, AutopaySetting autopaySetting, LoanStatus loanStatus, LoanStatus loanStatus2, i unknownFields) {
        m.h(fees, "fees");
        m.h(unknownFields, "unknownFields");
        return new QuotePaymentResponse(amount, fees, amount2, paymentMethod, amount3, amount4, autopaySetting, loanStatus, loanStatus2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof QuotePaymentResponse) {
            QuotePaymentResponse quotePaymentResponse = (QuotePaymentResponse) obj;
            return m.c(unknownFields(), quotePaymentResponse.unknownFields()) && m.c(this.subtotal, quotePaymentResponse.subtotal) && m.c(this.fees, quotePaymentResponse.fees) && m.c(this.total, quotePaymentResponse.total) && m.c(this.payment_method, quotePaymentResponse.payment_method) && m.c(this.remaining_loan_balance, quotePaymentResponse.remaining_loan_balance) && m.c(this.remaining_amount_due, quotePaymentResponse.remaining_amount_due) && m.c(this.autopay_setting, quotePaymentResponse.autopay_setting) && m.c(this.status_before, quotePaymentResponse.status_before) && m.c(this.status_after, quotePaymentResponse.status_after);
        }
        return false;
    }

    public final AutopaySetting getAutopay_setting() {
        return this.autopay_setting;
    }

    public final List<FeeDetails> getFees() {
        return this.fees;
    }

    public final PaymentMethod getPayment_method() {
        return this.payment_method;
    }

    public final Amount getRemaining_amount_due() {
        return this.remaining_amount_due;
    }

    public final Amount getRemaining_loan_balance() {
        return this.remaining_loan_balance;
    }

    public final LoanStatus getStatus_after() {
        return this.status_after;
    }

    public final LoanStatus getStatus_before() {
        return this.status_before;
    }

    public final Amount getSubtotal() {
        return this.subtotal;
    }

    public final Amount getTotal() {
        return this.total;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.subtotal;
            int hashCode2 = (((hashCode + (amount != null ? amount.hashCode() : 0)) * 37) + this.fees.hashCode()) * 37;
            Amount amount2 = this.total;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            PaymentMethod paymentMethod = this.payment_method;
            int hashCode4 = (hashCode3 + (paymentMethod != null ? paymentMethod.hashCode() : 0)) * 37;
            Amount amount3 = this.remaining_loan_balance;
            int hashCode5 = (hashCode4 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            Amount amount4 = this.remaining_amount_due;
            int hashCode6 = (hashCode5 + (amount4 != null ? amount4.hashCode() : 0)) * 37;
            AutopaySetting autopaySetting = this.autopay_setting;
            int hashCode7 = (hashCode6 + (autopaySetting != null ? autopaySetting.hashCode() : 0)) * 37;
            LoanStatus loanStatus = this.status_before;
            int hashCode8 = (hashCode7 + (loanStatus != null ? loanStatus.hashCode() : 0)) * 37;
            LoanStatus loanStatus2 = this.status_after;
            int hashCode9 = hashCode8 + (loanStatus2 != null ? loanStatus2.hashCode() : 0);
            this.hashCode = hashCode9;
            return hashCode9;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m386newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.subtotal != null) {
            arrayList.add("subtotal=" + this.subtotal);
        }
        if (!this.fees.isEmpty()) {
            arrayList.add("fees=" + this.fees);
        }
        if (this.total != null) {
            arrayList.add("total=" + this.total);
        }
        if (this.payment_method != null) {
            arrayList.add("payment_method=" + this.payment_method);
        }
        if (this.remaining_loan_balance != null) {
            arrayList.add("remaining_loan_balance=" + this.remaining_loan_balance);
        }
        if (this.remaining_amount_due != null) {
            arrayList.add("remaining_amount_due=" + this.remaining_amount_due);
        }
        if (this.autopay_setting != null) {
            arrayList.add("autopay_setting=" + this.autopay_setting);
        }
        if (this.status_before != null) {
            arrayList.add("status_before=" + this.status_before);
        }
        if (this.status_after != null) {
            arrayList.add("status_after=" + this.status_after);
        }
        h0 = z.h0(arrayList, ", ", "QuotePaymentResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m386newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuotePaymentResponse(Amount amount, List<FeeDetails> fees, Amount amount2, PaymentMethod paymentMethod, Amount amount3, Amount amount4, AutopaySetting autopaySetting, LoanStatus loanStatus, LoanStatus loanStatus2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(fees, "fees");
        m.h(unknownFields, "unknownFields");
        this.subtotal = amount;
        this.fees = fees;
        this.total = amount2;
        this.payment_method = paymentMethod;
        this.remaining_loan_balance = amount3;
        this.remaining_amount_due = amount4;
        this.autopay_setting = autopaySetting;
        this.status_before = loanStatus;
        this.status_after = loanStatus2;
    }
}