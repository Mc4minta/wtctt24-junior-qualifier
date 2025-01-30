package com.coinbase.wallet.features.pushnotifications.apis;

import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.pushnotifications.dtos.SubscribeToNotificationsRequestDto;
import com.coinbase.wallet.features.pushnotifications.dtos.SubscribeToNotificationsResultDto;
import com.coinbase.wallet.features.pushnotifications.dtos.UnsubscribeFromNotificationsRequestDto;
import com.coinbase.wallet.features.pushnotifications.dtos.UnsubscribeFromNotificationsResultDto;
import com.coinbase.wallet.user.annotations.AuthenticatedRequest;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.o;

/* compiled from: PushNotificationApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApiInterface;", "", "Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDto;", "rpcParams", "Lh/c/b0;", "Lcom/coinbase/wallet/common/models/RPCResponse;", "Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsResultDto;", "subscribeToNotifications", "(Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDto;)Lh/c/b0;", "Lcom/coinbase/wallet/features/pushnotifications/dtos/UnsubscribeFromNotificationsRequestDto;", "Lcom/coinbase/wallet/features/pushnotifications/dtos/UnsubscribeFromNotificationsResultDto;", "unsubscribeFromPushNotifications", "(Lcom/coinbase/wallet/features/pushnotifications/dtos/UnsubscribeFromNotificationsRequestDto;)Lh/c/b0;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface PushNotificationApiInterface {
    @AuthenticatedRequest
    @o("rpc/v2/subscribeToNotifications")
    b0<RPCResponse<SubscribeToNotificationsResultDto>> subscribeToNotifications(@retrofit2.z.a SubscribeToNotificationsRequestDto subscribeToNotificationsRequestDto);

    @AuthenticatedRequest
    @o("rpc/v2/unsubscribeFromNotifications")
    b0<RPCResponse<UnsubscribeFromNotificationsResultDto>> unsubscribeFromPushNotifications(@retrofit2.z.a UnsubscribeFromNotificationsRequestDto unsubscribeFromNotificationsRequestDto);
}