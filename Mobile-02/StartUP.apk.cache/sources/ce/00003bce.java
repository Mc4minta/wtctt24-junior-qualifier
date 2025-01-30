package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.m;
import com.google.firebase.remoteconfig.internal.p;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class k {
    private static final com.google.android.gms.common.util.e a = com.google.android.gms.common.util.h.c();

    /* renamed from: b  reason: collision with root package name */
    private static final Random f9469b = new Random();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, e> f9470c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f9471d;

    /* renamed from: e  reason: collision with root package name */
    private final ExecutorService f9472e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.c f9473f;

    /* renamed from: g  reason: collision with root package name */
    private final FirebaseInstanceId f9474g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.firebase.abt.b f9475h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.firebase.analytics.a.a f9476i;

    /* renamed from: j  reason: collision with root package name */
    private final String f9477j;

    /* renamed from: k  reason: collision with root package name */
    private Map<String, String> f9478k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, com.google.firebase.c cVar, FirebaseInstanceId firebaseInstanceId, com.google.firebase.abt.b bVar, com.google.firebase.analytics.a.a aVar) {
        this(context, Executors.newCachedThreadPool(), cVar, firebaseInstanceId, bVar, aVar, new p(context, cVar.j().c()), true);
    }

    public static com.google.firebase.remoteconfig.internal.e c(Context context, String str, String str2, String str3) {
        return com.google.firebase.remoteconfig.internal.e.f(Executors.newCachedThreadPool(), m.c(context, String.format("%s_%s_%s_%s.json", "frc", str, str2, str3)));
    }

    private com.google.firebase.remoteconfig.internal.e d(String str, String str2) {
        return c(this.f9471d, this.f9477j, str, str2);
    }

    private com.google.firebase.remoteconfig.internal.k h(com.google.firebase.remoteconfig.internal.e eVar, com.google.firebase.remoteconfig.internal.e eVar2) {
        return new com.google.firebase.remoteconfig.internal.k(eVar, eVar2);
    }

    static com.google.firebase.remoteconfig.internal.l i(Context context, String str, String str2) {
        return new com.google.firebase.remoteconfig.internal.l(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, "settings"), 0));
    }

    private static boolean j(com.google.firebase.c cVar, String str) {
        return str.equals("firebase") && k(cVar);
    }

    private static boolean k(com.google.firebase.c cVar) {
        return cVar.i().equals("[DEFAULT]");
    }

    synchronized e a(com.google.firebase.c cVar, String str, com.google.firebase.abt.b bVar, Executor executor, com.google.firebase.remoteconfig.internal.e eVar, com.google.firebase.remoteconfig.internal.e eVar2, com.google.firebase.remoteconfig.internal.e eVar3, com.google.firebase.remoteconfig.internal.j jVar, com.google.firebase.remoteconfig.internal.k kVar, com.google.firebase.remoteconfig.internal.l lVar) {
        if (!this.f9470c.containsKey(str)) {
            e eVar4 = new e(this.f9471d, cVar, j(cVar, str) ? bVar : null, executor, eVar, eVar2, eVar3, jVar, kVar, lVar);
            eVar4.l();
            this.f9470c.put(str, eVar4);
        }
        return this.f9470c.get(str);
    }

    public synchronized e b(String str) {
        com.google.firebase.remoteconfig.internal.e d2;
        com.google.firebase.remoteconfig.internal.e d3;
        com.google.firebase.remoteconfig.internal.e d4;
        com.google.firebase.remoteconfig.internal.l i2;
        d2 = d(str, "fetch");
        d3 = d(str, "activate");
        d4 = d(str, "defaults");
        i2 = i(this.f9471d, this.f9477j, str);
        return a(this.f9473f, str, this.f9475h, this.f9472e, d2, d3, d4, f(str, d2, i2), h(d3, d4), i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e e() {
        return b("firebase");
    }

    synchronized com.google.firebase.remoteconfig.internal.j f(String str, com.google.firebase.remoteconfig.internal.e eVar, com.google.firebase.remoteconfig.internal.l lVar) {
        return new com.google.firebase.remoteconfig.internal.j(this.f9474g, k(this.f9473f) ? this.f9476i : null, this.f9472e, a, f9469b, eVar, g(this.f9473f.j().b(), str, lVar), lVar, this.f9478k);
    }

    ConfigFetchHttpClient g(String str, String str2, com.google.firebase.remoteconfig.internal.l lVar) {
        return new ConfigFetchHttpClient(this.f9471d, this.f9473f.j().c(), str, str2, lVar.b(), 60L);
    }

    protected k(Context context, ExecutorService executorService, com.google.firebase.c cVar, FirebaseInstanceId firebaseInstanceId, com.google.firebase.abt.b bVar, com.google.firebase.analytics.a.a aVar, p pVar, boolean z) {
        this.f9470c = new HashMap();
        this.f9478k = new HashMap();
        this.f9471d = context;
        this.f9472e = executorService;
        this.f9473f = cVar;
        this.f9474g = firebaseInstanceId;
        this.f9475h = bVar;
        this.f9476i = aVar;
        this.f9477j = cVar.j().c();
        if (z) {
            com.google.android.gms.tasks.j.c(executorService, i.a(this));
            pVar.getClass();
            com.google.android.gms.tasks.j.c(executorService, j.a(pVar));
        }
    }
}