package com.facebook.imagepipeline.nativecode;

/* compiled from: WebpTranscoderFactory.java */
/* loaded from: classes2.dex */
public class f {
    private static e a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4628b;

    static {
        try {
            a = (e) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            f4628b = true;
        } catch (Throwable unused) {
            f4628b = false;
        }
    }

    public static e a() {
        return a;
    }
}