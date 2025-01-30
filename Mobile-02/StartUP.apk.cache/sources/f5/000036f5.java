package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class v4 implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.k2 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f7900b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ s4 f7901c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v4(s4 s4Var, com.google.android.gms.internal.measurement.k2 k2Var, ServiceConnection serviceConnection) {
        this.f7901c = s4Var;
        this.a = k2Var;
        this.f7900b = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        s4 s4Var = this.f7901c;
        t4 t4Var = s4Var.f7849b;
        str = s4Var.a;
        com.google.android.gms.internal.measurement.k2 k2Var = this.a;
        ServiceConnection serviceConnection = this.f7900b;
        Bundle a = t4Var.a(str, k2Var);
        t4Var.a.l().d();
        if (a != null) {
            long j2 = a.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j2 == 0) {
                t4Var.a.f().H().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a.getString("install_referrer");
                if (string != null && !string.isEmpty()) {
                    t4Var.a.f().P().b("InstallReferrer API result", string);
                    Bundle B = t4Var.a.H().B(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (B == null) {
                        t4Var.a.f().H().a("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = B.getString(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM);
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j3 = a.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j3 == 0) {
                                t4Var.a.f().H().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                B.putLong("click_timestamp", j3);
                            }
                        }
                        if (j2 == t4Var.a.B().f7711l.a()) {
                            t4Var.a.g();
                            t4Var.a.f().P().a("Install Referrer campaign has already been logged");
                        } else if (!com.google.android.gms.internal.measurement.m9.b() || !t4Var.a.y().u(r.E0) || t4Var.a.q()) {
                            t4Var.a.B().f7711l.b(j2);
                            t4Var.a.g();
                            t4Var.a.f().P().b("Logging Install Referrer campaign from sdk with ", "referrer API");
                            B.putString("_cis", "referrer API");
                            t4Var.a.G().S("auto", "_cmp", B);
                        }
                    }
                } else {
                    t4Var.a.f().H().a("No referrer defined in Install Referrer response");
                }
            }
        }
        if (serviceConnection != null) {
            com.google.android.gms.common.stats.a.b().c(t4Var.a.h(), serviceConnection);
        }
    }
}