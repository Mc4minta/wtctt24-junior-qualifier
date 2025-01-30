package com.coinbase.wallet.features.swap.viewmodels;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.features.swap.extensions.StoreKeys_SwapKt;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerArgs;
import com.coinbase.wallet.features.swap.models.SwapUserAgreementViewState;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.swap.models.SwapAsset;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: SwapDisclaimerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel;", "Landroidx/lifecycle/b0;", "Lh/c/b0;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "proceedToSwapFlow", "()Lh/c/b0;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/features/swap/models/SwapUserAgreementViewState;", ApiConstants.STATE, "Lcom/coinbase/wallet/features/swap/models/SwapUserAgreementViewState;", "getState", "()Lcom/coinbase/wallet/features/swap/models/SwapUserAgreementViewState;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "targetAsset", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "sourceAsset", "Landroidx/lifecycle/z;", "savedStateHandle", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Landroidx/lifecycle/z;)V", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapDisclaimerViewModel extends androidx.lifecycle.b0 {
    private final SwapAsset sourceAsset;
    private final SwapUserAgreementViewState state;
    private final StoreInterface store;
    private final SwapAsset targetAsset;

    /* compiled from: SwapDisclaimerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        SwapDisclaimerViewModel create(androidx.lifecycle.z zVar);
    }

    public SwapDisclaimerViewModel(StoreInterface store, androidx.lifecycle.z savedStateHandle) {
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.store = store;
        this.sourceAsset = (SwapAsset) savedStateHandle.b("sourceAsset");
        this.targetAsset = (SwapAsset) savedStateHandle.b("targetAsset");
        this.state = new SwapUserAgreementViewState(0, null, null, 7, null);
    }

    public static /* synthetic */ ViewModelNavRoute a(SwapDisclaimerViewModel swapDisclaimerViewModel, kotlin.x xVar) {
        return m1508proceedToSwapFlow$lambda1(swapDisclaimerViewModel, xVar);
    }

    public static /* synthetic */ kotlin.x b(SwapDisclaimerViewModel swapDisclaimerViewModel) {
        return m1507proceedToSwapFlow$lambda0(swapDisclaimerViewModel);
    }

    /* renamed from: proceedToSwapFlow$lambda-0 */
    public static final kotlin.x m1507proceedToSwapFlow$lambda0(SwapDisclaimerViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.store.set(StoreKeys_SwapKt.getSwapUserAgreementViewed(StoreKeys.INSTANCE), Boolean.TRUE);
        return kotlin.x.a;
    }

    /* renamed from: proceedToSwapFlow$lambda-1 */
    public static final ViewModelNavRoute m1508proceedToSwapFlow$lambda1(SwapDisclaimerViewModel this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return new ViewModelNavRoute(R.id.action_swapUserAgreementFragment_to_swapAmountPickerFragment, SwapAmountPickerArgs.INSTANCE.createArguments(this$0.sourceAsset, this$0.targetAsset), null, 4, null);
    }

    public final SwapUserAgreementViewState getState() {
        return this.state;
    }

    public final h.c.b0<ViewModelNavRoute> proceedToSwapFlow() {
        h.c.b0<ViewModelNavRoute> map = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.features.swap.viewmodels.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SwapDisclaimerViewModel.b(SwapDisclaimerViewModel.this);
            }
        }).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.r0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapDisclaimerViewModel.a(SwapDisclaimerViewModel.this, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "fromCallable { store.set(StoreKeys.swapUserAgreementViewed, true) }\n            .observeOn(AndroidSchedulers.mainThread())\n            .map {\n                ViewModelNavRoute(\n                    resourceId = R.id.action_swapUserAgreementFragment_to_swapAmountPickerFragment,\n                    args = SwapAmountPickerArgs.createArguments(\n                        sourceAsset = sourceAsset,\n                        targetAsset = targetAsset\n                    )\n                )\n            }");
        return map;
    }
}