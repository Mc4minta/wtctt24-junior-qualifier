package com.coinbase.cipherwebview.models;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.appsflyer.internal.referrer.Payload;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: NavigationHTTPError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/cipherwebview/models/NavigationHTTPError;", "", "Landroid/webkit/WebResourceRequest;", "component1", "()Landroid/webkit/WebResourceRequest;", "Landroid/webkit/WebResourceResponse;", "component2", "()Landroid/webkit/WebResourceResponse;", "request", Payload.RESPONSE, "copy", "(Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)Lcom/coinbase/cipherwebview/models/NavigationHTTPError;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/webkit/WebResourceRequest;", "getRequest", "Landroid/webkit/WebResourceResponse;", "getResponse", "<init>", "(Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NavigationHTTPError {
    private final WebResourceRequest request;
    private final WebResourceResponse response;

    public NavigationHTTPError(WebResourceRequest request, WebResourceResponse response) {
        m.g(request, "request");
        m.g(response, "response");
        this.request = request;
        this.response = response;
    }

    public static /* synthetic */ NavigationHTTPError copy$default(NavigationHTTPError navigationHTTPError, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            webResourceRequest = navigationHTTPError.request;
        }
        if ((i2 & 2) != 0) {
            webResourceResponse = navigationHTTPError.response;
        }
        return navigationHTTPError.copy(webResourceRequest, webResourceResponse);
    }

    public final WebResourceRequest component1() {
        return this.request;
    }

    public final WebResourceResponse component2() {
        return this.response;
    }

    public final NavigationHTTPError copy(WebResourceRequest request, WebResourceResponse response) {
        m.g(request, "request");
        m.g(response, "response");
        return new NavigationHTTPError(request, response);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigationHTTPError) {
            NavigationHTTPError navigationHTTPError = (NavigationHTTPError) obj;
            return m.c(this.request, navigationHTTPError.request) && m.c(this.response, navigationHTTPError.response);
        }
        return false;
    }

    public final WebResourceRequest getRequest() {
        return this.request;
    }

    public final WebResourceResponse getResponse() {
        return this.response;
    }

    public int hashCode() {
        return (this.request.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "NavigationHTTPError(request=" + this.request + ", response=" + this.response + ')';
    }
}