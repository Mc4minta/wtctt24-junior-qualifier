package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerTransferMethodsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "kotlin.jvm.PlatformType", "availableTransfers", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferMethodsViewModel$setup$1$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends AvailableTransfer>, kotlin.x> {
    final /* synthetic */ ConsumerTransferMethodsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferMethodsViewModel$setup$1$2(ConsumerTransferMethodsViewModel consumerTransferMethodsViewModel) {
        super(1);
        this.this$0 = consumerTransferMethodsViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends AvailableTransfer> list) {
        invoke2(list);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends AvailableTransfer> availableTransfers) {
        TransferMoneyRequest transferMoneyRequest;
        TransferMoneyRequest copy;
        ConsumerTransferMethodsViewModel consumerTransferMethodsViewModel = this.this$0;
        transferMoneyRequest = consumerTransferMethodsViewModel.transferRequest;
        if (transferMoneyRequest != null) {
            kotlin.jvm.internal.m.f(availableTransfers, "availableTransfers");
            copy = transferMoneyRequest.copy((r22 & 1) != 0 ? transferMoneyRequest.account : null, (r22 & 2) != 0 ? transferMoneyRequest.maxAtomicDecimals : 0, (r22 & 4) != 0 ? transferMoneyRequest.originalRequestAmount : null, (r22 & 8) != 0 ? transferMoneyRequest.availableTransfers : availableTransfers, (r22 & 16) != 0 ? transferMoneyRequest.fiatExchangeRate : null, (r22 & 32) != 0 ? transferMoneyRequest.fiatCurrency : null, (r22 & 64) != 0 ? transferMoneyRequest.isFiatPrimary : false, (r22 & 128) != 0 ? transferMoneyRequest.supportsDestinationTag : false, (r22 & 256) != 0 ? transferMoneyRequest.wallet : null, (r22 & 512) != 0 ? transferMoneyRequest.onrampEnabled : false);
            consumerTransferMethodsViewModel.transferRequest = copy;
            ConsumerTransferMethodsViewModel consumerTransferMethodsViewModel2 = this.this$0;
            consumerTransferMethodsViewModel2.setState(ConsumerTransferMethodsViewModel.generateState$default(consumerTransferMethodsViewModel2, availableTransfers, false, null, 6, null));
            return;
        }
        kotlin.jvm.internal.m.w("transferRequest");
        throw null;
    }
}