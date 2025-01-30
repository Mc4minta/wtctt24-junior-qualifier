package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class k0 implements Runnable {
    private final /* synthetic */ e.g.a.e.h.b.l a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i0 f6125b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(i0 i0Var, e.g.a.e.h.b.l lVar) {
        this.f6125b = i0Var;
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6125b.d1(this.a);
    }
}