package e.g.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.coinbase.wallet.core.extensions.Strings;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.f;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.t;
import e.g.a.e.d.a.e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.cache.DiskLruCache;

/* loaded from: classes2.dex */
public class a {
    private com.google.android.gms.common.a a;

    /* renamed from: b  reason: collision with root package name */
    private e.g.a.e.d.a.d f13074b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13075c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f13076d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private b f13077e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f13078f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13079g;

    /* renamed from: h  reason: collision with root package name */
    private final long f13080h;

    /* renamed from: e.g.a.e.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0299a {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f13081b;

        public C0299a(String str, boolean z) {
            this.a = str;
            this.f13081b = z;
        }

        public final String a() {
            return this.a;
        }

        public final boolean b() {
            return this.f13081b;
        }

        public final String toString() {
            String str = this.a;
            boolean z = this.f13081b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends Thread {
        private WeakReference<a> a;

        /* renamed from: b  reason: collision with root package name */
        private long f13082b;

        /* renamed from: c  reason: collision with root package name */
        CountDownLatch f13083c = new CountDownLatch(1);

        /* renamed from: d  reason: collision with root package name */
        boolean f13084d = false;

        public b(a aVar, long j2) {
            this.a = new WeakReference<>(aVar);
            this.f13082b = j2;
            start();
        }

        private final void a() {
            a aVar = this.a.get();
            if (aVar != null) {
                aVar.a();
                this.f13084d = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f13083c.await(this.f13082b, TimeUnit.MILLISECONDS)) {
                    return;
                }
                a();
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    private a(Context context, long j2, boolean z, boolean z2) {
        Context applicationContext;
        t.k(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f13078f = context;
        this.f13075c = false;
        this.f13080h = j2;
        this.f13079g = z2;
    }

    public static C0299a b(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        c cVar = new c(context);
        boolean a = cVar.a("gads:ad_id_app_context:enabled", false);
        float b2 = cVar.b("gads:ad_id_app_context:ping_ratio", 0.0f);
        String c2 = cVar.c("gads:ad_id_use_shared_preference:experiment_id", "");
        a aVar = new a(context, -1L, a, cVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.h(false);
            C0299a c3 = aVar.c();
            aVar.i(c3, a, b2, SystemClock.elapsedRealtime() - elapsedRealtime, c2, null);
            return c3;
        } finally {
        }
    }

    public static void d(boolean z) {
    }

    private static com.google.android.gms.common.a e(Context context, boolean z) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int h2 = f.f().h(context, h.a);
            if (h2 == 0 || h2 == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (com.google.android.gms.common.stats.a.b().a(context, intent, aVar, 1)) {
                        return aVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            }
            throw new IOException("Google Play services not available");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    private static e.g.a.e.d.a.d f(Context context, com.google.android.gms.common.a aVar) throws IOException {
        try {
            return e.n(aVar.b(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final void g() {
        synchronized (this.f13076d) {
            b bVar = this.f13077e;
            if (bVar != null) {
                bVar.f13083c.countDown();
                try {
                    this.f13077e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f13080h > 0) {
                this.f13077e = new b(this, this.f13080h);
            }
        }
    }

    private final void h(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        t.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f13075c) {
                a();
            }
            com.google.android.gms.common.a e2 = e(this.f13078f, this.f13079g);
            this.a = e2;
            this.f13074b = f(this.f13078f, e2);
            this.f13075c = true;
            if (z) {
                g();
            }
        }
    }

    private final boolean i(C0299a c0299a, boolean z, float f2, long j2, String str, Throwable th) {
        if (Math.random() > f2) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = DiskLruCache.VERSION_1;
        hashMap.put("app_context", z ? DiskLruCache.VERSION_1 : Strings.zero);
        if (c0299a != null) {
            if (!c0299a.b()) {
                str2 = Strings.zero;
            }
            hashMap.put("limit_ad_tracking", str2);
        }
        if (c0299a != null && c0299a.a() != null) {
            hashMap.put("ad_id_size", Integer.toString(c0299a.a().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j2));
        new e.g.a.e.a.a.b(this, hashMap).start();
        return true;
    }

    public final void a() {
        t.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f13078f == null || this.a == null) {
                return;
            }
            if (this.f13075c) {
                com.google.android.gms.common.stats.a.b().c(this.f13078f, this.a);
            }
            this.f13075c = false;
            this.f13074b = null;
            this.a = null;
        }
    }

    public C0299a c() throws IOException {
        C0299a c0299a;
        t.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f13075c) {
                synchronized (this.f13076d) {
                    b bVar = this.f13077e;
                    if (bVar == null || !bVar.f13084d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    h(false);
                    if (!this.f13075c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            t.k(this.a);
            t.k(this.f13074b);
            try {
                c0299a = new C0299a(this.f13074b.getId(), this.f13074b.j(true));
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception");
            }
        }
        g();
        return c0299a;
    }

    protected void finalize() throws Throwable {
        a();
        super.finalize();
    }
}