package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class h9 extends h {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ j9 f7626e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ e9 f7627f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h9(e9 e9Var, z5 z5Var, j9 j9Var) {
        super(z5Var);
        this.f7627f = e9Var;
        this.f7626e = j9Var;
    }

    @Override // com.google.android.gms.measurement.internal.h
    public final void b() {
        this.f7627f.y();
        this.f7627f.f().P().a("Starting upload from DelayedRunnable");
        this.f7626e.c0();
    }
}