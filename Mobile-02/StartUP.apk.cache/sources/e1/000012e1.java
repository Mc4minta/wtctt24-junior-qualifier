package com.coinbase.wallet.bip44wallets.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.CipherCore_wordListEnglishKt;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception;
import com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging;
import com.coinbase.wallet.bip44wallets.models.BIP44CoinSelection;
import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import com.coinbase.wallet.bip44wallets.models.BIP44Output;
import com.coinbase.wallet.bip44wallets.models.BIP44SignedData;
import com.coinbase.wallet.bip44wallets.models.BIP44SignedTx;
import com.coinbase.wallet.bip44wallets.models.BIP44UTXO;
import com.coinbase.wallet.bip44wallets.models.BIP44UnsignedTx;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.exceptions.TxException;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.AddressType;
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
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: BIP44BasedTxManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bj\u0010kJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J_\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00102\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0004\b%\u0010&J-\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00052\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0014H\u0017¢\u0006\u0004\b,\u0010-J%\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00052\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b0\u0010\u0016J\u001d\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b2\u0010\bR\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u00109\u001a\u0010\u0012\f\u0012\n 8*\u0004\u0018\u00010707068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010<\u001a\u00020;8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010G\u001a\u00020F8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010L\u001a\u00020K8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010Q\u001a\u00020P8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001c\u0010V\u001a\u00020U8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010]\u001a\u0004\b^\u0010_R\u001c\u0010a\u001a\u00020`8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001c\u0010f\u001a\u00020e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i¨\u0006l"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44BasedTxManaging;", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44BalanceManaging;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Ljava/math/BigInteger;", "estimateFeeRate", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "Lcom/coinbase/wallet/core/util/Optional;", "", "getNextChangeAddress", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/AddressType;)Lh/c/b0;", "address", "", "isValidAddress", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "refreshBalances", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signAndSubmit", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;Z)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxState", "Lkotlin/x;", "resubmitPendingTxs", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "kotlin.jvm.PlatformType", "txSubmitsSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "txUpdatesObservable", "Lh/c/s;", "getTxUpdatesObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "getTracer", "()Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "batchBalanceAPI", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "getBatchBalanceAPI", "()Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "walletService", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "getWalletService", "()Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;", "txDao", "Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "configuration", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "getConfiguration", "()Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "<init>", "(Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class BIP44BasedTxManaging implements TxManaging, BIP44BalanceManaging {
    private final AddressDao addressDao;
    private final BatchBalanceAPI batchBalanceAPI;
    private final Blockchain blockchain;
    private final CipherCoreInterface cipherCore;
    private final BIP44Configuration configuration;
    private final StoreInterface store;
    private final Tracing tracer;
    private final BIP44SignedTxDao txDao;
    private final h.c.v0.b<Transaction> txSubmitsSubject;
    private final h.c.s<TxUpdate> txUpdatesObservable;
    private final WalletDao walletDao;
    private final BIP44WalletService walletService;

    /* compiled from: BIP44BasedTxManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TxState.values().length];
            iArr[TxState.CONFIRMED.ordinal()] = 1;
            iArr[TxState.PENDING.ordinal()] = 2;
            iArr[TxState.DROPPED.ordinal()] = 3;
            iArr[TxState.FAILED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BIP44BasedTxManaging(BIP44SignedTxDao txDao, CipherCoreInterface cipherCore, BIP44Configuration configuration, AddressDao addressDao, WalletDao walletDao, BIP44WalletService walletService, StoreInterface store, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
        kotlin.jvm.internal.m.g(txDao, "txDao");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(configuration, "configuration");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(walletService, "walletService");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        kotlin.jvm.internal.m.g(batchBalanceAPI, "batchBalanceAPI");
        this.txDao = txDao;
        this.cipherCore = cipherCore;
        this.configuration = configuration;
        this.addressDao = addressDao;
        this.walletDao = walletDao;
        this.walletService = walletService;
        this.store = store;
        this.tracer = tracer;
        this.batchBalanceAPI = batchBalanceAPI;
        h.c.v0.b<Transaction> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Transaction>()");
        this.txSubmitsSubject = d2;
        this.blockchain = getConfiguration().getBlockchain();
        h.c.s<TxUpdate> merge = h.c.s.merge(d2.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.a((Transaction) obj);
            }
        }), txDao.observeSignedTx().distinctUntilChanged(new h.c.m0.d() { // from class: com.coinbase.wallet.bip44wallets.interfaces.t0
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return BIP44BasedTxManaging.z((BIP44SignedTx) obj, (BIP44SignedTx) obj2);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.y0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.E((BIP44SignedTx) obj);
            }
        }));
        kotlin.jvm.internal.m.f(merge, "merge(\n        txSubmitsSubject.hide().map { TxUpdate.Submitted(it) },\n        txDao.observeSignedTx()\n            .distinctUntilChanged { a, b ->\n                // '==' in kotlin compares value most of the time, but for ByteArray it is referential comparison\n                // that's why cannot simply call distinctUntilChanged() here and rely on equals method generated from\n                // data class to just work its magic. Consumers of this stream trigger many db writes/reads; optimizations\n                // are worthwhile\n                a.id == b.id && a.state == b.state && a.signedTransactionData.contentEquals(b.signedTransactionData)\n            }\n            .map { TxUpdate.Update(it) }\n    )");
        this.txUpdatesObservable = merge;
    }

    public static /* synthetic */ kotlin.x A(Throwable th) {
        return m741resubmitPendingTxs$lambda40$lambda39$lambda38(th);
    }

    public static /* synthetic */ kotlin.x B(Throwable th) {
        return m739resubmitPendingTxs$lambda40$lambda39$lambda36(th);
    }

    public static /* synthetic */ Optional C(Optional optional) {
        return m730getNextChangeAddress$lambda43(optional);
    }

    public static /* synthetic */ h.c.h0 D(BIP44BasedTxManaging bIP44BasedTxManaging, kotlin.o oVar) {
        return m742signAndSubmit$lambda15(bIP44BasedTxManaging, oVar);
    }

    public static /* synthetic */ TxUpdate.Update E(BIP44SignedTx bIP44SignedTx) {
        return m753txUpdatesObservable$lambda2(bIP44SignedTx);
    }

    public static /* synthetic */ TxUpdate.Submitted a(Transaction transaction) {
        return m751txUpdatesObservable$lambda0(transaction);
    }

    public static /* synthetic */ h.c.h0 b(Throwable th) {
        return m725generateUnsignedTx$lambda12(th);
    }

    public static /* synthetic */ SignedTx c(BIP44UnsignedTx bIP44UnsignedTx, Optional optional) {
        return m749signAndSubmit$lambda25(bIP44UnsignedTx, optional);
    }

    public static /* synthetic */ UnsignedTxResult d(Wallet wallet, String str, kotlin.o oVar) {
        return m724generateUnsignedTx$lambda11(wallet, str, oVar);
    }

    public static /* synthetic */ h.c.h0 e(CurrencyCode currencyCode, BIP44BasedTxManaging bIP44BasedTxManaging, List list) {
        return m732resubmitPendingTxs$lambda31(currencyCode, bIP44BasedTxManaging, list);
    }

    private final h.c.b0<BigInteger> estimateFeeRate(Network network) {
        BigInteger bigInteger;
        if (network.isTestnet()) {
            bigInteger = BIP44BasedTxManagingKt.defaultTestnetFee;
            h.c.b0<BigInteger> just = h.c.b0.just(bigInteger);
            kotlin.jvm.internal.m.f(just, "{\n        Single.just(defaultTestnetFee)\n    }");
            return just;
        }
        h.c.b0 map = getWalletService().estimateFee(network.isTestnet()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.o0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.u((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "{\n        walletService.estimateFee(network.isTestnet).map { it.getOrNull(1) ?: throw BIP44Exception.UnableToEstimateFee }\n    }");
        return map;
    }

    /* renamed from: estimateFeeRate$lambda-41 */
    public static final BigInteger m723estimateFeeRate$lambda41(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        BigInteger bigInteger = (BigInteger) kotlin.a0.p.b0(it, 1);
        if (bigInteger != null) {
            return bigInteger;
        }
        throw BIP44Exception.UnableToEstimateFee.INSTANCE;
    }

    public static /* synthetic */ TxState f(Throwable th) {
        return m736resubmitPendingTxs$lambda34$lambda33$lambda32(th);
    }

    public static /* synthetic */ kotlin.x g(Throwable th) {
        return m740resubmitPendingTxs$lambda40$lambda39$lambda37(th);
    }

    /* renamed from: generateUnsignedTx$lambda-11 */
    public static final UnsignedTxResult m724generateUnsignedTx$lambda11(Wallet wallet, String recipientAddress, kotlin.o dstr$coinSelection$changeAddress) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(dstr$coinSelection$changeAddress, "$dstr$coinSelection$changeAddress");
        BIP44CoinSelection coinSelection = (BIP44CoinSelection) dstr$coinSelection$changeAddress.a();
        String str = (String) dstr$coinSelection$changeAddress.b();
        List<BIP44Output> outputs = coinSelection.getOutputs();
        ArrayList<BIP44Output> arrayList = new ArrayList();
        for (Object obj : outputs) {
            if (!kotlin.jvm.internal.m.c(((BIP44Output) obj).getAddress(), str)) {
                arrayList.add(obj);
            }
        }
        BigInteger bigInteger = BigInteger.ZERO;
        BigInteger transferValue = bigInteger;
        for (BIP44Output bIP44Output : arrayList) {
            kotlin.jvm.internal.m.f(transferValue, "prev");
            transferValue = transferValue.add(bIP44Output.getValue());
            kotlin.jvm.internal.m.f(transferValue, "this.add(other)");
        }
        Blockchain blockchain = wallet.getBlockchain();
        kotlin.jvm.internal.m.f(coinSelection, "coinSelection");
        String primaryAddress = wallet.getPrimaryAddress();
        kotlin.jvm.internal.m.f(transferValue, "transferValue");
        return new UnsignedTxResult.Success(new BIP44UnsignedTx(blockchain, coinSelection, primaryAddress, recipientAddress, transferValue, wallet.getCurrencyCode(), wallet.getNetwork()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0023, code lost:
        if (r0 == true) goto L7;
     */
    /* renamed from: generateUnsignedTx$lambda-12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final h.c.h0 m725generateUnsignedTx$lambda12(java.lang.Throwable r6) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.m.g(r6, r0)
            boolean r0 = r6 instanceof com.coinbase.walletengine.WalletEngineException
            r1 = 0
            if (r0 == 0) goto Le
            r0 = r6
            com.coinbase.walletengine.WalletEngineException r0 = (com.coinbase.walletengine.WalletEngineException) r0
            goto Lf
        Le:
            r0 = r1
        Lf:
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L15
        L13:
            r2 = r3
            goto L25
        L15:
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L1c
            goto L13
        L1c:
            r4 = 2
            java.lang.String r5 = "unable to select coins"
            boolean r0 = kotlin.l0.o.V(r0, r5, r3, r4, r1)
            if (r0 != r2) goto L13
        L25:
            if (r2 == 0) goto L2a
            com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception$UnableToSelectCoins r6 = com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception.UnableToSelectCoins.INSTANCE
            throw r6
        L2a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedTxManaging.m725generateUnsignedTx$lambda12(java.lang.Throwable):h.c.h0");
    }

    /* renamed from: generateUnsignedTx$lambda-6 */
    public static final h.c.h0 m726generateUnsignedTx$lambda6(BIP44BasedTxManaging this$0, Wallet wallet, List addresses) {
        int r;
        List<List<String>> N;
        int r2;
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(addresses, "addresses");
        h.c.b0<Optional<String>> nextChangeAddress = this$0.getNextChangeAddress(wallet.getBlockchain(), wallet.getCurrencyCode(), wallet.getNetwork(), this$0.getConfiguration().getDefaultReceiveType());
        r = kotlin.a0.s.r(addresses, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = addresses.iterator();
        while (it.hasNext()) {
            arrayList.add(((Address) it.next()).getAddress());
        }
        N = kotlin.a0.z.N(arrayList, 5);
        r2 = kotlin.a0.s.r(N, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (List<String> list : N) {
            arrayList2.add(this$0.getWalletService().getUnspentTxs(list, wallet.getNetwork().isTestnet()));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList2.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList2, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedTxManaging$generateUnsignedTx$lambda-6$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : it2) {
                        if (obj instanceof List) {
                            arrayList3.add(obj);
                        }
                    }
                    return arrayList3;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0 map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.s0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.y((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "addressChunks.map { walletService.getUnspentTxs(it, wallet.network.isTestnet) }\n                .zipOrEmpty()\n                .map { it.flatten() }");
        return eVar.b(this$0.estimateFeeRate(wallet.getNetwork()), map, nextChangeAddress);
    }

    /* renamed from: generateUnsignedTx$lambda-6$lambda-5 */
    public static final List m727generateUnsignedTx$lambda6$lambda5(List it) {
        List u;
        kotlin.jvm.internal.m.g(it, "it");
        u = kotlin.a0.s.u(it);
        return u;
    }

    /* renamed from: generateUnsignedTx$lambda-8 */
    public static final h.c.h0 m728generateUnsignedTx$lambda8(BIP44BasedTxManaging this$0, TransferValue amount, String recipientAddress, Wallet wallet, kotlin.t dstr$feeRate$utxos$changeAddressOptional) {
        h.c.b0<BIP44CoinSelection> generateCoinSelection;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(dstr$feeRate$utxos$changeAddressOptional, "$dstr$feeRate$utxos$changeAddressOptional");
        BigInteger feeRate = (BigInteger) dstr$feeRate$utxos$changeAddressOptional.a();
        List<BIP44UTXO> utxos = (List) dstr$feeRate$utxos$changeAddressOptional.b();
        String str = (String) ((Optional) dstr$feeRate$utxos$changeAddressOptional.c()).getValue();
        if (str != null) {
            BIP44WalletService walletService = this$0.getWalletService();
            if (amount instanceof TransferValue.EntireBalance) {
                kotlin.jvm.internal.m.f(utxos, "utxos");
                kotlin.jvm.internal.m.f(feeRate, "feeRate");
                generateCoinSelection = walletService.generateCoinSweep(utxos, recipientAddress, feeRate, wallet.getNetwork().isTestnet());
            } else if (amount instanceof TransferValue.Amount) {
                kotlin.jvm.internal.m.f(utxos, "utxos");
                BigInteger value = ((TransferValue.Amount) amount).getValue();
                kotlin.jvm.internal.m.f(feeRate, "feeRate");
                generateCoinSelection = walletService.generateCoinSelection(utxos, recipientAddress, str, value, feeRate, wallet.getNetwork().isTestnet());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just(str);
            kotlin.jvm.internal.m.f(just, "just(changeAddress)");
            return eVar.a(generateCoinSelection, just);
        }
        throw BIP44Exception.ChangeAddressNotFound.INSTANCE;
    }

    private final h.c.b0<Optional<String>> getNextChangeAddress(final Blockchain blockchain, final CurrencyCode currencyCode, final Network network, final AddressType addressType) {
        h.c.b0<Optional<String>> map = getAddressDao().getFirstUnusedAddress(blockchain, currencyCode, network, addressType, true).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.h0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.n(BIP44BasedTxManaging.this, blockchain, currencyCode, network, addressType, (Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.w0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.C((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "addressDao\n        .getFirstUnusedAddress(\n            blockchain = blockchain,\n            currencyCode = currencyCode,\n            addressType = addressType,\n            isChangeAddress = true,\n            network = network\n        )\n        .flatMap {\n            if (it.value != null) {\n                return@flatMap Single.just(Optional(it.value))\n            }\n\n            addressDao.getLatestAddress(\n                blockchain = blockchain,\n                currencyCode = currencyCode,\n                addressType = addressType,\n                isChangeAddress = true,\n                network = network\n            )\n        }\n        .map { Optional(it.value?.address) }");
        return map;
    }

    /* renamed from: getNextChangeAddress$lambda-42 */
    public static final h.c.h0 m729getNextChangeAddress$lambda42(BIP44BasedTxManaging this$0, Blockchain blockchain, CurrencyCode currencyCode, Network network, AddressType addressType, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(addressType, "$addressType");
        kotlin.jvm.internal.m.g(it, "it");
        if (it.getValue() != null) {
            return h.c.b0.just(new Optional(it.getValue()));
        }
        return this$0.getAddressDao().getLatestAddress(blockchain, currencyCode, network, addressType, true);
    }

    /* renamed from: getNextChangeAddress$lambda-43 */
    public static final Optional m730getNextChangeAddress$lambda43(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        Address address = (Address) it.getValue();
        return new Optional(address == null ? null : address.getAddress());
    }

    /* renamed from: getTxState$lambda-27 */
    public static final TxState m731getTxState$lambda27(TxState it) {
        kotlin.jvm.internal.m.g(it, "it");
        TxState txState = TxState.CONFIRMED;
        return it == txState ? txState : TxState.PENDING;
    }

    public static /* synthetic */ h.c.h0 h(BIP44BasedTxManaging bIP44BasedTxManaging, Wallet wallet, List list) {
        return m726generateUnsignedTx$lambda6(bIP44BasedTxManaging, wallet, list);
    }

    public static /* synthetic */ h.c.h0 i(BIP44UnsignedTx bIP44UnsignedTx, BIP44BasedTxManaging bIP44BasedTxManaging, kotlin.o oVar) {
        return m746signAndSubmit$lambda24(bIP44UnsignedTx, bIP44BasedTxManaging, oVar);
    }

    public static /* synthetic */ BIP44SignedTx j(BIP44SignedTx bIP44SignedTx, Throwable th) {
        return m734resubmitPendingTxs$lambda31$lambda30$lambda29(bIP44SignedTx, th);
    }

    public static /* synthetic */ h.c.h0 k(BIP44UnsignedTx bIP44UnsignedTx, BIP44BasedTxManaging bIP44BasedTxManaging, kotlin.t tVar) {
        return m745signAndSubmit$lambda21(bIP44UnsignedTx, bIP44BasedTxManaging, tVar);
    }

    public static /* synthetic */ Optional l(Optional optional, Throwable th) {
        return m748signAndSubmit$lambda24$lambda23(optional, th);
    }

    public static /* synthetic */ SignedTx m(BIP44BasedTxManaging bIP44BasedTxManaging, UnsignedTx unsignedTx, SignedTx signedTx) {
        return m750signAndSubmit$lambda26(bIP44BasedTxManaging, unsignedTx, signedTx);
    }

    public static /* synthetic */ h.c.h0 n(BIP44BasedTxManaging bIP44BasedTxManaging, Blockchain blockchain, CurrencyCode currencyCode, Network network, AddressType addressType, Optional optional) {
        return m729getNextChangeAddress$lambda42(bIP44BasedTxManaging, blockchain, currencyCode, network, addressType, optional);
    }

    public static /* synthetic */ h.c.h0 o(BIP44BasedTxManaging bIP44BasedTxManaging, List list) {
        return m737resubmitPendingTxs$lambda40(bIP44BasedTxManaging, list);
    }

    public static /* synthetic */ h.c.h0 p(BIP44BasedTxManaging bIP44BasedTxManaging, TransferValue transferValue, String str, Wallet wallet, kotlin.t tVar) {
        return m728generateUnsignedTx$lambda8(bIP44BasedTxManaging, transferValue, str, wallet, tVar);
    }

    public static /* synthetic */ h.c.h0 q(BIP44BasedTxManaging bIP44BasedTxManaging, BIP44UnsignedTx bIP44UnsignedTx, BIP44SignedData bIP44SignedData) {
        return m744signAndSubmit$lambda20(bIP44BasedTxManaging, bIP44UnsignedTx, bIP44SignedData);
    }

    public static /* synthetic */ Optional r(Optional optional, kotlin.x xVar) {
        return m747signAndSubmit$lambda24$lambda22(optional, xVar);
    }

    /* renamed from: resubmitPendingTxs$lambda-31 */
    public static final h.c.h0 m732resubmitPendingTxs$lambda31(CurrencyCode currencyCode, BIP44BasedTxManaging this$0, List transactions) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transactions, "transactions");
        l.a.a.a('[' + currencyCode + "] unconfirmed signed transactions " + transactions + ".size " + transactions, new Object[0]);
        r = kotlin.a0.s.r(transactions, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = transactions.iterator();
        while (it.hasNext()) {
            final BIP44SignedTx bIP44SignedTx = (BIP44SignedTx) it.next();
            h.c.b0<R> map = this$0.getWalletService().submitTx(bIP44SignedTx.getSignedTransactionData(), bIP44SignedTx.getNetwork().isTestnet()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.p0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BasedTxManaging.v(BIP44SignedTx.this, (kotlin.x) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "walletService.submitTx(signedTxData, tx.network.isTestnet)\n                        .map { tx }");
            arrayList.add(Single_AnalyticsKt.logError$default(map, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.d0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BasedTxManaging.j(BIP44SignedTx.this, (Throwable) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedTxManaging$resubmitPendingTxs$lambda-31$$inlined$zipOrEmpty$1
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
                    if (obj != null ? obj instanceof BIP44SignedTx : true) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: resubmitPendingTxs$lambda-31$lambda-30$lambda-28 */
    public static final BIP44SignedTx m733resubmitPendingTxs$lambda31$lambda30$lambda28(BIP44SignedTx tx, kotlin.x it) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(it, "it");
        return tx;
    }

    /* renamed from: resubmitPendingTxs$lambda-31$lambda-30$lambda-29 */
    public static final BIP44SignedTx m734resubmitPendingTxs$lambda31$lambda30$lambda29(BIP44SignedTx tx, Throwable it) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(it, "it");
        return tx;
    }

    /* renamed from: resubmitPendingTxs$lambda-34 */
    public static final h.c.h0 m735resubmitPendingTxs$lambda34(BIP44BasedTxManaging this$0, List transactions) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transactions, "transactions");
        r = kotlin.a0.s.r(transactions, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = transactions.iterator();
        while (it.hasNext()) {
            BIP44SignedTx bIP44SignedTx = (BIP44SignedTx) it.next();
            h.c.b0 onErrorReturn = Single_AnalyticsKt.logError$default(this$0.getWalletService().getTxStatus(bIP44SignedTx.getTxHash(), bIP44SignedTx.getNetwork().isTestnet()), null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.z
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BasedTxManaging.f((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "walletService.getTxStatus(tx.txHash, tx.network.isTestnet)\n                        .logError()\n                        .onErrorReturn { TxState.PENDING }");
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just(bIP44SignedTx);
            kotlin.jvm.internal.m.f(just, "just(tx)");
            arrayList.add(eVar.a(just, onErrorReturn));
        }
        h.c.t0.e eVar2 = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just2 = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just2, "just(emptyList())");
            return just2;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedTxManaging$resubmitPendingTxs$lambda-34$$inlined$zipOrEmpty$1
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

    /* renamed from: resubmitPendingTxs$lambda-34$lambda-33$lambda-32 */
    public static final TxState m736resubmitPendingTxs$lambda34$lambda33$lambda32(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return TxState.PENDING;
    }

    /* renamed from: resubmitPendingTxs$lambda-40 */
    public static final h.c.h0 m737resubmitPendingTxs$lambda40(BIP44BasedTxManaging this$0, List txStatus) {
        int r;
        List g2;
        BIP44SignedTx copy;
        h.c.b0<kotlin.x> onErrorReturn;
        BIP44SignedTx copy2;
        BIP44SignedTx copy3;
        BIP44SignedTx copy4;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(txStatus, "txStatus");
        r = kotlin.a0.s.r(txStatus, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = txStatus.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            BIP44SignedTx tx = (BIP44SignedTx) oVar.a();
            TxState txState = (TxState) oVar.b();
            int i2 = txState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[txState.ordinal()];
            if (i2 != -1) {
                if (i2 == 1) {
                    BIP44SignedTxDao bIP44SignedTxDao = this$0.txDao;
                    kotlin.jvm.internal.m.f(tx, "tx");
                    copy3 = tx.copy((r18 & 1) != 0 ? tx.getId() : null, (r18 & 2) != 0 ? tx.signedTransactionData : null, (r18 & 4) != 0 ? tx.getTxHash() : null, (r18 & 8) != 0 ? tx.network : null, (r18 & 16) != 0 ? tx.getCurrencyCode() : null, (r18 & 32) != 0 ? tx.getBlockchain() : null, (r18 & 64) != 0 ? tx.getState() : TxState.CONFIRMED, (r18 & 128) != 0 ? tx.notFoundCount : 0);
                    onErrorReturn = Single_CoreKt.asUnit(bIP44SignedTxDao.save(copy3)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.n0
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return BIP44BasedTxManaging.t((Throwable) obj);
                        }
                    });
                } else if (i2 == 2) {
                    BIP44SignedTxDao bIP44SignedTxDao2 = this$0.txDao;
                    kotlin.jvm.internal.m.f(tx, "tx");
                    copy4 = tx.copy((r18 & 1) != 0 ? tx.getId() : null, (r18 & 2) != 0 ? tx.signedTransactionData : null, (r18 & 4) != 0 ? tx.getTxHash() : null, (r18 & 8) != 0 ? tx.network : null, (r18 & 16) != 0 ? tx.getCurrencyCode() : null, (r18 & 32) != 0 ? tx.getBlockchain() : null, (r18 & 64) != 0 ? tx.getState() : null, (r18 & 128) != 0 ? tx.notFoundCount : 0);
                    onErrorReturn = Single_CoreKt.asUnit(bIP44SignedTxDao2.save(copy4)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.v0
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return BIP44BasedTxManaging.B((Throwable) obj);
                        }
                    });
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    onErrorReturn = h.c.b0.just(kotlin.x.a);
                }
                kotlin.jvm.internal.m.f(onErrorReturn, "when (status) {\n                            TxState.CONFIRMED -> {\n                                txDao.save(tx.copy(state = TxState.CONFIRMED))\n                                    .asUnit()\n                                    .onErrorReturn { Unit }\n                            }\n                            TxState.PENDING -> {\n                                txDao.save(tx.copy(notFoundCount = 0))\n                                    .asUnit()\n                                    .onErrorReturn { Unit }\n                            }\n                            TxState.DROPPED,\n                            null -> {\n                                if (tx.notFoundCount >= configuration.maxSubmissionAttempts) {\n                                    txDao.save(tx.copy(state = TxState.DROPPED))\n                                        .asUnit()\n                                        .onErrorReturn { Unit }\n                                } else {\n                                    txDao.save(tx.copy(notFoundCount = tx.notFoundCount + 1))\n                                        .asUnit()\n                                        .onErrorReturn { Unit }\n                                }\n                            }\n                            TxState.FAILED -> { Single.just(Unit) }\n                        }");
                arrayList.add(onErrorReturn);
            }
            if (tx.getNotFoundCount() >= this$0.getConfiguration().getMaxSubmissionAttempts()) {
                BIP44SignedTxDao bIP44SignedTxDao3 = this$0.txDao;
                kotlin.jvm.internal.m.f(tx, "tx");
                copy2 = tx.copy((r18 & 1) != 0 ? tx.getId() : null, (r18 & 2) != 0 ? tx.signedTransactionData : null, (r18 & 4) != 0 ? tx.getTxHash() : null, (r18 & 8) != 0 ? tx.network : null, (r18 & 16) != 0 ? tx.getCurrencyCode() : null, (r18 & 32) != 0 ? tx.getBlockchain() : null, (r18 & 64) != 0 ? tx.getState() : TxState.DROPPED, (r18 & 128) != 0 ? tx.notFoundCount : 0);
                onErrorReturn = Single_CoreKt.asUnit(bIP44SignedTxDao3.save(copy2)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.a0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return BIP44BasedTxManaging.g((Throwable) obj);
                    }
                });
            } else {
                BIP44SignedTxDao bIP44SignedTxDao4 = this$0.txDao;
                kotlin.jvm.internal.m.f(tx, "tx");
                copy = tx.copy((r18 & 1) != 0 ? tx.getId() : null, (r18 & 2) != 0 ? tx.signedTransactionData : null, (r18 & 4) != 0 ? tx.getTxHash() : null, (r18 & 8) != 0 ? tx.network : null, (r18 & 16) != 0 ? tx.getCurrencyCode() : null, (r18 & 32) != 0 ? tx.getBlockchain() : null, (r18 & 64) != 0 ? tx.getState() : null, (r18 & 128) != 0 ? tx.notFoundCount : tx.getNotFoundCount() + 1);
                onErrorReturn = Single_CoreKt.asUnit(bIP44SignedTxDao4.save(copy)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.u0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return BIP44BasedTxManaging.A((Throwable) obj);
                    }
                });
            }
            kotlin.jvm.internal.m.f(onErrorReturn, "when (status) {\n                            TxState.CONFIRMED -> {\n                                txDao.save(tx.copy(state = TxState.CONFIRMED))\n                                    .asUnit()\n                                    .onErrorReturn { Unit }\n                            }\n                            TxState.PENDING -> {\n                                txDao.save(tx.copy(notFoundCount = 0))\n                                    .asUnit()\n                                    .onErrorReturn { Unit }\n                            }\n                            TxState.DROPPED,\n                            null -> {\n                                if (tx.notFoundCount >= configuration.maxSubmissionAttempts) {\n                                    txDao.save(tx.copy(state = TxState.DROPPED))\n                                        .asUnit()\n                                        .onErrorReturn { Unit }\n                                } else {\n                                    txDao.save(tx.copy(notFoundCount = tx.notFoundCount + 1))\n                                        .asUnit()\n                                        .onErrorReturn { Unit }\n                                }\n                            }\n                            TxState.FAILED -> { Single.just(Unit) }\n                        }");
            arrayList.add(onErrorReturn);
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedTxManaging$resubmitPendingTxs$lambda-40$$inlined$zipOrEmpty$1
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
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = it2[i3];
                    if (obj != null ? obj instanceof kotlin.x : true) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: resubmitPendingTxs$lambda-40$lambda-39$lambda-35 */
    public static final kotlin.x m738resubmitPendingTxs$lambda40$lambda39$lambda35(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: resubmitPendingTxs$lambda-40$lambda-39$lambda-36 */
    public static final kotlin.x m739resubmitPendingTxs$lambda40$lambda39$lambda36(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: resubmitPendingTxs$lambda-40$lambda-39$lambda-37 */
    public static final kotlin.x m740resubmitPendingTxs$lambda40$lambda39$lambda37(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: resubmitPendingTxs$lambda-40$lambda-39$lambda-38 */
    public static final kotlin.x m741resubmitPendingTxs$lambda40$lambda39$lambda38(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    public static /* synthetic */ TxState s(TxState txState) {
        return m731getTxState$lambda27(txState);
    }

    /* renamed from: signAndSubmit$lambda-15 */
    public static final h.c.h0 m742signAndSubmit$lambda15(BIP44BasedTxManaging this$0, kotlin.o dstr$addresses$seed) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$addresses$seed, "$dstr$addresses$seed");
        List<Address> addresses = (List) dstr$addresses$seed.a();
        byte[] seed = (byte[]) dstr$addresses$seed.b();
        kotlin.jvm.internal.m.f(addresses, "addresses");
        r = kotlin.a0.s.r(addresses, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Address address : addresses) {
            CipherCoreInterface cipherCoreInterface = this$0.cipherCore;
            kotlin.jvm.internal.m.f(seed, "seed");
            h.c.b0<KeyPair> deriveKeyPair = cipherCoreInterface.deriveKeyPair(seed, address.getDerivationPath());
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just(address.getAddress());
            kotlin.jvm.internal.m.f(just, "just(address.address)");
            arrayList.add(eVar.a(just, deriveKeyPair));
        }
        h.c.t0.e eVar2 = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just2 = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just2, "just(emptyList())");
            return just2;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedTxManaging$signAndSubmit$lambda-15$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it, "it");
                if (it.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : it) {
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

    /* renamed from: signAndSubmit$lambda-17 */
    public static final h.c.h0 m743signAndSubmit$lambda17(BIP44BasedTxManaging this$0, BIP44UnsignedTx tx, List entries) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(entries, "entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            Object c2 = oVar.c();
            kotlin.jvm.internal.m.f(c2, "item.first");
            linkedHashMap.put(c2, ((KeyPair) oVar.d()).getPrivateKey());
        }
        return this$0.getWalletService().signTx(linkedHashMap, tx.getCoinSelection(), tx.getNetwork().isTestnet());
    }

    /* renamed from: signAndSubmit$lambda-20 */
    public static final h.c.h0 m744signAndSubmit$lambda20(BIP44BasedTxManaging this$0, BIP44UnsignedTx tx, BIP44SignedData signedData) {
        int r;
        int r2;
        Set N0;
        List I0;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(signedData, "signedData");
        h.c.b0<kotlin.x> submitTx = this$0.getWalletService().submitTx(signedData.getData(), tx.getNetwork().isTestnet());
        List<BIP44Output> outputs = tx.getCoinSelection().getOutputs();
        r = kotlin.a0.s.r(outputs, 10);
        ArrayList arrayList = new ArrayList(r);
        for (BIP44Output bIP44Output : outputs) {
            arrayList.add(bIP44Output.getAddress());
        }
        List<BIP44UTXO> inputs = tx.getCoinSelection().getInputs();
        r2 = kotlin.a0.s.r(inputs, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (BIP44UTXO bip44utxo : inputs) {
            arrayList2.add(bip44utxo.getAddress());
        }
        N0 = kotlin.a0.z.N0(arrayList, arrayList2);
        I0 = kotlin.a0.z.I0(N0);
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(signedData);
        kotlin.jvm.internal.m.f(just, "just(signedData)");
        h.c.b0 just2 = h.c.b0.just(I0);
        kotlin.jvm.internal.m.f(just2, "just(refreshableAddresses)");
        return eVar.b(just, submitTx, just2);
    }

    /* renamed from: signAndSubmit$lambda-21 */
    public static final h.c.h0 m745signAndSubmit$lambda21(BIP44UnsignedTx tx, BIP44BasedTxManaging this$0, kotlin.t dstr$signedData$_u24__u24$refreshableAddresses) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$signedData$_u24__u24$refreshableAddresses, "$dstr$signedData$_u24__u24$refreshableAddresses");
        BIP44SignedData bIP44SignedData = (BIP44SignedData) dstr$signedData$_u24__u24$refreshableAddresses.a();
        String uuid = UUID.randomUUID().toString();
        byte[] data = bIP44SignedData.getData();
        String hash = bIP44SignedData.getHash();
        TxState txState = TxState.PENDING;
        Network network = tx.getNetwork();
        CurrencyCode currencyCode = tx.getCurrencyCode();
        Blockchain blockchain = tx.getBlockchain();
        kotlin.jvm.internal.m.f(uuid, "toString()");
        BIP44SignedTx bIP44SignedTx = new BIP44SignedTx(uuid, data, hash, network, currencyCode, blockchain, txState, 0);
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0<Optional<BIP44SignedTx>> save = this$0.txDao.save(bIP44SignedTx);
        h.c.b0 just = h.c.b0.just((List) dstr$signedData$_u24__u24$refreshableAddresses.c());
        kotlin.jvm.internal.m.f(just, "just(refreshableAddresses)");
        return eVar.a(save, just);
    }

    /* renamed from: signAndSubmit$lambda-24 */
    public static final h.c.h0 m746signAndSubmit$lambda24(BIP44UnsignedTx tx, BIP44BasedTxManaging this$0, kotlin.o dstr$signedTx$refreshableAddresses) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$signedTx$refreshableAddresses, "$dstr$signedTx$refreshableAddresses");
        final Optional optional = (Optional) dstr$signedTx$refreshableAddresses.a();
        List refreshableAddresses = (List) dstr$signedTx$refreshableAddresses.b();
        Network network = tx.getNetwork();
        kotlin.jvm.internal.m.f(refreshableAddresses, "refreshableAddresses");
        return this$0.refreshBalances(new RefreshContext(network, null, new RefreshContext.Mode.Subset(refreshableAddresses), true, 2, null)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.l0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.r(Optional.this, (kotlin.x) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.f0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.l(Optional.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: signAndSubmit$lambda-24$lambda-22 */
    public static final Optional m747signAndSubmit$lambda24$lambda22(Optional optional, kotlin.x it) {
        kotlin.jvm.internal.m.g(it, "it");
        return optional;
    }

    /* renamed from: signAndSubmit$lambda-24$lambda-23 */
    public static final Optional m748signAndSubmit$lambda24$lambda23(Optional optional, Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return optional;
    }

    /* renamed from: signAndSubmit$lambda-25 */
    public static final SignedTx m749signAndSubmit$lambda25(BIP44UnsignedTx tx, Optional it) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(it, "it");
        Object value = it.getValue();
        SignedTx signedTx = value instanceof SignedTx ? (SignedTx) value : null;
        if (signedTx != null) {
            return signedTx;
        }
        throw new TxException.UnableToSaveTx(tx.getBlockchain());
    }

    /* renamed from: signAndSubmit$lambda-26 */
    public static final SignedTx m750signAndSubmit$lambda26(BIP44BasedTxManaging this$0, UnsignedTx unsignedTx, SignedTx signedTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        this$0.txSubmitsSubject.onNext(Transaction.Companion.createSubmittedTx(unsignedTx, signedTx));
        return signedTx;
    }

    public static /* synthetic */ kotlin.x t(Throwable th) {
        return m738resubmitPendingTxs$lambda40$lambda39$lambda35(th);
    }

    /* renamed from: txUpdatesObservable$lambda-0 */
    public static final TxUpdate.Submitted m751txUpdatesObservable$lambda0(Transaction it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Submitted(it);
    }

    /* renamed from: txUpdatesObservable$lambda-1 */
    public static final boolean m752txUpdatesObservable$lambda1(BIP44SignedTx a, BIP44SignedTx b2) {
        kotlin.jvm.internal.m.g(a, "a");
        kotlin.jvm.internal.m.g(b2, "b");
        return kotlin.jvm.internal.m.c(a.getId(), b2.getId()) && a.getState() == b2.getState() && Arrays.equals(a.getSignedTransactionData(), b2.getSignedTransactionData());
    }

    /* renamed from: txUpdatesObservable$lambda-2 */
    public static final TxUpdate.Update m753txUpdatesObservable$lambda2(BIP44SignedTx it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Update(it);
    }

    public static /* synthetic */ BigInteger u(List list) {
        return m723estimateFeeRate$lambda41(list);
    }

    public static /* synthetic */ BIP44SignedTx v(BIP44SignedTx bIP44SignedTx, kotlin.x xVar) {
        return m733resubmitPendingTxs$lambda31$lambda30$lambda28(bIP44SignedTx, xVar);
    }

    public static /* synthetic */ h.c.h0 w(BIP44BasedTxManaging bIP44BasedTxManaging, List list) {
        return m735resubmitPendingTxs$lambda34(bIP44BasedTxManaging, list);
    }

    public static /* synthetic */ h.c.h0 x(BIP44BasedTxManaging bIP44BasedTxManaging, BIP44UnsignedTx bIP44UnsignedTx, List list) {
        return m743signAndSubmit$lambda17(bIP44BasedTxManaging, bIP44UnsignedTx, list);
    }

    public static /* synthetic */ List y(List list) {
        return m727generateUnsignedTx$lambda6$lambda5(list);
    }

    public static /* synthetic */ boolean z(BIP44SignedTx bIP44SignedTx, BIP44SignedTx bIP44SignedTx2) {
        return m752txUpdatesObservable$lambda1(bIP44SignedTx, bIP44SignedTx2);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<UnsignedTxResult> generateUnsignedTx(final Wallet wallet, final TransferValue amount, final String recipientAddress, Map<TxMetadataKey, ? extends Object> metadata, BigInteger bigInteger, BigInteger bigInteger2, Integer num) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        h.c.b0 onErrorResumeNext = getAddressDao().getAddressesWithBalance(wallet.getBlockchain(), wallet.getCurrencyCode(), wallet.getNetwork()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.h(BIP44BasedTxManaging.this, wallet, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.j0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.p(BIP44BasedTxManaging.this, amount, recipientAddress, wallet, (kotlin.t) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.d(Wallet.this, recipientAddress, (kotlin.o) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.b((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "addressDao\n        .getAddressesWithBalance(\n            wallet.blockchain,\n            wallet.currencyCode,\n            wallet.network\n        )\n\n        // Estimate the transaction fee, get the user's UTXOs, and get the user's change address\n        .flatMap { addresses ->\n            val nextChangeAddressSingle = getNextChangeAddress(\n                blockchain = wallet.blockchain,\n                currencyCode = wallet.currencyCode,\n                network = wallet.network,\n                addressType = configuration.defaultReceiveType\n            )\n\n            val addressChunks = addresses.map { it.address }.chunked(5)\n            val getUnspentTxsSingle = addressChunks.map { walletService.getUnspentTxs(it, wallet.network.isTestnet) }\n                .zipOrEmpty()\n                .map { it.flatten() }\n\n            Singles.zip(\n                estimateFeeRate(wallet.network),\n                getUnspentTxsSingle,\n                nextChangeAddressSingle\n            )\n        }\n\n        // Generate the coin selection\n        .flatMap { (feeRate, utxos, changeAddressOptional) ->\n            val changeAddress = changeAddressOptional.value\n                ?: throw BIP44Exception.ChangeAddressNotFound\n\n            val coinSelectionSingle = walletService.run {\n                when (amount) {\n                    is TransferValue.EntireBalance -> generateCoinSweep(\n                        utxos = utxos,\n                        toAddress = recipientAddress,\n                        feeRate = feeRate,\n                        testnet = wallet.network.isTestnet\n                    )\n\n                    is TransferValue.Amount -> generateCoinSelection(\n                        utxos = utxos,\n                        toAddress = recipientAddress,\n                        changeAddress = changeAddress,\n                        amount = amount.value,\n                        feeRate = feeRate,\n                        testnet = wallet.network.isTestnet\n                    )\n                }\n            }\n\n            Singles.zip(coinSelectionSingle, Single.just(changeAddress))\n        }\n\n        // Return an BIP44UnsignedTx with the coin selection\n        .map<UnsignedTxResult> { (coinSelection, changeAddress) ->\n            val transferValue = coinSelection.outputs\n                .filter { it.address != changeAddress }\n                .fold(BigInteger.ZERO) { prev, next -> prev + next.value }\n\n            val unsignedTx = BIP44UnsignedTx(\n                blockchain = wallet.blockchain,\n                coinSelection = coinSelection,\n                fromAddress = wallet.primaryAddress,\n                recipientAddress = recipientAddress,\n                transferValue = transferValue,\n                currencyCode = wallet.currencyCode,\n                network = wallet.network\n            )\n\n            UnsignedTxResult.Success(unsignedTx)\n        }\n        .onErrorResumeNext {\n            if ((it as? WalletEngineException)?.message?.contains(\"unable to select coins\") == true) {\n                throw BIP44Exception.UnableToSelectCoins\n            }\n\n            throw it\n        }");
        return Single_AnalyticsKt.logError$default(onErrorResumeNext, null, null, 3, null);
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public BatchBalanceAPI getBatchBalanceAPI() {
        return this.batchBalanceAPI;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public StoreInterface getStore() {
        return this.store;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public Tracing getTracer() {
        return this.tracer;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<TxState> getTxState(String txHash, Network network) {
        kotlin.jvm.internal.m.g(txHash, "txHash");
        kotlin.jvm.internal.m.g(network, "network");
        h.c.b0 map = getWalletService().getTxStatus(txHash, network.isTestnet()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.m0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.s((TxState) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletService\n        .getTxStatus(txHash, network.isTestnet)\n        .map { if (it == TxState.CONFIRMED) TxState.CONFIRMED else TxState.PENDING }");
        return map;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.s<TxUpdate> getTxUpdatesObservable() {
        return this.txUpdatesObservable;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public WalletDao getWalletDao() {
        return this.walletDao;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public BIP44WalletService getWalletService() {
        return this.walletService;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<Boolean> isValidAddress(String address, Network network) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(network, "network");
        return getWalletService().isAddressValid(address, network.isTestnet());
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    public h.c.b0<kotlin.x> refreshBalances(RefreshContext refreshContext) {
        return BIP44BalanceManaging.DefaultImpls.refreshBalances(this, refreshContext);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<kotlin.x> resubmitPendingTxs(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        final CurrencyCode currencyCode = getConfiguration().getCurrencyCode();
        h.c.b0 flatMap = this.txDao.getPendingTxs(this.blockchain, currencyCode, network).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.e(CurrencyCode.this, this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.q0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.w(BIP44BasedTxManaging.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.i0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.o(BIP44BasedTxManaging.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "txDao.getPendingTxs(blockchain, currencyCode, network)\n\n            // Resubmit transactions\n            .flatMap { transactions ->\n                Timber.d(\"[$currencyCode] unconfirmed signed transactions $transactions.size $transactions\")\n\n                val submitTxSingles = transactions.map { tx ->\n                    val signedTxData = tx.signedTransactionData\n                    return@map walletService.submitTx(signedTxData, tx.network.isTestnet)\n                        .map { tx }\n                        .logError()\n                        .onErrorReturn { tx }\n                }\n\n                return@flatMap Singles.zipOrEmpty(submitTxSingles)\n            }\n\n            // Check status of all submitted transactions\n            .flatMap { transactions ->\n                val statusSingles = transactions.map { tx ->\n                    val statusSingle = walletService.getTxStatus(tx.txHash, tx.network.isTestnet)\n                        .logError()\n                        .onErrorReturn { TxState.PENDING }\n\n                    return@map Singles.zip(Single.just(tx), statusSingle)\n                }\n\n                return@flatMap Singles.zipOrEmpty(statusSingles)\n            }\n\n            // Update transaction status accordingly\n            .flatMap { txStatus ->\n                txStatus\n                    .map { (tx, status) ->\n                        // If transaction status returns `notFound`. This means 1) The transaction hasn't been added to\n                        // the mempool yet. Or 2) The UTXOs for that transaction have been spent on a different wallet.\n                        // Number (1) is a fine state to be in. Number (2) is not. To fix that, the app will keep track\n                        // of the number of `notFound` status responses and ultimately mark the transaction as failed\n                        // once `maxSubmissionAttempts` is reached.\n                        val updateTxState = when (status) {\n                            TxState.CONFIRMED -> {\n                                txDao.save(tx.copy(state = TxState.CONFIRMED))\n                                    .asUnit()\n                                    .onErrorReturn { Unit }\n                            }\n                            TxState.PENDING -> {\n                                txDao.save(tx.copy(notFoundCount = 0))\n                                    .asUnit()\n                                    .onErrorReturn { Unit }\n                            }\n                            TxState.DROPPED,\n                            null -> {\n                                if (tx.notFoundCount >= configuration.maxSubmissionAttempts) {\n                                    txDao.save(tx.copy(state = TxState.DROPPED))\n                                        .asUnit()\n                                        .onErrorReturn { Unit }\n                                } else {\n                                    txDao.save(tx.copy(notFoundCount = tx.notFoundCount + 1))\n                                        .asUnit()\n                                        .onErrorReturn { Unit }\n                                }\n                            }\n                            TxState.FAILED -> { Single.just(Unit) }\n                        }\n\n                        updateTxState\n                    }\n                    .zipOrEmpty()\n            }");
        return Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null));
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public h.c.b0<Boolean> saveAddress(Blockchain blockchain, CurrencyCode currencyCode, Network network, AddressType addressType, boolean z, int i2, String str, boolean z2) {
        return BIP44BalanceManaging.DefaultImpls.saveAddress(this, blockchain, currencyCode, network, addressType, z, i2, str, z2);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public h.c.b0<SignedTx> signAndSubmit(final UnsignedTx unsignedTx, String mnemonic, boolean z) {
        int r;
        kotlin.jvm.internal.m.g(unsignedTx, "unsignedTx");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        final BIP44UnsignedTx bIP44UnsignedTx = unsignedTx instanceof BIP44UnsignedTx ? (BIP44UnsignedTx) unsignedTx : null;
        if (bIP44UnsignedTx == null) {
            h.c.b0<SignedTx> error = h.c.b0.error(TxException.UnknownTransactionType.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(TxException.UnknownTransactionType)");
            return error;
        }
        List<BIP44UTXO> inputs = bIP44UnsignedTx.getCoinSelection().getInputs();
        r = kotlin.a0.s.r(inputs, 10);
        ArrayList arrayList = new ArrayList(r);
        for (BIP44UTXO bip44utxo : inputs) {
            arrayList.add(bip44utxo.getAddress());
        }
        h.c.b0 map = h.c.t0.e.a.a(getAddressDao().getAddresses(bIP44UnsignedTx.getBlockchain(), bIP44UnsignedTx.getCurrencyCode(), arrayList, bIP44UnsignedTx.getNetwork()), this.cipherCore.seedFromRecoveryPhrase(mnemonic, CipherCore_wordListEnglishKt.getWordListEnglish(CipherCore.Companion))).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.x0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.D(BIP44BasedTxManaging.this, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.r0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.x(BIP44BasedTxManaging.this, bIP44UnsignedTx, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.k0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.q(BIP44BasedTxManaging.this, bIP44UnsignedTx, (BIP44SignedData) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.e0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.k(BIP44UnsignedTx.this, this, (kotlin.t) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.i(BIP44UnsignedTx.this, this, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.c(BIP44UnsignedTx.this, (Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedTxManaging.m(BIP44BasedTxManaging.this, unsignedTx, (SignedTx) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(getAddressesSingle, seedSingle)\n\n            // Pair each address with it's proper private key\n            .flatMap { (addresses, seed) ->\n                val singles = addresses.map { address ->\n                    val deriveKeyPairSingle = cipherCore.deriveKeyPair(\n                        seed = seed,\n                        derivationPath = address.derivationPath\n                    )\n\n                    Singles.zip(Single.just(address.address), deriveKeyPairSingle)\n                }\n\n                Singles.zipOrEmpty(singles)\n            }\n\n            // Sign the transaction with the private keys\n            .flatMap { entries ->\n                val privateKeys = entries.reduceIntoMap(mutableMapOf<String, ByteArray>()) { acc, item ->\n                    acc[item.first] = item.second.privateKey\n                }\n\n                return@flatMap walletService.signTx(\n                    privateKeys = privateKeys,\n                    coinSelection = tx.coinSelection,\n                    testnet = tx.network.isTestnet\n                )\n            }\n\n            // Submit the signed transaction\n            .flatMap { signedData ->\n                val submitTransactionSingle = walletService.submitTx(\n                    signedTxData = signedData.data,\n                    testnet = tx.network.isTestnet\n                )\n\n                val refreshableAddresses = tx.coinSelection.outputs.map { it.address }\n                    .union(tx.coinSelection.inputs.map { it.address })\n                    .toList()\n\n                return@flatMap Singles.zip(\n                    Single.just(signedData),\n                    submitTransactionSingle,\n                    Single.just(refreshableAddresses)\n                )\n            }\n\n            // Save an BIP44SignedTx\n            .flatMap { (signedData, _, refreshableAddresses) ->\n                val signedTx = BIP44SignedTx(\n                    id = UUID.randomUUID().toString(),\n                    signedTransactionData = signedData.data,\n                    txHash = signedData.hash,\n                    state = TxState.PENDING,\n                    network = tx.network,\n                    currencyCode = tx.currencyCode,\n                    notFoundCount = 0,\n                    blockchain = tx.blockchain\n                )\n\n                Singles.zip(txDao.save(signedTx), Single.just(refreshableAddresses))\n            }\n\n            // Refresh balance for all tx addresses\n            .flatMap { (signedTx, refreshableAddresses) ->\n                val context = RefreshContext(\n                    network = tx.network,\n                    mode = RefreshContext.Mode.Subset(refreshableAddresses),\n                    isForced = true\n                )\n\n                refreshBalances(context).map { signedTx }.onErrorReturn { signedTx }\n            }\n\n            // Ensure the transaction was saved\n            .map { it.value as? SignedTx ?: throw TxException.UnableToSaveTx(tx.blockchain) }\n            .map { signedTx ->\n                txSubmitsSubject.onNext(Transaction.createSubmittedTx(unsignedTx, signedTx))\n                signedTx\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging, com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public BIP44Configuration getConfiguration() {
        return this.configuration;
    }
}