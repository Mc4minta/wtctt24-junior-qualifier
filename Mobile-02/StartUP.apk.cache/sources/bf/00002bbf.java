package com.coinbase.walletlink.dtos;

import com.coinbase.walletlink.models.RequestMethod;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Web3ResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0081\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n¨\u0006 "}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3Response;", "T", "", "Lcom/coinbase/walletlink/models/RequestMethod;", "component1", "()Lcom/coinbase/walletlink/models/RequestMethod;", "component2", "()Ljava/lang/Object;", "", "component3", "()Ljava/lang/String;", "method", "result", "errorMessage", "copy", "(Lcom/coinbase/walletlink/models/RequestMethod;Ljava/lang/Object;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/Web3Response;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getResult", "Lcom/coinbase/walletlink/models/RequestMethod;", "getMethod", "Ljava/lang/String;", "getErrorMessage", "<init>", "(Lcom/coinbase/walletlink/models/RequestMethod;Ljava/lang/Object;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3Response<T> {
    private final String errorMessage;
    private final RequestMethod method;
    private final T result;

    public Web3Response(RequestMethod method, T t, String str) {
        m.g(method, "method");
        this.method = method;
        this.result = t;
        this.errorMessage = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Web3Response copy$default(Web3Response web3Response, RequestMethod requestMethod, Object obj, String str, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            requestMethod = web3Response.method;
        }
        if ((i2 & 2) != 0) {
            obj = web3Response.result;
        }
        if ((i2 & 4) != 0) {
            str = web3Response.errorMessage;
        }
        return web3Response.copy(requestMethod, obj, str);
    }

    public final RequestMethod component1() {
        return this.method;
    }

    public final T component2() {
        return this.result;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final Web3Response<T> copy(RequestMethod method, T t, String str) {
        m.g(method, "method");
        return new Web3Response<>(method, t, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Web3Response) {
            Web3Response web3Response = (Web3Response) obj;
            return this.method == web3Response.method && m.c(this.result, web3Response.result) && m.c(this.errorMessage, web3Response.errorMessage);
        }
        return false;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final RequestMethod getMethod() {
        return this.method;
    }

    public final T getResult() {
        return this.result;
    }

    public int hashCode() {
        int hashCode = this.method.hashCode() * 31;
        T t = this.result;
        int hashCode2 = (hashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.errorMessage;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Web3Response(method=" + this.method + ", result=" + this.result + ", errorMessage=" + ((Object) this.errorMessage) + ')';
    }
}