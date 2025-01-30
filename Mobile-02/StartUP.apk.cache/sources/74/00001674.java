package com.coinbase.wallet.consumer.models;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerConnectionStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "Landroid/os/Parcelable;", "", "onrampEnabled", "Z", "getOnrampEnabled", "()Z", "<init>", "(Z)V", "Lcom/coinbase/wallet/consumer/models/Connected;", "Lcom/coinbase/wallet/consumer/models/NotConnected;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerConnectionStatus implements Parcelable {
    private final boolean onrampEnabled;

    private ConsumerConnectionStatus(boolean z) {
        this.onrampEnabled = z;
    }

    public /* synthetic */ ConsumerConnectionStatus(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    public boolean getOnrampEnabled() {
        return this.onrampEnabled;
    }
}