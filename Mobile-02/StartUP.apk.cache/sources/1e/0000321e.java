package com.google.android.gms.common.n;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class c {
    private static c a = new c();

    /* renamed from: b  reason: collision with root package name */
    private b f6289b = null;

    public static b a(Context context) {
        return a.b(context);
    }

    private final synchronized b b(Context context) {
        if (this.f6289b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f6289b = new b(context);
        }
        return this.f6289b;
    }
}