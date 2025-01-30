package com.coinbase.wallet.features.send.viewmodels;

import android.content.Context;
import com.coinbase.wallet.features.send.repositories.RecipientRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SendDestinationPickerViewModel_Factory implements f.c.d<SendDestinationPickerViewModel> {
    private final Provider<Context> contextProvider;
    private final Provider<RecipientRepository> recipientRepositoryProvider;
    private final Provider<ITxRepository> txRepositoryProvider;

    public SendDestinationPickerViewModel_Factory(Provider<ITxRepository> provider, Provider<RecipientRepository> provider2, Provider<Context> provider3) {
        this.txRepositoryProvider = provider;
        this.recipientRepositoryProvider = provider2;
        this.contextProvider = provider3;
    }

    public static SendDestinationPickerViewModel_Factory create(Provider<ITxRepository> provider, Provider<RecipientRepository> provider2, Provider<Context> provider3) {
        return new SendDestinationPickerViewModel_Factory(provider, provider2, provider3);
    }

    public static SendDestinationPickerViewModel newInstance(ITxRepository iTxRepository, RecipientRepository recipientRepository, Context context) {
        return new SendDestinationPickerViewModel(iTxRepository, recipientRepository, context);
    }

    @Override // javax.inject.Provider
    public SendDestinationPickerViewModel get() {
        return newInstance(this.txRepositoryProvider.get(), this.recipientRepositoryProvider.get(), this.contextProvider.get());
    }
}