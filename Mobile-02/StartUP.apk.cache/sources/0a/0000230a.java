package com.coinbase.wallet.features.walletlink.models;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WalletLinkSessionKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/models/WalletLinkSessionKey;", "", "", "component1", "()Ljava/lang/String;", "Ljava/net/URL;", "component2", "()Ljava/net/URL;", WalletLinkPushNotification.sessionIdKey, "url", "copy", "(Ljava/lang/String;Ljava/net/URL;)Lcom/coinbase/wallet/features/walletlink/models/WalletLinkSessionKey;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/net/URL;", "getUrl", "Ljava/lang/String;", "getSessionId", "<init>", "(Ljava/lang/String;Ljava/net/URL;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkSessionKey {
    private final String sessionId;
    private final URL url;

    public WalletLinkSessionKey(String sessionId, URL url) {
        m.g(sessionId, "sessionId");
        m.g(url, "url");
        this.sessionId = sessionId;
        this.url = url;
    }

    public static /* synthetic */ WalletLinkSessionKey copy$default(WalletLinkSessionKey walletLinkSessionKey, String str, URL url, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = walletLinkSessionKey.sessionId;
        }
        if ((i2 & 2) != 0) {
            url = walletLinkSessionKey.url;
        }
        return walletLinkSessionKey.copy(str, url);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final URL component2() {
        return this.url;
    }

    public final WalletLinkSessionKey copy(String sessionId, URL url) {
        m.g(sessionId, "sessionId");
        m.g(url, "url");
        return new WalletLinkSessionKey(sessionId, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WalletLinkSessionKey) {
            WalletLinkSessionKey walletLinkSessionKey = (WalletLinkSessionKey) obj;
            return m.c(this.sessionId, walletLinkSessionKey.sessionId) && m.c(this.url, walletLinkSessionKey.url);
        }
        return false;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final URL getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.sessionId.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "WalletLinkSessionKey(sessionId=" + this.sessionId + ", url=" + this.url + ')';
    }
}