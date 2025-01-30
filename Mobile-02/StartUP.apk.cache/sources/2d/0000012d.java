package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
class k0 {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f829b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f830c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f831d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f832e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f833f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f834g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f835h = false;

    public int a() {
        return this.f834g ? this.a : this.f829b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.f829b;
    }

    public int d() {
        return this.f834g ? this.f829b : this.a;
    }

    public void e(int i2, int i3) {
        this.f835h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f832e = i2;
            this.a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f833f = i3;
            this.f829b = i3;
        }
    }

    public void f(boolean z) {
        if (z == this.f834g) {
            return;
        }
        this.f834g = z;
        if (!this.f835h) {
            this.a = this.f832e;
            this.f829b = this.f833f;
        } else if (z) {
            int i2 = this.f831d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f832e;
            }
            this.a = i2;
            int i3 = this.f830c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f833f;
            }
            this.f829b = i3;
        } else {
            int i4 = this.f830c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f832e;
            }
            this.a = i4;
            int i5 = this.f831d;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.f833f;
            }
            this.f829b = i5;
        }
    }

    public void g(int i2, int i3) {
        this.f830c = i2;
        this.f831d = i3;
        this.f835h = true;
        if (this.f834g) {
            if (i3 != Integer.MIN_VALUE) {
                this.a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f829b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f829b = i3;
        }
    }
}