package com.google.firebase.crashlytics.c.o;

import com.google.firebase.crashlytics.c.i.v;
import e.g.a.c.e;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class b implements e {
    private static final b a = new b();

    private b() {
    }

    public static e a() {
        return a;
    }

    @Override // e.g.a.c.e
    public Object apply(Object obj) {
        byte[] bytes;
        bytes = c.a.F((v) obj).getBytes(Charset.forName("UTF-8"));
        return bytes;
    }
}