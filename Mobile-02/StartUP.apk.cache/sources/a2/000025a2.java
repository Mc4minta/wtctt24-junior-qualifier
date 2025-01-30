package com.coinbase.wallet.ripple.repositories;

import com.appsflyer.internal.referrer.Payload;
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
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.ripple.exceptions.XrpException;
import com.coinbase.wallet.ripple.extensions.CipherCoreInterface_RippleKt;
import com.coinbase.wallet.ripple.extensions.TxMetadataKey_RippleKt;
import com.coinbase.wallet.ripple.extensions.WalletConfiguration_RippleKt;
import com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging;
import com.coinbase.wallet.ripple.models.XRPConfiguration;
import com.coinbase.wallet.ripple.models.XRPSignedTx;
import com.coinbase.wallet.ripple.models.XRPUnsignedTx;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.services.xrp.AccountInfo;
import com.coinbase.walletengine.services.xrp.SignedTransaction;
import com.coinbase.walletengine.services.xrp.TransactionResult;
import com.coinbase.walletengine.services.xrp.TransactionStatus;
import com.coinbase.walletengine.services.xrp.XRPService;
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
import org.apache.http.message.TokenParser;

/* compiled from: XRPTxRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\bW\u0010XJ%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ_\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\bH\u0017¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b%\u0010\nJ\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b'\u0010(R(\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0016@\u0017X\u0097\u0004¢\u0006\u0012\n\u0004\b+\u0010,\u0012\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001c\u00102\u001a\u0002018\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00107\u001a\u0002068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010<\u001a\u00020;8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R$\u0010C\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010A0A0@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010F\u001a\u00020E8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010K\u001a\u00020J8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001c\u0010S\u001a\u00020R8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lcom/coinbase/wallet/ripple/repositories/XRPTxRepository;", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "Lcom/coinbase/wallet/ripple/interfaces/XRPBalanceManaging;", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "", "isValidAddress", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Ljava/math/BigInteger;", "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "refreshBalances", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signAndSubmit", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;Z)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxState", "Lkotlin/x;", "resubmitPendingTxs", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "txUpdatesObservable", "Lh/c/s;", "getTxUpdatesObservable", "()Lh/c/s;", "getTxUpdatesObservable$annotations", "()V", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "walletService", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "getWalletService", "()Lcom/coinbase/walletengine/services/xrp/XRPService;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "kotlin.jvm.PlatformType", "txSubmitsSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/ripple/models/XRPConfiguration;", "configuration", "Lcom/coinbase/wallet/ripple/models/XRPConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/ripple/models/XRPConfiguration;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "xrpSignedTxDAO", "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "getXrpSignedTxDAO", "()Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;Lcom/coinbase/walletengine/services/xrp/XRPService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "ripple_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPTxRepository implements TxManaging, XRPBalanceManaging {
    private final AddressDao addressDao;
    private final CipherCoreInterface cipherCore;
    private final XRPConfiguration configuration;
    private final StoreInterface store;
    private final h.c.v0.b<Transaction> txSubmitsSubject;
    private final h.c.s<TxUpdate> txUpdatesObservable;
    private final WalletDao walletDao;
    private final XRPService walletService;
    private final XRPSignedTxDAO xrpSignedTxDAO;

    /* compiled from: XRPTxRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TransactionStatus.values().length];
            iArr[TransactionStatus.CONFIRMED.ordinal()] = 1;
            iArr[TransactionStatus.NOT_FOUND.ordinal()] = 2;
            iArr[TransactionStatus.PENDING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public XRPTxRepository(CipherCoreInterface cipherCore, XRPSignedTxDAO xrpSignedTxDAO, XRPService walletService, AddressDao addressDao, WalletDao walletDao, StoreInterface store) {
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(xrpSignedTxDAO, "xrpSignedTxDAO");
        kotlin.jvm.internal.m.g(walletService, "walletService");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(store, "store");
        this.cipherCore = cipherCore;
        this.xrpSignedTxDAO = xrpSignedTxDAO;
        this.walletService = walletService;
        this.addressDao = addressDao;
        this.walletDao = walletDao;
        this.store = store;
        h.c.v0.b<Transaction> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Transaction>()");
        this.txSubmitsSubject = d2;
        this.configuration = WalletConfiguration_RippleKt.getXRP(WalletConfiguration.Companion);
        h.c.s<TxUpdate> merge = h.c.s.merge(d2.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.n((Transaction) obj);
            }
        }), getXrpSignedTxDAO().observeSignedTx().distinctUntilChanged(new h.c.m0.d() { // from class: com.coinbase.wallet.ripple.repositories.f
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return XRPTxRepository.f((XRPSignedTx) obj, (XRPSignedTx) obj2);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.g((XRPSignedTx) obj);
            }
        }));
        kotlin.jvm.internal.m.f(merge, "merge(\n        txSubmitsSubject.hide().map { TxUpdate.Submitted(it) },\n        xrpSignedTxDAO.observeSignedTx()\n            .distinctUntilChanged { a, b ->\n                // '==' in kotlin compares value most of the time, but for ByteArray it is referential comparison\n                // that's why cannot simply call distinctUntilChanged() here and rely on equals method generated from\n                // data class to just work its magic. Consumers of this stream trigger many db writes/reads; optimizations\n                // are worthwhile\n                a.id == b.id && a.state == b.state && a.signedTxData.contentEquals(b.signedTxData)\n            }\n            .map { TxUpdate.Update(it) }\n    )");
        this.txUpdatesObservable = merge;
    }

    public static /* synthetic */ h0 a(XRPUnsignedTx xRPUnsignedTx, XRPTxRepository xRPTxRepository, kotlin.o oVar) {
        return m1679signAndSubmit$lambda7(xRPUnsignedTx, xRPTxRepository, oVar);
    }

    public static /* synthetic */ SignedTx b(XRPUnsignedTx xRPUnsignedTx, Optional optional) {
        return m1675signAndSubmit$lambda11(xRPUnsignedTx, optional);
    }

    public static /* synthetic */ List c(List list, List list2) {
        return m1664resubmitPendingTxs$lambda16$lambda15(list, list2);
    }

    public static /* synthetic */ kotlin.x d(Throwable th) {
        return m1671resubmitPendingTxs$lambda25$lambda24$lambda23(th);
    }

    public static /* synthetic */ h0 e(XRPTxRepository xRPTxRepository, List list) {
        return m1665resubmitPendingTxs$lambda20(xRPTxRepository, list);
    }

    public static /* synthetic */ boolean f(XRPSignedTx xRPSignedTx, XRPSignedTx xRPSignedTx2) {
        return m1681txUpdatesObservable$lambda1(xRPSignedTx, xRPSignedTx2);
    }

    public static /* synthetic */ TxUpdate.Update g(XRPSignedTx xRPSignedTx) {
        return m1682txUpdatesObservable$lambda2(xRPSignedTx);
    }

    /* renamed from: generateUnsignedTx$lambda-4 */
    public static final UnsignedTxResult m1661generateUnsignedTx$lambda4(Wallet wallet, TransferValue amount, String recipientAddress, UInt uInt, kotlin.t dstr$fee$recipientAccountInfo$recipientBalanceOptional) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(dstr$fee$recipientAccountInfo$recipientBalanceOptional, "$dstr$fee$recipientAccountInfo$recipientBalanceOptional");
        BigInteger fee = (BigInteger) dstr$fee$recipientAccountInfo$recipientBalanceOptional.a();
        com.coinbase.walletengine.Optional optional = (com.coinbase.walletengine.Optional) dstr$fee$recipientAccountInfo$recipientBalanceOptional.b();
        com.coinbase.walletengine.Optional optional2 = (com.coinbase.walletengine.Optional) dstr$fee$recipientAccountInfo$recipientBalanceOptional.c();
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
        BigInteger bigInteger = subtract2;
        String primaryAddress = wallet.getPrimaryAddress();
        BigInteger recipientBalance = BigInteger.ZERO;
        Comparable f2 = kotlin.b0.a.f(bigInteger, recipientBalance);
        kotlin.jvm.internal.m.f(f2, "maxOf(transferValue, BigInteger.ZERO)");
        XRPUnsignedTx xRPUnsignedTx = new XRPUnsignedTx(primaryAddress, recipientAddress, (BigInteger) f2, fee, uInt, wallet.getNetwork(), null);
        if (bigInteger.compareTo(recipientBalance) <= 0) {
            return new UnsignedTxResult.Error(xRPUnsignedTx, TxException.InsufficientBalance.INSTANCE);
        }
        AccountInfo accountInfo = (AccountInfo) optional.getValue();
        if (accountInfo == null) {
            BigInteger bigInteger2 = (BigInteger) optional2.getValue();
            if (bigInteger2 != null) {
                recipientBalance = bigInteger2;
            }
            kotlin.jvm.internal.m.f(recipientBalance, "recipientBalance");
            BigInteger add = bigInteger.add(recipientBalance);
            kotlin.jvm.internal.m.f(add, "this.add(other)");
            if (add.compareTo(minimumBalance2) >= 0) {
                return new UnsignedTxResult.Success(xRPUnsignedTx);
            }
            return new UnsignedTxResult.Error(xRPUnsignedTx, XrpException.RequiresBaseReserve.INSTANCE);
        } else if (accountInfo.getDisallowsIncomingXRP()) {
            return new UnsignedTxResult.Error(xRPUnsignedTx, XrpException.RecipientDisallowsIncomingXrp.INSTANCE);
        } else {
            if (accountInfo.getRequiresDestinationTag() && uInt == null) {
                return new UnsignedTxResult.Error(xRPUnsignedTx, XrpException.MissingDestinationTag.INSTANCE);
            }
            return new UnsignedTxResult.Success(xRPUnsignedTx);
        }
    }

    /* renamed from: getTxState$lambda-13 */
    public static final TxState m1662getTxState$lambda13(TransactionResult it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.getStatus() == TransactionStatus.CONFIRMED ? TxState.CONFIRMED : TxState.PENDING;
    }

    public static /* synthetic */ void getTxUpdatesObservable$annotations() {
    }

    public static /* synthetic */ kotlin.x h(Throwable th) {
        return m1669resubmitPendingTxs$lambda25$lambda24$lambda21(th);
    }

    public static /* synthetic */ h0 i(XRPTxRepository xRPTxRepository, XRPUnsignedTx xRPUnsignedTx, KeyPair keyPair) {
        return m1677signAndSubmit$lambda5(xRPTxRepository, xRPUnsignedTx, keyPair);
    }

    public static /* synthetic */ h0 j(XRPSignedTx xRPSignedTx, XRPTxRepository xRPTxRepository, UInt uInt) {
        return m1670resubmitPendingTxs$lambda25$lambda24$lambda22(xRPSignedTx, xRPTxRepository, uInt);
    }

    public static /* synthetic */ UnsignedTxResult k(Wallet wallet, TransferValue transferValue, String str, UInt uInt, kotlin.t tVar) {
        return m1661generateUnsignedTx$lambda4(wallet, transferValue, str, uInt, tVar);
    }

    public static /* synthetic */ TxState l(TransactionResult transactionResult) {
        return m1662getTxState$lambda13(transactionResult);
    }

    public static /* synthetic */ h0 m(XRPTxRepository xRPTxRepository, XRPUnsignedTx xRPUnsignedTx, SignedTransaction signedTransaction) {
        return m1678signAndSubmit$lambda6(xRPTxRepository, xRPUnsignedTx, signedTransaction);
    }

    public static /* synthetic */ TxUpdate.Submitted n(Transaction transaction) {
        return m1680txUpdatesObservable$lambda0(transaction);
    }

    public static /* synthetic */ Optional o(TransactionResult transactionResult) {
        return m1666resubmitPendingTxs$lambda20$lambda19$lambda17(transactionResult);
    }

    public static /* synthetic */ h0 p(UnsignedTx unsignedTx, XRPTxRepository xRPTxRepository, Optional optional) {
        return m1672signAndSubmit$lambda10(unsignedTx, xRPTxRepository, optional);
    }

    public static /* synthetic */ SignedTx q(XRPTxRepository xRPTxRepository, UnsignedTx unsignedTx, SignedTx signedTx) {
        return m1676signAndSubmit$lambda12(xRPTxRepository, unsignedTx, signedTx);
    }

    public static /* synthetic */ h0 r(XRPTxRepository xRPTxRepository, List list) {
        return m1663resubmitPendingTxs$lambda16(xRPTxRepository, list);
    }

    /* renamed from: resubmitPendingTxs$lambda-16 */
    public static final h0 m1663resubmitPendingTxs$lambda16(XRPTxRepository this$0, final List transactions) {
        int r;
        b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transactions, "transactions");
        l.a.a.a("XRP: unconfirmed signed transactions " + transactions.size() + TokenParser.SP + transactions, new Object[0]);
        r = kotlin.a0.s.r(transactions, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = transactions.iterator();
        while (it.hasNext()) {
            XRPSignedTx xRPSignedTx = (XRPSignedTx) it.next();
            arrayList.add(this$0.getWalletService().submitSignedTransaction(xRPSignedTx.getSignedTxData(), xRPSignedTx.getNetwork().isTestnet()));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.XRPTxRepository$resubmitPendingTxs$lambda-16$$inlined$zipOrEmpty$1
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
                        if (obj instanceof kotlin.x) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.c(transactions, (List) obj);
            }
        });
    }

    /* renamed from: resubmitPendingTxs$lambda-16$lambda-15 */
    public static final List m1664resubmitPendingTxs$lambda16$lambda15(List transactions, List it) {
        kotlin.jvm.internal.m.g(transactions, "$transactions");
        kotlin.jvm.internal.m.g(it, "it");
        return transactions;
    }

    /* renamed from: resubmitPendingTxs$lambda-20 */
    public static final h0 m1665resubmitPendingTxs$lambda20(XRPTxRepository this$0, List transactions) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transactions, "transactions");
        r = kotlin.a0.s.r(transactions, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = transactions.iterator();
        while (it.hasNext()) {
            XRPSignedTx xRPSignedTx = (XRPSignedTx) it.next();
            b0 onErrorReturn = this$0.getWalletService().m2122getTransactionResultJaBXUxU(xRPSignedTx.getTxHash(), UInt.s((int) xRPSignedTx.getMaxLedgerVersion()), null, xRPSignedTx.getNetwork().isTestnet()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.o
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPTxRepository.o((TransactionResult) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.u
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPTxRepository.u((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "walletService.getTransactionResult(\n                    txHash = tx.txHash,\n                    maxLedgerVersion = tx.maxLedgerVersion.toUInt(),\n                    testnet = tx.network.isTestnet,\n                    atLedgerVersion = null\n                )\n                    .map { Optional(it) }\n                    .onErrorReturn { Optional(null) }");
            h.c.t0.e eVar = h.c.t0.e.a;
            b0 just = b0.just(xRPSignedTx);
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
        b0 zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.XRPTxRepository$resubmitPendingTxs$lambda-20$$inlined$zipOrEmpty$1
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
    public static final Optional m1666resubmitPendingTxs$lambda20$lambda19$lambda17(TransactionResult it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(it);
    }

    /* renamed from: resubmitPendingTxs$lambda-20$lambda-19$lambda-18 */
    public static final Optional m1667resubmitPendingTxs$lambda20$lambda19$lambda18(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: resubmitPendingTxs$lambda-25 */
    public static final h0 m1668resubmitPendingTxs$lambda25(final XRPTxRepository this$0, List txResults) {
        List g2;
        XRPSignedTx copy;
        b0<kotlin.x> onErrorReturn;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(txResults, "txResults");
        ArrayList arrayList = new ArrayList();
        Iterator it = txResults.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            final XRPSignedTx tx = (XRPSignedTx) oVar.b();
            TransactionResult transactionResult = (TransactionResult) ((Optional) oVar.a()).getValue();
            b0<kotlin.x> b0Var = null;
            if (transactionResult != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[transactionResult.getStatus().ordinal()];
                if (i2 == 1) {
                    XRPSignedTxDAO xrpSignedTxDAO = this$0.getXrpSignedTxDAO();
                    kotlin.jvm.internal.m.f(tx, "tx");
                    copy = tx.copy((r18 & 1) != 0 ? tx.getId() : null, (r18 & 2) != 0 ? tx.signedTxData : null, (r18 & 4) != 0 ? tx.network : null, (r18 & 8) != 0 ? tx.maxLedgerVersion : 0L, (r18 & 16) != 0 ? tx.getState() : TxState.CONFIRMED, (r18 & 32) != 0 ? tx.transferValue : null, (r18 & 64) != 0 ? tx.getTxHash() : null);
                    onErrorReturn = Single_CoreKt.asUnit(xrpSignedTxDAO.save(copy)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.h
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return XRPTxRepository.h((Throwable) obj);
                        }
                    });
                } else if (i2 == 2) {
                    b0<R> flatMap = this$0.getWalletService().getLedgerVersion(tx.getNetwork().isTestnet()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.j
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return XRPTxRepository.j(XRPSignedTx.this, this$0, (UInt) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(flatMap, "walletService.getLedgerVersion(testnet = tx.network.isTestnet)\n                                .flatMap { currentLedgerVersion ->\n                                    if (currentLedgerVersion > tx.maxLedgerVersion.toUInt()) {\n                                        xrpSignedTxDAO.save(tx.copy(state = TxState.DROPPED))\n                                    } else {\n                                        Single.just(null)\n                                    }\n                                }");
                    onErrorReturn = Single_CoreKt.asUnit(flatMap).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.d
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return XRPTxRepository.d((Throwable) obj);
                        }
                    });
                } else if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                b0Var = onErrorReturn;
            }
            if (b0Var != null) {
                arrayList.add(b0Var);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            b0 just = b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        b0 zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.XRPTxRepository$resubmitPendingTxs$lambda-25$$inlined$zipOrEmpty$1
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

    /* renamed from: resubmitPendingTxs$lambda-25$lambda-24$lambda-21 */
    public static final kotlin.x m1669resubmitPendingTxs$lambda25$lambda24$lambda21(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: resubmitPendingTxs$lambda-25$lambda-24$lambda-22 */
    public static final h0 m1670resubmitPendingTxs$lambda25$lambda24$lambda22(XRPSignedTx tx, XRPTxRepository this$0, UInt currentLedgerVersion) {
        int compare;
        XRPSignedTx copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(currentLedgerVersion, "currentLedgerVersion");
        compare = Integer.compare(currentLedgerVersion.B() ^ Integer.MIN_VALUE, UInt.s((int) tx.getMaxLedgerVersion()) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            XRPSignedTxDAO xrpSignedTxDAO = this$0.getXrpSignedTxDAO();
            kotlin.jvm.internal.m.f(tx, "tx");
            copy = tx.copy((r18 & 1) != 0 ? tx.getId() : null, (r18 & 2) != 0 ? tx.signedTxData : null, (r18 & 4) != 0 ? tx.network : null, (r18 & 8) != 0 ? tx.maxLedgerVersion : 0L, (r18 & 16) != 0 ? tx.getState() : TxState.DROPPED, (r18 & 32) != 0 ? tx.transferValue : null, (r18 & 64) != 0 ? tx.getTxHash() : null);
            return xrpSignedTxDAO.save(copy);
        }
        b0 just = b0.just(null);
        kotlin.jvm.internal.m.f(just, "{\n                                        Single.just(null)\n                                    }");
        return just;
    }

    /* renamed from: resubmitPendingTxs$lambda-25$lambda-24$lambda-23 */
    public static final kotlin.x m1671resubmitPendingTxs$lambda25$lambda24$lambda23(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    public static /* synthetic */ Optional s(Optional optional, Throwable th) {
        return m1674signAndSubmit$lambda10$lambda9(optional, th);
    }

    /* renamed from: signAndSubmit$lambda-10 */
    public static final h0 m1672signAndSubmit$lambda10(UnsignedTx unsignedTx, XRPTxRepository this$0, final Optional signedTx) {
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        return this$0.refreshBalances(new RefreshContext(unsignedTx.getNetwork(), 0, RefreshContext.Mode.Quick.INSTANCE, true)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.v(Optional.this, (kotlin.x) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.s(Optional.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: signAndSubmit$lambda-10$lambda-8 */
    public static final Optional m1673signAndSubmit$lambda10$lambda8(Optional signedTx, kotlin.x it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-10$lambda-9 */
    public static final Optional m1674signAndSubmit$lambda10$lambda9(Optional signedTx, Throwable it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-11 */
    public static final SignedTx m1675signAndSubmit$lambda11(XRPUnsignedTx tx, Optional it) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(it, "it");
        Object value = it.getValue();
        SignedTx signedTx = value instanceof SignedTx ? (SignedTx) value : null;
        if (signedTx != null) {
            return signedTx;
        }
        throw new TxException.UnableToSaveTx(tx.getBlockchain());
    }

    /* renamed from: signAndSubmit$lambda-12 */
    public static final SignedTx m1676signAndSubmit$lambda12(XRPTxRepository this$0, UnsignedTx unsignedTx, SignedTx signedTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        this$0.txSubmitsSubject.onNext(Transaction.Companion.createSubmittedTx(unsignedTx, signedTx));
        return signedTx;
    }

    /* renamed from: signAndSubmit$lambda-5 */
    public static final h0 m1677signAndSubmit$lambda5(XRPTxRepository this$0, XRPUnsignedTx tx, KeyPair keyPair) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(keyPair, "keyPair");
        return this$0.getWalletService().m2123signTransactiongXGYdlU(tx.getFromAddress(), tx.getRecipientAddress(), tx.getTransferValue(), tx.getEstimatedFee(), 20, null, tx.m1660getDestinationTag0hXNFcg(), null, keyPair.getPrivateKey(), keyPair.getPublicKey(), tx.getNetwork().isTestnet());
    }

    /* renamed from: signAndSubmit$lambda-6 */
    public static final h0 m1678signAndSubmit$lambda6(XRPTxRepository this$0, XRPUnsignedTx tx, SignedTransaction signedData) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(signedData, "signedData");
        b0<kotlin.x> submitSignedTransaction = this$0.getWalletService().submitSignedTransaction(signedData.getData(), tx.getNetwork().isTestnet());
        h.c.t0.e eVar = h.c.t0.e.a;
        b0 just = b0.just(signedData);
        kotlin.jvm.internal.m.f(just, "just(signedData)");
        return eVar.a(just, submitSignedTransaction);
    }

    /* renamed from: signAndSubmit$lambda-7 */
    public static final h0 m1679signAndSubmit$lambda7(XRPUnsignedTx tx, XRPTxRepository this$0, kotlin.o dstr$signedData$_u24__u24) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$signedData$_u24__u24, "$dstr$signedData$_u24__u24");
        SignedTransaction signedTransaction = (SignedTransaction) dstr$signedData$_u24__u24.a();
        String uuid = UUID.randomUUID().toString();
        byte[] data = signedTransaction.getData();
        String hash = signedTransaction.getHash();
        TxState txState = TxState.PENDING;
        BigInteger transferValue = tx.getTransferValue();
        kotlin.jvm.internal.m.f(uuid, "toString()");
        return this$0.getXrpSignedTxDAO().save(new XRPSignedTx(uuid, data, tx.getNetwork(), 4294967295L & signedTransaction.m2097getMaxLedgerVersionpVg5ArA(), txState, transferValue, hash));
    }

    public static /* synthetic */ h0 t(XRPTxRepository xRPTxRepository, List list) {
        return m1668resubmitPendingTxs$lambda25(xRPTxRepository, list);
    }

    /* renamed from: txUpdatesObservable$lambda-0 */
    public static final TxUpdate.Submitted m1680txUpdatesObservable$lambda0(Transaction it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Submitted(it);
    }

    /* renamed from: txUpdatesObservable$lambda-1 */
    public static final boolean m1681txUpdatesObservable$lambda1(XRPSignedTx a, XRPSignedTx b2) {
        kotlin.jvm.internal.m.g(a, "a");
        kotlin.jvm.internal.m.g(b2, "b");
        return kotlin.jvm.internal.m.c(a.getId(), b2.getId()) && a.getState() == b2.getState() && Arrays.equals(a.getSignedTxData(), b2.getSignedTxData());
    }

    /* renamed from: txUpdatesObservable$lambda-2 */
    public static final TxUpdate.Update m1682txUpdatesObservable$lambda2(XRPSignedTx it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new TxUpdate.Update(it);
    }

    public static /* synthetic */ Optional u(Throwable th) {
        return m1667resubmitPendingTxs$lambda20$lambda19$lambda18(th);
    }

    public static /* synthetic */ Optional v(Optional optional, kotlin.x xVar) {
        return m1673signAndSubmit$lambda10$lambda8(optional, xVar);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<UnsignedTxResult> generateUnsignedTx(final Wallet wallet, final TransferValue amount, final String recipientAddress, Map<TxMetadataKey, ? extends Object> metadata, BigInteger bigInteger, BigInteger bigInteger2, Integer num) {
        final UInt h2;
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        boolean isTestnet = wallet.getNetwork().isTestnet();
        b0<com.coinbase.walletengine.Optional<AccountInfo>> accountInfo = getWalletService().getAccountInfo(recipientAddress, isTestnet);
        b0<BigInteger> estimateFee = getWalletService().estimateFee(isTestnet);
        b0<com.coinbase.walletengine.Optional<BigInteger>> m2121getBalanceSLwFa_Y = getWalletService().m2121getBalanceSLwFa_Y(recipientAddress, null, isTestnet);
        Object obj = metadata.get(TxMetadataKey_RippleKt.getDestinationTag(TxMetadataKey.Companion));
        if (obj == null) {
            h2 = null;
        } else {
            UInt uInt = obj instanceof UInt ? (UInt) obj : null;
            if (uInt == null) {
                b0<UnsignedTxResult> just = b0.just(new UnsignedTxResult.Error(null, XrpException.InvalidDestinationTag.INSTANCE));
                kotlin.jvm.internal.m.f(just, "just(UnsignedTxResult.Error(null, XrpException.InvalidDestinationTag))");
                return just;
            }
            h2 = UInt.h(uInt.B());
        }
        b0 map = h.c.t0.e.a.b(estimateFee, accountInfo, m2121getBalanceSLwFa_Y).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return XRPTxRepository.k(Wallet.this, amount, recipientAddress, h2, (kotlin.t) obj2);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(estimatedFeeSingle, getRecipientAccountInfoSingle, getRecipientBalanceSingle)\n            .map { (fee, recipientAccountInfo, recipientBalanceOptional) ->\n                val minimumBalance = wallet.minimumBalance ?: BigInteger.ZERO\n                val maximumTransferAmount = wallet.balance - minimumBalance - fee\n                val transferValue = when (amount) {\n                    is TransferValue.Amount -> {\n                        if (amount.value <= maximumTransferAmount) amount.value else maximumTransferAmount\n                    }\n                    is TransferValue.EntireBalance -> maximumTransferAmount\n                }\n\n                val unsignedTx = XRPUnsignedTx(\n                    fromAddress = wallet.primaryAddress,\n                    recipientAddress = recipientAddress,\n                    transferValue = maxOf(transferValue, BigInteger.ZERO),\n                    estimatedFee = fee,\n                    destinationTag = destinationTag,\n                    network = wallet.network\n                )\n\n                if (transferValue <= BigInteger.ZERO) {\n                    return@map UnsignedTxResult.Error(unsignedTx, TxException.InsufficientBalance)\n                }\n\n                val accountInfo = recipientAccountInfo.value\n                when {\n                    accountInfo == null -> {\n                        val recipientBalance = recipientBalanceOptional.value ?: BigInteger.ZERO\n\n                        if (transferValue + recipientBalance >= minimumBalance) {\n                            UnsignedTxResult.Success(unsignedTx)\n                        } else {\n                            UnsignedTxResult.Error(unsignedTx, XrpException.RequiresBaseReserve)\n                        }\n                    }\n\n                    accountInfo.disallowsIncomingXRP -> {\n                        UnsignedTxResult.Error(unsignedTx, XrpException.RecipientDisallowsIncomingXrp)\n                    }\n\n                    accountInfo.requiresDestinationTag && destinationTag == null -> {\n                        UnsignedTxResult.Error(unsignedTx, XrpException.MissingDestinationTag)\n                    }\n\n                    else -> UnsignedTxResult.Success(unsignedTx)\n                }\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getBalance(String str, Network network) {
        return XRPBalanceManaging.DefaultImpls.getBalance(this, str, network);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getMinimumBalance(Network network) {
        return XRPBalanceManaging.DefaultImpls.getMinimumBalance(this, network);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    public StoreInterface getStore() {
        return this.store;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<TxState> getTxState(String txHash, Network network) {
        kotlin.jvm.internal.m.g(txHash, "txHash");
        kotlin.jvm.internal.m.g(network, "network");
        b0 map = getWalletService().m2122getTransactionResultJaBXUxU(txHash, mo1646getXrpMaxLedgerVersionpVg5ArA(), null, network.isTestnet()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.l((TransactionResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletService\n        .getTransactionResult(\n            txHash = txHash,\n            maxLedgerVersion = xrpMaxLedgerVersion,\n            atLedgerVersion = null,\n            testnet = network.isTestnet\n        )\n        .map { if (it.status == TransactionStatus.CONFIRMED) TxState.CONFIRMED else TxState.PENDING }");
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

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    public XRPService getWalletService() {
        return this.walletService;
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    /* renamed from: getXrpMaxLedgerVersion-pVg5ArA */
    public int mo1646getXrpMaxLedgerVersionpVg5ArA() {
        return XRPBalanceManaging.DefaultImpls.m1654getXrpMaxLedgerVersionpVg5ArA(this);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    public XRPSignedTxDAO getXrpSignedTxDAO() {
        return this.xrpSignedTxDAO;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<Boolean> isValidAddress(String address, Network network) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(network, "network");
        return getWalletService().isAddressValid(address);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    public b0<kotlin.x> refreshBalances(RefreshContext refreshContext) {
        return XRPBalanceManaging.DefaultImpls.refreshBalances(this, refreshContext);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<kotlin.x> resubmitPendingTxs(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        b0 flatMap = getXrpSignedTxDAO().getPendingTxs(network).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.r(XRPTxRepository.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.e(XRPTxRepository.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.t(XRPTxRepository.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "xrpSignedTxDAO.getPendingTxs(network)\n        // Submit the transactions using WalletEngine\n        .flatMap { transactions ->\n            Timber.d(\"XRP: unconfirmed signed transactions ${transactions.size} $transactions\")\n\n            transactions\n                .map { walletService.submitSignedTransaction(it.signedTxData, it.network.isTestnet) }\n                .zipOrEmpty()\n                .map { transactions }\n        }\n\n        // Check status of all submitted transactions\n        .flatMap { transactions ->\n            val transactionResultSingles = transactions.map { tx ->\n                val result = walletService.getTransactionResult(\n                    txHash = tx.txHash,\n                    maxLedgerVersion = tx.maxLedgerVersion.toUInt(),\n                    testnet = tx.network.isTestnet,\n                    atLedgerVersion = null\n                )\n                    .map { Optional(it) }\n                    .onErrorReturn { Optional(null) }\n\n                Singles.zip(result, Single.just(tx))\n            }\n\n            Singles.zipOrEmpty(transactionResultSingles)\n        }\n        .flatMap { txResults ->\n            txResults\n                .mapNotNull { (aResult, tx) ->\n                    val result = aResult.value ?: return@mapNotNull null\n\n                    return@mapNotNull when (result.status) {\n                        TransactionStatus.CONFIRMED -> {\n                            xrpSignedTxDAO.save(tx.copy(state = TxState.CONFIRMED))\n                                .asUnit()\n                                .onErrorReturn { Unit }\n                        }\n\n                        TransactionStatus.NOT_FOUND -> {\n                            walletService.getLedgerVersion(testnet = tx.network.isTestnet)\n                                .flatMap { currentLedgerVersion ->\n                                    if (currentLedgerVersion > tx.maxLedgerVersion.toUInt()) {\n                                        xrpSignedTxDAO.save(tx.copy(state = TxState.DROPPED))\n                                    } else {\n                                        Single.just(null)\n                                    }\n                                }\n                                .asUnit()\n                                .onErrorReturn { Unit }\n                        }\n\n                        TransactionStatus.PENDING -> {\n                            null\n                        } // nothing to do. keep submitting\n                    }\n                }\n                .zipOrEmpty()\n        }");
        return Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null));
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging
    public b0<SignedTx> signAndSubmit(final UnsignedTx unsignedTx, String mnemonic, boolean z) {
        kotlin.jvm.internal.m.g(unsignedTx, "unsignedTx");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        final XRPUnsignedTx xRPUnsignedTx = unsignedTx instanceof XRPUnsignedTx ? (XRPUnsignedTx) unsignedTx : null;
        if (xRPUnsignedTx == null) {
            b0<SignedTx> error = b0.error(TxException.UnknownTransactionType.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(TxException.UnknownTransactionType)");
            return error;
        }
        b0 map = CipherCoreInterface_RippleKt.getXrpWalletKeyPair(this.cipherCore, mnemonic).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.i(XRPTxRepository.this, xRPUnsignedTx, (KeyPair) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.m(XRPTxRepository.this, xRPUnsignedTx, (SignedTransaction) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.a(XRPUnsignedTx.this, this, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.p(UnsignedTx.this, this, (Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.b(XRPUnsignedTx.this, (Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPTxRepository.q(XRPTxRepository.this, unsignedTx, (SignedTx) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cipherCore.getXrpWalletKeyPair(mnemonic)\n\n            // Sign the transaction with the private keys\n            .flatMap { keyPair ->\n                walletService.signTransaction(\n                    fromAddress = tx.fromAddress,\n                    toAddress = tx.recipientAddress,\n                    amount = tx.transferValue,\n                    fee = tx.estimatedFee,\n                    maxLedgerVersionOffset = 20u,\n                    sourceTag = null,\n                    destinationTag = tx.destinationTag,\n                    invoiceId = null,\n                    privateKey = keyPair.privateKey,\n                    publicKey = keyPair.publicKey,\n                    testnet = tx.network.isTestnet\n                )\n            }\n\n            // Submit the signed transaction\n            .flatMap { signedData ->\n                val submitTransactionSingle = walletService.submitSignedTransaction(\n                    signedTxData = signedData.data,\n                    testnet = tx.network.isTestnet\n                )\n\n                Singles.zip(Single.just(signedData), submitTransactionSingle)\n            }\n\n            // Save transaction\n            .flatMap { (signedData, _) ->\n                val transaction = XRPSignedTx(\n                    id = UUID.randomUUID().toString(),\n                    signedTxData = signedData.data,\n                    txHash = signedData.hash,\n                    state = TxState.PENDING,\n                    network = tx.network,\n                    maxLedgerVersion = signedData.maxLedgerVersion.toLong(),\n                    transferValue = tx.transferValue\n                )\n\n                xrpSignedTxDAO.save(transaction)\n            }\n\n            // Refresh balances if needed\n            .flatMap { signedTx ->\n                val context = RefreshContext(\n                    network = unsignedTx.network,\n                    index = 0,\n                    mode = RefreshContext.Mode.Quick,\n                    isForced = true\n                )\n\n                refreshBalances(context)\n                    .map { signedTx }\n                    .onErrorReturn { signedTx }\n            }\n\n            // Ensure the transaction was saved\n            .map { it.value as? SignedTx ?: throw TxException.UnableToSaveTx(tx.blockchain) }\n            .map { signedTx ->\n                txSubmitsSubject.onNext(Transaction.createSubmittedTx(unsignedTx, signedTx))\n                signedTx\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.TxManaging, com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public XRPConfiguration getConfiguration() {
        return this.configuration;
    }
}