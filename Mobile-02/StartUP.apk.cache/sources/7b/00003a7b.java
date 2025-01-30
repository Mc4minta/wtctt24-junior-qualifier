package com.google.firebase.crashlytics.c.l;

import android.content.Context;
import java.io.File;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class i implements h {
    private final Context a;

    public i(Context context) {
        this.a = context;
    }

    @Override // com.google.firebase.crashlytics.c.l.h
    public String a() {
        return new File(this.a.getFilesDir(), ".com.google.firebase.crashlytics").getPath();
    }

    @Override // com.google.firebase.crashlytics.c.l.h
    public File b() {
        return c(new File(this.a.getFilesDir(), ".com.google.firebase.crashlytics"));
    }

    File c(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            com.google.firebase.crashlytics.c.b.f().i("Couldn't create file");
            return null;
        }
        com.google.firebase.crashlytics.c.b.f().b("Null File");
        return null;
    }
}