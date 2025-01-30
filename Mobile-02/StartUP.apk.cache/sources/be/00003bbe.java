package com.google.firebase.remoteconfig.internal;

import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements com.google.android.gms.tasks.a {
    private final j a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f9433b;

    private h(j jVar, Date date) {
        this.a = jVar;
        this.f9433b = date;
    }

    public static com.google.android.gms.tasks.a b(j jVar, Date date) {
        return new h(jVar, date);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.firebase.remoteconfig.internal.j.o(com.google.firebase.remoteconfig.internal.j, java.util.Date, com.google.android.gms.tasks.g):com.google.android.gms.tasks.g
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException
        */
    @Override // com.google.android.gms.tasks.a
    public java.lang.Object a(com.google.android.gms.tasks.g r3) {
        /*
            r2 = this;
            com.google.firebase.remoteconfig.internal.j r0 = r2.a
            java.util.Date r1 = r2.f9433b
            com.google.android.gms.tasks.g r3 = com.google.firebase.remoteconfig.internal.j.o(r0, r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.h.a(com.google.android.gms.tasks.g):java.lang.Object");
    }
}