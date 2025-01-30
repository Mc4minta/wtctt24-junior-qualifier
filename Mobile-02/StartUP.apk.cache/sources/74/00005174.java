package kotlin.a0;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReversedViews.kt */
/* loaded from: classes3.dex */
public final class o0<T> extends f<T> {
    private final List<T> a;

    public o0(List<T> delegate) {
        kotlin.jvm.internal.m.g(delegate, "delegate");
        this.a = delegate;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        int J;
        List<T> list = this.a;
        J = x.J(this, i2);
        list.add(J, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        int I;
        List<T> list = this.a;
        I = x.I(this, i2);
        return list.get(I);
    }

    @Override // kotlin.a0.f
    public int i() {
        return this.a.size();
    }

    @Override // kotlin.a0.f
    public T k(int i2) {
        int I;
        List<T> list = this.a;
        I = x.I(this, i2);
        return list.remove(I);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        int I;
        List<T> list = this.a;
        I = x.I(this, i2);
        return list.set(I, t);
    }
}