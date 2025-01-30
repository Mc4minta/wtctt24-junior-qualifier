package com.coinbase.wallet.features.wallets.viewmodels;

import android.os.Bundle;
import androidx.lifecycle.b0;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.features.wallets.models.ListItem;
import com.coinbase.wallet.features.wallets.models.WalletsEmptyState;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.h0;
import h.c.s;
import h.c.x;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.a0.z;
import kotlin.o;
import kotlin.t;
import kotlin.u;
import org.toshi.R;

/* compiled from: WalletsTabViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eRR\u0010\u0012\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \u0011*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f \u0011*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \u0011*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000eR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR%\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000e¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/features/wallets/viewmodels/WalletsTabViewModel;", "Landroidx/lifecycle/b0;", "Landroid/os/Bundle;", "args", "Lkotlin/Function0;", "Lkotlin/x;", "onPromptDismiss", "Lh/c/b0;", "", "backupIfNeeded", "(Landroid/os/Bundle;Lkotlin/e0/c/a;)Lh/c/b0;", "Lh/c/s;", "isScanningObservable", "Lh/c/s;", "()Lh/c/s;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "usersWalletsObservable", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "Lcom/coinbase/wallet/features/wallets/models/WalletsEmptyState;", "updateEmptyStateViewObservable", "getUpdateEmptyStateViewObservable", "Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt;", "cloudBackupPrompt", "Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "walletsObservable", "getWalletsObservable", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Le/j/j/b;", "appPrefs", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "networkSettings", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Le/j/j/b;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Ljava/util/List;Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt;Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsTabViewModel extends b0 {
    private final CloudBackupPrompt cloudBackupPrompt;
    private final ConsumerUserRepository consumerUserRepository;
    private final s<Boolean> isScanningObservable;
    private final s<WalletsEmptyState> updateEmptyStateViewObservable;
    private final s<List<Wallet>> usersWalletsObservable;
    private final s<List<ListItem.WalletListItem>> walletsObservable;

    public WalletsTabViewModel(final IWalletRepository walletRepository, final TxHistoryRepository txHistoryRepository, IFiatCurrencyRepository fiatCurrencyRepository, IExchangeRateRepository exchangeRateRepository, e.j.j.b appPrefs, final CurrencyFormatter currencyFormatter, List<NetworkSetting> networkSettings, CloudBackupPrompt cloudBackupPrompt, ConsumerUserRepository consumerUserRepository) {
        int r;
        s<Boolean> switchMap;
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(txHistoryRepository, "txHistoryRepository");
        kotlin.jvm.internal.m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(networkSettings, "networkSettings");
        kotlin.jvm.internal.m.g(cloudBackupPrompt, "cloudBackupPrompt");
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        this.cloudBackupPrompt = cloudBackupPrompt;
        this.consumerUserRepository = consumerUserRepository;
        h.c.t0.c cVar = h.c.t0.c.a;
        s<List<Wallet>> usersWalletsObservable = cVar.a(walletRepository.observeWallets(false), txHistoryRepository.observeAllHistoryUpdates()).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h0 m1552usersWalletsObservable$lambda3;
                m1552usersWalletsObservable$lambda3 = WalletsTabViewModel.m1552usersWalletsObservable$lambda3(TxHistoryRepository.this, (o) obj);
                return m1552usersWalletsObservable$lambda3;
            }
        });
        this.usersWalletsObservable = usersWalletsObservable;
        kotlin.jvm.internal.m.f(usersWalletsObservable, "usersWalletsObservable");
        s<List<ExchangeRate>> distinctUntilChanged = exchangeRateRepository.getExchangeRateObservable().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "exchangeRateRepository.exchangeRateObservable.distinctUntilChanged()");
        s<FiatCurrency> distinctUntilChanged2 = fiatCurrencyRepository.getActiveCurrencyObservable().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged2, "fiatCurrencyRepository.activeCurrencyObservable.distinctUntilChanged()");
        s<List<ListItem.WalletListItem>> map = cVar.b(usersWalletsObservable, distinctUntilChanged, distinctUntilChanged2).observeOn(h.c.u0.a.a()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletsTabViewModel.b(CurrencyFormatter.this, (t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Observables\n        .combineLatest(\n            usersWalletsObservable,\n            exchangeRateRepository.exchangeRateObservable.distinctUntilChanged(),\n            fiatCurrencyRepository.activeCurrencyObservable.distinctUntilChanged()\n        )\n        .observeOn(Schedulers.computation())\n        .map { (wallets, _, _) ->\n            wallets.map { wallet ->\n                val fiatBalance = currencyFormatter.formatToFiat(\n                    fromCurrencyCode = wallet.currencyCode,\n                    contractAddress = wallet.contractAddress,\n                    decimals = wallet.decimals,\n                    value = wallet.balance,\n                    chainId = wallet.network.asEthereumChain?.chainId\n                )\n\n                val cryptoBalance = currencyFormatter.formatToCrypto(\n                    currencyCode = wallet.currencyCode,\n                    decimals = wallet.decimals,\n                    value = wallet.balance,\n                    includeCode = false\n                )\n\n                ListItem.WalletListItem(wallet, fiatBalance, cryptoBalance)\n            }\n        }");
        this.walletsObservable = map;
        if (appPrefs.p()) {
            switchMap = s.just(Boolean.FALSE);
            kotlin.jvm.internal.m.f(switchMap, "{\n        Observable.just(false)\n    }");
        } else {
            ArrayList<NetworkSetting> arrayList = new ArrayList();
            for (Object obj : networkSettings) {
                if (!kotlin.jvm.internal.m.c(((NetworkSetting) obj).getBlockchain(), Blockchain_RippleKt.getXRP(Blockchain.Companion))) {
                    arrayList.add(obj);
                }
            }
            r = kotlin.a0.s.r(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(r);
            for (final NetworkSetting networkSetting : arrayList) {
                arrayList2.add(walletRepository.observeNetwork(networkSetting.getBlockchain()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.i
                    @Override // h.c.m0.n
                    public final Object apply(Object obj2) {
                        return WalletsTabViewModel.a(NetworkSetting.this, (Network) obj2);
                    }
                }));
            }
            s zip = s.zip(arrayList2, new h.c.m0.n<Object[], R>() { // from class: com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel$special$$inlined$zip$1
                /* JADX WARN: Type inference failed for: r6v3, types: [R, java.util.Collection, java.util.ArrayList] */
                @Override // h.c.m0.n
                public final R apply(Object[] it) {
                    List c2;
                    int r2;
                    int r3;
                    kotlin.jvm.internal.m.h(it, "it");
                    c2 = kotlin.a0.m.c(it);
                    r2 = kotlin.a0.s.r(c2, 10);
                    ArrayList<o> arrayList3 = new ArrayList(r2);
                    for (T t : c2) {
                        if (t == null) {
                            throw new TypeCastException("null cannot be cast to non-null type T");
                        }
                        arrayList3.add(t);
                    }
                    r3 = kotlin.a0.s.r(arrayList3, 10);
                    ?? r6 = (R) new ArrayList(r3);
                    for (o oVar : arrayList3) {
                        Network network = (Network) oVar.b();
                        IWalletRepository iWalletRepository = IWalletRepository.this;
                        kotlin.jvm.internal.m.f(network, "network");
                        r6.add(iWalletRepository.isSynced((Blockchain) oVar.a(), network));
                    }
                    return r6;
                }
            });
            kotlin.jvm.internal.m.d(zip, "Observable.zip(this) { z…List().map { it as T }) }");
            switchMap = zip.switchMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.l
                @Override // h.c.m0.n
                public final Object apply(Object obj2) {
                    return WalletsTabViewModel.d((List) obj2);
                }
            });
            kotlin.jvm.internal.m.f(switchMap, "{\n        // Go through all of the crypto currencies we know about and check if we are still scanning for that currency\n        networkSettings\n            // TODO: Remove when xrp node becomes reliable otherwise scanning pill is always displayed\n            .filter { it.blockchain != Blockchain.XRP }\n            .map { networkSetting ->\n                walletRepository.observeNetwork(networkSetting.blockchain).map { networkSetting.blockchain to it }\n            }\n            .zip { it.map { (blockchain, network) -> walletRepository.isSynced(blockchain, network) } }\n            .switchMap { it.combineLatest { syncedList -> syncedList.contains(false) } }\n    }");
        }
        this.isScanningObservable = switchMap;
        h.c.t0.c cVar2 = h.c.t0.c.a;
        s<List<Wallet>> observeWallets = walletRepository.observeWallets(true);
        s<ConsumerConnectionStatus> observable = this.consumerUserRepository.getConnectStatus(false).toObservable();
        kotlin.jvm.internal.m.f(observable, "consumerUserRepository.getConnectStatus(requireRefresh = false).toObservable()");
        s<WalletsEmptyState> map2 = cVar2.b(observeWallets, switchMap, observable).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.n
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return WalletsTabViewModel.f((t) obj2);
            }
        });
        kotlin.jvm.internal.m.f(map2, "Observables\n        .combineLatest(\n            walletRepository.observeWallets(true),\n            isScanningObservable,\n            consumerUserRepository.getConnectStatus(requireRefresh = false).toObservable()\n        )\n        .map { (wallets, isScanning, connectStatus) ->\n            when {\n                wallets.isNotEmpty() -> WalletsEmptyState(\n                    title = R.string.empty,\n                    subtitle = R.string.empty,\n                    transferButtonVisible = false\n                )\n                isScanning -> WalletsEmptyState(\n                    title = R.string.wallet_empty_scanning_title,\n                    subtitle = R.string.wallet_empty_scanning_subtitle,\n                    transferButtonVisible = false\n                )\n                else ->\n                    if (connectStatus.onrampEnabled) {\n                        Analytics.log(AnalyticsEvent.walletsEmptyStateViewed(onrampEnabled = true))\n                        WalletsEmptyState(\n                            title = R.string.wallet_no_coins_found_title,\n                            subtitle = R.string.wallet_no_coins_found_subtitle_onramp,\n                            transferButtonVisible = true\n                        )\n                    } else {\n                        Analytics.log(AnalyticsEvent.walletsEmptyStateViewed(onrampEnabled = false))\n                        WalletsEmptyState(\n                            title = R.string.wallet_no_coins_found_title,\n                            subtitle = R.string.wallet_no_coins_found_subtitle,\n                            transferButtonVisible = true\n                        )\n                    }\n            }\n        }");
        this.updateEmptyStateViewObservable = map2;
    }

    public static /* synthetic */ o a(NetworkSetting networkSetting, Network network) {
        return m1550isScanningObservable$lambda8$lambda7(networkSetting, network);
    }

    public static /* synthetic */ List b(CurrencyFormatter currencyFormatter, t tVar) {
        return m1554walletsObservable$lambda5(currencyFormatter, tVar);
    }

    public static /* synthetic */ x d(List list) {
        return m1549isScanningObservable$lambda12(list);
    }

    public static /* synthetic */ List e(List list, List list2, List list3) {
        return m1553usersWalletsObservable$lambda3$lambda2(list, list2, list3);
    }

    public static /* synthetic */ WalletsEmptyState f(t tVar) {
        return m1551updateEmptyStateViewObservable$lambda13(tVar);
    }

    /* renamed from: isScanningObservable$lambda-12 */
    public static final x m1549isScanningObservable$lambda12(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        s combineLatest = s.combineLatest(it, new h.c.m0.n<Object[], R>() { // from class: com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel$isScanningObservable$lambda-12$$inlined$combineLatest$1
            @Override // h.c.m0.n
            public final R apply(Object[] it2) {
                List c2;
                int r;
                kotlin.jvm.internal.m.h(it2, "it");
                c2 = kotlin.a0.m.c(it2);
                r = kotlin.a0.s.r(c2, 10);
                ArrayList arrayList = new ArrayList(r);
                for (T t : c2) {
                    if (t == null) {
                        throw new TypeCastException("null cannot be cast to non-null type T");
                    }
                    arrayList.add(t);
                }
                return (R) Boolean.valueOf(arrayList.contains(Boolean.FALSE));
            }
        });
        kotlin.jvm.internal.m.d(combineLatest, "Observable.combineLatest…List().map { it as T }) }");
        return combineLatest;
    }

    /* renamed from: isScanningObservable$lambda-8$lambda-7 */
    public static final o m1550isScanningObservable$lambda8$lambda7(NetworkSetting networkSetting, Network it) {
        kotlin.jvm.internal.m.g(networkSetting, "$networkSetting");
        kotlin.jvm.internal.m.g(it, "it");
        return u.a(networkSetting.getBlockchain(), it);
    }

    /* renamed from: updateEmptyStateViewObservable$lambda-13 */
    public static final WalletsEmptyState m1551updateEmptyStateViewObservable$lambda13(t dstr$wallets$isScanning$connectStatus) {
        kotlin.jvm.internal.m.g(dstr$wallets$isScanning$connectStatus, "$dstr$wallets$isScanning$connectStatus");
        boolean booleanValue = ((Boolean) dstr$wallets$isScanning$connectStatus.b()).booleanValue();
        ConsumerConnectionStatus consumerConnectionStatus = (ConsumerConnectionStatus) dstr$wallets$isScanning$connectStatus.c();
        if (!((List) dstr$wallets$isScanning$connectStatus.a()).isEmpty()) {
            return new WalletsEmptyState(R.string.empty, R.string.empty, false);
        }
        if (booleanValue) {
            return new WalletsEmptyState(R.string.wallet_empty_scanning_title, R.string.wallet_empty_scanning_subtitle, false);
        }
        if (consumerConnectionStatus.getOnrampEnabled()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.walletsEmptyStateViewed(AnalyticsEvent.Companion, true));
            return new WalletsEmptyState(R.string.wallet_no_coins_found_title, R.string.wallet_no_coins_found_subtitle_onramp, true);
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.walletsEmptyStateViewed(AnalyticsEvent.Companion, false));
        return new WalletsEmptyState(R.string.wallet_no_coins_found_title, R.string.wallet_no_coins_found_subtitle, true);
    }

    /* renamed from: usersWalletsObservable$lambda-3 */
    public static final h0 m1552usersWalletsObservable$lambda3(TxHistoryRepository txHistoryRepository, o dstr$wallets$_u24__u24) {
        final List p0;
        kotlin.jvm.internal.m.g(txHistoryRepository, "$txHistoryRepository");
        kotlin.jvm.internal.m.g(dstr$wallets$_u24__u24, "$dstr$wallets$_u24__u24");
        List list = (List) dstr$wallets$_u24__u24.a();
        final List<Wallet> arrayList = new ArrayList<>();
        for (Object obj : list) {
            if (kotlin.jvm.internal.m.c(((Wallet) obj).getBalance(), BigInteger.ZERO)) {
                arrayList.add(obj);
            }
        }
        p0 = z.p0(list, arrayList);
        return txHistoryRepository.filterWalletsWithTx(arrayList).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.m
            @Override // h.c.m0.n
            public final Object apply(Object obj2) {
                return WalletsTabViewModel.e(p0, arrayList, (List) obj2);
            }
        });
    }

    /* renamed from: usersWalletsObservable$lambda-3$lambda-2 */
    public static final List m1553usersWalletsObservable$lambda3$lambda2(List walletsWithBalance, List zeroBalanceWallets, List walletsWithTx) {
        Set M0;
        List t0;
        kotlin.jvm.internal.m.g(walletsWithBalance, "$walletsWithBalance");
        kotlin.jvm.internal.m.g(zeroBalanceWallets, "$zeroBalanceWallets");
        kotlin.jvm.internal.m.g(walletsWithTx, "walletsWithTx");
        M0 = z.M0(walletsWithTx);
        ArrayList arrayList = new ArrayList();
        for (Object obj : zeroBalanceWallets) {
            if (M0.contains((Wallet) obj)) {
                arrayList.add(obj);
            }
        }
        t0 = z.t0(walletsWithBalance, arrayList);
        return t0;
    }

    /* renamed from: walletsObservable$lambda-5 */
    public static final List m1554walletsObservable$lambda5(CurrencyFormatter currencyFormatter, t dstr$wallets$_u24__u24$_u24__u24) {
        int r;
        String formatToFiat;
        kotlin.jvm.internal.m.g(currencyFormatter, "$currencyFormatter");
        kotlin.jvm.internal.m.g(dstr$wallets$_u24__u24$_u24__u24, "$dstr$wallets$_u24__u24$_u24__u24");
        List<Wallet> wallets = (List) dstr$wallets$_u24__u24$_u24__u24.a();
        kotlin.jvm.internal.m.f(wallets, "wallets");
        r = kotlin.a0.s.r(wallets, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Wallet wallet : wallets) {
            CurrencyCode currencyCode = wallet.getCurrencyCode();
            String contractAddress = wallet.getContractAddress();
            int decimals = wallet.getDecimals();
            BigInteger balance = wallet.getBalance();
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
            formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress, decimals, balance, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
            arrayList.add(new ListItem.WalletListItem(wallet, formatToFiat, CurrencyFormatter.formatToCrypto$default(currencyFormatter, wallet.getCurrencyCode(), wallet.getDecimals(), wallet.getBalance(), false, 0, 0, 48, (Object) null)));
        }
        return arrayList;
    }

    public final h.c.b0<Boolean> backupIfNeeded(Bundle args, kotlin.e0.c.a<kotlin.x> onPromptDismiss) {
        kotlin.jvm.internal.m.g(args, "args");
        kotlin.jvm.internal.m.g(onPromptDismiss, "onPromptDismiss");
        return CloudBackupPrompt.backupIfNeeded$default(this.cloudBackupPrompt, args, onPromptDismiss, null, 4, null);
    }

    public final s<WalletsEmptyState> getUpdateEmptyStateViewObservable() {
        return this.updateEmptyStateViewObservable;
    }

    public final s<List<ListItem.WalletListItem>> getWalletsObservable() {
        return this.walletsObservable;
    }

    public final s<Boolean> isScanningObservable() {
        return this.isScanningObservable;
    }
}