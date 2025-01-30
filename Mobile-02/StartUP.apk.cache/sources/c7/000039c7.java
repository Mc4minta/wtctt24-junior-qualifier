package com.google.firebase.crashlytics.c.g;

import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class l {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.l.h f8771b;

    public l(String str, com.google.firebase.crashlytics.c.l.h hVar) {
        this.a = str;
        this.f8771b = hVar;
    }

    private File b() {
        return new File(this.f8771b.b(), this.a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.e("Error creating marker: " + this.a, e2);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}