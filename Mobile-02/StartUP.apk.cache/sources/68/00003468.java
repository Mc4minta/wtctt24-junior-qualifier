package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class b extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7036e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7037f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ ia f7038g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ bd f7039h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(bd bdVar, String str, String str2, ia iaVar) {
        super(bdVar);
        this.f7039h = bdVar;
        this.f7036e = str;
        this.f7037f = str2;
        this.f7038g = iaVar;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7039h.q;
        h9Var.getConditionalUserProperties(this.f7036e, this.f7037f, this.f7038g);
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    protected final void b() {
        this.f7038g.g(null);
    }
}