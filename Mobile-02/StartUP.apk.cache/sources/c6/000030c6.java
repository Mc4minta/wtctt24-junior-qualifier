package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.e;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class c implements e.g.a.c.i.u.a {
    private final e a;

    private c(e eVar) {
        this.a = eVar;
    }

    public static e.g.a.c.i.u.a a(e eVar) {
        return new c(eVar);
    }

    @Override // e.g.a.c.i.u.a
    public Object apply(Object obj) {
        e.b d2;
        d2 = this.a.d((e.a) obj);
        return d2;
    }
}