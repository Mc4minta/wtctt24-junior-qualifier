package com.google.android.gms.common.util.q;

import com.google.android.gms.common.internal.t;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class a implements ThreadFactory {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6338b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f6339c;

    public a(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f6339c.newThread(new b(runnable, 0));
        newThread.setName(this.a);
        return newThread;
    }

    private a(String str, int i2) {
        this.f6339c = Executors.defaultThreadFactory();
        this.a = (String) t.l(str, "Name must not be null");
        this.f6338b = 0;
    }
}