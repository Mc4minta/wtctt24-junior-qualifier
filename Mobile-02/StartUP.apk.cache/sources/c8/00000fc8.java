package com.coinbase.ciphercore;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: types.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0013\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0080\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010#\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b#\u0010\u000eJ\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u001e\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b)\u0010\u000eR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010\bR\u0019\u0010\u001f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\u000bR\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b0\u0010\u000bR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b2\u0010\bR\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b3\u0010\u000eR\u0019\u0010\u001c\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b4\u0010\bR\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b5\u0010\bR\u0019\u0010\u001b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b6\u0010\b¨\u00069"}, d2 = {"Lcom/coinbase/ciphercore/ParsedEthereumTransaction;", "", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "", "component4", "()[B", "", "component5", "()I", "component6", "component7", "component8", "component9", "component10", "component11", "fromAddress", "toAddress", "weiValue", "data", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", RouteActionKey.RouteActionKeys.CHAIN_ID, "hash", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;I[B)Lcom/coinbase/ciphercore/ParsedEthereumTransaction;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChainId", "Ljava/lang/String;", "getToAddress", "Ljava/math/BigInteger;", "getGasLimit", "[B", "getHash", "getData", "getFromAddress", "getGasPriceInWei", "getNonce", "getMaxPriorityFeePerGas", "getWeiValue", "getMaxFeePerGas", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BILjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;I[B)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ParsedEthereumTransaction {
    private final int chainId;
    private final byte[] data;
    private final String fromAddress;
    private final BigInteger gasLimit;
    private final BigInteger gasPriceInWei;
    private final byte[] hash;
    private final BigInteger maxFeePerGas;
    private final BigInteger maxPriorityFeePerGas;
    private final int nonce;
    private final String toAddress;
    private final BigInteger weiValue;

    public ParsedEthereumTransaction(String fromAddress, String str, BigInteger weiValue, byte[] data, int i2, BigInteger gasPriceInWei, BigInteger maxFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, int i3, byte[] hash) {
        kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(gasPriceInWei, "gasPriceInWei");
        kotlin.jvm.internal.m.g(maxFeePerGas, "maxFeePerGas");
        kotlin.jvm.internal.m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(hash, "hash");
        this.fromAddress = fromAddress;
        this.toAddress = str;
        this.weiValue = weiValue;
        this.data = data;
        this.nonce = i2;
        this.gasPriceInWei = gasPriceInWei;
        this.maxFeePerGas = maxFeePerGas;
        this.maxPriorityFeePerGas = maxPriorityFeePerGas;
        this.gasLimit = gasLimit;
        this.chainId = i3;
        this.hash = hash;
    }

    public final String component1() {
        return this.fromAddress;
    }

    public final int component10() {
        return this.chainId;
    }

    public final byte[] component11() {
        return this.hash;
    }

    public final String component2() {
        return this.toAddress;
    }

    public final BigInteger component3() {
        return this.weiValue;
    }

    public final byte[] component4() {
        return this.data;
    }

    public final int component5() {
        return this.nonce;
    }

    public final BigInteger component6() {
        return this.gasPriceInWei;
    }

    public final BigInteger component7() {
        return this.maxFeePerGas;
    }

    public final BigInteger component8() {
        return this.maxPriorityFeePerGas;
    }

    public final BigInteger component9() {
        return this.gasLimit;
    }

    public final ParsedEthereumTransaction copy(String fromAddress, String str, BigInteger weiValue, byte[] data, int i2, BigInteger gasPriceInWei, BigInteger maxFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, int i3, byte[] hash) {
        kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(gasPriceInWei, "gasPriceInWei");
        kotlin.jvm.internal.m.g(maxFeePerGas, "maxFeePerGas");
        kotlin.jvm.internal.m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(hash, "hash");
        return new ParsedEthereumTransaction(fromAddress, str, weiValue, data, i2, gasPriceInWei, maxFeePerGas, maxPriorityFeePerGas, gasLimit, i3, hash);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParsedEthereumTransaction) {
            ParsedEthereumTransaction parsedEthereumTransaction = (ParsedEthereumTransaction) obj;
            return kotlin.jvm.internal.m.c(this.fromAddress, parsedEthereumTransaction.fromAddress) && kotlin.jvm.internal.m.c(this.toAddress, parsedEthereumTransaction.toAddress) && kotlin.jvm.internal.m.c(this.weiValue, parsedEthereumTransaction.weiValue) && kotlin.jvm.internal.m.c(this.data, parsedEthereumTransaction.data) && this.nonce == parsedEthereumTransaction.nonce && kotlin.jvm.internal.m.c(this.gasPriceInWei, parsedEthereumTransaction.gasPriceInWei) && kotlin.jvm.internal.m.c(this.maxFeePerGas, parsedEthereumTransaction.maxFeePerGas) && kotlin.jvm.internal.m.c(this.maxPriorityFeePerGas, parsedEthereumTransaction.maxPriorityFeePerGas) && kotlin.jvm.internal.m.c(this.gasLimit, parsedEthereumTransaction.gasLimit) && this.chainId == parsedEthereumTransaction.chainId && kotlin.jvm.internal.m.c(this.hash, parsedEthereumTransaction.hash);
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getFromAddress() {
        return this.fromAddress;
    }

    public final BigInteger getGasLimit() {
        return this.gasLimit;
    }

    public final BigInteger getGasPriceInWei() {
        return this.gasPriceInWei;
    }

    public final byte[] getHash() {
        return this.hash;
    }

    public final BigInteger getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public final BigInteger getMaxPriorityFeePerGas() {
        return this.maxPriorityFeePerGas;
    }

    public final int getNonce() {
        return this.nonce;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    public final BigInteger getWeiValue() {
        return this.weiValue;
    }

    public int hashCode() {
        int hashCode = this.fromAddress.hashCode() * 31;
        String str = this.toAddress;
        return ((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.weiValue.hashCode()) * 31) + Arrays.hashCode(this.data)) * 31) + this.nonce) * 31) + this.gasPriceInWei.hashCode()) * 31) + this.maxFeePerGas.hashCode()) * 31) + this.maxPriorityFeePerGas.hashCode()) * 31) + this.gasLimit.hashCode()) * 31) + this.chainId) * 31) + Arrays.hashCode(this.hash);
    }

    public String toString() {
        return "ParsedEthereumTransaction(fromAddress=" + this.fromAddress + ", toAddress=" + ((Object) this.toAddress) + ", weiValue=" + this.weiValue + ", data=" + Arrays.toString(this.data) + ", nonce=" + this.nonce + ", gasPriceInWei=" + this.gasPriceInWei + ", maxFeePerGas=" + this.maxFeePerGas + ", maxPriorityFeePerGas=" + this.maxPriorityFeePerGas + ", gasLimit=" + this.gasLimit + ", chainId=" + this.chainId + ", hash=" + Arrays.toString(this.hash) + ')';
    }
}