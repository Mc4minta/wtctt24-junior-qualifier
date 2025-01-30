package com.google.firebase.analytics.a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.a.a;
import com.google.firebase.analytics.connector.internal.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
public class b implements com.google.firebase.analytics.a.a {
    private static volatile com.google.firebase.analytics.a.a a;

    /* renamed from: b  reason: collision with root package name */
    private final AppMeasurement f8581b;

    /* renamed from: c  reason: collision with root package name */
    final Map<String, ?> f8582c;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
    /* loaded from: classes2.dex */
    class a implements a.InterfaceC0162a {
        private final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }
    }

    private b(AppMeasurement appMeasurement) {
        t.k(appMeasurement);
        this.f8581b = appMeasurement;
        this.f8582c = new ConcurrentHashMap();
    }

    public static com.google.firebase.analytics.a.a h(com.google.firebase.c cVar, Context context, com.google.firebase.e.d dVar) {
        t.k(cVar);
        t.k(context);
        t.k(dVar);
        t.k(context.getApplicationContext());
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    Bundle bundle = new Bundle(1);
                    if (cVar.q()) {
                        dVar.b(com.google.firebase.a.class, c.a, d.a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", cVar.p());
                    }
                    a = new b(AppMeasurement.d(context, bundle));
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void i(com.google.firebase.e.a aVar) {
        boolean z = ((com.google.firebase.a) aVar.a()).a;
        synchronized (b.class) {
            ((b) a).f8581b.f(z);
        }
    }

    private final boolean j(String str) {
        return (str.isEmpty() || !this.f8582c.containsKey(str) || this.f8582c.get(str) == null) ? false : true;
    }

    @Override // com.google.firebase.analytics.a.a
    public Map<String, Object> a(boolean z) {
        return this.f8581b.a(z);
    }

    @Override // com.google.firebase.analytics.a.a
    public void b(a.c cVar) {
        if (com.google.firebase.analytics.connector.internal.a.b(cVar)) {
            this.f8581b.setConditionalUserProperty(com.google.firebase.analytics.connector.internal.a.g(cVar));
        }
    }

    @Override // com.google.firebase.analytics.a.a
    public void c(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.a.c(str) && com.google.firebase.analytics.connector.internal.a.d(str2, bundle) && com.google.firebase.analytics.connector.internal.a.f(str, str2, bundle)) {
            com.google.firebase.analytics.connector.internal.a.h(str, str2, bundle);
            this.f8581b.logEventInternal(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.a.a
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || com.google.firebase.analytics.connector.internal.a.d(str2, bundle)) {
            this.f8581b.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.a.a
    public int d(String str) {
        return this.f8581b.getMaxUserProperties(str);
    }

    @Override // com.google.firebase.analytics.a.a
    public List<a.c> e(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty conditionalUserProperty : this.f8581b.getConditionalUserProperties(str, str2)) {
            arrayList.add(com.google.firebase.analytics.connector.internal.a.a(conditionalUserProperty));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.a.a
    public void f(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.a.c(str) && com.google.firebase.analytics.connector.internal.a.e(str, str2)) {
            this.f8581b.c(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.a.a
    public a.InterfaceC0162a g(String str, a.b bVar) {
        Object fVar;
        t.k(bVar);
        if (com.google.firebase.analytics.connector.internal.a.c(str) && !j(str)) {
            AppMeasurement appMeasurement = this.f8581b;
            if ("fiam".equals(str)) {
                fVar = new com.google.firebase.analytics.connector.internal.d(appMeasurement, bVar);
            } else {
                fVar = ("crash".equals(str) || "clx".equals(str)) ? new f(appMeasurement, bVar) : null;
            }
            if (fVar != null) {
                this.f8582c.put(str, fVar);
                return new a(str);
            }
            return null;
        }
        return null;
    }
}