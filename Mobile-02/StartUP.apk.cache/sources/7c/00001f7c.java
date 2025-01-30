package com.coinbase.wallet.features.send.dtos;

import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJH\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b \u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeResultDTO;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "component2", "component3", "component4", "", "Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTO;", "component5", "()Ljava/util/List;", "slow", "normal", "fast", "blockNum", "waitTimes", "copy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/util/List;)Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeResultDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getFast", "getBlockNum", "getNormal", "getSlow", "Ljava/util/List;", "getWaitTimes", "<init>", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/util/List;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeResultDTO {
    private final BigInteger blockNum;
    private final BigInteger fast;
    private final BigInteger normal;
    private final BigInteger slow;
    private final List<AdjustableMinerFeeWaitTimeDTO> waitTimes;

    public AdjustableMinerFeeResultDTO(BigInteger slow, BigInteger normal, BigInteger fast, BigInteger blockNum, List<AdjustableMinerFeeWaitTimeDTO> waitTimes) {
        m.g(slow, "slow");
        m.g(normal, "normal");
        m.g(fast, "fast");
        m.g(blockNum, "blockNum");
        m.g(waitTimes, "waitTimes");
        this.slow = slow;
        this.normal = normal;
        this.fast = fast;
        this.blockNum = blockNum;
        this.waitTimes = waitTimes;
    }

    public static /* synthetic */ AdjustableMinerFeeResultDTO copy$default(AdjustableMinerFeeResultDTO adjustableMinerFeeResultDTO, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = adjustableMinerFeeResultDTO.slow;
        }
        if ((i2 & 2) != 0) {
            bigInteger2 = adjustableMinerFeeResultDTO.normal;
        }
        BigInteger bigInteger5 = bigInteger2;
        if ((i2 & 4) != 0) {
            bigInteger3 = adjustableMinerFeeResultDTO.fast;
        }
        BigInteger bigInteger6 = bigInteger3;
        if ((i2 & 8) != 0) {
            bigInteger4 = adjustableMinerFeeResultDTO.blockNum;
        }
        BigInteger bigInteger7 = bigInteger4;
        List<AdjustableMinerFeeWaitTimeDTO> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = adjustableMinerFeeResultDTO.waitTimes;
        }
        return adjustableMinerFeeResultDTO.copy(bigInteger, bigInteger5, bigInteger6, bigInteger7, list2);
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

    public final BigInteger component4() {
        return this.blockNum;
    }

    public final List<AdjustableMinerFeeWaitTimeDTO> component5() {
        return this.waitTimes;
    }

    public final AdjustableMinerFeeResultDTO copy(BigInteger slow, BigInteger normal, BigInteger fast, BigInteger blockNum, List<AdjustableMinerFeeWaitTimeDTO> waitTimes) {
        m.g(slow, "slow");
        m.g(normal, "normal");
        m.g(fast, "fast");
        m.g(blockNum, "blockNum");
        m.g(waitTimes, "waitTimes");
        return new AdjustableMinerFeeResultDTO(slow, normal, fast, blockNum, waitTimes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFeeResultDTO) {
            AdjustableMinerFeeResultDTO adjustableMinerFeeResultDTO = (AdjustableMinerFeeResultDTO) obj;
            return m.c(this.slow, adjustableMinerFeeResultDTO.slow) && m.c(this.normal, adjustableMinerFeeResultDTO.normal) && m.c(this.fast, adjustableMinerFeeResultDTO.fast) && m.c(this.blockNum, adjustableMinerFeeResultDTO.blockNum) && m.c(this.waitTimes, adjustableMinerFeeResultDTO.waitTimes);
        }
        return false;
    }

    public final BigInteger getBlockNum() {
        return this.blockNum;
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

    public final List<AdjustableMinerFeeWaitTimeDTO> getWaitTimes() {
        return this.waitTimes;
    }

    public int hashCode() {
        return (((((((this.slow.hashCode() * 31) + this.normal.hashCode()) * 31) + this.fast.hashCode()) * 31) + this.blockNum.hashCode()) * 31) + this.waitTimes.hashCode();
    }

    public String toString() {
        return "AdjustableMinerFeeResultDTO(slow=" + this.slow + ", normal=" + this.normal + ", fast=" + this.fast + ", blockNum=" + this.blockNum + ", waitTimes=" + this.waitTimes + ')';
    }
}