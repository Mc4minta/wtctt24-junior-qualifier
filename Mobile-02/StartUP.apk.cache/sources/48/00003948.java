package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.coinbase.ApiConstants;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.m;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.f;
import com.google.firebase.components.h;
import com.google.firebase.components.l;
import com.google.firebase.components.q;
import com.google.firebase.i.g;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public class c {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f8595b = new d();

    /* renamed from: c  reason: collision with root package name */
    static final Map<String, c> f8596c = new c.e.a();

    /* renamed from: d  reason: collision with root package name */
    private final Context f8597d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8598e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.d f8599f;

    /* renamed from: g  reason: collision with root package name */
    private final l f8600g;

    /* renamed from: j  reason: collision with root package name */
    private final q<com.google.firebase.h.a> f8603j;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f8601h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f8602i = new AtomicBoolean();

    /* renamed from: k  reason: collision with root package name */
    private final List<b> f8604k = new CopyOnWriteArrayList();

    /* renamed from: l  reason: collision with root package name */
    private final List<?> f8605l = new CopyOnWriteArrayList();

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    @TargetApi(14)
    /* renamed from: com.google.firebase.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0163c implements c.a {
        private static AtomicReference<C0163c> a = new AtomicReference<>();

        private C0163c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (com.google.android.gms.common.util.l.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (a.get() == null) {
                    C0163c c0163c = new C0163c();
                    if (a.compareAndSet(null, c0163c)) {
                        com.google.android.gms.common.api.internal.c.c(application);
                        com.google.android.gms.common.api.internal.c.b().a(c0163c);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z) {
            synchronized (c.a) {
                Iterator it = new ArrayList(c.f8596c.values()).iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f8601h.get()) {
                        cVar.t(z);
                    }
                }
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    /* loaded from: classes2.dex */
    private static class d implements Executor {
        private static final Handler a = new Handler(Looper.getMainLooper());

        private d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    @TargetApi(24)
    /* loaded from: classes2.dex */
    public static class e extends BroadcastReceiver {
        private static AtomicReference<e> a = new AtomicReference<>();

        /* renamed from: b  reason: collision with root package name */
        private final Context f8606b;

        public e(Context context) {
            this.f8606b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (a.get() == null) {
                e eVar = new e(context);
                if (a.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f8606b.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (c.a) {
                for (c cVar : c.f8596c.values()) {
                    cVar.l();
                }
            }
            c();
        }
    }

    protected c(Context context, String str, com.google.firebase.d dVar) {
        this.f8597d = (Context) t.k(context);
        this.f8598e = t.g(str);
        this.f8599f = (com.google.firebase.d) t.k(dVar);
        List<h> a2 = f.b(context, ComponentDiscoveryService.class).a();
        String a3 = com.google.firebase.i.e.a();
        Executor executor = f8595b;
        com.google.firebase.components.d[] dVarArr = new com.google.firebase.components.d[8];
        dVarArr[0] = com.google.firebase.components.d.n(context, Context.class, new Class[0]);
        dVarArr[1] = com.google.firebase.components.d.n(this, c.class, new Class[0]);
        dVarArr[2] = com.google.firebase.components.d.n(dVar, com.google.firebase.d.class, new Class[0]);
        dVarArr[3] = g.a("fire-android", "");
        dVarArr[4] = g.a("fire-core", "19.3.0");
        dVarArr[5] = a3 != null ? g.a("kotlin", a3) : null;
        dVarArr[6] = com.google.firebase.i.c.b();
        dVarArr[7] = com.google.firebase.f.b.b();
        this.f8600g = new l(executor, a2, dVarArr);
        this.f8603j = new q<>(com.google.firebase.b.a(this, context));
    }

    private void e() {
        t.o(!this.f8602i.get(), "FirebaseApp was deleted");
    }

    public static c h() {
        c cVar;
        synchronized (a) {
            cVar = f8596c.get("[DEFAULT]");
            if (cVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + m.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!androidx.core.os.g.a(this.f8597d)) {
            e.b(this.f8597d);
        } else {
            this.f8600g.e(q());
        }
    }

    public static c m(Context context) {
        synchronized (a) {
            if (f8596c.containsKey("[DEFAULT]")) {
                return h();
            }
            com.google.firebase.d a2 = com.google.firebase.d.a(context);
            if (a2 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return n(context, a2);
        }
    }

    public static c n(Context context, com.google.firebase.d dVar) {
        return o(context, dVar, "[DEFAULT]");
    }

    public static c o(Context context, com.google.firebase.d dVar, String str) {
        c cVar;
        C0163c.c(context);
        String s = s(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (a) {
            Map<String, c> map = f8596c;
            boolean z = !map.containsKey(s);
            t.o(z, "FirebaseApp name " + s + " already exists!");
            t.l(context, "Application context cannot be null.");
            cVar = new c(context, s, dVar);
            map.put(s, cVar);
        }
        cVar.l();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.firebase.h.a r(c cVar, Context context) {
        return new com.google.firebase.h.a(context, cVar.k(), (com.google.firebase.e.c) cVar.f8600g.a(com.google.firebase.e.c.class));
    }

    private static String s(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (b bVar : this.f8604k) {
            bVar.a(z);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f8598e.equals(((c) obj).i());
        }
        return false;
    }

    public <T> T f(Class<T> cls) {
        e();
        return (T) this.f8600g.a(cls);
    }

    public Context g() {
        e();
        return this.f8597d;
    }

    public int hashCode() {
        return this.f8598e.hashCode();
    }

    public String i() {
        e();
        return this.f8598e;
    }

    public com.google.firebase.d j() {
        e();
        return this.f8599f;
    }

    public String k() {
        return com.google.android.gms.common.util.c.a(i().getBytes(Charset.defaultCharset())) + "+" + com.google.android.gms.common.util.c.a(j().c().getBytes(Charset.defaultCharset()));
    }

    public boolean p() {
        e();
        return this.f8603j.get().b();
    }

    public boolean q() {
        return "[DEFAULT]".equals(i());
    }

    public String toString() {
        return r.c(this).a(ApiConstants.NAME, this.f8598e).a("options", this.f8599f).toString();
    }
}