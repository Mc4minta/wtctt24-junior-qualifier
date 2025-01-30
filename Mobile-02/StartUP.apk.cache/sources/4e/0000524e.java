package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: TypeReference.kt */
/* loaded from: classes3.dex */
public final class m0 implements kotlin.j0.q {
    private final kotlin.j0.e a;

    /* renamed from: b  reason: collision with root package name */
    private final List<kotlin.j0.s> f17320b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17321c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeReference.kt */
    /* loaded from: classes3.dex */
    public static final class a extends o implements kotlin.e0.c.l<kotlin.j0.s, CharSequence> {
        a() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final CharSequence invoke(kotlin.j0.s it) {
            m.g(it, "it");
            return m0.this.c(it);
        }
    }

    public m0(kotlin.j0.e classifier, List<kotlin.j0.s> arguments, boolean z) {
        m.g(classifier, "classifier");
        m.g(arguments, "arguments");
        this.a = classifier;
        this.f17320b = arguments;
        this.f17321c = z;
    }

    private final String b() {
        String d2;
        kotlin.j0.e classifier = getClassifier();
        if (!(classifier instanceof kotlin.j0.d)) {
            classifier = null;
        }
        kotlin.j0.d dVar = (kotlin.j0.d) classifier;
        Class<?> b2 = dVar != null ? kotlin.e0.a.b(dVar) : null;
        if (b2 == null) {
            d2 = getClassifier().toString();
        } else {
            d2 = b2.isArray() ? d(b2) : b2.getName();
        }
        return d2 + (getArguments().isEmpty() ? "" : kotlin.a0.z.h0(getArguments(), ", ", "<", ">", 0, null, new a(), 24, null)) + (isMarkedNullable() ? "?" : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(kotlin.j0.s sVar) {
        String valueOf;
        if (sVar.d() == null) {
            return "*";
        }
        kotlin.j0.q c2 = sVar.c();
        if (!(c2 instanceof m0)) {
            c2 = null;
        }
        m0 m0Var = (m0) c2;
        if (m0Var == null || (valueOf = m0Var.b()) == null) {
            valueOf = String.valueOf(sVar.c());
        }
        kotlin.j0.u d2 = sVar.d();
        if (d2 != null) {
            int i2 = l0.a[d2.ordinal()];
            if (i2 == 1) {
                return valueOf;
            }
            if (i2 == 2) {
                return "in " + valueOf;
            } else if (i2 == 3) {
                return "out " + valueOf;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String d(Class<?> cls) {
        return m.c(cls, boolean[].class) ? "kotlin.BooleanArray" : m.c(cls, char[].class) ? "kotlin.CharArray" : m.c(cls, byte[].class) ? "kotlin.ByteArray" : m.c(cls, short[].class) ? "kotlin.ShortArray" : m.c(cls, int[].class) ? "kotlin.IntArray" : m.c(cls, float[].class) ? "kotlin.FloatArray" : m.c(cls, long[].class) ? "kotlin.LongArray" : m.c(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(Object obj) {
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            if (m.c(getClassifier(), m0Var.getClassifier()) && m.c(getArguments(), m0Var.getArguments()) && isMarkedNullable() == m0Var.isMarkedNullable()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.j0.b
    public List<Annotation> getAnnotations() {
        List<Annotation> g2;
        g2 = kotlin.a0.r.g();
        return g2;
    }

    @Override // kotlin.j0.q
    public List<kotlin.j0.s> getArguments() {
        return this.f17320b;
    }

    @Override // kotlin.j0.q
    public kotlin.j0.e getClassifier() {
        return this.a;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Boolean.valueOf(isMarkedNullable()).hashCode();
    }

    @Override // kotlin.j0.q
    public boolean isMarkedNullable() {
        return this.f17321c;
    }

    public String toString() {
        return b() + " (Kotlin reflection is not available)";
    }
}