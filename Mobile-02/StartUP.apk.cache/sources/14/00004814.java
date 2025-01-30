package e.g.a.e.d.f;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
final class n {
    private final ConcurrentHashMap<q, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f13155b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f13155b.poll();
        while (poll != null) {
            this.a.remove(poll);
            poll = this.f13155b.poll();
        }
        List<Throwable> list = this.a.get(new q(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.a.putIfAbsent(new q(th, this.f13155b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}