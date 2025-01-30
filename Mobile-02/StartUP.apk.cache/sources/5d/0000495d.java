package e.j.e;

import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import f.c.h;
import h.c.s;
import javax.inject.Provider;

/* compiled from: TxHistoryModule_ProvidesTxUpdatesObservableFactory.java */
/* loaded from: classes2.dex */
public final class d implements f.c.d<s<TxUpdate>> {
    private final Provider<ITxRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ConsumerTransferRepository> f13581b;

    public d(Provider<ITxRepository> provider, Provider<ConsumerTransferRepository> provider2) {
        this.a = provider;
        this.f13581b = provider2;
    }

    public static d a(Provider<ITxRepository> provider, Provider<ConsumerTransferRepository> provider2) {
        return new d(provider, provider2);
    }

    public static s<TxUpdate> c(ITxRepository iTxRepository, ConsumerTransferRepository consumerTransferRepository) {
        return (s) h.f(b.b(iTxRepository, consumerTransferRepository));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public s<TxUpdate> get() {
        return c(this.a.get(), this.f13581b.get());
    }
}