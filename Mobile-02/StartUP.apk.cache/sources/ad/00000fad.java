package com.coinbase.ciphercore;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;

/* compiled from: CipherCoreBridge.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/coinbase/ciphercore/CallMessage;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/List;", "id", "method", "params", "copy", "(ILjava/lang/String;Ljava/util/List;)Lcom/coinbase/ciphercore/CallMessage;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getMethod", "Ljava/util/List;", "getParams", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CallMessage {
    @Json(name = "id")
    private final int id;
    @Json(name = "method")
    private final String method;
    @Json(name = "params")
    private final List<String> params;

    public CallMessage(int i2, String method, List<String> params) {
        kotlin.jvm.internal.m.g(method, "method");
        kotlin.jvm.internal.m.g(params, "params");
        this.id = i2;
        this.method = method;
        this.params = params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallMessage copy$default(CallMessage callMessage, int i2, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = callMessage.id;
        }
        if ((i3 & 2) != 0) {
            str = callMessage.method;
        }
        if ((i3 & 4) != 0) {
            list = callMessage.params;
        }
        return callMessage.copy(i2, str, list);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.method;
    }

    public final List<String> component3() {
        return this.params;
    }

    public final CallMessage copy(int i2, String method, List<String> params) {
        kotlin.jvm.internal.m.g(method, "method");
        kotlin.jvm.internal.m.g(params, "params");
        return new CallMessage(i2, method, params);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CallMessage) {
            CallMessage callMessage = (CallMessage) obj;
            return this.id == callMessage.id && kotlin.jvm.internal.m.c(this.method, callMessage.method) && kotlin.jvm.internal.m.c(this.params, callMessage.params);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMethod() {
        return this.method;
    }

    public final List<String> getParams() {
        return this.params;
    }

    public int hashCode() {
        return (((this.id * 31) + this.method.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "CallMessage(id=" + this.id + ", method=" + this.method + ", params=" + this.params + ')';
    }
}