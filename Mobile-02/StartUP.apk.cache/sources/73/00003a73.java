package com.google.firebase.crashlytics.c.l;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements FilenameFilter {
    private final String a;

    private a(String str) {
        this.a = str;
    }

    public static FilenameFilter a(String str) {
        return new a(str);
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean startsWith;
        startsWith = str.startsWith(this.a);
        return startsWith;
    }
}