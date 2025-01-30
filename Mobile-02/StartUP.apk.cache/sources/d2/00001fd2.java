package com.coinbase.wallet.features.send.repositories;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.bitcoincash.extensions.Blockchain_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.ConsumerAddress;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.send.apis.RecipientAPI;
import com.coinbase.wallet.features.send.daos.RecipientDao;
import com.coinbase.wallet.features.send.exceptions.SendException;
import com.coinbase.wallet.features.send.models.AddressResolution;
import com.coinbase.wallet.features.send.models.AddressSearchResult;
import com.coinbase.wallet.features.send.models.Recipient;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.txhistory.daos.TxAddressDAO;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.txhistory.models.TxAddress;
import com.coinbase.wallet.user.extensions.StoreKeys_UserKt;
import com.coinbase.wallet.user.extensions.Strings_UserKt;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.walletengine.services.resolver.ResolutionResult;
import com.coinbase.walletengine.services.resolver.ResolverService;
import h.c.b0;
import h.c.h0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.z;
import kotlin.l0.x;
import kotlin.l0.y;

/* compiled from: RecipientRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bQ\u0010RJ+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\nJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJO\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J#\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010*\u001a\u00020'2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\b\u0012\u0004\u0012\u00020+0\u00062\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b/\u00100J)\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b1\u0010\nR\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR:\u0010O\u001a&\u0012\f\u0012\n N*\u0004\u0018\u00010\u00110\u0011 N*\u0012\u0012\f\u0012\n N*\u0004\u0018\u00010\u00110\u0011\u0018\u00010M0M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/coinbase/wallet/features/send/repositories/RecipientRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "", "query", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lh/c/b0;", "", "Lcom/coinbase/wallet/features/send/models/AddressSearchResult;", "searchAll", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Wallet;)Lh/c/b0;", "searchUsernames", "searchSuggestions", "getSuggestions", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "resolveENS", "", "isValidQuery", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Wallet;)Z", "destination", "Lcom/coinbase/walletengine/services/resolver/ResolutionResult;", "results", "Lkotlin/x;", "checkDomainResolutionResults", "(Ljava/lang/String;Ljava/util/List;)V", "start", "()V", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "recipientType", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "metadataKey", SendConfirmationArgs.metadataKey, "Lcom/coinbase/wallet/features/send/models/Recipient;", "getRecipient", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)Lh/c/b0;", "recipient", "Lcom/coinbase/wallet/features/send/models/AddressResolution;", "resolution", "saveRecipient", "(Lcom/coinbase/wallet/features/send/models/Recipient;Lcom/coinbase/wallet/features/send/models/AddressResolution;)Lh/c/b0;", "resolveAddress", "(Lcom/coinbase/wallet/features/send/models/Recipient;)Lh/c/b0;", "search", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/features/send/daos/RecipientDao;", "recipientDAO", "Lcom/coinbase/wallet/features/send/daos/RecipientDao;", "Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;", "txAddressDAO", "Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/walletengine/services/resolver/ResolverService;", "resolverService", "Lcom/coinbase/walletengine/services/resolver/ResolverService;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "consumerAccountsRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "Lcom/coinbase/wallet/features/send/apis/RecipientAPI;", "recipientAPI", "Lcom/coinbase/wallet/features/send/apis/RecipientAPI;", "Lh/c/s;", "kotlin.jvm.PlatformType", "hasConsumerUserObservable", "Lh/c/s;", "<init>", "(Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;Lcom/coinbase/wallet/features/send/daos/RecipientDao;Lcom/coinbase/wallet/features/send/apis/RecipientAPI;Lcom/coinbase/walletengine/services/resolver/ResolverService;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RecipientRepository implements Startable {
    private final ConsumerAccountsRepository consumerAccountsRepository;
    private final h.c.k0.a disposeBag;
    private final FeatureFlagsRepository featureFlagRepository;
    private final h.c.s<Boolean> hasConsumerUserObservable;
    private final RecipientAPI recipientAPI;
    private final RecipientDao recipientDAO;
    private final ResolverService resolverService;
    private final StoreInterface store;
    private final TxAddressDAO txAddressDAO;
    private final ITxRepository txRepository;

    /* compiled from: RecipientRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecipientType.values().length];
            iArr[RecipientType.Coinbase.ordinal()] = 1;
            iArr[RecipientType.ENS.ordinal()] = 2;
            iArr[RecipientType.User.ordinal()] = 3;
            iArr[RecipientType.Address.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RecipientRepository(TxAddressDAO txAddressDAO, RecipientDao recipientDAO, RecipientAPI recipientAPI, ResolverService resolverService, StoreInterface store, ConsumerAccountsRepository consumerAccountsRepository, FeatureFlagsRepository featureFlagRepository, ITxRepository txRepository) {
        kotlin.jvm.internal.m.g(txAddressDAO, "txAddressDAO");
        kotlin.jvm.internal.m.g(recipientDAO, "recipientDAO");
        kotlin.jvm.internal.m.g(recipientAPI, "recipientAPI");
        kotlin.jvm.internal.m.g(resolverService, "resolverService");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(consumerAccountsRepository, "consumerAccountsRepository");
        kotlin.jvm.internal.m.g(featureFlagRepository, "featureFlagRepository");
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        this.txAddressDAO = txAddressDAO;
        this.recipientDAO = recipientDAO;
        this.recipientAPI = recipientAPI;
        this.resolverService = resolverService;
        this.store = store;
        this.consumerAccountsRepository = consumerAccountsRepository;
        this.featureFlagRepository = featureFlagRepository;
        this.txRepository = txRepository;
        this.disposeBag = new h.c.k0.a();
        this.hasConsumerUserObservable = store.observe(StoreKeys_ConsumerConnectKt.getConsumerUser(StoreKeys.INSTANCE)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.b((Optional) obj);
            }
        });
    }

    public static /* synthetic */ Boolean b(Optional optional) {
        return m1339hasConsumerUserObservable$lambda0(optional);
    }

    public static /* synthetic */ List c(String str, kotlin.t tVar) {
        return m1350searchAll$lambda14(str, tVar);
    }

    private final void checkDomainResolutionResults(String str, List<ResolutionResult> list) {
        String a1;
        int r;
        List P;
        a1 = y.a1(str, ".", null, 2, null);
        if (list.size() > 1) {
            r = kotlin.a0.s.r(list, 10);
            ArrayList arrayList = new ArrayList(r);
            for (ResolutionResult resolutionResult : list) {
                String address = resolutionResult.getAddress();
                Locale US = Locale.US;
                kotlin.jvm.internal.m.f(US, "US");
                Objects.requireNonNull(address, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = address.toLowerCase(US);
                kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                arrayList.add(lowerCase);
            }
            P = z.P(arrayList);
            boolean z = P.size() == 1;
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.domainNameCollision(AnalyticsEvent.Companion, a1, z));
            if (!z) {
                throw SendException.MultipleUnmatchingDomainResolutions.INSTANCE;
            }
        } else if (!list.isEmpty()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.domainResult(AnalyticsEvent.Companion, a1, ((ResolutionResult) kotlin.a0.p.Y(list)).getResolveType()));
        }
    }

    public static /* synthetic */ Optional d(String str, Optional optional) {
        return m1348resolveENS$lambda28$lambda27(str, optional);
    }

    public static /* synthetic */ AddressResolution e(Optional optional) {
        return m1341resolveAddress$lambda7$lambda3(optional);
    }

    public static /* synthetic */ List f(RecipientRepository recipientRepository, List list) {
        return m1352searchUsernames$lambda16(recipientRepository, list);
    }

    public static /* synthetic */ Optional g(String str, Boolean bool) {
        return m1347resolveENS$lambda28$lambda26$lambda25$lambda24(str, bool);
    }

    /* renamed from: getRecipient$lambda-2 */
    public static final Recipient m1336getRecipient$lambda2(String destination, RecipientType recipientType, CurrencyCode currencyCode, Blockchain blockchain, Network network, TxMetadataKey txMetadataKey, String str, Optional it) {
        kotlin.jvm.internal.m.g(destination, "$destination");
        kotlin.jvm.internal.m.g(recipientType, "$recipientType");
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(it, "it");
        return it.toNullable() != null ? (Recipient) it.toNullable() : new Recipient(destination, recipientType, currencyCode, blockchain, network, txMetadataKey, str);
    }

    private final b0<List<AddressSearchResult>> getSuggestions(Wallet wallet) {
        b0<Optional<ConsumerAddress>> onErrorReturn;
        b0<List<Recipient>> recipients = this.recipientDAO.getRecipients(wallet.getBlockchain(), wallet.getCurrencyCode(), wallet.getNetwork());
        if (wallet.getNetwork().isTestnet()) {
            onErrorReturn = b0.just(OptionalKt.toOptional(null));
            kotlin.jvm.internal.m.f(onErrorReturn, "{\n            Single.just(null.toOptional())\n        }");
        } else {
            onErrorReturn = this.consumerAccountsRepository.resolveAddress(wallet.getBlockchain(), wallet.getCurrencyCode()).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.r
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return RecipientRepository.o((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "{\n            consumerAccountsRepository\n                .resolveAddress(\n                    blockchain = wallet.blockchain,\n                    currencyCode = wallet.currencyCode\n                )\n                .onErrorReturn { null.toOptional() }\n        }");
        }
        b0<List<AddressSearchResult>> map = h.c.t0.e.a.a(recipients, onErrorReturn).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.n((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(getCachedRecipients, getConsumerAddress)\n            .map { (cachedRecipients, consumerAddressOptional) ->\n                val recipients = cachedRecipients\n                    .map {\n                        AddressSearchResult(\n                            destination = it.destination,\n                            recipientType = it.recipientType,\n                            metadataKey = it.metadataKey,\n                            metadata = it.metadata\n                        )\n                    }\n\n                consumerAddressOptional.toNullable()?.let { consumerAddress ->\n                    val filteredRecipients = recipients.filter { it.recipientType != RecipientType.Coinbase }\n                    val consumerSearchResult = AddressSearchResult(\n                        destination = consumerAddress.email,\n                        recipientType = RecipientType.Coinbase,\n                        metadataKey = consumerAddress.metadataKey,\n                        metadata = consumerAddress.metadata\n                    )\n\n                    val suggestions = mutableListOf<AddressSearchResult>()\n                    suggestions.add(consumerSearchResult)\n                    suggestions.addAll(filteredRecipients)\n                    return@map suggestions\n                }\n\n                recipients\n            }");
        return map;
    }

    /* renamed from: getSuggestions$lambda-19 */
    public static final Optional m1337getSuggestions$lambda19(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(null);
    }

    /* renamed from: getSuggestions$lambda-23 */
    public static final List m1338getSuggestions$lambda23(kotlin.o dstr$cachedRecipients$consumerAddressOptional) {
        int r;
        kotlin.jvm.internal.m.g(dstr$cachedRecipients$consumerAddressOptional, "$dstr$cachedRecipients$consumerAddressOptional");
        List<Recipient> cachedRecipients = (List) dstr$cachedRecipients$consumerAddressOptional.a();
        Optional optional = (Optional) dstr$cachedRecipients$consumerAddressOptional.b();
        kotlin.jvm.internal.m.f(cachedRecipients, "cachedRecipients");
        r = kotlin.a0.s.r(cachedRecipients, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Recipient recipient : cachedRecipients) {
            arrayList.add(new AddressSearchResult(recipient.getDestination(), recipient.getRecipientType(), recipient.getMetadataKey(), recipient.getMetadata()));
        }
        ConsumerAddress consumerAddress = (ConsumerAddress) optional.toNullable();
        if (consumerAddress == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((AddressSearchResult) obj).getRecipientType() != RecipientType.Coinbase) {
                arrayList2.add(obj);
            }
        }
        AddressSearchResult addressSearchResult = new AddressSearchResult(consumerAddress.getEmail(), RecipientType.Coinbase, consumerAddress.getMetadataKey(), consumerAddress.getMetadata());
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(addressSearchResult);
        arrayList3.addAll(arrayList2);
        return arrayList3;
    }

    public static /* synthetic */ h0 h(RecipientRepository recipientRepository, String str, Wallet wallet, Boolean bool) {
        return m1345resolveENS$lambda28(recipientRepository, str, wallet, bool);
    }

    /* renamed from: hasConsumerUserObservable$lambda-0 */
    public static final Boolean m1339hasConsumerUserObservable$lambda0(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.toNullable() != null);
    }

    public static /* synthetic */ h0 i(RecipientRepository recipientRepository, String str, Wallet wallet, List list) {
        return m1346resolveENS$lambda28$lambda26(recipientRepository, str, wallet, list);
    }

    private final boolean isValidQuery(String str, Wallet wallet) {
        kotlin.l0.k kVar;
        boolean Q;
        Pattern pattern;
        kotlin.l0.k kVar2;
        kotlin.l0.k kVar3;
        kotlin.l0.k kVar4;
        if (kotlin.jvm.internal.m.c(wallet.getBlockchain(), Blockchain_BitcoinCashKt.getBITCOIN_CASH(Blockchain.Companion))) {
            Q = x.Q(str, "bitcoincash:", false, 2, null);
            if (Q) {
                pattern = RecipientRepositoryKt.bitcoincashPattern;
                Matcher matcher = pattern.matcher(str);
                if (!matcher.find(0)) {
                    kVar4 = RecipientRepositoryKt.validCharactersRegex;
                    return kVar4.d(str);
                }
                String group = matcher.group(2);
                if (group == null) {
                    kVar3 = RecipientRepositoryKt.validCharactersRegex;
                    return kVar3.d(str);
                }
                kVar2 = RecipientRepositoryKt.validCharactersRegex;
                return kVar2.d(group);
            }
        }
        kVar = RecipientRepositoryKt.validCharactersRegex;
        return kVar.d(str);
    }

    public static /* synthetic */ h0 j(String str, RecipientRepository recipientRepository, Wallet wallet, String str2, Boolean bool) {
        return m1349search$lambda8(str, recipientRepository, wallet, str2, bool);
    }

    public static /* synthetic */ h0 k(Recipient recipient, RecipientRepository recipientRepository, Blockchain blockchain, Boolean bool) {
        return m1340resolveAddress$lambda7(recipient, recipientRepository, blockchain, bool);
    }

    public static /* synthetic */ Recipient l(String str, RecipientType recipientType, CurrencyCode currencyCode, Blockchain blockchain, Network network, TxMetadataKey txMetadataKey, String str2, Optional optional) {
        return m1336getRecipient$lambda2(str, recipientType, currencyCode, blockchain, network, txMetadataKey, str2, optional);
    }

    public static /* synthetic */ h0 m(RecipientRepository recipientRepository, Boolean bool) {
        return m1353start$lambda1(recipientRepository, bool);
    }

    public static /* synthetic */ List n(kotlin.o oVar) {
        return m1338getSuggestions$lambda23(oVar);
    }

    public static /* synthetic */ Optional o(Throwable th) {
        return m1337getSuggestions$lambda19(th);
    }

    public static /* synthetic */ String p(Throwable th) {
        return m1343resolveAddress$lambda7$lambda5(th);
    }

    public static /* synthetic */ AddressResolution q(RecipientRepository recipientRepository, Recipient recipient, List list) {
        return m1342resolveAddress$lambda7$lambda4(recipientRepository, recipient, list);
    }

    public static /* synthetic */ AddressResolution r(String str) {
        return m1344resolveAddress$lambda7$lambda6(str);
    }

    /* renamed from: resolveAddress$lambda-7 */
    public static final h0 m1340resolveAddress$lambda7(final Recipient recipient, RecipientRepository this$0, Blockchain blockchain, Boolean isEnabled) {
        kotlin.jvm.internal.m.g(recipient, "$recipient");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(isEnabled, "isEnabled");
        if (isEnabled.booleanValue()) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[recipient.getRecipientType().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return b0.just(new AddressResolution(recipient.getDestination(), recipient.getMetadataKey(), recipient.getMetadata()));
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return this$0.recipientAPI.getUserAddress(recipient.getDestination(), blockchain).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.s
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return RecipientRepository.p((Throwable) obj);
                        }
                    }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.u
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return RecipientRepository.r((String) obj);
                        }
                    });
                }
                ResolverService resolverService = this$0.resolverService;
                String destination = recipient.getDestination();
                String rawValue = blockchain.getRawValue();
                Locale US = Locale.US;
                kotlin.jvm.internal.m.f(US, "US");
                Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
                String upperCase = rawValue.toUpperCase(US);
                kotlin.jvm.internal.m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return resolverService.resolveDomain(destination, upperCase).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.t
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return RecipientRepository.q(RecipientRepository.this, recipient, (List) obj);
                    }
                });
            }
            return this$0.consumerAccountsRepository.resolveAddress(blockchain, recipient.getCurrencyCode()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return RecipientRepository.e((Optional) obj);
                }
            });
        }
        throw SendException.UnableToResolveRecipientAddress.INSTANCE;
    }

    /* renamed from: resolveAddress$lambda-7$lambda-3 */
    public static final AddressResolution m1341resolveAddress$lambda7$lambda3(Optional consumerAddressOptional) {
        kotlin.jvm.internal.m.g(consumerAddressOptional, "consumerAddressOptional");
        ConsumerAddress consumerAddress = (ConsumerAddress) consumerAddressOptional.toNullable();
        if (consumerAddress != null) {
            return new AddressResolution(consumerAddress.getAddress(), consumerAddress.getMetadataKey(), consumerAddress.getMetadata());
        }
        throw SendException.UnableToResolveRecipientAddress.INSTANCE;
    }

    /* renamed from: resolveAddress$lambda-7$lambda-4 */
    public static final AddressResolution m1342resolveAddress$lambda7$lambda4(RecipientRepository this$0, Recipient recipient, List results) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(recipient, "$recipient");
        kotlin.jvm.internal.m.g(results, "results");
        this$0.checkDomainResolutionResults(recipient.getDestination(), results);
        ResolutionResult resolutionResult = (ResolutionResult) kotlin.a0.p.a0(results);
        String address = resolutionResult == null ? null : resolutionResult.getAddress();
        if (address != null) {
            return new AddressResolution(address, null, null);
        }
        throw SendException.UnableToResolveRecipientAddress.INSTANCE;
    }

    /* renamed from: resolveAddress$lambda-7$lambda-5 */
    public static final String m1343resolveAddress$lambda7$lambda5(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        throw SendException.UnableToResolveRecipientAddress.INSTANCE;
    }

    /* renamed from: resolveAddress$lambda-7$lambda-6 */
    public static final AddressResolution m1344resolveAddress$lambda7$lambda6(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new AddressResolution(it, null, null);
    }

    private final b0<Optional<AddressSearchResult>> resolveENS(final String str, final Wallet wallet) {
        boolean V;
        boolean z;
        if (!wallet.getNetwork().isTestnet()) {
            Strings strings = Strings.INSTANCE;
            V = y.V(str, Strings_CoreKt.getPeriod(strings), false, 2, null);
            if (V) {
                z = x.z(str, Strings_CoreKt.getPeriod(strings), false, 2, null);
                if (!z) {
                    b0<Optional<AddressSearchResult>> flatMap = FeatureFlagsRepository.value$default(this.featureFlagRepository, FeatureFlag.ENS, false, 0L, 6, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.k
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return RecipientRepository.h(RecipientRepository.this, str, wallet, (Boolean) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(flatMap, "isENSEnabledSingle\n            .flatMap { isENSEnabled ->\n\n                if (!isENSEnabled) {\n                    return@flatMap Single.just(null.toOptional())\n                }\n\n                resolverService\n                    .resolveDomain(\n                        domainName = query,\n                        assetSymbol = wallet.blockchain.rawValue.toUpperCase(Locale.US)\n                    )\n                    .flatMap { results ->\n                        checkDomainResolutionResults(query, results)\n\n                        results.firstOrNull()?.address?.let { address ->\n                            txRepository\n                                .isValidAddress(wallet.blockchain, wallet.network, address)\n                                .map { if (it) address.toOptional() else null.toOptional() }\n                        } ?: Single.just(null.toOptional())\n                    }\n                    .map { addressOptional ->\n                        addressOptional.toNullable() ?: return@map null.toOptional()\n\n                        AddressSearchResult(\n                            destination = query,\n                            recipientType = RecipientType.ENS,\n                            metadataKey = null,\n                            metadata = null\n                        ).toOptional()\n                    }\n            }");
                    return flatMap;
                }
            }
        }
        b0<Optional<AddressSearchResult>> just = b0.just(OptionalKt.toOptional(null));
        kotlin.jvm.internal.m.f(just, "just(null.toOptional())");
        return just;
    }

    /* renamed from: resolveENS$lambda-28 */
    public static final h0 m1345resolveENS$lambda28(RecipientRepository this$0, final String query, final Wallet wallet, Boolean isENSEnabled) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(query, "$query");
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(isENSEnabled, "isENSEnabled");
        if (!isENSEnabled.booleanValue()) {
            return b0.just(OptionalKt.toOptional(null));
        }
        ResolverService resolverService = this$0.resolverService;
        String rawValue = wallet.getBlockchain().getRawValue();
        Locale US = Locale.US;
        kotlin.jvm.internal.m.f(US, "US");
        Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
        String upperCase = rawValue.toUpperCase(US);
        kotlin.jvm.internal.m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return resolverService.resolveDomain(query, upperCase).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.i(RecipientRepository.this, query, wallet, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.d(query, (Optional) obj);
            }
        });
    }

    /* renamed from: resolveENS$lambda-28$lambda-26 */
    public static final h0 m1346resolveENS$lambda28$lambda26(RecipientRepository this$0, String query, Wallet wallet, List results) {
        final String address;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(query, "$query");
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(results, "results");
        this$0.checkDomainResolutionResults(query, results);
        ResolutionResult resolutionResult = (ResolutionResult) kotlin.a0.p.a0(results);
        h0 map = (resolutionResult == null || (address = resolutionResult.getAddress()) == null) ? null : this$0.txRepository.isValidAddress(wallet.getBlockchain(), wallet.getNetwork(), address).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.g(address, (Boolean) obj);
            }
        });
        return map == null ? b0.just(OptionalKt.toOptional(null)) : map;
    }

    /* renamed from: resolveENS$lambda-28$lambda-26$lambda-25$lambda-24 */
    public static final Optional m1347resolveENS$lambda28$lambda26$lambda25$lambda24(String address, Boolean it) {
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(it, "it");
        if (!it.booleanValue()) {
            address = null;
        }
        return OptionalKt.toOptional(address);
    }

    /* renamed from: resolveENS$lambda-28$lambda-27 */
    public static final Optional m1348resolveENS$lambda28$lambda27(String query, Optional addressOptional) {
        kotlin.jvm.internal.m.g(query, "$query");
        kotlin.jvm.internal.m.g(addressOptional, "addressOptional");
        return ((String) addressOptional.toNullable()) == null ? OptionalKt.toOptional(null) : OptionalKt.toOptional(new AddressSearchResult(query, RecipientType.ENS, null, null));
    }

    public static /* synthetic */ List s(String str, List list) {
        return m1351searchSuggestions$lambda18(str, list);
    }

    /* renamed from: search$lambda-8 */
    public static final h0 m1349search$lambda8(String searchQuery, RecipientRepository this$0, Wallet wallet, String query, Boolean isEnabled) {
        List g2;
        kotlin.jvm.internal.m.g(searchQuery, "$searchQuery");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(query, "$query");
        kotlin.jvm.internal.m.g(isEnabled, "isEnabled");
        if (!isEnabled.booleanValue()) {
            g2 = kotlin.a0.r.g();
            return b0.just(g2);
        }
        if (searchQuery.length() == 0) {
            return this$0.getSuggestions(wallet);
        }
        if (!this$0.isValidQuery(query, wallet)) {
            return b0.error(SendException.InvalidSearchQuery.INSTANCE);
        }
        if (searchQuery.length() < 3) {
            return this$0.searchSuggestions(searchQuery, wallet);
        }
        return this$0.searchAll(searchQuery, wallet);
    }

    private final b0<List<AddressSearchResult>> searchAll(final String str, Wallet wallet) {
        b0<List<AddressSearchResult>> map = h.c.t0.e.a.b(searchSuggestions(str, wallet), Single_AnalyticsKt.logError$default(searchUsernames(str, wallet), null, null, 3, null), Single_AnalyticsKt.logError$default(resolveENS(str, wallet), null, null, 3, null)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.c(str, (kotlin.t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles\n        .zip(\n            searchSuggestions(query = query, wallet = wallet),\n            searchUsernames(query = query, wallet = wallet).logError(),\n            resolveENS(query = query, wallet = wallet).logError()\n        )\n        .map { (suggestions, usernames, ensAddress) ->\n            val suggestionUsernames = suggestions\n                .filter { it.recipientType == RecipientType.User }\n                .map { it.destination }\n                .toSet()\n\n            val searchResults = usernames\n                .filter { !suggestionUsernames.contains(it) }\n                .map {\n                    AddressSearchResult(\n                        destination = it,\n                        recipientType = RecipientType.User,\n                        metadataKey = null,\n                        metadata = null\n                    )\n                }\n\n            val items = mutableListOf<AddressSearchResult>()\n\n            if (ensAddress.toNullable() != null) {\n                val hasENSSuggestion = suggestions.find {\n                    it.recipientType == RecipientType.ENS && query == it.destination.toLowerCase(Locale.US)\n                } != null\n\n                if (!hasENSSuggestion) {\n                    val ens = AddressSearchResult(\n                        destination = query,\n                        recipientType = RecipientType.ENS,\n                        metadataKey = null,\n                        metadata = null\n                    )\n                    items.add(ens)\n                }\n            }\n\n            items.addAll(suggestions)\n            items.addAll(searchResults)\n            items\n        }");
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0104 A[EDGE_INSN: B:116:0x0104->B:98:0x0104 ?: BREAK  , SYNTHETIC] */
    /* renamed from: searchAll$lambda-14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List m1350searchAll$lambda14(java.lang.String r10, kotlin.t r11) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.repositories.RecipientRepository.m1350searchAll$lambda14(java.lang.String, kotlin.t):java.util.List");
    }

    private final b0<List<AddressSearchResult>> searchSuggestions(final String str, Wallet wallet) {
        b0 map = getSuggestions(wallet).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.s(str, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getSuggestions(wallet = wallet)\n        .map { results ->\n            results.filter {\n                it.recipientType != RecipientType.Address && it.destination.toLowerCase(Locale.US).startsWith(query)\n            }\n        }");
        return map;
    }

    /* renamed from: searchSuggestions$lambda-18 */
    public static final List m1351searchSuggestions$lambda18(String query, List results) {
        boolean Q;
        kotlin.jvm.internal.m.g(query, "$query");
        kotlin.jvm.internal.m.g(results, "results");
        ArrayList arrayList = new ArrayList();
        for (Object obj : results) {
            AddressSearchResult addressSearchResult = (AddressSearchResult) obj;
            boolean z = false;
            if (addressSearchResult.getRecipientType() != RecipientType.Address) {
                String destination = addressSearchResult.getDestination();
                Locale US = Locale.US;
                kotlin.jvm.internal.m.f(US, "US");
                Objects.requireNonNull(destination, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = destination.toLowerCase(US);
                kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                Q = x.Q(lowerCase, query, false, 2, null);
                if (Q) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final b0<List<String>> searchUsernames(String str, Wallet wallet) {
        List j2;
        List g2;
        Blockchain.Companion companion = Blockchain.Companion;
        j2 = kotlin.a0.r.j(Blockchain_EthereumKt.getETHEREUM(companion), Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion));
        boolean contains = j2.contains(wallet.getBlockchain());
        if ((!wallet.getNetwork().isTestnet() || contains) && Strings_UserKt.isUsernameValid(str)) {
            b0 map = this.recipientAPI.search(str).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.i
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return RecipientRepository.f(RecipientRepository.this, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "recipientAPI.search(query)\n            .map { usernames ->\n                val currentUsername = store.get(StoreKeys.activeUser)?.username?.toLowerCase(Locale.US)\n\n                usernames.filter { currentUsername != it.toLowerCase(Locale.US) }\n            }");
            return map;
        }
        g2 = kotlin.a0.r.g();
        b0<List<String>> just = b0.just(g2);
        kotlin.jvm.internal.m.f(just, "just(emptyList())");
        return just;
    }

    /* renamed from: searchUsernames$lambda-16 */
    public static final List m1352searchUsernames$lambda16(RecipientRepository this$0, List usernames) {
        String username;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(usernames, "usernames");
        User user = (User) this$0.store.get(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE));
        String str = null;
        if (user != null && (username = user.getUsername()) != null) {
            Locale US = Locale.US;
            kotlin.jvm.internal.m.f(US, "US");
            str = username.toLowerCase(US);
            kotlin.jvm.internal.m.f(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : usernames) {
            String str2 = (String) obj;
            Locale US2 = Locale.US;
            kotlin.jvm.internal.m.f(US2, "US");
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str2.toLowerCase(US2);
            kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!kotlin.jvm.internal.m.c(str, lowerCase)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: start$lambda-1 */
    public static final h0 m1353start$lambda1(RecipientRepository this$0, Boolean hasConsumerUser) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(hasConsumerUser, "hasConsumerUser");
        if (hasConsumerUser.booleanValue()) {
            return b0.just(kotlin.x.a);
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        RecipientDao recipientDao = this$0.recipientDAO;
        RecipientType recipientType = RecipientType.Coinbase;
        return Single_CoreKt.asUnit(eVar.a(recipientDao.deleteRecipients(recipientType), this$0.txAddressDAO.deleteTxAddress(recipientType)));
    }

    public final b0<Recipient> getRecipient(final Blockchain blockchain, final CurrencyCode currencyCode, final Network network, final RecipientType recipientType, final String destination, final TxMetadataKey txMetadataKey, final String str) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(network, "network");
        kotlin.jvm.internal.m.g(recipientType, "recipientType");
        kotlin.jvm.internal.m.g(destination, "destination");
        b0 map = this.recipientDAO.getRecipient(blockchain, currencyCode, network, recipientType, destination, txMetadataKey, str).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.l(destination, recipientType, currencyCode, blockchain, network, txMetadataKey, str, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "recipientDAO\n        .getRecipient(blockchain, currencyCode, network, recipientType, destination, metadataKey, metadata)\n        .map {\n            if (it.toNullable() != null) return@map it.toNullable()\n\n            Recipient(\n                destination = destination,\n                recipientType = recipientType,\n                currencyCode = currencyCode,\n                blockchain = blockchain,\n                network = network,\n                metadataKey = metadataKey,\n                metadata = metadata\n            )\n        }");
        return map;
    }

    public final b0<AddressResolution> resolveAddress(final Recipient recipient) {
        kotlin.jvm.internal.m.g(recipient, "recipient");
        final Blockchain blockchain = recipient.getBlockchain();
        b0<AddressResolution> flatMap = FeatureFlagsRepository.value$default(this.featureFlagRepository, FeatureFlag.SOCIAL_SEND, true, 0L, 4, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.k(Recipient.this, this, blockchain, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "featureFlagRepository.value(featureFlag = FeatureFlag.SOCIAL_SEND, requireRefresh = true)\n            .flatMap { isEnabled ->\n                if (!isEnabled) throw SendException.UnableToResolveRecipientAddress\n\n                when (recipient.recipientType) {\n                    RecipientType.Coinbase -> {\n                        consumerAccountsRepository\n                            .resolveAddress(\n                                blockchain = blockchain,\n                                currencyCode = recipient.currencyCode\n                            )\n                            .map { consumerAddressOptional ->\n                                val consumerAddress = consumerAddressOptional.toNullable()\n                                    ?: throw SendException.UnableToResolveRecipientAddress\n\n                                val address = consumerAddress.address\n\n                                AddressResolution(\n                                    address = address,\n                                    metadataKey = consumerAddress.metadataKey,\n                                    metadata = consumerAddress.metadata\n                                )\n                            }\n                    }\n                    RecipientType.ENS -> {\n                        resolverService\n                            .resolveDomain(\n                                domainName = recipient.destination,\n                                assetSymbol = blockchain.rawValue.uppercase(Locale.US)\n                            )\n                            .map { results ->\n                                checkDomainResolutionResults(recipient.destination, results)\n\n                                val address = results.firstOrNull()?.address\n                                    ?: throw SendException.UnableToResolveRecipientAddress\n                                AddressResolution(address = address, metadataKey = null, metadata = null)\n                            }\n                    }\n                    RecipientType.User -> {\n                        recipientAPI.getUserAddress(username = recipient.destination, chain = blockchain)\n                            .onErrorReturn { throw SendException.UnableToResolveRecipientAddress }\n                            .map { AddressResolution(address = it, metadataKey = null, metadata = null) }\n                    }\n                    RecipientType.Address -> {\n                        val resolution = AddressResolution(\n                            address = recipient.destination,\n                            metadataKey = recipient.metadataKey,\n                            metadata = recipient.metadata\n                        )\n                        Single.just(resolution)\n                    }\n                }\n            }");
        return flatMap;
    }

    public final b0<kotlin.x> saveRecipient(Recipient recipient, AddressResolution resolution) {
        kotlin.jvm.internal.m.g(recipient, "recipient");
        kotlin.jvm.internal.m.g(resolution, "resolution");
        return Single_CoreKt.asUnit(h.c.t0.f.a(this.recipientDAO.save(recipient), this.txAddressDAO.save(new TxAddress(recipient.getBlockchain(), recipient.getCurrencyCode(), recipient.getNetwork(), recipient.getDestination(), resolution.getAddress(), recipient.getRecipientType(), resolution.getMetadataKey(), resolution.getMetadata()))));
    }

    public final b0<List<AddressSearchResult>> search(final String query, final Wallet wallet) {
        CharSequence h1;
        kotlin.jvm.internal.m.g(query, "query");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        h1 = y.h1(query);
        String obj = h1.toString();
        Locale US = Locale.US;
        kotlin.jvm.internal.m.f(US, "US");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
        final String lowerCase = obj.toLowerCase(US);
        kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        b0<List<AddressSearchResult>> flatMap = FeatureFlagsRepository.value$default(this.featureFlagRepository, FeatureFlag.SOCIAL_SEND, true, 0L, 4, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return RecipientRepository.j(lowerCase, this, wallet, query, (Boolean) obj2);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "featureFlagRepository.value(featureFlag = FeatureFlag.SOCIAL_SEND, requireRefresh = true)\n            .flatMap { isEnabled ->\n                // if social send is disabled\n                if (!isEnabled) return@flatMap Single.just(emptyList<AddressSearchResult>())\n\n                // If empty search query, return suggested results\n                if (searchQuery.isEmpty()) return@flatMap getSuggestions(wallet = wallet)\n\n                // Check if search query has valid characters\n                if (!isValidQuery(query, wallet)) {\n                    return@flatMap Single.error<List<AddressSearchResult>>(SendException.InvalidSearchQuery)\n                }\n\n                // Filter suggestion list if query size is less than minimum characters needed to search\n                if (searchQuery.length < minSearchCharacters) {\n                    return@flatMap searchSuggestions(searchQuery, wallet = wallet)\n                }\n\n                // Search everything + lookup ENS\n                searchAll(searchQuery, wallet = wallet)\n            }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.k0.b subscribe = this.hasConsumerUserObservable.flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientRepository.m(RecipientRepository.this, (Boolean) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "hasConsumerUserObservable\n            .flatMapSingle { hasConsumerUser ->\n                if (hasConsumerUser) return@flatMapSingle Single.just(Unit)\n\n                Singles.zip(\n                    recipientDAO.deleteRecipients(recipientType = RecipientType.Coinbase),\n                    txAddressDAO.deleteTxAddress(recipientType = RecipientType.Coinbase)\n                )\n                    .asUnit()\n            }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }
}