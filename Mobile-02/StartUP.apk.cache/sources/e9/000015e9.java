package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerPaymentMethodDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004Jv\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010\bJ\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010\bR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\rR\u0019\u0010\u001b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b-\u0010\bR\u0019\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u0010\u0010R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b2\u0010\bR\u0019\u0010\u0016\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b3\u0010\bR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b4\u0010\u0004¨\u00067"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodDTO;", "", "", "component1", "()Z", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "Lcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;", "component6", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;", "component7", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;", "component8", "component9", "component10", "allow_buy", "allow_sell", ApiConstants.CURRENCY, "id", "instant_buy", "limits", "minimum_purchase_amount", ApiConstants.NAME, "type", "verified", "copy", "(ZZLjava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;Ljava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodDTO;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAllow_buy", "Ljava/lang/String;", "getId", "Lcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;", "getLimits", "getName", "Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;", "getMinimum_purchase_amount", "getVerified", "getInstant_buy", "getType", "getCurrency", "getAllow_sell", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;Ljava/lang/String;Ljava/lang/String;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerPaymentMethodDTO {
    private final boolean allow_buy;
    private final boolean allow_sell;
    private final String currency;
    private final String id;
    private final boolean instant_buy;
    private final ConsumerLimitsDTO limits;
    private final ConsumerMinimumPurchaseAmountDTO minimum_purchase_amount;
    private final String name;
    private final String type;
    private final boolean verified;

    public ConsumerPaymentMethodDTO(boolean z, boolean z2, String currency, String id, boolean z3, ConsumerLimitsDTO consumerLimitsDTO, ConsumerMinimumPurchaseAmountDTO minimum_purchase_amount, String name, String type, boolean z4) {
        m.g(currency, "currency");
        m.g(id, "id");
        m.g(minimum_purchase_amount, "minimum_purchase_amount");
        m.g(name, "name");
        m.g(type, "type");
        this.allow_buy = z;
        this.allow_sell = z2;
        this.currency = currency;
        this.id = id;
        this.instant_buy = z3;
        this.limits = consumerLimitsDTO;
        this.minimum_purchase_amount = minimum_purchase_amount;
        this.name = name;
        this.type = type;
        this.verified = z4;
    }

    public final boolean component1() {
        return this.allow_buy;
    }

    public final boolean component10() {
        return this.verified;
    }

    public final boolean component2() {
        return this.allow_sell;
    }

    public final String component3() {
        return this.currency;
    }

    public final String component4() {
        return this.id;
    }

    public final boolean component5() {
        return this.instant_buy;
    }

    public final ConsumerLimitsDTO component6() {
        return this.limits;
    }

    public final ConsumerMinimumPurchaseAmountDTO component7() {
        return this.minimum_purchase_amount;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.type;
    }

    public final ConsumerPaymentMethodDTO copy(boolean z, boolean z2, String currency, String id, boolean z3, ConsumerLimitsDTO consumerLimitsDTO, ConsumerMinimumPurchaseAmountDTO minimum_purchase_amount, String name, String type, boolean z4) {
        m.g(currency, "currency");
        m.g(id, "id");
        m.g(minimum_purchase_amount, "minimum_purchase_amount");
        m.g(name, "name");
        m.g(type, "type");
        return new ConsumerPaymentMethodDTO(z, z2, currency, id, z3, consumerLimitsDTO, minimum_purchase_amount, name, type, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerPaymentMethodDTO) {
            ConsumerPaymentMethodDTO consumerPaymentMethodDTO = (ConsumerPaymentMethodDTO) obj;
            return this.allow_buy == consumerPaymentMethodDTO.allow_buy && this.allow_sell == consumerPaymentMethodDTO.allow_sell && m.c(this.currency, consumerPaymentMethodDTO.currency) && m.c(this.id, consumerPaymentMethodDTO.id) && this.instant_buy == consumerPaymentMethodDTO.instant_buy && m.c(this.limits, consumerPaymentMethodDTO.limits) && m.c(this.minimum_purchase_amount, consumerPaymentMethodDTO.minimum_purchase_amount) && m.c(this.name, consumerPaymentMethodDTO.name) && m.c(this.type, consumerPaymentMethodDTO.type) && this.verified == consumerPaymentMethodDTO.verified;
        }
        return false;
    }

    public final boolean getAllow_buy() {
        return this.allow_buy;
    }

    public final boolean getAllow_sell() {
        return this.allow_sell;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getInstant_buy() {
        return this.instant_buy;
    }

    public final ConsumerLimitsDTO getLimits() {
        return this.limits;
    }

    public final ConsumerMinimumPurchaseAmountDTO getMinimum_purchase_amount() {
        return this.minimum_purchase_amount;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getVerified() {
        return this.verified;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z = this.allow_buy;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        ?? r2 = this.allow_sell;
        int i3 = r2;
        if (r2 != 0) {
            i3 = 1;
        }
        int hashCode = (((((i2 + i3) * 31) + this.currency.hashCode()) * 31) + this.id.hashCode()) * 31;
        ?? r22 = this.instant_buy;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (hashCode + i4) * 31;
        ConsumerLimitsDTO consumerLimitsDTO = this.limits;
        int hashCode2 = (((((((i5 + (consumerLimitsDTO == null ? 0 : consumerLimitsDTO.hashCode())) * 31) + this.minimum_purchase_amount.hashCode()) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        boolean z2 = this.verified;
        return hashCode2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "ConsumerPaymentMethodDTO(allow_buy=" + this.allow_buy + ", allow_sell=" + this.allow_sell + ", currency=" + this.currency + ", id=" + this.id + ", instant_buy=" + this.instant_buy + ", limits=" + this.limits + ", minimum_purchase_amount=" + this.minimum_purchase_amount + ", name=" + this.name + ", type=" + this.type + ", verified=" + this.verified + ')';
    }

    public /* synthetic */ ConsumerPaymentMethodDTO(boolean z, boolean z2, String str, String str2, boolean z3, ConsumerLimitsDTO consumerLimitsDTO, ConsumerMinimumPurchaseAmountDTO consumerMinimumPurchaseAmountDTO, String str3, String str4, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, str, str2, z3, (i2 & 32) != 0 ? null : consumerLimitsDTO, consumerMinimumPurchaseAmountDTO, str3, str4, z4);
    }
}