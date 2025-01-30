package com.coinbase.wallet.features.lend.viewmodels;

import androidx.lifecycle.b0;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.features.lend.extensions.StoreKeys_LendKt;
import com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching;
import com.coinbase.wallet.features.lend.models.LendCoinPickerArgs;
import com.coinbase.wallet.features.lend.models.LendUserAgreementState;
import com.coinbase.wallet.features.lend.models.UserAgreementPageItem;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import h.c.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendUserAgreementViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b8\u00109J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR*\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R#\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00102\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u001e0\u001e0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0018R\u001f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150-8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/features/lend/viewmodels/LendUserAgreementViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/lend/interfaces/LendBalanceFetching;", "", "index", "Lkotlin/x;", "onPageChanged", "(I)V", "", "isChecked", "onAgreementChanged", "(Z)V", "Lh/c/b0;", "proceedToLendFlow", "()Lh/c/b0;", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "getTxHistoryRepository", "()Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "navigationSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "getLendRepository", "()Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;", "getState", "()Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;", "setState", "(Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;)V", "", "Lcom/coinbase/wallet/features/lend/models/UserAgreementPageItem;", "data$delegate", "Lkotlin/h;", "getData", "()Ljava/util/List;", "data", "Lh/c/s;", "stateObservable", "Lh/c/s;", "getStateObservable", "()Lh/c/s;", "stateSubject", "navigationObservable", "getNavigationObservable", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;Lcom/coinbase/wallet/lending/interfaces/ILendRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendUserAgreementViewModel extends b0 implements LendBalanceFetching {
    private final kotlin.h data$delegate;
    private final ILendRepository lendRepository;
    private final s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private LendUserAgreementState state;
    private final s<LendUserAgreementState> stateObservable;
    private final h.c.v0.b<LendUserAgreementState> stateSubject;
    private final StoreInterface store;
    private final TxHistoryRepository txHistoryRepository;

    public LendUserAgreementViewModel(StoreInterface store, TxHistoryRepository txHistoryRepository, ILendRepository lendRepository) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(txHistoryRepository, "txHistoryRepository");
        kotlin.jvm.internal.m.g(lendRepository, "lendRepository");
        this.store = store;
        this.txHistoryRepository = txHistoryRepository;
        this.lendRepository = lendRepository;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ViewModelNavRoute>()");
        this.navigationSubject = d2;
        h.c.v0.b<LendUserAgreementState> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<LendUserAgreementState>()");
        this.stateSubject = d3;
        s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        s<LendUserAgreementState> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "stateSubject.hide()");
        this.stateObservable = hide2;
        this.state = new LendUserAgreementState(0, false, 3, null);
        b2 = kotlin.k.b(LendUserAgreementViewModel$data$2.INSTANCE);
        this.data$delegate = b2;
    }

    public static /* synthetic */ x a(LendUserAgreementViewModel lendUserAgreementViewModel, Boolean bool) {
        return m1288proceedToLendFlow$lambda0(lendUserAgreementViewModel, bool);
    }

    /* renamed from: proceedToLendFlow$lambda-0 */
    public static final x m1288proceedToLendFlow$lambda0(LendUserAgreementViewModel this$0, Boolean hasBalance) {
        ViewModelNavRoute viewModelNavRoute;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(hasBalance, "hasBalance");
        if (hasBalance.booleanValue()) {
            viewModelNavRoute = new ViewModelNavRoute(R.id.action_lendUserAgreementFragment_to_lendDashboardFragment, null, null, 6, null);
        } else {
            viewModelNavRoute = new ViewModelNavRoute(R.id.action_lendUserAgreementFragment_to_lendCoinPickerFragment, LendCoinPickerArgs.INSTANCE.createArguments(ContractAction.SUPPLY), null, 4, null);
        }
        this$0.navigationSubject.onNext(viewModelNavRoute);
        return x.a;
    }

    private final void setState(LendUserAgreementState lendUserAgreementState) {
        this.state = lendUserAgreementState;
        this.stateSubject.onNext(lendUserAgreementState);
    }

    public final List<UserAgreementPageItem> getData() {
        return (List) this.data$delegate.getValue();
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public ILendRepository getLendRepository() {
        return this.lendRepository;
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final LendUserAgreementState getState() {
        return this.state;
    }

    public final s<LendUserAgreementState> getStateObservable() {
        return this.stateObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public TxHistoryRepository getTxHistoryRepository() {
        return this.txHistoryRepository;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public h.c.b0<Boolean> isBalanceAvailable() {
        return LendBalanceFetching.DefaultImpls.isBalanceAvailable(this);
    }

    public final void onAgreementChanged(boolean z) {
        setState(LendUserAgreementState.copy$default(this.state, 0, z, 1, null));
    }

    public final void onPageChanged(int i2) {
        setState(LendUserAgreementState.copy$default(this.state, i2, false, 2, null));
    }

    public final h.c.b0<x> proceedToLendFlow() {
        this.store.set(StoreKeys_LendKt.getLendUserAgreementViewed(StoreKeys.INSTANCE), Boolean.TRUE);
        h.c.b0 map = isBalanceAvailable().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendUserAgreementViewModel.a(LendUserAgreementViewModel.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "isBalanceAvailable()\n            .map { hasBalance ->\n                val route = if (hasBalance) {\n                    ViewModelNavRoute(\n                        resourceId = R.id.action_lendUserAgreementFragment_to_lendDashboardFragment\n                    )\n                } else {\n                    ViewModelNavRoute(\n                        resourceId = R.id.action_lendUserAgreementFragment_to_lendCoinPickerFragment,\n                        args = LendCoinPickerArgs.createArguments(contractAction = ContractAction.SUPPLY)\n                    )\n                }\n\n                navigationSubject.onNext(route)\n            }");
        return map;
    }
}