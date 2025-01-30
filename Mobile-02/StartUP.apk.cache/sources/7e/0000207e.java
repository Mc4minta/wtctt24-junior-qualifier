package com.coinbase.wallet.features.send.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.FlowableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.send.models.AmountPickerTitle;
import com.coinbase.wallet.features.send.models.SendCoinPickerArgs;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountPickerFragment$onAttachFragment$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
    final /* synthetic */ kotlin.e0.c.l<Wallet, kotlin.x> $setupWallet;
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmountPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.send.views.AmountPickerFragment$onAttachFragment$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Wallet, kotlin.x> {
        final /* synthetic */ kotlin.e0.c.l<Wallet, kotlin.x> $setupWallet;
        final /* synthetic */ AmountPickerFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AmountPickerFragment.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/send/models/AmountPickerTitle;", "kotlin.jvm.PlatformType", "titleOptional", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.send.views.AmountPickerFragment$onAttachFragment$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C01021 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends AmountPickerTitle>, kotlin.x> {
            final /* synthetic */ AmountPickerFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01021(AmountPickerFragment amountPickerFragment) {
                super(1);
                this.this$0 = amountPickerFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(Optional<? extends AmountPickerTitle> optional) {
                invoke2((Optional<AmountPickerTitle>) optional);
                return kotlin.x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Optional<AmountPickerTitle> optional) {
                AmountPickerTitle value = optional.getValue();
                if (value == null) {
                    return;
                }
                AmountPickerFragment amountPickerFragment = this.this$0;
                View view = amountPickerFragment.getView();
                ((TextView) (view == null ? null : view.findViewById(e.j.a.sendHeader))).setText(value.getTitle());
                View view2 = amountPickerFragment.getView();
                ((TextView) (view2 != null ? view2.findViewById(e.j.a.sendSubHeader) : null)).setText(value.getSubtitle());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(kotlin.e0.c.l<? super Wallet, kotlin.x> lVar, AmountPickerFragment amountPickerFragment) {
            super(1);
            this.$setupWallet = lVar;
            this.this$0 = amountPickerFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Wallet wallet) {
            invoke2(wallet);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Wallet it) {
            AmountPickerViewModel amountPickerViewModel;
            kotlin.e0.c.l<Wallet, kotlin.x> lVar = this.$setupWallet;
            kotlin.jvm.internal.m.f(it, "it");
            lVar.invoke(it);
            amountPickerViewModel = this.this$0.viewModel;
            if (amountPickerViewModel != null) {
                h.c.b0<Optional<AmountPickerTitle>> observeOn = amountPickerViewModel.generateTitle().observeOn(h.c.j0.c.a.b());
                kotlin.jvm.internal.m.f(observeOn, "viewModel.generateTitle()\n                                        .observeOn(AndroidSchedulers.mainThread())");
                h.c.t0.g.i(observeOn, null, new C01021(this.this$0), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmountPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.send.views.AmountPickerFragment$onAttachFragment$1$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Wallet, kotlin.x> {
        final /* synthetic */ AmountPickerFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AmountPickerFragment amountPickerFragment) {
            super(1);
            this.this$0 = amountPickerFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Wallet wallet) {
            invoke2(wallet);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Wallet it) {
            AmountPickerFragment amountPickerFragment = this.this$0;
            kotlin.jvm.internal.m.f(it, "it");
            amountPickerFragment.handleCoinPicked(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AmountPickerFragment$onAttachFragment$1(AmountPickerFragment amountPickerFragment, kotlin.e0.c.l<? super Wallet, kotlin.x> lVar) {
        super(1);
        this.this$0 = amountPickerFragment;
        this.$setupWallet = lVar;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
        invoke2(xVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.x xVar) {
        AmountFragment amountFragment;
        AmountPickerViewModel amountPickerViewModel;
        AmountPickerViewModel amountPickerViewModel2;
        AmountPickerViewModel amountPickerViewModel3;
        FragmentLifecycleScopeProvider onDestroyScopeProvider;
        FragmentLifecycleScopeProvider onDestroyScopeProvider2;
        amountFragment = this.this$0.amountFragment;
        if (amountFragment == null) {
            kotlin.jvm.internal.m.w("amountFragment");
            throw null;
        }
        amountPickerViewModel = this.this$0.viewModel;
        if (amountPickerViewModel != null) {
            amountFragment.setStyles(amountPickerViewModel.getSettings());
            amountPickerViewModel2 = this.this$0.viewModel;
            if (amountPickerViewModel2 != null) {
                if (amountPickerViewModel2.getSettings().isLend()) {
                    View view = this.this$0.getView();
                    View sendHeader = view == null ? null : view.findViewById(e.j.a.sendHeader);
                    kotlin.jvm.internal.m.f(sendHeader, "sendHeader");
                    sendHeader.setVisibility(0);
                    View view2 = this.this$0.getView();
                    View sendSubHeader = view2 == null ? null : view2.findViewById(e.j.a.sendSubHeader);
                    kotlin.jvm.internal.m.f(sendSubHeader, "sendSubHeader");
                    sendSubHeader.setVisibility(0);
                }
                amountPickerViewModel3 = this.this$0.viewModel;
                if (amountPickerViewModel3 != null) {
                    h.c.b0<Wallet> observeOn = amountPickerViewModel3.loadWallet().observeOn(h.c.j0.c.a.b());
                    onDestroyScopeProvider = this.this$0.getOnDestroyScopeProvider();
                    Object as = observeOn.as(com.uber.autodispose.d.a(onDestroyScopeProvider));
                    kotlin.jvm.internal.m.f(as, "viewModel.loadWallet()\n                            .observeOn(AndroidSchedulers.mainThread())\n                            .`as`(autoDisposable(onDestroyScopeProvider))");
                    SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new AnonymousClass1(this.$setupWallet, this.this$0), 1, null);
                    h.c.h observeOn2 = Fragment_CommonKt.getNavigationResult(this.this$0, SendCoinPickerArgs.INSTANCE.getPICKED_WALLET_RESULT()).observeOn(h.c.j0.c.a.b());
                    onDestroyScopeProvider2 = this.this$0.getOnDestroyScopeProvider();
                    Object as2 = observeOn2.as(com.uber.autodispose.d.a(onDestroyScopeProvider2));
                    kotlin.jvm.internal.m.f(as2, "getNavigationResult<Wallet>(SendCoinPickerArgs.PICKED_WALLET_RESULT)\n                            .observeOn(AndroidSchedulers.mainThread())\n                            .`as`(autoDisposable(onDestroyScopeProvider))");
                    FlowableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.u) as2, null, null, new AnonymousClass2(this.this$0), 3, null);
                    return;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}