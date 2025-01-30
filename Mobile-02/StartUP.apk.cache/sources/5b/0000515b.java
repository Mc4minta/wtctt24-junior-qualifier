package kotlin.a0;

import java.util.AbstractCollection;
import java.util.Collection;

/* compiled from: AbstractMutableCollection.kt */
/* loaded from: classes3.dex */
public abstract class e<E> extends AbstractCollection<E> implements Collection<E>, kotlin.jvm.internal.n0.b {
    public abstract int i();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return i();
    }
}