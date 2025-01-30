package com.coinbase.wallet.common.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* compiled from: JsonObject+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lorg/json/JSONObject;", "", "key", "getSafeString", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class JsonObject_CommonKt {
    public static final String getSafeString(JSONObject jSONObject, String key) {
        m.g(jSONObject, "<this>");
        m.g(key, "key");
        try {
            Object obj = jSONObject.get(key);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return null;
        }
    }
}