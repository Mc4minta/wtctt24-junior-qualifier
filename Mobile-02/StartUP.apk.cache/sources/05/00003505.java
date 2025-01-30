package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class l extends bd.a {

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7227f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Object f7228g;

    /* renamed from: k  reason: collision with root package name */
    private final /* synthetic */ bd f7231k;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ int f7226e = 5;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ Object f7229h = null;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ Object f7230j = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(bd bdVar, boolean z, int i2, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.f7231k = bdVar;
        this.f7227f = str;
        this.f7228g = obj;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7231k.q;
        h9Var.logHealthData(this.f7226e, this.f7227f, com.google.android.gms.dynamic.b.Y0(this.f7228g), com.google.android.gms.dynamic.b.Y0(this.f7229h), com.google.android.gms.dynamic.b.Y0(this.f7230j));
    }
}