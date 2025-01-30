package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import kotlin.a0.j;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* compiled from: ReflectJavaWildcardType.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    private final Collection<JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;
    private final WildcardType reflectType;

    public ReflectJavaWildcardType(WildcardType reflectType) {
        List g2;
        m.g(reflectType, "reflectType");
        this.reflectType = reflectType;
        g2 = r.g();
        this.annotations = g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        m.f(upperBounds, "reflectType.upperBounds");
        return !m.c(j.z(upperBounds), Object.class);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public ReflectJavaType getBound() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Type[] lowerBounds = getReflectType().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                ReflectJavaType.Factory factory = ReflectJavaType.Factory;
                m.f(lowerBounds, "lowerBounds");
                Object R = j.R(lowerBounds);
                m.f(R, "lowerBounds.single()");
                return factory.create((Type) R);
            } else if (upperBounds.length == 1) {
                m.f(upperBounds, "upperBounds");
                Type ub = (Type) j.R(upperBounds);
                if (m.c(ub, Object.class)) {
                    return null;
                }
                ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                m.f(ub, "ub");
                return factory2.create(ub);
            } else {
                return null;
            }
        }
        throw new UnsupportedOperationException(m.o("Wildcard types with many bounds are not yet supported: ", getReflectType()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public WildcardType getReflectType() {
        return this.reflectType;
    }
}