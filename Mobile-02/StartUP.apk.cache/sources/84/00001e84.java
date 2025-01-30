package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: LendAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isBackingUp", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendAmountPickerViewModel$nextAction$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, x> {
    final /* synthetic */ ViewModelNavRoute $navRoute;
    final /* synthetic */ LendAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendAmountPickerViewModel$nextAction$3(LendAmountPickerViewModel lendAmountPickerViewModel, ViewModelNavRoute viewModelNavRoute) {
        super(1);
        this.this$0 = lendAmountPickerViewModel;
        this.$navRoute = viewModelNavRoute;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return x.a;
    }

    public final void invoke(boolean z) {
        h.c.v0.b bVar;
        if (z) {
            return;
        }
        bVar = this.this$0.navigateSubject;
        bVar.onNext(this.$navRoute);
    }
}