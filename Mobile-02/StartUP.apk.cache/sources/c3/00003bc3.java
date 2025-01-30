package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.g;
import java.util.Date;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class l {
    static final Date a = new Date(-1);

    /* renamed from: b  reason: collision with root package name */
    static final Date f9451b = new Date(-1);

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f9452c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f9453d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final Object f9454e = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static class a {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private Date f9455b;

        a(int i2, Date date) {
            this.a = i2;
            this.f9455b = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date a() {
            return this.f9455b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.a;
        }
    }

    public l(SharedPreferences sharedPreferences) {
        this.f9452c = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a() {
        a aVar;
        synchronized (this.f9454e) {
            aVar = new a(this.f9452c.getInt("num_failed_fetches", 0), new Date(this.f9452c.getLong("backoff_end_time_in_millis", -1L)));
        }
        return aVar;
    }

    public long b() {
        return this.f9452c.getLong("fetch_timeout_in_seconds", 60L);
    }

    public com.google.firebase.remoteconfig.f c() {
        n a2;
        synchronized (this.f9453d) {
            long j2 = this.f9452c.getLong("last_fetch_time_in_millis", -1L);
            int i2 = this.f9452c.getInt("last_fetch_status", 0);
            a2 = n.b().c(i2).d(j2).b(new g.b().e(this.f9452c.getBoolean("is_developer_mode_enabled", false)).f(this.f9452c.getLong("fetch_timeout_in_seconds", 60L)).g(this.f9452c.getLong("minimum_fetch_interval_in_seconds", j.a)).d()).a();
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f9452c.getString("last_fetch_etag", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Date e() {
        return new Date(this.f9452c.getLong("last_fetch_time_in_millis", -1L));
    }

    public long f() {
        return this.f9452c.getLong("minimum_fetch_interval_in_seconds", j.a);
    }

    public boolean g() {
        return this.f9452c.getBoolean("is_developer_mode_enabled", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        i(0, f9451b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i2, Date date) {
        synchronized (this.f9454e) {
            this.f9452c.edit().putInt("num_failed_fetches", i2).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        synchronized (this.f9453d) {
            this.f9452c.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        synchronized (this.f9453d) {
            this.f9452c.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Date date) {
        synchronized (this.f9453d) {
            this.f9452c.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        synchronized (this.f9453d) {
            this.f9452c.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}