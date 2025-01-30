package com.coinbase.wallet.consumer.viewmodels;

import android.content.DialogInterface;
import kotlin.Metadata;

/* compiled from: ConsumerTransferMethodsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerTransferMethodsViewModel$infoClicked$action$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
    public static final ConsumerTransferMethodsViewModel$infoClicked$action$1 INSTANCE = new ConsumerTransferMethodsViewModel$infoClicked$action$1();

    ConsumerTransferMethodsViewModel$infoClicked$action$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface it) {
        kotlin.jvm.internal.m.g(it, "it");
        it.dismiss();
    }
}