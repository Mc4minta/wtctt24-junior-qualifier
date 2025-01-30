package com.coinbase.walletengine.services.resolver;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ResolverService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/coinbase/walletengine/services/resolver/ResolutionResult;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/walletengine/services/resolver/ResolveType;", "component2", "()Lcom/coinbase/walletengine/services/resolver/ResolveType;", "address", "resolveType", "copy", "(Ljava/lang/String;Lcom/coinbase/walletengine/services/resolver/ResolveType;)Lcom/coinbase/walletengine/services/resolver/ResolutionResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAddress", "Lcom/coinbase/walletengine/services/resolver/ResolveType;", "getResolveType", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletengine/services/resolver/ResolveType;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ResolutionResult {
    @Json(name = "address")
    private final String address;
    @Json(name = "resolveType")
    private final ResolveType resolveType;

    public ResolutionResult(String address, ResolveType resolveType) {
        m.g(address, "address");
        m.g(resolveType, "resolveType");
        this.address = address;
        this.resolveType = resolveType;
    }

    public static /* synthetic */ ResolutionResult copy$default(ResolutionResult resolutionResult, String str, ResolveType resolveType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resolutionResult.address;
        }
        if ((i2 & 2) != 0) {
            resolveType = resolutionResult.resolveType;
        }
        return resolutionResult.copy(str, resolveType);
    }

    public final String component1() {
        return this.address;
    }

    public final ResolveType component2() {
        return this.resolveType;
    }

    public final ResolutionResult copy(String address, ResolveType resolveType) {
        m.g(address, "address");
        m.g(resolveType, "resolveType");
        return new ResolutionResult(address, resolveType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolutionResult) {
            ResolutionResult resolutionResult = (ResolutionResult) obj;
            return m.c(this.address, resolutionResult.address) && this.resolveType == resolutionResult.resolveType;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final ResolveType getResolveType() {
        return this.resolveType;
    }

    public int hashCode() {
        return (this.address.hashCode() * 31) + this.resolveType.hashCode();
    }

    public String toString() {
        return "ResolutionResult(address=" + this.address + ", resolveType=" + this.resolveType + ')';
    }
}