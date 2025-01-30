package com.coinbase.wallet.consumer.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerAddCardState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAddCardState;", "", "", "component1", "()Z", "component2", "showWebView", "showLoading", "copy", "(ZZ)Lcom/coinbase/wallet/consumer/models/ConsumerAddCardState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowWebView", "getShowLoading", "<init>", "(ZZ)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAddCardState {
    private final boolean showLoading;
    private final boolean showWebView;

    public ConsumerAddCardState() {
        this(false, false, 3, null);
    }

    public ConsumerAddCardState(boolean z, boolean z2) {
        this.showWebView = z;
        this.showLoading = z2;
    }

    public static /* synthetic */ ConsumerAddCardState copy$default(ConsumerAddCardState consumerAddCardState, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = consumerAddCardState.showWebView;
        }
        if ((i2 & 2) != 0) {
            z2 = consumerAddCardState.showLoading;
        }
        return consumerAddCardState.copy(z, z2);
    }

    public final boolean component1() {
        return this.showWebView;
    }

    public final boolean component2() {
        return this.showLoading;
    }

    public final ConsumerAddCardState copy(boolean z, boolean z2) {
        return new ConsumerAddCardState(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAddCardState) {
            ConsumerAddCardState consumerAddCardState = (ConsumerAddCardState) obj;
            return this.showWebView == consumerAddCardState.showWebView && this.showLoading == consumerAddCardState.showLoading;
        }
        return false;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final boolean getShowWebView() {
        return this.showWebView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.showWebView;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z2 = this.showLoading;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "ConsumerAddCardState(showWebView=" + this.showWebView + ", showLoading=" + this.showLoading + ')';
    }

    public /* synthetic */ ConsumerAddCardState(boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? true : z2);
    }
}