package com.coinbase.wallet.consumer.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerUser.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b$\u0010\u0004R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/math/BigDecimal;", "component3", "()Ljava/math/BigDecimal;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component4", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component5", "()Ljava/util/List;", "id", "email", "withdrawalLimit", AppsFlyerProperties.CURRENCY_CODE, "restrictions", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/List;)Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/math/BigDecimal;", "getWithdrawalLimit", "Ljava/lang/String;", "getId", "getEmail", "Ljava/util/List;", "getRestrictions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/List;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerUser {
    private final CurrencyCode currencyCode;
    private final String email;
    private final String id;
    private final List<String> restrictions;
    private final BigDecimal withdrawalLimit;

    public ConsumerUser(String id, String email, BigDecimal withdrawalLimit, CurrencyCode currencyCode, List<String> restrictions) {
        m.g(id, "id");
        m.g(email, "email");
        m.g(withdrawalLimit, "withdrawalLimit");
        m.g(currencyCode, "currencyCode");
        m.g(restrictions, "restrictions");
        this.id = id;
        this.email = email;
        this.withdrawalLimit = withdrawalLimit;
        this.currencyCode = currencyCode;
        this.restrictions = restrictions;
    }

    public static /* synthetic */ ConsumerUser copy$default(ConsumerUser consumerUser, String str, String str2, BigDecimal bigDecimal, CurrencyCode currencyCode, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerUser.id;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerUser.email;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            bigDecimal = consumerUser.withdrawalLimit;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if ((i2 & 8) != 0) {
            currencyCode = consumerUser.currencyCode;
        }
        CurrencyCode currencyCode2 = currencyCode;
        List<String> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = consumerUser.restrictions;
        }
        return consumerUser.copy(str, str3, bigDecimal2, currencyCode2, list2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.email;
    }

    public final BigDecimal component3() {
        return this.withdrawalLimit;
    }

    public final CurrencyCode component4() {
        return this.currencyCode;
    }

    public final List<String> component5() {
        return this.restrictions;
    }

    public final ConsumerUser copy(String id, String email, BigDecimal withdrawalLimit, CurrencyCode currencyCode, List<String> restrictions) {
        m.g(id, "id");
        m.g(email, "email");
        m.g(withdrawalLimit, "withdrawalLimit");
        m.g(currencyCode, "currencyCode");
        m.g(restrictions, "restrictions");
        return new ConsumerUser(id, email, withdrawalLimit, currencyCode, restrictions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerUser) {
            ConsumerUser consumerUser = (ConsumerUser) obj;
            return m.c(this.id, consumerUser.id) && m.c(this.email, consumerUser.email) && m.c(this.withdrawalLimit, consumerUser.withdrawalLimit) && m.c(this.currencyCode, consumerUser.currencyCode) && m.c(this.restrictions, consumerUser.restrictions);
        }
        return false;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getRestrictions() {
        return this.restrictions;
    }

    public final BigDecimal getWithdrawalLimit() {
        return this.withdrawalLimit;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.email.hashCode()) * 31) + this.withdrawalLimit.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.restrictions.hashCode();
    }

    public String toString() {
        return "ConsumerUser(id=" + this.id + ", email=" + this.email + ", withdrawalLimit=" + this.withdrawalLimit + ", currencyCode=" + this.currencyCode + ", restrictions=" + this.restrictions + ')';
    }

    public /* synthetic */ ConsumerUser(String str, String str2, BigDecimal bigDecimal, CurrencyCode currencyCode, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bigDecimal, currencyCode, (i2 & 16) != 0 ? r.g() : list);
    }
}