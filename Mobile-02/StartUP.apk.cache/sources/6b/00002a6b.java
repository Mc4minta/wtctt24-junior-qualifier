package com.coinbase.walletengine.services.btclike;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BTCLikeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/walletengine/services/btclike/BigIntegerJsonAdapter;", "", "Ljava/math/BigInteger;", "value", "", "toJson", "(Ljava/math/BigInteger;)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)Ljava/math/BigInteger;", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class BigIntegerJsonAdapter {
    @FromJson
    public final BigInteger fromJson(String json) {
        m.g(json, "json");
        return new BigInteger(json);
    }

    @ToJson
    public final String toJson(BigInteger value) {
        m.g(value, "value");
        String bigInteger = value.toString(10);
        m.f(bigInteger, "value.toString(10)");
        return bigInteger;
    }
}