package com.coinbase.walletengine.services.bitcoin;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import kotlin.Metadata;

/* compiled from: BitcoinService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/coinbase/walletengine/services/bitcoin/Output;", "", "", "component1", "()Ljava/lang/String;", "Ljava/math/BigInteger;", "component2", "()Ljava/math/BigInteger;", "address", "value", "copy", "(Ljava/lang/String;Ljava/math/BigInteger;)Lcom/coinbase/walletengine/services/bitcoin/Output;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAddress", "Ljava/math/BigInteger;", "getValue", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Output {
    @Json(name = "address")
    private final String address;
    @Json(name = "value")
    private final BigInteger value;

    public Output(String address, BigInteger value) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(value, "value");
        this.address = address;
        this.value = value;
    }

    public static /* synthetic */ Output copy$default(Output output, String str, BigInteger bigInteger, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = output.address;
        }
        if ((i2 & 2) != 0) {
            bigInteger = output.value;
        }
        return output.copy(str, bigInteger);
    }

    public final String component1() {
        return this.address;
    }

    public final BigInteger component2() {
        return this.value;
    }

    public final Output copy(String address, BigInteger value) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(value, "value");
        return new Output(address, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Output) {
            Output output = (Output) obj;
            return kotlin.jvm.internal.m.c(this.address, output.address) && kotlin.jvm.internal.m.c(this.value, output.value);
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
        return (this.address.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Output(address=" + this.address + ", value=" + this.value + ')';
    }
}