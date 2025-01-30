package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: DirectorySoSource.java */
/* loaded from: classes2.dex */
public class c extends l {
    protected final File a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f5617b;

    public c(File file, int i2) {
        this.a = file;
        this.f5617b = i2;
    }

    private static String[] d(File file) throws IOException {
        boolean z = SoLoader.a;
        if (z) {
            Api18TraceUtils.a("SoLoader.getElfDependencies[", file.getName(), "]");
        }
        try {
            String[] a = i.a(file);
            if (z) {
                Api18TraceUtils.b();
            }
            return a;
        } catch (Throwable th) {
            if (SoLoader.a) {
                Api18TraceUtils.b();
            }
            throw th;
        }
    }

    private void e(File file, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] d2 = d(file);
        Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(d2));
        for (String str : d2) {
            if (!str.startsWith("/")) {
                SoLoader.l(str, (i2 | 1) & (-3), threadPolicy);
            }
        }
    }

    @Override // com.facebook.soloader.l
    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return f(str, i2, this.a, threadPolicy);
    }

    @Override // com.facebook.soloader.l
    public File c(String str) throws IOException {
        File file = new File(this.a, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f(String str, int i2, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
            return 0;
        }
        Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
        if ((i2 & 1) != 0 && (this.f5617b & 2) != 0) {
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        if ((this.f5617b & 1) != 0) {
            e(file2, i2, threadPolicy);
        } else {
            Log.d("SoLoader", "Not resolving dependencies for " + str);
        }
        try {
            SoLoader.f5596b.a(file2.getAbsolutePath(), i2);
            return 1;
        } catch (UnsatisfiedLinkError e2) {
            if (e2.getMessage().contains("bad ELF magic")) {
                Log.d("SoLoader", "Corrupted lib file detected");
                return 3;
            }
            throw e2;
        }
    }

    @Override // com.facebook.soloader.l
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.a.getCanonicalPath());
        } catch (IOException unused) {
            name = this.a.getName();
        }
        return getClass().getName() + "[root = " + name + " flags = " + this.f5617b + ']';
    }
}