package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.z1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class i implements Runnable {
    private final /* synthetic */ z1 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i1 f9329b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ d f9330c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar, z1 z1Var, i1 i1Var) {
        this.f9330c = dVar;
        this.a = z1Var;
        this.f9329b = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9330c.i(this.a, this.f9329b);
    }
}