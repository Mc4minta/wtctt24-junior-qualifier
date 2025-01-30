package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.viewmodels.ViewModelWithArgs;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.lend.extensions.PromptId_LendKt;
import com.coinbase.wallet.features.lend.models.LendAmountPickerArgs;
import com.coinbase.wallet.features.lend.models.LendProviderItem;
import com.coinbase.wallet.features.lend.models.LendProviderPickerArgs;
import com.coinbase.wallet.features.lend.models.LendProviderPickerState;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.toshi.model.local.room.Prompt;
import h.c.a0;
import h.c.s;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.z;
import org.toshi.R;

/* compiled from: LendProviderPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\bL\u0010MJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u0004R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R%\u0010)\u001a\n %*\u0004\u0018\u00010$0$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0011R$\u00100\u001a\u00020.2\u0006\u0010/\u001a\u00020.8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020.048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001f\u0010:\u001a\b\u0012\u0004\u0012\u00020.0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b=\u0010?\"\u0004\b@\u0010AR\u001d\u0010F\u001a\u00020B8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bD\u0010ER\u001f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00128\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010\u0017R\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/coinbase/wallet/features/lend/viewmodels/LendProviderPickerViewModel;", "Lcom/coinbase/wallet/commonui/viewmodels/ViewModelWithArgs;", "Lkotlin/x;", "setup", "()V", "Lcom/coinbase/wallet/features/lend/models/LendProviderItem;", "provider", "onProviderItemSelected", "(Lcom/coinbase/wallet/features/lend/models/LendProviderItem;)V", "onProviderAssetsClicked", "onProviderUtilizationClicked", "onProviderCollateralClicked", "proceedToAmountPicker", "onCleared", "Lh/c/v0/b;", "Lcom/toshi/model/local/room/Prompt;", "promptSubject", "Lh/c/v0/b;", "Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "lendTokens$delegate", "Lkotlin/h;", "getLendTokens", "()Ljava/util/List;", LendProviderPickerArgs.lendTokensKey, "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction$delegate", "getContractAction", "()Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler$delegate", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "navigationSubject", "Lcom/coinbase/wallet/features/lend/models/LendProviderPickerState;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/features/lend/models/LendProviderPickerState;", "setState", "(Lcom/coinbase/wallet/features/lend/models/LendProviderPickerState;)V", "Lh/c/v0/a;", "stateSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "stateObservable", "getStateObservable", "", "isSetup", "Z", "()Z", "setSetup", "(Z)V", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "lendWallet$delegate", "getLendWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", LendProviderPickerArgs.lendWalletKey, "promptObservable", "getPromptObservable", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "<init>", "(Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderPickerViewModel extends ViewModelWithArgs {
    private final kotlin.h contractAction$delegate;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.k0.a disposeBag;
    private final FeatureFlagsRepository featureFlagsRepository;
    private boolean isSetup;
    private final kotlin.h lendTokens$delegate;
    private final kotlin.h lendWallet$delegate;
    private final kotlin.h mainScheduler$delegate;
    private final s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final s<Prompt> promptObservable;
    private final h.c.v0.b<Prompt> promptSubject;
    private LendProviderPickerState state;
    private final s<LendProviderPickerState> stateObservable;
    private final h.c.v0.a<LendProviderPickerState> stateSubject;

    public LendProviderPickerViewModel(FeatureFlagsRepository featureFlagsRepository, CurrencyFormatter currencyFormatter) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        this.featureFlagsRepository = featureFlagsRepository;
        this.currencyFormatter = currencyFormatter;
        b2 = kotlin.k.b(new LendProviderPickerViewModel$lendTokens$2(this));
        this.lendTokens$delegate = b2;
        b3 = kotlin.k.b(new LendProviderPickerViewModel$contractAction$2(this));
        this.contractAction$delegate = b3;
        b4 = kotlin.k.b(new LendProviderPickerViewModel$lendWallet$2(this));
        this.lendWallet$delegate = b4;
        this.disposeBag = new h.c.k0.a();
        b5 = kotlin.k.b(LendProviderPickerViewModel$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b5;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.navigationSubject = d2;
        h.c.v0.b<Prompt> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.promptSubject = d3;
        h.c.v0.a<LendProviderPickerState> d4 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d4, "create()");
        this.stateSubject = d4;
        this.state = new LendProviderPickerState(null, false, false, 7, null);
        s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        s<Prompt> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "promptSubject.hide()");
        this.promptObservable = hide2;
        s<LendProviderPickerState> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "stateSubject.hide()");
        this.stateObservable = hide3;
    }

    private final ContractAction getContractAction() {
        return (ContractAction) this.contractAction$delegate.getValue();
    }

    private final List<LendToken> getLendTokens() {
        Object value = this.lendTokens$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-lendTokens>(...)");
        return (List) value;
    }

    private final Wallet getLendWallet() {
        return (Wallet) this.lendWallet$delegate.getValue();
    }

    private final a0 getMainScheduler() {
        return (a0) this.mainScheduler$delegate.getValue();
    }

    private final void setState(LendProviderPickerState lendProviderPickerState) {
        this.state = lendProviderPickerState;
        this.stateSubject.onNext(lendProviderPickerState);
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final s<Prompt> getPromptObservable() {
        return this.promptObservable;
    }

    public final s<LendProviderPickerState> getStateObservable() {
        return this.stateObservable;
    }

    public final boolean isSetup() {
        return this.isSetup;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void onProviderAssetsClicked() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendAUCExplainerStart(AnalyticsEvent.Companion));
        this.promptSubject.onNext(new Prompt(PromptId_LendKt.getLendAssetsUnderCustodyInfo(Prompt.Id.INSTANCE), R.string.provider_prompt_auc_title, R.string.provider_prompt_auc_message, null, Integer.valueOf((int) R.drawable.illustration_lend_custody), null, null, null, 232, null));
    }

    public final void onProviderCollateralClicked() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendCollateralExplainerStart(AnalyticsEvent.Companion));
        this.promptSubject.onNext(new Prompt(PromptId_LendKt.getLendMinCollateralInfo(Prompt.Id.INSTANCE), R.string.provider_prompt_collateral_title, R.string.provider_prompt_collateral_message, null, Integer.valueOf((int) R.drawable.illustration_lend_collateral), null, null, null, 232, null));
    }

    public final void onProviderItemSelected(LendProviderItem provider) {
        int r;
        kotlin.jvm.internal.m.g(provider, "provider");
        if (!provider.getEnabled()) {
            setState(LendProviderPickerState.copy$default(this.state, null, true, false, 5, null));
            return;
        }
        List<LendProviderItem> providers = this.state.getProviders();
        r = kotlin.a0.s.r(providers, 10);
        ArrayList arrayList = new ArrayList(r);
        boolean z = false;
        for (LendProviderItem lendProviderItem : providers) {
            if (kotlin.jvm.internal.m.c(lendProviderItem, provider)) {
                z = !lendProviderItem.getExpanded();
                lendProviderItem = LendProviderItem.copy$default(lendProviderItem, null, null, false, !lendProviderItem.getExpanded(), 7, null);
            } else if (lendProviderItem.getExpanded()) {
                lendProviderItem = LendProviderItem.copy$default(lendProviderItem, null, null, false, false, 7, null);
            }
            arrayList.add(lendProviderItem);
        }
        setState(this.state.copy(arrayList, false, z));
    }

    public final void onProviderUtilizationClicked() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendUtilizationExplainerStart(AnalyticsEvent.Companion));
        this.promptSubject.onNext(new Prompt(PromptId_LendKt.getLendUtilizationInfo(Prompt.Id.INSTANCE), R.string.provider_prompt_utilization_title, R.string.provider_prompt_utilization_message, null, Integer.valueOf((int) R.drawable.illustration_lend_utilization), null, null, null, 232, null));
    }

    public final void proceedToAmountPicker() {
        Object obj;
        Iterator<T> it = this.state.getProviders().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((LendProviderItem) obj).getExpanded()) {
                break;
            }
        }
        LendProviderItem lendProviderItem = (LendProviderItem) obj;
        if (lendProviderItem == null) {
            return;
        }
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_lendProviderPickerFragment_to_amountPickerFragment, LendAmountPickerArgs.INSTANCE.createArguments(getLendWallet(), lendProviderItem.getToken(), getContractAction()), null, 4, null));
    }

    public final void setSetup(boolean z) {
        this.isSetup = z;
    }

    public final void setup() {
        int r;
        List B0;
        LendProviderPickerState copy$default;
        List b2;
        List<LendToken> lendTokens = getLendTokens();
        r = kotlin.a0.s.r(lendTokens, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendToken lendToken : lendTokens) {
            arrayList.add(new LendProviderItem(lendToken, this.currencyFormatter, false, false, 12, null));
        }
        B0 = z.B0(arrayList, new Comparator<T>() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendProviderPickerViewModel$setup$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(((LendProviderItem) t).getToken().getProvider().getName(), ((LendProviderItem) t2).getToken().getProvider().getName());
                return c2;
            }
        });
        if (B0.size() == 1) {
            LendProviderPickerState lendProviderPickerState = this.state;
            b2 = kotlin.a0.q.b(LendProviderItem.copy$default((LendProviderItem) kotlin.a0.p.Y(B0), null, null, false, true, 7, null));
            copy$default = LendProviderPickerState.copy$default(lendProviderPickerState, b2, false, true, 2, null);
        } else {
            copy$default = LendProviderPickerState.copy$default(this.state, B0, false, false, 6, null);
        }
        setState(copy$default);
        this.isSetup = true;
    }
}