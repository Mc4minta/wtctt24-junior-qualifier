package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerNetworkAmountDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "amount", ApiConstants.CURRENCY, "scale", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getScale", "Ljava/lang/String;", "getCurrency", "getAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerNetworkAmountDTO {
    private final String amount;
    private final String currency;
    private final Integer scale;

    public ConsumerNetworkAmountDTO(String amount, String currency, Integer num) {
        m.g(amount, "amount");
        m.g(currency, "currency");
        this.amount = amount;
        this.currency = currency;
        this.scale = num;
    }

    public static /* synthetic */ ConsumerNetworkAmountDTO copy$default(ConsumerNetworkAmountDTO consumerNetworkAmountDTO, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerNetworkAmountDTO.amount;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerNetworkAmountDTO.currency;
        }
        if ((i2 & 4) != 0) {
            num = consumerNetworkAmountDTO.scale;
        }
        return consumerNetworkAmountDTO.copy(str, str2, num);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.currency;
    }

    public final Integer component3() {
        return this.scale;
    }

    public final ConsumerNetworkAmountDTO copy(String amount, String currency, Integer num) {
        m.g(amount, "amount");
        m.g(currency, "currency");
        return new ConsumerNetworkAmountDTO(amount, currency, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerNetworkAmountDTO) {
            ConsumerNetworkAmountDTO consumerNetworkAmountDTO = (ConsumerNetworkAmountDTO) obj;
            return m.c(this.amount, consumerNetworkAmountDTO.amount) && m.c(this.currency, consumerNetworkAmountDTO.currency) && m.c(this.scale, consumerNetworkAmountDTO.scale);
        }
        return false;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Integer getScale() {
        return this.scale;
    }

    public int hashCode() {
        int hashCode = ((this.amount.hashCode() * 31) + this.currency.hashCode()) * 31;
        Integer num = this.scale;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "ConsumerNetworkAmountDTO(amount=" + this.amount + ", currency=" + this.currency + ", scale=" + this.scale + ')';
    }

    public /* synthetic */ ConsumerNetworkAmountDTO(String str, String str2, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : num);
    }
}