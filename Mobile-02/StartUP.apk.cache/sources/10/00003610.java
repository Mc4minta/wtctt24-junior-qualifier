package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class b7 implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7516b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b7(i6 i6Var, boolean z) {
        this.f7516b = i6Var;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean q = this.f7516b.a.q();
        boolean p = this.f7516b.a.p();
        this.f7516b.a.o(this.a);
        if (p == this.a) {
            this.f7516b.a.f().P().b("Default data collection state already set to", Boolean.valueOf(this.a));
        }
        if (this.f7516b.a.q() == q || this.f7516b.a.q() != this.f7516b.a.p()) {
            this.f7516b.a.f().M().c("Default data collection is different than actual status", Boolean.valueOf(this.a), Boolean.valueOf(q));
        }
        this.f7516b.l0();
    }
}