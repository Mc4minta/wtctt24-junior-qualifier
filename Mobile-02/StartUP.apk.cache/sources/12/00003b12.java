package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class v {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Pair<String, String>, com.google.android.gms.tasks.g<a>> f9185b = new c.e.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Executor executor) {
        this.a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ com.google.android.gms.tasks.g a(Pair pair, com.google.android.gms.tasks.g gVar) throws Exception {
        synchronized (this) {
            this.f9185b.remove(pair);
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized com.google.android.gms.tasks.g<a> b(String str, String str2, x xVar) {
        Pair pair = new Pair(str, str2);
        com.google.android.gms.tasks.g<a> gVar = this.f9185b.get(pair);
        if (gVar != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(valueOf.length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return gVar;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        com.google.android.gms.tasks.g k2 = xVar.a().k(this.a, new com.google.android.gms.tasks.a(this, pair) { // from class: com.google.firebase.iid.u
            private final v a;

            /* renamed from: b  reason: collision with root package name */
            private final Pair f9183b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9183b = pair;
            }

            @Override // com.google.android.gms.tasks.a
            public final Object a(com.google.android.gms.tasks.g gVar2) {
                return this.a.a(this.f9183b, gVar2);
            }
        });
        this.f9185b.put(pair, k2);
        return k2;
    }
}