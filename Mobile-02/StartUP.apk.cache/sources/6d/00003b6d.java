package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.i;
import com.google.android.gms.internal.p000firebaseperf.q0;
import com.google.firebase.c;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.remoteconfig.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class a {
    private static volatile a a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f9297b;

    /* renamed from: c  reason: collision with root package name */
    private final i f9298c;

    /* renamed from: d  reason: collision with root package name */
    private final q0 f9299d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f9300e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar, e eVar) {
        this(cVar, eVar, RemoteConfigManager.zzci(), i.A(), GaugeManager.zzby());
    }

    public static a b() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = (a) c.h().f(a.class);
                }
            }
        }
        return a;
    }

    private static q0 e(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.d("isEnabled", valueOf.length() != 0 ? "No perf enable meta data found ".concat(valueOf) : new String("No perf enable meta data found "));
            bundle = null;
        }
        return bundle != null ? new q0(bundle) : new q0();
    }

    public final Map<String, String> a() {
        return new HashMap(this.f9297b);
    }

    public boolean c() {
        Boolean bool = this.f9300e;
        if (bool != null) {
            return bool.booleanValue();
        }
        return c.h().p();
    }

    public Trace d(String str) {
        return Trace.j(str);
    }

    private a(c cVar, e eVar, RemoteConfigManager remoteConfigManager, i iVar, GaugeManager gaugeManager) {
        this.f9297b = new ConcurrentHashMap();
        this.f9300e = null;
        if (cVar == null) {
            this.f9300e = Boolean.FALSE;
            this.f9298c = iVar;
            this.f9299d = new q0(new Bundle());
            return;
        }
        Context g2 = cVar.g();
        q0 e2 = e(g2);
        this.f9299d = e2;
        remoteConfigManager.zza(eVar);
        this.f9298c = iVar;
        iVar.c(e2);
        iVar.r(g2);
        gaugeManager.zzc(g2);
        this.f9300e = iVar.C();
    }
}