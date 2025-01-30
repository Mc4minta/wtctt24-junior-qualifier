package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z<TResult> {
    private final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Queue<y<TResult>> f8017b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8018c;

    public final void a(g<TResult> gVar) {
        y<TResult> poll;
        synchronized (this.a) {
            if (this.f8017b != null && !this.f8018c) {
                this.f8018c = true;
                while (true) {
                    synchronized (this.a) {
                        poll = this.f8017b.poll();
                        if (poll == null) {
                            this.f8018c = false;
                            return;
                        }
                    }
                    poll.a(gVar);
                }
            }
        }
    }

    public final void b(y<TResult> yVar) {
        synchronized (this.a) {
            if (this.f8017b == null) {
                this.f8017b = new ArrayDeque();
            }
            this.f8017b.add(yVar);
        }
    }
}