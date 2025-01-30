package com.coinbase.wallet.features.wallets.views;

import android.view.View;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel;
import com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel;
import com.uber.autodispose.a0;
import h.c.b0;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletsTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsTabFragment$setupClickListeners$1 extends o implements l<View, x> {
    final /* synthetic */ WalletsTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletsTabFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupClickListeners$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements kotlin.e0.c.a<x> {
        final /* synthetic */ a0<ActionSheetDialogHelper.Properties> $actionSheetSingle;
        final /* synthetic */ WalletsTabFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WalletsTabFragment.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;", "kotlin.jvm.PlatformType", "properties", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupClickListeners$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C01041 extends o implements l<ActionSheetDialogHelper.Properties, x> {
            final /* synthetic */ WalletsTabFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01041(WalletsTabFragment walletsTabFragment) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(a0<ActionSheetDialogHelper.Properties> a0Var, WalletsTabFragment walletsTabFragment) {
            super(0);
            this.$actionSheetSingle = a0Var;
            this.this$0 = walletsTabFragment;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ x invoke() {
            invoke2();
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            a0<ActionSheetDialogHelper.Properties> actionSheetSingle = this.$actionSheetSingle;
            m.f(actionSheetSingle, "actionSheetSingle");
            SingleSubscribeProxy_CommonKt.subscribeBy$default(actionSheetSingle, null, new C01041(this.this$0), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletsTabFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isBackingUp", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupClickListeners$1$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends o implements l<Boolean, x> {
        final /* synthetic */ a0<ActionSheetDialogHelper.Properties> $actionSheetSingle;
        final /* synthetic */ WalletsTabFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WalletsTabFragment.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;", "kotlin.jvm.PlatformType", "properties", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupClickListeners$1$2$1  reason: invalid class name */
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(a0<ActionSheetDialogHelper.Properties> a0Var, WalletsTabFragment walletsTabFragment) {
            super(1);
            this.$actionSheetSingle = a0Var;
            this.this$0 = walletsTabFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
            invoke2(bool);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (bool.booleanValue()) {
                return;
            }
            a0<ActionSheetDialogHelper.Properties> actionSheetSingle = this.$actionSheetSingle;
            m.f(actionSheetSingle, "actionSheetSingle");
            SingleSubscribeProxy_CommonKt.subscribeBy$default(actionSheetSingle, null, new AnonymousClass1(this.this$0), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletsTabFragment$setupClickListeners$1(WalletsTabFragment walletsTabFragment) {
        super(1);
        this.this$0 = walletsTabFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        ActionItemsViewModel actionItemsViewModel;
        h.c.a0 mainScheduler;
        FragmentLifecycleScopeProvider scopeProvider;
        WalletsTabViewModel walletsTabViewModel;
        FragmentLifecycleScopeProvider scopeProvider2;
        m.g(it, "it");
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.transferCoinsCTASelected(AnalyticsEvent.Companion));
        actionItemsViewModel = this.this$0.actionItemsViewModel;
        if (actionItemsViewModel != null) {
            b0<ActionSheetDialogHelper.Properties> fundActionSheetProperties = actionItemsViewModel.getFundActionSheetProperties(true);
            mainScheduler = this.this$0.getMainScheduler();
            b0<ActionSheetDialogHelper.Properties> observeOn = fundActionSheetProperties.observeOn(mainScheduler);
            scopeProvider = this.this$0.getScopeProvider();
            a0 a0Var = (a0) observeOn.as(com.uber.autodispose.d.a(scopeProvider));
            walletsTabViewModel = this.this$0.walletsTabViewModel;
            if (walletsTabViewModel != null) {
                b0<Boolean> observeOn2 = walletsTabViewModel.backupIfNeeded(ForwardArgs.INSTANCE.create(R.id.walletFragment), new AnonymousClass1(a0Var, this.this$0)).observeOn(h.c.j0.c.a.b());
                scopeProvider2 = this.this$0.getScopeProvider();
                Object as = observeOn2.as(com.uber.autodispose.d.a(scopeProvider2));
                m.f(as, "private fun setupClickListeners() = getCoinsButton.setOnSingleClickListener {\n        Analytics.log(AnalyticsEvent.transferCoinsCTASelected())\n        val actionSheetSingle = actionItemsViewModel\n            .getFundActionSheetProperties(isWalletsEmpty = true)\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))\n\n        walletsTabViewModel.backupIfNeeded(\n            args = ForwardArgs.create(R.id.walletFragment),\n            onPromptDismiss = {\n                actionSheetSingle\n                    .subscribeBy { properties ->\n                        ActionSheetDialogHelper.show(this, properties)\n                    }\n            }\n        )\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))\n            .subscribeBy { isBackingUp ->\n                if (!isBackingUp) {\n                    actionSheetSingle\n                        .subscribeBy { properties ->\n                            ActionSheetDialogHelper.show(this, properties)\n                        }\n                }\n            }\n    }");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, new AnonymousClass2(a0Var, this.this$0), 1, null);
                return;
            }
            m.w("walletsTabViewModel");
            throw null;
        }
        m.w("actionItemsViewModel");
        throw null;
    }
}