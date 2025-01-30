package com.coinbase.wallet.features.send.models;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AmountPickerSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0010\u0010\f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0010\u0010\r\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000f\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0013\u0010\tJ\u0088\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\"\u0010\u0012J\u0010\u0010#\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b#\u0010\tJ\u001a\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u001a\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010\tR\u0019\u0010\u001c\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b)\u0010\tR\u0019\u0010\u0018\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b*\u0010\tR\u0019\u0010\u001f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010'\u001a\u0004\b+\u0010\tR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b-\u0010\tR\u0019\u0010\u001b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b.\u0010\tR\u0019\u0010\u001e\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b0\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b1\u0010\tR\u0019\u0010\u0017\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b2\u0010\t¨\u00065"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "", "", "component1", "()Z", "component2", "component3", "", "component4", "()I", "component5", "component6", "component7", "component8", "component9", "component10", "", "component11", "()Ljava/lang/String;", "component12", "isSend", "isLend", "isSliderEnabled", "textColor", "secondaryTextColor", "amountButtonTextColor", "numpadTextColor", "backgroundColor", "buttonColor", "inactiveButtonColor", "proceedButtonLabel", "backButtonResource", "copy", "(ZZZIIIIIIILjava/lang/String;I)Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getNumpadTextColor", "getButtonColor", "getSecondaryTextColor", "getBackButtonResource", "Z", "getInactiveButtonColor", "getBackgroundColor", "Ljava/lang/String;", "getProceedButtonLabel", "getAmountButtonTextColor", "getTextColor", "<init>", "(ZZZIIIIIIILjava/lang/String;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerSettings {
    private final int amountButtonTextColor;
    private final int backButtonResource;
    private final int backgroundColor;
    private final int buttonColor;
    private final int inactiveButtonColor;
    private final boolean isLend;
    private final boolean isSend;
    private final boolean isSliderEnabled;
    private final int numpadTextColor;
    private final String proceedButtonLabel;
    private final int secondaryTextColor;
    private final int textColor;

    public AmountPickerSettings(boolean z, boolean z2, boolean z3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String proceedButtonLabel, int i9) {
        m.g(proceedButtonLabel, "proceedButtonLabel");
        this.isSend = z;
        this.isLend = z2;
        this.isSliderEnabled = z3;
        this.textColor = i2;
        this.secondaryTextColor = i3;
        this.amountButtonTextColor = i4;
        this.numpadTextColor = i5;
        this.backgroundColor = i6;
        this.buttonColor = i7;
        this.inactiveButtonColor = i8;
        this.proceedButtonLabel = proceedButtonLabel;
        this.backButtonResource = i9;
    }

    public final boolean component1() {
        return this.isSend;
    }

    public final int component10() {
        return this.inactiveButtonColor;
    }

    public final String component11() {
        return this.proceedButtonLabel;
    }

    public final int component12() {
        return this.backButtonResource;
    }

    public final boolean component2() {
        return this.isLend;
    }

    public final boolean component3() {
        return this.isSliderEnabled;
    }

    public final int component4() {
        return this.textColor;
    }

    public final int component5() {
        return this.secondaryTextColor;
    }

    public final int component6() {
        return this.amountButtonTextColor;
    }

    public final int component7() {
        return this.numpadTextColor;
    }

    public final int component8() {
        return this.backgroundColor;
    }

    public final int component9() {
        return this.buttonColor;
    }

    public final AmountPickerSettings copy(boolean z, boolean z2, boolean z3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String proceedButtonLabel, int i9) {
        m.g(proceedButtonLabel, "proceedButtonLabel");
        return new AmountPickerSettings(z, z2, z3, i2, i3, i4, i5, i6, i7, i8, proceedButtonLabel, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AmountPickerSettings) {
            AmountPickerSettings amountPickerSettings = (AmountPickerSettings) obj;
            return this.isSend == amountPickerSettings.isSend && this.isLend == amountPickerSettings.isLend && this.isSliderEnabled == amountPickerSettings.isSliderEnabled && this.textColor == amountPickerSettings.textColor && this.secondaryTextColor == amountPickerSettings.secondaryTextColor && this.amountButtonTextColor == amountPickerSettings.amountButtonTextColor && this.numpadTextColor == amountPickerSettings.numpadTextColor && this.backgroundColor == amountPickerSettings.backgroundColor && this.buttonColor == amountPickerSettings.buttonColor && this.inactiveButtonColor == amountPickerSettings.inactiveButtonColor && m.c(this.proceedButtonLabel, amountPickerSettings.proceedButtonLabel) && this.backButtonResource == amountPickerSettings.backButtonResource;
        }
        return false;
    }

    public final int getAmountButtonTextColor() {
        return this.amountButtonTextColor;
    }

    public final int getBackButtonResource() {
        return this.backButtonResource;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getButtonColor() {
        return this.buttonColor;
    }

    public final int getInactiveButtonColor() {
        return this.inactiveButtonColor;
    }

    public final int getNumpadTextColor() {
        return this.numpadTextColor;
    }

    public final String getProceedButtonLabel() {
        return this.proceedButtonLabel;
    }

    public final int getSecondaryTextColor() {
        return this.secondaryTextColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.isSend;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        ?? r2 = this.isLend;
        int i3 = r2;
        if (r2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z2 = this.isSliderEnabled;
        return ((((((((((((((((((i4 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.textColor) * 31) + this.secondaryTextColor) * 31) + this.amountButtonTextColor) * 31) + this.numpadTextColor) * 31) + this.backgroundColor) * 31) + this.buttonColor) * 31) + this.inactiveButtonColor) * 31) + this.proceedButtonLabel.hashCode()) * 31) + this.backButtonResource;
    }

    public final boolean isLend() {
        return this.isLend;
    }

    public final boolean isSend() {
        return this.isSend;
    }

    public final boolean isSliderEnabled() {
        return this.isSliderEnabled;
    }

    public String toString() {
        return "AmountPickerSettings(isSend=" + this.isSend + ", isLend=" + this.isLend + ", isSliderEnabled=" + this.isSliderEnabled + ", textColor=" + this.textColor + ", secondaryTextColor=" + this.secondaryTextColor + ", amountButtonTextColor=" + this.amountButtonTextColor + ", numpadTextColor=" + this.numpadTextColor + ", backgroundColor=" + this.backgroundColor + ", buttonColor=" + this.buttonColor + ", inactiveButtonColor=" + this.inactiveButtonColor + ", proceedButtonLabel=" + this.proceedButtonLabel + ", backButtonResource=" + this.backButtonResource + ')';
    }
}