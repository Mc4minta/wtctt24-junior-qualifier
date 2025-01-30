package com.google.firebase.installations;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
class l implements o {
    final com.google.android.gms.tasks.h<String> a;

    public l(com.google.android.gms.tasks.h<String> hVar) {
        this.a = hVar;
    }

    @Override // com.google.firebase.installations.o
    public boolean a(com.google.firebase.installations.q.d dVar, Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.o
    public boolean b(com.google.firebase.installations.q.d dVar) {
        if (dVar.l() || dVar.k() || dVar.i()) {
            this.a.e(dVar.d());
            return true;
        }
        return false;
    }
}