package com.coinbase.android.apiv3.generated.authed.card;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: Card.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J+\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J+\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020&H'¢\u0006\u0004\b(\u0010)J+\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020*H'¢\u0006\u0004\b,\u0010-J+\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020.H'¢\u0006\u0004\b0\u00101J+\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u000202H'¢\u0006\u0004\b4\u00105J+\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u000206H'¢\u0006\u0004\b8\u00109J+\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020:H'¢\u0006\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/Card;", "", "Lcom/coinbase/android/apiv3/generated/authed/card/CreateApplicationRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/card/CreateApplicationResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "createApplication", "(Lcom/coinbase/android/apiv3/generated/authed/card/CreateApplicationRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationPrefillInfoRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationPrefillInfoResponse;", "getApplicationPrefillInfo", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationPrefillInfoRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationStatusRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationStatusResponse;", "getApplicationStatus", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationStatusRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIntroductionMessagesRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIntroductionMessagesResponse;", "getCardIntroductionMessages", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIntroductionMessagesRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIsReadyMessagesRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIsReadyMessagesResponse;", "getCardIsReadyMessages", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIsReadyMessagesRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardSummaryRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardSummaryResponse;", "getCardSummary", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetCardSummaryRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetPendingApplicationMoreInfoRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetPendingApplicationMoreInfoResponse;", "getPendingApplicationMoreInfo", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetPendingApplicationMoreInfoRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetRewardsSummaryRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetRewardsSummaryResponse;", "getRewardsSummary", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetRewardsSummaryRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetUserIsRejectedMessagesRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetUserIsRejectedMessagesResponse;", "getUserIsRejectedMessages", "(Lcom/coinbase/android/apiv3/generated/authed/card/GetUserIsRejectedMessagesRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/ListRewardsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/ListRewardsResponse;", "listRewards", "(Lcom/coinbase/android/apiv3/generated/authed/card/ListRewardsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/ListSpendableAssetsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/ListSpendableAssetsResponse;", "listSpendableAssets", "(Lcom/coinbase/android/apiv3/generated/authed/card/ListSpendableAssetsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/ListTransactionsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/ListTransactionsResponse;", "listTransactions", "(Lcom/coinbase/android/apiv3/generated/authed/card/ListTransactionsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/SetRewardProgramRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/SetRewardProgramResponse;", "setRewardProgram", "(Lcom/coinbase/android/apiv3/generated/authed/card/SetRewardProgramRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/card/SetSpendableAssetRequest;", "Lcom/coinbase/android/apiv3/generated/authed/card/SetSpendableAssetResponse;", "setSpendableAsset", "(Lcom/coinbase/android/apiv3/generated/authed/card/SetSpendableAssetRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface Card {
    @o("coinbase.public_api.authed.card.Card/CreateApplication")
    b0<NetworkResponse<CreateApplicationResponse, V3Error>> createApplication(@a CreateApplicationRequest createApplicationRequest);

    @f("coinbase.public_api.authed.card.Card/GetApplicationPrefillInfo")
    b0<NetworkResponse<GetApplicationPrefillInfoResponse, V3Error>> getApplicationPrefillInfo(@t("q") GetApplicationPrefillInfoRequest getApplicationPrefillInfoRequest);

    @f("coinbase.public_api.authed.card.Card/GetApplicationStatus")
    b0<NetworkResponse<GetApplicationStatusResponse, V3Error>> getApplicationStatus(@t("q") GetApplicationStatusRequest getApplicationStatusRequest);

    @f("coinbase.public_api.authed.card.Card/GetCardIntroductionMessages")
    b0<NetworkResponse<GetCardIntroductionMessagesResponse, V3Error>> getCardIntroductionMessages(@t("q") GetCardIntroductionMessagesRequest getCardIntroductionMessagesRequest);

    @f("coinbase.public_api.authed.card.Card/GetCardIsReadyMessages")
    b0<NetworkResponse<GetCardIsReadyMessagesResponse, V3Error>> getCardIsReadyMessages(@t("q") GetCardIsReadyMessagesRequest getCardIsReadyMessagesRequest);

    @f("coinbase.public_api.authed.card.Card/GetCardSummary")
    b0<NetworkResponse<GetCardSummaryResponse, V3Error>> getCardSummary(@t("q") GetCardSummaryRequest getCardSummaryRequest);

    @f("coinbase.public_api.authed.card.Card/GetPendingApplicationMoreInfo")
    b0<NetworkResponse<GetPendingApplicationMoreInfoResponse, V3Error>> getPendingApplicationMoreInfo(@t("q") GetPendingApplicationMoreInfoRequest getPendingApplicationMoreInfoRequest);

    @f("coinbase.public_api.authed.card.Card/GetRewardsSummary")
    b0<NetworkResponse<GetRewardsSummaryResponse, V3Error>> getRewardsSummary(@t("q") GetRewardsSummaryRequest getRewardsSummaryRequest);

    @f("coinbase.public_api.authed.card.Card/GetUserIsRejectedMessages")
    b0<NetworkResponse<GetUserIsRejectedMessagesResponse, V3Error>> getUserIsRejectedMessages(@t("q") GetUserIsRejectedMessagesRequest getUserIsRejectedMessagesRequest);

    @f("coinbase.public_api.authed.card.Card/ListRewards")
    b0<NetworkResponse<ListRewardsResponse, V3Error>> listRewards(@t("q") ListRewardsRequest listRewardsRequest);

    @f("coinbase.public_api.authed.card.Card/ListSpendableAssets")
    b0<NetworkResponse<ListSpendableAssetsResponse, V3Error>> listSpendableAssets(@t("q") ListSpendableAssetsRequest listSpendableAssetsRequest);

    @f("coinbase.public_api.authed.card.Card/ListTransactions")
    b0<NetworkResponse<ListTransactionsResponse, V3Error>> listTransactions(@t("q") ListTransactionsRequest listTransactionsRequest);

    @f("coinbase.public_api.authed.card.Card/SetRewardProgram")
    b0<NetworkResponse<SetRewardProgramResponse, V3Error>> setRewardProgram(@t("q") SetRewardProgramRequest setRewardProgramRequest);

    @f("coinbase.public_api.authed.card.Card/SetSpendableAsset")
    b0<NetworkResponse<SetSpendableAssetResponse, V3Error>> setSpendableAsset(@t("q") SetSpendableAssetRequest setSpendableAssetRequest);
}