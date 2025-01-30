package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
class n {
    private static n a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f499b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationManager f500c;

    /* renamed from: d  reason: collision with root package name */
    private final a f501d = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TwilightManager.java */
    /* loaded from: classes.dex */
    public static class a {
        boolean a;

        /* renamed from: b  reason: collision with root package name */
        long f502b;

        /* renamed from: c  reason: collision with root package name */
        long f503c;

        /* renamed from: d  reason: collision with root package name */
        long f504d;

        /* renamed from: e  reason: collision with root package name */
        long f505e;

        /* renamed from: f  reason: collision with root package name */
        long f506f;

        a() {
        }
    }

    n(Context context, LocationManager locationManager) {
        this.f499b = context;
        this.f500c = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a(Context context) {
        if (a == null) {
            Context applicationContext = context.getApplicationContext();
            a = new n(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return a;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location c2 = androidx.core.content.c.c(this.f499b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c3 = androidx.core.content.c.c(this.f499b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c3 == null || c2 == null) ? c3 != null ? c3 : c2 : c3.getTime() > c2.getTime() ? c3 : c2;
    }

    private Location c(String str) {
        try {
            if (this.f500c.isProviderEnabled(str)) {
                return this.f500c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f501d.f506f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j2;
        a aVar = this.f501d;
        long currentTimeMillis = System.currentTimeMillis();
        m b2 = m.b();
        b2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = b2.f496b;
        b2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = b2.f498d == 1;
        long j4 = b2.f497c;
        long j5 = b2.f496b;
        b2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = b2.f497c;
        if (j4 == -1 || j5 == -1) {
            j2 = 43200000 + currentTimeMillis;
        } else {
            j2 = (currentTimeMillis > j5 ? 0 + j6 : currentTimeMillis > j4 ? 0 + j5 : 0 + j4) + 60000;
        }
        aVar.a = z;
        aVar.f502b = j3;
        aVar.f503c = j4;
        aVar.f504d = j5;
        aVar.f505e = j6;
        aVar.f506f = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f501d;
        if (e()) {
            return aVar.a;
        }
        Location b2 = b();
        if (b2 != null) {
            f(b2);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}