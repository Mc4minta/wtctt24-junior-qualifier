package e.j.n;

import android.content.DialogInterface;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.NetworkSettingItem;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.toshi.R;

/* compiled from: NetworkSwitcherViewModel.kt */
/* loaded from: classes2.dex */
public final class s2 extends androidx.lifecycle.b0 {
    private final IWalletRepository a;

    /* renamed from: b */
    private final List<NetworkSetting> f13962b;

    /* renamed from: c */
    private final FeatureFlagsRepository f13963c;

    /* renamed from: d */
    private final h.c.v0.b<PromptDialogHelper.Properties> f13964d;

    /* renamed from: e */
    private final h.c.s<PromptDialogHelper.Properties> f13965e;

    /* compiled from: Observables+Core.kt */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements h.c.m0.n {
        @Override // h.c.m0.n
        /* renamed from: a */
        public final List<T> apply(Object[] it) {
            List<T> g2;
            kotlin.jvm.internal.m.g(it, "it");
            if (it.length == 0) {
                g2 = kotlin.a0.r.g();
                return g2;
            }
            ArrayList arrayList = new ArrayList();
            int length = it.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = it[i2];
                if (obj != null ? obj instanceof kotlin.o : true) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int c2;
            c2 = kotlin.b0.b.c(((NetworkSetting) ((kotlin.o) t).c()).getBlockchain().getRawValue(), ((NetworkSetting) ((kotlin.o) t2).c()).getBlockchain().getRawValue());
            return c2;
        }
    }

    /* compiled from: NetworkSwitcherViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            it.dismiss();
        }
    }

    /* compiled from: NetworkSwitcherViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
        public static final d a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            it.dismiss();
        }
    }

    /* compiled from: NetworkSwitcherViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
        public static final e a = new e();

        e() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            it.dismiss();
        }
    }

    /* compiled from: NetworkSwitcherViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
        public static final f a = new f();

        f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            it.dismiss();
        }
    }

    public s2(IWalletRepository walletRepository, List<NetworkSetting> networkSettings, FeatureFlagsRepository featureFlagRepository) {
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(networkSettings, "networkSettings");
        kotlin.jvm.internal.m.g(featureFlagRepository, "featureFlagRepository");
        this.a = walletRepository;
        this.f13962b = networkSettings;
        this.f13963c = featureFlagRepository;
        h.c.v0.b<PromptDialogHelper.Properties> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<PromptDialogHelper.Properties>()");
        this.f13964d = d2;
        h.c.s<PromptDialogHelper.Properties> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "promptSubject.hide()");
        this.f13965e = hide;
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x00b5, code lost:
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<com.coinbase.wallet.blockchains.models.NetworkSettingItem> a(com.coinbase.wallet.blockchains.models.NetworkSetting r8) {
        /*
            r7 = this;
            java.util.List r8 = r8.getNetworkSettingItems()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        Ld:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto Lbf
            java.lang.Object r1 = r8.next()
            r2 = r1
            com.coinbase.wallet.blockchains.models.NetworkSettingItem r2 = (com.coinbase.wallet.blockchains.models.NetworkSettingItem) r2
            com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository r3 = r7.f13963c
            com.coinbase.wallet.featureflags.models.FeatureFlag r4 = com.coinbase.wallet.featureflags.models.FeatureFlag.POLYGON_ENABLED
            boolean r3 = r3.valueSync(r4)
            com.coinbase.ciphercore.ethereum.EthereumChain$Companion r4 = com.coinbase.ciphercore.ethereum.EthereumChain.Companion
            com.coinbase.wallet.blockchains.models.Network r2 = r2.getNetwork()
            java.lang.String r2 = r2.getRawValue()
            com.coinbase.ciphercore.ethereum.EthereumChain r2 = com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt.fromNetworkRawValue(r4, r2)
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.POLYGON_MAINNET
            r5 = 1
            r6 = 0
            if (r2 == r4) goto L3d
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.POLYGON_TESTNET
            if (r2 != r4) goto L3b
            goto L3d
        L3b:
            r4 = r6
            goto L3e
        L3d:
            r4 = r5
        L3e:
            if (r3 != 0) goto L45
            if (r4 == 0) goto L45
        L42:
            r5 = r6
            goto Lb8
        L45:
            com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository r3 = r7.f13963c
            com.coinbase.wallet.featureflags.models.FeatureFlag r4 = com.coinbase.wallet.featureflags.models.FeatureFlag.BSC_ENABLED
            boolean r3 = r3.valueSync(r4)
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.BSC_MAINNET
            if (r2 == r4) goto L58
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.BSC_TESTNET
            if (r2 != r4) goto L56
            goto L58
        L56:
            r4 = r6
            goto L59
        L58:
            r4 = r5
        L59:
            if (r3 != 0) goto L5e
            if (r4 == 0) goto L5e
            goto L42
        L5e:
            com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository r3 = r7.f13963c
            com.coinbase.wallet.featureflags.models.FeatureFlag r4 = com.coinbase.wallet.featureflags.models.FeatureFlag.FANTOM_ENABLED
            boolean r3 = r3.valueSync(r4)
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.FANTOM_TESTNET
            if (r2 == r4) goto L71
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.FANTOM_MAINNET
            if (r2 != r4) goto L6f
            goto L71
        L6f:
            r4 = r6
            goto L72
        L71:
            r4 = r5
        L72:
            if (r3 != 0) goto L77
            if (r4 == 0) goto L77
            goto L42
        L77:
            com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository r3 = r7.f13963c
            com.coinbase.wallet.featureflags.models.FeatureFlag r4 = com.coinbase.wallet.featureflags.models.FeatureFlag.ARBITRUM_ENABLED
            boolean r3 = r3.valueSync(r4)
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.ARBITRUM_TESTNET
            if (r2 == r4) goto L8a
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.ARBITRUM_MAINNET
            if (r2 != r4) goto L88
            goto L8a
        L88:
            r4 = r6
            goto L8b
        L8a:
            r4 = r5
        L8b:
            if (r3 != 0) goto L90
            if (r4 == 0) goto L90
            goto L42
        L90:
            com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository r3 = r7.f13963c
            com.coinbase.wallet.featureflags.models.FeatureFlag r4 = com.coinbase.wallet.featureflags.models.FeatureFlag.XDAI_ENABLED
            boolean r3 = r3.valueSync(r4)
            if (r3 != 0) goto L9f
            com.coinbase.ciphercore.ethereum.EthereumChain r3 = com.coinbase.ciphercore.ethereum.EthereumChain.XDAI_MAINNET
            if (r2 != r3) goto L9f
            goto L42
        L9f:
            com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository r3 = r7.f13963c
            com.coinbase.wallet.featureflags.models.FeatureFlag r4 = com.coinbase.wallet.featureflags.models.FeatureFlag.AVALANCHE_ENABLED
            boolean r3 = r3.valueSync(r4)
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.AVALANCHE_MAINNET
            if (r2 == r4) goto Lb2
            com.coinbase.ciphercore.ethereum.EthereumChain r4 = com.coinbase.ciphercore.ethereum.EthereumChain.AVALANCHE_FUJI
            if (r2 != r4) goto Lb0
            goto Lb2
        Lb0:
            r2 = r6
            goto Lb3
        Lb2:
            r2 = r5
        Lb3:
            if (r3 != 0) goto Lb8
            if (r2 == 0) goto Lb8
            goto L42
        Lb8:
            if (r5 == 0) goto Ld
            r0.add(r1)
            goto Ld
        Lbf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.n.s2.a(com.coinbase.wallet.blockchains.models.NetworkSetting):java.util.List");
    }

    public static /* synthetic */ List b(List list) {
        return f(list);
    }

    public static /* synthetic */ kotlin.o c(NetworkSetting networkSetting, Network network) {
        return e(networkSetting, network);
    }

    public static final kotlin.o e(NetworkSetting newNetworkSetting, Network it) {
        kotlin.jvm.internal.m.g(newNetworkSetting, "$newNetworkSetting");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.u.a(newNetworkSetting, it);
    }

    public static final List f(List networkSettings) {
        List m;
        List<kotlin.o> B0;
        List m2;
        kotlin.jvm.internal.m.g(networkSettings, "networkSettings");
        m = kotlin.a0.r.m(new a3(LocalizedStrings.INSTANCE.get(R.string.eth_mainnets)));
        Iterator it = networkSettings.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            if (kotlin.jvm.internal.m.c(((NetworkSetting) oVar.c()).getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                NetworkSetting networkSetting = (NetworkSetting) oVar.a();
                Network network = (Network) oVar.b();
                List<NetworkSettingItem> networkSettingItems = networkSetting.getNetworkSettingItems();
                ArrayList<NetworkSettingItem> arrayList = new ArrayList();
                for (Object obj : networkSettingItems) {
                    if (!((NetworkSettingItem) obj).getNetwork().isTestnet()) {
                        arrayList.add(obj);
                    }
                }
                for (NetworkSettingItem networkSettingItem : arrayList) {
                    m.add(new q2(networkSetting, networkSettingItem, kotlin.jvm.internal.m.c(networkSettingItem.getNetwork(), network)));
                }
                m.add(new a3(LocalizedStrings.INSTANCE.get(R.string.eth_testnets)));
                List<NetworkSettingItem> networkSettingItems2 = networkSetting.getNetworkSettingItems();
                ArrayList<NetworkSettingItem> arrayList2 = new ArrayList();
                for (Object obj2 : networkSettingItems2) {
                    if (((NetworkSettingItem) obj2).getNetwork().isTestnet()) {
                        arrayList2.add(obj2);
                    }
                }
                for (NetworkSettingItem networkSettingItem2 : arrayList2) {
                    m.add(new q2(networkSetting, networkSettingItem2, kotlin.jvm.internal.m.c(networkSettingItem2.getNetwork(), network)));
                }
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : networkSettings) {
                    kotlin.o oVar2 = (kotlin.o) obj3;
                    if (((NetworkSetting) oVar2.c()).getNetworkSettingItems().size() > 1 && !kotlin.jvm.internal.m.c(((NetworkSetting) oVar2.c()).getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                        arrayList3.add(obj3);
                    }
                }
                B0 = kotlin.a0.z.B0(arrayList3, new b());
                ArrayList arrayList4 = new ArrayList();
                for (kotlin.o oVar3 : B0) {
                    NetworkSetting networkSetting2 = (NetworkSetting) oVar3.a();
                    Network network2 = (Network) oVar3.b();
                    m2 = kotlin.a0.r.m(new a3(networkSetting2.getBlockchain().getRawValue()));
                    for (NetworkSettingItem networkSettingItem3 : networkSetting2.getNetworkSettingItems()) {
                        m2.add(new q2(networkSetting2, networkSettingItem3, kotlin.jvm.internal.m.c(networkSettingItem3.getNetwork(), network2)));
                    }
                    kotlin.a0.w.y(arrayList4, m2);
                }
                m.addAll(arrayList4);
                return m;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void g(EthereumChain ethereumChain) {
        List b2;
        boolean valueSync = this.f13963c.valueSync(FeatureFlag.OPTIMISM_L2_BETA_PROMPT);
        if ((ethereumChain != null && EthereumChain.OPTIMISM_MAINNET.getChainId() == ethereumChain.getChainId()) && valueSync) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, c.a));
            this.f13964d.onNext(new PromptDialogHelper.Properties(null, localizedStrings.get(R.string.l2_optimism_in_beta_title), localizedStrings.get(R.string.l2_optimism_in_beta_text), null, Integer.valueOf((int) R.drawable.ic_optimism_beta_image), b2, null, false, null, null, d.a, null, null, false, 15305, null));
        }
    }

    private final void h(EthereumChain ethereumChain) {
        List b2;
        if (ethereumChain == EthereumChain.AVALANCHE_MAINNET || ethereumChain == EthereumChain.AVALANCHE_FUJI || ethereumChain == EthereumChain.XDAI_MAINNET) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, e.a));
            this.f13964d.onNext(new PromptDialogHelper.Properties(null, localizedStrings.get(R.string.l2_txhistory_unavailable_title), localizedStrings.get(R.string.l2_txhistory_unavailable_body, ethereumChain.getDisplayName()), null, Integer.valueOf((int) R.drawable.ic_optimism_beta_image), b2, null, false, null, null, f.a, null, null, false, 15305, null));
        }
    }

    public final h.c.s<List<r2>> d() {
        int r;
        h.c.s combineLatest;
        List g2;
        List<NetworkSetting> list = this.f13962b;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final NetworkSetting networkSetting : list) {
            if (kotlin.jvm.internal.m.c(networkSetting.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                networkSetting = NetworkSetting.copy$default(networkSetting, null, null, a(networkSetting), 3, null);
            }
            arrayList.add(this.a.observeNetwork(networkSetting.getBlockchain()).map(new h.c.m0.n() { // from class: e.j.n.p0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return s2.c(NetworkSetting.this, (Network) obj);
                }
            }));
        }
        h.c.t0.c cVar = h.c.t0.c.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            combineLatest = h.c.s.just(g2);
            kotlin.jvm.internal.m.f(combineLatest, "just(emptyList())");
        } else {
            Object[] array = arrayList.toArray(new h.c.s[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            combineLatest = h.c.s.combineLatest((h.c.x[]) array, new a());
            kotlin.jvm.internal.m.f(combineLatest, "combineLatest(observables.toTypedArray()) {\n        if (it.isEmpty()) emptyList() else it.filterIsInstance<T>()\n    }");
        }
        h.c.s<List<r2>> map = combineLatest.map(new h.c.m0.n() { // from class: e.j.n.o0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return s2.b((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "networkSettings\n        .map { networkSetting ->\n            val newNetworkSetting = if (networkSetting.blockchain == Blockchain.ETHEREUM) {\n                networkSetting.copy(networkSettingItems = filterEthChainsByFeatureFlag(networkSetting))\n            } else {\n                networkSetting\n            }\n            walletRepository\n                .observeNetwork(newNetworkSetting.blockchain)\n                .map { newNetworkSetting to it }\n        }\n        .combineLatestOrEmpty()\n        .map { networkSettings ->\n            // Add Eth mainnets section\n            val items = mutableListOf<NetworkSwitcherRow>(SectionHeader(LocalizedStrings[R.string.eth_mainnets]))\n            val (ethNetworkSetting, selectedNetwork) = networkSettings\n                .first { it.first.blockchain == Blockchain.ETHEREUM }\n            ethNetworkSetting.networkSettingItems\n                .filter { !it.network.isTestnet }\n                .mapTo(items) { networkSettingItem ->\n                    NetworkItem(\n                        ethNetworkSetting,\n                        networkSettingItem,\n                        networkSettingItem.network == selectedNetwork\n                    )\n                }\n\n            // Add Eth testnets section\n            items.add(SectionHeader(LocalizedStrings[R.string.eth_testnets]))\n            ethNetworkSetting.networkSettingItems\n                .filter { it.network.isTestnet }\n                .mapTo(items) { networkSettingItem ->\n                    NetworkItem(\n                        ethNetworkSetting,\n                        networkSettingItem,\n                        networkSettingItem.network == selectedNetwork\n                    )\n                }\n\n            // Add all other blockchain sections\n            networkSettings\n                .filter { it.first.networkSettingItems.size > 1 && it.first.blockchain != Blockchain.ETHEREUM }\n                .sortedBy { it.first.blockchain.rawValue }\n                .flatMap { (networkSetting, selectedNetwork) ->\n                    mutableListOf<NetworkSwitcherRow>(\n                        SectionHeader(networkSetting.blockchain.rawValue)\n                    ).apply {\n                        networkSetting\n                            .networkSettingItems\n                            .mapTo(this) { networkSettingItem ->\n                                NetworkItem(\n                                    networkSetting,\n                                    networkSettingItem,\n                                    networkSettingItem.network == selectedNetwork\n                                )\n                            }\n                    }\n                }.apply { items.addAll(this) }\n\n            items\n        }");
        return map;
    }

    public final h.c.s<PromptDialogHelper.Properties> getPromptObservable() {
        return this.f13965e;
    }

    public final void i(q2 networkItem) {
        kotlin.jvm.internal.m.g(networkItem, "networkItem");
        this.a.switchNetwork(networkItem.b().getBlockchain(), networkItem.a().getNetwork());
        EthereumChain fromNetworkRawValue = EthereumChain_EthereumKt.fromNetworkRawValue(EthereumChain.Companion, networkItem.a().getNetwork().getRawValue());
        g(fromNetworkRawValue);
        h(fromNetworkRawValue);
    }
}