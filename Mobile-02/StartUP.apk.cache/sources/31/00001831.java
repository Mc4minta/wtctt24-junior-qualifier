package com.coinbase.wallet.consumer.views;

import android.content.DialogInterface;
import android.os.Bundle;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import kotlin.Metadata;

/* compiled from: ConsumerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "dialog", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerFragment$settingsBottomSheet$addPaymentMethodOption$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
    final /* synthetic */ ConsumerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerFragment$settingsBottomSheet$addPaymentMethodOption$1(ConsumerFragment consumerFragment) {
        super(1);
        this.this$0 = consumerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface dialog) {
        kotlin.jvm.internal.m.g(dialog, "dialog");
        dialog.dismiss();
        Bundle create = ForwardArgs.INSTANCE.create(R.id.consumerFragment);
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAccountSettingsPaymentMethodFlowTapped(AnalyticsEvent.Companion));
        Fragment_CommonKt.navigate$default(this.this$0, R.id.action_consumerFragment_to_consumerAvailablePaymentMethodsFragment, create, null, null, 12, null);
    }
}