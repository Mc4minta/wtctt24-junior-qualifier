package com.coinbase.wallet.features.swap.models;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.common.utilities.Locales;
import com.coinbase.wallet.commonui.utilities.AmountText;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.swap.models.SwapAsset;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapAmountPickerViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001VB§\u0001\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\u0006\u0010)\u001a\u00020\u0016\u0012\b\b\u0002\u0010*\u001a\u00020\u0006\u0012\b\b\u0002\u0010+\u001a\u00020\u001a\u0012\b\b\u0002\u0010,\u001a\u00020\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\u0016\u0012\b\b\u0002\u0010.\u001a\u00020\u0016\u0012\b\b\u0002\u0010/\u001a\u00020\u0002¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0015J\u0010\u0010\u001e\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0018J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J²\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010#\u001a\u00020\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020\u001a2\b\b\u0002\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b2\u0010\u0015J\u0010\u00104\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b7\u00108R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b!\u0010\u0004R\u0019\u0010/\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u00109\u001a\u0004\b/\u0010\u0004R\u0019\u0010)\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010:\u001a\u0004\b;\u0010\u0018R\u0019\u0010,\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010<\u001a\u0004\b=\u0010\u0015R\u0019\u0010#\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\b?\u0010\u000bR\u0013\u0010@\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010\u0004R\u001b\u0010$\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bB\u0010\u000eR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010C\u001a\u0004\bD\u0010\bR\u001b\u0010&\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010E\u001a\u0004\bF\u0010\u0012R\u0019\u0010*\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010<\u001a\u0004\bG\u0010\u0015R\u0019\u0010-\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010:\u001a\u0004\bH\u0010\u0018R\u0019\u0010(\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\bI\u0010\u0015R\u001b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bJ\u0010\u000eR\u0019\u0010.\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010:\u001a\u0004\bK\u0010\u0018R\u0013\u0010L\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010\u0004R\u0013\u0010P\u001a\u00020M8F@\u0006¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0019\u0010+\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010Q\u001a\u0004\bR\u0010\u001cR\u0019\u0010'\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u00109\u001a\u0004\b'\u0010\u0004R\u0013\u0010S\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bS\u0010\u0004¨\u0006W"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;", "", "", "component1", "()Z", "", "", "component2", "()Ljava/util/List;", "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "component3", "()Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "component4", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "component5", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerError;", "component6", "()Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerError;", "component7", "component8", "()Ljava/lang/String;", "Lcom/coinbase/wallet/commonui/utilities/AmountText;", "component9", "()Lcom/coinbase/wallet/commonui/utilities/AmountText;", "component10", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;", "component11", "()Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;", "component12", "component13", "component14", "component15", "isInitialized", "pickerItems", "activeCurrencyCard", "sourceSwapAsset", "targetSwapAsset", "error", "isLoading", "nextButtonTitle", "fiatAmountText", "equivalentAmountInCrypto", "focusedCryptoInputField", "equivalentAmountInFiat", "cryptoSourceAmount", "cryptoTargetAmount", "isTargetFieldDisabled", "copy", "(ZLjava/util/List;Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerError;ZLjava/lang/String;Lcom/coinbase/wallet/commonui/utilities/AmountText;Ljava/lang/String;Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;Ljava/lang/String;Lcom/coinbase/wallet/commonui/utilities/AmountText;Lcom/coinbase/wallet/commonui/utilities/AmountText;Z)Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/coinbase/wallet/commonui/utilities/AmountText;", "getFiatAmountText", "Ljava/lang/String;", "getEquivalentAmountInFiat", "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "getActiveCurrencyCard", "isNextButtonVisible", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getSourceSwapAsset", "Ljava/util/List;", "getPickerItems", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerError;", "getError", "getEquivalentAmountInCrypto", "getCryptoSourceAmount", "getNextButtonTitle", "getTargetSwapAsset", "getCryptoTargetAmount", "isConvertAllVisible", "Ljava/util/Locale;", "getNumpadLocale", "()Ljava/util/Locale;", "numpadLocale", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;", "getFocusedCryptoInputField", "isNumpadVisible", "<init>", "(ZLjava/util/List;Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerError;ZLjava/lang/String;Lcom/coinbase/wallet/commonui/utilities/AmountText;Ljava/lang/String;Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;Ljava/lang/String;Lcom/coinbase/wallet/commonui/utilities/AmountText;Lcom/coinbase/wallet/commonui/utilities/AmountText;Z)V", "CryptoField", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewState {
    private final SwapCurrencyType activeCurrencyCard;
    private final AmountText cryptoSourceAmount;
    private final AmountText cryptoTargetAmount;
    private final String equivalentAmountInCrypto;
    private final String equivalentAmountInFiat;
    private final SwapAmountPickerError error;
    private final AmountText fiatAmountText;
    private final CryptoField focusedCryptoInputField;
    private final boolean isInitialized;
    private final boolean isLoading;
    private final boolean isTargetFieldDisabled;
    private final String nextButtonTitle;
    private final List<String> pickerItems;
    private final SwapAsset sourceSwapAsset;
    private final SwapAsset targetSwapAsset;

    /* compiled from: SwapAmountPickerViewState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState$CryptoField;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE", "TARGET", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum CryptoField {
        SOURCE,
        TARGET
    }

    public SwapAmountPickerViewState(boolean z, List<String> pickerItems, SwapCurrencyType activeCurrencyCard, SwapAsset swapAsset, SwapAsset swapAsset2, SwapAmountPickerError swapAmountPickerError, boolean z2, String nextButtonTitle, AmountText fiatAmountText, String equivalentAmountInCrypto, CryptoField focusedCryptoInputField, String equivalentAmountInFiat, AmountText cryptoSourceAmount, AmountText cryptoTargetAmount, boolean z3) {
        m.g(pickerItems, "pickerItems");
        m.g(activeCurrencyCard, "activeCurrencyCard");
        m.g(nextButtonTitle, "nextButtonTitle");
        m.g(fiatAmountText, "fiatAmountText");
        m.g(equivalentAmountInCrypto, "equivalentAmountInCrypto");
        m.g(focusedCryptoInputField, "focusedCryptoInputField");
        m.g(equivalentAmountInFiat, "equivalentAmountInFiat");
        m.g(cryptoSourceAmount, "cryptoSourceAmount");
        m.g(cryptoTargetAmount, "cryptoTargetAmount");
        this.isInitialized = z;
        this.pickerItems = pickerItems;
        this.activeCurrencyCard = activeCurrencyCard;
        this.sourceSwapAsset = swapAsset;
        this.targetSwapAsset = swapAsset2;
        this.error = swapAmountPickerError;
        this.isLoading = z2;
        this.nextButtonTitle = nextButtonTitle;
        this.fiatAmountText = fiatAmountText;
        this.equivalentAmountInCrypto = equivalentAmountInCrypto;
        this.focusedCryptoInputField = focusedCryptoInputField;
        this.equivalentAmountInFiat = equivalentAmountInFiat;
        this.cryptoSourceAmount = cryptoSourceAmount;
        this.cryptoTargetAmount = cryptoTargetAmount;
        this.isTargetFieldDisabled = z3;
    }

    public final boolean component1() {
        return this.isInitialized;
    }

    public final String component10() {
        return this.equivalentAmountInCrypto;
    }

    public final CryptoField component11() {
        return this.focusedCryptoInputField;
    }

    public final String component12() {
        return this.equivalentAmountInFiat;
    }

    public final AmountText component13() {
        return this.cryptoSourceAmount;
    }

    public final AmountText component14() {
        return this.cryptoTargetAmount;
    }

    public final boolean component15() {
        return this.isTargetFieldDisabled;
    }

    public final List<String> component2() {
        return this.pickerItems;
    }

    public final SwapCurrencyType component3() {
        return this.activeCurrencyCard;
    }

    public final SwapAsset component4() {
        return this.sourceSwapAsset;
    }

    public final SwapAsset component5() {
        return this.targetSwapAsset;
    }

    public final SwapAmountPickerError component6() {
        return this.error;
    }

    public final boolean component7() {
        return this.isLoading;
    }

    public final String component8() {
        return this.nextButtonTitle;
    }

    public final AmountText component9() {
        return this.fiatAmountText;
    }

    public final SwapAmountPickerViewState copy(boolean z, List<String> pickerItems, SwapCurrencyType activeCurrencyCard, SwapAsset swapAsset, SwapAsset swapAsset2, SwapAmountPickerError swapAmountPickerError, boolean z2, String nextButtonTitle, AmountText fiatAmountText, String equivalentAmountInCrypto, CryptoField focusedCryptoInputField, String equivalentAmountInFiat, AmountText cryptoSourceAmount, AmountText cryptoTargetAmount, boolean z3) {
        m.g(pickerItems, "pickerItems");
        m.g(activeCurrencyCard, "activeCurrencyCard");
        m.g(nextButtonTitle, "nextButtonTitle");
        m.g(fiatAmountText, "fiatAmountText");
        m.g(equivalentAmountInCrypto, "equivalentAmountInCrypto");
        m.g(focusedCryptoInputField, "focusedCryptoInputField");
        m.g(equivalentAmountInFiat, "equivalentAmountInFiat");
        m.g(cryptoSourceAmount, "cryptoSourceAmount");
        m.g(cryptoTargetAmount, "cryptoTargetAmount");
        return new SwapAmountPickerViewState(z, pickerItems, activeCurrencyCard, swapAsset, swapAsset2, swapAmountPickerError, z2, nextButtonTitle, fiatAmountText, equivalentAmountInCrypto, focusedCryptoInputField, equivalentAmountInFiat, cryptoSourceAmount, cryptoTargetAmount, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapAmountPickerViewState) {
            SwapAmountPickerViewState swapAmountPickerViewState = (SwapAmountPickerViewState) obj;
            return this.isInitialized == swapAmountPickerViewState.isInitialized && m.c(this.pickerItems, swapAmountPickerViewState.pickerItems) && this.activeCurrencyCard == swapAmountPickerViewState.activeCurrencyCard && m.c(this.sourceSwapAsset, swapAmountPickerViewState.sourceSwapAsset) && m.c(this.targetSwapAsset, swapAmountPickerViewState.targetSwapAsset) && this.error == swapAmountPickerViewState.error && this.isLoading == swapAmountPickerViewState.isLoading && m.c(this.nextButtonTitle, swapAmountPickerViewState.nextButtonTitle) && m.c(this.fiatAmountText, swapAmountPickerViewState.fiatAmountText) && m.c(this.equivalentAmountInCrypto, swapAmountPickerViewState.equivalentAmountInCrypto) && this.focusedCryptoInputField == swapAmountPickerViewState.focusedCryptoInputField && m.c(this.equivalentAmountInFiat, swapAmountPickerViewState.equivalentAmountInFiat) && m.c(this.cryptoSourceAmount, swapAmountPickerViewState.cryptoSourceAmount) && m.c(this.cryptoTargetAmount, swapAmountPickerViewState.cryptoTargetAmount) && this.isTargetFieldDisabled == swapAmountPickerViewState.isTargetFieldDisabled;
        }
        return false;
    }

    public final SwapCurrencyType getActiveCurrencyCard() {
        return this.activeCurrencyCard;
    }

    public final AmountText getCryptoSourceAmount() {
        return this.cryptoSourceAmount;
    }

    public final AmountText getCryptoTargetAmount() {
        return this.cryptoTargetAmount;
    }

    public final String getEquivalentAmountInCrypto() {
        return this.equivalentAmountInCrypto;
    }

    public final String getEquivalentAmountInFiat() {
        return this.equivalentAmountInFiat;
    }

    public final SwapAmountPickerError getError() {
        return this.error;
    }

    public final AmountText getFiatAmountText() {
        return this.fiatAmountText;
    }

    public final CryptoField getFocusedCryptoInputField() {
        return this.focusedCryptoInputField;
    }

    public final String getNextButtonTitle() {
        return this.nextButtonTitle;
    }

    public final Locale getNumpadLocale() {
        if (this.activeCurrencyCard == SwapCurrencyType.CRYPTO) {
            Locale locale = Locale.US;
            m.f(locale, "{\n                Locale.US\n            }");
            return locale;
        }
        return Locales.INSTANCE.getCurrent();
    }

    public final List<String> getPickerItems() {
        return this.pickerItems;
    }

    public final SwapAsset getSourceSwapAsset() {
        return this.sourceSwapAsset;
    }

    public final SwapAsset getTargetSwapAsset() {
        return this.targetSwapAsset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    public int hashCode() {
        boolean z = this.isInitialized;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((r0 * 31) + this.pickerItems.hashCode()) * 31) + this.activeCurrencyCard.hashCode()) * 31;
        SwapAsset swapAsset = this.sourceSwapAsset;
        int hashCode2 = (hashCode + (swapAsset == null ? 0 : swapAsset.hashCode())) * 31;
        SwapAsset swapAsset2 = this.targetSwapAsset;
        int hashCode3 = (hashCode2 + (swapAsset2 == null ? 0 : swapAsset2.hashCode())) * 31;
        SwapAmountPickerError swapAmountPickerError = this.error;
        int hashCode4 = (hashCode3 + (swapAmountPickerError != null ? swapAmountPickerError.hashCode() : 0)) * 31;
        ?? r2 = this.isLoading;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int hashCode5 = (((((((((((((((hashCode4 + i2) * 31) + this.nextButtonTitle.hashCode()) * 31) + this.fiatAmountText.hashCode()) * 31) + this.equivalentAmountInCrypto.hashCode()) * 31) + this.focusedCryptoInputField.hashCode()) * 31) + this.equivalentAmountInFiat.hashCode()) * 31) + this.cryptoSourceAmount.hashCode()) * 31) + this.cryptoTargetAmount.hashCode()) * 31;
        boolean z2 = this.isTargetFieldDisabled;
        return hashCode5 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final boolean isConvertAllVisible() {
        SwapAsset swapAsset = this.sourceSwapAsset;
        return ((swapAsset == null ? null : swapAsset.getContractAddress()) == null || m.c(this.sourceSwapAsset.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) ? false : true;
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isNextButtonVisible() {
        SwapAmountPickerError swapAmountPickerError;
        if (this.sourceSwapAsset != null && this.targetSwapAsset != null && ((swapAmountPickerError = this.error) == null || swapAmountPickerError == SwapAmountPickerError.HighPriceImpact)) {
            if ((this.cryptoSourceAmount.getRawString().length() > 0) && String_CommonKt.isNonZeroAmount(this.cryptoSourceAmount.getRawString())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isNumpadVisible() {
        return (this.sourceSwapAsset == null || this.targetSwapAsset == null) ? false : true;
    }

    public final boolean isTargetFieldDisabled() {
        return this.isTargetFieldDisabled;
    }

    public String toString() {
        return "SwapAmountPickerViewState(isInitialized=" + this.isInitialized + ", pickerItems=" + this.pickerItems + ", activeCurrencyCard=" + this.activeCurrencyCard + ", sourceSwapAsset=" + this.sourceSwapAsset + ", targetSwapAsset=" + this.targetSwapAsset + ", error=" + this.error + ", isLoading=" + this.isLoading + ", nextButtonTitle=" + this.nextButtonTitle + ", fiatAmountText=" + this.fiatAmountText + ", equivalentAmountInCrypto=" + this.equivalentAmountInCrypto + ", focusedCryptoInputField=" + this.focusedCryptoInputField + ", equivalentAmountInFiat=" + this.equivalentAmountInFiat + ", cryptoSourceAmount=" + this.cryptoSourceAmount + ", cryptoTargetAmount=" + this.cryptoTargetAmount + ", isTargetFieldDisabled=" + this.isTargetFieldDisabled + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ SwapAmountPickerViewState(boolean r20, java.util.List r21, com.coinbase.wallet.features.swap.models.SwapCurrencyType r22, com.coinbase.wallet.swap.models.SwapAsset r23, com.coinbase.wallet.swap.models.SwapAsset r24, com.coinbase.wallet.features.swap.models.SwapAmountPickerError r25, boolean r26, java.lang.String r27, com.coinbase.wallet.commonui.utilities.AmountText r28, java.lang.String r29, com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState.CryptoField r30, java.lang.String r31, com.coinbase.wallet.commonui.utilities.AmountText r32, com.coinbase.wallet.commonui.utilities.AmountText r33, boolean r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState.<init>(boolean, java.util.List, com.coinbase.wallet.features.swap.models.SwapCurrencyType, com.coinbase.wallet.swap.models.SwapAsset, com.coinbase.wallet.swap.models.SwapAsset, com.coinbase.wallet.features.swap.models.SwapAmountPickerError, boolean, java.lang.String, com.coinbase.wallet.commonui.utilities.AmountText, java.lang.String, com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState$CryptoField, java.lang.String, com.coinbase.wallet.commonui.utilities.AmountText, com.coinbase.wallet.commonui.utilities.AmountText, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}