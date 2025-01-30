package com.coinbase.wallet.bip44wallets.interfaces;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.CipherCore_wordListEnglishKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception;
import com.coinbase.wallet.bip44wallets.extensions.StoreKeys_BIP44WalletsKt;
import com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging;
import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSettingItem;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: BIP44BasedWalletManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b?\u0010@J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\u001e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u00020#8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u00020(8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010.\u001a\u00020-8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00106\u001a\u0002058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010;\u001a\u00020:8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44BasedWalletManaging;", "Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44BalanceManaging;", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Lkotlin/x;", "createAddresses", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "seed", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "([BLcom/coinbase/wallet/blockchains/models/AddressType;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "hasWallets", "()Lh/c/b0;", "createWallets", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "refresh", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "batchBalanceAPI", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "getBatchBalanceAPI", "()Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "getTracer", "()Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "configuration", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "getConfiguration", "()Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "walletService", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "getWalletService", "()Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class BIP44BasedWalletManaging implements WalletManaging, BIP44BalanceManaging {
    private final AddressDao addressDao;
    private final BatchBalanceAPI batchBalanceAPI;
    private final CipherCoreInterface cipherCore;
    private final BIP44Configuration configuration;
    private final StoreInterface store;
    private final Tracing tracer;
    private final WalletDao walletDao;
    private final BIP44WalletService walletService;

    public BIP44BasedWalletManaging(CipherCoreInterface cipherCore, BIP44WalletService walletService, BIP44Configuration configuration, WalletDao walletDao, AddressDao addressDao, StoreInterface store, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(walletService, "walletService");
        kotlin.jvm.internal.m.g(configuration, "configuration");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        kotlin.jvm.internal.m.g(batchBalanceAPI, "batchBalanceAPI");
        this.cipherCore = cipherCore;
        this.walletService = walletService;
        this.configuration = configuration;
        this.walletDao = walletDao;
        this.addressDao = addressDao;
        this.store = store;
        this.tracer = tracer;
        this.batchBalanceAPI = batchBalanceAPI;
    }

    public static /* synthetic */ Boolean a(Boolean bool) {
        return m759hasWallets$lambda5(bool);
    }

    public static /* synthetic */ h.c.h0 b(BIP44BasedWalletManaging bIP44BasedWalletManaging, Network network, byte[] bArr) {
        return m754createAddresses$lambda10(bIP44BasedWalletManaging, network, bArr);
    }

    public static /* synthetic */ h.c.h0 c(BIP44BasedWalletManaging bIP44BasedWalletManaging, AddressType addressType, Network network, String str) {
        return m755createAddresses$lambda12(bIP44BasedWalletManaging, addressType, network, str);
    }

    private final h.c.b0<kotlin.x> createAddresses(String str, final Network network) {
        h.c.b0<R> flatMap = this.cipherCore.seedFromRecoveryPhrase(str, CipherCore_wordListEnglishKt.getWordListEnglish(CipherCore.Companion)).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.a1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedWalletManaging.b(BIP44BasedWalletManaging.this, network, (byte[]) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "cipherCore\n        .seedFromRecoveryPhrase(mnemonic, wordList = CipherCore.wordListEnglish)\n        .flatMap { seed ->\n            val addressSingles = configuration.supportedAddressTypes.map { addressType ->\n                createAddresses(seed, addressType, network)\n            }\n\n            Singles.zipOrEmpty(addressSingles).asUnit()\n        }");
        return Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null);
    }

    /* renamed from: createAddresses$lambda-10 */
    public static final h.c.h0 m754createAddresses$lambda10(BIP44BasedWalletManaging this$0, Network network, byte[] seed) {
        int r;
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(seed, "seed");
        List<AddressType> supportedAddressTypes = this$0.getConfiguration().getSupportedAddressTypes();
        r = kotlin.a0.s.r(supportedAddressTypes, 10);
        ArrayList arrayList = new ArrayList(r);
        for (AddressType addressType : supportedAddressTypes) {
            arrayList.add(this$0.createAddresses(seed, addressType, network));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedWalletManaging$createAddresses$lambda-10$$inlined$zipOrEmpty$1
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
                        if (obj instanceof kotlin.x) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    /* renamed from: createAddresses$lambda-12 */
    public static final h.c.h0 m755createAddresses$lambda12(BIP44BasedWalletManaging this$0, AddressType addressType, Network network, String xpubKey) {
        List<Boolean> j2;
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(addressType, "$addressType");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(xpubKey, "xpubKey");
        this$0.getStore().set(StoreKeys_BIP44WalletsKt.xpubKey(StoreKeys.INSTANCE, this$0.getConfiguration().getBlockchain(), this$0.getConfiguration().getCurrencyCode(), addressType, network.isTestnet()), xpubKey);
        j2 = kotlin.a0.r.j(Boolean.TRUE, Boolean.FALSE);
        r = kotlin.a0.s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Boolean bool : j2) {
            arrayList.add(this$0.saveAddress(this$0.getConfiguration().getBlockchain(), this$0.getConfiguration().getCurrencyCode(), network, addressType, bool.booleanValue(), 0, xpubKey, true));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            h.c.b0 just = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedWalletManaging$createAddresses$lambda-12$$inlined$zipOrEmpty$1
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

    /* renamed from: createWallets$lambda-8$lambda-7 */
    public static final h.c.h0 m756createWallets$lambda8$lambda7(NetworkSettingItem networkSetting, BIP44BasedWalletManaging this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(networkSetting, "$networkSetting");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return Single_AnalyticsKt.logError$default(this$0.refreshBalances(new RefreshContext(networkSetting.getNetwork(), null, RefreshContext.Mode.Quick.INSTANCE, true, 2, null)), null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.d1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedWalletManaging.e((Throwable) obj);
            }
        });
    }

    /* renamed from: createWallets$lambda-8$lambda-7$lambda-6 */
    public static final kotlin.x m757createWallets$lambda8$lambda7$lambda6(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    public static /* synthetic */ h.c.h0 d(NetworkSettingItem networkSettingItem, BIP44BasedWalletManaging bIP44BasedWalletManaging, kotlin.x xVar) {
        return m756createWallets$lambda8$lambda7(networkSettingItem, bIP44BasedWalletManaging, xVar);
    }

    public static /* synthetic */ kotlin.x e(Throwable th) {
        return m757createWallets$lambda8$lambda7$lambda6(th);
    }

    public static /* synthetic */ Boolean f(List list) {
        return m758hasWallets$lambda4(list);
    }

    /* renamed from: hasWallets$lambda-4 */
    public static final Boolean m758hasWallets$lambda4(List addresses) {
        boolean z;
        kotlin.jvm.internal.m.g(addresses, "addresses");
        boolean z2 = true;
        if (!(addresses instanceof Collection) || !addresses.isEmpty()) {
            Iterator it = addresses.iterator();
            while (it.hasNext()) {
                if (((Optional) it.next()).toNullable() == null) {
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
        }
        z2 = false;
        return Boolean.valueOf(z2);
    }

    /* renamed from: hasWallets$lambda-5 */
    public static final Boolean m759hasWallets$lambda5(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(!it.booleanValue());
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public h.c.b0<kotlin.x> createWallets(String mnemonic) {
        int r;
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        List<NetworkSettingItem> networkSettingItems = getConfiguration().getNetworkSetting().getNetworkSettingItems();
        r = kotlin.a0.s.r(networkSettingItems, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final NetworkSettingItem networkSettingItem : networkSettingItems) {
            arrayList.add(createAddresses(mnemonic, networkSettingItem.getNetwork()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.c1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BasedWalletManaging.d(NetworkSettingItem.this, this, (kotlin.x) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedWalletManaging$createWallets$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof kotlin.x : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public BatchBalanceAPI getBatchBalanceAPI() {
        return this.batchBalanceAPI;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public StoreInterface getStore() {
        return this.store;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public Tracing getTracer() {
        return this.tracer;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public WalletDao getWalletDao() {
        return this.walletDao;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public BIP44WalletService getWalletService() {
        return this.walletService;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public h.c.b0<Boolean> hasWallets() {
        int r;
        List u;
        h.c.b0 zip;
        List g2;
        int r2;
        int r3;
        List<AddressType> supportedAddressTypes = getConfiguration().getSupportedAddressTypes();
        r = kotlin.a0.s.r(supportedAddressTypes, 10);
        ArrayList arrayList = new ArrayList(r);
        for (AddressType addressType : supportedAddressTypes) {
            List<NetworkSettingItem> networkSettingItems = getConfiguration().getNetworkSetting().getNetworkSettingItems();
            r2 = kotlin.a0.s.r(networkSettingItems, 10);
            ArrayList<Network> arrayList2 = new ArrayList(r2);
            for (NetworkSettingItem networkSettingItem : networkSettingItems) {
                arrayList2.add(networkSettingItem.getNetwork());
            }
            r3 = kotlin.a0.s.r(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(r3);
            for (Network network : arrayList2) {
                arrayList3.add(getAddressDao().getAddressForIndex(getConfiguration().getBlockchain(), getConfiguration().getCurrencyCode(), network, addressType, false, 0));
            }
            arrayList.add(arrayList3);
        }
        u = kotlin.a0.s.u(arrayList);
        h.c.t0.e eVar = h.c.t0.e.a;
        if (u.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(u, new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedWalletManaging$hasWallets$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof Optional) {
                            arrayList4.add(obj);
                        }
                    }
                    return arrayList4;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0<Boolean> map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.e1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedWalletManaging.f((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.z0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BIP44BasedWalletManaging.a((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "configuration.supportedAddressTypes\n        .map { addressType ->\n            configuration.networkSetting.networkSettingItems.map { it.network }.map { network ->\n                addressDao.getAddressForIndex(\n                    blockchain = configuration.blockchain,\n                    currencyCode = configuration.currencyCode,\n                    network = network,\n                    addressType = addressType,\n                    isChangeAddress = false,\n                    index = 0\n                )\n            }\n        }\n        .flatten()\n        .zipOrEmpty()\n        .map { addresses -> addresses.any { it.toNullable() == null } }\n        .map { !it }");
        return map;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public h.c.b0<kotlin.x> refresh(RefreshContext context) {
        kotlin.jvm.internal.m.g(context, "context");
        return refreshBalances(context);
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    public h.c.b0<kotlin.x> refreshBalances(RefreshContext refreshContext) {
        return BIP44BalanceManaging.DefaultImpls.refreshBalances(this, refreshContext);
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44BalanceManaging
    public h.c.b0<Boolean> saveAddress(Blockchain blockchain, CurrencyCode currencyCode, Network network, AddressType addressType, boolean z, int i2, String str, boolean z2) {
        return BIP44BalanceManaging.DefaultImpls.saveAddress(this, blockchain, currencyCode, network, addressType, z, i2, str, z2);
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public BIP44Configuration getConfiguration() {
        return this.configuration;
    }

    private final h.c.b0<kotlin.x> createAddresses(byte[] bArr, final AddressType addressType, final Network network) {
        String xpubKeyDerivationPath = getWalletService().xpubKeyDerivationPath(addressType, network.isTestnet());
        if (xpubKeyDerivationPath != null) {
            h.c.b0<R> flatMap = this.cipherCore.xpubKeyFromSeed(bArr, xpubKeyDerivationPath).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.bip44wallets.interfaces.b1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BIP44BasedWalletManaging.c(BIP44BasedWalletManaging.this, addressType, network, (String) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "cipherCore.xpubKeyFromSeed(seed, derivationPath)\n            .flatMap { xpubKey ->\n                val xpubKeyStoreKey = StoreKeys.xpubKey(\n                    blockchain = configuration.blockchain,\n                    currencyCode = configuration.currencyCode,\n                    addressType = addressType,\n                    isTestnet = network.isTestnet\n                )\n\n                store.set(xpubKeyStoreKey, xpubKey)\n\n                listOf(true, false)\n                    .map { isChangeAddress ->\n                        saveAddress(\n                            blockchain = configuration.blockchain,\n                            currencyCode = configuration.currencyCode,\n                            network = network,\n                            addressType = addressType,\n                            isChangeAddress = isChangeAddress,\n                            index = 0,\n                            xpubKey = xpubKey,\n                            shouldSaveOnError = true\n                        )\n                    }\n                    .zipOrEmpty()\n            }");
            return Single_AnalyticsKt.logError$default(Single_CoreKt.asUnit(flatMap), null, null, 3, null);
        }
        throw new BIP44Exception.UnableToDeriveXpubKey(addressType, network.isTestnet());
    }
}