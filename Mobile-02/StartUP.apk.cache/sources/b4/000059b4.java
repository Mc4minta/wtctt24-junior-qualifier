package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.a0.n;
import kotlin.a0.s0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n0.a;
import kotlin.x;

/* compiled from: SmartSet.kt */
/* loaded from: classes3.dex */
public final class SmartSet<T> extends AbstractSet<T> {
    public static final Companion Companion = new Companion(null);
    private Object data;
    private int size;

    /* compiled from: SmartSet.kt */
    /* loaded from: classes3.dex */
    private static final class ArrayIterator<T> implements Iterator<T>, a {
        private final Iterator<T> arrayIterator;

        public ArrayIterator(T[] array) {
            m.g(array, "array");
            this.arrayIterator = b.a(array);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.arrayIterator.next();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: SmartSet.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> SmartSet<T> create() {
            return new SmartSet<>(null);
        }

        public final <T> SmartSet<T> create(Collection<? extends T> set) {
            m.g(set, "set");
            SmartSet<T> smartSet = new SmartSet<>(null);
            smartSet.addAll(set);
            return smartSet;
        }
    }

    /* compiled from: SmartSet.kt */
    /* loaded from: classes3.dex */
    private static final class SingletonIterator<T> implements Iterator<T>, a {
        private final T element;
        private boolean hasNext = true;

        public SingletonIterator(T t) {
            this.element = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.hasNext) {
                this.hasNext = false;
                return this.element;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private SmartSet() {
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        boolean u;
        Object[] objArr;
        LinkedHashSet c2;
        if (size() == 0) {
            this.data = t;
        } else if (size() == 1) {
            if (m.c(this.data, t)) {
                return false;
            }
            this.data = new Object[]{this.data, t};
        } else if (size() < 5) {
            Object obj = this.data;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            u = n.u(objArr2, t);
            if (u) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr3 = new Object[objArr2.length];
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                c2 = s0.c(objArr3);
                c2.add(t);
                x xVar = x.a;
                objArr = c2;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                m.f(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                copyOf[copyOf.length - 1] = t;
                x xVar2 = x.a;
                objArr = copyOf;
            }
            this.data = objArr;
        } else {
            Object obj2 = this.data;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!i0.e(obj2).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean u;
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return m.c(this.data, obj);
        }
        if (size() >= 5) {
            Object obj2 = this.data;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
            return ((Set) obj2).contains(obj);
        }
        Object obj3 = this.data;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        u = n.u((Object[]) obj3, obj);
        return u;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new SingletonIterator(this.data);
        }
        if (size() < 5) {
            Object obj = this.data;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new ArrayIterator((Object[]) obj);
        }
        Object obj2 = this.data;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return i0.e(obj2).iterator();
    }

    public void setSize(int i2) {
        this.size = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}