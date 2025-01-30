package com.google.firebase.crashlytics.c.l;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements FilenameFilter {
    private static final c a = new c();

    private c() {
    }

    public static FilenameFilter a() {
        return a;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean t;
        t = g.t(file, str);
        return t;
    }
}