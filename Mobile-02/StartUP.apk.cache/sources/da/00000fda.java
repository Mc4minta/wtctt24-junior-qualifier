package com.coinbase.ciphercore;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: types.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/ciphercore/SerializedERC20TransferParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "toAddress", "data", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/ciphercore/SerializedERC20TransferParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getData", "getToAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SerializedERC20TransferParams {
    @Json(name = "data")
    private final String data;
    @Json(name = "toAddress")
    private final String toAddress;

    public SerializedERC20TransferParams(String toAddress, String data) {
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        kotlin.jvm.internal.m.g(data, "data");
        this.toAddress = toAddress;
        this.data = data;
    }

    public static /* synthetic */ SerializedERC20TransferParams copy$default(SerializedERC20TransferParams serializedERC20TransferParams, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = serializedERC20TransferParams.toAddress;
        }
        if ((i2 & 2) != 0) {
            str2 = serializedERC20TransferParams.data;
        }
        return serializedERC20TransferParams.copy(str, str2);
    }

    public final String component1() {
        return this.toAddress;
    }

    public final String component2() {
        return this.data;
    }

    public final SerializedERC20TransferParams copy(String toAddress, String data) {
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        kotlin.jvm.internal.m.g(data, "data");
        return new SerializedERC20TransferParams(toAddress, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerializedERC20TransferParams) {
            SerializedERC20TransferParams serializedERC20TransferParams = (SerializedERC20TransferParams) obj;
            return kotlin.jvm.internal.m.c(this.toAddress, serializedERC20TransferParams.toAddress) && kotlin.jvm.internal.m.c(this.data, serializedERC20TransferParams.data);
        }
        return false;
    }

    public final String getData() {
        return this.data;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    public int hashCode() {
        return (this.toAddress.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "SerializedERC20TransferParams(toAddress=" + this.toAddress + ", data=" + this.data + ')';
    }
}