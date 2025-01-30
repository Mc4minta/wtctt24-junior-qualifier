package com.google.firebase.installations;

import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
@Keep
/* loaded from: classes2.dex */
public class FirebaseInstallationsRegistrar implements com.google.firebase.components.h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ i lambda$getComponents$0(com.google.firebase.components.e eVar) {
        return new h((com.google.firebase.c) eVar.a(com.google.firebase.c.class), (com.google.firebase.i.h) eVar.a(com.google.firebase.i.h.class), (com.google.firebase.f.c) eVar.a(com.google.firebase.f.c.class));
    }

    @Override // com.google.firebase.components.h
    public List<com.google.firebase.components.d<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.d.a(i.class).b(com.google.firebase.components.n.f(com.google.firebase.c.class)).b(com.google.firebase.components.n.f(com.google.firebase.f.c.class)).b(com.google.firebase.components.n.f(com.google.firebase.i.h.class)).f(j.b()).d(), com.google.firebase.i.g.a("fire-installations", "16.2.2"));
    }
}