package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.EthereumTransactionReceipt;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.exceptions.NetworkException;
import com.coinbase.wallet.blockchains.exceptions.TxException;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559Result;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.ERC20TxCreating;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxSubmitting;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.GasEstimationStatus;
import com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: EthereumBasedTxManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B9\b\u0000\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010[\u001a\u00020Z¢\u0006\u0004\b\\\u0010]J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ_\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJq\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010 \u001a\u0004\u0018\u00010\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\"\u0010#J-\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010*J%\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\n2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010\rJ\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\n2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b/\u00100J-\u00104\u001a\b\u0012\u0004\u0012\u0002010\n2\u0006\u00102\u001a\u0002012\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u00020\u000b¢\u0006\u0004\b4\u00105R\u001c\u00107\u001a\u0002068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010<\u001a\u00020;8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010D\u001a\u00020C8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010I\u001a\u00020H8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR(\u0010O\u001a\b\u0012\u0004\u0012\u00020N0M8\u0016@\u0017X\u0097\u0004¢\u0006\u0012\n\u0004\bO\u0010P\u0012\u0004\bS\u0010T\u001a\u0004\bQ\u0010RR$\u0010X\u001a\u0010\u0012\f\u0012\n W*\u0004\u0018\u00010V0V0U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006^"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/EthereumBasedTxManaging;", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "Lcom/coinbase/wallet/ethereum/interfaces/ERC20TxCreating;", "Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxSubmitting;", "Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxSigning;", "Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxResubmitting;", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "", "isValidAddress", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Ljava/math/BigInteger;", "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "maxFeePerGas", "baseFeePerGas", "maxPriorityFeePerGas", "generateUnsignedEthereum1559Tx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "refreshBalances", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signAndSubmit", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;Z)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxState", "Lkotlin/x;", "resubmitPendingTxs", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "tx", "shouldResubmit", "submitTx", "(Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Z)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "getMinerFeeAPI", "()Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "configuration", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "Lcom/coinbase/wallet/ethereum/repositories/EthereumBasedBalanceRepository;", "ethereumBasedBalanceManaging", "Lcom/coinbase/wallet/ethereum/repositories/EthereumBasedBalanceRepository;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "txUpdatesObservable", "Lh/c/s;", "getTxUpdatesObservable", "()Lh/c/s;", "getTxUpdatesObservable$annotations", "()V", "Lh/c/v0/b;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "kotlin.jvm.PlatformType", "txSubmitsSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "<init>", "(Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/ethereum/repositories/EthereumBasedBalanceRepository;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class EthereumBasedTxManaging implements TxManaging, ERC20TxCreating, EthereumTxSubmitting, EthereumTxSigning, EthereumTxResubmitting {
    private final AddressDao addressDao;
    private final CipherCoreInterface cipherCore;
    private final WalletConfiguration configuration;
    private final EthereumBasedBalanceRepository ethereumBasedBalanceManaging;
    private final MinerFeeAPI minerFeeAPI;
    private final h.c.v0.b<Transaction> txSubmitsSubject;
    private final h.c.s<TxUpdate> txUpdatesObservable;

    public EthereumBasedTxManaging(WalletConfiguration configuration, CipherCoreInterface cipherCore, AddressDao addressDao, MinerFeeAPI minerFeeAPI, EthereumBasedBalanceRepository ethereumBasedBalanceManaging, EthereumSignedTxDao ethereumSignedTxDao) {
        kotlin.jvm.internal.m.g(configuration, "configuration");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(minerFeeAPI, "minerFeeAPI");
        kotlin.jvm.internal.m.g(ethereumBasedBalanceManaging, "ethereumBasedBalanceManaging");
        kotlin.jvm.internal.m.g(ethereumSignedTxDao, "ethereumSignedTxDao");
        this.configuration = configuration;
        this.cipherCore = cipherCore;
        this.addressDao = addressDao;
        this.minerFeeAPI = minerFeeAPI;
        this.ethereumBasedBalanceManaging = ethereumBasedBalanceManaging;
        h.c.v0.b<Transaction> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Transaction>()");
        this.txSubmitsSubject = d2;
        h.c.s<TxUpdate> merge = h.c.s.merge(d2.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedTxManaging.s((Transaction) obj);
            }
        }), ethereumSignedTxDao.observeSignedTx().distinctUntilChanged(new h.c.m0.d() { // from class: com.coinbase.wallet.ethereum.interfaces.p
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return EthereumBasedTxManaging.i((EthereumSignedTx) obj, (EthereumSignedTx) obj2);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedTxManaging.h((EthereumSignedTx) obj);
            }
        }));
        kotlin.jvm.internal.m.f(merge, "merge(\n        txSubmitsSubject.hide().map { TxUpdate.Submitted(it) },\n        ethereumSignedTxDao.observeSignedTx()\n            .distinctUntilChanged { a, b ->\n                // '==' in kotlin compares value most of the time, but for ByteArray it is referential comparison\n                // that's why cannot simply call distinctUntilChanged() here and rely on equals method generated from\n                // data class to just work its magic. Consumers of this stream trigger many db writes/reads; optimizations\n                // are worthwhile\n                a.id == b.id && a.state == b.state && a.signedTxData.contentEquals(b.signedTxData)\n            }\n            .map { TxUpdate.Update(it) }\n    )");
        this.txUpdatesObservable = merge;
    }

    public static /* synthetic */ EthereumSignedTx a(EthereumSignedTx ethereumSignedTx, Throwable th) {
        return m1121signAndSubmit$lambda17$lambda16(ethereumSignedTx, th);
    }

    public static /* synthetic */ BigInteger b(GasEstimationStatus gasEstimationStatus) {
        return m1110generateUnsignedEthereum1559Tx$lambda8(gasEstimationStatus);
    }

    public static /* synthetic */ h.c.h0 c(EthereumBasedTxManaging ethereumBasedTxManaging, Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, Integer num, Map map, BigInteger bigInteger3) {
        return m1116generateUnsignedTx$lambda7(ethereumBasedTxManaging, wallet, str, str2, bigInteger, bigInteger2, num, map, bigInteger3);
    }

    public static /* synthetic */ BigInteger d(Optional optional) {
        return m1106generateUnsignedEthereum1559Tx$lambda10(optional);
    }

    public static /* synthetic */ h.c.h0 e(EthereumBasedTxManaging ethereumBasedTxManaging, Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, Map map, BigInteger bigInteger5) {
        return m1109generateUnsignedEthereum1559Tx$lambda13(ethereumBasedTxManaging, wallet, str, str2, bigInteger, bigInteger2, bigInteger3, bigInteger4, num, map, bigInteger5);
    }

    public static /* synthetic */ h.c.h0 f(Wallet wallet, EthereumBasedTxManaging ethereumBasedTxManaging, String str, BigInteger bigInteger, BigInteger bigInteger2, Integer num, Map map, kotlin.t tVar) {
        return m1108generateUnsignedEthereum1559Tx$lambda12(wallet, ethereumBasedTxManaging, str, bigInteger, bigInteger2, num, map, tVar);
    }

    public static /* synthetic */ EthereumSignedTx g(EthereumSignedTx ethereumSignedTx, kotlin.x xVar) {
        return m1120signAndSubmit$lambda17$lambda15(ethereumSignedTx, xVar);
    }

    /* renamed from: generateUnsignedEthereum1559Tx$lambda-10 */
    public static final BigInteger m1106generateUnsignedEthereum1559Tx$lambda10(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        BigInteger bigInteger = (BigInteger) it.getValue();
        if (bigInteger != null) {
            return bigInteger;
        }
        throw EthereumException.UnableToCalculateBalance.INSTANCE;
    }

    /* renamed from: generateUnsignedEthereum1559Tx$lambda-11 */
    public static final kotlin.t m1107generateUnsignedEthereum1559Tx$lambda11(kotlin.t dstr$weiValue$maxFeePerGas$gasLimit) {
        kotlin.jvm.internal.m.g(dstr$weiValue$maxFeePerGas$gasLimit, "$dstr$weiValue$maxFeePerGas$gasLimit");
        BigInteger weiValue = (BigInteger) dstr$weiValue$maxFeePerGas$gasLimit.a();
        BigInteger maxFeePerGas = (BigInteger) dstr$weiValue$maxFeePerGas$gasLimit.b();
        BigInteger gasLimit = (BigInteger) dstr$weiValue$maxFeePerGas$gasLimit.c();
        BigInteger bigInteger = BigInteger.ZERO;
        kotlin.jvm.internal.m.f(weiValue, "weiValue");
        kotlin.jvm.internal.m.f(maxFeePerGas, "maxFeePerGas");
        kotlin.jvm.internal.m.f(gasLimit, "gasLimit");
        BigInteger multiply = maxFeePerGas.multiply(gasLimit);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        BigInteger subtract = weiValue.subtract(multiply);
        kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
        return new kotlin.t(bigInteger.max(subtract), maxFeePerGas, gasLimit);
    }

    /* renamed from: generateUnsignedEthereum1559Tx$lambda-12 */
    public static final h.c.h0 m1108generateUnsignedEthereum1559Tx$lambda12(Wallet wallet, EthereumBasedTxManaging this$0, String recipientAddress, BigInteger bigInteger, BigInteger bigInteger2, Integer num, Map metadata, kotlin.t dstr$value$maxFeePerGas$gasLimit) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "$metadata");
        kotlin.jvm.internal.m.g(dstr$value$maxFeePerGas$gasLimit, "$dstr$value$maxFeePerGas$gasLimit");
        BigInteger bigInteger3 = (BigInteger) dstr$value$maxFeePerGas$gasLimit.c();
        return EthereumTxCreating.DefaultImpls.generateUnsignedEthereum1559Tx$default(this$0, wallet.getPrimaryAddress(), recipientAddress, (BigInteger) dstr$value$maxFeePerGas$gasLimit.a(), (BigInteger) dstr$value$maxFeePerGas$gasLimit.b(), bigInteger, bigInteger2, bigInteger3, null, wallet.getNetwork(), num, wallet.getCurrencyCode(), wallet.getBlockchain(), metadata, 128, null);
    }

    /* renamed from: generateUnsignedEthereum1559Tx$lambda-13 */
    public static final h.c.h0 m1109generateUnsignedEthereum1559Tx$lambda13(EthereumBasedTxManaging this$0, Wallet wallet, String recipientAddress, String contractAddress, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, Map metadata, BigInteger value) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(contractAddress, "$contractAddress");
        kotlin.jvm.internal.m.g(metadata, "$metadata");
        kotlin.jvm.internal.m.g(value, "value");
        return this$0.generateUnsignedERC201559Tx(wallet, recipientAddress, contractAddress, value, bigInteger, bigInteger2, bigInteger3, bigInteger4, num, metadata);
    }

    /* renamed from: generateUnsignedEthereum1559Tx$lambda-8 */
    public static final BigInteger m1110generateUnsignedEthereum1559Tx$lambda8(GasEstimationStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getGas().getValue();
    }

    /* renamed from: generateUnsignedEthereum1559Tx$lambda-9 */
    public static final BigInteger m1111generateUnsignedEthereum1559Tx$lambda9(AdjustableMinerFee1559Result it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getNormalMaxFeePerGas();
    }

    /* renamed from: generateUnsignedTx$lambda-3 */
    public static final BigInteger m1112generateUnsignedTx$lambda3(GasEstimationStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getGas().getValue();
    }

    /* renamed from: generateUnsignedTx$lambda-4 */
    public static final BigInteger m1113generateUnsignedTx$lambda4(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        BigInteger bigInteger = (BigInteger) it.getValue();
        if (bigInteger != null) {
            return bigInteger;
        }
        throw EthereumException.UnableToCalculateBalance.INSTANCE;
    }

    /* renamed from: generateUnsignedTx$lambda-5 */
    public static final kotlin.t m1114generateUnsignedTx$lambda5(kotlin.t dstr$weiValue$gasPrice$gasLimit) {
        kotlin.jvm.internal.m.g(dstr$weiValue$gasPrice$gasLimit, "$dstr$weiValue$gasPrice$gasLimit");
        BigInteger weiValue = (BigInteger) dstr$weiValue$gasPrice$gasLimit.a();
        BigInteger gasPrice = (BigInteger) dstr$weiValue$gasPrice$gasLimit.b();
        BigInteger gasLimit = (BigInteger) dstr$weiValue$gasPrice$gasLimit.c();
        BigInteger bigInteger = BigInteger.ZERO;
        kotlin.jvm.internal.m.f(weiValue, "weiValue");
        kotlin.jvm.internal.m.f(gasPrice, "gasPrice");
        kotlin.jvm.internal.m.f(gasLimit, "gasLimit");
        BigInteger multiply = gasPrice.multiply(gasLimit);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        BigInteger subtract = weiValue.subtract(multiply);
        kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
        return new kotlin.t(bigInteger.max(subtract), gasPrice, gasLimit);
    }

    /* renamed from: generateUnsignedTx$lambda-6 */
    public static final h.c.h0 m1115generateUnsignedTx$lambda6(Wallet wallet, EthereumBasedTxManaging this$0, String recipientAddress, Integer num, Map metadata, kotlin.t dstr$value$gasPrice$gasLimit) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "$metadata");
        kotlin.jvm.internal.m.g(dstr$value$gasPrice$gasLimit, "$dstr$value$gasPrice$gasLimit");
        BigInteger bigInteger = (BigInteger) dstr$value$gasPrice$gasLimit.c();
        return EthereumTxCreating.DefaultImpls.generateUnsignedEthereumTx$default(this$0, wallet.getPrimaryAddress(), recipientAddress, (BigInteger) dstr$value$gasPrice$gasLimit.a(), (BigInteger) dstr$value$gasPrice$gasLimit.b(), bigInteger, null, wallet.getNetwork(), num, wallet.getCurrencyCode(), wallet.getBlockchain(), metadata, 32, null);
    }

    /* renamed from: generateUnsignedTx$lambda-7 */
    public static final h.c.h0 m1116generateUnsignedTx$lambda7(EthereumBasedTxManaging this$0, Wallet wallet, String recipientAddress, String contractAddress, BigInteger bigInteger, BigInteger bigInteger2, Integer num, Map metadata, BigInteger value) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(contractAddress, "$contractAddress");
        kotlin.jvm.internal.m.g(metadata, "$metadata");
        kotlin.jvm.internal.m.g(value, "value");
        return this$0.generateUnsignedERC20Tx(wallet, recipientAddress, contractAddress, value, bigInteger, bigInteger2, num, metadata);
    }

    /* renamed from: getTxState$lambda-19 */
    public static final TxState m1117getTxState$lambda19(com.coinbase.ciphercore.Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        EthereumTransactionReceipt ethereumTransactionReceipt = (EthereumTransactionReceipt) it.getValue();
        boolean z = false;
        if (ethereumTransactionReceipt != null && ethereumTransactionReceipt.isSuccessful()) {
            z = true;
        }
        if (z) {
            return TxState.CONFIRMED;
        }
        return TxState.PENDING;
    }

    public static /* synthetic */ void getTxUpdatesObservable$annotations() {
    }

    public static /* synthetic */ TxUpdate.Update h(EthereumSignedTx ethereumSignedTx) {
        return m1126txUpdatesObservable$lambda2(ethereumSignedTx);
    }

    public static /* synthetic */ boolean i(EthereumSignedTx ethereumSignedTx, EthereumSignedTx ethereumSignedTx2) {
        return m1125txUpdatesObservable$lambda1(ethereumSignedTx, ethereumSignedTx2);
    }

    public static /* synthetic */ h.c.h0 j(EthereumBasedTxManaging ethereumBasedTxManaging, EthereumSignedTx ethereumSignedTx) {
        return m1118signAndSubmit$lambda14(ethereumBasedTxManaging, ethereumSignedTx);
    }

    public static /* synthetic */ BigInteger k(AdjustableMinerFee1559Result adjustableMinerFee1559Result) {
        return m1111generateUnsignedEthereum1559Tx$lambda9(adjustableMinerFee1559Result);
    }

    public static /* synthetic */ h.c.h0 l(Wallet wallet, EthereumBasedTxManaging ethereumBasedTxManaging, String str, Integer num, Map map, kotlin.t tVar) {
        return m1115generateUnsignedTx$lambda6(wallet, ethereumBasedTxManaging, str, num, map, tVar);
    }

    public static /* synthetic */ kotlin.t m(kotlin.t tVar) {
        return m1114generateUnsignedTx$lambda5(tVar);
    }

    public static /* synthetic */ SignedTx n(UnsignedTx unsignedTx, EthereumBasedTxManaging ethereumBasedTxManaging, EthereumSignedTx ethereumSignedTx) {
        return m1122signAndSubmit$lambda18(unsignedTx, ethereumBasedTxManaging, ethereumSignedTx);
    }

    public static /* synthetic */ h.c.h0 o(boolean z, UnsignedTx unsignedTx, int i2, EthereumBasedTxManaging ethereumBasedTxManaging, EthereumSignedTx ethereumSignedTx) {
        return m1119signAndSubmit$lambda17(z, unsignedTx, i2, ethereumBasedTxManaging, ethereumSignedTx);
    }

    public static /* synthetic */ BigInteger p(GasEstimationStatus gasEstimationStatus) {
        return m1112generateUnsignedTx$lambda3(gasEstimationStatus);
    }

    public static /* synthetic */ kotlin.t q(kotlin.t tVar) {
        return m1107generateUnsignedEthereum1559Tx$lambda11(tVar);
    }

    public static /* synthetic */ void r(UnsignedTx unsignedTx, EthereumSignedTx ethereumSignedTx, EthereumBasedTxManaging ethereumBasedTxManaging, EthereumSignedTx ethereumSignedTx2) {
        m1123submitTx$lambda20(unsignedTx, ethereumSignedTx, ethereumBasedTxManaging, ethereumSignedTx2);
    }

    public static /* synthetic */ TxUpdate.Submitted s(Transaction transaction) {
        return m1124txUpdatesObservable$lambda0(transaction);
    }

    /* renamed from: signAndSubmit$lambda-14 */
    public static final h.c.h0 m1118signAndSubmit$lambda14(EthereumBasedTxManaging this$0, EthereumSignedTx it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.submitTx(it, true);
    }

    /* renamed from: signAndSubmit$lambda-17 */
    public static final h.c.h0 m1119signAndSubmit$lambda17(boolean z, UnsignedTx unsignedTx, int i2, EthereumBasedTxManaging this$0, final EthereumSignedTx signedTx) {
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        if (z) {
            return this$0.ethereumBasedBalanceManaging.refreshBalances(new RefreshContext(unsignedTx.getNetwork(), Integer.valueOf(i2), RefreshContext.Mode.Quick.INSTANCE, true)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.n
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedTxManaging.g(EthereumSignedTx.this, (kotlin.x) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedTxManaging.a(EthereumSignedTx.this, (Throwable) obj);
                }
            });
        }
        return h.c.b0.just(signedTx);
    }

    /* renamed from: signAndSubmit$lambda-17$lambda-15 */
    public static final EthereumSignedTx m1120signAndSubmit$lambda17$lambda15(EthereumSignedTx signedTx, kotlin.x it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-17$lambda-16 */
    public static final EthereumSignedTx m1121signAndSubmit$lambda17$lambda16(EthereumSignedTx signedTx, Throwable it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-18 */
    public static final SignedTx m1122signAndSubmit$lambda18(UnsignedTx unsignedTx, EthereumBasedTxManaging this$0, EthereumSignedTx signedTx) {
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        Transaction createSubmittedTx = Transaction.Companion.createSubmittedTx(unsignedTx, signedTx);
        if (unsignedTx instanceof EthereumUnsigned1559Tx) {
            createSubmittedTx = createSubmittedTx.copy((r34 & 1) != 0 ? createSubmittedTx.getId() : null, (r34 & 2) != 0 ? createSubmittedTx.createdAt : null, (r34 & 4) != 0 ? createSubmittedTx.confirmedAt : null, (r34 & 8) != 0 ? createSubmittedTx.blockchain : null, (r34 & 16) != 0 ? createSubmittedTx.currencyCode : null, (r34 & 32) != 0 ? createSubmittedTx.feeCurrencyCode : null, (r34 & 64) != 0 ? createSubmittedTx.toAddress : null, (r34 & 128) != 0 ? createSubmittedTx.fromAddress : null, (r34 & 256) != 0 ? createSubmittedTx.amount : null, (r34 & 512) != 0 ? createSubmittedTx.fee : null, (r34 & 1024) != 0 ? createSubmittedTx.lowerBoundFee : ((EthereumUnsigned1559Tx) unsignedTx).getLowerBoundFee(), (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? createSubmittedTx.state : null, (r34 & 4096) != 0 ? createSubmittedTx.metadata : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? createSubmittedTx.network : null, (r34 & 16384) != 0 ? createSubmittedTx.txHash : null, (r34 & 32768) != 0 ? createSubmittedTx.isSent : false);
        }
        this$0.txSubmitsSubject.onNext(createSubmittedTx);
        return signedTx;
    }

    /* renamed from: submitTx$lambda-20 */
    public static final void m1123submitTx$lambda20(UnsignedTx unsignedTx, EthereumSignedTx tx, EthereumBasedTxManaging this$0, EthereumSignedTx ethereumSignedTx) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (unsignedTx != null) {
            Transaction createSubmittedTx = Transaction.Companion.createSubmittedTx(unsignedTx, tx);
            if (unsignedTx instanceof EthereumUnsigned1559Tx) {
                createSubmittedTx = createSubmittedTx.copy((r34 & 1) != 0 ? createSubmittedTx.getId() : null, (r34 & 2) != 0 ? createSubmittedTx.createdAt : null, (r34 & 4) != 0 ? createSubmittedTx.confirmedAt : null, (r34 & 8) != 0 ? createSubmittedTx.blockchain : null, (r34 & 16) != 0 ? createSubmittedTx.currencyCode : null, (r34 & 32) != 0 ? createSubmittedTx.feeCurrencyCode : null, (r34 & 64) != 0 ? createSubmittedTx.toAddress : null, (r34 & 128) != 0 ? createSubmittedTx.fromAddress : null, (r34 & 256) != 0 ? createSubmittedTx.amount : null, (r34 & 512) != 0 ? createSubmittedTx.fee : null, (r34 & 1024) != 0 ? createSubmittedTx.lowerBoundFee : ((EthereumUnsigned1559Tx) unsignedTx).getLowerBoundFee(), (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? createSubmittedTx.state : null, (r34 & 4096) != 0 ? createSubmittedTx.metadata : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? createSubmittedTx.network : null, (r34 & 16384) != 0 ? createSubmittedTx.txHash : null, (r34 & 32768) != 0 ? createSubmittedTx.isSent : false);
            }
            this$0.txSubmitsSubject.onNext(createSubmittedTx);
        }
    }

    public static /* synthetic */ TxState t(com.coinbase.ciphercore.Optional optional) {
        return m1117getTxState$lambda19(optional);
    }

    /* renamed from: txUpdatesObservable$lambda-0 */
    public static final TxUpdate.Submitted m1124txUpdatesObservable$lambda0(Transaction it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Submitted(it);
    }

    /* renamed from: txUpdatesObservable$lambda-1 */
    public static final boolean m1125txUpdatesObservable$lambda1(EthereumSignedTx a, EthereumSignedTx b2) {
        kotlin.jvm.internal.m.g(a, "a");
        kotlin.jvm.internal.m.g(b2, "b");
        return kotlin.jvm.internal.m.c(a.getId(), b2.getId()) && a.getState() == b2.getState() && Arrays.equals(a.getSignedTxData(), b2.getSignedTxData());
    }

    /* renamed from: txUpdatesObservable$lambda-2 */
    public static final TxUpdate.Update m1126txUpdatesObservable$lambda2(EthereumSignedTx it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Update(it);
    }

    public static /* synthetic */ BigInteger u(Optional optional) {
        return m1113generateUnsignedTx$lambda4(optional);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ERC20TxCreating
    public h.c.b0<UnsignedTxResult> generateUnsignedERC201559Tx(Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, Integer num, Map<TxMetadataKey, ? extends Object> map) {
        return ERC20TxCreating.DefaultImpls.generateUnsignedERC201559Tx(this, wallet, str, str2, bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, num, map);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ERC20TxCreating
    public h.c.b0<UnsignedTxResult> generateUnsignedERC20Tx(Wallet wallet, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Integer num, Map<TxMetadataKey, ? extends Object> map) {
        return ERC20TxCreating.DefaultImpls.generateUnsignedERC20Tx(this, wallet, str, str2, bigInteger, bigInteger2, bigInteger3, num, map);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map) {
        return ERC20TxCreating.DefaultImpls.generateUnsignedEthereum1559Tx(this, str, str2, bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bArr, network, num, currencyCode, blockchain, map);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public h.c.b0<UnsignedTxResult> generateUnsignedEthereumTx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, Network network, Integer num, CurrencyCode currencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> map) {
        return ERC20TxCreating.DefaultImpls.generateUnsignedEthereumTx(this, str, str2, bigInteger, bigInteger2, bigInteger3, bArr, network, num, currencyCode, blockchain, map);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<UnsignedTxResult> generateUnsignedTx(final Wallet wallet, TransferValue amount, final String recipientAddress, final Map<TxMetadataKey, ? extends Object> metadata, final BigInteger bigInteger, final BigInteger bigInteger2, final Integer num) {
        h.c.b0 just;
        h.c.b0 just2;
        h.c.b0 map;
        h.c.b0<BigInteger> gasPrice;
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
        if (asEthereumChain == null) {
            h.c.b0<UnsignedTxResult> error = h.c.b0.error(new NetworkException.InvalidNetwork(wallet.getNetwork()));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(wallet.network))");
            return error;
        } else if (kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), getConfiguration().currencyCodeForNetwork(wallet.getNetwork()))) {
            if (amount instanceof TransferValue.EntireBalance) {
                if (bigInteger2 != null) {
                    map = h.c.b0.just(bigInteger2);
                } else {
                    map = EthereumTxCreating.DefaultImpls.getGasLimit$default(this, wallet.getPrimaryAddress(), recipientAddress, null, null, asEthereumChain.getChainId(), 4, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.w
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return EthereumBasedTxManaging.p((GasEstimationStatus) obj);
                        }
                    });
                }
                kotlin.jvm.internal.m.f(map, "if (gasLimit != null) {\n                        Single.just(gasLimit)\n                    } else {\n                        getGasLimit(\n                            fromAddress = wallet.primaryAddress,\n                            toAddress = recipientAddress,\n                            chainID = ethereumChain.chainId,\n                            data = null\n                        )\n                            .map { it.gas.value }\n                    }");
                if (bigInteger != null) {
                    gasPrice = h.c.b0.just(bigInteger);
                    kotlin.jvm.internal.m.f(gasPrice, "{\n                        Single.just(gasPrice)\n                    }");
                } else {
                    gasPrice = getGasPrice(asEthereumChain.getChainId());
                }
                h.c.h0 map2 = this.ethereumBasedBalanceManaging.getBalance(wallet.getPrimaryAddress(), wallet.getNetwork()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.b0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedTxManaging.u((Optional) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map2, "ethereumBasedBalanceManaging\n                        .getBalance(wallet.primaryAddress, wallet.network)\n                        .map { it.value ?: throw EthereumException.UnableToCalculateBalance }");
                just2 = h.c.t0.e.a.b(map2, gasPrice, map).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.t
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedTxManaging.m((kotlin.t) obj);
                    }
                });
                kotlin.jvm.internal.m.f(just2, "{\n                    val getGasLimitSingle = if (gasLimit != null) {\n                        Single.just(gasLimit)\n                    } else {\n                        getGasLimit(\n                            fromAddress = wallet.primaryAddress,\n                            toAddress = recipientAddress,\n                            chainID = ethereumChain.chainId,\n                            data = null\n                        )\n                            .map { it.gas.value }\n                    }\n\n                    val getGasPriceSingle = if (gasPrice != null) {\n                        Single.just(gasPrice)\n                    } else {\n                        getGasPrice(ethereumChain.chainId)\n                    }\n\n                    val getBalanceSingle = ethereumBasedBalanceManaging\n                        .getBalance(wallet.primaryAddress, wallet.network)\n                        .map { it.value ?: throw EthereumException.UnableToCalculateBalance }\n\n                    Singles.zip(getBalanceSingle, getGasPriceSingle, getGasLimitSingle)\n                        .map { (weiValue, gasPrice, gasLimit) ->\n                            val value = BigInteger.ZERO.max(weiValue - (gasPrice * gasLimit))\n                            Triple(value, gasPrice, gasLimit)\n                        }\n                }");
            } else if (amount instanceof TransferValue.Amount) {
                just2 = h.c.b0.just(new kotlin.t(((TransferValue.Amount) amount).getValue(), bigInteger, bigInteger2));
                kotlin.jvm.internal.m.f(just2, "{\n                    Single.just(Triple(amount.value, gasPrice, gasLimit))\n                }");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            h.c.b0<UnsignedTxResult> flatMap = just2.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.s
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedTxManaging.l(Wallet.this, this, recipientAddress, num, metadata, (kotlin.t) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "amountWithGasSingle\n                .flatMap { (value, gasPrice, gasLimit) ->\n                    generateUnsignedEthereumTx(\n                        fromAddress = wallet.primaryAddress,\n                        toAddress = recipientAddress,\n                        weiValue = value,\n                        network = wallet.network,\n                        currencyCode = wallet.currencyCode,\n                        blockchain = wallet.blockchain,\n                        gasLimit = gasLimit,\n                        gasPrice = gasPrice,\n                        nonce = nonce,\n                        metadata = metadata\n                    )\n                }");
            return flatMap;
        } else {
            final String contractAddress = wallet.getContractAddress();
            if (contractAddress == null) {
                h.c.b0<UnsignedTxResult> error2 = h.c.b0.error(EthereumException.InvalidERC20.INSTANCE);
                kotlin.jvm.internal.m.f(error2, "error(EthereumException.InvalidERC20)");
                return error2;
            }
            if (amount instanceof TransferValue.EntireBalance) {
                just = EthereumBasedBalanceRepository.getERC20Balance$default(this.ethereumBasedBalanceManaging, wallet.getPrimaryAddress(), contractAddress, wallet.getNetwork(), null, 8, null);
            } else if (amount instanceof TransferValue.Amount) {
                just = h.c.b0.just(((TransferValue.Amount) amount).getValue());
                kotlin.jvm.internal.m.f(just, "{\n                Single.just(amount.value)\n            }");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            h.c.b0<UnsignedTxResult> flatMap2 = just.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.j
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedTxManaging.c(EthereumBasedTxManaging.this, wallet, recipientAddress, contractAddress, bigInteger, bigInteger2, num, metadata, (BigInteger) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap2, "getAmount.flatMap { value ->\n            generateUnsignedERC20Tx(\n                wallet = wallet,\n                recipientAddress = recipientAddress,\n                erc20ContractAddress = contractAddress,\n                value = value,\n                gasPrice = gasPrice,\n                gasLimit = gasLimit,\n                nonce = nonce,\n                metadata = metadata\n            )\n        }");
            return flatMap2;
        }
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public h.c.b0<AdjustableMinerFee1559Result> get1559GasPrice(int i2) {
        return ERC20TxCreating.DefaultImpls.get1559GasPrice(this, i2);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating, com.coinbase.wallet.ethereum.interfaces.EthereumTxSubmitting, com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning, com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting
    public CipherCoreInterface getCipherCore() {
        return this.cipherCore;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging, com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public WalletConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public h.c.b0<GasEstimationStatus> getGasLimit(String str, String str2, BigInteger bigInteger, byte[] bArr, int i2) {
        return ERC20TxCreating.DefaultImpls.getGasLimit(this, str, str2, bigInteger, bArr, i2);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public h.c.b0<BigInteger> getGasPrice(int i2) {
        return ERC20TxCreating.DefaultImpls.getGasPrice(this, i2);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxCreating
    public MinerFeeAPI getMinerFeeAPI() {
        return this.minerFeeAPI;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<TxState> getTxState(String txHash, Network network) {
        kotlin.jvm.internal.m.g(txHash, "txHash");
        kotlin.jvm.internal.m.g(network, "network");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            h.c.b0<TxState> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
            return error;
        }
        byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(txHash);
        if (asHexEncodedData == null) {
            h.c.b0<TxState> error2 = h.c.b0.error(TxException.UnableToHexEncode.INSTANCE);
            kotlin.jvm.internal.m.f(error2, "error(TxException.UnableToHexEncode)");
            return error2;
        }
        h.c.b0 map = getCipherCore().getEthereumTransactionReceipt(asHexEncodedData, asEthereumChain.getChainId(), null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedTxManaging.t((com.coinbase.ciphercore.Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cipherCore.getEthereumTransactionReceipt(data, ethereumChain.chainId, null)\n            .map {\n                if (it.value?.isSuccessful == true) {\n                    TxState.CONFIRMED\n                } else TxState.PENDING\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.s<TxUpdate> getTxUpdatesObservable() {
        return this.txUpdatesObservable;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<Boolean> isValidAddress(String address, Network network) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(network, "network");
        return getCipherCore().isValidEthereumAddress(address);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting
    public h.c.b0<kotlin.x> resubmitAllPendingTxs(Network network) {
        return EthereumTxResubmitting.DefaultImpls.resubmitAllPendingTxs(this, network);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<kotlin.x> resubmitPendingTxs(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        return resubmitAllPendingTxs(network);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning
    public h.c.b0<EthereumSignedTx> sign1559Tx(EthereumUnsigned1559Tx ethereumUnsigned1559Tx, String str, boolean z) {
        return EthereumTxSigning.DefaultImpls.sign1559Tx(this, ethereumUnsigned1559Tx, str, z);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<SignedTx> signAndSubmit(final UnsignedTx unsignedTx, String mnemonic, final boolean z) {
        kotlin.o oVar;
        kotlin.jvm.internal.m.g(unsignedTx, "unsignedTx");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        if (unsignedTx instanceof EthereumUnsignedLegacyTx) {
            EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx = (EthereumUnsignedLegacyTx) unsignedTx;
            oVar = new kotlin.o(signTx(ethereumUnsignedLegacyTx, mnemonic, ethereumUnsignedLegacyTx.getNonce() != null), Integer.valueOf(ethereumUnsignedLegacyTx.getWalletIndex()));
        } else if (unsignedTx instanceof EthereumUnsigned1559Tx) {
            EthereumUnsigned1559Tx ethereumUnsigned1559Tx = (EthereumUnsigned1559Tx) unsignedTx;
            oVar = new kotlin.o(sign1559Tx(ethereumUnsigned1559Tx, mnemonic, ethereumUnsigned1559Tx.getNonce() != null), Integer.valueOf(ethereumUnsigned1559Tx.getWalletIndex()));
        } else {
            h.c.b0<SignedTx> error = h.c.b0.error(TxException.UnknownTransactionType.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(TxException.UnknownTransactionType)");
            return error;
        }
        final int intValue = ((Number) oVar.b()).intValue();
        h.c.b0<SignedTx> map = ((h.c.b0) oVar.a()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedTxManaging.j(EthereumBasedTxManaging.this, (EthereumSignedTx) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedTxManaging.o(z, unsignedTx, intValue, this, (EthereumSignedTx) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedTxManaging.n(UnsignedTx.this, this, (EthereumSignedTx) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "signedTxSingle\n            .flatMap { submitTx(it, shouldResubmit = true) }\n            .flatMap { signedTx ->\n                return@flatMap if (refreshBalances) {\n                    val context = RefreshContext(\n                        network = unsignedTx.network,\n                        index = walletIndex,\n                        mode = RefreshContext.Mode.Quick,\n                        isForced = true\n                    )\n\n                    ethereumBasedBalanceManaging.refreshBalances(context)\n                        .map { signedTx }\n                        .onErrorReturn { signedTx }\n                } else {\n                    Single.just(signedTx)\n                }\n            }\n            .map { signedTx ->\n                var transaction = Transaction.createSubmittedTx(unsignedTx, signedTx)\n                if (unsignedTx is EthereumUnsigned1559Tx) {\n                    transaction = transaction.copy(\n                        lowerBoundFee = unsignedTx.lowerBoundFee\n                    )\n                }\n                txSubmitsSubject.onNext(transaction)\n                signedTx\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning
    public h.c.b0<EthereumSignedTx> signTx(EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, String str, boolean z) {
        return EthereumTxSigning.DefaultImpls.signTx(this, ethereumUnsignedLegacyTx, str, z);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxSubmitting
    public h.c.b0<EthereumSignedTx> submitTx(EthereumSignedTx ethereumSignedTx, boolean z) {
        return EthereumTxSubmitting.DefaultImpls.submitTx(this, ethereumSignedTx, z);
    }

    public final h.c.b0<UnsignedTxResult> generateUnsignedEthereum1559Tx(final Wallet wallet, TransferValue amount, final String recipientAddress, final Map<TxMetadataKey, ? extends Object> metadata, final BigInteger bigInteger, final BigInteger bigInteger2, final BigInteger bigInteger3, final BigInteger bigInteger4, final Integer num) {
        h.c.b0 just;
        h.c.b0 just2;
        h.c.b0 map;
        Object map2;
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
        if (asEthereumChain == null) {
            h.c.b0<UnsignedTxResult> error = h.c.b0.error(new NetworkException.InvalidNetwork(wallet.getNetwork()));
            kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(wallet.network))");
            return error;
        } else if (kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), getConfiguration().currencyCodeForNetwork(wallet.getNetwork()))) {
            if (amount instanceof TransferValue.EntireBalance) {
                if (bigInteger4 != null) {
                    map = h.c.b0.just(bigInteger4);
                } else {
                    map = EthereumTxCreating.DefaultImpls.getGasLimit$default(this, wallet.getPrimaryAddress(), recipientAddress, null, null, asEthereumChain.getChainId(), 4, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.i
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return EthereumBasedTxManaging.b((GasEstimationStatus) obj);
                        }
                    });
                }
                kotlin.jvm.internal.m.f(map, "if (gasLimit != null) {\n                        Single.just(gasLimit)\n                    } else {\n                        getGasLimit(\n                            fromAddress = wallet.primaryAddress,\n                            toAddress = recipientAddress,\n                            chainID = ethereumChain.chainId,\n                            data = null\n                        )\n                            .map { it.gas.value }\n                    }");
                if (bigInteger != null) {
                    map2 = h.c.b0.just(bigInteger);
                } else {
                    map2 = getMinerFeeAPI().get1559MinerFeeEstimates(asEthereumChain.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.r
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return EthereumBasedTxManaging.k((AdjustableMinerFee1559Result) obj);
                        }
                    });
                }
                kotlin.jvm.internal.m.f(map2, "if (maxFeePerGas != null) {\n                        Single.just(maxFeePerGas)\n                    } else {\n                        minerFeeAPI.get1559MinerFeeEstimates(ethereumChain.chainId).map { it.normalMaxFeePerGas }\n                    }");
                h.c.h0 map3 = this.ethereumBasedBalanceManaging.getBalance(wallet.getPrimaryAddress(), wallet.getNetwork()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.k
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedTxManaging.d((Optional) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map3, "ethereumBasedBalanceManaging\n                        .getBalance(wallet.primaryAddress, wallet.network)\n                        .map { it.value ?: throw EthereumException.UnableToCalculateBalance }");
                just2 = h.c.t0.e.a.b(map3, map2, map).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.x
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumBasedTxManaging.q((kotlin.t) obj);
                    }
                });
                kotlin.jvm.internal.m.f(just2, "{\n                    val getGasLimitSingle = if (gasLimit != null) {\n                        Single.just(gasLimit)\n                    } else {\n                        getGasLimit(\n                            fromAddress = wallet.primaryAddress,\n                            toAddress = recipientAddress,\n                            chainID = ethereumChain.chainId,\n                            data = null\n                        )\n                            .map { it.gas.value }\n                    }\n\n                    val maxFeePerGasSingle = if (maxFeePerGas != null) {\n                        Single.just(maxFeePerGas)\n                    } else {\n                        minerFeeAPI.get1559MinerFeeEstimates(ethereumChain.chainId).map { it.normalMaxFeePerGas }\n                    }\n\n                    val getBalanceSingle = ethereumBasedBalanceManaging\n                        .getBalance(wallet.primaryAddress, wallet.network)\n                        .map { it.value ?: throw EthereumException.UnableToCalculateBalance }\n\n                    Singles.zip(getBalanceSingle, maxFeePerGasSingle, getGasLimitSingle)\n                        .map { (weiValue, maxFeePerGas, gasLimit) ->\n                            val value = BigInteger.ZERO.max(weiValue - (maxFeePerGas * gasLimit))\n                            Triple(value, maxFeePerGas, gasLimit)\n                        }\n                }");
            } else if (amount instanceof TransferValue.Amount) {
                just2 = h.c.b0.just(new kotlin.t(((TransferValue.Amount) amount).getValue(), bigInteger, bigInteger4));
                kotlin.jvm.internal.m.f(just2, "{\n                    Single.just(Triple(amount.value, maxFeePerGas, gasLimit))\n                }");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            h.c.b0<UnsignedTxResult> flatMap = just2.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.m
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedTxManaging.f(Wallet.this, this, recipientAddress, bigInteger3, bigInteger2, num, metadata, (kotlin.t) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "amountWithGasSingle\n                .flatMap { (value, maxFeePerGas, gasLimit) ->\n                    generateUnsignedEthereum1559Tx(\n                        fromAddress = wallet.primaryAddress,\n                        toAddress = recipientAddress,\n                        weiValue = value,\n                        network = wallet.network,\n                        currencyCode = wallet.currencyCode,\n                        blockchain = wallet.blockchain,\n                        gasLimit = gasLimit,\n                        maxFeePerGas = maxFeePerGas,\n                        baseFeePerGas = baseFeePerGas,\n                        maxPriorityFeePerGas = maxPriorityFeePerGas,\n                        nonce = nonce,\n                        metadata = metadata\n                    )\n                }");
            return flatMap;
        } else {
            final String contractAddress = wallet.getContractAddress();
            if (contractAddress == null) {
                h.c.b0<UnsignedTxResult> error2 = h.c.b0.error(EthereumException.InvalidERC20.INSTANCE);
                kotlin.jvm.internal.m.f(error2, "error(EthereumException.InvalidERC20)");
                return error2;
            }
            if (amount instanceof TransferValue.EntireBalance) {
                just = EthereumBasedBalanceRepository.getERC20Balance$default(this.ethereumBasedBalanceManaging, wallet.getPrimaryAddress(), contractAddress, wallet.getNetwork(), null, 8, null);
            } else if (amount instanceof TransferValue.Amount) {
                just = h.c.b0.just(((TransferValue.Amount) amount).getValue());
                kotlin.jvm.internal.m.f(just, "{\n                Single.just(amount.value)\n            }");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            h.c.b0<UnsignedTxResult> flatMap2 = just.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.l
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedTxManaging.e(EthereumBasedTxManaging.this, wallet, recipientAddress, contractAddress, bigInteger, bigInteger2, bigInteger3, bigInteger4, num, metadata, (BigInteger) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap2, "getAmount.flatMap { value ->\n            generateUnsignedERC201559Tx(\n                wallet = wallet,\n                recipientAddress = recipientAddress,\n                erc20ContractAddress = contractAddress,\n                value = value,\n                maxFeePerGas = maxFeePerGas,\n                baseFeePerGas = baseFeePerGas,\n                maxPriorityFeePerGas = maxPriorityFeePerGas,\n                gasLimit = gasLimit,\n                nonce = nonce,\n                metadata = metadata\n            )\n        }");
            return flatMap2;
        }
    }

    public final h.c.b0<EthereumSignedTx> submitTx(final EthereumSignedTx tx, final UnsignedTx unsignedTx, boolean z) {
        kotlin.jvm.internal.m.g(tx, "tx");
        if (tx == null) {
            h.c.b0<EthereumSignedTx> error = h.c.b0.error(TxException.UnknownTransactionType.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(TxException.UnknownTransactionType)");
            return error;
        }
        h.c.b0<EthereumSignedTx> doOnSuccess = submitTx(tx, z).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.ethereum.interfaces.y
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                EthereumBasedTxManaging.r(UnsignedTx.this, tx, this, (EthereumSignedTx) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSuccess, "submitTx(tx, shouldResubmit = shouldResubmit)\n            .doOnSuccess {\n                if (unsignedTx != null) {\n                    var transaction = Transaction.createSubmittedTx(unsignedTx, tx)\n                    if (unsignedTx is EthereumUnsigned1559Tx) {\n                        transaction = transaction.copy(\n                            lowerBoundFee = unsignedTx.lowerBoundFee\n                        )\n                    }\n                    txSubmitsSubject.onNext(transaction)\n                }\n            }");
        return doOnSuccess;
    }
}