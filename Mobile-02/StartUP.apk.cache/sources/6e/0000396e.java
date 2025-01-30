package com.google.firebase.crashlytics;

import com.google.firebase.c;
import com.google.firebase.components.d;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.i.g;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class CrashlyticsRegistrar implements h {
    /* JADX INFO: Access modifiers changed from: private */
    public b b(e eVar) {
        return b.b((c) eVar.a(c.class), (com.google.firebase.iid.b.a) eVar.b(com.google.firebase.iid.b.a.class).get(), (com.google.firebase.crashlytics.c.a) eVar.a(com.google.firebase.crashlytics.c.a.class), (com.google.firebase.analytics.a.a) eVar.a(com.google.firebase.analytics.a.a.class));
    }

    @Override // com.google.firebase.components.h
    public List<d<?>> getComponents() {
        return Arrays.asList(d.a(b.class).b(n.f(c.class)).b(n.g(com.google.firebase.iid.b.a.class)).b(n.e(com.google.firebase.analytics.a.a.class)).b(n.e(com.google.firebase.crashlytics.c.a.class)).f(a.b(this)).e().d(), g.a("fire-cls", "17.0.0"));
    }
}