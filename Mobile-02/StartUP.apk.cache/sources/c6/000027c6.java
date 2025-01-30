package com.coinbase.wallet.txhistory.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.wallet.core.util.Optional;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.t;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxHistoryItemViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062>\u0010\u0005\u001a:\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u001c\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/t;", "", "Lcom/coinbase/wallet/core/util/Optional;", "", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/t;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryItemViewHolder$bind$2 extends o implements l<t<? extends String, ? extends Optional<? extends String>, ? extends Integer>, x> {
    final /* synthetic */ TxHistoryItemViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryItemViewHolder$bind$2(TxHistoryItemViewHolder txHistoryItemViewHolder) {
        super(1);
        this.this$0 = txHistoryItemViewHolder;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(t<? extends String, ? extends Optional<? extends String>, ? extends Integer> tVar) {
        invoke2((t<String, Optional<String>, Integer>) tVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(t<String, Optional<String>, Integer> tVar) {
        TextView fiatAmount;
        TextView cryptoAmount;
        TextView fiatAmount2;
        View view;
        int intValue = tVar.c().intValue();
        fiatAmount = this.this$0.getFiatAmount();
        fiatAmount.setText(tVar.a());
        cryptoAmount = this.this$0.getCryptoAmount();
        cryptoAmount.setText(tVar.b().toNullable());
        fiatAmount2 = this.this$0.getFiatAmount();
        view = this.this$0.view;
        fiatAmount2.setTextColor(androidx.core.content.a.d(view.getContext(), intValue));
    }
}