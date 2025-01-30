package com.coinbase.wallet.common.models;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RPCResponse.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00018\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/common/models/RPCResponse;", "", "T", "component1", "()Ljava/lang/Object;", "result", "copy", "(Ljava/lang/Object;)Lcom/coinbase/wallet/common/models/RPCResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getResult", "<init>", "(Ljava/lang/Object;)V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RPCResponse<T> {
    private final T result;

    public RPCResponse(T t) {
        this.result = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RPCResponse copy$default(RPCResponse rPCResponse, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = rPCResponse.result;
        }
        return rPCResponse.copy(obj);
    }

    public final T component1() {
        return this.result;
    }

    public final RPCResponse<T> copy(T t) {
        return new RPCResponse<>(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RPCResponse) && m.c(this.result, ((RPCResponse) obj).result);
    }

    public final T getResult() {
        return this.result;
    }

    public int hashCode() {
        T t = this.result;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "RPCResponse(result=" + this.result + ')';
    }
}