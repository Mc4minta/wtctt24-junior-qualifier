package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SignEthereumTransactionCallJson.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b&\b\u0081\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u008a\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\"\u0010\u0010J\u001a\u0010$\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b*\u0010\u0010R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b,\u0010\u0004R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u0013R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b0\u0010\u0004R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b1\u0010\u0004R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\nR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b4\u0010\u0004¨\u00067"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumTransactionCallParamsJson;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "component6", "component7", "component8", "component9", "component10", "()I", "", "component11", "()Z", "fromAddress", "toAddress", "weiValue", "data", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", RouteActionKey.RouteActionKeys.CHAIN_ID, "shouldSubmit", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumTransactionCallParamsJson;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getData", "getWeiValue", "I", "getChainId", "getToAddress", "getFromAddress", "getGasPriceInWei", "Z", "getShouldSubmit", "getMaxPriorityFeePerGas", "getGasLimit", "Ljava/lang/Integer;", "getNonce", "getMaxFeePerGas", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignEthereumTransactionCallParamsJson {
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
    @Json(name = "maxFeePerGas")
    private final String maxFeePerGas;
    @Json(name = "maxPriorityFeePerGas")
    private final String maxPriorityFeePerGas;
    @Json(name = AdjustableMinerFeeArgs.NONCE)
    private final Integer nonce;
    @Json(name = "shouldSubmit")
    private final boolean shouldSubmit;
    @Json(name = "toAddress")
    private final String toAddress;
    @Json(name = "weiValue")
    private final String weiValue;

    public SignEthereumTransactionCallParamsJson(String fromAddress, String str, String weiValue, String data, Integer num, String str2, String str3, String str4, String str5, int i2, boolean z) {
        m.g(fromAddress, "fromAddress");
        m.g(weiValue, "weiValue");
        m.g(data, "data");
        this.fromAddress = fromAddress;
        this.toAddress = str;
        this.weiValue = weiValue;
        this.data = data;
        this.nonce = num;
        this.gasPriceInWei = str2;
        this.maxFeePerGas = str3;
        this.maxPriorityFeePerGas = str4;
        this.gasLimit = str5;
        this.chainId = i2;
        this.shouldSubmit = z;
    }

    public final String component1() {
        return this.fromAddress;
    }

    public final int component10() {
        return this.chainId;
    }

    public final boolean component11() {
        return this.shouldSubmit;
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

    public final Integer component5() {
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

    public final SignEthereumTransactionCallParamsJson copy(String fromAddress, String str, String weiValue, String data, Integer num, String str2, String str3, String str4, String str5, int i2, boolean z) {
        m.g(fromAddress, "fromAddress");
        m.g(weiValue, "weiValue");
        m.g(data, "data");
        return new SignEthereumTransactionCallParamsJson(fromAddress, str, weiValue, data, num, str2, str3, str4, str5, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignEthereumTransactionCallParamsJson) {
            SignEthereumTransactionCallParamsJson signEthereumTransactionCallParamsJson = (SignEthereumTransactionCallParamsJson) obj;
            return m.c(this.fromAddress, signEthereumTransactionCallParamsJson.fromAddress) && m.c(this.toAddress, signEthereumTransactionCallParamsJson.toAddress) && m.c(this.weiValue, signEthereumTransactionCallParamsJson.weiValue) && m.c(this.data, signEthereumTransactionCallParamsJson.data) && m.c(this.nonce, signEthereumTransactionCallParamsJson.nonce) && m.c(this.gasPriceInWei, signEthereumTransactionCallParamsJson.gasPriceInWei) && m.c(this.maxFeePerGas, signEthereumTransactionCallParamsJson.maxFeePerGas) && m.c(this.maxPriorityFeePerGas, signEthereumTransactionCallParamsJson.maxPriorityFeePerGas) && m.c(this.gasLimit, signEthereumTransactionCallParamsJson.gasLimit) && this.chainId == signEthereumTransactionCallParamsJson.chainId && this.shouldSubmit == signEthereumTransactionCallParamsJson.shouldSubmit;
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

    public final String getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public final String getMaxPriorityFeePerGas() {
        return this.maxPriorityFeePerGas;
    }

    public final Integer getNonce() {
        return this.nonce;
    }

    public final boolean getShouldSubmit() {
        return this.shouldSubmit;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    public final String getWeiValue() {
        return this.weiValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.fromAddress.hashCode() * 31;
        String str = this.toAddress;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.weiValue.hashCode()) * 31) + this.data.hashCode()) * 31;
        Integer num = this.nonce;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.gasPriceInWei;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.maxFeePerGas;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.maxPriorityFeePerGas;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gasLimit;
        int hashCode7 = (((hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.chainId) * 31;
        boolean z = this.shouldSubmit;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode7 + i2;
    }

    public String toString() {
        return "SignEthereumTransactionCallParamsJson(fromAddress=" + this.fromAddress + ", toAddress=" + ((Object) this.toAddress) + ", weiValue=" + this.weiValue + ", data=" + this.data + ", nonce=" + this.nonce + ", gasPriceInWei=" + ((Object) this.gasPriceInWei) + ", maxFeePerGas=" + ((Object) this.maxFeePerGas) + ", maxPriorityFeePerGas=" + ((Object) this.maxPriorityFeePerGas) + ", gasLimit=" + ((Object) this.gasLimit) + ", chainId=" + this.chainId + ", shouldSubmit=" + this.shouldSubmit + ')';
    }
}