package com.coinbase.wallet.http.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: HTTPResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ6\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\t\u001a\u00028\u00002\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u0019\u0010\t\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/http/models/HTTPResponse;", "", "T", "component1", "()Ljava/lang/Object;", "", "", "component2", "()Ljava/util/Map;", "body", "headers", "copy", "(Ljava/lang/Object;Ljava/util/Map;)Lcom/coinbase/wallet/http/models/HTTPResponse;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getHeaders", "Ljava/lang/Object;", "getBody", "<init>", "(Ljava/lang/Object;Ljava/util/Map;)V", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HTTPResponse<T> {
    private final T body;
    private final Map<String, String> headers;

    public HTTPResponse(T body, Map<String, String> headers) {
        m.g(body, "body");
        m.g(headers, "headers");
        this.body = body;
        this.headers = headers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPResponse copy$default(HTTPResponse hTTPResponse, Object obj, Map map, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = hTTPResponse.body;
        }
        if ((i2 & 2) != 0) {
            map = hTTPResponse.headers;
        }
        return hTTPResponse.copy(obj, map);
    }

    public final T component1() {
        return this.body;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    public final HTTPResponse<T> copy(T body, Map<String, String> headers) {
        m.g(body, "body");
        m.g(headers, "headers");
        return new HTTPResponse<>(body, headers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HTTPResponse) {
            HTTPResponse hTTPResponse = (HTTPResponse) obj;
            return m.c(this.body, hTTPResponse.body) && m.c(this.headers, hTTPResponse.headers);
        }
        return false;
    }

    public final T getBody() {
        return this.body;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public int hashCode() {
        return (this.body.hashCode() * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "HTTPResponse(body=" + this.body + ", headers=" + this.headers + ')';
    }
}