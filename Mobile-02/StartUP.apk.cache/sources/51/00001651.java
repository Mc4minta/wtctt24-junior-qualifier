package com.coinbase.wallet.consumer.models;

import com.coinbase.ApiConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAccountViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b%\u0010&J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b$\u0010\u0006¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;", "", "switchToLoading", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;", "", "component1", "()Z", "component2", "Lcom/coinbase/wallet/consumer/models/ConsumerSplashScreenState;", "component3", "()Lcom/coinbase/wallet/consumer/models/ConsumerSplashScreenState;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellSectionViewState;", "component4", "()Ljava/util/List;", "showSplashScreen", "showLoading", "splashScreenState", ApiConstants.ACCOUNTS, "copy", "(ZZLcom/coinbase/wallet/consumer/models/ConsumerSplashScreenState;Ljava/util/List;)Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAccounts", "Z", "getShowLoading", "Lcom/coinbase/wallet/consumer/models/ConsumerSplashScreenState;", "getSplashScreenState", "getShowSplashScreen", "<init>", "(ZZLcom/coinbase/wallet/consumer/models/ConsumerSplashScreenState;Ljava/util/List;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountViewState {
    private final List<ConsumerCoinCellSectionViewState> accounts;
    private final boolean showLoading;
    private final boolean showSplashScreen;
    private final ConsumerSplashScreenState splashScreenState;

    public ConsumerAccountViewState() {
        this(false, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConsumerAccountViewState(boolean z, boolean z2, ConsumerSplashScreenState splashScreenState, List<? extends ConsumerCoinCellSectionViewState> accounts) {
        m.g(splashScreenState, "splashScreenState");
        m.g(accounts, "accounts");
        this.showSplashScreen = z;
        this.showLoading = z2;
        this.splashScreenState = splashScreenState;
        this.accounts = accounts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsumerAccountViewState copy$default(ConsumerAccountViewState consumerAccountViewState, boolean z, boolean z2, ConsumerSplashScreenState consumerSplashScreenState, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = consumerAccountViewState.showSplashScreen;
        }
        if ((i2 & 2) != 0) {
            z2 = consumerAccountViewState.showLoading;
        }
        if ((i2 & 4) != 0) {
            consumerSplashScreenState = consumerAccountViewState.splashScreenState;
        }
        if ((i2 & 8) != 0) {
            list = consumerAccountViewState.accounts;
        }
        return consumerAccountViewState.copy(z, z2, consumerSplashScreenState, list);
    }

    public final boolean component1() {
        return this.showSplashScreen;
    }

    public final boolean component2() {
        return this.showLoading;
    }

    public final ConsumerSplashScreenState component3() {
        return this.splashScreenState;
    }

    public final List<ConsumerCoinCellSectionViewState> component4() {
        return this.accounts;
    }

    public final ConsumerAccountViewState copy(boolean z, boolean z2, ConsumerSplashScreenState splashScreenState, List<? extends ConsumerCoinCellSectionViewState> accounts) {
        m.g(splashScreenState, "splashScreenState");
        m.g(accounts, "accounts");
        return new ConsumerAccountViewState(z, z2, splashScreenState, accounts);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAccountViewState) {
            ConsumerAccountViewState consumerAccountViewState = (ConsumerAccountViewState) obj;
            return this.showSplashScreen == consumerAccountViewState.showSplashScreen && this.showLoading == consumerAccountViewState.showLoading && m.c(this.splashScreenState, consumerAccountViewState.splashScreenState) && m.c(this.accounts, consumerAccountViewState.accounts);
        }
        return false;
    }

    public final List<ConsumerCoinCellSectionViewState> getAccounts() {
        return this.accounts;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final boolean getShowSplashScreen() {
        return this.showSplashScreen;
    }

    public final ConsumerSplashScreenState getSplashScreenState() {
        return this.splashScreenState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.showSplashScreen;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z2 = this.showLoading;
        return ((((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.splashScreenState.hashCode()) * 31) + this.accounts.hashCode();
    }

    public final ConsumerAccountViewState switchToLoading() {
        return copy$default(this, false, true, null, null, 12, null);
    }

    public String toString() {
        return "ConsumerAccountViewState(showSplashScreen=" + this.showSplashScreen + ", showLoading=" + this.showLoading + ", splashScreenState=" + this.splashScreenState + ", accounts=" + this.accounts + ')';
    }

    public /* synthetic */ ConsumerAccountViewState(boolean z, boolean z2, ConsumerSplashScreenState consumerSplashScreenState, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? true : z2, (i2 & 4) != 0 ? new ConsumerSplashScreenState(null, null, null, null, null, 31, null) : consumerSplashScreenState, (i2 & 8) != 0 ? r.g() : list);
    }
}