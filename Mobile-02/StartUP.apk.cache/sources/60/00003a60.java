package com.google.firebase.crashlytics.c.i.x;

import android.util.JsonReader;
import com.google.firebase.crashlytics.c.i.v;
import com.google.firebase.crashlytics.c.i.x.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements h.a {
    private static final a a = new a();

    private a() {
    }

    public static h.a b() {
        return a;
    }

    @Override // com.google.firebase.crashlytics.c.i.x.h.a
    public Object a(JsonReader jsonReader) {
        v.d.AbstractC0173d o;
        o = h.o(jsonReader);
        return o;
    }
}