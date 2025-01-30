package com.coinbase.wallet.user.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.user.apis.UserApi;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.exceptions.UserException;
import com.coinbase.wallet.user.extensions.StoreKeys_UserKt;
import com.coinbase.wallet.user.extensions.Strings_UserKt;
import com.coinbase.wallet.user.extensions.TraceKey_UserKt;
import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.coinbase.wallet.user.models.LegacyUser;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.h0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: UserRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B9\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b>\u0010?J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u0017J\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u0004H\u0007¢\u0006\u0004\b \u0010\u0007R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010/\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R%\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001e038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/coinbase/wallet/user/repositories/UserRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lh/c/b0;", "Lkotlin/x;", "addBlockchainAddresses", "()Lh/c/b0;", "reloadActiveUser", "Lcom/coinbase/wallet/user/models/User;", ApiConstants.USER, "addOrUpdate", "(Lcom/coinbase/wallet/user/models/User;)Lcom/coinbase/wallet/user/models/User;", "start", "()V", "", "isForced", "refresh", "(Z)Lh/c/b0;", "destroy", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "signIn", "(Ljava/lang/String;)Lh/c/b0;", "username", "isPublic", "createUser", "(Ljava/lang/String;ZLjava/lang/String;)Lh/c/b0;", "validateUsername", "setUserIsPublic", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/user/models/LegacyUser;", "getLegacyUser", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lcom/coinbase/wallet/user/apis/UserApi;", "userApi", "Lcom/coinbase/wallet/user/apis/UserApi;", "Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;", "userDao", "Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;", "Lh/c/k0/a;", "disposeBag$delegate", "Lkotlin/h;", "getDisposeBag", "()Lh/c/k0/a;", "disposeBag", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/s;", "activeUserObservable", "Lh/c/s;", "getActiveUserObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;", "accessTokenRepository", "Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "<init>", "(Lcom/coinbase/wallet/user/apis/UserApi;Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UserRepository implements Startable, Refreshable, Destroyable {
    private final AccessTokenRepository accessTokenRepository;
    private final h.c.s<Optional<User>> activeUserObservable;
    private final kotlin.h disposeBag$delegate;
    private final StoreInterface store;
    private final Tracing tracer;
    private final UserApi userApi;
    private final UserDaoInterface userDao;
    private final IWalletRepository walletRepository;

    public UserRepository(UserApi userApi, UserDaoInterface userDao, AccessTokenRepository accessTokenRepository, StoreInterface store, IWalletRepository walletRepository, Tracing tracer) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(userApi, "userApi");
        kotlin.jvm.internal.m.g(userDao, "userDao");
        kotlin.jvm.internal.m.g(accessTokenRepository, "accessTokenRepository");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.userApi = userApi;
        this.userDao = userDao;
        this.accessTokenRepository = accessTokenRepository;
        this.store = store;
        this.walletRepository = walletRepository;
        this.tracer = tracer;
        b2 = kotlin.k.b(UserRepository$disposeBag$2.INSTANCE);
        this.disposeBag$delegate = b2;
        h.c.s<Optional<User>> distinctUntilChanged = store.observe(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE)).distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "store.observe(StoreKeys.activeUser).distinctUntilChanged()");
        this.activeUserObservable = distinctUntilChanged;
    }

    private final h.c.b0<kotlin.x> addBlockchainAddresses() {
        h.c.b0<R> flatMap = this.walletRepository.getPrimaryReceiveAddresses().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.l(UserRepository.this, (Map) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletRepository.getPrimaryReceiveAddresses()\n        .flatMap { addressesMap ->\n            addressesMap\n                .map { (blockchain, address) -> userApi.addAddresses(blockchain, listOf(address)) }\n                .zipOrEmpty()\n        }");
        return Single_AnalyticsKt.logError$default(Single_CoreKt.asUnit(flatMap), null, null, 3, null);
    }

    /* renamed from: addBlockchainAddresses$lambda-10 */
    public static final h0 m1823addBlockchainAddresses$lambda10(UserRepository this$0, Map addressesMap) {
        List g2;
        List<WalletAddress> b2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(addressesMap, "addressesMap");
        ArrayList arrayList = new ArrayList(addressesMap.size());
        for (Map.Entry entry : addressesMap.entrySet()) {
            UserApi userApi = this$0.userApi;
            b2 = kotlin.a0.q.b((WalletAddress) entry.getValue());
            arrayList.add(userApi.addAddresses((Blockchain) entry.getKey(), b2));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.UserRepository$addBlockchainAddresses$lambda-10$$inlined$zipOrEmpty$1
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
                    if (obj instanceof Boolean) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    private final User addOrUpdate(User user) {
        this.store.set(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE), user);
        return user;
    }

    public static /* synthetic */ boolean b(User user) {
        return m1837start$lambda0(user);
    }

    public static /* synthetic */ Optional c(List list) {
        return m1827getLegacyUser$lambda16(list);
    }

    /* renamed from: createUser$lambda-4 */
    public static final h0 m1824createUser$lambda4(String username, UserRepository this$0, boolean z, String mnemonic, Boolean available) {
        kotlin.jvm.internal.m.g(username, "$username");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(available, "available");
        if (available.booleanValue()) {
            return this$0.accessTokenRepository.createUser(username, z, mnemonic).x(kotlin.x.a);
        }
        throw new UserException.UsernameAlreadyTakenException("Username " + username + " is taken");
    }

    /* renamed from: createUser$lambda-5 */
    public static final h0 m1825createUser$lambda5(UserRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.userApi.getUserProfile().retry(1L);
    }

    /* renamed from: createUser$lambda-6 */
    public static final void m1826createUser$lambda6(UserRepository this$0, User user) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.store.set(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE), user);
    }

    public static /* synthetic */ User d(User user, Throwable th) {
        return m1830reloadActiveUser$lambda13$lambda12(user, th);
    }

    public static /* synthetic */ User e(UserRepository userRepository, User user) {
        return m1831reloadActiveUser$lambda14(userRepository, user);
    }

    public static /* synthetic */ Boolean f(Boolean bool, kotlin.x xVar) {
        return m1834setUserIsPublic$lambda8$lambda7(bool, xVar);
    }

    public static /* synthetic */ kotlin.x g(Throwable th) {
        return m1832reloadActiveUser$lambda15(th);
    }

    private final h.c.k0.a getDisposeBag() {
        return (h.c.k0.a) this.disposeBag$delegate.getValue();
    }

    /* renamed from: getLegacyUser$lambda-16 */
    public static final Optional m1827getLegacyUser$lambda16(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(kotlin.a0.p.a0(it));
    }

    public static /* synthetic */ void h(UserRepository userRepository, User user) {
        m1826createUser$lambda6(userRepository, user);
    }

    public static /* synthetic */ void i(UserRepository userRepository, User user) {
        m1836signIn$lambda3(userRepository, user);
    }

    public static /* synthetic */ User j(User user, Boolean bool) {
        return m1829reloadActiveUser$lambda13$lambda11(user, bool);
    }

    public static /* synthetic */ h0 k(UserRepository userRepository, CreateAccessTokenResponseDTO createAccessTokenResponseDTO) {
        return m1835signIn$lambda2(userRepository, createAccessTokenResponseDTO);
    }

    public static /* synthetic */ h0 l(UserRepository userRepository, Map map) {
        return m1823addBlockchainAddresses$lambda10(userRepository, map);
    }

    public static /* synthetic */ h0 m(UserRepository userRepository, Boolean bool) {
        return m1833setUserIsPublic$lambda8(userRepository, bool);
    }

    public static /* synthetic */ h0 n(String str, UserRepository userRepository, boolean z, String str2, Boolean bool) {
        return m1824createUser$lambda4(str, userRepository, z, str2, bool);
    }

    public static /* synthetic */ h0 o(UserRepository userRepository, User user) {
        return m1838start$lambda1(userRepository, user);
    }

    public static /* synthetic */ h0 p(UserRepository userRepository, User user) {
        return m1828reloadActiveUser$lambda13(userRepository, user);
    }

    public static /* synthetic */ h0 q(UserRepository userRepository, kotlin.x xVar) {
        return m1825createUser$lambda5(userRepository, xVar);
    }

    private final h.c.b0<kotlin.x> reloadActiveUser() {
        h.c.b0<R> flatMap = this.userApi.getUserProfile().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.d0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.p(UserRepository.this, (User) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "userApi.getUserProfile()\n        .flatMap { activeUser ->\n            if (activeUser.isPublic == null) {\n                userApi.updateUserProfile(isPublic = true)\n                    .map { activeUser.copy(isPublic = true) }\n                    .onErrorReturn { activeUser }\n            } else {\n                Single.just(activeUser)\n            }\n        }");
        h.c.b0 map = Single_CoreKt.retryWithDelay(flatMap, 3L, 3L, TimeUnit.SECONDS).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.e(UserRepository.this, (User) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "userApi.getUserProfile()\n        .flatMap { activeUser ->\n            if (activeUser.isPublic == null) {\n                userApi.updateUserProfile(isPublic = true)\n                    .map { activeUser.copy(isPublic = true) }\n                    .onErrorReturn { activeUser }\n            } else {\n                Single.just(activeUser)\n            }\n        }\n        .retryWithDelay(3, 3, TimeUnit.SECONDS)\n        .map { user -> addOrUpdate(user) }");
        h.c.b0<kotlin.x> onErrorReturn = Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(map, null, null, 3, null)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.g((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "userApi.getUserProfile()\n        .flatMap { activeUser ->\n            if (activeUser.isPublic == null) {\n                userApi.updateUserProfile(isPublic = true)\n                    .map { activeUser.copy(isPublic = true) }\n                    .onErrorReturn { activeUser }\n            } else {\n                Single.just(activeUser)\n            }\n        }\n        .retryWithDelay(3, 3, TimeUnit.SECONDS)\n        .map { user -> addOrUpdate(user) }\n        .logError()\n        .asUnit()\n        .onErrorReturn { Unit }");
        return onErrorReturn;
    }

    /* renamed from: reloadActiveUser$lambda-13 */
    public static final h0 m1828reloadActiveUser$lambda13(UserRepository this$0, final User activeUser) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(activeUser, "activeUser");
        if (activeUser.isPublic() == null) {
            return this$0.userApi.updateUserProfile(true).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.x
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return UserRepository.j(User.this, (Boolean) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.r
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return UserRepository.d(User.this, (Throwable) obj);
                }
            });
        }
        return h.c.b0.just(activeUser);
    }

    /* renamed from: reloadActiveUser$lambda-13$lambda-11 */
    public static final User m1829reloadActiveUser$lambda13$lambda11(User activeUser, Boolean it) {
        kotlin.jvm.internal.m.g(activeUser, "$activeUser");
        kotlin.jvm.internal.m.g(it, "it");
        return User.copy$default(activeUser, 0, null, Boolean.TRUE, 3, null);
    }

    /* renamed from: reloadActiveUser$lambda-13$lambda-12 */
    public static final User m1830reloadActiveUser$lambda13$lambda12(User activeUser, Throwable it) {
        kotlin.jvm.internal.m.g(activeUser, "$activeUser");
        kotlin.jvm.internal.m.g(it, "it");
        return activeUser;
    }

    /* renamed from: reloadActiveUser$lambda-14 */
    public static final User m1831reloadActiveUser$lambda14(UserRepository this$0, User user) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(user, "user");
        return this$0.addOrUpdate(user);
    }

    /* renamed from: reloadActiveUser$lambda-15 */
    public static final kotlin.x m1832reloadActiveUser$lambda15(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: setUserIsPublic$lambda-8 */
    public static final h0 m1833setUserIsPublic$lambda8(UserRepository this$0, final Boolean updated) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(updated, "updated");
        return !updated.booleanValue() ? h.c.b0.just(updated) : this$0.reloadActiveUser().map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.f(updated, (kotlin.x) obj);
            }
        });
    }

    /* renamed from: setUserIsPublic$lambda-8$lambda-7 */
    public static final Boolean m1834setUserIsPublic$lambda8$lambda7(Boolean updated, kotlin.x it) {
        kotlin.jvm.internal.m.g(updated, "$updated");
        kotlin.jvm.internal.m.g(it, "it");
        return updated;
    }

    /* renamed from: signIn$lambda-2 */
    public static final h0 m1835signIn$lambda2(UserRepository this$0, CreateAccessTokenResponseDTO it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.userApi.getUserProfile();
    }

    /* renamed from: signIn$lambda-3 */
    public static final void m1836signIn$lambda3(UserRepository this$0, User user) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.store.set(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE), user);
    }

    /* renamed from: start$lambda-0 */
    public static final boolean m1837start$lambda0(User it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !kotlin.jvm.internal.m.c(it.isPublic(), Boolean.FALSE);
    }

    /* renamed from: start$lambda-1 */
    public static final h0 m1838start$lambda1(UserRepository this$0, User it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.addBlockchainAddresses();
    }

    public final h.c.b0<User> createUser(final String username, final boolean z, final String mnemonic) {
        kotlin.jvm.internal.m.g(username, "username");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        h.c.b0<User> doOnSuccess = this.userApi.checkUsernameAvailability(username).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.n(username, this, z, mnemonic, (Boolean) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.e0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.q(UserRepository.this, (kotlin.x) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.user.repositories.v
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                UserRepository.h(UserRepository.this, (User) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSuccess, "userApi.checkUsernameAvailability(username)\n            .flatMap { available ->\n                if (!available) throw UserException.UsernameAlreadyTakenException(\"Username $username is taken\")\n                accessTokenRepository.createUser(username, isPublic, mnemonic).toSingleDefault(Unit)\n            }\n            .flatMap { userApi.getUserProfile().retry(1) }\n            .doOnSuccess { store.set(StoreKeys.activeUser, it) }");
        return doOnSuccess;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        getDisposeBag().d();
        h.c.b0<Boolean> just = h.c.b0.just(Boolean.TRUE);
        kotlin.jvm.internal.m.f(just, "just(true)");
        return just;
    }

    public final h.c.s<Optional<User>> getActiveUserObservable() {
        return this.activeUserObservable;
    }

    public final h.c.b0<Optional<LegacyUser>> getLegacyUser() {
        h.c.b0 map = this.userDao.get().map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.c((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "userDao.get().map { it.firstOrNull().toOptional() }");
        return map;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        h.c.b0<kotlin.x> trace = Single_CoreKt.trace(reloadActiveUser(), TraceKey_UserKt.userRepositoryRefreshTrace(TraceKey.Companion), this.tracer);
        kotlin.jvm.internal.m.f(trace, "reloadActiveUser()\n            .trace(TraceKey.userRepositoryRefreshTrace(), tracer)");
        return trace;
    }

    public final h.c.b0<Boolean> setUserIsPublic(boolean z) {
        h.c.b0 flatMap = this.userApi.updateUserProfile(z).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.m(UserRepository.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "userApi\n        .updateUserProfile(isPublic)\n        .flatMap { updated ->\n            if (!updated) Single.just(updated)\n            else reloadActiveUser().map { updated }\n        }");
        return flatMap;
    }

    public final h.c.b0<User> signIn(String mnemonic) {
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        h.c.b0<User> doOnSuccess = this.accessTokenRepository.signIn(mnemonic).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.k(UserRepository.this, (CreateAccessTokenResponseDTO) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.user.repositories.w
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                UserRepository.i(UserRepository.this, (User) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSuccess, "accessTokenRepository.signIn(mnemonic)\n        .flatMap { userApi.getUserProfile() }\n        .doOnSuccess { store.set(StoreKeys.activeUser, it) }");
        return doOnSuccess;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.k0.b subscribe = Single_AnalyticsKt.logError$default(reloadActiveUser(), null, null, 3, null).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "reloadActiveUser()\n            .logError()\n            .subscribe()");
        h.c.t0.a.a(subscribe, getDisposeBag());
        h.c.s map = this.store.observe(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE)).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.user.repositories.UserRepository$start$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.UserRepository$start$$inlined$unwrap$2
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
        h.c.s flatMapSingle = map.distinctUntilChanged().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.user.repositories.p
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return UserRepository.b((User) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserRepository.o(UserRepository.this, (User) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "store.observe(StoreKeys.activeUser)\n            .unwrap()\n            .distinctUntilChanged()\n            .filter { it.isPublic != false }\n            .flatMapSingle { addBlockchainAddresses() }");
        h.c.k0.b subscribe2 = Observable_AnalyticsKt.logError$default(flatMapSingle, null, null, 3, null).subscribe();
        kotlin.jvm.internal.m.f(subscribe2, "store.observe(StoreKeys.activeUser)\n            .unwrap()\n            .distinctUntilChanged()\n            .filter { it.isPublic != false }\n            .flatMapSingle { addBlockchainAddresses() }\n            .logError()\n            .subscribe()");
        h.c.t0.a.a(subscribe2, getDisposeBag());
    }

    public final h.c.b0<Boolean> validateUsername(String username) {
        kotlin.jvm.internal.m.g(username, "username");
        if (Strings_UserKt.isUsernameValid(username)) {
            return this.userApi.checkUsernameAvailability(username);
        }
        h.c.b0<Boolean> just = h.c.b0.just(Boolean.FALSE);
        kotlin.jvm.internal.m.f(just, "just(false)");
        return just;
    }
}