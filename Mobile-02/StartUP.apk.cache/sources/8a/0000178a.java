package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerSettingViewModel_Factory implements f.c.d<ConsumerSettingViewModel> {
    private final Provider<ConsumerAccountsRepository> consumerAccountsRepositoryProvider;
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public ConsumerSettingViewModel_Factory(Provider<ConsumerUserRepository> provider, Provider<ConsumerTransferRepository> provider2, Provider<ConsumerAccountsRepository> provider3, Provider<IWalletRepository> provider4) {
        this.consumerUserRepositoryProvider = provider;
        this.consumerTransferRepositoryProvider = provider2;
        this.consumerAccountsRepositoryProvider = provider3;
        this.walletRepositoryProvider = provider4;
    }

    public static ConsumerSettingViewModel_Factory create(Provider<ConsumerUserRepository> provider, Provider<ConsumerTransferRepository> provider2, Provider<ConsumerAccountsRepository> provider3, Provider<IWalletRepository> provider4) {
        return new ConsumerSettingViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static ConsumerSettingViewModel newInstance(ConsumerUserRepository consumerUserRepository, ConsumerTransferRepository consumerTransferRepository, ConsumerAccountsRepository consumerAccountsRepository, IWalletRepository iWalletRepository) {
        return new ConsumerSettingViewModel(consumerUserRepository, consumerTransferRepository, consumerAccountsRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public ConsumerSettingViewModel get() {
        return newInstance(this.consumerUserRepositoryProvider.get(), this.consumerTransferRepositoryProvider.get(), this.consumerAccountsRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}