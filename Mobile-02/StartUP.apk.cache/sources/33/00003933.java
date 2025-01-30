package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.d;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.i.g;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
@Keep
/* loaded from: classes2.dex */
public class AbtRegistrar implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a lambda$getComponents$0(e eVar) {
        return new a((Context) eVar.a(Context.class), (com.google.firebase.analytics.a.a) eVar.a(com.google.firebase.analytics.a.a.class));
    }

    @Override // com.google.firebase.components.h
    public List<d<?>> getComponents() {
        return Arrays.asList(d.a(a.class).b(n.f(Context.class)).b(n.e(com.google.firebase.analytics.a.a.class)).f(b.b()).d(), g.a("fire-abt", "19.0.0"));
    }
}