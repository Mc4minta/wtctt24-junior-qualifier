package com.coinbase.wallet.features.lend.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: LendProviderPickerState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendProviderPickerState;", "", "", "Lcom/coinbase/wallet/features/lend/models/LendProviderItem;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "component3", "providers", "showProviderDisabledAlert", "showContinueButton", "copy", "(Ljava/util/List;ZZ)Lcom/coinbase/wallet/features/lend/models/LendProviderPickerState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getProviders", "Z", "getShowContinueButton", "getShowProviderDisabledAlert", "<init>", "(Ljava/util/List;ZZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderPickerState {
    private final List<LendProviderItem> providers;
    private final boolean showContinueButton;
    private final boolean showProviderDisabledAlert;

    public LendProviderPickerState() {
        this(null, false, false, 7, null);
    }

    public LendProviderPickerState(List<LendProviderItem> providers, boolean z, boolean z2) {
        m.g(providers, "providers");
        this.providers = providers;
        this.showProviderDisabledAlert = z;
        this.showContinueButton = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LendProviderPickerState copy$default(LendProviderPickerState lendProviderPickerState, List list, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = lendProviderPickerState.providers;
        }
        if ((i2 & 2) != 0) {
            z = lendProviderPickerState.showProviderDisabledAlert;
        }
        if ((i2 & 4) != 0) {
            z2 = lendProviderPickerState.showContinueButton;
        }
        return lendProviderPickerState.copy(list, z, z2);
    }

    public final List<LendProviderItem> component1() {
        return this.providers;
    }

    public final boolean component2() {
        return this.showProviderDisabledAlert;
    }

    public final boolean component3() {
        return this.showContinueButton;
    }

    public final LendProviderPickerState copy(List<LendProviderItem> providers, boolean z, boolean z2) {
        m.g(providers, "providers");
        return new LendProviderPickerState(providers, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendProviderPickerState) {
            LendProviderPickerState lendProviderPickerState = (LendProviderPickerState) obj;
            return m.c(this.providers, lendProviderPickerState.providers) && this.showProviderDisabledAlert == lendProviderPickerState.showProviderDisabledAlert && this.showContinueButton == lendProviderPickerState.showContinueButton;
        }
        return false;
    }

    public final List<LendProviderItem> getProviders() {
        return this.providers;
    }

    public final boolean getShowContinueButton() {
        return this.showContinueButton;
    }

    public final boolean getShowProviderDisabledAlert() {
        return this.showProviderDisabledAlert;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.providers.hashCode() * 31;
        boolean z = this.showProviderDisabledAlert;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.showContinueButton;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "LendProviderPickerState(providers=" + this.providers + ", showProviderDisabledAlert=" + this.showProviderDisabledAlert + ", showContinueButton=" + this.showContinueButton + ')';
    }

    public /* synthetic */ LendProviderPickerState(List list, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2);
    }
}