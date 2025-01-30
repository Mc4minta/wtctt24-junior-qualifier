package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.p2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class f implements Runnable {
    private final /* synthetic */ p2 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i1 f9325b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ d f9326c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, p2 p2Var, i1 i1Var) {
        this.f9326c = dVar;
        this.a = p2Var;
        this.f9325b = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9326c.j(this.a, this.f9325b);
    }
}