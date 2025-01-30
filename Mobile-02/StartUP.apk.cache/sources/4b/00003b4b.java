package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
@Keep
/* loaded from: classes2.dex */
public class FirebaseMessagingRegistrar implements com.google.firebase.components.h {

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
    /* loaded from: classes2.dex */
    private static class a<T> implements e.g.a.c.f<T> {
        private a() {
        }

        @Override // e.g.a.c.f
        public final void a(e.g.a.c.c<T> cVar) {
        }

        @Override // e.g.a.c.f
        public final void b(e.g.a.c.c<T> cVar, e.g.a.c.h hVar) {
            hVar.a(null);
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
    /* loaded from: classes2.dex */
    public static class b implements e.g.a.c.g {
        @Override // e.g.a.c.g
        public final <T> e.g.a.c.f<T> a(String str, Class<T> cls, e.g.a.c.b bVar, e.g.a.c.e<T, byte[]> eVar) {
            return new a();
        }
    }

    @Override // com.google.firebase.components.h
    @Keep
    public List<com.google.firebase.components.d<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.d.a(FirebaseMessaging.class).b(com.google.firebase.components.n.f(com.google.firebase.c.class)).b(com.google.firebase.components.n.f(FirebaseInstanceId.class)).b(com.google.firebase.components.n.f(com.google.firebase.i.h.class)).b(com.google.firebase.components.n.f(com.google.firebase.f.c.class)).b(com.google.firebase.components.n.e(e.g.a.c.g.class)).b(com.google.firebase.components.n.f(com.google.firebase.installations.i.class)).f(n.a).c().d(), com.google.firebase.i.g.a("fire-fcm", "20.1.6"));
    }
}