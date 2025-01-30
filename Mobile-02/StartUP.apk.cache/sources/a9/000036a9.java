package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class o5 implements Runnable {
    private final /* synthetic */ p a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7781b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ h5 f7782c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o5(h5 h5Var, p pVar, String str) {
        this.f7782c = h5Var;
        this.a = pVar;
        this.f7781b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7782c.a;
        j9Var.d0();
        j9Var2 = this.f7782c.a;
        j9Var2.q(this.a, this.f7781b);
    }
}