package com.coinbase.wallet.consumer.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerSecure3DVerificationViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationViewState;", "", "", "component1", "()Z", "isLoading", "copy", "(Z)Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationViewState {
    private final boolean isLoading;

    public ConsumerSecure3DVerificationViewState() {
        this(false, 1, null);
    }

    public ConsumerSecure3DVerificationViewState(boolean z) {
        this.isLoading = z;
    }

    public static /* synthetic */ ConsumerSecure3DVerificationViewState copy$default(ConsumerSecure3DVerificationViewState consumerSecure3DVerificationViewState, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = consumerSecure3DVerificationViewState.isLoading;
        }
        return consumerSecure3DVerificationViewState.copy(z);
    }

    public final boolean component1() {
        return this.isLoading;
    }

    public final ConsumerSecure3DVerificationViewState copy(boolean z) {
        return new ConsumerSecure3DVerificationViewState(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumerSecure3DVerificationViewState) && this.isLoading == ((ConsumerSecure3DVerificationViewState) obj).isLoading;
    }

    public int hashCode() {
        boolean z = this.isLoading;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "ConsumerSecure3DVerificationViewState(isLoading=" + this.isLoading + ')';
    }

    public /* synthetic */ ConsumerSecure3DVerificationViewState(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z);
    }
}