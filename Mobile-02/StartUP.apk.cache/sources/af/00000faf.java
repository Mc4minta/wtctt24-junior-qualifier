package com.coinbase.ciphercore;

import android.content.Context;
import android.util.Base64;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Moshi;
import h.c.b0;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CipherCore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 n2\u00020\u0001:\u0001nB\u0011\u0012\b\b\u0002\u0010j\u001a\u00020i¢\u0006\u0004\bl\u0010mJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010!\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u000e2\u0006\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010&J/\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u000e2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J7\u00100\u001a\b\u0012\u0004\u0012\u00020+0\u000e2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b0\u00101J?\u00106\u001a\b\u0012\u0004\u0012\u00020+0\u000e2\u0006\u00102\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b6\u00107J%\u00109\u001a\b\u0012\u0004\u0012\u0002080\u000e2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b9\u0010:JW\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u000e2\b\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00152\u0006\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b@\u0010AJW\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u000e2\b\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00152\u0006\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bB\u0010AJ_\u0010E\u001a\b\u0012\u0004\u0012\u00020?0\u000e2\b\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00152\u0006\u0010;\u001a\u00020)2\u0006\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020+2\u0006\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bE\u0010FJ-\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010G\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00152\u0006\u0010H\u001a\u00020'H\u0016¢\u0006\u0004\bI\u0010JJ-\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010G\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u00152\u0006\u0010H\u001a\u00020'H\u0016¢\u0006\u0004\bL\u0010JJ\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u00105\u001a\u00020\u0015H\u0016¢\u0006\u0004\bM\u0010#J/\u0010N\u001a\b\u0012\u0004\u0012\u00020)0\u000e2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\bN\u0010.J\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020+0\u000e2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bO\u0010PJ#\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\f0\u000e2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bQ\u0010PJ3\u0010T\u001a\b\u0012\u0004\u0012\u00020S0\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020R0\f2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bT\u0010UJ\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020W0\u000e2\u0006\u0010V\u001a\u00020\u0015H\u0016¢\u0006\u0004\bX\u0010#J%\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010V\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bY\u0010ZJ5\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\\0\u000e2\u0006\u0010[\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b^\u0010_J-\u0010b\u001a\b\u0012\u0004\u0012\u00020a0\u000e2\u0006\u00103\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u0010`\u001a\u00020+H\u0016¢\u0006\u0004\bb\u0010cR\u001c\u0010e\u001a\u00020d8\u0010@\u0010X\u0090\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0016\u0010j\u001a\u00020i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010k¨\u0006o"}, d2 = {"Lcom/coinbase/ciphercore/CipherCore;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Landroid/content/Context;", "applicationContext", "", "walletApiServiceUrl", "Lcom/coinbase/ciphercore/CipherCoreConfig;", "config", "Lkotlin/x;", "initialize", "(Landroid/content/Context;Ljava/lang/String;Lcom/coinbase/ciphercore/CipherCoreConfig;)V", "method", "", "params", "Lh/c/b0;", "call", "(Ljava/lang/String;Ljava/util/List;)Lh/c/b0;", "wordList", "generateRecoveryPhrase", "(Ljava/util/List;)Lh/c/b0;", "recoveryPhrase", "", "seedFromRecoveryPhrase", "seed", "derivationPath", "xpubKeyFromSeed", "([BLjava/lang/String;)Lh/c/b0;", "Lcom/coinbase/ciphercore/KeyPair;", "deriveKeyPair", "deriveEd25519KeyPair", "xpubKey", "derivePublicKeyFromXpubKey", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "publicKey", "ethereumAddressFromPublicKey", "([B)Lh/c/b0;", "address", "checksumEthereumAddress", "(Ljava/lang/String;)Lh/c/b0;", "", "isValidEthereumAddress", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Ljava/math/BigInteger;", "blockHeight", "getWeiBalance", "(Ljava/lang/String;ILjava/math/BigInteger;)Lh/c/b0;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "getERC20Balance", "(Ljava/lang/String;Ljava/lang/String;ILjava/math/BigInteger;)Lh/c/b0;", "fromAddress", "toAddress", "weiValue", "data", "estimateEthereumGasUsage", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BI)Lh/c/b0;", "Lcom/coinbase/ciphercore/ERC20Info;", "getERC20Info", "(Ljava/lang/String;I)Lh/c/b0;", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "gasLimit", "privateKey", "Lcom/coinbase/ciphercore/SignedEthereumTransaction;", "sign2930Transaction", "(Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;[BI)Lh/c/b0;", "signEthereumTransaction", "maxFeePerGas", "maxPriorityFeePerGas", "signEthereum1559Transaction", "(Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;[BI)Lh/c/b0;", ApiConstants.MESSAGE, "addPrefix", "signEthereumMessage", "([B[BZ)Lh/c/b0;", "signature", "ethereumAddressFromSignedMessage", "keccak256Hash", "getConfirmedEthereumTransactionCount", "getEthereumBlockHeight", "(I)Lh/c/b0;", "getEthereumGasPrices", "", "Lcom/coinbase/ciphercore/EthereumJSONRPCRequestResult;", "makeEthereumJSONRPCRequest", "(Ljava/lang/String;Ljava/util/List;I)Lh/c/b0;", "signedTransaction", "Lcom/coinbase/ciphercore/ParsedEthereumTransaction;", "parseSignedEthereumTransaction", "submitSignedEthereumTransaction", "([BI)Lh/c/b0;", "transactionHash", "Lcom/coinbase/ciphercore/Optional;", "Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "getEthereumTransactionReceipt", "([BILjava/math/BigInteger;)Lh/c/b0;", "value", "Lcom/coinbase/ciphercore/ERC20TransferParams;", "encodeERC20Transfer", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;)Lh/c/b0;", "Lcom/coinbase/ciphercore/CipherCoreBridge;", "bridge", "Lcom/coinbase/ciphercore/CipherCoreBridge;", "getBridge$cipher_core_release", "()Lcom/coinbase/ciphercore/CipherCoreBridge;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "<init>", "(Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "Companion", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class CipherCore implements CipherCoreInterface {
    public static final Companion Companion = new Companion(null);
    private final CipherCoreBridge bridge;
    private final Tracing tracer;

    /* compiled from: CipherCore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/ciphercore/CipherCore$Companion;", "", "<init>", "()V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CipherCore() {
        this(null, 1, null);
    }

    public CipherCore(Tracing tracer) {
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.tracer = tracer;
        this.bridge = new CipherCoreBridge(tracer);
    }

    public static /* synthetic */ ERC20TransferParams a(String str) {
        return m580encodeERC20Transfer$lambda23(str);
    }

    public static /* synthetic */ byte[] b(String str) {
        return m591keccak256Hash$lambda14(str);
    }

    public static /* synthetic */ byte[] c(String str) {
        return m597signEthereumMessage$lambda13(str);
    }

    public static /* synthetic */ KeyPair d(String str) {
        return m577deriveEd25519KeyPair$lambda3(str);
    }

    /* renamed from: deriveEd25519KeyPair$lambda-3 */
    public static final KeyPair m577deriveEd25519KeyPair$lambda3(String result) {
        List K0;
        kotlin.jvm.internal.m.g(result, "result");
        K0 = kotlin.l0.y.K0(result, new String[]{" "}, false, 0, 6, null);
        if (K0.size() == 2) {
            byte[] privateKey = Base64.decode((String) K0.get(0), 0);
            byte[] publicKey = Base64.decode((String) K0.get(1), 0);
            kotlin.jvm.internal.m.f(privateKey, "privateKey");
            kotlin.jvm.internal.m.f(publicKey, "publicKey");
            return new KeyPair(privateKey, publicKey);
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: deriveKeyPair$lambda-2 */
    public static final KeyPair m578deriveKeyPair$lambda2(String result) {
        List K0;
        kotlin.jvm.internal.m.g(result, "result");
        K0 = kotlin.l0.y.K0(result, new String[]{" "}, false, 0, 6, null);
        if (K0.size() == 2) {
            byte[] privateKey = Base64.decode((String) K0.get(0), 0);
            byte[] publicKey = Base64.decode((String) K0.get(1), 0);
            kotlin.jvm.internal.m.f(privateKey, "privateKey");
            kotlin.jvm.internal.m.f(publicKey, "publicKey");
            return new KeyPair(privateKey, publicKey);
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: derivePublicKeyFromXpubKey$lambda-4 */
    public static final byte[] m579derivePublicKeyFromXpubKey$lambda4(String publicKeyBase64) {
        kotlin.jvm.internal.m.g(publicKeyBase64, "publicKeyBase64");
        return Base64.decode(publicKeyBase64, 0);
    }

    public static /* synthetic */ SignedEthereumTransaction e(String str) {
        return m596signEthereum1559Transaction$lambda12(str);
    }

    /* renamed from: encodeERC20Transfer$lambda-23 */
    public static final ERC20TransferParams m580encodeERC20Transfer$lambda23(String resultJson) {
        kotlin.jvm.internal.m.g(resultJson, "resultJson");
        Moshi moshi = new Moshi.Builder().build();
        kotlin.jvm.internal.m.f(moshi, "moshi");
        SerializedERC20TransferParams fromJson = new SerializedERC20TransferParamsJsonAdapter(moshi).fromJson(resultJson);
        if (fromJson != null) {
            byte[] data = Base64.decode(fromJson.getData(), 0);
            String toAddress = fromJson.getToAddress();
            kotlin.jvm.internal.m.f(data, "data");
            return new ERC20TransferParams(toAddress, data);
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: estimateEthereumGasUsage$lambda-8 */
    public static final BigInteger m581estimateEthereumGasUsage$lambda8(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return new BigInteger(result);
    }

    public static /* synthetic */ SignedEthereumTransaction f(String str) {
        return m598signEthereumTransaction$lambda11(str);
    }

    public static /* synthetic */ Boolean g(String str) {
        return m590isValidEthereumAddress$lambda5(str);
    }

    /* renamed from: generateRecoveryPhrase$lambda-0 */
    public static final List m582generateRecoveryPhrase$lambda0(String phrase) {
        List K0;
        kotlin.jvm.internal.m.g(phrase, "phrase");
        K0 = kotlin.l0.y.K0(String_CipherCoreKt.normalize$default(phrase, null, 1, null), new String[]{" "}, false, 0, 6, null);
        return K0;
    }

    /* renamed from: getConfirmedEthereumTransactionCount$lambda-15 */
    public static final Integer m583getConfirmedEthereumTransactionCount$lambda15(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return Integer.valueOf(Integer.parseInt(result));
    }

    /* renamed from: getERC20Balance$lambda-7 */
    public static final BigInteger m584getERC20Balance$lambda7(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return new BigInteger(result);
    }

    /* renamed from: getERC20Info$lambda-9 */
    public static final ERC20Info m585getERC20Info$lambda9(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        Moshi moshi = new Moshi.Builder().build();
        kotlin.jvm.internal.m.f(moshi, "moshi");
        ERC20Info fromJson = new ERC20InfoJsonAdapter(moshi).fromJson(result);
        if (fromJson != null) {
            return fromJson;
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: getEthereumBlockHeight$lambda-16 */
    public static final BigInteger m586getEthereumBlockHeight$lambda16(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return new BigInteger(result);
    }

    /* renamed from: getEthereumGasPrices$lambda-18 */
    public static final List m587getEthereumGasPrices$lambda18(String priceStrings) {
        List<String> K0;
        int r;
        kotlin.jvm.internal.m.g(priceStrings, "priceStrings");
        K0 = kotlin.l0.y.K0(priceStrings, new String[]{" "}, false, 0, 6, null);
        r = kotlin.a0.s.r(K0, 10);
        ArrayList arrayList = new ArrayList(r);
        for (String str : K0) {
            arrayList.add(new BigInteger(str));
        }
        if (arrayList.isEmpty()) {
            throw new UnexpectedResultException();
        }
        return arrayList;
    }

    /* renamed from: getEthereumTransactionReceipt$lambda-22 */
    public static final Optional m588getEthereumTransactionReceipt$lambda22(String resultJson) {
        kotlin.jvm.internal.m.g(resultJson, "resultJson");
        if (kotlin.jvm.internal.m.c(resultJson, "null")) {
            return new Optional(null);
        }
        Moshi moshi = new Moshi.Builder().build();
        kotlin.jvm.internal.m.f(moshi, "moshi");
        SerializedEthereumTransactionReceipt fromJson = new SerializedEthereumTransactionReceiptJsonAdapter(moshi).fromJson(resultJson);
        if (fromJson != null) {
            byte[] blockHash = Base64.decode(fromJson.getBlockHash(), 0);
            BigInteger bigInteger = new BigInteger(fromJson.getGasUsed());
            boolean isSuccessful = fromJson.isSuccessful();
            int blockNumber = fromJson.getBlockNumber();
            kotlin.jvm.internal.m.f(blockHash, "blockHash");
            return new Optional(new EthereumTransactionReceipt(isSuccessful, blockNumber, blockHash, fromJson.getContractAddress(), bigInteger));
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: getWeiBalance$lambda-6 */
    public static final BigInteger m589getWeiBalance$lambda6(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return new BigInteger(result);
    }

    public static /* synthetic */ KeyPair h(String str) {
        return m578deriveKeyPair$lambda2(str);
    }

    public static /* synthetic */ BigInteger i(String str) {
        return m586getEthereumBlockHeight$lambda16(str);
    }

    public static /* synthetic */ void initialize$default(CipherCore cipherCore, Context context, String str, CipherCoreConfig cipherCoreConfig, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
        }
        if ((i2 & 4) != 0) {
            cipherCoreConfig = CipherCoreConfig.Companion.create(str);
        }
        cipherCore.initialize(context, str, cipherCoreConfig);
    }

    /* renamed from: isValidEthereumAddress$lambda-5 */
    public static final Boolean m590isValidEthereumAddress$lambda5(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        if (!kotlin.jvm.internal.m.c(result, "true") && !kotlin.jvm.internal.m.c(result, "false")) {
            throw new UnexpectedResultException();
        }
        return Boolean.valueOf(kotlin.jvm.internal.m.c(result, "true"));
    }

    public static /* synthetic */ BigInteger j(String str) {
        return m584getERC20Balance$lambda7(str);
    }

    public static /* synthetic */ ERC20Info k(String str) {
        return m585getERC20Info$lambda9(str);
    }

    /* renamed from: keccak256Hash$lambda-14 */
    public static final byte[] m591keccak256Hash$lambda14(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return Base64.decode(result, 0);
    }

    public static /* synthetic */ byte[] l(String str) {
        return m594seedFromRecoveryPhrase$lambda1(str);
    }

    public static /* synthetic */ byte[] m(String str) {
        return m579derivePublicKeyFromXpubKey$lambda4(str);
    }

    /* renamed from: makeEthereumJSONRPCRequest$lambda-19 */
    public static final EthereumJSONRPCRequestResult m592makeEthereumJSONRPCRequest$lambda19(Moshi moshi, String resultJson) {
        kotlin.jvm.internal.m.g(resultJson, "resultJson");
        return new EthereumJSONRPCRequestResult(moshi.adapter(Object.class).fromJson(resultJson));
    }

    public static /* synthetic */ EthereumJSONRPCRequestResult n(Moshi moshi, String str) {
        return m592makeEthereumJSONRPCRequest$lambda19(moshi, str);
    }

    public static /* synthetic */ byte[] o(String str) {
        return m599submitSignedEthereumTransaction$lambda21(str);
    }

    public static /* synthetic */ SignedEthereumTransaction p(String str) {
        return m595sign2930Transaction$lambda10(str);
    }

    /* renamed from: parseSignedEthereumTransaction$lambda-20 */
    public static final ParsedEthereumTransaction m593parseSignedEthereumTransaction$lambda20(String resultJson) {
        kotlin.jvm.internal.m.g(resultJson, "resultJson");
        Moshi moshi = new Moshi.Builder().build();
        kotlin.jvm.internal.m.f(moshi, "moshi");
        SerializedParsedEthereumTransaction fromJson = new SerializedParsedEthereumTransactionJsonAdapter(moshi).fromJson(resultJson);
        if (fromJson != null) {
            BigInteger bigInteger = new BigInteger(fromJson.getWeiValue());
            byte[] data = Base64.decode(fromJson.getData(), 0);
            BigInteger bigInteger2 = new BigInteger(fromJson.getGasPriceInWei());
            BigInteger bigInteger3 = new BigInteger(fromJson.getMaxFeePerGas());
            BigInteger bigInteger4 = new BigInteger(fromJson.getMaxPriorityFeePerGas());
            BigInteger bigInteger5 = new BigInteger(fromJson.getGasLimit());
            byte[] hash = Base64.decode(fromJson.getHash(), 0);
            String fromAddress = fromJson.getFromAddress();
            String toAddress = fromJson.getToAddress();
            kotlin.jvm.internal.m.f(data, "data");
            int nonce = fromJson.getNonce();
            int chainId = fromJson.getChainId();
            kotlin.jvm.internal.m.f(hash, "hash");
            return new ParsedEthereumTransaction(fromAddress, toAddress, bigInteger, data, nonce, bigInteger2, bigInteger3, bigInteger4, bigInteger5, chainId, hash);
        }
        throw new UnexpectedResultException();
    }

    public static /* synthetic */ List q(String str) {
        return m582generateRecoveryPhrase$lambda0(str);
    }

    public static /* synthetic */ Integer r(String str) {
        return m583getConfirmedEthereumTransactionCount$lambda15(str);
    }

    public static /* synthetic */ ParsedEthereumTransaction s(String str) {
        return m593parseSignedEthereumTransaction$lambda20(str);
    }

    /* renamed from: seedFromRecoveryPhrase$lambda-1 */
    public static final byte[] m594seedFromRecoveryPhrase$lambda1(String seedBase64) {
        kotlin.jvm.internal.m.g(seedBase64, "seedBase64");
        return Base64.decode(seedBase64, 0);
    }

    /* renamed from: sign2930Transaction$lambda-10 */
    public static final SignedEthereumTransaction m595sign2930Transaction$lambda10(String result) {
        List K0;
        kotlin.jvm.internal.m.g(result, "result");
        K0 = kotlin.l0.y.K0(result, new String[]{" "}, false, 0, 6, null);
        if (K0.size() == 2) {
            byte[] hash = Base64.decode((String) K0.get(0), 0);
            byte[] signedData = Base64.decode((String) K0.get(1), 0);
            kotlin.jvm.internal.m.f(hash, "hash");
            kotlin.jvm.internal.m.f(signedData, "signedData");
            return new SignedEthereumTransaction(hash, signedData);
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: signEthereum1559Transaction$lambda-12 */
    public static final SignedEthereumTransaction m596signEthereum1559Transaction$lambda12(String result) {
        List K0;
        kotlin.jvm.internal.m.g(result, "result");
        K0 = kotlin.l0.y.K0(result, new String[]{" "}, false, 0, 6, null);
        if (K0.size() == 2) {
            byte[] hash = Base64.decode((String) K0.get(0), 0);
            byte[] signedData = Base64.decode((String) K0.get(1), 0);
            kotlin.jvm.internal.m.f(hash, "hash");
            kotlin.jvm.internal.m.f(signedData, "signedData");
            return new SignedEthereumTransaction(hash, signedData);
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: signEthereumMessage$lambda-13 */
    public static final byte[] m597signEthereumMessage$lambda13(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return Base64.decode(result, 0);
    }

    /* renamed from: signEthereumTransaction$lambda-11 */
    public static final SignedEthereumTransaction m598signEthereumTransaction$lambda11(String result) {
        List K0;
        kotlin.jvm.internal.m.g(result, "result");
        K0 = kotlin.l0.y.K0(result, new String[]{" "}, false, 0, 6, null);
        if (K0.size() == 2) {
            byte[] hash = Base64.decode((String) K0.get(0), 0);
            byte[] signedData = Base64.decode((String) K0.get(1), 0);
            kotlin.jvm.internal.m.f(hash, "hash");
            kotlin.jvm.internal.m.f(signedData, "signedData");
            return new SignedEthereumTransaction(hash, signedData);
        }
        throw new UnexpectedResultException();
    }

    /* renamed from: submitSignedEthereumTransaction$lambda-21 */
    public static final byte[] m599submitSignedEthereumTransaction$lambda21(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return Base64.decode(result, 0);
    }

    public static /* synthetic */ BigInteger t(String str) {
        return m581estimateEthereumGasUsage$lambda8(str);
    }

    public static /* synthetic */ Optional u(String str) {
        return m588getEthereumTransactionReceipt$lambda22(str);
    }

    public static /* synthetic */ BigInteger v(String str) {
        return m589getWeiBalance$lambda6(str);
    }

    public static /* synthetic */ List w(String str) {
        return m587getEthereumGasPrices$lambda18(str);
    }

    public final b0<String> call(String method, List<String> params) {
        kotlin.jvm.internal.m.g(method, "method");
        kotlin.jvm.internal.m.g(params, "params");
        return getBridge$cipher_core_release().call(method, params);
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> checksumEthereumAddress(String address) {
        List<String> b2;
        kotlin.jvm.internal.m.g(address, "address");
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        b2 = kotlin.a0.q.b(address);
        return bridge$cipher_core_release.call("checksumEthereumAddress", b2);
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<KeyPair> deriveEd25519KeyPair(byte[] seed, String derivationPath) {
        List<String> j2;
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        String encodeToString = Base64.encodeToString(seed, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(encodeToString, derivationPath);
        b0 map = bridge$cipher_core_release.call("deriveEd25519KeyPair", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.d((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"deriveEd25519KeyPair\", listOf(seedBase64, derivationPath))\n            .map { result ->\n                val keys = result.split(\" \")\n                if (keys.size != 2) {\n                    throw UnexpectedResultException()\n                }\n                val privateKey = Base64.decode(keys[0], Base64.DEFAULT)\n                val publicKey = Base64.decode(keys[1], Base64.DEFAULT)\n                KeyPair(privateKey, publicKey)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<KeyPair> deriveKeyPair(byte[] seed, String derivationPath) {
        List<String> j2;
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        String encodeToString = Base64.encodeToString(seed, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(encodeToString, derivationPath);
        b0 map = bridge$cipher_core_release.call("deriveKeyPair", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.h((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"deriveKeyPair\", listOf(seedBase64, derivationPath))\n            .map { result ->\n                val keys = result.split(\" \")\n                if (keys.size != 2) {\n                    throw UnexpectedResultException()\n                }\n                val privateKey = Base64.decode(keys[0], Base64.DEFAULT)\n                val publicKey = Base64.decode(keys[1], Base64.DEFAULT)\n                KeyPair(privateKey, publicKey)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> derivePublicKeyFromXpubKey(String xpubKey, String derivationPath) {
        List<String> j2;
        kotlin.jvm.internal.m.g(xpubKey, "xpubKey");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(xpubKey, derivationPath);
        b0 map = bridge$cipher_core_release.call("derivePublicKeyFromXpubKey", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.m((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"derivePublicKeyFromXpubKey\", listOf(xpubKey, derivationPath))\n            .map { publicKeyBase64 ->\n                Base64.decode(publicKeyBase64, Base64.DEFAULT)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<ERC20TransferParams> encodeERC20Transfer(String toAddress, String contractAddress, BigInteger value) {
        List<String> j2;
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(value, "value");
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        String bigInteger = value.toString();
        kotlin.jvm.internal.m.f(bigInteger, "value.toString()");
        j2 = r.j(toAddress, contractAddress, bigInteger);
        b0 map = bridge$cipher_core_release.call("encodeERC20Transfer", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.a((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"encodeERC20Transfer\",\n                listOf(\n                    toAddress, contractAddress, value.toString()\n                )\n            )\n            .map { resultJson ->\n                val moshi = Moshi.Builder().build()\n                val result =\n                    SerializedERC20TransferParamsJsonAdapter(moshi).fromJson(resultJson)\n                        ?: throw UnexpectedResultException()\n                val data = Base64.decode(result.data, Base64.DEFAULT)\n\n                ERC20TransferParams(\n                    toAddress = result.toAddress,\n                    data = data\n                )\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> estimateEthereumGasUsage(String fromAddress, String str, BigInteger weiValue, byte[] data, int i2) {
        List<String> j2;
        kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        String encodeToString = Base64.encodeToString(data, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        String[] strArr = new String[5];
        strArr[0] = fromAddress;
        if (str == null) {
            str = "";
        }
        strArr[1] = str;
        strArr[2] = weiValue.toString();
        strArr[3] = encodeToString;
        strArr[4] = String.valueOf(i2);
        j2 = r.j(strArr);
        b0 map = bridge$cipher_core_release.call("estimateEthereumGasUsage", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.t((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"estimateEthereumGasUsage\",\n                listOf(\n                    fromAddress,\n                    toAddress ?: \"\",\n                    weiValue.toString(),\n                    dataBase64,\n                    chainId.toString()\n                )\n            )\n            .map { result -> BigInteger(result) }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> ethereumAddressFromPublicKey(byte[] publicKey) {
        List<String> b2;
        kotlin.jvm.internal.m.g(publicKey, "publicKey");
        String encodeToString = Base64.encodeToString(publicKey, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        b2 = kotlin.a0.q.b(encodeToString);
        return bridge$cipher_core_release.call("ethereumAddressFromPublicKey", b2);
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> ethereumAddressFromSignedMessage(byte[] message, byte[] signature, boolean z) {
        List<String> j2;
        kotlin.jvm.internal.m.g(message, "message");
        kotlin.jvm.internal.m.g(signature, "signature");
        String encodeToString = Base64.encodeToString(message, 2);
        String encodeToString2 = Base64.encodeToString(signature, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(encodeToString, encodeToString2, String.valueOf(z));
        return bridge$cipher_core_release.call("ethereumAddressFromSignedMessage", j2);
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<List<String>> generateRecoveryPhrase(List<String> list) {
        List<String> b2;
        String h0;
        String encodeToString = Base64.encodeToString(UtilKt.getRandomBytes(16), 2);
        if (list != null) {
            h0 = kotlin.a0.z.h0(list, " ", null, null, 0, null, null, 62, null);
            b2 = r.j(encodeToString, String_CipherCoreKt.normalize$default(h0, null, 1, null));
        } else {
            b2 = kotlin.a0.q.b(encodeToString);
        }
        b0 map = getBridge$cipher_core_release().call("generateRecoveryPhrase", b2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.q((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"generateRecoveryPhrase\", params)\n            .map { phrase ->\n                phrase.normalize().split(\" \")\n            }");
        return map;
    }

    public CipherCoreBridge getBridge$cipher_core_release() {
        return this.bridge;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<Integer> getConfirmedEthereumTransactionCount(String address, int i2, BigInteger bigInteger) {
        List<String> j2;
        kotlin.jvm.internal.m.g(address, "address");
        if (bigInteger != null) {
            String bigInteger2 = bigInteger.toString();
            kotlin.jvm.internal.m.f(bigInteger2, "blockHeight.toString()");
            j2 = r.j(address, String.valueOf(i2), bigInteger2);
        } else {
            j2 = r.j(address, String.valueOf(i2));
        }
        b0 map = getBridge$cipher_core_release().call("getConfirmedEthereumTransactionCount", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.r((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"getConfirmedEthereumTransactionCount\", params)\n            .map { result -> result.toInt() }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> getERC20Balance(String address, String contractAddress, int i2, BigInteger bigInteger) {
        List<String> j2;
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        if (bigInteger != null) {
            String bigInteger2 = bigInteger.toString();
            kotlin.jvm.internal.m.f(bigInteger2, "blockHeight.toString()");
            j2 = r.j(address, contractAddress, String.valueOf(i2), bigInteger2);
        } else {
            j2 = r.j(address, contractAddress, String.valueOf(i2));
        }
        b0 map = getBridge$cipher_core_release().call("getERC20Balance", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.j((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"getERC20Balance\", params)\n            .map { result -> BigInteger(result) }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<ERC20Info> getERC20Info(String contractAddress, int i2) {
        List<String> j2;
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(contractAddress, String.valueOf(i2));
        b0 map = bridge$cipher_core_release.call("getERC20Info", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.k((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"getERC20Info\",\n                listOf(\n                    contractAddress,\n                    chainId.toString()\n                )\n            )\n            .map { result ->\n                val moshi = Moshi.Builder().build()\n                ERC20InfoJsonAdapter(moshi).fromJson(result)\n                    ?: throw UnexpectedResultException()\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> getEthereumBlockHeight(int i2) {
        List<String> b2;
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        b2 = kotlin.a0.q.b(String.valueOf(i2));
        b0 map = bridge$cipher_core_release.call("getEthereumBlockHeight", b2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.i((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"getEthereumBlockHeight\", listOf(chainId.toString()))\n            .map { result -> BigInteger(result) }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<List<BigInteger>> getEthereumGasPrices(int i2) {
        List<String> b2;
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        b2 = kotlin.a0.q.b(String.valueOf(i2));
        b0 map = bridge$cipher_core_release.call("getEthereumGasPrices", b2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.w((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"getEthereumGasPrices\", listOf(chainId.toString()))\n            .map { priceStrings ->\n                val prices = priceStrings.split(\" \").map { priceString ->\n                    BigInteger(priceString)\n                }\n                if (prices.isEmpty()) {\n                    throw UnexpectedResultException()\n                }\n                prices\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<Optional<EthereumTransactionReceipt>> getEthereumTransactionReceipt(byte[] transactionHash, int i2, BigInteger bigInteger) {
        kotlin.jvm.internal.m.g(transactionHash, "transactionHash");
        String encodeToString = Base64.encodeToString(transactionHash, 2);
        b0 map = getBridge$cipher_core_release().call("getEthereumTransactionReceipt", bigInteger != null ? r.j(encodeToString, String.valueOf(i2), bigInteger.toString()) : r.j(encodeToString, String.valueOf(i2))).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.u((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"getEthereumTransactionReceipt\", params)\n            .map { resultJson ->\n                if (resultJson == \"null\") {\n                    return@map Optional<EthereumTransactionReceipt>(null)\n                }\n\n                val moshi = Moshi.Builder().build()\n                val receiptData =\n                    SerializedEthereumTransactionReceiptJsonAdapter(moshi).fromJson(resultJson)\n                        ?: throw UnexpectedResultException()\n\n                val blockHash = Base64.decode(receiptData.blockHash, Base64.DEFAULT)\n                val gasUsed = BigInteger(receiptData.gasUsed)\n\n                Optional(\n                    EthereumTransactionReceipt(\n                        isSuccessful = receiptData.isSuccessful,\n                        blockNumber = receiptData.blockNumber,\n                        blockHash = blockHash,\n                        contractAddress = receiptData.contractAddress,\n                        gasUsed = gasUsed\n                    )\n                )\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<BigInteger> getWeiBalance(String address, int i2, BigInteger bigInteger) {
        List<String> j2;
        kotlin.jvm.internal.m.g(address, "address");
        if (bigInteger != null) {
            String bigInteger2 = bigInteger.toString();
            kotlin.jvm.internal.m.f(bigInteger2, "blockHeight.toString()");
            j2 = r.j(address, String.valueOf(i2), bigInteger2);
        } else {
            j2 = r.j(address, String.valueOf(i2));
        }
        b0 map = getBridge$cipher_core_release().call("getWeiBalance", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.v((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"getWeiBalance\", params)\n            .map { result -> BigInteger(result) }");
        return map;
    }

    public final void initialize(Context applicationContext, String walletApiServiceUrl, CipherCoreConfig config) {
        kotlin.jvm.internal.m.g(applicationContext, "applicationContext");
        kotlin.jvm.internal.m.g(walletApiServiceUrl, "walletApiServiceUrl");
        kotlin.jvm.internal.m.g(config, "config");
        getBridge$cipher_core_release().initialize(applicationContext, config, this.tracer);
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<Boolean> isValidEthereumAddress(String address) {
        List<String> b2;
        kotlin.jvm.internal.m.g(address, "address");
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        b2 = kotlin.a0.q.b(address);
        b0 map = bridge$cipher_core_release.call("isValidEthereumAddress", b2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.g((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"isValidEthereumAddress\", listOf(address))\n            .map { result ->\n                if (result != \"true\" && result != \"false\") {\n                    throw UnexpectedResultException()\n                }\n                result == \"true\"\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> keccak256Hash(byte[] data) {
        List<String> b2;
        kotlin.jvm.internal.m.g(data, "data");
        String encodeToString = Base64.encodeToString(data, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        b2 = kotlin.a0.q.b(encodeToString);
        b0 map = bridge$cipher_core_release.call("keccak256Hash", b2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.b((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"keccak256Hash\", listOf(dataBase64))\n            .map { result -> Base64.decode(result, Base64.DEFAULT) }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<EthereumJSONRPCRequestResult> makeEthereumJSONRPCRequest(String method, List<? extends Object> params, int i2) {
        List<String> j2;
        kotlin.jvm.internal.m.g(method, "method");
        kotlin.jvm.internal.m.g(params, "params");
        final Moshi build = new Moshi.Builder().build();
        String json = build.adapter(List.class).toJson(params);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(method, json, String.valueOf(i2));
        b0 map = bridge$cipher_core_release.call("makeEthereumJSONRPCRequest", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.n(Moshi.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"makeEthereumJSONRPCRequest\", listOf(method, paramsJson, chainId.toString()))\n            .map { resultJson ->\n                EthereumJSONRPCRequestResult(\n                    moshi.adapter(Object::class.java).fromJson(resultJson)\n                )\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<ParsedEthereumTransaction> parseSignedEthereumTransaction(byte[] signedTransaction) {
        List<String> b2;
        kotlin.jvm.internal.m.g(signedTransaction, "signedTransaction");
        String encodeToString = Base64.encodeToString(signedTransaction, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        b2 = kotlin.a0.q.b(encodeToString);
        b0 map = bridge$cipher_core_release.call("parseSignedEthereumTransaction", b2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.s((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"parseSignedEthereumTransaction\",\n                listOf(\n                    signedTransactionBase64\n                )\n            )\n            .map { resultJson ->\n                val moshi = Moshi.Builder().build()\n                val result =\n                    SerializedParsedEthereumTransactionJsonAdapter(moshi).fromJson(resultJson)\n                        ?: throw UnexpectedResultException()\n\n                val weiValue = BigInteger(result.weiValue)\n                val data = Base64.decode(result.data, Base64.DEFAULT)\n                val gasPriceInWei = BigInteger(result.gasPriceInWei)\n                val maxFeePerGas = BigInteger(result.maxFeePerGas)\n                val maxPriorityFeePerGas = BigInteger(result.maxPriorityFeePerGas)\n                val gasLimit = BigInteger(result.gasLimit)\n                val hash = Base64.decode(result.hash, Base64.DEFAULT)\n\n                ParsedEthereumTransaction(\n                    fromAddress = result.fromAddress,\n                    toAddress = result.toAddress,\n                    weiValue = weiValue,\n                    data = data,\n                    nonce = result.nonce,\n                    gasPriceInWei = gasPriceInWei,\n                    maxFeePerGas = maxFeePerGas,\n                    maxPriorityFeePerGas = maxPriorityFeePerGas,\n                    gasLimit = gasLimit,\n                    chainId = result.chainId,\n                    hash = hash\n                )\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> seedFromRecoveryPhrase(String recoveryPhrase, List<String> list) {
        List<String> b2;
        String h0;
        kotlin.jvm.internal.m.g(recoveryPhrase, "recoveryPhrase");
        String normalize$default = String_CipherCoreKt.normalize$default(recoveryPhrase, null, 1, null);
        if (list != null) {
            h0 = kotlin.a0.z.h0(list, " ", null, null, 0, null, null, 62, null);
            b2 = r.j(normalize$default, String_CipherCoreKt.normalize$default(h0, null, 1, null));
        } else {
            b2 = kotlin.a0.q.b(normalize$default);
        }
        b0 map = getBridge$cipher_core_release().call("seedFromRecoveryPhrase", b2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.l((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\"seedFromRecoveryPhrase\", params)\n            .map { seedBase64 ->\n                Base64.decode(seedBase64, Base64.DEFAULT)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<SignedEthereumTransaction> sign2930Transaction(String str, BigInteger weiValue, byte[] data, int i2, BigInteger gasPriceInWei, BigInteger gasLimit, byte[] privateKey, int i3) {
        List<String> j2;
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(gasPriceInWei, "gasPriceInWei");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        String encodeToString = Base64.encodeToString(privateKey, 2);
        String encodeToString2 = Base64.encodeToString(data, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        String[] strArr = new String[8];
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        strArr[1] = weiValue.toString();
        strArr[2] = encodeToString2;
        strArr[3] = String.valueOf(i2);
        strArr[4] = gasPriceInWei.toString();
        strArr[5] = gasLimit.toString();
        strArr[6] = encodeToString;
        strArr[7] = String.valueOf(i3);
        j2 = r.j(strArr);
        b0 map = bridge$cipher_core_release.call("sign2930Transaction", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.p((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"sign2930Transaction\",\n                listOf(\n                    toAddress ?: \"\",\n                    weiValue.toString(),\n                    dataBase64,\n                    nonce.toString(),\n                    gasPriceInWei.toString(),\n                    gasLimit.toString(),\n                    privateKeyBase64,\n                    chainId.toString()\n                )\n            )\n            .map { result ->\n                val results = result.split(\" \")\n                if (results.size != 2) {\n                    throw UnexpectedResultException()\n                }\n                val hash = Base64.decode(results[0], Base64.DEFAULT)\n                val signedData = Base64.decode(results[1], Base64.DEFAULT)\n                SignedEthereumTransaction(hash, signedData)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<SignedEthereumTransaction> signEthereum1559Transaction(String str, BigInteger weiValue, byte[] data, int i2, BigInteger maxFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, byte[] privateKey, int i3) {
        List<String> j2;
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(maxFeePerGas, "maxFeePerGas");
        kotlin.jvm.internal.m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        String encodeToString = Base64.encodeToString(privateKey, 2);
        String encodeToString2 = Base64.encodeToString(data, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        String[] strArr = new String[9];
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        strArr[1] = weiValue.toString();
        strArr[2] = encodeToString2;
        strArr[3] = String.valueOf(i2);
        strArr[4] = maxFeePerGas.toString();
        strArr[5] = maxPriorityFeePerGas.toString();
        strArr[6] = gasLimit.toString();
        strArr[7] = encodeToString;
        strArr[8] = String.valueOf(i3);
        j2 = r.j(strArr);
        b0 map = bridge$cipher_core_release.call("sign1559Transaction", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.e((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"sign1559Transaction\",\n                listOf(\n                    toAddress ?: \"\",\n                    weiValue.toString(),\n                    dataBase64,\n                    nonce.toString(),\n                    maxFeePerGas.toString(),\n                    maxPriorityFeePerGas.toString(),\n                    gasLimit.toString(),\n                    privateKeyBase64,\n                    chainId.toString()\n                )\n            )\n            .map { result ->\n                val results = result.split(\" \")\n                if (results.size != 2) {\n                    throw UnexpectedResultException()\n                }\n                val hash = Base64.decode(results[0], Base64.DEFAULT)\n                val signedData = Base64.decode(results[1], Base64.DEFAULT)\n                SignedEthereumTransaction(hash, signedData)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> signEthereumMessage(byte[] message, byte[] privateKey, boolean z) {
        List<String> j2;
        kotlin.jvm.internal.m.g(message, "message");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        String encodeToString = Base64.encodeToString(message, 2);
        String encodeToString2 = Base64.encodeToString(privateKey, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(encodeToString, encodeToString2, String.valueOf(z));
        b0 map = bridge$cipher_core_release.call("signEthereumMessage", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.c((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"signEthereumMessage\",\n                listOf(\n                    messageBase64,\n                    privateKeyBase64,\n                    addPrefix.toString()\n                )\n            )\n            .map { result ->\n                Base64.decode(result, Base64.DEFAULT)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<SignedEthereumTransaction> signEthereumTransaction(String str, BigInteger weiValue, byte[] data, int i2, BigInteger gasPriceInWei, BigInteger gasLimit, byte[] privateKey, int i3) {
        List<String> j2;
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(gasPriceInWei, "gasPriceInWei");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        String encodeToString = Base64.encodeToString(privateKey, 2);
        String encodeToString2 = Base64.encodeToString(data, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        String[] strArr = new String[8];
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        strArr[1] = weiValue.toString();
        strArr[2] = encodeToString2;
        strArr[3] = String.valueOf(i2);
        strArr[4] = gasPriceInWei.toString();
        strArr[5] = gasLimit.toString();
        strArr[6] = encodeToString;
        strArr[7] = String.valueOf(i3);
        j2 = r.j(strArr);
        b0 map = bridge$cipher_core_release.call("signEthereumTransaction", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.f((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"signEthereumTransaction\",\n                listOf(\n                    toAddress ?: \"\",\n                    weiValue.toString(),\n                    dataBase64,\n                    nonce.toString(),\n                    gasPriceInWei.toString(),\n                    gasLimit.toString(),\n                    privateKeyBase64,\n                    chainId.toString()\n                )\n            )\n            .map { result ->\n                val results = result.split(\" \")\n                if (results.size != 2) {\n                    throw UnexpectedResultException()\n                }\n                val hash = Base64.decode(results[0], Base64.DEFAULT)\n                val signedData = Base64.decode(results[1], Base64.DEFAULT)\n                SignedEthereumTransaction(hash, signedData)\n            }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<byte[]> submitSignedEthereumTransaction(byte[] signedTransaction, int i2) {
        List<String> j2;
        kotlin.jvm.internal.m.g(signedTransaction, "signedTransaction");
        String encodeToString = Base64.encodeToString(signedTransaction, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(encodeToString, String.valueOf(i2));
        b0 map = bridge$cipher_core_release.call("submitSignedEthereumTransaction", j2).map(new h.c.m0.n() { // from class: com.coinbase.ciphercore.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore.o((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bridge\n            .call(\n                \"submitSignedEthereumTransaction\",\n                listOf(\n                    signedTransactionBase64,\n                    chainId.toString()\n                )\n            )\n            .map { result -> Base64.decode(result, Base64.DEFAULT) }");
        return map;
    }

    @Override // com.coinbase.ciphercore.CipherCoreInterface
    public b0<String> xpubKeyFromSeed(byte[] seed, String derivationPath) {
        List<String> j2;
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        String encodeToString = Base64.encodeToString(seed, 2);
        CipherCoreBridge bridge$cipher_core_release = getBridge$cipher_core_release();
        j2 = r.j(encodeToString, derivationPath);
        return bridge$cipher_core_release.call("xpubKeyFromSeed", j2);
    }

    public /* synthetic */ CipherCore(Tracing tracing, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Tracing.Companion.getNoOpTraceLogger() : tracing);
    }
}