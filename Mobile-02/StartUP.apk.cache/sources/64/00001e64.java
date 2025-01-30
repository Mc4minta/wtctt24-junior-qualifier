package com.coinbase.wallet.features.lend.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.features.lend.viewmodels.LendAmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import com.coinbase.wallet.lending.models.LendToken;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: LendAmountPickerArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendAmountPickerArgs;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", LendProviderPickerArgs.lendWalletKey, "Lcom/coinbase/wallet/lending/models/LendToken;", LendConfirmationArgs.lendTokenKey, "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/ethereum/models/ContractAction;)Landroid/os/Bundle;", "", "contractActionKey", "Ljava/lang/String;", LendAmountPickerArgs.sliderVisibleKey, "lendTokenKey", "lendWalletKey", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendAmountPickerArgs {
    public static final LendAmountPickerArgs INSTANCE = new LendAmountPickerArgs();
    public static final String contractActionKey = "contractAction";
    public static final String lendTokenKey = "selectedToken";
    public static final String lendWalletKey = "selectedWallet";
    public static final String sliderVisibleKey = "sliderVisibleKey";

    private LendAmountPickerArgs() {
    }

    public final Bundle createArguments(Wallet lendWallet, LendToken lendToken, ContractAction contractAction) {
        m.g(lendWallet, "lendWallet");
        m.g(lendToken, "lendToken");
        m.g(contractAction, "contractAction");
        return b.a(u.a(lendWalletKey, lendWallet), u.a(lendTokenKey, lendToken), u.a("contractAction", contractAction), u.a(AmountPickerViewModel.class.getName(), LendAmountPickerViewModel.class));
    }
}