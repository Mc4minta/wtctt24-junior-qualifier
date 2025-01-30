package com.google.firebase.crashlytics.c.l;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements FileFilter {
    private final String a;

    private b(String str) {
        this.a = str;
    }

    public static FileFilter a(String str) {
        return new b(str);
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return g.u(this.a, file);
    }
}