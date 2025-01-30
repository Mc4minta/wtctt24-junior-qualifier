package com.google.firebase.crashlytics.c.i.x;

import android.util.JsonReader;
import com.google.firebase.crashlytics.c.i.v;
import com.google.firebase.crashlytics.c.i.x.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements h.a {
    private static final b a = new b();

    private b() {
    }

    public static h.a b() {
        return a;
    }

    @Override // com.google.firebase.crashlytics.c.i.x.h.a
    public Object a(JsonReader jsonReader) {
        v.c.b y;
        y = h.y(jsonReader);
        return y;
    }
}