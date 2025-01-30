package com.toshi.view.fragment.coin;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.b0;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.appsflyer.share.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.CharSequence_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel;
import com.coinbase.wallet.routing.models.SendArgs;
import com.coinbase.wallet.txhistory.models.TxHistoryCellViewState;
import com.coinbase.wallet.txhistory.views.TxHistoryAdapter;
import com.coinbase.wallet.txhistory.views.TxHistoryDetailFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.toshi.view.fragment.h0;
import h.c.a0;
import h.c.s;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.u;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletDetailFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001MB\u0007¢\u0006\u0004\bL\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\nJ-\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\nJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00108\u001a\b\u0012\u0004\u0012\u000201008\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010;\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010&R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010DR\u0016\u0010K\u001a\u00020H8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/toshi/view/fragment/coin/WalletDetailFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;", "historyCellViewState", "Lkotlin/x;", "q", "(Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;)V", "initObservers", "()V", "initViewListeners", "Lcom/toshi/view/fragment/coin/q;", "walletUpdate", "s", "(Lcom/toshi/view/fragment/coin/q;)V", "p", "n", "r", "o", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "onBackPressed", "()Z", "Lh/c/a0;", "b", "Lh/c/a0;", "subscribeScheduler", "Lcom/toshi/view/fragment/h0;", "g", "Lcom/toshi/view/fragment/h0;", "m", "()Lcom/toshi/view/fragment/h0;", "setDisplayCoinAddressFragmentFactory$app_productionRelease", "(Lcom/toshi/view/fragment/h0;)V", "displayCoinAddressFragmentFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/toshi/view/fragment/coin/m;", "f", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "d", "Lcom/toshi/view/fragment/coin/m;", "viewModel", Constants.URL_CAMPAIGN, "mainScheduler", "Lcom/coinbase/wallet/txhistory/views/TxHistoryAdapter;", "e", "Lcom/coinbase/wallet/txhistory/views/TxHistoryAdapter;", "txHistoryAdapter", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "getScopeProvider", "scopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletDetailFragment extends LockedFragment implements StyledFragment, BackableFragment {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final a0 f11305b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f11306c;

    /* renamed from: d  reason: collision with root package name */
    private com.toshi.view.fragment.coin.m f11307d;

    /* renamed from: e  reason: collision with root package name */
    private TxHistoryAdapter f11308e;

    /* renamed from: f  reason: collision with root package name */
    public GenericViewModelFactory<com.toshi.view.fragment.coin.m> f11309f;

    /* renamed from: g  reason: collision with root package name */
    public h0 f11310g;

    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(Wallet wallet) {
            kotlin.jvm.internal.m.g(wallet, "wallet");
            Bundle bundle = new Bundle();
            bundle.putParcelable("wallet", wallet);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<q, x> {
        b() {
            super(1);
        }

        public final void a(q walletUpdate) {
            WalletDetailFragment walletDetailFragment = WalletDetailFragment.this;
            kotlin.jvm.internal.m.f(walletUpdate, "walletUpdate");
            walletDetailFragment.s(walletUpdate);
            com.toshi.view.fragment.coin.m mVar = WalletDetailFragment.this.f11307d;
            if (mVar != null) {
                mVar.setWallet(walletUpdate.c());
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(q qVar) {
            a(qVar);
            return x.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, x> {
        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
            invoke2(bool);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean it) {
            View view = WalletDetailFragment.this.getView();
            View findViewById = view == null ? null : view.findViewById(e.j.a.receiveBtn);
            kotlin.jvm.internal.m.f(it, "it");
            ((Button) findViewById).setEnabled(it.booleanValue());
            View view2 = WalletDetailFragment.this.getView();
            ((Button) (view2 != null ? view2.findViewById(e.j.a.receiveBtn) : null)).setAlpha(!it.booleanValue() ? 0.75f : 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends TxHistoryCellViewState>, x> {
        d() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(List<? extends TxHistoryCellViewState> list) {
            invoke2(list);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends TxHistoryCellViewState> list) {
            if (list.isEmpty()) {
                View view = WalletDetailFragment.this.getView();
                (view == null ? null : view.findViewById(e.j.a.emptyState)).setVisibility(0);
                View view2 = WalletDetailFragment.this.getView();
                ((RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.transactionHistory))).setVisibility(8);
                WalletDetailFragment.this.r();
            } else {
                View view3 = WalletDetailFragment.this.getView();
                (view3 == null ? null : view3.findViewById(e.j.a.emptyState)).setVisibility(8);
                View view4 = WalletDetailFragment.this.getView();
                ((RecyclerView) (view4 == null ? null : view4.findViewById(e.j.a.transactionHistory))).setVisibility(0);
            }
            TxHistoryAdapter txHistoryAdapter = WalletDetailFragment.this.f11308e;
            if (txHistoryAdapter != null) {
                txHistoryAdapter.submitList(list);
            } else {
                kotlin.jvm.internal.m.w("txHistoryAdapter");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<p, x> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WalletDetailFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
            final /* synthetic */ WalletDetailFragment a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(WalletDetailFragment walletDetailFragment) {
                super(1);
                this.a = walletDetailFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                this.a.o();
            }
        }

        /* compiled from: WalletDetailFragment.kt */
        /* loaded from: classes2.dex */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[p.values().length];
                iArr[p.SendOnly.ordinal()] = 1;
                iArr[p.Loading.ordinal()] = 2;
                iArr[p.All.ordinal()] = 3;
                a = iArr;
            }
        }

        e() {
            super(1);
        }

        public final void a(p pVar) {
            List<Button> j2;
            Button[] buttonArr = new Button[2];
            View view = WalletDetailFragment.this.getView();
            buttonArr[0] = (Button) (view == null ? null : view.findViewById(e.j.a.sendHistoryBtn));
            View view2 = WalletDetailFragment.this.getView();
            buttonArr[1] = (Button) (view2 != null ? view2.findViewById(e.j.a.emptySendHistoryBtn) : null);
            j2 = r.j(buttonArr);
            WalletDetailFragment walletDetailFragment = WalletDetailFragment.this;
            for (Button button : j2) {
                int i2 = pVar == null ? -1 : b.a[pVar.ordinal()];
                if (i2 == 1) {
                    kotlin.jvm.internal.m.f(button, "button");
                    View_CommonKt.setOnSingleClickListener$default(button, 0L, new a(walletDetailFragment), 1, null);
                    button.setVisibility(0);
                } else if (i2 == 2) {
                    button.setText(walletDetailFragment.getString(R.string.loading));
                    button.setVisibility(0);
                } else if (i2 == 3) {
                    button.setVisibility(8);
                }
            }
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(p pVar) {
            a(pVar);
            return x.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ViewModelNavRoute, x> {
        f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(ViewModelNavRoute viewModelNavRoute) {
            invoke2(viewModelNavRoute);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ViewModelNavRoute viewModelNavRoute) {
            Fragment_CommonKt.navigate$default(WalletDetailFragment.this, viewModelNavRoute.getResourceId(), viewModelNavRoute.getArgs(), viewModelNavRoute.getNavOptions(), null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<PromptDialogHelper.Properties, x> {
        g() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(PromptDialogHelper.Properties properties) {
            invoke2(properties);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(PromptDialogHelper.Properties it) {
            PromptDialogHelper promptDialogHelper = PromptDialogHelper.INSTANCE;
            WalletDetailFragment walletDetailFragment = WalletDetailFragment.this;
            kotlin.jvm.internal.m.f(it, "it");
            promptDialogHelper.show(walletDetailFragment, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        h() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(WalletDetailFragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        i() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            WalletDetailFragment.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        j() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            WalletDetailFragment.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WalletDetailFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ActionSheetDialogHelper.Properties, x> {
            final /* synthetic */ WalletDetailFragment a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(WalletDetailFragment walletDetailFragment) {
                super(1);
                this.a = walletDetailFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(ActionSheetDialogHelper.Properties properties) {
                invoke2(properties);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ActionSheetDialogHelper.Properties properties) {
                ActionSheetDialogHelper actionSheetDialogHelper = ActionSheetDialogHelper.INSTANCE;
                WalletDetailFragment walletDetailFragment = this.a;
                kotlin.jvm.internal.m.f(properties, "properties");
                actionSheetDialogHelper.show(walletDetailFragment, properties);
            }
        }

        k() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            com.toshi.view.fragment.coin.m mVar = WalletDetailFragment.this.f11307d;
            if (mVar != null) {
                Object as = mVar.F().as(com.uber.autodispose.d.a(WalletDetailFragment.this.getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.onMoreButtonClick()\n                .`as`(autoDisposable(scopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new a(WalletDetailFragment.this), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class l extends kotlin.jvm.internal.k implements kotlin.e0.c.l<TxHistoryCellViewState, x> {
        l(WalletDetailFragment walletDetailFragment) {
            super(1, walletDetailFragment, WalletDetailFragment.class, "transactionRowClicked", "transactionRowClicked(Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;)V", 0);
        }

        public final void a(TxHistoryCellViewState p0) {
            kotlin.jvm.internal.m.g(p0, "p0");
            ((WalletDetailFragment) this.receiver).q(p0);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(TxHistoryCellViewState txHistoryCellViewState) {
            a(txHistoryCellViewState);
            return x.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class m extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
        public static final m a = new m();

        m() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            it.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class n extends kotlin.jvm.internal.o implements kotlin.e0.c.l<TxHistoryDetailFragment.Args, x> {
        n() {
            super(1);
        }

        public final void a(TxHistoryDetailFragment.Args txHistoryDetail) {
            WalletDetailFragment walletDetailFragment = WalletDetailFragment.this;
            TxHistoryDetailFragment.Companion companion = TxHistoryDetailFragment.Companion;
            kotlin.jvm.internal.m.f(txHistoryDetail, "txHistoryDetail");
            Fragment_CommonKt.navigate$default(walletDetailFragment, R.id.action_coinDetailsFragment_to_txHistoryDetailFragment, companion.createArguments(txHistoryDetail), null, null, 12, null);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(TxHistoryDetailFragment.Args args) {
            a(args);
            return x.a;
        }
    }

    public WalletDetailFragment() {
        a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f11305b = c2;
        a0 b2 = h.c.j0.c.a.b();
        kotlin.jvm.internal.m.f(b2, "mainThread()");
        this.f11306c = b2;
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void initObservers() {
        com.toshi.view.fragment.coin.m mVar = this.f11307d;
        if (mVar != null) {
            s<q> observeOn = mVar.j().subscribeOn(this.f11305b).observeOn(this.f11306c);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.balanceObservable()\n            .subscribeOn(subscribeScheduler)\n            .observeOn(mainScheduler)");
            com.toshi.view.fragment.coin.m mVar2 = this.f11307d;
            if (mVar2 != null) {
                Object as = Observable_AnalyticsKt.logError$default(observeOn, kotlin.jvm.internal.m.o("Unable to update coin: ", mVar2.getWallet()), null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.balanceObservable()\n            .subscribeOn(subscribeScheduler)\n            .observeOn(mainScheduler)\n            .logError(\"Unable to update coin: ${viewModel.wallet}\")\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new b(), 3, null);
                com.toshi.view.fragment.coin.m mVar3 = this.f11307d;
                if (mVar3 != null) {
                    s<Boolean> observeOn2 = mVar3.t().observeOn(this.f11306c);
                    kotlin.jvm.internal.m.f(observeOn2, "viewModel.isBlockchainSynced()\n            .observeOn(mainScheduler)");
                    com.toshi.view.fragment.coin.m mVar4 = this.f11307d;
                    if (mVar4 != null) {
                        Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, kotlin.jvm.internal.m.o("Error while observing blockchain sync status for ", mVar4.getWallet().getCurrencyCode()), null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as2, "viewModel.isBlockchainSynced()\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing blockchain sync status for ${viewModel.wallet.currencyCode}\")\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new c(), 3, null);
                        com.toshi.view.fragment.coin.m mVar5 = this.f11307d;
                        if (mVar5 != null) {
                            s<List<TxHistoryCellViewState>> observeOn3 = mVar5.N().subscribeOn(this.f11305b).observeOn(this.f11306c);
                            kotlin.jvm.internal.m.f(observeOn3, "viewModel.txObservable()\n            .subscribeOn(subscribeScheduler)\n            .observeOn(mainScheduler)");
                            com.toshi.view.fragment.coin.m mVar6 = this.f11307d;
                            if (mVar6 != null) {
                                Object as3 = Observable_AnalyticsKt.logError$default(observeOn3, kotlin.jvm.internal.m.o("Error loading transaction history for coin: ", mVar6.getWallet().getId()), null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                                kotlin.jvm.internal.m.f(as3, "viewModel.txObservable()\n            .subscribeOn(subscribeScheduler)\n            .observeOn(mainScheduler)\n            .logError(\"Error loading transaction history for coin: ${viewModel.wallet.id}\")\n            .`as`(autoDisposable(scopeProvider))");
                                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new d(), 3, null);
                                com.toshi.view.fragment.coin.m mVar7 = this.f11307d;
                                if (mVar7 != null) {
                                    Object as4 = mVar7.r().observeOn(this.f11306c).as(com.uber.autodispose.d.a(getScopeProvider()));
                                    kotlin.jvm.internal.m.f(as4, "viewModel.historyType()\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new e(), 3, null);
                                    com.toshi.view.fragment.coin.m mVar8 = this.f11307d;
                                    if (mVar8 != null) {
                                        Object as5 = mVar8.getNavigationObservable().observeOn(this.f11306c).as(com.uber.autodispose.d.a(getScopeProvider()));
                                        kotlin.jvm.internal.m.f(as5, "viewModel.navigationObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as5, null, null, new f(), 3, null);
                                        com.toshi.view.fragment.coin.m mVar9 = this.f11307d;
                                        if (mVar9 != null) {
                                            Object as6 = mVar9.getPromptObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
                                            kotlin.jvm.internal.m.f(as6, "viewModel.promptObservable\n            .`as`(autoDisposable(scopeProvider))");
                                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as6, null, null, new g(), 3, null);
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
                            kotlin.jvm.internal.m.w("viewModel");
                            throw null;
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
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void initViewListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new h(), 1, null);
        View view2 = getView();
        View sendBtn = view2 == null ? null : view2.findViewById(e.j.a.sendBtn);
        kotlin.jvm.internal.m.f(sendBtn, "sendBtn");
        View_CommonKt.setOnSingleClickListener$default(sendBtn, 0L, new i(), 1, null);
        View view3 = getView();
        View receiveBtn = view3 == null ? null : view3.findViewById(e.j.a.receiveBtn);
        kotlin.jvm.internal.m.f(receiveBtn, "receiveBtn");
        View_CommonKt.setOnSingleClickListener$default(receiveBtn, 0L, new j(), 1, null);
        View view4 = getView();
        View moreBtn = view4 != null ? view4.findViewById(e.j.a.moreBtn) : null;
        kotlin.jvm.internal.m.f(moreBtn, "moreBtn");
        View_CommonKt.setOnSingleClickListener$default(moreBtn, 0L, new k(), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        com.toshi.view.fragment.coin.m mVar = this.f11307d;
        if (mVar != null) {
            analytics.log(AnalyticsEvent_ApplicationKt.coinDetailReceiveSelected(companion, mVar.getWallet().getDisplayName()));
            h0 m2 = m();
            com.toshi.view.fragment.coin.m mVar2 = this.f11307d;
            if (mVar2 != null) {
                List<WalletAddress> addresses = mVar2.getWallet().getAddresses();
                com.toshi.view.fragment.coin.m mVar3 = this.f11307d;
                if (mVar3 != null) {
                    CurrencyCode currencyCode = mVar3.getWallet().getCurrencyCode();
                    com.toshi.view.fragment.coin.m mVar4 = this.f11307d;
                    if (mVar4 != null) {
                        Blockchain blockchain = mVar4.getWallet().getBlockchain();
                        com.toshi.view.fragment.coin.m mVar5 = this.f11307d;
                        if (mVar5 != null) {
                            Fragment_CommonKt.navigate$default(this, R.id.action_walletDetailFragment_to_displayCoinAddressFragment, m2.c(addresses, currencyCode, blockchain, mVar5.getWallet()), null, null, 12, null);
                            return;
                        } else {
                            kotlin.jvm.internal.m.w("viewModel");
                            throw null;
                        }
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
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        List m2;
        CharSequence text = getText(R.string.got_it);
        kotlin.jvm.internal.m.f(text, "getText(R.string.got_it)");
        m2 = r.m(new PromptDialogHelper.Action(text, ActionStyle.POSITIVE, m.a));
        PromptDialogHelper promptDialogHelper = PromptDialogHelper.INSTANCE;
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.f(requireContext, "requireContext()");
        CharSequence text2 = getText(R.string.send_history_title);
        CharSequence text3 = getText(R.string.send_history_message);
        kotlin.jvm.internal.m.f(text2, "getText(R.string.send_history_title)");
        promptDialogHelper.create(requireContext, new PromptDialogHelper.Properties(null, text2, text3, null, Integer.valueOf((int) R.drawable.ic_celebrate), m2, Integer.valueOf((int) R.style.DialogVerticalSlideAnimation), false, null, null, null, null, null, false, 16265, null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        Bundle createArguments;
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        com.toshi.view.fragment.coin.m mVar = this.f11307d;
        if (mVar != null) {
            analytics.log(AnalyticsEvent_ApplicationKt.coinDetailSendSelected(companion, mVar.getWallet().getDisplayName()));
            SendArgs sendArgs = SendArgs.INSTANCE;
            com.toshi.view.fragment.coin.m mVar2 = this.f11307d;
            if (mVar2 != null) {
                createArguments = sendArgs.createArguments(mVar2.getWallet(), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, u.a(AmountPickerViewModel.class.getName(), SendAmountPickerViewModel.class));
                Fragment_CommonKt.navigate$default(this, R.id.action_walletDetailFragment_to_sendAmountPickerFragment, createArguments, null, null, 12, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(TxHistoryCellViewState txHistoryCellViewState) {
        if (txHistoryCellViewState instanceof TxHistoryCellViewState.Item) {
            com.toshi.view.fragment.coin.m mVar = this.f11307d;
            if (mVar != null) {
                TxHistoryCellViewState.Item item = (TxHistoryCellViewState.Item) txHistoryCellViewState;
                Object as = Single_AnalyticsKt.logError$default(Observable_CoreKt.takeSingle(mVar.m(item)), kotlin.jvm.internal.m.o("Could not find transaction with hash: ", item.getTx().getTxHash()), null, 2, null).observeOn(this.f11306c).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.getTxHistoryDetail(historyCellViewState)\n                .takeSingle()\n                .logError(\"Could not find transaction with hash: ${historyCellViewState.tx.txHash}\")\n                .observeOn(mainScheduler)\n                .`as`(autoDisposable(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new n(), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        View view = getView();
        ViewGroup.LayoutParams layoutParams = ((AppBarLayout) (view == null ? null : view.findViewById(e.j.a.appBarLayout))).getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
        fVar.o(null);
        View view2 = getView();
        ((AppBarLayout) (view2 != null ? view2.findViewById(e.j.a.appBarLayout) : null)).setLayoutParams(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(q qVar) {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.K6))).setText(qVar.c().getDisplayName());
        View view2 = getView();
        TextView textView = (TextView) (view2 == null ? null : view2.findViewById(e.j.a.fiatValue));
        String b2 = qVar.b();
        if (b2 == null) {
            b2 = "";
        }
        textView.setText(b2);
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.coinValue))).setText(qVar.a());
        Wallet c2 = qVar.c();
        if (c2.getImageURL() == null) {
            View view4 = getView();
            ((ImageView) (view4 == null ? null : view4.findViewById(e.j.a.thumbnail))).setVisibility(4);
            View view5 = getView();
            ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.fallbackThumbnail))).setText(CharSequence_CommonKt.buildTickerText(c2.getCurrencyCode().getRawValue()));
            View view6 = getView();
            ((TextView) (view6 != null ? view6.findViewById(e.j.a.fallbackThumbnail) : null)).setVisibility(0);
            return;
        }
        RequestBuilder<Drawable> load = Glide.with(this).load(c2.getImageURL());
        View view7 = getView();
        load.into((ImageView) (view7 != null ? view7.findViewById(e.j.a.thumbnail) : null));
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), false, false, false, 6, null);
    }

    public final GenericViewModelFactory<com.toshi.view.fragment.coin.m> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<com.toshi.view.fragment.coin.m> genericViewModelFactory = this.f11309f;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    public final h0 m() {
        h0 h0Var = this.f11310g;
        if (h0Var != null) {
            return h0Var;
        }
        kotlin.jvm.internal.m.w("displayCoinAddressFragmentFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_coin_details, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        com.toshi.view.fragment.coin.m mVar = this.f11307d;
        if (mVar != null) {
            analytics.log(AnalyticsEvent_ApplicationKt.coinDetailLanded(companion, mVar.getWallet().getDisplayName()));
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        Wallet wallet = (Wallet) e.j.f.e.b(getArguments(), "wallet");
        b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(com.toshi.view.fragment.coin.m.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        com.toshi.view.fragment.coin.m mVar = (com.toshi.view.fragment.coin.m) a2;
        this.f11307d = mVar;
        if (mVar != null) {
            mVar.setWallet(wallet);
            initObservers();
            initViewListeners();
            final Context requireContext = requireContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext) { // from class: com.toshi.view.fragment.coin.WalletDetailFragment$onViewCreated$layoutManager$1
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
                public void e1(RecyclerView.b0 b0Var) {
                    super.e1(b0Var);
                    int i2 = i2() + 1;
                    TxHistoryAdapter txHistoryAdapter = WalletDetailFragment.this.f11308e;
                    if (txHistoryAdapter == null) {
                        kotlin.jvm.internal.m.w("txHistoryAdapter");
                        throw null;
                    } else if (i2 == txHistoryAdapter.getItemCount()) {
                        WalletDetailFragment.this.r();
                    }
                }
            };
            this.f11308e = new TxHistoryAdapter(new l(this));
            View view2 = getView();
            ((RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.transactionHistory))).setLayoutManager(linearLayoutManager);
            View view3 = getView();
            RecyclerView recyclerView = (RecyclerView) (view3 == null ? null : view3.findViewById(e.j.a.transactionHistory));
            TxHistoryAdapter txHistoryAdapter = this.f11308e;
            if (txHistoryAdapter != null) {
                recyclerView.setAdapter(txHistoryAdapter);
                return;
            } else {
                kotlin.jvm.internal.m.w("txHistoryAdapter");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}