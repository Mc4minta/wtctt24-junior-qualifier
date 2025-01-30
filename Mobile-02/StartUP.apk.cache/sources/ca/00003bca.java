package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.remoteconfig.internal.f;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.e;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class p {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final ThreadLocal<DateFormat> f9463b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final Context f9464c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9465d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f9466e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static class b {
        private f a;

        /* renamed from: b  reason: collision with root package name */
        private f f9467b;

        /* renamed from: c  reason: collision with root package name */
        private f f9468c;

        /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public f g() {
            return this.f9467b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public f h() {
            return this.f9468c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public f i() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(f fVar) {
            this.f9467b = fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(f fVar) {
            this.f9468c = fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(f fVar) {
            this.a = fVar;
        }

        private b() {
        }
    }

    public p(Context context, String str) {
        this.f9464c = context;
        this.f9465d = str;
        this.f9466e = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    private Map<String, f> a(com.google.firebase.remoteconfig.m.b bVar) {
        HashMap hashMap = new HashMap();
        Date date = new Date(bVar.z());
        JSONArray d2 = d(bVar.x());
        for (com.google.firebase.remoteconfig.m.e eVar : bVar.y()) {
            String x = eVar.x();
            if (x.startsWith("configns:")) {
                x = x.substring(9);
            }
            f.b e2 = f.f().b(b(eVar.w())).e(date);
            if (x.equals("firebase")) {
                e2.d(d2);
            }
            try {
                hashMap.put(x, e2.a());
            } catch (JSONException unused) {
                Log.d("FirebaseRemoteConfig", "A set of legacy configs could not be converted.");
            }
        }
        return hashMap;
    }

    private Map<String, String> b(List<com.google.firebase.remoteconfig.m.c> list) {
        HashMap hashMap = new HashMap();
        for (com.google.firebase.remoteconfig.m.c cVar : list) {
            hashMap.put(cVar.w(), cVar.x().t(a));
        }
        return hashMap;
    }

    private JSONObject c(g.a.a.c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("experimentId", cVar.w());
        jSONObject.put("variantId", cVar.B());
        jSONObject.put("experimentStartTime", f9463b.get().format(new Date(cVar.x())));
        jSONObject.put("triggerEvent", cVar.z());
        jSONObject.put("triggerTimeoutMillis", cVar.A());
        jSONObject.put("timeToLiveMillis", cVar.y());
        return jSONObject;
    }

    private JSONArray d(List<com.google.protobuf.e> list) {
        JSONArray jSONArray = new JSONArray();
        for (com.google.protobuf.e eVar : list) {
            g.a.a.c e2 = e(eVar);
            if (e2 != null) {
                try {
                    jSONArray.put(c(e2));
                } catch (JSONException e3) {
                    Log.d("FirebaseRemoteConfig", "A legacy ABT experiment could not be parsed.", e3);
                }
            }
        }
        return jSONArray;
    }

    private g.a.a.c e(com.google.protobuf.e eVar) {
        try {
            e.InterfaceC0202e it = eVar.iterator();
            int size = eVar.size();
            byte[] bArr = new byte[size];
            for (int i2 = 0; i2 < size; i2++) {
                bArr[i2] = it.next().byteValue();
            }
            return g.a.a.c.C(bArr);
        } catch (InvalidProtocolBufferException e2) {
            Log.d("FirebaseRemoteConfig", "Payload was not defined or could not be deserialized.", e2);
            return null;
        }
    }

    private Map<String, b> g() {
        com.google.firebase.remoteconfig.m.f h2 = h();
        HashMap hashMap = new HashMap();
        if (h2 == null) {
            return hashMap;
        }
        Map<String, f> a2 = a(h2.w());
        Map<String, f> a3 = a(h2.y());
        Map<String, f> a4 = a(h2.x());
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(a2.keySet());
        hashSet.addAll(a3.keySet());
        hashSet.addAll(a4.keySet());
        for (String str : hashSet) {
            b bVar = new b(null);
            if (a2.containsKey(str)) {
                bVar.j(a2.get(str));
            }
            if (a3.containsKey(str)) {
                bVar.l(a3.get(str));
            }
            if (a4.containsKey(str)) {
                bVar.k(a4.get(str));
            }
            hashMap.put(str, bVar);
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    private com.google.firebase.remoteconfig.m.f h() {
        FileInputStream fileInputStream;
        ?? r2 = this.f9464c;
        try {
            if (r2 == 0) {
                return null;
            }
            try {
                fileInputStream = r2.openFileInput("persisted_config");
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = null;
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                r2 = 0;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e4) {
                        Log.d("FirebaseRemoteConfig", "Failed to close persisted config file.", e4);
                    }
                }
                throw th;
            }
            try {
                com.google.firebase.remoteconfig.m.f z = com.google.firebase.remoteconfig.m.f.z(fileInputStream);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        Log.d("FirebaseRemoteConfig", "Failed to close persisted config file.", e5);
                    }
                }
                return z;
            } catch (FileNotFoundException e6) {
                e = e6;
                Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        Log.d("FirebaseRemoteConfig", "Failed to close persisted config file.", e7);
                    }
                }
                return null;
            } catch (IOException e8) {
                e = e8;
                Log.d("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                        Log.d("FirebaseRemoteConfig", "Failed to close persisted config file.", e9);
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void i(Map<String, b> map) {
        for (Map.Entry<String, b> entry : map.entrySet()) {
            String key = entry.getKey();
            b value = entry.getValue();
            e f2 = f(key, "fetch");
            e f3 = f(key, "activate");
            e f4 = f(key, "defaults");
            if (value.i() != null) {
                f2.i(value.i());
            }
            if (value.g() != null) {
                f3.i(value.g());
            }
            if (value.h() != null) {
                f4.i(value.h());
            }
        }
    }

    e f(String str, String str2) {
        return com.google.firebase.remoteconfig.k.c(this.f9464c, this.f9465d, str, str2);
    }

    public boolean j() {
        if (this.f9466e.getBoolean("save_legacy_configs", true)) {
            i(g());
            this.f9466e.edit().putBoolean("save_legacy_configs", false).commit();
            return true;
        }
        return false;
    }
}