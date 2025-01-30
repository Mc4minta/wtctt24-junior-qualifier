package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import f.c.d;
import f.c.h;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TxManagingModule_ProvidesTxManagingListFactory implements d<List<TxManaging>> {
    private final Provider<Set<TxManaging>> txManagingsProvider;

    public TxManagingModule_ProvidesTxManagingListFactory(Provider<Set<TxManaging>> provider) {
        this.txManagingsProvider = provider;
    }

    public static TxManagingModule_ProvidesTxManagingListFactory create(Provider<Set<TxManaging>> provider) {
        return new TxManagingModule_ProvidesTxManagingListFactory(provider);
    }

    public static List<TxManaging> providesTxManagingList(Set<TxManaging> set) {
        return (List) h.f(TxManagingModule.providesTxManagingList(set));
    }

    @Override // javax.inject.Provider
    public List<TxManaging> get() {
        return providesTxManagingList(this.txManagingsProvider.get());
    }
}