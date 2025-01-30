package com.google.android.gms.internal.p000firebaseperf;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.c  reason: invalid package */
/* loaded from: classes2.dex */
final class c {
    private final ConcurrentHashMap<f, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f6690b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f6690b.poll();
        while (poll != null) {
            this.a.remove(poll);
            poll = this.f6690b.poll();
        }
        List<Throwable> list = this.a.get(new f(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.a.putIfAbsent(new f(th, this.f6690b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}