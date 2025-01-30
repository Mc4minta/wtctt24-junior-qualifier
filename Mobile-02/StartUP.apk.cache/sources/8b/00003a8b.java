package com.google.firebase.crashlytics.c.n.c;

import java.io.File;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public enum a {
        JAVA,
        NATIVE
    }

    String a();

    Map<String, String> b();

    File c();

    File[] d();

    String e();

    a getType();

    void remove();
}