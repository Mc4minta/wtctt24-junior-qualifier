package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.soloader.SoLoader;

/* compiled from: NativeJpegTranscoderSoLoader.java */
/* loaded from: classes2.dex */
public class d {
    private static boolean a;

    public static synchronized void a() {
        synchronized (d.class) {
            if (!a) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        SoLoader.j("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError unused) {
                    }
                }
                SoLoader.j("native-imagetranscoder");
                a = true;
            }
        }
    }
}