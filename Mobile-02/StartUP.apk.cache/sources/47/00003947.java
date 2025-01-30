package com.google.firebase;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements com.google.firebase.g.a {
    private final c a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f8594b;

    private b(c cVar, Context context) {
        this.a = cVar;
        this.f8594b = context;
    }

    public static com.google.firebase.g.a a(c cVar, Context context) {
        return new b(cVar, context);
    }

    @Override // com.google.firebase.g.a
    public Object get() {
        return c.r(this.a, this.f8594b);
    }
}