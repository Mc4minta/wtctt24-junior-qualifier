package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.ciphercore.ERC20TransferParams;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559Result;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.ERC20TxCreating;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.GasEstimationStatus;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ERC20TxCreating.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001Jm\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0085\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/ERC20TxCreating;", "Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxCreating;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "", SendConfirmationArgs.recipientAddressKey, "erc20ContractAddress", "Ljava/math/BigInteger;", "value", "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedERC20Tx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;Ljava/util/Map;)Lh/c/b0;", "maxFeePerGas", "baseFeePerGas", "maxPriorityFeePerGas", "generateUnsignedERC201559Tx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;Ljava/util/Map;)Lh/c/b0;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ERC20TxCreating extends EthereumTxCreating {

    /* compiled from: ERC20TxCreating.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ UnsignedTxResult a(Integer num, Wallet wallet, String str, String str2, BigInteger bigInteger, UnsignedTxResult unsignedTxResult) {
            return m1103generateUnsignedERC201559Tx$lambda3(num, wallet, str, str2, bigInteger, unsignedTxResult);
        }

        public static /* synthetic */ h.c.h0 b(ERC20TxCreating eRC20TxCreating, Wallet wallet, BigInteger bigInteger, BigInteger bigInteger2, Map map, ERC20TransferParams eRC20TransferParams) {
            return m1104generateUnsignedERC20Tx$lambda0(eRC20TxCreating, wallet, bigInteger, bigInteger2, map, eRC20TransferParams);
        }

        public static /* synthetic */ h.c.h0 c(Wallet wallet, ERC20TxCreating eRC20TxCreating, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, Map map, ERC20TransferParams eRC20TransferParams) {
            return m1102generateUnsignedERC201559Tx$lambda2(wallet, eRC20TxCreating, bigInteger, bigInteger2, bigInteger3, bigInteger4, num, map, eRC20TransferParams);
        }

        public static /* synthetic */ UnsignedTxResult d(Wallet wallet, String str, String str2, BigInteger bigInteger, UnsignedTxResult unsignedTxResult) {
            return m1105generateUnsignedERC20Tx$lambda1(wallet, str, str2, bigInteger, unsignedTxResult);
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedERC201559Tx(final ERC20TxCreating eRC20TxCreating, final Wallet wallet, final String recipientAddress, final String erc20ContractAddress, final BigInteger value, final BigInteger bigInteger, final BigInteger bigInteger2, final BigInteger bigInteger3, final BigInteger bigInteger4, final Integer num, final Map<TxMetadataKey, ? extends Object> metadata) {
            kotlin.jvm.internal.m.g(eRC20TxCreating, "this");
            kotlin.jvm.internal.m.g(wallet, "wallet");
            kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
            kotlin.jvm.internal.m.g(erc20ContractAddress, "erc20ContractAddress");
            kotlin.jvm.internal.m.g(value, "value");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            h.c.b0<UnsignedTxResult> map = eRC20TxCreating.getCipherCore().encodeERC20Transfer(recipientAddress, erc20ContractAddress, value).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.f
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ERC20TxCreating.DefaultImpls.c(Wallet.this, eRC20TxCreating, bigInteger, bigInteger3, bigInteger2, bigInteger4, num, metadata, (ERC20TransferParams) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ERC20TxCreating.DefaultImpls.a(num, wallet, erc20ContractAddress, recipientAddress, value, (UnsignedTxResult) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "cipherCore\n        .encodeERC20Transfer(\n            toAddress = recipientAddress,\n            contractAddress = erc20ContractAddress,\n            value = value\n        )\n        .flatMap { result ->\n            generateUnsignedEthereum1559Tx(\n                fromAddress = wallet.primaryAddress,\n                toAddress = result.toAddress,\n                weiValue = 0.toBigInteger(),\n                data = result.data,\n                maxFeePerGas = maxFeePerGas,\n                baseFeePerGas = baseFeePerGas,\n                gasLimit = gasLimit,\n                nonce = nonce,\n                maxPriorityFeePerGas = maxPriorityFeePerGas,\n                network = wallet.network,\n                currencyCode = wallet.currencyCode,\n                blockchain = wallet.blockchain,\n                metadata = metadata\n            )\n        }\n        .map { unsignedTxResult ->\n            when (unsignedTxResult) {\n                is UnsignedTxResult.Success -> {\n                    val ethereumUnsignedTx = unsignedTxResult.tx as? EthereumUnsigned1559Tx\n                        ?: throw EthereumException.UnableToFindSignedTx\n\n                    val erc20UnsignedTx = EthereumUnsigned1559Tx.createERC20Tx(\n                        fromAddress = ethereumUnsignedTx.fromAddress,\n                        contractAddress = erc20ContractAddress,\n                        recipientAddress = recipientAddress,\n                        nonce = nonce ?: ethereumUnsignedTx.nonce,\n                        erc20Value = value,\n                        data = ethereumUnsignedTx.data,\n                        maxFeePerGas = ethereumUnsignedTx.maxFeePerGas,\n                        baseFeePerGas = ethereumUnsignedTx.baseFeePerGas,\n                        maxPriorityFeePerGas = ethereumUnsignedTx.maxPriorityFeePerGas,\n                        gasLimit = ethereumUnsignedTx.gasLimit,\n                        network = ethereumUnsignedTx.network,\n                        currencyCode = ethereumUnsignedTx.currencyCode,\n                        feeCurrencyCode = EthereumBasedConfiguration.ETH.currencyCodeForNetwork(wallet.network),\n                        blockchain = ethereumUnsignedTx.blockchain,\n                        walletIndex = ethereumUnsignedTx.walletIndex\n                    )\n\n                    UnsignedTxResult.Success(erc20UnsignedTx)\n                }\n                is UnsignedTxResult.Error -> unsignedTxResult\n            }\n        }");
            return map;
        }

        public static /* synthetic */ h.c.b0 generateUnsignedERC201559Tx$default(ERC20TxCreating eRC20TxCreating, Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, Integer num, Map map, int i2, Object obj) {
            if (obj == null) {
                return eRC20TxCreating.generateUnsignedERC201559Tx(wallet, str, str2, bigInteger, (i2 & 16) != 0 ? null : bigInteger2, (i2 & 32) != 0 ? null : bigInteger3, (i2 & 64) != 0 ? null : bigInteger4, (i2 & 128) != 0 ? null : bigInteger5, (i2 & 256) != 0 ? null : num, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedERC201559Tx");
        }

        /* renamed from: generateUnsignedERC201559Tx$lambda-2 */
        public static h.c.h0 m1102generateUnsignedERC201559Tx$lambda2(Wallet wallet, ERC20TxCreating this$0, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, Map metadata, ERC20TransferParams result) {
            kotlin.jvm.internal.m.g(wallet, "$wallet");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(metadata, "$metadata");
            kotlin.jvm.internal.m.g(result, "result");
            String primaryAddress = wallet.getPrimaryAddress();
            String toAddress = result.getToAddress();
            BigInteger valueOf = BigInteger.valueOf(0);
            kotlin.jvm.internal.m.f(valueOf, "BigInteger.valueOf(this.toLong())");
            return this$0.generateUnsignedEthereum1559Tx(primaryAddress, toAddress, valueOf, bigInteger, bigInteger2, bigInteger3, bigInteger4, result.getData(), wallet.getNetwork(), num, wallet.getCurrencyCode(), wallet.getBlockchain(), metadata);
        }

        /* renamed from: generateUnsignedERC201559Tx$lambda-3 */
        public static UnsignedTxResult m1103generateUnsignedERC201559Tx$lambda3(Integer num, Wallet wallet, String erc20ContractAddress, String recipientAddress, BigInteger value, UnsignedTxResult unsignedTxResult) {
            kotlin.jvm.internal.m.g(wallet, "$wallet");
            kotlin.jvm.internal.m.g(erc20ContractAddress, "$erc20ContractAddress");
            kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
            kotlin.jvm.internal.m.g(value, "$value");
            kotlin.jvm.internal.m.g(unsignedTxResult, "unsignedTxResult");
            if (unsignedTxResult instanceof UnsignedTxResult.Success) {
                UnsignedTx tx = ((UnsignedTxResult.Success) unsignedTxResult).getTx();
                EthereumUnsigned1559Tx ethereumUnsigned1559Tx = tx instanceof EthereumUnsigned1559Tx ? (EthereumUnsigned1559Tx) tx : null;
                if (ethereumUnsigned1559Tx != null) {
                    return new UnsignedTxResult.Success(EthereumUnsigned1559Tx.Companion.createERC20Tx(ethereumUnsigned1559Tx.getFromAddress(), ethereumUnsigned1559Tx.getWalletIndex(), erc20ContractAddress, recipientAddress, num == null ? ethereumUnsigned1559Tx.getNonce() : num, value, ethereumUnsigned1559Tx.getData(), ethereumUnsigned1559Tx.getMaxFeePerGas(), ethereumUnsigned1559Tx.getBaseFeePerGas(), ethereumUnsigned1559Tx.getMaxPriorityFeePerGas(), ethereumUnsigned1559Tx.getGasLimit(), ethereumUnsigned1559Tx.getNetwork(), ethereumUnsigned1559Tx.getCurrencyCode(), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(wallet.getNetwork()), ethereumUnsigned1559Tx.getBlockchain()));
                }
                throw EthereumException.UnableToFindSignedTx.INSTANCE;
            } else if (unsignedTxResult instanceof UnsignedTxResult.Error) {
                return unsignedTxResult;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedERC20Tx(final ERC20TxCreating eRC20TxCreating, final Wallet wallet, final String recipientAddress, final String erc20ContractAddress, final BigInteger value, final BigInteger bigInteger, final BigInteger bigInteger2, Integer num, final Map<TxMetadataKey, ? extends Object> metadata) {
            kotlin.jvm.internal.m.g(eRC20TxCreating, "this");
            kotlin.jvm.internal.m.g(wallet, "wallet");
            kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
            kotlin.jvm.internal.m.g(erc20ContractAddress, "erc20ContractAddress");
            kotlin.jvm.internal.m.g(value, "value");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            h.c.b0<UnsignedTxResult> map = eRC20TxCreating.getCipherCore().encodeERC20Transfer(recipientAddress, erc20ContractAddress, value).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.e
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ERC20TxCreating.DefaultImpls.b(ERC20TxCreating.this, wallet, bigInteger, bigInteger2, metadata, (ERC20TransferParams) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ERC20TxCreating.DefaultImpls.d(Wallet.this, erc20ContractAddress, recipientAddress, value, (UnsignedTxResult) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "cipherCore\n        .encodeERC20Transfer(\n            toAddress = recipientAddress,\n            contractAddress = erc20ContractAddress,\n            value = value\n        )\n        .flatMap { result ->\n            generateUnsignedEthereumTx(\n                fromAddress = wallet.primaryAddress,\n                toAddress = result.toAddress,\n                weiValue = 0.toBigInteger(),\n                gasPrice = gasPrice,\n                gasLimit = gasLimit,\n                data = result.data,\n                network = wallet.network,\n                currencyCode = wallet.currencyCode,\n                blockchain = wallet.blockchain,\n                metadata = metadata\n            )\n        }\n        .map { unsignedTxResult ->\n            when (unsignedTxResult) {\n                is UnsignedTxResult.Success -> {\n                    val ethereumUnsignedTx = unsignedTxResult.tx as? EthereumUnsignedLegacyTx\n                        ?: throw EthereumException.UnableToFindSignedTx\n\n                    val erc20UnsignedTx = EthereumUnsignedLegacyTx.createERC20Tx(\n                        fromAddress = ethereumUnsignedTx.fromAddress,\n                        contractAddress = erc20ContractAddress,\n                        recipientAddress = recipientAddress,\n                        nonce = ethereumUnsignedTx.nonce,\n                        erc20Value = value,\n                        data = ethereumUnsignedTx.data,\n                        gasPrice = ethereumUnsignedTx.gasPrice,\n                        gasLimit = ethereumUnsignedTx.gasLimit,\n                        network = ethereumUnsignedTx.network,\n                        currencyCode = ethereumUnsignedTx.currencyCode,\n                        feeCurrencyCode = EthereumBasedConfiguration.ETH.currencyCodeForNetwork(wallet.network),\n                        blockchain = ethereumUnsignedTx.blockchain,\n                        walletIndex = ethereumUnsignedTx.walletIndex\n                    )\n\n                    UnsignedTxResult.Success(erc20UnsignedTx)\n                }\n                is UnsignedTxResult.Error -> unsignedTxResult\n            }\n        }");
            return map;
        }

        public static /* synthetic */ h.c.b0 generateUnsignedERC20Tx$default(ERC20TxCreating eRC20TxCreating, Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Integer num, Map map, int i2, Object obj) {
            if (obj == null) {
                return eRC20TxCreating.generateUnsignedERC20Tx(wallet, str, str2, bigInteger, (i2 & 16) != 0 ? null : bigInteger2, (i2 & 32) != 0 ? null : bigInteger3, (i2 & 64) != 0 ? null : num, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedERC20Tx");
        }

        /* renamed from: generateUnsignedERC20Tx$lambda-0 */
        public static h.c.h0 m1104generateUnsignedERC20Tx$lambda0(ERC20TxCreating this$0, Wallet wallet, BigInteger bigInteger, BigInteger bigInteger2, Map metadata, ERC20TransferParams result) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(wallet, "$wallet");
            kotlin.jvm.internal.m.g(metadata, "$metadata");
            kotlin.jvm.internal.m.g(result, "result");
            String primaryAddress = wallet.getPrimaryAddress();
            String toAddress = result.getToAddress();
            BigInteger valueOf = BigInteger.valueOf(0);
            kotlin.jvm.internal.m.f(valueOf, "BigInteger.valueOf(this.toLong())");
            return EthereumTxCreating.DefaultImpls.generateUnsignedEthereumTx$default(this$0, primaryAddress, toAddress, valueOf, bigInteger, bigInteger2, result.getData(), wallet.getNetwork(), null, wallet.getCurrencyCode(), wallet.getBlockchain(), metadata, 128, null);
        }

        /* renamed from: generateUnsignedERC20Tx$lambda-1 */
        public static UnsignedTxResult m1105generateUnsignedERC20Tx$lambda1(Wallet wallet, String erc20ContractAddress, String recipientAddress, BigInteger value, UnsignedTxResult unsignedTxResult) {
            kotlin.jvm.internal.m.g(wallet, "$wallet");
            kotlin.jvm.internal.m.g(erc20ContractAddress, "$erc20ContractAddress");
            kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
            kotlin.jvm.internal.m.g(value, "$value");
            kotlin.jvm.internal.m.g(unsignedTxResult, "unsignedTxResult");
            if (unsignedTxResult instanceof UnsignedTxResult.Success) {
                UnsignedTx tx = ((UnsignedTxResult.Success) unsignedTxResult).getTx();
                EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx = tx instanceof EthereumUnsignedLegacyTx ? (EthereumUnsignedLegacyTx) tx : null;
                if (ethereumUnsignedLegacyTx != null) {
                    return new UnsignedTxResult.Success(EthereumUnsignedLegacyTx.Companion.createERC20Tx(ethereumUnsignedLegacyTx.getFromAddress(), ethereumUnsignedLegacyTx.getWalletIndex(), erc20ContractAddress, recipientAddress, ethereumUnsignedLegacyTx.getNonce(), value, ethereumUnsignedLegacyTx.getData(), ethereumUnsignedLegacyTx.getGasPrice(), ethereumUnsignedLegacyTx.getGasLimit(), ethereumUnsignedLegacyTx.getNetwork(), ethereumUnsignedLegacyTx.getCurrencyCode(), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(wallet.getNetwork()), ethereumUnsignedLegacyTx.getBlockchain()));
                }
                throw EthereumException.UnableToFindSignedTx.INSTANCE;
            } else if (unsignedTxResult instanceof UnsignedTxResult.Error) {
                return unsignedTxResult;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(ERC20TxCreating eRC20TxCreating, String fromAddress, String str, BigInteger weiValue, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> metadata) {
            kotlin.jvm.internal.m.g(eRC20TxCreating, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "weiValue");
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(blockchain, "blockchain");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            return EthereumTxCreating.DefaultImpls.generateUnsignedEthereum1559Tx(eRC20TxCreating, fromAddress, str, weiValue, bigInteger, bigInteger2, bigInteger3, bigInteger4, bArr, network, num, currencyCode, blockchain, metadata);
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedEthereumTx(ERC20TxCreating eRC20TxCreating, String fromAddress, String str, BigInteger weiValue, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> metadata) {
            kotlin.jvm.internal.m.g(eRC20TxCreating, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "weiValue");
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(blockchain, "blockchain");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            return EthereumTxCreating.DefaultImpls.generateUnsignedEthereumTx(eRC20TxCreating, fromAddress, str, weiValue, bigInteger, bigInteger2, bArr, network, num, currencyCode, blockchain, metadata);
        }

        public static h.c.b0<AdjustableMinerFee1559Result> get1559GasPrice(ERC20TxCreating eRC20TxCreating, int i2) {
            kotlin.jvm.internal.m.g(eRC20TxCreating, "this");
            return EthereumTxCreating.DefaultImpls.get1559GasPrice(eRC20TxCreating, i2);
        }

        public static h.c.b0<GasEstimationStatus> getGasLimit(ERC20TxCreating eRC20TxCreating, String fromAddress, String str, BigInteger value, byte[] bArr, int i2) {
            kotlin.jvm.internal.m.g(eRC20TxCreating, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(value, "value");
            return EthereumTxCreating.DefaultImpls.getGasLimit(eRC20TxCreating, fromAddress, str, value, bArr, i2);
        }

        public static h.c.b0<BigInteger> getGasPrice(ERC20TxCreating eRC20TxCreating, int i2) {
            kotlin.jvm.internal.m.g(eRC20TxCreating, "this");
            return EthereumTxCreating.DefaultImpls.getGasPrice(eRC20TxCreating, i2);
        }
    }

    h.c.b0<UnsignedTxResult> generateUnsignedERC201559Tx(Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, Integer num, Map<TxMetadataKey, ? extends Object> map);

    h.c.b0<UnsignedTxResult> generateUnsignedERC20Tx(Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Integer num, Map<TxMetadataKey, ? extends Object> map);
}