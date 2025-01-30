package com.google.firebase.remoteconfig.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements com.google.android.gms.tasks.a {
    private final j a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9432b;

    private g(j jVar, long j2) {
        this.a = jVar;
        this.f9432b = j2;
    }

    public static com.google.android.gms.tasks.a b(j jVar, long j2) {
        return new g(jVar, j2);
    }

    @Override // com.google.android.gms.tasks.a
    public Object a(com.google.android.gms.tasks.g gVar) {
        com.google.android.gms.tasks.g h2;
        h2 = this.a.h(gVar, this.f9432b);
        return h2;
    }
}