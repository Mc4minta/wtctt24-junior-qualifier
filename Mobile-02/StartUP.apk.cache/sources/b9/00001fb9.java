package com.coinbase.wallet.features.send.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyDecimal_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.features.lend.models.LendConfirmationArgs;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SendConfirmationResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)BK\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b!\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b&\u0010\u0007¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "component1", "()Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", ApiConstants.STATE, "fiatAmount", "cryptoAmount", "fiatFee", "cryptoFee", "fiatTotal", "cryptoTotal", "copy", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCryptoTotal", "getFiatFee", "getFiatTotal", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "getState", "getCryptoAmount", "getFiatAmount", "getCryptoFee", "<init>", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationResult {
    public static final Companion Companion = new Companion(null);
    private final String cryptoAmount;
    private final String cryptoFee;
    private final String cryptoTotal;
    private final String fiatAmount;
    private final String fiatFee;
    private final String fiatTotal;
    private final SendConfirmationState state;

    public SendConfirmationResult(SendConfirmationState state, String fiatAmount, String cryptoAmount, String fiatFee, String cryptoFee, String fiatTotal, String cryptoTotal) {
        m.g(state, "state");
        m.g(fiatAmount, "fiatAmount");
        m.g(cryptoAmount, "cryptoAmount");
        m.g(fiatFee, "fiatFee");
        m.g(cryptoFee, "cryptoFee");
        m.g(fiatTotal, "fiatTotal");
        m.g(cryptoTotal, "cryptoTotal");
        this.state = state;
        this.fiatAmount = fiatAmount;
        this.cryptoAmount = cryptoAmount;
        this.fiatFee = fiatFee;
        this.cryptoFee = cryptoFee;
        this.fiatTotal = fiatTotal;
        this.cryptoTotal = cryptoTotal;
    }

    public static /* synthetic */ SendConfirmationResult copy$default(SendConfirmationResult sendConfirmationResult, SendConfirmationState sendConfirmationState, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sendConfirmationState = sendConfirmationResult.state;
        }
        if ((i2 & 2) != 0) {
            str = sendConfirmationResult.fiatAmount;
        }
        String str7 = str;
        if ((i2 & 4) != 0) {
            str2 = sendConfirmationResult.cryptoAmount;
        }
        String str8 = str2;
        if ((i2 & 8) != 0) {
            str3 = sendConfirmationResult.fiatFee;
        }
        String str9 = str3;
        if ((i2 & 16) != 0) {
            str4 = sendConfirmationResult.cryptoFee;
        }
        String str10 = str4;
        if ((i2 & 32) != 0) {
            str5 = sendConfirmationResult.fiatTotal;
        }
        String str11 = str5;
        if ((i2 & 64) != 0) {
            str6 = sendConfirmationResult.cryptoTotal;
        }
        return sendConfirmationResult.copy(sendConfirmationState, str7, str8, str9, str10, str11, str6);
    }

    public final SendConfirmationState component1() {
        return this.state;
    }

    public final String component2() {
        return this.fiatAmount;
    }

    public final String component3() {
        return this.cryptoAmount;
    }

    public final String component4() {
        return this.fiatFee;
    }

    public final String component5() {
        return this.cryptoFee;
    }

    public final String component6() {
        return this.fiatTotal;
    }

    public final String component7() {
        return this.cryptoTotal;
    }

    public final SendConfirmationResult copy(SendConfirmationState state, String fiatAmount, String cryptoAmount, String fiatFee, String cryptoFee, String fiatTotal, String cryptoTotal) {
        m.g(state, "state");
        m.g(fiatAmount, "fiatAmount");
        m.g(cryptoAmount, "cryptoAmount");
        m.g(fiatFee, "fiatFee");
        m.g(cryptoFee, "cryptoFee");
        m.g(fiatTotal, "fiatTotal");
        m.g(cryptoTotal, "cryptoTotal");
        return new SendConfirmationResult(state, fiatAmount, cryptoAmount, fiatFee, cryptoFee, fiatTotal, cryptoTotal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendConfirmationResult) {
            SendConfirmationResult sendConfirmationResult = (SendConfirmationResult) obj;
            return m.c(this.state, sendConfirmationResult.state) && m.c(this.fiatAmount, sendConfirmationResult.fiatAmount) && m.c(this.cryptoAmount, sendConfirmationResult.cryptoAmount) && m.c(this.fiatFee, sendConfirmationResult.fiatFee) && m.c(this.cryptoFee, sendConfirmationResult.cryptoFee) && m.c(this.fiatTotal, sendConfirmationResult.fiatTotal) && m.c(this.cryptoTotal, sendConfirmationResult.cryptoTotal);
        }
        return false;
    }

    public final String getCryptoAmount() {
        return this.cryptoAmount;
    }

    public final String getCryptoFee() {
        return this.cryptoFee;
    }

    public final String getCryptoTotal() {
        return this.cryptoTotal;
    }

    public final String getFiatAmount() {
        return this.fiatAmount;
    }

    public final String getFiatFee() {
        return this.fiatFee;
    }

    public final String getFiatTotal() {
        return this.fiatTotal;
    }

    public final SendConfirmationState getState() {
        return this.state;
    }

    public int hashCode() {
        return (((((((((((this.state.hashCode() * 31) + this.fiatAmount.hashCode()) * 31) + this.cryptoAmount.hashCode()) * 31) + this.fiatFee.hashCode()) * 31) + this.cryptoFee.hashCode()) * 31) + this.fiatTotal.hashCode()) * 31) + this.cryptoTotal.hashCode();
    }

    public String toString() {
        return "SendConfirmationResult(state=" + this.state + ", fiatAmount=" + this.fiatAmount + ", cryptoAmount=" + this.cryptoAmount + ", fiatFee=" + this.fiatFee + ", cryptoFee=" + this.cryptoFee + ", fiatTotal=" + this.fiatTotal + ", cryptoTotal=" + this.cryptoTotal + ')';
    }

    /* compiled from: SendConfirmationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationResult$Companion;", "", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", ApiConstants.STATE, "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "tx", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "feeWallet", "wallet", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "createLegacy", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationState;Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "create1559", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationState;Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "", "txs", "Lcom/coinbase/wallet/lending/models/LendToken;", LendConfirmationArgs.lendTokenKey, "Ljava/math/BigInteger;", "amount", "create", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationState;Ljava/util/List;Lcom/coinbase/wallet/lending/models/LendToken;Ljava/math/BigInteger;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SendConfirmationResult create1559(SendConfirmationState sendConfirmationState, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, Wallet wallet, Wallet wallet2, CurrencyFormatter currencyFormatter) {
            String formatToFiat;
            String formatToFiatRange;
            String formatToCryptoRange;
            String formatToFiatRange2;
            String formatToCryptoRange2;
            BigInteger transferValue = ethereumUnsigned1559Tx.getTransferValue();
            BigInteger transferValue2 = ethereumUnsigned1559Tx.getTransferValue();
            if (m.c(wallet.getCurrencyCode(), wallet2.getCurrencyCode()) && m.c(wallet.getContractAddress(), wallet2.getContractAddress())) {
                transferValue2 = transferValue2.add(ethereumUnsigned1559Tx.getEstimatedFee());
                m.f(transferValue2, "this.add(other)");
            }
            BigInteger bigInteger = transferValue2;
            formatToFiat = currencyFormatter.formatToFiat(ethereumUnsigned1559Tx.getCurrencyCode(), wallet2.getContractAddress(), wallet2.getDecimals(), transferValue, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
            if (formatToFiat == null) {
                formatToFiat = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            String str = formatToFiat;
            formatToFiatRange = currencyFormatter.formatToFiatRange(ethereumUnsigned1559Tx.getFeeCurrencyCode(), null, 18, ethereumUnsigned1559Tx.getLowerBoundFee(), ethereumUnsigned1559Tx.getEstimatedFee(), (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? null : null);
            if (formatToFiatRange == null) {
                formatToFiatRange = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            String str2 = formatToFiatRange;
            formatToCryptoRange = currencyFormatter.formatToCryptoRange(ethereumUnsigned1559Tx.getFeeCurrencyCode(), 18, ethereumUnsigned1559Tx.getLowerBoundFee(), ethereumUnsigned1559Tx.getEstimatedFee(), (r17 & 16) != 0, (r17 & 32) != 0 ? 4 : 0, (r17 & 64) != 0 ? 0 : 0);
            CurrencyCode feeCurrencyCode = ethereumUnsigned1559Tx.getFeeCurrencyCode();
            BigInteger add = ethereumUnsigned1559Tx.getLowerBoundFee().add(transferValue);
            m.f(add, "this.add(other)");
            formatToFiatRange2 = currencyFormatter.formatToFiatRange(feeCurrencyCode, null, 18, add, bigInteger, (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? null : null);
            if (formatToFiatRange2 == null) {
                formatToFiatRange2 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            String str3 = formatToFiatRange2;
            String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(currencyFormatter, ethereumUnsigned1559Tx.getCurrencyCode(), wallet2.getDecimals(), transferValue, false, 0, 0, 56, (Object) null);
            CurrencyCode feeCurrencyCode2 = ethereumUnsigned1559Tx.getFeeCurrencyCode();
            BigInteger add2 = ethereumUnsigned1559Tx.getLowerBoundFee().add(transferValue);
            m.f(add2, "this.add(other)");
            formatToCryptoRange2 = currencyFormatter.formatToCryptoRange(feeCurrencyCode2, 18, add2, bigInteger, (r17 & 16) != 0, (r17 & 32) != 0 ? 4 : 0, (r17 & 64) != 0 ? 0 : 0);
            return new SendConfirmationResult(sendConfirmationState, str, formatToCrypto$default, str2, formatToCryptoRange, str3, formatToCryptoRange2);
        }

        private final SendConfirmationResult createLegacy(SendConfirmationState sendConfirmationState, UnsignedTx unsignedTx, Wallet wallet, Wallet wallet2, CurrencyFormatter currencyFormatter) {
            String formatToFiat;
            String formatToFiat2;
            String formatToFiat3;
            BigInteger transferValue = unsignedTx.getTransferValue();
            BigInteger estimatedFee = unsignedTx.getEstimatedFee();
            BigInteger transferValue2 = unsignedTx.getTransferValue();
            if (m.c(wallet.getCurrencyCode(), wallet2.getCurrencyCode()) && m.c(wallet.getContractAddress(), wallet2.getContractAddress())) {
                transferValue2 = transferValue2.add(unsignedTx.getEstimatedFee());
                m.f(transferValue2, "this.add(other)");
            }
            BigInteger bigInteger = transferValue2;
            formatToFiat = currencyFormatter.formatToFiat(unsignedTx.getCurrencyCode(), wallet2.getContractAddress(), wallet2.getDecimals(), transferValue, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
            if (formatToFiat == null) {
                formatToFiat = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            String str = formatToFiat;
            formatToFiat2 = currencyFormatter.formatToFiat(unsignedTx.getFeeCurrencyCode(), wallet.getContractAddress(), wallet.getDecimals(), estimatedFee, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
            if (formatToFiat2 == null) {
                formatToFiat2 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            String str2 = formatToFiat2;
            formatToFiat3 = currencyFormatter.formatToFiat(unsignedTx.getCurrencyCode(), wallet2.getContractAddress(), wallet2.getDecimals(), bigInteger, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
            if (formatToFiat3 == null) {
                formatToFiat3 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            return new SendConfirmationResult(sendConfirmationState, str, CurrencyFormatter.formatToCrypto$default(currencyFormatter, unsignedTx.getCurrencyCode(), wallet2.getDecimals(), transferValue, false, 0, 0, 56, (Object) null), str2, CurrencyFormatter.formatToCrypto$default(currencyFormatter, unsignedTx.getFeeCurrencyCode(), wallet.getDecimals(), estimatedFee, false, 0, 0, 56, (Object) null), formatToFiat3, CurrencyFormatter.formatToCrypto$default(currencyFormatter, unsignedTx.getCurrencyCode(), wallet2.getDecimals(), bigInteger, false, 0, 0, 56, (Object) null));
        }

        public final SendConfirmationResult create(SendConfirmationState state, UnsignedTx tx, Wallet feeWallet, Wallet wallet, CurrencyFormatter currencyFormatter) {
            m.g(state, "state");
            m.g(tx, "tx");
            m.g(feeWallet, "feeWallet");
            m.g(wallet, "wallet");
            m.g(currencyFormatter, "currencyFormatter");
            if (tx instanceof EthereumUnsigned1559Tx) {
                return create1559(state, (EthereumUnsigned1559Tx) tx, feeWallet, wallet, currencyFormatter);
            }
            return createLegacy(state, tx, feeWallet, wallet, currencyFormatter);
        }

        public final SendConfirmationResult create(SendConfirmationState state, List<EthereumUnsigned1559Tx> txs, LendToken lendToken, BigInteger amount, CurrencyFormatter currencyFormatter) {
            int r;
            int r2;
            BigInteger bigInteger;
            String formatToFiat;
            String formatToFiatRange;
            String formatToFiat2;
            String formatToCryptoRange;
            m.g(state, "state");
            m.g(txs, "txs");
            m.g(lendToken, "lendToken");
            m.g(amount, "amount");
            m.g(currencyFormatter, "currencyFormatter");
            r = s.r(txs, 10);
            ArrayList arrayList = new ArrayList(r);
            for (EthereumUnsigned1559Tx ethereumUnsigned1559Tx : txs) {
                arrayList.add(ethereumUnsigned1559Tx.getEstimatedFee());
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                Object obj = it.next();
                while (it.hasNext()) {
                    Object add = ((BigInteger) obj).add((BigInteger) it.next());
                    m.f(add, "this.add(other)");
                    obj = add;
                }
                BigInteger bigInteger2 = (BigInteger) obj;
                r2 = s.r(txs, 10);
                ArrayList arrayList2 = new ArrayList(r2);
                for (EthereumUnsigned1559Tx ethereumUnsigned1559Tx2 : txs) {
                    arrayList2.add(ethereumUnsigned1559Tx2.getLowerBoundFee());
                }
                Iterator it2 = arrayList2.iterator();
                if (it2.hasNext()) {
                    BigInteger bigInteger3 = it2.next();
                    while (it2.hasNext()) {
                        BigInteger add2 = ((BigInteger) bigInteger3).add((BigInteger) it2.next());
                        m.f(add2, "this.add(other)");
                        bigInteger3 = add2;
                    }
                    BigInteger bigInteger4 = (BigInteger) bigInteger3;
                    CurrencyCode currencyCodeForNetwork = WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(((EthereumUnsigned1559Tx) p.Y(txs)).getNetwork());
                    int eth = CurrencyDecimal_EthereumKt.getETH(CurrencyDecimal.INSTANCE);
                    if (m.c(lendToken.getCurrencyCode(), currencyCodeForNetwork)) {
                        BigInteger add3 = amount.add(bigInteger2);
                        m.f(add3, "this.add(other)");
                        bigInteger = add3;
                    } else {
                        bigInteger = amount;
                    }
                    CurrencyCode currencyCode = lendToken.getCurrencyCode();
                    ContractAddress contractAddress = lendToken.getContractAddress();
                    formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), lendToken.getDecimals(), amount, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
                    if (formatToFiat == null) {
                        formatToFiat = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
                    }
                    String str = formatToFiat;
                    formatToFiatRange = currencyFormatter.formatToFiatRange(currencyCodeForNetwork, null, eth, bigInteger4, bigInteger2, (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? null : null);
                    if (formatToFiatRange == null) {
                        formatToFiatRange = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
                    }
                    String str2 = formatToFiatRange;
                    CurrencyCode currencyCode2 = lendToken.getCurrencyCode();
                    ContractAddress contractAddress2 = lendToken.getContractAddress();
                    formatToFiat2 = currencyFormatter.formatToFiat(currencyCode2, contractAddress2 == null ? null : contractAddress2.getRawValue(), lendToken.getDecimals(), bigInteger, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
                    if (formatToFiat2 == null) {
                        formatToFiat2 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
                    }
                    String str3 = formatToFiat2;
                    String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(currencyFormatter, lendToken.getCurrencyCode(), lendToken.getDecimals(), amount, false, 0, 0, 56, (Object) null);
                    formatToCryptoRange = currencyFormatter.formatToCryptoRange(currencyCodeForNetwork, eth, bigInteger4, bigInteger2, (r17 & 16) != 0, (r17 & 32) != 0 ? 4 : 0, (r17 & 64) != 0 ? 0 : 0);
                    return new SendConfirmationResult(state, str, formatToCrypto$default, str2, formatToCryptoRange, str3, CurrencyFormatter.formatToCrypto$default(currencyFormatter, lendToken.getCurrencyCode(), lendToken.getDecimals(), bigInteger, false, 0, 0, 56, (Object) null));
                }
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
    }

    public /* synthetic */ SendConfirmationResult(SendConfirmationState sendConfirmationState, String str, String str2, String str3, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sendConfirmationState, (i2 & 2) != 0 ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : str, (i2 & 4) != 0 ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : str2, (i2 & 8) != 0 ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : str3, (i2 & 16) != 0 ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : str4, (i2 & 32) != 0 ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : str5, (i2 & 64) != 0 ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : str6);
    }
}