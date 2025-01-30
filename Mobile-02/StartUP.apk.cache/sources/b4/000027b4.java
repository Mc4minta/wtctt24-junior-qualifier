package com.coinbase.wallet.txhistory.views;

import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import com.coinbase.wallet.txhistory.views.TxHistoryDetailFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: TxHistoryDetailFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;", "<anonymous>", "()Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class TxHistoryDetailFragment$txHistoryDetailArgs$2 extends o implements kotlin.e0.c.a<TxHistoryDetailFragment.Args> {
    final /* synthetic */ TxHistoryDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryDetailFragment$txHistoryDetailArgs$2(TxHistoryDetailFragment txHistoryDetailFragment) {
        super(0);
        this.this$0 = txHistoryDetailFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final TxHistoryDetailFragment.Args invoke() {
        return (TxHistoryDetailFragment.Args) Bundle_CommonKt.requireParcelable(this.this$0.getArguments(), "txHistoryDetails");
    }
}