package kotlin.jvm.internal;

/* compiled from: PackageReference.kt */
/* loaded from: classes3.dex */
public final class u implements d {
    private final Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17322b;

    public u(Class<?> jClass, String moduleName) {
        m.g(jClass, "jClass");
        m.g(moduleName, "moduleName");
        this.a = jClass;
        this.f17322b = moduleName;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && m.c(getJClass(), ((u) obj).getJClass());
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> getJClass() {
        return this.a;
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}