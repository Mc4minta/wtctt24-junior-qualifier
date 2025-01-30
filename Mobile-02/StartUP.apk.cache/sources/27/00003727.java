package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.measurement.internal.b5;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public class Analytics {
    private static volatile Analytics a;

    /* renamed from: b  reason: collision with root package name */
    private final b5 f7982b;

    private Analytics(b5 b5Var) {
        t.k(b5Var);
        this.f7982b = b5Var;
    }

    @Keep
    public static Analytics getInstance(Context context) {
        if (a == null) {
            synchronized (Analytics.class) {
                if (a == null) {
                    a = new Analytics(b5.a(context, null, null));
                }
            }
        }
        return a;
    }
}