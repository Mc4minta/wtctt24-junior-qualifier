package com.coinbase.wallet.features.swap.models;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapFee;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: SwapConfirmationViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "feeWallet", "Ljava/math/BigInteger;", "lowerBoundFee", "estimatedMinerFee", "Lcom/coinbase/wallet/swap/models/SwapFee;", "coinbaseFee", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "swapQuote", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "error", "newState", "(Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/SwapFee;Lcom/coinbase/wallet/swap/models/SwapQuote;Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;)Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationViewStateKt {
    public static final SwapConfirmationViewState newState(SwapConfirmationViewState swapConfirmationViewState, CurrencyFormatter currencyFormatter, Wallet feeWallet, BigInteger bigInteger, BigInteger estimatedMinerFee, SwapFee coinbaseFee, SwapQuote swapQuote, SwapConfirmationError swapConfirmationError) {
        String formatToCryptoRange;
        String formatToFiatRange;
        String str;
        SwapConfirmationViewState copy;
        m.g(swapConfirmationViewState, "<this>");
        m.g(currencyFormatter, "currencyFormatter");
        m.g(feeWallet, "feeWallet");
        m.g(estimatedMinerFee, "estimatedMinerFee");
        m.g(coinbaseFee, "coinbaseFee");
        m.g(swapQuote, "swapQuote");
        formatToCryptoRange = currencyFormatter.formatToCryptoRange(feeWallet.getCurrencyCode(), feeWallet.getDecimals(), bigInteger, estimatedMinerFee, (r17 & 16) != 0, (r17 & 32) != 0 ? 4 : 0, (r17 & 64) != 0 ? 0 : 0);
        CurrencyCode currencyCode = feeWallet.getCurrencyCode();
        String contractAddress = feeWallet.getContractAddress();
        int decimals = feeWallet.getDecimals();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(feeWallet.getNetwork());
        formatToFiatRange = currencyFormatter.formatToFiatRange(currencyCode, contractAddress, decimals, bigInteger, estimatedMinerFee, (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? null : asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
        if (formatToFiatRange == null) {
            formatToFiatRange = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        str = formatToFiatRange;
        SwapAsset baseAsset = coinbaseFee.getBaseAsset();
        BigInteger coinbaseFeeAmount = coinbaseFee.getAmount().toBigInteger();
        CurrencyCode currencyCode2 = baseAsset.getCurrencyCode();
        int decimals2 = baseAsset.getDecimals();
        m.f(coinbaseFeeAmount, "coinbaseFeeAmount");
        String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(currencyFormatter, currencyCode2, decimals2, coinbaseFeeAmount, false, 0, 0, 56, (Object) null);
        CurrencyCode currencyCode3 = baseAsset.getCurrencyCode();
        ContractAddress contractAddress2 = baseAsset.getContractAddress();
        String rawValue = contractAddress2 == null ? null : contractAddress2.getRawValue();
        int decimals3 = baseAsset.getDecimals();
        EthereumChain asEthereumChain2 = Network_EthereumKt.getAsEthereumChain(feeWallet.getNetwork());
        BigDecimal coinbaseFeeFiatAmount = CurrencyFormatter.fiatValue$default(currencyFormatter, currencyCode3, rawValue, decimals3, coinbaseFeeAmount, null, asEthereumChain2 == null ? null : Integer.valueOf(asEthereumChain2.getChainId()), 16, null);
        if (coinbaseFeeFiatAmount == null) {
            coinbaseFeeFiatAmount = BigDecimal.ZERO;
        }
        m.f(coinbaseFeeFiatAmount, "coinbaseFeeFiatAmount");
        String fiatValueString = currencyFormatter.fiatValueString(coinbaseFeeFiatAmount, true);
        String formatToCrypto$default2 = CurrencyFormatter.formatToCrypto$default(currencyFormatter, swapQuote.getToAsset().getCurrencyCode(), swapQuote.getToAsset().getDecimals(), swapQuote.getToAmount(), false, 0, 0, 56, (Object) null);
        String formatToCrypto$default3 = CurrencyFormatter.formatToCrypto$default(currencyFormatter, swapQuote.getFromAsset().getCurrencyCode(), swapQuote.getFromAsset().getDecimals(), swapQuote.getFromAmount(), true, 0, 0, 48, (Object) null);
        CurrencyCode currencyCode4 = swapQuote.getFromAsset().getCurrencyCode();
        ContractAddress contractAddress3 = swapQuote.getFromAsset().getContractAddress();
        BigDecimal fiatAmount = CurrencyFormatter.fiatValue$default(currencyFormatter, currencyCode4, contractAddress3 == null ? null : contractAddress3.getRawValue(), swapQuote.getFromAsset().getDecimals(), swapQuote.getFromAmount(), null, Integer.valueOf(swapQuote.getChainId()), 16, null);
        if (fiatAmount == null) {
            fiatAmount = BigDecimal.ZERO;
        }
        m.f(fiatAmount, "fiatAmount");
        copy = swapConfirmationViewState.copy((r34 & 1) != 0 ? swapConfirmationViewState.amountBase : null, (r34 & 2) != 0 ? swapConfirmationViewState.currencyType : null, (r34 & 4) != 0 ? swapConfirmationViewState.cardTitle : null, (r34 & 8) != 0 ? swapConfirmationViewState.isLoading : false, (r34 & 16) != 0 ? swapConfirmationViewState.isConverting : false, (r34 & 32) != 0 ? swapConfirmationViewState.isConvertButtonVisible : swapConfirmationError == null, (r34 & 64) != 0 ? swapConfirmationViewState.targetCurrencyCode : null, (r34 & 128) != 0 ? swapConfirmationViewState.targetImageURL : null, (r34 & 256) != 0 ? swapConfirmationViewState.sourceCryptoAmount : formatToCrypto$default3, (r34 & 512) != 0 ? swapConfirmationViewState.sourceFiatAmount : currencyFormatter.fiatValueString(fiatAmount, true), (r34 & 1024) != 0 ? swapConfirmationViewState.targetCryptoAmount : formatToCrypto$default2, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? swapConfirmationViewState.minerFeeFiatAmount : str, (r34 & 4096) != 0 ? swapConfirmationViewState.minerFeeCryptoAmount : formatToCryptoRange, (r34 & PKIFailureInfo.certRevoked) != 0 ? swapConfirmationViewState.coinbaseFeeFiatAmount : fiatValueString, (r34 & 16384) != 0 ? swapConfirmationViewState.coinbaseFeeCryptoAmount : formatToCrypto$default, (r34 & 32768) != 0 ? swapConfirmationViewState.error : swapConfirmationError);
        return copy;
    }
}