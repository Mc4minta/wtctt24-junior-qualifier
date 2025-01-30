package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class p4 {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f7793b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7794c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f7795d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k4 f7796e;

    public p4(k4 k4Var, String str, Bundle bundle) {
        this.f7796e = k4Var;
        com.google.android.gms.common.internal.t.g(str);
        this.a = str;
        this.f7793b = new Bundle();
    }

    private final String c(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", "s");
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", "d");
                    } else {
                        this.f7796e.f().H().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    this.f7796e.f().H().b("Cannot serialize bundle value to SharedPreferences", e2);
                }
            }
        }
        return jSONArray.toString();
    }

    public final Bundle a() {
        if (!this.f7794c) {
            this.f7794c = true;
            String string = this.f7796e.D().getString(this.a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            char c2 = 65535;
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode == 115 && string3.equals("s")) {
                                        c2 = 0;
                                    }
                                } else if (string3.equals("l")) {
                                    c2 = 2;
                                }
                            } else if (string3.equals("d")) {
                                c2 = 1;
                            }
                            if (c2 == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (c2 == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (c2 != 2) {
                                this.f7796e.f().H().b("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f7796e.f().H().a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f7795d = bundle;
                } catch (JSONException unused2) {
                    this.f7796e.f().H().a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f7795d == null) {
                this.f7795d = this.f7793b;
            }
        }
        return this.f7795d;
    }

    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f7796e.D().edit();
        if (bundle.size() == 0) {
            edit.remove(this.a);
        } else {
            edit.putString(this.a, c(bundle));
        }
        edit.apply();
        this.f7795d = bundle;
    }
}