package com.coinbase.ciphercore;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: types.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0081\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0080\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\nJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010\nR\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b,\u0010\nR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b.\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b0\u0010\u0004¨\u00063"}, d2 = {"Lcom/coinbase/ciphercore/SerializedParsedEthereumTransaction;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()I", "component6", "component7", "component8", "component9", "component10", "component11", "fromAddress", "toAddress", "weiValue", "data", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", RouteActionKey.RouteActionKeys.CHAIN_ID, "hash", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/coinbase/ciphercore/SerializedParsedEthereumTransaction;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHash", "getMaxFeePerGas", "getGasPriceInWei", "I", "getChainId", "getWeiValue", "getData", "getNonce", "getFromAddress", "getMaxPriorityFeePerGas", "getToAddress", "getGasLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SerializedParsedEthereumTransaction {
    @Json(name = RouteActionKey.RouteActionKeys.CHAIN_ID)
    private final int chainId;
    @Json(name = "data")
    private final String data;
    @Json(name = "fromAddress")
    private final String fromAddress;
    @Json(name = "gasLimit")
    private final String gasLimit;
    @Json(name = "gasPriceInWei")
    private final String gasPriceInWei;
    @Json(name = "hash")
    private final String hash;
    @Json(name = "maxFeePerGas")
    private final String maxFeePerGas;
    @Json(name = "maxPriorityFeePerGas")
    private final String maxPriorityFeePerGas;
    @Json(name = AdjustableMinerFeeArgs.NONCE)
    private final int nonce;
    @Json(name = "toAddress")
    private final String toAddress;
    @Json(name = "weiValue")
    private final String weiValue;

    public SerializedParsedEthereumTransaction(String fromAddress, String str, String weiValue, String data, int i2, String gasPriceInWei, String maxFeePerGas, String maxPriorityFeePerGas, String gasLimit, int i3, String hash) {
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

    public final String component11() {
        return this.hash;
    }

    public final String component2() {
        return this.toAddress;
    }

    public final String component3() {
        return this.weiValue;
    }

    public final String component4() {
        return this.data;
    }

    public final int component5() {
        return this.nonce;
    }

    public final String component6() {
        return this.gasPriceInWei;
    }

    public final String component7() {
        return this.maxFeePerGas;
    }

    public final String component8() {
        return this.maxPriorityFeePerGas;
    }

    public final String component9() {
        return this.gasLimit;
    }

    public final SerializedParsedEthereumTransaction copy(String fromAddress, String str, String weiValue, String data, int i2, String gasPriceInWei, String maxFeePerGas, String maxPriorityFeePerGas, String gasLimit, int i3, String hash) {
        kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
        kotlin.jvm.internal.m.g(weiValue, "weiValue");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(gasPriceInWei, "gasPriceInWei");
        kotlin.jvm.internal.m.g(maxFeePerGas, "maxFeePerGas");
        kotlin.jvm.internal.m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        kotlin.jvm.internal.m.g(gasLimit, "gasLimit");
        kotlin.jvm.internal.m.g(hash, "hash");
        return new SerializedParsedEthereumTransaction(fromAddress, str, weiValue, data, i2, gasPriceInWei, maxFeePerGas, maxPriorityFeePerGas, gasLimit, i3, hash);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerializedParsedEthereumTransaction) {
            SerializedParsedEthereumTransaction serializedParsedEthereumTransaction = (SerializedParsedEthereumTransaction) obj;
            return kotlin.jvm.internal.m.c(this.fromAddress, serializedParsedEthereumTransaction.fromAddress) && kotlin.jvm.internal.m.c(this.toAddress, serializedParsedEthereumTransaction.toAddress) && kotlin.jvm.internal.m.c(this.weiValue, serializedParsedEthereumTransaction.weiValue) && kotlin.jvm.internal.m.c(this.data, serializedParsedEthereumTransaction.data) && this.nonce == serializedParsedEthereumTransaction.nonce && kotlin.jvm.internal.m.c(this.gasPriceInWei, serializedParsedEthereumTransaction.gasPriceInWei) && kotlin.jvm.internal.m.c(this.maxFeePerGas, serializedParsedEthereumTransaction.maxFeePerGas) && kotlin.jvm.internal.m.c(this.maxPriorityFeePerGas, serializedParsedEthereumTransaction.maxPriorityFeePerGas) && kotlin.jvm.internal.m.c(this.gasLimit, serializedParsedEthereumTransaction.gasLimit) && this.chainId == serializedParsedEthereumTransaction.chainId && kotlin.jvm.internal.m.c(this.hash, serializedParsedEthereumTransaction.hash);
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final String getData() {
        return this.data;
    }

    public final String getFromAddress() {
        return this.fromAddress;
    }

    public final String getGasLimit() {
        return this.gasLimit;
    }

    public final String getGasPriceInWei() {
        return this.gasPriceInWei;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public final String getMaxPriorityFeePerGas() {
        return this.maxPriorityFeePerGas;
    }

    public final int getNonce() {
        return this.nonce;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    public final String getWeiValue() {
        return this.weiValue;
    }

    public int hashCode() {
        int hashCode = this.fromAddress.hashCode() * 31;
        String str = this.toAddress;
        return ((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.weiValue.hashCode()) * 31) + this.data.hashCode()) * 31) + this.nonce) * 31) + this.gasPriceInWei.hashCode()) * 31) + this.maxFeePerGas.hashCode()) * 31) + this.maxPriorityFeePerGas.hashCode()) * 31) + this.gasLimit.hashCode()) * 31) + this.chainId) * 31) + this.hash.hashCode();
    }

    public String toString() {
        return "SerializedParsedEthereumTransaction(fromAddress=" + this.fromAddress + ", toAddress=" + ((Object) this.toAddress) + ", weiValue=" + this.weiValue + ", data=" + this.data + ", nonce=" + this.nonce + ", gasPriceInWei=" + this.gasPriceInWei + ", maxFeePerGas=" + this.maxFeePerGas + ", maxPriorityFeePerGas=" + this.maxPriorityFeePerGas + ", gasLimit=" + this.gasLimit + ", chainId=" + this.chainId + ", hash=" + this.hash + ')';
    }
}