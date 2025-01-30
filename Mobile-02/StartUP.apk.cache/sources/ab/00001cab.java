package com.coinbase.wallet.ethereum.models;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeWaitTime;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ>\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/AdjustableMinerFeeResponse;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "component2", "component3", "", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeWaitTime;", "component4", "()Ljava/util/List;", "slow", "normal", "fast", "waitTimes", "copy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/util/List;)Lcom/coinbase/wallet/ethereum/models/AdjustableMinerFeeResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getFast", "getSlow", "Ljava/util/List;", "getWaitTimes", "getNormal", "<init>", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/util/List;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeResponse {
    private final BigInteger fast;
    private final BigInteger normal;
    private final BigInteger slow;
    private final List<AdjustableMinerFeeWaitTime> waitTimes;

    public AdjustableMinerFeeResponse(BigInteger slow, BigInteger normal, BigInteger fast, List<AdjustableMinerFeeWaitTime> waitTimes) {
        m.g(slow, "slow");
        m.g(normal, "normal");
        m.g(fast, "fast");
        m.g(waitTimes, "waitTimes");
        this.slow = slow;
        this.normal = normal;
        this.fast = fast;
        this.waitTimes = waitTimes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdjustableMinerFeeResponse copy$default(AdjustableMinerFeeResponse adjustableMinerFeeResponse, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = adjustableMinerFeeResponse.slow;
        }
        if ((i2 & 2) != 0) {
            bigInteger2 = adjustableMinerFeeResponse.normal;
        }
        if ((i2 & 4) != 0) {
            bigInteger3 = adjustableMinerFeeResponse.fast;
        }
        if ((i2 & 8) != 0) {
            list = adjustableMinerFeeResponse.waitTimes;
        }
        return adjustableMinerFeeResponse.copy(bigInteger, bigInteger2, bigInteger3, list);
    }

    public final BigInteger component1() {
        return this.slow;
    }

    public final BigInteger component2() {
        return this.normal;
    }

    public final BigInteger component3() {
        return this.fast;
    }

    public final List<AdjustableMinerFeeWaitTime> component4() {
        return this.waitTimes;
    }

    public final AdjustableMinerFeeResponse copy(BigInteger slow, BigInteger normal, BigInteger fast, List<AdjustableMinerFeeWaitTime> waitTimes) {
        m.g(slow, "slow");
        m.g(normal, "normal");
        m.g(fast, "fast");
        m.g(waitTimes, "waitTimes");
        return new AdjustableMinerFeeResponse(slow, normal, fast, waitTimes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFeeResponse) {
            AdjustableMinerFeeResponse adjustableMinerFeeResponse = (AdjustableMinerFeeResponse) obj;
            return m.c(this.slow, adjustableMinerFeeResponse.slow) && m.c(this.normal, adjustableMinerFeeResponse.normal) && m.c(this.fast, adjustableMinerFeeResponse.fast) && m.c(this.waitTimes, adjustableMinerFeeResponse.waitTimes);
        }
        return false;
    }

    public final BigInteger getFast() {
        return this.fast;
    }

    public final BigInteger getNormal() {
        return this.normal;
    }

    public final BigInteger getSlow() {
        return this.slow;
    }

    public final List<AdjustableMinerFeeWaitTime> getWaitTimes() {
        return this.waitTimes;
    }

    public int hashCode() {
        return (((((this.slow.hashCode() * 31) + this.normal.hashCode()) * 31) + this.fast.hashCode()) * 31) + this.waitTimes.hashCode();
    }

    public String toString() {
        return "AdjustableMinerFeeResponse(slow=" + this.slow + ", normal=" + this.normal + ", fast=" + this.fast + ", waitTimes=" + this.waitTimes + ')';
    }
}