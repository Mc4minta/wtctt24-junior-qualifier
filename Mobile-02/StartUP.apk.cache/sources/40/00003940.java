package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.i.g;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
@Keep
/* loaded from: classes2.dex */
public class AnalyticsConnectorRegistrar implements h {
    @Override // com.google.firebase.components.h
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<com.google.firebase.components.d<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.d.a(com.google.firebase.analytics.a.a.class).b(n.f(com.google.firebase.c.class)).b(n.f(Context.class)).b(n.f(com.google.firebase.e.d.class)).f(b.a).e().d(), g.a("fire-analytics", "17.4.0"));
    }
}