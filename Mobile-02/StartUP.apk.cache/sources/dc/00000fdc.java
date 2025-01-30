package com.coinbase.ciphercore;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: types.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001d\u0010\nR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001e\u0010\nR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b\r\u0010\u0004¨\u0006\""}, d2 = {"Lcom/coinbase/ciphercore/SerializedEthereumTransactionReceipt;", "", "", "component1", "()Z", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "component4", "component5", "isSuccessful", "blockNumber", "blockHash", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "gasUsed", "copy", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/ciphercore/SerializedEthereumTransactionReceipt;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGasUsed", "I", "getBlockNumber", "getBlockHash", "getContractAddress", "Z", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SerializedEthereumTransactionReceipt {
    @Json(name = "blockHash")
    private final String blockHash;
    @Json(name = "blockNumber")
    private final int blockNumber;
    @Json(name = RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS)
    private final String contractAddress;
    @Json(name = "gasUsed")
    private final String gasUsed;
    @Json(name = "isSuccessful")
    private final boolean isSuccessful;

    public SerializedEthereumTransactionReceipt(boolean z, int i2, String blockHash, String str, String gasUsed) {
        kotlin.jvm.internal.m.g(blockHash, "blockHash");
        kotlin.jvm.internal.m.g(gasUsed, "gasUsed");
        this.isSuccessful = z;
        this.blockNumber = i2;
        this.blockHash = blockHash;
        this.contractAddress = str;
        this.gasUsed = gasUsed;
    }

    public static /* synthetic */ SerializedEthereumTransactionReceipt copy$default(SerializedEthereumTransactionReceipt serializedEthereumTransactionReceipt, boolean z, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = serializedEthereumTransactionReceipt.isSuccessful;
        }
        if ((i3 & 2) != 0) {
            i2 = serializedEthereumTransactionReceipt.blockNumber;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = serializedEthereumTransactionReceipt.blockHash;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = serializedEthereumTransactionReceipt.contractAddress;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = serializedEthereumTransactionReceipt.gasUsed;
        }
        return serializedEthereumTransactionReceipt.copy(z, i4, str4, str5, str3);
    }

    public final boolean component1() {
        return this.isSuccessful;
    }

    public final int component2() {
        return this.blockNumber;
    }

    public final String component3() {
        return this.blockHash;
    }

    public final String component4() {
        return this.contractAddress;
    }

    public final String component5() {
        return this.gasUsed;
    }

    public final SerializedEthereumTransactionReceipt copy(boolean z, int i2, String blockHash, String str, String gasUsed) {
        kotlin.jvm.internal.m.g(blockHash, "blockHash");
        kotlin.jvm.internal.m.g(gasUsed, "gasUsed");
        return new SerializedEthereumTransactionReceipt(z, i2, blockHash, str, gasUsed);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerializedEthereumTransactionReceipt) {
            SerializedEthereumTransactionReceipt serializedEthereumTransactionReceipt = (SerializedEthereumTransactionReceipt) obj;
            return this.isSuccessful == serializedEthereumTransactionReceipt.isSuccessful && this.blockNumber == serializedEthereumTransactionReceipt.blockNumber && kotlin.jvm.internal.m.c(this.blockHash, serializedEthereumTransactionReceipt.blockHash) && kotlin.jvm.internal.m.c(this.contractAddress, serializedEthereumTransactionReceipt.contractAddress) && kotlin.jvm.internal.m.c(this.gasUsed, serializedEthereumTransactionReceipt.gasUsed);
        }
        return false;
    }

    public final String getBlockHash() {
        return this.blockHash;
    }

    public final int getBlockNumber() {
        return this.blockNumber;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final String getGasUsed() {
        return this.gasUsed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z = this.isSuccessful;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((r0 * 31) + this.blockNumber) * 31) + this.blockHash.hashCode()) * 31;
        String str = this.contractAddress;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.gasUsed.hashCode();
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    public String toString() {
        return "SerializedEthereumTransactionReceipt(isSuccessful=" + this.isSuccessful + ", blockNumber=" + this.blockNumber + ", blockHash=" + this.blockHash + ", contractAddress=" + ((Object) this.contractAddress) + ", gasUsed=" + this.gasUsed + ')';
    }
}