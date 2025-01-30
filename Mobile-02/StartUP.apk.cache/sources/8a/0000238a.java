package com.coinbase.wallet.features.wallets.views;

import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel;
import h.c.a0;
import h.c.b0;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletsTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsTabFragment$setupAdapter$2 extends o implements kotlin.e0.c.a<x> {
    final /* synthetic */ WalletsTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletsTabFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;", "kotlin.jvm.PlatformType", "properties", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupAdapter$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<ActionSheetDialogHelper.Properties, x> {
        final /* synthetic */ WalletsTabFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WalletsTabFragment walletsTabFragment) {
            super(1);
            this.this$0 = walletsTabFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(ActionSheetDialogHelper.Properties properties) {
            invoke2(properties);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ActionSheetDialogHelper.Properties properties) {
            ActionSheetDialogHelper actionSheetDialogHelper = ActionSheetDialogHelper.INSTANCE;
            WalletsTabFragment walletsTabFragment = this.this$0;
            m.f(properties, "properties");
            actionSheetDialogHelper.show(walletsTabFragment, properties);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletsTabFragment$setupAdapter$2(WalletsTabFragment walletsTabFragment) {
        super(0);
        this.this$0 = walletsTabFragment;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ActionItemsViewModel actionItemsViewModel;
        a0 mainScheduler;
        FragmentLifecycleScopeProvider scopeProvider;
        actionItemsViewModel = this.this$0.actionItemsViewModel;
        if (actionItemsViewModel != null) {
            b0<ActionSheetDialogHelper.Properties> fundActionSheetProperties = actionItemsViewModel.getFundActionSheetProperties(false);
            mainScheduler = this.this$0.getMainScheduler();
            b0<ActionSheetDialogHelper.Properties> observeOn = fundActionSheetProperties.observeOn(mainScheduler);
            scopeProvider = this.this$0.getScopeProvider();
            Object as = observeOn.as(com.uber.autodispose.d.a(scopeProvider));
            m.f(as, "actionItemsViewModel.getFundActionSheetProperties(isWalletsEmpty = false)\n                    .observeOn(mainScheduler)\n                    .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new AnonymousClass1(this.this$0), 1, null);
            return;
        }
        m.w("actionItemsViewModel");
        throw null;
    }
}