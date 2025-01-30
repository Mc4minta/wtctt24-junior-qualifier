package com.coinbase.wallet.features.lend.viewmodels;

import android.content.DialogInterface;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendCoinPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "dialog", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerViewModel$fundActions$actions$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
    final /* synthetic */ ConsumerConnectionStatus $consumerConnectionStatus;
    final /* synthetic */ Wallet $wallet;
    final /* synthetic */ LendCoinPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendCoinPickerViewModel$fundActions$actions$1(Wallet wallet, ConsumerConnectionStatus consumerConnectionStatus, LendCoinPickerViewModel lendCoinPickerViewModel) {
        super(1);
        this.$wallet = wallet;
        this.$consumerConnectionStatus = consumerConnectionStatus;
        this.this$0 = lendCoinPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface dialog) {
        h.c.v0.b bVar;
        kotlin.jvm.internal.m.g(dialog, "dialog");
        dialog.dismiss();
        Wallet wallet = this.$wallet;
        ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.consumer_nav_graph, ConsumerInterstitialArgs.createArguments$default(ConsumerInterstitialArgs.INSTANCE, false, this.$consumerConnectionStatus, wallet == null ? null : wallet.getCurrencyCode(), false, 8, null), null, 4, null);
        bVar = this.this$0.navigationSubject;
        bVar.onNext(viewModelNavRoute);
    }
}