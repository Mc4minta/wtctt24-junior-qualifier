package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaType.kt */
/* loaded from: classes3.dex */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = new Factory(null);

    /* compiled from: ReflectJavaType.kt */
    /* loaded from: classes3.dex */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReflectJavaType create(Type type) {
            ReflectJavaType reflectJavaArrayType;
            m.g(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            if (!(type instanceof GenericArrayType) && (!z || !((Class) type).isArray())) {
                reflectJavaArrayType = type instanceof WildcardType ? new ReflectJavaWildcardType((WildcardType) type) : new ReflectJavaClassifierType(type);
            } else {
                reflectJavaArrayType = new ReflectJavaArrayType(type);
            }
            return reflectJavaArrayType;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaType) && m.c(getReflectType(), ((ReflectJavaType) obj).getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName fqName) {
        return JavaType.DefaultImpls.findAnnotation(this, fqName);
    }

    protected abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}