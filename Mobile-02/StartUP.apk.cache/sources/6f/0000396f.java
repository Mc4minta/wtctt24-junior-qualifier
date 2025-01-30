package com.google.firebase.crashlytics;

import com.google.firebase.components.e;
import com.google.firebase.components.g;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class a implements g {
    private final CrashlyticsRegistrar a;

    private a(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.a = crashlyticsRegistrar;
    }

    public static g b(CrashlyticsRegistrar crashlyticsRegistrar) {
        return new a(crashlyticsRegistrar);
    }

    @Override // com.google.firebase.components.g
    public Object a(e eVar) {
        b b2;
        b2 = this.a.b(eVar);
        return b2;
    }
}