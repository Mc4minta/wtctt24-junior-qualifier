package com.google.android.gms.measurement.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class c5 extends Thread {
    private final Object a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<z4<?>> f7520b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7521c = false;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ y4 f7522d;

    public c5(y4 y4Var, String str, BlockingQueue<z4<?>> blockingQueue) {
        this.f7522d = y4Var;
        com.google.android.gms.common.internal.t.k(str);
        com.google.android.gms.common.internal.t.k(blockingQueue);
        this.a = new Object();
        this.f7520b = blockingQueue;
        setName(str);
    }

    private final void b(InterruptedException interruptedException) {
        this.f7522d.f().K().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    private final void c() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        c5 c5Var;
        c5 c5Var2;
        obj = this.f7522d.f7953j;
        synchronized (obj) {
            if (!this.f7521c) {
                semaphore = this.f7522d.f7954k;
                semaphore.release();
                obj2 = this.f7522d.f7953j;
                obj2.notifyAll();
                c5Var = this.f7522d.f7947d;
                if (this != c5Var) {
                    c5Var2 = this.f7522d.f7948e;
                    if (this == c5Var2) {
                        y4.B(this.f7522d, null);
                    } else {
                        this.f7522d.f().H().a("Current scheduler thread is neither worker nor network");
                    }
                } else {
                    y4.v(this.f7522d, null);
                }
                this.f7521c = true;
            }
        }
    }

    public final void a() {
        synchronized (this.a) {
            this.a.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        Semaphore semaphore;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore = this.f7522d.f7954k;
                semaphore.acquire();
                z2 = true;
            } catch (InterruptedException e2) {
                b(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                z4<?> poll = this.f7520b.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.f7964b ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.a) {
                        if (this.f7520b.peek() == null) {
                            z = this.f7522d.f7955l;
                            if (!z) {
                                try {
                                    this.a.wait(30000L);
                                } catch (InterruptedException e3) {
                                    b(e3);
                                }
                            }
                        }
                    }
                    obj = this.f7522d.f7953j;
                    synchronized (obj) {
                        if (this.f7520b.peek() == null) {
                            break;
                        }
                    }
                }
            }
            if (this.f7522d.o().u(r.B0)) {
                c();
            }
        } finally {
            c();
        }
    }
}