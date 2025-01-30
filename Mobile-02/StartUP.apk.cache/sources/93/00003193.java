package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class i0 extends e.g.a.e.h.b.e implements d.a, d.b {
    private static a.AbstractC0138a<? extends e.g.a.e.h.e, e.g.a.e.h.a> a = e.g.a.e.h.d.f13207c;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6117b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6118c;

    /* renamed from: d  reason: collision with root package name */
    private final a.AbstractC0138a<? extends e.g.a.e.h.e, e.g.a.e.h.a> f6119d;

    /* renamed from: e  reason: collision with root package name */
    private Set<Scope> f6120e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.gms.common.internal.d f6121f;

    /* renamed from: g  reason: collision with root package name */
    private e.g.a.e.h.e f6122g;

    /* renamed from: h  reason: collision with root package name */
    private j0 f6123h;

    public i0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar) {
        this(context, handler, dVar, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(e.g.a.e.h.b.l lVar) {
        com.google.android.gms.common.b i1 = lVar.i1();
        if (i1.m1()) {
            com.google.android.gms.common.internal.v j1 = lVar.j1();
            com.google.android.gms.common.b j12 = j1.j1();
            if (!j12.m1()) {
                String valueOf = String.valueOf(j12);
                StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f6123h.c(j12);
                this.f6122g.disconnect();
                return;
            }
            this.f6123h.b(j1.i1(), this.f6120e);
        } else {
            this.f6123h.c(i1);
        }
        this.f6122g.disconnect();
    }

    @Override // e.g.a.e.h.b.d
    public final void I(e.g.a.e.h.b.l lVar) {
        this.f6118c.post(new k0(this, lVar));
    }

    public final void b1(j0 j0Var) {
        e.g.a.e.h.e eVar = this.f6122g;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.f6121f.k(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0138a<? extends e.g.a.e.h.e, e.g.a.e.h.a> abstractC0138a = this.f6119d;
        Context context = this.f6117b;
        Looper looper = this.f6118c.getLooper();
        com.google.android.gms.common.internal.d dVar = this.f6121f;
        this.f6122g = abstractC0138a.a(context, looper, dVar, dVar.j(), this, this);
        this.f6123h = j0Var;
        Set<Scope> set = this.f6120e;
        if (set != null && !set.isEmpty()) {
            this.f6122g.g();
        } else {
            this.f6118c.post(new h0(this));
        }
    }

    public final void c1() {
        e.g.a.e.h.e eVar = this.f6122g;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.e
    public final void n(int i2) {
        this.f6122g.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final void p(com.google.android.gms.common.b bVar) {
        this.f6123h.c(bVar);
    }

    @Override // com.google.android.gms.common.api.internal.e
    public final void q(Bundle bundle) {
        this.f6122g.c(this);
    }

    public i0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar, a.AbstractC0138a<? extends e.g.a.e.h.e, e.g.a.e.h.a> abstractC0138a) {
        this.f6117b = context;
        this.f6118c = handler;
        this.f6121f = (com.google.android.gms.common.internal.d) com.google.android.gms.common.internal.t.l(dVar, "ClientSettings must not be null");
        this.f6120e = dVar.i();
        this.f6119d = abstractC0138a;
    }
}