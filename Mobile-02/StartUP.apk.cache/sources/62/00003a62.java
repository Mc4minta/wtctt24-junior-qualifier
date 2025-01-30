package com.google.firebase.crashlytics.c.i.x;

import android.util.JsonReader;
import com.google.firebase.crashlytics.c.i.v;
import com.google.firebase.crashlytics.c.i.x.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements h.a {
    private static final c a = new c();

    private c() {
    }

    public static h.a b() {
        return a;
    }

    @Override // com.google.firebase.crashlytics.c.i.x.h.a
    public Object a(JsonReader jsonReader) {
        v.b m;
        m = h.m(jsonReader);
        return m;
    }
}