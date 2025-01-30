package com.coinbase.android.apiv3.generated.unauthed.loyalty;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.t;

/* compiled from: UnauthedLoyaltyService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/UnauthedLoyaltyService;", "", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/GetCampaignRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/GetCampaignResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "getCampaign", "(Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/GetCampaignRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/ListCampaignsRequest;", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/ListCampaignsResponse;", "listCampaigns", "(Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/ListCampaignsRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface UnauthedLoyaltyService {
    @f("coinbase.public_api.unauthed.loyalty.UnauthedLoyaltyService/GetCampaign")
    b0<NetworkResponse<GetCampaignResponse, V3Error>> getCampaign(@t("q") GetCampaignRequest getCampaignRequest);

    @f("coinbase.public_api.unauthed.loyalty.UnauthedLoyaltyService/ListCampaigns")
    b0<NetworkResponse<ListCampaignsResponse, V3Error>> listCampaigns(@t("q") ListCampaignsRequest listCampaignsRequest);
}