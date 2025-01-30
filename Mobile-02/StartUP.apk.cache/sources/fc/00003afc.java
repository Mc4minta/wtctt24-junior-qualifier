package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
final class k1 implements c0 {
    private final ExecutorService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(ExecutorService executorService) {
        this.a = executorService;
    }

    @Override // com.google.firebase.iid.c0
    public final com.google.android.gms.tasks.g<Integer> a(final Intent intent) {
        return com.google.android.gms.tasks.j.c(this.a, new Callable(intent) { // from class: com.google.firebase.iid.j1
            private final Intent a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Intent intent2 = this.a;
                String stringExtra = intent2.getStringExtra("CMD");
                if (stringExtra != null) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(stringExtra.length() + 21 + valueOf.length());
                        sb.append("Received command: ");
                        sb.append(stringExtra);
                        sb.append(" - ");
                        sb.append(valueOf);
                        Log.d("FirebaseInstanceId", sb.toString());
                    }
                    if (!"RST".equals(stringExtra) && !"RST_FULL".equals(stringExtra)) {
                        if ("SYNC".equals(stringExtra)) {
                            FirebaseInstanceId.c().B();
                        }
                    } else {
                        FirebaseInstanceId.c().z();
                    }
                }
                return -1;
            }
        });
    }
}