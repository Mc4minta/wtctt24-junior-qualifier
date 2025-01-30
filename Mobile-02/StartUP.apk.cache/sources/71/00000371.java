package androidx.navigation;

/* compiled from: NavOptions.java */
/* loaded from: classes.dex */
public final class p {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private int f1918b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1919c;

    /* renamed from: d  reason: collision with root package name */
    private int f1920d;

    /* renamed from: e  reason: collision with root package name */
    private int f1921e;

    /* renamed from: f  reason: collision with root package name */
    private int f1922f;

    /* renamed from: g  reason: collision with root package name */
    private int f1923g;

    /* compiled from: NavOptions.java */
    /* loaded from: classes.dex */
    public static final class a {
        boolean a;

        /* renamed from: c  reason: collision with root package name */
        boolean f1925c;

        /* renamed from: b  reason: collision with root package name */
        int f1924b = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1926d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f1927e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f1928f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f1929g = -1;

        public p a() {
            return new p(this.a, this.f1924b, this.f1925c, this.f1926d, this.f1927e, this.f1928f, this.f1929g);
        }

        public a b(int i2) {
            this.f1926d = i2;
            return this;
        }

        public a c(int i2) {
            this.f1927e = i2;
            return this;
        }

        public a d(boolean z) {
            this.a = z;
            return this;
        }

        public a e(int i2) {
            this.f1928f = i2;
            return this;
        }

        public a f(int i2) {
            this.f1929g = i2;
            return this;
        }

        public a g(int i2, boolean z) {
            this.f1924b = i2;
            this.f1925c = z;
            return this;
        }
    }

    p(boolean z, int i2, boolean z2, int i3, int i4, int i5, int i6) {
        this.a = z;
        this.f1918b = i2;
        this.f1919c = z2;
        this.f1920d = i3;
        this.f1921e = i4;
        this.f1922f = i5;
        this.f1923g = i6;
    }

    public int a() {
        return this.f1920d;
    }

    public int b() {
        return this.f1921e;
    }

    public int c() {
        return this.f1922f;
    }

    public int d() {
        return this.f1923g;
    }

    public int e() {
        return this.f1918b;
    }

    public boolean f() {
        return this.f1919c;
    }

    public boolean g() {
        return this.a;
    }
}