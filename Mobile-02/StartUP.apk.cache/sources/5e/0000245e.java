package com.coinbase.wallet.lending.repositories;

import android.annotation.SuppressLint;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.RefreshInterval;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.lending.apis.LendAPI;
import com.coinbase.wallet.lending.daos.LendTokenDAO;
import com.coinbase.wallet.lending.exceptions.LendException;
import com.coinbase.wallet.lending.extensions.StoreKeys_LendKt;
import com.coinbase.wallet.lending.extensions.TraceLogger_LendKt;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.interfaces.LendManaging;
import com.coinbase.wallet.lending.interfaces.TokenResult;
import com.coinbase.wallet.lending.models.LendInterest;
import com.coinbase.wallet.lending.models.LendProvider;
import com.coinbase.wallet.lending.models.LendProviderID;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import h.c.b0;
import h.c.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.s0;
import kotlin.a0.z;
import kotlin.x;

/* compiled from: LendRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\bF\u0010GJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00140\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J-\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010\"R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010+\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R0\u00100\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 **\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010%R$\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R(\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0005060\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/coinbase/wallet/lending/repositories/LendRepository;", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "Lcom/coinbase/wallet/lending/models/LendProvider;", "provider", "Lh/c/b0;", "Lcom/coinbase/wallet/lending/interfaces/LendManaging;", "getService", "(Lcom/coinbase/wallet/lending/models/LendProvider;)Lh/c/b0;", "Lkotlin/x;", "start", "()V", "", "isForced", "refresh", "(Z)Lh/c/b0;", "Lcom/coinbase/wallet/core/interfaces/RefreshInterval;", "interval", "updateRefreshInterval", "(Lcom/coinbase/wallet/core/interfaces/RefreshInterval;)V", "Lh/c/s;", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "observeTokens", "()Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "address", "Lcom/coinbase/wallet/lending/models/LendInterest;", "getLifetimeInterestEarned", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;)Lh/c/b0;", ApiConstants.TOKEN, "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "supply", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "withdraw", "primaryETHAddressObservable", "Lh/c/s;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/v0/a;", "kotlin.jvm.PlatformType", "isReadySubject", "Lh/c/v0/a;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "tokensObservable", "<set-?>", "refreshInterval", "Lcom/coinbase/wallet/core/interfaces/RefreshInterval;", "getRefreshInterval", "()Lcom/coinbase/wallet/core/interfaces/RefreshInterval;", "", "Lcom/coinbase/wallet/lending/models/LendProviderID;", "getServicesSingle", "()Lh/c/b0;", "servicesSingle", "Lcom/coinbase/wallet/lending/daos/LendTokenDAO;", "dao", "Lcom/coinbase/wallet/lending/daos/LendTokenDAO;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lcom/coinbase/wallet/lending/apis/LendAPI;", "lendAPI", "Lcom/coinbase/wallet/lending/apis/LendAPI;", "services", "Ljava/util/List;", "<init>", "(Lcom/coinbase/wallet/lending/daos/LendTokenDAO;Lh/c/s;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/lending/apis/LendAPI;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendRepository implements ILendRepository {
    private final LendTokenDAO dao;
    private final h.c.k0.a disposeBag;
    private final h.c.v0.a<x> isReadySubject;
    private final LendAPI lendAPI;
    private final h.c.s<WalletAddress> primaryETHAddressObservable;
    private volatile RefreshInterval refreshInterval;
    private volatile List<? extends LendManaging> services;
    private final StoreInterface store;
    private final h.c.s<List<LendToken>> tokensObservable;
    private final Tracing tracer;

    public LendRepository(LendTokenDAO dao, h.c.s<WalletAddress> primaryETHAddressObservable, Tracing tracer, LendAPI lendAPI, StoreInterface store) {
        List<? extends LendManaging> g2;
        kotlin.jvm.internal.m.g(dao, "dao");
        kotlin.jvm.internal.m.g(primaryETHAddressObservable, "primaryETHAddressObservable");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        kotlin.jvm.internal.m.g(lendAPI, "lendAPI");
        kotlin.jvm.internal.m.g(store, "store");
        this.dao = dao;
        this.primaryETHAddressObservable = primaryETHAddressObservable;
        this.tracer = tracer;
        this.lendAPI = lendAPI;
        this.store = store;
        g2 = kotlin.a0.r.g();
        this.services = g2;
        this.disposeBag = new h.c.k0.a();
        h.c.v0.a<x> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<Unit>()");
        this.isReadySubject = d2;
        h.c.s map = d2.take(1L).switchMap(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.o(LendRepository.this, (x) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.t((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "isReadySubject\n        .take(1)\n        .switchMap {\n            Observables.combineLatest(\n                primaryETHAddressObservable.distinctUntilChanged(),\n                dao.observeTokens()\n            )\n        }\n        .map { (address, tokens) -> tokens.filter { it.walletAddress == address.address } }");
        this.tokensObservable = Observable_CoreKt.replayingShare$default(map, null, 1, null);
        this.refreshInterval = RefreshInterval.FIVE_MIN;
    }

    /* renamed from: _get_servicesSingle_$lambda-5 */
    public static final Map m1587_get_servicesSingle_$lambda5(List it) {
        int r;
        Map r2;
        kotlin.jvm.internal.m.g(it, "it");
        r = kotlin.a0.s.r(it, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            kotlin.o oVar = (kotlin.o) it2.next();
            arrayList.add(kotlin.u.a(((LendProvider) oVar.a()).getId(), (LendManaging) oVar.b()));
        }
        r2 = m0.r(arrayList);
        return r2;
    }

    public static /* synthetic */ h0 b(LendToken lendToken, WalletAddress walletAddress, TransferValue transferValue, LendManaging lendManaging) {
        return m1605supply$lambda27(lendToken, walletAddress, transferValue, lendManaging);
    }

    public static /* synthetic */ h0 c(LendRepository lendRepository, kotlin.o oVar) {
        return m1594refresh$lambda22$lambda18(lendRepository, oVar);
    }

    public static /* synthetic */ List d(LendRepository lendRepository, Set set) {
        return m1603start$lambda8(lendRepository, set);
    }

    public static /* synthetic */ h0 e(LendRepository lendRepository, WalletAddress walletAddress) {
        return m1599start$lambda10(lendRepository, walletAddress);
    }

    public static /* synthetic */ LendManaging f(LendProvider lendProvider, Map map) {
        return m1591getService$lambda29(lendProvider, map);
    }

    public static /* synthetic */ Map g(List list) {
        return m1587_get_servicesSingle_$lambda5(list);
    }

    /* renamed from: getLifetimeInterestEarned$lambda-26 */
    public static final h0 m1588getLifetimeInterestEarned$lambda26(WalletAddress address, Map services) {
        int r;
        b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(services, "services");
        Collection<LendManaging> values = services.values();
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendManaging lendManaging : values) {
            arrayList.add(lendManaging.getLifetimeInterestEarned(address));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.LendRepository$getLifetimeInterestEarned$lambda-26$$inlined$zipOrEmpty$1
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
                        if (obj instanceof List) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.r((List) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.v((Throwable) obj);
            }
        });
    }

    /* renamed from: getLifetimeInterestEarned$lambda-26$lambda-24 */
    public static final List m1589getLifetimeInterestEarned$lambda26$lambda24(List it) {
        List u;
        kotlin.jvm.internal.m.g(it, "it");
        u = kotlin.a0.s.u(it);
        return u;
    }

    /* renamed from: getLifetimeInterestEarned$lambda-26$lambda-25 */
    public static final List m1590getLifetimeInterestEarned$lambda26$lambda25(Throwable it) {
        List g2;
        kotlin.jvm.internal.m.g(it, "it");
        g2 = kotlin.a0.r.g();
        return g2;
    }

    private final b0<LendManaging> getService(final LendProvider lendProvider) {
        b0 map = getServicesSingle().map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.f(LendProvider.this, (Map) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "servicesSingle\n        .map { services -> services[provider.id] ?: throw LendException.UnableToGetLendService }");
        return map;
    }

    /* renamed from: getService$lambda-29 */
    public static final LendManaging m1591getService$lambda29(LendProvider provider, Map services) {
        kotlin.jvm.internal.m.g(provider, "$provider");
        kotlin.jvm.internal.m.g(services, "services");
        LendManaging lendManaging = (LendManaging) services.get(provider.getId());
        if (lendManaging != null) {
            return lendManaging;
        }
        throw LendException.UnableToGetLendService.INSTANCE;
    }

    private final b0<Map<LendProviderID, LendManaging>> getServicesSingle() {
        int r;
        b0 zip;
        List g2;
        List<? extends LendManaging> list = this.services;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendManaging lendManaging : list) {
            b0<LendProvider> provider = lendManaging.getProvider();
            b0 just = b0.just(lendManaging);
            kotlin.jvm.internal.m.f(just, "just(service)");
            arrayList.add(h.c.t0.f.a(provider, just));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.LendRepository$special$$inlined$zipOrEmpty$1
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
        }
        b0<Map<LendProviderID, LendManaging>> map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.g((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "services\n                .map { service -> service.provider.zipWith(Single.just(service)) }\n                .zipOrEmpty()\n                .map { it.map { (provider, service) -> provider.id to service }.toMap() }");
        return map;
    }

    public static /* synthetic */ h0 h(WalletAddress walletAddress, Map map) {
        return m1588getLifetimeInterestEarned$lambda26(walletAddress, map);
    }

    public static /* synthetic */ x i(Optional optional) {
        return m1597refresh$lambda22$lambda20(optional);
    }

    public static /* synthetic */ x j(LendRepository lendRepository, List list, List list2) {
        return m1604start$lambda9(lendRepository, list, list2);
    }

    public static /* synthetic */ kotlin.o k(List list) {
        return m1593refresh$lambda22$lambda16(list);
    }

    public static /* synthetic */ h0 l(LendRepository lendRepository, kotlin.o oVar) {
        return m1592refresh$lambda22(lendRepository, oVar);
    }

    public static /* synthetic */ List m(List list, x xVar) {
        return m1595refresh$lambda22$lambda18$lambda17(list, xVar);
    }

    public static /* synthetic */ x n(Throwable th) {
        return m1598refresh$lambda22$lambda21(th);
    }

    public static /* synthetic */ h.c.x o(LendRepository lendRepository, x xVar) {
        return m1606tokensObservable$lambda0(lendRepository, xVar);
    }

    public static /* synthetic */ x p(Throwable th) {
        return m1600start$lambda11(th);
    }

    public static /* synthetic */ h0 q(LendToken lendToken, WalletAddress walletAddress, TransferValue transferValue, LendManaging lendManaging) {
        return m1608withdraw$lambda28(lendToken, walletAddress, transferValue, lendManaging);
    }

    public static /* synthetic */ List r(List list) {
        return m1589getLifetimeInterestEarned$lambda26$lambda24(list);
    }

    /* renamed from: refresh$lambda-22 */
    public static final h0 m1592refresh$lambda22(LendRepository this$0, kotlin.o dstr$services$walletAddress) {
        int r;
        b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$services$walletAddress, "$dstr$services$walletAddress");
        WalletAddress walletAddress = (WalletAddress) dstr$services$walletAddress.b();
        Collection<LendManaging> values = ((Map) dstr$services$walletAddress.a()).values();
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendManaging lendManaging : values) {
            kotlin.jvm.internal.m.f(walletAddress, "walletAddress");
            arrayList.add(lendManaging.getTokens(walletAddress));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.LendRepository$refresh$lambda-22$$inlined$zipOrEmpty$1
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
                        if (obj instanceof TokenResult) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        b0 map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.k((List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.c(LendRepository.this, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.u(LendRepository.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.i((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "services.values.map { service -> service.getTokens(address = walletAddress) }\n                .zipOrEmpty()\n                .map { tokenResults ->\n                    val allTokens = tokenResults.map { it.tokens }.flatten()\n                    val shouldDeleteTokens = tokenResults.all { it.wasSuccessfulFetch }\n                    Pair(allTokens, shouldDeleteTokens)\n                }\n                .flatMap { (allTokens, shouldClearTokenTable) ->\n                    if (shouldClearTokenTable) {\n                        dao.deleteAll()\n                            .map { allTokens }\n                    } else {\n                        Single.just(allTokens)\n                    }\n                }\n                .flatMap { dao.save(tokens = it) }\n                .map { Unit }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.n((Throwable) obj);
            }
        });
    }

    /* renamed from: refresh$lambda-22$lambda-16 */
    public static final kotlin.o m1593refresh$lambda22$lambda16(List tokenResults) {
        int r;
        List u;
        kotlin.jvm.internal.m.g(tokenResults, "tokenResults");
        r = kotlin.a0.s.r(tokenResults, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = tokenResults.iterator();
        while (it.hasNext()) {
            arrayList.add(((TokenResult) it.next()).getTokens());
        }
        u = kotlin.a0.s.u(arrayList);
        boolean z = true;
        if (!(tokenResults instanceof Collection) || !tokenResults.isEmpty()) {
            Iterator it2 = tokenResults.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (!((TokenResult) it2.next()).getWasSuccessfulFetch()) {
                    z = false;
                    break;
                }
            }
        }
        return new kotlin.o(u, Boolean.valueOf(z));
    }

    /* renamed from: refresh$lambda-22$lambda-18 */
    public static final h0 m1594refresh$lambda22$lambda18(LendRepository this$0, kotlin.o dstr$allTokens$shouldClearTokenTable) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$allTokens$shouldClearTokenTable, "$dstr$allTokens$shouldClearTokenTable");
        final List list = (List) dstr$allTokens$shouldClearTokenTable.a();
        if (((Boolean) dstr$allTokens$shouldClearTokenTable.b()).booleanValue()) {
            return this$0.dao.deleteAll().map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.l
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return LendRepository.m(list, (x) obj);
                }
            });
        }
        return b0.just(list);
    }

    /* renamed from: refresh$lambda-22$lambda-18$lambda-17 */
    public static final List m1595refresh$lambda22$lambda18$lambda17(List allTokens, x it) {
        kotlin.jvm.internal.m.g(allTokens, "$allTokens");
        kotlin.jvm.internal.m.g(it, "it");
        return allTokens;
    }

    /* renamed from: refresh$lambda-22$lambda-19 */
    public static final h0 m1596refresh$lambda22$lambda19(LendRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.dao.save(it);
    }

    /* renamed from: refresh$lambda-22$lambda-20 */
    public static final x m1597refresh$lambda22$lambda20(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    /* renamed from: refresh$lambda-22$lambda-21 */
    public static final x m1598refresh$lambda22$lambda21(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static /* synthetic */ h0 s(LendRepository lendRepository, x xVar) {
        return m1601start$lambda12(lendRepository, xVar);
    }

    /* renamed from: start$lambda-10 */
    public static final h0 m1599start$lambda10(LendRepository this$0, WalletAddress it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.refresh(true);
    }

    /* renamed from: start$lambda-11 */
    public static final x m1600start$lambda11(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    /* renamed from: start$lambda-12 */
    public static final h0 m1601start$lambda12(LendRepository this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.refresh(true);
    }

    /* renamed from: start$lambda-6 */
    public static final void m1602start$lambda6(LendRepository this$0, Set set) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.store.set(StoreKeys_LendKt.getLendProviderIDs(StoreKeys.INSTANCE), set);
    }

    /* renamed from: start$lambda-8 */
    public static final List m1603start$lambda8(LendRepository this$0, Set remoteProviderIDs) {
        int r;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(remoteProviderIDs, "remoteProviderIDs");
        r = kotlin.a0.s.r(remoteProviderIDs, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = remoteProviderIDs.iterator();
        while (it.hasNext()) {
            arrayList.add(new RemoteLendService((String) it.next(), this$0.lendAPI));
        }
        return arrayList;
    }

    /* renamed from: start$lambda-9 */
    public static final x m1604start$lambda9(LendRepository this$0, List services, List remoteServices) {
        List<? extends LendManaging> t0;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(services, "$services");
        kotlin.jvm.internal.m.g(remoteServices, "remoteServices");
        t0 = z.t0(services, remoteServices);
        this$0.services = t0;
        return x.a;
    }

    /* renamed from: supply$lambda-27 */
    public static final h0 m1605supply$lambda27(LendToken token, WalletAddress address, TransferValue amount, LendManaging service) {
        kotlin.jvm.internal.m.g(token, "$token");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(service, "service");
        if (kotlin.jvm.internal.m.c(token.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) {
            return service.supplyETH(address, amount);
        }
        if (token.getContractAddress() != null) {
            return service.supplyERC20(address, token.getContractAddress(), token.getCurrencyCode(), amount);
        }
        throw new LendException.UnableToSupply(null, 1, null);
    }

    public static /* synthetic */ List t(kotlin.o oVar) {
        return m1607tokensObservable$lambda2(oVar);
    }

    /* renamed from: tokensObservable$lambda-0 */
    public static final h.c.x m1606tokensObservable$lambda0(LendRepository this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s<WalletAddress> distinctUntilChanged = this$0.primaryETHAddressObservable.distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "primaryETHAddressObservable.distinctUntilChanged()");
        return cVar.a(distinctUntilChanged, this$0.dao.observeTokens());
    }

    /* renamed from: tokensObservable$lambda-2 */
    public static final List m1607tokensObservable$lambda2(kotlin.o dstr$address$tokens) {
        kotlin.jvm.internal.m.g(dstr$address$tokens, "$dstr$address$tokens");
        WalletAddress walletAddress = (WalletAddress) dstr$address$tokens.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) dstr$address$tokens.b()) {
            if (kotlin.jvm.internal.m.c(((LendToken) obj).getWalletAddress(), walletAddress.getAddress())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ h0 u(LendRepository lendRepository, List list) {
        return m1596refresh$lambda22$lambda19(lendRepository, list);
    }

    public static /* synthetic */ List v(Throwable th) {
        return m1590getLifetimeInterestEarned$lambda26$lambda25(th);
    }

    public static /* synthetic */ void w(LendRepository lendRepository, Set set) {
        m1602start$lambda6(lendRepository, set);
    }

    /* renamed from: withdraw$lambda-28 */
    public static final h0 m1608withdraw$lambda28(LendToken token, WalletAddress address, TransferValue amount, LendManaging service) {
        kotlin.jvm.internal.m.g(token, "$token");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(service, "service");
        if (kotlin.jvm.internal.m.c(token.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) {
            return service.withdrawETH(address, amount);
        }
        if (token.getContractAddress() != null) {
            return service.withdrawERC20(address, token.getContractAddress(), token.getCurrencyCode(), amount);
        }
        throw new LendException.UnableToWithdraw(null, 1, null);
    }

    @Override // com.coinbase.wallet.lending.interfaces.ILendRepository
    public b0<List<LendInterest>> getLifetimeInterestEarned(final WalletAddress address) {
        kotlin.jvm.internal.m.g(address, "address");
        b0 flatMap = getServicesSingle().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.h(WalletAddress.this, (Map) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "servicesSingle\n            .flatMap { services ->\n                services.values.map { it.getLifetimeInterestEarned(address = address) }\n                    .zipOrEmpty()\n                    .map { it.flatten() }\n                    .onErrorReturn { emptyList() }\n            }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.core.interfaces.RefreshIntervalCustomizable
    public RefreshInterval getRefreshInterval() {
        return this.refreshInterval;
    }

    @Override // com.coinbase.wallet.lending.interfaces.ILendRepository
    public h.c.s<List<LendToken>> observeTokens() {
        return this.tokensObservable;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public b0<x> refresh(boolean z) {
        b0 flatMap = h.c.t0.e.a.a(getServicesSingle(), Observable_CoreKt.takeSingle(this.primaryETHAddressObservable)).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.l(LendRepository.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Singles\n        .zip(servicesSingle, primaryETHAddressObservable.takeSingle())\n        .flatMap { (services, walletAddress) ->\n            services.values.map { service -> service.getTokens(address = walletAddress) }\n                .zipOrEmpty()\n                .map { tokenResults ->\n                    val allTokens = tokenResults.map { it.tokens }.flatten()\n                    val shouldDeleteTokens = tokenResults.all { it.wasSuccessfulFetch }\n                    Pair(allTokens, shouldDeleteTokens)\n                }\n                .flatMap { (allTokens, shouldClearTokenTable) ->\n                    if (shouldClearTokenTable) {\n                        dao.deleteAll()\n                            .map { allTokens }\n                    } else {\n                        Single.just(allTokens)\n                    }\n                }\n                .flatMap { dao.save(tokens = it) }\n                .map { Unit }\n                .logError()\n                .onErrorReturn { Unit }\n        }");
        b0<x> trace = Single_CoreKt.trace(flatMap, TraceLogger_LendKt.repositoryRefreshTrace(Tracing.Companion), this.tracer);
        kotlin.jvm.internal.m.f(trace, "Singles\n        .zip(servicesSingle, primaryETHAddressObservable.takeSingle())\n        .flatMap { (services, walletAddress) ->\n            services.values.map { service -> service.getTokens(address = walletAddress) }\n                .zipOrEmpty()\n                .map { tokenResults ->\n                    val allTokens = tokenResults.map { it.tokens }.flatten()\n                    val shouldDeleteTokens = tokenResults.all { it.wasSuccessfulFetch }\n                    Pair(allTokens, shouldDeleteTokens)\n                }\n                .flatMap { (allTokens, shouldClearTokenTable) ->\n                    if (shouldClearTokenTable) {\n                        dao.deleteAll()\n                            .map { allTokens }\n                    } else {\n                        Single.just(allTokens)\n                    }\n                }\n                .flatMap { dao.save(tokens = it) }\n                .map { Unit }\n                .logError()\n                .onErrorReturn { Unit }\n        }\n        .trace(Tracing.repositoryRefreshTrace(), tracer)");
        return trace;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    @SuppressLint({"CheckResult"})
    public void start() {
        final List<? extends LendManaging> list = this.services;
        Object obj = this.store.get(StoreKeys_LendKt.getLendProviderIDs(StoreKeys.INSTANCE));
        Set set = obj instanceof Set ? (Set) obj : null;
        if (set == null) {
            set = s0.b();
        }
        h.c.s just = h.c.s.just(set);
        kotlin.jvm.internal.m.f(just, "just(cachedLendProviderIDs)");
        h.c.s map = h.c.s.merge(this.lendAPI.getLendProviderIds().doAfterSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.lending.repositories.v
            @Override // h.c.m0.f
            public final void accept(Object obj2) {
                LendRepository.w(LendRepository.this, (Set) obj2);
            }
        }).toObservable(), just).distinctUntilChanged().map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return LendRepository.d(LendRepository.this, (Set) obj2);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return LendRepository.j(LendRepository.this, list, (List) obj2);
            }
        });
        kotlin.jvm.internal.m.f(map, "merge(lendProviderRefreshObservable, cachedLendProviderObservable)\n            .distinctUntilChanged()\n            .map { remoteProviderIDs ->\n                remoteProviderIDs.map { providerID ->\n                    RemoteLendService(providerID, lendAPI)\n                }\n            }\n            .map { remoteServices ->\n                this.services = services + remoteServices\n            }");
        h.c.t0.a.a(h.c.t0.g.h(map, new LendRepository$start$3(this), null, new LendRepository$start$4(this), 2, null), this.disposeBag);
        h.c.s onErrorReturn = this.primaryETHAddressObservable.distinctUntilChanged().skip(1L).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return LendRepository.e(LendRepository.this, (WalletAddress) obj2);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.o
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return LendRepository.p((Throwable) obj2);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "primaryETHAddressObservable.distinctUntilChanged()\n            .skip(1)\n            .flatMapSingle { refresh(true) }\n            .onErrorReturn { Unit }");
        h.c.t0.a.a(h.c.t0.g.h(onErrorReturn, null, null, null, 7, null), this.disposeBag);
        h.c.s<R> flatMapSingle = this.isReadySubject.flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.r
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return LendRepository.s(LendRepository.this, (x) obj2);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "isReadySubject\n            .flatMapSingle { refresh(true) }");
        h.c.t0.a.a(h.c.t0.g.h(flatMapSingle, null, null, null, 7, null), this.disposeBag);
    }

    @Override // com.coinbase.wallet.lending.interfaces.ILendRepository
    public b0<List<EthereumUnsigned1559Tx>> supply(final WalletAddress address, final LendToken token, final TransferValue amount) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(token, "token");
        kotlin.jvm.internal.m.g(amount, "amount");
        b0 flatMap = getService(token.getProvider()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.b(LendToken.this, address, amount, (LendManaging) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "getService(token.provider)\n        .flatMap { service ->\n            when {\n                token.currencyCode == CurrencyCode.ETH -> {\n                    service.supplyETH(address = address, amount = amount)\n                }\n                token.contractAddress != null -> {\n                    service.supplyERC20(\n                        address = address,\n                        contractAddress = token.contractAddress,\n                        currencyCode = token.currencyCode,\n                        amount = amount\n                    )\n                }\n                else -> {\n                    throw LendException.UnableToSupply()\n                }\n            }\n        }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.core.interfaces.RefreshIntervalCustomizable
    public void updateRefreshInterval(RefreshInterval interval) {
        kotlin.jvm.internal.m.g(interval, "interval");
        this.refreshInterval = interval;
    }

    @Override // com.coinbase.wallet.lending.interfaces.ILendRepository
    public b0<EthereumUnsigned1559Tx> withdraw(final WalletAddress address, final LendToken token, final TransferValue amount) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(token, "token");
        kotlin.jvm.internal.m.g(amount, "amount");
        b0 flatMap = getService(token.getProvider()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.lending.repositories.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendRepository.q(LendToken.this, address, amount, (LendManaging) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "getService(provider = token.provider)\n        .flatMap { service ->\n            when {\n                token.currencyCode == CurrencyCode.ETH -> {\n                    service.withdrawETH(address = address, amount = amount)\n                }\n                token.contractAddress != null -> {\n                    service.withdrawERC20(\n                        address = address,\n                        contractAddress = token.contractAddress,\n                        currencyCode = token.currencyCode,\n                        amount = amount\n                    )\n                }\n                else -> {\n                    throw LendException.UnableToWithdraw()\n                }\n            }\n        }");
        return flatMap;
    }
}