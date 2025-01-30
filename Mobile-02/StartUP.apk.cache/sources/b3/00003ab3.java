package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.d;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import e.g.a.c.g;
import e.g.a.c.i.q;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
@Keep
/* loaded from: classes2.dex */
public class TransportRegistrar implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ g lambda$getComponents$0(e eVar) {
        q.f((Context) eVar.a(Context.class));
        return q.c().g(com.google.android.datatransport.cct.a.f5731f);
    }

    @Override // com.google.firebase.components.h
    public List<d<?>> getComponents() {
        return Collections.singletonList(d.a(g.class).b(n.f(Context.class)).f(a.b()).d());
    }
}