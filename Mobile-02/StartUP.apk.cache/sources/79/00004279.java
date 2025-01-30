package com.toshi.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: FundActionSheetFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/toshi/view/fragment/FundActionSheetFragment;", "Lcom/google/android/material/bottomsheet/b;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "<init>", "()V", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FundActionSheetFragment extends com.google.android.material.bottomsheet.b {
    public static final a a = new a(null);

    /* compiled from: FundActionSheetFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FundActionSheetFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
        b() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            FundActionSheetFragment.this.dismissAllowingStateLoss();
            FundActionSheetFragment fundActionSheetFragment = FundActionSheetFragment.this;
            Fragment_CommonKt.navigate$default(fundActionSheetFragment, R.id.swapAmountPickerFragment, null, Fragment_CommonKt.getVerticalNavOptions(fundActionSheetFragment), null, 10, null);
        }
    }

    /* compiled from: FundActionSheetFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ConsumerConnectionStatus f11274b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ConsumerConnectionStatus consumerConnectionStatus) {
            super(1);
            this.f11274b = consumerConnectionStatus;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            FundActionSheetFragment.this.dismissAllowingStateLoss();
            Fragment_CommonKt.navigate$default(FundActionSheetFragment.this, R.id.consumer_nav_graph, ConsumerInterstitialArgs.createArguments$default(ConsumerInterstitialArgs.INSTANCE, false, this.f11274b, null, false, 12, null), Fragment_CommonKt.getVerticalNavOptions(FundActionSheetFragment.this), null, 8, null);
        }
    }

    /* compiled from: FundActionSheetFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, kotlin.x> {
        d() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            FundActionSheetFragment.this.dismissAllowingStateLoss();
            FundActionSheetFragment fundActionSheetFragment = FundActionSheetFragment.this;
            Fragment_CommonKt.navigate$default(fundActionSheetFragment, R.id.receiveCoinPickerFragment, null, Fragment_CommonKt.getVerticalNavOptions(fundActionSheetFragment), null, 10, null);
        }
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.appcompat.app.i, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        List m;
        Bundle requireArguments = requireArguments();
        kotlin.jvm.internal.m.f(requireArguments, "requireArguments()");
        String string = requireArguments.getString("dialogTitleKey");
        if (string == null) {
            string = LocalizedStrings.INSTANCE.get(R.string.fund_sheet_dialog_title);
        }
        String str2 = string;
        kotlin.jvm.internal.m.f(str2, "args.getString(FundActionSheetArgs.dialogTitleKey)\n            ?: LocalizedStrings[R.string.fund_sheet_dialog_title]");
        boolean z = requireArguments.getBoolean("showCryptoActionKey");
        ConsumerConnectionStatus consumerConnectionStatus = (ConsumerConnectionStatus) Bundle_CommonKt.requireParcelable(requireArguments, "connectionStatusKey");
        if (consumerConnectionStatus.getOnrampEnabled()) {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase_onramp);
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase);
        }
        ActionStyle actionStyle = ActionStyle.NEUTRAL;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        m = kotlin.a0.r.m(new ActionSheetDialogHelper.Action(str, actionStyle, new c(consumerConnectionStatus)), new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.fund_action_transfer_from_elsewhere), actionStyle, new d()));
        if (z) {
            m.add(new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.fund_action_convert_crypto), actionStyle, new b()));
        }
        ActionSheetDialogHelper.Properties properties = new ActionSheetDialogHelper.Properties(str2, m, false, null, null, 28, null);
        ActionSheetDialogHelper actionSheetDialogHelper = ActionSheetDialogHelper.INSTANCE;
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.f(requireContext, "requireContext()");
        return actionSheetDialogHelper.create(requireContext, properties);
    }
}