package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.features.lend.models.LendProviderItem;
import com.coinbase.wallet.features.lend.models.LendProviderPickerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: LendProviderPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/features/lend/models/LendProviderItem;", "kotlin.jvm.PlatformType", "providers", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendProviderPickerViewModel$setup$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends LendProviderItem>, x> {
    final /* synthetic */ LendProviderPickerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LendProviderPickerViewModel$setup$2(LendProviderPickerViewModel lendProviderPickerViewModel) {
        super(1);
        this.this$0 = lendProviderPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(List<? extends LendProviderItem> list) {
        invoke2((List<LendProviderItem>) list);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<LendProviderItem> providers) {
        LendProviderPickerState copy$default;
        List b2;
        LendProviderPickerViewModel lendProviderPickerViewModel = this.this$0;
        if (providers.size() == 1) {
            LendProviderPickerState access$getState$p = LendProviderPickerViewModel.access$getState$p(this.this$0);
            kotlin.jvm.internal.m.f(providers, "providers");
            b2 = kotlin.a0.q.b(LendProviderItem.copy$default((LendProviderItem) kotlin.a0.p.Y(providers), null, null, false, true, 7, null));
            copy$default = LendProviderPickerState.copy$default(access$getState$p, b2, false, true, 2, null);
        } else {
            LendProviderPickerState access$getState$p2 = LendProviderPickerViewModel.access$getState$p(this.this$0);
            kotlin.jvm.internal.m.f(providers, "providers");
            copy$default = LendProviderPickerState.copy$default(access$getState$p2, providers, false, false, 6, null);
        }
        LendProviderPickerViewModel.access$setState(lendProviderPickerViewModel, copy$default);
    }
}