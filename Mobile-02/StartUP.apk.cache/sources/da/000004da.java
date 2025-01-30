package c.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Object[] f2626b = new Object[0];

    /* renamed from: c  reason: collision with root package name */
    private static Object[] f2627c;

    /* renamed from: d  reason: collision with root package name */
    private static int f2628d;

    /* renamed from: e  reason: collision with root package name */
    private static Object[] f2629e;

    /* renamed from: f  reason: collision with root package name */
    private static int f2630f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f2631g;

    /* renamed from: h  reason: collision with root package name */
    Object[] f2632h;

    /* renamed from: j  reason: collision with root package name */
    int f2633j;

    /* renamed from: k  reason: collision with root package name */
    private f<E, E> f2634k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArraySet.java */
    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        a() {
        }

        @Override // c.e.f
        protected void a() {
            b.this.clear();
        }

        @Override // c.e.f
        protected Object b(int i2, int i3) {
            return b.this.f2632h[i2];
        }

        @Override // c.e.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // c.e.f
        protected int d() {
            return b.this.f2633j;
        }

        @Override // c.e.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // c.e.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // c.e.f
        protected void g(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // c.e.f
        protected void h(int i2) {
            b.this.p(i2);
        }

        @Override // c.e.f
        protected E i(int i2, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void h(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                Object[] objArr = f2629e;
                if (objArr != null) {
                    this.f2632h = objArr;
                    f2629e = (Object[]) objArr[0];
                    this.f2631g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2630f--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f2627c;
                if (objArr2 != null) {
                    this.f2632h = objArr2;
                    f2627c = (Object[]) objArr2[0];
                    this.f2631g = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2628d--;
                    return;
                }
            }
        }
        this.f2631g = new int[i2];
        this.f2632h = new Object[i2];
    }

    private static void k(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f2630f < 10) {
                    objArr[0] = f2629e;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2629e = objArr;
                    f2630f++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f2628d < 10) {
                    objArr[0] = f2627c;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f2627c = objArr;
                    f2628d++;
                }
            }
        }
    }

    private f<E, E> l() {
        if (this.f2634k == null) {
            this.f2634k = new a();
        }
        return this.f2634k;
    }

    private int m(Object obj, int i2) {
        int i3 = this.f2633j;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f2631g, i3, i2);
        if (a2 >= 0 && !obj.equals(this.f2632h[a2])) {
            int i4 = a2 + 1;
            while (i4 < i3 && this.f2631g[i4] == i2) {
                if (obj.equals(this.f2632h[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a2 - 1; i5 >= 0 && this.f2631g[i5] == i2; i5--) {
                if (obj.equals(this.f2632h[i5])) {
                    return i5;
                }
            }
            return ~i4;
        }
        return a2;
    }

    private int o() {
        int i2 = this.f2633j;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f2631g, i2, 0);
        if (a2 >= 0 && this.f2632h[a2] != null) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.f2631g[i3] == 0) {
                if (this.f2632h[i3] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.f2631g[i4] == 0; i4--) {
                if (this.f2632h[i4] == null) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int m;
        if (e2 == null) {
            m = o();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            m = m(e2, hashCode);
        }
        if (m >= 0) {
            return false;
        }
        int i3 = ~m;
        int i4 = this.f2633j;
        int[] iArr = this.f2631g;
        if (i4 >= iArr.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            Object[] objArr = this.f2632h;
            h(i5);
            int[] iArr2 = this.f2631g;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2632h, 0, objArr.length);
            }
            k(iArr, objArr, this.f2633j);
        }
        int i6 = this.f2633j;
        if (i3 < i6) {
            int[] iArr3 = this.f2631g;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f2632h;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f2633j - i3);
        }
        this.f2631g[i3] = i2;
        this.f2632h[i3] = e2;
        this.f2633j++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        i(this.f2633j + collection.size());
        boolean z = false;
        for (E e2 : collection) {
            z |= add(e2);
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f2633j;
        if (i2 != 0) {
            k(this.f2631g, this.f2632h, i2);
            this.f2631g = a;
            this.f2632h = f2626b;
            this.f2633j = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2633j; i2++) {
                try {
                    if (!set.contains(q(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f2631g;
        int i2 = this.f2633j;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public void i(int i2) {
        int[] iArr = this.f2631g;
        if (iArr.length < i2) {
            Object[] objArr = this.f2632h;
            h(i2);
            int i3 = this.f2633j;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f2631g, 0, i3);
                System.arraycopy(objArr, 0, this.f2632h, 0, this.f2633j);
            }
            k(iArr, objArr, this.f2633j);
        }
    }

    public int indexOf(Object obj) {
        return obj == null ? o() : m(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f2633j <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return l().m().iterator();
    }

    public E p(int i2) {
        Object[] objArr = this.f2632h;
        E e2 = (E) objArr[i2];
        int i3 = this.f2633j;
        if (i3 <= 1) {
            k(this.f2631g, objArr, i3);
            this.f2631g = a;
            this.f2632h = f2626b;
            this.f2633j = 0;
        } else {
            int[] iArr = this.f2631g;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                h(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.f2633j--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f2631g, 0, i2);
                    System.arraycopy(objArr, 0, this.f2632h, 0, i2);
                }
                int i4 = this.f2633j;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, this.f2631g, i2, i4 - i2);
                    System.arraycopy(objArr, i5, this.f2632h, i2, this.f2633j - i2);
                }
            } else {
                int i6 = i3 - 1;
                this.f2633j = i6;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, iArr, i2, i6 - i2);
                    Object[] objArr2 = this.f2632h;
                    System.arraycopy(objArr2, i7, objArr2, i2, this.f2633j - i2);
                }
                this.f2632h[this.f2633j] = null;
            }
        }
        return e2;
    }

    public E q(int i2) {
        return (E) this.f2632h[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            p(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f2633j - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f2632h[i2])) {
                p(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f2633j;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f2633j;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f2632h, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2633j * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2633j; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E q = q(i2);
            if (q != this) {
                sb.append(q);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f2631g = a;
            this.f2632h = f2626b;
        } else {
            h(i2);
        }
        this.f2633j = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f2633j) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2633j));
        }
        System.arraycopy(this.f2632h, 0, tArr, 0, this.f2633j);
        int length = tArr.length;
        int i2 = this.f2633j;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}