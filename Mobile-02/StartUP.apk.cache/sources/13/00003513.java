package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class m extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7235e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7236f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ boolean f7237g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ ia f7238h;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ bd f7239j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(bd bdVar, String str, String str2, boolean z, ia iaVar) {
        super(bdVar);
        this.f7239j = bdVar;
        this.f7235e = str;
        this.f7236f = str2;
        this.f7237g = z;
        this.f7238h = iaVar;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7239j.q;
        h9Var.getUserProperties(this.f7235e, this.f7236f, this.f7237g, this.f7238h);
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    protected final void b() {
        this.f7238h.g(null);
    }
}