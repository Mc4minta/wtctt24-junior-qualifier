package com.coinbase.wallet.features.swap.views;

import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: FragmentViewModelLazy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/b0;", "VM", "Landroidx/lifecycle/f0;", "invoke", "()Landroidx/lifecycle/f0;", "com/coinbase/wallet/commonui/extensions/Fragment_CommonKt$viewModel$$inlined$viewModels$default$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerFragment$special$$inlined$viewModel$3 extends o implements kotlin.e0.c.a<f0> {
    final /* synthetic */ kotlin.e0.c.a $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerFragment$special$$inlined$viewModel$3(kotlin.e0.c.a aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final f0 invoke() {
        f0 viewModelStore = ((g0) this.$ownerProducer.invoke()).getViewModelStore();
        m.d(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}