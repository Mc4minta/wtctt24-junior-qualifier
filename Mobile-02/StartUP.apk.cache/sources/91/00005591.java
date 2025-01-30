package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes3.dex */
public final class JavaTypeAttributes {
    private final JavaTypeFlexibility flexibility;
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final TypeParameterDescriptor upperBoundOfTypeParameter;

    public JavaTypeAttributes(TypeUsage howThisTypeIsUsed, JavaTypeFlexibility flexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor) {
        m.g(howThisTypeIsUsed, "howThisTypeIsUsed");
        m.g(flexibility, "flexibility");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.flexibility = flexibility;
        this.isForAnnotationParameter = z;
        this.upperBoundOfTypeParameter = typeParameterDescriptor;
    }

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            typeUsage = javaTypeAttributes.howThisTypeIsUsed;
        }
        if ((i2 & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.flexibility;
        }
        if ((i2 & 4) != 0) {
            z = javaTypeAttributes.isForAnnotationParameter;
        }
        if ((i2 & 8) != 0) {
            typeParameterDescriptor = javaTypeAttributes.upperBoundOfTypeParameter;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility, z, typeParameterDescriptor);
    }

    public final JavaTypeAttributes copy(TypeUsage howThisTypeIsUsed, JavaTypeFlexibility flexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor) {
        m.g(howThisTypeIsUsed, "howThisTypeIsUsed");
        m.g(flexibility, "flexibility");
        return new JavaTypeAttributes(howThisTypeIsUsed, flexibility, z, typeParameterDescriptor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JavaTypeAttributes) {
            JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
            return this.howThisTypeIsUsed == javaTypeAttributes.howThisTypeIsUsed && this.flexibility == javaTypeAttributes.flexibility && this.isForAnnotationParameter == javaTypeAttributes.isForAnnotationParameter && m.c(this.upperBoundOfTypeParameter, javaTypeAttributes.upperBoundOfTypeParameter);
        }
        return false;
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    public final TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public final TypeParameterDescriptor getUpperBoundOfTypeParameter() {
        return this.upperBoundOfTypeParameter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.howThisTypeIsUsed.hashCode() * 31) + this.flexibility.hashCode()) * 31;
        boolean z = this.isForAnnotationParameter;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.upperBoundOfTypeParameter;
        return i3 + (typeParameterDescriptor == null ? 0 : typeParameterDescriptor.hashCode());
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.howThisTypeIsUsed + ", flexibility=" + this.flexibility + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", upperBoundOfTypeParameter=" + this.upperBoundOfTypeParameter + ')';
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility flexibility) {
        m.g(flexibility, "flexibility");
        return copy$default(this, null, flexibility, false, null, 13, null);
    }

    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i2 & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : typeParameterDescriptor);
    }
}