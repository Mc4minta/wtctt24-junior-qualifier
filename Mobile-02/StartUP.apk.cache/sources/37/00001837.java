package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel;
import kotlin.Metadata;

/* compiled from: ConsumerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerFragment$supportedAccountClickListener$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAccount, kotlin.x> {
    final /* synthetic */ ConsumerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerFragment$supportedAccountClickListener$1(ConsumerFragment consumerFragment) {
        super(1);
        this.this$0 = consumerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAccount consumerAccount) {
        invoke2(consumerAccount);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerAccount it) {
        ConsumerAccountsViewModel accountsViewModel;
        kotlin.jvm.internal.m.g(it, "it");
        accountsViewModel = this.this$0.getAccountsViewModel();
        accountsViewModel.accountClicked(it);
    }
}