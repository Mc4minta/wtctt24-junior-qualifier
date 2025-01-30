package com.coinbase.wallet.ethereum.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.AnalyticsEvent_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.exceptions.NetworkException;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559Result;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.ethereum.models.EthereumGas;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.GasEstimationStatus;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: EthereumTxCreating.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u008d\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u009b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJC\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010$\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00162\u0006\u0010$\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010&R\u0016\u0010,\u001a\u00020)8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxCreating;", "", "", "fromAddress", "toAddress", "Ljava/math/BigInteger;", "weiValue", "gasPrice", "gasLimit", "", "data", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", SendConfirmationArgs.metadataKey, "Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedEthereumTx", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;[BLcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/Integer;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/util/Map;)Lh/c/b0;", "maxFeePerGas", "maxPriorityFeePerGas", "baseFeePerGas", "generateUnsignedEthereum1559Tx", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;[BLcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/Integer;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/util/Map;)Lh/c/b0;", "value", "chainID", "Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus;", "getGasLimit", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BI)Lh/c/b0;", RouteActionKey.RouteActionKeys.CHAIN_ID, "getGasPrice", "(I)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "get1559GasPrice", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "getMinerFeeAPI", "()Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface EthereumTxCreating {

    /* compiled from: EthereumTxCreating.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ GasEstimationStatus a(int i2, BigInteger bigInteger) {
            return m1135getGasLimit$lambda8(i2, bigInteger);
        }

        public static /* synthetic */ kotlin.t b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, AdjustableMinerFee1559Result adjustableMinerFee1559Result) {
            return m1130generateUnsignedEthereum1559Tx$lambda4(bigInteger, bigInteger2, bigInteger3, adjustableMinerFee1559Result);
        }

        public static /* synthetic */ GasEstimationStatus c(int i2, Throwable th) {
            return m1136getGasLimit$lambda9(i2, th);
        }

        public static /* synthetic */ UnsignedTxResult d(Blockchain blockchain, Network network, String str, String str2, Integer num, BigInteger bigInteger, byte[] bArr, CurrencyCode currencyCode, Map map, kotlin.t tVar) {
            return m1134generateUnsignedEthereumTx$lambda3(blockchain, network, str, str2, num, bigInteger, bArr, currencyCode, map, tVar);
        }

        public static /* synthetic */ UnsignedTxResult e(Blockchain blockchain, Network network, String str, String str2, Integer num, BigInteger bigInteger, byte[] bArr, CurrencyCode currencyCode, Map map, kotlin.t tVar) {
            return m1132generateUnsignedEthereum1559Tx$lambda7(blockchain, network, str, str2, num, bigInteger, bArr, currencyCode, map, tVar);
        }

        public static /* synthetic */ Optional f(String str, List list) {
            return m1133generateUnsignedEthereumTx$lambda2(str, list);
        }

        public static /* synthetic */ Optional g(String str, List list) {
            return m1131generateUnsignedEthereum1559Tx$lambda6(str, list);
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(EthereumTxCreating ethereumTxCreating, final String fromAddress, final String str, final BigInteger weiValue, final BigInteger bigInteger, final BigInteger bigInteger2, final BigInteger bigInteger3, BigInteger bigInteger4, byte[] bArr, final Network network, final Integer num, final CurrencyCode currencyCode, final Blockchain blockchain, final Map<TxMetadataKey, ? extends Object> metadata) {
            h.c.b0<GasEstimationStatus> gasLimit;
            kotlin.jvm.internal.m.g(ethereumTxCreating, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "weiValue");
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(blockchain, "blockchain");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
            if (asEthereumChain == null) {
                h.c.b0<UnsignedTxResult> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
                return error;
            }
            byte[] bArr2 = bArr == null ? new byte[0] : bArr;
            int chainId = asEthereumChain.getChainId();
            h.c.h0 map = ethereumTxCreating.get1559GasPrice(chainId).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.g0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.b(bigInteger3, bigInteger, bigInteger2, (AdjustableMinerFee1559Result) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "get1559GasPrice(chainId).map { feeData ->\n            Triple(\n                baseFeePerGas ?: feeData.baseFee,\n                maxFeePerGas ?: feeData.normalMaxFeePerGas,\n                maxPriorityFeePerGas ?: feeData.normalPriorityFee\n            )\n        }");
            if (bigInteger4 != null) {
                gasLimit = h.c.b0.just(new GasEstimationStatus.Success(new EthereumGas(bigInteger4)));
                kotlin.jvm.internal.m.f(gasLimit, "{\n            Single.just(GasEstimationStatus.Success(EthereumGas(gasLimit)))\n        }");
            } else {
                gasLimit = ethereumTxCreating.getGasLimit(fromAddress, str, weiValue, bArr2, chainId);
            }
            h.c.h0 map2 = ethereumTxCreating.getAddressDao().getOrderedAddresses(blockchain, currencyCode, network).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.l0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.g(fromAddress, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(map2, "addressDao.getOrderedAddresses(blockchain, currencyCode, network)\n            .map { addresses ->\n                val locale = Locale.US\n                val index = addresses\n                    .firstOrNull { it.address.toLowerCase(locale) == fromAddress.toLowerCase(locale) }\n                    ?.index\n\n                index.toOptional()\n            }");
            final byte[] bArr3 = bArr2;
            h.c.b0 map3 = h.c.t0.e.a.b(map, gasLimit, map2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.j0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.e(Blockchain.this, network, fromAddress, str, num, weiValue, bArr3, currencyCode, metadata, (kotlin.t) obj);
                }
            });
            kotlin.jvm.internal.m.f(map3, "Singles.zip(gasPriceSingle, gasLimitSingle, walletIndexSingle)\n            // Generate the unsigned transaction with fetched details\n            .map { (gasPriceSingle, gasEstimationStatus, walletIndexOptional) ->\n                val (baseFeePerGas, maxFeePerGas, maxPriorityFeePerGas) = gasPriceSingle\n                val walletIndex = walletIndexOptional.value ?: throw EthereumException.UnableToFindWallet\n                val feeCurrencyCode = when (blockchain) {\n                    Blockchain.ETHEREUM -> EthereumBasedConfiguration.ETH.currencyCodeForNetwork(network)\n                    Blockchain.ETHEREUM_CLASSIC -> CurrencyCode.ETC\n                    else -> throw EthereumException.InvalidConfiguration\n                }\n\n                val tx = EthereumUnsigned1559Tx.createEtherTx(\n                    fromAddress = fromAddress,\n                    toAddress = toAddress,\n                    nonce = nonce,\n                    weiValue = weiValue,\n                    data = data,\n                    maxFeePerGas = maxFeePerGas,\n                    baseFeePerGas = baseFeePerGas,\n                    maxPriorityFeePerGas = maxPriorityFeePerGas,\n                    gasLimit = gasEstimationStatus.gas.value,\n                    network = network,\n                    currencyCode = currencyCode,\n                    feeCurrencyCode = feeCurrencyCode,\n                    blockchain = blockchain,\n                    walletIndex = walletIndex,\n                    metadata = metadata\n                )\n\n                when (gasEstimationStatus) {\n                    is GasEstimationStatus.Success -> {\n                        UnsignedTxResult.Success(tx)\n                    }\n                    is GasEstimationStatus.Error -> {\n                        UnsignedTxResult.Error(tx, EthereumException.UnableToEstimateGas)\n                    }\n                }\n            }");
            return Single_AnalyticsKt.logError$default(map3, null, null, 3, null);
        }

        public static /* synthetic */ h.c.b0 generateUnsignedEthereum1559Tx$default(EthereumTxCreating ethereumTxCreating, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map map, int i2, Object obj) {
            if (obj == null) {
                return ethereumTxCreating.generateUnsignedEthereum1559Tx(str, str2, bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, (i2 & 128) != 0 ? null : bArr, network, (i2 & 512) != 0 ? null : num, currencyCode, blockchain, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedEthereum1559Tx");
        }

        /* renamed from: generateUnsignedEthereum1559Tx$lambda-4 */
        public static kotlin.t m1130generateUnsignedEthereum1559Tx$lambda4(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, AdjustableMinerFee1559Result feeData) {
            kotlin.jvm.internal.m.g(feeData, "feeData");
            if (bigInteger == null) {
                bigInteger = feeData.getBaseFee();
            }
            if (bigInteger2 == null) {
                bigInteger2 = feeData.getNormalMaxFeePerGas();
            }
            if (bigInteger3 == null) {
                bigInteger3 = feeData.getNormalPriorityFee();
            }
            return new kotlin.t(bigInteger, bigInteger2, bigInteger3);
        }

        /* renamed from: generateUnsignedEthereum1559Tx$lambda-6 */
        public static Optional m1131generateUnsignedEthereum1559Tx$lambda6(String fromAddress, List addresses) {
            Object obj;
            kotlin.jvm.internal.m.g(fromAddress, "$fromAddress");
            kotlin.jvm.internal.m.g(addresses, "addresses");
            Locale locale = Locale.US;
            Iterator it = addresses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String address = ((Address) obj).getAddress();
                kotlin.jvm.internal.m.f(locale, "locale");
                Objects.requireNonNull(address, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = address.toLowerCase(locale);
                kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String lowerCase2 = fromAddress.toLowerCase(locale);
                kotlin.jvm.internal.m.f(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                if (kotlin.jvm.internal.m.c(lowerCase, lowerCase2)) {
                    break;
                }
            }
            Address address2 = (Address) obj;
            return OptionalKt.toOptional(address2 != null ? Integer.valueOf(address2.getIndex()) : null);
        }

        /* renamed from: generateUnsignedEthereum1559Tx$lambda-7 */
        public static UnsignedTxResult m1132generateUnsignedEthereum1559Tx$lambda7(Blockchain blockchain, Network network, String fromAddress, String str, Integer num, BigInteger weiValue, byte[] data, CurrencyCode currencyCode, Map metadata, kotlin.t dstr$gasPriceSingle$gasEstimationStatus$walletIndexOptional) {
            CurrencyCode etc;
            kotlin.jvm.internal.m.g(blockchain, "$blockchain");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(fromAddress, "$fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "$weiValue");
            kotlin.jvm.internal.m.g(data, "$data");
            kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
            kotlin.jvm.internal.m.g(metadata, "$metadata");
            kotlin.jvm.internal.m.g(dstr$gasPriceSingle$gasEstimationStatus$walletIndexOptional, "$dstr$gasPriceSingle$gasEstimationStatus$walletIndexOptional");
            kotlin.t tVar = (kotlin.t) dstr$gasPriceSingle$gasEstimationStatus$walletIndexOptional.a();
            GasEstimationStatus gasEstimationStatus = (GasEstimationStatus) dstr$gasPriceSingle$gasEstimationStatus$walletIndexOptional.b();
            BigInteger bigInteger = (BigInteger) tVar.a();
            BigInteger bigInteger2 = (BigInteger) tVar.b();
            BigInteger bigInteger3 = (BigInteger) tVar.c();
            Integer num2 = (Integer) ((Optional) dstr$gasPriceSingle$gasEstimationStatus$walletIndexOptional.c()).getValue();
            if (num2 != null) {
                int intValue = num2.intValue();
                Blockchain.Companion companion = Blockchain.Companion;
                if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion))) {
                    etc = WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(network);
                } else if (!kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion))) {
                    throw EthereumException.InvalidConfiguration.INSTANCE;
                } else {
                    etc = CurrencyCode_EthereumKt.getETC(CurrencyCode.Companion);
                }
                CurrencyCode currencyCode2 = etc;
                EthereumUnsigned1559Tx createEtherTx = EthereumUnsigned1559Tx.Companion.createEtherTx(fromAddress, intValue, str, num, weiValue, data, bigInteger2, bigInteger, bigInteger3, gasEstimationStatus.getGas().getValue(), network, currencyCode, currencyCode2, blockchain, metadata);
                if (gasEstimationStatus instanceof GasEstimationStatus.Success) {
                    return new UnsignedTxResult.Success(createEtherTx);
                }
                if (gasEstimationStatus instanceof GasEstimationStatus.Error) {
                    return new UnsignedTxResult.Error(createEtherTx, EthereumException.UnableToEstimateGas.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            throw EthereumException.UnableToFindWallet.INSTANCE;
        }

        public static h.c.b0<UnsignedTxResult> generateUnsignedEthereumTx(EthereumTxCreating ethereumTxCreating, final String fromAddress, final String str, final BigInteger weiValue, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, final Network network, final Integer num, final CurrencyCode currencyCode, final Blockchain blockchain, final Map<TxMetadataKey, ? extends Object> metadata) {
            h.c.b0<GasEstimationStatus> gasLimit;
            kotlin.jvm.internal.m.g(ethereumTxCreating, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "weiValue");
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
            kotlin.jvm.internal.m.g(blockchain, "blockchain");
            kotlin.jvm.internal.m.g(metadata, "metadata");
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
            if (asEthereumChain == null) {
                h.c.b0<UnsignedTxResult> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
                return error;
            }
            byte[] bArr2 = bArr == null ? new byte[0] : bArr;
            int chainId = asEthereumChain.getChainId();
            h.c.b0<BigInteger> just = bigInteger == null ? null : h.c.b0.just(bigInteger);
            if (just == null) {
                just = ethereumTxCreating.getGasPrice(chainId);
            }
            h.c.b0<BigInteger> b0Var = just;
            if (bigInteger2 != null) {
                gasLimit = h.c.b0.just(new GasEstimationStatus.Success(new EthereumGas(bigInteger2)));
                kotlin.jvm.internal.m.f(gasLimit, "{\n            Single.just(GasEstimationStatus.Success(EthereumGas(gasLimit)))\n        }");
            } else {
                gasLimit = ethereumTxCreating.getGasLimit(fromAddress, str, weiValue, bArr2, chainId);
            }
            h.c.h0 map = ethereumTxCreating.getAddressDao().getOrderedAddresses(blockchain, currencyCode, network).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.k0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.f(fromAddress, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "addressDao.getOrderedAddresses(blockchain, currencyCode, network)\n            .map { addresses ->\n                val locale = Locale.US\n                val index = addresses\n                    .firstOrNull { it.address.toLowerCase(locale) == fromAddress.toLowerCase(locale) }\n                    ?.index\n\n                index.toOptional()\n            }");
            final byte[] bArr3 = bArr2;
            h.c.b0 map2 = h.c.t0.e.a.b(b0Var, gasLimit, map).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.i0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.d(Blockchain.this, network, fromAddress, str, num, weiValue, bArr3, currencyCode, metadata, (kotlin.t) obj);
                }
            });
            kotlin.jvm.internal.m.f(map2, "Singles.zip(gasPriceSingle, gasLimitSingle, walletIndexSingle)\n            // Generate the unsigned transaction with fetched details\n            .map { (gasPrice, gasEstimationStatus, walletIndexOptional) ->\n                val walletIndex = walletIndexOptional.value ?: throw EthereumException.UnableToFindWallet\n                val feeCurrencyCode = when (blockchain) {\n                    Blockchain.ETHEREUM -> EthereumBasedConfiguration.ETH.currencyCodeForNetwork(network)\n                    Blockchain.ETHEREUM_CLASSIC -> CurrencyCode.ETC\n                    else -> throw EthereumException.InvalidConfiguration\n                }\n\n                val tx = EthereumUnsignedLegacyTx.createEtherTx(\n                    fromAddress = fromAddress,\n                    toAddress = toAddress,\n                    nonce = nonce,\n                    weiValue = weiValue,\n                    data = data,\n                    gasPrice = gasPrice,\n                    gasLimit = gasEstimationStatus.gas.value,\n                    network = network,\n                    currencyCode = currencyCode,\n                    feeCurrencyCode = feeCurrencyCode,\n                    blockchain = blockchain,\n                    walletIndex = walletIndex,\n                    metadata = metadata\n                )\n\n                when (gasEstimationStatus) {\n                    is GasEstimationStatus.Success -> {\n                        UnsignedTxResult.Success(tx)\n                    }\n                    is GasEstimationStatus.Error -> {\n                        UnsignedTxResult.Error(tx, EthereumException.UnableToEstimateGas)\n                    }\n                }\n            }");
            return Single_AnalyticsKt.logError$default(map2, null, null, 3, null);
        }

        public static /* synthetic */ h.c.b0 generateUnsignedEthereumTx$default(EthereumTxCreating ethereumTxCreating, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map map, int i2, Object obj) {
            if (obj == null) {
                return ethereumTxCreating.generateUnsignedEthereumTx(str, (i2 & 2) != 0 ? null : str2, bigInteger, (i2 & 8) != 0 ? null : bigInteger2, (i2 & 16) != 0 ? null : bigInteger3, (i2 & 32) != 0 ? null : bArr, network, (i2 & 128) != 0 ? null : num, currencyCode, blockchain, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedEthereumTx");
        }

        /* renamed from: generateUnsignedEthereumTx$lambda-2 */
        public static Optional m1133generateUnsignedEthereumTx$lambda2(String fromAddress, List addresses) {
            Object obj;
            kotlin.jvm.internal.m.g(fromAddress, "$fromAddress");
            kotlin.jvm.internal.m.g(addresses, "addresses");
            Locale locale = Locale.US;
            Iterator it = addresses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String address = ((Address) obj).getAddress();
                kotlin.jvm.internal.m.f(locale, "locale");
                Objects.requireNonNull(address, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = address.toLowerCase(locale);
                kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String lowerCase2 = fromAddress.toLowerCase(locale);
                kotlin.jvm.internal.m.f(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                if (kotlin.jvm.internal.m.c(lowerCase, lowerCase2)) {
                    break;
                }
            }
            Address address2 = (Address) obj;
            return OptionalKt.toOptional(address2 != null ? Integer.valueOf(address2.getIndex()) : null);
        }

        /* renamed from: generateUnsignedEthereumTx$lambda-3 */
        public static UnsignedTxResult m1134generateUnsignedEthereumTx$lambda3(Blockchain blockchain, Network network, String fromAddress, String str, Integer num, BigInteger weiValue, byte[] data, CurrencyCode currencyCode, Map metadata, kotlin.t dstr$gasPrice$gasEstimationStatus$walletIndexOptional) {
            CurrencyCode etc;
            kotlin.jvm.internal.m.g(blockchain, "$blockchain");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(fromAddress, "$fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "$weiValue");
            kotlin.jvm.internal.m.g(data, "$data");
            kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
            kotlin.jvm.internal.m.g(metadata, "$metadata");
            kotlin.jvm.internal.m.g(dstr$gasPrice$gasEstimationStatus$walletIndexOptional, "$dstr$gasPrice$gasEstimationStatus$walletIndexOptional");
            BigInteger gasPrice = (BigInteger) dstr$gasPrice$gasEstimationStatus$walletIndexOptional.a();
            GasEstimationStatus gasEstimationStatus = (GasEstimationStatus) dstr$gasPrice$gasEstimationStatus$walletIndexOptional.b();
            Integer num2 = (Integer) ((Optional) dstr$gasPrice$gasEstimationStatus$walletIndexOptional.c()).getValue();
            if (num2 != null) {
                int intValue = num2.intValue();
                Blockchain.Companion companion = Blockchain.Companion;
                if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion))) {
                    etc = WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(network);
                } else if (!kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion))) {
                    throw EthereumException.InvalidConfiguration.INSTANCE;
                } else {
                    etc = CurrencyCode_EthereumKt.getETC(CurrencyCode.Companion);
                }
                CurrencyCode currencyCode2 = etc;
                BigInteger value = gasEstimationStatus.getGas().getValue();
                EthereumUnsignedLegacyTx.Companion companion2 = EthereumUnsignedLegacyTx.Companion;
                kotlin.jvm.internal.m.f(gasPrice, "gasPrice");
                EthereumUnsignedLegacyTx createEtherTx = companion2.createEtherTx(fromAddress, intValue, str, num, weiValue, data, gasPrice, value, network, currencyCode, currencyCode2, blockchain, metadata);
                if (gasEstimationStatus instanceof GasEstimationStatus.Success) {
                    return new UnsignedTxResult.Success(createEtherTx);
                }
                if (gasEstimationStatus instanceof GasEstimationStatus.Error) {
                    return new UnsignedTxResult.Error(createEtherTx, EthereumException.UnableToEstimateGas.INSTANCE);
                }
                throw new NoWhenBranchMatchedException();
            }
            throw EthereumException.UnableToFindWallet.INSTANCE;
        }

        public static h.c.b0<AdjustableMinerFee1559Result> get1559GasPrice(EthereumTxCreating ethereumTxCreating, int i2) {
            kotlin.jvm.internal.m.g(ethereumTxCreating, "this");
            return ethereumTxCreating.getMinerFeeAPI().get1559MinerFeeEstimates(i2);
        }

        public static h.c.b0<GasEstimationStatus> getGasLimit(EthereumTxCreating ethereumTxCreating, String fromAddress, String str, BigInteger value, byte[] bArr, final int i2) {
            kotlin.jvm.internal.m.g(ethereumTxCreating, "this");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(value, "value");
            CipherCoreInterface cipherCore = ethereumTxCreating.getCipherCore();
            if (bArr == null) {
                bArr = new byte[0];
            }
            h.c.b0<GasEstimationStatus> onErrorReturn = cipherCore.estimateEthereumGasUsage(fromAddress, str, value, bArr, i2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.f0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.a(i2, (BigInteger) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.h0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.c(i2, (Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "cipherCore\n        .estimateEthereumGasUsage(\n            fromAddress = fromAddress,\n            toAddress = toAddress,\n            weiValue = value,\n            data = data ?: ByteArray(0),\n            chainId = chainID\n        )\n        .map { valueEstimate ->\n            val gasLimit = EthereumGas(valueEstimate)\n            val overEstimate = gasLimit.overEstimated\n            val isNotOptimismChain = chainID != EthereumChain.OPTIMISM_KOVAN.chainId &&\n                chainID != EthereumChain.OPTIMISM_MAINNET.chainId\n\n            when {\n                isNotOptimismChain -> GasEstimationStatus.Success(overEstimate)\n                overEstimate.value < EthereumGas.optimismTxGasLimit -> GasEstimationStatus.Success(overEstimate)\n                // TODO: Brendan display more useful error message when gasLimit is greater than\n                // optimismTransactionGasLimit\n                else -> {\n                    // if gasLimit exceeds max, the L2 RPC node will return an error and we'll display generic miner fee\n                    // error\n                    if (gasLimit.value > EthereumGas.optimismTxGasLimit) {\n                        Analytics.log(AnalyticsEvent.generalError(description = \"Optimism tx gas limit exceeded\"))\n                    }\n                    GasEstimationStatus.Success(gasLimit)\n                }\n            } as GasEstimationStatus\n        }\n        .onErrorReturn { GasEstimationStatus.Error(EthereumGas.defaultGasLimit(chainID)) }");
            return onErrorReturn;
        }

        public static /* synthetic */ h.c.b0 getGasLimit$default(EthereumTxCreating ethereumTxCreating, String str, String str2, BigInteger bigInteger, byte[] bArr, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bigInteger = BigInteger.valueOf(0);
                    kotlin.jvm.internal.m.f(bigInteger, "BigInteger.valueOf(this.toLong())");
                }
                return ethereumTxCreating.getGasLimit(str, str2, bigInteger, bArr, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGasLimit");
        }

        /* renamed from: getGasLimit$lambda-8 */
        public static GasEstimationStatus m1135getGasLimit$lambda8(int i2, BigInteger valueEstimate) {
            kotlin.jvm.internal.m.g(valueEstimate, "valueEstimate");
            EthereumGas ethereumGas = new EthereumGas(valueEstimate);
            EthereumGas overEstimated = ethereumGas.getOverEstimated();
            if ((i2 == EthereumChain.OPTIMISM_KOVAN.getChainId() || i2 == EthereumChain.OPTIMISM_MAINNET.getChainId()) ? false : true) {
                return new GasEstimationStatus.Success(overEstimated);
            }
            BigInteger value = overEstimated.getValue();
            EthereumGas.Companion companion = EthereumGas.Companion;
            if (value.compareTo(companion.getOptimismTxGasLimit()) < 0) {
                return new GasEstimationStatus.Success(overEstimated);
            }
            if (ethereumGas.getValue().compareTo(companion.getOptimismTxGasLimit()) > 0) {
                Analytics.INSTANCE.log(AnalyticsEvent_AnalyticsKt.generalError$default(AnalyticsEvent.Companion, "Optimism tx gas limit exceeded", null, 2, null));
            }
            return new GasEstimationStatus.Success(ethereumGas);
        }

        /* renamed from: getGasLimit$lambda-9 */
        public static GasEstimationStatus m1136getGasLimit$lambda9(int i2, Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            return new GasEstimationStatus.Error(EthereumGas.Companion.defaultGasLimit(i2));
        }

        public static h.c.b0<BigInteger> getGasPrice(EthereumTxCreating ethereumTxCreating, int i2) {
            kotlin.jvm.internal.m.g(ethereumTxCreating, "this");
            h.c.b0 map = ethereumTxCreating.getCipherCore().getEthereumGasPrices(i2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.m0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxCreating.DefaultImpls.h((List) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "cipherCore.getEthereumGasPrices(chainId)\n        .map { gasPrices ->\n            if (gasPrices.isEmpty()) {\n                throw EthereumException.UnableToFindGasPrice\n            }\n\n            val middleIndex = (gasPrices.size - 1) / 2\n\n            gasPrices[middleIndex]\n        }");
            return map;
        }

        /* renamed from: getGasPrice$lambda-10 */
        public static BigInteger m1137getGasPrice$lambda10(List gasPrices) {
            kotlin.jvm.internal.m.g(gasPrices, "gasPrices");
            if (!gasPrices.isEmpty()) {
                return (BigInteger) gasPrices.get((gasPrices.size() - 1) / 2);
            }
            throw EthereumException.UnableToFindGasPrice.INSTANCE;
        }

        public static /* synthetic */ BigInteger h(List list) {
            return m1137getGasPrice$lambda10(list);
        }
    }

    h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map);

    h.c.b0<UnsignedTxResult> generateUnsignedEthereumTx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map);

    h.c.b0<AdjustableMinerFee1559Result> get1559GasPrice(int i2);

    AddressDao getAddressDao();

    CipherCoreInterface getCipherCore();

    h.c.b0<GasEstimationStatus> getGasLimit(String str, String str2, BigInteger bigInteger, byte[] bArr, int i2);

    h.c.b0<BigInteger> getGasPrice(int i2);

    MinerFeeAPI getMinerFeeAPI();
}