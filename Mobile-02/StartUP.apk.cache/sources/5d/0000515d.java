package kotlin.a0;

import java.util.AbstractList;
import java.util.List;

/* compiled from: AbstractMutableList.kt */
/* loaded from: classes3.dex */
public abstract class f<E> extends AbstractList<E> implements List<E>, kotlin.jvm.internal.n0.d {
    public abstract int i();

    public abstract E k(int i2);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i2) {
        return k(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return i();
    }
}