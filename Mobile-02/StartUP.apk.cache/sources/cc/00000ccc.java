package com.coinbase.android.apiv3.generated.authed.loans;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: Loans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J+\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J+\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020&H'¢\u0006\u0004\b(\u0010)J+\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020*H'¢\u0006\u0004\b,\u0010-J+\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020.H'¢\u0006\u0004\b0\u00101J+\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u000202H'¢\u0006\u0004\b4\u00105J+\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u000206H'¢\u0006\u0004\b8\u00109J+\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020:H'¢\u0006\u0004\b<\u0010=J+\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020>H'¢\u0006\u0004\b@\u0010AJ+\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020BH'¢\u0006\u0004\bD\u0010EJ+\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020FH'¢\u0006\u0004\bH\u0010IJ+\u0010L\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020JH'¢\u0006\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/Loans;", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitAutopayRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitAutopayResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "commitAutopay", "(Lcom/coinbase/android/apiv3/generated/authed/loans/CommitAutopayRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitCollateralChangeRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitCollateralChangeResponse;", "commitCollateralChange", "(Lcom/coinbase/android/apiv3/generated/authed/loans/CommitCollateralChangeRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitLoanRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitLoanResponse;", "commitLoan", "(Lcom/coinbase/android/apiv3/generated/authed/loans/CommitLoanRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitPaymentRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitPaymentResponse;", "commitPayment", "(Lcom/coinbase/android/apiv3/generated/authed/loans/CommitPaymentRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanResponse;", "createLoan", "(Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanStatementRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanStatementResponse;", "createLoanStatement", "(Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanStatementRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetAutopayOptionsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetAutopayOptionsResponse;", "getAutopayOptions", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetAutopayOptionsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetEligibleAccountsForCollateralRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetEligibleAccountsForCollateralResponse;", "getEligibleAccountsForCollateral", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetEligibleAccountsForCollateralRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanResponse;", "getLoan", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanDocumentsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanDocumentsResponse;", "getLoanDocuments", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanDocumentsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanEventsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanEventsResponse;", "getLoanEvents", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanEventsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanIntroRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanIntroResponse;", "getLoanIntro", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanIntroRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanSummaryRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanSummaryResponse;", "getLoanSummary", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanSummaryRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetPaymentDetailsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetPaymentDetailsResponse;", "getPaymentDetails", "(Lcom/coinbase/android/apiv3/generated/authed/loans/GetPaymentDetailsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteAutopayRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteAutopayResponse;", "quoteAutopay", "(Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteAutopayRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteCollateralChangeRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteCollateralChangeResponse;", "quoteCollateralChange", "(Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteCollateralChangeRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteLoanRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteLoanResponse;", "quoteLoan", "(Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteLoanRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuotePaymentRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuotePaymentResponse;", "quotePayment", "(Lcom/coinbase/android/apiv3/generated/authed/loans/QuotePaymentRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface Loans {
    @o("coinbase.public_api.authed.loans.Loans/CommitAutopay")
    b0<NetworkResponse<CommitAutopayResponse, V3Error>> commitAutopay(@a CommitAutopayRequest commitAutopayRequest);

    @o("coinbase.public_api.authed.loans.Loans/CommitCollateralChange")
    b0<NetworkResponse<CommitCollateralChangeResponse, V3Error>> commitCollateralChange(@a CommitCollateralChangeRequest commitCollateralChangeRequest);

    @o("coinbase.public_api.authed.loans.Loans/CommitLoan")
    b0<NetworkResponse<CommitLoanResponse, V3Error>> commitLoan(@a CommitLoanRequest commitLoanRequest);

    @o("coinbase.public_api.authed.loans.Loans/CommitPayment")
    b0<NetworkResponse<CommitPaymentResponse, V3Error>> commitPayment(@a CommitPaymentRequest commitPaymentRequest);

    @o("coinbase.public_api.authed.loans.Loans/CreateLoan")
    b0<NetworkResponse<CreateLoanResponse, V3Error>> createLoan(@a CreateLoanRequest createLoanRequest);

    @o("coinbase.public_api.authed.loans.Loans/CreateLoanStatement")
    b0<NetworkResponse<CreateLoanStatementResponse, V3Error>> createLoanStatement(@a CreateLoanStatementRequest createLoanStatementRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetAutopayOptions")
    b0<NetworkResponse<GetAutopayOptionsResponse, V3Error>> getAutopayOptions(@t("q") GetAutopayOptionsRequest getAutopayOptionsRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetEligibleAccountsForCollateral")
    b0<NetworkResponse<GetEligibleAccountsForCollateralResponse, V3Error>> getEligibleAccountsForCollateral(@t("q") GetEligibleAccountsForCollateralRequest getEligibleAccountsForCollateralRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetLoan")
    b0<NetworkResponse<GetLoanResponse, V3Error>> getLoan(@t("q") GetLoanRequest getLoanRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetLoanDocuments")
    b0<NetworkResponse<GetLoanDocumentsResponse, V3Error>> getLoanDocuments(@t("q") GetLoanDocumentsRequest getLoanDocumentsRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetLoanEvents")
    b0<NetworkResponse<GetLoanEventsResponse, V3Error>> getLoanEvents(@t("q") GetLoanEventsRequest getLoanEventsRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetLoanIntro")
    b0<NetworkResponse<GetLoanIntroResponse, V3Error>> getLoanIntro(@t("q") GetLoanIntroRequest getLoanIntroRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetLoanSummary")
    b0<NetworkResponse<GetLoanSummaryResponse, V3Error>> getLoanSummary(@t("q") GetLoanSummaryRequest getLoanSummaryRequest);

    @f("coinbase.public_api.authed.loans.Loans/GetPaymentDetails")
    b0<NetworkResponse<GetPaymentDetailsResponse, V3Error>> getPaymentDetails(@t("q") GetPaymentDetailsRequest getPaymentDetailsRequest);

    @f("coinbase.public_api.authed.loans.Loans/QuoteAutopay")
    b0<NetworkResponse<QuoteAutopayResponse, V3Error>> quoteAutopay(@t("q") QuoteAutopayRequest quoteAutopayRequest);

    @f("coinbase.public_api.authed.loans.Loans/QuoteCollateralChange")
    b0<NetworkResponse<QuoteCollateralChangeResponse, V3Error>> quoteCollateralChange(@t("q") QuoteCollateralChangeRequest quoteCollateralChangeRequest);

    @o("coinbase.public_api.authed.loans.Loans/QuoteLoan")
    b0<NetworkResponse<QuoteLoanResponse, V3Error>> quoteLoan(@a QuoteLoanRequest quoteLoanRequest);

    @f("coinbase.public_api.authed.loans.Loans/QuotePayment")
    b0<NetworkResponse<QuotePaymentResponse, V3Error>> quotePayment(@t("q") QuotePaymentRequest quotePaymentRequest);
}