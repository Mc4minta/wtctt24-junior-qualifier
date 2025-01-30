package com.coinbase.wallet.consumer.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.squareup.moshi.Json;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTx;", "", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "toAddress", "Ljava/lang/String;", "getToAddress", "()Ljava/lang/String;", "Ljava/util/Date;", "createdAt", "Ljava/util/Date;", "getCreatedAt", "()Ljava/util/Date;", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/Date;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTx {
    private final Date createdAt;
    private final CurrencyCode currencyCode;
    private final String toAddress;

    public ConsumerTx(String toAddress, CurrencyCode currencyCode, @Json(name = "created_at") Date createdAt) {
        m.g(toAddress, "toAddress");
        m.g(currencyCode, "currencyCode");
        m.g(createdAt, "createdAt");
        this.toAddress = toAddress;
        this.currencyCode = currencyCode;
        this.createdAt = createdAt;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getToAddress() {
        return this.toAddress;
    }
}