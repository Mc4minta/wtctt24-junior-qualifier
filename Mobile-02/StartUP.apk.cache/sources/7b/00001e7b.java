package com.coinbase.wallet.features.lend.models;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: LendUserAgreementState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0019\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;", "", "", "component1", "()I", "", "component2", "()Z", "currentPageIndex", "agreementConfirmed", "copy", "(IZ)Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "isButtonEnabled", "Z", "getAgreementConfirmed", "getButtonText", "buttonText", "getShouldProceedToLending", "shouldProceedToLending", "I", "getCurrentPageIndex", "<init>", "(IZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendUserAgreementState {
    private final boolean agreementConfirmed;
    private final int currentPageIndex;

    public LendUserAgreementState() {
        this(0, false, 3, null);
    }

    public LendUserAgreementState(int i2, boolean z) {
        this.currentPageIndex = i2;
        this.agreementConfirmed = z;
    }

    public static /* synthetic */ LendUserAgreementState copy$default(LendUserAgreementState lendUserAgreementState, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = lendUserAgreementState.currentPageIndex;
        }
        if ((i3 & 2) != 0) {
            z = lendUserAgreementState.agreementConfirmed;
        }
        return lendUserAgreementState.copy(i2, z);
    }

    public final int component1() {
        return this.currentPageIndex;
    }

    public final boolean component2() {
        return this.agreementConfirmed;
    }

    public final LendUserAgreementState copy(int i2, boolean z) {
        return new LendUserAgreementState(i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendUserAgreementState) {
            LendUserAgreementState lendUserAgreementState = (LendUserAgreementState) obj;
            return this.currentPageIndex == lendUserAgreementState.currentPageIndex && this.agreementConfirmed == lendUserAgreementState.agreementConfirmed;
        }
        return false;
    }

    public final boolean getAgreementConfirmed() {
        return this.agreementConfirmed;
    }

    public final String getButtonText() {
        if (this.currentPageIndex == 0) {
            return LocalizedStrings.INSTANCE.get(R.string.lend_user_agreement_button_continue);
        }
        return LocalizedStrings.INSTANCE.get(R.string.lend_user_agreement_button_start);
    }

    public final int getCurrentPageIndex() {
        return this.currentPageIndex;
    }

    public final boolean getShouldProceedToLending() {
        return this.currentPageIndex == 1 && this.agreementConfirmed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i2 = this.currentPageIndex * 31;
        boolean z = this.agreementConfirmed;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return i2 + i3;
    }

    public final boolean isButtonEnabled() {
        return this.currentPageIndex == 0 || this.agreementConfirmed;
    }

    public String toString() {
        return "LendUserAgreementState(currentPageIndex=" + this.currentPageIndex + ", agreementConfirmed=" + this.agreementConfirmed + ')';
    }

    public /* synthetic */ LendUserAgreementState(int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? false : z);
    }
}