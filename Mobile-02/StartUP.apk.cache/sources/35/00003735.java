package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class i {
    public static final Executor a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final Executor f7989b = new a0();

    /* loaded from: classes2.dex */
    private static final class a implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }
}