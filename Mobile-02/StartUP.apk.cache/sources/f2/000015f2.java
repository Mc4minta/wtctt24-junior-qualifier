package com.coinbase.wallet.consumer.dtos;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerSendFeeResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeEstimateDTO;", "", "Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeDTO;", "component1", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeDTO;", "userFee", "copy", "(Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeDTO;)Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeEstimateDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeDTO;", "getUserFee", "<init>", "(Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeDTO;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSendFeeEstimateDTO {
    private final ConsumerSendFeeDTO userFee;

    public ConsumerSendFeeEstimateDTO(@Json(name = "user_fee") ConsumerSendFeeDTO userFee) {
        m.g(userFee, "userFee");
        this.userFee = userFee;
    }

    public static /* synthetic */ ConsumerSendFeeEstimateDTO copy$default(ConsumerSendFeeEstimateDTO consumerSendFeeEstimateDTO, ConsumerSendFeeDTO consumerSendFeeDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            consumerSendFeeDTO = consumerSendFeeEstimateDTO.userFee;
        }
        return consumerSendFeeEstimateDTO.copy(consumerSendFeeDTO);
    }

    public final ConsumerSendFeeDTO component1() {
        return this.userFee;
    }

    public final ConsumerSendFeeEstimateDTO copy(@Json(name = "user_fee") ConsumerSendFeeDTO userFee) {
        m.g(userFee, "userFee");
        return new ConsumerSendFeeEstimateDTO(userFee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumerSendFeeEstimateDTO) && m.c(this.userFee, ((ConsumerSendFeeEstimateDTO) obj).userFee);
    }

    public final ConsumerSendFeeDTO getUserFee() {
        return this.userFee;
    }

    public int hashCode() {
        return this.userFee.hashCode();
    }

    public String toString() {
        return "ConsumerSendFeeEstimateDTO(userFee=" + this.userFee + ')';
    }
}