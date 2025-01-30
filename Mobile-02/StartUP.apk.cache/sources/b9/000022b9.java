package com.coinbase.wallet.features.swap.views;

import android.view.View;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerItem;
import com.coinbase.wallet.features.swap.views.adapters.SwapAssetPickerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapAssetPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;", "kotlin.jvm.PlatformType", "assets", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAssetPickerFragment$onViewCreated$4 extends o implements l<List<? extends SwapAssetPickerItem>, x> {
    final /* synthetic */ SwapAssetPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerFragment$onViewCreated$4(SwapAssetPickerFragment swapAssetPickerFragment) {
        super(1);
        this.this$0 = swapAssetPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(List<? extends SwapAssetPickerItem> list) {
        invoke2(list);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends SwapAssetPickerItem> list) {
        SwapAssetPickerAdapter assetPickerAdapter;
        assetPickerAdapter = this.this$0.getAssetPickerAdapter();
        assetPickerAdapter.submitList(list);
        View view = this.this$0.getView();
        View emptyResultView = view == null ? null : view.findViewById(e.j.a.emptyResultView);
        m.f(emptyResultView, "emptyResultView");
        emptyResultView.setVisibility(list.isEmpty() ? 0 : 8);
    }
}