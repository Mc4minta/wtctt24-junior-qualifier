package com.coinbase.wallet.consumer.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import java.math.BigDecimal;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAmountPickerViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010&\u001a\u00020\u0013\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u000b\u0012\b\b\u0002\u0010)\u001a\u00020\u000b\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\bF\u0010GJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\rJ\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ¬\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010&\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b.\u0010\rJ\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104R\u001b\u0010+\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b+\u00105\u001a\u0004\b6\u0010\u001cR\u0019\u0010(\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\b8\u0010\rR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0004R\u0019\u0010\"\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b;\u0010\rR\u001b\u0010%\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\b=\u0010\u0012R\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010>\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010 \u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b \u0010\u0007R\u0019\u0010!\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010>\u001a\u0004\b!\u0010\u0007R\u0019\u0010&\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010?\u001a\u0004\b@\u0010\u0015R\u0019\u0010#\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\bA\u0010\rR\u0019\u0010*\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010>\u001a\u0004\b*\u0010\u0007R\u0019\u0010$\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010>\u001a\u0004\bB\u0010\u0007R\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010>\u001a\u0004\b\u001f\u0010\u0007\"\u0004\bC\u0010DR\u0019\u0010)\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\bE\u0010\rR\u0019\u0010'\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010>\u001a\u0004\b'\u0010\u0007¨\u0006H"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;", "", "Ljava/math/BigDecimal;", "component1", "()Ljava/math/BigDecimal;", "", "component2", "()Z", "component3", "component4", "component5", "", "component6", "()Ljava/lang/String;", "component7", "component8", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component9", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Ljava/util/Locale;", "component10", "()Ljava/util/Locale;", "component11", "component12", "component13", "component14", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "component15", "()Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "maxAmount", "isMaxButtonLoading", "isNextButtonVisible", "isNextButtonLoading", "isFiatSelected", "primaryText", "secondaryText", "swapButtonEnabled", AppsFlyerProperties.CURRENCY_CODE, "keyboardLocale", "isOnrampEnabled", "cryptoBalance", "fiatBalance", "isInsufficientBalance", "wallet", "copy", "(Ljava/math/BigDecimal;ZZZZLjava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/Locale;ZLjava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/consumer/models/ReceivableWallet;)Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "getWallet", "Ljava/lang/String;", "getCryptoBalance", "Ljava/math/BigDecimal;", "getMaxAmount", "getPrimaryText", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Z", "Ljava/util/Locale;", "getKeyboardLocale", "getSecondaryText", "getSwapButtonEnabled", "setNextButtonVisible", "(Z)V", "getFiatBalance", "<init>", "(Ljava/math/BigDecimal;ZZZZLjava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/Locale;ZLjava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/consumer/models/ReceivableWallet;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewState {
    private final String cryptoBalance;
    private final CurrencyCode currencyCode;
    private final String fiatBalance;
    private final boolean isFiatSelected;
    private final boolean isInsufficientBalance;
    private final boolean isMaxButtonLoading;
    private final boolean isNextButtonLoading;
    private boolean isNextButtonVisible;
    private final boolean isOnrampEnabled;
    private final Locale keyboardLocale;
    private final BigDecimal maxAmount;
    private final String primaryText;
    private final String secondaryText;
    private final boolean swapButtonEnabled;
    private final ReceivableWallet wallet;

    public ConsumerAmountPickerViewState() {
        this(null, false, false, false, false, null, null, false, null, null, false, null, null, false, null, 32767, null);
    }

    public ConsumerAmountPickerViewState(BigDecimal bigDecimal, boolean z, boolean z2, boolean z3, boolean z4, String primaryText, String secondaryText, boolean z5, CurrencyCode currencyCode, Locale keyboardLocale, boolean z6, String cryptoBalance, String fiatBalance, boolean z7, ReceivableWallet receivableWallet) {
        m.g(primaryText, "primaryText");
        m.g(secondaryText, "secondaryText");
        m.g(keyboardLocale, "keyboardLocale");
        m.g(cryptoBalance, "cryptoBalance");
        m.g(fiatBalance, "fiatBalance");
        this.maxAmount = bigDecimal;
        this.isMaxButtonLoading = z;
        this.isNextButtonVisible = z2;
        this.isNextButtonLoading = z3;
        this.isFiatSelected = z4;
        this.primaryText = primaryText;
        this.secondaryText = secondaryText;
        this.swapButtonEnabled = z5;
        this.currencyCode = currencyCode;
        this.keyboardLocale = keyboardLocale;
        this.isOnrampEnabled = z6;
        this.cryptoBalance = cryptoBalance;
        this.fiatBalance = fiatBalance;
        this.isInsufficientBalance = z7;
        this.wallet = receivableWallet;
    }

    public final BigDecimal component1() {
        return this.maxAmount;
    }

    public final Locale component10() {
        return this.keyboardLocale;
    }

    public final boolean component11() {
        return this.isOnrampEnabled;
    }

    public final String component12() {
        return this.cryptoBalance;
    }

    public final String component13() {
        return this.fiatBalance;
    }

    public final boolean component14() {
        return this.isInsufficientBalance;
    }

    public final ReceivableWallet component15() {
        return this.wallet;
    }

    public final boolean component2() {
        return this.isMaxButtonLoading;
    }

    public final boolean component3() {
        return this.isNextButtonVisible;
    }

    public final boolean component4() {
        return this.isNextButtonLoading;
    }

    public final boolean component5() {
        return this.isFiatSelected;
    }

    public final String component6() {
        return this.primaryText;
    }

    public final String component7() {
        return this.secondaryText;
    }

    public final boolean component8() {
        return this.swapButtonEnabled;
    }

    public final CurrencyCode component9() {
        return this.currencyCode;
    }

    public final ConsumerAmountPickerViewState copy(BigDecimal bigDecimal, boolean z, boolean z2, boolean z3, boolean z4, String primaryText, String secondaryText, boolean z5, CurrencyCode currencyCode, Locale keyboardLocale, boolean z6, String cryptoBalance, String fiatBalance, boolean z7, ReceivableWallet receivableWallet) {
        m.g(primaryText, "primaryText");
        m.g(secondaryText, "secondaryText");
        m.g(keyboardLocale, "keyboardLocale");
        m.g(cryptoBalance, "cryptoBalance");
        m.g(fiatBalance, "fiatBalance");
        return new ConsumerAmountPickerViewState(bigDecimal, z, z2, z3, z4, primaryText, secondaryText, z5, currencyCode, keyboardLocale, z6, cryptoBalance, fiatBalance, z7, receivableWallet);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAmountPickerViewState) {
            ConsumerAmountPickerViewState consumerAmountPickerViewState = (ConsumerAmountPickerViewState) obj;
            return m.c(this.maxAmount, consumerAmountPickerViewState.maxAmount) && this.isMaxButtonLoading == consumerAmountPickerViewState.isMaxButtonLoading && this.isNextButtonVisible == consumerAmountPickerViewState.isNextButtonVisible && this.isNextButtonLoading == consumerAmountPickerViewState.isNextButtonLoading && this.isFiatSelected == consumerAmountPickerViewState.isFiatSelected && m.c(this.primaryText, consumerAmountPickerViewState.primaryText) && m.c(this.secondaryText, consumerAmountPickerViewState.secondaryText) && this.swapButtonEnabled == consumerAmountPickerViewState.swapButtonEnabled && m.c(this.currencyCode, consumerAmountPickerViewState.currencyCode) && m.c(this.keyboardLocale, consumerAmountPickerViewState.keyboardLocale) && this.isOnrampEnabled == consumerAmountPickerViewState.isOnrampEnabled && m.c(this.cryptoBalance, consumerAmountPickerViewState.cryptoBalance) && m.c(this.fiatBalance, consumerAmountPickerViewState.fiatBalance) && this.isInsufficientBalance == consumerAmountPickerViewState.isInsufficientBalance && m.c(this.wallet, consumerAmountPickerViewState.wallet);
        }
        return false;
    }

    public final String getCryptoBalance() {
        return this.cryptoBalance;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getFiatBalance() {
        return this.fiatBalance;
    }

    public final Locale getKeyboardLocale() {
        return this.keyboardLocale;
    }

    public final BigDecimal getMaxAmount() {
        return this.maxAmount;
    }

    public final String getPrimaryText() {
        return this.primaryText;
    }

    public final String getSecondaryText() {
        return this.secondaryText;
    }

    public final boolean getSwapButtonEnabled() {
        return this.swapButtonEnabled;
    }

    public final ReceivableWallet getWallet() {
        return this.wallet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        BigDecimal bigDecimal = this.maxAmount;
        int hashCode = (bigDecimal == null ? 0 : bigDecimal.hashCode()) * 31;
        boolean z = this.isMaxButtonLoading;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.isNextButtonVisible;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isNextButtonLoading;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z4 = this.isFiatSelected;
        int i8 = z4;
        if (z4 != 0) {
            i8 = 1;
        }
        int hashCode2 = (((((i7 + i8) * 31) + this.primaryText.hashCode()) * 31) + this.secondaryText.hashCode()) * 31;
        boolean z5 = this.swapButtonEnabled;
        int i9 = z5;
        if (z5 != 0) {
            i9 = 1;
        }
        int i10 = (hashCode2 + i9) * 31;
        CurrencyCode currencyCode = this.currencyCode;
        int hashCode3 = (((i10 + (currencyCode == null ? 0 : currencyCode.hashCode())) * 31) + this.keyboardLocale.hashCode()) * 31;
        boolean z6 = this.isOnrampEnabled;
        int i11 = z6;
        if (z6 != 0) {
            i11 = 1;
        }
        int hashCode4 = (((((hashCode3 + i11) * 31) + this.cryptoBalance.hashCode()) * 31) + this.fiatBalance.hashCode()) * 31;
        boolean z7 = this.isInsufficientBalance;
        int i12 = (hashCode4 + (z7 ? 1 : z7 ? 1 : 0)) * 31;
        ReceivableWallet receivableWallet = this.wallet;
        return i12 + (receivableWallet != null ? receivableWallet.hashCode() : 0);
    }

    public final boolean isFiatSelected() {
        return this.isFiatSelected;
    }

    public final boolean isInsufficientBalance() {
        return this.isInsufficientBalance;
    }

    public final boolean isMaxButtonLoading() {
        return this.isMaxButtonLoading;
    }

    public final boolean isNextButtonLoading() {
        return this.isNextButtonLoading;
    }

    public final boolean isNextButtonVisible() {
        return this.isNextButtonVisible;
    }

    public final boolean isOnrampEnabled() {
        return this.isOnrampEnabled;
    }

    public final void setNextButtonVisible(boolean z) {
        this.isNextButtonVisible = z;
    }

    public String toString() {
        return "ConsumerAmountPickerViewState(maxAmount=" + this.maxAmount + ", isMaxButtonLoading=" + this.isMaxButtonLoading + ", isNextButtonVisible=" + this.isNextButtonVisible + ", isNextButtonLoading=" + this.isNextButtonLoading + ", isFiatSelected=" + this.isFiatSelected + ", primaryText=" + this.primaryText + ", secondaryText=" + this.secondaryText + ", swapButtonEnabled=" + this.swapButtonEnabled + ", currencyCode=" + this.currencyCode + ", keyboardLocale=" + this.keyboardLocale + ", isOnrampEnabled=" + this.isOnrampEnabled + ", cryptoBalance=" + this.cryptoBalance + ", fiatBalance=" + this.fiatBalance + ", isInsufficientBalance=" + this.isInsufficientBalance + ", wallet=" + this.wallet + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ConsumerAmountPickerViewState(java.math.BigDecimal r17, boolean r18, boolean r19, boolean r20, boolean r21, java.lang.String r22, java.lang.String r23, boolean r24, com.coinbase.wallet.blockchains.models.CurrencyCode r25, java.util.Locale r26, boolean r27, java.lang.String r28, java.lang.String r29, boolean r30, com.coinbase.wallet.consumer.models.ReceivableWallet r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            if (r1 == 0) goto L8
            r1 = 0
            goto La
        L8:
            r1 = r17
        La:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L11
            r3 = r4
            goto L13
        L11:
            r3 = r18
        L13:
            r5 = r0 & 4
            if (r5 == 0) goto L19
            r5 = r4
            goto L1b
        L19:
            r5 = r19
        L1b:
            r6 = r0 & 8
            if (r6 == 0) goto L21
            r6 = r4
            goto L23
        L21:
            r6 = r20
        L23:
            r7 = r0 & 16
            if (r7 == 0) goto L29
            r7 = r4
            goto L2b
        L29:
            r7 = r21
        L2b:
            r8 = r0 & 32
            if (r8 == 0) goto L36
            com.coinbase.wallet.core.extensions.Strings r8 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r8 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r8)
            goto L38
        L36:
            r8 = r22
        L38:
            r9 = r0 & 64
            if (r9 == 0) goto L43
            com.coinbase.wallet.core.extensions.Strings r9 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r9 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r9)
            goto L45
        L43:
            r9 = r23
        L45:
            r10 = r0 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L4b
            r10 = 1
            goto L4d
        L4b:
            r10 = r24
        L4d:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L53
            r11 = 0
            goto L55
        L53:
            r11 = r25
        L55:
            r12 = r0 & 512(0x200, float:7.17E-43)
            if (r12 == 0) goto L61
            java.util.Locale r12 = java.util.Locale.US
            java.lang.String r13 = "US"
            kotlin.jvm.internal.m.f(r12, r13)
            goto L63
        L61:
            r12 = r26
        L63:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L69
            r13 = r4
            goto L6b
        L69:
            r13 = r27
        L6b:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L76
            com.coinbase.wallet.core.extensions.Strings r14 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r14 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r14)
            goto L78
        L76:
            r14 = r28
        L78:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L83
            com.coinbase.wallet.core.extensions.Strings r15 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r15 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r15)
            goto L85
        L83:
            r15 = r29
        L85:
            r2 = r0 & 8192(0x2000, float:1.148E-41)
            if (r2 == 0) goto L8a
            goto L8c
        L8a:
            r4 = r30
        L8c:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L92
            r0 = 0
            goto L94
        L92:
            r0 = r31
        L94:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r15
            r31 = r4
            r32 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.models.ConsumerAmountPickerViewState.<init>(java.math.BigDecimal, boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, boolean, com.coinbase.wallet.blockchains.models.CurrencyCode, java.util.Locale, boolean, java.lang.String, java.lang.String, boolean, com.coinbase.wallet.consumer.models.ReceivableWallet, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}