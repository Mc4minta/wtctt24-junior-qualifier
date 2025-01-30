package com.coinbase.wallet.features.walletlink.models;

import com.coinbase.wallet.features.pushnotifications.interfaces.PushNotification;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: WalletLinkPushNotification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R%\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b#\u0010\u0004¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotification;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Ljava/net/URL;", "component4", "()Ljava/net/URL;", "channelId", WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.eventIdKey, WalletLinkPushNotification.serverUrlKey, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;)Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEventId", "Ljava/net/URL;", "getServerUrl", "getChannelId", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "getSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkPushNotification implements PushNotification {
    public static final Companion Companion = new Companion(null);
    public static final String eventIdKey = "eventId";
    public static final String serverUrlKey = "serverUrl";
    public static final String sessionIdKey = "sessionId";
    private final String channelId;
    private final Map<String, String> data;
    private final String eventId;
    private final URL serverUrl;
    private final String sessionId;

    /* compiled from: WalletLinkPushNotification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification$Companion;", "", "", "eventIdKey", "Ljava/lang/String;", "serverUrlKey", "sessionIdKey", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WalletLinkPushNotification(String channelId, String sessionId, String eventId, URL serverUrl) {
        Map<String, String> l2;
        m.g(channelId, "channelId");
        m.g(sessionId, "sessionId");
        m.g(eventId, "eventId");
        m.g(serverUrl, "serverUrl");
        this.channelId = channelId;
        this.sessionId = sessionId;
        this.eventId = eventId;
        this.serverUrl = serverUrl;
        l2 = m0.l(u.a(sessionIdKey, sessionId), u.a(eventIdKey, eventId), u.a(serverUrlKey, serverUrl.toString()));
        this.data = l2;
    }

    public static /* synthetic */ WalletLinkPushNotification copy$default(WalletLinkPushNotification walletLinkPushNotification, String str, String str2, String str3, URL url, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = walletLinkPushNotification.channelId;
        }
        if ((i2 & 2) != 0) {
            str2 = walletLinkPushNotification.sessionId;
        }
        if ((i2 & 4) != 0) {
            str3 = walletLinkPushNotification.eventId;
        }
        if ((i2 & 8) != 0) {
            url = walletLinkPushNotification.serverUrl;
        }
        return walletLinkPushNotification.copy(str, str2, str3, url);
    }

    public final String component1() {
        return this.channelId;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.eventId;
    }

    public final URL component4() {
        return this.serverUrl;
    }

    public final WalletLinkPushNotification copy(String channelId, String sessionId, String eventId, URL serverUrl) {
        m.g(channelId, "channelId");
        m.g(sessionId, "sessionId");
        m.g(eventId, "eventId");
        m.g(serverUrl, "serverUrl");
        return new WalletLinkPushNotification(channelId, sessionId, eventId, serverUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WalletLinkPushNotification) {
            WalletLinkPushNotification walletLinkPushNotification = (WalletLinkPushNotification) obj;
            return m.c(this.channelId, walletLinkPushNotification.channelId) && m.c(this.sessionId, walletLinkPushNotification.sessionId) && m.c(this.eventId, walletLinkPushNotification.eventId) && m.c(this.serverUrl, walletLinkPushNotification.serverUrl);
        }
        return false;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final URL getServerUrl() {
        return this.serverUrl;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (((((this.channelId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.eventId.hashCode()) * 31) + this.serverUrl.hashCode();
    }

    public String toString() {
        return "WalletLinkPushNotification(channelId=" + this.channelId + ", sessionId=" + this.sessionId + ", eventId=" + this.eventId + ", serverUrl=" + this.serverUrl + ')';
    }
}