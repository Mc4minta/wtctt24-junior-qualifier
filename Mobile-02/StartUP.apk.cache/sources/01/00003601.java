package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class a4 implements Runnable {
    private final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7480b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f7481c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Object f7482d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Object f7483e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ x3 f7484f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a4(x3 x3Var, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f7484f = x3Var;
        this.a = i2;
        this.f7480b = str;
        this.f7481c = obj;
        this.f7482d = obj2;
        this.f7483e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c2;
        long j2;
        char c3;
        long j3;
        k4 B = this.f7484f.a.B();
        if (B.u()) {
            c2 = this.f7484f.f7930c;
            if (c2 == 0) {
                if (this.f7484f.o().G()) {
                    x3 x3Var = this.f7484f;
                    x3Var.g();
                    x3Var.f7930c = 'C';
                } else {
                    x3 x3Var2 = this.f7484f;
                    x3Var2.g();
                    x3Var2.f7930c = 'c';
                }
            }
            j2 = this.f7484f.f7931d;
            if (j2 < 0) {
                x3 x3Var3 = this.f7484f;
                x3Var3.f7931d = x3Var3.o().E();
            }
            char charAt = "01VDIWEA?".charAt(this.a);
            c3 = this.f7484f.f7930c;
            j3 = this.f7484f.f7931d;
            String A = x3.A(true, this.f7480b, this.f7481c, this.f7482d, this.f7483e);
            StringBuilder sb = new StringBuilder(String.valueOf(A).length() + 24);
            sb.append("2");
            sb.append(charAt);
            sb.append(c3);
            sb.append(j3);
            sb.append(":");
            sb.append(A);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.f7480b.substring(0, 1024);
            }
            B.f7704e.b(sb2, 1L);
            return;
        }
        this.f7484f.B(6, "Persisted config not initialized. Not logging error/warn");
    }
}