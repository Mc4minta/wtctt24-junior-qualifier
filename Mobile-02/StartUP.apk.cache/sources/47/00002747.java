package com.coinbase.wallet.txhistory.dtos;

import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetHdWalletTxsResponse.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsInputOutput;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "", "component2", "()Ljava/lang/String;", "value", "address", "copy", "(Ljava/math/BigInteger;Ljava/lang/String;)Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsInputOutput;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAddress", "Ljava/math/BigInteger;", "getValue", "<init>", "(Ljava/math/BigInteger;Ljava/lang/String;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetHdWalletTxsInputOutput {
    private final String address;
    private final BigInteger value;

    public GetHdWalletTxsInputOutput(BigInteger value, String address) {
        m.g(value, "value");
        m.g(address, "address");
        this.value = value;
        this.address = address;
    }

    public static /* synthetic */ GetHdWalletTxsInputOutput copy$default(GetHdWalletTxsInputOutput getHdWalletTxsInputOutput, BigInteger bigInteger, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = getHdWalletTxsInputOutput.value;
        }
        if ((i2 & 2) != 0) {
            str = getHdWalletTxsInputOutput.address;
        }
        return getHdWalletTxsInputOutput.copy(bigInteger, str);
    }

    public final BigInteger component1() {
        return this.value;
    }

    public final String component2() {
        return this.address;
    }

    public final GetHdWalletTxsInputOutput copy(BigInteger value, String address) {
        m.g(value, "value");
        m.g(address, "address");
        return new GetHdWalletTxsInputOutput(value, address);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetHdWalletTxsInputOutput) {
            GetHdWalletTxsInputOutput getHdWalletTxsInputOutput = (GetHdWalletTxsInputOutput) obj;
            return m.c(this.value, getHdWalletTxsInputOutput.value) && m.c(this.address, getHdWalletTxsInputOutput.address);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final BigInteger getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.address.hashCode();
    }

    public String toString() {
        return "GetHdWalletTxsInputOutput(value=" + this.value + ", address=" + this.address + ')';
    }
}