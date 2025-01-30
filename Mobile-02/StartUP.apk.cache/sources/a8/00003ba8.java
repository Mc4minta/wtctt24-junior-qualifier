package com.google.firebase.remoteconfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements com.google.android.gms.tasks.f {
    private final e a;

    private b(e eVar) {
        this.a = eVar;
    }

    public static com.google.android.gms.tasks.f b(e eVar) {
        return new b(eVar);
    }

    @Override // com.google.android.gms.tasks.f
    public com.google.android.gms.tasks.g a(Object obj) {
        com.google.android.gms.tasks.g b2;
        Void r2 = (Void) obj;
        b2 = this.a.b();
        return b2;
    }
}