package com.coinbase.wallet.features.lend.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.lending.models.LendToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: LendProviderPickerArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendProviderPickerArgs;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", LendProviderPickerArgs.lendWalletKey, "", "Lcom/coinbase/wallet/lending/models/LendToken;", LendProviderPickerArgs.lendTokensKey, "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/util/List;Lcom/coinbase/wallet/ethereum/models/ContractAction;)Landroid/os/Bundle;", "", "contractActionKey", "Ljava/lang/String;", "lendWalletKey", "lendTokensKey", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderPickerArgs {
    public static final LendProviderPickerArgs INSTANCE = new LendProviderPickerArgs();
    public static final String contractActionKey = "contractAction";
    public static final String lendTokensKey = "lendTokens";
    public static final String lendWalletKey = "lendWallet";

    private LendProviderPickerArgs() {
    }

    public final Bundle createArguments(Wallet lendWallet, List<LendToken> lendTokens, ContractAction contractAction) {
        m.g(lendWallet, "lendWallet");
        m.g(lendTokens, "lendTokens");
        m.g(contractAction, "contractAction");
        return b.a(u.a(lendWalletKey, lendWallet), u.a(lendTokensKey, lendTokens), u.a("contractAction", contractAction));
    }
}