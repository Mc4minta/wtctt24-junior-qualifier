package com.coinbase.walletlink.models;

import android.net.Uri;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: HostRequestId.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BM\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b6\u00107J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u0013HÀ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jd\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b!\u0010\bJ\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010\bR\u001c\u0010\u001e\u001a\u00020\u00138\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b,\u0010\bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b.\u0010\rR\u0019\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u0010\u0010R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b1\u0010\bR\u0019\u0010\u0018\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b2\u0010\bR\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b3\u0010\rR\u0013\u00104\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequestId;", "", "cancellableRequestId", "", "canCancel", "(Lcom/coinbase/walletlink/models/HostRequestId;)Z", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Ljava/net/URL;", "component4", "()Ljava/net/URL;", "Landroid/net/Uri;", "component5", "()Landroid/net/Uri;", "component6", "component7", "Lcom/coinbase/walletlink/models/RequestMethod;", "component8$walletlink_release", "()Lcom/coinbase/walletlink/models/RequestMethod;", "component8", "id", WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.eventIdKey, "url", "dappURL", "dappImageURL", WalletLinkCompleteArgs.DAPP_NAME, "method", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;Ljava/net/URL;Ljava/lang/String;Lcom/coinbase/walletlink/models/RequestMethod;)Lcom/coinbase/walletlink/models/HostRequestId;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lcom/coinbase/walletlink/models/RequestMethod;", "getMethod$walletlink_release", "getEventId", "Ljava/net/URL;", "getDappImageURL", "Landroid/net/Uri;", "getDappURL", "getDappName", "getSessionId", "getUrl", "isCancelation", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;Ljava/net/URL;Ljava/lang/String;Lcom/coinbase/walletlink/models/RequestMethod;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class HostRequestId {
    private final URL dappImageURL;
    private final String dappName;
    private final Uri dappURL;
    private final String eventId;
    private final String id;
    private final RequestMethod method;
    private final String sessionId;
    private final URL url;

    public HostRequestId(String id, String sessionId, String eventId, URL url, Uri dappURL, URL url2, String str, RequestMethod method) {
        m.g(id, "id");
        m.g(sessionId, "sessionId");
        m.g(eventId, "eventId");
        m.g(url, "url");
        m.g(dappURL, "dappURL");
        m.g(method, "method");
        this.id = id;
        this.sessionId = sessionId;
        this.eventId = eventId;
        this.url = url;
        this.dappURL = dappURL;
        this.dappImageURL = url2;
        this.dappName = str;
        this.method = method;
    }

    public final boolean canCancel(HostRequestId cancellableRequestId) {
        m.g(cancellableRequestId, "cancellableRequestId");
        return isCancelation() && !cancellableRequestId.isCancelation() && m.c(this.dappURL, cancellableRequestId.dappURL) && m.c(this.id, cancellableRequestId.id) && m.c(this.url, cancellableRequestId.url) && m.c(this.sessionId, cancellableRequestId.sessionId);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.eventId;
    }

    public final URL component4() {
        return this.url;
    }

    public final Uri component5() {
        return this.dappURL;
    }

    public final URL component6() {
        return this.dappImageURL;
    }

    public final String component7() {
        return this.dappName;
    }

    public final RequestMethod component8$walletlink_release() {
        return this.method;
    }

    public final HostRequestId copy(String id, String sessionId, String eventId, URL url, Uri dappURL, URL url2, String str, RequestMethod method) {
        m.g(id, "id");
        m.g(sessionId, "sessionId");
        m.g(eventId, "eventId");
        m.g(url, "url");
        m.g(dappURL, "dappURL");
        m.g(method, "method");
        return new HostRequestId(id, sessionId, eventId, url, dappURL, url2, str, method);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostRequestId) {
            HostRequestId hostRequestId = (HostRequestId) obj;
            return m.c(this.id, hostRequestId.id) && m.c(this.sessionId, hostRequestId.sessionId) && m.c(this.eventId, hostRequestId.eventId) && m.c(this.url, hostRequestId.url) && m.c(this.dappURL, hostRequestId.dappURL) && m.c(this.dappImageURL, hostRequestId.dappImageURL) && m.c(this.dappName, hostRequestId.dappName) && this.method == hostRequestId.method;
        }
        return false;
    }

    public final URL getDappImageURL() {
        return this.dappImageURL;
    }

    public final String getDappName() {
        return this.dappName;
    }

    public final Uri getDappURL() {
        return this.dappURL;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getId() {
        return this.id;
    }

    public final RequestMethod getMethod$walletlink_release() {
        return this.method;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final URL getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((((((((this.id.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.eventId.hashCode()) * 31) + this.url.hashCode()) * 31) + this.dappURL.hashCode()) * 31;
        URL url = this.dappImageURL;
        int hashCode2 = (hashCode + (url == null ? 0 : url.hashCode())) * 31;
        String str = this.dappName;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.method.hashCode();
    }

    public final boolean isCancelation() {
        return this.method == RequestMethod.RequestCanceled;
    }

    public String toString() {
        return "HostRequestId(id=" + this.id + ", sessionId=" + this.sessionId + ", eventId=" + this.eventId + ", url=" + this.url + ", dappURL=" + this.dappURL + ", dappImageURL=" + this.dappImageURL + ", dappName=" + ((Object) this.dappName) + ", method=" + this.method + ')';
    }
}