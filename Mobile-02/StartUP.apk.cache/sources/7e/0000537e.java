package kotlin.reflect.jvm.internal.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a0.r;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: SpecialJvmAnnotations.kt */
/* loaded from: classes3.dex */
public final class SpecialJvmAnnotations {
    public static final SpecialJvmAnnotations INSTANCE = new SpecialJvmAnnotations();
    private static final Set<ClassId> SPECIAL_ANNOTATIONS;

    static {
        List<FqName> j2;
        j2 = r.j(JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (FqName fqName : j2) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        SPECIAL_ANNOTATIONS = linkedHashSet;
    }

    private SpecialJvmAnnotations() {
    }

    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }
}