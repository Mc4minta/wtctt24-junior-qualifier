package com.coinbase.wallet.compoundfinance.models;

import com.coinbase.ApiConstants;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CompoundExchangeRateResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/compoundfinance/models/CompoundExchangeRateResult;", "", "Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;", "component1", "()Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;", "Ljava/math/BigInteger;", "component2", "()Ljava/math/BigInteger;", ApiConstants.TOKEN, "rate", "copy", "(Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;Ljava/math/BigInteger;)Lcom/coinbase/wallet/compoundfinance/models/CompoundExchangeRateResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;", "getToken", "Ljava/math/BigInteger;", "getRate", "<init>", "(Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;Ljava/math/BigInteger;)V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompoundExchangeRateResult {
    private final BigInteger rate;
    private final CompoundToken token;

    public CompoundExchangeRateResult(CompoundToken token, BigInteger rate) {
        m.g(token, "token");
        m.g(rate, "rate");
        this.token = token;
        this.rate = rate;
    }

    public static /* synthetic */ CompoundExchangeRateResult copy$default(CompoundExchangeRateResult compoundExchangeRateResult, CompoundToken compoundToken, BigInteger bigInteger, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            compoundToken = compoundExchangeRateResult.token;
        }
        if ((i2 & 2) != 0) {
            bigInteger = compoundExchangeRateResult.rate;
        }
        return compoundExchangeRateResult.copy(compoundToken, bigInteger);
    }

    public final CompoundToken component1() {
        return this.token;
    }

    public final BigInteger component2() {
        return this.rate;
    }

    public final CompoundExchangeRateResult copy(CompoundToken token, BigInteger rate) {
        m.g(token, "token");
        m.g(rate, "rate");
        return new CompoundExchangeRateResult(token, rate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompoundExchangeRateResult) {
            CompoundExchangeRateResult compoundExchangeRateResult = (CompoundExchangeRateResult) obj;
            return m.c(this.token, compoundExchangeRateResult.token) && m.c(this.rate, compoundExchangeRateResult.rate);
        }
        return false;
    }

    public final BigInteger getRate() {
        return this.rate;
    }

    public final CompoundToken getToken() {
        return this.token;
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.rate.hashCode();
    }

    public String toString() {
        return "CompoundExchangeRateResult(token=" + this.token + ", rate=" + this.rate + ')';
    }
}