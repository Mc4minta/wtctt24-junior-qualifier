package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.util.n;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public final class d {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9079b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9080c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9081d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9082e;

    /* renamed from: f  reason: collision with root package name */
    private final String f9083f;

    /* renamed from: g  reason: collision with root package name */
    private final String f9084g;

    private d(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        t.o(!n.a(str), "ApplicationId must be set.");
        this.f9079b = str;
        this.a = str2;
        this.f9080c = str3;
        this.f9081d = str4;
        this.f9082e = str5;
        this.f9083f = str6;
        this.f9084g = str7;
    }

    public static d a(Context context) {
        x xVar = new x(context);
        String a = xVar.a("google_app_id");
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        return new d(a, xVar.a("google_api_key"), xVar.a("firebase_database_url"), xVar.a("ga_trackingId"), xVar.a("gcm_defaultSenderId"), xVar.a("google_storage_bucket"), xVar.a("project_id"));
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f9079b;
    }

    public String d() {
        return this.f9082e;
    }

    public String e() {
        return this.f9084g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return r.a(this.f9079b, dVar.f9079b) && r.a(this.a, dVar.a) && r.a(this.f9080c, dVar.f9080c) && r.a(this.f9081d, dVar.f9081d) && r.a(this.f9082e, dVar.f9082e) && r.a(this.f9083f, dVar.f9083f) && r.a(this.f9084g, dVar.f9084g);
        }
        return false;
    }

    public int hashCode() {
        return r.b(this.f9079b, this.a, this.f9080c, this.f9081d, this.f9082e, this.f9083f, this.f9084g);
    }

    public String toString() {
        return r.c(this).a("applicationId", this.f9079b).a("apiKey", this.a).a("databaseUrl", this.f9080c).a("gcmSenderId", this.f9082e).a("storageBucket", this.f9083f).a("projectId", this.f9084g).toString();
    }
}