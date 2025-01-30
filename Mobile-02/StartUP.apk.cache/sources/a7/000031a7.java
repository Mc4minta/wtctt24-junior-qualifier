package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class s0 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    protected volatile boolean f6138b;

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicReference<u0> f6139c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f6140d;

    /* renamed from: e  reason: collision with root package name */
    protected final com.google.android.gms.common.e f6141e;

    /* JADX INFO: Access modifiers changed from: protected */
    public s0(i iVar) {
        this(iVar, com.google.android.gms.common.e.o());
    }

    private static int l(u0 u0Var) {
        if (u0Var == null) {
            return -1;
        }
        return u0Var.b();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e(int i2, int i3, Intent intent) {
        u0 u0Var = this.f6139c.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int g2 = this.f6141e.g(b());
                r1 = g2 == 0;
                if (u0Var == null) {
                    return;
                }
                if (u0Var.a().i1() == 18 && g2 == 18) {
                    return;
                }
            }
            r1 = false;
        } else if (i3 != -1) {
            if (i3 == 0) {
                u0 u0Var2 = new u0(new com.google.android.gms.common.b(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, u0Var.a().toString()), l(u0Var));
                this.f6139c.set(u0Var2);
                u0Var = u0Var2;
            }
            r1 = false;
        }
        if (r1) {
            p();
        } else if (u0Var != null) {
            m(u0Var.a(), u0Var.b());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f6139c.set(bundle.getBoolean("resolving_error", false) ? new u0(new com.google.android.gms.common.b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void i(Bundle bundle) {
        super.i(bundle);
        u0 u0Var = this.f6139c.get();
        if (u0Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", u0Var.b());
            bundle.putInt("failed_status", u0Var.a().i1());
            bundle.putParcelable("failed_resolution", u0Var.a().k1());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f6138b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f6138b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void m(com.google.android.gms.common.b bVar, int i2);

    public final void n(com.google.android.gms.common.b bVar, int i2) {
        u0 u0Var = new u0(bVar, i2);
        if (this.f6139c.compareAndSet(null, u0Var)) {
            this.f6140d.post(new t0(this, u0Var));
        }
    }

    protected abstract void o();

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m(new com.google.android.gms.common.b(13, null), l(this.f6139c.get()));
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        this.f6139c.set(null);
        o();
    }

    private s0(i iVar, com.google.android.gms.common.e eVar) {
        super(iVar);
        this.f6139c = new AtomicReference<>(null);
        this.f6140d = new e.g.a.e.d.d.d(Looper.getMainLooper());
        this.f6141e = eVar;
    }
}