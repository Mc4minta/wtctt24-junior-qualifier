package com.google.android.datatransport.runtime.backends;

import android.content.Context;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class h {
    public static h a(Context context, e.g.a.c.i.w.a aVar, e.g.a.c.i.w.a aVar2, String str) {
        return new c(context, aVar, aVar2, str);
    }

    public abstract Context b();

    public abstract String c();

    public abstract e.g.a.c.i.w.a d();

    public abstract e.g.a.c.i.w.a e();
}