package com.google.firebase.remoteconfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements com.google.android.gms.tasks.a {
    private final e a;

    private a(e eVar) {
        this.a = eVar;
    }

    public static com.google.android.gms.tasks.a b(e eVar) {
        return new a(eVar);
    }

    @Override // com.google.android.gms.tasks.a
    public Object a(com.google.android.gms.tasks.g gVar) {
        boolean k2;
        k2 = this.a.k(gVar);
        return Boolean.valueOf(k2);
    }
}