package h.c.n0.j;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes3.dex */
public class a<T> {
    final int a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f16765b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f16766c;

    /* renamed from: d  reason: collision with root package name */
    int f16767d;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: h.c.n0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0400a<T> extends h.c.m0.p<T> {
        @Override // h.c.m0.p
        boolean test(T t);
    }

    public a(int i2) {
        this.a = i2;
        Object[] objArr = new Object[i2 + 1];
        this.f16765b = objArr;
        this.f16766c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean a(h.c.z<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16765b
            int r1 = r4.a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = h.c.n0.j.m.q(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h.c.n0.j.a.a(h.c.z):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean b(k.a.c<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16765b
            int r1 = r4.a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = h.c.n0.j.m.s(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h.c.n0.j.a.b(k.a.c):boolean");
    }

    public void c(T t) {
        int i2 = this.a;
        int i3 = this.f16767d;
        if (i3 == i2) {
            Object[] objArr = new Object[i2 + 1];
            this.f16766c[i2] = objArr;
            this.f16766c = objArr;
            i3 = 0;
        }
        this.f16766c[i3] = t;
        this.f16767d = i3 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(h.c.n0.j.a.InterfaceC0400a<? super T> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16765b
            int r1 = r4.a
        L4:
            if (r0 == 0) goto L1d
            r2 = 0
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L18
        Le:
            boolean r3 = r5.test(r3)
            if (r3 == 0) goto L15
            return
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.c.n0.j.a.d(h.c.n0.j.a$a):void");
    }

    public void e(T t) {
        this.f16765b[0] = t;
    }
}