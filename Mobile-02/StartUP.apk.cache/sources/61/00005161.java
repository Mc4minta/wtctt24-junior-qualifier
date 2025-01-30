package kotlin.a0;

import java.util.AbstractSet;
import java.util.Set;

/* compiled from: AbstractMutableSet.kt */
/* loaded from: classes3.dex */
public abstract class h<E> extends AbstractSet<E> implements Set<E>, kotlin.jvm.internal.n0.f {
    public abstract int i();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return i();
    }
}