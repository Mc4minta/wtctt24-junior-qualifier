package com.google.firebase.remoteconfig.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements com.google.android.gms.tasks.f {
    private final e a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9420b;

    /* renamed from: c  reason: collision with root package name */
    private final f f9421c;

    private b(e eVar, boolean z, f fVar) {
        this.a = eVar;
        this.f9420b = z;
        this.f9421c = fVar;
    }

    public static com.google.android.gms.tasks.f b(e eVar, boolean z, f fVar) {
        return new b(eVar, z, fVar);
    }

    @Override // com.google.android.gms.tasks.f
    public com.google.android.gms.tasks.g a(Object obj) {
        return e.h(this.a, this.f9420b, this.f9421c, (Void) obj);
    }
}