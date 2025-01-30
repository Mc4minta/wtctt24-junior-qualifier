package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerBuyLimitDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001d\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\bR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u000b¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitRemainingDTO;", "component4", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitRemainingDTO;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitTotalDTO;", "component5", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitTotalDTO;", ApiConstants.DESCRIPTION, "label", "period_in_days", "remaining", ApiConstants.TOTAL, "copy", "(Ljava/lang/String;Ljava/lang/String;ILcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitRemainingDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitTotalDTO;)Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitTotalDTO;", "getTotal", "Ljava/lang/String;", "getDescription", "getLabel", "I", "getPeriod_in_days", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitRemainingDTO;", "getRemaining", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitRemainingDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitTotalDTO;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerBuyLimitDTO {
    private final String description;
    private final String label;
    private final int period_in_days;
    private final ConsumerBuyLimitRemainingDTO remaining;
    private final ConsumerBuyLimitTotalDTO total;

    public ConsumerBuyLimitDTO(String description, String label, int i2, ConsumerBuyLimitRemainingDTO remaining, ConsumerBuyLimitTotalDTO total) {
        m.g(description, "description");
        m.g(label, "label");
        m.g(remaining, "remaining");
        m.g(total, "total");
        this.description = description;
        this.label = label;
        this.period_in_days = i2;
        this.remaining = remaining;
        this.total = total;
    }

    public static /* synthetic */ ConsumerBuyLimitDTO copy$default(ConsumerBuyLimitDTO consumerBuyLimitDTO, String str, String str2, int i2, ConsumerBuyLimitRemainingDTO consumerBuyLimitRemainingDTO, ConsumerBuyLimitTotalDTO consumerBuyLimitTotalDTO, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = consumerBuyLimitDTO.description;
        }
        if ((i3 & 2) != 0) {
            str2 = consumerBuyLimitDTO.label;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i2 = consumerBuyLimitDTO.period_in_days;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            consumerBuyLimitRemainingDTO = consumerBuyLimitDTO.remaining;
        }
        ConsumerBuyLimitRemainingDTO consumerBuyLimitRemainingDTO2 = consumerBuyLimitRemainingDTO;
        if ((i3 & 16) != 0) {
            consumerBuyLimitTotalDTO = consumerBuyLimitDTO.total;
        }
        return consumerBuyLimitDTO.copy(str, str3, i4, consumerBuyLimitRemainingDTO2, consumerBuyLimitTotalDTO);
    }

    public final String component1() {
        return this.description;
    }

    public final String component2() {
        return this.label;
    }

    public final int component3() {
        return this.period_in_days;
    }

    public final ConsumerBuyLimitRemainingDTO component4() {
        return this.remaining;
    }

    public final ConsumerBuyLimitTotalDTO component5() {
        return this.total;
    }

    public final ConsumerBuyLimitDTO copy(String description, String label, int i2, ConsumerBuyLimitRemainingDTO remaining, ConsumerBuyLimitTotalDTO total) {
        m.g(description, "description");
        m.g(label, "label");
        m.g(remaining, "remaining");
        m.g(total, "total");
        return new ConsumerBuyLimitDTO(description, label, i2, remaining, total);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerBuyLimitDTO) {
            ConsumerBuyLimitDTO consumerBuyLimitDTO = (ConsumerBuyLimitDTO) obj;
            return m.c(this.description, consumerBuyLimitDTO.description) && m.c(this.label, consumerBuyLimitDTO.label) && this.period_in_days == consumerBuyLimitDTO.period_in_days && m.c(this.remaining, consumerBuyLimitDTO.remaining) && m.c(this.total, consumerBuyLimitDTO.total);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getPeriod_in_days() {
        return this.period_in_days;
    }

    public final ConsumerBuyLimitRemainingDTO getRemaining() {
        return this.remaining;
    }

    public final ConsumerBuyLimitTotalDTO getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((((this.description.hashCode() * 31) + this.label.hashCode()) * 31) + this.period_in_days) * 31) + this.remaining.hashCode()) * 31) + this.total.hashCode();
    }

    public String toString() {
        return "ConsumerBuyLimitDTO(description=" + this.description + ", label=" + this.label + ", period_in_days=" + this.period_in_days + ", remaining=" + this.remaining + ", total=" + this.total + ')';
    }
}