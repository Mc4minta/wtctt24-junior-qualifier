package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class f0 extends Binder {
    private final h0 a;

    public f0(h0 h0Var) {
        this.a = h0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(j0 j0Var) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
            }
            this.a.a(j0Var.a).c(s0.a(), new com.google.android.gms.tasks.c(j0Var) { // from class: com.google.firebase.iid.i0
                private final j0 a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = j0Var;
                }

                @Override // com.google.android.gms.tasks.c
                public final void a(com.google.android.gms.tasks.g gVar) {
                    this.a.b();
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}