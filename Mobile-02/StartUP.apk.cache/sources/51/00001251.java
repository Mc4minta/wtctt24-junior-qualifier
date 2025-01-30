package com.coinbase.wallet.application.view;

import android.os.Bundle;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HomeFragment$initObservables$11 extends o implements l<x, x> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$initObservables$11(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x xVar) {
        HomeFragment homeFragment = this.this$0;
        Bundle bundle = new Bundle();
        bundle.putSerializable(AmountPickerViewModel.class.getName(), SendAmountPickerViewModel.class);
        x xVar2 = x.a;
        Fragment_CommonKt.navigate$default(homeFragment, R.id.action_walletFragment_to_sendAmountPickerFragment, bundle, Fragment_CommonKt.getVerticalNavOptions(this.this$0), null, 8, null);
    }
}