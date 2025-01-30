package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.firebase.abt.AbtException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class e {
    public static final byte[] a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private final Context f9398b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.c f9399c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.abt.b f9400d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f9401e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.internal.e f9402f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.internal.e f9403g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.internal.e f9404h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.internal.j f9405i;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.internal.k f9406j;

    /* renamed from: k  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.internal.l f9407k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, com.google.firebase.c cVar, com.google.firebase.abt.b bVar, Executor executor, com.google.firebase.remoteconfig.internal.e eVar, com.google.firebase.remoteconfig.internal.e eVar2, com.google.firebase.remoteconfig.internal.e eVar3, com.google.firebase.remoteconfig.internal.j jVar, com.google.firebase.remoteconfig.internal.k kVar, com.google.firebase.remoteconfig.internal.l lVar) {
        this.f9398b = context;
        this.f9399c = cVar;
        this.f9400d = bVar;
        this.f9401e = executor;
        this.f9402f = eVar;
        this.f9403g = eVar2;
        this.f9404h = eVar3;
        this.f9405i = jVar;
        this.f9406j = kVar;
        this.f9407k = lVar;
    }

    private static boolean g(com.google.firebase.remoteconfig.internal.f fVar, com.google.firebase.remoteconfig.internal.f fVar2) {
        return fVar2 == null || !fVar.e().equals(fVar2.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.tasks.g h(e eVar, com.google.android.gms.tasks.g gVar, com.google.android.gms.tasks.g gVar2, com.google.android.gms.tasks.g gVar3) throws Exception {
        if (gVar.q() && gVar.m() != null) {
            com.google.firebase.remoteconfig.internal.f fVar = (com.google.firebase.remoteconfig.internal.f) gVar.m();
            if (gVar2.q() && !g(fVar, (com.google.firebase.remoteconfig.internal.f) gVar2.m())) {
                return com.google.android.gms.tasks.j.e(Boolean.FALSE);
            }
            return eVar.f9403g.i(fVar).i(eVar.f9401e, a.b(eVar));
        }
        return com.google.android.gms.tasks.j.e(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(com.google.android.gms.tasks.g<com.google.firebase.remoteconfig.internal.f> gVar) {
        if (gVar.q()) {
            this.f9402f.b();
            if (gVar.m() != null) {
                n(gVar.m().c());
                return true;
            }
            Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            return true;
        }
        return false;
    }

    static List<Map<String, String>> m(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public com.google.android.gms.tasks.g<Boolean> b() {
        com.google.android.gms.tasks.g<com.google.firebase.remoteconfig.internal.f> c2 = this.f9402f.c();
        com.google.android.gms.tasks.g<com.google.firebase.remoteconfig.internal.f> c3 = this.f9403g.c();
        return com.google.android.gms.tasks.j.h(c2, c3).k(this.f9401e, c.b(this, c2, c3));
    }

    public com.google.android.gms.tasks.g<Void> c() {
        return this.f9405i.d().r(d.b());
    }

    public com.google.android.gms.tasks.g<Boolean> d() {
        return c().s(this.f9401e, b.b(this));
    }

    public f e() {
        return this.f9407k.c();
    }

    public h f(String str) {
        return this.f9406j.c(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.f9403g.c();
        this.f9404h.c();
        this.f9402f.c();
    }

    void n(JSONArray jSONArray) {
        if (this.f9400d == null) {
            return;
        }
        try {
            this.f9400d.l(m(jSONArray));
        } catch (AbtException e2) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e2);
        } catch (JSONException e3) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e3);
        }
    }
}