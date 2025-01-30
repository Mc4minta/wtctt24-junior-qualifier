package com.google.firebase.messaging;

import android.content.Intent;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f9268b;

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
    /* renamed from: com.google.firebase.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0192a {
        private final a a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0192a(a aVar) {
            this.a = (a) com.google.android.gms.common.internal.t.k(aVar);
        }

        final a a() {
            return this.a;
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
    /* loaded from: classes2.dex */
    static class b implements com.google.firebase.encoders.b<a> {
        @Override // com.google.firebase.encoders.b
        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            a aVar = (a) obj;
            com.google.firebase.encoders.c cVar = (com.google.firebase.encoders.c) obj2;
            Intent a = aVar.a();
            cVar.c("ttl", r.l(a));
            cVar.e("event", aVar.b());
            cVar.e("instanceId", r.g());
            cVar.c("priority", r.s(a));
            cVar.e("packageName", r.e());
            cVar.e("sdkPlatform", "ANDROID");
            cVar.e("messageType", r.q(a));
            String p = r.p(a);
            if (p != null) {
                cVar.e("messageId", p);
            }
            String r = r.r(a);
            if (r != null) {
                cVar.e("topic", r);
            }
            String m = r.m(a);
            if (m != null) {
                cVar.e("collapseKey", m);
            }
            if (r.o(a) != null) {
                cVar.e("analyticsLabel", r.o(a));
            }
            if (r.n(a) != null) {
                cVar.e("composerLabel", r.n(a));
            }
            String i2 = r.i();
            if (i2 != null) {
                cVar.e("projectNumber", i2);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
    /* loaded from: classes2.dex */
    static final class c implements com.google.firebase.encoders.b<C0192a> {
        @Override // com.google.firebase.encoders.b
        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            ((com.google.firebase.encoders.c) obj2).e("messaging_client_event", ((C0192a) obj).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, Intent intent) {
        this.a = com.google.android.gms.common.internal.t.h(str, "evenType must be non-null");
        this.f9268b = (Intent) com.google.android.gms.common.internal.t.l(intent, "intent must be non-null");
    }

    final Intent a() {
        return this.f9268b;
    }

    final String b() {
        return this.a;
    }
}