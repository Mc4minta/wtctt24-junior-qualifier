package com.coinbase.wallet.features.swap.viewmodels;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.features.swap.extensions.StoreKeys_SwapKt;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerArgs;
import com.coinbase.wallet.features.swap.models.SwapDisclaimerFragmentArgs;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: SwapInterstitialViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001b\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\b\b\u0001\u0010 \u001a\u00020\u001f¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00108B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u000eR\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapInterstitialViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "getSwapNavRoute", "()Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "Lkotlin/x;", "onPause", "()V", "onPreDraw", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "targetAsset", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "Lh/c/v0/b;", "dismissSubject", "Lh/c/v0/b;", "sourceAsset", "", "hasSharedElementTransition", "Z", "getHasSharedElementTransition", "()Z", "Lh/c/s;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "value", "getShouldFinish", "setShouldFinish", "(Z)V", SwapInterstitialViewModel.shouldFinishKey, "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "navigationSubject", "dismissObservable", "getDismissObservable", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Landroidx/lifecycle/z;)V", "Companion", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapInterstitialViewModel extends androidx.lifecycle.b0 {
    public static final Companion Companion = new Companion(null);
    private static final String shouldFinishKey = "shouldFinish";
    private final h.c.s<kotlin.x> dismissObservable;
    private final h.c.v0.b<kotlin.x> dismissSubject;
    private final boolean hasSharedElementTransition;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final androidx.lifecycle.z savedStateHandle;
    private final SwapAsset sourceAsset;
    private final StoreInterface store;
    private final SwapAsset targetAsset;

    /* compiled from: SwapInterstitialViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapInterstitialViewModel$Companion;", "", "", "shouldFinishKey", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SwapInterstitialViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapInterstitialViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapInterstitialViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapInterstitialViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        SwapInterstitialViewModel create(androidx.lifecycle.z zVar);
    }

    public SwapInterstitialViewModel(StoreInterface store, androidx.lifecycle.z savedStateHandle) {
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.store = store;
        this.savedStateHandle = savedStateHandle;
        this.sourceAsset = (SwapAsset) savedStateHandle.b("sourceAsset");
        this.targetAsset = (SwapAsset) savedStateHandle.b("targetAsset");
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.navigationSubject = d2;
        h.c.v0.b<kotlin.x> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.dismissSubject = d3;
        this.hasSharedElementTransition = ((Boolean) SavedStateHandle_CommonKt.require(savedStateHandle, "hasSharedElementTransition")).booleanValue();
        h.c.s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        h.c.s<kotlin.x> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "dismissSubject.hide()");
        this.dismissObservable = hide2;
    }

    private final boolean getShouldFinish() {
        return kotlin.jvm.internal.m.c(this.savedStateHandle.b(shouldFinishKey), Boolean.TRUE);
    }

    private final ViewModelNavRoute getSwapNavRoute() {
        Boolean bool = (Boolean) this.store.get(StoreKeys_SwapKt.getSwapUserAgreementViewed(StoreKeys.INSTANCE));
        if (bool == null ? false : bool.booleanValue()) {
            return new ViewModelNavRoute(R.id.action_swapInterstitialFragment_to_swapAmountPickerFragment, SwapAmountPickerArgs.INSTANCE.createArguments(this.sourceAsset, this.targetAsset), null, 4, null);
        }
        return new ViewModelNavRoute(R.id.action_swapInterstitialFragment_to_swapUserAgreementFragment, SwapDisclaimerFragmentArgs.INSTANCE.createArguments(this.sourceAsset, this.targetAsset), null, 4, null);
    }

    private final void setShouldFinish(boolean z) {
        this.savedStateHandle.g(shouldFinishKey, Boolean.valueOf(z));
    }

    public final h.c.s<kotlin.x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final boolean getHasSharedElementTransition() {
        return this.hasSharedElementTransition;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final void onPause() {
        setShouldFinish(true);
    }

    public final void onPreDraw() {
        if (getShouldFinish()) {
            this.dismissSubject.onNext(kotlin.x.a);
        } else {
            this.navigationSubject.onNext(getSwapNavRoute());
        }
    }
}