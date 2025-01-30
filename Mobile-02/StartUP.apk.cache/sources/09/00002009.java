package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import com.coinbase.wallet.ethereum.models.ContractAction;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ContractAction;", "<anonymous>", "()Lcom/coinbase/wallet/ethereum/models/ContractAction;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendConfirmationViewModel$contractAction$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ContractAction> {
    final /* synthetic */ LendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendConfirmationViewModel$contractAction$2(LendConfirmationViewModel lendConfirmationViewModel) {
        super(0);
        this.this$0 = lendConfirmationViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ContractAction invoke() {
        return (ContractAction) Bundle_CommonKt.requireParcelable(this.this$0.getArgs(), "contractAction");
    }
}