package com.coinbase.walletengine.services.xrp;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: XRPService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/walletengine/services/xrp/AccountInfo;", "", "", "component1", "()Z", "component2", "disallowsIncomingXRP", "requiresDestinationTag", "copy", "(ZZ)Lcom/coinbase/walletengine/services/xrp/AccountInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getRequiresDestinationTag", "getDisallowsIncomingXRP", "<init>", "(ZZ)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AccountInfo {
    @Json(name = "disallowsIncomingXRP")
    private final boolean disallowsIncomingXRP;
    @Json(name = "requiresDestinationTag")
    private final boolean requiresDestinationTag;

    public AccountInfo(boolean z, boolean z2) {
        this.disallowsIncomingXRP = z;
        this.requiresDestinationTag = z2;
    }

    public static /* synthetic */ AccountInfo copy$default(AccountInfo accountInfo, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = accountInfo.disallowsIncomingXRP;
        }
        if ((i2 & 2) != 0) {
            z2 = accountInfo.requiresDestinationTag;
        }
        return accountInfo.copy(z, z2);
    }

    public final boolean component1() {
        return this.disallowsIncomingXRP;
    }

    public final boolean component2() {
        return this.requiresDestinationTag;
    }

    public final AccountInfo copy(boolean z, boolean z2) {
        return new AccountInfo(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountInfo) {
            AccountInfo accountInfo = (AccountInfo) obj;
            return this.disallowsIncomingXRP == accountInfo.disallowsIncomingXRP && this.requiresDestinationTag == accountInfo.requiresDestinationTag;
        }
        return false;
    }

    public final boolean getDisallowsIncomingXRP() {
        return this.disallowsIncomingXRP;
    }

    public final boolean getRequiresDestinationTag() {
        return this.requiresDestinationTag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.disallowsIncomingXRP;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z2 = this.requiresDestinationTag;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "AccountInfo(disallowsIncomingXRP=" + this.disallowsIncomingXRP + ", requiresDestinationTag=" + this.requiresDestinationTag + ')';
    }
}