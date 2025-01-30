package com.coinbase.wallet.swap.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapEstimateMinerFeeDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/swap/dtos/SwapEstimateMinerFeeResultDTO;", "", "", "component1", "()Ljava/lang/String;", "estimatedMinerFee", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/swap/dtos/SwapEstimateMinerFeeResultDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEstimatedMinerFee", "<init>", "(Ljava/lang/String;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapEstimateMinerFeeResultDTO {
    private final String estimatedMinerFee;

    public SwapEstimateMinerFeeResultDTO(String estimatedMinerFee) {
        m.g(estimatedMinerFee, "estimatedMinerFee");
        this.estimatedMinerFee = estimatedMinerFee;
    }

    public static /* synthetic */ SwapEstimateMinerFeeResultDTO copy$default(SwapEstimateMinerFeeResultDTO swapEstimateMinerFeeResultDTO, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = swapEstimateMinerFeeResultDTO.estimatedMinerFee;
        }
        return swapEstimateMinerFeeResultDTO.copy(str);
    }

    public final String component1() {
        return this.estimatedMinerFee;
    }

    public final SwapEstimateMinerFeeResultDTO copy(String estimatedMinerFee) {
        m.g(estimatedMinerFee, "estimatedMinerFee");
        return new SwapEstimateMinerFeeResultDTO(estimatedMinerFee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SwapEstimateMinerFeeResultDTO) && m.c(this.estimatedMinerFee, ((SwapEstimateMinerFeeResultDTO) obj).estimatedMinerFee);
    }

    public final String getEstimatedMinerFee() {
        return this.estimatedMinerFee;
    }

    public int hashCode() {
        return this.estimatedMinerFee.hashCode();
    }

    public String toString() {
        return "SwapEstimateMinerFeeResultDTO(estimatedMinerFee=" + this.estimatedMinerFee + ')';
    }
}