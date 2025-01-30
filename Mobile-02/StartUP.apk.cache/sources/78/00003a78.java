package com.google.firebase.crashlytics.c.l;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class f implements FilenameFilter {
    private static final f a = new f();

    private f() {
    }

    public static FilenameFilter a() {
        return a;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean startsWith;
        startsWith = str.startsWith("event");
        return startsWith;
    }
}