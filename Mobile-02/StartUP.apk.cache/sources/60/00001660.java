package com.coinbase.wallet.consumer.models;

import com.coinbase.android.apiv3.generated.authed.b;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAuthToken.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAuthToken;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "component4", "component5", "accessToken", "tokenType", "expiresIn", "refreshToken", "scope", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerAuthToken;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRefreshToken", "J", "getExpiresIn", "getScope", "getTokenType", "getAccessToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAuthToken {
    private final String accessToken;
    private final long expiresIn;
    private final String refreshToken;
    private final String scope;
    private final String tokenType;

    public ConsumerAuthToken(String accessToken, String tokenType, long j2, String refreshToken, String scope) {
        m.g(accessToken, "accessToken");
        m.g(tokenType, "tokenType");
        m.g(refreshToken, "refreshToken");
        m.g(scope, "scope");
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = j2;
        this.refreshToken = refreshToken;
        this.scope = scope;
    }

    public static /* synthetic */ ConsumerAuthToken copy$default(ConsumerAuthToken consumerAuthToken, String str, String str2, long j2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerAuthToken.accessToken;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerAuthToken.tokenType;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            j2 = consumerAuthToken.expiresIn;
        }
        long j3 = j2;
        if ((i2 & 8) != 0) {
            str3 = consumerAuthToken.refreshToken;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = consumerAuthToken.scope;
        }
        return consumerAuthToken.copy(str, str5, j3, str6, str4);
    }

    public final String component1() {
        return this.accessToken;
    }

    public final String component2() {
        return this.tokenType;
    }

    public final long component3() {
        return this.expiresIn;
    }

    public final String component4() {
        return this.refreshToken;
    }

    public final String component5() {
        return this.scope;
    }

    public final ConsumerAuthToken copy(String accessToken, String tokenType, long j2, String refreshToken, String scope) {
        m.g(accessToken, "accessToken");
        m.g(tokenType, "tokenType");
        m.g(refreshToken, "refreshToken");
        m.g(scope, "scope");
        return new ConsumerAuthToken(accessToken, tokenType, j2, refreshToken, scope);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAuthToken) {
            ConsumerAuthToken consumerAuthToken = (ConsumerAuthToken) obj;
            return m.c(this.accessToken, consumerAuthToken.accessToken) && m.c(this.tokenType, consumerAuthToken.tokenType) && this.expiresIn == consumerAuthToken.expiresIn && m.c(this.refreshToken, consumerAuthToken.refreshToken) && m.c(this.scope, consumerAuthToken.scope);
        }
        return false;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        return (((((((this.accessToken.hashCode() * 31) + this.tokenType.hashCode()) * 31) + b.a(this.expiresIn)) * 31) + this.refreshToken.hashCode()) * 31) + this.scope.hashCode();
    }

    public String toString() {
        return "ConsumerAuthToken(accessToken=" + this.accessToken + ", tokenType=" + this.tokenType + ", expiresIn=" + this.expiresIn + ", refreshToken=" + this.refreshToken + ", scope=" + this.scope + ')';
    }
}