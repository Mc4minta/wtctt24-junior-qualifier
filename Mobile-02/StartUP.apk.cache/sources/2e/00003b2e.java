package com.google.firebase.installations;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
class k implements o {
    private final p a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.tasks.h<m> f9221b;

    public k(p pVar, com.google.android.gms.tasks.h<m> hVar) {
        this.a = pVar;
        this.f9221b = hVar;
    }

    @Override // com.google.firebase.installations.o
    public boolean a(com.google.firebase.installations.q.d dVar, Exception exc) {
        if (dVar.i() || dVar.j() || dVar.l()) {
            this.f9221b.d(exc);
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.installations.o
    public boolean b(com.google.firebase.installations.q.d dVar) {
        if (!dVar.k() || this.a.b(dVar)) {
            return false;
        }
        this.f9221b.c(m.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }
}