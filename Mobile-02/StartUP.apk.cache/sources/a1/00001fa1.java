package com.coinbase.wallet.features.send.models;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeInfo;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "", "component2", "()Ljava/lang/String;", "component3", "gasPrice", "fiatFee", "cryptoFee", "copy", "(Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFiatFee", "Ljava/math/BigInteger;", "getGasPrice", "getCryptoFee", "<init>", "(Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeInfo {
    private final String cryptoFee;
    private final String fiatFee;
    private final BigInteger gasPrice;

    public AdjustableMinerFeeInfo(BigInteger gasPrice, String fiatFee, String cryptoFee) {
        m.g(gasPrice, "gasPrice");
        m.g(fiatFee, "fiatFee");
        m.g(cryptoFee, "cryptoFee");
        this.gasPrice = gasPrice;
        this.fiatFee = fiatFee;
        this.cryptoFee = cryptoFee;
    }

    public static /* synthetic */ AdjustableMinerFeeInfo copy$default(AdjustableMinerFeeInfo adjustableMinerFeeInfo, BigInteger bigInteger, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = adjustableMinerFeeInfo.gasPrice;
        }
        if ((i2 & 2) != 0) {
            str = adjustableMinerFeeInfo.fiatFee;
        }
        if ((i2 & 4) != 0) {
            str2 = adjustableMinerFeeInfo.cryptoFee;
        }
        return adjustableMinerFeeInfo.copy(bigInteger, str, str2);
    }

    public final BigInteger component1() {
        return this.gasPrice;
    }

    public final String component2() {
        return this.fiatFee;
    }

    public final String component3() {
        return this.cryptoFee;
    }

    public final AdjustableMinerFeeInfo copy(BigInteger gasPrice, String fiatFee, String cryptoFee) {
        m.g(gasPrice, "gasPrice");
        m.g(fiatFee, "fiatFee");
        m.g(cryptoFee, "cryptoFee");
        return new AdjustableMinerFeeInfo(gasPrice, fiatFee, cryptoFee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFeeInfo) {
            AdjustableMinerFeeInfo adjustableMinerFeeInfo = (AdjustableMinerFeeInfo) obj;
            return m.c(this.gasPrice, adjustableMinerFeeInfo.gasPrice) && m.c(this.fiatFee, adjustableMinerFeeInfo.fiatFee) && m.c(this.cryptoFee, adjustableMinerFeeInfo.cryptoFee);
        }
        return false;
    }

    public final String getCryptoFee() {
        return this.cryptoFee;
    }

    public final String getFiatFee() {
        return this.fiatFee;
    }

    public final BigInteger getGasPrice() {
        return this.gasPrice;
    }

    public int hashCode() {
        return (((this.gasPrice.hashCode() * 31) + this.fiatFee.hashCode()) * 31) + this.cryptoFee.hashCode();
    }

    public String toString() {
        return "AdjustableMinerFeeInfo(gasPrice=" + this.gasPrice + ", fiatFee=" + this.fiatFee + ", cryptoFee=" + this.cryptoFee + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AdjustableMinerFeeInfo(java.math.BigInteger r1, java.lang.String r2, java.lang.String r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 1
            if (r4 == 0) goto Lb
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            java.lang.String r4 = "ZERO"
            kotlin.jvm.internal.m.f(r1, r4)
        Lb:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.models.AdjustableMinerFeeInfo.<init>(java.math.BigInteger, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}