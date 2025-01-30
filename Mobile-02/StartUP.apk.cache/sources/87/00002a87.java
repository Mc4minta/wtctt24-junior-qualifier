package com.coinbase.walletengine.services.dogecoin;

import android.util.Base64;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: DogecoinService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/walletengine/services/dogecoin/ByteArrayJsonAdapter;", "", "", "value", "", "toJson", "([B)Ljava/lang/String;", "json", "fromJson", "(Ljava/lang/String;)[B", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ByteArrayJsonAdapter {
    @FromJson
    public final byte[] fromJson(String json) {
        m.g(json, "json");
        byte[] decode = Base64.decode(json, 0);
        m.f(decode, "decode(json, Base64.DEFAULT)");
        return decode;
    }

    @ToJson
    public final String toJson(byte[] value) {
        m.g(value, "value");
        String encodeToString = Base64.encodeToString(value, 2);
        m.f(encodeToString, "encodeToString(value, Base64.NO_WRAP)");
        return encodeToString;
    }
}