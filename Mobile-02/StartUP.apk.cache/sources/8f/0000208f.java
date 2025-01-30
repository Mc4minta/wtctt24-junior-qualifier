package com.coinbase.wallet.features.send.views;

import android.os.Bundle;
import android.view.View;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.features.send.models.SendCoinPickerArgs;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountPickerFragment$setupOnClickListeners$6 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupOnClickListeners$6(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        kotlin.jvm.internal.m.g(it, "it");
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendCoinAmountCoinPickerSelected(AnalyticsEvent.Companion));
        AmountPickerFragment amountPickerFragment = this.this$0;
        Bundle createArguments$default = SendCoinPickerArgs.createArguments$default(SendCoinPickerArgs.INSTANCE, null, null, null, 7, null);
        createArguments$default.putAll(ForwardArgs.INSTANCE.create(R.id.amountPickerFragment));
        kotlin.x xVar = kotlin.x.a;
        Fragment_CommonKt.navigate$default(amountPickerFragment, R.id.action_sendAmountPickerFragment_to_sendCoinPickerFragment, createArguments$default, Fragment_CommonKt.getVerticalNavOptions(this.this$0), null, 8, null);
    }
}