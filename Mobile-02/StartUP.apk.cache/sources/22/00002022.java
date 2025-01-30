package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeSelection;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u000622\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationViewModel$fetchReceiptInformation$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends UnsignedTxResult, ? extends Optional<? extends Wallet>>, kotlin.x> {
    final /* synthetic */ AdjustableMinerFeeSelection $adjustableMinerFeeSelection;
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$fetchReceiptInformation$4(SendConfirmationViewModel sendConfirmationViewModel, AdjustableMinerFeeSelection adjustableMinerFeeSelection) {
        super(1);
        this.this$0 = sendConfirmationViewModel;
        this.$adjustableMinerFeeSelection = adjustableMinerFeeSelection;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends UnsignedTxResult, ? extends Optional<? extends Wallet>> oVar) {
        invoke2((kotlin.o<? extends UnsignedTxResult, Optional<Wallet>>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends UnsignedTxResult, Optional<Wallet>> oVar) {
        h.c.v0.b bVar;
        UnsignedTxResult txResult = oVar.a();
        UnsignedTx transaction = txResult.getTransaction();
        Wallet value = oVar.b().getValue();
        if (transaction != null && value != null) {
            this.this$0.tx = transaction;
            boolean z = this.$adjustableMinerFeeSelection != null;
            SendConfirmationViewModel sendConfirmationViewModel = this.this$0;
            kotlin.jvm.internal.m.f(txResult, "txResult");
            sendConfirmationViewModel.handleUnsignedTx(txResult, value, z);
            this.this$0.updateMinerFeeExplainer();
            return;
        }
        SendConfirmationState.FeeCalculationFailed feeCalculationFailed = new SendConfirmationState.FeeCalculationFailed(LocalizedStrings.INSTANCE.get(R.string.send_confirm_calculation_error));
        bVar = this.this$0.sendConfirmationSubject;
        bVar.onNext(new SendConfirmationResult(feeCalculationFailed, null, null, null, null, null, null, 126, null));
    }
}