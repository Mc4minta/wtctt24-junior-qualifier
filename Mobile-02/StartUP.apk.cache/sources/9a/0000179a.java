package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.appreview.repositories.AppReviewRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferInitiatedViewModel_Factory implements f.c.d<ConsumerTransferInitiatedViewModel> {
    private final Provider<AppReviewRepository> appReviewRepositoryProvider;

    public ConsumerTransferInitiatedViewModel_Factory(Provider<AppReviewRepository> provider) {
        this.appReviewRepositoryProvider = provider;
    }

    public static ConsumerTransferInitiatedViewModel_Factory create(Provider<AppReviewRepository> provider) {
        return new ConsumerTransferInitiatedViewModel_Factory(provider);
    }

    public static ConsumerTransferInitiatedViewModel newInstance(AppReviewRepository appReviewRepository) {
        return new ConsumerTransferInitiatedViewModel(appReviewRepository);
    }

    @Override // javax.inject.Provider
    public ConsumerTransferInitiatedViewModel get() {
        return newInstance(this.appReviewRepositoryProvider.get());
    }
}