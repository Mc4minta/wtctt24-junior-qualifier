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
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: GetLoanSummaryResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 C2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB¯\u0001\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\bA\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJµ\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u00100R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b2\u00103R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b5\u00106R\u001e\u0010!\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b7\u00103R\u001e\u0010#\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00101\u001a\u0004\b8\u00103R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b9\u00103R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u00101\u001a\u0004\b:\u00103R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010;\u001a\u0004\b<\u0010=R\u001e\u0010 \u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b>\u00103R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\b?\u00103R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b@\u00103¨\u0006D"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanSummaryResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEligibility;", "eligibility", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "max_loan_eligibility", "loan_balance", "collateral", "Lcom/google/protobuf/u;", "next_payment_due", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "status", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "autopay_setting", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPayment;", "upcoming_payments", "amount_due", "additional_borrow", "additional_collateral_required", "additional_collateral_recommended", "available_balance", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEligibility;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanSummaryResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "getStatus", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "Lcom/google/protobuf/u;", "getNext_payment_due", "()Lcom/google/protobuf/u;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEligibility;", "getEligibility", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEligibility;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount_due", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/util/List;", "getUpcoming_payments", "()Ljava/util/List;", "getAdditional_collateral_required", "getAvailable_balance", "getAdditional_collateral_recommended", "getMax_loan_eligibility", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "getAutopay_setting", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "getAdditional_borrow", "getLoan_balance", "getCollateral", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEligibility;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetLoanSummaryResponse extends a {
    public static final ProtoAdapter<GetLoanSummaryResponse> ADAPTER;
    public static final Parcelable.Creator<GetLoanSummaryResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "additionalBorrow", tag = 10)
    private final Amount additional_borrow;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "additionalCollateralRecommended", tag = 12)
    private final Amount additional_collateral_recommended;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "additionalCollateralRequired", tag = 11)
    private final Amount additional_collateral_required;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "amountDue", tag = 9)
    private final Amount amount_due;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopaySetting#ADAPTER", jsonName = "autopaySetting", tag = 7)
    private final AutopaySetting autopay_setting;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "availableBalance", tag = 13)
    private final Amount available_balance;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 4)
    private final Amount collateral;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanEligibility#ADAPTER", tag = 1)
    private final LoanEligibility eligibility;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "loanBalance", tag = 3)
    private final Amount loan_balance;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "maxLoanEligibility", tag = 2)
    private final Amount max_loan_eligibility;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "nextPaymentDue", tag = 5)
    private final u next_payment_due;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatus#ADAPTER", tag = 6)
    private final LoanStatus status;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.UpcomingPayment#ADAPTER", jsonName = "upcomingPayments", label = p.a.REPEATED, tag = 8)
    private final List<UpcomingPayment> upcoming_payments;

    /* compiled from: GetLoanSummaryResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanSummaryResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanSummaryResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetLoanSummaryResponse> protoAdapter = new ProtoAdapter<GetLoanSummaryResponse>(c.LENGTH_DELIMITED, e0.b(GetLoanSummaryResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.GetLoanSummaryResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.GetLoanSummaryResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetLoanSummaryResponse decode(k reader) {
                long j2;
                LoanEligibility loanEligibility;
                LoanEligibility decode;
                m.h(reader, "reader");
                LoanEligibility loanEligibility2 = LoanEligibility.NOT_ELIGIBLE;
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                Amount amount = null;
                Amount amount2 = null;
                Amount amount3 = null;
                u uVar = null;
                LoanStatus loanStatus = null;
                AutopaySetting autopaySetting = null;
                Amount amount4 = null;
                Amount amount5 = null;
                Amount amount6 = null;
                Amount amount7 = null;
                Amount amount8 = null;
                LoanEligibility loanEligibility3 = loanEligibility2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetLoanSummaryResponse(loanEligibility3, amount, amount2, amount3, uVar, loanStatus, autopaySetting, arrayList, amount4, amount5, amount6, amount8, amount7, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            try {
                                decode = LoanEligibility.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                e = e2;
                            }
                            try {
                                x xVar = x.a;
                                loanEligibility = decode;
                                j2 = d2;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                e = e3;
                                loanEligibility3 = decode;
                                j2 = d2;
                                loanEligibility = loanEligibility3;
                                reader.a(g2, c.VARINT, Long.valueOf(e.a));
                                x xVar2 = x.a;
                                loanEligibility3 = loanEligibility;
                                continue;
                                d2 = j2;
                            }
                            loanEligibility3 = loanEligibility;
                            continue;
                            d2 = j2;
                        case 2:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 3:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            uVar = u.a.decode(reader);
                            break;
                        case 6:
                            loanStatus = LoanStatus.ADAPTER.decode(reader);
                            break;
                        case 7:
                            autopaySetting = AutopaySetting.ADAPTER.decode(reader);
                            break;
                        case 8:
                            arrayList.add(UpcomingPayment.ADAPTER.decode(reader));
                            break;
                        case 9:
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        case 10:
                            amount5 = Amount.ADAPTER.decode(reader);
                            break;
                        case 11:
                            amount6 = Amount.ADAPTER.decode(reader);
                            break;
                        case 12:
                            j2 = d2;
                            amount8 = Amount.ADAPTER.decode(reader);
                            continue;
                            d2 = j2;
                        case 13:
                            amount7 = Amount.ADAPTER.decode(reader);
                            break;
                        default:
                            j2 = d2;
                            reader.m(g2);
                            continue;
                            d2 = j2;
                    }
                    j2 = d2;
                    d2 = j2;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetLoanSummaryResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getEligibility() != LoanEligibility.NOT_ELIGIBLE) {
                    LoanEligibility.ADAPTER.encodeWithTag(writer, 1, value.getEligibility());
                }
                if (value.getMax_loan_eligibility() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getMax_loan_eligibility());
                }
                if (value.getLoan_balance() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getLoan_balance());
                }
                if (value.getCollateral() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getCollateral());
                }
                if (value.getNext_payment_due() != null) {
                    u.a.encodeWithTag(writer, 5, value.getNext_payment_due());
                }
                if (value.getStatus() != null) {
                    LoanStatus.ADAPTER.encodeWithTag(writer, 6, value.getStatus());
                }
                if (value.getAutopay_setting() != null) {
                    AutopaySetting.ADAPTER.encodeWithTag(writer, 7, value.getAutopay_setting());
                }
                UpcomingPayment.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.getUpcoming_payments());
                if (value.getAmount_due() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 9, value.getAmount_due());
                }
                if (value.getAdditional_borrow() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 10, value.getAdditional_borrow());
                }
                if (value.getAdditional_collateral_required() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 11, value.getAdditional_collateral_required());
                }
                if (value.getAdditional_collateral_recommended() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 12, value.getAdditional_collateral_recommended());
                }
                if (value.getAvailable_balance() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 13, value.getAvailable_balance());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetLoanSummaryResponse value) {
                m.h(value, "value");
                if (value.getEligibility() == LoanEligibility.NOT_ELIGIBLE) {
                    return 0;
                }
                int encodedSizeWithTag = LoanEligibility.ADAPTER.encodedSizeWithTag(1, value.getEligibility());
                if (value.getMax_loan_eligibility() != null) {
                    ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getMax_loan_eligibility());
                    if (value.getLoan_balance() != null) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getLoan_balance());
                        if (value.getCollateral() != null) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getCollateral());
                            if (value.getNext_payment_due() != null) {
                                int encodedSizeWithTag5 = u.a.encodedSizeWithTag(5, value.getNext_payment_due());
                                if (value.getStatus() != null) {
                                    int encodedSizeWithTag6 = LoanStatus.ADAPTER.encodedSizeWithTag(6, value.getStatus());
                                    if (value.getAutopay_setting() != null) {
                                        int encodedSizeWithTag7 = AutopaySetting.ADAPTER.encodedSizeWithTag(7, value.getAutopay_setting()) + UpcomingPayment.ADAPTER.asRepeated().encodedSizeWithTag(8, value.getUpcoming_payments());
                                        if (value.getAmount_due() != null) {
                                            int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(9, value.getAmount_due());
                                            if (value.getAdditional_borrow() != null) {
                                                int encodedSizeWithTag9 = protoAdapter2.encodedSizeWithTag(10, value.getAdditional_borrow());
                                                if (value.getAdditional_collateral_required() != null) {
                                                    int encodedSizeWithTag10 = protoAdapter2.encodedSizeWithTag(11, value.getAdditional_collateral_required());
                                                    if (value.getAdditional_collateral_recommended() != null) {
                                                        r2 = (value.getAvailable_balance() != null ? protoAdapter2.encodedSizeWithTag(13, value.getAvailable_balance()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(12, value.getAdditional_collateral_recommended());
                                                    }
                                                    r2 += encodedSizeWithTag10;
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
            public GetLoanSummaryResponse redact(GetLoanSummaryResponse value) {
                m.h(value, "value");
                Amount max_loan_eligibility = value.getMax_loan_eligibility();
                Amount redact = max_loan_eligibility != null ? Amount.ADAPTER.redact(max_loan_eligibility) : null;
                Amount loan_balance = value.getLoan_balance();
                Amount redact2 = loan_balance != null ? Amount.ADAPTER.redact(loan_balance) : null;
                Amount collateral = value.getCollateral();
                Amount redact3 = collateral != null ? Amount.ADAPTER.redact(collateral) : null;
                u next_payment_due = value.getNext_payment_due();
                u redact4 = next_payment_due != null ? u.a.redact(next_payment_due) : null;
                LoanStatus status = value.getStatus();
                LoanStatus redact5 = status != null ? LoanStatus.ADAPTER.redact(status) : null;
                AutopaySetting autopay_setting = value.getAutopay_setting();
                AutopaySetting redact6 = autopay_setting != null ? AutopaySetting.ADAPTER.redact(autopay_setting) : null;
                List a = b.a(value.getUpcoming_payments(), UpcomingPayment.ADAPTER);
                Amount amount_due = value.getAmount_due();
                Amount redact7 = amount_due != null ? Amount.ADAPTER.redact(amount_due) : null;
                Amount additional_borrow = value.getAdditional_borrow();
                Amount redact8 = additional_borrow != null ? Amount.ADAPTER.redact(additional_borrow) : null;
                Amount additional_collateral_required = value.getAdditional_collateral_required();
                Amount redact9 = additional_collateral_required != null ? Amount.ADAPTER.redact(additional_collateral_required) : null;
                Amount additional_collateral_recommended = value.getAdditional_collateral_recommended();
                Amount redact10 = additional_collateral_recommended != null ? Amount.ADAPTER.redact(additional_collateral_recommended) : null;
                Amount available_balance = value.getAvailable_balance();
                return GetLoanSummaryResponse.copy$default(value, null, redact, redact2, redact3, redact4, redact5, redact6, a, redact7, redact8, redact9, redact10, available_balance != null ? Amount.ADAPTER.redact(available_balance) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetLoanSummaryResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public /* synthetic */ GetLoanSummaryResponse(LoanEligibility loanEligibility, Amount amount, Amount amount2, Amount amount3, u uVar, LoanStatus loanStatus, AutopaySetting autopaySetting, List list, Amount amount4, Amount amount5, Amount amount6, Amount amount7, Amount amount8, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? LoanEligibility.NOT_ELIGIBLE : loanEligibility, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? null : amount2, (i2 & 8) != 0 ? null : amount3, (i2 & 16) != 0 ? null : uVar, (i2 & 32) != 0 ? null : loanStatus, (i2 & 64) != 0 ? null : autopaySetting, (i2 & 128) != 0 ? r.g() : list, (i2 & 256) != 0 ? null : amount4, (i2 & 512) != 0 ? null : amount5, (i2 & 1024) != 0 ? null : amount6, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? null : amount7, (i2 & 4096) == 0 ? amount8 : null, (i2 & PKIFailureInfo.certRevoked) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetLoanSummaryResponse copy$default(GetLoanSummaryResponse getLoanSummaryResponse, LoanEligibility loanEligibility, Amount amount, Amount amount2, Amount amount3, u uVar, LoanStatus loanStatus, AutopaySetting autopaySetting, List list, Amount amount4, Amount amount5, Amount amount6, Amount amount7, Amount amount8, i iVar, int i2, Object obj) {
        return getLoanSummaryResponse.copy((i2 & 1) != 0 ? getLoanSummaryResponse.eligibility : loanEligibility, (i2 & 2) != 0 ? getLoanSummaryResponse.max_loan_eligibility : amount, (i2 & 4) != 0 ? getLoanSummaryResponse.loan_balance : amount2, (i2 & 8) != 0 ? getLoanSummaryResponse.collateral : amount3, (i2 & 16) != 0 ? getLoanSummaryResponse.next_payment_due : uVar, (i2 & 32) != 0 ? getLoanSummaryResponse.status : loanStatus, (i2 & 64) != 0 ? getLoanSummaryResponse.autopay_setting : autopaySetting, (i2 & 128) != 0 ? getLoanSummaryResponse.upcoming_payments : list, (i2 & 256) != 0 ? getLoanSummaryResponse.amount_due : amount4, (i2 & 512) != 0 ? getLoanSummaryResponse.additional_borrow : amount5, (i2 & 1024) != 0 ? getLoanSummaryResponse.additional_collateral_required : amount6, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? getLoanSummaryResponse.additional_collateral_recommended : amount7, (i2 & 4096) != 0 ? getLoanSummaryResponse.available_balance : amount8, (i2 & PKIFailureInfo.certRevoked) != 0 ? getLoanSummaryResponse.unknownFields() : iVar);
    }

    public final GetLoanSummaryResponse copy(LoanEligibility eligibility, Amount amount, Amount amount2, Amount amount3, u uVar, LoanStatus loanStatus, AutopaySetting autopaySetting, List<UpcomingPayment> upcoming_payments, Amount amount4, Amount amount5, Amount amount6, Amount amount7, Amount amount8, i unknownFields) {
        m.h(eligibility, "eligibility");
        m.h(upcoming_payments, "upcoming_payments");
        m.h(unknownFields, "unknownFields");
        return new GetLoanSummaryResponse(eligibility, amount, amount2, amount3, uVar, loanStatus, autopaySetting, upcoming_payments, amount4, amount5, amount6, amount7, amount8, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetLoanSummaryResponse) {
            GetLoanSummaryResponse getLoanSummaryResponse = (GetLoanSummaryResponse) obj;
            return m.c(unknownFields(), getLoanSummaryResponse.unknownFields()) && this.eligibility == getLoanSummaryResponse.eligibility && m.c(this.max_loan_eligibility, getLoanSummaryResponse.max_loan_eligibility) && m.c(this.loan_balance, getLoanSummaryResponse.loan_balance) && m.c(this.collateral, getLoanSummaryResponse.collateral) && m.c(this.next_payment_due, getLoanSummaryResponse.next_payment_due) && m.c(this.status, getLoanSummaryResponse.status) && m.c(this.autopay_setting, getLoanSummaryResponse.autopay_setting) && m.c(this.upcoming_payments, getLoanSummaryResponse.upcoming_payments) && m.c(this.amount_due, getLoanSummaryResponse.amount_due) && m.c(this.additional_borrow, getLoanSummaryResponse.additional_borrow) && m.c(this.additional_collateral_required, getLoanSummaryResponse.additional_collateral_required) && m.c(this.additional_collateral_recommended, getLoanSummaryResponse.additional_collateral_recommended) && m.c(this.available_balance, getLoanSummaryResponse.available_balance);
        }
        return false;
    }

    public final Amount getAdditional_borrow() {
        return this.additional_borrow;
    }

    public final Amount getAdditional_collateral_recommended() {
        return this.additional_collateral_recommended;
    }

    public final Amount getAdditional_collateral_required() {
        return this.additional_collateral_required;
    }

    public final Amount getAmount_due() {
        return this.amount_due;
    }

    public final AutopaySetting getAutopay_setting() {
        return this.autopay_setting;
    }

    public final Amount getAvailable_balance() {
        return this.available_balance;
    }

    public final Amount getCollateral() {
        return this.collateral;
    }

    public final LoanEligibility getEligibility() {
        return this.eligibility;
    }

    public final Amount getLoan_balance() {
        return this.loan_balance;
    }

    public final Amount getMax_loan_eligibility() {
        return this.max_loan_eligibility;
    }

    public final u getNext_payment_due() {
        return this.next_payment_due;
    }

    public final LoanStatus getStatus() {
        return this.status;
    }

    public final List<UpcomingPayment> getUpcoming_payments() {
        return this.upcoming_payments;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.eligibility.hashCode()) * 37;
            Amount amount = this.max_loan_eligibility;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.loan_balance;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.collateral;
            int hashCode4 = (hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            u uVar = this.next_payment_due;
            int hashCode5 = (hashCode4 + (uVar != null ? uVar.hashCode() : 0)) * 37;
            LoanStatus loanStatus = this.status;
            int hashCode6 = (hashCode5 + (loanStatus != null ? loanStatus.hashCode() : 0)) * 37;
            AutopaySetting autopaySetting = this.autopay_setting;
            int hashCode7 = (((hashCode6 + (autopaySetting != null ? autopaySetting.hashCode() : 0)) * 37) + this.upcoming_payments.hashCode()) * 37;
            Amount amount4 = this.amount_due;
            int hashCode8 = (hashCode7 + (amount4 != null ? amount4.hashCode() : 0)) * 37;
            Amount amount5 = this.additional_borrow;
            int hashCode9 = (hashCode8 + (amount5 != null ? amount5.hashCode() : 0)) * 37;
            Amount amount6 = this.additional_collateral_required;
            int hashCode10 = (hashCode9 + (amount6 != null ? amount6.hashCode() : 0)) * 37;
            Amount amount7 = this.additional_collateral_recommended;
            int hashCode11 = (hashCode10 + (amount7 != null ? amount7.hashCode() : 0)) * 37;
            Amount amount8 = this.available_balance;
            int hashCode12 = hashCode11 + (amount8 != null ? amount8.hashCode() : 0);
            this.hashCode = hashCode12;
            return hashCode12;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m367newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("eligibility=" + this.eligibility);
        if (this.max_loan_eligibility != null) {
            arrayList.add("max_loan_eligibility=" + this.max_loan_eligibility);
        }
        if (this.loan_balance != null) {
            arrayList.add("loan_balance=" + this.loan_balance);
        }
        if (this.collateral != null) {
            arrayList.add("collateral=" + this.collateral);
        }
        if (this.next_payment_due != null) {
            arrayList.add("next_payment_due=" + this.next_payment_due);
        }
        if (this.status != null) {
            arrayList.add("status=" + this.status);
        }
        if (this.autopay_setting != null) {
            arrayList.add("autopay_setting=" + this.autopay_setting);
        }
        if (!this.upcoming_payments.isEmpty()) {
            arrayList.add("upcoming_payments=" + this.upcoming_payments);
        }
        if (this.amount_due != null) {
            arrayList.add("amount_due=" + this.amount_due);
        }
        if (this.additional_borrow != null) {
            arrayList.add("additional_borrow=" + this.additional_borrow);
        }
        if (this.additional_collateral_required != null) {
            arrayList.add("additional_collateral_required=" + this.additional_collateral_required);
        }
        if (this.additional_collateral_recommended != null) {
            arrayList.add("additional_collateral_recommended=" + this.additional_collateral_recommended);
        }
        if (this.available_balance != null) {
            arrayList.add("available_balance=" + this.available_balance);
        }
        h0 = z.h0(arrayList, ", ", "GetLoanSummaryResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m367newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLoanSummaryResponse(LoanEligibility eligibility, Amount amount, Amount amount2, Amount amount3, u uVar, LoanStatus loanStatus, AutopaySetting autopaySetting, List<UpcomingPayment> upcoming_payments, Amount amount4, Amount amount5, Amount amount6, Amount amount7, Amount amount8, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(eligibility, "eligibility");
        m.h(upcoming_payments, "upcoming_payments");
        m.h(unknownFields, "unknownFields");
        this.eligibility = eligibility;
        this.max_loan_eligibility = amount;
        this.loan_balance = amount2;
        this.collateral = amount3;
        this.next_payment_due = uVar;
        this.status = loanStatus;
        this.autopay_setting = autopaySetting;
        this.upcoming_payments = upcoming_payments;
        this.amount_due = amount4;
        this.additional_borrow = amount5;
        this.additional_collateral_required = amount6;
        this.additional_collateral_recommended = amount7;
        this.available_balance = amount8;
    }
}