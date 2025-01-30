package com.coinbase.wallet.swap.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.swap.models.Aggregator;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapAssetStats;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.coinbase.wallet.swap.models.SwapTrade;
import h.c.b0;
import h.c.s;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: ISwapRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&¢\u0006\u0004\b\u0015\u0010\u0016J=\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b \u0010!JE\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b%\u0010&J+\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b(\u0010)J+\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b*\u0010)J#\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\r0\u00042\u0006\u0010+\u001a\u00020$H&¢\u0006\u0004\b-\u0010.J#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\r0\u00042\u0006\u0010+\u001a\u00020$H&¢\u0006\u0004\b0\u0010.J/\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\r0\u00042\u0006\u0010+\u001a\u00020$2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b2\u00103J/\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\r0\u00042\u0006\u0010+\u001a\u00020$2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b4\u00103J\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00105\u001a\u00020\u000eH&¢\u0006\u0004\b6\u00107J\u001b\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00110\u0004H&¢\u0006\u0004\b9\u0010:R\"\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "", "isForced", "Lh/c/b0;", "Lkotlin/x;", "refresh", "(Z)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lh/c/s;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "observeSwapAsset", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;)Lh/c/s;", "", "", "ids", "Lcom/coinbase/wallet/swap/models/Aggregator;", "getAggregators", "(Ljava/util/List;)Lh/c/b0;", Payload.SOURCE, "target", "Ljava/math/BigInteger;", "amount", "Lcom/coinbase/wallet/swap/models/AmountBase;", "amountBase", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/swap/models/SwapQuote;", "getFastQuote", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;I)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "address", "Lcom/coinbase/wallet/swap/models/SwapTrade;", "getTrade", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;I)Lh/c/b0;", "signedTxHashes", "getEstimatedMinerFee", "(Ljava/util/List;I)Lh/c/b0;", "getEstimatedGasLimit", "trade", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;", "generateUnsignedApproveTx", "(Lcom/coinbase/wallet/swap/models/SwapTrade;)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "generateUnsigned1559ApproveTx", AdjustableMinerFeeArgs.NONCE, "generateUnsignedSwapTx", "(Lcom/coinbase/wallet/swap/models/SwapTrade;Ljava/lang/Integer;)Lh/c/b0;", "generateUnsigned1559SwapTx", "asset", "selectSwapAsset", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)Lh/c/b0;", "Lcom/coinbase/wallet/swap/models/SwapAssetStats;", "getSwapAssetStats", "()Lh/c/b0;", "getSwapAssetListObservable", "()Lh/c/s;", "swapAssetListObservable", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ISwapRepository extends Refreshable {

    /* compiled from: ISwapRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ b0 generateUnsigned1559SwapTx$default(ISwapRepository iSwapRepository, SwapTrade swapTrade, Integer num, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    num = null;
                }
                return iSwapRepository.generateUnsigned1559SwapTx(swapTrade, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsigned1559SwapTx");
        }

        public static /* synthetic */ b0 generateUnsignedSwapTx$default(ISwapRepository iSwapRepository, SwapTrade swapTrade, Integer num, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    num = null;
                }
                return iSwapRepository.generateUnsignedSwapTx(swapTrade, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedSwapTx");
        }
    }

    b0<Optional<EthereumUnsigned1559Tx>> generateUnsigned1559ApproveTx(SwapTrade swapTrade);

    b0<Optional<EthereumUnsigned1559Tx>> generateUnsigned1559SwapTx(SwapTrade swapTrade, Integer num);

    b0<Optional<EthereumUnsignedLegacyTx>> generateUnsignedApproveTx(SwapTrade swapTrade);

    b0<Optional<EthereumUnsignedLegacyTx>> generateUnsignedSwapTx(SwapTrade swapTrade, Integer num);

    b0<List<Aggregator>> getAggregators(List<String> list);

    b0<BigInteger> getEstimatedGasLimit(List<String> list, int i2);

    b0<BigInteger> getEstimatedMinerFee(List<String> list, int i2);

    b0<SwapQuote> getFastQuote(SwapAsset swapAsset, SwapAsset swapAsset2, BigInteger bigInteger, AmountBase amountBase, int i2);

    s<List<SwapAsset>> getSwapAssetListObservable();

    b0<List<SwapAssetStats>> getSwapAssetStats();

    b0<SwapTrade> getTrade(WalletAddress walletAddress, SwapAsset swapAsset, SwapAsset swapAsset2, BigInteger bigInteger, AmountBase amountBase, int i2);

    s<Optional<SwapAsset>> observeSwapAsset(CurrencyCode currencyCode, ContractAddress contractAddress);

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    b0<x> refresh(boolean z);

    b0<x> selectSwapAsset(SwapAsset swapAsset);
}