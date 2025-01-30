package c.e;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class h<E> implements Cloneable {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2658b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f2659c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f2660d;

    /* renamed from: e  reason: collision with root package name */
    private int f2661e;

    public h() {
        this(10);
    }

    private void e() {
        int i2 = this.f2661e;
        int[] iArr = this.f2659c;
        Object[] objArr = this.f2660d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != a) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2658b = false;
        this.f2661e = i3;
    }

    public void b(int i2, E e2) {
        int i3 = this.f2661e;
        if (i3 != 0 && i2 <= this.f2659c[i3 - 1]) {
            l(i2, e2);
            return;
        }
        if (this.f2658b && i3 >= this.f2659c.length) {
            e();
        }
        int i4 = this.f2661e;
        if (i4 >= this.f2659c.length) {
            int e3 = c.e(i4 + 1);
            int[] iArr = new int[e3];
            Object[] objArr = new Object[e3];
            int[] iArr2 = this.f2659c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f2660d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2659c = iArr;
            this.f2660d = objArr;
        }
        this.f2659c[i4] = i2;
        this.f2660d[i4] = e2;
        this.f2661e = i4 + 1;
    }

    public void c() {
        int i2 = this.f2661e;
        Object[] objArr = this.f2660d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2661e = 0;
        this.f2658b = false;
    }

    /* renamed from: d */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f2659c = (int[]) this.f2659c.clone();
            hVar.f2660d = (Object[]) this.f2660d.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E f(int i2) {
        return h(i2, null);
    }

    public E h(int i2, E e2) {
        int a2 = c.a(this.f2659c, this.f2661e, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f2660d;
            if (objArr[a2] != a) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public int i(int i2) {
        if (this.f2658b) {
            e();
        }
        return c.a(this.f2659c, this.f2661e, i2);
    }

    public int k(int i2) {
        if (this.f2658b) {
            e();
        }
        return this.f2659c[i2];
    }

    public void l(int i2, E e2) {
        int a2 = c.a(this.f2659c, this.f2661e, i2);
        if (a2 >= 0) {
            this.f2660d[a2] = e2;
            return;
        }
        int i3 = ~a2;
        int i4 = this.f2661e;
        if (i3 < i4) {
            Object[] objArr = this.f2660d;
            if (objArr[i3] == a) {
                this.f2659c[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f2658b && i4 >= this.f2659c.length) {
            e();
            i3 = ~c.a(this.f2659c, this.f2661e, i2);
        }
        int i5 = this.f2661e;
        if (i5 >= this.f2659c.length) {
            int e3 = c.e(i5 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f2659c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f2660d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2659c = iArr;
            this.f2660d = objArr2;
        }
        int i6 = this.f2661e;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.f2659c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f2660d;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f2661e - i3);
        }
        this.f2659c[i3] = i2;
        this.f2660d[i3] = e2;
        this.f2661e++;
    }

    public void n(int i2) {
        int a2 = c.a(this.f2659c, this.f2661e, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f2660d;
            Object obj = objArr[a2];
            Object obj2 = a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f2658b = true;
            }
        }
    }

    public void o(int i2) {
        Object[] objArr = this.f2660d;
        Object obj = objArr[i2];
        Object obj2 = a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f2658b = true;
        }
    }

    public int p() {
        if (this.f2658b) {
            e();
        }
        return this.f2661e;
    }

    public E q(int i2) {
        if (this.f2658b) {
            e();
        }
        return (E) this.f2660d[i2];
    }

    public String toString() {
        if (p() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2661e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2661e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(k(i2));
            sb.append('=');
            E q = q(i2);
            if (q != this) {
                sb.append(q);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i2) {
        this.f2658b = false;
        if (i2 == 0) {
            this.f2659c = c.a;
            this.f2660d = c.f2637c;
            return;
        }
        int e2 = c.e(i2);
        this.f2659c = new int[e2];
        this.f2660d = new Object[e2];
    }
}