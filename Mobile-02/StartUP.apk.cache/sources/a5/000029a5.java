package com.coinbase.wallet.wallets.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.apis.FiatCurrencyAPI;
import com.coinbase.wallet.wallets.daos.FiatCurrencyDAO;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* compiled from: FiatCurrencyRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b#\u0010$J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/wallets/repositories/FiatCurrencyRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "Lh/c/b0;", "", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "getCurrencies", "()Lh/c/b0;", "fiatCurrency", "Lkotlin/x;", "saveActiveCurrency", "(Lcom/coinbase/wallet/wallets/models/FiatCurrency;)V", "start", "()V", "", "destroy", "Lcom/coinbase/wallet/wallets/daos/FiatCurrencyDAO;", "fiatCurrencyDAO", "Lcom/coinbase/wallet/wallets/daos/FiatCurrencyDAO;", "Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;", "fiatCurrencyAPI", "Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;", "getActiveCurrency", "()Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "activeCurrency", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/s;", "activeCurrencyObservable", "Lh/c/s;", "getActiveCurrencyObservable", "()Lh/c/s;", "<init>", "(Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/wallets/daos/FiatCurrencyDAO;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FiatCurrencyRepository implements IFiatCurrencyRepository {
    private final h.c.s<FiatCurrency> activeCurrencyObservable;
    private final h.c.k0.a disposeBag;
    private final FiatCurrencyAPI fiatCurrencyAPI;
    private final FiatCurrencyDAO fiatCurrencyDAO;
    private final StoreInterface store;

    public FiatCurrencyRepository(FiatCurrencyAPI fiatCurrencyAPI, StoreInterface store, FiatCurrencyDAO fiatCurrencyDAO) {
        kotlin.jvm.internal.m.g(fiatCurrencyAPI, "fiatCurrencyAPI");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(fiatCurrencyDAO, "fiatCurrencyDAO");
        this.fiatCurrencyAPI = fiatCurrencyAPI;
        this.store = store;
        this.fiatCurrencyDAO = fiatCurrencyDAO;
        this.disposeBag = new h.c.k0.a();
        h.c.s<FiatCurrency> map = store.observe(StoreKeys_WalletsKt.getActiveCurrency(StoreKeys.INSTANCE)).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.wallets.repositories.FiatCurrencyRepository$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.FiatCurrencyRepository$special$$inlined$unwrap$2
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
        this.activeCurrencyObservable = map;
    }

    public static /* synthetic */ h.c.h0 b(FiatCurrencyRepository fiatCurrencyRepository, List list) {
        return m1869getCurrencies$lambda0(fiatCurrencyRepository, list);
    }

    public static /* synthetic */ h.c.h0 c(FiatCurrencyRepository fiatCurrencyRepository, kotlin.x xVar) {
        return m1871start$lambda2(fiatCurrencyRepository, xVar);
    }

    public static /* synthetic */ h.c.h0 d(FiatCurrencyRepository fiatCurrencyRepository, List list) {
        return m1872start$lambda3(fiatCurrencyRepository, list);
    }

    public static /* synthetic */ kotlin.x e(Throwable th) {
        return m1873start$lambda4(th);
    }

    public static /* synthetic */ kotlin.x f(FiatCurrencyRepository fiatCurrencyRepository) {
        return m1870start$lambda1(fiatCurrencyRepository);
    }

    /* renamed from: getCurrencies$lambda-0 */
    public static final h.c.h0 m1869getCurrencies$lambda0(FiatCurrencyRepository this$0, List currencies) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(currencies, "currencies");
        if (currencies.isEmpty()) {
            return this$0.fiatCurrencyAPI.getCurrencies();
        }
        h.c.b0 just = h.c.b0.just(currencies);
        kotlin.jvm.internal.m.f(just, "just(currencies)");
        return just;
    }

    /* renamed from: start$lambda-1 */
    public static final kotlin.x m1870start$lambda1(FiatCurrencyRepository this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        StoreInterface storeInterface = this$0.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        if (storeInterface.get(StoreKeys_WalletsKt.getActiveCurrency(storeKeys)) == null) {
            this$0.store.set(StoreKeys_WalletsKt.getActiveCurrency(storeKeys), FiatCurrency.Companion.getUSD());
        }
        return kotlin.x.a;
    }

    /* renamed from: start$lambda-2 */
    public static final h.c.h0 m1871start$lambda2(FiatCurrencyRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.fiatCurrencyAPI.getCurrencies();
    }

    /* renamed from: start$lambda-3 */
    public static final h.c.h0 m1872start$lambda3(FiatCurrencyRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.fiatCurrencyDAO.save(it);
    }

    /* renamed from: start$lambda-4 */
    public static final kotlin.x m1873start$lambda4(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        this.disposeBag.d();
        kotlin.x xVar = kotlin.x.a;
        h.c.b0<Boolean> just = h.c.b0.just(Boolean.TRUE);
        kotlin.jvm.internal.m.f(just, "disposeBag.clear().run { Single.just(true) }");
        return just;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository
    public FiatCurrency getActiveCurrency() {
        FiatCurrency fiatCurrency = (FiatCurrency) this.store.get(StoreKeys_WalletsKt.getActiveCurrency(StoreKeys.INSTANCE));
        return fiatCurrency == null ? FiatCurrency.Companion.getUSD() : fiatCurrency;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository
    public h.c.s<FiatCurrency> getActiveCurrencyObservable() {
        return this.activeCurrencyObservable;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository
    public h.c.b0<List<FiatCurrency>> getCurrencies() {
        h.c.b0 flatMap = this.fiatCurrencyDAO.getCurrencies().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FiatCurrencyRepository.b(FiatCurrencyRepository.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "fiatCurrencyDAO.getCurrencies()\n        .flatMap { currencies ->\n            if (currencies.isEmpty()) fiatCurrencyAPI.getCurrencies() else Single.just(currencies)\n        }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository
    public void saveActiveCurrency(FiatCurrency fiatCurrency) {
        kotlin.jvm.internal.m.g(fiatCurrency, "fiatCurrency");
        this.store.set(StoreKeys_WalletsKt.getActiveCurrency(StoreKeys.INSTANCE), fiatCurrency);
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.b0 flatMap = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.wallets.repositories.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FiatCurrencyRepository.f(FiatCurrencyRepository.this);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FiatCurrencyRepository.c(FiatCurrencyRepository.this, (kotlin.x) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FiatCurrencyRepository.d(FiatCurrencyRepository.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "fromCallable {\n                if (store.get(StoreKeys.activeCurrency) == null) {\n                    store.set(StoreKeys.activeCurrency, FiatCurrency.USD)\n                }\n            }\n            .flatMap { fiatCurrencyAPI.getCurrencies() }\n            .flatMap { fiatCurrencyDAO.save(it) }");
        h.c.k0.b subscribe = Single_AnalyticsKt.logError$default(Single_CoreKt.asUnit(flatMap), "Unable to fetch latest fiat currency list on startup", null, 2, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FiatCurrencyRepository.e((Throwable) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "fromCallable {\n                if (store.get(StoreKeys.activeCurrency) == null) {\n                    store.set(StoreKeys.activeCurrency, FiatCurrency.USD)\n                }\n            }\n            .flatMap { fiatCurrencyAPI.getCurrencies() }\n            .flatMap { fiatCurrencyDAO.save(it) }\n            .asUnit()\n            .logError(\"Unable to fetch latest fiat currency list on startup\")\n            .onErrorReturn { Unit }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }
}