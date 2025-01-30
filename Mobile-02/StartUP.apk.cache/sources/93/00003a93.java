package com.google.firebase.crashlytics.c.o;

import com.google.firebase.crashlytics.c.g.n;
import e.g.a.c.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements h {
    private final com.google.android.gms.tasks.h a;

    /* renamed from: b  reason: collision with root package name */
    private final n f9022b;

    private a(com.google.android.gms.tasks.h hVar, n nVar) {
        this.a = hVar;
        this.f9022b = nVar;
    }

    public static h b(com.google.android.gms.tasks.h hVar, n nVar) {
        return new a(hVar, nVar);
    }

    @Override // e.g.a.c.h
    public void a(Exception exc) {
        c.b(this.a, this.f9022b, exc);
    }
}