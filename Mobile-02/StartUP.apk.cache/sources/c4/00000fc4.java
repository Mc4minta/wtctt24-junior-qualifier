package com.coinbase.ciphercore;

import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: types.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\rJ\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\nR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\rR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b\u0011\u0010\u0004¨\u0006("}, d2 = {"Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "", "", "component1", "()Z", "", "component2", "()I", "", "component3", "()[B", "", "component4", "()Ljava/lang/String;", "Ljava/math/BigInteger;", "component5", "()Ljava/math/BigInteger;", "isSuccessful", "blockNumber", "blockHash", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "gasUsed", "copy", "(ZI[BLjava/lang/String;Ljava/math/BigInteger;)Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getGasUsed", "[B", "getBlockHash", "Ljava/lang/String;", "getContractAddress", "I", "getBlockNumber", "Z", "<init>", "(ZI[BLjava/lang/String;Ljava/math/BigInteger;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumTransactionReceipt {
    private final byte[] blockHash;
    private final int blockNumber;
    private final String contractAddress;
    private final BigInteger gasUsed;
    private final boolean isSuccessful;

    public EthereumTransactionReceipt(boolean z, int i2, byte[] blockHash, String str, BigInteger gasUsed) {
        kotlin.jvm.internal.m.g(blockHash, "blockHash");
        kotlin.jvm.internal.m.g(gasUsed, "gasUsed");
        this.isSuccessful = z;
        this.blockNumber = i2;
        this.blockHash = blockHash;
        this.contractAddress = str;
        this.gasUsed = gasUsed;
    }

    public static /* synthetic */ EthereumTransactionReceipt copy$default(EthereumTransactionReceipt ethereumTransactionReceipt, boolean z, int i2, byte[] bArr, String str, BigInteger bigInteger, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = ethereumTransactionReceipt.isSuccessful;
        }
        if ((i3 & 2) != 0) {
            i2 = ethereumTransactionReceipt.blockNumber;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            bArr = ethereumTransactionReceipt.blockHash;
        }
        byte[] bArr2 = bArr;
        if ((i3 & 8) != 0) {
            str = ethereumTransactionReceipt.contractAddress;
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            bigInteger = ethereumTransactionReceipt.gasUsed;
        }
        return ethereumTransactionReceipt.copy(z, i4, bArr2, str2, bigInteger);
    }

    public final boolean component1() {
        return this.isSuccessful;
    }

    public final int component2() {
        return this.blockNumber;
    }

    public final byte[] component3() {
        return this.blockHash;
    }

    public final String component4() {
        return this.contractAddress;
    }

    public final BigInteger component5() {
        return this.gasUsed;
    }

    public final EthereumTransactionReceipt copy(boolean z, int i2, byte[] blockHash, String str, BigInteger gasUsed) {
        kotlin.jvm.internal.m.g(blockHash, "blockHash");
        kotlin.jvm.internal.m.g(gasUsed, "gasUsed");
        return new EthereumTransactionReceipt(z, i2, blockHash, str, gasUsed);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumTransactionReceipt) {
            EthereumTransactionReceipt ethereumTransactionReceipt = (EthereumTransactionReceipt) obj;
            return this.isSuccessful == ethereumTransactionReceipt.isSuccessful && this.blockNumber == ethereumTransactionReceipt.blockNumber && kotlin.jvm.internal.m.c(this.blockHash, ethereumTransactionReceipt.blockHash) && kotlin.jvm.internal.m.c(this.contractAddress, ethereumTransactionReceipt.contractAddress) && kotlin.jvm.internal.m.c(this.gasUsed, ethereumTransactionReceipt.gasUsed);
        }
        return false;
    }

    public final byte[] getBlockHash() {
        return this.blockHash;
    }

    public final int getBlockNumber() {
        return this.blockNumber;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final BigInteger getGasUsed() {
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
        int hashCode = ((((r0 * 31) + this.blockNumber) * 31) + Arrays.hashCode(this.blockHash)) * 31;
        String str = this.contractAddress;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.gasUsed.hashCode();
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    public String toString() {
        return "EthereumTransactionReceipt(isSuccessful=" + this.isSuccessful + ", blockNumber=" + this.blockNumber + ", blockHash=" + Arrays.toString(this.blockHash) + ", contractAddress=" + ((Object) this.contractAddress) + ", gasUsed=" + this.gasUsed + ')';
    }
}