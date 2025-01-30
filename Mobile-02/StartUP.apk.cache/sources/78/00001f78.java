package com.coinbase.wallet.features.send.di;

import androidx.lifecycle.b0;
import com.coinbase.wallet.features.lend.viewmodels.LendAmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendCompleteViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendConfirmationViewModel;
import kotlin.Metadata;

/* compiled from: SendModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H!¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H!¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH!¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH!¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H!¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/features/send/di/SendModule;", "", "Lcom/coinbase/wallet/features/send/viewmodels/SendCompleteViewModel;", "sendCompleteViewModel", "Landroidx/lifecycle/b0;", "sendCompleteViewModel$app_productionRelease", "(Lcom/coinbase/wallet/features/send/viewmodels/SendCompleteViewModel;)Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/send/viewmodels/LendConfirmationViewModel;", "lendConfirmationViewModel", "lendConfirmationViewModel$app_productionRelease", "(Lcom/coinbase/wallet/features/send/viewmodels/LendConfirmationViewModel;)Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/send/viewmodels/SendConfirmationViewModel;", "sendConfirmationViewModel", "sendConfirmationViewModel$app_productionRelease", "(Lcom/coinbase/wallet/features/send/viewmodels/SendConfirmationViewModel;)Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/lend/viewmodels/LendAmountPickerViewModel;", "lendAmountPickerViewModel", "lendAmountPickerViewModel$app_productionRelease", "(Lcom/coinbase/wallet/features/lend/viewmodels/LendAmountPickerViewModel;)Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/send/viewmodels/SendAmountPickerViewModel;", "sendAmountPickerViewModel", "sendAmountPickerViewModel$app_productionRelease", "(Lcom/coinbase/wallet/features/send/viewmodels/SendAmountPickerViewModel;)Landroidx/lifecycle/b0;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SendModule {
    public abstract b0 lendAmountPickerViewModel$app_productionRelease(LendAmountPickerViewModel lendAmountPickerViewModel);

    public abstract b0 lendConfirmationViewModel$app_productionRelease(LendConfirmationViewModel lendConfirmationViewModel);

    public abstract b0 sendAmountPickerViewModel$app_productionRelease(SendAmountPickerViewModel sendAmountPickerViewModel);

    public abstract b0 sendCompleteViewModel$app_productionRelease(SendCompleteViewModel sendCompleteViewModel);

    public abstract b0 sendConfirmationViewModel$app_productionRelease(SendConfirmationViewModel sendConfirmationViewModel);
}