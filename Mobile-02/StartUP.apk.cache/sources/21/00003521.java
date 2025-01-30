package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class n extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7247e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ ia f7248f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ bd f7249g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(bd bdVar, String str, ia iaVar) {
        super(bdVar);
        this.f7249g = bdVar;
        this.f7247e = str;
        this.f7248f = iaVar;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7249g.q;
        h9Var.getMaxUserProperties(this.f7247e, this.f7248f);
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    protected final void b() {
        this.f7248f.g(null);
    }
}