package com.google.firebase.crashlytics.c.j;

import com.google.firebase.crashlytics.c.g.h;
import com.google.firebase.crashlytics.c.j.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class e implements a.InterfaceC0185a {
    private static String b(String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (Throwable th) {
            th = th;
        }
        try {
            String H = h.H(bufferedInputStream);
            h.f(bufferedInputStream);
            return H;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            h.f(bufferedInputStream2);
            throw th;
        }
    }

    @Override // com.google.firebase.crashlytics.c.j.a.InterfaceC0185a
    public String a(File file) throws IOException {
        return b(file.getPath());
    }
}