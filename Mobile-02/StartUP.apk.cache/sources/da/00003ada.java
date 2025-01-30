package com.google.firebase.iid;

import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
@Keep
/* loaded from: classes2.dex */
public final class Registrar implements com.google.firebase.components.h {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
    /* loaded from: classes2.dex */
    public static class a implements com.google.firebase.iid.b.a {
        private final FirebaseInstanceId a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.a = firebaseInstanceId;
        }

        @Override // com.google.firebase.iid.b.a
        public final String getId() {
            return this.a.b();
        }
    }

    @Override // com.google.firebase.components.h
    @Keep
    public final List<com.google.firebase.components.d<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.d.a(FirebaseInstanceId.class).b(com.google.firebase.components.n.f(com.google.firebase.c.class)).b(com.google.firebase.components.n.f(com.google.firebase.e.d.class)).b(com.google.firebase.components.n.f(com.google.firebase.i.h.class)).b(com.google.firebase.components.n.f(com.google.firebase.f.c.class)).b(com.google.firebase.components.n.f(com.google.firebase.installations.i.class)).f(s.a).c().d(), com.google.firebase.components.d.a(com.google.firebase.iid.b.a.class).b(com.google.firebase.components.n.f(FirebaseInstanceId.class)).f(t.a).d(), com.google.firebase.i.g.a("fire-iid", "20.1.6"));
    }
}