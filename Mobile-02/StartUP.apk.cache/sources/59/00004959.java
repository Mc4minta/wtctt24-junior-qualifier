package e.j.e;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import e.j.e.b;
import h.c.b0;
import h.c.m0.n;
import h.c.s;
import java.util.List;
import kotlin.e0.c.q;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: TxHistoryModule.kt */
/* loaded from: classes2.dex */
public abstract class b {
    public static final a a = new a(null);

    /* compiled from: TxHistoryModule.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: TxHistoryModule.kt */
        /* renamed from: e.j.e.b$a$a */
        /* loaded from: classes2.dex */
        public static final class C0319a extends o implements q<Blockchain, Network, String, b0<TxState>> {
            final /* synthetic */ ITxRepository a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0319a(ITxRepository iTxRepository) {
                super(3);
                this.a = iTxRepository;
            }

            @Override // kotlin.e0.c.q
            /* renamed from: a */
            public final b0<TxState> invoke(Blockchain blockchain, Network network, String txHash) {
                m.g(blockchain, "blockchain");
                m.g(network, "network");
                m.g(txHash, "txHash");
                return this.a.getTxState(blockchain, network, txHash);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TxUpdate.Submitted a(Transaction transaction) {
            return d(transaction);
        }

        public static final TxUpdate.Submitted d(Transaction it) {
            m.g(it, "it");
            return new TxUpdate.Submitted(it);
        }

        public final q<Blockchain, Network, String, b0<TxState>> b(ITxRepository txRepository) {
            m.g(txRepository, "txRepository");
            return new C0319a(txRepository);
        }

        public final s<TxUpdate> c(ITxRepository txRepository, ConsumerTransferRepository consumerTransferRepository) {
            m.g(txRepository, "txRepository");
            m.g(consumerTransferRepository, "consumerTransferRepository");
            s<TxUpdate> merge = s.merge(txRepository.getTxUpdatesObservable(), consumerTransferRepository.getSubmittedTxObservable().map(new n() { // from class: e.j.e.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return b.a.a((Transaction) obj);
                }
            }));
            m.f(merge, "merge(\n                txRepository.txUpdatesObservable,\n                consumerTxUpdateObservable\n            )");
            return merge;
        }

        public final s<List<Wallet>> e(IWalletRepository walletRepository) {
            m.g(walletRepository, "walletRepository");
            return walletRepository.observeWallets(false);
        }
    }

    public static final q<Blockchain, Network, String, b0<TxState>> a(ITxRepository iTxRepository) {
        return a.b(iTxRepository);
    }

    public static final s<TxUpdate> b(ITxRepository iTxRepository, ConsumerTransferRepository consumerTransferRepository) {
        return a.c(iTxRepository, consumerTransferRepository);
    }

    public static final s<List<Wallet>> c(IWalletRepository iWalletRepository) {
        return a.e(iWalletRepository);
    }
}