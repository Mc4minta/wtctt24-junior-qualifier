package com.coinbase.wallet.features.send.models;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFee1559Info.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJF\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001c\u0010\tR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "component2", "component3", "", "component4", "()Ljava/lang/String;", "component5", "maxFeePerGas", "maxPriorityFeePerGas", "baseFeePerGas", "fiatRangeString", "cryptoRangeString", "copy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFiatRangeString", "getCryptoRangeString", "Ljava/math/BigInteger;", "getBaseFeePerGas", "getMaxFeePerGas", "getMaxPriorityFeePerGas", "<init>", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559Info {
    private final BigInteger baseFeePerGas;
    private final String cryptoRangeString;
    private final String fiatRangeString;
    private final BigInteger maxFeePerGas;
    private final BigInteger maxPriorityFeePerGas;

    public AdjustableMinerFee1559Info(BigInteger maxFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger baseFeePerGas, String str, String str2) {
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        this.maxFeePerGas = maxFeePerGas;
        this.maxPriorityFeePerGas = maxPriorityFeePerGas;
        this.baseFeePerGas = baseFeePerGas;
        this.fiatRangeString = str;
        this.cryptoRangeString = str2;
    }

    public static /* synthetic */ AdjustableMinerFee1559Info copy$default(AdjustableMinerFee1559Info adjustableMinerFee1559Info, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = adjustableMinerFee1559Info.maxFeePerGas;
        }
        if ((i2 & 2) != 0) {
            bigInteger2 = adjustableMinerFee1559Info.maxPriorityFeePerGas;
        }
        BigInteger bigInteger4 = bigInteger2;
        if ((i2 & 4) != 0) {
            bigInteger3 = adjustableMinerFee1559Info.baseFeePerGas;
        }
        BigInteger bigInteger5 = bigInteger3;
        if ((i2 & 8) != 0) {
            str = adjustableMinerFee1559Info.fiatRangeString;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = adjustableMinerFee1559Info.cryptoRangeString;
        }
        return adjustableMinerFee1559Info.copy(bigInteger, bigInteger4, bigInteger5, str3, str2);
    }

    public final BigInteger component1() {
        return this.maxFeePerGas;
    }

    public final BigInteger component2() {
        return this.maxPriorityFeePerGas;
    }

    public final BigInteger component3() {
        return this.baseFeePerGas;
    }

    public final String component4() {
        return this.fiatRangeString;
    }

    public final String component5() {
        return this.cryptoRangeString;
    }

    public final AdjustableMinerFee1559Info copy(BigInteger maxFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger baseFeePerGas, String str, String str2) {
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        return new AdjustableMinerFee1559Info(maxFeePerGas, maxPriorityFeePerGas, baseFeePerGas, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFee1559Info) {
            AdjustableMinerFee1559Info adjustableMinerFee1559Info = (AdjustableMinerFee1559Info) obj;
            return m.c(this.maxFeePerGas, adjustableMinerFee1559Info.maxFeePerGas) && m.c(this.maxPriorityFeePerGas, adjustableMinerFee1559Info.maxPriorityFeePerGas) && m.c(this.baseFeePerGas, adjustableMinerFee1559Info.baseFeePerGas) && m.c(this.fiatRangeString, adjustableMinerFee1559Info.fiatRangeString) && m.c(this.cryptoRangeString, adjustableMinerFee1559Info.cryptoRangeString);
        }
        return false;
    }

    public final BigInteger getBaseFeePerGas() {
        return this.baseFeePerGas;
    }

    public final String getCryptoRangeString() {
        return this.cryptoRangeString;
    }

    public final String getFiatRangeString() {
        return this.fiatRangeString;
    }

    public final BigInteger getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public final BigInteger getMaxPriorityFeePerGas() {
        return this.maxPriorityFeePerGas;
    }

    public int hashCode() {
        int hashCode = ((((this.maxFeePerGas.hashCode() * 31) + this.maxPriorityFeePerGas.hashCode()) * 31) + this.baseFeePerGas.hashCode()) * 31;
        String str = this.fiatRangeString;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cryptoRangeString;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AdjustableMinerFee1559Info(maxFeePerGas=" + this.maxFeePerGas + ", maxPriorityFeePerGas=" + this.maxPriorityFeePerGas + ", baseFeePerGas=" + this.baseFeePerGas + ", fiatRangeString=" + ((Object) this.fiatRangeString) + ", cryptoRangeString=" + ((Object) this.cryptoRangeString) + ')';
    }
}