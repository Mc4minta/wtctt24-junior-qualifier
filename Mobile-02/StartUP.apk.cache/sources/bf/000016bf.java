package com.coinbase.wallet.consumer.repositories;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.Coinbase;
import com.coinbase.resources.accounts.Account;
import com.coinbase.resources.accounts.Currency;
import com.coinbase.resources.addresses.Address;
import com.coinbase.resources.transactions.MoneyHash;
import com.coinbase.resources.transactions.entities.AddressInfo;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.daos.ConsumerAccountsDAO;
import com.coinbase.wallet.consumer.dtos.ConsumerAppInfoDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerWalletAddressDTO;
import com.coinbase.wallet.consumer.dtos.PutConsumerWalletAddressRequestDTO;
import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.consumer.extensions.TraceKey_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAddress;
import com.coinbase.wallet.consumer.models.ConsumerAsset;
import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Singles_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.Four;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.ripple.extensions.TxMetadataKey_RippleKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.user.extensions.StoreKeys_UserKt;
import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.coinbase.wallet.user.models.LegacyUser;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: ConsumerAccountsRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BI\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010V\u001a\u00020U¢\u0006\u0004\b^\u0010_J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\u0014\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ=\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#0\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\"0\nH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010(J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016¢\u0006\u0004\b*\u0010\u001fJ\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\tJ\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\u001fJ+\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b-\u0010\u001dR\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00109\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001b0@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR0\u0010E\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 D*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n0\n0C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR%\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0G8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010?R\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006`"}, d2 = {"Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "", "forceSignOut", "Lh/c/b0;", "Lkotlin/x;", "deleteAccounts", "(Z)Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallets", "Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "supportedCurrencies", "Lcom/coinbase/wallet/user/models/User;", ApiConstants.USER, "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", ApiConstants.ACCOUNTS, "Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", "buildPutConsumerWalletAddressRequest", "(Ljava/util/List;Ljava/util/List;Lcom/coinbase/wallet/user/models/User;Ljava/util/List;)Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/consumer/models/ConsumerAddress;", "resolveConsumerUserAddress", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lh/c/b0;", "getAccounts", "()Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerAsset;", "assets", "Lcom/coinbase/resources/accounts/Account;", "", "", "getAssetImages", "(Ljava/util/List;Ljava/util/List;)Lh/c/b0;", "observeConsumerAccessToken", "()V", "start", "destroy", "isForced", "refresh", "resolveAddress", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "consumerAPI", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "Lh/c/a0;", "concurrentScheduler$delegate", "Lkotlin/h;", "getConcurrentScheduler", "()Lh/c/a0;", "concurrentScheduler", "Lcom/coinbase/Coinbase;", "coinbaseApi", "Lcom/coinbase/Coinbase;", "Lh/c/k0/a;", "coinsDisposeBag", "Lh/c/k0/a;", "", "resolvedAddressCache", "Ljava/util/Map;", "Lh/c/v0/a;", "kotlin.jvm.PlatformType", "accountsSubject", "Lh/c/v0/a;", "Lh/c/s;", "accountsObservable", "Lh/c/s;", "getAccountsObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/consumer/daos/ConsumerAccountsDAO;", "consumerAccountsDAO", "Lcom/coinbase/wallet/consumer/daos/ConsumerAccountsDAO;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletsRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;", "userDao", "Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "disposeBag", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "resolvedAddressCacheScheduler", "Lh/c/a0;", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/consumer/daos/ConsumerAccountsDAO;Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;Lcom/coinbase/Coinbase;Lcom/coinbase/wallet/user/repositories/UserRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountsRepository implements Refreshable, Startable, Destroyable {
    private final h.c.s<List<ConsumerAccount>> accountsObservable;
    private final h.c.v0.a<List<ConsumerAccount>> accountsSubject;
    private final Coinbase coinbaseApi;
    private final h.c.k0.a coinsDisposeBag;
    private final kotlin.h concurrentScheduler$delegate;
    private final ConsumerAPI consumerAPI;
    private final ConsumerAccountsDAO consumerAccountsDAO;
    private final h.c.k0.a disposeBag;
    private final Map<String, ConsumerAddress> resolvedAddressCache;
    private final h.c.a0 resolvedAddressCacheScheduler;
    private final StoreInterface store;
    private final Tracing tracer;
    private final UserDaoInterface userDao;
    private final UserRepository userRepository;
    private final IWalletRepository walletsRepository;

    public ConsumerAccountsRepository(StoreInterface store, ConsumerAccountsDAO consumerAccountsDAO, ConsumerAPI consumerAPI, Coinbase coinbaseApi, UserRepository userRepository, IWalletRepository walletsRepository, UserDaoInterface userDao, Tracing tracer) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(consumerAccountsDAO, "consumerAccountsDAO");
        kotlin.jvm.internal.m.g(consumerAPI, "consumerAPI");
        kotlin.jvm.internal.m.g(coinbaseApi, "coinbaseApi");
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(walletsRepository, "walletsRepository");
        kotlin.jvm.internal.m.g(userDao, "userDao");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.store = store;
        this.consumerAccountsDAO = consumerAccountsDAO;
        this.consumerAPI = consumerAPI;
        this.coinbaseApi = coinbaseApi;
        this.userRepository = userRepository;
        this.walletsRepository = walletsRepository;
        this.userDao = userDao;
        this.tracer = tracer;
        h.c.v0.a<List<ConsumerAccount>> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<List<ConsumerAccount>>()");
        this.accountsSubject = d2;
        b2 = kotlin.k.b(ConsumerAccountsRepository$concurrentScheduler$2.INSTANCE);
        this.concurrentScheduler$delegate = b2;
        this.disposeBag = new h.c.k0.a();
        this.coinsDisposeBag = new h.c.k0.a();
        this.resolvedAddressCache = new LinkedHashMap();
        this.resolvedAddressCacheScheduler = RxSchedulers.INSTANCE.newSerialScheduler();
        h.c.s<List<ConsumerAccount>> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "accountsSubject.hide()");
        this.accountsObservable = hide;
    }

    public static /* synthetic */ boolean A(ConsumerAccountsRepository consumerAccountsRepository, Optional optional) {
        return m903start$lambda3(consumerAccountsRepository, optional);
    }

    public static /* synthetic */ boolean B(List list) {
        return m873observeConsumerAccessToken$lambda49(list);
    }

    public static /* synthetic */ ConsumerAccount C(CurrencyCode currencyCode, List list) {
        return m894resolveConsumerUserAddress$lambda30(currencyCode, list);
    }

    public static /* synthetic */ h.c.h0 D(Throwable th) {
        return m863deleteAccounts$lambda18$lambda17(th);
    }

    public static /* synthetic */ kotlin.x E(ConsumerAccountsRepository consumerAccountsRepository, List list) {
        return m885refresh$lambda11(consumerAccountsRepository, list);
    }

    public static /* synthetic */ h.c.x F(ConsumerAccountsRepository consumerAccountsRepository, Four four) {
        return m877observeConsumerAccessToken$lambda54(consumerAccountsRepository, four);
    }

    public static /* synthetic */ boolean G(kotlin.o oVar) {
        return m883observeConsumerAccessToken$lambda59(oVar);
    }

    public static /* synthetic */ Boolean H(kotlin.x xVar) {
        return m867destroy$lambda5(xVar);
    }

    public static /* synthetic */ h.c.h0 I(ConsumerAccountsRepository consumerAccountsRepository, kotlin.t tVar) {
        return m875observeConsumerAccessToken$lambda52(consumerAccountsRepository, tVar);
    }

    public static /* synthetic */ Optional J(Blockchain blockchain, ConsumerAccountsRepository consumerAccountsRepository, CurrencyCode currencyCode, Address address) {
        return m897resolveConsumerUserAddress$lambda35(blockchain, consumerAccountsRepository, currencyCode, address);
    }

    public static /* synthetic */ kotlin.x K(ConsumerAccountsRepository consumerAccountsRepository, List list) {
        return m887refresh$lambda6(consumerAccountsRepository, list);
    }

    public static /* synthetic */ h.c.h0 L(ConsumerAccountsRepository consumerAccountsRepository, kotlin.x xVar) {
        return m888refresh$lambda7(consumerAccountsRepository, xVar);
    }

    public static /* synthetic */ kotlin.o M(Account account, ConsumerAsset consumerAsset) {
        return m870getAssetImages$lambda46$lambda45(account, consumerAsset);
    }

    public static /* synthetic */ List N(Throwable th) {
        return m876observeConsumerAccessToken$lambda52$lambda51(th);
    }

    public static /* synthetic */ h.c.h0 O(ConsumerAccountsRepository consumerAccountsRepository, List list) {
        return m884refresh$lambda10(consumerAccountsRepository, list);
    }

    public static /* synthetic */ kotlin.x P(ConsumerAccountsRepository consumerAccountsRepository, Boolean bool) {
        return m901start$lambda1(consumerAccountsRepository, bool);
    }

    public static /* synthetic */ List Q(List list, Boolean bool) {
        return m890refresh$lambda9$lambda8(list, bool);
    }

    public static /* synthetic */ Boolean R(Optional optional) {
        return m900start$lambda0(optional);
    }

    public static /* synthetic */ Boolean S(kotlin.x xVar) {
        return m861deleteAccounts$lambda13(xVar);
    }

    public static /* synthetic */ kotlin.x b(Throwable th) {
        return m886refresh$lambda12(th);
    }

    private final PutConsumerWalletAddressRequestDTO buildPutConsumerWalletAddressRequest(List<Wallet> list, List<CryptoCurrency> list2, User user, List<ConsumerAccount> list3) {
        Map r;
        int r2;
        Map r3;
        int r4;
        Map r5;
        ConsumerWalletAddressDTO consumerWalletAddressDTO;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list3) {
            ConsumerAccount consumerAccount = (ConsumerAccount) obj;
            if ((kotlin.jvm.internal.m.c(consumerAccount.getType(), "vault") || kotlin.jvm.internal.m.c(consumerAccount.getType(), "fiat")) ? false : true) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ConsumerAccount consumerAccount2 = (ConsumerAccount) it.next();
            CurrencyCode currencyCode = consumerAccount2.getCurrencyCode();
            String assetId = consumerAccount2.getAssetId();
            kotlin.o a = assetId != null ? kotlin.u.a(currencyCode, assetId) : null;
            if (a != null) {
                arrayList2.add(a);
            }
        }
        r = kotlin.a0.m0.r(arrayList2);
        r2 = kotlin.a0.s.r(list, 10);
        ArrayList arrayList3 = new ArrayList(r2);
        for (Wallet wallet : list) {
            arrayList3.add(kotlin.u.a(wallet.getCurrencyCode(), wallet));
        }
        r3 = kotlin.a0.m0.r(arrayList3);
        ArrayList<CryptoCurrency> arrayList4 = new ArrayList();
        for (Object obj2 : list2) {
            if (r.containsKey(((CryptoCurrency) obj2).getCode())) {
                arrayList4.add(obj2);
            }
        }
        r4 = kotlin.a0.s.r(arrayList4, 10);
        ArrayList arrayList5 = new ArrayList(r4);
        for (CryptoCurrency cryptoCurrency : arrayList4) {
            arrayList5.add(kotlin.u.a(cryptoCurrency.getCode(), cryptoCurrency.getBlockchain()));
        }
        r5 = kotlin.a0.m0.r(arrayList5);
        ArrayList arrayList6 = new ArrayList(r.size());
        for (Map.Entry entry : r.entrySet()) {
            CurrencyCode currencyCode2 = (CurrencyCode) entry.getKey();
            String str = (String) entry.getValue();
            if (kotlin.jvm.internal.m.c(r5.get(currencyCode2), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                currencyCode2 = CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion);
            }
            Wallet wallet2 = (Wallet) r3.get(currencyCode2);
            if (wallet2 == null) {
                consumerWalletAddressDTO = new ConsumerWalletAddressDTO(str, null, null, null, 14, null);
            } else {
                consumerWalletAddressDTO = new ConsumerWalletAddressDTO(str, wallet2.getPrimaryAddress(), null, null);
            }
            arrayList6.add(consumerWalletAddressDTO);
        }
        return new PutConsumerWalletAddressRequestDTO(new ConsumerAppInfoDTO(String.valueOf(user.getId()), user.getUsername()), arrayList6);
    }

    public static /* synthetic */ void c(Blockchain blockchain, CurrencyCode currencyCode, ConsumerAccountsRepository consumerAccountsRepository, Optional optional) {
        m899resolveConsumerUserAddress$lambda38(blockchain, currencyCode, consumerAccountsRepository, optional);
    }

    public static /* synthetic */ Map d(List list) {
        return m871getAssetImages$lambda47(list);
    }

    /* renamed from: deleteAccounts$lambda-13 */
    public static final Boolean m861deleteAccounts$lambda13(kotlin.x it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.TRUE;
    }

    /* renamed from: deleteAccounts$lambda-18 */
    public static final h.c.h0 m862deleteAccounts$lambda18(ConsumerAccountsRepository this$0, List users) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(users, "users");
        if (users.isEmpty()) {
            return h.c.b0.just(kotlin.x.a);
        }
        return this$0.consumerAPI.deleteWalletAddresses(((LegacyUser) users.get(0)).getToshiId()).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.D((Throwable) obj);
            }
        });
    }

    /* renamed from: deleteAccounts$lambda-18$lambda-17 */
    public static final h.c.h0 m863deleteAccounts$lambda18$lambda17(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return h.c.b0.just(kotlin.x.a);
    }

    /* renamed from: deleteAccounts$lambda-20 */
    public static final h.c.h0 m864deleteAccounts$lambda20(ConsumerAccountsRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        User user = (User) this$0.store.get(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE));
        if (user == null) {
            return h.c.b0.just(kotlin.x.a);
        }
        return this$0.consumerAPI.deleteWalletAddresses(String.valueOf(user.getId())).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.h((Throwable) obj);
            }
        });
    }

    /* renamed from: deleteAccounts$lambda-20$lambda-19 */
    public static final h.c.h0 m865deleteAccounts$lambda20$lambda19(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return h.c.b0.just(kotlin.x.a);
    }

    /* renamed from: deleteAccounts$lambda-21 */
    public static final h.c.h0 m866deleteAccounts$lambda21(ConsumerAccountsRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.consumerAccountsDAO.deleteAccounts();
    }

    /* renamed from: destroy$lambda-5 */
    public static final Boolean m867destroy$lambda5(kotlin.x it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.TRUE;
    }

    public static /* synthetic */ h.c.h0 e(ConsumerAccountsRepository consumerAccountsRepository, List list) {
        return m862deleteAccounts$lambda18(consumerAccountsRepository, list);
    }

    public static /* synthetic */ h.c.h0 f(ConsumerAccountsRepository consumerAccountsRepository, ConsumerAccount consumerAccount) {
        return m895resolveConsumerUserAddress$lambda33(consumerAccountsRepository, consumerAccount);
    }

    public static /* synthetic */ h.c.h0 g(ConsumerAccountsRepository consumerAccountsRepository, kotlin.x xVar) {
        return m866deleteAccounts$lambda21(consumerAccountsRepository, xVar);
    }

    private final h.c.b0<List<ConsumerAccount>> getAccounts() {
        List g2;
        List<String> restrictions;
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        if (storeInterface.has(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys))) {
            ConsumerUser consumerUser = (ConsumerUser) this.store.get(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys));
            if (!((consumerUser == null || (restrictions = consumerUser.getRestrictions()) == null || !(restrictions.isEmpty() ^ true)) ? false : true)) {
                h.c.b0<List<ConsumerAccount>> map = h.c.t0.f.a(this.consumerAPI.getAssets(), this.consumerAPI.getAccounts()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.h
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.i(ConsumerAccountsRepository.this, (kotlin.o) obj);
                    }
                }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.q
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.r((kotlin.t) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map, "consumerAPI.getAssets()\n            .zipWith(consumerAPI.getAccounts())\n            .flatMap { (assets, accounts) ->\n                val assetImageSingles = getAssetImages(assets = assets, accounts = accounts)\n                Singles.zip(\n                    Single.just(accounts),\n                    assetImageSingles,\n                    walletsRepository.getCryptoCurrencies(null)\n                )\n            }\n            .map { (accounts, assetImageUrls, currencies) ->\n                val currencyDecimals: Map<String, Int> = currencies.map { it.code.code to it.decimals }.toMap()\n                accounts.map { account ->\n                    val accountId = account.id\n                    val currency = account.currency\n                    val balance = account.balance\n                    val accountName = account.name\n                    val currencyName = currency.name\n                    val type = account.type\n\n                    val decimals = currencyDecimals[currency.code] ?: 0\n                    val amount = balance.amount.toBigDecimal().scaleByPowerOfTen(decimals).toBigInteger()\n\n                    ConsumerAccount(\n                        id = accountId,\n                        name = accountName,\n                        balance = amount,\n                        currencyCode = CurrencyCode(currency.code.toUpperCase(Locale.US)),\n                        currencyName = currencyName,\n                        decimals = decimals,\n                        type = type,\n                        imageUrl = assetImageUrls[currency.code],\n                        destinationTagName = currency.destinationTagName,\n                        assetId = currency.assetId\n                    )\n                }\n            }");
                return map;
            }
        }
        g2 = kotlin.a0.r.g();
        h.c.b0<List<ConsumerAccount>> just = h.c.b0.just(g2);
        kotlin.jvm.internal.m.f(just, "just(emptyList())");
        return just;
    }

    /* renamed from: getAccounts$lambda-39 */
    public static final h.c.h0 m868getAccounts$lambda39(ConsumerAccountsRepository this$0, kotlin.o dstr$assets$accounts) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$assets$accounts, "$dstr$assets$accounts");
        List<? extends Account> accounts = (List) dstr$assets$accounts.b();
        kotlin.jvm.internal.m.f(accounts, "accounts");
        h.c.b0<Map<String, String>> assetImages = this$0.getAssetImages((List) dstr$assets$accounts.a(), accounts);
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(accounts);
        kotlin.jvm.internal.m.f(just, "just(accounts)");
        return eVar.b(just, assetImages, this$0.walletsRepository.getCryptoCurrencies(null));
    }

    /* renamed from: getAccounts$lambda-42 */
    public static final List m869getAccounts$lambda42(kotlin.t dstr$accounts$assetImageUrls$currencies) {
        int r;
        Map r2;
        int r3;
        kotlin.jvm.internal.m.g(dstr$accounts$assetImageUrls$currencies, "$dstr$accounts$assetImageUrls$currencies");
        List<Account> accounts = (List) dstr$accounts$assetImageUrls$currencies.a();
        Map map = (Map) dstr$accounts$assetImageUrls$currencies.b();
        List<CryptoCurrency> currencies = (List) dstr$accounts$assetImageUrls$currencies.c();
        kotlin.jvm.internal.m.f(currencies, "currencies");
        r = kotlin.a0.s.r(currencies, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CryptoCurrency cryptoCurrency : currencies) {
            arrayList.add(kotlin.u.a(cryptoCurrency.getCode().getCode(), Integer.valueOf(cryptoCurrency.getDecimals())));
        }
        r2 = kotlin.a0.m0.r(arrayList);
        kotlin.jvm.internal.m.f(accounts, "accounts");
        r3 = kotlin.a0.s.r(accounts, 10);
        ArrayList arrayList2 = new ArrayList(r3);
        for (Account account : accounts) {
            String accountId = account.getId();
            Currency currency = account.getCurrency();
            MoneyHash balance = account.getBalance();
            String accountName = account.getName();
            String currencyName = currency.getName();
            String type = account.getType();
            Integer num = (Integer) r2.get(currency.getCode());
            int intValue = num == null ? 0 : num.intValue();
            String amount = balance.getAmount();
            kotlin.jvm.internal.m.f(amount, "balance.amount");
            BigInteger amount2 = new BigDecimal(amount).scaleByPowerOfTen(intValue).toBigInteger();
            kotlin.jvm.internal.m.f(accountId, "accountId");
            kotlin.jvm.internal.m.f(accountName, "accountName");
            kotlin.jvm.internal.m.f(amount2, "amount");
            String code = currency.getCode();
            kotlin.jvm.internal.m.f(code, "currency.code");
            Locale US = Locale.US;
            kotlin.jvm.internal.m.f(US, "US");
            String upperCase = code.toUpperCase(US);
            kotlin.jvm.internal.m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            CurrencyCode currencyCode = new CurrencyCode(upperCase);
            kotlin.jvm.internal.m.f(currencyName, "currencyName");
            kotlin.jvm.internal.m.f(type, "type");
            arrayList2.add(new ConsumerAccount(accountId, accountName, amount2, currencyCode, currencyName, intValue, type, (String) map.get(currency.getCode()), currency.getDestinationTagName(), currency.getAssetId()));
        }
        return arrayList2;
    }

    private final h.c.b0<Map<String, String>> getAssetImages(List<ConsumerAsset> list, List<? extends Account> list2) {
        int r;
        Map r2;
        int r3;
        h.c.b0 zip;
        List g2;
        h.c.h0 map;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ConsumerAsset consumerAsset : list) {
            arrayList.add(kotlin.u.a(consumerAsset.getSymbol(), consumerAsset.getImageUrl()));
        }
        r2 = kotlin.a0.m0.r(arrayList);
        ArrayList<Account> arrayList2 = new ArrayList();
        for (Object obj : list2) {
            if (((Account) obj).getCurrency().getAssetId() != null) {
                arrayList2.add(obj);
            }
        }
        r3 = kotlin.a0.s.r(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(r3);
        for (final Account account : arrayList2) {
            String str = (String) r2.get(account.getCurrency().getCode());
            if (str != null) {
                map = h.c.b0.just(kotlin.u.a(account.getCurrency().getCode(), str));
            } else {
                ConsumerAPI consumerAPI = this.consumerAPI;
                String assetId = account.getCurrency().getAssetId();
                kotlin.jvm.internal.m.f(assetId, "account.currency.assetId");
                map = consumerAPI.getAsset(assetId).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.l0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj2) {
                        return ConsumerAccountsRepository.M(Account.this, (ConsumerAsset) obj2);
                    }
                });
            }
            arrayList3.add(map);
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList3.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList3, new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository$getAssetImages$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj2 = it[i2];
                        if (obj2 != null ? obj2 instanceof kotlin.o : true) {
                            arrayList4.add(obj2);
                        }
                    }
                    return arrayList4;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0<Map<String, String>> map2 = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return ConsumerAccountsRepository.d((List) obj2);
            }
        });
        kotlin.jvm.internal.m.f(map2, "accounts\n            .filter { it.currency.assetId != null }\n            .map { account ->\n                val assetImageUrl = assetToImageMap[account.currency.code]\n                if (assetImageUrl != null) {\n                    Single.just(account.currency.code to assetImageUrl)\n                } else {\n                    // If an asset isn't one of the 'top 50' the assets api doesn't return it,\n                    // so we need to fetch it individually\n                    consumerAPI\n                        .getAsset(account.currency.assetId)\n                        .map { account.currency.code to it.imageUrl }\n                }\n            }\n            .zipOrEmpty()\n            .map { it.toMap() }");
        return map2;
    }

    /* renamed from: getAssetImages$lambda-46$lambda-45 */
    public static final kotlin.o m870getAssetImages$lambda46$lambda45(Account account, ConsumerAsset it) {
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.u.a(account.getCurrency().getCode(), it.getImageUrl());
    }

    /* renamed from: getAssetImages$lambda-47 */
    public static final Map m871getAssetImages$lambda47(List it) {
        Map r;
        kotlin.jvm.internal.m.g(it, "it");
        r = kotlin.a0.m0.r(it);
        return r;
    }

    private final h.c.a0 getConcurrentScheduler() {
        return (h.c.a0) this.concurrentScheduler$delegate.getValue();
    }

    public static /* synthetic */ h.c.h0 h(Throwable th) {
        return m865deleteAccounts$lambda20$lambda19(th);
    }

    public static /* synthetic */ h.c.h0 i(ConsumerAccountsRepository consumerAccountsRepository, kotlin.o oVar) {
        return m868getAccounts$lambda39(consumerAccountsRepository, oVar);
    }

    public static /* synthetic */ List j(Throwable th) {
        return m874observeConsumerAccessToken$lambda50(th);
    }

    public static /* synthetic */ h.c.h0 k(Throwable th) {
        return m878observeConsumerAccessToken$lambda54$lambda53(th);
    }

    public static /* synthetic */ h.c.x l(ConsumerAccountsRepository consumerAccountsRepository, Optional optional) {
        return m880observeConsumerAccessToken$lambda58(consumerAccountsRepository, optional);
    }

    public static /* synthetic */ h.c.h0 m(ConsumerAccountsRepository consumerAccountsRepository, List list) {
        return m889refresh$lambda9(consumerAccountsRepository, list);
    }

    public static /* synthetic */ Optional n(Throwable th) {
        return m898resolveConsumerUserAddress$lambda36(th);
    }

    public static /* synthetic */ h.c.h0 o(ConsumerAccountsRepository consumerAccountsRepository, ConsumerAccount consumerAccount, Throwable th) {
        return m896resolveConsumerUserAddress$lambda33$lambda32(consumerAccountsRepository, consumerAccount, th);
    }

    private final void observeConsumerAccessToken() {
        h.c.s walletsObservable = this.walletsRepository.observeWallets(false).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.u((List) obj);
            }
        }).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.repositories.a0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return ConsumerAccountsRepository.B((List) obj);
            }
        }).distinctUntilChanged();
        h.c.s cryptoCurrencyObservable = IWalletRepository.DefaultImpls.getCryptoCurrencies$default(this.walletsRepository, null, 1, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.j((Throwable) obj);
            }
        }).toObservable();
        h.c.t0.c cVar = h.c.t0.c.a;
        kotlin.jvm.internal.m.f(walletsObservable, "walletsObservable");
        kotlin.jvm.internal.m.f(cryptoCurrencyObservable, "cryptoCurrencyObservable");
        h.c.s<R> map = this.userRepository.getActiveUserObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository$observeConsumerAccessToken$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository$observeConsumerAccessToken$$inlined$unwrap$2
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
        h.c.s distinctUntilChanged = map.distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "userRepository.activeUserObservable.unwrap().distinctUntilChanged()");
        h.c.s flatMap = cVar.b(walletsObservable, cryptoCurrencyObservable, distinctUntilChanged).throttleLatest(10L, TimeUnit.SECONDS).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.h0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.I(ConsumerAccountsRepository.this, (kotlin.t) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.e0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.F(ConsumerAccountsRepository.this, (Four) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.x(ConsumerAccountsRepository.this, (kotlin.x) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.l(ConsumerAccountsRepository.this, (Optional) obj);
            }
        });
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        h.c.s filter = cVar.a(storeInterface.observe(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys)), this.store.observe(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys))).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.repositories.f0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return ConsumerAccountsRepository.G((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "Observables.combineLatest(store.observe(StoreKeys.consumerAccessToken), store.observe(StoreKeys.consumerUser))\n            .filter { (_, user) -> user.toNullable()?.restrictions?.isEmpty() == true }");
        h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(filter, "Error observing consumer access token", null, 2, null), null, null, new ConsumerAccountsRepository$observeConsumerAccessToken$2(this, flatMap), 3, null), this.disposeBag);
    }

    /* renamed from: observeConsumerAccessToken$lambda-48 */
    public static final List m872observeConsumerAccessToken$lambda48(List it) {
        List K0;
        kotlin.jvm.internal.m.g(it, "it");
        K0 = kotlin.a0.z.K0(it);
        return K0;
    }

    /* renamed from: observeConsumerAccessToken$lambda-49 */
    public static final boolean m873observeConsumerAccessToken$lambda49(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.isEmpty();
    }

    /* renamed from: observeConsumerAccessToken$lambda-50 */
    public static final List m874observeConsumerAccessToken$lambda50(Throwable it) {
        List g2;
        kotlin.jvm.internal.m.g(it, "it");
        g2 = kotlin.a0.r.g();
        return g2;
    }

    /* renamed from: observeConsumerAccessToken$lambda-52 */
    public static final h.c.h0 m875observeConsumerAccessToken$lambda52(ConsumerAccountsRepository this$0, kotlin.t dstr$wallets$supportedCurrencies$user) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$wallets$supportedCurrencies$user, "$dstr$wallets$supportedCurrencies$user");
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just((List) dstr$wallets$supportedCurrencies$user.a());
        kotlin.jvm.internal.m.f(just, "just(wallets)");
        h.c.b0 just2 = h.c.b0.just((List) dstr$wallets$supportedCurrencies$user.b());
        kotlin.jvm.internal.m.f(just2, "just(supportedCurrencies)");
        h.c.b0 just3 = h.c.b0.just((User) dstr$wallets$supportedCurrencies$user.c());
        kotlin.jvm.internal.m.f(just3, "just(user)");
        h.c.b0<List<ConsumerAccount>> onErrorReturn = this$0.getAccounts().onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.m0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.N((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "getAccounts().onErrorReturn { emptyList() }");
        return Singles_CoreKt.zip(eVar, just, just2, just3, onErrorReturn);
    }

    /* renamed from: observeConsumerAccessToken$lambda-52$lambda-51 */
    public static final List m876observeConsumerAccessToken$lambda52$lambda51(Throwable it) {
        List g2;
        kotlin.jvm.internal.m.g(it, "it");
        g2 = kotlin.a0.r.g();
        return g2;
    }

    /* renamed from: observeConsumerAccessToken$lambda-54 */
    public static final h.c.x m877observeConsumerAccessToken$lambda54(ConsumerAccountsRepository this$0, Four dstr$wallets$supportedCurrencies$user$accounts) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$wallets$supportedCurrencies$user$accounts, "$dstr$wallets$supportedCurrencies$user$accounts");
        List<Wallet> wallets = (List) dstr$wallets$supportedCurrencies$user$accounts.component1();
        List<CryptoCurrency> supportedCurrencies = (List) dstr$wallets$supportedCurrencies$user$accounts.component2();
        User user = (User) dstr$wallets$supportedCurrencies$user$accounts.component3();
        List<ConsumerAccount> accounts = (List) dstr$wallets$supportedCurrencies$user$accounts.component4();
        kotlin.jvm.internal.m.f(wallets, "wallets");
        kotlin.jvm.internal.m.f(supportedCurrencies, "supportedCurrencies");
        kotlin.jvm.internal.m.f(user, "user");
        kotlin.jvm.internal.m.f(accounts, "accounts");
        return this$0.consumerAPI.linkWalletAddresses(this$0.buildPutConsumerWalletAddressRequest(wallets, supportedCurrencies, user, accounts)).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.k((Throwable) obj);
            }
        }).toObservable();
    }

    /* renamed from: observeConsumerAccessToken$lambda-54$lambda-53 */
    public static final h.c.h0 m878observeConsumerAccessToken$lambda54$lambda53(Throwable t) {
        kotlin.jvm.internal.m.g(t, "t");
        l.a.a.f(t, "Failure sending external addresses", new Object[0]);
        return h.c.b0.just(kotlin.x.a);
    }

    /* renamed from: observeConsumerAccessToken$lambda-55 */
    public static final h.c.x m879observeConsumerAccessToken$lambda55(ConsumerAccountsRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.userRepository.getLegacyUser().toObservable();
    }

    /* renamed from: observeConsumerAccessToken$lambda-58 */
    public static final h.c.x m880observeConsumerAccessToken$lambda58(ConsumerAccountsRepository this$0, Optional dstr$legacyUser) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$legacyUser, "$dstr$legacyUser");
        final LegacyUser legacyUser = (LegacyUser) dstr$legacyUser.component1();
        if (legacyUser != null) {
            return this$0.consumerAPI.deleteWalletAddresses(legacyUser.getToshiId()).flatMapCompletable(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.u
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAccountsRepository.v(ConsumerAccountsRepository.this, legacyUser, (kotlin.x) obj);
                }
            }).x(kotlin.x.a).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.x
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAccountsRepository.y((Throwable) obj);
                }
            }).toObservable();
        }
        return h.c.s.just(kotlin.x.a);
    }

    /* renamed from: observeConsumerAccessToken$lambda-58$lambda-56 */
    public static final h.c.f m881observeConsumerAccessToken$lambda58$lambda56(ConsumerAccountsRepository this$0, LegacyUser legacyUser, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.userDao.delete(legacyUser);
    }

    /* renamed from: observeConsumerAccessToken$lambda-58$lambda-57 */
    public static final h.c.h0 m882observeConsumerAccessToken$lambda58$lambda57(Throwable t) {
        kotlin.jvm.internal.m.g(t, "t");
        l.a.a.f(t, "Failure deleting external addresses", new Object[0]);
        return h.c.b0.just(kotlin.x.a);
    }

    /* renamed from: observeConsumerAccessToken$lambda-59 */
    public static final boolean m883observeConsumerAccessToken$lambda59(kotlin.o dstr$_u24__u24$user) {
        List<String> restrictions;
        kotlin.jvm.internal.m.g(dstr$_u24__u24$user, "$dstr$_u24__u24$user");
        ConsumerUser consumerUser = (ConsumerUser) ((Optional) dstr$_u24__u24$user.b()).toNullable();
        return (consumerUser == null || (restrictions = consumerUser.getRestrictions()) == null || !restrictions.isEmpty()) ? false : true;
    }

    public static /* synthetic */ Optional p(Blockchain blockchain, CurrencyCode currencyCode, ConsumerAccountsRepository consumerAccountsRepository) {
        return m891resolveAddress$lambda14(blockchain, currencyCode, consumerAccountsRepository);
    }

    public static /* synthetic */ h.c.h0 q(ConsumerAccountsRepository consumerAccountsRepository, kotlin.x xVar) {
        return m864deleteAccounts$lambda20(consumerAccountsRepository, xVar);
    }

    public static /* synthetic */ List r(kotlin.t tVar) {
        return m869getAccounts$lambda42(tVar);
    }

    /* renamed from: refresh$lambda-10 */
    public static final h.c.h0 m884refresh$lambda10(ConsumerAccountsRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.consumerAccountsDAO.save(it);
    }

    /* renamed from: refresh$lambda-11 */
    public static final kotlin.x m885refresh$lambda11(ConsumerAccountsRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.accountsSubject.onNext(it);
        return kotlin.x.a;
    }

    /* renamed from: refresh$lambda-12 */
    public static final kotlin.x m886refresh$lambda12(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: refresh$lambda-6 */
    public static final kotlin.x m887refresh$lambda6(ConsumerAccountsRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.accountsSubject.onNext(it);
        return kotlin.x.a;
    }

    /* renamed from: refresh$lambda-7 */
    public static final h.c.h0 m888refresh$lambda7(ConsumerAccountsRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getAccounts();
    }

    /* renamed from: refresh$lambda-9 */
    public static final h.c.h0 m889refresh$lambda9(ConsumerAccountsRepository this$0, final List accounts) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(accounts, "accounts");
        return this$0.consumerAccountsDAO.deleteAccounts().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.p0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.Q(accounts, (Boolean) obj);
            }
        });
    }

    /* renamed from: refresh$lambda-9$lambda-8 */
    public static final List m890refresh$lambda9$lambda8(List accounts, Boolean it) {
        kotlin.jvm.internal.m.g(accounts, "$accounts");
        kotlin.jvm.internal.m.g(it, "it");
        return accounts;
    }

    /* renamed from: resolveAddress$lambda-14 */
    public static final Optional m891resolveAddress$lambda14(Blockchain blockchain, CurrencyCode currencyCode, ConsumerAccountsRepository this$0) {
        List j2;
        String h0;
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        j2 = kotlin.a0.r.j(blockchain.getRawValue(), currencyCode.getCode());
        h0 = kotlin.a0.z.h0(j2, ",", null, null, 0, null, null, 62, null);
        return OptionalKt.toOptional(this$0.resolvedAddressCache.get(h0));
    }

    /* renamed from: resolveAddress$lambda-16 */
    public static final h.c.h0 m892resolveAddress$lambda16(ConsumerAccountsRepository this$0, Blockchain blockchain, CurrencyCode currencyCode, Optional consumerAddressOptional) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(consumerAddressOptional, "consumerAddressOptional");
        h.c.b0 just = ((ConsumerAddress) consumerAddressOptional.toNullable()) == null ? null : h.c.b0.just(consumerAddressOptional);
        return just == null ? this$0.resolveConsumerUserAddress(blockchain, currencyCode) : just;
    }

    private final h.c.b0<Optional<ConsumerAddress>> resolveConsumerUserAddress(final Blockchain blockchain, final CurrencyCode currencyCode) {
        h.c.b0 map = this.consumerAccountsDAO.getAccounts().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.s(ConsumerAccountsRepository.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.C(CurrencyCode.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.f(ConsumerAccountsRepository.this, (ConsumerAccount) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.i0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.J(Blockchain.this, this, currencyCode, (Address) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAccountsDAO.getAccounts()\n        .flatMap { accounts -> if (accounts.isEmpty()) getAccounts() else Single.just(accounts) }\n        .map { accounts ->\n            accounts\n                .firstOrNull { it.type == ConsumerAccount.TYPE_WALLET && it.currencyCode == currencyCode }\n                ?: throw ConsumerException.WalletAddressNotFound\n        }\n        .flatMap { account ->\n            consumerAPI.getAddress(accountID = account.id)\n                .onErrorResumeNext { error ->\n                    (error as? ConsumerException.WalletAddressNotFound)?.let {\n                        consumerAPI.createAddress(account.id)\n                    } ?: throw error\n                }\n        }\n        .map { address ->\n            val consumerNetwork = address.network ?: throw ConsumerException.WalletAddressNotFound\n            val networkSetting = consumerNetworkToNetworkSetting[consumerNetwork]\n            if (blockchain != networkSetting?.blockchain) throw ConsumerException.WalletAddressNotFound\n            val addressString = address.address ?: throw ConsumerException.WalletAddressNotFound\n            val email = store.get(StoreKeys.consumerUser)?.email\n                ?: throw ConsumerException.WalletAddressNotFound\n\n            val metadata: String? = address.addressInfo?.destinationTag\n\n            val metadataKey: TxMetadataKey? = metadata?.let {\n                when (networkSetting.blockchain) {\n                    Blockchain.XRP -> TxMetadataKey.destinationTag\n                    Blockchain.STELLAR -> TxMetadataKey.memoId\n                    else -> null\n                }\n            }\n\n            ConsumerAddress(\n                address = addressString,\n                blockchain = networkSetting.blockchain,\n                currencyCode = currencyCode,\n                network = networkSetting.mainnetNetworkSettingItem.network,\n                metadataKey = metadataKey,\n                metadata = metadata,\n                email = email\n            ).toOptional()\n        }");
        h.c.b0<Optional<ConsumerAddress>> doOnSuccess = Single_CoreKt.retryWithDelay(map, 3L, 300L, TimeUnit.MILLISECONDS).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.n((Throwable) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.repositories.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerAccountsRepository.c(Blockchain.this, currencyCode, this, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSuccess, "consumerAccountsDAO.getAccounts()\n        .flatMap { accounts -> if (accounts.isEmpty()) getAccounts() else Single.just(accounts) }\n        .map { accounts ->\n            accounts\n                .firstOrNull { it.type == ConsumerAccount.TYPE_WALLET && it.currencyCode == currencyCode }\n                ?: throw ConsumerException.WalletAddressNotFound\n        }\n        .flatMap { account ->\n            consumerAPI.getAddress(accountID = account.id)\n                .onErrorResumeNext { error ->\n                    (error as? ConsumerException.WalletAddressNotFound)?.let {\n                        consumerAPI.createAddress(account.id)\n                    } ?: throw error\n                }\n        }\n        .map { address ->\n            val consumerNetwork = address.network ?: throw ConsumerException.WalletAddressNotFound\n            val networkSetting = consumerNetworkToNetworkSetting[consumerNetwork]\n            if (blockchain != networkSetting?.blockchain) throw ConsumerException.WalletAddressNotFound\n            val addressString = address.address ?: throw ConsumerException.WalletAddressNotFound\n            val email = store.get(StoreKeys.consumerUser)?.email\n                ?: throw ConsumerException.WalletAddressNotFound\n\n            val metadata: String? = address.addressInfo?.destinationTag\n\n            val metadataKey: TxMetadataKey? = metadata?.let {\n                when (networkSetting.blockchain) {\n                    Blockchain.XRP -> TxMetadataKey.destinationTag\n                    Blockchain.STELLAR -> TxMetadataKey.memoId\n                    else -> null\n                }\n            }\n\n            ConsumerAddress(\n                address = addressString,\n                blockchain = networkSetting.blockchain,\n                currencyCode = currencyCode,\n                network = networkSetting.mainnetNetworkSettingItem.network,\n                metadataKey = metadataKey,\n                metadata = metadata,\n                email = email\n            ).toOptional()\n        }\n        .retryWithDelay(3, 300, TimeUnit.MILLISECONDS)\n        .onErrorReturn { null.toOptional() }\n        .doOnSuccess { address ->\n            val cacheKey = listOf(blockchain.rawValue, currencyCode.code).joinToString(\",\")\n            address.toNullable()?.let { resolvedAddressCache[cacheKey] = it }\n        }");
        return doOnSuccess;
    }

    /* renamed from: resolveConsumerUserAddress$lambda-28 */
    public static final h.c.h0 m893resolveConsumerUserAddress$lambda28(ConsumerAccountsRepository this$0, List accounts) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(accounts, "accounts");
        if (accounts.isEmpty()) {
            return this$0.getAccounts();
        }
        h.c.b0 just = h.c.b0.just(accounts);
        kotlin.jvm.internal.m.f(just, "just(accounts)");
        return just;
    }

    /* renamed from: resolveConsumerUserAddress$lambda-30 */
    public static final ConsumerAccount m894resolveConsumerUserAddress$lambda30(CurrencyCode currencyCode, List accounts) {
        Object obj;
        boolean z;
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(accounts, "accounts");
        Iterator it = accounts.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ConsumerAccount consumerAccount = (ConsumerAccount) obj;
            if (kotlin.jvm.internal.m.c(consumerAccount.getType(), "wallet") && kotlin.jvm.internal.m.c(consumerAccount.getCurrencyCode(), currencyCode)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ConsumerAccount consumerAccount2 = (ConsumerAccount) obj;
        if (consumerAccount2 != null) {
            return consumerAccount2;
        }
        throw ConsumerException.WalletAddressNotFound.INSTANCE;
    }

    /* renamed from: resolveConsumerUserAddress$lambda-33 */
    public static final h.c.h0 m895resolveConsumerUserAddress$lambda33(ConsumerAccountsRepository this$0, final ConsumerAccount account) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(account, "account");
        return this$0.consumerAPI.getAddress(account.getId()).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.o(ConsumerAccountsRepository.this, account, (Throwable) obj);
            }
        });
    }

    /* renamed from: resolveConsumerUserAddress$lambda-33$lambda-32 */
    public static final h.c.h0 m896resolveConsumerUserAddress$lambda33$lambda32(ConsumerAccountsRepository this$0, ConsumerAccount account, Throwable error) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(error, "error");
        h.c.b0<Address> createAddress = (error instanceof ConsumerException.WalletAddressNotFound ? (ConsumerException.WalletAddressNotFound) error : null) != null ? this$0.consumerAPI.createAddress(account.getId()) : null;
        if (createAddress != null) {
            return createAddress;
        }
        throw error;
    }

    /* renamed from: resolveConsumerUserAddress$lambda-35 */
    public static final Optional m897resolveConsumerUserAddress$lambda35(Blockchain blockchain, ConsumerAccountsRepository this$0, CurrencyCode currencyCode, Address address) {
        Map map;
        TxMetadataKey memoId;
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(address, "address");
        String network = address.getNetwork();
        if (network != null) {
            map = ConsumerAccountsRepositoryKt.consumerNetworkToNetworkSetting;
            NetworkSetting networkSetting = (NetworkSetting) map.get(network);
            TxMetadataKey txMetadataKey = null;
            if (kotlin.jvm.internal.m.c(blockchain, networkSetting == null ? null : networkSetting.getBlockchain())) {
                String address2 = address.getAddress();
                if (address2 != null) {
                    ConsumerUser consumerUser = (ConsumerUser) this$0.store.get(StoreKeys_ConsumerConnectKt.getConsumerUser(StoreKeys.INSTANCE));
                    String email = consumerUser == null ? null : consumerUser.getEmail();
                    if (email != null) {
                        AddressInfo addressInfo = address.getAddressInfo();
                        String destinationTag = addressInfo == null ? null : addressInfo.getDestinationTag();
                        if (destinationTag != null) {
                            Blockchain blockchain2 = networkSetting.getBlockchain();
                            Blockchain.Companion companion = Blockchain.Companion;
                            if (kotlin.jvm.internal.m.c(blockchain2, Blockchain_RippleKt.getXRP(companion))) {
                                memoId = TxMetadataKey_RippleKt.getDestinationTag(TxMetadataKey.Companion);
                            } else if (kotlin.jvm.internal.m.c(blockchain2, Blockchain_StellarKt.getSTELLAR(companion))) {
                                memoId = TxMetadataKey_StellarKt.getMemoId(TxMetadataKey.Companion);
                            }
                            txMetadataKey = memoId;
                        }
                        return OptionalKt.toOptional(new ConsumerAddress(address2, networkSetting.getBlockchain(), currencyCode, networkSetting.getMainnetNetworkSettingItem().getNetwork(), txMetadataKey, destinationTag, email));
                    }
                    throw ConsumerException.WalletAddressNotFound.INSTANCE;
                }
                throw ConsumerException.WalletAddressNotFound.INSTANCE;
            }
            throw ConsumerException.WalletAddressNotFound.INSTANCE;
        }
        throw ConsumerException.WalletAddressNotFound.INSTANCE;
    }

    /* renamed from: resolveConsumerUserAddress$lambda-36 */
    public static final Optional m898resolveConsumerUserAddress$lambda36(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(null);
    }

    /* renamed from: resolveConsumerUserAddress$lambda-38 */
    public static final void m899resolveConsumerUserAddress$lambda38(Blockchain blockchain, CurrencyCode currencyCode, ConsumerAccountsRepository this$0, Optional optional) {
        List j2;
        String h0;
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        j2 = kotlin.a0.r.j(blockchain.getRawValue(), currencyCode.getCode());
        h0 = kotlin.a0.z.h0(j2, ",", null, null, 0, null, null, 62, null);
        ConsumerAddress consumerAddress = (ConsumerAddress) optional.toNullable();
        if (consumerAddress == null) {
            return;
        }
        this$0.resolvedAddressCache.put(h0, consumerAddress);
    }

    public static /* synthetic */ h.c.h0 s(ConsumerAccountsRepository consumerAccountsRepository, List list) {
        return m893resolveConsumerUserAddress$lambda28(consumerAccountsRepository, list);
    }

    /* renamed from: start$lambda-0 */
    public static final Boolean m900start$lambda0(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.toNullable() != null);
    }

    /* renamed from: start$lambda-1 */
    public static final kotlin.x m901start$lambda1(ConsumerAccountsRepository this$0, Boolean hasConsumerUser) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(hasConsumerUser, "hasConsumerUser");
        if (hasConsumerUser.booleanValue()) {
            return kotlin.x.a;
        }
        this$0.resolvedAddressCache.clear();
        return kotlin.x.a;
    }

    /* renamed from: start$lambda-2 */
    public static final boolean m902start$lambda2(Optional t1, Optional t2) {
        kotlin.jvm.internal.m.g(t1, "t1");
        kotlin.jvm.internal.m.g(t2, "t2");
        ConsumerUser consumerUser = (ConsumerUser) t1.toNullable();
        String id = consumerUser == null ? null : consumerUser.getId();
        ConsumerUser consumerUser2 = (ConsumerUser) t2.toNullable();
        return kotlin.jvm.internal.m.c(id, consumerUser2 != null ? consumerUser2.getId() : null);
    }

    /* renamed from: start$lambda-3 */
    public static final boolean m903start$lambda3(ConsumerAccountsRepository this$0, Optional it) {
        List<String> restrictions;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ConsumerUser consumerUser = (ConsumerUser) it.toNullable();
        return (consumerUser != null && (restrictions = consumerUser.getRestrictions()) != null && restrictions.isEmpty()) && this$0.store.has(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(StoreKeys.INSTANCE));
    }

    /* renamed from: start$lambda-4 */
    public static final h.c.h0 m904start$lambda4(ConsumerAccountsRepository this$0, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.refresh(false);
    }

    public static /* synthetic */ h.c.h0 t(ConsumerAccountsRepository consumerAccountsRepository, Blockchain blockchain, CurrencyCode currencyCode, Optional optional) {
        return m892resolveAddress$lambda16(consumerAccountsRepository, blockchain, currencyCode, optional);
    }

    public static /* synthetic */ List u(List list) {
        return m872observeConsumerAccessToken$lambda48(list);
    }

    public static /* synthetic */ h.c.f v(ConsumerAccountsRepository consumerAccountsRepository, LegacyUser legacyUser, kotlin.x xVar) {
        return m881observeConsumerAccessToken$lambda58$lambda56(consumerAccountsRepository, legacyUser, xVar);
    }

    public static /* synthetic */ boolean w(Optional optional, Optional optional2) {
        return m902start$lambda2(optional, optional2);
    }

    public static /* synthetic */ h.c.x x(ConsumerAccountsRepository consumerAccountsRepository, kotlin.x xVar) {
        return m879observeConsumerAccessToken$lambda55(consumerAccountsRepository, xVar);
    }

    public static /* synthetic */ h.c.h0 y(Throwable th) {
        return m882observeConsumerAccessToken$lambda58$lambda57(th);
    }

    public static /* synthetic */ h.c.h0 z(ConsumerAccountsRepository consumerAccountsRepository, Optional optional) {
        return m904start$lambda4(consumerAccountsRepository, optional);
    }

    public final h.c.b0<Boolean> deleteAccounts() {
        h.c.b0 map = deleteAccounts(false).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.r0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.S((kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "deleteAccounts(false).map { true }");
        return map;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        h.c.b0 map = deleteAccounts(true).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.H((kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "deleteAccounts(true).map { true }");
        return map;
    }

    public final h.c.s<List<ConsumerAccount>> getAccountsObservable() {
        return this.accountsObservable;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        List<String> restrictions;
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        if (storeInterface.has(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys))) {
            ConsumerUser consumerUser = (ConsumerUser) this.store.get(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys));
            if ((consumerUser == null || (restrictions = consumerUser.getRestrictions()) == null || !restrictions.isEmpty()) ? false : true) {
                h.c.b0 map = this.consumerAccountsDAO.getAccounts().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.j0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.K(ConsumerAccountsRepository.this, (List) obj);
                    }
                }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.k0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.L(ConsumerAccountsRepository.this, (kotlin.x) obj);
                    }
                }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.l
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.m(ConsumerAccountsRepository.this, (List) obj);
                    }
                }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.n0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.O(ConsumerAccountsRepository.this, (List) obj);
                    }
                }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.d0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.E(ConsumerAccountsRepository.this, (List) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map, "consumerAccountsDAO.getAccounts()\n            .map { accountsSubject.onNext(it) }\n            .flatMap { getAccounts() }\n            .flatMap { accounts ->\n                consumerAccountsDAO\n                    .deleteAccounts()\n                    .map { accounts }\n            }\n            .flatMap { consumerAccountsDAO.save(it) }\n            .map { accountsSubject.onNext(it) }");
                h.c.b0 trace = Single_CoreKt.trace(map, TraceKey_ConsumerConnectKt.consumerAccountsRepositoryTrace(TraceKey.Companion), this.tracer);
                kotlin.jvm.internal.m.f(trace, "consumerAccountsDAO.getAccounts()\n            .map { accountsSubject.onNext(it) }\n            .flatMap { getAccounts() }\n            .flatMap { accounts ->\n                consumerAccountsDAO\n                    .deleteAccounts()\n                    .map { accounts }\n            }\n            .flatMap { consumerAccountsDAO.save(it) }\n            .map { accountsSubject.onNext(it) }\n            .trace(TraceKey.consumerAccountsRepositoryTrace(), tracer)");
                h.c.b0<kotlin.x> onErrorReturn = Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(trace, null, null, 3, null)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.a
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.b((Throwable) obj);
                    }
                });
                kotlin.jvm.internal.m.f(onErrorReturn, "{\n        consumerAccountsDAO.getAccounts()\n            .map { accountsSubject.onNext(it) }\n            .flatMap { getAccounts() }\n            .flatMap { accounts ->\n                consumerAccountsDAO\n                    .deleteAccounts()\n                    .map { accounts }\n            }\n            .flatMap { consumerAccountsDAO.save(it) }\n            .map { accountsSubject.onNext(it) }\n            .trace(TraceKey.consumerAccountsRepositoryTrace(), tracer)\n            .logError()\n            .asUnit()\n            .onErrorReturn { Unit }\n    }");
                return onErrorReturn;
            }
        }
        h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
        kotlin.jvm.internal.m.f(just, "{\n        Single.just(Unit)\n    }");
        return just;
    }

    public final h.c.b0<Optional<ConsumerAddress>> resolveAddress(final Blockchain blockchain, final CurrencyCode currencyCode) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        if (!this.coinbaseApi.isAuthorized()) {
            h.c.b0<Optional<ConsumerAddress>> just = h.c.b0.just(OptionalKt.toOptional(null));
            kotlin.jvm.internal.m.f(just, "just(null.toOptional())");
            return just;
        }
        h.c.b0<Optional<ConsumerAddress>> flatMap = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.repositories.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConsumerAccountsRepository.p(Blockchain.this, currencyCode, this);
            }
        }).subscribeOn(this.resolvedAddressCacheScheduler).observeOn(this.resolvedAddressCacheScheduler).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.t(ConsumerAccountsRepository.this, blockchain, currencyCode, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "fromCallable {\n                val cacheKey = listOf(blockchain.rawValue, currencyCode.code).joinToString(\",\")\n\n                resolvedAddressCache[cacheKey].toOptional()\n            }\n            .subscribeOn(resolvedAddressCacheScheduler)\n            .observeOn(resolvedAddressCacheScheduler)\n            .flatMap { consumerAddressOptional ->\n                consumerAddressOptional.toNullable()?.let { Single.just(consumerAddressOptional) }\n                    ?: resolveConsumerUserAddress(blockchain = blockchain, currencyCode = currencyCode)\n            }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        observeConsumerAccessToken();
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        h.c.k0.b subscribe = storeInterface.observe(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.q0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.R((Optional) obj);
            }
        }).observeOn(this.resolvedAddressCacheScheduler).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.o0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.P(ConsumerAccountsRepository.this, (Boolean) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "store.observe(StoreKeys.consumerUser)\n            .map { it.toNullable() != null }\n            .observeOn(resolvedAddressCacheScheduler)\n            .map { hasConsumerUser ->\n                if (hasConsumerUser) return@map\n                resolvedAddressCache.clear()\n            }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
        h.c.s flatMapSingle = this.store.observe(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys)).distinctUntilChanged(new h.c.m0.d() { // from class: com.coinbase.wallet.consumer.repositories.v
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return ConsumerAccountsRepository.w((Optional) obj, (Optional) obj2);
            }
        }).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.repositories.z
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return ConsumerAccountsRepository.A(ConsumerAccountsRepository.this, (Optional) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsRepository.z(ConsumerAccountsRepository.this, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "store.observe(StoreKeys.consumerUser)\n            .distinctUntilChanged { t1, t2 -> t1.toNullable()?.id == t2.toNullable()?.id }\n            .filter { it.toNullable()?.restrictions?.isEmpty() == true && store.has(StoreKeys.consumerAccessToken) }\n            .flatMapSingle { refresh(false) }");
        h.c.t0.a.a(h.c.t0.g.h(flatMapSingle, null, null, ConsumerAccountsRepository$start$6.INSTANCE, 3, null), this.disposeBag);
    }

    private final h.c.b0<kotlin.x> deleteAccounts(boolean z) {
        List<String> restrictions;
        if (this.coinbaseApi.isAuthorized()) {
            ConsumerUser consumerUser = (ConsumerUser) this.store.get(StoreKeys_ConsumerConnectKt.getConsumerUser(StoreKeys.INSTANCE));
            if (!((consumerUser == null || (restrictions = consumerUser.getRestrictions()) == null || !(restrictions.isEmpty() ^ true)) ? false : true)) {
                h.c.b0 flatMap = this.userDao.get().subscribeOn(getConcurrentScheduler()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.d
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.e(ConsumerAccountsRepository.this, (List) obj);
                    }
                }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.p
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.q(ConsumerAccountsRepository.this, (kotlin.x) obj);
                    }
                }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.f
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerAccountsRepository.g(ConsumerAccountsRepository.this, (kotlin.x) obj);
                    }
                });
                kotlin.jvm.internal.m.f(flatMap, "userDao.get()\n            .subscribeOn(concurrentScheduler)\n            .flatMap { users ->\n                if (users.isEmpty()) {\n                    Single.just(Unit)\n                } else {\n                    consumerAPI\n                        .deleteWalletAddresses(users[0].toshiId)\n                        .onErrorResumeNext { Single.just(Unit) }\n                }\n            }\n            .flatMap {\n                val user = store.get(StoreKeys.activeUser)\n                if (user == null) {\n                    Single.just(Unit)\n                } else {\n                    consumerAPI\n                        .deleteWalletAddresses(user.id.toString())\n                        .onErrorResumeNext { Single.just(Unit) }\n                }\n            }\n            .flatMap { consumerAccountsDAO.deleteAccounts() }");
                return Single_AnalyticsKt.logError$default(Single_CoreKt.asUnit(flatMap), null, null, 3, null);
            }
        }
        h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
        kotlin.jvm.internal.m.f(just, "just(Unit)");
        return just;
    }
}