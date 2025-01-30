package com.coinbase.ciphercore;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;

/* compiled from: CipherCoreInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u000fJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u000fJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0004\b\u001d\u0010\u001bJ1\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H&¢\u0006\u0004\b\"\u0010#J9\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H&¢\u0006\u0004\b%\u0010&J?\u0010+\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b+\u0010,J%\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00052\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b.\u0010/JW\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b5\u00106J_\u00109\u001a\b\u0012\u0004\u0012\u0002040\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001e2\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b9\u0010:JW\u0010;\u001a\b\u0012\u0004\u0012\u0002040\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b;\u00106J/\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010<\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\b\b\u0002\u0010=\u001a\u00020\u001cH&¢\u0006\u0004\b>\u0010?J/\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010<\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\b\b\u0002\u0010=\u001a\u00020\u001cH&¢\u0006\u0004\bA\u0010?J\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010*\u001a\u00020\tH&¢\u0006\u0004\bB\u0010\u0018J1\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H&¢\u0006\u0004\bC\u0010#J\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\bD\u0010EJ#\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\bF\u0010EJ3\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\u00052\u0006\u0010G\u001a\u00020\u00032\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\bJ\u0010KJ\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u00052\u0006\u0010L\u001a\u00020\tH&¢\u0006\u0004\bN\u0010\u0018J%\u0010O\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010L\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\bO\u0010PJ7\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0R0\u00052\u0006\u0010Q\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H&¢\u0006\u0004\bT\u0010UJ-\u0010X\u001a\b\u0012\u0004\u0012\u00020W0\u00052\u0006\u0010(\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010V\u001a\u00020 H&¢\u0006\u0004\bX\u0010Y¨\u0006Z"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreInterface;", "", "", "", "wordList", "Lh/c/b0;", "generateRecoveryPhrase", "(Ljava/util/List;)Lh/c/b0;", "recoveryPhrase", "", "seedFromRecoveryPhrase", "(Ljava/lang/String;Ljava/util/List;)Lh/c/b0;", "seed", "derivationPath", "xpubKeyFromSeed", "([BLjava/lang/String;)Lh/c/b0;", "Lcom/coinbase/ciphercore/KeyPair;", "deriveKeyPair", "deriveEd25519KeyPair", "xpubKey", "derivePublicKeyFromXpubKey", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "publicKey", "ethereumAddressFromPublicKey", "([B)Lh/c/b0;", "address", "checksumEthereumAddress", "(Ljava/lang/String;)Lh/c/b0;", "", "isValidEthereumAddress", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Ljava/math/BigInteger;", "blockHeight", "getWeiBalance", "(Ljava/lang/String;ILjava/math/BigInteger;)Lh/c/b0;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "getERC20Balance", "(Ljava/lang/String;Ljava/lang/String;ILjava/math/BigInteger;)Lh/c/b0;", "fromAddress", "toAddress", "weiValue", "data", "estimateEthereumGasUsage", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BI)Lh/c/b0;", "Lcom/coinbase/ciphercore/ERC20Info;", "getERC20Info", "(Ljava/lang/String;I)Lh/c/b0;", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "gasLimit", "privateKey", "Lcom/coinbase/ciphercore/SignedEthereumTransaction;", "sign2930Transaction", "(Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;[BI)Lh/c/b0;", "maxFeePerGas", "maxPriorityFeePerGas", "signEthereum1559Transaction", "(Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;[BI)Lh/c/b0;", "signEthereumTransaction", ApiConstants.MESSAGE, "addPrefix", "signEthereumMessage", "([B[BZ)Lh/c/b0;", "signature", "ethereumAddressFromSignedMessage", "keccak256Hash", "getConfirmedEthereumTransactionCount", "getEthereumBlockHeight", "(I)Lh/c/b0;", "getEthereumGasPrices", "method", "params", "Lcom/coinbase/ciphercore/EthereumJSONRPCRequestResult;", "makeEthereumJSONRPCRequest", "(Ljava/lang/String;Ljava/util/List;I)Lh/c/b0;", "signedTransaction", "Lcom/coinbase/ciphercore/ParsedEthereumTransaction;", "parseSignedEthereumTransaction", "submitSignedEthereumTransaction", "([BI)Lh/c/b0;", "transactionHash", "Lcom/coinbase/ciphercore/Optional;", "Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "getEthereumTransactionReceipt", "([BILjava/math/BigInteger;)Lh/c/b0;", "value", "Lcom/coinbase/ciphercore/ERC20TransferParams;", "encodeERC20Transfer", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;)Lh/c/b0;", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface CipherCoreInterface {

    /* compiled from: CipherCoreInterface.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ b0 ethereumAddressFromSignedMessage$default(CipherCoreInterface cipherCoreInterface, byte[] bArr, byte[] bArr2, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = true;
                }
                return cipherCoreInterface.ethereumAddressFromSignedMessage(bArr, bArr2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ethereumAddressFromSignedMessage");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b0 generateRecoveryPhrase$default(CipherCoreInterface cipherCoreInterface, List list, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    list = null;
                }
                return cipherCoreInterface.generateRecoveryPhrase(list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateRecoveryPhrase");
        }

        public static /* synthetic */ b0 getConfirmedEthereumTransactionCount$default(CipherCoreInterface cipherCoreInterface, String str, int i2, BigInteger bigInteger, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bigInteger = null;
                }
                return cipherCoreInterface.getConfirmedEthereumTransactionCount(str, i2, bigInteger);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfirmedEthereumTransactionCount");
        }

        public static /* synthetic */ b0 getERC20Balance$default(CipherCoreInterface cipherCoreInterface, String str, String str2, int i2, BigInteger bigInteger, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    bigInteger = null;
                }
                return cipherCoreInterface.getERC20Balance(str, str2, i2, bigInteger);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getERC20Balance");
        }

        public static /* synthetic */ b0 getEthereumTransactionReceipt$default(CipherCoreInterface cipherCoreInterface, byte[] bArr, int i2, BigInteger bigInteger, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bigInteger = null;
                }
                return cipherCoreInterface.getEthereumTransactionReceipt(bArr, i2, bigInteger);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEthereumTransactionReceipt");
        }

        public static /* synthetic */ b0 getWeiBalance$default(CipherCoreInterface cipherCoreInterface, String str, int i2, BigInteger bigInteger, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bigInteger = null;
                }
                return cipherCoreInterface.getWeiBalance(str, i2, bigInteger);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWeiBalance");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b0 seedFromRecoveryPhrase$default(CipherCoreInterface cipherCoreInterface, String str, List list, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    list = null;
                }
                return cipherCoreInterface.seedFromRecoveryPhrase(str, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: seedFromRecoveryPhrase");
        }

        public static /* synthetic */ b0 signEthereumMessage$default(CipherCoreInterface cipherCoreInterface, byte[] bArr, byte[] bArr2, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = true;
                }
                return cipherCoreInterface.signEthereumMessage(bArr, bArr2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signEthereumMessage");
        }
    }

    b0<String> checksumEthereumAddress(String str);

    b0<KeyPair> deriveEd25519KeyPair(byte[] bArr, String str);

    b0<KeyPair> deriveKeyPair(byte[] bArr, String str);

    b0<byte[]> derivePublicKeyFromXpubKey(String str, String str2);

    b0<ERC20TransferParams> encodeERC20Transfer(String str, String str2, BigInteger bigInteger);

    b0<BigInteger> estimateEthereumGasUsage(String str, String str2, BigInteger bigInteger, byte[] bArr, int i2);

    b0<String> ethereumAddressFromPublicKey(byte[] bArr);

    b0<String> ethereumAddressFromSignedMessage(byte[] bArr, byte[] bArr2, boolean z);

    b0<List<String>> generateRecoveryPhrase(List<String> list);

    b0<Integer> getConfirmedEthereumTransactionCount(String str, int i2, BigInteger bigInteger);

    b0<BigInteger> getERC20Balance(String str, String str2, int i2, BigInteger bigInteger);

    b0<ERC20Info> getERC20Info(String str, int i2);

    b0<BigInteger> getEthereumBlockHeight(int i2);

    b0<List<BigInteger>> getEthereumGasPrices(int i2);

    b0<Optional<EthereumTransactionReceipt>> getEthereumTransactionReceipt(byte[] bArr, int i2, BigInteger bigInteger);

    b0<BigInteger> getWeiBalance(String str, int i2, BigInteger bigInteger);

    b0<Boolean> isValidEthereumAddress(String str);

    b0<byte[]> keccak256Hash(byte[] bArr);

    b0<EthereumJSONRPCRequestResult> makeEthereumJSONRPCRequest(String str, List<? extends Object> list, int i2);

    b0<ParsedEthereumTransaction> parseSignedEthereumTransaction(byte[] bArr);

    b0<byte[]> seedFromRecoveryPhrase(String str, List<String> list);

    b0<SignedEthereumTransaction> sign2930Transaction(String str, BigInteger bigInteger, byte[] bArr, int i2, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr2, int i3);

    b0<SignedEthereumTransaction> signEthereum1559Transaction(String str, BigInteger bigInteger, byte[] bArr, int i2, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, byte[] bArr2, int i3);

    b0<byte[]> signEthereumMessage(byte[] bArr, byte[] bArr2, boolean z);

    b0<SignedEthereumTransaction> signEthereumTransaction(String str, BigInteger bigInteger, byte[] bArr, int i2, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr2, int i3);

    b0<byte[]> submitSignedEthereumTransaction(byte[] bArr, int i2);

    b0<String> xpubKeyFromSeed(byte[] bArr, String str);
}