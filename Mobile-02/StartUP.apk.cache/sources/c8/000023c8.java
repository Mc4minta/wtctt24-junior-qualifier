package com.coinbase.wallet.http.models;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: HTTPService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/http/models/HTTPService;", "", "Ljava/net/URL;", "component1", "()Ljava/net/URL;", "url", "copy", "(Ljava/net/URL;)Lcom/coinbase/wallet/http/models/HTTPService;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/net/URL;", "getUrl", "<init>", "(Ljava/net/URL;)V", "Companion", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HTTPService {
    public static final Companion Companion = new Companion(null);
    private final URL url;

    /* compiled from: HTTPService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/http/models/HTTPService$Companion;", "", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HTTPService(URL url) {
        m.g(url, "url");
        this.url = url;
    }

    public static /* synthetic */ HTTPService copy$default(HTTPService hTTPService, URL url, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            url = hTTPService.url;
        }
        return hTTPService.copy(url);
    }

    public final URL component1() {
        return this.url;
    }

    public final HTTPService copy(URL url) {
        m.g(url, "url");
        return new HTTPService(url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HTTPService) && m.c(this.url, ((HTTPService) obj).url);
    }

    public final URL getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "HTTPService(url=" + this.url + ')';
    }
}