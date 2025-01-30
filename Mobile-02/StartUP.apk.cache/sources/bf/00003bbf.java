package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements com.google.android.gms.tasks.f {
    private final j.a a;

    private i(j.a aVar) {
        this.a = aVar;
    }

    public static com.google.android.gms.tasks.f b(j.a aVar) {
        return new i(aVar);
    }

    @Override // com.google.android.gms.tasks.f
    public com.google.android.gms.tasks.g a(Object obj) {
        com.google.android.gms.tasks.g e2;
        f fVar = (f) obj;
        e2 = com.google.android.gms.tasks.j.e(this.a);
        return e2;
    }
}