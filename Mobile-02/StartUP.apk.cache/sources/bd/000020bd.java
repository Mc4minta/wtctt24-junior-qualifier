package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062v\u0010\u0005\u001ar\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0003*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00010\u0001 \u0003*8\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0003*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/o;", "", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "kotlin.jvm.PlatformType", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerFragment$setupQrScanner$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends List<? extends QRCodeScanResult>, ? extends List<? extends Wallet>>, kotlin.x> {
    final /* synthetic */ boolean $isMetadata;
    final /* synthetic */ SendDestinationPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerFragment$setupQrScanner$3(SendDestinationPickerFragment sendDestinationPickerFragment, boolean z) {
        super(1);
        this.this$0 = sendDestinationPickerFragment;
        this.$isMetadata = z;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends List<? extends QRCodeScanResult>, ? extends List<? extends Wallet>> oVar) {
        invoke2((kotlin.o<? extends List<? extends QRCodeScanResult>, ? extends List<Wallet>>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends List<? extends QRCodeScanResult>, ? extends List<Wallet>> oVar) {
        SendDestinationPickerViewModel sendDestinationPickerViewModel;
        List<? extends QRCodeScanResult> results = oVar.a();
        List<Wallet> wallets = oVar.b();
        sendDestinationPickerViewModel = this.this$0.viewModel;
        if (sendDestinationPickerViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.f(results, "results");
        kotlin.jvm.internal.m.f(wallets, "wallets");
        sendDestinationPickerViewModel.finishQrScan(results, wallets, this.$isMetadata);
    }
}