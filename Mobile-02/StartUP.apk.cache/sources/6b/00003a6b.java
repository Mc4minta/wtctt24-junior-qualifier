package com.google.firebase.crashlytics.c.j;

import android.content.Context;
import com.google.firebase.crashlytics.c.g.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final class b {
    public static byte[] a(File file, Context context) throws IOException {
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return new byte[0];
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] a = new a(context, new e()).a(bufferedReader);
            h.f(bufferedReader);
            return a;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            h.f(bufferedReader2);
            throw th;
        }
    }
}