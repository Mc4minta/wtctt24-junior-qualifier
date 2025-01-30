package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
final class j0 {
    final Intent a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.tasks.h<Void> f9165b = new com.google.android.gms.tasks.h<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Intent intent) {
        this.a = intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.tasks.g<Void> a() {
        return this.f9165b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f9165b.e(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        String action = this.a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        b();
    }
}