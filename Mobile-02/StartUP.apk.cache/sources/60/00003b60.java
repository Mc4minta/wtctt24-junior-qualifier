package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
final /* synthetic */ class n implements com.google.firebase.components.g {
    static final com.google.firebase.components.g a = new n();

    private n() {
    }

    @Override // com.google.firebase.components.g
    public final Object a(com.google.firebase.components.e eVar) {
        com.google.firebase.c cVar = (com.google.firebase.c) eVar.a(com.google.firebase.c.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) eVar.a(FirebaseInstanceId.class);
        com.google.firebase.i.h hVar = (com.google.firebase.i.h) eVar.a(com.google.firebase.i.h.class);
        com.google.firebase.f.c cVar2 = (com.google.firebase.f.c) eVar.a(com.google.firebase.f.c.class);
        com.google.firebase.installations.i iVar = (com.google.firebase.installations.i) eVar.a(com.google.firebase.installations.i.class);
        e.g.a.c.g gVar = (e.g.a.c.g) eVar.a(e.g.a.c.g.class);
        if (gVar == null || !com.google.android.datatransport.cct.a.f5731f.a().contains(e.g.a.c.b.b("json"))) {
            gVar = new FirebaseMessagingRegistrar.b();
        }
        return new FirebaseMessaging(cVar, firebaseInstanceId, hVar, cVar2, iVar, gVar);
    }
}