package com.journeyapps.barcodescanner;

import android.os.Looper;

/* compiled from: Util.java */
/* loaded from: classes2.dex */
public class p {
    public static void a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}