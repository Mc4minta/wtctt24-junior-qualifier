package com.coinbase.cipherwebview.models;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: NavigationSSLError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/cipherwebview/models/NavigationSSLError;", "", "Landroid/net/http/SslError;", "component1", "()Landroid/net/http/SslError;", "Landroid/webkit/SslErrorHandler;", "component2", "()Landroid/webkit/SslErrorHandler;", "error", "handler", "copy", "(Landroid/net/http/SslError;Landroid/webkit/SslErrorHandler;)Lcom/coinbase/cipherwebview/models/NavigationSSLError;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/net/http/SslError;", "getError", "Landroid/webkit/SslErrorHandler;", "getHandler", "<init>", "(Landroid/net/http/SslError;Landroid/webkit/SslErrorHandler;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NavigationSSLError {
    private final SslError error;
    private final SslErrorHandler handler;

    public NavigationSSLError(SslError error, SslErrorHandler handler) {
        m.g(error, "error");
        m.g(handler, "handler");
        this.error = error;
        this.handler = handler;
    }

    public static /* synthetic */ NavigationSSLError copy$default(NavigationSSLError navigationSSLError, SslError sslError, SslErrorHandler sslErrorHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sslError = navigationSSLError.error;
        }
        if ((i2 & 2) != 0) {
            sslErrorHandler = navigationSSLError.handler;
        }
        return navigationSSLError.copy(sslError, sslErrorHandler);
    }

    public final SslError component1() {
        return this.error;
    }

    public final SslErrorHandler component2() {
        return this.handler;
    }

    public final NavigationSSLError copy(SslError error, SslErrorHandler handler) {
        m.g(error, "error");
        m.g(handler, "handler");
        return new NavigationSSLError(error, handler);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigationSSLError) {
            NavigationSSLError navigationSSLError = (NavigationSSLError) obj;
            return m.c(this.error, navigationSSLError.error) && m.c(this.handler, navigationSSLError.handler);
        }
        return false;
    }

    public final SslError getError() {
        return this.error;
    }

    public final SslErrorHandler getHandler() {
        return this.handler;
    }

    public int hashCode() {
        return (this.error.hashCode() * 31) + this.handler.hashCode();
    }

    public String toString() {
        return "NavigationSSLError(error=" + this.error + ", handler=" + this.handler + ')';
    }
}