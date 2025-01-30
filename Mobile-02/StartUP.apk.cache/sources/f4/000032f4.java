package com.google.android.gms.internal.clearcut;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;

/* loaded from: classes2.dex */
public final class t2 extends com.google.android.gms.common.api.c<?> implements e.g.a.e.c.c {
    private t2(Context context) {
        super(context, (com.google.android.gms.common.api.a<a.d>) e.g.a.e.c.a.f13097c, (a.d) null, (com.google.android.gms.common.api.internal.n) new com.google.android.gms.common.api.internal.a());
    }

    public static e.g.a.e.c.c o(Context context) {
        return new t2(context);
    }

    @Override // e.g.a.e.c.c
    public final com.google.android.gms.common.api.e<Status> a(e.g.a.e.c.f fVar) {
        return d(new h5(fVar, b()));
    }
}