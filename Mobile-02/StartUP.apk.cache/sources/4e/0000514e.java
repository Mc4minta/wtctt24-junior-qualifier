package kotlin.a0;

import java.util.Collection;
import java.util.Objects;

/* compiled from: AbstractCollection.kt */
/* loaded from: classes3.dex */
public abstract class a<E> implements Collection<E>, kotlin.jvm.internal.n0.a {

    /* compiled from: AbstractCollection.kt */
    /* renamed from: kotlin.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0411a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<E, CharSequence> {
        C0411a() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
            return invoke((C0411a) obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.l
        public final CharSequence invoke(E e2) {
            return e2 == a.this ? "(this Collection)" : String.valueOf(e2);
        }
    }

    @Override // java.util.Collection
    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (E e2 : this) {
            if (kotlin.jvm.internal.m.c(e2, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.m.g(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    public abstract int i();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return i();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.f.a(this);
    }

    public String toString() {
        String h0;
        h0 = z.h0(this, ", ", "[", "]", 0, null, new C0411a(), 24, null);
        return h0;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.m.g(array, "array");
        T[] tArr = (T[]) kotlin.jvm.internal.f.b(this, array);
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }
}