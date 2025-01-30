package h.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ContentDiscoveryManifest.java */
/* loaded from: classes2.dex */
public class c {
    private static c a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f14052b;

    /* renamed from: c  reason: collision with root package name */
    private String f14053c;

    /* renamed from: h  reason: collision with root package name */
    private JSONArray f14058h;

    /* renamed from: i  reason: collision with root package name */
    private SharedPreferences f14059i;

    /* renamed from: d  reason: collision with root package name */
    private int f14054d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f14055e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f14056f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14057g = false;

    /* renamed from: j  reason: collision with root package name */
    private final String f14060j = "BNC_CD_MANIFEST";

    /* compiled from: ContentDiscoveryManifest.java */
    /* loaded from: classes2.dex */
    class a {
        final JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14061b;

        /* renamed from: c  reason: collision with root package name */
        private int f14062c;

        /* renamed from: d  reason: collision with root package name */
        private int f14063d;

        a(JSONObject jSONObject) {
            this.a = jSONObject;
            this.f14063d = 15;
            if (jSONObject.has("h")) {
                try {
                    this.f14061b = !jSONObject.getBoolean("h");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                if (jSONObject.has("dri")) {
                    this.f14062c = jSONObject.getInt("dri");
                }
                if (jSONObject.has("mdr")) {
                    this.f14063d = jSONObject.getInt("mdr");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.f14062c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public JSONArray b() {
            if (this.a.has("ck")) {
                try {
                    return this.a.getJSONArray("ck");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int c() {
            return this.f14063d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d() {
            return this.f14061b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean e() {
            JSONArray b2 = b();
            return b2 != null && b2.length() == 0;
        }
    }

    private c(Context context) {
        this.f14059i = context.getSharedPreferences("bnc_content_discovery_manifest_storage", 0);
        j(context);
    }

    public static c b(Context context) {
        if (a == null) {
            a = new c(context);
        }
        return a;
    }

    private void i() {
        this.f14059i.edit().putString("BNC_CD_MANIFEST", this.f14052b.toString()).apply();
    }

    private void j(Context context) {
        String string = this.f14059i.getString("BNC_CD_MANIFEST", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.f14052b = jSONObject;
                if (jSONObject.has("mv")) {
                    this.f14053c = this.f14052b.getString("mv");
                }
                if (this.f14052b.has("m")) {
                    this.f14058h = this.f14052b.getJSONArray("m");
                    return;
                }
                return;
            } catch (JSONException unused) {
                this.f14052b = new JSONObject();
                return;
            }
        }
        this.f14052b = new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(Activity activity) {
        if (this.f14058h != null) {
            String str = "/" + activity.getClass().getSimpleName();
            for (int i2 = 0; i2 < this.f14058h.length(); i2++) {
                try {
                    JSONObject jSONObject = this.f14058h.getJSONObject(i2);
                    if (jSONObject.has("p") && jSONObject.getString("p").equals(str)) {
                        return new a(jSONObject);
                    }
                } catch (JSONException unused) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public String c() {
        return TextUtils.isEmpty(this.f14053c) ? "-1" : this.f14053c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f14056f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f14054d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f14055e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f14057g;
    }

    public void h(JSONObject jSONObject) {
        int i2;
        if (jSONObject.has("cd")) {
            this.f14057g = true;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("cd");
                if (jSONObject2.has("mv")) {
                    this.f14053c = jSONObject2.getString("mv");
                }
                if (jSONObject2.has("mhl")) {
                    this.f14055e = jSONObject2.getInt("mhl");
                }
                if (jSONObject2.has("m")) {
                    this.f14058h = jSONObject2.getJSONArray("m");
                }
                if (jSONObject2.has("mtl") && (i2 = jSONObject2.getInt("mtl")) > 0) {
                    this.f14054d = i2;
                }
                if (jSONObject2.has("mps")) {
                    this.f14056f = jSONObject2.getInt("mps");
                }
                this.f14052b.put("mv", this.f14053c);
                this.f14052b.put("m", this.f14058h);
                i();
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        this.f14057g = false;
    }
}