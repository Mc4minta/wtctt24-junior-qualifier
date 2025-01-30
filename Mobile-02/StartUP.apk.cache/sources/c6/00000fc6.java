package com.coinbase.ciphercore;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MockCipherCore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b[\u0010\\J+\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ/\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J7\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b%\u0010&J?\u0010+\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J%\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00052\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b.\u0010/JW\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b5\u00106J_\u00109\u001a\b\u0012\u0004\u0012\u0002040\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001e2\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b9\u0010:JW\u0010;\u001a\b\u0012\u0004\u0012\u0002040\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b;\u00106J-\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010<\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u001cH\u0016¢\u0006\u0004\b>\u0010?J-\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010<\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u001cH\u0016¢\u0006\u0004\bA\u0010?J\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u0010\u0018J/\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\bC\u0010#J\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\bD\u0010EJ#\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\bF\u0010EJ3\u0010K\u001a\b\u0012\u0004\u0012\u00020J0\u00052\u0006\u0010G\u001a\u00020\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\bK\u0010LJ\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020N0\u00052\u0006\u0010M\u001a\u00020\tH\u0016¢\u0006\u0004\bO\u0010\u0018J%\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010M\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\bP\u0010QJ5\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0S0\u00052\u0006\u0010R\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\bU\u0010VJ-\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0\u00052\u0006\u0010(\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010W\u001a\u00020 H\u0016¢\u0006\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/coinbase/ciphercore/MockCipherCore;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "", "", "wordList", "Lh/c/b0;", "generateRecoveryPhrase", "(Ljava/util/List;)Lh/c/b0;", "recoveryPhrase", "", "seedFromRecoveryPhrase", "(Ljava/lang/String;Ljava/util/List;)Lh/c/b0;", "seed", "derivationPath", "xpubKeyFromSeed", "([BLjava/lang/String;)Lh/c/b0;", "Lcom/coinbase/ciphercore/KeyPair;", "deriveKeyPair", "deriveEd25519KeyPair", "xpubKey", "derivePublicKeyFromXpubKey", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "publicKey", "ethereumAddressFromPublicKey", "([B)Lh/c/b0;", "address", "checksumEthereumAddress", "(Ljava/lang/String;)Lh/c/b0;", "", "isValidEthereumAddress", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Ljava/math/BigInteger;", "blockHeight", "getWeiBalance", "(Ljava/lang/String;ILjava/math/BigInteger;)Lh/c/b0;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "getERC20Balance", "(Ljava/lang/String;Ljava/lang/String;ILjava/math/BigInteger;)Lh/c/b0;", "fromAddress", "toAddress", "weiValue", "data", "estimateEthereumGasUsage", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BI)Lh/c/b0;", "Lcom/coinbase/ciphercore/ERC20Info;", "getERC20Info", "(Ljava/lang/String;I)Lh/c/b0;", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "gasLimit", "privateKey", "Lcom/coinbase/ciphercore/SignedEthereumTransaction;", "sign2930Transaction", "(Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;[BI)Lh/c/b0;", "maxFeePerGas", "maxPriorityFeePerGas", "signEthereum1559Transaction", "(Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;[BI)Lh/c/b0;", "signEthereumTransaction", ApiConstants.MESSAGE, "addPrefix", "signEthereumMessage", "([B[BZ)Lh/c/b0;", "signature", "ethereumAddressFromSignedMessage", "keccak256Hash", "getConfirmedEthereumTransactionCount", "getEthereumBlockHeight", "(I)Lh/c/b0;", "getEthereumGasPrices", "method", "", "params", "Lcom/coinbase/ciphercore/EthereumJSONRPCRequestResult;", "makeEthereumJSONRPCRequest", "(Ljava/lang/String;Ljava/util/List;I)Lh/c/b0;", "signedTransaction", "Lcom/coinbase/ciphercore/ParsedEthereumTransaction;", "parseSignedEthereumTransaction", "submitSignedEthereumTransaction", "([BI)Lh/c/b0;", "transactionHash", "Lcom/coinbase/ciphercore/Optional;", "Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "getEthereumTransactionReceipt", "([BILjava/math/BigInteger;)Lh/c/b0;", "value", "Lcom/coinbase/ciphercore/ERC20TransferParams;", "encodeERC20Transfer", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;)Lh/c/b0;", "<init>", "()V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class MockCipherCore implements CipherCoreInterface {
    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> checksumEthereumAddress(String address) {
        kotlin.jvm.internal.m.g(address, "address");
        b0<String> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<KeyPair> deriveEd25519KeyPair(byte[] seed, String derivationPath) {
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        b0<KeyPair> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<KeyPair> deriveKeyPair(byte[] seed, String derivationPath) {
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        b0<KeyPair> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> derivePublicKeyFromXpubKey(String xpubKey, String derivationPath) {
        kotlin.jvm.internal.m.g(xpubKey, "xpubKey");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        b0<byte[]> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<ERC20TransferParams> encodeERC20Transfer(String toAddress, String contractAddress, BigInteger value) {
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(value, "value");
        b0<ERC20TransferParams> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> estimateEthereumGasUsage(String fromAddress, String str, BigInteger weiValue, byte[] data, int i2) {
        kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        b0<BigInteger> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> ethereumAddressFromPublicKey(byte[] publicKey) {
        kotlin.jvm.internal.m.g(publicKey, "publicKey");
        b0<String> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> ethereumAddressFromSignedMessage(byte[] message, byte[] signature, boolean z) {
        kotlin.jvm.internal.m.g(message, "message");
        kotlin.jvm.internal.m.g(signature, "signature");
        b0<String> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<List<String>> generateRecoveryPhrase(List<String> list) {
        b0<List<String>> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<Integer> getConfirmedEthereumTransactionCount(String address, int i2, BigInteger bigInteger) {
        kotlin.jvm.internal.m.g(address, "address");
        b0<Integer> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> getERC20Balance(String address, String contractAddress, int i2, BigInteger bigInteger) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        b0<BigInteger> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<ERC20Info> getERC20Info(String contractAddress, int i2) {
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        b0<ERC20Info> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> getEthereumBlockHeight(int i2) {
        b0<BigInteger> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<List<BigInteger>> getEthereumGasPrices(int i2) {
        b0<List<BigInteger>> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<Optional<EthereumTransactionReceipt>> getEthereumTransactionReceipt(byte[] transactionHash, int i2, BigInteger bigInteger) {
        kotlin.jvm.internal.m.g(transactionHash, "transactionHash");
        b0<Optional<EthereumTransactionReceipt>> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> getWeiBalance(String address, int i2, BigInteger bigInteger) {
        kotlin.jvm.internal.m.g(address, "address");
        b0<BigInteger> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<Boolean> isValidEthereumAddress(String address) {
        kotlin.jvm.internal.m.g(address, "address");
        b0<Boolean> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> keccak256Hash(byte[] data) {
        kotlin.jvm.internal.m.g(data, "data");
        b0<byte[]> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<EthereumJSONRPCRequestResult> makeEthereumJSONRPCRequest(String method, List<? extends Object> params, int i2) {
        kotlin.jvm.internal.m.g(method, "method");
        kotlin.jvm.internal.m.g(params, "params");
        b0<EthereumJSONRPCRequestResult> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<ParsedEthereumTransaction> parseSignedEthereumTransaction(byte[] signedTransaction) {
        kotlin.jvm.internal.m.g(signedTransaction, "signedTransaction");
        b0<ParsedEthereumTransaction> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> seedFromRecoveryPhrase(String recoveryPhrase, List<String> list) {
        kotlin.jvm.internal.m.g(recoveryPhrase, "recoveryPhrase");
        b0<byte[]> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<SignedEthereumTransaction> sign2930Transaction(String str, BigInteger weiValue, byte[] data, int i2, BigInteger gasPriceInWei, BigInteger gasLimit, byte[] privateKey, int i3) {
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(gasPriceInWei, "gasPriceInWei");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        b0<SignedEthereumTransaction> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<SignedEthereumTransaction> signEthereum1559Transaction(String str, BigInteger weiValue, byte[] data, int i2, BigInteger maxFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, byte[] privateKey, int i3) {
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(maxFeePerGas, "maxFeePerGas");
        kotlin.jvm.internal.m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        b0<SignedEthereumTransaction> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> signEthereumMessage(byte[] message, byte[] privateKey, boolean z) {
        kotlin.jvm.internal.m.g(message, "message");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        b0<byte[]> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<SignedEthereumTransaction> signEthereumTransaction(String str, BigInteger weiValue, byte[] data, int i2, BigInteger gasPriceInWei, BigInteger gasLimit, byte[] privateKey, int i3) {
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(gasPriceInWei, "gasPriceInWei");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        b0<SignedEthereumTransaction> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> submitSignedEthereumTransaction(byte[] signedTransaction, int i2) {
        kotlin.jvm.internal.m.g(signedTransaction, "signedTransaction");
        b0<byte[]> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> xpubKeyFromSeed(byte[] seed, String derivationPath) {
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        b0<String> error = b0.error(new kotlin.n(null, 1, null));
        kotlin.jvm.internal.m.f(error, "error(NotImplementedError())");
        return error;
    }
}