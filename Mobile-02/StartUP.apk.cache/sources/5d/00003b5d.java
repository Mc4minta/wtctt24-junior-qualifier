package com.google.firebase.messaging;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
final class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        return b("Firebase-Messaging-Rpc-Task");
    }

    private static Executor b(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.google.android.gms.common.util.q.a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor c() {
        return b("Firebase-Messaging-Trigger-Topics-Io");
    }
}