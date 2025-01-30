package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaAnnotationTargetMapper$mapJavaTargetArguments$1 extends o implements l<ModuleDescriptor, KotlinType> {
    public static final JavaAnnotationTargetMapper$mapJavaTargetArguments$1 INSTANCE = new JavaAnnotationTargetMapper$mapJavaTargetArguments$1();

    JavaAnnotationTargetMapper$mapJavaTargetArguments$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(ModuleDescriptor module) {
        m.g(module, "module");
        ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), module.getBuiltIns().getBuiltInClassByFqName(StandardNames.FqNames.target));
        KotlinType type = annotationParameterByName == null ? null : annotationParameterByName.getType();
        if (type == null) {
            SimpleType createErrorType = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
            m.f(createErrorType, "createErrorType(\"Error: AnnotationTarget[]\")");
            return createErrorType;
        }
        return type;
    }
}