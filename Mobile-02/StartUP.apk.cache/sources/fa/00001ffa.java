package com.coinbase.wallet.features.send.viewmodels;

import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.viewmodels.ViewModelWithArgs;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.send.extensions.StoreKeys_SendKt;
import com.coinbase.wallet.features.send.models.AmountPickerSettings;
import com.coinbase.wallet.features.send.models.AmountPickerTitle;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;

/* compiled from: AmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\bG\u0010HJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0006H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020 H&¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u0011H&¢\u0006\u0004\b&\u0010\u0015R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020-0'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010)R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\r0'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010)R\u001c\u00101\u001a\u00020\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\b1\u0010,\"\u0004\b2\u00103R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\r0'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010)R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010)R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010,R\u0016\u0010?\u001a\u00020<8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010)R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020B0'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010)R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010)¨\u0006I"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/AmountPickerViewModel;", "Lcom/coinbase/wallet/commonui/viewmodels/ViewModelWithArgs;", "Lkotlin/x;", "updateMaxSendAmount", "()V", "onResume", "", "amountString", "Landroid/os/Bundle;", "args", "nextAction", "(Ljava/lang/String;Landroid/os/Bundle;)V", "rawCryptoAmount", "", "isSendingEntireBalance", "updateSendAmount", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/send/models/AmountPickerTitle;", "generateTitle", "()Lh/c/b0;", "onSliderToggled", "", "percentage", "formatCryptoAmount", "(F)Ljava/lang/String;", "cryptoAmount", "getCryptoPercentage", "(Ljava/lang/String;)F", "clearCachedCryptoAmount", "restoreCachedCryptoAmount", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "setWallet", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "loadWallet", "Lh/c/s;", "getMaxSendAmountObservable", "()Lh/c/s;", "maxSendAmountObservable", "isInterestDescriptionVisible", "()Z", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "getNavigateObservable", "navigateObservable", "isBalanceSufficientObservable", "isFiatSelected", "setFiatSelected", "(Z)V", "isNextButtonHiddenObservable", "getRestoredAmountObservable", "restoredAmountObservable", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getHasFiatRepresentation", "hasFiatRepresentation", "Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "getSettings", "()Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "settings", "getInterestInfoObservable", "interestInfoObservable", "Lcom/coinbase/wallet/features/send/models/SendBalances;", "getBalancesObservable", "balancesObservable", "getSliderStateObservable", "sliderStateObservable", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AmountPickerViewModel extends ViewModelWithArgs {
    private final StoreInterface store;

    public AmountPickerViewModel(StoreInterface store) {
        kotlin.jvm.internal.m.g(store, "store");
        this.store = store;
    }

    public static /* synthetic */ void updateSendAmount$default(AmountPickerViewModel amountPickerViewModel, String str, Boolean bool, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSendAmount");
        }
        if ((i2 & 2) != 0) {
            bool = null;
        }
        amountPickerViewModel.updateSendAmount(str, bool);
    }

    public abstract void clearCachedCryptoAmount();

    public abstract String formatCryptoAmount(float f2);

    public abstract h.c.b0<Optional<AmountPickerTitle>> generateTitle();

    public abstract h.c.s<SendBalances> getBalancesObservable();

    public abstract float getCryptoPercentage(String str);

    public abstract boolean getHasFiatRepresentation();

    public abstract h.c.s<String> getInterestInfoObservable();

    public abstract h.c.s<String> getMaxSendAmountObservable();

    public abstract h.c.s<ViewModelNavRoute> getNavigateObservable();

    public abstract h.c.s<String> getRestoredAmountObservable();

    public abstract AmountPickerSettings getSettings();

    public abstract h.c.s<Boolean> getSliderStateObservable();

    public abstract Wallet getWallet();

    public abstract h.c.s<Boolean> isBalanceSufficientObservable();

    public abstract boolean isFiatSelected();

    public abstract boolean isInterestDescriptionVisible();

    public abstract h.c.s<Boolean> isNextButtonHiddenObservable();

    public abstract h.c.b0<Wallet> loadWallet();

    public abstract void nextAction(String str, Bundle bundle);

    public void onResume() {
    }

    public abstract void onSliderToggled();

    public abstract void restoreCachedCryptoAmount();

    public abstract void setFiatSelected(boolean z);

    public abstract void setWallet(Wallet wallet);

    public abstract void updateMaxSendAmount();

    public void updateSendAmount(String rawCryptoAmount, Boolean bool) {
        kotlin.jvm.internal.m.g(rawCryptoAmount, "rawCryptoAmount");
        this.store.set(StoreKeys_SendKt.getCachedCryptoAmount(StoreKeys.INSTANCE), rawCryptoAmount);
    }
}