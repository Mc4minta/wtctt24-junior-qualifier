package com.coinbase.wallet.di;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.Map_CommonKt;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.http.connectivity.Internet;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import e.j.i.w1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: RefreshablesModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/di/RefreshablesModule;", "", "Le/j/i/w1;", "refreshable", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "providesCollectiblesRefreshable", "(Le/j/i/w1;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "providesExchangeRateRepository", "(Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "providesUserRefreshable", "(Lcom/coinbase/wallet/user/repositories/UserRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "providesWalletRepositoryRefreshable", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "providesTxResumbmitter", "(Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "providesTxHistoryRepositoryRefreshable", "(Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "providesLendRepositoryRefreshable", "(Lcom/coinbase/wallet/lending/interfaces/ILendRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "providesConsumerTransferRepositoryRefreshable", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "providesFeatureFlagsRefreshable", "(Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;)Lcom/coinbase/wallet/core/interfaces/Refreshable;", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class RefreshablesModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: RefreshablesModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/di/RefreshablesModule$Companion;", "", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "providesInternetRefreshable", "()Lcom/coinbase/wallet/core/interfaces/Refreshable;", "", "", "refreshableMap", "", "providesRefreshableList", "(Ljava/util/Map;)Ljava/util/List;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ApplicationScoped
        public final Refreshable providesInternetRefreshable() {
            return Internet.INSTANCE;
        }

        @ApplicationScoped
        public final List<Refreshable> providesRefreshableList(Map<Integer, Refreshable> refreshableMap) {
            m.g(refreshableMap, "refreshableMap");
            return Map_CommonKt.mapToSortedList(refreshableMap);
        }
    }

    @ApplicationScoped
    public static final Refreshable providesInternetRefreshable() {
        return Companion.providesInternetRefreshable();
    }

    @ApplicationScoped
    public static final List<Refreshable> providesRefreshableList(Map<Integer, Refreshable> map) {
        return Companion.providesRefreshableList(map);
    }

    @ApplicationScoped
    public abstract Refreshable providesCollectiblesRefreshable(w1 w1Var);

    @ApplicationScoped
    public abstract Refreshable providesConsumerTransferRepositoryRefreshable(ConsumerTransferRepository consumerTransferRepository);

    @ApplicationScoped
    public abstract Refreshable providesExchangeRateRepository(IExchangeRateRepository iExchangeRateRepository);

    @ApplicationScoped
    public abstract Refreshable providesFeatureFlagsRefreshable(FeatureFlagsRepository featureFlagsRepository);

    @ApplicationScoped
    public abstract Refreshable providesLendRepositoryRefreshable(ILendRepository iLendRepository);

    @ApplicationScoped
    public abstract Refreshable providesTxHistoryRepositoryRefreshable(TxHistoryRepository txHistoryRepository);

    @ApplicationScoped
    public abstract Refreshable providesTxResumbmitter(ITxRepository iTxRepository);

    @ApplicationScoped
    public abstract Refreshable providesUserRefreshable(UserRepository userRepository);

    @ApplicationScoped
    public abstract Refreshable providesWalletRepositoryRefreshable(IWalletRepository iWalletRepository);
}