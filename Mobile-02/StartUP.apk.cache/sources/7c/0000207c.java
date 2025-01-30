package com.coinbase.wallet.features.send.views;

import kotlin.Metadata;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lc/s/b;", "<anonymous>", "()Lc/s/b;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountPickerFragment$autoTransition$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<c.s.b> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$autoTransition$2(AmountPickerFragment amountPickerFragment) {
        super(0);
        this.this$0 = amountPickerFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final c.s.b invoke() {
        long shortAnimDuration;
        c.s.b bVar = new c.s.b();
        shortAnimDuration = this.this$0.getShortAnimDuration();
        bVar.setDuration(shortAnimDuration);
        return bVar;
    }
}