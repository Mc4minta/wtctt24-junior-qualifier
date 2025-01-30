package com.coinbase.wallet.txhistory.interfaces;

import com.coinbase.wallet.blockchains.models.Transaction;
import h.c.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxHistorySyncing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "it", "Lh/c/b0;", "", "kotlin.jvm.PlatformType", "<anonymous>", "(Ljava/util/List;)Lh/c/b0;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistorySyncing$fetchCompletionCondition$1 extends o implements l<List<? extends Transaction>, b0<Boolean>> {
    final /* synthetic */ TxHistorySyncing this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistorySyncing$fetchCompletionCondition$1(TxHistorySyncing txHistorySyncing) {
        super(1);
        this.this$0 = txHistorySyncing;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final b0<Boolean> invoke2(List<Transaction> it) {
        m.g(it, "it");
        b0<Boolean> just = b0.just(Boolean.valueOf(it.size() < this.this$0.getPerPage()));
        m.f(just, "just(it.count() < perPage)");
        return just;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ b0<Boolean> invoke(List<? extends Transaction> list) {
        return invoke2((List<Transaction>) list);
    }
}