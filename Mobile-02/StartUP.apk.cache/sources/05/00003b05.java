package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public abstract class p<T> {
    final int a;

    /* renamed from: b  reason: collision with root package name */
    final com.google.android.gms.tasks.h<T> f9176b = new com.google.android.gms.tasks.h<>();

    /* renamed from: c  reason: collision with root package name */
    final int f9177c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f9178d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i2, int i3, Bundle bundle) {
        this.a = i2;
        this.f9177c = i3;
        this.f9178d = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzam zzamVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzamVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f9176b.b(zzamVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(valueOf.length() + 16 + valueOf2.length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f9176b.c(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean d();

    public String toString() {
        int i2 = this.f9177c;
        int i3 = this.a;
        boolean d2 = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i2);
        sb.append(" id=");
        sb.append(i3);
        sb.append(" oneWay=");
        sb.append(d2);
        sb.append("}");
        return sb.toString();
    }
}