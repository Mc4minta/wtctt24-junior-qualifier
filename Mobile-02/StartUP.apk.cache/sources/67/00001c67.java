package com.coinbase.wallet.ethereum.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IETHTxRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u008d\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H&¢\u0006\u0004\b\u0019\u0010\u001aJ¥\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H&¢\u0006\u0004\b\u001e\u0010\u001fJs\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u001e\u0010%J/\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00172\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020)H&¢\u0006\u0004\b,\u0010-J/\u0010/\u001a\b\u0012\u0004\u0012\u00020+0\u00172\u0006\u0010'\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020)H&¢\u0006\u0004\b/\u00100J1\u00104\u001a\b\u0012\u0004\u0012\u00020+0\u00172\u0006\u0010'\u001a\u00020+2\n\b\u0002\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020)H&¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "", "fromAddress", "toAddress", "Ljava/math/BigInteger;", "weiValue", "gasPrice", "gasLimit", "", "data", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedEthereumTx", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;[BLcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/Integer;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/util/Map;)Lh/c/b0;", "maxFeePerGas", "maxPriorityFeePerGas", "baseFeePerGas", "generateUnsignedEthereum1559Tx", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;[BLcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/Integer;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/util/Map;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;", "tx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "", "skipNonceCheck", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "signTx", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;Ljava/lang/String;Z)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "sign1559Tx", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;Ljava/lang/String;Z)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", "shouldResubmit", "submitTx", "(Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Z)Lh/c/b0;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface IETHTxRepository extends TxManaging {

    /* compiled from: IETHTxRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ h.c.b0 generateUnsignedEthereum1559Tx$default(IETHTxRepository iETHTxRepository, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map map, int i2, Object obj) {
            if (obj == null) {
                return iETHTxRepository.generateUnsignedEthereum1559Tx(str, (i2 & 2) != 0 ? null : str2, bigInteger, (i2 & 8) != 0 ? null : bigInteger2, (i2 & 16) != 0 ? null : bigInteger3, (i2 & 32) != 0 ? null : bigInteger4, (i2 & 64) != 0 ? null : bigInteger5, (i2 & 128) != 0 ? null : bArr, network, (i2 & 512) != 0 ? null : num, currencyCode, blockchain, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedEthereum1559Tx");
        }

        public static /* synthetic */ h.c.b0 generateUnsignedEthereumTx$default(IETHTxRepository iETHTxRepository, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map map, int i2, Object obj) {
            if (obj == null) {
                return iETHTxRepository.generateUnsignedEthereumTx(str, (i2 & 2) != 0 ? null : str2, bigInteger, (i2 & 8) != 0 ? null : bigInteger2, (i2 & 16) != 0 ? null : bigInteger3, (i2 & 32) != 0 ? null : bArr, network, (i2 & 128) != 0 ? null : num, currencyCode, blockchain, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedEthereumTx");
        }

        public static /* synthetic */ h.c.b0 sign1559Tx$default(IETHTxRepository iETHTxRepository, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, String str, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = false;
                }
                return iETHTxRepository.sign1559Tx(ethereumUnsigned1559Tx, str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sign1559Tx");
        }

        public static /* synthetic */ h.c.b0 signTx$default(IETHTxRepository iETHTxRepository, EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, String str, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = false;
                }
                return iETHTxRepository.signTx(ethereumUnsignedLegacyTx, str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signTx");
        }

        public static /* synthetic */ h.c.b0 submitTx$default(IETHTxRepository iETHTxRepository, EthereumSignedTx ethereumSignedTx, UnsignedTx unsignedTx, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    unsignedTx = null;
                }
                return iETHTxRepository.submitTx(ethereumSignedTx, unsignedTx, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitTx");
        }
    }

    h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(Wallet wallet, TransferValue transferValue, String str, Map<TxMetadataKey, ? extends Object> map, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num);

    h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map);

    h.c.b0<UnsignedTxResult> generateUnsignedEthereumTx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map);

    h.c.b0<EthereumSignedTx> sign1559Tx(EthereumUnsigned1559Tx ethereumUnsigned1559Tx, String str, boolean z);

    h.c.b0<EthereumSignedTx> signTx(EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, String str, boolean z);

    h.c.b0<EthereumSignedTx> submitTx(EthereumSignedTx ethereumSignedTx, UnsignedTx unsignedTx, boolean z);
}