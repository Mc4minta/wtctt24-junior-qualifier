package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class q extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Long f7307e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7308f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ String f7309g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ Bundle f7310h;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ boolean f7311j;

    /* renamed from: k  reason: collision with root package name */
    private final /* synthetic */ boolean f7312k;

    /* renamed from: l  reason: collision with root package name */
    private final /* synthetic */ bd f7313l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(bd bdVar, Long l2, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(bdVar);
        this.f7313l = bdVar;
        this.f7307e = l2;
        this.f7308f = str;
        this.f7309g = str2;
        this.f7310h = bundle;
        this.f7311j = z;
        this.f7312k = z2;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        Long l2 = this.f7307e;
        long longValue = l2 == null ? this.a : l2.longValue();
        h9Var = this.f7313l.q;
        h9Var.logEvent(this.f7308f, this.f7309g, this.f7310h, this.f7311j, this.f7312k, longValue);
    }
}