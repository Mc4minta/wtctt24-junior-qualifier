package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class v5 implements Runnable {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7902b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7903c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f7904d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ h5 f7905e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v5(h5 h5Var, String str, String str2, String str3, long j2) {
        this.f7905e = h5Var;
        this.a = str;
        this.f7902b = str2;
        this.f7903c = str3;
        this.f7904d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9 j9Var2;
        String str = this.a;
        if (str == null) {
            j9Var2 = this.f7905e.a;
            j9Var2.f0().P().K(this.f7902b, null);
            return;
        }
        o7 o7Var = new o7(this.f7903c, str, this.f7904d);
        j9Var = this.f7905e.a;
        j9Var.f0().P().K(this.f7902b, o7Var);
    }
}