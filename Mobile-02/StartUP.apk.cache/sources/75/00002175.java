package com.coinbase.wallet.features.signer.viewmodel;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class TxSignerViewModel$presentMinerFee$properties$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
    public static final TxSignerViewModel$presentMinerFee$properties$1 INSTANCE = new TxSignerViewModel$presentMinerFee$properties$1();

    TxSignerViewModel$presentMinerFee$properties$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface it) {
        kotlin.jvm.internal.m.g(it, "it");
        it.dismiss();
    }
}