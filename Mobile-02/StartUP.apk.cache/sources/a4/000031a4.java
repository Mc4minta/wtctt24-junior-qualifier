package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class r extends s0 {

    /* renamed from: f  reason: collision with root package name */
    private final c.e.b<b<?>> f6131f;

    /* renamed from: g  reason: collision with root package name */
    private f f6132g;

    private r(i iVar) {
        super(iVar);
        this.f6131f = new c.e.b<>();
        this.a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void q(Activity activity, f fVar, b<?> bVar) {
        i c2 = LifecycleCallback.c(activity);
        r rVar = (r) c2.b("ConnectionlessLifecycleHelper", r.class);
        if (rVar == null) {
            rVar = new r(c2);
        }
        rVar.f6132g = fVar;
        com.google.android.gms.common.internal.t.l(bVar, "ApiKey cannot be null");
        rVar.f6131f.add(bVar);
        fVar.f(rVar);
    }

    private final void s() {
        if (this.f6131f.isEmpty()) {
            return;
        }
        this.f6132g.f(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void h() {
        super.h();
        s();
    }

    @Override // com.google.android.gms.common.api.internal.s0, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        s();
    }

    @Override // com.google.android.gms.common.api.internal.s0, com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f6132g.j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.s0
    public final void m(com.google.android.gms.common.b bVar, int i2) {
        this.f6132g.c(bVar, i2);
    }

    @Override // com.google.android.gms.common.api.internal.s0
    protected final void o() {
        this.f6132g.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c.e.b<b<?>> r() {
        return this.f6131f;
    }
}