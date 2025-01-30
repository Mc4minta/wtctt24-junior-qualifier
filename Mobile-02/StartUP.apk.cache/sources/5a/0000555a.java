package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor$type$2 extends o implements a<SimpleType> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final SimpleType invoke() {
        LazyJavaResolverContext lazyJavaResolverContext;
        JavaAnnotation javaAnnotation;
        LazyJavaResolverContext lazyJavaResolverContext2;
        JavaAnnotation javaAnnotation2;
        FqName fqName = this.this$0.getFqName();
        if (fqName == null) {
            javaAnnotation2 = this.this$0.javaAnnotation;
            return ErrorUtils.createErrorType(m.o("No fqName: ", javaAnnotation2));
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        lazyJavaResolverContext = this.this$0.f17396c;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, lazyJavaResolverContext.getModule().getBuiltIns(), null, 4, null);
        if (mapJavaToKotlin$default == null) {
            javaAnnotation = this.this$0.javaAnnotation;
            JavaClass resolve = javaAnnotation.resolve();
            if (resolve == null) {
                mapJavaToKotlin$default = null;
            } else {
                lazyJavaResolverContext2 = this.this$0.f17396c;
                mapJavaToKotlin$default = lazyJavaResolverContext2.getComponents().getModuleClassResolver().resolveClass(resolve);
            }
            if (mapJavaToKotlin$default == null) {
                mapJavaToKotlin$default = this.this$0.createTypeForMissingDependencies(fqName);
            }
        }
        return mapJavaToKotlin$default.getDefaultType();
    }
}