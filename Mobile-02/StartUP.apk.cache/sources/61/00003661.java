package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public class i4 extends BroadcastReceiver {
    private static final String a = i4.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private final j9 f7633b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7634c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7635d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i4(j9 j9Var) {
        com.google.android.gms.common.internal.t.k(j9Var);
        this.f7633b = j9Var;
    }

    public final void b() {
        this.f7633b.b0();
        this.f7633b.l().d();
        if (this.f7634c) {
            return;
        }
        this.f7633b.h().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f7635d = this.f7633b.S().A();
        this.f7633b.f().P().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f7635d));
        this.f7634c = true;
    }

    public final void c() {
        this.f7633b.b0();
        this.f7633b.l().d();
        this.f7633b.l().d();
        if (this.f7634c) {
            this.f7633b.f().P().a("Unregistering connectivity change receiver");
            this.f7634c = false;
            this.f7635d = false;
            try {
                this.f7633b.h().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f7633b.f().H().b("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f7633b.b0();
        String action = intent.getAction();
        this.f7633b.f().P().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean A = this.f7633b.S().A();
            if (this.f7635d != A) {
                this.f7635d = A;
                this.f7633b.l().A(new l4(this, A));
                return;
            }
            return;
        }
        this.f7633b.f().K().b("NetworkBroadcastReceiver received unknown action", action);
    }
}