package com.coinbase.wallet.txhistory.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CurrencyComponents.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/txhistory/models/CurrencyComponents;", "", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component1", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component2", "()I", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", AppsFlyerProperties.CURRENCY_CODE, "decimals", "value", "copy", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/math/BigInteger;)Lcom/coinbase/wallet/txhistory/models/CurrencyComponents;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getDecimals", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/math/BigInteger;", "getValue", "<init>", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/math/BigInteger;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CurrencyComponents {
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final BigInteger value;

    public CurrencyComponents(CurrencyCode currencyCode, int i2, BigInteger value) {
        m.g(currencyCode, "currencyCode");
        m.g(value, "value");
        this.currencyCode = currencyCode;
        this.decimals = i2;
        this.value = value;
    }

    public static /* synthetic */ CurrencyComponents copy$default(CurrencyComponents currencyComponents, CurrencyCode currencyCode, int i2, BigInteger bigInteger, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            currencyCode = currencyComponents.currencyCode;
        }
        if ((i3 & 2) != 0) {
            i2 = currencyComponents.decimals;
        }
        if ((i3 & 4) != 0) {
            bigInteger = currencyComponents.value;
        }
        return currencyComponents.copy(currencyCode, i2, bigInteger);
    }

    public final CurrencyCode component1() {
        return this.currencyCode;
    }

    public final int component2() {
        return this.decimals;
    }

    public final BigInteger component3() {
        return this.value;
    }

    public final CurrencyComponents copy(CurrencyCode currencyCode, int i2, BigInteger value) {
        m.g(currencyCode, "currencyCode");
        m.g(value, "value");
        return new CurrencyComponents(currencyCode, i2, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CurrencyComponents) {
            CurrencyComponents currencyComponents = (CurrencyComponents) obj;
            return m.c(this.currencyCode, currencyComponents.currencyCode) && this.decimals == currencyComponents.decimals && m.c(this.value, currencyComponents.value);
        }
        return false;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final BigInteger getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.currencyCode.hashCode() * 31) + this.decimals) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "CurrencyComponents(currencyCode=" + this.currencyCode + ", decimals=" + this.decimals + ", value=" + this.value + ')';
    }
}