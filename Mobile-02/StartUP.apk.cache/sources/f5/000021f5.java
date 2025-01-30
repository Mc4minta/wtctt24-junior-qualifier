package com.coinbase.wallet.features.swap.models;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.swap.models.AmountBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.internal.http2.Settings;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* compiled from: SwapConfirmationViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B«\u0001\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\b\b\u0002\u0010%\u001a\u00020\b\u0012\b\b\u0002\u0010&\u001a\u00020\b\u0012\b\b\u0002\u0010'\u001a\u00020\b\u0012\b\b\u0002\u0010(\u001a\u00020\b\u0012\b\b\u0002\u0010)\u001a\u00020\b\u0012\b\b\u0002\u0010*\u001a\u00020\b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJ\u0010\u0010\u0014\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\nJ\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0017\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0010\u0010\u0018\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ´\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b.\u0010\nJ\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104R\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b\u001f\u0010\rR\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u0010\u0004R\u0019\u0010'\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b9\u0010\nR\u0019\u0010\u001d\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010\u0007R\u0019\u0010%\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00108\u001a\u0004\b<\u0010\nR\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b!\u0010\rR\u0019\u0010)\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u00108\u001a\u0004\b=\u0010\nR\u0019\u0010*\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u00108\u001a\u0004\b>\u0010\nR\u0019\u0010$\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00108\u001a\u0004\b?\u0010\nR\u0019\u0010\"\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\b@\u0010\nR\u0019\u0010&\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\bA\u0010\nR\u0019\u0010(\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u00108\u001a\u0004\bB\u0010\nR\u001b\u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\bC\u0010\nR\u001b\u0010+\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010D\u001a\u0004\bE\u0010\u001bR\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b \u0010\rR\u0019\u0010\u001e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\bF\u0010\n¨\u0006I"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", "", "Lcom/coinbase/wallet/swap/models/AmountBase;", "component1", "()Lcom/coinbase/wallet/swap/models/AmountBase;", "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "component2", "()Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "", "component3", "()Ljava/lang/String;", "", "component4", "()Z", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "component16", "()Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "amountBase", SwapConfirmationArgs.currencyTypeKey, "cardTitle", "isLoading", "isConverting", "isConvertButtonVisible", "targetCurrencyCode", "targetImageURL", "sourceCryptoAmount", "sourceFiatAmount", "targetCryptoAmount", "minerFeeFiatAmount", "minerFeeCryptoAmount", "coinbaseFeeFiatAmount", "coinbaseFeeCryptoAmount", "error", "copy", "(Lcom/coinbase/wallet/swap/models/AmountBase;Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;)Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/coinbase/wallet/swap/models/AmountBase;", "getAmountBase", "Ljava/lang/String;", "getMinerFeeFiatAmount", "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "getCurrencyType", "getSourceFiatAmount", "getCoinbaseFeeFiatAmount", "getCoinbaseFeeCryptoAmount", "getSourceCryptoAmount", "getTargetCurrencyCode", "getTargetCryptoAmount", "getMinerFeeCryptoAmount", "getTargetImageURL", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "getError", "getCardTitle", "<init>", "(Lcom/coinbase/wallet/swap/models/AmountBase;Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationViewState {
    private final AmountBase amountBase;
    private final String cardTitle;
    private final String coinbaseFeeCryptoAmount;
    private final String coinbaseFeeFiatAmount;
    private final SwapCurrencyType currencyType;
    private final SwapConfirmationError error;
    private final boolean isConvertButtonVisible;
    private final boolean isConverting;
    private final boolean isLoading;
    private final String minerFeeCryptoAmount;
    private final String minerFeeFiatAmount;
    private final String sourceCryptoAmount;
    private final String sourceFiatAmount;
    private final String targetCryptoAmount;
    private final String targetCurrencyCode;
    private final String targetImageURL;

    public SwapConfirmationViewState() {
        this(null, null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    public SwapConfirmationViewState(AmountBase amountBase, SwapCurrencyType currencyType, String cardTitle, boolean z, boolean z2, boolean z3, String targetCurrencyCode, String str, String sourceCryptoAmount, String sourceFiatAmount, String targetCryptoAmount, String minerFeeFiatAmount, String minerFeeCryptoAmount, String coinbaseFeeFiatAmount, String coinbaseFeeCryptoAmount, SwapConfirmationError swapConfirmationError) {
        m.g(amountBase, "amountBase");
        m.g(currencyType, "currencyType");
        m.g(cardTitle, "cardTitle");
        m.g(targetCurrencyCode, "targetCurrencyCode");
        m.g(sourceCryptoAmount, "sourceCryptoAmount");
        m.g(sourceFiatAmount, "sourceFiatAmount");
        m.g(targetCryptoAmount, "targetCryptoAmount");
        m.g(minerFeeFiatAmount, "minerFeeFiatAmount");
        m.g(minerFeeCryptoAmount, "minerFeeCryptoAmount");
        m.g(coinbaseFeeFiatAmount, "coinbaseFeeFiatAmount");
        m.g(coinbaseFeeCryptoAmount, "coinbaseFeeCryptoAmount");
        this.amountBase = amountBase;
        this.currencyType = currencyType;
        this.cardTitle = cardTitle;
        this.isLoading = z;
        this.isConverting = z2;
        this.isConvertButtonVisible = z3;
        this.targetCurrencyCode = targetCurrencyCode;
        this.targetImageURL = str;
        this.sourceCryptoAmount = sourceCryptoAmount;
        this.sourceFiatAmount = sourceFiatAmount;
        this.targetCryptoAmount = targetCryptoAmount;
        this.minerFeeFiatAmount = minerFeeFiatAmount;
        this.minerFeeCryptoAmount = minerFeeCryptoAmount;
        this.coinbaseFeeFiatAmount = coinbaseFeeFiatAmount;
        this.coinbaseFeeCryptoAmount = coinbaseFeeCryptoAmount;
        this.error = swapConfirmationError;
    }

    public final AmountBase component1() {
        return this.amountBase;
    }

    public final String component10() {
        return this.sourceFiatAmount;
    }

    public final String component11() {
        return this.targetCryptoAmount;
    }

    public final String component12() {
        return this.minerFeeFiatAmount;
    }

    public final String component13() {
        return this.minerFeeCryptoAmount;
    }

    public final String component14() {
        return this.coinbaseFeeFiatAmount;
    }

    public final String component15() {
        return this.coinbaseFeeCryptoAmount;
    }

    public final SwapConfirmationError component16() {
        return this.error;
    }

    public final SwapCurrencyType component2() {
        return this.currencyType;
    }

    public final String component3() {
        return this.cardTitle;
    }

    public final boolean component4() {
        return this.isLoading;
    }

    public final boolean component5() {
        return this.isConverting;
    }

    public final boolean component6() {
        return this.isConvertButtonVisible;
    }

    public final String component7() {
        return this.targetCurrencyCode;
    }

    public final String component8() {
        return this.targetImageURL;
    }

    public final String component9() {
        return this.sourceCryptoAmount;
    }

    public final SwapConfirmationViewState copy(AmountBase amountBase, SwapCurrencyType currencyType, String cardTitle, boolean z, boolean z2, boolean z3, String targetCurrencyCode, String str, String sourceCryptoAmount, String sourceFiatAmount, String targetCryptoAmount, String minerFeeFiatAmount, String minerFeeCryptoAmount, String coinbaseFeeFiatAmount, String coinbaseFeeCryptoAmount, SwapConfirmationError swapConfirmationError) {
        m.g(amountBase, "amountBase");
        m.g(currencyType, "currencyType");
        m.g(cardTitle, "cardTitle");
        m.g(targetCurrencyCode, "targetCurrencyCode");
        m.g(sourceCryptoAmount, "sourceCryptoAmount");
        m.g(sourceFiatAmount, "sourceFiatAmount");
        m.g(targetCryptoAmount, "targetCryptoAmount");
        m.g(minerFeeFiatAmount, "minerFeeFiatAmount");
        m.g(minerFeeCryptoAmount, "minerFeeCryptoAmount");
        m.g(coinbaseFeeFiatAmount, "coinbaseFeeFiatAmount");
        m.g(coinbaseFeeCryptoAmount, "coinbaseFeeCryptoAmount");
        return new SwapConfirmationViewState(amountBase, currencyType, cardTitle, z, z2, z3, targetCurrencyCode, str, sourceCryptoAmount, sourceFiatAmount, targetCryptoAmount, minerFeeFiatAmount, minerFeeCryptoAmount, coinbaseFeeFiatAmount, coinbaseFeeCryptoAmount, swapConfirmationError);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapConfirmationViewState) {
            SwapConfirmationViewState swapConfirmationViewState = (SwapConfirmationViewState) obj;
            return m.c(this.amountBase, swapConfirmationViewState.amountBase) && this.currencyType == swapConfirmationViewState.currencyType && m.c(this.cardTitle, swapConfirmationViewState.cardTitle) && this.isLoading == swapConfirmationViewState.isLoading && this.isConverting == swapConfirmationViewState.isConverting && this.isConvertButtonVisible == swapConfirmationViewState.isConvertButtonVisible && m.c(this.targetCurrencyCode, swapConfirmationViewState.targetCurrencyCode) && m.c(this.targetImageURL, swapConfirmationViewState.targetImageURL) && m.c(this.sourceCryptoAmount, swapConfirmationViewState.sourceCryptoAmount) && m.c(this.sourceFiatAmount, swapConfirmationViewState.sourceFiatAmount) && m.c(this.targetCryptoAmount, swapConfirmationViewState.targetCryptoAmount) && m.c(this.minerFeeFiatAmount, swapConfirmationViewState.minerFeeFiatAmount) && m.c(this.minerFeeCryptoAmount, swapConfirmationViewState.minerFeeCryptoAmount) && m.c(this.coinbaseFeeFiatAmount, swapConfirmationViewState.coinbaseFeeFiatAmount) && m.c(this.coinbaseFeeCryptoAmount, swapConfirmationViewState.coinbaseFeeCryptoAmount) && m.c(this.error, swapConfirmationViewState.error);
        }
        return false;
    }

    public final AmountBase getAmountBase() {
        return this.amountBase;
    }

    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final String getCoinbaseFeeCryptoAmount() {
        return this.coinbaseFeeCryptoAmount;
    }

    public final String getCoinbaseFeeFiatAmount() {
        return this.coinbaseFeeFiatAmount;
    }

    public final SwapCurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public final SwapConfirmationError getError() {
        return this.error;
    }

    public final String getMinerFeeCryptoAmount() {
        return this.minerFeeCryptoAmount;
    }

    public final String getMinerFeeFiatAmount() {
        return this.minerFeeFiatAmount;
    }

    public final String getSourceCryptoAmount() {
        return this.sourceCryptoAmount;
    }

    public final String getSourceFiatAmount() {
        return this.sourceFiatAmount;
    }

    public final String getTargetCryptoAmount() {
        return this.targetCryptoAmount;
    }

    public final String getTargetCurrencyCode() {
        return this.targetCurrencyCode;
    }

    public final String getTargetImageURL() {
        return this.targetImageURL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.amountBase.hashCode() * 31) + this.currencyType.hashCode()) * 31) + this.cardTitle.hashCode()) * 31;
        boolean z = this.isLoading;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.isConverting;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isConvertButtonVisible;
        int hashCode2 = (((i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.targetCurrencyCode.hashCode()) * 31;
        String str = this.targetImageURL;
        int hashCode3 = (((((((((((((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.sourceCryptoAmount.hashCode()) * 31) + this.sourceFiatAmount.hashCode()) * 31) + this.targetCryptoAmount.hashCode()) * 31) + this.minerFeeFiatAmount.hashCode()) * 31) + this.minerFeeCryptoAmount.hashCode()) * 31) + this.coinbaseFeeFiatAmount.hashCode()) * 31) + this.coinbaseFeeCryptoAmount.hashCode()) * 31;
        SwapConfirmationError swapConfirmationError = this.error;
        return hashCode3 + (swapConfirmationError != null ? swapConfirmationError.hashCode() : 0);
    }

    public final boolean isConvertButtonVisible() {
        return this.isConvertButtonVisible;
    }

    public final boolean isConverting() {
        return this.isConverting;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "SwapConfirmationViewState(amountBase=" + this.amountBase + ", currencyType=" + this.currencyType + ", cardTitle=" + this.cardTitle + ", isLoading=" + this.isLoading + ", isConverting=" + this.isConverting + ", isConvertButtonVisible=" + this.isConvertButtonVisible + ", targetCurrencyCode=" + this.targetCurrencyCode + ", targetImageURL=" + ((Object) this.targetImageURL) + ", sourceCryptoAmount=" + this.sourceCryptoAmount + ", sourceFiatAmount=" + this.sourceFiatAmount + ", targetCryptoAmount=" + this.targetCryptoAmount + ", minerFeeFiatAmount=" + this.minerFeeFiatAmount + ", minerFeeCryptoAmount=" + this.minerFeeCryptoAmount + ", coinbaseFeeFiatAmount=" + this.coinbaseFeeFiatAmount + ", coinbaseFeeCryptoAmount=" + this.coinbaseFeeCryptoAmount + ", error=" + this.error + ')';
    }

    public /* synthetic */ SwapConfirmationViewState(AmountBase amountBase, SwapCurrencyType swapCurrencyType, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, SwapConfirmationError swapConfirmationError, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? AmountBase.Target.INSTANCE : amountBase, (i2 & 2) != 0 ? SwapCurrencyType.FIAT : swapCurrencyType, (i2 & 4) != 0 ? LocalizedStrings.INSTANCE.get(R.string.swap) : str, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) == 0 ? z3 : false, (i2 & 64) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str2, (i2 & 128) != 0 ? null : str3, (i2 & 256) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str4, (i2 & 512) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str5, (i2 & 1024) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str6, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str7, (i2 & 4096) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str8, (i2 & PKIFailureInfo.certRevoked) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str9, (i2 & 16384) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str10, (i2 & 32768) != 0 ? null : swapConfirmationError);
    }
}