package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042F\u0010\u0003\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/o;", "", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerFragment$setupObservables$10 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends String, ? extends String>, kotlin.x> {
    final /* synthetic */ SendDestinationPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerFragment$setupObservables$10(SendDestinationPickerFragment sendDestinationPickerFragment) {
        super(1);
        this.this$0 = sendDestinationPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends String, ? extends String> oVar) {
        invoke2((kotlin.o<String, String>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<String, String> oVar) {
        SendDestinationPickerViewModel sendDestinationPickerViewModel;
        sendDestinationPickerViewModel = this.this$0.viewModel;
        if (sendDestinationPickerViewModel != null) {
            sendDestinationPickerViewModel.search(oVar.c(), oVar.d());
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }
}