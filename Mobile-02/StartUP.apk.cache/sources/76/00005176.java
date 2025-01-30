package kotlin.a0;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes3.dex */
final class p0<T> extends d<T> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private final int f17217b;

    /* renamed from: c  reason: collision with root package name */
    private int f17218c;

    /* renamed from: d  reason: collision with root package name */
    private int f17219d;

    /* renamed from: e  reason: collision with root package name */
    private final Object[] f17220e;

    /* compiled from: SlidingWindow.kt */
    /* loaded from: classes3.dex */
    public static final class a extends c<T> {

        /* renamed from: c  reason: collision with root package name */
        private int f17221c;

        /* renamed from: d  reason: collision with root package name */
        private int f17222d;

        a() {
            this.f17221c = p0.this.size();
            this.f17222d = p0.this.f17218c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.a0.c
        protected void b() {
            if (this.f17221c != 0) {
                d(p0.this.f17220e[this.f17222d]);
                this.f17222d = (this.f17222d + 1) % p0.this.f17217b;
                this.f17221c--;
                return;
            }
            c();
        }
    }

    public p0(Object[] buffer, int i2) {
        kotlin.jvm.internal.m.g(buffer, "buffer");
        this.f17220e = buffer;
        if (i2 >= 0) {
            if (i2 <= buffer.length) {
                this.f17217b = buffer.length;
                this.f17219d = i2;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
    }

    @Override // kotlin.a0.d, java.util.List
    public T get(int i2) {
        d.a.a(i2, size());
        return (T) this.f17220e[(this.f17218c + i2) % this.f17217b];
    }

    @Override // kotlin.a0.a
    public int i() {
        return this.f17219d;
    }

    @Override // kotlin.a0.d, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a();
    }

    public final void o(T t) {
        if (!q()) {
            this.f17220e[(this.f17218c + size()) % this.f17217b] = t;
            this.f17219d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p0<T> p(int i2) {
        int d2;
        Object[] array;
        int i3 = this.f17217b;
        d2 = kotlin.i0.f.d(i3 + (i3 >> 1) + 1, i2);
        if (this.f17218c == 0) {
            array = Arrays.copyOf(this.f17220e, d2);
            kotlin.jvm.internal.m.f(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[d2]);
        }
        return new p0<>(array, size());
    }

    public final boolean q() {
        return size() == this.f17217b;
    }

    public final void r(int i2) {
        if (i2 >= 0) {
            if (!(i2 <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
            } else if (i2 > 0) {
                int i3 = this.f17218c;
                int i4 = (i3 + i2) % this.f17217b;
                if (i3 > i4) {
                    m.k(this.f17220e, null, i3, this.f17217b);
                    m.k(this.f17220e, null, 0, i4);
                } else {
                    m.k(this.f17220e, null, i3, i4);
                }
                this.f17218c = i4;
                this.f17219d = size() - i2;
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.a0.a, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.m.g(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.m.f(array, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.f17218c; i3 < size && i4 < this.f17217b; i4++) {
            array[i3] = this.f17220e[i4];
            i3++;
        }
        while (i3 < size) {
            array[i3] = this.f17220e[i2];
            i3++;
            i2++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public p0(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.a0.a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}