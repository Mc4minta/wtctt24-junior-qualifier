package com.coinbase.android.apiv3.generated.authed.user_tracking_params_service;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: UserTrackingParamsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UserTrackingParamsService;", "", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/GetConsentInformationRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/ConsentInformationResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "getConsentInformation", "(Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/GetConsentInformationRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateConsentInformationRequest;", "updateConsentInformation", "(Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateConsentInformationRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateTrackingParamsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateTrackingParamsResponse;", "updateTrackingParams", "(Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateTrackingParamsRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface UserTrackingParamsService {
    @f("coinbase.public_api.authed.user_tracking_params_service.UserTrackingParamsService/GetConsentInformation")
    b0<NetworkResponse<ConsentInformationResponse, V3Error>> getConsentInformation(@t("q") GetConsentInformationRequest getConsentInformationRequest);

    @o("coinbase.public_api.authed.user_tracking_params_service.UserTrackingParamsService/UpdateConsentInformation")
    b0<NetworkResponse<ConsentInformationResponse, V3Error>> updateConsentInformation(@a UpdateConsentInformationRequest updateConsentInformationRequest);

    @o("coinbase.public_api.authed.user_tracking_params_service.UserTrackingParamsService/UpdateTrackingParams")
    b0<NetworkResponse<UpdateTrackingParamsResponse, V3Error>> updateTrackingParams(@a UpdateTrackingParamsRequest updateTrackingParamsRequest);
}