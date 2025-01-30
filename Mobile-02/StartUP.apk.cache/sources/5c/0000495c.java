package e.j.e;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import f.c.h;
import h.c.b0;
import javax.inject.Provider;
import kotlin.e0.c.q;

/* compiled from: TxHistoryModule_ProvidesGetTxStateFactory.java */
/* loaded from: classes2.dex */
public final class c implements f.c.d<q<Blockchain, Network, String, b0<TxState>>> {
    private final Provider<ITxRepository> a;

    public c(Provider<ITxRepository> provider) {
        this.a = provider;
    }

    public static c a(Provider<ITxRepository> provider) {
        return new c(provider);
    }

    public static q<Blockchain, Network, String, b0<TxState>> c(ITxRepository iTxRepository) {
        return (q) h.f(b.a(iTxRepository));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public q<Blockchain, Network, String, b0<TxState>> get() {
        return c(this.a.get());
    }
}