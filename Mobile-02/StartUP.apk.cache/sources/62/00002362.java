package com.coinbase.wallet.features.wallets.models;

import kotlin.Metadata;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: WalletsEmptyState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/wallets/models/WalletsEmptyState;", "", "", "component1", "()I", "component2", "", "component3", "()Z", MessageBundle.TITLE_ENTRY, "subtitle", "transferButtonVisible", "copy", "(IIZ)Lcom/coinbase/wallet/features/wallets/models/WalletsEmptyState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getSubtitle", "getTitle", "Z", "getTransferButtonVisible", "<init>", "(IIZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsEmptyState {
    private final int subtitle;
    private final int title;
    private final boolean transferButtonVisible;

    public WalletsEmptyState(int i2, int i3, boolean z) {
        this.title = i2;
        this.subtitle = i3;
        this.transferButtonVisible = z;
    }

    public static /* synthetic */ WalletsEmptyState copy$default(WalletsEmptyState walletsEmptyState, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = walletsEmptyState.title;
        }
        if ((i4 & 2) != 0) {
            i3 = walletsEmptyState.subtitle;
        }
        if ((i4 & 4) != 0) {
            z = walletsEmptyState.transferButtonVisible;
        }
        return walletsEmptyState.copy(i2, i3, z);
    }

    public final int component1() {
        return this.title;
    }

    public final int component2() {
        return this.subtitle;
    }

    public final boolean component3() {
        return this.transferButtonVisible;
    }

    public final WalletsEmptyState copy(int i2, int i3, boolean z) {
        return new WalletsEmptyState(i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WalletsEmptyState) {
            WalletsEmptyState walletsEmptyState = (WalletsEmptyState) obj;
            return this.title == walletsEmptyState.title && this.subtitle == walletsEmptyState.subtitle && this.transferButtonVisible == walletsEmptyState.transferButtonVisible;
        }
        return false;
    }

    public final int getSubtitle() {
        return this.subtitle;
    }

    public final int getTitle() {
        return this.title;
    }

    public final boolean getTransferButtonVisible() {
        return this.transferButtonVisible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i2 = ((this.title * 31) + this.subtitle) * 31;
        boolean z = this.transferButtonVisible;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return i2 + i3;
    }

    public String toString() {
        return "WalletsEmptyState(title=" + this.title + ", subtitle=" + this.subtitle + ", transferButtonVisible=" + this.transferButtonVisible + ')';
    }
}