package com.coinbase.wallet.ripple.interfaces;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.ripple.extensions.StoreKeys_RippleKt;
import com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging;
import com.coinbase.wallet.ripple.models.XRPSignedTx;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.walletengine.services.xrp.TransactionResult;
import com.coinbase.walletengine.services.xrp.TransactionStatus;
import com.coinbase.walletengine.services.xrp.XRPService;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.x;

/* compiled from: XRPBalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u001e\u001a\u00020\u00128V@\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/ripple/interfaces/XRPBalanceManaging;", "Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedBalanceManaging;", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Ljava/math/BigInteger;", "getBalance", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "getMinimumBalance", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lkotlin/x;", "refreshBalances", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lkotlin/UInt;", "ledgerVersion", "", "Lcom/coinbase/wallet/ripple/interfaces/SignedXrpTxResult;", "getPendingTxResults", "(Lkotlin/UInt;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "getWalletService", "()Lcom/coinbase/walletengine/services/xrp/XRPService;", "walletService", "getXrpMaxLedgerVersion-pVg5ArA", "()I", "xrpMaxLedgerVersion", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "getXrpSignedTxDAO", "()Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "xrpSignedTxDAO", "ripple_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface XRPBalanceManaging extends AccountBasedBalanceManaging {

    /* compiled from: XRPBalanceManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Optional a(BigInteger bigInteger) {
            return m1649getMinimumBalance$lambda5(bigInteger);
        }

        public static /* synthetic */ Optional b(TransactionResult transactionResult) {
            return m1653getPendingTxResults_aPkLuA0$lambda12$lambda11$lambda9(transactionResult);
        }

        public static /* synthetic */ h0 c(XRPBalanceManaging xRPBalanceManaging, RefreshContext refreshContext, x xVar) {
            return m1656refreshBalances$lambda8(xRPBalanceManaging, refreshContext, xVar);
        }

        public static /* synthetic */ Optional d(com.coinbase.walletengine.Optional optional) {
            return m1647getBalance$lambda0(optional);
        }

        public static /* synthetic */ h0 e(XRPBalanceManaging xRPBalanceManaging, UInt uInt, Network network, List list) {
            return m1651getPendingTxResults_aPkLuA0$lambda12(xRPBalanceManaging, uInt, network, list);
        }

        public static /* synthetic */ SignedXrpTxResult f(XRPSignedTx xRPSignedTx, Optional optional) {
            return m1652getPendingTxResults_aPkLuA0$lambda12$lambda11$lambda10(xRPSignedTx, optional);
        }

        public static /* synthetic */ Optional g(o oVar) {
            return m1648getBalance$lambda4(oVar);
        }

        public static b0<Optional<BigInteger>> getBalance(XRPBalanceManaging xRPBalanceManaging, String address, Network network) {
            m.g(xRPBalanceManaging, "this");
            m.g(address, "address");
            m.g(network, "network");
            UInt uInt = (UInt) xRPBalanceManaging.getStore().get(StoreKeys_RippleKt.xrpLedgerVersion(StoreKeys.INSTANCE, network));
            b0<List<SignedXrpTxResult>> m1650getPendingTxResultsaPkLuA0 = m1650getPendingTxResultsaPkLuA0(xRPBalanceManaging, uInt, network);
            b0<R> map = xRPBalanceManaging.getWalletService().m2121getBalanceSLwFa_Y(address, uInt, network.isTestnet()).map(new n() { // from class: com.coinbase.wallet.ripple.interfaces.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPBalanceManaging.DefaultImpls.d((com.coinbase.walletengine.Optional) obj);
                }
            });
            m.f(map, "walletService\n            .getBalance(address = address, atLedgerVersion = ledgerVersion, testnet = network.isTestnet)\n            .map { it.value.toOptional() }");
            b0<Optional<BigInteger>> map2 = h.c.t0.f.a(map, m1650getPendingTxResultsaPkLuA0).map(new n() { // from class: com.coinbase.wallet.ripple.interfaces.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPBalanceManaging.DefaultImpls.g((o) obj);
                }
            });
            m.f(map2, "walletService\n            .getBalance(address = address, atLedgerVersion = ledgerVersion, testnet = network.isTestnet)\n            .map { it.value.toOptional() }\n            .zipWith(getUnconfirmedTxResults)\n            .map { (optionalBalance, pendingTxs) ->\n                val balance = optionalBalance.value ?: return@map null.toOptional()\n                val txBalance = pendingTxs\n                    .filter { it.result?.status != TransactionStatus.CONFIRMED }\n                    .map { it.tx.transferValue }\n                    .fold(BigInteger.ZERO) { prev, next -> prev.add(next) }\n\n                val pendingBalance = balance - txBalance\n                pendingBalance.toOptional()\n            }");
            return map2;
        }

        /* renamed from: getBalance$lambda-0 */
        public static Optional m1647getBalance$lambda0(com.coinbase.walletengine.Optional it) {
            m.g(it, "it");
            return OptionalKt.toOptional(it.getValue());
        }

        /* renamed from: getBalance$lambda-4 */
        public static Optional m1648getBalance$lambda4(o dstr$optionalBalance$pendingTxs) {
            int r;
            m.g(dstr$optionalBalance$pendingTxs, "$dstr$optionalBalance$pendingTxs");
            List pendingTxs = (List) dstr$optionalBalance$pendingTxs.b();
            BigInteger bigInteger = (BigInteger) ((Optional) dstr$optionalBalance$pendingTxs.a()).getValue();
            if (bigInteger == null) {
                return OptionalKt.toOptional(null);
            }
            m.f(pendingTxs, "pendingTxs");
            ArrayList<SignedXrpTxResult> arrayList = new ArrayList();
            for (Object obj : pendingTxs) {
                TransactionResult result = ((SignedXrpTxResult) obj).getResult();
                if ((result == null ? null : result.getStatus()) != TransactionStatus.CONFIRMED) {
                    arrayList.add(obj);
                }
            }
            r = s.r(arrayList, 10);
            ArrayList<BigInteger> arrayList2 = new ArrayList(r);
            for (SignedXrpTxResult signedXrpTxResult : arrayList) {
                arrayList2.add(signedXrpTxResult.getTx().getTransferValue());
            }
            BigInteger txBalance = BigInteger.ZERO;
            for (BigInteger bigInteger2 : arrayList2) {
                txBalance = txBalance.add(bigInteger2);
            }
            m.f(txBalance, "txBalance");
            BigInteger subtract = bigInteger.subtract(txBalance);
            m.f(subtract, "this.subtract(other)");
            return OptionalKt.toOptional(subtract);
        }

        public static b0<Optional<BigInteger>> getMinimumBalance(XRPBalanceManaging xRPBalanceManaging, Network network) {
            m.g(xRPBalanceManaging, "this");
            m.g(network, "network");
            b0 map = xRPBalanceManaging.getWalletService().getReserveBase(network.isTestnet()).map(new n() { // from class: com.coinbase.wallet.ripple.interfaces.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPBalanceManaging.DefaultImpls.a((BigInteger) obj);
                }
            });
            m.f(map, "walletService.getReserveBase(network.isTestnet).map { it.toOptional() }");
            return map;
        }

        /* renamed from: getMinimumBalance$lambda-5 */
        public static Optional m1649getMinimumBalance$lambda5(BigInteger it) {
            m.g(it, "it");
            return OptionalKt.toOptional(it);
        }

        /* renamed from: getPendingTxResults-aPkLuA0 */
        private static b0<List<SignedXrpTxResult>> m1650getPendingTxResultsaPkLuA0(final XRPBalanceManaging xRPBalanceManaging, final UInt uInt, final Network network) {
            b0 flatMap = xRPBalanceManaging.getXrpSignedTxDAO().getPendingTxs(network).flatMap(new n() { // from class: com.coinbase.wallet.ripple.interfaces.e
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPBalanceManaging.DefaultImpls.e(XRPBalanceManaging.this, uInt, network, (List) obj);
                }
            });
            m.f(flatMap, "xrpSignedTxDAO.getPendingTxs(network)\n        .flatMap { signedTxs ->\n            signedTxs\n                .map { signedTx ->\n                    walletService\n                        .getTransactionResult(\n                            txHash = signedTx.txHash,\n                            maxLedgerVersion = xrpMaxLedgerVersion,\n                            atLedgerVersion = ledgerVersion,\n                            testnet = network.isTestnet\n                        )\n                        .map { it.toOptional() }\n                        .map { SignedXrpTxResult(it.value, signedTx) }\n                }\n                .zipOrEmpty()\n        }");
            return flatMap;
        }

        /* renamed from: getPendingTxResults_aPkLuA0$lambda-12 */
        public static h0 m1651getPendingTxResults_aPkLuA0$lambda12(XRPBalanceManaging this$0, UInt uInt, Network network, List signedTxs) {
            int r;
            List g2;
            m.g(this$0, "this$0");
            m.g(network, "$network");
            m.g(signedTxs, "signedTxs");
            r = s.r(signedTxs, 10);
            ArrayList arrayList = new ArrayList(r);
            Iterator it = signedTxs.iterator();
            while (it.hasNext()) {
                final XRPSignedTx xRPSignedTx = (XRPSignedTx) it.next();
                arrayList.add(this$0.getWalletService().m2122getTransactionResultJaBXUxU(xRPSignedTx.getTxHash(), this$0.mo1646getXrpMaxLedgerVersionpVg5ArA(), uInt, network.isTestnet()).map(new n() { // from class: com.coinbase.wallet.ripple.interfaces.b
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return XRPBalanceManaging.DefaultImpls.b((TransactionResult) obj);
                    }
                }).map(new n() { // from class: com.coinbase.wallet.ripple.interfaces.f
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return XRPBalanceManaging.DefaultImpls.f(XRPSignedTx.this, (Optional) obj);
                    }
                }));
            }
            h.c.t0.e eVar = h.c.t0.e.a;
            if (arrayList.isEmpty()) {
                g2 = r.g();
                b0 just = b0.just(g2);
                m.f(just, "just(emptyList())");
                return just;
            }
            b0 zip = b0.zip(arrayList, new n() { // from class: com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging$DefaultImpls$getPendingTxResults_aPkLuA0$lambda-12$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it2.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it2[i2];
                        if (obj != null ? obj instanceof SignedXrpTxResult : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
            return zip;
        }

        /* renamed from: getPendingTxResults_aPkLuA0$lambda-12$lambda-11$lambda-10 */
        public static SignedXrpTxResult m1652getPendingTxResults_aPkLuA0$lambda12$lambda11$lambda10(XRPSignedTx signedTx, Optional it) {
            m.g(signedTx, "$signedTx");
            m.g(it, "it");
            return new SignedXrpTxResult((TransactionResult) it.getValue(), signedTx);
        }

        /* renamed from: getPendingTxResults_aPkLuA0$lambda-12$lambda-11$lambda-9 */
        public static Optional m1653getPendingTxResults_aPkLuA0$lambda12$lambda11$lambda9(TransactionResult it) {
            m.g(it, "it");
            return OptionalKt.toOptional(it);
        }

        /* renamed from: getXrpMaxLedgerVersion-pVg5ArA */
        public static int m1654getXrpMaxLedgerVersionpVg5ArA(XRPBalanceManaging xRPBalanceManaging) {
            m.g(xRPBalanceManaging, "this");
            return 20;
        }

        public static /* synthetic */ x h(RefreshContext refreshContext, XRPBalanceManaging xRPBalanceManaging, UInt uInt) {
            return m1655refreshBalances$lambda7(refreshContext, xRPBalanceManaging, uInt);
        }

        public static b0<x> refreshBalances(final XRPBalanceManaging xRPBalanceManaging, final RefreshContext context) {
            m.g(xRPBalanceManaging, "this");
            m.g(context, "context");
            b0<x> flatMap = xRPBalanceManaging.getWalletService().getLedgerVersion(context.getNetwork().isTestnet()).map(new n() { // from class: com.coinbase.wallet.ripple.interfaces.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPBalanceManaging.DefaultImpls.h(RefreshContext.this, xRPBalanceManaging, (UInt) obj);
                }
            }).flatMap(new n() { // from class: com.coinbase.wallet.ripple.interfaces.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return XRPBalanceManaging.DefaultImpls.c(XRPBalanceManaging.this, context, (x) obj);
                }
            });
            m.f(flatMap, "walletService.getLedgerVersion(context.network.isTestnet)\n        .map { ledgerVersion ->\n            ledgerVersionLock.withLock {\n                val blockHeightKey = StoreKeys.xrpLedgerVersion(context.network)\n                val storedLedgerVersion = store.get(blockHeightKey)\n                if (storedLedgerVersion == null || ledgerVersion > storedLedgerVersion) {\n                    store.set(blockHeightKey, ledgerVersion)\n                }\n            }\n        }\n        .flatMap { super.refreshBalances(context) }");
            return flatMap;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
            if (kotlin.z.a(r5.B(), r1.B()) > 0) goto L12;
         */
        /* renamed from: refreshBalances$lambda-7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static kotlin.x m1655refreshBalances$lambda7(com.coinbase.wallet.blockchains.models.RefreshContext r3, com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging r4, kotlin.UInt r5) {
            /*
                java.lang.String r0 = "$context"
                kotlin.jvm.internal.m.g(r3, r0)
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.m.g(r4, r0)
                java.util.concurrent.locks.ReentrantLock r0 = com.coinbase.wallet.ripple.interfaces.XRPBalanceManagingKt.access$getLedgerVersionLock()
                r0.lock()
                com.coinbase.wallet.store.models.StoreKeys r1 = com.coinbase.wallet.store.models.StoreKeys.INSTANCE     // Catch: java.lang.Throwable -> L47
                com.coinbase.wallet.blockchains.models.Network r3 = r3.getNetwork()     // Catch: java.lang.Throwable -> L47
                com.coinbase.wallet.store.models.SharedPrefsStoreKey r3 = com.coinbase.wallet.ripple.extensions.StoreKeys_RippleKt.xrpLedgerVersion(r1, r3)     // Catch: java.lang.Throwable -> L47
                com.coinbase.wallet.store.interfaces.StoreInterface r1 = r4.getStore()     // Catch: java.lang.Throwable -> L47
                java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L47
                kotlin.UInt r1 = (kotlin.UInt) r1     // Catch: java.lang.Throwable -> L47
                if (r1 == 0) goto L3a
                java.lang.String r2 = "ledgerVersion"
                kotlin.jvm.internal.m.f(r5, r2)     // Catch: java.lang.Throwable -> L47
                int r2 = r5.B()     // Catch: java.lang.Throwable -> L47
                int r1 = r1.B()     // Catch: java.lang.Throwable -> L47
                int r1 = kotlin.z.a(r2, r1)     // Catch: java.lang.Throwable -> L47
                if (r1 <= 0) goto L41
            L3a:
                com.coinbase.wallet.store.interfaces.StoreInterface r4 = r4.getStore()     // Catch: java.lang.Throwable -> L47
                r4.set(r3, r5)     // Catch: java.lang.Throwable -> L47
            L41:
                kotlin.x r3 = kotlin.x.a     // Catch: java.lang.Throwable -> L47
                r0.unlock()
                return r3
            L47:
                r3 = move-exception
                r0.unlock()
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging.DefaultImpls.m1655refreshBalances$lambda7(com.coinbase.wallet.blockchains.models.RefreshContext, com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging, kotlin.UInt):kotlin.x");
        }

        /* renamed from: refreshBalances$lambda-8 */
        public static h0 m1656refreshBalances$lambda8(XRPBalanceManaging this$0, RefreshContext context, x it) {
            m.g(this$0, "this$0");
            m.g(context, "$context");
            m.g(it, "it");
            return AccountBasedBalanceManaging.DefaultImpls.refreshBalances(this$0, context);
        }
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    b0<Optional<BigInteger>> getBalance(String str, Network network);

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    b0<Optional<BigInteger>> getMinimumBalance(Network network);

    StoreInterface getStore();

    XRPService getWalletService();

    /* renamed from: getXrpMaxLedgerVersion-pVg5ArA */
    int mo1646getXrpMaxLedgerVersionpVg5ArA();

    XRPSignedTxDAO getXrpSignedTxDAO();

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    b0<x> refreshBalances(RefreshContext refreshContext);
}