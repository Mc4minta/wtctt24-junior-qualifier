package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerMinimumPurchaseAmountDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "amount", ApiConstants.CURRENCY, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCurrency", "getAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerMinimumPurchaseAmountDTO {
    private final String amount;
    private final String currency;

    public ConsumerMinimumPurchaseAmountDTO(String amount, String currency) {
        m.g(amount, "amount");
        m.g(currency, "currency");
        this.amount = amount;
        this.currency = currency;
    }

    public static /* synthetic */ ConsumerMinimumPurchaseAmountDTO copy$default(ConsumerMinimumPurchaseAmountDTO consumerMinimumPurchaseAmountDTO, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerMinimumPurchaseAmountDTO.amount;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerMinimumPurchaseAmountDTO.currency;
        }
        return consumerMinimumPurchaseAmountDTO.copy(str, str2);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.currency;
    }

    public final ConsumerMinimumPurchaseAmountDTO copy(String amount, String currency) {
        m.g(amount, "amount");
        m.g(currency, "currency");
        return new ConsumerMinimumPurchaseAmountDTO(amount, currency);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerMinimumPurchaseAmountDTO) {
            ConsumerMinimumPurchaseAmountDTO consumerMinimumPurchaseAmountDTO = (ConsumerMinimumPurchaseAmountDTO) obj;
            return m.c(this.amount, consumerMinimumPurchaseAmountDTO.amount) && m.c(this.currency, consumerMinimumPurchaseAmountDTO.currency);
        }
        return false;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        return (this.amount.hashCode() * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "ConsumerMinimumPurchaseAmountDTO(amount=" + this.amount + ", currency=" + this.currency + ')';
    }
}