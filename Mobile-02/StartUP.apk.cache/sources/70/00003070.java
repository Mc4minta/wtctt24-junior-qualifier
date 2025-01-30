package com.facebook.soloader.o;

/* compiled from: NativeLoader.java */
/* loaded from: classes2.dex */
public class a {
    private static b a;

    private a() {
    }

    public static synchronized void a(b bVar) {
        synchronized (a.class) {
            if (a == null) {
                a = bVar;
            } else {
                throw new IllegalStateException("Cannot re-initialize NativeLoader.");
            }
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (a.class) {
            z = a != null;
        }
        return z;
    }

    public static boolean c(String str) {
        b bVar;
        synchronized (a.class) {
            bVar = a;
            if (bVar == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return bVar.a(str);
    }
}