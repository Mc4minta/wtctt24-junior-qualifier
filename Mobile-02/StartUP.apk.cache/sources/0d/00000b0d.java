package com.coinbase.android.apiv3.generated.authed;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: NotificationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/NotificationService;", "", "Lcom/coinbase/android/apiv3/generated/authed/GetMetaDataRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/GetMetaDataResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "getMetaData", "(Lcom/coinbase/android/apiv3/generated/authed/GetMetaDataRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsResponse;", "listNotifications", "(Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/UnhighlightAllNotificationsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/UnhighlightAllNotificationsResponse;", "unhighlightAllNotifications", "(Lcom/coinbase/android/apiv3/generated/authed/UnhighlightAllNotificationsRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/UnhighlightNotificationRequest;", "Lcom/coinbase/android/apiv3/generated/authed/UnhighlightNotificationResponse;", "unhighlightNotification", "(Lcom/coinbase/android/apiv3/generated/authed/UnhighlightNotificationRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface NotificationService {
    @f("coinbase.public_api.authed.NotificationService/GetMetaData")
    b0<NetworkResponse<GetMetaDataResponse, V3Error>> getMetaData(@t("q") GetMetaDataRequest getMetaDataRequest);

    @f("coinbase.public_api.authed.NotificationService/ListNotifications")
    b0<NetworkResponse<ListNotificationsResponse, V3Error>> listNotifications(@t("q") ListNotificationsRequest listNotificationsRequest);

    @o("coinbase.public_api.authed.NotificationService/UnhighlightAllNotifications")
    b0<NetworkResponse<UnhighlightAllNotificationsResponse, V3Error>> unhighlightAllNotifications(@retrofit2.z.a UnhighlightAllNotificationsRequest unhighlightAllNotificationsRequest);

    @o("coinbase.public_api.authed.NotificationService/UnhighlightNotification")
    b0<NetworkResponse<UnhighlightNotificationResponse, V3Error>> unhighlightNotification(@retrofit2.z.a UnhighlightNotificationRequest unhighlightNotificationRequest);
}