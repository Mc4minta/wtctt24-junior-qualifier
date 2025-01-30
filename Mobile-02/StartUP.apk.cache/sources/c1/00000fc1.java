package com.coinbase.ciphercore;

import kotlin.Metadata;

/* compiled from: types.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0003¨\u0006\u0015"}, d2 = {"Lcom/coinbase/ciphercore/EthereumJSONRPCRequestResult;", "", "component1", "()Ljava/lang/Object;", "value", "copy", "(Ljava/lang/Object;)Lcom/coinbase/ciphercore/EthereumJSONRPCRequestResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumJSONRPCRequestResult {
    private final Object value;

    public EthereumJSONRPCRequestResult(Object obj) {
        this.value = obj;
    }

    public static /* synthetic */ EthereumJSONRPCRequestResult copy$default(EthereumJSONRPCRequestResult ethereumJSONRPCRequestResult, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = ethereumJSONRPCRequestResult.value;
        }
        return ethereumJSONRPCRequestResult.copy(obj);
    }

    public final Object component1() {
        return this.value;
    }

    public final EthereumJSONRPCRequestResult copy(Object obj) {
        return new EthereumJSONRPCRequestResult(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EthereumJSONRPCRequestResult) && kotlin.jvm.internal.m.c(this.value, ((EthereumJSONRPCRequestResult) obj).value);
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "EthereumJSONRPCRequestResult(value=" + this.value + ')';
    }
}