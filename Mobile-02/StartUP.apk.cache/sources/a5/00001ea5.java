package com.coinbase.wallet.features.lend.viewmodels;

import androidx.lifecycle.b0;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.features.lend.extensions.StoreKeys_LendKt;
import com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching;
import com.coinbase.wallet.features.lend.models.LendCoinPickerArgs;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: LendViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/lend/viewmodels/LendViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/lend/interfaces/LendBalanceFetching;", "Lh/c/b0;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "getLendNavRoute", "()Lh/c/b0;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "getTxHistoryRepository", "()Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "getLendRepository", "()Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "<init>", "(Lcom/coinbase/wallet/lending/interfaces/ILendRepository;Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendViewModel extends b0 implements LendBalanceFetching {
    private final ILendRepository lendRepository;
    private final StoreInterface store;
    private final TxHistoryRepository txHistoryRepository;

    public LendViewModel(ILendRepository lendRepository, TxHistoryRepository txHistoryRepository, StoreInterface store) {
        kotlin.jvm.internal.m.g(lendRepository, "lendRepository");
        kotlin.jvm.internal.m.g(txHistoryRepository, "txHistoryRepository");
        kotlin.jvm.internal.m.g(store, "store");
        this.lendRepository = lendRepository;
        this.txHistoryRepository = txHistoryRepository;
        this.store = store;
    }

    public static /* synthetic */ ViewModelNavRoute a(LendViewModel lendViewModel, Boolean bool) {
        return m1289getLendNavRoute$lambda0(lendViewModel, bool);
    }

    /* renamed from: getLendNavRoute$lambda-0 */
    public static final ViewModelNavRoute m1289getLendNavRoute$lambda0(LendViewModel this$0, Boolean isBalanceAvailable) {
        AnalyticsEvent lendEarnInterestNewUserStart;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(isBalanceAvailable, "isBalanceAvailable");
        if (isBalanceAvailable.booleanValue()) {
            lendEarnInterestNewUserStart = AnalyticsEvent_ApplicationKt.lendEarnInterestExistingUserStart(AnalyticsEvent.Companion);
        } else {
            lendEarnInterestNewUserStart = AnalyticsEvent_ApplicationKt.lendEarnInterestNewUserStart(AnalyticsEvent.Companion);
        }
        Analytics.INSTANCE.log(lendEarnInterestNewUserStart);
        Boolean bool = (Boolean) this$0.store.get(StoreKeys_LendKt.getLendUserAgreementViewed(StoreKeys.INSTANCE));
        if (!(bool == null ? false : bool.booleanValue())) {
            return new ViewModelNavRoute(R.id.action_lendInterstitialFragment_to_lendUserAgreementFragment, null, null, 6, null);
        }
        if (isBalanceAvailable.booleanValue()) {
            return new ViewModelNavRoute(R.id.action_lendInterstitialFragment_to_lendDashboard, null, null, 6, null);
        }
        return new ViewModelNavRoute(R.id.action_lendInterstitialFragment_to_lendCoinPickerFragment, LendCoinPickerArgs.INSTANCE.createArguments(ContractAction.SUPPLY), null, 4, null);
    }

    public final h.c.b0<ViewModelNavRoute> getLendNavRoute() {
        h.c.b0 map = isBalanceAvailable().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendViewModel.a(LendViewModel.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "isBalanceAvailable()\n        .map { isBalanceAvailable ->\n            val event = if (isBalanceAvailable) {\n                AnalyticsEvent.lendEarnInterestExistingUserStart()\n            } else {\n                AnalyticsEvent.lendEarnInterestNewUserStart()\n            }\n            Analytics.log(event)\n\n            val agreementViewed = store.get(StoreKeys.lendUserAgreementViewed) ?: false\n            if (!agreementViewed) {\n                return@map ViewModelNavRoute(\n                    resourceId = R.id.action_lendInterstitialFragment_to_lendUserAgreementFragment\n                )\n            }\n\n            if (isBalanceAvailable) {\n                ViewModelNavRoute(R.id.action_lendInterstitialFragment_to_lendDashboard)\n            } else {\n                val arguments = LendCoinPickerArgs.createArguments(contractAction = ContractAction.SUPPLY)\n                ViewModelNavRoute(\n                    resourceId = R.id.action_lendInterstitialFragment_to_lendCoinPickerFragment,\n                    args = arguments\n                )\n            }\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public ILendRepository getLendRepository() {
        return this.lendRepository;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public TxHistoryRepository getTxHistoryRepository() {
        return this.txHistoryRepository;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public h.c.b0<Boolean> isBalanceAvailable() {
        return LendBalanceFetching.DefaultImpls.isBalanceAvailable(this);
    }
}