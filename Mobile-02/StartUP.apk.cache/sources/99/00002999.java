package com.coinbase.wallet.wallets.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ExchangeRate.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b*\u0010+B=\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b*\u0010,J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJP\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001f\u0010\fR\u001c\u0010\u0019\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\n8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b$\u0010\fR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010\u0015R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\"\u001a\u0004\b)\u0010\f¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component2", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Ljava/math/BigDecimal;", "component3", "()Ljava/math/BigDecimal;", "component4", "component5", "()Ljava/lang/Integer;", "component6", "id", AppsFlyerProperties.CURRENCY_CODE, "rate", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CHAIN_ID, ApiConstants.NAME, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "toString", "Ljava/math/BigDecimal;", "getRate", "Ljava/lang/String;", "getId", "getContractAddress", "Ljava/lang/Integer;", "getChainId", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "getName", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ExchangeRate implements DatabaseModelObject {
    private final Integer chainId;
    private final String contractAddress;
    private final CurrencyCode currencyCode;
    private final String id;
    private final String name;
    private final BigDecimal rate;

    public ExchangeRate(String id, CurrencyCode currencyCode, BigDecimal rate, String str, Integer num, String name) {
        m.g(id, "id");
        m.g(currencyCode, "currencyCode");
        m.g(rate, "rate");
        m.g(name, "name");
        this.id = id;
        this.currencyCode = currencyCode;
        this.rate = rate;
        this.contractAddress = str;
        this.chainId = num;
        this.name = name;
    }

    public static /* synthetic */ ExchangeRate copy$default(ExchangeRate exchangeRate, String str, CurrencyCode currencyCode, BigDecimal bigDecimal, String str2, Integer num, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = exchangeRate.getId();
        }
        if ((i2 & 2) != 0) {
            currencyCode = exchangeRate.currencyCode;
        }
        CurrencyCode currencyCode2 = currencyCode;
        if ((i2 & 4) != 0) {
            bigDecimal = exchangeRate.rate;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if ((i2 & 8) != 0) {
            str2 = exchangeRate.contractAddress;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            num = exchangeRate.chainId;
        }
        Integer num2 = num;
        if ((i2 & 32) != 0) {
            str3 = exchangeRate.name;
        }
        return exchangeRate.copy(str, currencyCode2, bigDecimal2, str4, num2, str3);
    }

    public final String component1() {
        return getId();
    }

    public final CurrencyCode component2() {
        return this.currencyCode;
    }

    public final BigDecimal component3() {
        return this.rate;
    }

    public final String component4() {
        return this.contractAddress;
    }

    public final Integer component5() {
        return this.chainId;
    }

    public final String component6() {
        return this.name;
    }

    public final ExchangeRate copy(String id, CurrencyCode currencyCode, BigDecimal rate, String str, Integer num, String name) {
        m.g(id, "id");
        m.g(currencyCode, "currencyCode");
        m.g(rate, "rate");
        m.g(name, "name");
        return new ExchangeRate(id, currencyCode, rate, str, num, name);
    }

    public boolean equals(Object obj) {
        String id = getId();
        ExchangeRate exchangeRate = obj instanceof ExchangeRate ? (ExchangeRate) obj : null;
        return m.c(id, exchangeRate != null ? exchangeRate.getId() : null);
    }

    public final Integer getChainId() {
        return this.chainId;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final BigDecimal getRate() {
        return this.rate;
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return "ExchangeRate(id=" + getId() + ", currencyCode=" + this.currencyCode + ", rate=" + this.rate + ", contractAddress=" + ((Object) this.contractAddress) + ", chainId=" + this.chainId + ", name=" + this.name + ')';
    }

    public /* synthetic */ ExchangeRate(CurrencyCode currencyCode, BigDecimal bigDecimal, String str, Integer num, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(currencyCode, bigDecimal, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExchangeRate(com.coinbase.wallet.blockchains.models.CurrencyCode r10, java.math.BigDecimal r11, java.lang.String r12, java.lang.Integer r13, java.lang.String r14) {
        /*
            r9 = this;
            java.lang.String r0 = "currencyCode"
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "rate"
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r10.getRawValue()
            r0.append(r1)
            r1 = 47
            r0.append(r1)
            r0.append(r12)
            r0.append(r1)
            r0.append(r13)
            java.lang.String r3 = r0.toString()
            if (r14 != 0) goto L43
            java.lang.String r14 = r10.getRawValue()
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = "US"
            kotlin.jvm.internal.m.f(r0, r1)
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r14, r1)
            java.lang.String r14 = r14.toUpperCase(r0)
            java.lang.String r0 = "(this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.m.f(r14, r0)
        L43:
            r8 = r14
            r2 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.wallets.models.ExchangeRate.<init>(com.coinbase.wallet.blockchains.models.CurrencyCode, java.math.BigDecimal, java.lang.String, java.lang.Integer, java.lang.String):void");
    }
}