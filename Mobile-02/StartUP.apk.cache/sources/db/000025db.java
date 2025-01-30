package com.coinbase.wallet.routing.models;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DeeplinkDestination.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/routing/models/NavDeepLinkDestination;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "Landroid/os/Bundle;", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "", "destinationResId", "I", "getDestinationResId", "()I", "<init>", "(ILandroid/os/Bundle;)V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class NavDeepLinkDestination extends DeeplinkDestination {
    private final Bundle args;
    private final int destinationResId;

    public /* synthetic */ NavDeepLinkDestination(int i2, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : bundle);
    }

    public final Bundle getArgs() {
        return this.args;
    }

    public final int getDestinationResId() {
        return this.destinationResId;
    }

    public NavDeepLinkDestination(int i2, Bundle bundle) {
        super(null);
        this.destinationResId = i2;
        this.args = bundle;
    }
}