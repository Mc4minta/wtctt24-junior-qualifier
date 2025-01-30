package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerBuyOrderRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J`\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\tR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b%\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b&\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTO;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "()Ljava/lang/Boolean;", "component4", "component5", "component6", "component7", ApiConstants.CURRENCY, ApiConstants.COMMIT, ApiConstants.QUOTE, "amount", ApiConstants.TOTAL, "paymentMethod", "recurringPeriod", "copy", "(Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTO;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getQuote", "Ljava/lang/String;", "getTotal", "getPaymentMethod", "Z", "getCommit", "getAmount", "getRecurringPeriod", "getCurrency", "<init>", "(Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerBuyOrderRequestDTO {
    private final String amount;
    private final boolean commit;
    private final String currency;
    private final String paymentMethod;
    private final Boolean quote;
    private final String recurringPeriod;
    private final String total;

    public ConsumerBuyOrderRequestDTO(String currency, boolean z, Boolean bool, String str, String str2, @Json(name = "payment_method") String str3, @Json(name = "recurring_period") String str4) {
        m.g(currency, "currency");
        this.currency = currency;
        this.commit = z;
        this.quote = bool;
        this.amount = str;
        this.total = str2;
        this.paymentMethod = str3;
        this.recurringPeriod = str4;
    }

    public static /* synthetic */ ConsumerBuyOrderRequestDTO copy$default(ConsumerBuyOrderRequestDTO consumerBuyOrderRequestDTO, String str, boolean z, Boolean bool, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerBuyOrderRequestDTO.currency;
        }
        if ((i2 & 2) != 0) {
            z = consumerBuyOrderRequestDTO.commit;
        }
        boolean z2 = z;
        if ((i2 & 4) != 0) {
            bool = consumerBuyOrderRequestDTO.quote;
        }
        Boolean bool2 = bool;
        if ((i2 & 8) != 0) {
            str2 = consumerBuyOrderRequestDTO.amount;
        }
        String str6 = str2;
        if ((i2 & 16) != 0) {
            str3 = consumerBuyOrderRequestDTO.total;
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = consumerBuyOrderRequestDTO.paymentMethod;
        }
        String str8 = str4;
        if ((i2 & 64) != 0) {
            str5 = consumerBuyOrderRequestDTO.recurringPeriod;
        }
        return consumerBuyOrderRequestDTO.copy(str, z2, bool2, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.currency;
    }

    public final boolean component2() {
        return this.commit;
    }

    public final Boolean component3() {
        return this.quote;
    }

    public final String component4() {
        return this.amount;
    }

    public final String component5() {
        return this.total;
    }

    public final String component6() {
        return this.paymentMethod;
    }

    public final String component7() {
        return this.recurringPeriod;
    }

    public final ConsumerBuyOrderRequestDTO copy(String currency, boolean z, Boolean bool, String str, String str2, @Json(name = "payment_method") String str3, @Json(name = "recurring_period") String str4) {
        m.g(currency, "currency");
        return new ConsumerBuyOrderRequestDTO(currency, z, bool, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerBuyOrderRequestDTO) {
            ConsumerBuyOrderRequestDTO consumerBuyOrderRequestDTO = (ConsumerBuyOrderRequestDTO) obj;
            return m.c(this.currency, consumerBuyOrderRequestDTO.currency) && this.commit == consumerBuyOrderRequestDTO.commit && m.c(this.quote, consumerBuyOrderRequestDTO.quote) && m.c(this.amount, consumerBuyOrderRequestDTO.amount) && m.c(this.total, consumerBuyOrderRequestDTO.total) && m.c(this.paymentMethod, consumerBuyOrderRequestDTO.paymentMethod) && m.c(this.recurringPeriod, consumerBuyOrderRequestDTO.recurringPeriod);
        }
        return false;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final boolean getCommit() {
        return this.commit;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    public final Boolean getQuote() {
        return this.quote;
    }

    public final String getRecurringPeriod() {
        return this.recurringPeriod;
    }

    public final String getTotal() {
        return this.total;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.currency.hashCode() * 31;
        boolean z = this.commit;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        Boolean bool = this.quote;
        int hashCode2 = (i3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.amount;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.total;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.paymentMethod;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.recurringPeriod;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ConsumerBuyOrderRequestDTO(currency=" + this.currency + ", commit=" + this.commit + ", quote=" + this.quote + ", amount=" + ((Object) this.amount) + ", total=" + ((Object) this.total) + ", paymentMethod=" + ((Object) this.paymentMethod) + ", recurringPeriod=" + ((Object) this.recurringPeriod) + ')';
    }

    public /* synthetic */ ConsumerBuyOrderRequestDTO(String str, boolean z, Boolean bool, String str2, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : bool, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) == 0 ? str5 : null);
    }
}