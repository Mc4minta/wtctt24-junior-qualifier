package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
public final class TypeAndDefaultQualifiers {
    private final JavaDefaultQualifiers defaultQualifiers;
    private final boolean isFromStarProjection;
    private final KotlinType type;
    private final TypeParameterDescriptor typeParameterForArgument;

    public TypeAndDefaultQualifiers(KotlinType type, JavaDefaultQualifiers javaDefaultQualifiers, TypeParameterDescriptor typeParameterDescriptor, boolean z) {
        m.g(type, "type");
        this.type = type;
        this.defaultQualifiers = javaDefaultQualifiers;
        this.typeParameterForArgument = typeParameterDescriptor;
        this.isFromStarProjection = z;
    }

    public final KotlinType component1() {
        return this.type;
    }

    public final JavaDefaultQualifiers component2() {
        return this.defaultQualifiers;
    }

    public final TypeParameterDescriptor component3() {
        return this.typeParameterForArgument;
    }

    public final boolean component4() {
        return this.isFromStarProjection;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypeAndDefaultQualifiers) {
            TypeAndDefaultQualifiers typeAndDefaultQualifiers = (TypeAndDefaultQualifiers) obj;
            return m.c(this.type, typeAndDefaultQualifiers.type) && m.c(this.defaultQualifiers, typeAndDefaultQualifiers.defaultQualifiers) && m.c(this.typeParameterForArgument, typeAndDefaultQualifiers.typeParameterForArgument) && this.isFromStarProjection == typeAndDefaultQualifiers.isFromStarProjection;
        }
        return false;
    }

    public final KotlinType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        JavaDefaultQualifiers javaDefaultQualifiers = this.defaultQualifiers;
        int hashCode2 = (hashCode + (javaDefaultQualifiers == null ? 0 : javaDefaultQualifiers.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterForArgument;
        int hashCode3 = (hashCode2 + (typeParameterDescriptor != null ? typeParameterDescriptor.hashCode() : 0)) * 31;
        boolean z = this.isFromStarProjection;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.type + ", defaultQualifiers=" + this.defaultQualifiers + ", typeParameterForArgument=" + this.typeParameterForArgument + ", isFromStarProjection=" + this.isFromStarProjection + ')';
    }
}