package kotlin.jvm.internal;

import java.util.List;

/* compiled from: TypeParameterReference.kt */
/* loaded from: classes3.dex */
public final class k0 implements kotlin.j0.r {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private volatile List<? extends kotlin.j0.q> f17315b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f17316c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17317d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.j0.u f17318e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17319f;

    /* compiled from: TypeParameterReference.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final String a(kotlin.j0.r typeParameter) {
            m.g(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i2 = j0.a[typeParameter.getVariance().ordinal()];
            if (i2 == 2) {
                sb.append("in ");
            } else if (i2 == 3) {
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            String sb2 = sb.toString();
            m.f(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k0(Object obj, String name, kotlin.j0.u variance, boolean z) {
        m.g(name, "name");
        m.g(variance, "variance");
        this.f17316c = obj;
        this.f17317d = name;
        this.f17318e = variance;
        this.f17319f = z;
    }

    public final void a(List<? extends kotlin.j0.q> upperBounds) {
        m.g(upperBounds, "upperBounds");
        if (this.f17315b == null) {
            this.f17315b = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof k0) {
            k0 k0Var = (k0) obj;
            if (m.c(this.f17316c, k0Var.f17316c) && m.c(getName(), k0Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.j0.r
    public String getName() {
        return this.f17317d;
    }

    @Override // kotlin.j0.r
    public List<kotlin.j0.q> getUpperBounds() {
        List<kotlin.j0.q> b2;
        List list = this.f17315b;
        if (list != null) {
            return list;
        }
        b2 = kotlin.a0.q.b(e0.g(Object.class));
        this.f17315b = b2;
        return b2;
    }

    @Override // kotlin.j0.r
    public kotlin.j0.u getVariance() {
        return this.f17318e;
    }

    public int hashCode() {
        Object obj = this.f17316c;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    public String toString() {
        return a.a(this);
    }
}