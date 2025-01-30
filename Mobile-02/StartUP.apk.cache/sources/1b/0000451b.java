package e.c.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import e.g.a.d.a.a;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstallReferrerClientImpl.java */
/* loaded from: classes.dex */
public class b extends e.c.a.a.a {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11977b;

    /* renamed from: c  reason: collision with root package name */
    private e.g.a.d.a.a f11978c;

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f11979d;

    /* compiled from: InstallReferrerClientImpl.java */
    /* renamed from: e.c.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class ServiceConnectionC0259b implements ServiceConnection {
        private final c a;

        private ServiceConnectionC0259b(c cVar) {
            if (cVar != null) {
                this.a = cVar;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.c.a.b.a.a("InstallReferrerClient", "Install Referrer service connected.");
            b.this.f11978c = a.AbstractBinderC0297a.n(iBinder);
            b.this.a = 2;
            this.a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e.c.a.b.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            b.this.f11978c = null;
            b.this.a = 0;
            this.a.onInstallReferrerServiceDisconnected();
        }
    }

    public b(Context context) {
        this.f11977b = context.getApplicationContext();
    }

    private boolean h() {
        return this.f11977b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
    }

    @Override // e.c.a.a.a
    public void a() {
        this.a = 3;
        if (this.f11979d != null) {
            e.c.a.b.a.a("InstallReferrerClient", "Unbinding from service.");
            this.f11977b.unbindService(this.f11979d);
            this.f11979d = null;
        }
        this.f11978c = null;
    }

    @Override // e.c.a.a.a
    public d b() throws RemoteException {
        if (c()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f11977b.getPackageName());
            try {
                return new d(this.f11978c.z(bundle));
            } catch (RemoteException e2) {
                e.c.a.b.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
                this.a = 0;
                throw e2;
            }
        }
        throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
    }

    @Override // e.c.a.a.a
    public boolean c() {
        return (this.a != 2 || this.f11978c == null || this.f11979d == null) ? false : true;
    }

    @Override // e.c.a.a.a
    public void e(c cVar) {
        ServiceInfo serviceInfo;
        if (c()) {
            e.c.a.b.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            cVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i2 = this.a;
        if (i2 == 1) {
            e.c.a.b.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            cVar.onInstallReferrerSetupFinished(3);
        } else if (i2 != 3) {
            e.c.a.b.a.a("InstallReferrerClient", "Starting install referrer service setup.");
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List<ResolveInfo> queryIntentServices = this.f11977b.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if ("com.android.vending".equals(str) && str2 != null && h()) {
                    Intent intent2 = new Intent(intent);
                    ServiceConnectionC0259b serviceConnectionC0259b = new ServiceConnectionC0259b(cVar);
                    this.f11979d = serviceConnectionC0259b;
                    if (this.f11977b.bindService(intent2, serviceConnectionC0259b, 1)) {
                        e.c.a.b.a.a("InstallReferrerClient", "Service was bonded successfully.");
                        return;
                    }
                    e.c.a.b.a.b("InstallReferrerClient", "Connection to service is blocked.");
                    this.a = 0;
                    cVar.onInstallReferrerSetupFinished(1);
                    return;
                }
                e.c.a.b.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
                this.a = 0;
                cVar.onInstallReferrerSetupFinished(2);
                return;
            }
            this.a = 0;
            e.c.a.b.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
            cVar.onInstallReferrerSetupFinished(2);
        } else {
            e.c.a.b.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            cVar.onInstallReferrerSetupFinished(3);
        }
    }
}