package com.coinbase.android.apiv3.generated.unauthed.proofing;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.t;

/* compiled from: BasicDiligence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/proofing/BasicDiligence;", "", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListAnnualIncomeRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListAnnualIncomeResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "listAnnualIncome", "(Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListAnnualIncomeRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerIndustryRequest;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerIndustryResponse;", "listEmployerIndustry", "(Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerIndustryRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerNameRequest;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerNameResponse;", "listEmployerName", "(Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerNameRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListExpectedCryptoTradePerYearRequest;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListExpectedCryptoTradePerYearResponse;", "listExpectedCryptoTradePerYear", "(Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListExpectedCryptoTradePerYearRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface BasicDiligence {
    @f("coinbase.public_api.unauthed.proofing.BasicDiligence/ListAnnualIncome")
    b0<NetworkResponse<ListAnnualIncomeResponse, V3Error>> listAnnualIncome(@t("q") ListAnnualIncomeRequest listAnnualIncomeRequest);

    @f("coinbase.public_api.unauthed.proofing.BasicDiligence/ListEmployerIndustry")
    b0<NetworkResponse<ListEmployerIndustryResponse, V3Error>> listEmployerIndustry(@t("q") ListEmployerIndustryRequest listEmployerIndustryRequest);

    @f("coinbase.public_api.unauthed.proofing.BasicDiligence/ListEmployerName")
    b0<NetworkResponse<ListEmployerNameResponse, V3Error>> listEmployerName(@t("q") ListEmployerNameRequest listEmployerNameRequest);

    @f("coinbase.public_api.unauthed.proofing.BasicDiligence/ListExpectedCryptoTradePerYear")
    b0<NetworkResponse<ListExpectedCryptoTradePerYearResponse, V3Error>> listExpectedCryptoTradePerYear(@t("q") ListExpectedCryptoTradePerYearRequest listExpectedCryptoTradePerYearRequest);
}