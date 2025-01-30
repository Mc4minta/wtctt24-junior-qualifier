package com.coinbase.wallet.features.send.models;

import android.os.Bundle;
import com.coinbase.wallet.blockchains.models.Wallet;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SendCompleteArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00068\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00068\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendCompleteArgs;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Ljava/math/BigInteger;", "amount", "", "recipient", "Landroid/os/Bundle;", "createArgs", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/math/BigInteger;Ljava/lang/String;)Landroid/os/Bundle;", "AMOUNT", "Ljava/lang/String;", "WALLET", "RECIPIENT", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendCompleteArgs {
    public static final String AMOUNT = "amount";
    public static final SendCompleteArgs INSTANCE = new SendCompleteArgs();
    public static final String RECIPIENT = "recipient";
    public static final String WALLET = "wallet";

    private SendCompleteArgs() {
    }

    public final Bundle createArgs(Wallet wallet, BigInteger amount, String recipient) {
        m.g(wallet, "wallet");
        m.g(amount, "amount");
        m.g(recipient, "recipient");
        Bundle bundle = new Bundle();
        bundle.putParcelable("wallet", wallet);
        bundle.putString("amount", amount.toString());
        bundle.putString("recipient", recipient);
        return bundle;
    }
}