package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.s1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class h implements Runnable {
    private final /* synthetic */ s1 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i1 f9327b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ d f9328c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, s1 s1Var, i1 i1Var) {
        this.f9328c = dVar;
        this.a = s1Var;
        this.f9327b = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9328c.h(this.a, this.f9327b);
    }
}