package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerLimitsDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ6\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\bR!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;", "", "", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitDTO;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "buy", ApiConstants.NAME, "type", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "Ljava/util/List;", "getBuy", "getName", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerLimitsDTO {
    private final List<ConsumerBuyLimitDTO> buy;
    private final String name;
    private final String type;

    public ConsumerLimitsDTO(List<ConsumerBuyLimitDTO> list, String name, String type) {
        m.g(name, "name");
        m.g(type, "type");
        this.buy = list;
        this.name = name;
        this.type = type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsumerLimitsDTO copy$default(ConsumerLimitsDTO consumerLimitsDTO, List list, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = consumerLimitsDTO.buy;
        }
        if ((i2 & 2) != 0) {
            str = consumerLimitsDTO.name;
        }
        if ((i2 & 4) != 0) {
            str2 = consumerLimitsDTO.type;
        }
        return consumerLimitsDTO.copy(list, str, str2);
    }

    public final List<ConsumerBuyLimitDTO> component1() {
        return this.buy;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.type;
    }

    public final ConsumerLimitsDTO copy(List<ConsumerBuyLimitDTO> list, String name, String type) {
        m.g(name, "name");
        m.g(type, "type");
        return new ConsumerLimitsDTO(list, name, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerLimitsDTO) {
            ConsumerLimitsDTO consumerLimitsDTO = (ConsumerLimitsDTO) obj;
            return m.c(this.buy, consumerLimitsDTO.buy) && m.c(this.name, consumerLimitsDTO.name) && m.c(this.type, consumerLimitsDTO.type);
        }
        return false;
    }

    public final List<ConsumerBuyLimitDTO> getBuy() {
        return this.buy;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        List<ConsumerBuyLimitDTO> list = this.buy;
        return ((((list == null ? 0 : list.hashCode()) * 31) + this.name.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ConsumerLimitsDTO(buy=" + this.buy + ", name=" + this.name + ", type=" + this.type + ')';
    }
}