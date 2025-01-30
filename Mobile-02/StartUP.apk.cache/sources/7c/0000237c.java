package com.coinbase.wallet.features.wallets.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.send.models.SendCoinPickerArgs;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel;
import com.coinbase.wallet.features.wallets.extensions.legacy.Wallet_Erc20Kt;
import com.coinbase.wallet.features.wallets.models.ListItem;
import com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel;
import com.coinbase.wallet.features.wallets.views.adapters.WalletAdapter;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.routing.models.SendArgs;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import com.uber.autodispose.x;
import e.j.f.r;
import h.c.a0;
import h.c.m0.f;
import h.c.m0.n;
import h.c.s;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.u;
import org.toshi.R;

/* compiled from: SendCoinPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001%\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001NB\u0007¢\u0006\u0004\bM\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R#\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R#\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00100\u001a\u0004\b5\u00102R\u001f\u0010:\u001a\u0004\u0018\u00010\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00100\u001a\u0004\b8\u00109R(\u0010<\u001a\b\u0012\u0004\u0012\u00020(0;8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020B8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/SendCoinPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "initViewModel", "()V", "initClickListeners", "", "isNotElevated", "setHeaderElevated", "(Z)V", "initAdapter", "initObservers", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "handleNavigation", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "qrCodeResult", "navToSendAmount", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/qr/models/QRCodeScanResult;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onBackPressed", "()Z", "com/coinbase/wallet/features/wallets/views/SendCoinPickerFragment$headerElevationScrollerListener$1", "headerElevationScrollerListener", "Lcom/coinbase/wallet/features/wallets/views/SendCoinPickerFragment$headerElevationScrollerListener$1;", "Lcom/coinbase/wallet/features/wallets/viewmodels/WalletsTabViewModel;", "viewModel", "Lcom/coinbase/wallet/features/wallets/viewmodels/WalletsTabViewModel;", "Lh/c/a0;", "mainScheduler", "Lh/c/a0;", "", "walletFilter$delegate", "Lkotlin/h;", "getWalletFilter", "()Ljava/util/List;", "walletFilter", "qrCodeScanResults$delegate", "getQrCodeScanResults", "qrCodeScanResults", "initialSelection$delegate", "getInitialSelection", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "initialSelection", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter;", "adapter", "Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter;", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendCoinPickerFragment extends BaseFragment implements StyledFragment, BackableFragment {
    public static final Companion Companion = new Companion(null);
    private static final int UP_DIRECTION = -1;
    private WalletAdapter adapter;
    private final SendCoinPickerFragment$headerElevationScrollerListener$1 headerElevationScrollerListener;
    private final h initialSelection$delegate;
    private final a0 mainScheduler;
    private final h qrCodeScanResults$delegate;
    private WalletsTabViewModel viewModel;
    public GenericViewModelFactory<WalletsTabViewModel> viewModelFactory;
    private final h walletFilter$delegate;

    /* compiled from: SendCoinPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/SendCoinPickerFragment$Companion;", "", "", "UP_DIRECTION", "I", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.coinbase.wallet.features.wallets.views.SendCoinPickerFragment$headerElevationScrollerListener$1] */
    public SendCoinPickerFragment() {
        h b2;
        h b3;
        h b4;
        b2 = k.b(new SendCoinPickerFragment$initialSelection$2(this));
        this.initialSelection$delegate = b2;
        a0 b5 = h.c.j0.c.a.b();
        m.f(b5, "mainThread()");
        this.mainScheduler = b5;
        b3 = k.b(new SendCoinPickerFragment$walletFilter$2(this));
        this.walletFilter$delegate = b3;
        b4 = k.b(new SendCoinPickerFragment$qrCodeScanResults$2(this));
        this.qrCodeScanResults$delegate = b4;
        this.headerElevationScrollerListener = new RecyclerView.t() { // from class: com.coinbase.wallet.features.wallets.views.SendCoinPickerFragment$headerElevationScrollerListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.t
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                m.g(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                if (recyclerView.canScrollVertically(-1)) {
                    SendCoinPickerFragment.access$setHeaderElevated(SendCoinPickerFragment.this, false);
                } else {
                    SendCoinPickerFragment.access$setHeaderElevated(SendCoinPickerFragment.this, true);
                }
            }
        };
    }

    public static final /* synthetic */ void access$setHeaderElevated(SendCoinPickerFragment sendCoinPickerFragment, boolean z) {
        sendCoinPickerFragment.setHeaderElevated(z);
    }

    public static /* synthetic */ void d(SendCoinPickerFragment sendCoinPickerFragment, List list) {
        m1556initObservers$lambda3(sendCoinPickerFragment, list);
    }

    public static /* synthetic */ List e(SendCoinPickerFragment sendCoinPickerFragment, List list) {
        return m1555initObservers$lambda2(sendCoinPickerFragment, list);
    }

    public final Wallet getInitialSelection() {
        return (Wallet) this.initialSelection$delegate.getValue();
    }

    private final List<QRCodeScanResult> getQrCodeScanResults() {
        return (List) this.qrCodeScanResults$delegate.getValue();
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final List<Wallet> getWalletFilter() {
        return (List) this.walletFilter$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void handleNavigation(Wallet wallet) {
        ?? r2;
        QRCodeScanResult qRCodeScanResult;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendCoinPickerCoinSelected(AnalyticsEvent.Companion, wallet.getDisplayName()));
        if (Wallet_Erc20Kt.isErc20(wallet)) {
            List<QRCodeScanResult> qrCodeScanResults = getQrCodeScanResults();
            ArrayList arrayList = new ArrayList();
            for (Object obj : qrCodeScanResults) {
                if (obj instanceof QRCodeScanResult.ERC20) {
                    arrayList.add(obj);
                }
            }
            qRCodeScanResult = (QRCodeScanResult) p.a0(arrayList);
        } else {
            Iterator it = getQrCodeScanResults().iterator();
            while (true) {
                if (!it.hasNext()) {
                    r2 = 0;
                    break;
                }
                r2 = it.next();
                if (m.c(((QRCodeScanResult) r2).getBlockchain(), wallet.getBlockchain())) {
                    break;
                }
            }
            qRCodeScanResult = r2;
        }
        String address = qRCodeScanResult == null ? null : qRCodeScanResult.getAddress();
        BigInteger amount = qRCodeScanResult == null ? null : qRCodeScanResult.getAmount();
        if (address != null && amount != null) {
            Fragment_CommonKt.navigate$default(this, R.id.action_sendCoinPickerFragment_to_sendDestinationPickerFragment, SendDestinationPickerArgs.INSTANCE.createArguments(new TransferValue.Amount(amount), wallet, address, qRCodeScanResult == null ? null : qRCodeScanResult.getWalletAccountId(), qRCodeScanResult != null ? qRCodeScanResult.getMemoType() : null), null, null, 12, null);
            return;
        }
        navToSendAmount(wallet, qRCodeScanResult);
    }

    private final void initAdapter() {
        this.adapter = new WalletAdapter(null, null, null, new SendCoinPickerFragment$initAdapter$1(this), 7, null);
        View view = getView();
        View recyclerView = view == null ? null : view.findViewById(e.j.a.recyclerView);
        m.f(recyclerView, "recyclerView");
        r.b((RecyclerView) recyclerView, 0, 0, 0, 0, 0, 0, 63, null);
        View view2 = getView();
        RecyclerView recyclerView2 = (RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.recyclerView));
        WalletAdapter walletAdapter = this.adapter;
        if (walletAdapter != null) {
            recyclerView2.setAdapter(walletAdapter);
            View view3 = getView();
            ((RecyclerView) (view3 != null ? view3.findViewById(e.j.a.recyclerView) : null)).addOnScrollListener(this.headerElevationScrollerListener);
            return;
        }
        m.w("adapter");
        throw null;
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new SendCoinPickerFragment$initClickListeners$1(this), 1, null);
        View view2 = getView();
        View getCryptoButton = view2 != null ? view2.findViewById(e.j.a.getCryptoButton) : null;
        m.f(getCryptoButton, "getCryptoButton");
        View_CommonKt.setOnSingleClickListener$default(getCryptoButton, 0L, new SendCoinPickerFragment$initClickListeners$2(this), 1, null);
    }

    private final void initObservers() {
        WalletsTabViewModel walletsTabViewModel = this.viewModel;
        if (walletsTabViewModel != null) {
            s<R> map = walletsTabViewModel.getWalletsObservable().observeOn(this.mainScheduler).map(new n() { // from class: com.coinbase.wallet.features.wallets.views.b
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SendCoinPickerFragment.e(SendCoinPickerFragment.this, (List) obj);
                }
            });
            m.f(map, "viewModel.walletsObservable\n            .observeOn(mainScheduler)\n            .map { coins ->\n                if (walletFilter.isNotEmpty()) {\n                    coins.filter {\n                        walletFilter.map { res -> res.blockchain }\n                            .contains(it.wallet.blockchain)\n                    }\n                } else {\n                    coins\n                }\n            }");
            ((x) Observable_AnalyticsKt.logError$default(map, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new f() { // from class: com.coinbase.wallet.features.wallets.views.a
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    SendCoinPickerFragment.d(SendCoinPickerFragment.this, (List) obj);
                }
            });
            return;
        }
        m.w("viewModel");
        throw null;
    }

    /* renamed from: initObservers$lambda-2 */
    public static final List m1555initObservers$lambda2(SendCoinPickerFragment this$0, List coins) {
        int r;
        m.g(this$0, "this$0");
        m.g(coins, "coins");
        if (!this$0.getWalletFilter().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : coins) {
                ListItem.WalletListItem walletListItem = (ListItem.WalletListItem) obj;
                List<Wallet> walletFilter = this$0.getWalletFilter();
                r = kotlin.a0.s.r(walletFilter, 10);
                ArrayList arrayList2 = new ArrayList(r);
                for (Wallet wallet : walletFilter) {
                    arrayList2.add(wallet.getBlockchain());
                }
                if (arrayList2.contains(walletListItem.getWallet().getBlockchain())) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return coins;
    }

    /* renamed from: initObservers$lambda-3 */
    public static final void m1556initObservers$lambda3(SendCoinPickerFragment this$0, List it) {
        m.g(this$0, "this$0");
        m.f(it, "it");
        if (!it.isEmpty()) {
            WalletAdapter walletAdapter = this$0.adapter;
            if (walletAdapter != null) {
                walletAdapter.submitList(it);
                return;
            } else {
                m.w("adapter");
                throw null;
            }
        }
        View view = this$0.getView();
        ((RecyclerView) (view == null ? null : view.findViewById(e.j.a.recyclerView))).setVisibility(4);
        View view2 = this$0.getView();
        ((ConstraintLayout) (view2 == null ? null : view2.findViewById(e.j.a.emptyCoinView))).setVisibility(0);
        View view3 = this$0.getView();
        ((CardView) (view3 != null ? view3.findViewById(e.j.a.headerBar) : null)).setCardElevation(0.0f);
    }

    private final void initViewModel() {
        b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(WalletsTabViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (WalletsTabViewModel) a;
    }

    private final void navToSendAmount(Wallet wallet, QRCodeScanResult qRCodeScanResult) {
        if (ForwardArgs.INSTANCE.modalSourceFromArgs(getArguments()) != null) {
            Fragment_CommonKt.setNavigationResult(this, SendCoinPickerArgs.INSTANCE.getPICKED_WALLET_RESULT(), wallet);
            Fragment_CommonKt.navigateUpTo$default(this, R.id.amountPickerFragment, false, 2, null);
            return;
        }
        Fragment_CommonKt.navigate$default(this, R.id.action_sendCoinPickerFragment_to_sendAmountPickerFragment, SendArgs.INSTANCE.createArguments(wallet, qRCodeScanResult == null ? null : qRCodeScanResult.getAddress(), qRCodeScanResult == null ? null : qRCodeScanResult.getWalletAccountId(), qRCodeScanResult != null ? qRCodeScanResult.getMemoType() : null, u.a(AmountPickerViewModel.class.getName(), SendAmountPickerViewModel.class)), null, null, 12, null);
    }

    public final void setHeaderElevated(boolean z) {
        if (z) {
            View view = getView();
            CardView cardView = (CardView) (view != null ? view.findViewById(e.j.a.headerBar) : null);
            if (cardView == null) {
                return;
            }
            cardView.setCardElevation(0.0f);
            return;
        }
        View view2 = getView();
        CardView cardView2 = (CardView) (view2 != null ? view2.findViewById(e.j.a.headerBar) : null);
        if (cardView2 == null) {
            return;
        }
        cardView2.setCardElevation(getResources().getDimension(R.dimen.elevation_default));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    public final GenericViewModelFactory<WalletsTabViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        super.onCreateView(inflater, viewGroup, bundle);
        return inflater.inflate(R.layout.fragment_send_coin_picker, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendCoinPickerLanded(AnalyticsEvent.Companion));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        initViewModel();
        initClickListeners();
        initAdapter();
        initObservers();
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}