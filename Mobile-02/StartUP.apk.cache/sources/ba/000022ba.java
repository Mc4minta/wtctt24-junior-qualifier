package com.coinbase.wallet.features.swap.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerViewState;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapAssetPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAssetPickerFragment$onViewCreated$5 extends o implements l<SwapAssetPickerViewState, x> {
    final /* synthetic */ SwapAssetPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerFragment$onViewCreated$5(SwapAssetPickerFragment swapAssetPickerFragment) {
        super(1);
        this.this$0 = swapAssetPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SwapAssetPickerViewState swapAssetPickerViewState) {
        invoke2(swapAssetPickerViewState);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapAssetPickerViewState swapAssetPickerViewState) {
        View view = this.this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.K6))).setText(swapAssetPickerViewState.getTitle());
        View view2 = this.this$0.getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.emptyStateTitle))).setText(swapAssetPickerViewState.getEmptyStateTitle());
        View view3 = this.this$0.getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.emptyStateDescription))).setText(swapAssetPickerViewState.getEmptyStateDescription());
        View view4 = this.this$0.getView();
        View progress = view4 == null ? null : view4.findViewById(e.j.a.c5);
        m.f(progress, "progress");
        progress.setVisibility(swapAssetPickerViewState.isLoading() ? 0 : 8);
        View view5 = this.this$0.getView();
        View currenciesRecyclerView = view5 != null ? view5.findViewById(e.j.a.currenciesRecyclerView) : null;
        m.f(currenciesRecyclerView, "currenciesRecyclerView");
        currenciesRecyclerView.setVisibility(swapAssetPickerViewState.isLoading() ^ true ? 0 : 8);
    }
}