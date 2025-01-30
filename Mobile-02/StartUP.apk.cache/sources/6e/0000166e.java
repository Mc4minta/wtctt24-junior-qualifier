package com.coinbase.wallet.consumer.models;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerCardCDVState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVState;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "errorMessage", "buttonEnabled", "loading", "copy", "(Ljava/lang/String;ZZ)Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getErrorMessage", "Z", "getLoading", "getButtonEnabled", "<init>", "(Ljava/lang/String;ZZ)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerCardCDVState {
    private final boolean buttonEnabled;
    private final String errorMessage;
    private final boolean loading;

    public ConsumerCardCDVState() {
        this(null, false, false, 7, null);
    }

    public ConsumerCardCDVState(String errorMessage, boolean z, boolean z2) {
        m.g(errorMessage, "errorMessage");
        this.errorMessage = errorMessage;
        this.buttonEnabled = z;
        this.loading = z2;
    }

    public static /* synthetic */ ConsumerCardCDVState copy$default(ConsumerCardCDVState consumerCardCDVState, String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerCardCDVState.errorMessage;
        }
        if ((i2 & 2) != 0) {
            z = consumerCardCDVState.buttonEnabled;
        }
        if ((i2 & 4) != 0) {
            z2 = consumerCardCDVState.loading;
        }
        return consumerCardCDVState.copy(str, z, z2);
    }

    public final String component1() {
        return this.errorMessage;
    }

    public final boolean component2() {
        return this.buttonEnabled;
    }

    public final boolean component3() {
        return this.loading;
    }

    public final ConsumerCardCDVState copy(String errorMessage, boolean z, boolean z2) {
        m.g(errorMessage, "errorMessage");
        return new ConsumerCardCDVState(errorMessage, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerCardCDVState) {
            ConsumerCardCDVState consumerCardCDVState = (ConsumerCardCDVState) obj;
            return m.c(this.errorMessage, consumerCardCDVState.errorMessage) && this.buttonEnabled == consumerCardCDVState.buttonEnabled && this.loading == consumerCardCDVState.loading;
        }
        return false;
    }

    public final boolean getButtonEnabled() {
        return this.buttonEnabled;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.errorMessage.hashCode() * 31;
        boolean z = this.buttonEnabled;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.loading;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "ConsumerCardCDVState(errorMessage=" + this.errorMessage + ", buttonEnabled=" + this.buttonEnabled + ", loading=" + this.loading + ')';
    }

    public /* synthetic */ ConsumerCardCDVState(String str, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2);
    }
}