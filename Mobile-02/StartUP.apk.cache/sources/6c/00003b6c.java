package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.firebase.c;
import com.google.firebase.components.d;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.i.g;
import com.google.firebase.remoteconfig.k;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
@Keep
/* loaded from: classes2.dex */
public class FirebasePerfRegistrar implements h {
    @Override // com.google.firebase.components.h
    @Keep
    public List<d<?>> getComponents() {
        return Arrays.asList(d.a(a.class).b(n.f(c.class)).b(n.f(k.class)).f(b.a).e().d(), g.a("fire-perf", "19.0.7"));
    }
}