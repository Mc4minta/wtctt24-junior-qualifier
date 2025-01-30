package com.coinbase.wallet.stellar.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.exceptions.TxException;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
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
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.stellar.api.TimeAPI;
import com.coinbase.wallet.stellar.daos.StellarSignedTxDao;
import com.coinbase.wallet.stellar.exceptions.StellarException;
import com.coinbase.wallet.stellar.extensions.CipherCoreInterface_StellarKt;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import com.coinbase.wallet.stellar.extensions.WalletConfiguration_StellarKt;
import com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging;
import com.coinbase.wallet.stellar.models.StellarSignedTx;
import com.coinbase.wallet.stellar.models.StellarUnsignedTx;
import com.coinbase.wallet.stellar.models.XLMConfiguration;
import com.coinbase.walletengine.services.stellar.SignedTransaction;
import com.coinbase.walletengine.services.stellar.StellarService;
import com.coinbase.walletengine.services.stellar.TransactionResult;
import h.c.b0;
import h.c.h0;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.x;
import org.apache.http.message.TokenParser;

/* compiled from: StellarTxRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bS\u0010TJ%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ_\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\bH\u0017¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\nJ\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b'\u0010(R\u001c\u0010*\u001a\u00020)8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00102\u001a\u0002018\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00107\u001a\u0002068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010A\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010?0?0>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR(\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0016@\u0017X\u0097\u0004¢\u0006\u0012\n\u0004\bE\u0010F\u0012\u0004\bI\u0010J\u001a\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010O\u001a\u00020N8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/coinbase/wallet/stellar/repositories/StellarTxRepository;", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "Lcom/coinbase/wallet/stellar/interfaces/StellarBalanceManaging;", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "", "isValidAddress", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Ljava/math/BigInteger;", "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "refreshBalances", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signAndSubmit", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;Z)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxState", "Lkotlin/x;", "resubmitPendingTxs", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/stellar/models/XLMConfiguration;", "configuration", "Lcom/coinbase/wallet/stellar/models/XLMConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/stellar/models/XLMConfiguration;", "Lcom/coinbase/wallet/stellar/api/TimeAPI;", "timeAPI", "Lcom/coinbase/wallet/stellar/api/TimeAPI;", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "walletService", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "getWalletService", "()Lcom/coinbase/walletengine/services/stellar/StellarService;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/stellar/daos/StellarSignedTxDao;", "txDao", "Lcom/coinbase/wallet/stellar/daos/StellarSignedTxDao;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "kotlin.jvm.PlatformType", "txSubmitsSubject", "Lh/c/v0/b;", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "txUpdatesObservable", "Lh/c/s;", "getTxUpdatesObservable", "()Lh/c/s;", "getTxUpdatesObservable$annotations", "()V", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "<init>", "(Lcom/coinbase/wallet/stellar/daos/StellarSignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/stellar/api/TimeAPI;Lcom/coinbase/walletengine/services/stellar/StellarService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;)V", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StellarTxRepository implements TxManaging, StellarBalanceManaging {
    private final AddressDao addressDao;
    private final CipherCoreInterface cipherCore;
    private final XLMConfiguration configuration;
    private final TimeAPI timeAPI;
    private final StellarSignedTxDao txDao;
    private final h.c.v0.b<Transaction> txSubmitsSubject;
    private final h.c.s<TxUpdate> txUpdatesObservable;
    private final WalletDao walletDao;
    private final StellarService walletService;

    public StellarTxRepository(StellarSignedTxDao txDao, CipherCoreInterface cipherCore, TimeAPI timeAPI, StellarService walletService, AddressDao addressDao, WalletDao walletDao) {
        kotlin.jvm.internal.m.g(txDao, "txDao");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(timeAPI, "timeAPI");
        kotlin.jvm.internal.m.g(walletService, "walletService");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        this.txDao = txDao;
        this.cipherCore = cipherCore;
        this.timeAPI = timeAPI;
        this.walletService = walletService;
        this.addressDao = addressDao;
        this.walletDao = walletDao;
        h.c.v0.b<Transaction> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Transaction>()");
        this.txSubmitsSubject = d2;
        this.configuration = WalletConfiguration_StellarKt.getXLM(WalletConfiguration.Companion);
        h.c.s<TxUpdate> merge = h.c.s.merge(d2.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.f((Transaction) obj);
            }
        }), txDao.observeSignedTx().distinctUntilChanged(new h.c.m0.d() { // from class: com.coinbase.wallet.stellar.repositories.k
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return StellarTxRepository.k((StellarSignedTx) obj, (StellarSignedTx) obj2);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.d((StellarSignedTx) obj);
            }
        }));
        kotlin.jvm.internal.m.f(merge, "merge(\n        txSubmitsSubject.hide().map { TxUpdate.Submitted(it) },\n        txDao.observeSignedTx()\n            .distinctUntilChanged { a, b ->\n                // '==' in kotlin compares value most of the time, but for ByteArray it is referential comparison\n                // that's why cannot simply call distinctUntilChanged() here and rely on equals method generated from\n                // data class to just work its magic. Consumers of this stream trigger many db writes/reads; optimizations\n                // are worthwhile\n                a.id == b.id && a.state == b.state && a.signedTransactionData.contentEquals(b.signedTransactionData)\n            }\n            .map { TxUpdate.Update(it) }\n    )");
        this.txUpdatesObservable = merge;
    }

    public static /* synthetic */ h0 a(StellarTxRepository stellarTxRepository, List list) {
        return m1704resubmitPendingTxs$lambda25(stellarTxRepository, list);
    }

    public static /* synthetic */ UnsignedTxResult b(Wallet wallet, TransferValue transferValue, String str, String str2, BigInteger bigInteger, String str3, String str4, kotlin.o oVar) {
        return m1697generateUnsignedTx$lambda4(wallet, transferValue, str, str2, bigInteger, str3, str4, oVar);
    }

    public static /* synthetic */ Optional c(Throwable th) {
        return m1703resubmitPendingTxs$lambda20$lambda19$lambda18(th);
    }

    public static /* synthetic */ TxUpdate.Update d(StellarSignedTx stellarSignedTx) {
        return m1718txUpdatesObservable$lambda2(stellarSignedTx);
    }

    public static /* synthetic */ h0 e(StellarUnsignedTx stellarUnsignedTx, StellarTxRepository stellarTxRepository, kotlin.t tVar) {
        return m1715signAndSubmit$lambda7(stellarUnsignedTx, stellarTxRepository, tVar);
    }

    public static /* synthetic */ TxUpdate.Submitted f(Transaction transaction) {
        return m1716txUpdatesObservable$lambda0(transaction);
    }

    public static /* synthetic */ x g(Throwable th) {
        return m1706resubmitPendingTxs$lambda25$lambda24$lambda22$lambda21(th);
    }

    /* renamed from: generateUnsignedTx$lambda-4 */
    public static final UnsignedTxResult m1697generateUnsignedTx$lambda4(Wallet wallet, TransferValue amount, String recipientAddress, String str, BigInteger bigInteger, String str2, String str3, kotlin.o dstr$fee$recipientBalance) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(dstr$fee$recipientBalance, "$dstr$fee$recipientBalance");
        BigInteger fee = (BigInteger) dstr$fee$recipientBalance.a();
        com.coinbase.walletengine.Optional optional = (com.coinbase.walletengine.Optional) dstr$fee$recipientBalance.b();
        BigInteger minimumBalance = wallet.getMinimumBalance();
        if (minimumBalance == null) {
            minimumBalance = BigInteger.ZERO;
        }
        BigInteger minimumBalance2 = minimumBalance;
        BigInteger balance = wallet.getBalance();
        kotlin.jvm.internal.m.f(minimumBalance2, "minimumBalance");
        BigInteger subtract = balance.subtract(minimumBalance2);
        kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
        kotlin.jvm.internal.m.f(fee, "fee");
        BigInteger subtract2 = subtract.subtract(fee);
        kotlin.jvm.internal.m.f(subtract2, "this.subtract(other)");
        if (amount instanceof TransferValue.Amount) {
            TransferValue.Amount amount2 = (TransferValue.Amount) amount;
            if (amount2.getValue().compareTo(subtract2) <= 0) {
                subtract2 = amount2.getValue();
            }
        } else if (!(amount instanceof TransferValue.EntireBalance)) {
            throw new NoWhenBranchMatchedException();
        }
        BigInteger bigInteger2 = subtract2;
        String primaryAddress = wallet.getPrimaryAddress();
        BigInteger bigInteger3 = BigInteger.ZERO;
        Comparable f2 = kotlin.b0.a.f(bigInteger2, bigInteger3);
        kotlin.jvm.internal.m.f(f2, "maxOf(transferValue, BigInteger.ZERO)");
        StellarUnsignedTx stellarUnsignedTx = new StellarUnsignedTx(primaryAddress, recipientAddress, (BigInteger) f2, fee, str, bigInteger, str2, str3, wallet.getNetwork());
        if (bigInteger2.compareTo(bigInteger3) <= 0) {
            return new UnsignedTxResult.Error(stellarUnsignedTx, TxException.InsufficientBalance.INSTANCE);
        }
        if (optional.getValue() == null && bigInteger2.compareTo(minimumBalance2) < 0) {
            return new UnsignedTxResult.Error(stellarUnsignedTx, StellarException.RequiresMinimumBalance.INSTANCE);
        }
        return new UnsignedTxResult.Success(stellarUnsignedTx);
    }

    /* renamed from: getTxState$lambda-13 */
    public static final TxState m1698getTxState$lambda13(com.coinbase.walletengine.Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        TransactionResult transactionResult = (TransactionResult) it.getValue();
        boolean z = false;
        if (transactionResult != null && transactionResult.getSuccessful()) {
            z = true;
        }
        return z ? TxState.CONFIRMED : TxState.PENDING;
    }

    public static /* synthetic */ void getTxUpdatesObservable$annotations() {
    }

    public static /* synthetic */ h0 h(StellarTxRepository stellarTxRepository, StellarUnsignedTx stellarUnsignedTx, kotlin.o oVar) {
        return m1714signAndSubmit$lambda6(stellarTxRepository, stellarUnsignedTx, oVar);
    }

    public static /* synthetic */ SignedTx i(StellarTxRepository stellarTxRepository, UnsignedTx unsignedTx, SignedTx signedTx) {
        return m1712signAndSubmit$lambda12(stellarTxRepository, unsignedTx, signedTx);
    }

    public static /* synthetic */ h0 j(StellarSignedTx stellarSignedTx, StellarTxRepository stellarTxRepository, UInt uInt) {
        return m1705resubmitPendingTxs$lambda25$lambda24$lambda22(stellarSignedTx, stellarTxRepository, uInt);
    }

    public static /* synthetic */ boolean k(StellarSignedTx stellarSignedTx, StellarSignedTx stellarSignedTx2) {
        return m1717txUpdatesObservable$lambda1(stellarSignedTx, stellarSignedTx2);
    }

    public static /* synthetic */ TxState l(com.coinbase.walletengine.Optional optional) {
        return m1698getTxState$lambda13(optional);
    }

    public static /* synthetic */ h0 m(StellarTxRepository stellarTxRepository, StellarUnsignedTx stellarUnsignedTx, kotlin.o oVar) {
        return m1713signAndSubmit$lambda5(stellarTxRepository, stellarUnsignedTx, oVar);
    }

    public static /* synthetic */ SignedTx n(Optional optional) {
        return m1711signAndSubmit$lambda11(optional);
    }

    public static /* synthetic */ x o(Throwable th) {
        return m1707resubmitPendingTxs$lambda25$lambda24$lambda23(th);
    }

    public static /* synthetic */ Optional p(Optional optional, x xVar) {
        return m1709signAndSubmit$lambda10$lambda8(optional, xVar);
    }

    public static /* synthetic */ h0 q(StellarTxRepository stellarTxRepository, List list) {
        return m1699resubmitPendingTxs$lambda16(stellarTxRepository, list);
    }

    public static /* synthetic */ Optional r(com.coinbase.walletengine.Optional optional) {
        return m1702resubmitPendingTxs$lambda20$lambda19$lambda17(optional);
    }

    /* renamed from: resubmitPendingTxs$lambda-16 */
    public static final h0 m1699resubmitPendingTxs$lambda16(StellarTxRepository this$0, final List transactions) {
        int r;
        b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transactions, "transactions");
        l.a.a.a("Stellar: unconfirmed signed transactions " + transactions.size() + TokenParser.SP + transactions, new Object[0]);
        r = kotlin.a0.s.r(transactions, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = transactions.iterator();
        while (it.hasNext()) {
            StellarSignedTx stellarSignedTx = (StellarSignedTx) it.next();
            arrayList.add(this$0.getWalletService().submitSignedTransaction(stellarSignedTx.getSignedTransactionData(), stellarSignedTx.getNetwork().isTestnet()));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.StellarTxRepository$resubmitPendingTxs$lambda-16$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it2) {
                        if (obj instanceof x) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.u(transactions, (List) obj);
            }
        });
    }

    /* renamed from: resubmitPendingTxs$lambda-16$lambda-15 */
    public static final List m1700resubmitPendingTxs$lambda16$lambda15(List transactions, List it) {
        kotlin.jvm.internal.m.g(transactions, "$transactions");
        kotlin.jvm.internal.m.g(it, "it");
        return transactions;
    }

    /* renamed from: resubmitPendingTxs$lambda-20 */
    public static final h0 m1701resubmitPendingTxs$lambda20(StellarTxRepository this$0, List transactions) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transactions, "transactions");
        r = kotlin.a0.s.r(transactions, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = transactions.iterator();
        while (it.hasNext()) {
            StellarSignedTx stellarSignedTx = (StellarSignedTx) it.next();
            b0 onErrorReturn = this$0.getWalletService().getTransactionResult(stellarSignedTx.getTxHash(), stellarSignedTx.getNetwork().isTestnet()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.r
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return StellarTxRepository.r((com.coinbase.walletengine.Optional) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return StellarTxRepository.c((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "walletService.getTransactionResult(tx.txHash, tx.network.isTestnet)\n                    .map { Optional(it.value) }\n                    .onErrorReturn { Optional(null) }");
            h.c.t0.e eVar = h.c.t0.e.a;
            b0 just = b0.just(stellarSignedTx);
            kotlin.jvm.internal.m.f(just, "just(tx)");
            arrayList.add(eVar.a(onErrorReturn, just));
        }
        h.c.t0.e eVar2 = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            b0 just2 = b0.just(g2);
            kotlin.jvm.internal.m.f(just2, "just(emptyList())");
            return just2;
        }
        b0 zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.StellarTxRepository$resubmitPendingTxs$lambda-20$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : it2) {
                    if (obj instanceof kotlin.o) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: resubmitPendingTxs$lambda-20$lambda-19$lambda-17 */
    public static final Optional m1702resubmitPendingTxs$lambda20$lambda19$lambda17(com.coinbase.walletengine.Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(it.getValue());
    }

    /* renamed from: resubmitPendingTxs$lambda-20$lambda-19$lambda-18 */
    public static final Optional m1703resubmitPendingTxs$lambda20$lambda19$lambda18(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: resubmitPendingTxs$lambda-25 */
    public static final h0 m1704resubmitPendingTxs$lambda25(final StellarTxRepository this$0, List txResults) {
        List g2;
        h0 onErrorReturn;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(txResults, "txResults");
        ArrayList arrayList = new ArrayList();
        Iterator it = txResults.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            final StellarSignedTx tx = (StellarSignedTx) oVar.b();
            TransactionResult transactionResult = (TransactionResult) ((Optional) oVar.a()).getValue();
            if (transactionResult == null) {
                onErrorReturn = this$0.getWalletService().getLedgerSequence(tx.getNetwork().isTestnet()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.j
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return StellarTxRepository.j(StellarSignedTx.this, this$0, (UInt) obj);
                    }
                });
            } else {
                TxState txState = transactionResult.getSuccessful() ? TxState.CONFIRMED : TxState.FAILED;
                StellarSignedTxDao stellarSignedTxDao = this$0.txDao;
                kotlin.jvm.internal.m.f(tx, "tx");
                onErrorReturn = Single_CoreKt.asUnit(stellarSignedTxDao.save(StellarSignedTx.copy$default(tx, null, null, null, null, 0L, txState, 31, null))).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.o
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return StellarTxRepository.o((Throwable) obj);
                    }
                });
            }
            if (onErrorReturn != null) {
                arrayList.add(onErrorReturn);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            b0 just = b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        b0 zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.StellarTxRepository$resubmitPendingTxs$lambda-25$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                int length = it2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = it2[i2];
                    if (obj != null ? obj instanceof x : true) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: resubmitPendingTxs$lambda-25$lambda-24$lambda-22 */
    public static final h0 m1705resubmitPendingTxs$lambda25$lambda24$lambda22(StellarSignedTx tx, StellarTxRepository this$0, UInt ledgerSequence) {
        int compare;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(ledgerSequence, "ledgerSequence");
        compare = Integer.compare(ledgerSequence.B() ^ Integer.MIN_VALUE, UInt.s((int) tx.getValidBefore()) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            StellarSignedTxDao stellarSignedTxDao = this$0.txDao;
            kotlin.jvm.internal.m.f(tx, "tx");
            return Single_CoreKt.asUnit(stellarSignedTxDao.save(StellarSignedTx.copy$default(tx, null, null, null, null, 0L, TxState.DROPPED, 31, null))).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return StellarTxRepository.g((Throwable) obj);
                }
            });
        }
        return b0.just(x.a);
    }

    /* renamed from: resubmitPendingTxs$lambda-25$lambda-24$lambda-22$lambda-21 */
    public static final x m1706resubmitPendingTxs$lambda25$lambda24$lambda22$lambda21(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    /* renamed from: resubmitPendingTxs$lambda-25$lambda-24$lambda-23 */
    public static final x m1707resubmitPendingTxs$lambda25$lambda24$lambda23(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static /* synthetic */ h0 s(UnsignedTx unsignedTx, StellarTxRepository stellarTxRepository, Optional optional) {
        return m1708signAndSubmit$lambda10(unsignedTx, stellarTxRepository, optional);
    }

    /* renamed from: signAndSubmit$lambda-10 */
    public static final h0 m1708signAndSubmit$lambda10(UnsignedTx unsignedTx, StellarTxRepository this$0, final Optional signedTx) {
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        return this$0.refreshBalances(new RefreshContext(unsignedTx.getNetwork(), 0, RefreshContext.Mode.Quick.INSTANCE, true)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.p(Optional.this, (x) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.t(Optional.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: signAndSubmit$lambda-10$lambda-8 */
    public static final Optional m1709signAndSubmit$lambda10$lambda8(Optional signedTx, x it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-10$lambda-9 */
    public static final Optional m1710signAndSubmit$lambda10$lambda9(Optional signedTx, Throwable it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-11 */
    public static final SignedTx m1711signAndSubmit$lambda11(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        Object value = it.getValue();
        SignedTx signedTx = value instanceof SignedTx ? (SignedTx) value : null;
        if (signedTx != null) {
            return signedTx;
        }
        throw StellarException.UnableToSaveTransaction.INSTANCE;
    }

    /* renamed from: signAndSubmit$lambda-12 */
    public static final SignedTx m1712signAndSubmit$lambda12(StellarTxRepository this$0, UnsignedTx unsignedTx, SignedTx signedTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        this$0.txSubmitsSubject.onNext(Transaction.Companion.createSubmittedTx(unsignedTx, signedTx));
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-5 */
    public static final h0 m1713signAndSubmit$lambda5(StellarTxRepository this$0, StellarUnsignedTx tx, kotlin.o dstr$keyPair$now) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(dstr$keyPair$now, "$dstr$keyPair$now");
        long longValue = ((Long) dstr$keyPair$now.b()).longValue() + 60;
        b0<SignedTransaction> m2083signTransactionu2Zo5yI = this$0.getWalletService().m2083signTransactionu2Zo5yI(tx.getFromAddress(), tx.getRecipientAddress(), tx.getTransferValue(), tx.getEstimatedFee(), UInt.s((int) longValue), tx.getMemoText(), tx.getMemoId(), tx.getMemoHash(), tx.getMemoReturn(), ((KeyPair) dstr$keyPair$now.a()).getPrivateKey(), tx.getNetwork().isTestnet());
        h.c.t0.e eVar = h.c.t0.e.a;
        b0 just = b0.just(Long.valueOf(longValue));
        kotlin.jvm.internal.m.f(just, "just(validBefore)");
        return eVar.a(m2083signTransactionu2Zo5yI, just);
    }

    /* renamed from: signAndSubmit$lambda-6 */
    public static final h0 m1714signAndSubmit$lambda6(StellarTxRepository this$0, StellarUnsignedTx tx, kotlin.o dstr$signedData$validBefore) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(dstr$signedData$validBefore, "$dstr$signedData$validBefore");
        SignedTransaction signedTransaction = (SignedTransaction) dstr$signedData$validBefore.a();
        b0<x> submitSignedTransaction = this$0.getWalletService().submitSignedTransaction(signedTransaction.getData(), tx.getNetwork().isTestnet());
        h.c.t0.e eVar = h.c.t0.e.a;
        b0 just = b0.just(signedTransaction);
        kotlin.jvm.internal.m.f(just, "just(signedData)");
        b0 just2 = b0.just((Long) dstr$signedData$validBefore.b());
        kotlin.jvm.internal.m.f(just2, "just(validBefore)");
        return eVar.b(just, just2, submitSignedTransaction);
    }

    /* renamed from: signAndSubmit$lambda-7 */
    public static final h0 m1715signAndSubmit$lambda7(StellarUnsignedTx tx, StellarTxRepository this$0, kotlin.t dstr$signedData$validBefore$_u24__u24) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$signedData$validBefore$_u24__u24, "$dstr$signedData$validBefore$_u24__u24");
        SignedTransaction signedTransaction = (SignedTransaction) dstr$signedData$validBefore$_u24__u24.a();
        Long validBefore = (Long) dstr$signedData$validBefore$_u24__u24.b();
        String uuid = UUID.randomUUID().toString();
        byte[] data = signedTransaction.getData();
        String hash = signedTransaction.getHash();
        TxState txState = TxState.PENDING;
        Network network = tx.getNetwork();
        kotlin.jvm.internal.m.f(uuid, "toString()");
        kotlin.jvm.internal.m.f(validBefore, "validBefore");
        return this$0.txDao.save(new StellarSignedTx(uuid, data, hash, network, validBefore.longValue(), txState));
    }

    public static /* synthetic */ Optional t(Optional optional, Throwable th) {
        return m1710signAndSubmit$lambda10$lambda9(optional, th);
    }

    /* renamed from: txUpdatesObservable$lambda-0 */
    public static final TxUpdate.Submitted m1716txUpdatesObservable$lambda0(Transaction it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Submitted(it);
    }

    /* renamed from: txUpdatesObservable$lambda-1 */
    public static final boolean m1717txUpdatesObservable$lambda1(StellarSignedTx a, StellarSignedTx b2) {
        kotlin.jvm.internal.m.g(a, "a");
        kotlin.jvm.internal.m.g(b2, "b");
        return kotlin.jvm.internal.m.c(a.getId(), b2.getId()) && a.getState() == b2.getState() && Arrays.equals(a.getSignedTransactionData(), b2.getSignedTransactionData());
    }

    /* renamed from: txUpdatesObservable$lambda-2 */
    public static final TxUpdate.Update m1718txUpdatesObservable$lambda2(StellarSignedTx it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Update(it);
    }

    public static /* synthetic */ List u(List list, List list2) {
        return m1700resubmitPendingTxs$lambda16$lambda15(list, list2);
    }

    public static /* synthetic */ h0 v(StellarTxRepository stellarTxRepository, List list) {
        return m1701resubmitPendingTxs$lambda20(stellarTxRepository, list);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<UnsignedTxResult> generateUnsignedTx(final Wallet wallet, final TransferValue amount, final String recipientAddress, Map<TxMetadataKey, ? extends Object> metadata, BigInteger bigInteger, BigInteger bigInteger2, Integer num) {
        List l2;
        Throwable invalidMemoFieldFormat;
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        TxMetadataKey.Companion companion = TxMetadataKey.Companion;
        Object obj = metadata.get(TxMetadataKey_StellarKt.getMemoText(companion));
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = metadata.get(TxMetadataKey_StellarKt.getMemoId(companion));
        BigInteger bigInteger3 = obj2 instanceof BigInteger ? (BigInteger) obj2 : null;
        Object obj3 = metadata.get(TxMetadataKey_StellarKt.getMemoHash(companion));
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = metadata.get(TxMetadataKey_StellarKt.getMemoReturn(companion));
        String str3 = obj4 instanceof String ? (String) obj4 : null;
        l2 = kotlin.a0.r.l(str, bigInteger3, str2, str3);
        if (l2.size() > 1) {
            invalidMemoFieldFormat = StellarException.MultipleMemoFieldsProvided.INSTANCE;
        } else if (metadata.containsKey(TxMetadataKey_StellarKt.getMemoText(companion)) && str == null) {
            invalidMemoFieldFormat = new StellarException.InvalidMemoFieldFormat(TxMetadataKey_StellarKt.getMemoText(companion));
        } else if (metadata.containsKey(TxMetadataKey_StellarKt.getMemoId(companion)) && bigInteger3 == null) {
            invalidMemoFieldFormat = new StellarException.InvalidMemoFieldFormat(TxMetadataKey_StellarKt.getMemoId(companion));
        } else if (metadata.containsKey(TxMetadataKey_StellarKt.getMemoReturn(companion)) && str3 == null) {
            invalidMemoFieldFormat = new StellarException.InvalidMemoFieldFormat(TxMetadataKey_StellarKt.getMemoReturn(companion));
        } else {
            invalidMemoFieldFormat = (metadata.containsKey(TxMetadataKey_StellarKt.getMemoHash(companion)) && str2 == null) ? new StellarException.InvalidMemoFieldFormat(TxMetadataKey_StellarKt.getMemoHash(companion)) : null;
        }
        if (invalidMemoFieldFormat == null) {
            final String str4 = str;
            final BigInteger bigInteger4 = bigInteger3;
            final String str5 = str2;
            final String str6 = str3;
            b0 map = h.c.t0.e.a.a(getWalletService().estimateFee(wallet.getNetwork().isTestnet()), getWalletService().getBalance(recipientAddress, wallet.getNetwork().isTestnet())).map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.b
                @Override // h.c.m0.n
                public final Object apply(Object obj5) {
                    return StellarTxRepository.b(Wallet.this, amount, recipientAddress, str4, bigInteger4, str5, str6, (kotlin.o) obj5);
                }
            });
            kotlin.jvm.internal.m.f(map, "Singles.zip(estimatedFeeSingle, getRecipientBalanceSingle)\n            .map { (fee, recipientBalance) ->\n                val minimumBalance = wallet.minimumBalance ?: BigInteger.ZERO\n                val maximumTransferAmount = wallet.balance - minimumBalance - fee\n\n                val transferValue = when (amount) {\n                    is TransferValue.Amount -> {\n                        if (amount.value <= maximumTransferAmount) amount.value else maximumTransferAmount\n                    }\n                    is TransferValue.EntireBalance -> maximumTransferAmount\n                }\n\n                val unsignedTx = StellarUnsignedTx(\n                    fromAddress = wallet.primaryAddress,\n                    recipientAddress = recipientAddress,\n                    transferValue = maxOf(transferValue, BigInteger.ZERO),\n                    estimatedFee = fee,\n                    memoText = memoText,\n                    memoId = memoId,\n                    memoHash = memoHash,\n                    memoReturn = memoReturn,\n                    network = wallet.network\n                )\n\n                if (transferValue <= BigInteger.ZERO) {\n                    return@map UnsignedTxResult.Error(unsignedTx, TxException.InsufficientBalance)\n                }\n\n                if (recipientBalance.value == null && transferValue < minimumBalance) {\n                    UnsignedTxResult.Error(unsignedTx, StellarException.RequiresMinimumBalance)\n                } else {\n                    UnsignedTxResult.Success(unsignedTx)\n                }\n            }");
            return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
        }
        b0<UnsignedTxResult> just = b0.just(new UnsignedTxResult.Error(null, invalidMemoFieldFormat));
        kotlin.jvm.internal.m.f(just, "just(UnsignedTxResult.Error(null, it))");
        return just;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getBalance(String str, Network network) {
        return StellarBalanceManaging.DefaultImpls.getBalance(this, str, network);
    }

    @Override // com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getMinimumBalance(Network network) {
        return StellarBalanceManaging.DefaultImpls.getMinimumBalance(this, network);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<TxState> getTxState(String txHash, Network network) {
        kotlin.jvm.internal.m.g(txHash, "txHash");
        kotlin.jvm.internal.m.g(network, "network");
        b0 map = getWalletService().getTransactionResult(txHash, network.isTestnet()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.l((com.coinbase.walletengine.Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletService\n        .getTransactionResult(\n            txHash = txHash,\n            testnet = network.isTestnet\n        )\n        .map { if (it.value?.successful == true) TxState.CONFIRMED else TxState.PENDING }");
        return map;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.s<TxUpdate> getTxUpdatesObservable() {
        return this.txUpdatesObservable;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public WalletDao getWalletDao() {
        return this.walletDao;
    }

    @Override // com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging
    public StellarService getWalletService() {
        return this.walletService;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<Boolean> isValidAddress(String address, Network network) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(network, "network");
        return getWalletService().isAddressValid(address);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    public b0<x> refreshBalances(RefreshContext refreshContext) {
        return StellarBalanceManaging.DefaultImpls.refreshBalances(this, refreshContext);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<x> resubmitPendingTxs(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        b0 flatMap = this.txDao.getPendingTxs(network).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.q(StellarTxRepository.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.v(StellarTxRepository.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.a(StellarTxRepository.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "txDao.getPendingTxs(network)\n        // Submit the transactions using WalletEngine\n        .flatMap { transactions ->\n            Timber.d(\"Stellar: unconfirmed signed transactions ${transactions.size} $transactions\")\n\n            transactions\n                .map { walletService.submitSignedTransaction(it.signedTransactionData, it.network.isTestnet) }\n                .zipOrEmpty()\n                .map { transactions }\n        }\n\n        // Check status of all submitted transactions\n        .flatMap { transactions ->\n            val transactionResultSingles = transactions.map { tx ->\n                val result = walletService.getTransactionResult(tx.txHash, tx.network.isTestnet)\n                    .map { Optional(it.value) }\n                    .onErrorReturn { Optional(null) }\n\n                Singles.zip(result, Single.just(tx))\n            }\n\n            Singles.zipOrEmpty(transactionResultSingles)\n        }\n        .flatMap { txResults ->\n            txResults\n                .mapNotNull { (aResult, tx) ->\n                    val result = aResult.value\n                        ?: return@mapNotNull walletService.getLedgerSequence(tx.network.isTestnet)\n                            .flatMap { ledgerSequence ->\n                                if (ledgerSequence > tx.validBefore.toUInt()) {\n                                    txDao\n                                        .save(tx.copy(state = TxState.DROPPED))\n                                        .asUnit()\n                                        .onErrorReturn { Unit }\n                                } else {\n                                    Single.just(Unit)\n                                }\n                            }\n\n                    val state = if (result.successful) TxState.CONFIRMED else TxState.FAILED\n\n                    txDao\n                        .save(tx.copy(state = state))\n                        .asUnit()\n                        .onErrorReturn { Unit }\n                }\n                .zipOrEmpty()\n        }");
        return Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null));
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<SignedTx> signAndSubmit(final UnsignedTx unsignedTx, String mnemonic, boolean z) {
        kotlin.jvm.internal.m.g(unsignedTx, "unsignedTx");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        final StellarUnsignedTx stellarUnsignedTx = unsignedTx instanceof StellarUnsignedTx ? (StellarUnsignedTx) unsignedTx : null;
        if (stellarUnsignedTx == null) {
            b0<SignedTx> error = b0.error(TxException.UnknownTransactionType.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(TxException.UnknownTransactionType)");
            return error;
        }
        b0 map = h.c.t0.e.a.a(CipherCoreInterface_StellarKt.getStellarWalletKeyPair(this.cipherCore, mnemonic), this.timeAPI.getEpoch()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.m(StellarTxRepository.this, stellarUnsignedTx, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.h(StellarTxRepository.this, stellarUnsignedTx, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.e(StellarUnsignedTx.this, this, (kotlin.t) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.s(UnsignedTx.this, this, (Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.n((Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarTxRepository.i(StellarTxRepository.this, unsignedTx, (SignedTx) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(cipherCore.getStellarWalletKeyPair(mnemonic), timeAPI.getEpoch())\n            // Sign the transaction with the private keys\n            .flatMap { (keyPair, now) ->\n                // add 60 seconds to epoch\n                val validBefore = now + 60L\n\n                val signedDataSingle = walletService.signTransaction(\n                    fromAddress = tx.fromAddress,\n                    toAddress = tx.recipientAddress,\n                    amount = tx.transferValue,\n                    fee = tx.estimatedFee,\n                    validBefore = validBefore.toUInt(),\n                    memoText = tx.memoText,\n                    memoId = tx.memoId,\n                    memoHash = tx.memoHash,\n                    memoReturn = tx.memoReturn,\n                    privateKey = keyPair.privateKey,\n                    testnet = tx.network.isTestnet\n                )\n\n                Singles.zip(signedDataSingle, Single.just(validBefore))\n            }\n\n            // Submit the signed transaction\n            .flatMap { (signedData, validBefore) ->\n                val submitTransactionSingle = walletService.submitSignedTransaction(\n                    signedTxData = signedData.data,\n                    testnet = tx.network.isTestnet\n                )\n\n                Singles.zip(\n                    Single.just(signedData),\n                    Single.just(validBefore),\n                    submitTransactionSingle\n                )\n            }\n\n            // Save transaction\n            .flatMap { (signedData, validBefore, _) ->\n                val transaction = StellarSignedTx(\n                    id = UUID.randomUUID().toString(),\n                    signedTransactionData = signedData.data,\n                    txHash = signedData.hash,\n                    state = TxState.PENDING,\n                    network = tx.network,\n                    validBefore = validBefore\n                )\n\n                txDao.save(tx = transaction)\n            }\n\n            // Refresh balances if needed\n            .flatMap { signedTx ->\n                val context = RefreshContext(\n                    network = unsignedTx.network,\n                    index = 0,\n                    mode = RefreshContext.Mode.Quick,\n                    isForced = true\n                )\n\n                refreshBalances(context).map { signedTx }.onErrorReturn { signedTx }\n            }\n\n            // Ensure the transaction was saved\n            .map { it.value as? SignedTx ?: throw StellarException.UnableToSaveTransaction }\n            .map { signedTx ->\n                txSubmitsSubject.onNext(Transaction.createSubmittedTx(unsignedTx, signedTx))\n                signedTx\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging, com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public XLMConfiguration getConfiguration() {
        return this.configuration;
    }
}