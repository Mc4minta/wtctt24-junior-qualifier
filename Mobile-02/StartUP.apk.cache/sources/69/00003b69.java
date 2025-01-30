package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
final class w {
    private final SharedPreferences a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Context context) {
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized String a() {
        return this.a.getString("topic_operation_queue", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(String str) {
        this.a.edit().putString("topic_operation_queue", str).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean c(String str) {
        String a = a();
        String valueOf = String.valueOf(str);
        String concat = valueOf.length() != 0 ? ",".concat(valueOf) : new String(",");
        if (a.startsWith(concat)) {
            b(a.substring(concat.length()));
            return true;
        }
        if (v.k()) {
            StringBuilder sb = new StringBuilder(a.length() + 105);
            sb.append("Illegal topic operation queue: ");
            sb.append(a);
            sb.append(". Illegal topic operation queue will lead to any topic operations to fail.");
            Log.d("FirebaseMessaging", sb.toString());
        }
        return false;
    }
}