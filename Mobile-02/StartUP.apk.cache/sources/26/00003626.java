package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class d5 implements Runnable {
    private final /* synthetic */ e6 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ b5 f7535b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d5(b5 b5Var, e6 e6Var) {
        this.f7535b = b5Var;
        this.a = e6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7535b.m(this.a);
        this.f7535b.c();
    }
}