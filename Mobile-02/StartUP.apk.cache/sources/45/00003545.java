package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class p extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f7299e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd f7300f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(bd bdVar, boolean z) {
        super(bdVar);
        this.f7300f = bdVar;
        this.f7299e = z;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7300f.q;
        h9Var.setDataCollectionEnabled(this.f7299e);
    }
}