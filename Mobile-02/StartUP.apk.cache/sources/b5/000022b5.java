package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.models.SwapAssetPickerItem;
import com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel;
import com.coinbase.wallet.features.swap.views.adapters.SwapAssetPickerAdapter;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapAssetPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter;", "<anonymous>", "()Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAssetPickerFragment$assetPickerAdapter$2 extends o implements kotlin.e0.c.a<SwapAssetPickerAdapter> {
    final /* synthetic */ SwapAssetPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwapAssetPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.swap.views.SwapAssetPickerFragment$assetPickerAdapter$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<SwapAssetPickerItem.SwapAssetItem, x> {
        final /* synthetic */ SwapAssetPickerFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SwapAssetPickerFragment swapAssetPickerFragment) {
            super(1);
            this.this$0 = swapAssetPickerFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(SwapAssetPickerItem.SwapAssetItem swapAssetItem) {
            invoke2(swapAssetItem);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(SwapAssetPickerItem.SwapAssetItem it) {
            SwapAssetPickerViewModel viewModel;
            m.g(it, "it");
            viewModel = this.this$0.getViewModel();
            viewModel.onAssetSelected(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerFragment$assetPickerAdapter$2(SwapAssetPickerFragment swapAssetPickerFragment) {
        super(0);
        this.this$0 = swapAssetPickerFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final SwapAssetPickerAdapter invoke() {
        return new SwapAssetPickerAdapter(new AnonymousClass1(this.this$0));
    }
}