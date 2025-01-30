package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.u;

/* compiled from: AnnotationQualifiersFqNames.kt */
/* loaded from: classes3.dex */
public final class AnnotationQualifiersFqNamesKt {
    private static final Map<FqName, JavaDefaultQualifiers> BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    private static final Set<FqName> BUILT_IN_TYPE_QUALIFIER_FQ_NAMES;
    private static final List<AnnotationQualifierApplicabilityType> DEFAULT_JSPECIFY_APPLICABILITY;
    private static final Map<FqName, JavaDefaultQualifiers> JSPECIFY_DEFAULT_ANNOTATIONS;
    private static final FqName TYPE_QUALIFIER_NICKNAME_FQNAME = new FqName("javax.annotation.meta.TypeQualifierNickname");
    private static final FqName TYPE_QUALIFIER_FQNAME = new FqName("javax.annotation.meta.TypeQualifier");
    private static final FqName TYPE_QUALIFIER_DEFAULT_FQNAME = new FqName("javax.annotation.meta.TypeQualifierDefault");
    private static final FqName MIGRATION_ANNOTATION_FQNAME = new FqName("kotlin.annotations.jvm.UnderMigration");

    static {
        List<AnnotationQualifierApplicabilityType> j2;
        Map<FqName, JavaDefaultQualifiers> e2;
        List b2;
        List b3;
        Map l2;
        Map<FqName, JavaDefaultQualifiers> o;
        Set<FqName> e3;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        j2 = r.j(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        DEFAULT_JSPECIFY_APPLICABILITY = j2;
        FqName jspecify_default_not_null = JvmAnnotationNamesKt.getJSPECIFY_DEFAULT_NOT_NULL();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        e2 = l0.e(u.a(jspecify_default_not_null, new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), j2, false)));
        JSPECIFY_DEFAULT_ANNOTATIONS = e2;
        FqName fqName = new FqName("javax.annotation.ParametersAreNullableByDefault");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
        b2 = q.b(annotationQualifierApplicabilityType);
        FqName fqName2 = new FqName("javax.annotation.ParametersAreNonnullByDefault");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null);
        b3 = q.b(annotationQualifierApplicabilityType);
        l2 = m0.l(u.a(fqName, new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus, b2, false, 4, null)), u.a(fqName2, new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus2, b3, false, 4, null)));
        o = m0.o(l2, e2);
        BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS = o;
        e3 = s0.e(JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNamesKt.getJAVAX_CHECKFORNULL_ANNOTATION());
        BUILT_IN_TYPE_QUALIFIER_FQ_NAMES = e3;
    }

    public static final Map<FqName, JavaDefaultQualifiers> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    }

    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return BUILT_IN_TYPE_QUALIFIER_FQ_NAMES;
    }

    public static final Map<FqName, JavaDefaultQualifiers> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return JSPECIFY_DEFAULT_ANNOTATIONS;
    }

    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return MIGRATION_ANNOTATION_FQNAME;
    }

    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return TYPE_QUALIFIER_DEFAULT_FQNAME;
    }

    public static final FqName getTYPE_QUALIFIER_FQNAME() {
        return TYPE_QUALIFIER_FQNAME;
    }

    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return TYPE_QUALIFIER_NICKNAME_FQNAME;
    }
}