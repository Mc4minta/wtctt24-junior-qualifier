package com.coinbase.wallet.consumer.viewmodels;

import kotlin.Metadata;

/* compiled from: ConsumerTransferConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "<anonymous>", "(Ljava/lang/Throwable;)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerTransferConfirmationViewModel$startSend$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, Boolean> {
    final /* synthetic */ boolean $triedBuying;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferConfirmationViewModel$startSend$3(boolean z) {
        super(1);
        this.$triedBuying = z;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke2(th));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return this.$triedBuying;
    }
}