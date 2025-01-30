package com.coinbase.walletlink.dtos;

import com.coinbase.walletlink.models.RequestMethod;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Web3RequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3Request;", "T", "", "Lcom/coinbase/walletlink/models/RequestMethod;", "component1", "()Lcom/coinbase/walletlink/models/RequestMethod;", "component2", "()Ljava/lang/Object;", "method", "params", "copy", "(Lcom/coinbase/walletlink/models/RequestMethod;Ljava/lang/Object;)Lcom/coinbase/walletlink/dtos/Web3Request;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getParams", "Lcom/coinbase/walletlink/models/RequestMethod;", "getMethod", "<init>", "(Lcom/coinbase/walletlink/models/RequestMethod;Ljava/lang/Object;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3Request<T> {
    private final RequestMethod method;
    private final T params;

    public Web3Request(RequestMethod method, T t) {
        m.g(method, "method");
        this.method = method;
        this.params = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Web3Request copy$default(Web3Request web3Request, RequestMethod requestMethod, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            requestMethod = web3Request.method;
        }
        if ((i2 & 2) != 0) {
            obj = web3Request.params;
        }
        return web3Request.copy(requestMethod, obj);
    }

    public final RequestMethod component1() {
        return this.method;
    }

    public final T component2() {
        return this.params;
    }

    public final Web3Request<T> copy(RequestMethod method, T t) {
        m.g(method, "method");
        return new Web3Request<>(method, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Web3Request) {
            Web3Request web3Request = (Web3Request) obj;
            return this.method == web3Request.method && m.c(this.params, web3Request.params);
        }
        return false;
    }

    public final RequestMethod getMethod() {
        return this.method;
    }

    public final T getParams() {
        return this.params;
    }

    public int hashCode() {
        int hashCode = this.method.hashCode() * 31;
        T t = this.params;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "Web3Request(method=" + this.method + ", params=" + this.params + ')';
    }
}