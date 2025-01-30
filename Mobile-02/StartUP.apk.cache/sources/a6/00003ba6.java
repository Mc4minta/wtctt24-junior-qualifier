package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.n;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
@Keep
/* loaded from: classes2.dex */
public class RemoteConfigRegistrar implements com.google.firebase.components.h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ k lambda$getComponents$0(com.google.firebase.components.e eVar) {
        return new k((Context) eVar.a(Context.class), (com.google.firebase.c) eVar.a(com.google.firebase.c.class), (FirebaseInstanceId) eVar.a(FirebaseInstanceId.class), ((com.google.firebase.abt.component.a) eVar.a(com.google.firebase.abt.component.a.class)).b("frc"), (com.google.firebase.analytics.a.a) eVar.a(com.google.firebase.analytics.a.a.class));
    }

    @Override // com.google.firebase.components.h
    public List<com.google.firebase.components.d<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.d.a(k.class).b(n.f(Context.class)).b(n.f(com.google.firebase.c.class)).b(n.f(FirebaseInstanceId.class)).b(n.f(com.google.firebase.abt.component.a.class)).b(n.e(com.google.firebase.analytics.a.a.class)).f(l.b()).e().d(), com.google.firebase.i.g.a("fire-rc", "19.0.4"));
    }
}