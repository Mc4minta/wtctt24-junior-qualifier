package com.coinbase.wallet.features.pushnotifications.apis;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.common.extensions.Throwable_CommonKt;
import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.pushnotifications.dtos.SubscribeToNotificationsRequestDto;
import com.coinbase.wallet.features.pushnotifications.dtos.SubscribeToNotificationsResultDto;
import com.coinbase.wallet.features.pushnotifications.dtos.UnsubscribeFromNotificationsRequestDto;
import com.coinbase.wallet.features.pushnotifications.dtos.UnsubscribeFromNotificationsResultDto;
import com.coinbase.wallet.features.pushnotifications.exceptions.PushNotificationException;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: PushNotificationApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApi;", "", "", ApiConstants.TOKEN, "deviceId", "Lh/c/b0;", "", "subscribeToNotifications", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "unsubscribeFromPushNotifications", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApiInterface;", "api", "Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApiInterface;", "<init>", "(Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApiInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PushNotificationApi {
    private final PushNotificationApiInterface api;

    public PushNotificationApi(PushNotificationApiInterface api) {
        m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ h0 a(Throwable th) {
        return m1305unsubscribeFromPushNotifications$lambda3(th);
    }

    public static /* synthetic */ Boolean b(UnsubscribeFromNotificationsResultDto unsubscribeFromNotificationsResultDto) {
        return m1307unsubscribeFromPushNotifications$lambda5(unsubscribeFromNotificationsResultDto);
    }

    public static /* synthetic */ Boolean c(SubscribeToNotificationsResultDto subscribeToNotificationsResultDto) {
        return m1304subscribeToNotifications$lambda2(subscribeToNotificationsResultDto);
    }

    public static /* synthetic */ UnsubscribeFromNotificationsResultDto d(RPCResponse rPCResponse) {
        return m1306unsubscribeFromPushNotifications$lambda4(rPCResponse);
    }

    public static /* synthetic */ h0 e(Throwable th) {
        return m1302subscribeToNotifications$lambda0(th);
    }

    public static /* synthetic */ SubscribeToNotificationsResultDto f(RPCResponse rPCResponse) {
        return m1303subscribeToNotifications$lambda1(rPCResponse);
    }

    /* renamed from: subscribeToNotifications$lambda-0 */
    public static final h0 m1302subscribeToNotifications$lambda0(Throwable it) {
        m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: subscribeToNotifications$lambda-1 */
    public static final SubscribeToNotificationsResultDto m1303subscribeToNotifications$lambda1(RPCResponse it) {
        m.g(it, "it");
        SubscribeToNotificationsResultDto subscribeToNotificationsResultDto = (SubscribeToNotificationsResultDto) it.getResult();
        if (subscribeToNotificationsResultDto != null) {
            return subscribeToNotificationsResultDto;
        }
        throw PushNotificationException.ApiError.INSTANCE;
    }

    /* renamed from: subscribeToNotifications$lambda-2 */
    public static final Boolean m1304subscribeToNotifications$lambda2(SubscribeToNotificationsResultDto it) {
        m.g(it, "it");
        return Boolean.valueOf(it.getSubscribed());
    }

    /* renamed from: unsubscribeFromPushNotifications$lambda-3 */
    public static final h0 m1305unsubscribeFromPushNotifications$lambda3(Throwable it) {
        m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: unsubscribeFromPushNotifications$lambda-4 */
    public static final UnsubscribeFromNotificationsResultDto m1306unsubscribeFromPushNotifications$lambda4(RPCResponse it) {
        m.g(it, "it");
        UnsubscribeFromNotificationsResultDto unsubscribeFromNotificationsResultDto = (UnsubscribeFromNotificationsResultDto) it.getResult();
        if (unsubscribeFromNotificationsResultDto != null) {
            return unsubscribeFromNotificationsResultDto;
        }
        throw PushNotificationException.ApiError.INSTANCE;
    }

    /* renamed from: unsubscribeFromPushNotifications$lambda-5 */
    public static final Boolean m1307unsubscribeFromPushNotifications$lambda5(UnsubscribeFromNotificationsResultDto it) {
        m.g(it, "it");
        return Boolean.valueOf(it.getUnsubscribed());
    }

    public final b0<Boolean> subscribeToNotifications(String token, String deviceId) {
        m.g(token, "token");
        m.g(deviceId, "deviceId");
        b0<Boolean> map = this.api.subscribeToNotifications(new SubscribeToNotificationsRequestDto(token, deviceId, null, 4, null)).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.features.pushnotifications.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationApi.e((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.pushnotifications.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationApi.f((RPCResponse) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.pushnotifications.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationApi.c((SubscribeToNotificationsResultDto) obj);
            }
        });
        m.f(map, "api.subscribeToNotifications(params)\n            .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n            .map { it.result ?: throw PushNotificationException.ApiError }\n            .map { it.subscribed }");
        return map;
    }

    public final b0<Boolean> unsubscribeFromPushNotifications(String token) {
        m.g(token, "token");
        b0<Boolean> map = this.api.unsubscribeFromPushNotifications(new UnsubscribeFromNotificationsRequestDto(token)).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.features.pushnotifications.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationApi.a((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.pushnotifications.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationApi.d((RPCResponse) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.pushnotifications.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationApi.b((UnsubscribeFromNotificationsResultDto) obj);
            }
        });
        m.f(map, "api.unsubscribeFromPushNotifications(params)\n            .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n            .map { it.result ?: throw PushNotificationException.ApiError }\n            .map { it.unsubscribed }");
        return map;
    }
}