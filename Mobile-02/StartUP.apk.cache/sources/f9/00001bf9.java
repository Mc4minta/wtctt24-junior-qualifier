package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFee1559DTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b#\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "component2", "component3", "component4", "component5", "component6", "component7", "fastPriorityFee", "normalPriorityFee", "slowPriorityFee", "baseFee", "slowMaxFeePerGas", "normalMaxFeePerGas", "fastMaxFeePerGas", "copy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;)Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getFastMaxFeePerGas", "getSlowMaxFeePerGas", "getBaseFee", "getSlowPriorityFee", "getNormalMaxFeePerGas", "getNormalPriorityFee", "getFastPriorityFee", "<init>", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559Result {
    private final BigInteger baseFee;
    private final BigInteger fastMaxFeePerGas;
    private final BigInteger fastPriorityFee;
    private final BigInteger normalMaxFeePerGas;
    private final BigInteger normalPriorityFee;
    private final BigInteger slowMaxFeePerGas;
    private final BigInteger slowPriorityFee;

    public AdjustableMinerFee1559Result(BigInteger fastPriorityFee, BigInteger normalPriorityFee, BigInteger slowPriorityFee, BigInteger baseFee, BigInteger slowMaxFeePerGas, BigInteger normalMaxFeePerGas, BigInteger fastMaxFeePerGas) {
        m.g(fastPriorityFee, "fastPriorityFee");
        m.g(normalPriorityFee, "normalPriorityFee");
        m.g(slowPriorityFee, "slowPriorityFee");
        m.g(baseFee, "baseFee");
        m.g(slowMaxFeePerGas, "slowMaxFeePerGas");
        m.g(normalMaxFeePerGas, "normalMaxFeePerGas");
        m.g(fastMaxFeePerGas, "fastMaxFeePerGas");
        this.fastPriorityFee = fastPriorityFee;
        this.normalPriorityFee = normalPriorityFee;
        this.slowPriorityFee = slowPriorityFee;
        this.baseFee = baseFee;
        this.slowMaxFeePerGas = slowMaxFeePerGas;
        this.normalMaxFeePerGas = normalMaxFeePerGas;
        this.fastMaxFeePerGas = fastMaxFeePerGas;
    }

    public static /* synthetic */ AdjustableMinerFee1559Result copy$default(AdjustableMinerFee1559Result adjustableMinerFee1559Result, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = adjustableMinerFee1559Result.fastPriorityFee;
        }
        if ((i2 & 2) != 0) {
            bigInteger2 = adjustableMinerFee1559Result.normalPriorityFee;
        }
        BigInteger bigInteger8 = bigInteger2;
        if ((i2 & 4) != 0) {
            bigInteger3 = adjustableMinerFee1559Result.slowPriorityFee;
        }
        BigInteger bigInteger9 = bigInteger3;
        if ((i2 & 8) != 0) {
            bigInteger4 = adjustableMinerFee1559Result.baseFee;
        }
        BigInteger bigInteger10 = bigInteger4;
        if ((i2 & 16) != 0) {
            bigInteger5 = adjustableMinerFee1559Result.slowMaxFeePerGas;
        }
        BigInteger bigInteger11 = bigInteger5;
        if ((i2 & 32) != 0) {
            bigInteger6 = adjustableMinerFee1559Result.normalMaxFeePerGas;
        }
        BigInteger bigInteger12 = bigInteger6;
        if ((i2 & 64) != 0) {
            bigInteger7 = adjustableMinerFee1559Result.fastMaxFeePerGas;
        }
        return adjustableMinerFee1559Result.copy(bigInteger, bigInteger8, bigInteger9, bigInteger10, bigInteger11, bigInteger12, bigInteger7);
    }

    public final BigInteger component1() {
        return this.fastPriorityFee;
    }

    public final BigInteger component2() {
        return this.normalPriorityFee;
    }

    public final BigInteger component3() {
        return this.slowPriorityFee;
    }

    public final BigInteger component4() {
        return this.baseFee;
    }

    public final BigInteger component5() {
        return this.slowMaxFeePerGas;
    }

    public final BigInteger component6() {
        return this.normalMaxFeePerGas;
    }

    public final BigInteger component7() {
        return this.fastMaxFeePerGas;
    }

    public final AdjustableMinerFee1559Result copy(BigInteger fastPriorityFee, BigInteger normalPriorityFee, BigInteger slowPriorityFee, BigInteger baseFee, BigInteger slowMaxFeePerGas, BigInteger normalMaxFeePerGas, BigInteger fastMaxFeePerGas) {
        m.g(fastPriorityFee, "fastPriorityFee");
        m.g(normalPriorityFee, "normalPriorityFee");
        m.g(slowPriorityFee, "slowPriorityFee");
        m.g(baseFee, "baseFee");
        m.g(slowMaxFeePerGas, "slowMaxFeePerGas");
        m.g(normalMaxFeePerGas, "normalMaxFeePerGas");
        m.g(fastMaxFeePerGas, "fastMaxFeePerGas");
        return new AdjustableMinerFee1559Result(fastPriorityFee, normalPriorityFee, slowPriorityFee, baseFee, slowMaxFeePerGas, normalMaxFeePerGas, fastMaxFeePerGas);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFee1559Result) {
            AdjustableMinerFee1559Result adjustableMinerFee1559Result = (AdjustableMinerFee1559Result) obj;
            return m.c(this.fastPriorityFee, adjustableMinerFee1559Result.fastPriorityFee) && m.c(this.normalPriorityFee, adjustableMinerFee1559Result.normalPriorityFee) && m.c(this.slowPriorityFee, adjustableMinerFee1559Result.slowPriorityFee) && m.c(this.baseFee, adjustableMinerFee1559Result.baseFee) && m.c(this.slowMaxFeePerGas, adjustableMinerFee1559Result.slowMaxFeePerGas) && m.c(this.normalMaxFeePerGas, adjustableMinerFee1559Result.normalMaxFeePerGas) && m.c(this.fastMaxFeePerGas, adjustableMinerFee1559Result.fastMaxFeePerGas);
        }
        return false;
    }

    public final BigInteger getBaseFee() {
        return this.baseFee;
    }

    public final BigInteger getFastMaxFeePerGas() {
        return this.fastMaxFeePerGas;
    }

    public final BigInteger getFastPriorityFee() {
        return this.fastPriorityFee;
    }

    public final BigInteger getNormalMaxFeePerGas() {
        return this.normalMaxFeePerGas;
    }

    public final BigInteger getNormalPriorityFee() {
        return this.normalPriorityFee;
    }

    public final BigInteger getSlowMaxFeePerGas() {
        return this.slowMaxFeePerGas;
    }

    public final BigInteger getSlowPriorityFee() {
        return this.slowPriorityFee;
    }

    public int hashCode() {
        return (((((((((((this.fastPriorityFee.hashCode() * 31) + this.normalPriorityFee.hashCode()) * 31) + this.slowPriorityFee.hashCode()) * 31) + this.baseFee.hashCode()) * 31) + this.slowMaxFeePerGas.hashCode()) * 31) + this.normalMaxFeePerGas.hashCode()) * 31) + this.fastMaxFeePerGas.hashCode();
    }

    public String toString() {
        return "AdjustableMinerFee1559Result(fastPriorityFee=" + this.fastPriorityFee + ", normalPriorityFee=" + this.normalPriorityFee + ", slowPriorityFee=" + this.slowPriorityFee + ", baseFee=" + this.baseFee + ", slowMaxFeePerGas=" + this.slowMaxFeePerGas + ", normalMaxFeePerGas=" + this.normalMaxFeePerGas + ", fastMaxFeePerGas=" + this.fastMaxFeePerGas + ')';
    }
}