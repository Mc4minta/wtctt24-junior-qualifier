package com.coinbase.wallet.features.signer.views;

import android.view.View;
import android.widget.ImageButton;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: TxSignerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/x;", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class TxSignerFragment$showDetails$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<x, x> {
    final /* synthetic */ TxSignerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerFragment$showDetails$1(TxSignerFragment txSignerFragment) {
        super(1);
        this.this$0 = txSignerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x it) {
        kotlin.jvm.internal.m.g(it, "it");
        View view = this.this$0.getView();
        ((ImageButton) (view == null ? null : view.findViewById(e.j.a.F1))).setEnabled(true);
    }
}