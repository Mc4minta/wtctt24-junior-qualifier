package com.coinbase.wallet.txhistory.views;

import android.view.View;
import com.coinbase.wallet.txhistory.R;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxHistoryItemViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/RecipientImageView;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lcom/coinbase/wallet/txhistory/views/RecipientImageView;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryItemViewHolder$iconView$2 extends o implements kotlin.e0.c.a<RecipientImageView> {
    final /* synthetic */ TxHistoryItemViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryItemViewHolder$iconView$2(TxHistoryItemViewHolder txHistoryItemViewHolder) {
        super(0);
        this.this$0 = txHistoryItemViewHolder;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final RecipientImageView invoke() {
        View view;
        view = this.this$0.view;
        return (RecipientImageView) view.findViewById(R.id.image);
    }
}