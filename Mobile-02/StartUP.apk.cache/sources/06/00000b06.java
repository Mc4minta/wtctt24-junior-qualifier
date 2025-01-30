package com.coinbase.android.apiv3.generated.authed;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: NotificationPreferences.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferences;", "", "Lcom/coinbase/android/apiv3/generated/authed/GetNotificationPreferenceRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/GetNotificationPreferenceResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "getNotificationPreference", "(Lcom/coinbase/android/apiv3/generated/authed/GetNotificationPreferenceRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/UpdateMutePushNotificationPreferenceRequest;", "Lcom/coinbase/android/apiv3/generated/authed/UpdateMutePushNotificationPreferenceResponse;", "updateMutePushNotificationPreference", "(Lcom/coinbase/android/apiv3/generated/authed/UpdateMutePushNotificationPreferenceRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/UpdateNotificationPreferenceRequest;", "Lcom/coinbase/android/apiv3/generated/authed/UpdateNotificationPreferenceResponse;", "updateNotificationPreference", "(Lcom/coinbase/android/apiv3/generated/authed/UpdateNotificationPreferenceRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface NotificationPreferences {
    @f("coinbase.public_api.authed.NotificationPreferences/GetNotificationPreference")
    b0<NetworkResponse<GetNotificationPreferenceResponse, V3Error>> getNotificationPreference(@t("q") GetNotificationPreferenceRequest getNotificationPreferenceRequest);

    @o("coinbase.public_api.authed.NotificationPreferences/UpdateMutePushNotificationPreference")
    b0<NetworkResponse<UpdateMutePushNotificationPreferenceResponse, V3Error>> updateMutePushNotificationPreference(@retrofit2.z.a UpdateMutePushNotificationPreferenceRequest updateMutePushNotificationPreferenceRequest);

    @o("coinbase.public_api.authed.NotificationPreferences/UpdateNotificationPreference")
    b0<NetworkResponse<UpdateNotificationPreferenceResponse, V3Error>> updateNotificationPreference(@retrofit2.z.a UpdateNotificationPreferenceRequest updateNotificationPreferenceRequest);
}