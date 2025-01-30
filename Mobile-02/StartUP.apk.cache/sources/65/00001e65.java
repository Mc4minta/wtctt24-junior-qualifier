package com.coinbase.wallet.features.lend.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.ethereum.models.ContractAction;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: LendCoinPickerArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendCoinPickerArgs;", "", "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/ethereum/models/ContractAction;)Landroid/os/Bundle;", "", "contractActionKey", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerArgs {
    public static final LendCoinPickerArgs INSTANCE = new LendCoinPickerArgs();
    public static final String contractActionKey = "contractAction";

    private LendCoinPickerArgs() {
    }

    public final Bundle createArguments(ContractAction contractAction) {
        m.g(contractAction, "contractAction");
        return b.a(u.a("contractAction", contractAction));
    }
}