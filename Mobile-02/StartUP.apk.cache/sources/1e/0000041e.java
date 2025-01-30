package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.d;
import androidx.room.e;
import androidx.room.g;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MultiInstanceInvalidationClient.java */
/* loaded from: classes.dex */
class h {
    final Context a;

    /* renamed from: b  reason: collision with root package name */
    final String f2251b;

    /* renamed from: c  reason: collision with root package name */
    int f2252c;

    /* renamed from: d  reason: collision with root package name */
    final g f2253d;

    /* renamed from: e  reason: collision with root package name */
    final g.c f2254e;

    /* renamed from: f  reason: collision with root package name */
    androidx.room.e f2255f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f2256g;

    /* renamed from: h  reason: collision with root package name */
    final androidx.room.d f2257h = new a();

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f2258i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    final ServiceConnection f2259j;

    /* renamed from: k  reason: collision with root package name */
    final Runnable f2260k;

    /* renamed from: l  reason: collision with root package name */
    final Runnable f2261l;
    private final Runnable m;

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class a extends d.a {

        /* compiled from: MultiInstanceInvalidationClient.java */
        /* renamed from: androidx.room.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0043a implements Runnable {
            final /* synthetic */ String[] a;

            RunnableC0043a(String[] strArr) {
                this.a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f2253d.e(this.a);
            }
        }

        a() {
        }

        @Override // androidx.room.d
        public void F(String[] strArr) {
            h.this.f2256g.execute(new RunnableC0043a(strArr));
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.f2255f = e.a.n(iBinder);
            h hVar = h.this;
            hVar.f2256g.execute(hVar.f2260k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h hVar = h.this;
            hVar.f2256g.execute(hVar.f2261l);
            h.this.f2255f = null;
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h hVar = h.this;
                androidx.room.e eVar = hVar.f2255f;
                if (eVar != null) {
                    hVar.f2252c = eVar.L(hVar.f2257h, hVar.f2251b);
                    h hVar2 = h.this;
                    hVar2.f2253d.a(hVar2.f2254e);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e2);
            }
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f2253d.g(hVar.f2254e);
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f2253d.g(hVar.f2254e);
            try {
                h hVar2 = h.this;
                androidx.room.e eVar = hVar2.f2255f;
                if (eVar != null) {
                    eVar.S0(hVar2.f2257h, hVar2.f2252c);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e2);
            }
            h hVar3 = h.this;
            hVar3.a.unbindService(hVar3.f2259j);
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class f extends g.c {
        f(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.g.c
        boolean a() {
            return true;
        }

        @Override // androidx.room.g.c
        public void b(Set<String> set) {
            if (h.this.f2258i.get()) {
                return;
            }
            try {
                h hVar = h.this;
                androidx.room.e eVar = hVar.f2255f;
                if (eVar != null) {
                    eVar.K0(hVar.f2252c, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot broadcast invalidation", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str, g gVar, Executor executor) {
        b bVar = new b();
        this.f2259j = bVar;
        this.f2260k = new c();
        this.f2261l = new d();
        this.m = new e();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f2251b = str;
        this.f2253d = gVar;
        this.f2256g = executor;
        this.f2254e = new f((String[]) gVar.f2233b.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), bVar, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f2258i.compareAndSet(false, true)) {
            this.f2256g.execute(this.m);
        }
    }
}