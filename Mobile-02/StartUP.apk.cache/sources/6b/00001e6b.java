package com.coinbase.wallet.features.lend.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: LendCoinPickerState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\n\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;", "", "", "Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "items", "isLoading", "copy", "(Ljava/util/List;Z)Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "Z", "<init>", "(Ljava/util/List;Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerState {
    private final boolean isLoading;
    private final List<LendCoinPickerItem> items;

    public LendCoinPickerState() {
        this(null, false, 3, null);
    }

    public LendCoinPickerState(List<LendCoinPickerItem> items, boolean z) {
        m.g(items, "items");
        this.items = items;
        this.isLoading = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LendCoinPickerState copy$default(LendCoinPickerState lendCoinPickerState, List list, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = lendCoinPickerState.items;
        }
        if ((i2 & 2) != 0) {
            z = lendCoinPickerState.isLoading;
        }
        return lendCoinPickerState.copy(list, z);
    }

    public final List<LendCoinPickerItem> component1() {
        return this.items;
    }

    public final boolean component2() {
        return this.isLoading;
    }

    public final LendCoinPickerState copy(List<LendCoinPickerItem> items, boolean z) {
        m.g(items, "items");
        return new LendCoinPickerState(items, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendCoinPickerState) {
            LendCoinPickerState lendCoinPickerState = (LendCoinPickerState) obj;
            return m.c(this.items, lendCoinPickerState.items) && this.isLoading == lendCoinPickerState.isLoading;
        }
        return false;
    }

    public final List<LendCoinPickerItem> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.items.hashCode() * 31;
        boolean z = this.isLoading;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "LendCoinPickerState(items=" + this.items + ", isLoading=" + this.isLoading + ')';
    }

    public /* synthetic */ LendCoinPickerState(List list, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? true : z);
    }
}