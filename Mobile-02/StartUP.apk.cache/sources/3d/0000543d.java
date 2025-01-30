package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: annotationUtil.kt */
/* loaded from: classes3.dex */
final class AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1 extends o implements l<ModuleDescriptor, KotlinType> {
    final /* synthetic */ KotlinBuiltIns $this_createDeprecatedAnnotation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(KotlinBuiltIns kotlinBuiltIns) {
        super(1);
        this.$this_createDeprecatedAnnotation = kotlinBuiltIns;
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(ModuleDescriptor module) {
        m.g(module, "module");
        SimpleType arrayType = module.getBuiltIns().getArrayType(Variance.INVARIANT, this.$this_createDeprecatedAnnotation.getStringType());
        m.f(arrayType, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
        return arrayType;
    }
}