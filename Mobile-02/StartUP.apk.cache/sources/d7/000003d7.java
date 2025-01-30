package androidx.recyclerview.widget;

/* compiled from: BatchingListUpdateCallback.java */
/* loaded from: classes.dex */
public class e implements n {
    final n a;

    /* renamed from: b  reason: collision with root package name */
    int f2110b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f2111c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f2112d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f2113e = null;

    public e(n nVar) {
        this.a = nVar;
    }

    @Override // androidx.recyclerview.widget.n
    public void a(int i2, int i3) {
        e();
        this.a.a(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n
    public void b(int i2, int i3) {
        int i4;
        if (this.f2110b == 1 && i2 >= (i4 = this.f2111c)) {
            int i5 = this.f2112d;
            if (i2 <= i4 + i5) {
                this.f2112d = i5 + i3;
                this.f2111c = Math.min(i2, i4);
                return;
            }
        }
        e();
        this.f2111c = i2;
        this.f2112d = i3;
        this.f2110b = 1;
    }

    @Override // androidx.recyclerview.widget.n
    public void c(int i2, int i3) {
        int i4;
        if (this.f2110b == 2 && (i4 = this.f2111c) >= i2 && i4 <= i2 + i3) {
            this.f2112d += i3;
            this.f2111c = i2;
            return;
        }
        e();
        this.f2111c = i2;
        this.f2112d = i3;
        this.f2110b = 2;
    }

    @Override // androidx.recyclerview.widget.n
    public void d(int i2, int i3, Object obj) {
        int i4;
        if (this.f2110b == 3) {
            int i5 = this.f2111c;
            int i6 = this.f2112d;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f2113e == obj) {
                this.f2111c = Math.min(i2, i5);
                this.f2112d = Math.max(i6 + i5, i4) - this.f2111c;
                return;
            }
        }
        e();
        this.f2111c = i2;
        this.f2112d = i3;
        this.f2113e = obj;
        this.f2110b = 3;
    }

    public void e() {
        int i2 = this.f2110b;
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            this.a.b(this.f2111c, this.f2112d);
        } else if (i2 == 2) {
            this.a.c(this.f2111c, this.f2112d);
        } else if (i2 == 3) {
            this.a.d(this.f2111c, this.f2112d, this.f2113e);
        }
        this.f2113e = null;
        this.f2110b = 0;
    }
}