package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.lending.models.LendToken;
import java.util.List;
import kotlin.Metadata;

/* compiled from: LendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072z\u0010\u0006\u001av\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*:\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/t;", "", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "kotlin.jvm.PlatformType", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lcom/coinbase/wallet/lending/models/LendToken;", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/t;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendConfirmationViewModel$fetchReceiptInformation$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.t<? extends List<? extends EthereumUnsigned1559Tx>, ? extends Wallet, ? extends LendToken>, kotlin.x> {
    final /* synthetic */ LendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendConfirmationViewModel$fetchReceiptInformation$3(LendConfirmationViewModel lendConfirmationViewModel) {
        super(1);
        this.this$0 = lendConfirmationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.t<? extends List<? extends EthereumUnsigned1559Tx>, ? extends Wallet, ? extends LendToken> tVar) {
        invoke2((kotlin.t<? extends List<EthereumUnsigned1559Tx>, Wallet, LendToken>) tVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.t<? extends List<EthereumUnsigned1559Tx>, Wallet, LendToken> tVar) {
        TransferValue amount;
        List<EthereumUnsigned1559Tx> unSignedTxs = tVar.a();
        Wallet feeWallet = tVar.b();
        LendToken token = tVar.c();
        LendConfirmationViewModel lendConfirmationViewModel = this.this$0;
        kotlin.jvm.internal.m.f(unSignedTxs, "unSignedTxs");
        lendConfirmationViewModel.lendingTxs = unSignedTxs;
        this.this$0.updateMinerFeeExplainer();
        LendConfirmationViewModel lendConfirmationViewModel2 = this.this$0;
        kotlin.jvm.internal.m.f(token, "token");
        kotlin.jvm.internal.m.f(feeWallet, "feeWallet");
        amount = this.this$0.getAmount();
        lendConfirmationViewModel2.handleUnsignedLendTxs(unSignedTxs, token, feeWallet, amount);
    }
}