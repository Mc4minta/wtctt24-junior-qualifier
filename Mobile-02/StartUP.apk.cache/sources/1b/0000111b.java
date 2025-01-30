package com.coinbase.wallet.accountwallets.interfaces;

import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.CipherCore_wordListEnglishKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSettingItem;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import h.c.s;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: AccountBasedWalletManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 .2\u00020\u0001:\u0001.B'\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b,\u0010-J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u0019J%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u001c8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0019\u0010%\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedWalletManaging;", "Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Lkotlin/x;", "createAddresses", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "seed", "", "index", "derivationPath", "Lcom/coinbase/wallet/blockchains/models/Address;", "createAddress", "([BILjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "hasWallets", "()Lh/c/b0;", "createWallets", "(Ljava/lang/String;)Lh/c/b0;", "numberOfAddress", "(Lcom/coinbase/wallet/blockchains/models/Network;)I", "(ILcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "deriveAddress", "([BLjava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "configuration", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "<init>", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;Lcom/coinbase/ciphercore/CipherCoreInterface;)V", "Companion", "accountwallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AccountBasedWalletManaging implements WalletManaging {
    public static final Companion Companion = new Companion(null);
    private static String customAddr;
    private final AddressDao addressDao;
    private final CipherCoreInterface cipherCore;
    private final WalletConfiguration configuration;
    private final WalletDao walletDao;

    /* compiled from: AccountBasedWalletManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedWalletManaging$Companion;", "", "", "customAddr", "Ljava/lang/String;", "getCustomAddr", "()Ljava/lang/String;", "setCustomAddr", "(Ljava/lang/String;)V", "<init>", "()V", "accountwallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getCustomAddr() {
            return AccountBasedWalletManaging.customAddr;
        }

        public final void setCustomAddr(String str) {
            AccountBasedWalletManaging.customAddr = str;
        }
    }

    public AccountBasedWalletManaging(AddressDao addressDao, WalletDao walletDao, WalletConfiguration configuration, CipherCoreInterface cipherCore) {
        m.g(addressDao, "addressDao");
        m.g(walletDao, "walletDao");
        m.g(configuration, "configuration");
        m.g(cipherCore, "cipherCore");
        this.addressDao = addressDao;
        this.walletDao = walletDao;
        this.configuration = configuration;
        this.cipherCore = cipherCore;
    }

    public static /* synthetic */ h0 a(AccountBasedWalletManaging accountBasedWalletManaging, Network network, byte[] bArr) {
        return m617createAddresses$lambda10(accountBasedWalletManaging, network, bArr);
    }

    public static /* synthetic */ h0 b(int i2, AccountBasedWalletManaging accountBasedWalletManaging, Network network, String str) {
        return m616createAddress$lambda11(i2, accountBasedWalletManaging, network, str);
    }

    public static /* synthetic */ h0 c(AccountBasedWalletManaging accountBasedWalletManaging, NetworkSettingItem networkSettingItem, List list) {
        return m620createWallets$lambda8$lambda7(accountBasedWalletManaging, networkSettingItem, list);
    }

    private final b0<Address> createAddress(byte[] bArr, final int i2, String str, final Network network) {
        b0 flatMap = deriveAddress(bArr, str).flatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccountBasedWalletManaging.b(i2, this, network, (String) obj);
            }
        });
        m.f(flatMap, "deriveAddress(seed, derivationPath).flatMap { addressString ->\n        val newAddressString = if (BuildConfig.DEBUG) {\n            customAddr ?: addressString\n        } else {\n            addressString\n        }\n\n        val address = Address(\n            index = index,\n            address = newAddressString,\n            balance = BigInteger.ZERO,\n            currencyCode = configuration.currencyCodeForNetwork(network),\n            isChangeAddress = false,\n            network = network,\n            type = configuration.defaultReceiveType,\n            derivationPath = derivationPath(index, network),\n            isUsed = true,\n            blockchain = configuration.blockchain\n        )\n\n        addressDao.save(address)\n    }");
        return flatMap;
    }

    /* renamed from: createAddress$lambda-11 */
    public static final h0 m616createAddress$lambda11(int i2, AccountBasedWalletManaging this$0, Network network, String addressString) {
        m.g(this$0, "this$0");
        m.g(network, "$network");
        m.g(addressString, "addressString");
        BigInteger ZERO = BigInteger.ZERO;
        m.f(ZERO, "ZERO");
        return this$0.addressDao.save(new Address(i2, addressString, ZERO, this$0.getConfiguration().currencyCodeForNetwork(network), false, network, this$0.getConfiguration().getDefaultReceiveType(), this$0.derivationPath(i2, network), true, this$0.getConfiguration().getBlockchain(), null, 1024, null));
    }

    private final b0<x> createAddresses(String str, final Network network) {
        b0<R> flatMap = this.cipherCore.seedFromRecoveryPhrase(str, CipherCore_wordListEnglishKt.getWordListEnglish(CipherCore.Companion)).flatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccountBasedWalletManaging.a(AccountBasedWalletManaging.this, network, (byte[]) obj);
            }
        });
        m.f(flatMap, "cipherCore.seedFromRecoveryPhrase(mnemonic, wordList = CipherCore.wordListEnglish)\n            .flatMap { seed ->\n                Observable.range(0, numberOfAddress(network))\n                    .concatMap { index ->\n                        this\n                            .createAddress(\n                                seed = seed,\n                                index = index,\n                                derivationPath = derivationPath(index, network),\n                                network = network\n                            )\n                            .asUnit()\n                            .toObservable()\n                    }\n                    .last(Unit)\n            }");
        return Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null);
    }

    /* renamed from: createAddresses$lambda-10 */
    public static final h0 m617createAddresses$lambda10(AccountBasedWalletManaging this$0, final Network network, final byte[] seed) {
        m.g(this$0, "this$0");
        m.g(network, "$network");
        m.g(seed, "seed");
        return s.range(0, this$0.numberOfAddress(network)).concatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccountBasedWalletManaging.e(AccountBasedWalletManaging.this, seed, network, (Integer) obj);
            }
        }).last(x.a);
    }

    /* renamed from: createAddresses$lambda-10$lambda-9 */
    public static final h.c.x m618createAddresses$lambda10$lambda9(AccountBasedWalletManaging this$0, byte[] seed, Network network, Integer index) {
        m.g(this$0, "this$0");
        m.g(seed, "$seed");
        m.g(network, "$network");
        m.g(index, "index");
        return Single_CoreKt.asUnit(this$0.createAddress(seed, index.intValue(), this$0.derivationPath(index.intValue(), network), network)).toObservable();
    }

    /* renamed from: createWallets$lambda-8$lambda-5 */
    public static final h0 m619createWallets$lambda8$lambda5(AccountBasedWalletManaging this$0, NetworkSettingItem networkSetting, x it) {
        m.g(this$0, "this$0");
        m.g(networkSetting, "$networkSetting");
        m.g(it, "it");
        return this$0.addressDao.getOrderedAddresses(this$0.getConfiguration().getBlockchain(), this$0.getConfiguration().currencyCodeForNetwork(networkSetting.getNetwork()), networkSetting.getNetwork());
    }

    /* renamed from: createWallets$lambda-8$lambda-7 */
    public static final h0 m620createWallets$lambda8$lambda7(AccountBasedWalletManaging this$0, NetworkSettingItem networkSetting, List addresses) {
        int r;
        List b2;
        m.g(this$0, "this$0");
        m.g(networkSetting, "$networkSetting");
        m.g(addresses, "addresses");
        r = kotlin.a0.s.r(addresses, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = addresses.iterator();
        while (it.hasNext()) {
            Address address = (Address) it.next();
            WalletAddress walletAddress = new WalletAddress(this$0.getConfiguration().getDefaultReceiveType(), address.getAddress(), address.getIndex());
            String address2 = address.getAddress();
            b2 = q.b(walletAddress);
            arrayList.add(new Wallet(address2, b2, this$0.getConfiguration().displayName(networkSetting.getNetwork()), this$0.getConfiguration().currencyCodeForNetwork(networkSetting.getNetwork()), this$0.getConfiguration().imageURLForNetwork(networkSetting.getNetwork()), address.getBalance(), this$0.getConfiguration().getDecimals(), this$0.getConfiguration().getBlockchain(), null, networkSetting.getNetwork(), null, Integer.valueOf(address.getIndex()), 1024, null));
        }
        return this$0.walletDao.saveAll(arrayList);
    }

    public static /* synthetic */ Boolean d(Boolean bool) {
        return m622hasWallets$lambda4(bool);
    }

    public static /* synthetic */ h.c.x e(AccountBasedWalletManaging accountBasedWalletManaging, byte[] bArr, Network network, Integer num) {
        return m618createAddresses$lambda10$lambda9(accountBasedWalletManaging, bArr, network, num);
    }

    public static /* synthetic */ Boolean f(List list) {
        return m621hasWallets$lambda3(list);
    }

    public static /* synthetic */ h0 g(AccountBasedWalletManaging accountBasedWalletManaging, NetworkSettingItem networkSettingItem, x xVar) {
        return m619createWallets$lambda8$lambda5(accountBasedWalletManaging, networkSettingItem, xVar);
    }

    /* renamed from: hasWallets$lambda-3 */
    public static final Boolean m621hasWallets$lambda3(List addresses) {
        boolean z;
        m.g(addresses, "addresses");
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

    /* renamed from: hasWallets$lambda-4 */
    public static final Boolean m622hasWallets$lambda4(Boolean it) {
        m.g(it, "it");
        return Boolean.valueOf(!it.booleanValue());
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public b0<x> createWallets(String mnemonic) {
        int r;
        b0 zip;
        List g2;
        m.g(mnemonic, "mnemonic");
        List<NetworkSettingItem> networkSettingItems = getConfiguration().getNetworkSetting().getNetworkSettingItems();
        r = kotlin.a0.s.r(networkSettingItems, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final NetworkSettingItem networkSettingItem : networkSettingItems) {
            arrayList.add(createAddresses(mnemonic, networkSettingItem.getNetwork()).flatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.k
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AccountBasedWalletManaging.g(AccountBasedWalletManaging.this, networkSettingItem, (x) obj);
                }
            }).flatMap(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AccountBasedWalletManaging.c(AccountBasedWalletManaging.this, networkSettingItem, (List) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            zip = b0.just(g2);
            m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging$createWallets$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    m.g(it, "it");
                    if (it.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof List : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    public abstract String derivationPath(int i2, Network network);

    public abstract b0<String> deriveAddress(byte[] bArr, String str);

    public final CipherCoreInterface getCipherCore() {
        return this.cipherCore;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public WalletConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public b0<Boolean> hasWallets() {
        int r;
        int r2;
        b0 zip;
        List g2;
        List<NetworkSettingItem> networkSettingItems = getConfiguration().getNetworkSetting().getNetworkSettingItems();
        r = kotlin.a0.s.r(networkSettingItems, 10);
        ArrayList<Network> arrayList = new ArrayList(r);
        for (NetworkSettingItem networkSettingItem : networkSettingItems) {
            arrayList.add(networkSettingItem.getNetwork());
        }
        r2 = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (Network network : arrayList) {
            arrayList2.add(this.addressDao.getAddressForIndex(getConfiguration().getBlockchain(), getConfiguration().currencyCodeForNetwork(network), network, getConfiguration().getDefaultReceiveType(), false, 0));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList2.isEmpty()) {
            g2 = r.g();
            zip = b0.just(g2);
            m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList2, new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging$hasWallets$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    m.g(it, "it");
                    if (it.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof Optional) {
                            arrayList3.add(obj);
                        }
                    }
                    return arrayList3;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        b0<Boolean> map = zip.map(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccountBasedWalletManaging.f((List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.accountwallets.interfaces.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccountBasedWalletManaging.d((Boolean) obj);
            }
        });
        m.f(map, "configuration.networkSetting.networkSettingItems\n        .map { it.network }\n        .map { network ->\n            addressDao.getAddressForIndex(\n                blockchain = configuration.blockchain,\n                currencyCode = configuration.currencyCodeForNetwork(network),\n                network = network,\n                addressType = configuration.defaultReceiveType,\n                isChangeAddress = false,\n                index = 0\n            )\n        }\n        .zipOrEmpty()\n        .map { addresses -> addresses.any { it.toNullable() == null } }\n        .map { !it }");
        return map;
    }

    public abstract int numberOfAddress(Network network);
}