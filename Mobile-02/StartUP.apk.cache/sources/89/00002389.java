package com.coinbase.wallet.features.wallets.views;

import com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletsTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsTabFragment$setupAdapter$1 extends o implements kotlin.e0.c.a<x> {
    final /* synthetic */ WalletsTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletsTabFragment$setupAdapter$1(WalletsTabFragment walletsTabFragment) {
        super(0);
        this.this$0 = walletsTabFragment;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ActionItemsViewModel actionItemsViewModel;
        actionItemsViewModel = this.this$0.actionItemsViewModel;
        if (actionItemsViewModel != null) {
            actionItemsViewModel.onLendItemClick();
        } else {
            m.w("actionItemsViewModel");
            throw null;
        }
    }
}