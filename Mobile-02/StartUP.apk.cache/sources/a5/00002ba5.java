package com.coinbase.walletlink.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Web3RequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/walletlink/dtos/RequestEthereumAccountsParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "appName", "appLogoUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/RequestEthereumAccountsParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAppName", "getAppLogoUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RequestEthereumAccountsParams {
    private final String appLogoUrl;
    private final String appName;

    public RequestEthereumAccountsParams(String appName, String str) {
        m.g(appName, "appName");
        this.appName = appName;
        this.appLogoUrl = str;
    }

    public static /* synthetic */ RequestEthereumAccountsParams copy$default(RequestEthereumAccountsParams requestEthereumAccountsParams, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = requestEthereumAccountsParams.appName;
        }
        if ((i2 & 2) != 0) {
            str2 = requestEthereumAccountsParams.appLogoUrl;
        }
        return requestEthereumAccountsParams.copy(str, str2);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.appLogoUrl;
    }

    public final RequestEthereumAccountsParams copy(String appName, String str) {
        m.g(appName, "appName");
        return new RequestEthereumAccountsParams(appName, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RequestEthereumAccountsParams) {
            RequestEthereumAccountsParams requestEthereumAccountsParams = (RequestEthereumAccountsParams) obj;
            return m.c(this.appName, requestEthereumAccountsParams.appName) && m.c(this.appLogoUrl, requestEthereumAccountsParams.appLogoUrl);
        }
        return false;
    }

    public final String getAppLogoUrl() {
        return this.appLogoUrl;
    }

    public final String getAppName() {
        return this.appName;
    }

    public int hashCode() {
        int hashCode = this.appName.hashCode() * 31;
        String str = this.appLogoUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RequestEthereumAccountsParams(appName=" + this.appName + ", appLogoUrl=" + ((Object) this.appLogoUrl) + ')';
    }
}