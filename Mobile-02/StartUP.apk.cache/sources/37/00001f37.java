package com.coinbase.wallet.features.pushnotifications.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: SubscribeToNotificationsResultDto.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsResultDto;", "", "", "component1", "()Z", "subscribed", "copy", "(Z)Lcom/coinbase/wallet/features/pushnotifications/dtos/SubscribeToNotificationsResultDto;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSubscribed", "<init>", "(Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SubscribeToNotificationsResultDto {
    private final boolean subscribed;

    public SubscribeToNotificationsResultDto(boolean z) {
        this.subscribed = z;
    }

    public static /* synthetic */ SubscribeToNotificationsResultDto copy$default(SubscribeToNotificationsResultDto subscribeToNotificationsResultDto, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = subscribeToNotificationsResultDto.subscribed;
        }
        return subscribeToNotificationsResultDto.copy(z);
    }

    public final boolean component1() {
        return this.subscribed;
    }

    public final SubscribeToNotificationsResultDto copy(boolean z) {
        return new SubscribeToNotificationsResultDto(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscribeToNotificationsResultDto) && this.subscribed == ((SubscribeToNotificationsResultDto) obj).subscribed;
    }

    public final boolean getSubscribed() {
        return this.subscribed;
    }

    public int hashCode() {
        boolean z = this.subscribed;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "SubscribeToNotificationsResultDto(subscribed=" + this.subscribed + ')';
    }
}