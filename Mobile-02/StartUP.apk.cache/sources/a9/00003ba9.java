package com.google.firebase.remoteconfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements com.google.android.gms.tasks.a {
    private final e a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.tasks.g f9396b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.tasks.g f9397c;

    private c(e eVar, com.google.android.gms.tasks.g gVar, com.google.android.gms.tasks.g gVar2) {
        this.a = eVar;
        this.f9396b = gVar;
        this.f9397c = gVar2;
    }

    public static com.google.android.gms.tasks.a b(e eVar, com.google.android.gms.tasks.g gVar, com.google.android.gms.tasks.g gVar2) {
        return new c(eVar, gVar, gVar2);
    }

    @Override // com.google.android.gms.tasks.a
    public Object a(com.google.android.gms.tasks.g gVar) {
        return e.h(this.a, this.f9396b, this.f9397c, gVar);
    }
}