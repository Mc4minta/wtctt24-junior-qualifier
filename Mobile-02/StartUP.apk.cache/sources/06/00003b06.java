package com.google.firebase.iid;

import org.apache.http.HttpStatus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final /* synthetic */ class p0 implements com.google.android.gms.tasks.a {
    static final com.google.android.gms.tasks.a a = new p0();

    private p0() {
    }

    @Override // com.google.android.gms.tasks.a
    public final Object a(com.google.android.gms.tasks.g gVar) {
        Integer valueOf;
        valueOf = Integer.valueOf((int) HttpStatus.SC_FORBIDDEN);
        return valueOf;
    }
}