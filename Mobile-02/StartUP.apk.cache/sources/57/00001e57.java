package com.coinbase.wallet.features.lend.interfaces;

import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching;
import com.coinbase.wallet.lending.extensions.TxMetadataKey_LendKt;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import h.c.b0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: LendBalanceFetching.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/lend/interfaces/LendBalanceFetching;", "", "Lh/c/b0;", "", "isBalanceAvailable", "()Lh/c/b0;", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "getLendRepository", "()Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "getTxHistoryRepository", "()Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface LendBalanceFetching {

    /* compiled from: LendBalanceFetching.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Boolean a(o oVar) {
            return m1269isBalanceAvailable$lambda3(oVar);
        }

        public static /* synthetic */ boolean b(List list) {
            return m1268isBalanceAvailable$lambda0(list);
        }

        public static b0<Boolean> isBalanceAvailable(LendBalanceFetching lendBalanceFetching) {
            m.g(lendBalanceFetching, "this");
            h.c.t0.e eVar = h.c.t0.e.a;
            s<List<LendToken>> filter = lendBalanceFetching.getLendRepository().observeTokens().filter(new p() { // from class: com.coinbase.wallet.features.lend.interfaces.b
                @Override // h.c.m0.p
                public final boolean test(Object obj) {
                    return LendBalanceFetching.DefaultImpls.b((List) obj);
                }
            });
            m.f(filter, "lendRepository.observeTokens().filter { it.isNotEmpty() }");
            b0<Boolean> map = eVar.a(Observable_CoreKt.takeSingle(filter), lendBalanceFetching.getTxHistoryRepository().getPendingTxs()).map(new n() { // from class: com.coinbase.wallet.features.lend.interfaces.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return LendBalanceFetching.DefaultImpls.a((o) obj);
                }
            });
            m.f(map, "Singles\n            .zip(\n                lendRepository.observeTokens().filter { it.isNotEmpty() }.takeSingle(),\n                txHistoryRepository.getPendingTxs()\n            )\n            .map { (tokens, pendingTxs) ->\n                val balances = tokens.any { it.supplyBalance > BigInteger.ZERO }\n                val pendingTxs = pendingTxs.any { it.metadata[TxMetadataKey.lendTokenID] != null }\n\n                balances || pendingTxs\n            }");
            return map;
        }

        /* renamed from: isBalanceAvailable$lambda-0 */
        public static boolean m1268isBalanceAvailable$lambda0(List it) {
            m.g(it, "it");
            return !it.isEmpty();
        }

        /* renamed from: isBalanceAvailable$lambda-3 */
        public static Boolean m1269isBalanceAvailable$lambda3(o dstr$tokens$pendingTxs) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            m.g(dstr$tokens$pendingTxs, "$dstr$tokens$pendingTxs");
            List<LendToken> tokens = (List) dstr$tokens$pendingTxs.a();
            List<Transaction> pendingTxs = (List) dstr$tokens$pendingTxs.b();
            m.f(tokens, "tokens");
            boolean z5 = true;
            if (!(tokens instanceof Collection) || !tokens.isEmpty()) {
                for (LendToken lendToken : tokens) {
                    if (lendToken.getSupplyBalance().compareTo(BigInteger.ZERO) > 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            m.f(pendingTxs, "pendingTxs");
            if (!(pendingTxs instanceof Collection) || !pendingTxs.isEmpty()) {
                for (Transaction transaction : pendingTxs) {
                    if (transaction.getMetadata().get(TxMetadataKey_LendKt.getLendTokenID(TxMetadataKey.Companion)) != null) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        z4 = true;
                        break;
                    }
                }
            }
            z4 = false;
            if (!z2 && !z4) {
                z5 = false;
            }
            return Boolean.valueOf(z5);
        }
    }

    ILendRepository getLendRepository();

    TxHistoryRepository getTxHistoryRepository();

    b0<Boolean> isBalanceAvailable();
}