package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a0.r;
import kotlin.a0.t0;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JvmAnnotationNames.kt */
/* loaded from: classes3.dex */
public final class JvmAnnotationNamesKt {
    private static final FqName ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    private static final FqName ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    private static final FqName COMPATQUAL_NONNULL_ANNOTATION;
    private static final FqName COMPATQUAL_NULLABLE_ANNOTATION;
    private static final FqName JAVAX_CHECKFORNULL_ANNOTATION;
    private static final FqName JAVAX_NONNULL_ANNOTATION;
    private static final FqName JSPECIFY_DEFAULT_NOT_NULL;
    private static final FqName JSPECIFY_NULLABLE;
    private static final FqName JSPECIFY_NULLNESS_UNKNOWN;
    private static final List<FqName> MUTABLE_ANNOTATIONS;
    private static final List<FqName> NOT_NULL_ANNOTATIONS;
    private static final Set<FqName> NULLABILITY_ANNOTATIONS;
    private static final List<FqName> NULLABLE_ANNOTATIONS;
    private static final List<FqName> READ_ONLY_ANNOTATIONS;

    static {
        List<FqName> j2;
        List<FqName> j3;
        Set h2;
        Set i2;
        Set h3;
        Set i3;
        Set i4;
        Set i5;
        Set i6;
        Set i7;
        Set i8;
        Set<FqName> i9;
        List<FqName> j4;
        List<FqName> j5;
        FqName fqName = new FqName("org.jspecify.annotations.Nullable");
        JSPECIFY_NULLABLE = fqName;
        FqName fqName2 = new FqName("org.jspecify.annotations.NullnessUnspecified");
        JSPECIFY_NULLNESS_UNKNOWN = fqName2;
        FqName fqName3 = new FqName("org.jspecify.annotations.DefaultNonNull");
        JSPECIFY_DEFAULT_NOT_NULL = fqName3;
        j2 = r.j(JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable"));
        NULLABLE_ANNOTATIONS = j2;
        FqName fqName4 = new FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION = fqName4;
        JAVAX_CHECKFORNULL_ANNOTATION = new FqName("javax.annotation.CheckForNull");
        j3 = r.j(JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull"));
        NOT_NULL_ANNOTATIONS = j3;
        FqName fqName5 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        COMPATQUAL_NULLABLE_ANNOTATION = fqName5;
        FqName fqName6 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        COMPATQUAL_NONNULL_ANNOTATION = fqName6;
        FqName fqName7 = new FqName("androidx.annotation.RecentlyNullable");
        ANDROIDX_RECENTLY_NULLABLE_ANNOTATION = fqName7;
        FqName fqName8 = new FqName("androidx.annotation.RecentlyNonNull");
        ANDROIDX_RECENTLY_NON_NULL_ANNOTATION = fqName8;
        h2 = t0.h(new LinkedHashSet(), j2);
        i2 = t0.i(h2, fqName4);
        h3 = t0.h(i2, j3);
        i3 = t0.i(h3, fqName5);
        i4 = t0.i(i3, fqName6);
        i5 = t0.i(i4, fqName7);
        i6 = t0.i(i5, fqName8);
        i7 = t0.i(i6, fqName);
        i8 = t0.i(i7, fqName2);
        i9 = t0.i(i8, fqName3);
        NULLABILITY_ANNOTATIONS = i9;
        j4 = r.j(JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION);
        READ_ONLY_ANNOTATIONS = j4;
        j5 = r.j(JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION);
        MUTABLE_ANNOTATIONS = j5;
    }

    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    }

    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    }

    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return COMPATQUAL_NONNULL_ANNOTATION;
    }

    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return COMPATQUAL_NULLABLE_ANNOTATION;
    }

    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return JAVAX_CHECKFORNULL_ANNOTATION;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return JAVAX_NONNULL_ANNOTATION;
    }

    public static final FqName getJSPECIFY_DEFAULT_NOT_NULL() {
        return JSPECIFY_DEFAULT_NOT_NULL;
    }

    public static final FqName getJSPECIFY_NULLABLE() {
        return JSPECIFY_NULLABLE;
    }

    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return JSPECIFY_NULLNESS_UNKNOWN;
    }

    public static final List<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    public static final List<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }
}