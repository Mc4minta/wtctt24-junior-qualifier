package com.coinbase.cipherwebview.models;

import android.webkit.HttpAuthHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AuthenticationChallenge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/coinbase/cipherwebview/models/AuthenticationChallenge;", "", "", "component1", "()Ljava/lang/String;", "component2", "Landroid/webkit/HttpAuthHandler;", "component3", "()Landroid/webkit/HttpAuthHandler;", "host", "realm", "handler", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/webkit/HttpAuthHandler;)Lcom/coinbase/cipherwebview/models/AuthenticationChallenge;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHost", "getRealm", "Landroid/webkit/HttpAuthHandler;", "getHandler", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/webkit/HttpAuthHandler;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AuthenticationChallenge {
    private final HttpAuthHandler handler;
    private final String host;
    private final String realm;

    public AuthenticationChallenge(String host, String str, HttpAuthHandler handler) {
        m.g(host, "host");
        m.g(handler, "handler");
        this.host = host;
        this.realm = str;
        this.handler = handler;
    }

    public static /* synthetic */ AuthenticationChallenge copy$default(AuthenticationChallenge authenticationChallenge, String str, String str2, HttpAuthHandler httpAuthHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = authenticationChallenge.host;
        }
        if ((i2 & 2) != 0) {
            str2 = authenticationChallenge.realm;
        }
        if ((i2 & 4) != 0) {
            httpAuthHandler = authenticationChallenge.handler;
        }
        return authenticationChallenge.copy(str, str2, httpAuthHandler);
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.realm;
    }

    public final HttpAuthHandler component3() {
        return this.handler;
    }

    public final AuthenticationChallenge copy(String host, String str, HttpAuthHandler handler) {
        m.g(host, "host");
        m.g(handler, "handler");
        return new AuthenticationChallenge(host, str, handler);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthenticationChallenge) {
            AuthenticationChallenge authenticationChallenge = (AuthenticationChallenge) obj;
            return m.c(this.host, authenticationChallenge.host) && m.c(this.realm, authenticationChallenge.realm) && m.c(this.handler, authenticationChallenge.handler);
        }
        return false;
    }

    public final HttpAuthHandler getHandler() {
        return this.handler;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getRealm() {
        return this.realm;
    }

    public int hashCode() {
        int hashCode = this.host.hashCode() * 31;
        String str = this.realm;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.handler.hashCode();
    }

    public String toString() {
        return "AuthenticationChallenge(host=" + this.host + ", realm=" + ((Object) this.realm) + ", handler=" + this.handler + ')';
    }
}