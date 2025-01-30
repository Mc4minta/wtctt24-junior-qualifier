package com.amplitude.api;

import java.util.HashSet;
import java.util.Set;

/* compiled from: TrackingOptions.java */
/* loaded from: classes.dex */
public class k {
    private static String[] a = {"city", "country", "dma", "ip_address", "lat_lng", "region"};

    /* renamed from: b  reason: collision with root package name */
    Set<String> f3575b = new HashSet();

    private boolean g(String str) {
        return !this.f3575b.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return g("adid");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return g("carrier");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return g("country");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return g("device_brand");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return g("device_manufacturer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return g("device_model");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return g("language");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return g("lat_lng");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return g("os_name");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return g("os_version");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return g("platform");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return g("version_name");
    }
}