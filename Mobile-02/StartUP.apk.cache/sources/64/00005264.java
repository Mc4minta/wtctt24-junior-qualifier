package kotlin.k0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequencesJVM.kt */
/* loaded from: classes3.dex */
public final class a<T> implements h<T> {
    private final AtomicReference<h<T>> a;

    public a(h<? extends T> sequence) {
        kotlin.jvm.internal.m.g(sequence, "sequence");
        this.a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.k0.h
    public Iterator<T> iterator() {
        h<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}