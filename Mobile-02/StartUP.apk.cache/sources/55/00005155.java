package kotlin.a0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbstractList.kt */
/* loaded from: classes3.dex */
public abstract class d<E> extends kotlin.a0.a<E> implements List<E>, kotlin.jvm.internal.n0.a {
    public static final a a = new a(null);

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void c(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            } else if (i2 <= i3) {
            } else {
                throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
            }
        }

        public final boolean d(Collection<?> c2, Collection<?> other) {
            kotlin.jvm.internal.m.g(c2, "c");
            kotlin.jvm.internal.m.g(other, "other");
            if (c2.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c2.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.m.c(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection<?> c2) {
            kotlin.jvm.internal.m.g(c2, "c");
            Iterator<?> it = c2.iterator();
            int i2 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i2 = (i2 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    public class b implements Iterator<E>, kotlin.jvm.internal.n0.a {
        private int a;

        public b() {
        }

        protected final int b() {
            return this.a;
        }

        protected final void c(int i2) {
            this.a = i2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < d.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                d dVar = d.this;
                int i2 = this.a;
                this.a = i2 + 1;
                return (E) dVar.get(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    private class c extends d<E>.b implements ListIterator<E>, kotlin.jvm.internal.n0.a {
        public c(int i2) {
            super();
            d.a.b(i2, d.this.size());
            c(i2);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                d dVar = d.this;
                c(b() - 1);
                return (E) dVar.get(b());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.a0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0412d<E> extends d<E> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        private int f17210b;

        /* renamed from: c  reason: collision with root package name */
        private final d<E> f17211c;

        /* renamed from: d  reason: collision with root package name */
        private final int f17212d;

        /* JADX WARN: Multi-variable type inference failed */
        public C0412d(d<? extends E> list, int i2, int i3) {
            kotlin.jvm.internal.m.g(list, "list");
            this.f17211c = list;
            this.f17212d = i2;
            d.a.c(i2, i3, list.size());
            this.f17210b = i3 - i2;
        }

        @Override // kotlin.a0.d, java.util.List
        public E get(int i2) {
            d.a.a(i2, this.f17210b);
            return this.f17211c.get(this.f17212d + i2);
        }

        @Override // kotlin.a0.a
        public int i() {
            return this.f17210b;
        }
    }

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return a.d(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i2);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return a.e(this);
    }

    public int indexOf(Object obj) {
        int i2 = 0;
        for (E e2 : this) {
            if (kotlin.jvm.internal.m.c(e2, obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.m.c(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i2, int i3) {
        return new C0412d(this, i2, i3);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }
}