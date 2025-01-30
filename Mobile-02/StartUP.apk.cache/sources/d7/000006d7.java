package com.appsflyer;

import android.os.Build;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AFHelper {
    public static JSONObject convertToJsonObject(Map<String, ?> map) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new JSONObject(map);
        }
        return m10(map);
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static Object m9(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                for (Object obj2 : (Collection) obj) {
                    jSONArray.put(m9(obj2));
                }
                return jSONArray;
            } else if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < length; i2++) {
                    jSONArray2.put(m9(Array.get(obj, i2)));
                }
                return jSONArray2;
            } else if (obj instanceof Map) {
                return m10((Map) obj);
            } else {
                return ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj.toString();
            }
        } catch (Exception unused) {
            return JSONObject.NULL;
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static JSONObject m10(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), m9(entry.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}