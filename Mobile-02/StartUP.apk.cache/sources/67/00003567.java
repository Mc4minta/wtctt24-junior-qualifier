package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class r2 {
    private final ConcurrentHashMap<u2, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f7331b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f7331b.poll();
        while (poll != null) {
            this.a.remove(poll);
            poll = this.f7331b.poll();
        }
        List<Throwable> list = this.a.get(new u2(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.a.putIfAbsent(new u2(th, this.f7331b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}