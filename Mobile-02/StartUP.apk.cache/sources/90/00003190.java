package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class h {
    private final Object a;

    public h(Activity activity) {
        com.google.android.gms.common.internal.t.l(activity, "Activity must not be null");
        this.a = activity;
    }

    public Activity a() {
        return (Activity) this.a;
    }

    public androidx.fragment.app.d b() {
        return (androidx.fragment.app.d) this.a;
    }

    public boolean c() {
        return this.a instanceof androidx.fragment.app.d;
    }

    public final boolean d() {
        return this.a instanceof Activity;
    }
}