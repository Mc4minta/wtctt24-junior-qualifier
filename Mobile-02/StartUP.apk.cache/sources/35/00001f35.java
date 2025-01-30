package com.coinbase.wallet.features.pushnotifications.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SubscribeToNotificationsRequestDto.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDto;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "fcmToken", "deviceId", "deviceType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsRequestDto;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getFcmToken", "getDeviceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SubscribeToNotificationsRequestDto {
    private final String deviceId;
    private final String deviceType;
    private final String fcmToken;

    public SubscribeToNotificationsRequestDto(String fcmToken, String deviceId, String deviceType) {
        m.g(fcmToken, "fcmToken");
        m.g(deviceId, "deviceId");
        m.g(deviceType, "deviceType");
        this.fcmToken = fcmToken;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }

    public static /* synthetic */ SubscribeToNotificationsRequestDto copy$default(SubscribeToNotificationsRequestDto subscribeToNotificationsRequestDto, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subscribeToNotificationsRequestDto.fcmToken;
        }
        if ((i2 & 2) != 0) {
            str2 = subscribeToNotificationsRequestDto.deviceId;
        }
        if ((i2 & 4) != 0) {
            str3 = subscribeToNotificationsRequestDto.deviceType;
        }
        return subscribeToNotificationsRequestDto.copy(str, str2, str3);
    }

    public final String component1() {
        return this.fcmToken;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.deviceType;
    }

    public final SubscribeToNotificationsRequestDto copy(String fcmToken, String deviceId, String deviceType) {
        m.g(fcmToken, "fcmToken");
        m.g(deviceId, "deviceId");
        m.g(deviceType, "deviceType");
        return new SubscribeToNotificationsRequestDto(fcmToken, deviceId, deviceType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubscribeToNotificationsRequestDto) {
            SubscribeToNotificationsRequestDto subscribeToNotificationsRequestDto = (SubscribeToNotificationsRequestDto) obj;
            return m.c(this.fcmToken, subscribeToNotificationsRequestDto.fcmToken) && m.c(this.deviceId, subscribeToNotificationsRequestDto.deviceId) && m.c(this.deviceType, subscribeToNotificationsRequestDto.deviceType);
        }
        return false;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getFcmToken() {
        return this.fcmToken;
    }

    public int hashCode() {
        return (((this.fcmToken.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.deviceType.hashCode();
    }

    public String toString() {
        return "SubscribeToNotificationsRequestDto(fcmToken=" + this.fcmToken + ", deviceId=" + this.deviceId + ", deviceType=" + this.deviceType + ')';
    }

    public /* synthetic */ SubscribeToNotificationsRequestDto(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? "android" : str3);
    }
}