package com.coinbase.wallet.txhistory.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetEthereumTxsResultDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/GetEthereumTxsResultDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", ApiConstants.FROM, ApiConstants.TO, "gasUsed", "gasPrice", "hash", "value", "timeStamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/txhistory/dtos/GetEthereumTxsResultDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHash", "getValue", "getTo", "getGasPrice", "getTimeStamp", "getGasUsed", "getFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetEthereumTxsResultDTO {
    private final String from;
    private final String gasPrice;
    private final String gasUsed;
    private final String hash;
    private final String timeStamp;
    private final String to;
    private final String value;

    public GetEthereumTxsResultDTO(String from, String to, String gasUsed, String gasPrice, String hash, String value, String timeStamp) {
        m.g(from, "from");
        m.g(to, "to");
        m.g(gasUsed, "gasUsed");
        m.g(gasPrice, "gasPrice");
        m.g(hash, "hash");
        m.g(value, "value");
        m.g(timeStamp, "timeStamp");
        this.from = from;
        this.to = to;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.hash = hash;
        this.value = value;
        this.timeStamp = timeStamp;
    }

    public static /* synthetic */ GetEthereumTxsResultDTO copy$default(GetEthereumTxsResultDTO getEthereumTxsResultDTO, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getEthereumTxsResultDTO.from;
        }
        if ((i2 & 2) != 0) {
            str2 = getEthereumTxsResultDTO.to;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = getEthereumTxsResultDTO.gasUsed;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = getEthereumTxsResultDTO.gasPrice;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = getEthereumTxsResultDTO.hash;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = getEthereumTxsResultDTO.value;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = getEthereumTxsResultDTO.timeStamp;
        }
        return getEthereumTxsResultDTO.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.from;
    }

    public final String component2() {
        return this.to;
    }

    public final String component3() {
        return this.gasUsed;
    }

    public final String component4() {
        return this.gasPrice;
    }

    public final String component5() {
        return this.hash;
    }

    public final String component6() {
        return this.value;
    }

    public final String component7() {
        return this.timeStamp;
    }

    public final GetEthereumTxsResultDTO copy(String from, String to, String gasUsed, String gasPrice, String hash, String value, String timeStamp) {
        m.g(from, "from");
        m.g(to, "to");
        m.g(gasUsed, "gasUsed");
        m.g(gasPrice, "gasPrice");
        m.g(hash, "hash");
        m.g(value, "value");
        m.g(timeStamp, "timeStamp");
        return new GetEthereumTxsResultDTO(from, to, gasUsed, gasPrice, hash, value, timeStamp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetEthereumTxsResultDTO) {
            GetEthereumTxsResultDTO getEthereumTxsResultDTO = (GetEthereumTxsResultDTO) obj;
            return m.c(this.from, getEthereumTxsResultDTO.from) && m.c(this.to, getEthereumTxsResultDTO.to) && m.c(this.gasUsed, getEthereumTxsResultDTO.gasUsed) && m.c(this.gasPrice, getEthereumTxsResultDTO.gasPrice) && m.c(this.hash, getEthereumTxsResultDTO.hash) && m.c(this.value, getEthereumTxsResultDTO.value) && m.c(this.timeStamp, getEthereumTxsResultDTO.timeStamp);
        }
        return false;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getGasPrice() {
        return this.gasPrice;
    }

    public final String getGasUsed() {
        return this.gasUsed;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTo() {
        return this.to;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((((((this.from.hashCode() * 31) + this.to.hashCode()) * 31) + this.gasUsed.hashCode()) * 31) + this.gasPrice.hashCode()) * 31) + this.hash.hashCode()) * 31) + this.value.hashCode()) * 31) + this.timeStamp.hashCode();
    }

    public String toString() {
        return "GetEthereumTxsResultDTO(from=" + this.from + ", to=" + this.to + ", gasUsed=" + this.gasUsed + ", gasPrice=" + this.gasPrice + ", hash=" + this.hash + ", value=" + this.value + ", timeStamp=" + this.timeStamp + ')';
    }
}