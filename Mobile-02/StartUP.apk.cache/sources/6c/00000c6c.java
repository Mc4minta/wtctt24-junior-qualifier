package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.FeeDetails;
import com.coinbase.android.apiv3.generated.resources.Loan;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: CreateLoanResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 E2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB\u009f\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\r\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\bC\u0010DJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ¥\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010#\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'R\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u000fR\u001c\u0010#\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010(\u001a\u0004\b*\u0010\u000fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010-R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u00100R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b1\u0010-R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b2\u0010-R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\b4\u00105R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u00108R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u00109\u001a\u0004\b:\u0010;R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b<\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010=\u001a\u0004\b>\u0010?R\u001e\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010@\u001a\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/resources/Loan;", "loan", "Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;", "legal_agreement_summary", "full_legal_agreement", "legal_agreement_signature_text", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "collateral", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "withdrawal_method", "", "Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "fees", "withdrawal_total", "first_interest_payment", "Lcom/google/protobuf/u;", "first_interest_payment_due", "Lcom/coinbase/android/apiv3/generated/authed/loans/PaymentInfo;", "payment_info", "legal_agreement_url", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/resources/Loan;Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/loans/PaymentInfo;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanResponse;", "Ljava/lang/String;", "getLegal_agreement_signature_text", "getLegal_agreement_url", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getCollateral", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/util/List;", "getFees", "()Ljava/util/List;", "getWithdrawal_total", "getFirst_interest_payment", "Lcom/coinbase/android/apiv3/generated/resources/Loan;", "getLoan", "()Lcom/coinbase/android/apiv3/generated/resources/Loan;", "Lcom/coinbase/android/apiv3/generated/authed/loans/PaymentInfo;", "getPayment_info", "()Lcom/coinbase/android/apiv3/generated/authed/loans/PaymentInfo;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;", "getLegal_agreement_summary", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;", "getFull_legal_agreement", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getWithdrawal_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Lcom/google/protobuf/u;", "getFirst_interest_payment_due", "()Lcom/google/protobuf/u;", "<init>", "(Lcom/coinbase/android/apiv3/generated/resources/Loan;Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/loans/PaymentInfo;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CreateLoanResponse extends a {
    public static final ProtoAdapter<CreateLoanResponse> ADAPTER;
    public static final Parcelable.Creator<CreateLoanResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 5)
    private final Amount collateral;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.FeeDetails#ADAPTER", label = p.a.REPEATED, tag = 7)
    private final List<FeeDetails> fees;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "firstInterestPayment", tag = 9)
    private final Amount first_interest_payment;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "firstInterestPaymentDue", tag = 10)
    private final u first_interest_payment_due;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "fullLegalAgreement", tag = 3)
    private final String full_legal_agreement;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "legalAgreementSignatureText", tag = 4)
    private final String legal_agreement_signature_text;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LegalAgreementSummary#ADAPTER", jsonName = "legalAgreementSummary", tag = 2)
    private final LegalAgreementSummary legal_agreement_summary;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "legalAgreementUrl", tag = 12)
    private final String legal_agreement_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Loan#ADAPTER", tag = 1)
    private final Loan loan;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.PaymentInfo#ADAPTER", jsonName = "paymentInfo", tag = 11)
    private final PaymentInfo payment_info;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "withdrawalMethod", tag = 6)
    private final PaymentMethod withdrawal_method;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "withdrawalTotal", tag = 8)
    private final Amount withdrawal_total;

    /* compiled from: CreateLoanResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<CreateLoanResponse> protoAdapter = new ProtoAdapter<CreateLoanResponse>(c.LENGTH_DELIMITED, e0.b(CreateLoanResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.CreateLoanResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.CreateLoanResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateLoanResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                LegalAgreementSummary legalAgreementSummary = null;
                String str = "";
                String str2 = str;
                String str3 = str2;
                Loan loan = null;
                Amount amount = null;
                PaymentMethod paymentMethod = null;
                Amount amount2 = null;
                Amount amount3 = null;
                u uVar = null;
                PaymentInfo paymentInfo = null;
                while (true) {
                    int g2 = reader.g();
                    String str4 = str3;
                    if (g2 == -1) {
                        return new CreateLoanResponse(loan, legalAgreementSummary, str, str2, amount, paymentMethod, arrayList, amount2, amount3, uVar, paymentInfo, str4, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            loan = Loan.ADAPTER.decode(reader);
                            break;
                        case 2:
                            legalAgreementSummary = LegalAgreementSummary.ADAPTER.decode(reader);
                            break;
                        case 3:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                            break;
                        case 7:
                            arrayList.add(FeeDetails.ADAPTER.decode(reader));
                            break;
                        case 8:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 9:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 10:
                            uVar = u.a.decode(reader);
                            break;
                        case 11:
                            paymentInfo = PaymentInfo.ADAPTER.decode(reader);
                            break;
                        case 12:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        default:
                            reader.m(g2);
                            break;
                    }
                    str3 = str4;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CreateLoanResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getLoan() != null) {
                    Loan.ADAPTER.encodeWithTag(writer, 1, value.getLoan());
                }
                if (value.getLegal_agreement_summary() != null) {
                    LegalAgreementSummary.ADAPTER.encodeWithTag(writer, 2, value.getLegal_agreement_summary());
                }
                if (!m.c(value.getFull_legal_agreement(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getFull_legal_agreement());
                }
                if (!m.c(value.getLegal_agreement_signature_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getLegal_agreement_signature_text());
                }
                if (value.getCollateral() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getCollateral());
                }
                if (value.getWithdrawal_method() != null) {
                    PaymentMethod.ADAPTER.encodeWithTag(writer, 6, value.getWithdrawal_method());
                }
                FeeDetails.ADAPTER.asRepeated().encodeWithTag(writer, 7, value.getFees());
                if (value.getWithdrawal_total() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 8, value.getWithdrawal_total());
                }
                if (value.getFirst_interest_payment() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 9, value.getFirst_interest_payment());
                }
                if (value.getFirst_interest_payment_due() != null) {
                    u.a.encodeWithTag(writer, 10, value.getFirst_interest_payment_due());
                }
                if (value.getPayment_info() != null) {
                    PaymentInfo.ADAPTER.encodeWithTag(writer, 11, value.getPayment_info());
                }
                if (!m.c(value.getLegal_agreement_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.getLegal_agreement_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CreateLoanResponse value) {
                m.h(value, "value");
                if (value.getLoan() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Loan.ADAPTER.encodedSizeWithTag(1, value.getLoan());
                if (value.getLegal_agreement_summary() != null) {
                    int encodedSizeWithTag2 = LegalAgreementSummary.ADAPTER.encodedSizeWithTag(2, value.getLegal_agreement_summary());
                    if (!m.c(value.getFull_legal_agreement(), "")) {
                        ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getFull_legal_agreement());
                        if (!m.c(value.getLegal_agreement_signature_text(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getLegal_agreement_signature_text());
                            if (value.getCollateral() != null) {
                                ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getCollateral());
                                if (value.getWithdrawal_method() != null) {
                                    int encodedSizeWithTag6 = PaymentMethod.ADAPTER.encodedSizeWithTag(6, value.getWithdrawal_method()) + FeeDetails.ADAPTER.asRepeated().encodedSizeWithTag(7, value.getFees());
                                    if (value.getWithdrawal_total() != null) {
                                        int encodedSizeWithTag7 = protoAdapter3.encodedSizeWithTag(8, value.getWithdrawal_total());
                                        if (value.getFirst_interest_payment() != null) {
                                            int encodedSizeWithTag8 = protoAdapter3.encodedSizeWithTag(9, value.getFirst_interest_payment());
                                            if (value.getFirst_interest_payment_due() != null) {
                                                int encodedSizeWithTag9 = u.a.encodedSizeWithTag(10, value.getFirst_interest_payment_due());
                                                if (value.getPayment_info() != null) {
                                                    r2 = (m.c(value.getLegal_agreement_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(12, value.getLegal_agreement_url()) + value.unknownFields().Q()) + PaymentInfo.ADAPTER.encodedSizeWithTag(11, value.getPayment_info());
                                                }
                                                r2 += encodedSizeWithTag9;
                                            }
                                            r2 += encodedSizeWithTag8;
                                        }
                                        r2 += encodedSizeWithTag7;
                                    }
                                    r2 += encodedSizeWithTag6;
                                }
                                r2 += encodedSizeWithTag5;
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CreateLoanResponse redact(CreateLoanResponse value) {
                m.h(value, "value");
                Loan loan = value.getLoan();
                Loan redact = loan != null ? Loan.ADAPTER.redact(loan) : null;
                LegalAgreementSummary legal_agreement_summary = value.getLegal_agreement_summary();
                LegalAgreementSummary redact2 = legal_agreement_summary != null ? LegalAgreementSummary.ADAPTER.redact(legal_agreement_summary) : null;
                Amount collateral = value.getCollateral();
                Amount redact3 = collateral != null ? Amount.ADAPTER.redact(collateral) : null;
                PaymentMethod withdrawal_method = value.getWithdrawal_method();
                PaymentMethod redact4 = withdrawal_method != null ? PaymentMethod.ADAPTER.redact(withdrawal_method) : null;
                List a = b.a(value.getFees(), FeeDetails.ADAPTER);
                Amount withdrawal_total = value.getWithdrawal_total();
                Amount redact5 = withdrawal_total != null ? Amount.ADAPTER.redact(withdrawal_total) : null;
                Amount first_interest_payment = value.getFirst_interest_payment();
                Amount redact6 = first_interest_payment != null ? Amount.ADAPTER.redact(first_interest_payment) : null;
                u first_interest_payment_due = value.getFirst_interest_payment_due();
                u redact7 = first_interest_payment_due != null ? u.a.redact(first_interest_payment_due) : null;
                PaymentInfo payment_info = value.getPayment_info();
                return CreateLoanResponse.copy$default(value, redact, redact2, null, null, redact3, redact4, a, redact5, redact6, redact7, payment_info != null ? PaymentInfo.ADAPTER.redact(payment_info) : null, null, i.a, 2060, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CreateLoanResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public /* synthetic */ CreateLoanResponse(Loan loan, LegalAgreementSummary legalAgreementSummary, String str, String str2, Amount amount, PaymentMethod paymentMethod, List list, Amount amount2, Amount amount3, u uVar, PaymentInfo paymentInfo, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : loan, (i2 & 2) != 0 ? null : legalAgreementSummary, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? null : amount, (i2 & 32) != 0 ? null : paymentMethod, (i2 & 64) != 0 ? r.g() : list, (i2 & 128) != 0 ? null : amount2, (i2 & 256) != 0 ? null : amount3, (i2 & 512) != 0 ? null : uVar, (i2 & 1024) == 0 ? paymentInfo : null, (i2 & PKIFailureInfo.wrongIntegrity) == 0 ? str3 : "", (i2 & 4096) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateLoanResponse copy$default(CreateLoanResponse createLoanResponse, Loan loan, LegalAgreementSummary legalAgreementSummary, String str, String str2, Amount amount, PaymentMethod paymentMethod, List list, Amount amount2, Amount amount3, u uVar, PaymentInfo paymentInfo, String str3, i iVar, int i2, Object obj) {
        return createLoanResponse.copy((i2 & 1) != 0 ? createLoanResponse.loan : loan, (i2 & 2) != 0 ? createLoanResponse.legal_agreement_summary : legalAgreementSummary, (i2 & 4) != 0 ? createLoanResponse.full_legal_agreement : str, (i2 & 8) != 0 ? createLoanResponse.legal_agreement_signature_text : str2, (i2 & 16) != 0 ? createLoanResponse.collateral : amount, (i2 & 32) != 0 ? createLoanResponse.withdrawal_method : paymentMethod, (i2 & 64) != 0 ? createLoanResponse.fees : list, (i2 & 128) != 0 ? createLoanResponse.withdrawal_total : amount2, (i2 & 256) != 0 ? createLoanResponse.first_interest_payment : amount3, (i2 & 512) != 0 ? createLoanResponse.first_interest_payment_due : uVar, (i2 & 1024) != 0 ? createLoanResponse.payment_info : paymentInfo, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? createLoanResponse.legal_agreement_url : str3, (i2 & 4096) != 0 ? createLoanResponse.unknownFields() : iVar);
    }

    public final CreateLoanResponse copy(Loan loan, LegalAgreementSummary legalAgreementSummary, String full_legal_agreement, String legal_agreement_signature_text, Amount amount, PaymentMethod paymentMethod, List<FeeDetails> fees, Amount amount2, Amount amount3, u uVar, PaymentInfo paymentInfo, String legal_agreement_url, i unknownFields) {
        m.h(full_legal_agreement, "full_legal_agreement");
        m.h(legal_agreement_signature_text, "legal_agreement_signature_text");
        m.h(fees, "fees");
        m.h(legal_agreement_url, "legal_agreement_url");
        m.h(unknownFields, "unknownFields");
        return new CreateLoanResponse(loan, legalAgreementSummary, full_legal_agreement, legal_agreement_signature_text, amount, paymentMethod, fees, amount2, amount3, uVar, paymentInfo, legal_agreement_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreateLoanResponse) {
            CreateLoanResponse createLoanResponse = (CreateLoanResponse) obj;
            return m.c(unknownFields(), createLoanResponse.unknownFields()) && m.c(this.loan, createLoanResponse.loan) && m.c(this.legal_agreement_summary, createLoanResponse.legal_agreement_summary) && m.c(this.full_legal_agreement, createLoanResponse.full_legal_agreement) && m.c(this.legal_agreement_signature_text, createLoanResponse.legal_agreement_signature_text) && m.c(this.collateral, createLoanResponse.collateral) && m.c(this.withdrawal_method, createLoanResponse.withdrawal_method) && m.c(this.fees, createLoanResponse.fees) && m.c(this.withdrawal_total, createLoanResponse.withdrawal_total) && m.c(this.first_interest_payment, createLoanResponse.first_interest_payment) && m.c(this.first_interest_payment_due, createLoanResponse.first_interest_payment_due) && m.c(this.payment_info, createLoanResponse.payment_info) && m.c(this.legal_agreement_url, createLoanResponse.legal_agreement_url);
        }
        return false;
    }

    public final Amount getCollateral() {
        return this.collateral;
    }

    public final List<FeeDetails> getFees() {
        return this.fees;
    }

    public final Amount getFirst_interest_payment() {
        return this.first_interest_payment;
    }

    public final u getFirst_interest_payment_due() {
        return this.first_interest_payment_due;
    }

    public final String getFull_legal_agreement() {
        return this.full_legal_agreement;
    }

    public final String getLegal_agreement_signature_text() {
        return this.legal_agreement_signature_text;
    }

    public final LegalAgreementSummary getLegal_agreement_summary() {
        return this.legal_agreement_summary;
    }

    public final String getLegal_agreement_url() {
        return this.legal_agreement_url;
    }

    public final Loan getLoan() {
        return this.loan;
    }

    public final PaymentInfo getPayment_info() {
        return this.payment_info;
    }

    public final PaymentMethod getWithdrawal_method() {
        return this.withdrawal_method;
    }

    public final Amount getWithdrawal_total() {
        return this.withdrawal_total;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Loan loan = this.loan;
            int hashCode2 = (hashCode + (loan != null ? loan.hashCode() : 0)) * 37;
            LegalAgreementSummary legalAgreementSummary = this.legal_agreement_summary;
            int hashCode3 = (((((hashCode2 + (legalAgreementSummary != null ? legalAgreementSummary.hashCode() : 0)) * 37) + this.full_legal_agreement.hashCode()) * 37) + this.legal_agreement_signature_text.hashCode()) * 37;
            Amount amount = this.collateral;
            int hashCode4 = (hashCode3 + (amount != null ? amount.hashCode() : 0)) * 37;
            PaymentMethod paymentMethod = this.withdrawal_method;
            int hashCode5 = (((hashCode4 + (paymentMethod != null ? paymentMethod.hashCode() : 0)) * 37) + this.fees.hashCode()) * 37;
            Amount amount2 = this.withdrawal_total;
            int hashCode6 = (hashCode5 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.first_interest_payment;
            int hashCode7 = (hashCode6 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            u uVar = this.first_interest_payment_due;
            int hashCode8 = (hashCode7 + (uVar != null ? uVar.hashCode() : 0)) * 37;
            PaymentInfo paymentInfo = this.payment_info;
            int hashCode9 = ((hashCode8 + (paymentInfo != null ? paymentInfo.hashCode() : 0)) * 37) + this.legal_agreement_url.hashCode();
            this.hashCode = hashCode9;
            return hashCode9;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m349newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.loan != null) {
            arrayList.add("loan=" + this.loan);
        }
        if (this.legal_agreement_summary != null) {
            arrayList.add("legal_agreement_summary=" + this.legal_agreement_summary);
        }
        arrayList.add("full_legal_agreement=" + b.c(this.full_legal_agreement));
        arrayList.add("legal_agreement_signature_text=" + b.c(this.legal_agreement_signature_text));
        if (this.collateral != null) {
            arrayList.add("collateral=" + this.collateral);
        }
        if (this.withdrawal_method != null) {
            arrayList.add("withdrawal_method=" + this.withdrawal_method);
        }
        if (!this.fees.isEmpty()) {
            arrayList.add("fees=" + this.fees);
        }
        if (this.withdrawal_total != null) {
            arrayList.add("withdrawal_total=" + this.withdrawal_total);
        }
        if (this.first_interest_payment != null) {
            arrayList.add("first_interest_payment=" + this.first_interest_payment);
        }
        if (this.first_interest_payment_due != null) {
            arrayList.add("first_interest_payment_due=" + this.first_interest_payment_due);
        }
        if (this.payment_info != null) {
            arrayList.add("payment_info=" + this.payment_info);
        }
        arrayList.add("legal_agreement_url=" + b.c(this.legal_agreement_url));
        h0 = z.h0(arrayList, ", ", "CreateLoanResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m349newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateLoanResponse(Loan loan, LegalAgreementSummary legalAgreementSummary, String full_legal_agreement, String legal_agreement_signature_text, Amount amount, PaymentMethod paymentMethod, List<FeeDetails> fees, Amount amount2, Amount amount3, u uVar, PaymentInfo paymentInfo, String legal_agreement_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(full_legal_agreement, "full_legal_agreement");
        m.h(legal_agreement_signature_text, "legal_agreement_signature_text");
        m.h(fees, "fees");
        m.h(legal_agreement_url, "legal_agreement_url");
        m.h(unknownFields, "unknownFields");
        this.loan = loan;
        this.legal_agreement_summary = legalAgreementSummary;
        this.full_legal_agreement = full_legal_agreement;
        this.legal_agreement_signature_text = legal_agreement_signature_text;
        this.collateral = amount;
        this.withdrawal_method = paymentMethod;
        this.fees = fees;
        this.withdrawal_total = amount2;
        this.first_interest_payment = amount3;
        this.first_interest_payment_due = uVar;
        this.payment_info = paymentInfo;
        this.legal_agreement_url = legal_agreement_url;
    }
}