package com.coinbase.wallet.lending.models;

import com.appsflyer.AppsFlyerProperties;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: TxParams.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jv\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b+\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b,\u0010\u0004¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/lending/models/TxParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "lendTokenId", "toAddress", AppsFlyerProperties.CURRENCY_CODE, "weiValue", "transferValue", "data", "gasLimit", "gasPrice", "gasBaseFee", "gasPriorityFee", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/lending/models/TxParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGasPriorityFee", "getGasLimit", "getCurrencyCode", "getTransferValue", "getData", "getWeiValue", "getLendTokenId", "getGasPrice", "getGasBaseFee", "getToAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxParams {
    private final String currencyCode;
    private final String data;
    private final String gasBaseFee;
    private final String gasLimit;
    private final String gasPrice;
    private final String gasPriorityFee;
    private final String lendTokenId;
    private final String toAddress;
    private final String transferValue;
    private final String weiValue;

    public TxParams(String lendTokenId, String str, String currencyCode, String weiValue, String transferValue, String data, String gasLimit, String gasPrice, String gasBaseFee, String gasPriorityFee) {
        m.g(lendTokenId, "lendTokenId");
        m.g(currencyCode, "currencyCode");
        m.g(weiValue, "weiValue");
        m.g(transferValue, "transferValue");
        m.g(data, "data");
        m.g(gasLimit, "gasLimit");
        m.g(gasPrice, "gasPrice");
        m.g(gasBaseFee, "gasBaseFee");
        m.g(gasPriorityFee, "gasPriorityFee");
        this.lendTokenId = lendTokenId;
        this.toAddress = str;
        this.currencyCode = currencyCode;
        this.weiValue = weiValue;
        this.transferValue = transferValue;
        this.data = data;
        this.gasLimit = gasLimit;
        this.gasPrice = gasPrice;
        this.gasBaseFee = gasBaseFee;
        this.gasPriorityFee = gasPriorityFee;
    }

    public final String component1() {
        return this.lendTokenId;
    }

    public final String component10() {
        return this.gasPriorityFee;
    }

    public final String component2() {
        return this.toAddress;
    }

    public final String component3() {
        return this.currencyCode;
    }

    public final String component4() {
        return this.weiValue;
    }

    public final String component5() {
        return this.transferValue;
    }

    public final String component6() {
        return this.data;
    }

    public final String component7() {
        return this.gasLimit;
    }

    public final String component8() {
        return this.gasPrice;
    }

    public final String component9() {
        return this.gasBaseFee;
    }

    public final TxParams copy(String lendTokenId, String str, String currencyCode, String weiValue, String transferValue, String data, String gasLimit, String gasPrice, String gasBaseFee, String gasPriorityFee) {
        m.g(lendTokenId, "lendTokenId");
        m.g(currencyCode, "currencyCode");
        m.g(weiValue, "weiValue");
        m.g(transferValue, "transferValue");
        m.g(data, "data");
        m.g(gasLimit, "gasLimit");
        m.g(gasPrice, "gasPrice");
        m.g(gasBaseFee, "gasBaseFee");
        m.g(gasPriorityFee, "gasPriorityFee");
        return new TxParams(lendTokenId, str, currencyCode, weiValue, transferValue, data, gasLimit, gasPrice, gasBaseFee, gasPriorityFee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TxParams) {
            TxParams txParams = (TxParams) obj;
            return m.c(this.lendTokenId, txParams.lendTokenId) && m.c(this.toAddress, txParams.toAddress) && m.c(this.currencyCode, txParams.currencyCode) && m.c(this.weiValue, txParams.weiValue) && m.c(this.transferValue, txParams.transferValue) && m.c(this.data, txParams.data) && m.c(this.gasLimit, txParams.gasLimit) && m.c(this.gasPrice, txParams.gasPrice) && m.c(this.gasBaseFee, txParams.gasBaseFee) && m.c(this.gasPriorityFee, txParams.gasPriorityFee);
        }
        return false;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getData() {
        return this.data;
    }

    public final String getGasBaseFee() {
        return this.gasBaseFee;
    }

    public final String getGasLimit() {
        return this.gasLimit;
    }

    public final String getGasPrice() {
        return this.gasPrice;
    }

    public final String getGasPriorityFee() {
        return this.gasPriorityFee;
    }

    public final String getLendTokenId() {
        return this.lendTokenId;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    public final String getTransferValue() {
        return this.transferValue;
    }

    public final String getWeiValue() {
        return this.weiValue;
    }

    public int hashCode() {
        int hashCode = this.lendTokenId.hashCode() * 31;
        String str = this.toAddress;
        return ((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.currencyCode.hashCode()) * 31) + this.weiValue.hashCode()) * 31) + this.transferValue.hashCode()) * 31) + this.data.hashCode()) * 31) + this.gasLimit.hashCode()) * 31) + this.gasPrice.hashCode()) * 31) + this.gasBaseFee.hashCode()) * 31) + this.gasPriorityFee.hashCode();
    }

    public String toString() {
        return "TxParams(lendTokenId=" + this.lendTokenId + ", toAddress=" + ((Object) this.toAddress) + ", currencyCode=" + this.currencyCode + ", weiValue=" + this.weiValue + ", transferValue=" + this.transferValue + ", data=" + this.data + ", gasLimit=" + this.gasLimit + ", gasPrice=" + this.gasPrice + ", gasBaseFee=" + this.gasBaseFee + ", gasPriorityFee=" + this.gasPriorityFee + ')';
    }
}