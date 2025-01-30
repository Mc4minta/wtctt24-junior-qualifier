package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.bitcoincash.extensions.Blockchain_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.consumer.models.Connected;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerTx;
import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ConsumerSettingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0019\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0002¢\u0006\u0004\b\u0010\u0010\u0005R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSettingViewModel;", "Landroidx/lifecycle/b0;", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/Connected;", "getAuthedConsumerInfo", "()Lh/c/s;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerTx;", "getLatestTx", "Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "getConnectStatus", "()Lh/c/b0;", "getConsumerInfo", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "getConsumerUserObservable", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "consumerAccountsRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSettingViewModel extends androidx.lifecycle.b0 {
    private final ConsumerAccountsRepository consumerAccountsRepository;
    private final ConsumerTransferRepository consumerTransferRepository;
    private final ConsumerUserRepository consumerUserRepository;
    private final IWalletRepository walletRepository;

    public ConsumerSettingViewModel(ConsumerUserRepository consumerUserRepository, ConsumerTransferRepository consumerTransferRepository, ConsumerAccountsRepository consumerAccountsRepository, IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        kotlin.jvm.internal.m.g(consumerAccountsRepository, "consumerAccountsRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.consumerUserRepository = consumerUserRepository;
        this.consumerTransferRepository = consumerTransferRepository;
        this.consumerAccountsRepository = consumerAccountsRepository;
        this.walletRepository = walletRepository;
    }

    public static /* synthetic */ Optional a(ConsumerConnectionStatus consumerConnectionStatus) {
        return m992getAuthedConsumerInfo$lambda3$lambda1(consumerConnectionStatus);
    }

    public static /* synthetic */ h.c.x b(Throwable th) {
        return m995getAuthedConsumerInfo$lambda5(th);
    }

    public static /* synthetic */ Connected c(kotlin.t tVar) {
        return m994getAuthedConsumerInfo$lambda4(tVar);
    }

    public static /* synthetic */ List d(ConsumerSettingViewModel consumerSettingViewModel, List list) {
        return m1002getLatestTx$lambda7(consumerSettingViewModel, list);
    }

    public static /* synthetic */ h.c.h0 e(ConsumerSettingViewModel consumerSettingViewModel, List list) {
        return m997getLatestTx$lambda15(consumerSettingViewModel, list);
    }

    public static /* synthetic */ List f(List list) {
        return m1004getLatestTx$lambda9(list);
    }

    public static /* synthetic */ List g(List list, List list2) {
        return m998getLatestTx$lambda15$lambda14(list, list2);
    }

    private final h.c.s<Connected> getAuthedConsumerInfo() {
        h.c.s onErrorResumeNext = h.c.t0.d.a(getLatestTx(), this.consumerUserRepository.getUserObservable()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.z0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.l(ConsumerSettingViewModel.this, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.q0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.c((kotlin.t) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.p0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.b((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "transactionAndUserNameObservable\n            .flatMap { (transactions, user) ->\n                Single.just(consumerUserRepository.getConnectStatus())\n                    .map { (it as? Connected).toOptional() }\n                    .toObservable()\n                    .unwrap()\n                    .map { Triple(transactions, user, it) }\n            }\n            .map { (transactions, user, status) ->\n                val lastTransaction = if (transactions.isEmpty()) null else transactions[0]\n                status.copy(\n                    lastTransactionDate = lastTransaction?.createdAt,\n                    email = user.toNullable()?.email\n                )\n            }\n            .onErrorResumeNext { _: Throwable -> Observable.never() }");
        return Observable_AnalyticsKt.logError$default(onErrorResumeNext, null, null, 3, null);
    }

    /* renamed from: getAuthedConsumerInfo$lambda-3 */
    public static final h.c.x m991getAuthedConsumerInfo$lambda3(ConsumerSettingViewModel this$0, kotlin.o dstr$transactions$user) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$transactions$user, "$dstr$transactions$user");
        final List list = (List) dstr$transactions$user.a();
        final Optional optional = (Optional) dstr$transactions$user.b();
        h.c.s observable = h.c.b0.just(this$0.consumerUserRepository.getConnectStatus()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.o0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.a((ConsumerConnectionStatus) obj);
            }
        }).toObservable();
        kotlin.jvm.internal.m.f(observable, "just(consumerUserRepository.getConnectStatus())\n                    .map { (it as? Connected).toOptional() }\n                    .toObservable()");
        h.c.s map = observable.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel$getAuthedConsumerInfo$lambda-3$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel$getAuthedConsumerInfo$lambda-3$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map.map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.w0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.i(list, optional, (Connected) obj);
            }
        });
    }

    /* renamed from: getAuthedConsumerInfo$lambda-3$lambda-1 */
    public static final Optional m992getAuthedConsumerInfo$lambda3$lambda1(ConsumerConnectionStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it instanceof Connected ? (Connected) it : null);
    }

    /* renamed from: getAuthedConsumerInfo$lambda-3$lambda-2 */
    public static final kotlin.t m993getAuthedConsumerInfo$lambda3$lambda2(List transactions, Optional optional, Connected it) {
        kotlin.jvm.internal.m.g(transactions, "$transactions");
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.t(transactions, optional, it);
    }

    /* renamed from: getAuthedConsumerInfo$lambda-4 */
    public static final Connected m994getAuthedConsumerInfo$lambda4(kotlin.t dstr$transactions$user$status) {
        kotlin.jvm.internal.m.g(dstr$transactions$user$status, "$dstr$transactions$user$status");
        List list = (List) dstr$transactions$user$status.a();
        Optional optional = (Optional) dstr$transactions$user$status.b();
        Connected status = (Connected) dstr$transactions$user$status.c();
        ConsumerTx consumerTx = list.isEmpty() ? null : (ConsumerTx) list.get(0);
        kotlin.jvm.internal.m.f(status, "status");
        Date createdAt = consumerTx == null ? null : consumerTx.getCreatedAt();
        ConsumerUser consumerUser = (ConsumerUser) optional.toNullable();
        return Connected.copy$default(status, false, false, createdAt, consumerUser == null ? null : consumerUser.getEmail(), 3, null);
    }

    /* renamed from: getAuthedConsumerInfo$lambda-5 */
    public static final h.c.x m995getAuthedConsumerInfo$lambda5(Throwable noName_0) {
        kotlin.jvm.internal.m.g(noName_0, "$noName_0");
        return h.c.s.never();
    }

    /* renamed from: getConsumerInfo$lambda-0 */
    public static final h.c.x m996getConsumerInfo$lambda0(ConsumerSettingViewModel this$0, ConsumerConnectionStatus status) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(status, "status");
        if ((status instanceof Connected) && !((Connected) status).getHasRestrictions()) {
            return this$0.getAuthedConsumerInfo();
        }
        h.c.s just = h.c.s.just(status);
        kotlin.jvm.internal.m.f(just, "{\n                    Observable.just(status)\n                }");
        return just;
    }

    private final h.c.s<List<ConsumerTx>> getLatestTx() {
        h.c.s map = this.consumerAccountsRepository.getAccountsObservable().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.r0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.d(ConsumerSettingViewModel.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.a1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.m((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.t0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.f((List) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.s0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.e(ConsumerSettingViewModel.this, (List) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.y0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.k(ConsumerSettingViewModel.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.x0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.j((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "allConsumerTransactions\n            .flatMapSingle { transactions ->\n                val currencyCodes = transactions.map { tx -> tx.currencyCode }.distinct()\n                walletRepository\n                    .getCryptoCurrencies(currencyCodes)\n                    .map { currencies ->\n                        val currenciesMap = currencies.map { it.code to it }.toMap()\n                        transactions.mapNotNull { tx -> currenciesMap[tx.currencyCode]?.let { tx to it } }\n                    }\n            }\n            .flatMapSingle { consumerTxns ->\n                consumerTxns\n                    .map { (consumerTx, currency) ->\n                        val containsAddressSingle = walletRepository.containsAddress(\n                            currency.blockchain,\n                            currency.code,\n                            consumerTx.toAddress\n                        )\n\n                        /** Consumer sends bitcoincash without the prefix, check for that as well */\n                        val additionalContainsSingle = if (currency.blockchain == Blockchain.BITCOIN_CASH) {\n                            walletRepository.containsAddress(\n                                currency.blockchain,\n                                currency.code,\n                                \"bitcoincash:${consumerTx.toAddress}\"\n                            )\n                        } else {\n                            Single.just(false)\n                        }\n\n                        val containsSingle = Singles.zip(containsAddressSingle, additionalContainsSingle)\n                            .map { it.first || it.second }\n\n                        Single.just(consumerTx).zipWith(containsSingle)\n                    }\n                    .zipOrEmpty()\n            }\n            .map { consumerTxToCreatedList ->\n                consumerTxToCreatedList\n                    .mapNotNull { (tx, created) -> if (created) tx else null }\n                    .sortedBy { tx -> tx.createdAt }\n                    .reversed()\n            }");
        return Observable_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    /* renamed from: getLatestTx$lambda-15 */
    public static final h.c.h0 m997getLatestTx$lambda15(ConsumerSettingViewModel this$0, final List transactions) {
        int r;
        List<CurrencyCode> P;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transactions, "transactions");
        r = kotlin.a0.s.r(transactions, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = transactions.iterator();
        while (it.hasNext()) {
            arrayList.add(((ConsumerTx) it.next()).getCurrencyCode());
        }
        P = kotlin.a0.z.P(arrayList);
        return this$0.walletRepository.getCryptoCurrencies(P).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.u0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.g(transactions, (List) obj);
            }
        });
    }

    /* renamed from: getLatestTx$lambda-15$lambda-14 */
    public static final List m998getLatestTx$lambda15$lambda14(List transactions, List currencies) {
        int r;
        Map r2;
        kotlin.jvm.internal.m.g(transactions, "$transactions");
        kotlin.jvm.internal.m.g(currencies, "currencies");
        r = kotlin.a0.s.r(currencies, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = currencies.iterator();
        while (it.hasNext()) {
            CryptoCurrency cryptoCurrency = (CryptoCurrency) it.next();
            arrayList.add(kotlin.u.a(cryptoCurrency.getCode(), cryptoCurrency));
        }
        r2 = kotlin.a0.m0.r(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = transactions.iterator();
        while (it2.hasNext()) {
            ConsumerTx consumerTx = (ConsumerTx) it2.next();
            CryptoCurrency cryptoCurrency2 = (CryptoCurrency) r2.get(consumerTx.getCurrencyCode());
            kotlin.o a = cryptoCurrency2 == null ? null : kotlin.u.a(consumerTx, cryptoCurrency2);
            if (a != null) {
                arrayList2.add(a);
            }
        }
        return arrayList2;
    }

    /* renamed from: getLatestTx$lambda-18 */
    public static final h.c.h0 m999getLatestTx$lambda18(ConsumerSettingViewModel this$0, List consumerTxns) {
        int r;
        List g2;
        h.c.b0<Boolean> just;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(consumerTxns, "consumerTxns");
        r = kotlin.a0.s.r(consumerTxns, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = consumerTxns.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            ConsumerTx consumerTx = (ConsumerTx) oVar.a();
            CryptoCurrency cryptoCurrency = (CryptoCurrency) oVar.b();
            h.c.b0<Boolean> containsAddress = this$0.walletRepository.containsAddress(cryptoCurrency.getBlockchain(), cryptoCurrency.getCode(), consumerTx.getToAddress());
            if (kotlin.jvm.internal.m.c(cryptoCurrency.getBlockchain(), Blockchain_BitcoinCashKt.getBITCOIN_CASH(Blockchain.Companion))) {
                just = this$0.walletRepository.containsAddress(cryptoCurrency.getBlockchain(), cryptoCurrency.getCode(), kotlin.jvm.internal.m.o("bitcoincash:", consumerTx.getToAddress()));
            } else {
                just = h.c.b0.just(Boolean.FALSE);
                kotlin.jvm.internal.m.f(just, "{\n                            Single.just(false)\n                        }");
            }
            h.c.b0 map = h.c.t0.e.a.a(containsAddress, just).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.b1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerSettingViewModel.n((kotlin.o) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "Singles.zip(containsAddressSingle, additionalContainsSingle)\n                            .map { it.first || it.second }");
            h.c.b0 just2 = h.c.b0.just(consumerTx);
            kotlin.jvm.internal.m.f(just2, "just(consumerTx)");
            arrayList.add(h.c.t0.f.a(just2, map));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just3 = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just3, "just(emptyList())");
            return just3;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel$getLatestTx$lambda-18$$inlined$zipOrEmpty$1
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

    /* renamed from: getLatestTx$lambda-18$lambda-17$lambda-16 */
    public static final Boolean m1000getLatestTx$lambda18$lambda17$lambda16(kotlin.o it) {
        boolean z;
        kotlin.jvm.internal.m.g(it, "it");
        Object c2 = it.c();
        kotlin.jvm.internal.m.f(c2, "it.first");
        if (!((Boolean) c2).booleanValue()) {
            Object d2 = it.d();
            kotlin.jvm.internal.m.f(d2, "it.second");
            if (!((Boolean) d2).booleanValue()) {
                z = false;
                return Boolean.valueOf(z);
            }
        }
        z = true;
        return Boolean.valueOf(z);
    }

    /* renamed from: getLatestTx$lambda-21 */
    public static final List m1001getLatestTx$lambda21(List consumerTxToCreatedList) {
        List B0;
        List v0;
        kotlin.jvm.internal.m.g(consumerTxToCreatedList, "consumerTxToCreatedList");
        ArrayList arrayList = new ArrayList();
        Iterator it = consumerTxToCreatedList.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            ConsumerTx consumerTx = (ConsumerTx) oVar.a();
            Boolean created = (Boolean) oVar.b();
            kotlin.jvm.internal.m.f(created, "created");
            if (!created.booleanValue()) {
                consumerTx = null;
            }
            if (consumerTx != null) {
                arrayList.add(consumerTx);
            }
        }
        B0 = kotlin.a0.z.B0(arrayList, new Comparator<T>() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel$getLatestTx$lambda-21$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(((ConsumerTx) t).getCreatedAt(), ((ConsumerTx) t2).getCreatedAt());
                return c2;
            }
        });
        v0 = kotlin.a0.z.v0(B0);
        return v0;
    }

    /* renamed from: getLatestTx$lambda-7 */
    public static final List m1002getLatestTx$lambda7(ConsumerSettingViewModel this$0, List it) {
        int r;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        r = kotlin.a0.s.r(it, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            arrayList.add(this$0.consumerTransferRepository.reloadTransactions(((ConsumerAccount) it2.next()).getId()));
        }
        return arrayList;
    }

    /* renamed from: getLatestTx$lambda-8 */
    public static final h.c.x m1003getLatestTx$lambda8(List transactionObservables) {
        List g2;
        kotlin.jvm.internal.m.g(transactionObservables, "transactionObservables");
        h.c.t0.c cVar = h.c.t0.c.a;
        if (transactionObservables.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.s just = h.c.s.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        Object[] array = transactionObservables.toArray(new h.c.s[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        h.c.s combineLatest = h.c.s.combineLatest((h.c.x[]) array, new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel$getLatestTx$lambda-8$$inlined$combineLatestOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it, "it");
                if (it.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : it) {
                    if (obj instanceof List) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        });
        kotlin.jvm.internal.m.f(combineLatest, "combineLatest(observables.toTypedArray()) {\n        if (it.isEmpty()) emptyList() else it.filterIsInstance<T>()\n    }");
        return combineLatest;
    }

    /* renamed from: getLatestTx$lambda-9 */
    public static final List m1004getLatestTx$lambda9(List it) {
        List u;
        kotlin.jvm.internal.m.g(it, "it");
        u = kotlin.a0.s.u(it);
        return u;
    }

    public static /* synthetic */ h.c.x h(ConsumerSettingViewModel consumerSettingViewModel, ConsumerConnectionStatus consumerConnectionStatus) {
        return m996getConsumerInfo$lambda0(consumerSettingViewModel, consumerConnectionStatus);
    }

    public static /* synthetic */ kotlin.t i(List list, Optional optional, Connected connected) {
        return m993getAuthedConsumerInfo$lambda3$lambda2(list, optional, connected);
    }

    public static /* synthetic */ List j(List list) {
        return m1001getLatestTx$lambda21(list);
    }

    public static /* synthetic */ h.c.h0 k(ConsumerSettingViewModel consumerSettingViewModel, List list) {
        return m999getLatestTx$lambda18(consumerSettingViewModel, list);
    }

    public static /* synthetic */ h.c.x l(ConsumerSettingViewModel consumerSettingViewModel, kotlin.o oVar) {
        return m991getAuthedConsumerInfo$lambda3(consumerSettingViewModel, oVar);
    }

    public static /* synthetic */ h.c.x m(List list) {
        return m1003getLatestTx$lambda8(list);
    }

    public static /* synthetic */ Boolean n(kotlin.o oVar) {
        return m1000getLatestTx$lambda18$lambda17$lambda16(oVar);
    }

    public final h.c.b0<ConsumerConnectionStatus> getConnectStatus() {
        h.c.b0<ConsumerConnectionStatus> just = h.c.b0.just(this.consumerUserRepository.getConnectStatus());
        kotlin.jvm.internal.m.f(just, "just(consumerUserRepository.getConnectStatus())");
        return just;
    }

    public final h.c.s<ConsumerConnectionStatus> getConsumerInfo() {
        h.c.s just = h.c.s.just(this.consumerUserRepository.getConnectStatus());
        kotlin.jvm.internal.m.f(just, "just(consumerUserRepository.getConnectStatus())");
        h.c.s flatMapObservable = h.c.b0.just(this.consumerUserRepository.getConnectStatus()).flatMapObservable(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.v0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerSettingViewModel.h(ConsumerSettingViewModel.this, (ConsumerConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapObservable, "just(consumerUserRepository.getConnectStatus())\n            .flatMapObservable { status ->\n                if (status is Connected && !status.hasRestrictions) {\n                    getAuthedConsumerInfo()\n                } else {\n                    Observable.just(status)\n                }\n            }");
        h.c.s<ConsumerConnectionStatus> mergeWith = just.mergeWith(flatMapObservable);
        kotlin.jvm.internal.m.f(mergeWith, "connectStatus.mergeWith(statusWithEmail)");
        return mergeWith;
    }

    public final h.c.s<Optional<ConsumerUser>> getConsumerUserObservable() {
        return this.consumerUserRepository.getUserObservable();
    }
}