package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class f {
    private static final Date a = new Date(0);

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f9426b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f9427c;

    /* renamed from: d  reason: collision with root package name */
    private Date f9428d;

    /* renamed from: e  reason: collision with root package name */
    private JSONArray f9429e;

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static class b {
        private JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        private Date f9430b;

        /* renamed from: c  reason: collision with root package name */
        private JSONArray f9431c;

        public f a() throws JSONException {
            return new f(this.a, this.f9430b, this.f9431c);
        }

        public b b(Map<String, String> map) {
            this.a = new JSONObject(map);
            return this;
        }

        public b c(JSONObject jSONObject) {
            try {
                this.a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b d(JSONArray jSONArray) {
            try {
                this.f9431c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b e(Date date) {
            this.f9430b = date;
            return this;
        }

        private b() {
            this.a = new JSONObject();
            this.f9430b = f.a;
            this.f9431c = new JSONArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f b(JSONObject jSONObject) throws JSONException {
        return new f(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
    }

    public static b f() {
        return new b();
    }

    public JSONArray c() {
        return this.f9429e;
    }

    public JSONObject d() {
        return this.f9427c;
    }

    public Date e() {
        return this.f9428d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return this.f9426b.toString().equals(((f) obj).toString());
        }
        return false;
    }

    public int hashCode() {
        return this.f9426b.hashCode();
    }

    public String toString() {
        return this.f9426b.toString();
    }

    private f(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.f9427c = jSONObject;
        this.f9428d = date;
        this.f9429e = jSONArray;
        this.f9426b = jSONObject2;
    }
}