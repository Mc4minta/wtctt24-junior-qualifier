package com.coinbase.wallet.application.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isSwapEnabled", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HomeFragment$initObservables$17 extends o implements l<Boolean, x> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$initObservables$17(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke2(bool);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean isSwapEnabled) {
        View view = this.this$0.getView();
        View walletSwapButton = view == null ? null : view.findViewById(e.j.a.walletSwapButton);
        m.f(walletSwapButton, "walletSwapButton");
        m.f(isSwapEnabled, "isSwapEnabled");
        walletSwapButton.setVisibility(isSwapEnabled.booleanValue() ? 0 : 8);
        View view2 = this.this$0.getView();
        View walletSwapButtonLeftDivider = view2 != null ? view2.findViewById(e.j.a.walletSwapButtonLeftDivider) : null;
        m.f(walletSwapButtonLeftDivider, "walletSwapButtonLeftDivider");
        walletSwapButtonLeftDivider.setVisibility(isSwapEnabled.booleanValue() ? 0 : 8);
    }
}