package com.coinbase.wallet.features.wallets.extensions;

import com.coinbase.wallet.blockchains.models.Wallet;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Wallet+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "Ljava/math/BigInteger;", "maximumAvailableBalance", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)Ljava/math/BigInteger;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Wallet_ApplicationKt {
    public static final BigInteger maximumAvailableBalance(Wallet wallet) {
        m.g(wallet, "<this>");
        BigInteger balance = wallet.getBalance();
        BigInteger minimumBalance = wallet.getMinimumBalance();
        if (minimumBalance == null) {
            minimumBalance = BigInteger.ZERO;
        }
        m.f(minimumBalance, "minimumBalance ?: BigInteger.ZERO");
        BigInteger subtract = balance.subtract(minimumBalance);
        m.f(subtract, "this.subtract(other)");
        return subtract;
    }
}