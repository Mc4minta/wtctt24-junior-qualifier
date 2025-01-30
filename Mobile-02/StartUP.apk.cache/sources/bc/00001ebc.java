package com.coinbase.wallet.features.lend.views;

import android.view.View;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.lend.models.LendCoinPickerState;
import com.coinbase.wallet.features.lend.views.adapters.LendCoinPickerAdapter;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendCoinPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerFragment$setupObservers$1 extends o implements l<LendCoinPickerState, x> {
    final /* synthetic */ LendCoinPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendCoinPickerFragment$setupObservers$1(LendCoinPickerFragment lendCoinPickerFragment) {
        super(1);
        this.this$0 = lendCoinPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(LendCoinPickerState lendCoinPickerState) {
        invoke2(lendCoinPickerState);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(LendCoinPickerState lendCoinPickerState) {
        LendCoinPickerAdapter lendCoinPickerAdapter;
        lendCoinPickerAdapter = this.this$0.coinPickerAdapter;
        if (lendCoinPickerAdapter != null) {
            lendCoinPickerAdapter.submitList(lendCoinPickerState.getItems());
            View view = this.this$0.getView();
            View chooseCoinRecyclerView = view == null ? null : view.findViewById(e.j.a.chooseCoinRecyclerView);
            m.f(chooseCoinRecyclerView, "chooseCoinRecyclerView");
            chooseCoinRecyclerView.setVisibility(lendCoinPickerState.isLoading() ^ true ? 0 : 8);
            View view2 = this.this$0.getView();
            View progress = view2 != null ? view2.findViewById(e.j.a.c5) : null;
            m.f(progress, "progress");
            progress.setVisibility(lendCoinPickerState.isLoading() ? 0 : 8);
            return;
        }
        m.w("coinPickerAdapter");
        throw null;
    }
}