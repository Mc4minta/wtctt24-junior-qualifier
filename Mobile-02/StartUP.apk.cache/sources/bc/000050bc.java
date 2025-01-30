package io.branch.referral;

import com.coinbase.ApiConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ServerResponse.java */
/* loaded from: classes2.dex */
public class e0 {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private String f16944b;

    /* renamed from: c  reason: collision with root package name */
    private Object f16945c;

    public e0(String str, int i2) {
        this.f16944b = str;
        this.a = i2;
    }

    public JSONArray a() {
        Object obj = this.f16945c;
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        return null;
    }

    public String b() {
        try {
            JSONObject c2 = c();
            if (c2 != null && c2.has("error") && c2.getJSONObject("error").has(ApiConstants.MESSAGE)) {
                String string = c2.getJSONObject("error").getString(ApiConstants.MESSAGE);
                if (string == null || string.trim().length() <= 0) {
                    return string;
                }
                return string + ".";
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public JSONObject c() {
        Object obj = this.f16945c;
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return new JSONObject();
    }

    public int d() {
        return this.a;
    }

    public void e(Object obj) {
        this.f16945c = obj;
    }
}