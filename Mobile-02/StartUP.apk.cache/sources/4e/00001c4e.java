package com.coinbase.wallet.ethereum.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559Result;
import com.coinbase.wallet.ethereum.exceptions.ERC20ContractException;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.String_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.ERC20Approving;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating;
import com.coinbase.wallet.ethereum.models.ETHABIEncodedAddress;
import com.coinbase.wallet.ethereum.models.ETHABIEncodedUInt256;
import com.coinbase.wallet.ethereum.models.GasEstimationStatus;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ERC20Approving.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J_\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/ERC20Approving;", "Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxCreating;", "", "fromAddress", "spenderAddress", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Ljava/math/BigInteger;", "amount", "approveAmount", "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateApproveTx", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/util/Map;)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "getErc20ContractAPI", "()Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "erc20ContractAPI", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ERC20Approving extends EthereumTxCreating {

    /* compiled from: ERC20Approving.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ UnsignedTxResult.Error a(UnsignedTxResult unsignedTxResult) {
            return m1100generateApproveTx$lambda2$lambda0(unsignedTxResult);
        }

        public static /* synthetic */ h.c.h0 b(BigInteger bigInteger, ERC20Approving eRC20Approving, String str, String str2, byte[] bArr, EthereumChain ethereumChain, CurrencyCode currencyCode, Map map, kotlin.t tVar) {
            return m1099generateApproveTx$lambda2(bigInteger, eRC20Approving, str, str2, bArr, ethereumChain, currencyCode, map, tVar);
        }

        public static /* synthetic */ Optional c(UnsignedTxResult unsignedTxResult) {
            return m1101generateApproveTx$lambda2$lambda1(unsignedTxResult);
        }

        public static h.c.b0<Optional<UnsignedTxResult>> generateApproveTx(final ERC20Approving eRC20Approving, final String fromAddress, String spenderAddress, final String contractAddress, final CurrencyCode currencyCode, final BigInteger amount, BigInteger approveAmount, final Map<TxMetadataKey, ? extends Object> metadata) {
            List j2;
            kotlin.jvm.internal.m.g(eRC20Approving, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(spenderAddress, "spenderAddress");
            kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(amount, "amount");
            kotlin.jvm.internal.m.g(approveAmount, "approveAmount");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            j2 = kotlin.a0.r.j(new ETHABIEncodedAddress(spenderAddress), new ETHABIEncodedUInt256(approveAmount));
            String asETHCallRequestData = String_EthereumKt.asETHCallRequestData("approve(address,uint256)", j2);
            final byte[] asHexEncodedData = asETHCallRequestData == null ? null : String_CoreKt.asHexEncodedData(asETHCallRequestData);
            if (asHexEncodedData == null) {
                h.c.b0<Optional<UnsignedTxResult>> error = h.c.b0.error(ERC20ContractException.UnableToApproveTransfer.INSTANCE);
                kotlin.jvm.internal.m.f(error, "error(ERC20ContractException.UnableToApproveTransfer)");
                return error;
            }
            final EthereumChain ethereumChain = EthereumChain.ETHEREUM_MAINNET;
            int chainId = ethereumChain.getChainId();
            h.c.b0<BigInteger> gasPrice = eRC20Approving.getGasPrice(chainId);
            BigInteger ZERO = BigInteger.ZERO;
            kotlin.jvm.internal.m.f(ZERO, "ZERO");
            h.c.b0<Optional<UnsignedTxResult>> flatMap = h.c.t0.e.a.b(gasPrice, eRC20Approving.getGasLimit(fromAddress, contractAddress, ZERO, asHexEncodedData, chainId), eRC20Approving.getErc20ContractAPI().getAllowance(fromAddress, spenderAddress, contractAddress, chainId)).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.b
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ERC20Approving.DefaultImpls.b(amount, eRC20Approving, fromAddress, contractAddress, asHexEncodedData, ethereumChain, currencyCode, metadata, (kotlin.t) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "Singles\n            .zip(gasPriceSingle, gasLimitSingle, allowanceSingle)\n            .flatMap { (gasPrice, gasEstimationStatus, balanceRemaining) ->\n                if (amount <= balanceRemaining) return@flatMap Singles.justNull<UnsignedTxResult>()\n\n                val txSingle = generateUnsignedEthereumTx(\n                    fromAddress = fromAddress,\n                    toAddress = contractAddress,\n                    weiValue = BigInteger.ZERO,\n                    gasPrice = gasPrice,\n                    gasLimit = gasEstimationStatus.gas.value,\n                    data = data,\n                    network = ethMainnet.asNetwork,\n                    nonce = null,\n                    currencyCode = currencyCode,\n                    blockchain = Blockchain.ETHEREUM,\n                    metadata = metadata\n                )\n\n                val txResultSingle = when (gasEstimationStatus) {\n                    is GasEstimationStatus.Success -> txSingle\n                    is GasEstimationStatus.Error -> {\n                        txSingle.map { result ->\n                            UnsignedTxResult.Error(\n                                tx = result.transaction,\n                                err = EthereumException.UnableToEstimateGas\n                            )\n                        }\n                    }\n                }\n\n                return@flatMap txResultSingle.map { it.toOptional() }\n            }");
            return flatMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: generateApproveTx$lambda-2 */
        public static h.c.h0 m1099generateApproveTx$lambda2(BigInteger amount, ERC20Approving this$0, String fromAddress, String contractAddress, byte[] data, EthereumChain ethMainnet, CurrencyCode currencyCode, Map metadata, kotlin.t dstr$gasPrice$gasEstimationStatus$balanceRemaining) {
            kotlin.jvm.internal.m.g(amount, "$amount");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(fromAddress, "$fromAddress");
            kotlin.jvm.internal.m.g(contractAddress, "$contractAddress");
            kotlin.jvm.internal.m.g(data, "$data");
            kotlin.jvm.internal.m.g(ethMainnet, "$ethMainnet");
            kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
            kotlin.jvm.internal.m.g(metadata, "$metadata");
            kotlin.jvm.internal.m.g(dstr$gasPrice$gasEstimationStatus$balanceRemaining, "$dstr$gasPrice$gasEstimationStatus$balanceRemaining");
            BigInteger bigInteger = (BigInteger) dstr$gasPrice$gasEstimationStatus$balanceRemaining.a();
            GasEstimationStatus gasEstimationStatus = (GasEstimationStatus) dstr$gasPrice$gasEstimationStatus$balanceRemaining.b();
            if (amount.compareTo((BigInteger) dstr$gasPrice$gasEstimationStatus$balanceRemaining.c()) <= 0) {
                h.c.t0.e eVar = h.c.t0.e.a;
                h.c.b0 just = h.c.b0.just(new Optional(null));
                kotlin.jvm.internal.m.f(just, "just(Optional(null))");
                return just;
            }
            BigInteger ZERO = BigInteger.ZERO;
            kotlin.jvm.internal.m.f(ZERO, "ZERO");
            h.c.b0 generateUnsignedEthereumTx = this$0.generateUnsignedEthereumTx(fromAddress, contractAddress, ZERO, bigInteger, gasEstimationStatus.getGas().getValue(), data, EthereumChain_EthereumKt.getAsNetwork(ethMainnet), null, currencyCode, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), metadata);
            h.c.b0 b0Var = generateUnsignedEthereumTx;
            if (!(gasEstimationStatus instanceof GasEstimationStatus.Success)) {
                if (gasEstimationStatus instanceof GasEstimationStatus.Error) {
                    h.c.b0 map = generateUnsignedEthereumTx.map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.a
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return ERC20Approving.DefaultImpls.a((UnsignedTxResult) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(map, "{\n                        txSingle.map { result ->\n                            UnsignedTxResult.Error(\n                                tx = result.transaction,\n                                err = EthereumException.UnableToEstimateGas\n                            )\n                        }\n                    }");
                    b0Var = map;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return b0Var.map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ERC20Approving.DefaultImpls.c((UnsignedTxResult) obj);
                }
            });
        }

        /* renamed from: generateApproveTx$lambda-2$lambda-0 */
        public static UnsignedTxResult.Error m1100generateApproveTx$lambda2$lambda0(UnsignedTxResult result) {
            kotlin.jvm.internal.m.g(result, "result");
            return new UnsignedTxResult.Error(result.getTransaction(), EthereumException.UnableToEstimateGas.INSTANCE);
        }

        /* renamed from: generateApproveTx$lambda-2$lambda-1 */
        public static Optional m1101generateApproveTx$lambda2$lambda1(UnsignedTxResult it) {
            kotlin.jvm.internal.m.g(it, "it");
            return OptionalKt.toOptional(it);
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(ERC20Approving eRC20Approving, String fromAddress, String str, BigInteger weiValue, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> metadata) {
            kotlin.jvm.internal.m.g(eRC20Approving, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "weiValue");
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(blockchain, "blockchain");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            return EthereumTxCreating.DefaultImpls.generateUnsignedEthereum1559Tx(eRC20Approving, fromAddress, str, weiValue, bigInteger, bigInteger2, bigInteger3, bigInteger4, bArr, network, num, currencyCode, blockchain, metadata);
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedEthereumTx(ERC20Approving eRC20Approving, String fromAddress, String str, BigInteger weiValue, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> metadata) {
            kotlin.jvm.internal.m.g(eRC20Approving, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "weiValue");
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(blockchain, "blockchain");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            return EthereumTxCreating.DefaultImpls.generateUnsignedEthereumTx(eRC20Approving, fromAddress, str, weiValue, bigInteger, bigInteger2, bArr, network, num, currencyCode, blockchain, metadata);
        }

        public static h.c.b0<AdjustableMinerFee1559Result> get1559GasPrice(ERC20Approving eRC20Approving, int i2) {
            kotlin.jvm.internal.m.g(eRC20Approving, "this");
            return EthereumTxCreating.DefaultImpls.get1559GasPrice(eRC20Approving, i2);
        }

        public static h.c.b0<GasEstimationStatus> getGasLimit(ERC20Approving eRC20Approving, String fromAddress, String str, BigInteger value, byte[] bArr, int i2) {
            kotlin.jvm.internal.m.g(eRC20Approving, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(value, "value");
            return EthereumTxCreating.DefaultImpls.getGasLimit(eRC20Approving, fromAddress, str, value, bArr, i2);
        }

        public static h.c.b0<BigInteger> getGasPrice(ERC20Approving eRC20Approving, int i2) {
            kotlin.jvm.internal.m.g(eRC20Approving, "this");
            return EthereumTxCreating.DefaultImpls.getGasPrice(eRC20Approving, i2);
        }
    }

    h.c.b0<Optional<UnsignedTxResult>> generateApproveTx(String str, String str2, String str3, CurrencyCode currencyCode, BigInteger bigInteger, BigInteger bigInteger2, Map<TxMetadataKey, ? extends Object> map);

    ERC20ContractAPI getErc20ContractAPI();
}