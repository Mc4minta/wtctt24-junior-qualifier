package com.coinbase.wallet.features.send.models;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFee1559Info.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Infos;", "", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;", "component1", "()Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;", "component2", "component3", "slow", "normal", "fast", "copy", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Infos;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;", "getFast", "getNormal", "getSlow", "<init>", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Info;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559Infos {
    private final AdjustableMinerFee1559Info fast;
    private final AdjustableMinerFee1559Info normal;
    private final AdjustableMinerFee1559Info slow;

    public AdjustableMinerFee1559Infos(AdjustableMinerFee1559Info slow, AdjustableMinerFee1559Info normal, AdjustableMinerFee1559Info fast) {
        m.g(slow, "slow");
        m.g(normal, "normal");
        m.g(fast, "fast");
        this.slow = slow;
        this.normal = normal;
        this.fast = fast;
    }

    public static /* synthetic */ AdjustableMinerFee1559Infos copy$default(AdjustableMinerFee1559Infos adjustableMinerFee1559Infos, AdjustableMinerFee1559Info adjustableMinerFee1559Info, AdjustableMinerFee1559Info adjustableMinerFee1559Info2, AdjustableMinerFee1559Info adjustableMinerFee1559Info3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            adjustableMinerFee1559Info = adjustableMinerFee1559Infos.slow;
        }
        if ((i2 & 2) != 0) {
            adjustableMinerFee1559Info2 = adjustableMinerFee1559Infos.normal;
        }
        if ((i2 & 4) != 0) {
            adjustableMinerFee1559Info3 = adjustableMinerFee1559Infos.fast;
        }
        return adjustableMinerFee1559Infos.copy(adjustableMinerFee1559Info, adjustableMinerFee1559Info2, adjustableMinerFee1559Info3);
    }

    public final AdjustableMinerFee1559Info component1() {
        return this.slow;
    }

    public final AdjustableMinerFee1559Info component2() {
        return this.normal;
    }

    public final AdjustableMinerFee1559Info component3() {
        return this.fast;
    }

    public final AdjustableMinerFee1559Infos copy(AdjustableMinerFee1559Info slow, AdjustableMinerFee1559Info normal, AdjustableMinerFee1559Info fast) {
        m.g(slow, "slow");
        m.g(normal, "normal");
        m.g(fast, "fast");
        return new AdjustableMinerFee1559Infos(slow, normal, fast);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFee1559Infos) {
            AdjustableMinerFee1559Infos adjustableMinerFee1559Infos = (AdjustableMinerFee1559Infos) obj;
            return m.c(this.slow, adjustableMinerFee1559Infos.slow) && m.c(this.normal, adjustableMinerFee1559Infos.normal) && m.c(this.fast, adjustableMinerFee1559Infos.fast);
        }
        return false;
    }

    public final AdjustableMinerFee1559Info getFast() {
        return this.fast;
    }

    public final AdjustableMinerFee1559Info getNormal() {
        return this.normal;
    }

    public final AdjustableMinerFee1559Info getSlow() {
        return this.slow;
    }

    public int hashCode() {
        return (((this.slow.hashCode() * 31) + this.normal.hashCode()) * 31) + this.fast.hashCode();
    }

    public String toString() {
        return "AdjustableMinerFee1559Infos(slow=" + this.slow + ", normal=" + this.normal + ", fast=" + this.fast + ')';
    }
}