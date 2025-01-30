package com.coinbase.wallet.txhistory.interfaces;

import com.coinbase.wallet.blockchains.models.Transaction;
import h.c.b0;
import h.c.m0.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: TxHistorySyncing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "txs", "Lh/c/b0;", "", "<anonymous>", "(Ljava/util/List;)Lh/c/b0;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistorySyncing$fetchCompletionCondition$2 extends o implements l<List<? extends Transaction>, b0<Boolean>> {
    final /* synthetic */ TxHistorySyncing this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistorySyncing$fetchCompletionCondition$2(TxHistorySyncing txHistorySyncing) {
        super(1);
        this.this$0 = txHistorySyncing;
    }

    public static /* synthetic */ Boolean a(List list) {
        return m1753invoke$lambda1$lambda0(list);
    }

    /* renamed from: invoke$lambda-1$lambda-0 */
    public static final Boolean m1753invoke$lambda1$lambda0(List it) {
        m.g(it, "it");
        return Boolean.valueOf(!it.isEmpty());
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ b0<Boolean> invoke(List<? extends Transaction> list) {
        return invoke2((List<Transaction>) list);
    }

    /* renamed from: invoke */
    public final b0<Boolean> invoke2(List<Transaction> txs) {
        String txHash;
        m.g(txs, "txs");
        try {
            Transaction transaction = (Transaction) p.l0(txs);
            b0<Boolean> b0Var = null;
            if (transaction != null && (txHash = transaction.getTxHash()) != null) {
                b0Var = this.this$0.getDao().getTxsByHash(txHash).map(new n() { // from class: com.coinbase.wallet.txhistory.interfaces.g
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return TxHistorySyncing$fetchCompletionCondition$2.a((List) obj);
                    }
                });
            }
            if (b0Var == null) {
                b0<Boolean> just = b0.just(Boolean.TRUE);
                m.f(just, "just(true)");
                return just;
            }
            return b0Var;
        } catch (Exception unused) {
            b0<Boolean> just2 = b0.just(Boolean.TRUE);
            m.f(just2, "{\n                    Single.just(true)\n                }");
            return just2;
        }
    }
}