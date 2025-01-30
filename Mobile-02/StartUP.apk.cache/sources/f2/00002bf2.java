package com.coinbase.walletlink.models;

import android.net.Uri;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.squareup.moshi.JsonClass;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.apache.http.cookie.ClientCookie;

/* compiled from: Session.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u0082\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b\u001d\u0010\fR\u0019\u0010*\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010\bR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b0\u0010\bR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b1\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b4\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/coinbase/walletlink/models/Session;", "", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/net/URL;", "component3", "()Ljava/net/URL;", "component4", "", "component5", "()Ljava/lang/Boolean;", "component6", "component7", "component8", "Landroid/net/Uri;", "component9", "()Landroid/net/Uri;", "component10", "id", "secret", "url", ClientCookie.VERSION_ATTR, "isParent", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "dappImageURL", "dappURL", "isApproved", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;Ljava/lang/Boolean;)Lcom/coinbase/walletlink/models/Session;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDappName", "Ljava/lang/Boolean;", "isAuthorized", "Z", "()Z", "Ljava/net/URL;", "getDappImageURL", "getSecret", "getUrl", "getId", "Landroid/net/Uri;", "getDappURL", "getVersion", "getParentSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;Ljava/lang/Boolean;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Session {
    private final URL dappImageURL;
    private final String dappName;
    private final Uri dappURL;
    private final String id;
    private final Boolean isApproved;
    private final boolean isAuthorized;
    private final Boolean isParent;
    private final String parentSessionId;
    private final String secret;
    private final URL url;
    private final String version;

    public Session(String id, String secret, URL url, String str, Boolean bool, String str2, String str3, URL url2, Uri uri, Boolean bool2) {
        m.g(id, "id");
        m.g(secret, "secret");
        m.g(url, "url");
        this.id = id;
        this.secret = secret;
        this.url = url;
        this.version = str;
        this.isParent = bool;
        this.parentSessionId = str2;
        this.dappName = str3;
        this.dappImageURL = url2;
        this.dappURL = uri;
        this.isApproved = bool2;
        this.isAuthorized = bool2 == null || m.c(bool2, Boolean.TRUE);
    }

    public final String component1() {
        return this.id;
    }

    public final Boolean component10() {
        return this.isApproved;
    }

    public final String component2() {
        return this.secret;
    }

    public final URL component3() {
        return this.url;
    }

    public final String component4() {
        return this.version;
    }

    public final Boolean component5() {
        return this.isParent;
    }

    public final String component6() {
        return this.parentSessionId;
    }

    public final String component7() {
        return this.dappName;
    }

    public final URL component8() {
        return this.dappImageURL;
    }

    public final Uri component9() {
        return this.dappURL;
    }

    public final Session copy(String id, String secret, URL url, String str, Boolean bool, String str2, String str3, URL url2, Uri uri, Boolean bool2) {
        m.g(id, "id");
        m.g(secret, "secret");
        m.g(url, "url");
        return new Session(id, secret, url, str, bool, str2, str3, url2, uri, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Session) {
            Session session = (Session) obj;
            return m.c(this.id, session.id) && m.c(this.secret, session.secret) && m.c(this.url, session.url) && m.c(this.version, session.version) && m.c(this.isParent, session.isParent) && m.c(this.parentSessionId, session.parentSessionId) && m.c(this.dappName, session.dappName) && m.c(this.dappImageURL, session.dappImageURL) && m.c(this.dappURL, session.dappURL) && m.c(this.isApproved, session.isApproved);
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

    public final String getId() {
        return this.id;
    }

    public final String getParentSessionId() {
        return this.parentSessionId;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final URL getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.secret.hashCode()) * 31) + this.url.hashCode()) * 31;
        String str = this.version;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isParent;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.parentSessionId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dappName;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        URL url = this.dappImageURL;
        int hashCode6 = (hashCode5 + (url == null ? 0 : url.hashCode())) * 31;
        Uri uri = this.dappURL;
        int hashCode7 = (hashCode6 + (uri == null ? 0 : uri.hashCode())) * 31;
        Boolean bool2 = this.isApproved;
        return hashCode7 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final Boolean isApproved() {
        return this.isApproved;
    }

    public final boolean isAuthorized() {
        return this.isAuthorized;
    }

    public final Boolean isParent() {
        return this.isParent;
    }

    public String toString() {
        return "Session(id=" + this.id + ", secret=" + this.secret + ", url=" + this.url + ", version=" + ((Object) this.version) + ", isParent=" + this.isParent + ", parentSessionId=" + ((Object) this.parentSessionId) + ", dappName=" + ((Object) this.dappName) + ", dappImageURL=" + this.dappImageURL + ", dappURL=" + this.dappURL + ", isApproved=" + this.isApproved + ')';
    }

    public /* synthetic */ Session(String str, String str2, URL url, String str3, Boolean bool, String str4, String str5, URL url2, Uri uri, Boolean bool2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, url, (i2 & 8) != 0 ? null : str3, bool, str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : url2, (i2 & 256) != 0 ? null : uri, (i2 & 512) != 0 ? null : bool2);
    }
}