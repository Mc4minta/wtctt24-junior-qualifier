package com.amplitude.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class l {
    private static d a = d.d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.length() == 0) {
            return new JSONObject();
        }
        try {
            jSONArray = jSONObject.names();
        } catch (ArrayIndexOutOfBoundsException e2) {
            a.b("com.amplitude.api.Utils", e2.toString());
            jSONArray = null;
        }
        int length = jSONArray != null ? jSONArray.length() : 0;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = jSONArray.optString(i2);
        }
        try {
            return new JSONObject(jSONObject, strArr);
        } catch (JSONException e3) {
            a.b("com.amplitude.api.Utils", e3.toString());
            return null;
        }
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        if (b(str)) {
            str = "$default_instance";
        }
        return str.toLowerCase();
    }
}