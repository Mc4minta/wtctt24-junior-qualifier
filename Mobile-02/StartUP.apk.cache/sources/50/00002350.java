package com.coinbase.wallet.features.walletlink.views;

import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkSettingsViewModel;
import com.coinbase.walletlink.models.Session;
import com.uber.autodispose.a0;
import com.uber.autodispose.d;
import h.c.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: WalletLinkSettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter;", "<anonymous>", "()Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class WalletLinkSettingsFragment$adapter$2 extends o implements a<WalletLinkSettingsAdapter> {
    final /* synthetic */ WalletLinkSettingsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletLinkSettingsFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/coinbase/walletlink/models/Session;", "sessions", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsFragment$adapter$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<List<? extends Session>, x> {
        final /* synthetic */ WalletLinkSettingsFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WalletLinkSettingsFragment.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsFragment$adapter$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C01031 extends o implements l<Throwable, x> {
            final /* synthetic */ WalletLinkSettingsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01031(WalletLinkSettingsFragment walletLinkSettingsFragment) {
                super(1);
                this.this$0 = walletLinkSettingsFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(Throwable th) {
                invoke2(th);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                m.g(it, "it");
                this.this$0.hideActivityIndicator();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WalletLinkSettingsFragment.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsFragment$adapter$2$1$2  reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends o implements l<x, x> {
            final /* synthetic */ WalletLinkSettingsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(WalletLinkSettingsFragment walletLinkSettingsFragment) {
                super(1);
                this.this$0 = walletLinkSettingsFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(x xVar) {
                invoke2(xVar);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(x xVar) {
                this.this$0.hideActivityIndicator();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WalletLinkSettingsFragment walletLinkSettingsFragment) {
            super(1);
            this.this$0 = walletLinkSettingsFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(List<? extends Session> list) {
            invoke2((List<Session>) list);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<Session> list) {
            WalletLinkSettingsViewModel walletLinkSettingsViewModel;
            FragmentLifecycleScopeProvider scopeProvider;
            this.this$0.showActivityIndicator();
            walletLinkSettingsViewModel = this.this$0.viewModel;
            if (walletLinkSettingsViewModel != null) {
                b0<x> observeOn = walletLinkSettingsViewModel.disconnect(list).observeOn(h.c.j0.c.a.b());
                scopeProvider = this.this$0.getScopeProvider();
                Object as = observeOn.as(d.a(scopeProvider));
                m.f(as, "viewModel.disconnect(sessions)\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .`as`(autoDisposable(scopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy((a0) as, new C01031(this.this$0), new AnonymousClass2(this.this$0));
                return;
            }
            m.w("viewModel");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletLinkSettingsFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "properties", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsFragment$adapter$2$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends o implements l<PromptDialogHelper.Properties, x> {
        final /* synthetic */ WalletLinkSettingsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(WalletLinkSettingsFragment walletLinkSettingsFragment) {
            super(1);
            this.this$0 = walletLinkSettingsFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(PromptDialogHelper.Properties properties) {
            invoke2(properties);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(PromptDialogHelper.Properties properties) {
            m.g(properties, "properties");
            PromptDialogHelper.INSTANCE.show(this.this$0, properties);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkSettingsFragment$adapter$2(WalletLinkSettingsFragment walletLinkSettingsFragment) {
        super(0);
        this.this$0 = walletLinkSettingsFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final WalletLinkSettingsAdapter invoke() {
        return new WalletLinkSettingsAdapter(new AnonymousClass1(this.this$0), new AnonymousClass2(this.this$0));
    }
}