package com.coinbase.walletlink.dtos;

import android.net.Uri;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Web3RequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JD\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/walletlink/dtos/ChildRequestEthereumAccountsParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "Landroid/net/Uri;", "component3", "()Landroid/net/Uri;", "component4", "component5", WalletLinkPushNotification.sessionIdKey, "sessionSecret", "appURL", "appName", "appLogoURL", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/ChildRequestEthereumAccountsParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAppLogoURL", "Landroid/net/Uri;", "getAppURL", "getSessionId", "getSessionSecret", "getAppName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ChildRequestEthereumAccountsParams {
    private final String appLogoURL;
    private final String appName;
    private final Uri appURL;
    private final String sessionId;
    private final String sessionSecret;

    public ChildRequestEthereumAccountsParams(String sessionId, String sessionSecret, Uri appURL, String appName, String str) {
        m.g(sessionId, "sessionId");
        m.g(sessionSecret, "sessionSecret");
        m.g(appURL, "appURL");
        m.g(appName, "appName");
        this.sessionId = sessionId;
        this.sessionSecret = sessionSecret;
        this.appURL = appURL;
        this.appName = appName;
        this.appLogoURL = str;
    }

    public static /* synthetic */ ChildRequestEthereumAccountsParams copy$default(ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams, String str, String str2, Uri uri, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = childRequestEthereumAccountsParams.sessionId;
        }
        if ((i2 & 2) != 0) {
            str2 = childRequestEthereumAccountsParams.sessionSecret;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            uri = childRequestEthereumAccountsParams.appURL;
        }
        Uri uri2 = uri;
        if ((i2 & 8) != 0) {
            str3 = childRequestEthereumAccountsParams.appName;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = childRequestEthereumAccountsParams.appLogoURL;
        }
        return childRequestEthereumAccountsParams.copy(str, str5, uri2, str6, str4);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.sessionSecret;
    }

    public final Uri component3() {
        return this.appURL;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.appLogoURL;
    }

    public final ChildRequestEthereumAccountsParams copy(String sessionId, String sessionSecret, Uri appURL, String appName, String str) {
        m.g(sessionId, "sessionId");
        m.g(sessionSecret, "sessionSecret");
        m.g(appURL, "appURL");
        m.g(appName, "appName");
        return new ChildRequestEthereumAccountsParams(sessionId, sessionSecret, appURL, appName, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChildRequestEthereumAccountsParams) {
            ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams = (ChildRequestEthereumAccountsParams) obj;
            return m.c(this.sessionId, childRequestEthereumAccountsParams.sessionId) && m.c(this.sessionSecret, childRequestEthereumAccountsParams.sessionSecret) && m.c(this.appURL, childRequestEthereumAccountsParams.appURL) && m.c(this.appName, childRequestEthereumAccountsParams.appName) && m.c(this.appLogoURL, childRequestEthereumAccountsParams.appLogoURL);
        }
        return false;
    }

    public final String getAppLogoURL() {
        return this.appLogoURL;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Uri getAppURL() {
        return this.appURL;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionSecret() {
        return this.sessionSecret;
    }

    public int hashCode() {
        int hashCode = ((((((this.sessionId.hashCode() * 31) + this.sessionSecret.hashCode()) * 31) + this.appURL.hashCode()) * 31) + this.appName.hashCode()) * 31;
        String str = this.appLogoURL;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ChildRequestEthereumAccountsParams(sessionId=" + this.sessionId + ", sessionSecret=" + this.sessionSecret + ", appURL=" + this.appURL + ", appName=" + this.appName + ", appLogoURL=" + ((Object) this.appLogoURL) + ')';
    }
}