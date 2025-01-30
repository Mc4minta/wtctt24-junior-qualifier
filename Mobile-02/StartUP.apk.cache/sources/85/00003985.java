package com.google.firebase.crashlytics.c.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c0 implements com.google.android.gms.tasks.a {
    private final e0 a;

    private c0(e0 e0Var) {
        this.a = e0Var;
    }

    public static com.google.android.gms.tasks.a b(e0 e0Var) {
        return new c0(e0Var);
    }

    @Override // com.google.android.gms.tasks.a
    public Object a(com.google.android.gms.tasks.g gVar) {
        boolean i2;
        i2 = this.a.i(gVar);
        return Boolean.valueOf(i2);
    }
}