package com.coinbase.wallet.features.lend.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.lending.models.LendToken;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: LendConfirmationArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendConfirmationArgs;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "Lcom/coinbase/wallet/lending/models/LendToken;", LendConfirmationArgs.lendTokenKey, "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "", LendConfirmationArgs.interestAbbreviatedKey, "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/ethereum/models/ContractAction;Ljava/lang/String;)Landroid/os/Bundle;", "lendTokenKey", "Ljava/lang/String;", "walletKey", "interestAbbreviatedKey", "contractActionKey", "amountKey", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendConfirmationArgs {
    public static final LendConfirmationArgs INSTANCE = new LendConfirmationArgs();
    public static final String amountKey = "amount";
    public static final String contractActionKey = "contractAction";
    public static final String interestAbbreviatedKey = "interestAbbreviated";
    public static final String lendTokenKey = "lendToken";
    public static final String walletKey = "wallet";

    private LendConfirmationArgs() {
    }

    public final Bundle createArguments(Wallet wallet, TransferValue amount, LendToken lendToken, ContractAction contractAction, String interestAbbreviated) {
        m.g(wallet, "wallet");
        m.g(amount, "amount");
        m.g(lendToken, "lendToken");
        m.g(contractAction, "contractAction");
        m.g(interestAbbreviated, "interestAbbreviated");
        return b.a(u.a("wallet", wallet), u.a("amount", amount), u.a(lendTokenKey, lendToken), u.a("contractAction", contractAction), u.a(interestAbbreviatedKey, interestAbbreviated));
    }
}