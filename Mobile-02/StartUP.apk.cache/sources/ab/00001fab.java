package com.coinbase.wallet.features.send.models;

import com.coinbase.ApiConstants;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeWaitTime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeWaitTime;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "component2", ApiConstants.PRICE, "waitTime", "copy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeWaitTime;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getPrice", "getWaitTime", "<init>", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeWaitTime {
    private final BigInteger price;
    private final BigInteger waitTime;

    public AdjustableMinerFeeWaitTime(BigInteger price, BigInteger waitTime) {
        m.g(price, "price");
        m.g(waitTime, "waitTime");
        this.price = price;
        this.waitTime = waitTime;
    }

    public static /* synthetic */ AdjustableMinerFeeWaitTime copy$default(AdjustableMinerFeeWaitTime adjustableMinerFeeWaitTime, BigInteger bigInteger, BigInteger bigInteger2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = adjustableMinerFeeWaitTime.price;
        }
        if ((i2 & 2) != 0) {
            bigInteger2 = adjustableMinerFeeWaitTime.waitTime;
        }
        return adjustableMinerFeeWaitTime.copy(bigInteger, bigInteger2);
    }

    public final BigInteger component1() {
        return this.price;
    }

    public final BigInteger component2() {
        return this.waitTime;
    }

    public final AdjustableMinerFeeWaitTime copy(BigInteger price, BigInteger waitTime) {
        m.g(price, "price");
        m.g(waitTime, "waitTime");
        return new AdjustableMinerFeeWaitTime(price, waitTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFeeWaitTime) {
            AdjustableMinerFeeWaitTime adjustableMinerFeeWaitTime = (AdjustableMinerFeeWaitTime) obj;
            return m.c(this.price, adjustableMinerFeeWaitTime.price) && m.c(this.waitTime, adjustableMinerFeeWaitTime.waitTime);
        }
        return false;
    }

    public final BigInteger getPrice() {
        return this.price;
    }

    public final BigInteger getWaitTime() {
        return this.waitTime;
    }

    public int hashCode() {
        return (this.price.hashCode() * 31) + this.waitTime.hashCode();
    }

    public String toString() {
        return "AdjustableMinerFeeWaitTime(price=" + this.price + ", waitTime=" + this.waitTime + ')';
    }
}