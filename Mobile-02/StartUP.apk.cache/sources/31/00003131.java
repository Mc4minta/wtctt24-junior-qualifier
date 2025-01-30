package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class h extends c.o.b.a<Void> implements com.google.android.gms.common.api.internal.m {
    private Semaphore p;
    private Set<com.google.android.gms.common.api.d> q;

    public h(Context context, Set<com.google.android.gms.common.api.d> set) {
        super(context);
        this.p = new Semaphore(0);
        this.q = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // c.o.b.a
    /* renamed from: D */
    public final Void A() {
        int i2 = 0;
        for (com.google.android.gms.common.api.d dVar : this.q) {
            if (dVar.e(this)) {
                i2++;
            }
        }
        try {
            this.p.tryAcquire(i2, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e2) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e2);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // c.o.b.b
    protected final void o() {
        this.p.drainPermits();
        h();
    }
}