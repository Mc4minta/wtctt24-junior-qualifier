package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;

/* compiled from: AnnotationQualifiersFqNames.kt */
/* loaded from: classes3.dex */
public final class JavaDefaultQualifiers {
    private final boolean affectsTypeParameterBasedTypes;
    private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    private final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifier, Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z) {
        m.g(nullabilityQualifier, "nullabilityQualifier");
        m.g(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = nullabilityQualifier;
        this.qualifierApplicabilityTypes = qualifierApplicabilityTypes;
        this.affectsTypeParameterBasedTypes = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers.nullabilityQualifier;
        }
        if ((i2 & 2) != 0) {
            collection = javaDefaultQualifiers.qualifierApplicabilityTypes;
        }
        if ((i2 & 4) != 0) {
            z = javaDefaultQualifiers.affectsTypeParameterBasedTypes;
        }
        return javaDefaultQualifiers.copy(nullabilityQualifierWithMigrationStatus, collection, z);
    }

    public final JavaDefaultQualifiers copy(NullabilityQualifierWithMigrationStatus nullabilityQualifier, Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z) {
        m.g(nullabilityQualifier, "nullabilityQualifier");
        m.g(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(nullabilityQualifier, qualifierApplicabilityTypes, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JavaDefaultQualifiers) {
            JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
            return m.c(this.nullabilityQualifier, javaDefaultQualifiers.nullabilityQualifier) && m.c(this.qualifierApplicabilityTypes, javaDefaultQualifiers.qualifierApplicabilityTypes) && this.affectsTypeParameterBasedTypes == javaDefaultQualifiers.affectsTypeParameterBasedTypes;
        }
        return false;
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.affectsTypeParameterBasedTypes;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.nullabilityQualifier.getQualifier() == NullabilityQualifier.NOT_NULL && this.affectsTypeParameterBasedTypes;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.nullabilityQualifier.hashCode() * 31) + this.qualifierApplicabilityTypes.hashCode()) * 31;
        boolean z = this.affectsTypeParameterBasedTypes;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ", affectsTypeParameterBasedTypes=" + this.affectsTypeParameterBasedTypes + ')';
    }

    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i2 & 4) != 0 ? nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NOT_NULL : z);
    }
}