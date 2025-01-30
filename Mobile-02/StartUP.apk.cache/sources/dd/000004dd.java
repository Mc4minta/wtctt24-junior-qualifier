package c.e;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2638b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f2639c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f2640d;

    /* renamed from: e  reason: collision with root package name */
    private int f2641e;

    public d() {
        this(10);
    }

    private void f() {
        int i2 = this.f2641e;
        long[] jArr = this.f2639c;
        Object[] objArr = this.f2640d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != a) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2638b = false;
        this.f2641e = i3;
    }

    public void b(long j2, E e2) {
        int i2 = this.f2641e;
        if (i2 != 0 && j2 <= this.f2639c[i2 - 1]) {
            n(j2, e2);
            return;
        }
        if (this.f2638b && i2 >= this.f2639c.length) {
            f();
        }
        int i3 = this.f2641e;
        if (i3 >= this.f2639c.length) {
            int f2 = c.f(i3 + 1);
            long[] jArr = new long[f2];
            Object[] objArr = new Object[f2];
            long[] jArr2 = this.f2639c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f2640d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2639c = jArr;
            this.f2640d = objArr;
        }
        this.f2639c[i3] = j2;
        this.f2640d[i3] = e2;
        this.f2641e = i3 + 1;
    }

    public void c() {
        int i2 = this.f2641e;
        Object[] objArr = this.f2640d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2641e = 0;
        this.f2638b = false;
    }

    /* renamed from: d */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f2639c = (long[]) this.f2639c.clone();
            dVar.f2640d = (Object[]) this.f2640d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean e(long j2) {
        return k(j2) >= 0;
    }

    public E h(long j2) {
        return i(j2, null);
    }

    public E i(long j2, E e2) {
        int b2 = c.b(this.f2639c, this.f2641e, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f2640d;
            if (objArr[b2] != a) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public int k(long j2) {
        if (this.f2638b) {
            f();
        }
        return c.b(this.f2639c, this.f2641e, j2);
    }

    public long l(int i2) {
        if (this.f2638b) {
            f();
        }
        return this.f2639c[i2];
    }

    public void n(long j2, E e2) {
        int b2 = c.b(this.f2639c, this.f2641e, j2);
        if (b2 >= 0) {
            this.f2640d[b2] = e2;
            return;
        }
        int i2 = ~b2;
        int i3 = this.f2641e;
        if (i2 < i3) {
            Object[] objArr = this.f2640d;
            if (objArr[i2] == a) {
                this.f2639c[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f2638b && i3 >= this.f2639c.length) {
            f();
            i2 = ~c.b(this.f2639c, this.f2641e, j2);
        }
        int i4 = this.f2641e;
        if (i4 >= this.f2639c.length) {
            int f2 = c.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.f2639c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f2640d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2639c = jArr;
            this.f2640d = objArr2;
        }
        int i5 = this.f2641e;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f2639c;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f2640d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f2641e - i2);
        }
        this.f2639c[i2] = j2;
        this.f2640d[i2] = e2;
        this.f2641e++;
    }

    public void o(long j2) {
        int b2 = c.b(this.f2639c, this.f2641e, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f2640d;
            Object obj = objArr[b2];
            Object obj2 = a;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.f2638b = true;
            }
        }
    }

    public void p(int i2) {
        Object[] objArr = this.f2640d;
        Object obj = objArr[i2];
        Object obj2 = a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f2638b = true;
        }
    }

    public int q() {
        if (this.f2638b) {
            f();
        }
        return this.f2641e;
    }

    public E r(int i2) {
        if (this.f2638b) {
            f();
        }
        return (E) this.f2640d[i2];
    }

    public String toString() {
        if (q() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2641e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2641e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(l(i2));
            sb.append('=');
            E r = r(i2);
            if (r != this) {
                sb.append(r);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        this.f2638b = false;
        if (i2 == 0) {
            this.f2639c = c.f2636b;
            this.f2640d = c.f2637c;
            return;
        }
        int f2 = c.f(i2);
        this.f2639c = new long[f2];
        this.f2640d = new Object[f2];
    }
}