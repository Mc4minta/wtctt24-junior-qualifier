package com.amplitude.api;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: WorkerThread.java */
/* loaded from: classes.dex */
public class m extends HandlerThread {
    private Handler a;

    public m(String str) {
        super(str);
    }

    private synchronized void c() {
        if (this.a == null) {
            this.a = new Handler(getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        c();
        this.a.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Runnable runnable, long j2) {
        c();
        this.a.postDelayed(runnable, j2);
    }
}