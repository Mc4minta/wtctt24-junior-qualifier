package com.coinbase.wallet.features.send.models;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SendDestinationPickerState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b7\u00108B\t\b\u0016¢\u0006\u0004\b7\u00109J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J¢\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b\u001b\u0010\u0007R\u0013\u0010,\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b/\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b0\u0010\u0004R\u0013\u00101\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b1\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010!\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b!\u0010\u0007R\u0013\u00103\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b2\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b5\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b6\u0010\u0007¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "errorMessage", "isNextButtonHidden", "isNextButtonLoading", "isPasteboardHidden", "pasteboardText", "isMetadataFieldHidden", "isMetadataButtonHidden", "isErrorMessageHidden", "emptyStateTitle", "emptyStateDetails", "memoTypeButtonTapped", "isMetadataFieldErrorLabelHidden", "metadataFieldErrorMessage", "isPasteboardLoading", "copy", "(Ljava/lang/String;ZZZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Z)Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "isErrorLabelHidden", "Ljava/lang/String;", "getEmptyStateDetails", "getPasteboardText", "getMetadataFieldErrorMessage", "isPasteboardContainerViewHidden", "getHasError", "hasError", "getErrorMessage", "getEmptyStateTitle", "getMemoTypeButtonTapped", "<init>", "(Ljava/lang/String;ZZZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Z)V", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerState {
    private final String emptyStateDetails;
    private final String emptyStateTitle;
    private final String errorMessage;
    private final boolean isErrorMessageHidden;
    private final boolean isMetadataButtonHidden;
    private final boolean isMetadataFieldErrorLabelHidden;
    private final boolean isMetadataFieldHidden;
    private final boolean isNextButtonHidden;
    private final boolean isNextButtonLoading;
    private final boolean isPasteboardHidden;
    private final boolean isPasteboardLoading;
    private final boolean memoTypeButtonTapped;
    private final String metadataFieldErrorMessage;
    private final String pasteboardText;

    public SendDestinationPickerState(String str, boolean z, boolean z2, boolean z3, String str2, boolean z4, boolean z5, boolean z6, String emptyStateTitle, String emptyStateDetails, boolean z7, boolean z8, String str3, boolean z9) {
        m.g(emptyStateTitle, "emptyStateTitle");
        m.g(emptyStateDetails, "emptyStateDetails");
        this.errorMessage = str;
        this.isNextButtonHidden = z;
        this.isNextButtonLoading = z2;
        this.isPasteboardHidden = z3;
        this.pasteboardText = str2;
        this.isMetadataFieldHidden = z4;
        this.isMetadataButtonHidden = z5;
        this.isErrorMessageHidden = z6;
        this.emptyStateTitle = emptyStateTitle;
        this.emptyStateDetails = emptyStateDetails;
        this.memoTypeButtonTapped = z7;
        this.isMetadataFieldErrorLabelHidden = z8;
        this.metadataFieldErrorMessage = str3;
        this.isPasteboardLoading = z9;
    }

    public final String component1() {
        return this.errorMessage;
    }

    public final String component10() {
        return this.emptyStateDetails;
    }

    public final boolean component11() {
        return this.memoTypeButtonTapped;
    }

    public final boolean component12() {
        return this.isMetadataFieldErrorLabelHidden;
    }

    public final String component13() {
        return this.metadataFieldErrorMessage;
    }

    public final boolean component14() {
        return this.isPasteboardLoading;
    }

    public final boolean component2() {
        return this.isNextButtonHidden;
    }

    public final boolean component3() {
        return this.isNextButtonLoading;
    }

    public final boolean component4() {
        return this.isPasteboardHidden;
    }

    public final String component5() {
        return this.pasteboardText;
    }

    public final boolean component6() {
        return this.isMetadataFieldHidden;
    }

    public final boolean component7() {
        return this.isMetadataButtonHidden;
    }

    public final boolean component8() {
        return this.isErrorMessageHidden;
    }

    public final String component9() {
        return this.emptyStateTitle;
    }

    public final SendDestinationPickerState copy(String str, boolean z, boolean z2, boolean z3, String str2, boolean z4, boolean z5, boolean z6, String emptyStateTitle, String emptyStateDetails, boolean z7, boolean z8, String str3, boolean z9) {
        m.g(emptyStateTitle, "emptyStateTitle");
        m.g(emptyStateDetails, "emptyStateDetails");
        return new SendDestinationPickerState(str, z, z2, z3, str2, z4, z5, z6, emptyStateTitle, emptyStateDetails, z7, z8, str3, z9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendDestinationPickerState) {
            SendDestinationPickerState sendDestinationPickerState = (SendDestinationPickerState) obj;
            return m.c(this.errorMessage, sendDestinationPickerState.errorMessage) && this.isNextButtonHidden == sendDestinationPickerState.isNextButtonHidden && this.isNextButtonLoading == sendDestinationPickerState.isNextButtonLoading && this.isPasteboardHidden == sendDestinationPickerState.isPasteboardHidden && m.c(this.pasteboardText, sendDestinationPickerState.pasteboardText) && this.isMetadataFieldHidden == sendDestinationPickerState.isMetadataFieldHidden && this.isMetadataButtonHidden == sendDestinationPickerState.isMetadataButtonHidden && this.isErrorMessageHidden == sendDestinationPickerState.isErrorMessageHidden && m.c(this.emptyStateTitle, sendDestinationPickerState.emptyStateTitle) && m.c(this.emptyStateDetails, sendDestinationPickerState.emptyStateDetails) && this.memoTypeButtonTapped == sendDestinationPickerState.memoTypeButtonTapped && this.isMetadataFieldErrorLabelHidden == sendDestinationPickerState.isMetadataFieldErrorLabelHidden && m.c(this.metadataFieldErrorMessage, sendDestinationPickerState.metadataFieldErrorMessage) && this.isPasteboardLoading == sendDestinationPickerState.isPasteboardLoading;
        }
        return false;
    }

    public final String getEmptyStateDetails() {
        return this.emptyStateDetails;
    }

    public final String getEmptyStateTitle() {
        return this.emptyStateTitle;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getHasError() {
        return (this.errorMessage == null || this.isErrorMessageHidden) ? false : true;
    }

    public final boolean getMemoTypeButtonTapped() {
        return this.memoTypeButtonTapped;
    }

    public final String getMetadataFieldErrorMessage() {
        return this.metadataFieldErrorMessage;
    }

    public final String getPasteboardText() {
        return this.pasteboardText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.errorMessage;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isNextButtonHidden;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.isNextButtonLoading;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isPasteboardHidden;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        String str2 = this.pasteboardText;
        int hashCode2 = (i7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z4 = this.isMetadataFieldHidden;
        int i8 = z4;
        if (z4 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        boolean z5 = this.isMetadataButtonHidden;
        int i10 = z5;
        if (z5 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean z6 = this.isErrorMessageHidden;
        int i12 = z6;
        if (z6 != 0) {
            i12 = 1;
        }
        int hashCode3 = (((((i11 + i12) * 31) + this.emptyStateTitle.hashCode()) * 31) + this.emptyStateDetails.hashCode()) * 31;
        boolean z7 = this.memoTypeButtonTapped;
        int i13 = z7;
        if (z7 != 0) {
            i13 = 1;
        }
        int i14 = (hashCode3 + i13) * 31;
        boolean z8 = this.isMetadataFieldErrorLabelHidden;
        int i15 = z8;
        if (z8 != 0) {
            i15 = 1;
        }
        int i16 = (i14 + i15) * 31;
        String str3 = this.metadataFieldErrorMessage;
        int hashCode4 = (i16 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z9 = this.isPasteboardLoading;
        return hashCode4 + (z9 ? 1 : z9 ? 1 : 0);
    }

    public final boolean isErrorLabelHidden() {
        return !getHasError();
    }

    public final boolean isErrorMessageHidden() {
        return this.isErrorMessageHidden;
    }

    public final boolean isMetadataButtonHidden() {
        return this.isMetadataButtonHidden;
    }

    public final boolean isMetadataFieldErrorLabelHidden() {
        return this.isMetadataFieldErrorLabelHidden;
    }

    public final boolean isMetadataFieldHidden() {
        return this.isMetadataFieldHidden;
    }

    public final boolean isNextButtonHidden() {
        return this.isNextButtonHidden;
    }

    public final boolean isNextButtonLoading() {
        return this.isNextButtonLoading;
    }

    public final boolean isPasteboardContainerViewHidden() {
        return getHasError() || this.isPasteboardHidden;
    }

    public final boolean isPasteboardHidden() {
        return this.isPasteboardHidden;
    }

    public final boolean isPasteboardLoading() {
        return this.isPasteboardLoading;
    }

    public String toString() {
        return "SendDestinationPickerState(errorMessage=" + ((Object) this.errorMessage) + ", isNextButtonHidden=" + this.isNextButtonHidden + ", isNextButtonLoading=" + this.isNextButtonLoading + ", isPasteboardHidden=" + this.isPasteboardHidden + ", pasteboardText=" + ((Object) this.pasteboardText) + ", isMetadataFieldHidden=" + this.isMetadataFieldHidden + ", isMetadataButtonHidden=" + this.isMetadataButtonHidden + ", isErrorMessageHidden=" + this.isErrorMessageHidden + ", emptyStateTitle=" + this.emptyStateTitle + ", emptyStateDetails=" + this.emptyStateDetails + ", memoTypeButtonTapped=" + this.memoTypeButtonTapped + ", isMetadataFieldErrorLabelHidden=" + this.isMetadataFieldErrorLabelHidden + ", metadataFieldErrorMessage=" + ((Object) this.metadataFieldErrorMessage) + ", isPasteboardLoading=" + this.isPasteboardLoading + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SendDestinationPickerState() {
        /*
            r17 = this;
            com.coinbase.wallet.common.utilities.LocalizedStrings r0 = com.coinbase.wallet.common.utilities.LocalizedStrings.INSTANCE
            r1 = 2131952333(0x7f1302cd, float:1.9541106E38)
            java.lang.String r11 = r0.get(r1)
            r1 = 2131952332(0x7f1302cc, float:1.9541104E38)
            java.lang.String r12 = r0.get(r1)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1
            r7 = 0
            r8 = 1
            r9 = 1
            r10 = 1
            r13 = 0
            r14 = 1
            r15 = 0
            r16 = 0
            r2 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.models.SendDestinationPickerState.<init>():void");
    }
}