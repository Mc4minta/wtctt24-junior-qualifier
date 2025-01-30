package kotlin.a0.w0;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class c<K, V> implements Map<K, V>, kotlin.jvm.internal.n0.e {
    private static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private int f17237b;

    /* renamed from: c  reason: collision with root package name */
    private int f17238c;

    /* renamed from: d  reason: collision with root package name */
    private kotlin.a0.w0.e<K> f17239d;

    /* renamed from: e  reason: collision with root package name */
    private kotlin.a0.w0.f<V> f17240e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.a0.w0.d<K, V> f17241f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17242g;

    /* renamed from: h  reason: collision with root package name */
    private K[] f17243h;

    /* renamed from: j  reason: collision with root package name */
    private V[] f17244j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f17245k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f17246l;
    private int m;
    private int n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i2) {
            int b2;
            b2 = kotlin.i0.f.b(i2, 1);
            return Integer.highestOneBit(b2 * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, kotlin.jvm.internal.n0.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c<K, V> map) {
            super(map);
            m.g(map, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: i */
        public C0413c<K, V> next() {
            if (b() < ((c) d()).n) {
                int b2 = b();
                f(b2 + 1);
                g(b2);
                C0413c<K, V> c0413c = new C0413c<>(d(), c());
                e();
                return c0413c;
            }
            throw new NoSuchElementException();
        }

        public final void j(StringBuilder sb) {
            m.g(sb, "sb");
            if (b() < ((c) d()).n) {
                int b2 = b();
                f(b2 + 1);
                g(b2);
                Object obj = ((c) d()).f17243h[c()];
                if (m.c(obj, d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = ((c) d()).f17244j;
                m.e(objArr);
                Object obj2 = objArr[c()];
                if (m.c(obj2, d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                e();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int k() {
            if (b() < ((c) d()).n) {
                int b2 = b();
                f(b2 + 1);
                g(b2);
                Object obj = ((c) d()).f17243h[c()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = ((c) d()).f17244j;
                m.e(objArr);
                Object obj2 = objArr[c()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                e();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* renamed from: kotlin.a0.w0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0413c<K, V> implements Map.Entry<K, V>, kotlin.jvm.internal.n0.a {
        private final c<K, V> a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17247b;

        public C0413c(c<K, V> map, int i2) {
            m.g(map, "map");
            this.a = map;
            this.f17247b = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (m.c(entry.getKey(), getKey()) && m.c(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((c) this.a).f17243h[this.f17247b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((c) this.a).f17244j;
            m.e(objArr);
            return (V) objArr[this.f17247b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.a.k();
            Object[] i2 = this.a.i();
            int i3 = this.f17247b;
            V v2 = (V) i2[i3];
            i2[i3] = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static class d<K, V> {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f17248b;

        /* renamed from: c  reason: collision with root package name */
        private final c<K, V> f17249c;

        public d(c<K, V> map) {
            m.g(map, "map");
            this.f17249c = map;
            this.f17248b = -1;
            e();
        }

        public final int b() {
            return this.a;
        }

        public final int c() {
            return this.f17248b;
        }

        public final c<K, V> d() {
            return this.f17249c;
        }

        public final void e() {
            while (this.a < ((c) this.f17249c).n) {
                int[] iArr = ((c) this.f17249c).f17245k;
                int i2 = this.a;
                if (iArr[i2] >= 0) {
                    return;
                }
                this.a = i2 + 1;
            }
        }

        public final void f(int i2) {
            this.a = i2;
        }

        public final void g(int i2) {
            this.f17248b = i2;
        }

        public final boolean hasNext() {
            return this.a < ((c) this.f17249c).n;
        }

        public final void remove() {
            this.f17249c.k();
            this.f17249c.J(this.f17248b);
            this.f17248b = -1;
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, kotlin.jvm.internal.n0.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c<K, V> map) {
            super(map);
            m.g(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (b() < ((c) d()).n) {
                int b2 = b();
                f(b2 + 1);
                g(b2);
                K k2 = (K) ((c) d()).f17243h[c()];
                e();
                return k2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, kotlin.jvm.internal.n0.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c<K, V> map) {
            super(map);
            m.g(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (b() < ((c) d()).n) {
                int b2 = b();
                f(b2 + 1);
                g(b2);
                Object[] objArr = ((c) d()).f17244j;
                m.e(objArr);
                V v = (V) objArr[c()];
                e();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    private c(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.f17243h = kArr;
        this.f17244j = vArr;
        this.f17245k = iArr;
        this.f17246l = iArr2;
        this.m = i2;
        this.n = i3;
        this.f17237b = a.d(w());
    }

    private final int A(K k2) {
        return ((k2 != null ? k2.hashCode() : 0) * (-1640531527)) >>> this.f17237b;
    }

    private final boolean C(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        q(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (D(entry)) {
                z = true;
            }
        }
        return z;
    }

    private final boolean D(Map.Entry<? extends K, ? extends V> entry) {
        int g2 = g(entry.getKey());
        V[] i2 = i();
        if (g2 >= 0) {
            i2[g2] = entry.getValue();
            return true;
        }
        int i3 = (-g2) - 1;
        if (!m.c(entry.getValue(), i2[i3])) {
            i2[i3] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean E(int i2) {
        int A = A(this.f17243h[i2]);
        int i3 = this.m;
        while (true) {
            int[] iArr = this.f17246l;
            if (iArr[A] == 0) {
                iArr[A] = i2 + 1;
                this.f17245k[i2] = A;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            A = A == 0 ? w() - 1 : A - 1;
        }
    }

    private final void F(int i2) {
        if (this.n > size()) {
            l();
        }
        int i3 = 0;
        if (i2 != w()) {
            this.f17246l = new int[i2];
            this.f17237b = a.d(i2);
        } else {
            kotlin.a0.m.j(this.f17246l, 0, 0, w());
        }
        while (i3 < this.n) {
            int i4 = i3 + 1;
            if (!E(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i3 = i4;
        }
    }

    private final void H(int i2) {
        int d2;
        d2 = kotlin.i0.f.d(this.m * 2, w() / 2);
        int i3 = d2;
        int i4 = 0;
        int i5 = i2;
        do {
            i2 = i2 == 0 ? w() - 1 : i2 - 1;
            i4++;
            if (i4 > this.m) {
                this.f17246l[i5] = 0;
                return;
            }
            int[] iArr = this.f17246l;
            int i6 = iArr[i2];
            if (i6 == 0) {
                iArr[i5] = 0;
                return;
            }
            if (i6 < 0) {
                iArr[i5] = -1;
            } else {
                int i7 = i6 - 1;
                if (((A(this.f17243h[i7]) - i2) & (w() - 1)) >= i4) {
                    this.f17246l[i5] = i6;
                    this.f17245k[i7] = i5;
                }
                i3--;
            }
            i5 = i2;
            i4 = 0;
            i3--;
        } while (i3 >= 0);
        this.f17246l[i5] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(int i2) {
        kotlin.a0.w0.b.c(this.f17243h, i2);
        H(this.f17245k[i2]);
        this.f17245k[i2] = -1;
        this.f17238c = size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] i() {
        V[] vArr = this.f17244j;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.a0.w0.b.a(u());
        this.f17244j = vArr2;
        return vArr2;
    }

    private final void l() {
        int i2;
        V[] vArr = this.f17244j;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            if (this.f17245k[i3] >= 0) {
                K[] kArr = this.f17243h;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        kotlin.a0.w0.b.d(this.f17243h, i4, i2);
        if (vArr != null) {
            kotlin.a0.w0.b.d(vArr, i4, this.n);
        }
        this.n = i4;
    }

    private final boolean o(Map<?, ?> map) {
        return size() == map.size() && m(map.entrySet());
    }

    private final void p(int i2) {
        if (i2 > u()) {
            int u = (u() * 3) / 2;
            if (i2 <= u) {
                i2 = u;
            }
            this.f17243h = (K[]) kotlin.a0.w0.b.b(this.f17243h, i2);
            V[] vArr = this.f17244j;
            this.f17244j = vArr != null ? (V[]) kotlin.a0.w0.b.b(vArr, i2) : null;
            int[] copyOf = Arrays.copyOf(this.f17245k, i2);
            m.f(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.f17245k = copyOf;
            int c2 = a.c(i2);
            if (c2 > w()) {
                F(c2);
            }
        } else if ((this.n + i2) - size() > u()) {
            F(w());
        }
    }

    private final void q(int i2) {
        p(this.n + i2);
    }

    private final int s(K k2) {
        int A = A(k2);
        int i2 = this.m;
        while (true) {
            int i3 = this.f17246l[A];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (m.c(this.f17243h[i4], k2)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            A = A == 0 ? w() - 1 : A - 1;
        }
    }

    private final int t(V v) {
        int i2 = this.n;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f17245k[i2] >= 0) {
                V[] vArr = this.f17244j;
                m.e(vArr);
                if (m.c(vArr[i2], v)) {
                    return i2;
                }
            }
        }
    }

    private final int u() {
        return this.f17243h.length;
    }

    private final int w() {
        return this.f17246l.length;
    }

    public final e<K, V> B() {
        return new e<>(this);
    }

    public final boolean G(Map.Entry<? extends K, ? extends V> entry) {
        m.g(entry, "entry");
        k();
        int s = s(entry.getKey());
        if (s < 0) {
            return false;
        }
        V[] vArr = this.f17244j;
        m.e(vArr);
        if (!m.c(vArr[s], entry.getValue())) {
            return false;
        }
        J(s);
        return true;
    }

    public final int I(K k2) {
        k();
        int s = s(k2);
        if (s < 0) {
            return -1;
        }
        J(s);
        return s;
    }

    public final boolean K(V v) {
        k();
        int t = t(v);
        if (t < 0) {
            return false;
        }
        J(t);
        return true;
    }

    public final f<K, V> L() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        k();
        int i2 = this.n - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f17245k;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.f17246l[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        kotlin.a0.w0.b.d(this.f17243h, 0, this.n);
        V[] vArr = this.f17244j;
        if (vArr != null) {
            kotlin.a0.w0.b.d(vArr, 0, this.n);
        }
        this.f17238c = 0;
        this.n = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return s(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return t(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return v();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && o((Map) obj));
    }

    public final int g(K k2) {
        int d2;
        k();
        while (true) {
            int A = A(k2);
            d2 = kotlin.i0.f.d(this.m * 2, w() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.f17246l[A];
                if (i3 <= 0) {
                    if (this.n >= u()) {
                        q(1);
                    } else {
                        int i4 = this.n;
                        int i5 = i4 + 1;
                        this.n = i5;
                        this.f17243h[i4] = k2;
                        this.f17245k[i4] = A;
                        this.f17246l[A] = i5;
                        this.f17238c = size() + 1;
                        if (i2 > this.m) {
                            this.m = i2;
                        }
                        return i4;
                    }
                } else if (m.c(this.f17243h[i3 - 1], k2)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > d2) {
                        F(w() * 2);
                        break;
                    }
                    A = A == 0 ? w() - 1 : A - 1;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int s = s(obj);
        if (s < 0) {
            return null;
        }
        V[] vArr = this.f17244j;
        m.e(vArr);
        return vArr[s];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> r = r();
        int i2 = 0;
        while (r.hasNext()) {
            i2 += r.k();
        }
        return i2;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Map<K, V> j() {
        k();
        this.f17242g = true;
        return this;
    }

    public final void k() {
        if (this.f17242g) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return x();
    }

    public final boolean m(Collection<?> m) {
        m.g(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!n((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean n(Map.Entry<? extends K, ? extends V> entry) {
        m.g(entry, "entry");
        int s = s(entry.getKey());
        if (s < 0) {
            return false;
        }
        V[] vArr = this.f17244j;
        m.e(vArr);
        return m.c(vArr[s], entry.getValue());
    }

    @Override // java.util.Map
    public V put(K k2, V v) {
        k();
        int g2 = g(k2);
        V[] i2 = i();
        if (g2 < 0) {
            int i3 = (-g2) - 1;
            V v2 = i2[i3];
            i2[i3] = v;
            return v2;
        }
        i2[g2] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        m.g(from, "from");
        k();
        C(from.entrySet());
    }

    public final b<K, V> r() {
        return new b<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int I = I(obj);
        if (I < 0) {
            return null;
        }
        V[] vArr = this.f17244j;
        m.e(vArr);
        V v = vArr[I];
        kotlin.a0.w0.b.c(vArr, I);
        return v;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return y();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> r = r();
        int i2 = 0;
        while (r.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            r.j(sb);
            i2++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        m.f(sb2, "sb.toString()");
        return sb2;
    }

    public Set<Map.Entry<K, V>> v() {
        kotlin.a0.w0.d<K, V> dVar = this.f17241f;
        if (dVar == null) {
            kotlin.a0.w0.d<K, V> dVar2 = new kotlin.a0.w0.d<>(this);
            this.f17241f = dVar2;
            return dVar2;
        }
        return dVar;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return z();
    }

    public Set<K> x() {
        kotlin.a0.w0.e<K> eVar = this.f17239d;
        if (eVar == null) {
            kotlin.a0.w0.e<K> eVar2 = new kotlin.a0.w0.e<>(this);
            this.f17239d = eVar2;
            return eVar2;
        }
        return eVar;
    }

    public int y() {
        return this.f17238c;
    }

    public Collection<V> z() {
        kotlin.a0.w0.f<V> fVar = this.f17240e;
        if (fVar == null) {
            kotlin.a0.w0.f<V> fVar2 = new kotlin.a0.w0.f<>(this);
            this.f17240e = fVar2;
            return fVar2;
        }
        return fVar;
    }

    public c() {
        this(8);
    }

    public c(int i2) {
        this(kotlin.a0.w0.b.a(i2), null, new int[i2], new int[a.c(i2)], 2, 0);
    }
}