package com.amplitude.api;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Identify.java */
/* loaded from: classes.dex */
public class j {
    protected JSONObject a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    protected Set<String> f3574b = new HashSet();

    private void a(String str, String str2, Object obj) {
        if (l.b(str2)) {
            d.d().f("com.amplitude.api.Identify", String.format("Attempting to perform operation %s with a null or empty string property, ignoring", str));
        } else if (obj == null) {
            d.d().f("com.amplitude.api.Identify", String.format("Attempting to perform operation %s with null value for property %s, ignoring", str, str2));
        } else if (this.a.has("$clearAll")) {
            d.d().f("com.amplitude.api.Identify", String.format("This Identify already contains a $clearAll operation, ignoring operation %s", str));
        } else if (this.f3574b.contains(str2)) {
            d.d().f("com.amplitude.api.Identify", String.format("Already used property %s in previous operation, ignoring operation %s", str2, str));
        } else {
            try {
                if (!this.a.has(str)) {
                    this.a.put(str, new JSONObject());
                }
                this.a.getJSONObject(str).put(str2, obj);
                this.f3574b.add(str2);
            } catch (JSONException e2) {
                d.d().b("com.amplitude.api.Identify", e2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j b(String str, Object obj) {
        a("$set", str, obj);
        return this;
    }
}