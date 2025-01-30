package com.coinbase.wallet.lending.interfaces;

import com.coinbase.wallet.lending.models.LendToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/lending/interfaces/TokenResult;", "", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "tokens", "wasSuccessfulFetch", "copy", "(Ljava/util/List;Z)Lcom/coinbase/wallet/lending/interfaces/TokenResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getWasSuccessfulFetch", "Ljava/util/List;", "getTokens", "<init>", "(Ljava/util/List;Z)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TokenResult {
    private final List<LendToken> tokens;
    private final boolean wasSuccessfulFetch;

    public TokenResult(List<LendToken> tokens, boolean z) {
        m.g(tokens, "tokens");
        this.tokens = tokens;
        this.wasSuccessfulFetch = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TokenResult copy$default(TokenResult tokenResult, List list, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = tokenResult.tokens;
        }
        if ((i2 & 2) != 0) {
            z = tokenResult.wasSuccessfulFetch;
        }
        return tokenResult.copy(list, z);
    }

    public final List<LendToken> component1() {
        return this.tokens;
    }

    public final boolean component2() {
        return this.wasSuccessfulFetch;
    }

    public final TokenResult copy(List<LendToken> tokens, boolean z) {
        m.g(tokens, "tokens");
        return new TokenResult(tokens, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TokenResult) {
            TokenResult tokenResult = (TokenResult) obj;
            return m.c(this.tokens, tokenResult.tokens) && this.wasSuccessfulFetch == tokenResult.wasSuccessfulFetch;
        }
        return false;
    }

    public final List<LendToken> getTokens() {
        return this.tokens;
    }

    public final boolean getWasSuccessfulFetch() {
        return this.wasSuccessfulFetch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.tokens.hashCode() * 31;
        boolean z = this.wasSuccessfulFetch;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "TokenResult(tokens=" + this.tokens + ", wasSuccessfulFetch=" + this.wasSuccessfulFetch + ')';
    }
}