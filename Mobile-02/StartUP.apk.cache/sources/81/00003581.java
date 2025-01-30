package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class t extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7341e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7342f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Object f7343g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ boolean f7344h;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ bd f7345j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(bd bdVar, String str, String str2, Object obj, boolean z) {
        super(bdVar);
        this.f7345j = bdVar;
        this.f7341e = str;
        this.f7342f = str2;
        this.f7343g = obj;
        this.f7344h = z;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7345j.q;
        h9Var.setUserProperty(this.f7341e, this.f7342f, com.google.android.gms.dynamic.b.Y0(this.f7343g), this.f7344h, this.a);
    }
}