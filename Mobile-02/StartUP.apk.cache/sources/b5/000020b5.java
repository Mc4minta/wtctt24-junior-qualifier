package com.coinbase.wallet.features.send.views;

import android.os.Bundle;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendConfirmationViewModel;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "args", "Lkotlin/x;", "<anonymous>", "(Landroid/os/Bundle;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendDestinationPickerFragment$setupObservables$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Bundle, kotlin.x> {
    final /* synthetic */ SendDestinationPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerFragment$setupObservables$3(SendDestinationPickerFragment sendDestinationPickerFragment) {
        super(1);
        this.this$0 = sendDestinationPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Bundle bundle) {
        invoke2(bundle);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Bundle bundle) {
        bundle.putSerializable(ConfirmationViewModel.class.getName(), SendConfirmationViewModel.class);
        Fragment_CommonKt.navigate$default(this.this$0, R.id.action_destinationPickerFragment_to_confirmationFragment, bundle, Fragment_CommonKt.getFadeInNavOptions(this.this$0), null, 8, null);
    }
}