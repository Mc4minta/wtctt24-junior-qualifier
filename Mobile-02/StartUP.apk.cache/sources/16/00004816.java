package e.g.a.e.d.f;

import java.util.Objects;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
final class p extends o {

    /* renamed from: b  reason: collision with root package name */
    private final n f13156b = new n();

    @Override // e.g.a.e.d.f.o
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.f13156b.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}