package com.coinbase.android.apiv3.generated.authed.loyalty;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: LoyaltyService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyService;", "", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnLessonRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnLessonResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "getEarnLesson", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnLessonRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnQuizRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnQuizResponse;", "getEarnQuiz", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnQuizRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Request;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Response;", "getLoyaltyCardV2", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltyCardV2Request;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltySummaryRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltySummaryResponse;", "getLoyaltySummary", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetLoyaltySummaryRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsResponse;", "listLoyaltyCards", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsV2Request;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsV2Response;", "listLoyaltyCardsV2", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/ListLoyaltyCardsV2Request;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerRequest;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerResponse;", "postEarnQuizAnswer", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface LoyaltyService {
    @f("coinbase.public_api.authed.loyalty.LoyaltyService/GetEarnLesson")
    b0<NetworkResponse<GetEarnLessonResponse, V3Error>> getEarnLesson(@t("q") GetEarnLessonRequest getEarnLessonRequest);

    @f("coinbase.public_api.authed.loyalty.LoyaltyService/GetEarnQuiz")
    b0<NetworkResponse<GetEarnQuizResponse, V3Error>> getEarnQuiz(@t("q") GetEarnQuizRequest getEarnQuizRequest);

    @f("coinbase.public_api.authed.loyalty.LoyaltyService/GetLoyaltyCardV2")
    b0<NetworkResponse<GetLoyaltyCardV2Response, V3Error>> getLoyaltyCardV2(@t("q") GetLoyaltyCardV2Request getLoyaltyCardV2Request);

    @f("coinbase.public_api.authed.loyalty.LoyaltyService/GetLoyaltySummary")
    b0<NetworkResponse<GetLoyaltySummaryResponse, V3Error>> getLoyaltySummary(@t("q") GetLoyaltySummaryRequest getLoyaltySummaryRequest);

    @f("coinbase.public_api.authed.loyalty.LoyaltyService/ListLoyaltyCards")
    b0<NetworkResponse<ListLoyaltyCardsResponse, V3Error>> listLoyaltyCards(@t("q") ListLoyaltyCardsRequest listLoyaltyCardsRequest);

    @f("coinbase.public_api.authed.loyalty.LoyaltyService/ListLoyaltyCardsV2")
    b0<NetworkResponse<ListLoyaltyCardsV2Response, V3Error>> listLoyaltyCardsV2(@t("q") ListLoyaltyCardsV2Request listLoyaltyCardsV2Request);

    @o("coinbase.public_api.authed.loyalty.LoyaltyService/PostEarnQuizAnswer")
    b0<NetworkResponse<PostEarnQuizAnswerResponse, V3Error>> postEarnQuizAnswer(@a PostEarnQuizAnswerRequest postEarnQuizAnswerRequest);
}