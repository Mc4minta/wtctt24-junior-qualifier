package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;

/* compiled from: ReflectJavaArrayType.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    private final Collection<JavaAnnotation> annotations;
    private final ReflectJavaType componentType;
    private final boolean isDeprecatedInJavaDoc;
    private final Type reflectType;

    public ReflectJavaArrayType(Type reflectType) {
        ReflectJavaType create;
        List g2;
        m.g(reflectType, "reflectType");
        this.reflectType = reflectType;
        Type reflectType2 = getReflectType();
        if (!(reflectType2 instanceof GenericArrayType)) {
            if (reflectType2 instanceof Class) {
                Class cls = (Class) reflectType2;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory = ReflectJavaType.Factory;
                    Class<?> componentType = cls.getComponentType();
                    m.f(componentType, "getComponentType()");
                    create = factory.create(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
        }
        ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
        Type genericComponentType = ((GenericArrayType) reflectType2).getGenericComponentType();
        m.f(genericComponentType, "genericComponentType");
        create = factory2.create(genericComponentType);
        this.componentType = create;
        g2 = r.g();
        this.annotations = g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    protected Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }
}